package com.trufflez.tsarcanum.util;

import java.util.Random;

public class TsMath {
    ///////////////////////////////////////
    // Riven's sine/cosine ( https://jvm-gaming.org/t/fast-math-sin-cos-lookup-tables/36660 )
    ///////////////////////////////////////

    private static final int SIN_BITS, SIN_MASK, SIN_COUNT;
    private static final float radFull, radToIndex;
    private static final float degFull, degToIndex;
    private static final float[] sin, cos;

    static {
        SIN_BITS = 12;
        SIN_MASK = ~(-1 << SIN_BITS);
        SIN_COUNT = SIN_MASK + 1;

        radFull = (float) (Math.PI * 2.0);
        degFull = (float) (360.0);
        radToIndex = SIN_COUNT / radFull;
        degToIndex = SIN_COUNT / degFull;

        sin = new float[SIN_COUNT];
        cos = new float[SIN_COUNT];

        for (int i = 0; i < SIN_COUNT; i++) {
            sin[i] = (float) Math.sin((i + 0.5f) / SIN_COUNT * radFull);
            cos[i] = (float) Math.cos((i + 0.5f) / SIN_COUNT * radFull);
        }

        // Four cardinal directions (credits: Nate)
        for (int i = 0; i < 360; i += 90) {
            sin[(int) (i * degToIndex) & SIN_MASK] = (float) Math.sin(i * Math.PI / 180.0);
            cos[(int) (i * degToIndex) & SIN_MASK] = (float) Math.cos(i * Math.PI / 180.0);
        }
    }
    
    public static float sin(float rad) {
        return sin[(int) (rad * radToIndex) & SIN_MASK];
    }
    
    public static float cos(float rad) {
        return cos[(int) (rad * radToIndex) & SIN_MASK];
    }
    
    /////////////// ARRAY SHUFFLER FUNCTION ///////////////
    public static void shuffleArray(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}

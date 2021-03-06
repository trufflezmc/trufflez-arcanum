package com.trufflez.tsarcanum.world.feature;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class TsSaplingGenerator extends SaplingGenerator {
    private final RegistryEntry<? extends ConfiguredFeature<?, ?>> feature;
    
    // This may be an issue
    public TsSaplingGenerator(RegistryEntry<? extends ConfiguredFeature<?, ?>> feature) {
        this.feature = feature;
    }
    
    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return feature;
    }
    
    
}

package com.trufflez.tsarcanum.block.patches;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;

public class TsSignBlockEntityRenderer extends SignBlockEntityRenderer {
    public TsSignBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        super(ctx);
    }
}

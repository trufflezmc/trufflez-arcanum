package com.trufflez.tsarcanum.client;

import com.trufflez.tsarcanum.blocks.TsBlocks;
import com.trufflez.tsarcanum.blocks.TsSaplings;
import com.trufflez.tsarcanum.items.TsItems;
import com.trufflez.tsarcanum.screen.AuricWorkbenchScreen;
import com.trufflez.tsarcanum.blocks.TsBlockEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TsArcanumClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        // Screens
        ScreenRegistry.register(TsBlockEntities.AURIC_WORKBENCH_SCREENHANDLER, AuricWorkbenchScreen::new);
        
        // Render Layers
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), TsSaplings.GREAT_OAK_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), TsSaplings.HEARTWOOD_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), TsBlocks.VITRIOL);

        //BlockRenderLayerMap.INSTANCE.putItems(RenderLayer.getTranslucent(), TsItems.GREAT_OAK_STAFF);
        
        // Model Predicate Providers
        /*FabricModelPredicateProviderRegistry.register(TsItems.GREAT_OAK_STAFF, new Identifier("pull"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getActiveItem() != itemStack ? 0.0F : (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
        });*/

        FabricModelPredicateProviderRegistry.register(TsItems.HEARTWOOD_STAFF, new Identifier("charged"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return ( livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ) ? 1.0F : 0.0F;
        });

        FabricModelPredicateProviderRegistry.register(TsItems.GREAT_OAK_STAFF, new Identifier("charged"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return ( livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ) ? 1.0F : 0.0F;
        });
    }
}

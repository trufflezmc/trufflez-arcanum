package com.trufflez.tsarcanum.item;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.block.TsBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TsItems {
    // Items
    public static final Item DEV_TOOL;
    
    public static final Item COPPER_SHEET;
    public static final Item REFRACTORY_CLAY_BRICK;
    public static final Item REFRACTORY_BRICK;

    public static final Item GREAT_OAK_STAFF_CORE;
    public static final Item HEARTWOOD_STAFF_CORE;
    public static final Item WILLOW_STAFF_CORE;
    public static final Item ELM_STAFF_CORE;

    public static final StaffItem GREAT_OAK_STAFF;
    public static final StaffItem HEARTWOOD_STAFF;
    public static final StaffItem WILLOW_STAFF;
    public static final StaffItem ELM_STAFF;
    
    // Custom BlockItems
    public static final BlockItem GREAT_OAK_LEAVES_ITEM;
    public static final BlockItem HEARTWOOD_LEAVES_ITEM;
    public static final BlockItem WILLOW_LEAVES_ITEM;
    public static final BlockItem ELM_LEAVES_ITEM;
    

    private static BlockItem blockItem(Block block) {
        return new BlockItem(block, new FabricItemSettings().group(TsItemGroup.MAIN));
    }

    private static Item register(String id, Item item) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), item); }
    private static Item register(String id, StaffItem item) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), item); }
    private static BlockItem register(String id, BlockItem blockItem) { return Registry.register(Registry.ITEM, new Identifier(TsArcanum.MOD_ID, id), blockItem); }
    

    static {
        DEV_TOOL = register("devtool", new DevTool(new FabricItemSettings()));

        GREAT_OAK_LEAVES_ITEM = register("great_oak_leaves", blockItem(TsBlocks.GREAT_OAK_LEAVES));
        HEARTWOOD_LEAVES_ITEM = register("heartwood_leaves", blockItem(TsBlocks.HEARTWOOD_LEAVES));
        WILLOW_LEAVES_ITEM = register("willow_leaves", blockItem(TsBlocks.WILLOW_LEAVES));
        ELM_LEAVES_ITEM = register("elm_leaves", blockItem(TsBlocks.ELM_LEAVES));

        COPPER_SHEET = register("copper_sheet", new Item(new FabricItemSettings().maxCount(16).group(TsItemGroup.MAIN)));
        REFRACTORY_CLAY_BRICK = register("refractory_clay_brick", new Item(new FabricItemSettings().group(TsItemGroup.MAIN)));
        REFRACTORY_BRICK = register("refractory_brick", new Item(new FabricItemSettings().fireproof().group(TsItemGroup.MAIN)));

        GREAT_OAK_STAFF_CORE = register("great_oak_staff_core", new Item(new FabricItemSettings().group(TsItemGroup.MAIN)));
        HEARTWOOD_STAFF_CORE = register("heartwood_staff_core", new Item(new FabricItemSettings().group(TsItemGroup.MAIN)));
        WILLOW_STAFF_CORE = register("willow_staff_core", new Item(new FabricItemSettings().group(TsItemGroup.MAIN)));
        ELM_STAFF_CORE = register("elm_staff_core", new Item(new FabricItemSettings().group(TsItemGroup.MAIN)));

        GREAT_OAK_STAFF = (StaffItem) register("great_oak_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof().group(TsItemGroup.MAIN)));
        HEARTWOOD_STAFF = (StaffItem) register("heartwood_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof().group(TsItemGroup.MAIN)));
        WILLOW_STAFF = (StaffItem) register("willow_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof().group(TsItemGroup.MAIN)));
        ELM_STAFF = (StaffItem) register("elm_staff", new StaffItem(new FabricItemSettings().maxCount(1).fireproof().group(TsItemGroup.MAIN)));
    }
    
    
    public static void registerItems() {
        TsArcanum.LOGGER.info("Registering items");
    }
}
package com.nonobett.oresrevamped.block;

import com.nonobett.oresrevamped.OresRevamped;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.RED).requiresTool().strength(50.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(OresRevamped.MOD_ID, name), block);
    }

    private static  void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(OresRevamped.MOD_ID, name),
        new BlockItem(block, new Item.Settings()));
    }

    public static  void registerModBlocks() {
        OresRevamped.LOGGER.info(" Registering Mod Blocks for " + OresRevamped.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RUBY_BLOCK);
        });
    }
}

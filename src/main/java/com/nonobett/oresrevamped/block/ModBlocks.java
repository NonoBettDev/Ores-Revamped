package com.nonobett.oresrevamped.block;

import com.nonobett.oresrevamped.OresRevamped;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.RED).requiresTool().strength(10.0F).sounds(BlockSoundGroup.METAL)));

     public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
             new Block(AbstractBlock.Settings.create().mapColor(MapColor.RED).requiresTool().strength(5.0F).instrument(NoteBlockInstrument.BASS)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).requiresTool().strength(3.0F).instrument(NoteBlockInstrument.BASEDRUM)));

    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).requiresTool().strength(4.5F).sounds(BlockSoundGroup.DEEPSLATE)));


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
            entries.add(ModBlocks.RAW_RUBY_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.RUBY_ORE);
            entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
        });
    }
}

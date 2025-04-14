package com.nonobett.oresrevamped.block;

import com.nonobett.oresrevamped.OresRevamped;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {


    private static  void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(OresRevamped.MOD_ID, name),
        new BlockItem(block, new Item.Settings()));
    }

    public static  void registerModBlocks() {
        OresRevamped.LOGGER.info(" Registering Mod Blocks for " + OresRevamped.MOD_ID);
    }
}

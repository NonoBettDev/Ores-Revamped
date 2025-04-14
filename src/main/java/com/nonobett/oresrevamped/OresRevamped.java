package com.nonobett.oresrevamped;

import com.nonobett.oresrevamped.block.ModBlocks;
import com.nonobett.oresrevamped.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//very important comment test
public class OresRevamped implements ModInitializer {
	public static  final String MOD_ID = "oresrevamped";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
package armet.spelunkers_palette;

import armet.spelunkers_palette.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry.registerOxidizableBlockPair;
import static net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry.registerWaxableBlockPair;

public class SpelunkersPalette implements ModInitializer {

	public static final String MOD_ID = "spelunkers_palette";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModBlocks.registerModBlocks();


		registerOxidizableBlockPair(ModBlocks.IRON_PLATING, ModBlocks.EXPOSED_IRON_PLATING);
		registerOxidizableBlockPair(ModBlocks.EXPOSED_IRON_PLATING, ModBlocks.OXIDIZED_IRON_PLATING);

		registerWaxableBlockPair(ModBlocks.IRON_PLATING, ModBlocks.WAXED_IRON_PLATING);
		registerWaxableBlockPair(ModBlocks.EXPOSED_IRON_PLATING, ModBlocks.WAXED_EXPOSED_IRON_PLATING);
		registerWaxableBlockPair(ModBlocks.OXIDIZED_IRON_PLATING, ModBlocks.WAXED_OXIDIZED_IRON_PLATING);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {

			for (Item item : ModBlocks.BuildingBlockItems) {
				content.add(item);
			}
		});
	}
}
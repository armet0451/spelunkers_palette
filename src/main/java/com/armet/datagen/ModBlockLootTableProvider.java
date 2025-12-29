package com.armet.datagen;

import com.armet.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.WeatheringCopperDoorBlock;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Locale;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {


        for (Block block : getKnownBlocks()) {
            if (block instanceof DoorBlock) {
                this.add(block, this::createDoorTable);
            }
            else{
                this.dropSelf(block);
            }


        }

        this.createDoorTable(ModBlocks.GOLD_DOOR.get());
        this.createDoorTable(ModBlocks.IRON_DOOR.get());
        this.createDoorTable(ModBlocks.EXPOSED_IRON_DOOR.get());
        this.createDoorTable(ModBlocks.OXIDIZED_IRON_DOOR.get());
        this.createDoorTable(ModBlocks.WAXED_IRON_DOOR.get());
        this.createDoorTable(ModBlocks.WAXED_EXPOSED_IRON_DOOR.get());
        this.createDoorTable(ModBlocks.WAXED_OXIDIZED_IRON_DOOR.get());
        // cobbled variants for vanilla silk touch

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

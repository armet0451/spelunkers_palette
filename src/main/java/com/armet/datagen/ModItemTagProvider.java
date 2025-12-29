package com.armet.datagen;

import com.armet.SpelunkersPalette;
import com.armet.block.ModBlocks;
import com.armet.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, SpelunkersPalette.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for (Item item : getKnownItems()) {
            if (item.toString().contains("cobbled")) {
                tag(ItemTags.STONE_CRAFTING_MATERIALS).add(item);
                tag(ItemTags.STONE_TOOL_MATERIALS).add(item);
            }
        }
    }



    protected Iterable<Item> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream().map(Holder::value)::iterator;
    }


}

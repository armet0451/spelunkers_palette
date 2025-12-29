package com.armet.datagen;

import com.armet.block.ModBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.packs.VanillaAdvancementProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.*;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.armet.SpelunkersPalette.MODID;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput p_recipeOutput, HolderLookup.Provider holderLookup) {
        // manual recipes


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_PLATING, 32)
                .pattern("XX").pattern("XX")
                .define('X', Ingredient.of(Blocks.IRON_BLOCK.asItem()))
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(p_recipeOutput);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_PLATING, Blocks.IRON_BLOCK, 32);



        //COPPER
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COPPER_BLOCK, 32)
                .pattern("XX").pattern("XX")
                .define('X', Ingredient.of(ModBlocks.COPPER_STORAGE_BLOCK.asItem()))
                .unlockedBy("has_iron", has(Items.COPPER_INGOT))
                .save(p_recipeOutput);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.COPPER_BLOCK, ModBlocks.COPPER_STORAGE_BLOCK, 32);
        nineBlockStorageRecipes(p_recipeOutput, RecipeCategory.MISC, Items.COPPER_INGOT, RecipeCategory.MISC, ModBlocks.COPPER_STORAGE_BLOCK);





        //DOORS
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.IRON_DOOR, 3)
                .pattern("XX").pattern("XX").pattern("XX")
                .define('X', Ingredient.of(Items.IRON_INGOT))
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.IRON_TRAPDOOR, 2)
                .pattern("XXX").pattern("XXX")
                .define('X', Ingredient.of(Items.IRON_INGOT))
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.GOLD_DOOR, 3)
                .pattern("XX").pattern("XX").pattern("XX")
                .define('X', Ingredient.of(Items.GOLD_INGOT))
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.GOLD_TRAPDOOR, 2)
                .pattern("XXX").pattern("XXX")
                .define('X', Ingredient.of(Items.GOLD_INGOT))
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(p_recipeOutput);

        // POLISHING AND BRICKS
        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE, Blocks.STONE);
        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS, ModBlocks.POLISHED_STONE);


        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_BRICKS.base, Blocks.POLISHED_BASALT);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_BRICKS.base, Blocks.POLISHED_BASALT);

        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS.base, Blocks.POLISHED_ANDESITE);
        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS.base, Blocks.POLISHED_GRANITE);
        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS.base, Blocks.POLISHED_DIORITE);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS.base, Blocks.POLISHED_ANDESITE);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS.base, Blocks.POLISHED_GRANITE);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS.base, Blocks.POLISHED_DIORITE);

        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE.base, Blocks.DRIPSTONE_BLOCK);
        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS.base, ModBlocks.POLISHED_DRIPSTONE.base);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS.base, ModBlocks.POLISHED_DRIPSTONE.base);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE.base, Blocks.DRIPSTONE_BLOCK);

        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE.base, Blocks.CALCITE);
        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS.base, ModBlocks.POLISHED_CALCITE.base);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE.base, Blocks.CALCITE);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS.base, ModBlocks.POLISHED_CALCITE.base);

        // MANUAL CRAFTING TABLE CHISELING
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GOLD, ModBlocks.CUT_GOLD.slab);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BASALT, ModBlocks.BASALT_BRICKS.slab);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_CALCITE, ModBlocks.CALCITE_BRICKS.slab);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DRIPSTONE, ModBlocks.DRIPSTONE_BRICKS.slab);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ANDESITE, ModBlocks.ANDESITE_BRICKS.slab);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DIORITE, ModBlocks.DIORITE_BRICKS.slab);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GRANITE, ModBlocks.GRANITE_BRICKS.slab);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_IRON, ModBlocks.CUT_IRON.slab);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXPOSED_CHISELED_IRON, ModBlocks.EXPOSED_CUT_IRON.slab);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OXIDIZED_CHISELED_IRON, ModBlocks.OXIDIZED_CUT_IRON.slab);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_EXPOSED_CHISELED_IRON, ModBlocks.EXPOSED_CUT_IRON.slab_waxed);
        chiseled(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAXED_OXIDIZED_CHISELED_IRON, ModBlocks.OXIDIZED_CUT_IRON.slab_waxed);


        // GOLD RECIPES
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_PLATING, 32)
                .pattern("XX").pattern("XX")
                .define('X', Ingredient.of(Blocks.GOLD_BLOCK.asItem()))
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(p_recipeOutput);

        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_PLATING, Blocks.GOLD_BLOCK, 32);

        polished(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD.base, ModBlocks.GOLD_PLATING);
        stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD.base, ModBlocks.GOLD_PLATING);

        // auto stairs and slabs
        for (Block block : getKnownBlocks()) {
            String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
            // figure out the base block for this stair/slab/wall
            Block baseBlock =  getBaseBlock(name);

            // automatically make shape variant recipes
            if (block instanceof SlabBlock) {
                slab(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, block, baseBlock);
                stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, block, baseBlock, 2);
                
            }
            if (block instanceof WallBlock) {
                wall(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, block, baseBlock);
                stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, block, baseBlock, 1);
            }
            if (block instanceof StairBlock) {
                stair(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, block, baseBlock);
                stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, block, baseBlock, 1);
            }

            if (name.contains("cracked")){
                smeltingResultFromBase(p_recipeOutput, block, baseBlock);
            }

            if (name.contains("chiseled")){
                stonecutterResultFromBase(p_recipeOutput, RecipeCategory.BUILDING_BLOCKS, block, baseBlock, 1);

            }

        }
    }

    private static Block getPriorPolishState(String name){
        String resultName = "";
        if (name.endsWith("_bricks")){
            resultName = "polished_".concat(name.substring(0, name.length() - "_bricks".length()));
        }
        if (name.startsWith("polished_")){
            resultName = name.substring("polished".length(), name.length());
        }


        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("spelunkerspalette", resultName));
    }

    private static @NotNull Block getBaseBlock(String name) {
        String baseBlockName = "";
        if (name.endsWith("_stairs")) {baseBlockName = name.substring(0, name.length() - "_stairs".length());}
        else if (name.endsWith("_slab")) {baseBlockName = name.substring(0, name.length() - "_slab".length());}
        else if (name.endsWith("_wall")) {baseBlockName = name.substring(0, name.length() - "_wall".length());}
        else if (name.contains("cracked_")) {baseBlockName = name.substring("cracked_".length(), name.length());}


        // chiseled_iron_blocks
        else if (name.contains("chiseled_iron")){
            baseBlockName = name.substring(0, name.indexOf("chiseled_")) + "cut_iron";
        }
        else if (name.contains("chiseled_gold")){
            baseBlockName = "cut_gold";
        }
        // chiseled stone blocks
        else if (name.startsWith("chiseled_")){
            baseBlockName = name.substring("chiseled_".length(), name.length()).concat("_bricks");
        }


        if (baseBlockName.endsWith("_brick")) {baseBlockName = baseBlockName + "s";}




        String namespace = "spelunkerspalette";

        if (baseBlockName.equals("polished_granite") || baseBlockName.equals("polished_andesite") || baseBlockName.equals("polished_diorite")) {
            namespace = "minecraft";
        }

        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(namespace, baseBlockName));
    }

    protected void stair(RecipeOutput p_recipeOutput, RecipeCategory recipeCategory, Block output, Block ingredient) {

        ShapedRecipeBuilder.shaped(recipeCategory, output, 4)
                .pattern("  #")
                .pattern(" ##")
                .pattern("###")
                .define('#', ingredient)
                .group(recipeCategory.toString())
                .unlockedBy("has_base", has(ingredient))
                .save(p_recipeOutput, BuiltInRegistries.BLOCK.getKey(output).getPath());
    }

    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}


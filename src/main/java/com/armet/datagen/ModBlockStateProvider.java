package com.armet.datagen;

import com.armet.SpelunkersPalette;
import com.armet.block.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.armet.block.ModBlocks.CHISELED_DRIPSTONE;
import static com.armet.block.ModBlocks.CHISELED_GOLD;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SpelunkersPalette.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (DeferredHolder<Block, ? extends Block> deferredBlock : ModBlocks.BLOCKS.getEntries()){
            Block block = deferredBlock.get();
            String name = BuiltInRegistries.BLOCK.getKey(block).getPath();


            // figure out the base block for this stair/slab/wall variant and use its texture
            String baseBlockName = name;
            if (name.endsWith("_stairs")) {baseBlockName = name.substring(0, name.length() - "_stairs".length());}
            else if (name.endsWith("_slab")) {baseBlockName = name.substring(0, name.length() - "_slab".length());}
            else if (name.endsWith("_wall")) {baseBlockName = name.substring(0, name.length() - "_wall".length());}

            if (baseBlockName.endsWith("_brick")) {baseBlockName = baseBlockName + "s";}

            ResourceLocation texture = modLoc("block/" + baseBlockName);




            if (block instanceof StairBlock) {
                stairsBlock((StairBlock) block, texture);
                itemModels().stairs(name, texture,texture,texture);
            }

            else if (block instanceof SlabBlock) {
                slabBlock((SlabBlock) block, texture, texture);
                itemModels().slab(name,texture,texture,texture);
            }

            else if (block instanceof WallBlock) {
                wallBlock((WallBlock) block, texture);
                itemModels().wallInventory(name, texture);
            }

            else if (block instanceof RotatedPillarBlock) {
                ResourceLocation top = ResourceLocation.fromNamespaceAndPath("spelunkerspalette", texture.getPath() + "_top");
                axisBlock((RotatedPillarBlock) block, texture, top);
                itemModels().cubeBottomTop(name, texture, top, top);
            }

            else if (block instanceof TrapDoorBlock) {
                trapdoorBlockWithRenderType((TrapDoorBlock) block, texture, false, "cutout");
                itemModels().trapdoorBottom(baseBlockName, texture);
            }

            else if (block instanceof DoorBlock) {

                doorBlockWithRenderType(
                        (DoorBlock) block,
                        modLoc("block/" + baseBlockName + "_bottom"),
                        modLoc("block/" + baseBlockName + "_top"),
                "cutout");

                itemModels().basicItem(modLoc(baseBlockName));
            }

            else if (block instanceof Block && block != CHISELED_DRIPSTONE.get() && block != CHISELED_GOLD.get()) {

                simpleBlockWithItem(block, cubeAll(block));
            }
        }
    }


    // lists all blocks in an iterable format
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

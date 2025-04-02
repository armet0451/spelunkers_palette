package armet.spelunkers_palette.block;

import armet.spelunkers_palette.SpelunkersPalette;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {



    public static List<Item> BuildingBlockItems = new ArrayList<Item>() {
    };
    public static List<Block> PickaxeMineable = new ArrayList<Block>() {
    };

    private static Block registerBlock(String name, Block block) {
        BuildingBlockItems.add(registerBlockItem(name, block));
        Block registeredBlock = Registry.register(Registries.BLOCK, new Identifier(SpelunkersPalette.MOD_ID, name), block);

        PickaxeMineable.add(registeredBlock);
        return registeredBlock;
    }

    private static Item registerBlockItem(String name, Block block) {
      return Registry.register(Registries.ITEM, new Identifier(SpelunkersPalette.MOD_ID, name),
              new BlockItem(block, new FabricItemSettings()));

    }



    private static void registerVariantSet(String stoneType, Block block) {
        registerSlabSet("cobbled_" + stoneType, block);
        registerBlock("cobbled_" + stoneType, new Block(FabricBlockSettings.copyOf(block)));

        registerSlabSet("polished_" + stoneType, block);
        registerSlabSet(stoneType + "_brick", block);

        registerBlock(stoneType + "_bricks", new Block(FabricBlockSettings.copyOf(block)));
        registerBlock("chiseled_" + stoneType, new Block(FabricBlockSettings.copyOf(block)));
    }

    private static void registerSlabSet(String blockName, Block block){
        registerBlock(blockName + "_slab", new SlabBlock(FabricBlockSettings.copyOf(block)));
        registerBlock(blockName + "_stairs", new StairsBlock(block.getDefaultState(), FabricBlockSettings.copyOf(block)));
        registerBlock(blockName + "_wall", new WallBlock(FabricBlockSettings.copyOf(block)));


    }

    public static void registerModBlocks() {
        SpelunkersPalette.LOGGER.info("Registering mod blocks for " + SpelunkersPalette.MOD_ID);
        registerVariantSet("calcite", (Blocks.CALCITE));
        registerVariantSet("dripstone", (Blocks.DRIPSTONE_BLOCK));
        registerVariantSet("tuff", (Blocks.TUFF));


        registerSlabSet("cobbled_basalt", Blocks.BASALT);
        registerSlabSet("basalt_brick", Blocks.BASALT);
        registerBlock("chiseled_basalt", new Block(FabricBlockSettings.copyOf(Blocks.BASALT)));
        registerBlock("polished_basalt_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.BASALT)));
        registerBlock("polished_basalt_stairs", new StairsBlock(Blocks.BASALT.getDefaultState(),
                FabricBlockSettings.copyOf(Blocks.BASALT)));
        registerBlock("polished_basalt_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.BASALT)));

    }

    public static final Block IRON_PLATING = registerBlock("iron_plating",
            new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.LANTERN)));
    public static final Block WAXED_IRON_PLATING = registerBlock("waxed_iron_plating",
            new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(IRON_PLATING).sounds(BlockSoundGroup.LANTERN)));

    public static final Block EXPOSED_IRON_PLATING = registerBlock("exposed_iron_plating",
            new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.LANTERN)));
    public static final Block WAXED_EXPOSED_IRON_PLATING = registerBlock("waxed_exposed_iron_plating",
            new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(EXPOSED_IRON_PLATING).sounds(BlockSoundGroup.LANTERN)));

    public static final Block OXIDIZED_IRON_PLATING = registerBlock("oxidized_iron_plating",
            new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.LANTERN)));
    public static final Block WAXED_OXIDIZED_IRON_PLATING = registerBlock("waxed_oxidized_iron_plating",
            new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(OXIDIZED_IRON_PLATING).sounds(BlockSoundGroup.LANTERN)));






}

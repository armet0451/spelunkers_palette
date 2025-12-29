package com.armet.block;

import com.armet.SpelunkersPalette;
import com.armet.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SpelunkersPalette.MODID);

    // STONE
    public static final DeferredBlock<Block> POLISHED_STONE = registerBlock(
            "polished_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    // THE ITE BROTHERS
    public static final BlockFamily ANDESITE_BRICKS = new BlockFamily("andesite_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> CHISELED_ANDESITE = registerBlock(
            "chiseled_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> CRACKED_ANDESITE_BRICKS = registerBlock(
            "cracked_andesite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> POLISHED_ANDESITE_WALL = registerBlock(
            "polished_andesite_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));

    public static final BlockFamily GRANITE_BRICKS = new BlockFamily("granite_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> CHISELED_GRANITE= registerBlock(
            "chiseled_granite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> CRACKED_GRANITE_BRICKS = registerBlock(
            "cracked_granite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> POLISHED_GRANITE_WALL = registerBlock(
            "polished_granite_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));

    public static final BlockFamily DIORITE_BRICKS = new BlockFamily("diorite_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> CHISELED_DIORITE = registerBlock(
            "chiseled_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> CRACKED_DIORITE_BRICKS = registerBlock(
            "cracked_diorite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> POLISHED_DIORITE_WALL = registerBlock(
            "polished_diorite_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));


    // DRIPSTONE
    public static final BlockFamily COBBLED_DRIPSTONE = new BlockFamily("cobbled_dripstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final BlockFamily POLISHED_DRIPSTONE = new BlockFamily("polished_dripstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final BlockFamily DRIPSTONE_BRICKS = new BlockFamily("dripstone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> CHISELED_DRIPSTONE = registerBlock(
            "chiseled_dripstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> CRACKED_DRIPSTONE_BRICKS = registerBlock(
            "cracked_dripstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));

    // CALCITE
    public static final BlockFamily COBBLED_CALCITE = new BlockFamily("cobbled_calcite",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final BlockFamily POLISHED_CALCITE = new BlockFamily("polished_calcite",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final BlockFamily CALCITE_BRICKS = new BlockFamily("calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> CHISELED_CALCITE = registerBlock(
            "chiseled_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> CRACKED_CALCITE_BRICKS = registerBlock(
            "cracked_calcite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));

    // BASALT
    public static final BlockFamily COBBLED_BASALT = new BlockFamily("cobbled_basalt",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final BlockFamily BASALT_BRICKS = new BlockFamily("basalt_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> CHISELED_BASALT = registerBlock(
            "chiseled_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> CRACKED_BASALT_BRICKS = registerBlock(
            "cracked_basalt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));

    //TUFF
    public static final BlockFamily COBBLED_TUFF = new BlockFamily("cobbled_tuff",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));

    // GOLD
    public static final MetalBlockFamily CUT_GOLD = new MetalBlockFamily("cut_gold",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK)));
    public static final DeferredBlock<Block> GOLD_PLATING = registerBlock(
            "gold_plating", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK)));
    public static final DeferredBlock<Block> GOLD_DOOR = registerBlock(
            "gold_door", () -> new DoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK)));
    public static final DeferredBlock<Block> GOLD_TRAPDOOR = registerBlock(
            "gold_trapdoor", () -> new TrapDoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK)));
    public static final DeferredBlock<Block> CHISELED_GOLD = registerBlock(
            "chiseled_gold", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK)));

    // IRON
    public static final BlockBehaviour.Properties ironProperties = BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).randomTicks();

    public static final OxidizableBlockFamily CUT_IRON = new OxidizableBlockFamily("cut_iron",
            ironProperties, WeatheringCopper.WeatherState.UNAFFECTED);
    public static final OxidizableBlockFamily EXPOSED_CUT_IRON = new OxidizableBlockFamily("exposed_cut_iron",
            ironProperties, WeatheringCopper.WeatherState.EXPOSED);
    public static final OxidizableBlockFamily OXIDIZED_CUT_IRON = new OxidizableBlockFamily("oxidized_cut_iron",
            ironProperties, WeatheringCopper.WeatherState.OXIDIZED);


    public static final DeferredBlock<Block> IRON_PLATING = registerBlock(
            "iron_plating", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, ironProperties));
    public static final DeferredBlock<Block> WAXED_IRON_PLATING = registerBlock(
            "waxed_iron_plating", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, ironProperties));
    public static final DeferredBlock<Block> EXPOSED_IRON_PLATING = registerBlock(
            "exposed_iron_plating", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, ironProperties));
    public static final DeferredBlock<Block> WAXED_EXPOSED_IRON_PLATING = registerBlock(
            "waxed_exposed_iron_plating", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, ironProperties));
    public static final DeferredBlock<Block> OXIDIZED_IRON_PLATING = registerBlock(
            "oxidized_iron_plating", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, ironProperties));
    public static final DeferredBlock<Block> WAXED_OXIDIZED_IRON_PLATING = registerBlock(
            "waxed_oxidized_iron_plating", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, ironProperties));

    public static final DeferredBlock<Block> CHISELED_IRON = registerBlock(
            "chiseled_iron", () -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.UNAFFECTED, ironProperties));
    public static final DeferredBlock<Block> WAXED_CHISELED_IRON = registerBlock(
            "waxed_chiseled_iron", () -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.UNAFFECTED, ironProperties));
    public static final DeferredBlock<Block> EXPOSED_CHISELED_IRON = registerBlock(
            "exposed_chiseled_iron", () -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.EXPOSED, ironProperties));
    public static final DeferredBlock<Block> WAXED_EXPOSED_CHISELED_IRON = registerBlock(
            "waxed_exposed_chiseled_iron", () -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.EXPOSED, ironProperties));
    public static final DeferredBlock<Block> OXIDIZED_CHISELED_IRON = registerBlock(
            "oxidized_chiseled_iron", () -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.OXIDIZED, ironProperties));
    public static final DeferredBlock<Block> WAXED_OXIDIZED_CHISELED_IRON = registerBlock(
            "waxed_oxidized_chiseled_iron", () -> new WeatheringCopperPillarBlock(WeatheringCopper.WeatherState.OXIDIZED, ironProperties));


    // IRON DOORS
    public static final DeferredBlock<Block> IRON_DOOR = registerBlock(
            "iron_door", () -> new WeatheringCopperDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.UNAFFECTED, ironProperties.noOcclusion()));
    public static final DeferredBlock<Block> EXPOSED_IRON_DOOR = registerBlock(
            "exposed_iron_door", () -> new WeatheringCopperDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.EXPOSED, ironProperties.noOcclusion()));
    public static final DeferredBlock<Block> OXIDIZED_IRON_DOOR = registerBlock(
            "oxidized_iron_door", () -> new WeatheringCopperDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.OXIDIZED, ironProperties.noOcclusion()));
    public static final DeferredBlock<Block> WAXED_IRON_DOOR = registerBlock(
            "waxed_iron_door", () -> new WeatheringCopperDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.UNAFFECTED, ironProperties.noOcclusion()));
    public static final DeferredBlock<Block> WAXED_EXPOSED_IRON_DOOR = registerBlock(
            "waxed_exposed_iron_door", () -> new WeatheringCopperDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.EXPOSED, ironProperties.noOcclusion()));
    public static final DeferredBlock<Block> WAXED_OXIDIZED_IRON_DOOR = registerBlock(
            "waxed_oxidized_iron_door", () -> new WeatheringCopperDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.OXIDIZED, ironProperties.noOcclusion()));

    // IRON TRAPDOORS
    public static final DeferredBlock<Block> IRON_TRAPDOOR = registerBlock(
            "iron_trapdoor", () -> new WeatheringCopperTrapDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.UNAFFECTED, ironProperties.noOcclusion()));
    public static final DeferredBlock<Block> EXPOSED_IRON_TRAPDOOR = registerBlock(
            "exposed_iron_trapdoor", () -> new WeatheringCopperTrapDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.EXPOSED, ironProperties.noOcclusion()));
    public static final DeferredBlock<Block> OXIDIZED_IRON_TRAPDOOR = registerBlock(
            "oxidized_iron_trapdoor", () -> new WeatheringCopperTrapDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.OXIDIZED, ironProperties.noOcclusion()));
    public static final DeferredBlock<Block> WAXED_IRON_TRAPDOOR = registerBlock(
            "waxed_iron_trapdoor", () -> new WeatheringCopperTrapDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.UNAFFECTED, ironProperties.noOcclusion()));
    public static final DeferredBlock<Block> WAXED_EXPOSED_IRON_TRAPDOOR = registerBlock(
            "waxed_exposed_iron_trapdoor", () -> new WeatheringCopperTrapDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.EXPOSED, ironProperties.noOcclusion()));
    public static final DeferredBlock<Block> WAXED_OXIDIZED_IRON_TRAPDOOR = registerBlock(
            "waxed_oxidized_iron_trapdoor", () -> new WeatheringCopperTrapDoorBlock(BlockSetType.IRON, WeatheringCopper.WeatherState.OXIDIZED, ironProperties.noOcclusion()));

    // COPPER
    public static final DeferredBlock<Block> COPPER_STORAGE_BLOCK = registerBlock(
            "copper_storage_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK)));



    public static class BlockFamily {
        public final DeferredBlock<Block> base;
        public final DeferredBlock<Block> slab;
        public final DeferredBlock<Block> stair;
        public final DeferredBlock<Block> wall;

        public BlockFamily(String path, Supplier<Block> baseBlock) {
            String brickPath = path;
            if (path.endsWith("bricks")) {
                brickPath = path.substring(0, path.length() - 1);
            }
            base = registerBlock(path, baseBlock);
            slab = registerBlock(brickPath + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(base.get())));
            stair = registerBlock(brickPath + "_stairs", () -> new StairBlock(base.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(base.get())));
            wall = registerBlock(brickPath + "_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(base.get())));
        }
    }

    public static class MetalBlockFamily {
        public final DeferredBlock<Block> base;
        public final DeferredBlock<Block> slab;
        public final DeferredBlock<Block> stair;


        public MetalBlockFamily(String path, Supplier<Block> baseBlock) {
            base = registerBlock(path, baseBlock);
            slab = registerBlock(path + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(base.get())));
            stair = registerBlock(path + "_stairs", () -> new StairBlock(base.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(base.get())));
        }
    }


    public static class OxidizableBlockFamily {
        public final DeferredBlock<Block> base;
        public final DeferredBlock<Block> slab;
        public final DeferredBlock<Block> stair;

        public final DeferredBlock<Block> base_waxed;
        public final DeferredBlock<Block> slab_waxed;
        public final DeferredBlock<Block> stair_waxed;
        public OxidizableBlockFamily(String path, BlockBehaviour.Properties properties, WeatheringCopper.WeatherState weatherState)
        {
            base = registerBlock(path, () -> new WeatheringCopperFullBlock(weatherState, properties));
            stair = registerBlock(path + "_stairs", () -> new WeatheringCopperStairBlock(weatherState, Blocks.COPPER_BLOCK.defaultBlockState(), properties));
            slab = registerBlock(path + "_slab", () -> new WeatheringCopperSlabBlock(weatherState, properties));

            base_waxed = registerBlock("waxed_" + path, () -> new WeatheringCopperFullBlock(weatherState, properties));
            stair_waxed = registerBlock("waxed_" + path + "_stairs", () -> new WeatheringCopperStairBlock(weatherState, Blocks.COPPER_BLOCK.defaultBlockState(), properties));
            slab_waxed = registerBlock("waxed_" + path + "_slab", () -> new WeatheringCopperSlabBlock(weatherState, properties));
        }
    }


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

package com.armet;

import com.armet.block.ModBlocks;
import com.armet.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

import static net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion.MOD_ID;


@Mod(SpelunkersPalette.MODID)
public class SpelunkersPalette {
    public static final String MODID = "spelunkerspalette";

    public SpelunkersPalette(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modEventBus.addListener(this::addPackFinders);
        modEventBus.addListener(this::onClientSetup);

    }



    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {

            for (DeferredHolder<Block, ? extends Block> block : ModBlocks.BLOCKS.getEntries()){
                event.accept(block.get());
            }
        }
    }



    @SubscribeEvent
    public void addPackFinders(AddPackFindersEvent event) {

        if (event.getPackType() != PackType.CLIENT_RESOURCES) {
            return;
        }

        event.addPackFinders(
                ResourceLocation.fromNamespaceAndPath(
                        SpelunkersPalette.MODID,
                        "resourcepacks/fancy_storage_blocks"
                ),
                PackType.CLIENT_RESOURCES,
                Component.literal("Fancy Storage Blocks"),
                PackSource.DEFAULT,
                false,
                Pack.Position.TOP
        );
    }


    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {

            Minecraft mc = Minecraft.getInstance();

            // Internal ID of your built-in pack
            String packId =  "mod/spelunkerspalette:resourcepacks/fancy_storage_blocks";
            List<String> selected = new ArrayList<>(mc.options.resourcePacks);

            // First launch / not already enabled
            if (!Config.MOD_LAUNCHED.getAsBoolean()) {

                selected.add(packId);

                mc.options.resourcePacks = selected;
                mc.options.save();

                // Reload repository
                PackRepository repository = mc.getResourcePackRepository();
                repository.reload();

                // Apply selected packs
                repository.setSelected(selected);

                // Save options
                mc.options.save();

                // Reload resources so the pack actually activates
                mc.reloadResourcePacks();
                Config.MOD_LAUNCHED.set(Boolean.TRUE);
                Config.MOD_LAUNCHED.save();
            };

        });
    }

}

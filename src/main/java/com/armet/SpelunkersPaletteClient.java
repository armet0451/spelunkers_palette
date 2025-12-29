package com.armet;


import com.armet.block.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class SpelunkersPaletteClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){

        event.enqueueWork(()-> {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.IRON_DOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_IRON_DOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.OXIDIZED_IRON_DOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_IRON_DOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_IRON_DOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_OXIDIZED_IRON_DOOR.get(), RenderType.CUTOUT);
        });
    }
}

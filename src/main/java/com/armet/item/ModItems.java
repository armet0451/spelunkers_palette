package com.armet.item;

import com.armet.SpelunkersPalette;
import com.armet.SpelunkersPalette;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SpelunkersPalette.MODID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

package io.github.randomusert.mods.ogtts_core.init;

import io.github.randomusert.mods.ogtts_core.Ogtts_core;
import io.github.randomusert.mods.ogtts_core.item.IronCore;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ogtts_core.MODID);

    public static final DeferredItem<IronCore> IRON_CORE = ITEMS.registerItem("iron_core",
            IronCore::new,
            new Item.Properties().durability(10));
}

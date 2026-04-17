package io.github.randomusert.mods.ogtts_core.init;

import io.github.randomusert.mods.ogtts_core.Ogtts_core;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ogtts_core.MODID);

    public static final Supplier<CreativeModeTab> OGTTS = CREATIVE_MODE_TAB.register("ogtts_core",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.DIAMOND))
                    .title(Component.translatable("creativetab.ogtts_core.ogtts"))
                    .displayItems((itemDisplayParameter, output) -> {
                        output.accept(ModBlocks.TEST_UI_BLOCK);
                    }).build());
}

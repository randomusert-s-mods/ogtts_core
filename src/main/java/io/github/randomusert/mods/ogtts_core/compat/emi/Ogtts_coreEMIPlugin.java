package io.github.randomusert.mods.ogtts_core.compat.emi;


import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiInfoRecipe;
import dev.emi.emi.api.stack.EmiStack;
import io.github.randomusert.mods.ogtts_core.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

@EmiEntrypoint
public class Ogtts_coreEMIPlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("ogtts_core", "iron_core");
        EmiStack stack = EmiStack.of(ModItems.IRON_CORE);

        List<Component> text = List.of(
                Component.translatable("tooltip.ogtts_core.iron_core.info")
        );

        registry.addRecipe(new EmiInfoRecipe(List.of(stack), text, id));
    }
}

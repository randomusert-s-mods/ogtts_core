package io.github.randomusert.mods.ogtts_core.data;


import io.github.randomusert.mods.ogtts_core.Ogtts_core;
import io.github.randomusert.mods.ogtts_core.init.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, Ogtts_core.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.IRON_CORE.get());
    }
}

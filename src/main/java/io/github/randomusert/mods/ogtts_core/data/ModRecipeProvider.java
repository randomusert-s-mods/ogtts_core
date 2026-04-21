package io.github.randomusert.mods.ogtts_core.data;

import io.github.randomusert.mods.ogtts_core.Helpers;
import io.github.randomusert.mods.ogtts_core.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput out) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_CORE)
                .pattern("III")
                .pattern("I I")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(out);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.IRON_PICKAXE)
                .pattern("ICI")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', Items.IRON_INGOT)
                .define('C', ModItems.IRON_CORE)
                .define('S', Items.STICK)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(out, Helpers.rl("shaped/"+"iron_pickaxe"));
    }
}

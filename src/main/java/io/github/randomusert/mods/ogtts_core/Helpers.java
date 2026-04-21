package io.github.randomusert.mods.ogtts_core;

import net.minecraft.resources.ResourceLocation;

public class Helpers {
    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(Ogtts_core.MODID, path);
    }
}

package io.github.randomusert.mods.ogtts_core.init;

import io.github.randomusert.mods.ogtts_core.Ogtts_core;
import net.neoforged.fml.ModList;

public class ModDetection {
    public static void detectMods() {
        if (ModList.get().isLoaded("emi")) {
            Ogtts_core.LOGGER.info("EMI detected");
        }
        if (ModList.get().isLoaded("gtceu")){
            Ogtts_core.LOGGER.info("GTCEuM detected. Is this on the pack this mod is developed for?");
        }
    }
}

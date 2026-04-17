package io.github.randomusert.mods.ogtts_core.init;

import io.github.randomusert.mods.ogtts_core.Ogtts_core;
import io.github.randomusert.mods.ogtts_core.block.entities.TestUiBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Ogtts_core.MODID);

    public static final Supplier<BlockEntityType<TestUiBlockEntity>> TEST_UI_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "test_ui_block_entity",
            () -> BlockEntityType.Builder.of(
                    TestUiBlockEntity::new,
                    ModBlocks.TEST_UI_BLOCK.get()
            ).build(null)
    );
}

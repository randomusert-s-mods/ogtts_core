package io.github.randomusert.mods.ogtts_core.block;

import com.lowdragmc.lowdraglib2.gui.factory.BlockUIMenuType;
import com.lowdragmc.lowdraglib2.gui.ui.ModularUI;
import com.lowdragmc.lowdraglib2.gui.ui.UI;
import com.lowdragmc.lowdraglib2.gui.ui.UIElement;
import com.lowdragmc.lowdraglib2.gui.ui.elements.Label;
import com.lowdragmc.lowdraglib2.gui.ui.elements.TextField;
import com.lowdragmc.lowdraglib2.gui.ui.styletemplate.Sprites;
import dev.vfyjxf.taffy.style.AlignContent;
import io.github.randomusert.mods.ogtts_core.block.entities.StarForgeEntity;
import io.github.randomusert.mods.ogtts_core.block.entities.TestUiBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StartForgeBlock extends Block implements EntityBlock, BlockUIMenuType.BlockUI {

    public StartForgeBlock(Properties props) {
        super(props);
    }

    @Override
    public ModularUI createUI(BlockUIMenuType.BlockUIHolder holder) {
        if (holder.player.level().getBlockEntity(holder.pos) instanceof StarForgeEntity starForgeEntity) {
            return starForgeEntity.createUI(holder, holder.player);
        }
        var root = new UIElement().layout(layout -> layout
                .width(100)
                .height(100)
                .paddingAll(4)
                .gapAll(2)
                .justifyContent(AlignContent.CENTER)
        ).style(style -> style.backgroundTexture(Sprites.BORDER));
        root.addChild(new Label().setText("Star Forge"));
        root.addChild(new TextField());
        return new ModularUI(UI.of(root), holder.player);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new StarForgeEntity(blockPos, blockState);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else if (player instanceof ServerPlayer serverPlayer) {
            BlockUIMenuType.openUI(serverPlayer, pos);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
}

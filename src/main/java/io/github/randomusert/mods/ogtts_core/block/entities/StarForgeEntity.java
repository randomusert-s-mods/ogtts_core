package io.github.randomusert.mods.ogtts_core.block.entities;

import com.lowdragmc.lowdraglib2.gui.factory.BlockUIMenuType;
import com.lowdragmc.lowdraglib2.gui.sync.bindings.impl.DataBindingBuilder;
import com.lowdragmc.lowdraglib2.gui.texture.SpriteTexture;
import com.lowdragmc.lowdraglib2.gui.ui.ModularUI;
import com.lowdragmc.lowdraglib2.gui.ui.UI;
import com.lowdragmc.lowdraglib2.gui.ui.UIElement;
import com.lowdragmc.lowdraglib2.gui.ui.data.FillDirection;
import com.lowdragmc.lowdraglib2.gui.ui.data.Horizontal;
import com.lowdragmc.lowdraglib2.gui.ui.elements.Button;
import com.lowdragmc.lowdraglib2.gui.ui.elements.ItemSlot;
import com.lowdragmc.lowdraglib2.gui.ui.elements.Label;
import com.lowdragmc.lowdraglib2.gui.ui.elements.ProgressBar;
import com.lowdragmc.lowdraglib2.gui.ui.elements.inventory.InventorySlots;
import com.lowdragmc.lowdraglib2.gui.ui.styletemplate.Sprites;
import io.github.randomusert.mods.ogtts_core.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.appliedenergistics.yoga.YogaFlexDirection;

public class StarForgeEntity extends BlockEntity {
    public StarForgeEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.STAR_FORGE_BLOCK_ENTITY.get(), pos, blockState);
    }

    private Component name = Component.translatable("gui.ogtts_core.star_forge.name");
    private final ItemStackHandler itemHandler = new ItemStackHandler(2);
    private final EnergyStorage energyStorage = new EnergyStorage(100000);



    public ModularUI createUI(BlockUIMenuType.BlockUIHolder holder, Player player) {
        var root = new UIElement();
        var energy_bar = new ProgressBar();
        energy_bar.setRange(0, 100000);
        energy_bar.setProgress(0f);
        root.addChild(energy_bar);

        var bar = new ProgressBar();
        bar.setRange(0, 100);
        bar.setProgress(0f);
        root.addChild(bar);

        energy_bar.progressBarStyle(style -> style.fillDirection(FillDirection.DOWN_TO_UP));

        root.addChildren(
                // add a label to display text
                new Label().setText(name)
                        // center align text
                        .textStyle(textStyle -> textStyle.textAlignHorizontal(Horizontal.CENTER)),

                new UIElement().addChildren(
                        new ItemSlot().bind(itemHandler, 0),
                        new ItemSlot().bind(itemHandler, 1)

                ),

                // add player invotry
                new InventorySlots()

        ).style(style -> style.background(Sprites.BORDER)); // set a background for the root element
        // set padding and gap for children elements
        root.layout(layout -> layout.paddingAll(7).gapAll(5));
        // create a UI
        var ui = UI.of(root);
        // return a modular UI for runtime instance
        return ModularUI.of(ui);
    }
}

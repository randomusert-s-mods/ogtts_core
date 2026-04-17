package io.github.randomusert.mods.ogtts_core.block.entities;

import com.lowdragmc.lowdraglib2.gui.factory.BlockUIMenuType;
import com.lowdragmc.lowdraglib2.gui.texture.SpriteTexture;
import com.lowdragmc.lowdraglib2.gui.ui.ModularUI;
import com.lowdragmc.lowdraglib2.gui.ui.UI;
import com.lowdragmc.lowdraglib2.gui.ui.UIElement;
import com.lowdragmc.lowdraglib2.gui.ui.data.Horizontal;
import com.lowdragmc.lowdraglib2.gui.ui.elements.Button;
import com.lowdragmc.lowdraglib2.gui.ui.elements.Label;
import com.lowdragmc.lowdraglib2.gui.ui.elements.inventory.InventorySlots;
import com.lowdragmc.lowdraglib2.gui.ui.event.UIEvents;
import com.lowdragmc.lowdraglib2.gui.ui.style.StylesheetManager;
import com.lowdragmc.lowdraglib2.gui.ui.styletemplate.Sprites;
import com.lowdragmc.lowdraglib2.utils.XmlUtils;
import io.github.randomusert.mods.ogtts_core.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.appliedenergistics.yoga.YogaFlexDirection;

public class TestUiBlockEntity extends BlockEntity {
    public TestUiBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.TEST_UI_BLOCK_ENTITY.get(), pos, blockState);
    }

    public ModularUI createUI(BlockUIMenuType.BlockUIHolder holder, Player player) {
        // create a root element
        var root = new UIElement();
        // add an element to display an image based on a resource location
        var image = new UIElement().layout(layout -> layout.width(80).height(80))
                .style(style -> style.background(
                        SpriteTexture.of("ldlib2:textures/gui/icon.png"))
                );
        root.addChildren(
                // add a label to display text
                new Label().setText("Interaction")
                        // center align text
                        .textStyle(textStyle -> textStyle.textAlignHorizontal(Horizontal.CENTER)),
                image,
                // add a container with the row flex direction
                new UIElement().layout(layout -> layout.flexDirection(YogaFlexDirection.ROW)).addChildren(
                        // a button to rotate the image -45°
                        new Button().setText("-45°")
                                .setOnClick(e -> image.transform(transform ->
                                        transform.rotation(transform.rotation()-45))),
                        new UIElement().layout(layout -> layout.flex(1)), // occupies the remaining space
                        // a button to rotate the image 45°
                        new Button().setText("+45°")
                                .setOnClick(e -> image.transform(transform ->
                                        transform.rotation(transform.rotation() + 45)))
                )
        ).style(style -> style.background(Sprites.BORDER)); // set a background for the root element
        // set padding and gap for children elements
        root.layout(layout -> layout.paddingAll(7).gapAll(5));
        // create a UI
        var ui = UI.of(root);
        // return a modular UI for runtime instance
        return ModularUI.of(ui);
    }
}

package io.github.randomusert.mods.ogtts_core.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class IronCore extends Item {
    public IronCore(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> componentList, TooltipFlag tooltipFlag) {
        componentList.add(Component.translatable("tooltip.ogtts_core.iron_core"));
        componentList.add(Component.translatable("tooltip.ogtts_core.see_emi").withStyle(ChatFormatting.DARK_GRAY));
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return (stack.getItem() instanceof IronCore);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        int durability = itemStack.getDamageValue();

        itemStack.setDamageValue(durability + 1);

        if (itemStack.getDamageValue() == itemStack.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        return itemStack.copy();
    }
}

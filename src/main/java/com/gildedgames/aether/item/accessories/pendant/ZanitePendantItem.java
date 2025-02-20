package com.gildedgames.aether.item.accessories.pendant;

import com.gildedgames.aether.client.AetherSoundEvents;
import com.gildedgames.aether.item.AetherItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nonnull;

public class ZanitePendantItem extends PendantItem
{
    public ZanitePendantItem(Properties properties) {
        super("zanite_pendant", AetherSoundEvents.ITEM_ACCESSORY_EQUIP_ZANITE_PENDANT, properties);
    }

    @Override
    public boolean isValidRepairItem(@Nonnull ItemStack repairItem, ItemStack repairMaterial) {
        return repairMaterial.is(AetherItems.ZANITE_GEMSTONE.get());
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        if (!livingEntity.level.isClientSide() && livingEntity.tickCount % 400 == 0) {
            stack.hurtAndBreak(1, livingEntity, wearer -> CuriosApi.getCuriosHelper().onBrokenCurio(slotContext));
        }
    }
}
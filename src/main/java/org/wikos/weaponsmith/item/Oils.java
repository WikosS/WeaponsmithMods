package org.wikos.weaponsmith.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.UUID;

public class Oils extends Item {

    public Oils(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack secondhandItemStack = playerEntity.getOffHandStack(); //get the offhand itemstack
        if (secondhandItemStack.getItem() instanceof SwordItem) { //check if the offhand itemstack is a sword
            EntityAttributeModifier MODIFIER = new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", 0.5, EntityAttributeModifier.Operation.ADDITION);
            secondhandItemStack.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, MODIFIER, EquipmentSlot.MAINHAND);
            playerEntity.getStackInHand(hand).setCount(0);
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}

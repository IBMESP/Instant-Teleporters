package me.ibmesp.portals.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class SilverVoid extends Item {

    public SilverVoid(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) user;
        }
        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,60*20,1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,10*20,4));
        }
        if (user instanceof PlayerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
            ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
            stack.decrement(1);
            PlayerEntity playerEntity = (PlayerEntity) user;
            if (!playerEntity.getInventory().insertStack(itemStack)) {
                playerEntity.dropItem(itemStack, false);
            }
        }
        return stack;
    }

    @Override
    public int getMaxUseTime (ItemStack stack){
        return 40;
    }

    @Override
    public UseAction getUseAction (ItemStack stack){
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getDrinkSound () {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand){
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}

package me.ibmesp.portals.item.custom;

import me.ibmesp.portals.util.Teleporter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EndTp extends Item {

    int cooldown = 0;

    public EndTp(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (user.world.getRegistryKey() == World.NETHER)
        {
            if(cooldown < 1){
                user.sendMessage(new TranslatableText("portals.notp"), false);
                cooldown++;
            }else {
                cooldown--;
            }
        }else{
            Teleporter.teleport(user,hand);
            stack.decrement(1);
            user.getItemCooldownManager().set(this, 20);
        }
        return TypedActionResult.consume(stack);
    }
}

package me.ibmesp.portals.item.custom;

import me.ibmesp.portals.util.Teleporter;
import me.ibmesp.portals.util.TeleporterMessages;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EndTp extends Item {

    public EndTp(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (user.world.getRegistryKey() == World.NETHER)
        {
            TeleporterMessages.cooldown(user,"notp");
        }else{
            Teleporter.teleport(user,hand);
            stack.decrement(1);
            user.getItemCooldownManager().set(this, 20);
        }
        return TypedActionResult.consume(stack);
    }
}

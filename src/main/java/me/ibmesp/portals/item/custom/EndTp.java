package me.ibmesp.portals.item.custom;

import me.ibmesp.portals.util.TeleporterE;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EndTp extends Item {

    public EndTp(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.world.getRegistryKey() == World.NETHER)
        {
            user.sendMessage(new TranslatableText("portals.notp"), false);
        }else{
            TeleporterE.teleport(user);
        }
        user.getItemCooldownManager().set(this, 20);
        return super.use(world, user, hand);
    }
}

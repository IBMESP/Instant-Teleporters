package me.ibmesp.portals.item.custom;

import me.ibmesp.portals.util.TeleporterMessages;
import me.ibmesp.portals.util.Teleporter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PermaEndTp extends Item {

    public PermaEndTp(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.world.getRegistryKey() == World.NETHER) {
            TeleporterMessages.cooldown(user,"notp");
        }else if(user.experienceLevel < TeleporterMessages.getLevel() && !(user.isCreative())){
            TeleporterMessages.cooldown(user,"noexp");
        }else{
            Teleporter.teleport(user, hand);
            user.getItemCooldownManager().set(this, 20);
            user.experienceLevel = user.isCreative() ? user.experienceLevel : user.experienceLevel - TeleporterMessages.getLevel();
        }
        return super.use(world, user, hand);
    }
}

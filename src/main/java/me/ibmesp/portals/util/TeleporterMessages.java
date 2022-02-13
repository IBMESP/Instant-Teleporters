package me.ibmesp.portals.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;

public class TeleporterMessages {

    private static int cooldown = 0;

    public static int getLevel() {
        return 5;
    }

    public static void cooldown (PlayerEntity user, String reason) {
        if(cooldown < 1){
            user.sendMessage(new TranslatableText("portals." + reason), false);
            cooldown++;
        }else {
            cooldown--;
        }
    }
}

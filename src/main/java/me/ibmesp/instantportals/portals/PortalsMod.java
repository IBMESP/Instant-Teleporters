package me.ibmesp.instantportals.portals;

import me.ibmesp.instantportals.portals.item.ModItems;
import net.fabricmc.api.ModInitializer;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class PortalsMod implements ModInitializer {
    public static final String MOD_ID = "portals";
    public static final Logger LOGGER = LogManager.getLogManager().getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
    }
}

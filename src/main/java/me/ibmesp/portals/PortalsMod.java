package me.ibmesp.portals;

import me.ibmesp.portals.blocks.ModBlocks;
import me.ibmesp.portals.item.ModItems;
import me.ibmesp.portals.world.features.ModConfiguredFeatures;
import me.ibmesp.portals.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class PortalsMod implements ModInitializer {
    public static final String MOD_ID = "portals";
    public static final Logger LOGGER = LogManager.getLogManager().getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModConfiguredFeatures.registerConfiguredFeatures();
        ModWorldGen.generateModWorldGen();
    }
}

package me.ibmesp.portals.world.features;

import me.ibmesp.portals.TeleporterMod;
import me.ibmesp.portals.blocks.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;

import java.util.List;


public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_ZIRCON_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ZIRCON_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ZIRCON_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> NETHER_SILVER_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlocks.SILVER_ORE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> ZIRCON_ORE = register("zircon_ore",
            Feature.ORE.configure(new OreFeatureConfig(OVERWORLD_ZIRCON_ORES, 4)));

    public static final ConfiguredFeature<?, ?> SILVER_ORE = register("silver_ore",
            Feature.ORE.configure(new OreFeatureConfig(NETHER_SILVER_ORE, 3)));

    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TeleporterMod.MOD_ID, name),
                configuredFeature);
    }

    public static void registerConfiguredFeatures() {
    }
}

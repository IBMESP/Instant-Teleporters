package me.ibmesp.portals.world.features;

import me.ibmesp.portals.TeleporterMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.heightprovider.VeryBiasedToBottomHeightProvider;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ZIRCON_ORE_PLACED_KEY = registerKey("zircon_ore_placed");
    public static final RegistryKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");

    public static final PlacedFeature ZIRCON_ORE_PLACED = registerPlacedFeature("zircon_ore_placed",
            ModConfiguredFeatures.ZIRCON_ORE.withPlacement(ModOreFeatures.modifiersWithCount(4,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(80)))));

    public static final PlacedFeature SILVER_ORE_PLACED = registerPlacedFeature("silver_ore_placed",
            ModConfiguredFeatures.SILVER_ORE.withPlacement(ModOreFeatures.modifiersWithCount(5,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-30), YOffset.aboveBottom(30)))));

    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TeleporterMod.MOD_ID, name), placedFeature);
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(TeleporterMod.MOD_ID, name));
    }

}

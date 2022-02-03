package me.ibmesp.portals.world.features;

import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.heightprovider.VeryBiasedToBottomHeightProvider;

import java.util.List;

public class ModOreFeatures {
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
}

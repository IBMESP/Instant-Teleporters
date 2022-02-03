package me.ibmesp.portals.util;

import me.ibmesp.portals.item.ModItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTablesModifier {
    private static final Identifier END_CITY_CHEST_ID =
            new Identifier("minecraft","chests/end_city_treasure");

    public static void modifyLootTables(){
        LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
            if(END_CITY_CHEST_ID.equals(id))
            {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.SILVER_VOID))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

        });
    }
}

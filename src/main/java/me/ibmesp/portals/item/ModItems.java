package me.ibmesp.portals.item;

import me.ibmesp.portals.TeleporterMod;
import me.ibmesp.portals.item.custom.EndTp;
import me.ibmesp.portals.item.custom.NetherTp;
import me.ibmesp.portals.item.custom.PermaEndTp;
import me.ibmesp.portals.item.custom.PermaNetherTp;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //Creation of items
    public static final Item NETHER_PORTAL = registerItem("nether_tp",
            new NetherTp(new FabricItemSettings().group(ModItemGroup.PORTALS).maxCount(16).rarity(Rarity.RARE)));
    public static final Item END_PORTAL = registerItem("end_tp",
            new EndTp(new FabricItemSettings().group(ModItemGroup.PORTALS).maxCount(16).rarity(Rarity.RARE)));

    public static final Item PERMA_NETHER_PORTAL = registerItem("perma_nether_tp",
            new PermaNetherTp(new FabricItemSettings().group(ModItemGroup.PORTALS).maxCount(1).rarity(Rarity.EPIC)));
    public static final Item PERMA_END_PORTAL = registerItem("perma_end_tp",
            new PermaEndTp(new FabricItemSettings().group(ModItemGroup.PORTALS).maxCount(1).rarity(Rarity.EPIC)));

    public static final Item ZIRCON = registerItem("zircon",
            new Item(new FabricItemSettings().group(ModItemGroup.PORTALS)));

    public static final Item RAW_SILVER = registerItem("raw_silver",
            new Item(new FabricItemSettings().group(ModItemGroup.PORTALS)));
    public static final Item SILVER_INGOT = registerItem("silver_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.PORTALS)));

    public static final Item SILVER_VOID = registerItem("silver_void",
            new Item(new FabricItemSettings().group(ModItemGroup.PORTALS)));

    //Function to make easier the creation of items
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(TeleporterMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        //PortalsMod.LOGGER.info("Registering ModItems for " + PortalsMod.MOD_ID);
    }
}
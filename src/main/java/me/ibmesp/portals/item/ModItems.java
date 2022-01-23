package me.ibmesp.portals.item;

import me.ibmesp.portals.PortalsMod;
import me.ibmesp.portals.item.custom.EndTp;
import me.ibmesp.portals.item.custom.NetherTp;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //Creation of items
    public static final Item NETHER_PORTAL = registerItem("nether_tp",
            new NetherTp(new FabricItemSettings().group(ItemGroup.REDSTONE).maxCount(1)));
    public static final Item END_PORTAL = registerItem("end_tp",
            new EndTp(new FabricItemSettings().group(ItemGroup.REDSTONE).maxCount(1)));
    public static final Item ORE = registerItem("ore",
            new Item(new FabricItemSettings().group(ItemGroup.REDSTONE)));

    //Function to make easier the creation of items
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(PortalsMod.MOD_ID, name), item);
    }

    public static void registerModItems(){

    }
}

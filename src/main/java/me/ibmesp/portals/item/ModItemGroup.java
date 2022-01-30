package me.ibmesp.portals.item;

import me.ibmesp.portals.TeleporterMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup PORTALS = FabricItemGroupBuilder.build(new Identifier(TeleporterMod.MOD_ID, "portals"),
            () -> new ItemStack(ModItems.ZIRCON));
}

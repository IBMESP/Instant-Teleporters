package me.ibmesp.portals.blocks;

import me.ibmesp.portals.PortalsMod;
import me.ibmesp.portals.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block ZIRCON_ORE = registerBlocks("zircon_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemGroup.PORTALS);

    private static Block registerBlocks(String name, Block block, ItemGroup group)
    {
        registerBlocksItem(name,block,group);
        return Registry.register(Registry.BLOCK, new Identifier(PortalsMod.MOD_ID, name), block);
    }

    private static Item registerBlocksItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM,new Identifier(PortalsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks(){
        //PortalsMod.LOGGER.info("Registering ModBlocks for " + PortalsMod.MOD_ID);
    }
}

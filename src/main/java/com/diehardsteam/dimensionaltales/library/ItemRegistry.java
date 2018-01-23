package com.diehardsteam.dimensionaltales.library;

import net.minecraft.item.*;
import com.diehardsteam.dimensionaltales.metadata.items.*;
import com.diehardsteam.dimensionaltales.tabs.*;
import cpw.mods.fml.common.registry.*;
import net.minecraftforge.common.util.*;

public class ItemRegistry
{
    public static Item.ToolMaterial obsidiumIngotMaterial;
    public static Item obsidianPickaxe;
    public static Item obsidiumIngot;
    public static DimensionCore dimensionCore;
    public static Item obsidiumSword;
    public static DimensionItem dimensionItem;
    
    public static void mainRegistry() {
        initializeItem();
        registerItem();
    }
    
    public static void initializeItem() {
        ItemRegistry.obsidianPickaxe = new ObsidianPick(ItemRegistry.obsidiumIngotMaterial).setUnlocalizedName("obsidianPickaxe").setCreativeTab(ModTabs.tabTools).setTextureName("dimensionaltales:ObsidiumPickaxe");
        ItemRegistry.obsidiumIngot = new Item().setUnlocalizedName("obsidiumIngot").setTextureName("dimensionaltales:obsidiumIngot").setCreativeTab(ModTabs.tabItems);
        ItemRegistry.obsidiumSword = new ObsidiumSword(ItemRegistry.obsidiumIngotMaterial).setUnlocalizedName("obsidiumSword").setTextureName("dimensionaltales:ObsidiumSword").setCreativeTab(ModTabs.tabTools);
    }
    
    public static void registerItem() {
        GameRegistry.registerItem(ItemRegistry.obsidianPickaxe, ItemRegistry.obsidianPickaxe.getUnlocalizedName());
        GameRegistry.registerItem(ItemRegistry.obsidiumIngot, ItemRegistry.obsidiumIngot.getUnlocalizedName());
        GameRegistry.registerItem((Item)(ItemRegistry.dimensionCore = new DimensionCore("dimensionCore")), "dimensionCore");
        GameRegistry.registerItem(ItemRegistry.obsidiumSword, ItemRegistry.obsidiumSword.getUnlocalizedName());
        GameRegistry.registerItem((Item)(ItemRegistry.dimensionItem = new DimensionItem("dimensionItem")), "dimensionItem");
    }
    
    static {
        ItemRegistry.obsidiumIngotMaterial = EnumHelper.addToolMaterial("Obsidium Ingot", 5, 15000, 19.0f, 7.0f, 10);
    }
}

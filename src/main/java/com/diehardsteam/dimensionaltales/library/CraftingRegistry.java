package com.diehardsteam.dimensionaltales.library;

import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class CraftingRegistry
{
    public static void mainRegistry() {
        addCraftingRec();
        addSmeltingRec();
    }
    
    public static void addCraftingRec() {
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.obsidianPickaxe, 1), new Object[] { "XXX", " Y ", " Y ", 'X', ItemRegistry.obsidiumIngot, 'Y', Items.stick });
        GameRegistry.addRecipe(new ItemStack((Item)ItemRegistry.dimensionCore, 1), new Object[] { "XYX", "YZY", "XYX", 'X', Items.diamond, 'Y', Blocks.iron_bars, 'Z', Items.nether_star });
        GameRegistry.addRecipe(new ItemStack((Item)ItemRegistry.dimensionCore, 1, 1), new Object[] { " X ", "XYX", " X ", 'X', ItemRegistry.obsidiumIngot, 'Y', ItemRegistry.dimensionCore });
    }
    
    public static void addSmeltingRec() {
        GameRegistry.addSmelting(BlockRegistry.obsidiumOre, new ItemStack(ItemRegistry.obsidiumIngot), 100.0f);
    }
}

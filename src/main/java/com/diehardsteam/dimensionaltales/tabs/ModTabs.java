package com.diehardsteam.dimensionaltales.tabs;

import net.minecraft.creativetab.*;

public class ModTabs
{
    public static CreativeTabs tabBlock;
    public static CreativeTabs tabItems;
    public static CreativeTabs tabTools;
    
    public static void initialiseTabs() {
        ModTabs.tabBlock = new CreativeTabBlock("BlockTab");
        ModTabs.tabItems = new CreativeTabItems("ItemTab");
        ModTabs.tabTools = new CreativeTabTools("ToolTab");
    }
}

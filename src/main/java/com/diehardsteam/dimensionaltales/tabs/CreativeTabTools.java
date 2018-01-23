package com.diehardsteam.dimensionaltales.tabs;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class CreativeTabTools extends CreativeTabs
{
    public CreativeTabTools(final String lable) {
        super(lable);
    }
    
    public Item getTabIconItem() {
        return Items.diamond_pickaxe;
    }
}

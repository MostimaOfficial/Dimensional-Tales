package com.diehardsteam.dimensionaltales.tabs;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class CreativeTabItems extends CreativeTabs
{
    public CreativeTabItems(final String lable) {
        super(lable);
    }
    
    public Item getTabIconItem() {
        return Items.apple;
    }
}

package com.diehardsteam.dimensionaltales.tabs;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class CreativeTabBlock extends CreativeTabs
{
    public CreativeTabBlock(final String lable) {
        super(lable);
    }
    
    public Item getTabIconItem() {
        return Item.getItemFromBlock(Blocks.anvil);
    }
}

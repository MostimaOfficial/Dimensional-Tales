package com.diehardsteam.dimensionaltales.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import com.diehardsteam.dimensionaltales.library.*;

public class obsidiumOre extends Block
{
    public obsidiumOre(final Material ground) {
        super(ground);
        this.setHardness(120.0f);
        this.setResistance(6000.0f);
        this.setHarvestLevel("pickaxe", 3);
    }
    
    public Item getItemDropped(final int par1, final Random random, final int par2) {
        return ItemRegistry.obsidiumIngot.setUnlocalizedName("obsidiumIngot");
    }
}

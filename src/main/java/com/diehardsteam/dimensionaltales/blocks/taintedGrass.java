package com.diehardsteam.dimensionaltales.blocks;

import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

import java.util.Random;

import com.diehardsteam.dimensionaltales.library.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;

public class taintedGrass extends Block implements IGrowable
{
    private IIcon sideIcon;
    private IIcon bottomIcon;
    
    public taintedGrass(final Material grass) {
        super(grass);
        final Block taintedGrass = BlockRegistry.taintedGrass;
        this.setStepSound(Block.soundTypeGrass);
        this.setTickRandomly(true);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon("dimensionaltales:tainted_top");
        this.sideIcon = p_149651_1_.registerIcon("dimensionaltales:tainted_side");
        this.bottomIcon = p_149651_1_.registerIcon("minecraft:dirt");
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final IBlockAccess p_149673_1_, final int p_149673_2_, final int p_149673_3_, final int p_149673_4_, final int p_149673_5_) {
        if (p_149673_5_ == 1) {
            return this.blockIcon;
        }
        if (p_149673_5_ == 0) {
            return this.bottomIcon;
        }
        return this.sideIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        if (side == 1) {
            return this.blockIcon;
        }
        if (side == 0) {
            return this.bottomIcon;
        }
        return this.sideIcon;
    }

	@Override
	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_,
			boolean p_149851_5_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_,
			int p_149852_5_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_,
			int p_149853_5_) {
		// TODO Auto-generated method stub
		
	}
}

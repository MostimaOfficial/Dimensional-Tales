package com.diehardsteam.dimensionaltales.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import com.diehardsteam.dimensionaltales.library.BlockRegistry;
import com.diehardsteam.dimensionaltales.tabs.ModTabs;
import com.diehardsteam.dimensionaltales.world.WorldGenTaintTree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class taintedTree extends BlockBush implements IGrowable
{
    public static final String[] sapling = new String[] {"tainted"};
    private static final IIcon[] saplingIco = new IIcon[sapling.length];

    public taintedTree()
    {
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(ModTabs.tabBlock);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random p_149674_5_)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, x, y, z, p_149674_5_);

            if (world.getBlockLightValue(x, y + 1, z) >= 9 && p_149674_5_.nextInt(7) == 0)
            {
                this.func_149879_c(world, x, y, z, p_149674_5_);
            }
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        p_149691_2_ &= 7;
        return saplingIco[MathHelper.clamp_int(p_149691_2_, 0, 5)];
    }

    public void func_149879_c(World p_149879_1_, int p_149879_2_, int p_149879_3_, int p_149879_4_, Random p_149879_5_)
    {
        int l = p_149879_1_.getBlockMetadata(p_149879_2_, p_149879_3_, p_149879_4_);

        if ((l & 8) == 0)
        {
            p_149879_1_.setBlockMetadataWithNotify(p_149879_2_, p_149879_3_, p_149879_4_, l | 8, 4);
        }
        else
        {
            this.func_149878_d(p_149879_1_, p_149879_2_, p_149879_3_, p_149879_4_, p_149879_5_);
        }
    }

    public void func_149878_d(World p_149878_1_, int p_149878_2_, int p_149878_3_, int p_149878_4_, Random p_149878_5_)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(p_149878_1_, p_149878_5_, p_149878_2_, p_149878_3_, p_149878_4_)) return;
        int l = p_149878_1_.getBlockMetadata(p_149878_2_, p_149878_3_, p_149878_4_) & 7;
        Object object = p_149878_5_.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        switch (l)
        {
            case 0:
            	object = new WorldGenTaintTree(Blocks.log, BlockRegistry.taintedLeave, 0, 0, false, 5, 10, false);
                break;
            case 1:

                break;
            case 2:
            
                break;
            case 3:
                break;
            case 4:
               
                break;
            case 5:
            	break;
        }

        Block block = Blocks.air;

        if (flag)
        {
            p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, block, 0, 4);
            p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, block, 0, 4);
            p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, block, 0, 4);
            p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, block, 0, 4);
        }
        else
        {
            p_149878_1_.setBlock(p_149878_2_, p_149878_3_, p_149878_4_, block, 0, 4);
        }

        if (!((WorldGenerator)object).generate(p_149878_1_, p_149878_5_, p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1))
        {
            if (flag)
            {
                p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, this, l, 4);
                p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, this, l, 4);
                p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, this, l, 4);
                p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, this, l, 4);
            }
            else
            {
                p_149878_1_.setBlock(p_149878_2_, p_149878_3_, p_149878_4_, this, l, 4);
            }
        }
    }

    public boolean func_149880_a(World p_149880_1_, int p_149880_2_, int p_149880_3_, int p_149880_4_, int p_149880_5_)
    {
        return p_149880_1_.getBlock(p_149880_2_, p_149880_3_, p_149880_4_) == this && (p_149880_1_.getBlockMetadata(p_149880_2_, p_149880_3_, p_149880_4_) & 7) == p_149880_5_;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return MathHelper.clamp_int(p_149692_1_ & 7, 0, 5);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
    		for (int i = 0; i < sapling.length; i++) {
    			list.add(new ItemStack(item, 1, i));
    		}
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        for (int i = 0; i < saplingIco.length; ++i)
        {
            saplingIco[i] = p_149651_1_.registerIcon(this.getUnlocalizedName().substring(5) + "_" + sapling[i]);
        }
    }

    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        return true;
    }

    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return (double)p_149852_1_.rand.nextFloat() < 0.45D;
    }

    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_)
    {
        this.func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
    }
}
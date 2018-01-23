package com.diehardsteam.dimensionaltales.library;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import com.diehardsteam.dimensionaltales.tabs.*;
import com.diehardsteam.dimensionaltales.blocks.*;
import cpw.mods.fml.common.registry.*;

public class BlockRegistry
{
    public static Block obsidiumOre;
    public static Block taintedGrass;
    public static Block taintedTree;
    public static Block taintedLeave;
    
    public static void mainRegistry() {
        initilizeBlock();
        registerItem();
    }
    
    public static void initilizeBlock() {
        BlockRegistry.obsidiumOre = new obsidiumOre(Material.ground).setBlockName("ObsidiumOre").setBlockTextureName("dimensionaltales:obsidiumore").setCreativeTab(ModTabs.tabBlock);
        BlockRegistry.taintedGrass = new taintedGrass(Material.grass).setBlockName("TaintedGrass").setCreativeTab(ModTabs.tabBlock);
        BlockRegistry.taintedLeave = new taintedLeave().setBlockName("TaintedLeave");
        BlockRegistry.taintedTree = new taintedTree().setBlockName("TaintedTree");
    }
    
    public static void registerItem() {
        GameRegistry.registerBlock(BlockRegistry.obsidiumOre, BlockRegistry.obsidiumOre.getUnlocalizedName());
        GameRegistry.registerBlock(BlockRegistry.taintedGrass, BlockRegistry.taintedGrass.getUnlocalizedName());
        GameRegistry.registerBlock(BlockRegistry.taintedLeave, BlockRegistry.taintedLeave.getUnlocalizedName());
        GameRegistry.registerBlock(BlockRegistry.taintedTree, BlockRegistry.taintedTree.getUnlocalizedName());
    }
}

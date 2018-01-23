package com.diehardsteam.dimensionaltales.biomes;

import com.diehardsteam.dimensionaltales.library.BlockRegistry;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenPlains;

public class BiomeGenDimension extends BiomeGenBase
{
    public BiomeGenDimension(final int id) {
        super(id);
        this.theBiomeDecorator.grassPerChunk = 2;
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry((Class)EntitySlime.class, 5, 2, 10));
        this.topBlock = BlockRegistry.taintedGrass;
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.treesPerChunk = 5;
    }
}

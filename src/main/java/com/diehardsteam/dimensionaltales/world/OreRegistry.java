package com.diehardsteam.dimensionaltales.world;

import cpw.mods.fml.common.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.feature.*;
import com.diehardsteam.dimensionaltales.library.*;
import net.minecraft.init.*;

public class OreRegistry implements IWorldGenerator
{
    public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1: {
                this.generateNether(random, chunkX * 16, chunkZ * 16, world);
                break;
            }
            case 0: {
                this.generateOverworld(random, chunkX * 16, chunkZ * 16, world);
                break;
            }
            case 1: {
                this.generateEnd(random, chunkX * 16, chunkZ * 16, world);
                break;
            }
        }
    }
    
    private void addOre(final Block block, final Block blockspawn, final Random random, final World world, final int posX, final int posZ, final int minY, final int maxY, final int minVein, final int maxVein, final int spawnChance) {
        for (int i = 0; i < spawnChance; ++i) {
            final int defaultChunkSize = 16;
            final int xPos = posX + random.nextInt(defaultChunkSize);
            final int zPos = posZ + random.nextInt(defaultChunkSize);
            final int yPos = minY + random.nextInt(maxY - minY);
            new WorldGenMinable(block, minVein + random.nextInt(maxVein - minVein), blockspawn).generate(world, random, xPos, yPos, zPos);
        }
    }
    
    private void generateEnd(final Random random, final int chunkX, final int chunkY, final World world) {
    }
    
    private void generateOverworld(final Random random, final int chunkX, final int chunkZ, final World world) {
        this.addOre(BlockRegistry.obsidiumOre, Blocks.stone, random, world, chunkX, chunkZ, 5, 30, 1, 2, 50);
    }
    
    private void generateNether(final Random random, final int chunkX, final int chunkY, final World world) {
    }
}

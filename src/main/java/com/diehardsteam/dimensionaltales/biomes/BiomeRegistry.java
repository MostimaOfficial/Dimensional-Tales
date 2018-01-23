package com.diehardsteam.dimensionaltales.biomes;

import net.minecraft.world.biome.*;
import net.minecraftforge.common.*;

public class BiomeRegistry
{
    public static BiomeGenBase biomeDimension;
    
    public static void MainRegistry() {
        initializeBiome();
        registerBiome();
    }
    
    public static void initializeBiome() {
        BiomeRegistry.biomeDimension = new BiomeGenDimension(40).setBiomeName("Dimension").setTemperatureRainfall(1.2f, 0.9f);
    }
    
    public static void registerBiome() {
        BiomeDictionary.registerBiomeType(BiomeRegistry.biomeDimension, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeManager.addSpawnBiome(BiomeRegistry.biomeDimension);
    }
}

package com.diehardsteam.dimensionaltales.world;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.registry.*;

public class mcworld
{
    public static void mainRegistry() {
        initiliseWorldGen();
    }
    
    public static void initiliseWorldGen() {
        registerWorldGen((IWorldGenerator)new OreRegistry(), 1);
    }
    
    public static void registerWorldGen(final IWorldGenerator worldGenClass, final int weightedProbability) {
        GameRegistry.registerWorldGenerator(worldGenClass, weightedProbability);
    }
}

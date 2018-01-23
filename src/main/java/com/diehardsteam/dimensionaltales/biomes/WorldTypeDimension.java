package com.diehardsteam.dimensionaltales.biomes;

import net.minecraft.world.*;
import net.minecraft.world.gen.layer.*;

public class WorldTypeDimension extends WorldType
{
    public WorldTypeDimension(final int par1, final String name) {
        super(name);
    }
    
    public GenLayer getBiomeLayer(final long worldSeed, final GenLayer parentLayer) {
        GenLayer ret = new DimensionGenLayerBiome(200L, parentLayer, this);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = (GenLayer)new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }
}

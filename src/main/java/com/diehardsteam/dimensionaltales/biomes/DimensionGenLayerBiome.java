package com.diehardsteam.dimensionaltales.biomes;

import net.minecraftforge.common.*;
import net.minecraft.world.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.*;

public class DimensionGenLayerBiome extends GenLayer
{
    private List<BiomeManager.BiomeEntry>[] biomes;
    private static final String __OBFID = "CL_00000555";
    
    public DimensionGenLayerBiome(final long p_i2122_1_, final GenLayer p_i2122_3_, final WorldType p_i2122_4_) {
        super(p_i2122_1_);
        this.biomes = (List<BiomeManager.BiomeEntry>[])new ArrayList[BiomeManager.BiomeType.values().length];
        this.parent = p_i2122_3_;
        for (final BiomeManager.BiomeType type : BiomeManager.BiomeType.values()) {
            final ImmutableList<BiomeManager.BiomeEntry> biomesToAdd = (ImmutableList<BiomeManager.BiomeEntry>)BiomeManager.getBiomes(type);
            final int idx = type.ordinal();
            if (this.biomes[idx] == null) {
                this.biomes[idx] = new ArrayList<BiomeManager.BiomeEntry>();
            }
            if (biomesToAdd != null) {
                this.biomes[idx].addAll((Collection<? extends BiomeManager.BiomeEntry>)biomesToAdd);
            }
        }
        final int desertIdx = BiomeManager.BiomeType.DESERT.ordinal();
        if (p_i2122_4_ == WorldType.DEFAULT_1_1) {
            this.biomes[desertIdx].add(new BiomeManager.BiomeEntry(BiomeRegistry.biomeDimension, 10));
        }
        else {
            this.biomes[desertIdx].add(new BiomeManager.BiomeEntry(BiomeRegistry.biomeDimension, 10));
        }
    }
    
    public int[] getInts(final int p_75904_1_, final int p_75904_2_, final int p_75904_3_, final int p_75904_4_) {
        final int[] aint = this.parent.getInts(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
        final int[] aint2 = IntCache.getIntCache(p_75904_3_ * p_75904_4_);
        for (int i1 = 0; i1 < p_75904_4_; ++i1) {
            for (int j1 = 0; j1 < p_75904_3_; ++j1) {
                this.initChunkSeed((long)(j1 + p_75904_1_), (long)(i1 + p_75904_2_));
                int k1 = aint[j1 + i1 * p_75904_3_];
                final int l1 = (k1 & 0xF00) >> 8;
                k1 &= 0xFFFFF0FF;
                if (isBiomeOceanic(k1)) {
                    aint2[j1 + i1 * p_75904_3_] = k1;
                }
                else if (k1 == BiomeGenBase.mushroomIsland.biomeID) {
                    aint2[j1 + i1 * p_75904_3_] = k1;
                }
                else if (k1 == 1) {
                    if (l1 > 0) {
                        if (this.nextInt(3) == 0) {
                            aint2[j1 + i1 * p_75904_3_] = BiomeGenBase.mesaPlateau.biomeID;
                        }
                        else {
                            aint2[j1 + i1 * p_75904_3_] = BiomeGenBase.mesaPlateau_F.biomeID;
                        }
                    }
                    else {
                        aint2[j1 + i1 * p_75904_3_] = this.getWeightedBiomeEntry(BiomeManager.BiomeType.DESERT).biome.biomeID;
                    }
                }
                else if (k1 == 2) {
                    if (l1 > 0) {
                        aint2[j1 + i1 * p_75904_3_] = BiomeGenBase.jungle.biomeID;
                    }
                    else {
                        aint2[j1 + i1 * p_75904_3_] = this.getWeightedBiomeEntry(BiomeManager.BiomeType.WARM).biome.biomeID;
                    }
                }
                else if (k1 == 3) {
                    if (l1 > 0) {
                        aint2[j1 + i1 * p_75904_3_] = BiomeGenBase.megaTaiga.biomeID;
                    }
                    else {
                        aint2[j1 + i1 * p_75904_3_] = this.getWeightedBiomeEntry(BiomeManager.BiomeType.COOL).biome.biomeID;
                    }
                }
                else if (k1 == 4) {
                    aint2[j1 + i1 * p_75904_3_] = this.getWeightedBiomeEntry(BiomeManager.BiomeType.ICY).biome.biomeID;
                }
                else {
                    aint2[j1 + i1 * p_75904_3_] = BiomeGenBase.mushroomIsland.biomeID;
                }
            }
        }
        return aint2;
    }
    
    protected BiomeManager.BiomeEntry getWeightedBiomeEntry(final BiomeManager.BiomeType type) {
        final List<BiomeManager.BiomeEntry> biomeList = this.biomes[type.ordinal()];
        final int totalWeight = WeightedRandom.getTotalWeight((Collection)biomeList);
        final int weight = BiomeManager.isTypeListModded(type) ? this.nextInt(totalWeight) : (this.nextInt(totalWeight / 10) * 10);
        return (BiomeManager.BiomeEntry)WeightedRandom.getItem((Collection)biomeList, weight);
    }
}

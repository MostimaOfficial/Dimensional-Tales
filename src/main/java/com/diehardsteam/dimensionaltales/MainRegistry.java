package com.diehardsteam.dimensionaltales;

import cpw.mods.fml.common.*;
import com.diehardsteam.dimensionaltales.tabs.*;
import com.diehardsteam.dimensionaltales.library.*;
import com.diehardsteam.dimensionaltales.world.*;
import com.diehardsteam.dimensionaltales.entities.*;
import cpw.mods.fml.common.event.*;
import com.diehardsteam.dimensionaltales.biomes.*;
import net.minecraft.world.*;

@Mod(modid = "dimensionaltales", name = "Dimensional Tales", version = "1.0")
public class MainRegistry
{
    @SidedProxy(clientSide = "com.diehardsteam.dimensionaltales.library.ClientProxy", serverSide = "com.diehardsteam.dimensionaltales.library.ServerProxy")
    public static ServerProxy proxy;
    @Mod.Instance("dimensionaltales")
    public static MainRegistry modInstance;
    
    @Mod.EventHandler
    public static void PreLoad(final FMLPreInitializationEvent PreEvent) {
        ModTabs.initialiseTabs();
        ItemRegistry.mainRegistry();
        BlockRegistry.mainRegistry();
        CraftingRegistry.mainRegistry();
        MainRegistry.proxy.registerRenderInfo();
        mcworld.mainRegistry();
        EntityTestLib.mainRegistry();
        BiomeRegistry.MainRegistry();
    }
    
    @Mod.EventHandler
    public static void load(final FMLInitializationEvent event) {
    }
    
    @Mod.EventHandler
    public static void PostLoad(final FMLPostInitializationEvent PostEvent) {
        final WorldType DIMENSION = new WorldTypeDimension(3, "dimension");
    }
}

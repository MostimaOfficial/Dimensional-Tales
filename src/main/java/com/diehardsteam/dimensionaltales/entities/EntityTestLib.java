package com.diehardsteam.dimensionaltales.entities;

import com.diehardsteam.dimensionaltales.*;
import net.minecraft.entity.*;

public class EntityTestLib
{
    public static void mainRegistry() {
        registerEntity();
    }
    
    public static void registerEntity() {
        createEntity(EntityTest.class, "TestMob", 16711680, 7935);
    }
    
    public static void createEntity(final Class entityClass, final String entityName, final int solidColour, final int spotColour) {
        final int randomId = findGlobalUniqueEntityId();
        registerGlobalEntityID(entityClass, entityName, randomId);
        registerModEntity(entityClass, entityName, randomId, MainRegistry.modInstance, 64, 1, true);
        createEgg(randomId, solidColour, spotColour);
    }
    
    private static void registerModEntity(final Class entityClass, final String entityName, final int randomId, final MainRegistry modInstance, final int i, final int j, final boolean b) {
    }
    
    private static void registerGlobalEntityID(final Class entityClass, final String entityName, final int randomId) {
    }
    
    private static int findGlobalUniqueEntityId() {
        return 0;
    }
    
    private static void createEgg(final int randomId, final int solidColour, final int spotColour) {
        EntityList.entityEggs.put(randomId, new EntityList.EntityEggInfo(randomId, solidColour, spotColour));
    }
}

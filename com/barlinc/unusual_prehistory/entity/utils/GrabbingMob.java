/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 */
package com.barlinc.unusual_prehistory.entity.utils;

import net.minecraft.world.entity.Entity;

public interface GrabbingMob {
    public void setHeldMobId(int var1);

    public int getHeldMobId();

    default public Entity getHeldMob(Entity entity) {
        int id = this.getHeldMobId();
        return id == -1 ? null : entity.m_9236_().m_6815_(id);
    }
}


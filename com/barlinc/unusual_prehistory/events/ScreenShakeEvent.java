/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.events;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class ScreenShakeEvent {
    private final Vec3 position;
    private final int duration;
    private final float degree;
    private final float distance;
    private final boolean groundRequired;
    private int age;

    public ScreenShakeEvent(Vec3 position, int duration, float degree, float distance, boolean groundRequired) {
        this.position = position;
        this.duration = duration;
        this.degree = degree;
        this.distance = distance;
        this.groundRequired = groundRequired;
        this.age = 0;
    }

    public float getDegree(Entity cameraEntity, float partialTicks) {
        double dist = this.position.m_82554_(cameraEntity.m_20182_());
        if (dist < (double)this.distance && (!this.groundRequired || cameraEntity.m_20096_())) {
            return (1.0f - (float)(dist / (double)this.distance)) * this.degree * (float)Math.sin((double)(((float)this.age + partialTicks) / (float)this.duration) * Math.PI);
        }
        return 0.0f;
    }

    public void tick() {
        ++this.age;
    }

    public boolean isDone() {
        return this.age >= this.duration;
    }
}


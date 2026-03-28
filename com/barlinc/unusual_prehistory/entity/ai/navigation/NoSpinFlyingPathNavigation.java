/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.navigation.FlyingPathNavigation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.navigation;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class NoSpinFlyingPathNavigation
extends FlyingPathNavigation {
    public float distanceModifier = 0.75f;

    public NoSpinFlyingPathNavigation(Mob mob, Level level) {
        super(mob, level);
    }

    public NoSpinFlyingPathNavigation(Mob mob, Level level, float distanceModifier) {
        super(mob, level);
        this.distanceModifier = distanceModifier;
    }

    protected void m_7636_() {
        boolean flag;
        Vec3 vec3 = this.m_7475_();
        this.f_26505_ = this.f_26494_.m_20205_() * this.distanceModifier;
        BlockPos nodePos = this.f_26496_.m_77400_();
        double d0 = Math.abs(this.f_26494_.m_20185_() - ((double)nodePos.m_123341_() + 0.5));
        double d2 = Math.abs(this.f_26494_.m_20189_() - ((double)nodePos.m_123343_() + 0.5));
        boolean bl = flag = d0 < (double)this.f_26505_ && d2 < (double)this.f_26505_;
        if (flag || this.m_264193_(this.f_26496_.m_77401_().f_77282_) && this.m_26559_(vec3)) {
            this.f_26496_.m_77374_();
        }
        this.m_6481_(vec3);
    }

    public boolean m_26559_(Vec3 currentPosition) {
        Vec3 vec33;
        if (this.f_26496_.m_77399_() + 1 >= this.f_26496_.m_77398_()) {
            return false;
        }
        Vec3 vec3 = Vec3.m_82539_((Vec3i)this.f_26496_.m_77400_());
        if (!currentPosition.m_82509_((Position)vec3, 2.0)) {
            return false;
        }
        Vec3 vec31 = Vec3.m_82539_((Vec3i)this.f_26496_.m_77396_(this.f_26496_.m_77399_() + 1));
        Vec3 vec32 = vec31.m_82546_(vec3);
        return vec32.m_82526_(vec33 = currentPosition.m_82546_(vec3)) > 0.0;
    }
}


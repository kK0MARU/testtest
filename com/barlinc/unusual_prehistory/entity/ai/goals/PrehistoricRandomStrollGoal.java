/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.ai.util.LandRandomPos
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import javax.annotation.Nullable;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.phys.Vec3;

public class PrehistoricRandomStrollGoal
extends RandomStrollGoal {
    protected final boolean shouldAvoidWater;

    public PrehistoricRandomStrollGoal(PathfinderMob mob, double speedModifier) {
        this(mob, speedModifier, 120, true);
    }

    public PrehistoricRandomStrollGoal(PathfinderMob mob, double speedModifier, boolean shouldAvoidWater) {
        this(mob, speedModifier, 120, shouldAvoidWater);
    }

    public PrehistoricRandomStrollGoal(PathfinderMob mob, double speedModifier, int interval, boolean shouldAvoidWater) {
        super(mob, speedModifier, interval, true);
        this.shouldAvoidWater = shouldAvoidWater;
    }

    @Nullable
    protected Vec3 m_7037_() {
        if (this.shouldAvoidWater) {
            if (this.f_25725_.m_20069_()) {
                Vec3 randomPos = LandRandomPos.m_148488_((PathfinderMob)this.f_25725_, (int)30, (int)8);
                return randomPos == null ? LandRandomPos.m_148488_((PathfinderMob)this.f_25725_, (int)10, (int)7) : randomPos;
            }
            Vec3 randomPos = this.f_25725_.m_217043_().m_188501_() > 0.001f ? LandRandomPos.m_148488_((PathfinderMob)this.f_25725_, (int)10, (int)7) : DefaultRandomPos.m_148403_((PathfinderMob)this.f_25725_, (int)10, (int)7);
            return randomPos;
        }
        return DefaultRandomPos.m_148403_((PathfinderMob)this.f_25725_, (int)10, (int)7);
    }
}


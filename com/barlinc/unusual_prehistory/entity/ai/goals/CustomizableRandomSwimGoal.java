/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.behavior.BehaviorUtils
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import javax.annotation.Nullable;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.phys.Vec3;

public class CustomizableRandomSwimGoal
extends RandomStrollGoal {
    private final int radius;
    private final int height;
    private final int proximity;
    private final boolean hasProximity;
    protected Vec3 wantedPos;

    public CustomizableRandomSwimGoal(PathfinderMob entity, double speedMultiplier, int interval, int radius, int height) {
        this(entity, speedMultiplier, interval, radius, height, 0, false);
    }

    public CustomizableRandomSwimGoal(PathfinderMob entity, double speedMultiplier, int interval) {
        this(entity, speedMultiplier, interval, 10, 7, 0, false);
    }

    public CustomizableRandomSwimGoal(PathfinderMob entity, double speedMultiplier, int interval, int proximity) {
        this(entity, speedMultiplier, interval, 10, 7, proximity, true);
    }

    public CustomizableRandomSwimGoal(PathfinderMob entity, double speedMultiplier, int interval, int radius, int height, int proximity, boolean hasProximity) {
        super(entity, speedMultiplier, interval);
        this.radius = radius;
        this.height = height;
        this.proximity = proximity;
        this.hasProximity = hasProximity;
    }

    public boolean m_8045_() {
        this.wantedPos = new Vec3(this.f_25726_, this.f_25727_, this.f_25728_);
        if (this.hasProximity) {
            return super.m_8045_() && !(this.wantedPos.m_82554_(this.f_25725_.m_20182_()) <= (double)(this.f_25725_.m_20205_() * (float)this.proximity));
        }
        return super.m_8045_();
    }

    @Nullable
    protected Vec3 m_7037_() {
        return BehaviorUtils.m_147444_((PathfinderMob)this.f_25725_, (int)this.radius, (int)this.height);
    }
}


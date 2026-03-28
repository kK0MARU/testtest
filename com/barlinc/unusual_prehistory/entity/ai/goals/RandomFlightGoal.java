/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricFlyingMob;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class RandomFlightGoal
extends Goal {
    protected final PrehistoricFlyingMob mob;
    protected final float speedModifier;
    protected final float runningSpeedModifier;
    private final int flightRange;
    private final int flightHeight;
    private final int interval;
    protected final int maxTimeFlying;
    protected double x;
    protected double y;
    protected double z;

    public RandomFlightGoal(PrehistoricFlyingMob mob, float speedModifier, float runningSpeedModifier, int flightRange, int flightHeight, int interval, int maxTimeFlying) {
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE));
        this.flightRange = flightRange;
        this.flightHeight = flightHeight;
        this.maxTimeFlying = maxTimeFlying;
        this.speedModifier = speedModifier;
        this.runningSpeedModifier = runningSpeedModifier;
        this.interval = interval;
        this.mob = mob;
    }

    public boolean m_8036_() {
        if (this.mob.isDancing() || this.mob.m_20160_() || this.mob.m_5448_() != null && this.mob.m_5448_().m_6084_() || this.mob.m_20159_()) {
            return false;
        }
        if (!this.mob.m_29443_() && this.mob.m_217043_().m_188503_(this.interval) != 0) {
            return false;
        }
        Vec3 target = this.getPosition();
        this.x = target.f_82479_;
        this.y = target.f_82480_;
        this.z = target.f_82481_;
        return true;
    }

    public void m_8056_() {
        this.mob.setFlying(true);
        this.mob.m_21573_().m_26519_(this.x, this.y, this.z, this.mob.isRunning() ? (double)this.runningSpeedModifier : (double)this.speedModifier);
        if (this.mob.m_20096_()) {
            this.mob.m_20256_(this.mob.m_20184_().m_82520_(0.0, 0.5, 0.0));
        }
    }

    public void m_8041_() {
        this.mob.m_21573_().m_26573_();
        this.mob.landingFlag = false;
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public void m_8037_() {
        if (this.mob.m_29443_() && this.mob.m_20096_() && this.mob.flightTicks > 40) {
            this.mob.setFlying(false);
        }
        if (this.mob.m_29443_() && this.mob.flightTicks % this.maxTimeFlying == 0 && !this.isOverWaterOrVoid()) {
            this.mob.landingFlag = true;
        }
        if (this.isOverWaterOrVoid() || this.mob.m_20072_()) {
            this.mob.setFlying(true);
            this.mob.landingFlag = false;
        }
    }

    public boolean m_8045_() {
        if (this.mob.landingFlag) {
            return !this.mob.m_21573_().m_26571_() && !this.mob.m_20096_() && this.mob.groundTicks <= 0;
        }
        return this.mob.m_29443_() && !this.mob.m_21573_().m_26571_() && this.mob.groundTicks <= 0;
    }

    protected Vec3 getPosition() {
        return this.findFlightPos();
    }

    protected Vec3 findFlightPos() {
        Vec3 heightAdjusted = this.mob.m_20182_().m_82520_((double)(this.mob.m_217043_().m_188503_(this.flightRange * 2) - this.flightRange), 0.0, (double)(this.mob.m_217043_().m_188503_(this.flightRange * 2) - this.flightRange));
        if (this.mob.m_9236_().m_45527_(BlockPos.m_274446_((Position)heightAdjusted))) {
            ground = this.groundPosition(heightAdjusted);
            heightAdjusted = new Vec3(heightAdjusted.f_82479_, ground.f_82480_ + (double)this.flightHeight + (double)this.mob.m_217043_().m_188503_(6), heightAdjusted.f_82481_);
        } else {
            ground = this.groundPosition(heightAdjusted);
            BlockPos ceiling = BlockPos.m_274446_((Position)ground).m_6630_(2);
            while (ceiling.m_123342_() < this.mob.m_9236_().m_151558_() && !this.mob.m_9236_().m_8055_(ceiling).m_280296_()) {
                ceiling = ceiling.m_7494_();
            }
            float randCeilVal = 0.3f + this.mob.m_217043_().m_188501_() * 0.5f;
            heightAdjusted = new Vec3(heightAdjusted.f_82479_, ground.f_82480_ + ((double)ceiling.m_123342_() - ground.f_82480_) * (double)randCeilVal, heightAdjusted.f_82481_);
        }
        BlockHitResult result = this.mob.m_9236_().m_45547_(new ClipContext(this.mob.m_146892_(), heightAdjusted, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)this.mob));
        if (result.m_6662_() == HitResult.Type.MISS) {
            return heightAdjusted;
        }
        return result.m_82450_();
    }

    public Vec3 groundPosition(Vec3 airPosition) {
        BlockPos.MutableBlockPos ground = new BlockPos.MutableBlockPos();
        ground.m_122169_(airPosition.f_82479_, airPosition.f_82480_, airPosition.f_82481_);
        boolean flag = false;
        while (ground.m_123342_() < this.mob.m_9236_().m_151558_() && !this.mob.m_9236_().m_8055_((BlockPos)ground).m_280296_() && this.mob.m_9236_().m_6425_((BlockPos)ground).m_76178_()) {
            ground.m_122184_(0, 1, 0);
            flag = true;
        }
        ground.m_122184_(0, -1, 0);
        while (ground.m_123342_() > this.mob.m_9236_().m_141937_() && !this.mob.m_9236_().m_8055_((BlockPos)ground).m_280296_() && this.mob.m_9236_().m_6425_((BlockPos)ground).m_76178_()) {
            ground.m_122184_(0, -1, 0);
        }
        return Vec3.m_82512_((Vec3i)(flag ? ground.m_7494_() : ground.m_7495_()));
    }

    protected boolean isOverWaterOrVoid() {
        BlockPos position = this.mob.m_20183_();
        while (position.m_123342_() > this.mob.m_9236_().m_141937_() && this.mob.m_9236_().m_46859_(position) && this.mob.m_9236_().m_6425_(position).m_76178_()) {
            position = position.m_7495_();
        }
        return !this.mob.m_9236_().m_6425_(position).m_76178_() || this.mob.m_9236_().m_8055_(position).m_60713_(Blocks.f_50191_) || position.m_123342_() <= this.mob.m_9236_().m_141937_();
    }
}


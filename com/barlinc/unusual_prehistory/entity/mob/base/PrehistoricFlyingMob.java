/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.animal.FlyingAnimal
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.base;

import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricFlyingLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricFlyingMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinFlyingPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class PrehistoricFlyingMob
extends PrehistoricMob
implements FlyingAnimal {
    private static final EntityDataAccessor<Boolean> FLYING = SynchedEntityData.m_135353_(PrehistoricFlyingMob.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    protected float flyProgress;
    protected float prevFlyProgress;
    public int flightTicks = 0;
    protected float flightPitch = 0.0f;
    protected float prevFlightPitch = 0.0f;
    protected float flightRoll = 0.0f;
    protected float prevFlightRoll = 0.0f;
    public int groundTicks = 0;
    public boolean isLandNavigator;
    public boolean landingFlag;
    public final SmoothAnimationState flyAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState flyFastAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState hoverAnimationState = new SmoothAnimationState();

    protected PrehistoricFlyingMob(EntityType<? extends PrehistoricFlyingMob> entityType, Level level) {
        super(entityType, level);
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.f_21342_ = new PrehistoricMoveControl(this);
            this.f_21365_ = new PrehistoricLookControl(this);
            this.f_21344_ = this.m_6037_(this.m_9236_());
            this.isLandNavigator = true;
        } else {
            this.f_21342_ = new PrehistoricFlyingMoveControl(this);
            this.f_21365_ = new PrehistoricFlyingLookControl((Mob)this, 85);
            this.f_21344_ = new NoSpinFlyingPathNavigation((Mob)this, this.m_9236_());
            this.isLandNavigator = false;
        }
    }

    @Override
    public boolean m_142535_(float fallDistance, float multiplier, @NotNull DamageSource damageSource) {
        return false;
    }

    protected void m_7840_(double y, boolean onGround, @NotNull BlockState state, @NotNull BlockPos pos) {
    }

    public boolean canTrample(@NotNull BlockState state, @NotNull BlockPos pos, float fallDistance) {
        return false;
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        this.prevFlyProgress = this.flyProgress;
        this.prevFlightPitch = this.flightPitch;
        this.prevFlightRoll = this.flightRoll;
        this.tickFlight();
        this.tickRotation((float)this.m_20184_().f_82480_ * 2.0f * -57.295776f);
    }

    public void tickFlight() {
        if (this.m_29443_() && this.flyProgress < 5.0f) {
            this.flyProgress += 1.0f;
        }
        if (!this.m_29443_() && this.flyProgress > 0.0f) {
            this.flyProgress -= 1.0f;
        }
        if (this.m_29443_()) {
            ++this.flightTicks;
            this.m_20242_(true);
            if (this.groundTicks > 0) {
                this.setFlying(false);
            }
            if (this.isLandNavigator) {
                this.switchNavigator(false);
            }
        } else {
            this.flightTicks = 0;
            this.m_20242_(false);
            if (!this.isLandNavigator) {
                this.switchNavigator(true);
            }
        }
        if (this.groundTicks > 0) {
            --this.groundTicks;
        }
        if (!this.m_9236_().f_46443_) {
            if (this.m_29443_() && this.m_6084_() && !this.m_20160_()) {
                if (this.landingFlag) {
                    this.m_20256_(this.m_20184_().m_82520_(0.0, -0.1, 0.0));
                }
                if (this.f_19862_ && !this.landingFlag && !this.m_20069_()) {
                    this.m_20256_(this.m_20184_().m_82520_(0.0, 0.05, 0.0));
                }
            }
            if (this.m_29443_() && this.flightTicks > 40 && this.m_20096_()) {
                this.setFlying(false);
            }
        }
    }

    public void tickRotation(float yMov) {
        this.flightPitch = yMov;
        float threshold = 1.0f;
        boolean flag = false;
        if (this.m_29443_() && this.f_19859_ - this.m_146908_() > threshold) {
            this.flightRoll += 10.0f;
            flag = true;
        }
        if (this.m_29443_() && this.f_19859_ - this.m_146908_() < -threshold) {
            this.flightRoll -= 10.0f;
            flag = true;
        }
        if (!flag) {
            if (this.flightRoll > 0.0f) {
                this.flightRoll = Math.max(this.flightRoll - 5.0f, 0.0f);
            }
            if (this.flightRoll < 0.0f) {
                this.flightRoll = Math.min(this.flightRoll + 5.0f, 0.0f);
            }
        }
        this.flightRoll = Mth.m_14036_((float)this.flightRoll, (float)-60.0f, (float)60.0f);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(FLYING, (Object)false);
    }

    public boolean m_29443_() {
        return (Boolean)this.f_19804_.m_135370_(FLYING);
    }

    public void setFlying(boolean flying) {
        this.f_19804_.m_135381_(FLYING, (Object)flying);
    }

    public float getFlightPitch(float partialTick) {
        return this.prevFlightPitch + (this.flightPitch - this.prevFlightPitch) * partialTick;
    }

    public float getFlightRoll(float partialTick) {
        return this.prevFlightRoll + (this.flightRoll - this.prevFlightRoll) * partialTick;
    }

    public float getFlyProgress(float partialTick) {
        return (this.prevFlyProgress + (this.flyProgress - this.prevFlyProgress) * partialTick) * 0.2f;
    }
}


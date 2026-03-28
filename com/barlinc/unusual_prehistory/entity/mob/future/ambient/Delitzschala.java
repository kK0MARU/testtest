/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.FlyingMoveControl
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.util.AirAndWaterRandomPos
 *  net.minecraft.world.entity.ai.util.HoverRandomPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.future.ambient;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinFlyingPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.AmbientMob;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class Delitzschala
extends AmbientMob {
    public final SmoothAnimationState idleAnimationState = new SmoothAnimationState(1.0f);
    public final SmoothAnimationState flyAnimationState = new SmoothAnimationState(1.0f);

    public Delitzschala(EntityType<? extends AmbientMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new FlyingMoveControl((Mob)this, 20, false);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 1.0).m_22268_(Attributes.f_22279_, (double)0.01f).m_22268_(Attributes.f_22280_, (double)0.7f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new DelitzschalaWanderAroundGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new DelitzschalaLookAroundGoal(this));
    }

    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        NoSpinFlyingPathNavigation flyingPathNavigation = new NoSpinFlyingPathNavigation((Mob)this, level){

            public boolean m_6342_(BlockPos blockPos) {
                return !Delitzschala.this.m_9236_().m_8055_(blockPos.m_7495_()).m_60795_();
            }
        };
        flyingPathNavigation.m_26440_(false);
        flyingPathNavigation.m_7008_(false);
        flyingPathNavigation.m_26443_(true);
        return flyingPathNavigation;
    }

    public float m_5610_(@NotNull BlockPos blockPos, LevelReader levelReader) {
        return levelReader.m_8055_(blockPos).m_60795_() ? 10.0f : 0.0f;
    }

    @NotNull
    public MobType m_6336_() {
        return MobType.f_21642_;
    }

    public void m_142687_(@NotNull Entity.RemovalReason removalReason) {
        UnusualPrehistory2.PROXY.clearSoundCacheFor((Entity)this);
        super.m_142687_(removalReason);
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (!this.m_20096_() && this.m_20184_().f_82480_ < 0.0) {
            this.m_20256_(this.m_20184_().m_82542_(1.0, 0.6, 1.0));
        }
        if (this.m_9236_().f_46443_ && this.m_6084_()) {
            UnusualPrehistory2.PROXY.playWorldSound((Object)this, (byte)3);
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(this.m_20096_(), this.f_19797_);
        this.flyAnimationState.m_246184_(!this.m_20096_(), this.f_19797_);
    }

    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.BUG_HURT.get();
    }

    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.BUG_DEATH.get();
    }

    private static class DelitzschalaWanderAroundGoal
    extends Goal {
        private final Delitzschala delitzschala;

        public DelitzschalaWanderAroundGoal(Delitzschala delitzschala) {
            this.delitzschala = delitzschala;
            this.m_7021_(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean m_8036_() {
            return this.delitzschala.f_21344_.m_26571_() && this.delitzschala.f_19796_.m_188503_(10) == 0;
        }

        public boolean m_8045_() {
            return this.delitzschala.f_21344_.m_26572_();
        }

        public void m_8056_() {
            Vec3 vec3d = this.getRandomLocation();
            if (vec3d != null) {
                this.delitzschala.f_21344_.m_26536_(this.delitzschala.f_21344_.m_7864_(BlockPos.m_274446_((Position)vec3d), 1), 1.0);
            }
        }

        @Nullable
        private Vec3 getRandomLocation() {
            Vec3 vec3d2 = this.delitzschala.m_20252_(0.0f);
            Vec3 vec3d3 = HoverRandomPos.m_148465_((PathfinderMob)this.delitzschala, (int)10, (int)3, (double)vec3d2.f_82479_, (double)vec3d2.f_82481_, (float)1.5707964f, (int)3, (int)1);
            return vec3d3 != null ? vec3d3 : AirAndWaterRandomPos.m_148357_((PathfinderMob)this.delitzschala, (int)10, (int)2, (int)-2, (double)vec3d2.f_82479_, (double)vec3d2.f_82481_, (double)1.5707963705062866);
        }
    }

    private class DelitzschalaLookAroundGoal
    extends RandomLookAroundGoal {
        private final Delitzschala delitzschala;

        public DelitzschalaLookAroundGoal(Delitzschala delitzschala2) {
            super((Mob)Delitzschala.this);
            this.delitzschala = delitzschala2;
        }

        public boolean m_8036_() {
            return this.delitzschala.m_20096_() && super.m_8036_();
        }

        public boolean m_8045_() {
            return this.delitzschala.m_20096_() && super.m_8045_();
        }
    }
}


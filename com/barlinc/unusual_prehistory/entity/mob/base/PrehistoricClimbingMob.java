/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Vec3i
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.control.LookControl
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.navigation.WallClimberNavigation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.base;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public abstract class PrehistoricClimbingMob
extends PrehistoricMob {
    private static final EntityDataAccessor<Boolean> CLIMBING = SynchedEntityData.m_135353_(PrehistoricClimbingMob.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Direction> CLIMB_DIRECTION = SynchedEntityData.m_135353_(PrehistoricClimbingMob.class, (EntityDataSerializer)EntityDataSerializers.f_135040_);
    public float climbProgress;
    public float prevClimbProgress;
    public Direction prevClimbDirection = Direction.UP;
    public int climbTicks = 0;
    private int climbCooldown = 0;

    protected PrehistoricClimbingMob(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
        this.f_21365_ = new ClimbingLookControl(this);
    }

    @Override
    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        return new WallClimberNavigation((Mob)this, level);
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        this.tickClimbing();
    }

    public void tickClimbing() {
        if (this.m_9236_().f_46443_) {
            this.prevClimbProgress = this.climbProgress;
            if (this.isClimbing() && this.climbProgress < 5.0f) {
                this.climbProgress += 1.0f;
            }
            if (!this.isClimbing() && this.climbProgress > 0.0f) {
                this.climbProgress -= 1.0f;
            }
        }
        if (this.isClimbing()) {
            boolean onCooldown;
            ++this.climbTicks;
            boolean bl = onCooldown = this.climbTicks >= this.getMaxClimbTicks() || this.m_9236_().m_8055_(this.m_20183_().m_7494_()).m_280296_();
            if (!this.f_19862_ || onCooldown) {
                this.setClimbing(false);
                this.setClimbDirection(Direction.UP);
                this.climbTicks = 0;
                if (onCooldown) {
                    this.climbCooldown = 900;
                }
            } else {
                Pair<Direction, Double> dir = this.getClosestSide(this.m_20191_(), this.m_20183_());
                this.setClimbDirection((Direction)dir.getFirst());
                if (this.m_20184_().m_165924_() < (double)1.0E-5f) {
                    this.m_146922_(((Direction)dir.getFirst()).m_122435_());
                }
            }
        } else {
            --this.climbCooldown;
            if (this.canClimb()) {
                this.climbTicks = 0;
                this.setClimbing(true);
            }
        }
    }

    protected boolean canClimb() {
        return this.climbCooldown <= 0 && this.f_19862_ && !this.isEepy() && !this.isSitting();
    }

    public float getClimbProgress(float partialTicks) {
        return (this.prevClimbProgress + (this.climbProgress - this.prevClimbProgress) * partialTicks) * 0.2f;
    }

    public int getMaxClimbTicks() {
        return 100;
    }

    public Pair<Direction, Double> getClosestSide(AABB bounding, BlockPos blockPos) {
        AABB aabb = bounding.m_82383_(Vec3.m_82539_((Vec3i)blockPos).m_82490_(-1.0));
        double maxX = Math.abs(Math.abs(aabb.f_82291_) - 0.5);
        double minZ = Math.abs(Math.abs(aabb.f_82290_) - 0.5);
        double maxZ = Math.abs(Math.abs(aabb.f_82293_) - 0.5);
        double smallest = Math.abs(Math.abs(aabb.f_82288_) - 0.5);
        Direction dir = Direction.WEST;
        if (maxX < smallest) {
            smallest = maxX;
            dir = Direction.EAST;
        }
        if (minZ < smallest) {
            smallest = minZ;
            dir = Direction.NORTH;
        }
        if (maxZ < smallest) {
            smallest = maxZ;
            dir = Direction.SOUTH;
        }
        return Pair.of((Object)dir, (Object)smallest);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(CLIMBING, (Object)false);
        this.f_19804_.m_135372_(CLIMB_DIRECTION, (Object)Direction.UP);
    }

    public boolean isClimbing() {
        return (Boolean)this.f_19804_.m_135370_(CLIMBING);
    }

    public void setClimbing(boolean climbing) {
        this.f_19804_.m_135381_(CLIMBING, (Object)climbing);
    }

    public Direction getClimbDirection() {
        return (Direction)this.f_19804_.m_135370_(CLIMB_DIRECTION);
    }

    public void setClimbDirection(Direction direction) {
        this.f_19804_.m_135381_(CLIMB_DIRECTION, (Object)direction);
    }

    public boolean m_6147_() {
        return this.isClimbing();
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (this.m_9236_().f_46443_ && CLIMB_DIRECTION.equals(accessor) && this.f_19804_.m_135370_(CLIMB_DIRECTION) != Direction.UP) {
            this.prevClimbDirection = (Direction)this.f_19804_.m_135370_(CLIMB_DIRECTION);
        }
        super.m_7350_(accessor);
    }

    protected static class ClimbingLookControl
    extends LookControl {
        protected final PrehistoricClimbingMob f_24937_;

        public ClimbingLookControl(PrehistoricClimbingMob mob) {
            super((Mob)mob);
            this.f_24937_ = mob;
        }

        public void m_8128_() {
            if (!this.f_24937_.refuseToMove() && !this.f_24937_.isClimbing()) {
                super.m_8128_();
            }
        }
    }
}


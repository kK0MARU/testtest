/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.future;

import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricFlyingLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricFlyingMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinFlyingPathNavigation;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricFlyingMob;
import com.barlinc.unusual_prehistory.entity.utils.GrabbingMob;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class Dimorphodon
extends PrehistoricFlyingMob
implements GrabbingMob {
    private static final EntityDataAccessor<Integer> HELD_MOB_ID = SynchedEntityData.m_135353_(Dimorphodon.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    public int grabCooldown = 0;
    private int runTicks = 0;
    public final SmoothAnimationState grabAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState nip1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState nip2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState tailChaseAnimationState = new SmoothAnimationState();
    private int nipCooldown = 900 + this.m_217043_().m_188503_(900);
    private int tailChaseCooldown = 1300 + this.m_217043_().m_188503_(1300);

    public Dimorphodon(EntityType<? extends PrehistoricFlyingMob> entityType, Level level) {
        super(entityType, level);
        this.switchNavigator(false);
        this.m_21441_(BlockPathTypes.LEAVES, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22280_, 1.0).m_22268_(Attributes.f_22279_, (double)0.17f);
    }

    @Override
    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.f_21365_ = new PrehistoricLookControl(this);
            this.f_21342_ = new PrehistoricMoveControl(this);
            this.f_21344_ = new NoSpinGroundPathNavigation((Mob)this, this.m_9236_());
            this.isLandNavigator = true;
        } else {
            this.f_21365_ = new PrehistoricFlyingLookControl((Mob)this, 85);
            this.f_21342_ = new PrehistoricFlyingMoveControl(this);
            this.f_21344_ = new NoSpinFlyingPathNavigation((Mob)this, this.m_9236_());
            this.isLandNavigator = false;
        }
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if ((this.refuseToMove() || this.isDancing()) && this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        super.m_7023_(travelVec);
    }

    public boolean m_6469_(@NotNull DamageSource source, float amount) {
        boolean hurt = super.m_6469_(source, amount);
        if (hurt && this.getHeldMobId() != -1) {
            this.setHeldMobId(-1);
            if (this.m_5448_() != null) {
                this.m_6710_(null);
            }
        }
        if (hurt && source.m_7639_() != null && this.m_6084_() && this.m_21223_() < this.m_21233_() * 0.5f) {
            this.setFlying(true);
            this.setRunning(true);
            this.runTicks = this.getFastFlyingTicks();
        }
        return hurt;
    }

    @Override
    public boolean canDanceToJukebox() {
        return !this.m_29443_();
    }

    private void positionHeldMob() {
        Entity entity = this.m_9236_().m_6815_(this.getHeldMobId());
        if (entity != null) {
            Vec3 heldPos = this.m_20182_().m_82520_(0.0, -2.0, 0.0);
            Vec3 minus = new Vec3(heldPos.f_82479_ - entity.m_20185_(), heldPos.f_82480_ - entity.m_20186_(), heldPos.f_82481_ - entity.m_20189_());
            entity.m_20256_(minus);
        }
    }

    public boolean canPickUpTarget(LivingEntity target) {
        if (target == null) {
            return false;
        }
        if (target.m_6095_().m_204039_(UP2EntityTags.DIMORPHODON_CANT_GRAB)) {
            return false;
        }
        return target.m_20205_() < this.m_20205_() && target.m_20206_() < this.m_20206_() || target.m_6095_().m_204039_(UP2EntityTags.DIMORPHODON_CAN_GRAB) || target instanceof Player;
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (this.getHeldMobId() != -1) {
            this.positionHeldMob();
        }
        if (!this.m_9236_().f_46443_) {
            if (this.m_29443_()) {
                if (this.runTicks > 0) {
                    --this.runTicks;
                }
                if (this.isRunning() && this.runTicks == 0) {
                    this.setRunning(false);
                }
            }
            if (this.grabCooldown > 0) {
                --this.grabCooldown;
            }
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.m_29443_() && !this.isDancing()) {
            if (this.nipCooldown > 0) {
                --this.nipCooldown;
            }
            if (this.tailChaseCooldown > 0) {
                --this.tailChaseCooldown;
            }
        }
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 2;
    }

    public int getFastFlyingTicks() {
        return 80 + this.m_217043_().m_188503_(60);
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.isDancing() && !this.m_29443_() && this.getIdleState() != 2, this.f_19797_);
        this.flyAnimationState.m_246184_(this.m_29443_() && !this.isRunning() && this.getAttackState() != 1, this.f_19797_);
        this.flyFastAnimationState.m_246184_(this.m_29443_() && this.isRunning() && this.getAttackState() != 1, this.f_19797_);
        this.hoverAnimationState.m_246184_(this.m_29443_() && this.getAttackState() != 1, this.f_19797_);
        this.danceAnimationState.m_246184_(this.isDancing(), this.f_19797_);
        this.grabAnimationState.m_246184_(this.getAttackState() == 1, this.f_19797_);
        this.nip1AnimationState.m_246184_(this.nip1AnimationState.m_216984_(), this.f_19797_);
        this.nip2AnimationState.m_246184_(this.nip2AnimationState.m_216984_(), this.f_19797_);
        this.tailChaseAnimationState.m_246184_(this.tailChaseAnimationState.m_216984_(), this.f_19797_);
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        super.m_7350_(accessor);
    }

    @Override
    public void m_7822_(byte id) {
        switch (id) {
            case 67: {
                if (this.m_217043_().m_188499_()) {
                    this.nip1AnimationState.m_216977_(this.f_19797_);
                    break;
                }
                this.nip2AnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 68: {
                this.nip1AnimationState.m_216973_();
                this.nip2AnimationState.m_216973_();
                break;
            }
            case 69: {
                this.tailChaseAnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 70: {
                this.tailChaseAnimationState.m_216973_();
                break;
            }
            default: {
                super.m_7822_(id);
            }
        }
    }

    protected void nipCooldown() {
        this.nipCooldown = 900 + this.m_217043_().m_188503_(900);
    }

    protected void tailChaseCooldown() {
        this.tailChaseCooldown = 1300 + this.m_217043_().m_188503_(1300);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.DIMORPHODON_FOOD);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(HELD_MOB_ID, (Object)-1);
    }

    @Override
    public void setHeldMobId(int id) {
        this.f_19804_.m_135381_(HELD_MOB_ID, (Object)id);
    }

    @Override
    public int getHeldMobId() {
        return (Integer)this.f_19804_.m_135370_(HELD_MOB_ID);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.DIMORPHODON_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.DIMORPHODON_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.DIMORPHODON_DEATH.get();
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.DIMORPHODON.get()).m_20615_((Level)serverLevel);
    }

    @NotNull
    public AABB m_6921_() {
        return this.m_20191_().m_82377_(3.0, 3.0, 3.0);
    }

    public boolean m_6783_(double distance) {
        return Math.sqrt(distance) < 1024.0;
    }

    public static boolean canSpawn(EntityType<Dimorphodon> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.DIMORPHODON_SPAWNABLE_ON) && Dimorphodon.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class DimorphodonTailChaseGoal
    extends IdleAnimationGoal {
        private final Dimorphodon dimorphodon;

        public DimorphodonTailChaseGoal(Dimorphodon dimorphodon) {
            super(dimorphodon, 60, 2);
            this.dimorphodon = dimorphodon;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.dimorphodon.tailChaseCooldown == 0 && !this.dimorphodon.m_29443_() && !this.dimorphodon.m_6162_();
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && !this.dimorphodon.m_29443_();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.dimorphodon.tailChaseCooldown();
        }
    }

    private static class DimorphodonNipGoal
    extends IdleAnimationGoal {
        private final Dimorphodon dimorphodon;

        public DimorphodonNipGoal(Dimorphodon dimorphodon) {
            super(dimorphodon, 20, 1, false);
            this.dimorphodon = dimorphodon;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.dimorphodon.nipCooldown == 0 && !this.dimorphodon.m_29443_() && !this.dimorphodon.m_6162_();
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && !this.dimorphodon.m_29443_();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.dimorphodon.nipCooldown();
        }
    }

    private static class DimorphodonGrabGoal
    extends AttackGoal {
        private final Dimorphodon dimorphodon;

        public DimorphodonGrabGoal(Dimorphodon dimorphodon) {
            super(dimorphodon);
            this.dimorphodon = dimorphodon;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.dimorphodon.grabCooldown == 0 && this.dimorphodon.canPickUpTarget(this.dimorphodon.m_5448_());
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && this.dimorphodon.grabCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.dimorphodon.m_6710_(null);
            this.dimorphodon.grabCooldown = 100 + this.dimorphodon.m_217043_().m_188503_(100);
            if (!this.dimorphodon.m_20096_()) {
                this.dimorphodon.setFlying(true);
            }
        }

        public void m_8037_() {
            LivingEntity target = this.dimorphodon.m_5448_();
            if (target != null) {
                double distance = this.dimorphodon.m_20280_((Entity)target);
                if (this.dimorphodon.getAttackState() == 1) {
                    this.tickGrab();
                } else if (distance <= this.getAttackReachSqr(target) && this.dimorphodon.canPickUpTarget(target) && this.dimorphodon.grabCooldown == 0) {
                    this.dimorphodon.setAttackState(1);
                } else {
                    this.dimorphodon.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
                    this.dimorphodon.m_21573_().m_5624_((Entity)target, 2.0);
                }
            }
        }

        protected void tickGrab() {
            ++this.timer;
            this.dimorphodon.m_21573_().m_26573_();
            LivingEntity target = this.dimorphodon.m_5448_();
            if (this.timer == 1 && this.isInAttackRange(target, 1.5)) {
                this.dimorphodon.setHeldMobId(target.m_19879_());
            }
            if (this.timer > 1 && this.dimorphodon.getHeldMobId() != -1) {
                this.dimorphodon.setFlying(true);
                this.dimorphodon.m_20334_(this.dimorphodon.m_20184_().f_82479_, 0.18, this.dimorphodon.m_20184_().f_82481_);
            }
            if (this.timer > 80 || this.timer > 2 && this.dimorphodon.getHeldMobId() == -1) {
                this.m_8041_();
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_3;

import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.goals.AquaticLeapGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.CustomizableRandomSwimGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.EnterWaterGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargeBabyPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SemiAquaticRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_3.MetriorhynchusAttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.ai.navigation.UP2SemiAquaticPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import com.barlinc.unusual_prehistory.entity.utils.GrabbingMob;
import com.barlinc.unusual_prehistory.entity.utils.LeapingMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Metriorhynchus
extends SemiAquaticMob
implements LeapingMob,
GrabbingMob {
    private static final EntityDataAccessor<Integer> HELD_MOB_ID = SynchedEntityData.m_135353_(Metriorhynchus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Boolean> LEAPING = SynchedEntityData.m_135353_(Metriorhynchus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public int grabCooldown = 0;
    public int attackCooldown = 0;
    public final SmoothAnimationState swimIdleAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState grab1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState grab2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState bellowAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState angryAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState leapAnimationState = new SmoothAnimationState();
    public boolean grabAlt = false;
    public boolean attackAlt = false;
    public int bellowCooldown = 2000 + this.m_217043_().m_188503_(2000);

    public Metriorhynchus(EntityType<? extends SemiAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.switchNavigator(true);
        this.m_21441_(BlockPathTypes.WATER, 0.0f);
        this.m_21441_(BlockPathTypes.WATER_BORDER, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22279_, (double)0.15f).m_22268_(Attributes.f_22281_, 7.0);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new LargeBabyPanicGoal(this, 2.0, 10, 4));
        this.f_21345_.m_25352_(1, (Goal)new AquaticLeapGoal(this, 10, 0.9, 0.7));
        this.f_21345_.m_25352_(2, (Goal)new MetriorhynchusAttackGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.METRIORHYNCHUS_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new CustomizableRandomSwimGoal((PathfinderMob)this, 1.0, 20, 3));
        this.f_21345_.m_25352_(4, (Goal)new SemiAquaticRandomStrollGoal(this, 1.0));
        this.f_21345_.m_25352_(5, (Goal)new EnterWaterGoal(this, 1.0, 400));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(7, (Goal)new MetriorhynchusBellowGoal(this));
        this.f_21346_.m_25352_(0, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(1, new PrehistoricNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 300, true, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.METRIORHYNCHUS_TARGETS)));
        this.f_21346_.m_25352_(2, new PrehistoricNearestAttackableTargetGoal<Player>(this, Player.class, 300, true, true, arg_0 -> ((Metriorhynchus)this).m_6779_(arg_0)));
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions size) {
        return size.f_20378_ * 0.5f;
    }

    protected void switchNavigator(boolean onLand) {
        if (onLand) {
            this.f_21342_ = new PrehistoricMoveControl(this);
            this.f_21365_ = new MetriorhynchusLookControl(this);
            this.f_21344_ = new NoSpinGroundPathNavigation((Mob)this, this.m_9236_());
            this.isLandNavigator = true;
        } else {
            this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 85, 10, 0.98f, 0.1f, false);
            this.f_21365_ = new SmoothSwimmingLookControl((Mob)this, 20);
            this.f_21344_ = new UP2SemiAquaticPathNavigation((Mob)this, this.m_9236_());
            this.isLandNavigator = false;
        }
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.refuseToMove() && this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        if (this.m_21515_() && this.m_20069_()) {
            this.m_19920_(this.m_6113_(), travelVec);
            this.m_6478_(MoverType.SELF, this.m_20184_());
            this.m_20256_(this.m_20184_().m_82490_(0.9));
            if (this.f_19862_ && this.m_204029_(FluidTags.f_13131_) && this.m_21691_()) {
                this.m_20256_(this.m_20184_().m_82520_(0.0, 0.005, 0.0));
            }
        } else {
            super.m_7023_(travelVec);
        }
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.METRIORHYNCHUS_FOOD);
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_METRIORHYNCHUS);
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    public boolean m_6914_(LevelReader level) {
        return level.m_45784_((Entity)this);
    }

    public boolean canPickUpTarget(LivingEntity target) {
        if (target == null) {
            return false;
        }
        if (target.m_6095_().m_204039_(UP2EntityTags.METRIORHYNCHUS_CANT_GRAB)) {
            return false;
        }
        return target.m_20205_() < this.m_20205_() && target.m_20206_() < this.m_20206_() || target.m_6095_().m_204039_(UP2EntityTags.METRIORHYNCHUS_CAN_GRAB);
    }

    @Override
    public void m_8119_() {
        boolean ground;
        super.m_8119_();
        boolean bl = ground = !this.m_20072_();
        if (!ground && this.isLandNavigator) {
            this.switchNavigator(false);
        }
        if (ground && !this.isLandNavigator) {
            this.switchNavigator(true);
        }
        if (!this.m_9236_().f_46443_) {
            if (this.grabCooldown > 0) {
                --this.grabCooldown;
            }
            if (this.attackCooldown > 0) {
                --this.attackCooldown;
            }
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.m_9236_().f_46443_ && this.m_5448_() == null && this.bellowCooldown > 0) {
            --this.bellowCooldown;
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.m_20072_(), this.f_19797_);
        this.swimIdleAnimationState.m_246184_(this.m_20072_() && this.m_20089_() != UP2Poses.GRABBING.get(), this.f_19797_);
        this.bellowAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.attack1AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && !this.attackAlt, this.f_19797_);
        this.attack2AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && this.attackAlt, this.f_19797_);
        this.grab1AnimationState.m_246184_(this.m_20089_() == UP2Poses.GRABBING.get() && !this.grabAlt, this.f_19797_);
        this.grab2AnimationState.m_246184_(this.m_20089_() == UP2Poses.GRABBING.get() && this.grabAlt, this.f_19797_);
        this.angryAnimationState.m_246184_(this.m_5912_() && this.m_20089_() != UP2Poses.GRABBING.get() && this.m_20089_() != UP2Poses.ATTACKING.get(), this.f_19797_);
        this.leapAnimationState.m_246184_(this.isLeaping() && this.m_20089_() != UP2Poses.GRABBING.get(), this.f_19797_);
    }

    protected void bellowCooldown() {
        this.bellowCooldown = 2000 + this.m_217043_().m_188503_(2000);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(HELD_MOB_ID, (Object)-1);
        this.f_19804_.m_135372_(LEAPING, (Object)false);
    }

    @Override
    public void setHeldMobId(int id) {
        this.f_19804_.m_135381_(HELD_MOB_ID, (Object)id);
    }

    @Override
    public int getHeldMobId() {
        return (Integer)this.f_19804_.m_135370_(HELD_MOB_ID);
    }

    @Override
    public void setLeaping(boolean leaping) {
        this.f_19804_.m_135381_(LEAPING, (Object)leaping);
    }

    @Override
    public boolean isLeaping() {
        return (Boolean)this.f_19804_.m_135370_(LEAPING);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.METRIORHYNCHUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.METRIORHYNCHUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.METRIORHYNCHUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_(SoundEvents.f_215696_, 0.3f, 0.9f);
    }

    public int m_8100_() {
        return 200;
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.METRIORHYNCHUS.get()).m_20615_((Level)level);
    }

    public static boolean canSpawn(EntityType<Metriorhynchus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        int i = level.m_5736_();
        int j = i - 13;
        return pos.m_123342_() >= j && pos.m_123342_() <= i && level.m_6425_(pos.m_7495_()).m_205070_(FluidTags.f_13131_) && level.m_8055_(pos.m_7494_()).m_60713_(Blocks.f_49990_);
    }

    @Override
    public boolean m_8023_() {
        return this.getSpawnType() != MobSpawnType.CHUNK_GENERATION && this.getSpawnType() != MobSpawnType.NATURAL || this.isFromEgg();
    }

    @Override
    public boolean m_6785_(double distanceToPlayer) {
        return !this.m_8023_();
    }

    private static class MetriorhynchusBellowGoal
    extends IdleAnimationGoal {
        private final Metriorhynchus metriorhynchus;

        public MetriorhynchusBellowGoal(Metriorhynchus metriorhynchus) {
            super(metriorhynchus, 40, 1, false, false);
            this.metriorhynchus = metriorhynchus;
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            this.metriorhynchus.m_5496_((SoundEvent)UP2SoundEvents.METRIORHYNCHUS_BELLOW.get(), 1.5f, 1.0f);
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.metriorhynchus.bellowCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.metriorhynchus.bellowCooldown();
        }
    }

    private static class MetriorhynchusLookControl
    extends PrehistoricLookControl {
        private final Metriorhynchus metriorhynchus;

        public MetriorhynchusLookControl(Metriorhynchus metriorhynchus) {
            super(metriorhynchus);
            this.metriorhynchus = metriorhynchus;
        }

        protected boolean m_8106_() {
            return !this.metriorhynchus.isLeaping();
        }
    }
}


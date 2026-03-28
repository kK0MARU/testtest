/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
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
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_4;

import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.goals.CustomizableRandomSwimGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.EnterWaterGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargeBabyPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LeaveWaterGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricFollowOwnerGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricOwnerHurtByTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricOwnerHurtTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricSitWhenOrderedToGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SemiAquaticRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_4.KaprosuchusAttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.UP2SemiAquaticPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import com.barlinc.unusual_prehistory.entity.utils.LeapingMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
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
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Kaprosuchus
extends SemiAquaticMob
implements LeapingMob {
    private static final EntityDataAccessor<Integer> TAME_ATTEMPTS = SynchedEntityData.m_135353_(Kaprosuchus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Boolean> LEAPING = SynchedEntityData.m_135353_(Kaprosuchus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public int leapCooldown = 70 + this.m_217043_().m_188503_(80);
    public int attackCooldown = 0;
    public final SmoothAnimationState swimIdleAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState leapAnimationState = new SmoothAnimationState();
    public boolean attackAlt = false;

    public Kaprosuchus(EntityType<? extends SemiAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.switchNavigator(true);
        this.m_21441_(BlockPathTypes.WATER, 0.0f);
        this.m_21441_(BlockPathTypes.WATER_BORDER, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 20.0).m_22268_(Attributes.f_22279_, (double)0.2f).m_22268_(Attributes.f_22284_, 4.0).m_22268_(Attributes.f_22281_, 6.0);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new PrehistoricSitWhenOrderedToGoal(this));
        this.f_21345_.m_25352_(1, (Goal)new LargeBabyPanicGoal(this, 1.8, 10, 4));
        this.f_21345_.m_25352_(2, (Goal)new KaprosuchusAttackGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new PrehistoricFollowOwnerGoal(this, 1.2, 5.0f, 2.0f, false));
        this.f_21345_.m_25352_(4, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.KAPROSUCHUS_FOOD), false));
        this.f_21345_.m_25352_(5, (Goal)new CustomizableRandomSwimGoal((PathfinderMob)this, 1.0, 50));
        this.f_21345_.m_25352_(5, (Goal)new SemiAquaticRandomStrollGoal(this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LeaveWaterGoal(this, 1.0, 1200, 1500));
        this.f_21345_.m_25352_(6, (Goal)new EnterWaterGoal(this, 1.0, 1500));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 10.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(8, (Goal)new SleepingGoal(this));
        this.f_21346_.m_25352_(0, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(1, new PrehistoricNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 300, true, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.KAPROSUCHUS_TARGETS)));
        this.f_21346_.m_25352_(2, (Goal)new PrehistoricOwnerHurtByTargetGoal(this));
        this.f_21346_.m_25352_(3, (Goal)new PrehistoricOwnerHurtTargetGoal(this));
    }

    protected void switchNavigator(boolean onLand) {
        if (onLand) {
            this.f_21365_ = new KaprosuchusLookControl(this);
            this.f_21342_ = new PrehistoricMoveControl(this);
            this.f_21344_ = this.m_6037_(this.m_9236_());
            this.isLandNavigator = true;
        } else {
            this.f_21365_ = new SmoothSwimmingLookControl((Mob)this, 20);
            this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 85, 10, 0.4f, 1.0f, false);
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
        } else {
            super.m_7023_(travelVec);
        }
    }

    public float getStepHeight() {
        return this.isRunning() ? 1.0f : 0.6f;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.KAPROSUCHUS_FOOD);
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_KAPROSUCHUS);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove();
    }

    @Override
    public boolean m_142535_(float fallDistance, float multiplier, @NotNull DamageSource damageSource) {
        return false;
    }

    protected void m_7840_(double y, boolean onGround, @NotNull BlockState state, @NotNull BlockPos pos) {
    }

    public void leapCooldown() {
        this.leapCooldown = 70 + this.m_217043_().m_188503_(80);
    }

    @Override
    public boolean canOwnerCommand(Player player) {
        return true;
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        InteractionResult type = super.m_6071_(player, hand);
        if (!this.m_21824_() && itemstack.m_204117_(UP2ItemTags.TAMES_KAPROSUCHUS)) {
            this.m_146850_(GameEvent.f_223708_);
            if (!this.m_9236_().f_46443_) {
                if (!player.m_150110_().f_35937_) {
                    itemstack.m_41774_(1);
                }
                if (this.getTameAttempts() > 2 && this.m_217043_().m_188499_()) {
                    this.m_9236_().m_7605_((Entity)this, (byte)7);
                    this.m_21828_(player);
                    this.setPacifiedTicks(-1);
                    this.m_5634_(this.m_21233_());
                } else {
                    this.m_9236_().m_7605_((Entity)this, (byte)6);
                    this.setTameAttempts(this.getTameAttempts() + 1);
                }
            }
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        return type;
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
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.m_20069_() && !this.isLeaping() && !this.isSitting() && !this.isEepy(), this.f_19797_);
        this.swimIdleAnimationState.m_246184_(this.m_20069_(), this.f_19797_);
        this.leapAnimationState.m_246184_(this.isLeaping(), this.f_19797_);
        this.sitAnimationState.m_246184_(this.isSitting(), this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
        this.attack1AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && !this.attackAlt, this.f_19797_);
        this.attack2AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && this.attackAlt, this.f_19797_);
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.leapCooldown > 0) {
            --this.leapCooldown;
        }
        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(TAME_ATTEMPTS, (Object)0);
        this.f_19804_.m_135372_(LEAPING, (Object)false);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("TameAttempts", this.getTameAttempts());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setTameAttempts(compoundTag.m_128451_("TameAttempts"));
    }

    public void setTameAttempts(int tameAttempts) {
        this.f_19804_.m_135381_(TAME_ATTEMPTS, (Object)tameAttempts);
    }

    public int getTameAttempts() {
        return (Integer)this.f_19804_.m_135370_(TAME_ATTEMPTS);
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
        return (SoundEvent)UP2SoundEvents.KAPROSUCHUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.KAPROSUCHUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.KAPROSUCHUS_DEATH.get();
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.KAPROSUCHUS.get()).m_20615_((Level)level);
    }

    public static boolean canSpawn(EntityType<Kaprosuchus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.KAPROSUCHUS_SPAWNABLE_ON) && Kaprosuchus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class KaprosuchusLookControl
    extends PrehistoricLookControl {
        private final Kaprosuchus kaprosuchus;

        public KaprosuchusLookControl(Kaprosuchus kaprosuchus) {
            super(kaprosuchus);
            this.kaprosuchus = kaprosuchus;
        }

        protected boolean m_8106_() {
            return !this.kaprosuchus.isLeaping();
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
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
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.animal.Bucketable
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
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
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LeaveWaterGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.RandomSitGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SemiAquaticRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_4.PraepusaAttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.ai.navigation.UP2SemiAquaticPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Praepusa
extends SemiAquaticMob
implements Bucketable {
    private static final EntityDataAccessor<Integer> MITOSIS_COOLDOWN = SynchedEntityData.m_135353_(Praepusa.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.m_135353_(Praepusa.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private boolean prevOnGround = false;
    private Vec3 prevVelocity = Vec3.f_82478_;
    public int attackCooldown = 0;
    public final SmoothAnimationState swimIdleAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState slap1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState slap2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState loafAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState applauseAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState mitosisAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attackAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState bounceAnimationState = new SmoothAnimationState();
    private int mitosisTicks;
    private int bounceTicks = 0;
    private boolean slapAlt = false;
    private int slapCooldown = 300 + this.m_217043_().m_188503_(300);
    private int loafCooldown = 400 + this.m_217043_().m_188503_(400);
    private int applauseCooldown = 900 + this.m_217043_().m_188503_(900);

    public Praepusa(EntityType<? extends SemiAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.switchNavigator(true);
        this.m_21441_(BlockPathTypes.WATER, 0.0f);
        this.m_21441_(BlockPathTypes.WATER_BORDER, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22279_, (double)0.16f).m_22268_(Attributes.f_22281_, 3.0);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new LargePanicGoal(this, 1.6, 10, 4, true));
        this.f_21345_.m_25352_(1, new PrehistoricAvoidEntityGoal<LivingEntity>((PrehistoricMob)this, LivingEntity.class, 8.0f, 1.8, entity -> entity.m_6095_().m_204039_(UP2EntityTags.PRAEPUSA_AVOIDS)));
        this.f_21345_.m_25352_(2, (Goal)new PraepusaAttackGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.PRAEPUSA_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new CustomizableRandomSwimGoal((PathfinderMob)this, 1.0, 50));
        this.f_21345_.m_25352_(4, (Goal)new SemiAquaticRandomStrollGoal(this, 1.0));
        this.f_21345_.m_25352_(5, (Goal)new LeaveWaterGoal(this, 1.0, 1200, 1500));
        this.f_21345_.m_25352_(5, (Goal)new EnterWaterGoal(this, 1.0, 1500));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(7, (Goal)new RandomSitGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new PraepusaSlapGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new PraepusaLoafGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new PraepusaApplauseGoal(this));
        this.f_21346_.m_25352_(0, new PrehistoricNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 500, true, true, this::canHuntFish));
    }

    protected void switchNavigator(boolean onLand) {
        if (onLand) {
            this.f_21342_ = new PrehistoricMoveControl(this);
            this.f_21365_ = new PrehistoricLookControl(this);
            this.f_21344_ = new NoSpinGroundPathNavigation((Mob)this, this.m_9236_());
            this.isLandNavigator = true;
        } else {
            this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 85, 10, 0.4f, 1.0f, false);
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
        } else {
            super.m_7023_(travelVec);
        }
    }

    public float getStepHeight() {
        return this.isRunning() ? 1.0f : 0.6f;
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_PRAEPUSA);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.PRAEPUSA_FOOD);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1 || this.getIdleState() == 2 || this.getIdleState() == 3 || this.m_20089_() == UP2Poses.MITOSIS.get();
    }

    public boolean m_214076_(@NotNull ServerLevel level, @NotNull LivingEntity victim) {
        if (this.getMitosisCooldown() == 0) {
            this.m_20124_(UP2Poses.MITOSIS.get());
        }
        return super.m_214076_(level, victim);
    }

    public boolean canHuntFish(Entity entity) {
        return this.getMitosisCooldown() == 0 && entity.m_6095_().m_204039_(UP2EntityTags.PRAEPUSA_TARGETS);
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
        if (this.getMitosisCooldown() > 0) {
            this.setMitosisCooldown(this.getMitosisCooldown() - 1);
        }
        if (this.m_20089_() == UP2Poses.MITOSIS.get()) {
            this.setMitosisCooldown(2400 + this.m_217043_().m_188503_(1200));
            if (this.mitosisTicks == 7) {
                this.performMitosis();
                this.m_246865_(this.m_20154_().m_82490_(2.0).m_82542_((double)(this.m_9236_().m_213780_().m_188501_() * (this.m_9236_().m_213780_().m_188499_() ? -0.25f : 0.25f)), 0.0, (double)(this.m_9236_().m_213780_().m_188501_() * (this.m_9236_().m_213780_().m_188499_() ? -0.25f : 0.25f))));
                this.m_9236_().m_5594_(null, this.m_20183_(), (SoundEvent)UP2SoundEvents.PRAEPUSA_MITOSIS.get(), SoundSource.NEUTRAL, 1.0f, 0.9f + this.m_217043_().m_188501_() * 0.25f);
            }
        }
        if (!this.m_9236_().f_46443_ && this.m_6084_() && !this.m_20072_()) {
            this.bounce();
        }
        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
    }

    @Override
    public boolean m_142535_(float distance, float multiplier, @NotNull DamageSource source) {
        return false;
    }

    protected void performMitosis() {
        Praepusa praepusa = (Praepusa)((EntityType)UP2Entities.PRAEPUSA.get()).m_20615_(this.m_9236_());
        if (praepusa != null) {
            praepusa.m_20219_(this.m_20182_());
            praepusa.m_21530_();
            praepusa.setMitosisCooldown(2400 + praepusa.m_217043_().m_188503_(1200));
            praepusa.m_246865_(praepusa.m_20154_().m_82490_(2.0).m_82542_((double)(praepusa.m_9236_().m_213780_().m_188501_() * (praepusa.m_9236_().m_213780_().m_188499_() ? -0.25f : 0.25f)), 0.0, (double)(praepusa.m_9236_().m_213780_().m_188501_() * (praepusa.m_9236_().m_213780_().m_188499_() ? -0.25f : 0.25f))));
            this.m_9236_().m_7967_((Entity)praepusa);
        }
    }

    private void bounce() {
        double minBounceVelocity;
        double bounceFactor;
        double impactSpeed;
        double newYVelocity;
        double impactThreshold = 0.1;
        if (this.m_20096_() && !this.prevOnGround && this.prevVelocity.f_82480_ < -impactThreshold && (newYVelocity = (impactSpeed = Math.abs(this.prevVelocity.f_82480_)) * (bounceFactor = 0.7)) > (minBounceVelocity = 0.38)) {
            this.m_20334_(this.m_20184_().f_82479_, newYVelocity, this.m_20184_().f_82481_);
            if (this.bounceTicks == 0) {
                this.m_9236_().m_7605_((Entity)this, (byte)73);
            }
            this.bounceTicks = 10;
            this.m_9236_().m_5594_(null, this.m_20183_(), (SoundEvent)UP2SoundEvents.PRAEPUSA_BOUNCE.get(), SoundSource.NEUTRAL, 0.3f, 0.9f + this.m_217043_().m_188501_() * 0.25f);
            this.m_6853_(false);
            this.f_19812_ = true;
            BlockPos blockBelow = BlockPos.m_274561_((double)this.m_20185_(), (double)(this.m_20186_() - 0.1), (double)this.m_20189_());
            BlockState blockState = this.m_9236_().m_8055_(blockBelow);
            if (!blockState.m_60795_()) {
                ((ServerLevel)this.m_9236_()).m_8767_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, blockState), this.m_20185_(), this.m_20186_() + 0.1, this.m_20189_(), 8, 0.15, 0.05, 0.15, 0.05);
            }
        }
        this.prevVelocity = this.m_20184_();
        this.prevOnGround = this.m_20096_();
    }

    @Override
    public void setupAnimationStates() {
        if (this.mitosisAnimationState.m_216984_() && this.mitosisTicks == 0) {
            this.mitosisAnimationState.m_216973_();
        }
        this.idleAnimationState.m_246184_(!this.m_20072_() && this.getIdleState() != 3 && !this.isSitting(), this.f_19797_);
        this.swimIdleAnimationState.m_246184_(this.m_20072_(), this.f_19797_);
        this.attackAnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get(), this.f_19797_);
        this.sitAnimationState.m_246184_(this.isSitting(), this.f_19797_);
        this.slap1AnimationState.m_246184_(this.getIdleState() == 1 && !this.slapAlt, this.f_19797_);
        this.slap2AnimationState.m_246184_(this.getIdleState() == 1 && this.slapAlt, this.f_19797_);
        this.loafAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
        this.applauseAnimationState.m_246184_(this.getIdleState() == 3, this.f_19797_);
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.mitosisTicks > 0) {
            --this.mitosisTicks;
        }
        if (this.bounceTicks > 0) {
            --this.bounceTicks;
        }
        if (this.mitosisTicks == 0 && this.m_20089_() == UP2Poses.MITOSIS.get()) {
            this.m_20124_(Pose.STANDING);
        }
        if (this.slapCooldown > 0) {
            --this.slapCooldown;
        }
        if (this.loafCooldown > 0) {
            --this.loafCooldown;
        }
        if (this.applauseCooldown > 0) {
            --this.applauseCooldown;
        }
        if (this.bounceTicks == 0) {
            this.m_9236_().m_7605_((Entity)this, (byte)74);
        }
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (f_19806_.equals(accessor)) {
            if (this.m_20089_() == UP2Poses.MITOSIS.get()) {
                this.mitosisAnimationState.m_216977_(this.f_19797_);
                this.mitosisTicks = 40;
            } else if (this.m_20089_() == Pose.STANDING) {
                this.mitosisAnimationState.m_216973_();
            }
        }
        super.m_7350_(accessor);
    }

    @Override
    public void m_7822_(byte id) {
        switch (id) {
            case 73: {
                this.bounceAnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 74: {
                this.bounceAnimationState.m_216973_();
                break;
            }
            default: {
                super.m_7822_(id);
            }
        }
    }

    protected void slapCooldown() {
        this.slapCooldown = 500 + this.m_217043_().m_188503_(500);
    }

    protected void loafCooldown() {
        this.loafCooldown = 700 + this.m_217043_().m_188503_(700);
    }

    protected void applauseCooldown() {
        this.applauseCooldown = 1000 + this.m_217043_().m_188503_(1000);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(MITOSIS_COOLDOWN, (Object)0);
        this.f_19804_.m_135372_(FROM_BUCKET, (Object)false);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("MitosisCooldown", this.getMitosisCooldown());
        compoundTag.m_128379_("FromBucket", this.m_27487_());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setMitosisCooldown(compoundTag.m_128451_("MitosisCooldown"));
        this.m_27497_(compoundTag.m_128471_("FromBucket"));
    }

    public int getMitosisCooldown() {
        return (Integer)this.f_19804_.m_135370_(MITOSIS_COOLDOWN);
    }

    public void setMitosisCooldown(int cooldown) {
        this.f_19804_.m_135381_(MITOSIS_COOLDOWN, (Object)cooldown);
    }

    public boolean m_27487_() {
        return (Boolean)this.f_19804_.m_135370_(FROM_BUCKET);
    }

    public void m_27497_(boolean fromBucket) {
        this.f_19804_.m_135381_(FROM_BUCKET, (Object)fromBucket);
    }

    @NotNull
    public SoundEvent m_142623_() {
        return SoundEvents.f_11782_;
    }

    public void m_6872_(@NotNull ItemStack bucket) {
        if (this.m_8077_()) {
            bucket.m_41714_(this.m_7770_());
        }
        Bucketable.m_148822_((Mob)this, (ItemStack)bucket);
        CompoundTag compoundTag = bucket.m_41784_();
        compoundTag.m_128405_("BucketVariantTag", this.getVariant());
        compoundTag.m_128405_("Age", this.m_146764_());
        compoundTag.m_128405_("MitosisCooldown", this.getMitosisCooldown());
    }

    public void m_142278_(@NotNull CompoundTag compoundTag) {
        Bucketable.m_148825_((Mob)this, (CompoundTag)compoundTag);
        if (compoundTag.m_128425_("BucketVariantTag", 3)) {
            this.setVariant(compoundTag.m_128451_("BucketVariantTag"));
        }
        this.m_146762_(compoundTag.m_128451_("Age"));
        this.setMitosisCooldown(compoundTag.m_128451_("MitosisCooldown"));
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        if (this.m_6898_(itemstack) && !this.m_6162_() && this.getMitosisCooldown() == 0 && this.m_20089_() == Pose.STANDING) {
            this.feedItemToMob(player, hand, itemstack);
            this.m_20124_(UP2Poses.MITOSIS.get());
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        if (itemstack.m_41619_() && this.loafCooldown > 0 && this.getIdleState() == 0 && this.m_21188_() == null && !this.m_20069_()) {
            this.loafCooldown = 0;
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            return InteractionResult.SUCCESS;
        }
        return Bucketable.m_148828_((Player)player, (InteractionHand)hand, (LivingEntity)this).orElse(super.m_6071_(player, hand));
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.PRAEPUSA_BUCKET.get());
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.PRAEPUSA_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.PRAEPUSA_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.PRAEPUSA_DEATH.get();
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.PRAEPUSA.get()).m_20615_((Level)level);
    }

    public static boolean canSpawn(EntityType<Praepusa> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.PRAEPUSA_SPAWNABLE_ON) && Praepusa.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class PraepusaSlapGoal
    extends IdleAnimationGoal {
        private final Praepusa praepusa;

        public PraepusaSlapGoal(Praepusa praepusa) {
            super(praepusa, 40, 1);
            this.praepusa = praepusa;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.praepusa.slapCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.praepusa.slapCooldown();
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            this.praepusa.slapAlt = this.praepusa.m_217043_().m_188499_();
        }
    }

    private static class PraepusaLoafGoal
    extends IdleAnimationGoal {
        private final Praepusa praepusa;

        public PraepusaLoafGoal(Praepusa praepusa) {
            super(praepusa, 80, 2);
            this.praepusa = praepusa;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.praepusa.loafCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.praepusa.loafCooldown();
        }
    }

    private static class PraepusaApplauseGoal
    extends IdleAnimationGoal {
        private final Praepusa praepusa;

        public PraepusaApplauseGoal(Praepusa praepusa) {
            super(praepusa, 60, 3);
            this.praepusa = praepusa;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.praepusa.applauseCooldown == 0 && !this.praepusa.isSitting();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.praepusa.applauseCooldown();
        }
    }
}


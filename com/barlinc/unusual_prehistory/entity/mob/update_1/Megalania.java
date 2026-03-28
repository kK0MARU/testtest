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
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.SpawnGroupData
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
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.MobEffectEvent$Applicable
 *  net.minecraftforge.eventbus.api.Event
 *  net.minecraftforge.eventbus.api.Event$Result
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.goals.CustomizableRandomSwimGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargeBabyPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LeaveWaterGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricFollowOwnerGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricOwnerHurtByTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricOwnerHurtTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricSitWhenOrderedToGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_1.MegalaniaAttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.UP2SemiAquaticPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
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
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Megalania
extends SemiAquaticMob {
    private static final EntityDataAccessor<Integer> TEMPERATURE_STATE = SynchedEntityData.m_135353_(Megalania.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Integer> PREV_TEMPERATURE_STATE = SynchedEntityData.m_135353_(Megalania.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Integer> TAME_ATTEMPTS = SynchedEntityData.m_135353_(Megalania.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    public TemperatureStates localTemperatureState = TemperatureStates.TEMPERATE;
    public float tempProgress = 0.0f;
    public float prevTempProgress = 0.0f;
    @Nullable
    private PrehistoricRandomStrollGoal randomStrollGoal;
    public int attackCooldown = 0;
    public int talWhipCooldown = 150;
    public final SmoothAnimationState tongueAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState roarAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState tailWhipAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState aggroAnimationState = new SmoothAnimationState();
    public boolean attackAlt = false;
    private int tongueCooldown = 100 + this.m_217043_().m_188503_(100);
    private int roarCooldown = 650 + this.m_217043_().m_188503_(4200);

    public Megalania(EntityType<? extends Megalania> entityType, Level level) {
        super(entityType, level);
        this.m_274367_(1.1f);
        this.switchNavigator(true);
        this.m_21441_(BlockPathTypes.WATER, 0.0f);
        this.m_21441_(BlockPathTypes.WATER_BORDER, 0.0f);
    }

    protected void m_8099_() {
        this.randomStrollGoal = new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0, false);
        this.f_21345_.m_25352_(0, (Goal)new PrehistoricSitWhenOrderedToGoal(this));
        this.f_21345_.m_25352_(1, (Goal)new MegalaniaAttackGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new PrehistoricFollowOwnerGoal(this, 1.2, 7.0f, 4.0f, false));
        this.f_21345_.m_25352_(3, (Goal)new LargeBabyPanicGoal(this, 1.6, 10, 4));
        this.f_21345_.m_25352_(4, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.MEGALANIA_FOOD), false));
        this.f_21345_.m_25352_(5, (Goal)new CustomizableRandomSwimGoal((PathfinderMob)this, 1.0, 50, 10, 5));
        this.f_21345_.m_25352_(6, (Goal)this.randomStrollGoal);
        this.f_21345_.m_25352_(7, (Goal)new LeaveWaterGoal(this, 1.0, 600, 2400));
        this.f_21345_.m_25352_(8, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.f_21345_.m_25352_(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(9, (Goal)new SleepingGoal(this));
        this.f_21345_.m_25352_(10, (Goal)new MegalaniaTongueGoal(this));
        this.f_21345_.m_25352_(10, (Goal)new MegalaniaRoarGoal(this));
        this.f_21346_.m_25352_(0, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(1, (Goal)new PrehistoricOwnerHurtByTargetGoal(this));
        this.f_21346_.m_25352_(2, (Goal)new PrehistoricOwnerHurtTargetGoal(this));
        this.f_21346_.m_25352_(3, new PrehistoricNearestAttackableTargetGoal<Player>(this, Player.class, 200, true, false, this::isHostileToPlayers));
        this.f_21346_.m_25352_(4, new MegalaniaTargetGoal<LivingEntity>(this, LivingEntity.class));
        this.f_21346_.m_25352_(5, new PrehistoricNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 100, true, true, this::isHostileToEverything));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 38.0).m_22268_(Attributes.f_22281_, 6.0).m_22268_(Attributes.f_22279_, (double)0.16f).m_22268_(Attributes.f_22277_, 32.0).m_22268_(Attributes.f_22278_, 0.5);
    }

    protected void switchNavigator(boolean onLand) {
        if (onLand) {
            this.f_21342_ = new PrehistoricMoveControl(this);
            this.f_21365_ = new PrehistoricLookControl(this);
            this.f_21344_ = this.m_6037_(this.m_9236_());
            this.isLandNavigator = true;
        } else {
            this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 85, 10, 0.6f, 0.1f, false);
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
        if (this.m_20069_()) {
            this.m_19920_(this.m_6113_(), travelVec);
            this.m_6478_(MoverType.SELF, this.m_20184_());
            if (this.f_19862_ && this.m_204029_(FluidTags.f_13131_) && this.m_21691_()) {
                this.m_20256_(this.m_20184_().m_82520_(0.0, 0.005, 0.0));
            }
            this.m_20256_(this.m_20184_().m_82490_(0.9));
            this.m_267651_(false);
        } else {
            super.m_7023_(travelVec);
        }
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        InteractionResult type = super.m_6071_(player, hand);
        if (!this.m_21824_() && itemstack.m_204117_(UP2ItemTags.TAMES_MEGALANIA)) {
            this.m_146850_(GameEvent.f_223708_);
            if (!this.m_9236_().f_46443_) {
                if (!player.m_150110_().f_35937_) {
                    itemstack.m_41774_(1);
                }
                if (this.getTameAttempts() > 4 && this.m_217043_().m_188499_()) {
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

    public boolean isHostileToPlayers(LivingEntity entity) {
        return this.m_6779_(entity) && (this.getTemperatureState() == TemperatureStates.WARM || this.getTemperatureState() == TemperatureStates.NETHER);
    }

    public boolean isHostileToEverything(LivingEntity entity) {
        return this.m_6779_(entity) && this.getTemperatureState() == TemperatureStates.NETHER;
    }

    private int getHuntingInterval() {
        switch (this.getTemperatureState()) {
            case COLD: {
                return 500;
            }
            case WARM: {
                return 200;
            }
            case NETHER: {
                return 100;
            }
        }
        return 300;
    }

    @Override
    public Vec3 getEepyParticleVec() {
        return new Vec3((double)-0.8f, 0.0, (double)(-this.m_20205_() * 1.2f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    public boolean m_214076_(@NotNull ServerLevel level, @NotNull LivingEntity victim) {
        this.m_5634_(4.0f);
        return super.m_214076_(level, victim);
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_MEGALANIA);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.MEGALANIA_FOOD);
    }

    @Override
    public boolean canOwnerCommand(Player player) {
        return true;
    }

    public void applyPoison(@NotNull LivingEntity entity) {
        float chance = 0.0f;
        int i = 0;
        if (this.m_9236_().m_46791_() == Difficulty.NORMAL) {
            i = 5;
        } else if (this.m_9236_().m_46791_() == Difficulty.HARD) {
            i = 10;
        }
        if (this.getTemperatureState() == TemperatureStates.COLD) {
            chance = -0.1f;
        } else if (this.getTemperatureState() == TemperatureStates.WARM) {
            chance = 0.1f;
        } else if (this.getTemperatureState() == TemperatureStates.NETHER) {
            chance = 0.2f;
        }
        if (i > 0 && this.m_217043_().m_188501_() < 0.3f + chance) {
            entity.m_147207_(new MobEffectInstance(this.getTemperatureState() == TemperatureStates.NETHER ? MobEffects.f_19615_ : MobEffects.f_19614_, i * 40, 0), (Entity)this);
        }
    }

    public boolean m_7301_(MobEffectInstance effect) {
        if (effect.m_19544_() == MobEffects.f_19614_) {
            MobEffectEvent.Applicable event = new MobEffectEvent.Applicable((LivingEntity)this, effect);
            MinecraftForge.EVENT_BUS.post((Event)event);
            return event.getResult() == Event.Result.ALLOW;
        }
        if (effect.m_19544_() == MobEffects.f_19615_ && this.getTemperatureState() == TemperatureStates.NETHER) {
            MobEffectEvent.Applicable event = new MobEffectEvent.Applicable((LivingEntity)this, effect);
            MinecraftForge.EVENT_BUS.post((Event)event);
            return event.getResult() == Event.Result.ALLOW;
        }
        return super.m_7301_(effect);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(TEMPERATURE_STATE, (Object)0);
        this.f_19804_.m_135372_(PREV_TEMPERATURE_STATE, (Object)-1);
        this.f_19804_.m_135372_(TAME_ATTEMPTS, (Object)0);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("TemperatureState", this.getTemperatureState().ordinal());
        compoundTag.m_128405_("TameAttempts", this.getTameAttempts());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.f_19804_.m_135381_(TEMPERATURE_STATE, (Object)compoundTag.m_128451_("TemperatureState"));
        this.setTameAttempts(compoundTag.m_128451_("TameAttempts"));
    }

    public TemperatureStates getTemperatureState() {
        return TemperatureStates.values()[Mth.m_14045_((int)((Integer)this.f_19804_.m_135370_(TEMPERATURE_STATE)), (int)0, (int)3)];
    }

    public void setTemperatureState(TemperatureStates state) {
        if (this.getTemperatureState() != state) {
            this.f_19804_.m_135381_(PREV_TEMPERATURE_STATE, (Object)((Integer)this.f_19804_.m_135370_(TEMPERATURE_STATE)));
        }
        this.f_19804_.m_135381_(TEMPERATURE_STATE, (Object)state.ordinal());
    }

    public TemperatureStates getPrevTemperatureState() {
        if ((Integer)this.f_19804_.m_135370_(PREV_TEMPERATURE_STATE) == -1) {
            return null;
        }
        return TemperatureStates.values()[Mth.m_14045_((int)((Integer)this.f_19804_.m_135370_(PREV_TEMPERATURE_STATE)), (int)0, (int)3)];
    }

    public void setTameAttempts(int tameAttempts) {
        this.f_19804_.m_135381_(TAME_ATTEMPTS, (Object)tameAttempts);
    }

    public int getTameAttempts() {
        return (Integer)this.f_19804_.m_135370_(TAME_ATTEMPTS);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 2;
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
        this.tickTemperatureStates();
        if (!this.m_9236_().f_46443_) {
            if (this.attackCooldown > 0) {
                --this.attackCooldown;
            }
            if (this.talWhipCooldown > 0 && !this.m_20072_()) {
                --this.talWhipCooldown;
            }
        }
    }

    private void tickTemperatureStates() {
        if (((Biome)this.m_9236_().m_204166_(this.m_20183_()).m_203334_()).m_47554_() >= 1.0f) {
            if (this.m_9236_().m_46472_() == Level.f_46429_) {
                this.setTemperatureState(TemperatureStates.NETHER);
            } else {
                this.setTemperatureState(TemperatureStates.WARM);
            }
        } else if (((Biome)this.m_9236_().m_204166_(this.m_20183_()).m_203334_()).m_47554_() <= 0.0f) {
            this.setTemperatureState(TemperatureStates.COLD);
        } else {
            this.setTemperatureState(TemperatureStates.TEMPERATE);
        }
        this.prevTempProgress = this.tempProgress;
        if (this.localTemperatureState != this.getPrevTemperatureState()) {
            this.localTemperatureState = this.getPrevTemperatureState();
            this.tempProgress = 0.0f;
        }
        if (this.getPrevTemperatureState() != this.getTemperatureState() && this.tempProgress < 5.0f) {
            this.tempProgress += 0.4f;
        }
        if (this.getPrevTemperatureState() == this.getTemperatureState() && this.tempProgress > 0.0f) {
            this.tempProgress -= 0.4f;
        }
    }

    public float getTempProgress(float partialTicks) {
        return (this.prevTempProgress + (this.tempProgress - this.prevTempProgress) * partialTicks) * 0.2f;
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.m_20072_() && this.getIdleState() != 2 && this.m_20089_() != UP2Poses.TAIL_WHIPPING.get() && !this.isSitting() && !this.isEepy(), this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20072_(), this.f_19797_);
        this.aggroAnimationState.m_246184_(this.m_5912_() && this.m_20089_() == Pose.STANDING, this.f_19797_);
        this.sitAnimationState.m_246184_(this.isSitting(), this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
        this.tongueAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.roarAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
        this.attack1AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && !this.attackAlt, this.f_19797_);
        this.attack2AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && this.attackAlt, this.f_19797_);
        this.tailWhipAnimationState.m_246184_(this.m_20089_() == UP2Poses.TAIL_WHIPPING.get(), this.f_19797_);
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.m_21188_() == null && this.m_5448_() == null && !this.m_20069_() && !this.m_9236_().f_46443_) {
            if (this.tongueCooldown > 0) {
                --this.tongueCooldown;
            }
            if (this.roarCooldown > 0) {
                --this.roarCooldown;
            }
        }
    }

    protected void tongueCooldown() {
        this.tongueCooldown = 100 + this.m_217043_().m_188503_(100);
    }

    protected void roarCooldown() {
        this.roarCooldown = 650 + this.m_217043_().m_188503_(4200);
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (TEMPERATURE_STATE.equals(accessor)) {
            if (this.getTemperatureState().equals((Object)TemperatureStates.COLD)) {
                this.m_21051_(Attributes.f_22279_).m_22100_((double)0.14f);
                this.m_21051_(Attributes.f_22277_).m_22100_(10.0);
                if (this.randomStrollGoal != null) {
                    this.randomStrollGoal.m_25746_(200);
                }
            } else if (this.getTemperatureState().equals((Object)TemperatureStates.TEMPERATE)) {
                this.m_21051_(Attributes.f_22279_).m_22100_((double)0.18f);
                this.m_21051_(Attributes.f_22277_).m_22100_(16.0);
                if (this.randomStrollGoal != null) {
                    this.randomStrollGoal.m_25746_(120);
                }
            } else if (this.getTemperatureState().equals((Object)TemperatureStates.WARM)) {
                this.m_21051_(Attributes.f_22279_).m_22100_((double)0.2f);
                this.m_21051_(Attributes.f_22277_).m_22100_(20.0);
                if (this.randomStrollGoal != null) {
                    this.randomStrollGoal.m_25746_(80);
                }
            } else if (this.getTemperatureState().equals((Object)TemperatureStates.NETHER)) {
                this.m_21051_(Attributes.f_22279_).m_22100_((double)0.3f);
                this.m_21051_(Attributes.f_22277_).m_22100_(32.0);
                if (this.randomStrollGoal != null) {
                    this.randomStrollGoal.m_25746_(50);
                }
            }
        }
        super.m_7350_(accessor);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.MEGALANIA.get()).m_20615_((Level)level);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.MEGALANIA_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSourceIn) {
        return (SoundEvent)UP2SoundEvents.MEGALANIA_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.MEGALANIA_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.MEGALANIA_STEP.get(), 0.6f, 1.0f);
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor levelAccessor, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag compoundTag) {
        this.f_19804_.m_135381_(PREV_TEMPERATURE_STATE, (Object)0);
        this.setTemperatureState(TemperatureStates.TEMPERATE);
        return super.m_6518_(levelAccessor, difficulty, spawnType, spawnDataIn, compoundTag);
    }

    public static boolean canSpawn(EntityType<Megalania> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.MEGALANIA_SPAWNABLE_ON) && Megalania.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    public static enum TemperatureStates {
        TEMPERATE,
        COLD,
        WARM,
        NETHER;

    }

    private static class MegalaniaTongueGoal
    extends IdleAnimationGoal {
        private final Megalania megalania;

        public MegalaniaTongueGoal(Megalania megalania) {
            super(megalania, 20, 1, false, false);
            this.megalania = megalania;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.megalania.tongueCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.megalania.tongueCooldown();
        }
    }

    private static class MegalaniaRoarGoal
    extends IdleAnimationGoal {
        private final Megalania megalania;

        public MegalaniaRoarGoal(Megalania megalania) {
            super(megalania, 80, 2);
            this.megalania = megalania;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.megalania.roarCooldown == 0 && !this.megalania.isSitting();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.megalania.roarCooldown();
        }

        @Override
        public void m_8037_() {
            super.m_8037_();
            if (this.timer == 61) {
                this.megalania.m_5496_((SoundEvent)UP2SoundEvents.MEGALANIA_ROAR.get(), 1.5f, this.megalania.m_6100_());
            }
        }
    }

    private static class MegalaniaTargetGoal<T extends LivingEntity>
    extends PrehistoricNearestAttackableTargetGoal<T> {
        private final Megalania megalania;

        public MegalaniaTargetGoal(Megalania megalania, Class<T> targetClass) {
            super(megalania, targetClass, 0, true, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.MEGALANIA_TARGETS));
            this.megalania = megalania;
        }

        @Override
        public boolean m_8036_() {
            return this.getInterval() && !this.prehistoricMob.isPacified() && !this.prehistoricMob.m_6162_();
        }

        private boolean getInterval() {
            if (this.megalania.getHuntingInterval() > 0 && this.megalania.m_217043_().m_188503_(this.megalania.getHuntingInterval()) != 0) {
                return false;
            }
            this.m_26073_();
            return this.f_26050_ != null;
        }
    }
}


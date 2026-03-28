/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargeBabyPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_1.CarnotaurusAttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2MobEffects;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Carnotaurus
extends PrehistoricMob {
    private static final EntityDataAccessor<Boolean> ANGRY = SynchedEntityData.m_135353_(Carnotaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public int chargeCooldown = 200 + this.m_217043_().m_188503_(200);
    public int roarCooldown = 100;
    public int biteCooldown = 0;
    public int headbuttCooldown = 0;
    public final SmoothAnimationState attack1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState chargeStartAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState chargeEndAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState headbuttAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState angryAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState roarAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState swimAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attackFast1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attackFast2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState headbuttFastAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState yawnAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState shakeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState sniff1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState sniff2AnimationState = new SmoothAnimationState();
    public boolean attackAlt = false;
    private boolean sniffAlt = false;
    private int yawnCooldown = 500 + this.m_217043_().m_188503_(2500);
    private int shakeCooldown = 600 + this.m_217043_().m_188503_(2500);
    private int sniffCooldown = 700 + this.m_217043_().m_188503_(4200);
    private int startChargeTicks;
    private int stopChargeTicks;

    public Carnotaurus(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargeBabyPanicGoal(this, 1.7, 10, 4));
        this.f_21345_.m_25352_(2, (Goal)new CarnotaurusAttackGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.CARNOTAURUS_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(5, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.f_21345_.m_25352_(5, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(6, (Goal)new SleepingGoal(this){

            @Override
            public boolean m_8036_() {
                return super.m_8036_() && !Carnotaurus.this.isAngry();
            }
        });
        this.f_21345_.m_25352_(7, (Goal)new CarnotaurusYawnGoal(this));
        this.f_21345_.m_25352_(7, (Goal)new CarnotaurusShakeGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new CarnotaurusSniffGoal(this));
        this.f_21346_.m_25352_(0, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(1, new PrehistoricNearestAttackableTargetGoal<Player>(this, Player.class, 100, true, true, arg_0 -> ((Carnotaurus)this).m_6779_(arg_0)));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Monster.class, 60, true, true, entity -> !entity.m_6095_().m_204039_(UP2EntityTags.CARNOTAURUS_IGNORES)));
        this.f_21346_.m_25352_(3, new PrehistoricNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 300, true, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.CARNOTAURUS_TARGETS)));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 60.0).m_22268_(Attributes.f_22281_, 9.0).m_22268_(Attributes.f_22279_, (double)0.18f).m_22268_(Attributes.f_22278_, 0.5).m_22268_(Attributes.f_22284_, 6.0).m_22268_(Attributes.f_22277_, 32.0);
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.refuseToMove() && this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        super.m_7023_(travelVec);
    }

    public float getStepHeight() {
        return 1.1f;
    }

    public void roar() {
        if (this.m_6084_()) {
            this.m_9236_().m_7605_((Entity)this, (byte)39);
            this.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 400, 1));
            this.m_7292_(new MobEffectInstance((MobEffect)UP2MobEffects.FURY.get(), 300, 0));
            this.m_146850_(GameEvent.f_223709_);
        }
    }

    public boolean isFurious() {
        return this.m_21023_((MobEffect)UP2MobEffects.FURY.get());
    }

    public boolean m_214076_(@NotNull ServerLevel level, @NotNull LivingEntity victim) {
        this.m_5634_(6.0f);
        return super.m_214076_(level, victim);
    }

    public boolean isWithinYRange(LivingEntity target) {
        if (target == null) {
            return false;
        }
        return Math.abs(target.m_20186_() - this.m_20186_()) < 2.0;
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_CARNOTAURUS);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.CARNOTAURUS_FOOD);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 3;
    }

    public void chargeCooldown() {
        this.chargeCooldown = 200 + this.m_217043_().m_188503_(200);
    }

    public void roarCooldown() {
        this.roarCooldown = 600 + this.m_217043_().m_188503_(400);
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (this.chargeCooldown > 0) {
            --this.chargeCooldown;
        }
        if (this.roarCooldown > 0) {
            --this.roarCooldown;
        }
        if (this.headbuttCooldown > 0) {
            --this.headbuttCooldown;
        }
        if (this.biteCooldown > 0) {
            --this.biteCooldown;
        }
        this.setAngry(this.m_21223_() < this.m_21233_() * 0.5f && !this.m_6162_());
    }

    @Override
    public void setupAnimationStates() {
        this.angryAnimationState.m_246184_(this.canPlayAngryAnimation(), this.f_19797_);
        this.idleAnimationState.m_246184_(this.m_20089_() != Pose.ROARING && !this.m_20069_() && !this.isEepy(), this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20089_() != Pose.ROARING && this.m_20069_(), this.f_19797_);
        this.attack1AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && !this.attackAlt, this.f_19797_);
        this.attack2AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && this.attackAlt, this.f_19797_);
        this.attackFast1AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING_FAST.get() && !this.attackAlt, this.f_19797_);
        this.attackFast2AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING_FAST.get() && this.attackAlt, this.f_19797_);
        this.headbuttAnimationState.m_246184_(this.m_20089_() == UP2Poses.HEADBUTTING.get(), this.f_19797_);
        this.headbuttFastAnimationState.m_246184_(this.m_20089_() == UP2Poses.HEADBUTTING_FAST.get(), this.f_19797_);
        this.chargeStartAnimationState.m_246184_(this.m_20089_() == UP2Poses.START_CHARGING.get(), this.f_19797_);
        this.chargeEndAnimationState.m_246184_(this.m_20089_() == UP2Poses.STOP_CHARGING.get(), this.f_19797_);
        this.roarAnimationState.m_246184_(this.m_20089_() == UP2Poses.ROARING.get(), this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
        this.yawnAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.shakeAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
        this.sniff1AnimationState.m_246184_(this.getIdleState() == 3 && !this.sniffAlt, this.f_19797_);
        this.sniff2AnimationState.m_246184_(this.getIdleState() == 3 && this.sniffAlt, this.f_19797_);
    }

    private boolean canPlayAngryAnimation() {
        if (this.m_20089_() == UP2Poses.ROARING.get() && this.m_20089_() == UP2Poses.ATTACKING.get() && this.m_20089_() == UP2Poses.ATTACKING_FAST.get() && this.m_20089_() == UP2Poses.HEADBUTTING.get() && this.m_20089_() == UP2Poses.HEADBUTTING_FAST.get()) {
            return false;
        }
        return this.isAngry();
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.isEepy()) {
            if (this.yawnCooldown > 0) {
                --this.yawnCooldown;
            }
            if (this.shakeCooldown > 0) {
                --this.shakeCooldown;
            }
            if (this.sniffCooldown > 0) {
                --this.sniffCooldown;
            }
        }
        if (this.startChargeTicks > 0) {
            --this.startChargeTicks;
        }
        if (this.stopChargeTicks > 0) {
            --this.stopChargeTicks;
        }
        if (this.startChargeTicks == 0 && this.m_20089_() == UP2Poses.START_CHARGING.get()) {
            this.m_20124_(UP2Poses.CHARGING.get());
        }
        if (this.stopChargeTicks == 0 && this.m_20089_() == UP2Poses.STOP_CHARGING.get()) {
            this.m_20124_(Pose.STANDING);
        }
    }

    @Override
    public float getWalkAnimationSpeed() {
        return this.m_6162_() ? 2.0f : 4.0f;
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (f_19806_.equals(accessor)) {
            if (this.m_20089_() == UP2Poses.START_CHARGING.get()) {
                this.startChargeTicks = 30;
            } else if (this.m_20089_() == UP2Poses.STOP_CHARGING.get()) {
                this.stopChargeTicks = 15;
            }
        }
        super.m_7350_(accessor);
    }

    @Override
    public void m_7822_(byte id) {
        if (id == 39) {
            this.roarEffect();
        } else {
            super.m_7822_(id);
        }
    }

    private void roarEffect() {
        for (int i = 0; i < 10; ++i) {
            double d0 = this.f_19796_.m_188583_() * 0.02;
            double d1 = this.f_19796_.m_188583_() * 0.02;
            double d2 = this.f_19796_.m_188583_() * 0.02;
            this.m_9236_().m_7106_((ParticleOptions)ParticleTypes.f_123792_, this.m_20208_(1.0), this.m_20187_() + 1.0, this.m_20262_(1.0), d0, d1, d2);
        }
    }

    protected void yawnCooldown() {
        this.yawnCooldown = 500 + this.m_217043_().m_188503_(2500);
    }

    protected void shakeCooldown() {
        this.shakeCooldown = 600 + this.m_217043_().m_188503_(3600);
    }

    protected void sniffCooldown() {
        this.sniffCooldown = 700 + this.m_217043_().m_188503_(4200);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(ANGRY, (Object)false);
    }

    public boolean isAngry() {
        return (Boolean)this.f_19804_.m_135370_(ANGRY);
    }

    public void setAngry(boolean angry) {
        this.f_19804_.m_135381_(ANGRY, (Object)angry);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        Carnotaurus carnotaurus = (Carnotaurus)((EntityType)UP2Entities.CARNOTAURUS.get()).m_20615_((Level)level);
        if (carnotaurus != null) {
            carnotaurus.setVariant(this.getVariant());
        }
        return carnotaurus;
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.CARNOTAURUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSourceIn) {
        return (SoundEvent)UP2SoundEvents.CARNOTAURUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.CARNOTAURUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.CARNOTAURUS_STEP.get(), this.m_6162_() ? 0.25f : 1.0f, this.m_6162_() ? 1.2f : 0.9f);
    }

    public int m_8100_() {
        return 180;
    }

    @Override
    public int getVariantCount() {
        return CarnotaurusVariant.values().length;
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag compoundTag) {
        if (level.m_213780_().m_188501_() < 0.2f) {
            this.setVariant(1);
        } else {
            this.setVariant(0);
        }
        return super.m_6518_(level, difficulty, spawnType, spawnData, compoundTag);
    }

    public static boolean canSpawn(EntityType<Carnotaurus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.CARNOTAURUS_SPAWNABLE_ON) && Carnotaurus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class CarnotaurusYawnGoal
    extends IdleAnimationGoal {
        private final Carnotaurus carnotaurus;

        public CarnotaurusYawnGoal(Carnotaurus carnotaurus) {
            super(carnotaurus, 60, 1, false);
            this.carnotaurus = carnotaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.carnotaurus.yawnCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.carnotaurus.yawnCooldown();
        }
    }

    private static class CarnotaurusShakeGoal
    extends IdleAnimationGoal {
        private final Carnotaurus carnotaurus;

        public CarnotaurusShakeGoal(Carnotaurus carnotaurus) {
            super(carnotaurus, 40, 2, false);
            this.carnotaurus = carnotaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.carnotaurus.shakeCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.carnotaurus.shakeCooldown();
        }
    }

    private static class CarnotaurusSniffGoal
    extends IdleAnimationGoal {
        private final Carnotaurus carnotaurus;

        public CarnotaurusSniffGoal(Carnotaurus carnotaurus) {
            super(carnotaurus, 80, 3);
            this.carnotaurus = carnotaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.carnotaurus.sniffCooldown == 0;
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            this.carnotaurus.sniffAlt = this.carnotaurus.m_217043_().m_188499_();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.carnotaurus.sniffCooldown();
        }

        @Override
        public void m_8037_() {
            super.m_8037_();
            if (this.timer == 50) {
                this.carnotaurus.m_5496_((SoundEvent)UP2SoundEvents.CARNOTAURUS_SNIFF.get(), 1.0f, this.carnotaurus.m_6100_());
            }
        }
    }

    public static enum CarnotaurusVariant {
        CARNOTAURUS(0),
        GOLDEN_EMPEROR(1);

        private final int id;

        private CarnotaurusVariant(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static CarnotaurusVariant byId(int id) {
            if (id < 0 || id >= CarnotaurusVariant.values().length) {
                id = 0;
            }
            return CarnotaurusVariant.values()[id];
        }
    }
}


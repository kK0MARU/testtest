/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
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
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.EntityDimensions
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
 *  net.minecraft.world.entity.ai.goal.FollowParentGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_4;

import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_4.PachycephalosaurusAttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Particles;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
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
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
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
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Pachycephalosaurus
extends PrehistoricMob {
    private static final EntityDataAccessor<Integer> CHARGE_COOLDOWN = SynchedEntityData.m_135353_(Pachycephalosaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Integer> FIGHT_COOLDOWN = SynchedEntityData.m_135353_(Pachycephalosaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Boolean> FIGHT_PARTNER = SynchedEntityData.m_135353_(Pachycephalosaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Boolean> WANTS_TO_KILL = SynchedEntityData.m_135353_(Pachycephalosaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Integer> FIND_TARGET_COOLDOWN = SynchedEntityData.m_135353_(Pachycephalosaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private int grazeCooldown = 700 + this.m_217043_().m_188503_(3000);
    private int huffCooldown = 600 + this.m_217043_().m_188503_(3600);
    public final SmoothAnimationState idleAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState huffAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState grazeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState warnAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState recoverAnimationState = new SmoothAnimationState();
    private int recoverTicks;

    public Pachycephalosaurus(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargePanicGoal(this, 1.7){

            @Override
            public boolean m_8036_() {
                return super.m_8036_() && Pachycephalosaurus.this.m_6162_() || Pachycephalosaurus.this.m_21223_() <= Pachycephalosaurus.this.m_21233_() * 0.5f;
            }
        });
        this.f_21345_.m_25352_(2, (Goal)new PachycephalosaurusAttackGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.PACHYCEPHALOSAURUS_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(5, (Goal)new FollowParentGoal((Animal)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(7, (Goal)new SleepingGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new PachycephalosaurusGrazeGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new PachycephalosaurusHuffGoal(this));
        this.f_21346_.m_25352_(0, (Goal)new PachycephalosaurusHurtByTargetGoal(this, Pachycephalosaurus.class));
        this.f_21346_.m_25352_(1, new PachycephalosaurusTargetToKillGoal<LivingEntity>(this, LivingEntity.class, 300, true, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.PACHYCEPHALOSAURUS_TARGETS_TO_KILL)));
        this.f_21346_.m_25352_(2, new PachycephalosaurusTargetOthersGoal<Pachycephalosaurus>(this, Pachycephalosaurus.class));
        this.f_21346_.m_25352_(3, new PachycephalosaurusNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 500, true, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.PACHYCEPHALOSAURUS_TARGETS)));
        this.f_21346_.m_25352_(4, new PachycephalosaurusNearestAttackableTargetGoal<Player>(this, Player.class, 500, true, true, arg_0 -> ((Pachycephalosaurus)this).m_6779_(arg_0)));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 14.0).m_22268_(Attributes.f_22281_, 8.0).m_22268_(Attributes.f_22278_, 0.25).m_22268_(Attributes.f_22279_, 0.25).m_22268_(Attributes.f_22284_, 4.0);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions size) {
        return size.f_20378_ * 0.9f;
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
        return this.isRunning() ? 1.0f : 0.6f;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.PACHYCEPHALOSAURUS_FOOD);
    }

    @Override
    public Vec3 getEepyParticleVec() {
        return new Vec3(0.0, (double)0.15f, (double)(-this.m_20205_() * 0.8f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    public boolean canChargeAtOtherPachycephalosaurus(LivingEntity entity) {
        Mob mob;
        if (entity instanceof Mob && (mob = (Mob)entity).m_5448_() != null) {
            return false;
        }
        return this.m_6779_(entity) && !this.m_20072_() && this.getFightCooldown() <= 0 && entity.m_21188_() == null && !entity.m_20072_();
    }

    public boolean m_5843_() {
        return this.m_20184_().m_165924_() > 0.05 && this.getAttackState() == 1 && !this.m_20069_() && !this.m_5833_() && !this.m_6047_() && !this.m_20077_() && this.m_6084_() && !this.isInFluidType();
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (!this.m_9236_().f_46443_) {
            if (this.getChargeCooldown() > 0) {
                this.setChargeCooldown(this.getChargeCooldown() - 1);
            }
            if (this.getFightCooldown() > 0 && !this.isEepy() && !this.m_20072_()) {
                this.setFightCooldown(this.getFightCooldown() - 1);
            }
            if (this.getFindTargetCooldown() > 0 && !this.isEepy() && !this.m_20072_()) {
                this.setFindTargetCooldown(this.getFindTargetCooldown() - 1);
            }
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.recoverTicks > 0) {
            --this.recoverTicks;
        }
        if (this.recoverTicks == 0 && this.m_20089_() == UP2Poses.RECOVERING.get()) {
            this.m_20124_(Pose.STANDING);
        }
        if (!(this.m_9236_().f_46443_ || this.m_20072_() || this.isEepy())) {
            if (this.huffCooldown > 0) {
                --this.huffCooldown;
            }
            if (this.grazeCooldown > 0) {
                --this.grazeCooldown;
            }
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(this.getAttackState() != 1 && !this.m_20072_() && !this.isEepy() && this.m_20089_() != UP2Poses.RECOVERING.get(), this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20072_() && this.getAttackState() != 1, this.f_19797_);
        this.recoverAnimationState.m_246184_(this.m_20089_() == UP2Poses.RECOVERING.get(), this.f_19797_);
        this.warnAnimationState.m_246184_(this.m_20089_() == UP2Poses.WARNING.get(), this.f_19797_);
        this.grazeAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.huffAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (f_19806_.equals(accessor) && this.m_20089_() == UP2Poses.RECOVERING.get()) {
            this.recoverTicks = 70;
        }
        super.m_7350_(accessor);
    }

    protected void grazeCooldown() {
        this.grazeCooldown = 700 + this.m_217043_().m_188503_(3000);
    }

    protected void huffCooldown() {
        this.huffCooldown = 600 + this.m_217043_().m_188503_(3600);
    }

    @Override
    public void m_7822_(byte id) {
        if (id == 39) {
            this.spawnImpactParticles(4, 0.25);
        } else {
            super.m_7822_(id);
        }
    }

    public void spawnImpactParticles(int amount, double speed) {
        Vec3 impactPos = this.m_146892_().m_82549_(this.m_20252_(0.0f).m_82490_(2.5).m_82520_(0.0, -0.25, (double)(-this.m_20205_() * 0.5f)));
        Vec3 forward = this.m_20252_(0.0f).m_82541_().m_82490_(-1.0);
        for (int i = 0; i < amount; ++i) {
            double theta = (double)(this.m_217043_().m_188501_() - 0.5f) * Math.PI * 0.75;
            Vec3 rotated = forward.m_82524_((float)theta);
            double xVelocity = rotated.f_82479_ * (double)this.m_217043_().m_188501_() * (double)0.6f;
            double yVelocity = this.m_217043_().m_188501_() * 0.8f;
            double zVelocity = rotated.f_82481_ * (double)this.m_217043_().m_188501_() * (double)0.6f;
            this.m_9236_().m_6493_((ParticleOptions)UP2Particles.IMPACT_STUN.get(), false, impactPos.f_82479_, impactPos.f_82480_, impactPos.f_82481_, xVelocity * speed, yVelocity * speed, zVelocity * speed);
        }
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1 || this.getIdleState() == 3 || this.m_20089_() == UP2Poses.RECOVERING.get();
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(CHARGE_COOLDOWN, (Object)0);
        this.f_19804_.m_135372_(FIGHT_COOLDOWN, (Object)800);
        this.f_19804_.m_135372_(FIGHT_PARTNER, (Object)false);
        this.f_19804_.m_135372_(WANTS_TO_KILL, (Object)false);
        this.f_19804_.m_135372_(FIND_TARGET_COOLDOWN, (Object)100);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("FightCooldown", this.getFightCooldown());
        compoundTag.m_128405_("FindTargetCooldown", this.getFindTargetCooldown());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setFightCooldown(compoundTag.m_128451_("FightCooldown"));
        this.setFindTargetCooldown(compoundTag.m_128451_("FindTargetCooldown"));
    }

    public void setChargeCooldown(int cooldown) {
        this.f_19804_.m_135381_(CHARGE_COOLDOWN, (Object)cooldown);
    }

    public int getChargeCooldown() {
        return (Integer)this.f_19804_.m_135370_(CHARGE_COOLDOWN);
    }

    public void setFightCooldown(int cooldown) {
        this.f_19804_.m_135381_(FIGHT_COOLDOWN, (Object)cooldown);
    }

    public int getFightCooldown() {
        return (Integer)this.f_19804_.m_135370_(FIGHT_COOLDOWN);
    }

    public void setFightPartner(boolean partner) {
        this.f_19804_.m_135381_(FIGHT_PARTNER, (Object)partner);
    }

    public boolean isFightPartner() {
        return (Boolean)this.f_19804_.m_135370_(FIGHT_PARTNER);
    }

    public void setWantsToKill(boolean wantsToKill) {
        this.f_19804_.m_135381_(WANTS_TO_KILL, (Object)wantsToKill);
    }

    public boolean wantsToKill() {
        return (Boolean)this.f_19804_.m_135370_(WANTS_TO_KILL);
    }

    public void setFindTargetCooldown(int cooldown) {
        this.f_19804_.m_135381_(FIND_TARGET_COOLDOWN, (Object)cooldown);
    }

    public int getFindTargetCooldown() {
        return (Integer)this.f_19804_.m_135370_(FIND_TARGET_COOLDOWN);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        Pachycephalosaurus pachycephalosaurus = (Pachycephalosaurus)((EntityType)UP2Entities.PACHYCEPHALOSAURUS.get()).m_20615_((Level)level);
        if (pachycephalosaurus != null) {
            pachycephalosaurus.setVariant(this.getVariant());
        }
        return pachycephalosaurus;
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.PACHYCEPHALOSAURUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.PACHYCEPHALOSAURUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.PACHYCEPHALOSAURUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.PACHYCEPHALOSAURUS_STEP.get(), 0.15f, 1.0f);
    }

    public int m_8100_() {
        return 200;
    }

    @Override
    public int getVariantCount() {
        return PachycephalosaurusVariant.values().length;
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag compoundTag) {
        this.setVariant(level.m_213780_().m_188503_(this.getVariantCount()));
        return super.m_6518_(level, difficulty, spawnType, spawnData, compoundTag);
    }

    public static boolean canSpawn(EntityType<Pachycephalosaurus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.PACHYCEPHALOSAURUS_SPAWNABLE_ON) && Pachycephalosaurus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class PachycephalosaurusGrazeGoal
    extends IdleAnimationGoal {
        private final Pachycephalosaurus pachycephalosaurus;

        public PachycephalosaurusGrazeGoal(Pachycephalosaurus pachycephalosaurus) {
            super(pachycephalosaurus, 60, 1);
            this.pachycephalosaurus = pachycephalosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.pachycephalosaurus.grazeCooldown == 0 && this.pachycephalosaurus.m_9236_().m_8055_(this.pachycephalosaurus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.PACHYCEPHALOSAURUS_GRAZING_BLOCKS);
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.pachycephalosaurus.grazeCooldown();
        }
    }

    private static class PachycephalosaurusHuffGoal
    extends IdleAnimationGoal {
        private final Pachycephalosaurus pachycephalosaurus;

        public PachycephalosaurusHuffGoal(Pachycephalosaurus pachycephalosaurus) {
            super(pachycephalosaurus, 30, 2, false);
            this.pachycephalosaurus = pachycephalosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.pachycephalosaurus.huffCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.pachycephalosaurus.huffCooldown();
        }
    }

    private static class PachycephalosaurusHurtByTargetGoal
    extends HurtByTargetGoal {
        private final Pachycephalosaurus pachycephalosaurus;

        public PachycephalosaurusHurtByTargetGoal(Pachycephalosaurus pachycephalosaurus, Class<?> ... toIgnoreDamage) {
            super((PathfinderMob)pachycephalosaurus, (Class[])toIgnoreDamage);
            this.pachycephalosaurus = pachycephalosaurus;
        }

        public void m_8056_() {
            super.m_8056_();
            this.pachycephalosaurus.setWantsToKill(true);
        }

        public void m_8041_() {
            super.m_8041_();
            this.pachycephalosaurus.setWantsToKill(false);
        }
    }

    private static class PachycephalosaurusTargetToKillGoal<T extends LivingEntity>
    extends PrehistoricNearestAttackableTargetGoal<T> {
        private final Pachycephalosaurus pachycephalosaurus;

        public PachycephalosaurusTargetToKillGoal(Pachycephalosaurus pachycephalosaurus, Class<T> targetClass, int interval, boolean mustSee, boolean mustReach, @Nullable Predicate<LivingEntity> entityPredicate) {
            super(pachycephalosaurus, targetClass, interval, mustSee, mustReach, entityPredicate);
            this.pachycephalosaurus = pachycephalosaurus;
        }

        public void m_8056_() {
            super.m_8056_();
            this.pachycephalosaurus.setWantsToKill(true);
        }

        public void m_8041_() {
            super.m_8041_();
            this.pachycephalosaurus.setWantsToKill(false);
        }
    }

    private static class PachycephalosaurusTargetOthersGoal<T extends LivingEntity>
    extends NearestAttackableTargetGoal<T> {
        private final Pachycephalosaurus prehistoricMob;

        public PachycephalosaurusTargetOthersGoal(Pachycephalosaurus pachycephalosaurus, Class<T> targetClass) {
            super((Mob)pachycephalosaurus, targetClass, 200, true, true, pachycephalosaurus::canChargeAtOtherPachycephalosaurus);
            this.prehistoricMob = pachycephalosaurus;
        }

        public void m_8056_() {
            Pachycephalosaurus pachycephalosaurus;
            this.f_26135_.m_6710_(this.f_26050_);
            LivingEntity livingEntity = this.f_26050_;
            if (livingEntity instanceof Pachycephalosaurus && (pachycephalosaurus = (Pachycephalosaurus)livingEntity).m_5448_() == null && pachycephalosaurus.m_21188_() == null && !pachycephalosaurus.m_20072_()) {
                pachycephalosaurus.setFightPartner(true);
                pachycephalosaurus.m_6710_((LivingEntity)this.f_26135_);
            }
            super.m_8056_();
        }

        public boolean m_8036_() {
            return super.m_8036_() && !this.prehistoricMob.m_6162_() && !this.prehistoricMob.isEepy();
        }

        public boolean m_8045_() {
            return super.m_8045_() && !this.prehistoricMob.isEepy();
        }
    }

    private static class PachycephalosaurusNearestAttackableTargetGoal<T extends LivingEntity>
    extends PrehistoricNearestAttackableTargetGoal<T> {
        private final Pachycephalosaurus pachycephalosaurus;

        public PachycephalosaurusNearestAttackableTargetGoal(Pachycephalosaurus pachycephalosaurus, Class<T> targetClass, int interval, boolean mustSee, boolean mustReach, @Nullable Predicate<LivingEntity> entityPredicate) {
            super(pachycephalosaurus, targetClass, interval, mustSee, mustReach, entityPredicate);
            this.pachycephalosaurus = pachycephalosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.pachycephalosaurus.getFindTargetCooldown() <= 0;
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && this.pachycephalosaurus.getFindTargetCooldown() <= 0;
        }
    }

    public static enum PachycephalosaurusVariant {
        LAVENDER(0),
        MAROON(1),
        FOREST(2);

        private final int id;

        private PachycephalosaurusVariant(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static PachycephalosaurusVariant byId(int id) {
            if (id < 0 || id >= PachycephalosaurusVariant.values().length) {
                id = 0;
            }
            return PachycephalosaurusVariant.values()[id];
        }
    }
}


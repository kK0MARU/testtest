/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.util.valueproviders.IntProvider
 *  net.minecraft.util.valueproviders.UniformInt
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.item.FallingBlockEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_4;

import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargeBabyPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricFollowParentGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_4.LystrosaurusRunLikeCrazyGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2DamageTypeTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import com.barlinc.unusual_prehistory.utils.UP2ParticleUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Lystrosaurus
extends PrehistoricMob {
    public final SmoothAnimationState grazeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attackAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState digAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState shakeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState scratch1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState scratch2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState blinkAnimationState = new SmoothAnimationState();
    private boolean scratchAlt = false;
    private int scratchCooldown = 1200 + this.m_217043_().m_188503_(1300);
    private int grazeCooldown = 1300 + this.m_217043_().m_188503_(1400);
    private int digCooldown = 2000 + this.m_217043_().m_188503_(2000);
    private int blinkCooldown = 400 + this.m_217043_().m_188503_(500);
    private int shakeCooldown = 1000 + this.m_217043_().m_188503_(1200);

    public Lystrosaurus(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new LystrosaurusRunLikeCrazyGoal(this));
        this.f_21345_.m_25352_(1, (Goal)new LargeBabyPanicGoal(this, 2.0, 10, 4));
        this.f_21345_.m_25352_(2, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.LYSTROSAURUS_FOOD), false));
        this.f_21345_.m_25352_(3, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(4, (Goal)new PrehistoricFollowParentGoal(this, 1.0));
        this.f_21345_.m_25352_(5, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.f_21345_.m_25352_(5, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(6, (Goal)new SleepingGoal(this));
        this.f_21345_.m_25352_(7, (Goal)new LystrosaurusBlinkGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new LystrosaurusScratchGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new LystrosaurusDigGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new LystrosaurusShakeGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new LystrosaurusGrazeGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22281_, 2.0).m_22268_(Attributes.f_22278_, 2.0).m_22268_(Attributes.f_22279_, (double)0.23f).m_22268_(Attributes.f_22284_, 30.0).m_22268_(Attributes.f_22285_, 20.0);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions size) {
        return size.f_20378_ * 0.9f;
    }

    public float getStepHeight() {
        return this.isRunning() ? 1.0f : 0.6f;
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

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.LYSTROSAURUS_FOOD);
    }

    @Override
    public int getHealCooldown() {
        return this.isEepy() ? 80 : 150;
    }

    @Override
    protected void m_6475_(@NotNull DamageSource source, float amount) {
        if (source.m_276093_(DamageTypes.f_268515_) || source.m_276093_(DamageTypes.f_268530_)) {
            super.m_6475_(source, amount * 0.1f);
        } else {
            super.m_6475_(source, amount * 0.2f);
        }
    }

    public boolean m_7301_(@NotNull MobEffectInstance effect) {
        return false;
    }

    public int m_6062_() {
        return 216000;
    }

    protected int m_7305_(int currentAir) {
        return this.m_6062_();
    }

    @Override
    public Vec3 getEepyParticleVec() {
        return new Vec3(0.0, 0.0, (double)(-this.m_20205_() * 1.05f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (this.m_6084_() && !this.m_9236_().f_46443_ && this.f_19797_ % 4 == 0) {
            this.breakFallingBlocks();
        }
    }

    private void breakFallingBlocks() {
        this.m_9236_().m_45933_((Entity)this, this.m_20191_()).forEach(entity -> {
            if (entity instanceof FallingBlockEntity) {
                FallingBlockEntity fallingBlockEntity = (FallingBlockEntity)entity;
                if (fallingBlockEntity.f_31943_ && this.m_9236_().m_46469_().m_46207_(GameRules.f_46137_)) {
                    fallingBlockEntity.m_19998_((ItemLike)fallingBlockEntity.m_31980_().m_60734_());
                }
                fallingBlockEntity.m_146870_();
                UP2ParticleUtils.queueParticlesOnBlockFaces(fallingBlockEntity.m_9236_(), fallingBlockEntity.m_20183_(), (ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, fallingBlockEntity.m_31980_()), (IntProvider)UniformInt.m_146622_((int)2, (int)4));
                fallingBlockEntity.m_149650_(fallingBlockEntity.m_31980_().m_60734_(), fallingBlockEntity.m_20183_());
            }
        });
    }

    protected void m_7840_(double y, boolean onGround, @NotNull BlockState state, @NotNull BlockPos pos) {
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.isEepy() && !this.m_20072_()) {
            if (this.scratchCooldown > 0) {
                --this.scratchCooldown;
            }
            if (this.grazeCooldown > 0) {
                --this.grazeCooldown;
            }
            if (this.digCooldown > 0) {
                --this.digCooldown;
            }
            if (this.blinkCooldown > 0) {
                --this.blinkCooldown;
            }
            if (this.shakeCooldown > 0) {
                --this.shakeCooldown;
            }
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(this.getIdleState() != 3 && !this.isEepy(), this.f_19797_);
        this.scratch1AnimationState.m_246184_(this.getIdleState() == 1 && !this.scratchAlt, this.f_19797_);
        this.scratch2AnimationState.m_246184_(this.getIdleState() == 1 && this.scratchAlt, this.f_19797_);
        this.grazeAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
        this.digAnimationState.m_246184_(this.getIdleState() == 3, this.f_19797_);
        this.blinkAnimationState.m_246184_(this.getIdleState() == 4, this.f_19797_);
        this.shakeAnimationState.m_246184_(this.getIdleState() == 5, this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20072_() && !this.m_20096_(), this.f_19797_);
    }

    protected void scratchCooldown() {
        this.scratchCooldown = 1200 + this.m_217043_().m_188503_(1300);
    }

    protected void grazeCooldown() {
        this.grazeCooldown = 1300 + this.m_217043_().m_188503_(1400);
    }

    protected void digCooldown() {
        this.digCooldown = 2000 + this.m_217043_().m_188503_(2000);
    }

    protected void blinkCooldown() {
        this.blinkCooldown = 400 + this.m_217043_().m_188503_(500);
    }

    protected void shakeCooldown() {
        this.shakeCooldown = 1000 + this.m_217043_().m_188503_(1200);
    }

    public boolean m_6673_(@NotNull DamageSource source) {
        return super.m_6673_(source) || source.m_269533_(UP2DamageTypeTags.LYSTROSAURUS_IMMUNE_TO);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1 || this.getIdleState() == 2 || this.getIdleState() == 3;
    }

    @Override
    public boolean refuseToLook() {
        return super.refuseToLook() || this.getIdleState() == 2 || this.getIdleState() == 3;
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        return (AgeableMob)((EntityType)UP2Entities.LYSTROSAURUS.get()).m_20615_((Level)level);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        if (this.m_8077_() && this.m_7755_().getString().contains("chainsmoker") && this.m_217043_().m_188501_() < 0.3f) {
            return (SoundEvent)UP2SoundEvents.LYSTROSAURUS_CHAINSMOKER.get();
        }
        return (SoundEvent)UP2SoundEvents.LYSTROSAURUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.LYSTROSAURUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.LYSTROSAURUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.LYSTROSAURUS_STEP.get(), 0.15f, 1.0f);
    }

    public int m_8100_() {
        return 180;
    }

    public static boolean canSpawn(EntityType<Lystrosaurus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.LYSTROSAURUS_SPAWNABLE_ON) && Lystrosaurus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class LystrosaurusBlinkGoal
    extends IdleAnimationGoal {
        private final Lystrosaurus lystrosaurus;

        public LystrosaurusBlinkGoal(Lystrosaurus lystrosaurus) {
            super(lystrosaurus, 60, 4, false, false);
            this.lystrosaurus = lystrosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.lystrosaurus.blinkCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.lystrosaurus.blinkCooldown();
        }
    }

    private static class LystrosaurusScratchGoal
    extends IdleAnimationGoal {
        private final Lystrosaurus lystrosaurus;

        public LystrosaurusScratchGoal(Lystrosaurus lystrosaurus) {
            super(lystrosaurus, 30, 1);
            this.lystrosaurus = lystrosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.lystrosaurus.scratchCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.lystrosaurus.scratchCooldown();
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            this.lystrosaurus.scratchAlt = this.lystrosaurus.m_217043_().m_188499_();
        }
    }

    private static class LystrosaurusDigGoal
    extends IdleAnimationGoal {
        private final Lystrosaurus lystrosaurus;

        public LystrosaurusDigGoal(Lystrosaurus lystrosaurus) {
            super(lystrosaurus, 80, 3);
            this.lystrosaurus = lystrosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.lystrosaurus.digCooldown == 0 && this.lystrosaurus.m_9236_().m_8055_(this.lystrosaurus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.LYSTROSAURUS_DIGGING_BLOCKS);
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.lystrosaurus.digCooldown();
        }

        @Override
        public void m_8037_() {
            super.m_8037_();
            if (this.timer % 6 == 0 && this.timer < 60 && this.timer > 20) {
                this.spawnEffectsAtBlock(this.lystrosaurus.m_20183_().m_7495_());
                this.lystrosaurus.m_5496_(this.lystrosaurus.m_9236_().m_8055_(this.lystrosaurus.m_20183_().m_7495_()).m_60827_().m_56778_(), 0.3f, 0.8f + this.lystrosaurus.m_217043_().m_188501_() * 0.25f);
            }
        }

        public void spawnEffectsAtBlock(BlockPos blockPos) {
            float radius = 0.4f;
            for (int i1 = 0; i1 < 3; ++i1) {
                double motionX = this.lystrosaurus.m_217043_().m_188583_() * 0.07;
                double motionY = this.lystrosaurus.m_217043_().m_188583_() * 0.07;
                double motionZ = this.lystrosaurus.m_217043_().m_188583_() * 0.07;
                float angle = (float)(0.0174532925 * (double)this.lystrosaurus.f_20883_ + (double)i1);
                double extraX = radius * Mth.m_14031_((float)((float)Math.PI + angle));
                double extraY = 0.8f;
                double extraZ = radius * Mth.m_14089_((float)angle);
                BlockState state = this.lystrosaurus.m_9236_().m_8055_(blockPos);
                ((ServerLevel)this.lystrosaurus.m_9236_()).m_8767_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, state), (double)blockPos.m_123341_() + 0.5 + extraX, (double)blockPos.m_123342_() + 0.5 + extraY, (double)blockPos.m_123343_() + 0.5 + extraZ, 1, motionX, motionY, motionZ, 1.0);
            }
        }
    }

    private static class LystrosaurusShakeGoal
    extends IdleAnimationGoal {
        private final Lystrosaurus lystrosaurus;

        public LystrosaurusShakeGoal(Lystrosaurus lystrosaurus) {
            super(lystrosaurus, 40, 5, false);
            this.lystrosaurus = lystrosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.lystrosaurus.shakeCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.lystrosaurus.shakeCooldown();
        }
    }

    private static class LystrosaurusGrazeGoal
    extends IdleAnimationGoal {
        private final Lystrosaurus lystrosaurus;

        public LystrosaurusGrazeGoal(Lystrosaurus lystrosaurus) {
            super(lystrosaurus, 40, 2);
            this.lystrosaurus = lystrosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.lystrosaurus.grazeCooldown == 0 && this.lystrosaurus.m_9236_().m_8055_(this.lystrosaurus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.LYSTROSAURUS_GRAZING_BLOCKS);
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.lystrosaurus.grazeCooldown();
        }
    }
}


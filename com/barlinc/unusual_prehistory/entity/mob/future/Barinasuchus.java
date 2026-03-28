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
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.future;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Barinasuchus
extends PrehistoricMob {
    private static final EntityDataAccessor<Integer> TAME_ATTEMPTS = SynchedEntityData.m_135353_(Barinasuchus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDimensions EEPY_DIMENSIONS = EntityDimensions.m_20395_((float)1.5f, (float)1.4f);
    public int attackCooldown = 0;
    public final SmoothAnimationState swimAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState yawnAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState shakeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState scratch1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState scratch2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState snapAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState threatenAnimationState = new SmoothAnimationState();
    private int attackTicks;
    private int yawnCooldown = 1100 + this.m_217043_().m_188503_(1200);
    private int shakeCooldown = 1400 + this.m_217043_().m_188503_(1600);
    private int snapCooldown = 1500 + this.m_217043_().m_188503_(1700);
    private int scratchCooldown = 1600 + this.m_217043_().m_188503_(1700);
    private int threatenCooldown = 2300 + this.m_217043_().m_188503_(2400);

    public Barinasuchus(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 40.0).m_22268_(Attributes.f_22279_, (double)0.23f).m_22268_(Attributes.f_22281_, 7.0).m_22268_(Attributes.f_22284_, 8.0).m_22268_(Attributes.f_22278_, 0.5).m_22268_(Attributes.f_22277_, 32.0);
    }

    @Override
    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        return new NoSpinGroundPathNavigation((Mob)this, level);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.7f;
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

    protected float m_245547_(@NotNull Player rider) {
        float sprintSpeed = rider.m_20142_() ? 0.12f : 0.0f;
        return (float)this.m_21133_(Attributes.f_22279_) * 0.5f + sprintSpeed;
    }

    public boolean m_264410_() {
        return true;
    }

    @Override
    public Vec3 getRiderOffset() {
        return new Vec3(0.0, 0.0, 0.25);
    }

    @Override
    public boolean canOwnerCommand(Player player) {
        return player.m_6144_();
    }

    @Override
    public boolean canOwnerMount(Player player) {
        return !this.m_6162_();
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.BARINASUCHUS_FOOD);
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_BARINASUCHUS);
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        InteractionResult type = super.m_6071_(player, hand);
        if (!this.m_21824_() && itemstack.m_204117_(UP2ItemTags.TAMES_BARINASUCHUS)) {
            if (!this.m_9236_().f_46443_) {
                if (!player.m_150110_().f_35937_) {
                    itemstack.m_41774_(1);
                }
                this.m_146850_(GameEvent.f_223708_);
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
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 4 || this.getIdleState() == 5;
    }

    @NotNull
    public EntityDimensions m_6972_(@NotNull Pose pose) {
        return pose == UP2Poses.SLEEPING.get() || pose == UP2Poses.SITTING.get() ? EEPY_DIMENSIONS.m_20388_(this.m_6134_()) : super.m_6972_(pose);
    }

    @Override
    public Vec3 getEepyParticleVec() {
        return new Vec3(0.0, 0.0, (double)(-this.m_20205_() * 1.5f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    @Override
    public void setupAnimationStates() {
        if (this.attackTicks == 0 && (this.attack1AnimationState.m_216984_() || this.attack2AnimationState.m_216984_())) {
            this.attack1AnimationState.m_216973_();
            this.attack2AnimationState.m_216973_();
        }
        this.idleAnimationState.m_246184_(!this.m_20069_() && this.getIdleState() != 5 && !this.isSitting() && !this.isEepy(), this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20069_(), this.f_19797_);
        this.attack1AnimationState.m_246184_(this.attack1AnimationState.m_216984_(), this.f_19797_);
        this.attack2AnimationState.m_246184_(this.attack2AnimationState.m_216984_(), this.f_19797_);
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.attackTicks > 0) {
            --this.attackTicks;
        }
        if (this.attackTicks == 0 && this.m_20089_() == UP2Poses.ATTACKING.get()) {
            this.attackCooldown = 3 + this.m_217043_().m_188503_(2);
            this.m_20124_(Pose.STANDING);
        }
        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
        if (!this.isEepy()) {
            if (this.yawnCooldown > 0) {
                --this.yawnCooldown;
            }
            if (this.shakeCooldown > 0) {
                --this.shakeCooldown;
            }
            if (this.snapCooldown > 0) {
                --this.snapCooldown;
            }
            if (this.scratchCooldown > 0) {
                --this.scratchCooldown;
            }
            if (this.threatenCooldown > 0) {
                --this.threatenCooldown;
            }
        }
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (f_19806_.equals(accessor)) {
            if (this.m_20089_() == UP2Poses.ATTACKING.get()) {
                if (this.m_217043_().m_188499_()) {
                    this.attack1AnimationState.m_216977_(this.f_19797_);
                } else {
                    this.attack2AnimationState.m_216977_(this.f_19797_);
                }
                this.attackTicks = 15;
            } else {
                this.attack1AnimationState.m_216973_();
                this.attack2AnimationState.m_216973_();
            }
        }
        super.m_7350_(accessor);
    }

    @Override
    public void m_7822_(byte id) {
        switch (id) {
            case 67: {
                this.yawnAnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 68: {
                this.yawnAnimationState.m_216973_();
                break;
            }
            case 69: {
                this.shakeAnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 70: {
                this.shakeAnimationState.m_216973_();
                break;
            }
            case 71: {
                this.snapAnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 72: {
                this.snapAnimationState.m_216973_();
                break;
            }
            case 73: {
                if (this.m_217043_().m_188499_()) {
                    this.scratch1AnimationState.m_216977_(this.f_19797_);
                    break;
                }
                this.scratch2AnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 74: {
                this.scratch1AnimationState.m_216973_();
                this.scratch2AnimationState.m_216973_();
                break;
            }
            case 75: {
                this.threatenAnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 76: {
                this.threatenAnimationState.m_216973_();
                break;
            }
            default: {
                super.m_7822_(id);
            }
        }
    }

    protected void yawnCooldown() {
        this.yawnCooldown = 1100 + this.m_217043_().m_188503_(1200);
    }

    protected void shakeCooldown() {
        this.shakeCooldown = 1400 + this.m_217043_().m_188503_(1600);
    }

    protected void snapCooldown() {
        this.snapCooldown = 1500 + this.m_217043_().m_188503_(1700);
    }

    protected void scratchCooldown() {
        this.scratchCooldown = 1600 + this.m_217043_().m_188503_(1700);
    }

    protected void threatenCooldown() {
        this.threatenCooldown = 2300 + this.m_217043_().m_188503_(2400);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(TAME_ATTEMPTS, (Object)0);
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

    @Nullable
    protected SoundEvent m_7515_() {
        return this.getIdleState() == 5 ? SoundEvents.f_271165_ : (SoundEvent)UP2SoundEvents.BARINASUCHUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.BARINASUCHUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.BARINASUCHUS_DEATH.get();
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.BARINASUCHUS.get()).m_20615_((Level)level);
    }

    public static boolean canSpawn(EntityType<Barinasuchus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.BARINASUCHUS_SPAWNABLE_ON) && Barinasuchus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class BarinasuchusThreatenGoal
    extends IdleAnimationGoal {
        private final Barinasuchus barinasuchus;

        public BarinasuchusThreatenGoal(Barinasuchus barinasuchus) {
            super(barinasuchus, 60, 5);
            this.barinasuchus = barinasuchus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.barinasuchus.threatenCooldown == 0 && !this.barinasuchus.isSitting();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.barinasuchus.threatenCooldown();
        }

        @Override
        public void m_8037_() {
            super.m_8037_();
            if (this.timer == 55) {
                this.barinasuchus.m_5496_((SoundEvent)UP2SoundEvents.BARINASUCHUS_THREATEN.get(), 1.5f, 0.9f + this.barinasuchus.m_217043_().m_188501_() * 0.25f);
            }
        }
    }

    private static class BarinasuchusScratchGoal
    extends IdleAnimationGoal {
        private final Barinasuchus barinasuchus;

        public BarinasuchusScratchGoal(Barinasuchus barinasuchus) {
            super(barinasuchus, 30, 4);
            this.barinasuchus = barinasuchus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.barinasuchus.scratchCooldown == 0 && !this.barinasuchus.isSitting();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.barinasuchus.scratchCooldown();
        }
    }

    private static class BarinasuchusSnapGoal
    extends IdleAnimationGoal {
        private final Barinasuchus barinasuchus;

        public BarinasuchusSnapGoal(Barinasuchus barinasuchus) {
            super(barinasuchus, 60, 3, false, false);
            this.barinasuchus = barinasuchus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.barinasuchus.snapCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.barinasuchus.snapCooldown();
        }
    }

    private static class BarinasuchusShakeGoal
    extends IdleAnimationGoal {
        private final Barinasuchus barinasuchus;

        public BarinasuchusShakeGoal(Barinasuchus barinasuchus) {
            super(barinasuchus, 60, 2, false);
            this.barinasuchus = barinasuchus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.barinasuchus.shakeCooldown == 0 && !this.barinasuchus.isSitting();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.barinasuchus.shakeCooldown();
        }
    }

    private static class BarinasuchusYawnGoal
    extends IdleAnimationGoal {
        private final Barinasuchus barinasuchus;

        public BarinasuchusYawnGoal(Barinasuchus barinasuchus) {
            super(barinasuchus, 80, 1, false, false);
            this.barinasuchus = barinasuchus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.barinasuchus.yawnCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.barinasuchus.yawnCooldown();
        }
    }

    private static class BarinasuchusAttackGoal
    extends AttackGoal {
        protected final Barinasuchus barinasuchus;

        public BarinasuchusAttackGoal(Barinasuchus barinasuchus) {
            super(barinasuchus);
            this.barinasuchus = barinasuchus;
        }

        public void m_8037_() {
            LivingEntity target = this.barinasuchus.m_5448_();
            if (target != null) {
                double distance = this.barinasuchus.m_20280_((Entity)target);
                this.barinasuchus.m_21391_((Entity)this.barinasuchus.m_5448_(), 30.0f, 30.0f);
                this.barinasuchus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
                if (this.barinasuchus.getAttackState() == 1) {
                    this.barinasuchus.m_21573_().m_5624_((Entity)target, 1.5);
                    this.tickBite();
                } else {
                    this.barinasuchus.m_21573_().m_5624_((Entity)target, 1.8);
                    if (distance <= this.getAttackReachSqr(target) && this.barinasuchus.attackCooldown == 0) {
                        this.barinasuchus.setAttackState(1);
                    }
                }
            }
        }

        protected void tickBite() {
            ++this.timer;
            LivingEntity target = this.barinasuchus.m_5448_();
            if (this.timer == 1) {
                this.barinasuchus.m_20124_(UP2Poses.ATTACKING.get());
            }
            if (this.timer == 7) {
                this.barinasuchus.m_5496_((SoundEvent)UP2SoundEvents.BARINASUCHUS_ATTACK.get(), 1.0f, 0.9f + this.barinasuchus.m_217043_().m_188501_() * 0.2f);
            }
            if (this.timer == 11 && (double)this.barinasuchus.m_20270_((Entity)target) < this.getAttackReachSqr(target)) {
                this.barinasuchus.m_7327_((Entity)target);
                this.barinasuchus.m_6674_(InteractionHand.MAIN_HAND);
            }
            if (this.timer > 15) {
                this.timer = 0;
                this.barinasuchus.setAttackState(0);
            }
        }

        @Override
        protected double getAttackReachSqr(LivingEntity target) {
            return this.mob.m_20205_() * 1.4f * this.mob.m_20205_() * 1.4f + target.m_20205_();
        }
    }
}


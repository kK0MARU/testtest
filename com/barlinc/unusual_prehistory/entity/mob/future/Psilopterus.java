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
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.future;

import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PackAnimalNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.ButtonPressingMob;
import com.barlinc.unusual_prehistory.entity.utils.ChestLootingMob;
import com.barlinc.unusual_prehistory.entity.utils.LeverPullingMob;
import com.barlinc.unusual_prehistory.entity.utils.PackAnimal;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import java.util.function.Predicate;
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
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Psilopterus
extends PrehistoricMob
implements PackAnimal,
ButtonPressingMob,
LeverPullingMob,
ChestLootingMob {
    private static final EntityDataAccessor<Boolean> PACK_LEADER = SynchedEntityData.m_135353_(Psilopterus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private Psilopterus priorPackMember;
    private Psilopterus afterPackMember;
    private int pushButtonCooldown = 0;
    private int pullLeverCooldown = 0;
    public final AnimationState swimAnimationState = new AnimationState();
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();
    public final AnimationState kickAnimationState = new AnimationState();
    public final AnimationState pokeAnimationState = new AnimationState();
    public final AnimationState dig1AnimationState = new AnimationState();
    public final AnimationState dig2AnimationState = new AnimationState();
    public final AnimationState preen1AnimationState = new AnimationState();
    public final AnimationState preen2AnimationState = new AnimationState();
    private int attackTicks;
    private int kickTicks;
    private int pokeTicks;
    private int digCooldown = 1500 + this.m_217043_().m_188503_(1600);
    private int preenCooldown = 1200 + this.m_217043_().m_188503_(1400);

    public Psilopterus(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 12.0).m_22268_(Attributes.f_22281_, 5.0).m_22268_(Attributes.f_22279_, (double)0.28f);
    }

    @Override
    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        NoSpinGroundPathNavigation navigation = new NoSpinGroundPathNavigation((Mob)this, level);
        navigation.m_26477_(true);
        navigation.m_148214_(true);
        return navigation;
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions size) {
        return size.f_20378_ * 0.9f;
    }

    public int m_6056_() {
        return super.m_6056_() + 10;
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

    public boolean m_5829_() {
        return false;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.PSILOPTERUS_FOOD);
    }

    public boolean m_20039_(@NotNull BlockPos pos, BlockState blockState) {
        return (!(blockState.m_60734_() instanceof DoorBlock) || (Boolean)blockState.m_61143_((Property)DoorBlock.f_52727_) == false) && super.m_20039_(pos, blockState);
    }

    @Override
    public void pressButton() {
        this.m_20124_(UP2Poses.POKING.get());
    }

    @Override
    public int getPushButtonCooldown() {
        return this.pushButtonCooldown;
    }

    @Override
    public void setPushButtonCooldown(int cooldown) {
        this.pushButtonCooldown = cooldown;
    }

    @Override
    public void pullLever() {
        this.m_20124_(UP2Poses.POKING.get());
    }

    @Override
    public int getPullLeverCooldown() {
        return this.pullLeverCooldown;
    }

    @Override
    public void setPullLeverCooldown(int cooldown) {
        this.pullLeverCooldown = cooldown;
    }

    @Override
    public boolean shouldLootItem(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.PSILOPTERUS_FOOD);
    }

    @Override
    public void startOpeningChest() {
        if (this.m_20089_() == Pose.STANDING) {
            this.m_20124_(UP2Poses.POKING.get());
        }
    }

    @Override
    public boolean openChest() {
        return this.m_20089_() == UP2Poses.POKING.get() && this.pokeTicks == 10;
    }

    @Override
    public Vec3 getEepyParticleVec() {
        return new Vec3(0.0, 0.0, (double)(-this.m_20205_() * 1.1f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    @Override
    public void m_8119_() {
        Player player;
        super.m_8119_();
        LivingEntity target = this.m_5448_();
        if (target != null && target.m_6084_() && (!(target instanceof Player) || !(player = (Player)target).m_7500_()) && this.isPackLeader()) {
            PackAnimal leader = this;
            while (leader.getAfterPackMember() != null) {
                if (((PrehistoricMob)((Object)(leader = leader.getAfterPackMember()))).m_7307_((Entity)target)) continue;
                ((Psilopterus)leader).m_6710_(target);
            }
        }
        if (!this.m_9236_().f_46443_) {
            if (this.pushButtonCooldown > 0) {
                --this.pushButtonCooldown;
            }
            if (this.pullLeverCooldown > 0) {
                --this.pullLeverCooldown;
            }
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.attackTicks > 0) {
            --this.attackTicks;
        }
        if (this.kickTicks > 0) {
            --this.kickTicks;
        }
        if (this.pokeTicks > 0) {
            --this.pokeTicks;
        }
        if (this.attackTicks == 0 && this.m_20089_() == UP2Poses.ATTACKING.get()) {
            this.m_20124_(Pose.STANDING);
        }
        if (this.kickTicks == 0 && this.m_20089_() == UP2Poses.KICKING.get()) {
            this.m_20124_(Pose.STANDING);
        }
        if (this.pokeTicks == 0 && this.m_20089_() == UP2Poses.POKING.get()) {
            this.m_20124_(Pose.STANDING);
        }
        if (this.digCooldown > 0) {
            --this.digCooldown;
        }
        if (this.preenCooldown > 0) {
            --this.preenCooldown;
        }
    }

    @Override
    public void setupAnimationStates() {
        if (this.attackTicks == 0 && (this.attack1AnimationState.m_216984_() || this.attack2AnimationState.m_216984_())) {
            this.attack1AnimationState.m_216973_();
            this.attack2AnimationState.m_216973_();
        }
        if (this.kickTicks == 0 && this.kickAnimationState.m_216984_()) {
            this.kickAnimationState.m_216973_();
        }
        if (this.pokeTicks == 0 && this.pokeAnimationState.m_216984_()) {
            this.pokeAnimationState.m_216973_();
        }
        this.idleAnimationState.m_246184_(this.canPlayIdleAnimation() && !this.m_20069_(), this.f_19797_);
        this.swimAnimationState.m_246184_(this.canPlayIdleAnimation() && this.m_20069_(), this.f_19797_);
    }

    private boolean canPlayIdleAnimation() {
        return this.getIdleState() != 1 && this.getIdleState() != 2 && this.m_20089_() != UP2Poses.KICKING.get();
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
                this.attackTicks = 10;
            } else if (this.m_20089_() == UP2Poses.KICKING.get()) {
                this.kickAnimationState.m_216977_(this.f_19797_);
                this.kickTicks = 30;
            } else if (this.m_20089_() == UP2Poses.POKING.get()) {
                this.pokeAnimationState.m_216977_(this.f_19797_);
                this.pokeTicks = 20;
            } else if (this.m_20089_() == Pose.STANDING) {
                this.attack1AnimationState.m_216973_();
                this.attack2AnimationState.m_216973_();
                this.kickAnimationState.m_216973_();
                this.pokeAnimationState.m_216973_();
            }
        }
        super.m_7350_(accessor);
    }

    @Override
    public void m_7822_(byte id) {
        switch (id) {
            case 67: {
                if (this.m_217043_().m_188499_()) {
                    this.dig1AnimationState.m_216977_(this.f_19797_);
                    break;
                }
                this.dig2AnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 68: {
                this.dig1AnimationState.m_216973_();
                this.dig2AnimationState.m_216973_();
                break;
            }
            case 69: {
                if (this.m_217043_().m_188499_()) {
                    this.preen1AnimationState.m_216977_(this.f_19797_);
                    break;
                }
                this.preen2AnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 70: {
                this.preen1AnimationState.m_216973_();
                this.preen2AnimationState.m_216973_();
                break;
            }
            default: {
                super.m_7822_(id);
            }
        }
    }

    protected void digCooldown() {
        this.digCooldown = 1500 + this.m_217043_().m_188503_(1600);
    }

    protected void preenCooldown() {
        this.preenCooldown = 1200 + this.m_217043_().m_188503_(1400);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1 || this.getIdleState() == 2;
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(PACK_LEADER, (Object)false);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128379_("PackLeader", this.isPackLeader());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setPackLeader(compoundTag.m_128471_("PackLeader"));
    }

    public boolean isPackLeader() {
        return (Boolean)this.f_19804_.m_135370_(PACK_LEADER);
    }

    public void setPackLeader(boolean packLeader) {
        this.f_19804_.m_135381_(PACK_LEADER, (Object)packLeader);
    }

    @Override
    public PackAnimal getPriorPackMember() {
        return this.priorPackMember;
    }

    @Override
    public PackAnimal getAfterPackMember() {
        return this.afterPackMember;
    }

    @Override
    public void setPriorPackMember(PackAnimal animal) {
        this.priorPackMember = (Psilopterus)animal;
    }

    @Override
    public void setAfterPackMember(PackAnimal animal) {
        this.afterPackMember = (Psilopterus)animal;
    }

    @Override
    public boolean isValidLeader(PackAnimal packLeader) {
        return packLeader instanceof Psilopterus && ((Psilopterus)packLeader).m_6084_() && ((Psilopterus)packLeader).isPackLeader();
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        Psilopterus psilopterus = (Psilopterus)((EntityType)UP2Entities.PSILOPTERUS.get()).m_20615_((Level)level);
        psilopterus.setPackLeader(this.isPackLeader());
        return psilopterus;
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.PSILOPTERUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.PSILOPTERUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.PSILOPTERUS_DEATH.get();
    }

    public int m_8100_() {
        return 130;
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag compoundTag) {
        this.setPackLeader(this.m_217043_().m_188503_(4) == 0);
        return super.m_6518_(level, difficulty, spawnType, spawnData, compoundTag);
    }

    public static boolean canSpawn(EntityType<Psilopterus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.PSILOPTERUS_SPAWNABLE_ON) && Psilopterus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class PsilopterusPreenGoal
    extends IdleAnimationGoal {
        private final Psilopterus psilopterus;

        public PsilopterusPreenGoal(Psilopterus psilopterus) {
            super(psilopterus, 80, 2);
            this.psilopterus = psilopterus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.psilopterus.preenCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.psilopterus.preenCooldown();
        }
    }

    private static class PsilopterusDigGoal
    extends IdleAnimationGoal {
        private final Psilopterus psilopterus;

        public PsilopterusDigGoal(Psilopterus psilopterus) {
            super(psilopterus, 60, 1);
            this.psilopterus = psilopterus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.psilopterus.digCooldown == 0 && this.psilopterus.m_9236_().m_8055_(this.psilopterus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.PSILOPTERUS_DIGGING_BLOCKS);
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.psilopterus.digCooldown();
        }

        @Override
        public void m_8037_() {
            super.m_8037_();
            if (this.timer % 6 == 0 && this.timer < 50 && this.timer > 20) {
                this.spawnEffectsAtBlock(this.psilopterus.m_20183_().m_7495_());
                this.psilopterus.m_5496_(this.psilopterus.m_9236_().m_8055_(this.psilopterus.m_20183_().m_7495_()).m_60827_().m_56778_(), 0.3f, 0.8f + this.psilopterus.m_217043_().m_188501_() * 0.25f);
            }
        }

        public void spawnEffectsAtBlock(BlockPos blockPos) {
            float radius = 0.3f;
            for (int i1 = 0; i1 < 3; ++i1) {
                double motionX = this.psilopterus.m_217043_().m_188583_() * 0.07;
                double motionY = this.psilopterus.m_217043_().m_188583_() * 0.07;
                double motionZ = this.psilopterus.m_217043_().m_188583_() * 0.07;
                float angle = (float)(0.0174532925 * (double)this.psilopterus.f_20883_ + (double)i1);
                double extraX = radius * Mth.m_14031_((float)((float)Math.PI + angle));
                double extraY = 0.8f;
                double extraZ = radius * Mth.m_14089_((float)angle);
                BlockState state = this.psilopterus.m_9236_().m_8055_(blockPos);
                ((ServerLevel)this.psilopterus.m_9236_()).m_8767_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, state), (double)blockPos.m_123341_() + 0.5 + extraX, (double)blockPos.m_123342_() + 0.5 + extraY, (double)blockPos.m_123343_() + 0.5 + extraZ, 1, motionX, motionY, motionZ, 1.0);
            }
        }
    }

    private static class PsilopterusNearestAttackableTargetGoal<T extends LivingEntity>
    extends PackAnimalNearestAttackableTargetGoal<T> {
        protected final Psilopterus psilopterus;

        public PsilopterusNearestAttackableTargetGoal(Psilopterus psilopterus, Class<T> targetClass, int interval, boolean mustSee, boolean mustReach, @Nullable Predicate<LivingEntity> entityPredicate, int packSizeRequired) {
            super(psilopterus, targetClass, interval, mustSee, mustReach, entityPredicate, packSizeRequired);
            this.psilopterus = psilopterus;
        }

        public void m_8056_() {
            super.m_8056_();
            if (this.psilopterus.isPackLeader()) {
                this.psilopterus.m_5496_((SoundEvent)UP2SoundEvents.PSILOPTERUS_CALL.get(), 3.0f, 0.9f + this.psilopterus.m_217043_().m_188501_() * 0.25f);
            }
        }

        @Override
        public boolean m_8036_() {
            if (super.m_8036_()) {
                return this.packAnimal.getPackSize() >= this.packSizeRequired && this.psilopterus.isPackLeader();
            }
            return false;
        }
    }
}


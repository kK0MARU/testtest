/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.GameEventTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
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
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.util.LandRandomPos
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.DynamicGameEventListener
 *  net.minecraft.world.level.gameevent.EntityPositionSource
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEventListener
 *  net.minecraft.world.level.gameevent.PositionSource
 *  net.minecraft.world.level.gameevent.vibrations.VibrationSystem
 *  net.minecraft.world.level.gameevent.vibrations.VibrationSystem$Data
 *  net.minecraft.world.level.gameevent.vibrations.VibrationSystem$User
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.future;

import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.EnumSet;
import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Therizinosaurus
extends PrehistoricMob
implements VibrationSystem {
    private static final EntityDataAccessor<Boolean> SHAVED = SynchedEntityData.m_135353_(Therizinosaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Boolean> FORAGING_TREE = SynchedEntityData.m_135353_(Therizinosaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Integer> ANGER_LEVEL = SynchedEntityData.m_135353_(Therizinosaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Integer> ANGER_TIME = SynchedEntityData.m_135353_(Therizinosaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private final TherizinosaurusVibrationUser vibrationUser;
    private final DynamicGameEventListener<TherizinosaurusVibrationListener> loudVibrationListener;
    private final VibrationSystem.Data vibrationData;
    public int slashCooldown = 0;
    public int vibrationCooldown = 0;
    public final SmoothAnimationState attack1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState forageLowAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState forageHighAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState shakeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState stretchAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState alert1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState alert2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState roarAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState angryAnimationState = new SmoothAnimationState();
    public int attackTicks;
    private int alertTicks;
    private int foragingTicks;
    private int roarTicks;
    private int shakeCooldown = 1200 + this.m_217043_().m_188503_(1200);
    private int stretchCooldown = 1400 + this.m_217043_().m_188503_(1400);

    public Therizinosaurus(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
        this.m_274367_(1.1f);
        this.vibrationUser = new TherizinosaurusVibrationUser(this);
        this.vibrationData = new VibrationSystem.Data();
        this.loudVibrationListener = new DynamicGameEventListener((GameEventListener)new TherizinosaurusVibrationListener(this, this.vibrationUser.m_280010_(), GameEvent.f_238690_.m_157827_()));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 160.0).m_22268_(Attributes.f_22281_, 15.0).m_22268_(Attributes.f_22278_, 1.0).m_22268_(Attributes.f_22279_, (double)0.2f);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.98f;
    }

    @Override
    public double m_20204_() {
        if (this.m_20069_() && this.f_19862_) {
            return super.m_20204_();
        }
        return 0.5 * (double)this.m_20206_();
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

    @NotNull
    public EntityDimensions m_6972_(@NotNull Pose pose) {
        if (this.m_6162_()) {
            return super.m_6972_(pose).m_20390_(0.6f, 0.5f);
        }
        return super.m_6972_(pose);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.THERIZINOSAURUS_FOOD);
    }

    public boolean targetsEverything(Entity entity) {
        return this.getAngerLevel() > 3;
    }

    @Override
    public boolean isEepyTime() {
        return this.m_9236_().m_46461_();
    }

    @Override
    public Vec3 getEepyParticleVec() {
        return new Vec3(0.0, (double)2.3f, (double)(-this.m_20205_() * 0.8f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (!this.m_9236_().f_46443_) {
            if (this.slashCooldown > 0) {
                --this.slashCooldown;
            }
            if (this.vibrationCooldown > 0) {
                --this.vibrationCooldown;
            }
            if (this.getAngerTime() > 0) {
                this.setAngerTime(this.getAngerTime() - 1);
            }
        }
        if (!this.m_9236_().f_46443_ && this.getAngerTime() == 0 && this.getAngerLevel() > 0) {
            this.setAngerLevel(this.getAngerLevel() - 1);
            this.setAngerTime(900 + this.m_217043_().m_188503_(300));
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.m_9236_().f_46443_) {
            if (this.attackTicks > 0) {
                --this.attackTicks;
            }
            if (this.foragingTicks > 0) {
                --this.foragingTicks;
            }
            if (this.alertTicks > 0) {
                --this.alertTicks;
            }
            if (this.roarTicks > 0) {
                --this.roarTicks;
            }
            if (this.attackTicks == 0 && this.m_20089_() == UP2Poses.ATTACKING.get()) {
                this.m_20124_(Pose.STANDING);
            }
            if (this.foragingTicks == 0 && this.m_20089_() == UP2Poses.FORAGING.get()) {
                this.m_20124_(Pose.STANDING);
            }
            if (this.alertTicks == 0 && this.m_20089_() == UP2Poses.ALERTED.get()) {
                this.m_20124_(Pose.STANDING);
            }
            if (this.roarTicks == 0 && this.m_20089_() == UP2Poses.ENRAGED.get()) {
                this.m_20124_(Pose.STANDING);
            }
            if (!this.isEepy()) {
                if (this.shakeCooldown > 0) {
                    --this.shakeCooldown;
                }
                if (this.stretchCooldown > 0) {
                    --this.stretchCooldown;
                }
            }
        }
    }

    @Override
    public void setupAnimationStates() {
        if (this.attackTicks == 0 && (this.attack1AnimationState.m_216984_() || this.attack2AnimationState.m_216984_())) {
            this.attack1AnimationState.m_216973_();
            this.attack2AnimationState.m_216973_();
        }
        if (this.foragingTicks == 0 && (this.forageLowAnimationState.m_216984_() || this.forageHighAnimationState.m_216984_())) {
            this.forageLowAnimationState.m_216973_();
            this.forageHighAnimationState.m_216973_();
        }
        if (this.alertTicks == 0 && (this.alert1AnimationState.m_216984_() || this.alert2AnimationState.m_216984_())) {
            this.alert1AnimationState.m_216973_();
            this.alert2AnimationState.m_216973_();
        }
        if (this.roarTicks == 0 && this.roarAnimationState.m_216984_()) {
            this.roarAnimationState.m_216973_();
        }
        this.idleAnimationState.m_246184_(this.m_20089_() != UP2Poses.ATTACKING.get() && !this.isEepy() && !this.m_20069_() && this.m_20089_() != UP2Poses.FORAGING.get(), this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20069_() && this.m_20089_() != UP2Poses.ATTACKING.get(), this.f_19797_);
        this.attack1AnimationState.m_246184_(this.attack1AnimationState.m_216984_(), this.f_19797_);
        this.attack2AnimationState.m_246184_(this.attack2AnimationState.m_216984_(), this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
        this.angryAnimationState.m_246184_(this.getAngerLevel() > 3, this.f_19797_);
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
                this.attackTicks = 20;
            } else if (this.m_20089_() == UP2Poses.FORAGING.get()) {
                if (this.isForagingTree()) {
                    this.forageHighAnimationState.m_216977_(this.f_19797_);
                } else {
                    this.forageLowAnimationState.m_216977_(this.f_19797_);
                }
                this.foragingTicks = 60;
            } else if (this.m_20089_() == UP2Poses.ALERTED.get()) {
                if (this.m_217043_().m_188499_()) {
                    this.alert1AnimationState.m_216977_(this.f_19797_);
                } else {
                    this.alert2AnimationState.m_216977_(this.f_19797_);
                }
                this.alertTicks = 80;
            } else if (this.m_20089_() == UP2Poses.ENRAGED.get()) {
                this.roarAnimationState.m_216977_(this.f_19797_);
                this.roarTicks = 60;
            } else if (this.m_20089_() == Pose.STANDING) {
                this.attack1AnimationState.m_216973_();
                this.attack2AnimationState.m_216973_();
                this.forageLowAnimationState.m_216973_();
                this.forageHighAnimationState.m_216973_();
                this.roarAnimationState.m_216973_();
            }
        }
        super.m_7350_(accessor);
    }

    @Override
    public void m_7822_(byte id) {
        switch (id) {
            case 67: {
                this.shakeAnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 68: {
                this.shakeAnimationState.m_216973_();
                break;
            }
            case 69: {
                this.stretchAnimationState.m_216977_(this.f_19797_);
                break;
            }
            case 70: {
                this.stretchAnimationState.m_216973_();
                break;
            }
            default: {
                super.m_7822_(id);
            }
        }
    }

    protected void shakeCooldown() {
        this.shakeCooldown = 1200 + this.m_217043_().m_188503_(1200);
    }

    protected void stretchCooldown() {
        this.stretchCooldown = 1400 + this.m_217043_().m_188503_(1400);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 2 || this.m_20089_() == UP2Poses.FORAGING.get() || this.m_20089_() == UP2Poses.ALERTED.get() || this.m_20089_() == UP2Poses.ENRAGED.get();
    }

    @NotNull
    public AABB m_6921_() {
        return this.m_20191_().m_82377_(3.0, 3.0, 3.0);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(SHAVED, (Object)false);
        this.f_19804_.m_135372_(FORAGING_TREE, (Object)false);
        this.f_19804_.m_135372_(ANGER_LEVEL, (Object)0);
        this.f_19804_.m_135372_(ANGER_TIME, (Object)0);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128379_("Shaved", this.isShaved());
        compoundTag.m_128405_("AngerLevel", this.getAngerLevel());
        compoundTag.m_128405_("AngerTime", this.getAngerTime());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setShaved(compoundTag.m_128471_("Shaved"));
        this.setAngerLevel(compoundTag.m_128451_("AngerLevel"));
        this.setAngerTime(compoundTag.m_128451_("AngerTime"));
    }

    public boolean isShaved() {
        return (Boolean)this.f_19804_.m_135370_(SHAVED);
    }

    public void setShaved(boolean shaved) {
        this.f_19804_.m_135381_(SHAVED, (Object)shaved);
    }

    public boolean isForagingTree() {
        return (Boolean)this.f_19804_.m_135370_(FORAGING_TREE);
    }

    public void setForagingTree(boolean foragingTree) {
        this.f_19804_.m_135381_(FORAGING_TREE, (Object)foragingTree);
    }

    public int getAngerLevel() {
        return (Integer)this.f_19804_.m_135370_(ANGER_LEVEL);
    }

    public void setAngerLevel(int anger) {
        this.f_19804_.m_135381_(ANGER_LEVEL, (Object)anger);
    }

    public int getAngerTime() {
        return (Integer)this.f_19804_.m_135370_(ANGER_TIME);
    }

    public void setAngerTime(int angerTime) {
        this.f_19804_.m_135381_(ANGER_TIME, (Object)angerTime);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        Therizinosaurus therizinosaurus = (Therizinosaurus)((EntityType)UP2Entities.THERIZINOSAURUS.get()).m_20615_((Level)level);
        therizinosaurus.setVariant(this.getVariant());
        return therizinosaurus;
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.THERIZINOSAURUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.THERIZINOSAURUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.THERIZINOSAURUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.THERIZINOSAURUS_STEP.get(), this.m_6162_() ? 0.1f : 0.5f, this.m_6162_() ? 1.7f : 1.0f);
    }

    public int m_8100_() {
        return 300;
    }

    public static boolean canSpawn(EntityType<Therizinosaurus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.THERIZINOSAURUS_SPAWNABLE_ON);
    }

    @Override
    public void m_213651_(@NotNull BiConsumer<DynamicGameEventListener<?>, ServerLevel> biConsumer) {
        Level level = this.m_9236_();
        if (level instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)level;
            biConsumer.accept(this.loudVibrationListener, serverLevel);
        }
    }

    @NotNull
    public VibrationSystem.Data m_280002_() {
        return this.vibrationData;
    }

    @NotNull
    public VibrationSystem.User m_280445_() {
        return this.vibrationUser;
    }

    public static boolean isLoudNoise(GameEvent gameEvent, ServerLevel serverLevel, BlockPos blockPos) {
        return gameEvent == GameEvent.f_157812_ || gameEvent == GameEvent.f_223696_ || gameEvent == GameEvent.f_238690_ || gameEvent == GameEvent.f_157792_ && serverLevel.m_8055_(blockPos).m_60713_(Blocks.f_50680_);
    }

    private static class TherizinosaurusVibrationUser
    implements VibrationSystem.User {
        private final Therizinosaurus therizinosaurus;
        private final PositionSource positionSource;

        public TherizinosaurusVibrationUser(Therizinosaurus therizinosaurus) {
            this.therizinosaurus = therizinosaurus;
            this.positionSource = new EntityPositionSource((Entity)therizinosaurus, therizinosaurus.m_20192_());
        }

        public int m_280351_() {
            return 24;
        }

        @NotNull
        public PositionSource m_280010_() {
            return this.positionSource;
        }

        public boolean m_280080_(@NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull GameEvent gameEvent, // Could not load outer class - annotation placement on inner may be incorrect
        @NotNull GameEvent.Context context) {
            if (this.therizinosaurus.m_21525_() || this.therizinosaurus.m_6162_() || this.therizinosaurus.isShaved() || this.therizinosaurus.vibrationCooldown > 0) {
                return false;
            }
            return this.therizinosaurus.m_5448_() != null;
        }

        public void m_280271_(@NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull GameEvent gameEvent, @Nullable Entity entity, @Nullable Entity entity2, float f) {
        }

        @NotNull
        public TagKey<GameEvent> m_280028_() {
            return GameEventTags.f_215855_;
        }
    }

    private static class TherizinosaurusVibrationListener
    implements GameEventListener {
        private final Therizinosaurus therizinosaurus;
        private final PositionSource listenerSource;
        private final int listenerRadius;

        public TherizinosaurusVibrationListener(Therizinosaurus therizinosaurus, PositionSource positionSource, int i) {
            this.therizinosaurus = therizinosaurus;
            this.listenerSource = positionSource;
            this.listenerRadius = i;
        }

        @NotNull
        public PositionSource m_142460_() {
            return this.listenerSource;
        }

        public int m_142078_() {
            return this.listenerRadius;
        }

        public boolean m_214068_(@NotNull ServerLevel serverLevel, @NotNull GameEvent gameEvent, // Could not load outer class - annotation placement on inner may be incorrect
        @NotNull GameEvent.Context context, @NotNull Vec3 vec3) {
            BlockPos blockPos = BlockPos.m_274446_((Position)vec3);
            if (Therizinosaurus.isLoudNoise(gameEvent, serverLevel, blockPos) && this.therizinosaurus.vibrationCooldown == 0 && this.therizinosaurus.getAngerLevel() < 4) {
                if (this.therizinosaurus.getAngerLevel() < 3) {
                    this.therizinosaurus.m_20124_(UP2Poses.ALERTED.get());
                    this.therizinosaurus.setAngerLevel(this.therizinosaurus.getAngerLevel() + 1);
                    this.therizinosaurus.m_5496_((SoundEvent)UP2SoundEvents.THERIZINOSAURUS_NOTICE.get(), 1.0f, 0.9f + this.therizinosaurus.m_217043_().m_188501_() * 0.15f);
                } else {
                    this.therizinosaurus.m_20124_(UP2Poses.ENRAGED.get());
                    this.therizinosaurus.setAngerLevel(this.therizinosaurus.getAngerLevel() + 1);
                    this.therizinosaurus.m_5496_((SoundEvent)UP2SoundEvents.THERIZINOSAURUS_ROAR.get(), 3.0f, 0.9f + this.therizinosaurus.m_217043_().m_188501_() * 0.15f);
                }
                this.therizinosaurus.setAngerTime(900 + serverLevel.m_213780_().m_188503_(300));
                this.therizinosaurus.vibrationCooldown = 85;
                return true;
            }
            return false;
        }
    }

    private static class TherizinosaurusStretchGoal
    extends IdleAnimationGoal {
        private final Therizinosaurus therizinosaurus;

        public TherizinosaurusStretchGoal(Therizinosaurus therizinosaurus) {
            super(therizinosaurus, 100, 2);
            this.therizinosaurus = therizinosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.therizinosaurus.getAngerLevel() < 4 && this.therizinosaurus.stretchCooldown == 0 && !this.therizinosaurus.m_6162_();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.therizinosaurus.stretchCooldown();
        }
    }

    private static class TherizinosaurusShakeGoal
    extends IdleAnimationGoal {
        private final Therizinosaurus therizinosaurus;

        public TherizinosaurusShakeGoal(Therizinosaurus therizinosaurus) {
            super(therizinosaurus, 40, 1, false);
            this.therizinosaurus = therizinosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.therizinosaurus.getAngerLevel() < 4 && this.therizinosaurus.shakeCooldown == 0 && !this.therizinosaurus.m_6162_();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.therizinosaurus.shakeCooldown();
        }
    }

    private static class TherizinosaurusFreakOutGoal
    extends Goal {
        protected final Therizinosaurus therizinosaurus;
        protected double wantedX;
        protected double wantedY;
        protected double wantedZ;

        public TherizinosaurusFreakOutGoal(Therizinosaurus therizinosaurus) {
            this.therizinosaurus = therizinosaurus;
            this.m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean m_8036_() {
            if (this.therizinosaurus.m_20160_() || this.therizinosaurus.m_5448_() != null) {
                return false;
            }
            Vec3 position = this.getPosition();
            if (position == null) {
                return false;
            }
            if (this.therizinosaurus.getAngerLevel() > 3) {
                this.wantedX = position.f_82479_;
                this.wantedY = position.f_82480_;
                this.wantedZ = position.f_82481_;
                return true;
            }
            return false;
        }

        @Nullable
        protected Vec3 getPosition() {
            return LandRandomPos.m_148488_((PathfinderMob)this.therizinosaurus, (int)10, (int)4);
        }

        public boolean m_8045_() {
            return this.therizinosaurus.getAngerLevel() > 3 && !this.therizinosaurus.m_21573_().m_26571_() && this.therizinosaurus.m_5448_() == null;
        }

        public void m_8056_() {
            this.therizinosaurus.m_21573_().m_26519_(this.wantedX, this.wantedY, this.wantedZ, 1.5);
            this.therizinosaurus.setRunning(true);
        }

        public void m_8037_() {
            this.therizinosaurus.m_21563_().m_24950_(this.wantedX, this.wantedY, this.wantedZ, 30.0f, 30.0f);
        }

        public void m_8041_() {
            this.therizinosaurus.setRunning(false);
            this.therizinosaurus.m_21573_().m_26573_();
        }
    }

    private static class TherizinosaurusSleepGoal
    extends SleepingGoal {
        private final Therizinosaurus therizinosaurus;

        public TherizinosaurusSleepGoal(Therizinosaurus therizinosaurus) {
            super(therizinosaurus);
            this.therizinosaurus = therizinosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.therizinosaurus.getAngerLevel() <= 0;
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && this.therizinosaurus.getAngerLevel() <= 0;
        }
    }
}


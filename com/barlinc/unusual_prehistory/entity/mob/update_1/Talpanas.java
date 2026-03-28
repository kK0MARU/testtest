/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.BreedGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.LightLayer
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricSitWhenOrderedToGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.BreedableMob;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Talpanas
extends BreedableMob {
    public static final EntityDataAccessor<Integer> LIGHT_THRESHOLD = SynchedEntityData.m_135353_(Talpanas.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    public final SmoothAnimationState flapAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState peckAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState shakeAnimationState = new SmoothAnimationState();
    private int peckCooldown = 300 + this.m_217043_().m_188503_(300);
    private int shakeCooldown = 240 + this.m_217043_().m_188503_(240);

    public Talpanas(EntityType<? extends BreedableMob> entityType, Level level) {
        super(entityType, level);
        this.m_21441_(BlockPathTypes.WATER, 1.0f);
        this.m_21441_(BlockPathTypes.LAVA, 1.0f);
        this.m_21441_(BlockPathTypes.DANGER_FIRE, 1.0f);
        this.m_21441_(BlockPathTypes.DAMAGE_FIRE, 1.0f);
        this.m_21441_(BlockPathTypes.DANGER_OTHER, 1.0f);
        this.m_21441_(BlockPathTypes.DAMAGE_OTHER, 1.0f);
        this.m_21441_(BlockPathTypes.DAMAGE_CAUTIOUS, 1.0f);
        this.m_21441_(BlockPathTypes.POWDER_SNOW, 1.0f);
        this.m_21441_(BlockPathTypes.DAMAGE_CAUTIOUS, 1.0f);
        this.m_21441_(BlockPathTypes.DAMAGE_CAUTIOUS, 1.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 6.0).m_22268_(Attributes.f_22279_, 0.24);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new PrehistoricSitWhenOrderedToGoal(this));
        this.f_21345_.m_25352_(1, (Goal)new LargePanicGoal(this, 1.5, 10, 4));
        this.f_21345_.m_25352_(2, new PrehistoricAvoidEntityGoal<Player>((PrehistoricMob)this, Player.class, 4.0f, 1.5, EntitySelector.f_20408_::test));
        this.f_21345_.m_25352_(2, new PrehistoricAvoidEntityGoal<LivingEntity>((PrehistoricMob)this, LivingEntity.class, 4.0f, 1.5, entity -> entity.m_6095_().m_204039_(UP2EntityTags.TALPANAS_AVOIDS)));
        this.f_21345_.m_25352_(3, (Goal)new TalpanasSeekShelterGoal(this));
        this.f_21345_.m_25352_(4, (Goal)new BreedGoal((Animal)this, 1.0));
        this.f_21345_.m_25352_(5, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.TALPANAS_FOOD), false));
        this.f_21345_.m_25352_(6, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 3.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(8, (Goal)new SleepingGoal(this));
        this.f_21345_.m_25352_(9, (Goal)new TalpanasPeckGoal(this));
        this.f_21345_.m_25352_(9, (Goal)new TalpanasShakeGoal(this));
    }

    @Override
    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        NoSpinGroundPathNavigation navigation = new NoSpinGroundPathNavigation((Mob)this, level);
        navigation.m_26490_(true);
        return navigation;
    }

    @Override
    public float m_5610_(@NotNull BlockPos pos, @NotNull LevelReader level) {
        return this.getLightPathfindingFavor(pos, level);
    }

    private float getLightPathfindingFavor(BlockPos pos, LevelReader level) {
        if (level.m_45517_(LightLayer.BLOCK, pos) <= this.getLightThreshold() || level.m_45517_(LightLayer.SKY, pos) <= this.getLightThreshold()) {
            return 10.0f;
        }
        return 0.0f;
    }

    protected float m_6431_(@NotNull Pose pose, @NotNull EntityDimensions dimensions) {
        return this.m_6162_() ? dimensions.f_20378_ * 0.85f : dimensions.f_20378_ * 0.92f;
    }

    @Override
    public double m_20204_() {
        return this.m_6162_() ? 0.2 : 0.4;
    }

    public void m_8107_() {
        super.m_8107_();
        Vec3 vec3 = this.m_20184_();
        if (!this.m_20096_() && !this.m_20072_() && vec3.f_82480_ < 0.0) {
            this.m_20256_(vec3.m_82542_(1.0, 0.6, 1.0));
            if (this.m_142319_().m_146945_()) {
                this.m_146850_(GameEvent.f_157815_);
            }
        }
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.refuseToMove() && this.m_20096_()) {
            this.m_21573_().m_26573_();
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        super.m_7023_(travelVec);
    }

    @Override
    public boolean m_142535_(float fallDistance, float multiplier, @NotNull DamageSource source) {
        return false;
    }

    @Override
    public boolean isEepyTime() {
        return this.m_9236_().m_46461_() && this.m_9236_().m_45517_(LightLayer.BLOCK, this.m_20183_()) <= this.getLightThreshold() && !this.m_9236_().m_45527_(this.m_20183_());
    }

    @Override
    public Vec3 getEepyParticleVec() {
        return new Vec3(0.0, (double)0.15f, (double)(-this.m_20205_() * 0.5f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(this.m_20096_() || this.m_20072_() && !this.isEepy(), this.f_19797_);
        this.flapAnimationState.m_246184_(!this.m_20096_() && !this.m_20072_() && !this.isEepy(), this.f_19797_);
        this.peckAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.shakeAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.m_9236_().f_46443_ && !this.isEepy()) {
            if (this.peckCooldown > 0) {
                --this.peckCooldown;
            }
            if (this.shakeCooldown > 0) {
                --this.shakeCooldown;
            }
        }
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1 || this.getIdleState() == 2;
    }

    public boolean m_6673_(DamageSource source) {
        return source.m_276093_(DamageTypes.f_268671_);
    }

    public boolean m_6573_(@NotNull Player player) {
        return true;
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(LIGHT_THRESHOLD, (Object)5);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("LightThreshold", this.getLightThreshold());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setLightThreshold(compoundTag.m_128451_("LightThreshold"));
    }

    public int getLightThreshold() {
        return (Integer)this.f_19804_.m_135370_(LIGHT_THRESHOLD);
    }

    public void setLightThreshold(int threshold) {
        this.f_19804_.m_135381_(LIGHT_THRESHOLD, (Object)threshold);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.TALPANAS_FOOD);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.TALPANAS.get()).m_20615_((Level)serverLevel);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.TALPANAS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.TALPANAS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.TALPANAS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_(SoundEvents.f_11754_, 0.06f, 1.0f);
    }

    public static boolean canSpawn(EntityType<Talpanas> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.TALPANAS_SPAWNABLE_ON);
    }

    private static class TalpanasSeekShelterGoal
    extends Goal {
        protected final Talpanas talpanas;
        private double wantedX;
        private double wantedY;
        private double wantedZ;

        public TalpanasSeekShelterGoal(Talpanas talpanas) {
            this.talpanas = talpanas;
            this.m_7021_(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean m_8036_() {
            if (this.talpanas.m_9236_().m_45517_(LightLayer.BLOCK, this.talpanas.m_20183_()) > this.talpanas.getLightThreshold() || this.talpanas.m_9236_().m_46461_() && this.talpanas.m_9236_().m_45527_(this.talpanas.m_20183_())) {
                return this.setWantedPos();
            }
            return false;
        }

        protected boolean setWantedPos() {
            Vec3 vec3 = this.getHidePos();
            if (vec3 == null) {
                return false;
            }
            this.wantedX = vec3.f_82479_;
            this.wantedY = vec3.f_82480_;
            this.wantedZ = vec3.f_82481_;
            return true;
        }

        public boolean m_8045_() {
            return !this.talpanas.m_21573_().m_26571_();
        }

        public void m_8056_() {
            this.talpanas.m_21573_().m_26519_(this.wantedX, this.wantedY, this.wantedZ, 1.2);
        }

        public void m_8037_() {
            this.talpanas.m_21563_().m_24950_(this.wantedX, this.wantedY, this.wantedZ, 30.0f, 30.0f);
        }

        @Nullable
        protected Vec3 getHidePos() {
            RandomSource randomsource = this.talpanas.m_217043_();
            BlockPos blockpos = this.talpanas.m_20183_();
            for (int i = 0; i < 10; ++i) {
                BlockPos blockpos1 = blockpos.m_7918_(randomsource.m_188503_(20) - 10, randomsource.m_188503_(6) - 3, randomsource.m_188503_(20) - 10);
                if (this.talpanas.m_9236_().m_45517_(LightLayer.BLOCK, blockpos1) > this.talpanas.getLightThreshold() && this.talpanas.m_9236_().m_45527_(blockpos1) || !(this.talpanas.m_21692_(blockpos1) > 0.0f)) continue;
                return Vec3.m_82539_((Vec3i)blockpos1);
            }
            return null;
        }
    }

    private static class TalpanasPeckGoal
    extends IdleAnimationGoal {
        private final Talpanas talpanas;

        public TalpanasPeckGoal(Talpanas talpanas) {
            super(talpanas, 40, 1);
            this.talpanas = talpanas;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.talpanas.shakeCooldown == 0 && this.talpanas.m_9236_().m_8055_(this.talpanas.m_20183_().m_7495_()).m_204336_(UP2BlockTags.TALPANAS_PECKING_BLOCKS);
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.talpanas.shakeCooldown = 240 + this.talpanas.m_217043_().m_188503_(240);
        }
    }

    private static class TalpanasShakeGoal
    extends IdleAnimationGoal {
        private final Talpanas talpanas;

        public TalpanasShakeGoal(Talpanas talpanas) {
            super(talpanas, 20, 2);
            this.talpanas = talpanas;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.talpanas.shakeCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.talpanas.shakeCooldown = 240 + this.talpanas.m_217043_().m_188503_(240);
        }
    }
}


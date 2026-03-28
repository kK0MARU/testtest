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
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
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
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.animal.Bucketable
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.goals.CustomizableRandomSwimGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.EnterWaterGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LeaveWaterGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SemiAquaticRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.ai.navigation.UP2SemiAquaticPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.EnumSet;
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
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Diplocaulus
extends SemiAquaticMob
implements Bucketable {
    public static final EntityDataAccessor<Integer> BURROW_COOLDOWN = SynchedEntityData.m_135353_(Diplocaulus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Boolean> SLIDING = SynchedEntityData.m_135353_(Diplocaulus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.m_135353_(Diplocaulus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Boolean> BURROWED = SynchedEntityData.m_135353_(Diplocaulus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public final SmoothAnimationState swimIdleAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState burrowAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState quirkAnimationState = new SmoothAnimationState();
    private int quirkCooldown = 600 + this.m_217043_().m_188503_(3600);

    public Diplocaulus(EntityType<? extends SemiAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.switchNavigator(true);
        this.m_21441_(BlockPathTypes.WATER, 0.0f);
        this.m_21441_(BlockPathTypes.WATER_BORDER, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22279_, (double)0.2f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new LargePanicGoal(this, 1.6, 10, 4, true));
        this.f_21345_.m_25352_(1, new PrehistoricAvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 10.0f, 1.6, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.DIPLOCAULUS_AVOIDS)));
        this.f_21345_.m_25352_(2, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.DIPLOCAULUS_FOOD), false));
        this.f_21345_.m_25352_(3, (Goal)new DiplocaulusSlideGoal(this, 2.0));
        this.f_21345_.m_25352_(4, (Goal)new CustomizableRandomSwimGoal((PathfinderMob)this, 1.0, 80));
        this.f_21345_.m_25352_(4, (Goal)new SemiAquaticRandomStrollGoal(this, 1.0){

            @Override
            public boolean m_8036_() {
                return super.m_8036_() && !Diplocaulus.this.isSliding();
            }
        });
        this.f_21345_.m_25352_(5, (Goal)new LeaveWaterGoal(this, 1.0, 1500, 800));
        this.f_21345_.m_25352_(5, (Goal)new EnterWaterGoal(this, 1.0, 800));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(7, (Goal)new DiplocaulusBurrowGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new DiplocaulusQuirkGoal(this));
    }

    protected void switchNavigator(boolean onLand) {
        if (onLand) {
            this.f_21342_ = new PrehistoricMoveControl(this);
            this.f_21365_ = new PrehistoricLookControl(this);
            this.f_21344_ = new NoSpinGroundPathNavigation((Mob)this, this.m_9236_());
            this.isLandNavigator = true;
        } else {
            this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 85, 10, 0.34f, 1.0f, false);
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

    @Override
    public float m_5610_(@NotNull BlockPos pos, @NotNull LevelReader level) {
        if (!this.m_20072_() && level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.DIPLOCAULUS_PREFERRED_WALKING_BLOCKS)) {
            return 10.0f;
        }
        return super.m_5610_(pos, level);
    }

    public float getStepHeight() {
        return this.isSliding() || this.isRunning() ? 1.0f : 0.6f;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.DIPLOCAULUS_FOOD);
    }

    @Override
    public boolean m_6094_() {
        return !this.isBurrowed();
    }

    public void m_7324_(@NotNull Entity entity) {
        if (!this.isBurrowed()) {
            super.m_7324_(entity);
        }
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
        if (this.isBurrowed() && this.m_20072_() || !this.m_20096_()) {
            this.setBurrowed(false);
        }
        if (this.isSliding() && !this.m_20072_() && this.m_20184_().m_165924_() > 0.05) {
            for (int i = 0; i < 1; ++i) {
                double velocityX = this.f_19796_.m_188583_() * 0.15;
                double velocityY = this.f_19796_.m_188583_() * 0.15;
                double velocityZ = this.f_19796_.m_188583_() * 0.15;
                this.m_9236_().m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, this.m_20075_()), this.m_20208_(1.0), this.m_20187_() - 0.5, this.m_20262_(1.0) - 0.75, velocityX, velocityY, velocityZ);
            }
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.m_20072_() && !this.isBurrowed(), this.f_19797_);
        this.swimIdleAnimationState.m_246184_(this.m_20072_() && !this.isBurrowed(), this.f_19797_);
        this.burrowAnimationState.m_246184_(this.isBurrowed(), this.f_19797_);
        this.quirkAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.getBurrowCooldown() > 0) {
            this.setBurrowCooldown(this.getBurrowCooldown() - 1);
        }
        if (this.quirkCooldown > 0) {
            --this.quirkCooldown;
        }
    }

    protected void quirkCooldown() {
        this.quirkCooldown = 600 + this.m_217043_().m_188503_(3600);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.isBurrowed();
    }

    @Override
    protected void m_7880_(float distance) {
        if (distance > 5.0f && this.isBurrowed()) {
            this.setBurrowed(false);
        }
    }

    @Override
    protected void m_6475_(@NotNull DamageSource source, float amount) {
        this.setBurrowed(false);
        super.m_6475_(source, amount);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(BURROW_COOLDOWN, (Object)(800 + this.m_217043_().m_188503_(800)));
        this.f_19804_.m_135372_(SLIDING, (Object)false);
        this.f_19804_.m_135372_(FROM_BUCKET, (Object)false);
        this.f_19804_.m_135372_(BURROWED, (Object)false);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("BurrowCooldown", this.getBurrowCooldown());
        compoundTag.m_128379_("FromBucket", this.m_27487_());
        compoundTag.m_128379_("Burrowed", this.isBurrowed());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setBurrowCooldown(compoundTag.m_128451_("BurrowCooldown"));
        this.m_27497_(compoundTag.m_128471_("FromBucket"));
        this.setBurrowed(compoundTag.m_128471_("Burrowed"));
    }

    public boolean isBurrowed() {
        return (Boolean)this.f_19804_.m_135370_(BURROWED);
    }

    public void setBurrowed(boolean burrowed) {
        this.f_19804_.m_135381_(BURROWED, (Object)burrowed);
    }

    public int getBurrowCooldown() {
        return (Integer)this.f_19804_.m_135370_(BURROW_COOLDOWN);
    }

    public void setBurrowCooldown(int cooldown) {
        this.f_19804_.m_135381_(BURROW_COOLDOWN, (Object)cooldown);
    }

    public void burrowCooldown() {
        this.f_19804_.m_135381_(BURROW_COOLDOWN, (Object)(800 + this.m_217043_().m_188503_(800)));
    }

    public boolean isSliding() {
        return (Boolean)this.f_19804_.m_135370_(SLIDING);
    }

    public void setSliding(boolean sliding) {
        this.f_19804_.m_135381_(SLIDING, (Object)sliding);
    }

    protected boolean isSlideableBlockBelow() {
        return this.m_9236_().m_8055_(this.m_20183_().m_7495_()).m_204336_(UP2BlockTags.DIPLOCAULUS_SLIDING_BLOCKS) || this.m_9236_().m_8055_(this.m_20183_()).m_204336_(UP2BlockTags.DIPLOCAULUS_SLIDING_BLOCKS);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.DIPLOCAULUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.DIPLOCAULUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.DIPLOCAULUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        if (this.isSliding()) {
            super.m_7355_(pos, state);
        } else {
            this.m_5496_((SoundEvent)UP2SoundEvents.DIPLOCAULUS_STEP.get(), 0.15f, 1.0f);
        }
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        Diplocaulus diplocaulus = (Diplocaulus)((EntityType)UP2Entities.DIPLOCAULUS.get()).m_20615_((Level)level);
        if (diplocaulus != null) {
            diplocaulus.setVariant(this.getVariant());
        }
        return diplocaulus;
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
    }

    public void m_142278_(@NotNull CompoundTag compoundTag) {
        Bucketable.m_148825_((Mob)this, (CompoundTag)compoundTag);
        if (compoundTag.m_128425_("BucketVariantTag", 3)) {
            this.setVariant(compoundTag.m_128451_("BucketVariantTag"));
        }
        this.m_146762_(compoundTag.m_128451_("Age"));
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        return Bucketable.m_148828_((Player)player, (InteractionHand)hand, (LivingEntity)this).orElse(super.m_6071_(player, hand));
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.DIPLOCAULUS_BUCKET.get());
    }

    @Override
    public int getVariantCount() {
        return DiplocaulusVariant.values().length;
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        spawnGroupData = super.m_6518_(level, difficulty, spawnType, spawnGroupData, compoundTag);
        if (spawnType == MobSpawnType.BUCKET && compoundTag != null && compoundTag.m_128425_("BucketVariantTag", 3)) {
            this.setVariant(compoundTag.m_128451_("BucketVariantTag"));
        } else {
            this.setVariant(this.f_19796_.m_188503_(DiplocaulusVariant.values().length));
        }
        return spawnGroupData;
    }

    public static boolean canSpawn(EntityType<Diplocaulus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.DIPLOCAULUS_SPAWNABLE_ON) && Diplocaulus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class DiplocaulusSlideGoal
    extends Goal {
        protected final Diplocaulus diplocaulus;
        protected double wantedX;
        protected double wantedY;
        protected double wantedZ;
        protected final double speedModifier;

        public DiplocaulusSlideGoal(Diplocaulus diplocaulus, double speedModifier) {
            this.diplocaulus = diplocaulus;
            this.speedModifier = speedModifier;
            this.m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean m_8036_() {
            if (this.diplocaulus.m_20160_() || this.diplocaulus.m_21691_() || this.diplocaulus.m_20072_() && !this.diplocaulus.isSlideableBlockBelow()) {
                return false;
            }
            if (this.diplocaulus.m_21216_() >= 100) {
                return false;
            }
            if (this.diplocaulus.m_217043_().m_188503_(DiplocaulusSlideGoal.m_186073_((int)120)) != 0) {
                return false;
            }
            Vec3 vec3 = this.getPosition();
            if (vec3 == null) {
                return false;
            }
            this.wantedX = vec3.f_82479_;
            this.wantedY = vec3.f_82480_;
            this.wantedZ = vec3.f_82481_;
            return true;
        }

        public void m_8037_() {
            this.diplocaulus.m_21563_().m_24950_(this.wantedX, this.wantedY, this.wantedZ, 30.0f, 30.0f);
        }

        @Nullable
        protected Vec3 getPosition() {
            return DefaultRandomPos.m_148403_((PathfinderMob)this.diplocaulus, (int)20, (int)1);
        }

        public boolean m_8045_() {
            return !this.diplocaulus.m_21573_().m_26571_() && !this.diplocaulus.m_20160_() && !this.diplocaulus.m_20072_() && this.diplocaulus.isSlideableBlockBelow();
        }

        public void m_8056_() {
            this.diplocaulus.setSliding(true);
            this.diplocaulus.m_21573_().m_26519_(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
        }

        public void m_8041_() {
            this.diplocaulus.setSliding(false);
            this.diplocaulus.m_21573_().m_26573_();
        }
    }

    private static class DiplocaulusBurrowGoal
    extends Goal {
        private final Diplocaulus diplocaulus;

        public DiplocaulusBurrowGoal(Diplocaulus diplocaulus) {
            this.diplocaulus = diplocaulus;
        }

        public boolean m_8036_() {
            return !this.diplocaulus.m_20069_() && this.diplocaulus.getBurrowCooldown() == 0 && !this.diplocaulus.m_21523_() && this.diplocaulus.m_20096_() && this.diplocaulus.m_21188_() == null && this.isBurrowBlock();
        }

        public boolean m_8045_() {
            return !this.diplocaulus.m_20069_() && !this.diplocaulus.m_21523_() && this.diplocaulus.m_20096_();
        }

        public void m_8056_() {
            if (this.diplocaulus.isBurrowed()) {
                this.diplocaulus.burrowCooldown();
                this.diplocaulus.setBurrowed(false);
            } else {
                this.diplocaulus.burrowCooldown();
                this.diplocaulus.setBurrowed(true);
            }
        }

        protected boolean isBurrowBlock() {
            return this.diplocaulus.m_9236_().m_8055_(this.diplocaulus.m_20183_()).m_204336_(UP2BlockTags.DIPLOCAULUS_BURROWING_BLOCKS) || this.diplocaulus.m_9236_().m_8055_(this.diplocaulus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.DIPLOCAULUS_BURROWING_BLOCKS);
        }
    }

    private static class DiplocaulusQuirkGoal
    extends IdleAnimationGoal {
        private final Diplocaulus diplocaulus;

        public DiplocaulusQuirkGoal(Diplocaulus diplocaulus) {
            super(diplocaulus, 60, 1, false, false);
            this.diplocaulus = diplocaulus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.diplocaulus.quirkCooldown == 0 && !this.diplocaulus.isBurrowed();
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && !this.diplocaulus.isBurrowed();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.diplocaulus.quirkCooldown();
        }
    }

    public static enum DiplocaulusVariant {
        BREVIROSTRIS(0),
        MAGNICORNIS(1),
        RECURVATIS(2),
        SALAMANDROIDES(3);

        private final int id;

        private DiplocaulusVariant(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static DiplocaulusVariant byId(int id) {
            if (id < 0 || id >= DiplocaulusVariant.values().length) {
                id = 0;
            }
            return DiplocaulusVariant.values()[id];
        }
    }
}


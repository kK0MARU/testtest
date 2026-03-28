/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MovementEmission
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
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.animal.Bucketable
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_4;

import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricFlyingLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricFlyingMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.goals.FlyingPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_4.PterodactylusFlyAndHangGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinFlyingPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricFlyingMob;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.List;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Pterodactylus
extends PrehistoricFlyingMob
implements Bucketable {
    private static final EntityDataAccessor<Boolean> HANGING = SynchedEntityData.m_135353_(Pterodactylus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.m_135353_(Pterodactylus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private boolean validHangingPos = false;
    private int checkHangingTime;
    private BlockPos prevHangPos;
    public int timeHanging = 0;
    public final SmoothAnimationState hangIdleAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState stretchAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState hangingStretchAnimationState = new SmoothAnimationState();
    private int stretchCooldown = 400 + this.m_217043_().m_188503_(600);

    public Pterodactylus(EntityType<? extends PrehistoricFlyingMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new PrehistoricFlyingMoveControl(this);
        this.f_21365_ = new PrehistoricFlyingLookControl((Mob)this, 85);
        this.m_21441_(BlockPathTypes.LEAVES, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 4.0).m_22268_(Attributes.f_22280_, (double)1.1f).m_22268_(Attributes.f_22279_, (double)0.01f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new FlyingPanicGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new PterodactylusScatterGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.PTERODACTYLUS_FOOD), true));
        this.f_21345_.m_25352_(4, (Goal)new PterodactylusFlyAndHangGoal(this));
        this.f_21345_.m_25352_(5, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(7, (Goal)new PterodactylusStretchGoal(this));
    }

    @Override
    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        return new NoSpinFlyingPathNavigation((Mob)this, level);
    }

    @Override
    public float m_5610_(@NotNull BlockPos pos, @NotNull LevelReader level) {
        return level.m_8055_(pos).m_60795_() ? 10.0f : 0.0f;
    }

    @Override
    public void switchNavigator(boolean onLand) {
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.7f;
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.refuseToMove() || this.m_20096_() || this.isHanging()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        super.m_7023_(travelVec);
    }

    public boolean m_6469_(@NotNull DamageSource source, float amount) {
        Entity entity;
        boolean hurt = super.m_6469_(source, amount);
        if (hurt && source.m_7639_() != null && this.m_6084_() && (entity = source.m_7639_()) instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            double range = 8.0;
            List entities = this.m_9236_().m_45976_(((Object)((Object)this)).getClass(), this.m_20191_().m_82377_(range, range / 2.0, range));
            for (Pterodactylus pterodactylus : entities) {
                pterodactylus.m_6703_(livingEntity);
            }
        }
        return hurt;
    }

    public boolean canHangFrom(BlockPos pos, BlockState state) {
        return state.m_60783_((BlockGetter)this.m_9236_(), pos, Direction.DOWN) && this.m_9236_().m_46859_(pos.m_7495_()) && this.m_9236_().m_46859_(pos.m_6625_(2));
    }

    public BlockPos posAbove() {
        return BlockPos.m_274561_((double)this.m_20185_(), (double)(this.m_20191_().f_82292_ + (double)0.1f), (double)this.m_20189_());
    }

    protected void m_7324_(@NotNull Entity entity) {
    }

    protected void m_6138_() {
    }

    protected // Could not load outer class - annotation placement on inner may be incorrect
    @NotNull Entity.MovementEmission m_142319_() {
        return Entity.MovementEmission.EVENTS;
    }

    protected void m_5841_() {
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (!this.m_9236_().f_46443_) {
            this.tickHanging();
        }
        if (this.m_20072_()) {
            this.setFlying(true);
        }
    }

    private void tickHanging() {
        if (this.isHanging()) {
            BlockPos above = this.posAbove();
            if (this.checkHangingTime-- < 0 || this.f_19796_.m_188501_() < 0.1f || this.prevHangPos != above) {
                this.validHangingPos = this.canHangFrom(above, this.m_9236_().m_8055_(above));
                this.checkHangingTime = 5 + this.f_19796_.m_188503_(5);
                this.prevHangPos = above;
            }
            if (this.validHangingPos) {
                this.m_20256_(this.m_20184_().m_82542_((double)0.1f, (double)0.3f, (double)0.1f).m_82520_(0.0, 0.08, 0.0));
            } else {
                this.setHanging(false);
                this.setFlying(true);
            }
            ++this.timeHanging;
            if (this.isHanging() && this.timeHanging > 800) {
                this.setFlying(true);
                this.setHanging(false);
            }
        } else {
            this.timeHanging = 0;
            this.validHangingPos = false;
            this.prevHangPos = null;
        }
    }

    @Override
    public void tickFlight() {
        if (this.m_29443_() && this.flyProgress < 5.0f) {
            this.flyProgress += 1.0f;
        }
        if (!this.m_29443_() && this.flyProgress > 0.0f) {
            this.flyProgress -= 1.0f;
        }
        if (this.m_29443_()) {
            ++this.flightTicks;
            this.m_20242_(true);
            if (this.groundTicks > 0) {
                this.setFlying(false);
            }
        } else {
            this.flightTicks = 0;
            this.m_20242_(false);
        }
        if (this.groundTicks > 0) {
            --this.groundTicks;
        }
        if (!this.m_9236_().f_46443_) {
            if (this.m_29443_() && this.m_6084_() && !this.m_20160_()) {
                if (this.landingFlag) {
                    this.m_20256_(this.m_20184_().m_82520_(0.0, -0.1, 0.0));
                }
                if (this.f_19862_ && !this.landingFlag) {
                    this.m_20256_(this.m_20184_().m_82520_(0.0, 0.05, 0.0));
                }
            }
            if (this.m_29443_() && this.flightTicks > 40 && this.m_20096_()) {
                this.setFlying(false);
            }
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.stretchCooldown > 0) {
            --this.stretchCooldown;
        }
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1;
    }

    public int getFastFlyingTicks() {
        return 100 + this.m_217043_().m_188503_(50);
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.m_29443_() && !this.isHanging(), this.f_19797_);
        this.hangIdleAnimationState.m_246184_(!this.m_29443_() && this.isHanging(), this.f_19797_);
        this.flyAnimationState.m_246184_(this.m_29443_() && !this.isRunning() && !this.isHanging(), this.f_19797_);
        this.flyFastAnimationState.m_246184_(this.m_29443_() && this.isRunning() && !this.isHanging(), this.f_19797_);
        this.stretchAnimationState.m_246184_(this.getIdleState() == 1 && !this.isHanging(), this.f_19797_);
        this.hangingStretchAnimationState.m_246184_(this.getIdleState() == 1 && this.isHanging(), this.f_19797_);
    }

    protected void stretchCooldown() {
        this.stretchCooldown = 400 + this.m_217043_().m_188503_(600);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.PTERODACTYLUS_FOOD);
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        if (itemstack.m_41720_() == Items.f_42618_ && this.m_6084_()) {
            this.m_5496_(SoundEvents.f_12019_, 0.5f, 1.1f);
            itemstack.m_41774_(1);
            ItemStack pot = new ItemStack((ItemLike)UP2Items.PTERODACTYLUS_POT.get());
            this.m_6872_(pot);
            if (!this.m_9236_().f_46443_) {
                CriteriaTriggers.f_10576_.m_38772_((ServerPlayer)player, pot);
            }
            if (itemstack.m_41619_() && !player.m_7500_()) {
                player.m_21008_(hand, pot);
            } else if (!player.m_150109_().m_36054_(pot)) {
                player.m_36176_(pot, false);
            }
            this.m_146870_();
            return InteractionResult.SUCCESS;
        }
        return super.m_6071_(player, hand);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(HANGING, (Object)false);
        this.f_19804_.m_135372_(FROM_BUCKET, (Object)false);
    }

    public void m_6872_(@NotNull ItemStack bucket) {
        if (this.m_8077_()) {
            bucket.m_41714_(this.m_7770_());
        }
        Bucketable.m_148822_((Mob)this, (ItemStack)bucket);
        CompoundTag compoundTag = bucket.m_41784_();
        compoundTag.m_128405_("BucketVariantTag", this.getVariant());
        compoundTag.m_128405_("Age", this.m_146764_());
        compoundTag.m_128405_("PacifiedTicks", this.getPacifiedTicks());
        compoundTag.m_128379_("FromEgg", this.isFromEgg());
        compoundTag.m_128405_("EatingCooldown", this.getEatCooldown());
    }

    public void m_142278_(@NotNull CompoundTag compoundTag) {
        Bucketable.m_148825_((Mob)this, (CompoundTag)compoundTag);
        if (compoundTag.m_128425_("BucketVariantTag", 3)) {
            this.setVariant(compoundTag.m_128451_("BucketVariantTag"));
        }
        this.m_146762_(compoundTag.m_128451_("Age"));
        this.setPacifiedTicks(compoundTag.m_128451_("PacifiedTicks"));
        this.setFromEgg(compoundTag.m_128471_("FromEgg"));
        this.setEatCooldown(compoundTag.m_128451_("EatingCooldown"));
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.PTERODACTYLUS_POT.get());
    }

    public boolean m_27487_() {
        return (Boolean)this.f_19804_.m_135370_(FROM_BUCKET);
    }

    public void m_27497_(boolean fromBucket) {
        this.f_19804_.m_135381_(FROM_BUCKET, (Object)fromBucket);
    }

    @NotNull
    public SoundEvent m_142623_() {
        return SoundEvents.f_12019_;
    }

    public boolean isHanging() {
        return (Boolean)this.f_19804_.m_135370_(HANGING);
    }

    public void setHanging(boolean hanging) {
        this.f_19804_.m_135381_(HANGING, (Object)hanging);
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.f_12190_;
    }

    @javax.annotation.Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.PTERODACTYLUS_IDLE.get();
    }

    @javax.annotation.Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.PTERODACTYLUS_HURT.get();
    }

    @javax.annotation.Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.PTERODACTYLUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
    }

    public int m_8100_() {
        return 150;
    }

    protected float m_6121_() {
        return 0.8f;
    }

    @javax.annotation.Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        Pterodactylus pterodactylus = (Pterodactylus)((EntityType)UP2Entities.PTERODACTYLUS.get()).m_20615_((Level)level);
        if (pterodactylus != null) {
            pterodactylus.setVariant(this.getVariant());
        }
        return pterodactylus;
    }

    public boolean m_6673_(DamageSource source) {
        return source.m_276093_(DamageTypes.f_268671_);
    }

    @NotNull
    public AABB m_6921_() {
        return this.m_20191_().m_82377_(3.0, 3.0, 3.0);
    }

    public boolean m_6783_(double distance) {
        return Math.sqrt(distance) < 1024.0;
    }

    @Override
    public int getVariantCount() {
        return PterodactylusVariant.values().length;
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

    public static boolean canSpawn(EntityType<Pterodactylus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.PTERODACTYLUS_SPAWNABLE_ON);
    }

    private static class PterodactylusScatterGoal
    extends Goal {
        private final Pterodactylus pterodactylus;

        public PterodactylusScatterGoal(Pterodactylus pterodactylus) {
            this.pterodactylus = pterodactylus;
        }

        public boolean m_8036_() {
            if (this.pterodactylus.m_29443_()) {
                return false;
            }
            long worldTime = this.pterodactylus.m_9236_().m_46467_() % 10L;
            if (this.pterodactylus.m_217043_().m_188503_(10) != 0 && worldTime != 0L) {
                return false;
            }
            AABB aabb = this.pterodactylus.m_20191_().m_82400_(6.0);
            List list = this.pterodactylus.m_9236_().m_6443_(Entity.class, aabb, entity -> entity.m_6095_().m_204039_(UP2EntityTags.TELECREX_AVOIDS) || entity instanceof Player && !((Player)entity).m_7500_());
            return !list.isEmpty();
        }

        public boolean m_8045_() {
            return false;
        }

        public void m_8056_() {
            if (this.pterodactylus.isHanging()) {
                this.pterodactylus.setHanging(false);
            }
            this.pterodactylus.setFlying(true);
            if (this.pterodactylus.m_20096_()) {
                this.pterodactylus.m_20256_(this.pterodactylus.m_20184_().m_82520_(0.0, 0.5, 0.0));
            }
        }
    }

    private static class PterodactylusStretchGoal
    extends IdleAnimationGoal {
        private final Pterodactylus pterodactylus;

        public PterodactylusStretchGoal(Pterodactylus pterodactylus) {
            super(pterodactylus, 40, 1);
            this.pterodactylus = pterodactylus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.pterodactylus.stretchCooldown == 0 && (this.pterodactylus.m_20096_() || this.pterodactylus.isHanging()) && !this.pterodactylus.m_29443_();
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && !this.pterodactylus.m_29443_();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.pterodactylus.stretchCooldown();
        }
    }

    public static enum PterodactylusVariant {
        BROWN(0),
        BANANA(1);

        private final int id;

        private PterodactylusVariant(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static PterodactylusVariant byId(int id) {
            if (id < 0 || id >= PterodactylusVariant.values().length) {
                id = 0;
            }
            return PterodactylusVariant.values()[id];
        }
    }
}


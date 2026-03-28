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
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.FluidTags
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
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.animal.Bucketable
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.EnterWaterGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Kimmeridgebrachypteraeschnidium;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
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
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KimmeridgebrachypteraeschnidiumNymph
extends SemiAquaticMob
implements Bucketable {
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.m_135353_(KimmeridgebrachypteraeschnidiumNymph.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public static int ticksToBeDragonfly = Math.abs(-24000);
    protected int nymphAge;

    public KimmeridgebrachypteraeschnidiumNymph(EntityType<? extends SemiAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.m_21441_(BlockPathTypes.WATER, 0.0f);
        this.m_21441_(BlockPathTypes.WATER_BORDER, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 4.0).m_22268_(Attributes.f_22279_, (double)0.2f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new LargePanicGoal(this, 1.7, 10, 4, true));
        this.f_21345_.m_25352_(1, (Goal)new EnterWaterGoal(this, 1.0, 400));
        this.f_21345_.m_25352_(2, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_FOOD), false));
        this.f_21345_.m_25352_(3, new PrehistoricAvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 6.0f, 1.7, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_AVOIDS)));
        this.f_21345_.m_25352_(3, new PrehistoricAvoidEntityGoal<Player>((PrehistoricMob)this, Player.class, 6.0f, 1.7, true));
        this.f_21345_.m_25352_(4, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(5, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(5, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
    }

    @Override
    @NotNull
    public PathNavigation m_6037_(@NotNull Level level) {
        return new NoSpinGroundPathNavigation((Mob)this, level);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.5f;
    }

    public float getStepHeight() {
        return this.m_20072_() ? 1.0f : 0.6f;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_FOOD);
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        if (this.m_6898_(itemstack)) {
            if (!player.m_150110_().f_35937_) {
                itemstack.m_41774_(1);
            }
            this.increaseNymphAge(AgeableMob.m_216967_((int)this.getTicksLeftUntilAdult()));
            this.m_9236_().m_7106_((ParticleOptions)ParticleTypes.f_123748_, this.m_20208_(1.0), this.m_20187_() + 0.5, this.m_20262_(1.0), 0.0, 0.0, 0.0);
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        return Bucketable.m_148828_((Player)player, (InteractionHand)hand, (LivingEntity)this).orElse(super.m_6071_(player, hand));
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.m_21515_() && this.m_20072_()) {
            this.m_19920_(this.m_6113_(), travelVec);
            Vec3 delta = this.m_20184_();
            this.m_6478_(MoverType.SELF, delta);
            delta = this.f_20899_ || this.f_19862_ ? delta.m_82520_(0.0, (double)0.1f, 0.0) : delta.m_82520_(0.0, (double)-0.05f, 0.0);
            this.m_20256_(delta.m_82542_(0.1, 1.0, 0.1));
        } else {
            super.m_7023_(travelVec);
        }
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (!this.m_9236_().f_46443_) {
            this.setNymphAge(this.nymphAge + 1);
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(this.m_6084_(), this.f_19797_);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(FROM_BUCKET, (Object)false);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("NymphAge", this.nymphAge);
        compoundTag.m_128379_("FromBucket", this.m_27487_());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setNymphAge(compoundTag.m_128451_("NymphAge"));
        this.m_27497_(compoundTag.m_128471_("FromBucket"));
    }

    public int getNymphAge() {
        return this.nymphAge;
    }

    public void increaseNymphAge(int offset) {
        this.setNymphAge(this.nymphAge + offset * 20);
    }

    public void setNymphAge(int age) {
        this.nymphAge = age;
        if (this.nymphAge >= ticksToBeDragonfly) {
            this.becomeDragonfly();
        }
    }

    private void becomeDragonfly() {
        Level level = this.m_9236_();
        if (level instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)level;
            Kimmeridgebrachypteraeschnidium dragonfly = (Kimmeridgebrachypteraeschnidium)((EntityType)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM.get()).m_20615_((Level)serverLevel);
            if (dragonfly != null) {
                dragonfly.m_7678_(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_146908_(), this.m_146909_());
                dragonfly.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(dragonfly.m_20183_()), MobSpawnType.CONVERSION, null, null);
                dragonfly.m_21557_(this.m_21525_());
                if (this.m_8077_()) {
                    dragonfly.m_6593_(this.m_7770_());
                    dragonfly.m_20340_(this.m_20151_());
                }
                dragonfly.m_21530_();
                serverLevel.m_47205_((Entity)dragonfly);
                this.m_146870_();
            }
        }
    }

    private int getTicksLeftUntilAdult() {
        return Math.max(0, ticksToBeDragonfly - this.nymphAge);
    }

    public boolean m_6162_() {
        return false;
    }

    public void m_6863_(boolean baby) {
    }

    protected void m_30232_() {
    }

    public int m_146764_() {
        return 1;
    }

    public void m_146740_(int amount, boolean forced) {
    }

    public void m_146758_(int amount) {
    }

    public void m_146762_(int age) {
    }

    @NotNull
    public MobType m_6336_() {
        return MobType.f_21642_;
    }

    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_HURT.get();
    }

    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_(SoundEvents.f_12422_, 0.05f, 1.8f);
    }

    protected float m_6121_() {
        return 0.5f;
    }

    public boolean m_27487_() {
        return (Boolean)this.f_19804_.m_135370_(FROM_BUCKET);
    }

    public void m_27497_(boolean fromBucket) {
        this.f_19804_.m_135381_(FROM_BUCKET, (Object)fromBucket);
    }

    public void m_6872_(ItemStack bucket) {
        CompoundTag compoundTag = bucket.m_41784_();
        Bucketable.m_148822_((Mob)this, (ItemStack)bucket);
        compoundTag.m_128350_("Health", this.m_21223_());
        if (this.m_8077_()) {
            bucket.m_41714_(this.m_7770_());
        }
        compoundTag.m_128405_("NymphAge", this.getNymphAge());
    }

    public void m_142278_(@NotNull CompoundTag compoundTag) {
        Bucketable.m_148825_((Mob)this, (CompoundTag)compoundTag);
        if (compoundTag.m_128441_("NymphAge")) {
            this.setNymphAge(compoundTag.m_128451_("NymphAge"));
        }
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_BUCKET.get());
    }

    @NotNull
    public SoundEvent m_142623_() {
        return SoundEvents.f_11779_;
    }

    public static boolean canSpawn(EntityType<KimmeridgebrachypteraeschnidiumNymph> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        int seaLevel = level.m_5736_();
        int minHeight = seaLevel - 13;
        return pos.m_123342_() >= minHeight && pos.m_123342_() <= seaLevel && level.m_6425_(pos.m_7495_()).m_205070_(FluidTags.f_13131_) && level.m_8055_(pos.m_7494_()).m_60713_(Blocks.f_49990_);
    }

    @Override
    public boolean m_8023_() {
        return this.getSpawnType() != MobSpawnType.CHUNK_GENERATION && this.getSpawnType() != MobSpawnType.NATURAL || this.isFromEgg();
    }

    @Override
    public boolean m_6785_(double distanceToPlayer) {
        return !this.m_8023_();
    }
}


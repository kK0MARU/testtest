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
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation
 *  net.minecraft.world.entity.animal.Bucketable
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.base;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.NotNull;

public abstract class PrehistoricAquaticMob
extends PrehistoricMob
implements Bucketable {
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.m_135353_(PrehistoricAquaticMob.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public float prevOnLandProgress;
    public float onLandProgress;
    public final SmoothAnimationState swimIdleAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState flopAnimationState = new SmoothAnimationState();

    protected PrehistoricAquaticMob(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
        this.m_21441_(BlockPathTypes.WATER, 0.0f);
    }

    @Override
    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        return new WaterBoundPathNavigation((Mob)this, level);
    }

    public float getDepthPathfindingFavor(BlockPos pos, LevelReader level) {
        int y = pos.m_123342_() + Math.abs(level.m_141937_());
        return 1.0f / (float)(y == 0 ? 1 : y);
    }

    public float getSurfacePathfindingFavor(BlockPos pos, LevelReader level) {
        int y = Math.abs(level.m_151558_()) - pos.m_123342_();
        return 1.0f / (float)(y == 0 ? 1 : y);
    }

    public boolean m_6040_() {
        return true;
    }

    public boolean m_6063_() {
        return false;
    }

    @NotNull
    public MobType m_6336_() {
        return MobType.f_21644_;
    }

    public boolean m_6914_(LevelReader level) {
        return level.m_45784_((Entity)this);
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.f_11760_;
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        this.prevOnLandProgress = this.onLandProgress;
        this.tickFlopping();
    }

    @Override
    public void setupAnimationStates() {
        this.swimIdleAnimationState.m_246184_(this.m_20072_(), this.f_19797_);
        this.flopAnimationState.m_246184_(!this.m_20072_(), this.f_19797_);
    }

    public float flopChance() {
        return 1.0f;
    }

    public boolean shouldFlop() {
        return true;
    }

    public void tickFlopping() {
        if (!this.m_20072_() && this.onLandProgress < 5.0f) {
            this.onLandProgress += 1.0f;
        }
        if (this.m_20072_() && this.onLandProgress > 0.0f) {
            this.onLandProgress -= 1.0f;
        }
        if (!this.m_20069_() && this.m_20096_() && this.m_217043_().m_188501_() < this.flopChance() && this.shouldFlop()) {
            this.m_20256_(this.m_20184_().m_82520_((double)((this.m_217043_().m_188501_() * 2.0f - 1.0f) * 0.2f), 0.5, (double)((this.m_217043_().m_188501_() * 2.0f - 1.0f) * 0.2f)));
            if (this.m_217043_().m_188501_() < 0.3f) {
                this.m_146922_(this.m_217043_().m_188501_() * 360.0f);
            }
            this.m_5496_(this.getFlopSound(), this.m_6121_(), this.m_6100_());
        }
    }

    public void m_6075_() {
        int airSupply = this.m_20146_();
        super.m_6075_();
        this.handleAirSupply(airSupply);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(FROM_BUCKET, (Object)false);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128379_("FromBucket", this.m_27487_());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.m_27497_(compoundTag.m_128471_("FromBucket"));
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

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        if (this.canBucket()) {
            return Bucketable.m_148828_((Player)player, (InteractionHand)hand, (LivingEntity)this).orElse(super.m_6071_(player, hand));
        }
        return super.m_6071_(player, hand);
    }

    public boolean canBucket() {
        return false;
    }

    protected void handleAirSupply(int airSupply) {
        if (this.m_6084_() && !this.m_20072_()) {
            this.m_20301_(airSupply - 1);
            if (this.m_20146_() == -20) {
                this.m_20301_(0);
                this.m_6469_(this.m_269291_().m_269063_(), 2.0f);
            }
        } else {
            this.m_20301_(300);
        }
    }

    public static boolean checkSpawnRules(EntityType<? extends PrehistoricAquaticMob> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        int i = level.m_5736_();
        int j = i - 13;
        return pos.m_123342_() >= j && pos.m_123342_() <= i && level.m_6425_(pos.m_7495_()).m_205070_(FluidTags.f_13131_) && level.m_8055_(pos.m_7494_()).m_60713_(Blocks.f_49990_);
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


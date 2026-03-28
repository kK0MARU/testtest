/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.future;

import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Eryon
extends SemiAquaticMob {
    public Eryon(EntityType<? extends SemiAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.m_21441_(BlockPathTypes.WATER_BORDER, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 4.0).m_22268_(Attributes.f_22279_, (double)0.24f).m_22268_(Attributes.f_22284_, 4.0);
    }

    @Override
    @NotNull
    public PathNavigation m_6037_(@NotNull Level level) {
        return new NoSpinGroundPathNavigation((Mob)this, level);
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.refuseToMove() && this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        if (this.m_21515_() && this.m_20072_()) {
            this.m_19920_(this.m_6113_(), travelVec);
            Vec3 delta = this.m_20184_();
            this.m_6478_(MoverType.SELF, delta);
            delta = delta.m_82490_(0.8);
            delta = this.f_20899_ || this.f_19862_ ? delta.m_82520_(0.0, (double)0.1f, 0.0) : delta.m_82520_(0.0, (double)-0.05f, 0.0);
            this.m_20256_(delta.m_82490_(0.8));
        } else {
            super.m_7023_(travelVec);
        }
    }

    @NotNull
    public MobType m_6336_() {
        return MobType.f_21642_;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.HIBBERTOPTERUS_FOOD);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove();
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.isEepy(), this.f_19797_);
    }

    @Override
    public float getWalkAnimationSpeed() {
        return this.m_6162_() ? 4.0f : 10.0f;
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        super.m_7350_(accessor);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.HIBBERTOPTERUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.HIBBERTOPTERUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.HIBBERTOPTERUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.HIBBERTOPTERUS_STEP.get(), 0.4f, this.getStepPitch());
    }

    protected float m_6059_() {
        return this.f_19788_ + 0.55f;
    }

    private float getStepPitch() {
        return this.m_6162_() ? 1.45f + this.m_217043_().m_188501_() * 0.1f : 0.95f + this.m_217043_().m_188501_() * 0.1f;
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.ERYON.get()).m_20615_((Level)level);
    }

    public static boolean canSpawn(EntityType<Eryon> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.HIBBERTOPTERUS_SPAWNABLE_ON) && Eryon.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }
}


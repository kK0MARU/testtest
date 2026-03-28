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
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MovementEmission
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.base;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AmbientMob
extends PathfinderMob {
    protected static final EntityDataAccessor<Integer> DESPAWN_TIME = SynchedEntityData.m_135353_(AmbientMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);

    protected AmbientMob(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @NotNull
    protected Entity.MovementEmission m_142319_() {
        return Entity.MovementEmission.NONE;
    }

    protected void m_5841_() {
    }

    protected void m_7324_(@NotNull Entity entity) {
    }

    protected void m_6138_() {
    }

    public boolean m_6094_() {
        return false;
    }

    public boolean m_142535_(float fallDistance, float multiplier, @NotNull DamageSource damageSource) {
        return false;
    }

    protected void m_7840_(double y, boolean onGround, @NotNull BlockState state, @NotNull BlockPos pos) {
    }

    public boolean canTrample(@NotNull BlockState state, @NotNull BlockPos pos, float fallDistance) {
        return false;
    }

    public int m_213860_() {
        return 0;
    }

    public boolean m_6149_() {
        return false;
    }

    protected boolean m_6125_() {
        return false;
    }

    protected float m_6121_() {
        return 0.25f;
    }

    public void m_8119_() {
        super.m_8119_();
        if (!this.m_9236_().f_46443_) {
            if (this.getDespawnTime() > 0) {
                this.setDespawnTime(this.getDespawnTime() - 1);
            } else if (this.getDespawnTime() == 0) {
                this.m_146870_();
            }
        } else {
            this.setupAnimationStates();
        }
    }

    public void setupAnimationStates() {
    }

    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(DESPAWN_TIME, (Object)(1200 + this.m_217043_().m_188503_(600)));
    }

    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("DespawnTime", this.getDespawnTime());
    }

    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setDespawnTime(compoundTag.m_128451_("DespawnTime"));
    }

    public int getDespawnTime() {
        return (Integer)this.f_19804_.m_135370_(DESPAWN_TIME);
    }

    public void setDespawnTime(int despawnTime) {
        this.f_19804_.m_135381_(DESPAWN_TIME, (Object)despawnTime);
    }

    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        this.setDespawnTime(1200 + this.m_217043_().m_188503_(600));
        return super.m_6518_(level, difficulty, spawnType, spawnGroupData, compoundTag);
    }
}


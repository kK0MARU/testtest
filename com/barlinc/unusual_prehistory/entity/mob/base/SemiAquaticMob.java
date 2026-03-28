/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.base;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class SemiAquaticMob
extends PrehistoricMob {
    public static final EntityDataAccessor<Integer> TIME_IN_WATER = SynchedEntityData.m_135353_(SemiAquaticMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    public static final EntityDataAccessor<Integer> TIME_ON_LAND = SynchedEntityData.m_135353_(SemiAquaticMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    public boolean isLandNavigator;

    protected SemiAquaticMob(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (this.m_20069_()) {
            this.setTimeInWater(this.getTimeInWater() + 1);
            this.setTimeOnLand(0);
        } else {
            this.setTimeOnLand(this.getTimeOnLand() + 1);
            this.setTimeInWater(0);
        }
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(TIME_IN_WATER, (Object)0);
        this.f_19804_.m_135372_(TIME_ON_LAND, (Object)0);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("TimeInWater", this.getTimeInWater());
        compoundTag.m_128405_("TimeOnLand", this.getTimeOnLand());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setTimeInWater(compoundTag.m_128451_("TimeInWater"));
        this.setTimeOnLand(compoundTag.m_128451_("TimeOnLand"));
    }

    public boolean m_6063_() {
        return false;
    }

    public boolean m_6040_() {
        return true;
    }

    public int getTimeInWater() {
        return (Integer)this.f_19804_.m_135370_(TIME_IN_WATER);
    }

    public void setTimeInWater(int time) {
        this.f_19804_.m_135381_(TIME_IN_WATER, (Object)time);
    }

    public int getTimeOnLand() {
        return (Integer)this.f_19804_.m_135370_(TIME_ON_LAND);
    }

    public void setTimeOnLand(int time) {
        this.f_19804_.m_135381_(TIME_ON_LAND, (Object)time);
    }
}


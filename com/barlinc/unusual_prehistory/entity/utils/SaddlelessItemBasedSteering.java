/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 */
package com.barlinc.unusual_prehistory.entity.utils;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

public class SaddlelessItemBasedSteering {
    private final SynchedEntityData entityData;
    private final EntityDataAccessor<Integer> boostTimeAccessor;
    private boolean boosting;
    private int boostTime;

    public SaddlelessItemBasedSteering(SynchedEntityData entityData, EntityDataAccessor<Integer> dataAccessor) {
        this.entityData = entityData;
        this.boostTimeAccessor = dataAccessor;
    }

    public void onSynced() {
        this.boosting = true;
        this.boostTime = 0;
    }

    public boolean boost(RandomSource random) {
        if (this.boosting) {
            return false;
        }
        this.boosting = true;
        this.boostTime = 0;
        this.entityData.m_135381_(this.boostTimeAccessor, (Object)(random.m_188503_(900) + 200));
        return true;
    }

    public void tickBoost() {
        if (this.boosting && this.boostTime++ > this.boostTimeTotal()) {
            this.boosting = false;
        }
    }

    public float boostFactor() {
        return this.boosting ? 1.0f + 1.15f * Mth.m_14031_((float)((float)this.boostTime / (float)this.boostTimeTotal() * (float)Math.PI)) : 1.0f;
    }

    private int boostTimeTotal() {
        return (Integer)this.entityData.m_135370_(this.boostTimeAccessor);
    }

    public boolean isBoosting() {
        return this.boosting;
    }
}


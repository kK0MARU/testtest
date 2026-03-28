/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.control.LookControl
 */
package com.barlinc.unusual_prehistory.entity.ai.control;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.LookControl;

public class PrehistoricLookControl
extends LookControl {
    protected final PrehistoricMob f_24937_;

    public PrehistoricLookControl(PrehistoricMob mob) {
        super((Mob)mob);
        this.f_24937_ = mob;
    }

    public void m_8128_() {
        if (!this.f_24937_.refuseToLook()) {
            super.m_8128_();
        }
    }
}


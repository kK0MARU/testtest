/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 */
package com.barlinc.unusual_prehistory.entity.ai.control;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.BodyRotationControl;

public class PrehistoricBodyRotationControl
extends BodyRotationControl {
    protected final PrehistoricMob f_24875_;

    public PrehistoricBodyRotationControl(PrehistoricMob mob) {
        super((Mob)mob);
        this.f_24875_ = mob;
    }

    public void m_8121_() {
        if (!this.f_24875_.refuseToLook()) {
            super.m_8121_();
        }
    }
}


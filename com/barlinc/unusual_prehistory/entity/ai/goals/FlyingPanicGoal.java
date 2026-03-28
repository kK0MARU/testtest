/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.ai.goal.Goal
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricFlyingMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class FlyingPanicGoal
extends Goal {
    protected final PrehistoricFlyingMob prehistoricMob;

    public FlyingPanicGoal(PrehistoricFlyingMob mob) {
        this.prehistoricMob = mob;
    }

    public void m_8056_() {
        this.prehistoricMob.setFlying(true);
        if (this.prehistoricMob.m_20096_()) {
            this.prehistoricMob.m_20256_(this.prehistoricMob.m_20184_().m_82520_(0.0, 0.5, 0.0));
        }
    }

    public boolean m_8036_() {
        if (this.prehistoricMob.m_29443_()) {
            return false;
        }
        return this.prehistoricMob.m_21188_() != null;
    }

    public boolean m_8045_() {
        return false;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;

public class LargeBabyPanicGoal
extends LargePanicGoal {
    protected final PrehistoricMob prehistoricMob;

    public LargeBabyPanicGoal(PrehistoricMob mob, double speedModifier, int radius, int height) {
        super(mob, speedModifier, radius, height);
        this.prehistoricMob = mob;
    }

    protected boolean m_202729_() {
        return (this.f_25684_.m_21188_() != null || this.f_25684_.m_203117_() || this.f_25684_.m_6060_()) && this.f_25684_.m_6162_();
    }
}


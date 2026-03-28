/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.ai.goal.Goal
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class RandomSitGoal
extends Goal {
    protected final PrehistoricMob prehistoricMob;

    public RandomSitGoal(PrehistoricMob prehistoricMob) {
        this.prehistoricMob = prehistoricMob;
    }

    public boolean m_8036_() {
        if (this.prehistoricMob.m_21188_() != null) {
            return false;
        }
        if (this.prehistoricMob.m_5448_() != null) {
            return false;
        }
        return !this.prehistoricMob.m_21827_() && !this.prehistoricMob.m_217005_() && !this.prehistoricMob.m_6162_() && !this.prehistoricMob.isEepy() && !this.prehistoricMob.m_20071_() && this.prehistoricMob.getSitCooldown() <= 0 && !this.prehistoricMob.m_21523_() && this.prehistoricMob.m_20096_();
    }

    public boolean m_8045_() {
        return !this.prehistoricMob.m_21827_() && !this.prehistoricMob.m_20071_() && !this.prehistoricMob.m_21523_() && this.prehistoricMob.m_20096_();
    }

    public void m_8056_() {
        if (this.prehistoricMob.isSitting()) {
            this.prehistoricMob.setSitCooldown(6000 + this.prehistoricMob.m_217043_().m_188503_(3000));
            this.prehistoricMob.setSitting(false);
        } else {
            this.prehistoricMob.setSitCooldown(1200 + this.prehistoricMob.m_217043_().m_188503_(2000));
            this.prehistoricMob.setSitting(true);
        }
    }
}


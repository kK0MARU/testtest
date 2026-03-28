/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.ai.goal.Goal
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class SleepingGoal
extends Goal {
    public PrehistoricMob prehistoricMob;

    public SleepingGoal(PrehistoricMob prehistoricMob) {
        this.prehistoricMob = prehistoricMob;
    }

    public boolean m_8036_() {
        return this.prehistoricMob.isEepyTime() && this.prehistoricMob.m_21188_() == null && this.prehistoricMob.m_5448_() == null && !this.prehistoricMob.m_20072_() && !this.prehistoricMob.m_20077_() && this.prehistoricMob.getEepyCooldown() == 0 && !this.prehistoricMob.isSitting() && !this.prehistoricMob.m_6162_() && !this.prehistoricMob.isFollowingOwner();
    }

    public boolean m_8045_() {
        if (!this.prehistoricMob.isEepyTime() || this.prehistoricMob.m_21188_() != null || !super.m_8045_() || this.prehistoricMob.m_5448_() != null || this.prehistoricMob.m_20072_() || this.prehistoricMob.m_20077_() || this.prehistoricMob.isFollowingOwner()) {
            this.m_8041_();
            return false;
        }
        return true;
    }

    public void m_8056_() {
        this.prehistoricMob.f_20900_ = 0.0f;
        this.prehistoricMob.f_20901_ = 0.0f;
        this.prehistoricMob.f_20902_ = 0.0f;
        this.prehistoricMob.m_21573_().m_26573_();
        this.prehistoricMob.setEepy(true);
    }

    public void m_8037_() {
        super.m_8037_();
        this.prehistoricMob.m_21573_().m_26573_();
        if (!this.prehistoricMob.isEepyTime() || this.prehistoricMob.m_21188_() != null || this.prehistoricMob.m_5448_() != null || this.prehistoricMob.m_20072_() || this.prehistoricMob.m_20077_() || this.prehistoricMob.isFollowingOwner()) {
            this.m_8041_();
        }
    }

    public void m_8041_() {
        this.prehistoricMob.setEepyCooldown(100);
        this.prehistoricMob.setEepy(false);
    }
}


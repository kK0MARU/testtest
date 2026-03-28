/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.ai.goal.Goal
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class IdleAnimationGoal
extends Goal {
    protected final PrehistoricMob prehistoricMob;
    protected int timer;
    protected final int animationTime;
    protected final int idleState;
    protected final boolean stopMoving;
    protected final boolean stopIfHurt;
    protected final boolean stopInWater;

    public IdleAnimationGoal(PrehistoricMob prehistoricMob, int animationTime, int idleState) {
        this(prehistoricMob, animationTime, idleState, true, true, true);
    }

    public IdleAnimationGoal(PrehistoricMob prehistoricMob, int animationTime, int idleState, boolean stopMoving) {
        this(prehistoricMob, animationTime, idleState, stopMoving, true, true);
    }

    public IdleAnimationGoal(PrehistoricMob prehistoricMob, int animationTime, int idleState, boolean stopMoving, boolean stopInWater) {
        this(prehistoricMob, animationTime, idleState, stopMoving, true, stopInWater);
    }

    public IdleAnimationGoal(PrehistoricMob prehistoricMob, int animationTime, int idleState, boolean stopMoving, boolean stopIfHurt, boolean stopInWater) {
        this.prehistoricMob = prehistoricMob;
        this.animationTime = animationTime;
        this.idleState = idleState;
        this.stopMoving = stopMoving;
        this.stopIfHurt = stopIfHurt;
        this.stopInWater = stopInWater;
    }

    public boolean m_8036_() {
        if (this.stopIfHurt && this.prehistoricMob.m_21188_() != null) {
            return false;
        }
        if (this.stopMoving && !this.prehistoricMob.m_21573_().m_26571_()) {
            return false;
        }
        if (this.stopInWater && this.prehistoricMob.m_20069_()) {
            return false;
        }
        return this.prehistoricMob.m_6084_() && this.prehistoricMob.getIdleState() == 0 && !this.prehistoricMob.isEepy() && !this.prehistoricMob.isDancing();
    }

    public void m_8056_() {
        this.prehistoricMob.setIdleState(this.idleState);
        this.timer = this.animationTime;
        if (this.stopMoving) {
            this.prehistoricMob.m_21573_().m_26573_();
        }
    }

    public boolean m_8045_() {
        if (this.stopIfHurt && this.prehistoricMob.m_21188_() != null) {
            return false;
        }
        if (this.stopInWater && this.prehistoricMob.m_20069_()) {
            return false;
        }
        return !this.prehistoricMob.isDancing() && !this.prehistoricMob.isEepy() && this.prehistoricMob.m_5448_() == null && this.timer > 0 && this.prehistoricMob.m_6084_() && this.prehistoricMob.getIdleState() == this.idleState;
    }

    public void m_8037_() {
        --this.timer;
        if (this.stopMoving) {
            this.prehistoricMob.m_21573_().m_26573_();
        }
    }

    public void m_8041_() {
        this.prehistoricMob.setIdleState(0);
    }

    public boolean m_183429_() {
        return true;
    }
}


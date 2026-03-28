/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import java.util.EnumSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class PrehistoricSitWhenOrderedToGoal
extends Goal {
    protected final PrehistoricMob tamedMob;

    public PrehistoricSitWhenOrderedToGoal(PrehistoricMob mob) {
        this.tamedMob = mob;
        this.m_7021_(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    public boolean m_8045_() {
        return this.tamedMob.m_21827_();
    }

    public boolean m_8036_() {
        if (!this.tamedMob.m_21824_()) {
            return false;
        }
        if (this.tamedMob.m_20072_()) {
            return false;
        }
        if (!this.tamedMob.m_20096_()) {
            return false;
        }
        LivingEntity livingentity = this.tamedMob.m_269323_();
        if (livingentity == null) {
            return true;
        }
        return !(this.tamedMob.m_20280_((Entity)livingentity) < 144.0 && livingentity.m_21188_() != null || !this.tamedMob.m_21827_());
    }

    public void m_8056_() {
        this.tamedMob.m_21837_(true);
        this.tamedMob.m_21573_().m_26573_();
        this.tamedMob.setSitting(true);
    }

    public void m_8041_() {
        this.tamedMob.m_21837_(false);
        if (this.tamedMob.isSitting() && this.tamedMob.getCommand() != 1) {
            this.tamedMob.setSitting(false);
        }
    }
}


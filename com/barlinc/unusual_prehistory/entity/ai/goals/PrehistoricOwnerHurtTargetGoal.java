/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.target.TargetGoal
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

public class PrehistoricOwnerHurtTargetGoal
extends TargetGoal {
    protected final PrehistoricMob tamedMob;
    private LivingEntity ownerLastHurt;
    private int timestamp;

    public PrehistoricOwnerHurtTargetGoal(PrehistoricMob tamedMob) {
        super((Mob)tamedMob, false);
        this.tamedMob = tamedMob;
        this.m_7021_(EnumSet.of(Goal.Flag.TARGET));
    }

    public boolean m_8036_() {
        if (this.tamedMob.m_21824_() && !this.tamedMob.m_21827_()) {
            LivingEntity livingentity = this.tamedMob.m_269323_();
            if (livingentity == null) {
                return false;
            }
            this.ownerLastHurt = livingentity.m_21214_();
            int i = livingentity.m_21215_();
            return i != this.timestamp && this.m_26150_(this.ownerLastHurt, TargetingConditions.f_26872_) && this.tamedMob.m_7757_(this.ownerLastHurt, livingentity);
        }
        return false;
    }

    public void m_8056_() {
        this.f_26135_.m_6710_(this.ownerLastHurt);
        LivingEntity livingentity = this.tamedMob.m_269323_();
        if (livingentity != null) {
            this.timestamp = livingentity.m_21215_();
        }
        super.m_8056_();
    }
}


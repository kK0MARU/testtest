/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.future;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.future.Psilopterus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class PsilopterusAttackGoal
extends AttackGoal {
    protected final Psilopterus psilopterus;

    public PsilopterusAttackGoal(Psilopterus psilopterus) {
        super(psilopterus);
        this.psilopterus = psilopterus;
    }

    public void m_8037_() {
        LivingEntity target = this.psilopterus.m_5448_();
        if (target != null) {
            double distanceToTarget = this.psilopterus.m_262793_(target);
            this.psilopterus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
            if (this.psilopterus.getAttackState() == 1) {
                this.tickPeck();
                this.psilopterus.m_21573_().m_5624_((Entity)target, 1.3);
            } else if (this.psilopterus.getAttackState() == 2) {
                this.tickKick();
            } else {
                if (distanceToTarget < this.getAttackReachSqr(target)) {
                    if (this.psilopterus.m_217043_().m_188501_() < 0.3f && !this.psilopterus.m_20069_()) {
                        this.psilopterus.setAttackState(2);
                    } else {
                        this.psilopterus.setAttackState(1);
                    }
                }
                this.psilopterus.m_21573_().m_5624_((Entity)target, 1.5);
            }
        }
    }

    protected void tickPeck() {
        ++this.timer;
        LivingEntity target = this.psilopterus.m_5448_();
        if (this.timer == 1) {
            this.psilopterus.m_20124_(UP2Poses.ATTACKING.get());
            this.psilopterus.m_5496_((SoundEvent)UP2SoundEvents.PSILOPTERUS_BITE.get(), 1.0f, 0.9f + this.psilopterus.m_217043_().m_188501_() * 0.2f);
        }
        if (this.timer == 5 && this.isInAttackRange(target, 1.5)) {
            this.psilopterus.m_7327_((Entity)target);
            this.psilopterus.m_6674_(InteractionHand.MAIN_HAND);
        }
        if (this.timer > 10) {
            this.timer = 0;
            this.psilopterus.setAttackState(0);
        }
    }

    protected void tickKick() {
        ++this.timer;
        LivingEntity target = this.psilopterus.m_5448_();
        this.psilopterus.m_21573_().m_26573_();
        if (this.timer == 1) {
            this.psilopterus.m_20124_(UP2Poses.KICKING.get());
        }
        if (this.timer == 12) {
            this.psilopterus.m_5496_((SoundEvent)UP2SoundEvents.PSILOPTERUS_ATTACK.get(), 1.0f, 0.9f + this.psilopterus.m_217043_().m_188501_() * 0.2f);
        }
        if (this.timer == 14 && this.isInAttackRange(target, 1.75)) {
            this.psilopterus.m_7327_((Entity)target);
            this.psilopterus.strongKnockback((Entity)target, 0.75, 0.025);
            this.psilopterus.m_6674_(InteractionHand.MAIN_HAND);
        }
        if (this.timer > 30) {
            this.timer = 0;
            this.psilopterus.setAttackState(0);
        }
    }

    @Override
    protected double getAttackReachSqr(LivingEntity target) {
        return this.mob.m_20205_() * 1.8f * this.mob.m_20205_() * 1.8f + target.m_20205_();
    }
}


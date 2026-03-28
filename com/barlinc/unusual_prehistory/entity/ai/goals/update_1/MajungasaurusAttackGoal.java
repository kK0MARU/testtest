/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Majungasaurus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;

public class MajungasaurusAttackGoal
extends AttackGoal {
    protected final Majungasaurus majungasaurus;

    public MajungasaurusAttackGoal(Majungasaurus majungasaurus) {
        super(majungasaurus);
        this.majungasaurus = majungasaurus;
    }

    @Override
    public void m_8056_() {
        super.m_8056_();
        this.majungasaurus.setCamo(false);
    }

    @Override
    public void m_8041_() {
        super.m_8041_();
        this.majungasaurus.setCamo(false);
        this.majungasaurus.camoCooldown();
    }

    public void m_8037_() {
        LivingEntity target = this.majungasaurus.m_5448_();
        if (target != null) {
            double distance = this.majungasaurus.m_20280_((Entity)target);
            this.majungasaurus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
            if (distance > 25.0 && this.majungasaurus.getCamoCooldown() == 0 && !this.majungasaurus.m_20072_()) {
                this.majungasaurus.setCamo(true);
                this.majungasaurus.m_21573_().m_5624_((Entity)target, 0.9);
            }
            if (distance <= 25.0 || this.majungasaurus.getCamoCooldown() > 0) {
                this.majungasaurus.setCamo(false);
                this.majungasaurus.camoCooldown();
                this.majungasaurus.m_21573_().m_5624_((Entity)target, 2.0);
            }
            if (this.majungasaurus.getAttackState() == 1) {
                this.tickAttack();
            } else if (distance <= this.getAttackReachSqr(target)) {
                this.majungasaurus.setAttackState(1);
            }
        }
    }

    protected void tickAttack() {
        ++this.timer;
        LivingEntity target = this.majungasaurus.m_5448_();
        if (this.timer == 1) {
            this.majungasaurus.attackAlt = this.majungasaurus.m_217043_().m_188499_();
            this.majungasaurus.m_20124_(UP2Poses.ATTACKING.get());
        }
        if (this.timer == 8) {
            this.majungasaurus.m_5496_((SoundEvent)UP2SoundEvents.MAJUNGASAURUS_ATTACK.get(), 1.0f, 0.9f + this.majungasaurus.m_217043_().m_188501_() * 0.25f);
        }
        if (this.timer == 11 && this.isInAttackRange(target, 1.5)) {
            this.majungasaurus.m_7327_((Entity)target);
            this.majungasaurus.m_6674_(InteractionHand.MAIN_HAND);
        }
        if (this.timer > 17) {
            this.timer = 0;
            this.majungasaurus.m_20124_(Pose.STANDING);
            this.majungasaurus.setAttackState(0);
        }
    }
}


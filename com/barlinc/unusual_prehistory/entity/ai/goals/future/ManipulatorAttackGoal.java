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
package com.barlinc.unusual_prehistory.entity.ai.goals.future;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.future.Manipulator;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;

public class ManipulatorAttackGoal
extends AttackGoal {
    protected final Manipulator manipulator;

    public ManipulatorAttackGoal(Manipulator manipulator) {
        super(manipulator);
        this.manipulator = manipulator;
    }

    public void m_8037_() {
        LivingEntity target = this.manipulator.m_5448_();
        if (target != null) {
            double distance = this.manipulator.m_20280_((Entity)target);
            this.manipulator.m_21391_((Entity)this.manipulator.m_5448_(), 30.0f, 30.0f);
            this.manipulator.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
            if (this.manipulator.getAttackState() == 1) {
                this.manipulator.m_21573_().m_26573_();
                this.tickAttack();
            } else {
                this.manipulator.m_21573_().m_5624_((Entity)target, 1.4);
                if (distance <= this.getAttackReachSqr(target) && this.manipulator.attackCooldown == 0) {
                    this.manipulator.setAttackState(1);
                }
            }
        }
    }

    protected void tickAttack() {
        ++this.timer;
        LivingEntity target = this.manipulator.m_5448_();
        if (this.timer == 1) {
            this.manipulator.m_20124_(UP2Poses.ATTACKING.get());
            this.manipulator.m_5496_((SoundEvent)UP2SoundEvents.MANIPULATOR_ATTACK_VOCAL.get(), 1.0f, 0.9f + this.manipulator.m_217043_().m_188501_() * 0.2f);
        }
        if (this.timer == 7) {
            this.manipulator.m_5496_((SoundEvent)UP2SoundEvents.MANIPULATOR_ATTACK_SLASH.get(), 0.8f, 1.0f + this.manipulator.m_217043_().m_188501_() * 0.2f);
            if (this.isInAttackRange(target, 2.1)) {
                this.manipulator.m_7327_((Entity)target);
                this.manipulator.m_6674_(InteractionHand.MAIN_HAND);
            }
        }
        if (this.timer == 17) {
            this.manipulator.m_5496_((SoundEvent)UP2SoundEvents.MANIPULATOR_ATTACK_SLASH.get(), 0.8f, 1.0f + this.manipulator.m_217043_().m_188501_() * 0.2f);
            if (this.isInAttackRange(target, 2.1)) {
                this.manipulator.m_7327_((Entity)target);
                this.manipulator.m_6674_(InteractionHand.OFF_HAND);
            }
        }
        if (this.timer > 30) {
            this.timer = 0;
            this.manipulator.blockCooldown();
            this.manipulator.m_20124_(Pose.STANDING);
            this.manipulator.setAttackState(0);
        }
    }

    @Override
    protected double getAttackReachSqr(LivingEntity target) {
        return this.mob.m_20205_() * 1.7f * this.mob.m_20205_() * 1.7f + target.m_20205_();
    }
}


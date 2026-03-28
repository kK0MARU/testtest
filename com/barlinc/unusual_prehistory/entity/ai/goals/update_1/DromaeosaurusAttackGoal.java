/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Dromaeosaurus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;

public class DromaeosaurusAttackGoal
extends AttackGoal {
    protected final Dromaeosaurus dromaeosaurus;

    public DromaeosaurusAttackGoal(Dromaeosaurus dromaeosaurus) {
        super(dromaeosaurus);
        this.dromaeosaurus = dromaeosaurus;
    }

    @Override
    public boolean m_8036_() {
        return super.m_8036_() && this.dromaeosaurus.m_21223_() >= this.dromaeosaurus.m_21233_() * 0.5f;
    }

    @Override
    public boolean m_8045_() {
        return super.m_8045_() && this.dromaeosaurus.m_21223_() >= this.dromaeosaurus.m_21233_() * 0.5f;
    }

    public void m_8037_() {
        LivingEntity target = this.dromaeosaurus.m_5448_();
        if (target != null) {
            double distance = this.dromaeosaurus.m_20280_((Entity)target);
            this.dromaeosaurus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
            this.dromaeosaurus.m_21573_().m_5624_((Entity)target, 1.0);
            if (this.dromaeosaurus.getAttackState() == 1) {
                this.tickAttack();
            } else if (distance <= this.getAttackReachSqr(target)) {
                this.dromaeosaurus.setAttackState(1);
            }
        }
    }

    private void tickAttack() {
        ++this.timer;
        LivingEntity target = this.dromaeosaurus.m_5448_();
        if (this.timer == 1) {
            this.dromaeosaurus.m_20124_(UP2Poses.ATTACKING.get());
        }
        if (this.timer == 6 && this.isInAttackRange(target, 1.25)) {
            this.dromaeosaurus.m_7327_((Entity)target);
            this.dromaeosaurus.m_6674_(InteractionHand.MAIN_HAND);
        }
        if (this.timer > 15) {
            this.timer = 0;
            this.dromaeosaurus.m_20124_(Pose.STANDING);
            this.dromaeosaurus.setAttackState(0);
        }
    }

    @Override
    protected double getAttackReachSqr(LivingEntity target) {
        return this.mob.m_20205_() * 1.5f * this.mob.m_20205_() * 1.5f + target.m_20205_();
    }
}


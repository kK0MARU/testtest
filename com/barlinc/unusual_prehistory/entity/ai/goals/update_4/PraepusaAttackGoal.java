/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.player.Player
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_4;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Praepusa;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;

public class PraepusaAttackGoal
extends AttackGoal {
    private final Praepusa praepusa;

    public PraepusaAttackGoal(Praepusa praepusa) {
        super(praepusa);
        this.praepusa = praepusa;
    }

    @Override
    public boolean m_8036_() {
        LivingEntity target = this.praepusa.m_5448_();
        return super.m_8036_() && this.praepusa.m_20089_() == Pose.STANDING && target != null && target.m_6084_() && target.m_20069_() && !target.m_6095_().m_204039_(UP2EntityTags.PRAEPUSA_AVOIDS) && !(target instanceof Player);
    }

    public void m_8037_() {
        LivingEntity target = this.praepusa.m_5448_();
        if (target != null && target.m_20069_()) {
            this.praepusa.m_21391_((Entity)target, 30.0f, 30.0f);
            this.praepusa.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
            double distance = this.praepusa.m_20275_(target.m_20185_(), target.m_20186_(), target.m_20189_());
            this.praepusa.m_21573_().m_5624_((Entity)target, 1.5);
            if (distance <= 4.0 && this.praepusa.attackCooldown == 0) {
                this.praepusa.setAttackState(1);
            }
            if (this.praepusa.getAttackState() == 1) {
                this.tickAttack();
            }
        }
    }

    protected void tickAttack() {
        ++this.timer;
        LivingEntity target = this.praepusa.m_5448_();
        if (this.timer == 1) {
            this.praepusa.m_20124_(UP2Poses.ATTACKING.get());
        }
        if (this.timer == 8 && (double)this.praepusa.m_20270_((Entity)target) < this.getAttackReachSqr(target)) {
            this.praepusa.m_7327_((Entity)target);
            this.praepusa.m_6674_(InteractionHand.MAIN_HAND);
        }
        if (this.timer > 10) {
            this.timer = 0;
            this.praepusa.setAttackState(0);
            this.praepusa.attackCooldown = 4;
        }
    }
}


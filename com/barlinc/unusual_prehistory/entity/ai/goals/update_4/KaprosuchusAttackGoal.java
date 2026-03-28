/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_4;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Kaprosuchus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.Vec3;

public class KaprosuchusAttackGoal
extends AttackGoal {
    protected final Kaprosuchus kaprosuchus;
    private int waitTimer;

    public KaprosuchusAttackGoal(Kaprosuchus kaprosuchus) {
        super(kaprosuchus);
        this.kaprosuchus = kaprosuchus;
    }

    @Override
    public void m_8056_() {
        super.m_8056_();
        this.waitTimer = 0;
    }

    @Override
    public void m_8041_() {
        super.m_8041_();
        this.kaprosuchus.setLeaping(false);
    }

    public void m_8037_() {
        LivingEntity target = this.kaprosuchus.m_5448_();
        if (target != null) {
            double distance = this.kaprosuchus.m_20280_((Entity)target);
            if (!this.kaprosuchus.isLeaping()) {
                this.kaprosuchus.m_21391_((Entity)target, 30.0f, 30.0f);
                this.kaprosuchus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
            }
            if (this.kaprosuchus.isLeaping()) {
                Vec3 vec3 = this.kaprosuchus.m_20184_();
                if (vec3.f_82480_ * vec3.f_82480_ < (double)0.03f && this.kaprosuchus.m_146909_() != 0.0f) {
                    this.kaprosuchus.m_146926_(Mth.m_14189_((float)0.2f, (float)this.kaprosuchus.m_146909_(), (float)0.0f));
                } else if (vec3.m_82553_() > (double)1.0E-5f) {
                    double horizontalDistance = vec3.m_165924_();
                    double xRot = Math.atan2(-vec3.f_82480_, horizontalDistance) * 57.2957763671875;
                    this.kaprosuchus.m_146926_((float)xRot);
                    this.kaprosuchus.m_146922_((float)Mth.m_14136_((double)this.kaprosuchus.m_6374_().m_122431_(), (double)this.kaprosuchus.m_6374_().m_122429_()) * 57.295776f - 90.0f);
                }
            }
            if (this.waitTimer > 0) {
                --this.waitTimer;
                this.kaprosuchus.m_21573_().m_26573_();
            }
            if ((this.kaprosuchus.m_20096_() || this.kaprosuchus.m_20072_()) && this.kaprosuchus.isLeaping()) {
                this.kaprosuchus.setAttackState(0);
                this.kaprosuchus.setLeaping(false);
                this.kaprosuchus.leapCooldown();
                this.waitTimer = 15;
            }
            if (this.kaprosuchus.getAttackState() == 1) {
                this.kaprosuchus.m_21573_().m_5624_((Entity)target, 1.7);
                this.tickBite();
            } else if (this.kaprosuchus.getAttackState() == 2) {
                this.tickLeap();
            } else {
                if (this.waitTimer == 0) {
                    this.kaprosuchus.m_21573_().m_5624_((Entity)target, 1.9);
                }
                if (distance > 12.0 && distance < 90.0 && this.kaprosuchus.leapCooldown == 0 && this.isPathClear(target) && this.waitTimer == 0) {
                    this.kaprosuchus.setAttackState(2);
                } else if (distance <= this.getAttackReachSqr(target) && this.kaprosuchus.attackCooldown == 0 && this.waitTimer == 0) {
                    this.kaprosuchus.setAttackState(1);
                }
            }
        }
    }

    protected void tickBite() {
        ++this.timer;
        LivingEntity target = this.kaprosuchus.m_5448_();
        if (this.timer == 1) {
            this.kaprosuchus.attackAlt = this.kaprosuchus.m_217043_().m_188499_();
            this.kaprosuchus.m_20124_(UP2Poses.ATTACKING.get());
        }
        if (this.timer == 8 && this.isInAttackRange(target, 2.0)) {
            this.kaprosuchus.m_7327_((Entity)target);
            this.kaprosuchus.m_6674_(InteractionHand.MAIN_HAND);
        }
        if (this.timer > 10) {
            this.timer = 0;
            this.kaprosuchus.m_20124_(Pose.STANDING);
            this.kaprosuchus.attackCooldown = 4 + this.kaprosuchus.m_217043_().m_188503_(3);
            this.kaprosuchus.setAttackState(0);
        }
    }

    protected void tickLeap() {
        ++this.timer;
        LivingEntity target = this.kaprosuchus.m_5448_();
        this.kaprosuchus.m_21573_().m_26573_();
        if (this.timer <= 10) {
            this.kaprosuchus.m_21391_((Entity)target, 30.0f, 30.0f);
            this.kaprosuchus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
        }
        if (this.timer > 10 && this.kaprosuchus.m_20096_()) {
            this.kaprosuchus.setLeaping(true);
            Vec3 deltaMovement = this.kaprosuchus.m_20184_();
            Vec3 vec3 = new Vec3(target.m_20185_() - this.kaprosuchus.m_20185_(), 0.0, target.m_20189_() - this.kaprosuchus.m_20189_());
            if (vec3.m_82556_() > 1.0E-7) {
                vec3 = vec3.m_82541_().m_82490_(1.1).m_82549_(deltaMovement.m_82490_(0.5));
            }
            this.kaprosuchus.m_20334_(vec3.f_82479_, 1.1f, vec3.f_82481_);
        }
        if (this.isInAttackRange(target, 0.5) && this.timer > 20) {
            this.kaprosuchus.m_7327_((Entity)target);
            this.kaprosuchus.strongKnockback((Entity)target, 0.5, 0.05);
            this.kaprosuchus.m_6674_(InteractionHand.MAIN_HAND);
            this.kaprosuchus.setLeaping(false);
            this.kaprosuchus.m_20124_(Pose.STANDING);
            this.kaprosuchus.setAttackState(0);
            this.kaprosuchus.leapCooldown();
            this.waitTimer = 15;
        } else if (this.timer > 80) {
            this.kaprosuchus.m_20124_(Pose.STANDING);
            this.kaprosuchus.setLeaping(false);
            this.kaprosuchus.setAttackState(0);
            this.kaprosuchus.leapCooldown();
            this.waitTimer = 15;
        }
    }

    private boolean isPathClear(LivingEntity target) {
        double z = target.m_20189_() - this.kaprosuchus.m_20189_();
        double x = target.m_20185_() - this.kaprosuchus.m_20185_();
        double d2 = z / x;
        for (int j = 0; j < 6; ++j) {
            double d3 = d2 == 0.0 ? 0.0 : z * ((double)j / 6.0);
            double d4 = d2 == 0.0 ? x * ((double)j / 6.0) : d3 / d2;
            for (int k = 1; k < 4; ++k) {
                if (this.kaprosuchus.m_9236_().m_8055_(BlockPos.m_274561_((double)(this.kaprosuchus.m_20185_() + d4), (double)(this.kaprosuchus.m_20186_() + (double)k), (double)(this.kaprosuchus.m_20189_() + d3))).m_247087_()) continue;
                return false;
            }
        }
        return true;
    }
}


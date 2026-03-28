/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_4;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Pachycephalosaurus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class PachycephalosaurusAttackGoal
extends AttackGoal {
    protected final Pachycephalosaurus pachycephalosaurus;
    private boolean hitTarget;

    public PachycephalosaurusAttackGoal(Pachycephalosaurus pachycephalosaurus) {
        super(pachycephalosaurus);
        this.pachycephalosaurus = pachycephalosaurus;
    }

    @Override
    public boolean m_8036_() {
        return super.m_8036_() && this.pachycephalosaurus.m_21223_() > this.pachycephalosaurus.m_21233_() * 0.5f;
    }

    @Override
    public boolean m_8045_() {
        return super.m_8045_() && this.pachycephalosaurus.m_21223_() > this.pachycephalosaurus.m_21233_() * 0.5f;
    }

    @Override
    public void m_8056_() {
        super.m_8056_();
        this.hitTarget = false;
    }

    @Override
    public void m_8041_() {
        super.m_8041_();
        this.pachycephalosaurus.setFightCooldown(1000 + this.pachycephalosaurus.m_217043_().m_188503_(1000));
        this.pachycephalosaurus.setFindTargetCooldown(1200 + this.pachycephalosaurus.m_217043_().m_188503_(1200));
        this.pachycephalosaurus.setFightPartner(false);
    }

    public void m_8037_() {
        LivingEntity target = this.pachycephalosaurus.m_5448_();
        if (target != null) {
            double distance = this.pachycephalosaurus.m_20280_((Entity)target);
            int attackState = this.pachycephalosaurus.getAttackState();
            this.pachycephalosaurus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
            if (attackState == 1) {
                this.pachycephalosaurus.m_21573_().m_26573_();
                this.tickCharge();
            } else {
                if (distance > 50.0) {
                    this.pachycephalosaurus.m_21573_().m_5624_((Entity)target, 1.7);
                }
                if (distance <= 70.0 && this.isWithinYRange(target) && !this.pachycephalosaurus.m_20069_() && this.pachycephalosaurus.getChargeCooldown() == 0 && this.pachycephalosaurus.m_20089_() != UP2Poses.RECOVERING.get()) {
                    this.pachycephalosaurus.setAttackState(1);
                }
            }
        }
    }

    protected void tickCharge() {
        ++this.timer;
        LivingEntity target = this.pachycephalosaurus.m_5448_();
        if (this.timer == 1) {
            this.pachycephalosaurus.m_20124_(UP2Poses.WARNING.get());
        }
        if (this.timer < 50) {
            this.pachycephalosaurus.m_21391_((Entity)target, 360.0f, 30.0f);
            this.pachycephalosaurus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
        }
        if (this.timer == 50) {
            this.pachycephalosaurus.m_20124_(Pose.STANDING);
        }
        if (this.timer == 27 && !this.pachycephalosaurus.isFightPartner()) {
            this.pachycephalosaurus.m_5496_((SoundEvent)UP2SoundEvents.PACHYCEPHALOSAURUS_WARN.get(), 1.8f, 0.9f + this.pachycephalosaurus.m_217043_().m_188501_() * 0.3f);
        }
        if (this.timer > 50 && this.timer < 70) {
            if (this.isInAttackRange(target, target instanceof Pachycephalosaurus ? 0.1 : 1.1) && !this.hitTarget) {
                this.hurtAndKnockbackTarget(target);
                if (target instanceof Pachycephalosaurus) {
                    this.bonkAndRecover(!this.pachycephalosaurus.isFightPartner());
                    this.m_8041_();
                }
            } else {
                this.chargeAtTarget((Entity)target, 0.85f);
            }
        }
        if (this.pachycephalosaurus.f_19862_ && this.timer > 50) {
            this.bonkAndRecover(true);
            if (target instanceof Pachycephalosaurus || !this.pachycephalosaurus.wantsToKill()) {
                this.m_8041_();
            }
        }
        if (this.timer > 70) {
            this.timer = 0;
            this.pachycephalosaurus.m_20124_(Pose.STANDING);
            this.pachycephalosaurus.setAttackState(0);
            this.pachycephalosaurus.setChargeCooldown(15 + this.pachycephalosaurus.m_217043_().m_188503_(10));
            this.hitTarget = false;
            if (target instanceof Pachycephalosaurus || !this.pachycephalosaurus.wantsToKill()) {
                this.m_8041_();
            }
        }
    }

    private void hurtAndKnockbackTarget(LivingEntity entity) {
        float knockbackForce;
        BlockPos pos = this.pachycephalosaurus.m_20183_();
        Vec3 targetPos = entity.m_20182_();
        Vec3 knockbackDirection = new Vec3((double)pos.m_123341_() - targetPos.m_7096_(), 0.0, (double)pos.m_123343_() - targetPos.m_7094_()).m_82541_();
        int speedFactor = this.pachycephalosaurus.m_21023_(MobEffects.f_19596_) ? this.pachycephalosaurus.m_21124_(MobEffects.f_19596_).m_19564_() + 1 : 0;
        int slownessFactor = this.pachycephalosaurus.m_21023_(MobEffects.f_19597_) ? this.pachycephalosaurus.m_21124_(MobEffects.f_19597_).m_19564_() + 1 : 0;
        float effectSpeed = 0.15f * (float)(speedFactor - slownessFactor);
        float speedForce = Mth.m_14036_((float)(this.pachycephalosaurus.m_6113_() * 1.5f), (float)0.2f, (float)3.0f) + effectSpeed;
        float f = knockbackForce = entity.m_21275_(this.pachycephalosaurus.m_9236_().m_269111_().m_269333_((LivingEntity)this.pachycephalosaurus)) ? 2.25f : 3.0f;
        if (entity instanceof Pachycephalosaurus) {
            knockbackForce = 1.0f;
        } else {
            entity.m_6469_(entity.m_269291_().m_269333_((LivingEntity)this.pachycephalosaurus), (float)this.pachycephalosaurus.m_21133_(Attributes.f_22281_));
        }
        entity.m_147240_((double)(knockbackForce * speedForce * 1.5f), knockbackDirection.m_7096_(), knockbackDirection.m_7094_());
        if (entity.m_21275_(this.pachycephalosaurus.m_269291_().m_269333_((LivingEntity)this.pachycephalosaurus)) && entity instanceof Player) {
            Player player = (Player)entity;
            player.m_36384_(true);
            this.bonkAndRecover(true);
        }
        this.pachycephalosaurus.m_6674_(InteractionHand.MAIN_HAND);
        this.hitTarget = true;
    }

    private void bonkAndRecover(boolean playSound) {
        this.pachycephalosaurus.m_9236_().m_7605_((Entity)this.pachycephalosaurus, (byte)39);
        if (playSound) {
            this.pachycephalosaurus.m_5496_((SoundEvent)UP2SoundEvents.PACHYCEPHALOSAURUS_BONK.get(), 1.5f, 0.9f + this.pachycephalosaurus.m_217043_().m_188501_() * 0.25f);
        }
        this.timer = 0;
        this.pachycephalosaurus.m_20124_(UP2Poses.RECOVERING.get());
        this.pachycephalosaurus.setAttackState(0);
        this.pachycephalosaurus.setChargeCooldown(15 + this.pachycephalosaurus.m_217043_().m_188503_(10));
        this.hitTarget = false;
    }

    private boolean isWithinYRange(LivingEntity target) {
        if (target == null) {
            return false;
        }
        return Math.abs(target.m_20186_() - this.pachycephalosaurus.m_20186_()) < 2.0;
    }
}


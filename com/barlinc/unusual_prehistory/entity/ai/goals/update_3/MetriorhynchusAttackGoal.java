/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_3;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.update_3.Metriorhynchus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class MetriorhynchusAttackGoal
extends AttackGoal {
    private final Metriorhynchus metriorhynchus;

    public MetriorhynchusAttackGoal(Metriorhynchus metriorhynchus) {
        super(metriorhynchus);
        this.metriorhynchus = metriorhynchus;
    }

    public void m_8037_() {
        LivingEntity target = this.metriorhynchus.m_5448_();
        if (target != null) {
            double distance = this.metriorhynchus.m_20280_((Entity)target);
            int attackState = this.metriorhynchus.getAttackState();
            this.metriorhynchus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
            if (attackState == 1) {
                this.tickBite();
            } else if (attackState == 2) {
                this.tickDeathRoll();
            } else if (distance <= this.getAttackReachSqr(target)) {
                if (this.canGrab()) {
                    this.metriorhynchus.setAttackState(2);
                } else if (this.metriorhynchus.attackCooldown == 0 && !this.canGrab()) {
                    this.metriorhynchus.setAttackState(1);
                }
            } else {
                this.metriorhynchus.m_21573_().m_5624_((Entity)target, this.metriorhynchus.m_20069_() ? 1.4 : 1.5);
            }
        }
    }

    private boolean canGrab() {
        return this.metriorhynchus.grabCooldown == 0 && !(this.metriorhynchus.m_5448_() instanceof Player) && this.metriorhynchus.m_20069_() && this.metriorhynchus.canPickUpTarget(this.metriorhynchus.m_5448_());
    }

    protected void tickBite() {
        ++this.timer;
        LivingEntity target = this.metriorhynchus.m_5448_();
        this.metriorhynchus.m_21573_().m_5624_((Entity)target, this.metriorhynchus.m_20069_() ? 1.1 : 1.3);
        if (this.timer == 1) {
            this.metriorhynchus.attackAlt = this.metriorhynchus.m_217043_().m_188499_();
            this.metriorhynchus.m_20124_(UP2Poses.ATTACKING.get());
        }
        if (this.timer == 2) {
            this.metriorhynchus.m_5496_((SoundEvent)UP2SoundEvents.METRIORHYNCHUS_BITE.get(), 1.0f, this.metriorhynchus.m_6100_());
        }
        if (this.timer == 5 && this.isInAttackRange(target, 1.6)) {
            this.metriorhynchus.m_7327_((Entity)target);
            this.metriorhynchus.m_6674_(InteractionHand.MAIN_HAND);
        }
        if (this.timer > 10) {
            this.timer = 0;
            this.metriorhynchus.setAttackState(0);
            this.metriorhynchus.m_20124_(Pose.STANDING);
            this.metriorhynchus.attackCooldown = 5;
        }
    }

    protected void tickDeathRoll() {
        Entity entity;
        ++this.timer;
        this.metriorhynchus.m_21573_().m_26573_();
        LivingEntity target = this.metriorhynchus.m_5448_();
        if (this.timer == 1) {
            this.metriorhynchus.grabAlt = this.metriorhynchus.m_217043_().m_188499_();
            this.metriorhynchus.m_20124_(UP2Poses.GRABBING.get());
        }
        if (this.timer == 3) {
            this.metriorhynchus.m_5496_((SoundEvent)UP2SoundEvents.METRIORHYNCHUS_BITE.get(), 1.0f, this.metriorhynchus.m_6100_() * 0.9f);
        }
        if (this.timer == 5 && this.isInAttackRange(target, 1.5)) {
            this.metriorhynchus.setHeldMobId(target.m_19879_());
        }
        if (this.timer > 5 && this.timer <= 40 && this.metriorhynchus.getHeldMobId() != -1 && (entity = this.metriorhynchus.m_9236_().m_6815_(this.metriorhynchus.getHeldMobId())) != null) {
            this.positionHeldMob(entity);
            if (this.timer % 20 == 0) {
                entity.m_6469_(this.metriorhynchus.m_269291_().m_269333_((LivingEntity)this.metriorhynchus), (float)this.metriorhynchus.m_21133_(Attributes.f_22281_) * 0.6f);
            }
        }
        if (this.timer > 40) {
            this.timer = 0;
            this.metriorhynchus.setAttackState(0);
            this.metriorhynchus.m_20124_(Pose.STANDING);
            this.metriorhynchus.grabCooldown = 200 + this.metriorhynchus.m_217043_().m_188503_(200);
            if (this.metriorhynchus.getHeldMobId() != -1) {
                this.metriorhynchus.setHeldMobId(-1);
            }
        }
    }

    private void positionHeldMob(Entity entity) {
        Vec3 heldPos = this.metriorhynchus.m_146892_().m_82549_(new Vec3(0.0, 0.0, (double)2.2f).m_82524_(-this.metriorhynchus.f_20883_ * ((float)Math.PI / 180)));
        Vec3 minus = new Vec3(heldPos.f_82479_ - entity.m_20185_(), heldPos.f_82480_ - entity.m_20186_(), heldPos.f_82481_ - entity.m_20189_());
        entity.m_20256_(minus);
        entity.f_19789_ = 0.0f;
        entity.m_146922_(0.0f);
        entity.m_5618_(0.0f);
        entity.m_5616_(0.0f);
        entity.m_146926_(0.0f);
        entity.m_20256_(minus);
        entity.m_20256_(entity.m_20184_().m_82490_((double)0.4f));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.monster.Creeper
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Carnotaurus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2MobEffects;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import java.util.List;
import java.util.Objects;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class CarnotaurusAttackGoal
extends AttackGoal {
    private final Carnotaurus carnotaurus;
    private int collisionTicks;
    private Vec3 chargeDirection;

    public CarnotaurusAttackGoal(Carnotaurus carnotaurus) {
        super(carnotaurus);
        this.carnotaurus = carnotaurus;
        this.chargeDirection = Vec3.f_82478_;
    }

    @Override
    public void m_8056_() {
        super.m_8056_();
        this.collisionTicks = 0;
    }

    @Override
    public void m_8041_() {
        super.m_8041_();
        this.collisionTicks = 0;
    }

    public void m_8037_() {
        LivingEntity target = this.carnotaurus.m_5448_();
        if (target != null) {
            if (!this.isInChargingPose()) {
                this.carnotaurus.m_21391_((Entity)this.carnotaurus.m_5448_(), 30.0f, 30.0f);
                this.carnotaurus.m_21563_().m_24960_((Entity)this.carnotaurus.m_5448_(), 30.0f, 30.0f);
            }
            double distance = this.carnotaurus.m_20275_(target.m_20185_(), target.m_20186_(), target.m_20189_());
            int attackState = this.carnotaurus.getAttackState();
            if (this.carnotaurus.f_19862_) {
                ++this.collisionTicks;
            } else if (this.collisionTicks > 0) {
                --this.collisionTicks;
            }
            if (this.isInChargingPose() || attackState == 3 || attackState == 2 || attackState == 4) {
                this.carnotaurus.m_21573_().m_26573_();
            }
            if (attackState == 1) {
                this.carnotaurus.m_21573_().m_5624_((Entity)target, 1.8);
                if (this.carnotaurus.isFurious()) {
                    this.tickBiteFast();
                } else {
                    this.tickBite();
                }
            } else if (attackState == 2) {
                if (this.carnotaurus.isFurious()) {
                    this.tickHeadbuttFast();
                } else {
                    this.tickHeadbutt();
                }
            } else if (attackState == 3) {
                this.tickCharge();
            } else if (attackState == 4) {
                this.tickRoar();
            } else {
                if (!this.isInChargingPose()) {
                    this.carnotaurus.m_21573_().m_5624_((Entity)target, 2.2);
                }
                if (distance <= 10.0 && this.carnotaurus.chargeCooldown > 0 && !this.isInChargingPose()) {
                    if (this.carnotaurus.m_217043_().m_188501_() < 0.8f && !(target instanceof Creeper) && this.carnotaurus.biteCooldown == 0) {
                        this.carnotaurus.setAttackState(1);
                    } else if (this.carnotaurus.headbuttCooldown == 0) {
                        this.carnotaurus.setAttackState(2);
                    }
                } else if (distance < 70.0 && this.carnotaurus.chargeCooldown == 0 && !this.isInChargingPose() && !this.carnotaurus.m_20069_() && this.carnotaurus.isWithinYRange(target)) {
                    this.carnotaurus.setAttackState(3);
                } else if (this.carnotaurus.roarCooldown == 0 && this.carnotaurus.m_21223_() < this.carnotaurus.m_21233_() * 0.5f) {
                    this.carnotaurus.setAttackState(4);
                }
            }
        }
    }

    private boolean isInChargingPose() {
        return this.carnotaurus.m_20089_() == UP2Poses.STOP_CHARGING.get() || this.carnotaurus.m_20089_() == UP2Poses.CHARGING.get() || this.carnotaurus.m_20089_() == UP2Poses.START_CHARGING.get();
    }

    protected void tickBite() {
        ++this.timer;
        LivingEntity target = this.carnotaurus.m_5448_();
        if (this.timer == 1) {
            this.carnotaurus.m_20124_(UP2Poses.ATTACKING.get());
            this.carnotaurus.attackAlt = this.carnotaurus.m_217043_().m_188499_();
        }
        if (this.timer == 9) {
            this.carnotaurus.m_5496_((SoundEvent)UP2SoundEvents.CARNOTAURUS_BITE.get(), 1.0f, this.carnotaurus.m_6100_());
        }
        if (this.timer == 11 && (double)this.carnotaurus.m_20270_((Entity)Objects.requireNonNull(target)) <= this.getAttackReachSqr(target)) {
            this.carnotaurus.m_6674_(InteractionHand.MAIN_HAND);
            this.carnotaurus.m_7327_((Entity)target);
        }
        if (this.timer > 15) {
            this.timer = 0;
            this.carnotaurus.m_20124_(Pose.STANDING);
            this.carnotaurus.biteCooldown = 3;
            this.carnotaurus.setAttackState(0);
        }
    }

    protected void tickBiteFast() {
        ++this.timer;
        LivingEntity target = this.carnotaurus.m_5448_();
        if (this.timer == 1) {
            this.carnotaurus.m_20124_(UP2Poses.ATTACKING_FAST.get());
            this.carnotaurus.attackAlt = this.carnotaurus.m_217043_().m_188499_();
        }
        if (this.timer == 3) {
            this.carnotaurus.m_5496_((SoundEvent)UP2SoundEvents.CARNOTAURUS_BITE.get(), 1.0f, 1.1f * this.carnotaurus.m_6100_());
        }
        if (this.timer == 6 && (double)this.carnotaurus.m_20270_((Entity)Objects.requireNonNull(target)) <= this.getAttackReachSqr(target)) {
            this.carnotaurus.m_6674_(InteractionHand.MAIN_HAND);
            this.carnotaurus.m_7327_((Entity)target);
        }
        if (this.timer > 12) {
            this.timer = 0;
            this.carnotaurus.m_20124_(Pose.STANDING);
            this.carnotaurus.biteCooldown = 1;
            this.carnotaurus.setAttackState(0);
        }
    }

    protected void tickHeadbutt() {
        ++this.timer;
        if (this.timer == 1) {
            this.carnotaurus.m_20124_(UP2Poses.HEADBUTTING.get());
        }
        if (this.timer == 9) {
            this.carnotaurus.m_246865_(this.carnotaurus.m_20154_().m_82490_(2.0).m_82542_(0.2, 0.0, 0.2));
        }
        if (this.timer == 12) {
            this.headbuttNearbyEntities();
        }
        if (this.timer > 20) {
            this.timer = 0;
            this.carnotaurus.m_20124_(Pose.STANDING);
            this.carnotaurus.headbuttCooldown = 40 + this.carnotaurus.m_217043_().m_188503_(20);
            this.carnotaurus.setAttackState(0);
        }
    }

    protected void tickHeadbuttFast() {
        ++this.timer;
        if (this.timer == 1) {
            this.carnotaurus.m_20124_(UP2Poses.HEADBUTTING_FAST.get());
        }
        if (this.timer == 4) {
            this.carnotaurus.m_246865_(this.carnotaurus.m_20154_().m_82490_(2.0).m_82542_(0.2, 0.0, 0.2));
        }
        if (this.timer == 8) {
            this.headbuttNearbyEntities();
        }
        if (this.timer > 15) {
            this.timer = 0;
            this.carnotaurus.m_20124_(Pose.STANDING);
            this.carnotaurus.headbuttCooldown = 20 + this.carnotaurus.m_217043_().m_188503_(10);
            this.carnotaurus.setAttackState(0);
        }
    }

    protected void tickCharge() {
        ++this.timer;
        LivingEntity target = this.carnotaurus.m_5448_();
        int speedFactor = this.carnotaurus.m_21023_(MobEffects.f_19596_) ? this.carnotaurus.m_21124_(MobEffects.f_19596_).m_19564_() + 1 : 0;
        int furyFactor = this.carnotaurus.m_21023_((MobEffect)UP2MobEffects.FURY.get()) ? this.carnotaurus.m_21124_((MobEffect)UP2MobEffects.FURY.get()).m_19564_() + 1 : 0;
        int slownessFactor = this.carnotaurus.m_21023_(MobEffects.f_19597_) ? this.carnotaurus.m_21124_(MobEffects.f_19597_).m_19564_() + 1 : 0;
        float effectSpeed = 0.1f * (float)(speedFactor - slownessFactor);
        float effectFury = 0.1f * (float)(furyFactor - slownessFactor);
        if (this.timer == 1) {
            this.carnotaurus.m_20124_(UP2Poses.START_CHARGING.get());
        }
        if (this.timer == 18) {
            this.carnotaurus.m_5496_((SoundEvent)UP2SoundEvents.CARNOTAURUS_CHARGE.get(), 1.0f, this.carnotaurus.m_6100_());
        }
        if (this.timer < 20) {
            this.carnotaurus.m_21391_((Entity)target, 360.0f, 30.0f);
            this.carnotaurus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
        }
        if (this.timer > 20 && this.timer < 45) {
            this.chargeDirection = new Vec3(target.m_20185_() - this.carnotaurus.m_20185_(), target.m_20186_() - this.carnotaurus.m_20186_(), target.m_20189_() - this.carnotaurus.m_20189_()).m_82541_();
            float YRot = Mth.m_14148_((float)this.carnotaurus.m_146908_(), (float)((float)(Mth.m_14136_((double)this.chargeDirection.f_82481_, (double)this.chargeDirection.f_82479_) * 57.29577951308232) - 90.0f), (float)1.0f);
            float speed = 0.74f + effectSpeed + effectFury;
            this.carnotaurus.m_146922_(YRot);
            this.carnotaurus.m_5618_(YRot);
            this.carnotaurus.m_20334_(-Mth.m_14031_((float)(YRot * ((float)Math.PI / 180))) * speed, this.carnotaurus.m_20184_().f_82480_, Mth.m_14089_((float)(YRot * ((float)Math.PI / 180))) * speed);
            this.hurtNearbyEntities();
        }
        if (this.timer > 45 || this.collisionTicks > 10) {
            this.timer = 0;
            this.carnotaurus.m_20124_(UP2Poses.STOP_CHARGING.get());
            this.carnotaurus.chargeCooldown();
            this.carnotaurus.setAttackState(0);
        }
    }

    protected void tickRoar() {
        ++this.timer;
        LivingEntity target = this.carnotaurus.m_5448_();
        if (this.timer == 1) {
            this.carnotaurus.m_20124_(UP2Poses.ROARING.get());
        }
        if (this.timer == 5) {
            this.carnotaurus.m_5496_((SoundEvent)UP2SoundEvents.CARNOTAURUS_ROAR.get(), 2.0f, 1.0f);
        }
        this.carnotaurus.m_21391_((Entity)target, 360.0f, 30.0f);
        this.carnotaurus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
        if (this.timer == 8) {
            this.carnotaurus.roar();
        }
        if (this.timer > 40) {
            this.timer = 0;
            this.carnotaurus.m_20124_(Pose.STANDING);
            this.carnotaurus.roarCooldown();
            this.carnotaurus.setAttackState(0);
        }
    }

    private void headbuttNearbyEntities() {
        List nearbyEntities = this.carnotaurus.m_9236_().m_45971_(LivingEntity.class, TargetingConditions.m_148352_(), (LivingEntity)this.carnotaurus, this.carnotaurus.m_20191_().m_82400_(2.0));
        if (!nearbyEntities.isEmpty()) {
            nearbyEntities.stream().filter(entity -> !(entity instanceof Carnotaurus) && !(entity instanceof Creeper)).limit(3L).forEach(entity -> {
                if (entity.m_6469_(entity.m_269291_().m_269333_((LivingEntity)this.carnotaurus), (float)this.carnotaurus.m_21133_(Attributes.f_22281_))) {
                    this.carnotaurus.m_5496_((SoundEvent)UP2SoundEvents.CARNOTAURUS_HEADBUTT.get(), 1.0f, this.carnotaurus.m_6100_());
                }
                this.carnotaurus.strongKnockback((Entity)entity, 1.5, 0.5);
                if (entity.m_21275_(this.carnotaurus.m_269291_().m_269333_((LivingEntity)this.carnotaurus)) && entity instanceof Player) {
                    Player player = (Player)entity;
                    player.m_36384_(true);
                }
                this.carnotaurus.m_6674_(InteractionHand.MAIN_HAND);
            });
        }
    }

    private void hurtNearbyEntities() {
        LivingEntity entity;
        List nearbyEntities = this.carnotaurus.m_9236_().m_45971_(LivingEntity.class, TargetingConditions.m_148352_(), (LivingEntity)this.carnotaurus, this.carnotaurus.m_20191_().m_82400_(1.5));
        if (!nearbyEntities.isEmpty() && !((entity = (LivingEntity)nearbyEntities.get(0)) instanceof Carnotaurus)) {
            BlockPos pos = this.carnotaurus.m_20183_();
            Vec3 targetPos = entity.m_20182_();
            Vec3 knockbackDirection = new Vec3((double)pos.m_123341_() - targetPos.m_7096_(), 0.0, (double)pos.m_123343_() - targetPos.m_7094_()).m_82541_();
            int speedFactor = this.carnotaurus.m_21023_(MobEffects.f_19596_) ? this.carnotaurus.m_21124_(MobEffects.f_19596_).m_19564_() + 1 : 0;
            int slownessFactor = this.carnotaurus.m_21023_(MobEffects.f_19597_) ? this.carnotaurus.m_21124_(MobEffects.f_19597_).m_19564_() + 1 : 0;
            float effectSpeed = 0.15f * (float)(speedFactor - slownessFactor);
            float speedForce = Mth.m_14036_((float)(this.carnotaurus.m_6113_() * 1.65f), (float)0.2f, (float)3.0f) + effectSpeed;
            float knockbackForce = entity.m_21275_(this.carnotaurus.m_9236_().m_269111_().m_269333_((LivingEntity)this.carnotaurus)) ? 1.75f : 2.25f;
            entity.m_6469_(entity.m_269291_().m_269333_((LivingEntity)this.carnotaurus), (float)this.carnotaurus.m_21133_(Attributes.f_22281_));
            entity.m_147240_((double)(knockbackForce * speedForce * 2.5f), knockbackDirection.m_7096_(), knockbackDirection.m_7094_());
            if (entity.m_21275_(this.carnotaurus.m_269291_().m_269333_((LivingEntity)this.carnotaurus)) && entity instanceof Player) {
                Player player = (Player)entity;
                player.m_36384_(true);
            }
            this.carnotaurus.m_6674_(InteractionHand.MAIN_HAND);
        }
    }

    @Override
    protected double getAttackReachSqr(LivingEntity target) {
        return this.mob.m_20205_() * 1.4f * this.mob.m_20205_() * 1.4f + target.m_20205_();
    }
}


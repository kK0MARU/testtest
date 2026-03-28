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
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.player.Player
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Megalania;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import java.util.List;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;

public class MegalaniaAttackGoal
extends AttackGoal {
    private final Megalania megalania;

    public MegalaniaAttackGoal(Megalania megalania) {
        super(megalania);
        this.megalania = megalania;
        megalania.m_21573_().m_7008_(false);
    }

    @Override
    public boolean m_8036_() {
        return super.m_8036_() && this.megalania.m_20089_() != Pose.ROARING && !this.megalania.isSitting();
    }

    public void m_8037_() {
        LivingEntity target = this.megalania.m_5448_();
        if (target != null) {
            this.megalania.m_21391_((Entity)this.megalania.m_5448_(), 30.0f, 30.0f);
            this.megalania.m_21563_().m_24960_((Entity)this.megalania.m_5448_(), 30.0f, 30.0f);
            double distance = this.megalania.m_20275_(target.m_20185_(), target.m_20186_(), target.m_20189_());
            int attackState = this.megalania.getAttackState();
            if (attackState == 1) {
                this.megalania.m_21573_().m_5624_((Entity)target, this.megalania.m_20069_() ? this.getSpeedMultiplier() * 0.25 : this.getSpeedMultiplier() * (double)0.4f);
                this.tickBite();
            } else if (attackState == 2) {
                this.tickTailWhip();
            } else {
                this.megalania.m_21573_().m_5624_((Entity)target, this.megalania.m_20069_() ? this.getSpeedMultiplier() * (double)0.7f : this.getSpeedMultiplier());
                if (distance <= this.getAttackReachSqr(target)) {
                    this.selectAttack();
                }
            }
        }
    }

    private double getSpeedMultiplier() {
        switch (this.megalania.getTemperatureState()) {
            case COLD: {
                return 1.4;
            }
            case WARM: {
                return 1.9;
            }
            case NETHER: {
                return 1.5;
            }
        }
        return 2.0;
    }

    private void selectAttack() {
        if (this.megalania.m_20069_() && this.megalania.attackCooldown == 0) {
            this.megalania.setAttackState(1);
        } else if (this.megalania.m_217043_().m_188499_() && this.megalania.talWhipCooldown == 0) {
            this.megalania.setAttackState(2);
        } else if (this.megalania.attackCooldown == 0) {
            this.megalania.setAttackState(1);
        }
    }

    private void tickBite() {
        ++this.timer;
        LivingEntity target = this.megalania.m_5448_();
        if (this.timer == 1) {
            this.megalania.attackAlt = this.megalania.m_217043_().m_188499_();
            this.megalania.m_20124_(UP2Poses.ATTACKING.get());
        }
        if (this.timer == 5) {
            this.megalania.m_5496_((SoundEvent)UP2SoundEvents.MEGALANIA_BITE.get(), 1.0f, 1.0f);
        }
        if (this.timer == 11 && this.isInAttackRange(target, 1.4)) {
            this.megalania.m_6674_(InteractionHand.MAIN_HAND);
            this.megalania.m_7327_((Entity)target);
            this.megalania.applyPoison(target);
        }
        if (this.timer > 20) {
            this.timer = 0;
            this.megalania.attackCooldown = 5 + this.megalania.m_217043_().m_188503_(3);
            this.megalania.m_20124_(Pose.STANDING);
            this.megalania.setAttackState(0);
        }
    }

    private void tickTailWhip() {
        ++this.timer;
        this.megalania.m_21573_().m_26573_();
        if (this.timer == 1) {
            this.megalania.m_20124_(UP2Poses.TAIL_WHIPPING.get());
        }
        if (this.timer == 9) {
            this.megalania.m_5496_((SoundEvent)UP2SoundEvents.MEGALANIA_TAIL_SWING.get(), 1.0f, 1.0f);
        }
        if (this.timer == 14) {
            this.whipNearbyEnemies();
        }
        if (this.timer > 30) {
            this.timer = 0;
            this.megalania.talWhipCooldown = 100 + this.megalania.m_217043_().m_188503_(50);
            this.megalania.m_20124_(Pose.STANDING);
            this.megalania.setAttackState(0);
        }
    }

    private void whipNearbyEnemies() {
        List nearbyEntities = this.megalania.m_9236_().m_45971_(LivingEntity.class, TargetingConditions.m_148352_(), (LivingEntity)this.megalania, this.megalania.m_20191_().m_82377_(2.7, -0.25, 2.7));
        if (!nearbyEntities.isEmpty()) {
            nearbyEntities.stream().filter(entity -> !entity.m_7306_((Entity)this.megalania) && !entity.m_7307_((Entity)this.megalania)).limit(3L).forEach(entity -> {
                entity.m_6469_(entity.m_269291_().m_269333_((LivingEntity)this.megalania), (float)this.megalania.m_21133_(Attributes.f_22281_));
                this.megalania.strongKnockback((Entity)entity, 1.3, 0.2);
                if (entity.m_21275_(this.megalania.m_269291_().m_269333_((LivingEntity)this.megalania)) && entity instanceof Player) {
                    Player player = (Player)entity;
                    player.m_36384_(true);
                }
                this.megalania.m_6674_(InteractionHand.MAIN_HAND);
            });
        }
    }

    @Override
    protected double getAttackReachSqr(LivingEntity target) {
        return this.mob.m_20205_() * 1.75f * this.mob.m_20205_() * 1.75f + target.m_20205_();
    }
}


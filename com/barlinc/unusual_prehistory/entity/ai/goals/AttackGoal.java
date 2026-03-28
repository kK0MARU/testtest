/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Mth
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.GrabbingMob;
import java.util.EnumSet;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class AttackGoal
extends Goal {
    protected int timer = 0;
    protected final PrehistoricMob mob;

    public AttackGoal(PrehistoricMob mob) {
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.mob = mob;
    }

    public void m_8056_() {
        this.mob.m_20124_(Pose.STANDING);
        this.mob.setAttackState(0);
        this.mob.m_21561_(true);
        this.mob.setRunning(true);
        this.timer = 0;
        PrehistoricMob prehistoricMob = this.mob;
        if (prehistoricMob instanceof GrabbingMob) {
            GrabbingMob grabbingMob = (GrabbingMob)((Object)prehistoricMob);
            grabbingMob.setHeldMobId(-1);
        }
    }

    public void m_8041_() {
        this.mob.m_20124_(Pose.STANDING);
        this.mob.m_6710_(null);
        this.mob.setAttackState(0);
        this.mob.m_21561_(false);
        this.mob.setRunning(false);
        this.mob.m_21573_().m_26573_();
        PrehistoricMob prehistoricMob = this.mob;
        if (prehistoricMob instanceof GrabbingMob) {
            GrabbingMob grabbingMob = (GrabbingMob)((Object)prehistoricMob);
            grabbingMob.setHeldMobId(-1);
        }
    }

    public boolean m_8036_() {
        return !this.mob.m_6162_() && this.mob.m_5448_() != null && this.mob.m_5448_().m_6084_() && !this.mob.m_20160_() && !this.mob.isSitting() && !this.mob.isEepy();
    }

    public boolean m_8045_() {
        LivingEntity target = this.mob.m_5448_();
        if (target == null) {
            return false;
        }
        if (!target.m_6084_()) {
            return false;
        }
        if (!this.mob.m_21444_(target.m_20183_())) {
            return false;
        }
        return !(target instanceof Player) || !target.m_5833_() && !((Player)target).m_7500_() || !this.mob.m_21573_().m_26571_();
    }

    public boolean m_183429_() {
        return true;
    }

    protected double getAttackReachSqr(LivingEntity target) {
        return this.mob.m_20205_() * 2.0f * this.mob.m_20205_() * 2.0f + target.m_20205_();
    }

    protected boolean isInAttackRange(LivingEntity target, double reach) {
        return this.mob.m_142582_((Entity)target) && (double)this.mob.m_20270_((Entity)target) < (double)(this.mob.m_20205_() + target.m_20205_()) + reach;
    }

    protected void chargeAtTarget(Entity target, float speed) {
        int speedFactor = this.mob.m_21023_(MobEffects.f_19596_) ? this.mob.m_21124_(MobEffects.f_19596_).m_19564_() + 1 : 0;
        int slownessFactor = this.mob.m_21023_(MobEffects.f_19597_) ? this.mob.m_21124_(MobEffects.f_19597_).m_19564_() + 1 : 0;
        float effectSpeed = 0.1f * (float)(speedFactor - slownessFactor);
        Vec3 chargeDirection = new Vec3(target.m_20185_() - this.mob.m_20185_(), target.m_20186_() - this.mob.m_20186_(), target.m_20189_() - this.mob.m_20189_()).m_82541_();
        float YRot = Mth.m_14148_((float)this.mob.m_146908_(), (float)((float)(Mth.m_14136_((double)chargeDirection.f_82481_, (double)chargeDirection.f_82479_) * 57.29577951308232) - 90.0f), (float)0.5f);
        this.mob.m_146922_(YRot);
        this.mob.m_5618_(YRot);
        this.mob.m_20334_(-Mth.m_14031_((float)(YRot * ((float)Math.PI / 180))) * (speed += effectSpeed), this.mob.m_20184_().f_82480_, Mth.m_14089_((float)(YRot * ((float)Math.PI / 180))) * speed);
    }
}


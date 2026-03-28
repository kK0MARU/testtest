/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.utils.PackAnimal;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class JoinPackGoal
extends Goal {
    public final LivingEntity entity;
    public final PackAnimal packAnimal;
    private int distCheckCounter;
    private final int rate;
    private final int packSize;

    public JoinPackGoal(LivingEntity animal, int rate, int packSize) {
        this.entity = animal;
        this.packAnimal = (PackAnimal)animal;
        this.rate = rate;
        this.packSize = packSize;
    }

    public boolean m_8036_() {
        long worldTime = this.entity.m_9236_().m_46467_() % 10L;
        if (worldTime != 0L && this.entity.m_217043_().m_188503_(JoinPackGoal.m_186073_((int)this.rate)) != 0) {
            return false;
        }
        if (!this.packAnimal.isPackFollower() && !this.packAnimal.hasPackFollower()) {
            double dist = 30.0;
            List list = this.entity.m_9236_().m_45976_(this.entity.getClass(), this.entity.m_20191_().m_82377_(dist, dist, dist));
            LivingEntity closestTail = null;
            double value = Double.MAX_VALUE;
            for (LivingEntity animal : list) {
                double distance;
                if (((PackAnimal)animal).hasPackFollower() || !((PackAnimal)animal).isValidLeader(((PackAnimal)animal).getPackLeader()) || animal.m_20148_().equals(this.entity.m_20148_()) || ((PackAnimal)animal).isInPack(this.packAnimal) || ((PackAnimal)animal).getPackSize() >= this.packSize || (distance = this.entity.m_20280_((Entity)animal)) > value) continue;
                value = distance;
                closestTail = animal;
            }
            if (closestTail == null) {
                return false;
            }
            if (value < 1.0) {
                return false;
            }
            if (!this.packAnimal.isValidLeader(((PackAnimal)closestTail).getPackLeader())) {
                return false;
            }
            this.packAnimal.joinPackOf((PackAnimal)closestTail);
            return true;
        }
        return false;
    }

    public boolean m_8045_() {
        if (this.packAnimal.isPackFollower() && this.packAnimal.isValidLeader(this.packAnimal.getPackLeader())) {
            double distance = this.entity.m_20280_((Entity)((LivingEntity)this.packAnimal.getPriorPackMember()));
            if (distance > 676.0 && this.distCheckCounter == 0) {
                return false;
            }
            if (this.distCheckCounter > 0) {
                --this.distCheckCounter;
            }
            return true;
        }
        return false;
    }

    public void m_8041_() {
        this.packAnimal.leavePack();
    }
}


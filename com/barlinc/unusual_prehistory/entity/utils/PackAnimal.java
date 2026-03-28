/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.LivingEntity
 */
package com.barlinc.unusual_prehistory.entity.utils;

import net.minecraft.world.entity.LivingEntity;

public interface PackAnimal {
    default public boolean isPackFollower() {
        return this.getPriorPackMember() != null;
    }

    default public boolean hasPackFollower() {
        return this.getAfterPackMember() != null;
    }

    default public PackAnimal getPackLeader() {
        PackAnimal leader = this;
        while (leader.getPriorPackMember() != null && leader.getPriorPackMember() != this) {
            leader = leader.getPriorPackMember();
        }
        return leader;
    }

    default public int getPackSize() {
        PackAnimal leader = this.getPackLeader();
        int i = 1;
        while (leader.getAfterPackMember() != null) {
            leader = leader.getAfterPackMember();
            ++i;
        }
        return i;
    }

    default public boolean isInPack(PackAnimal packAnimal) {
        PackAnimal leader = this.getPackLeader();
        while (leader.getAfterPackMember() != null) {
            if (packAnimal.equals(leader)) {
                return true;
            }
            leader = leader.getAfterPackMember();
        }
        return false;
    }

    default public boolean isValidLeader(PackAnimal packLeader) {
        return !packLeader.isPackFollower() && ((LivingEntity)packLeader).m_6084_();
    }

    public PackAnimal getPriorPackMember();

    public PackAnimal getAfterPackMember();

    public void setPriorPackMember(PackAnimal var1);

    public void setAfterPackMember(PackAnimal var1);

    default public void joinPackOf(PackAnimal caravanHeadIn) {
        this.setPriorPackMember(caravanHeadIn);
        caravanHeadIn.setAfterPackMember(this);
        this.resetPackFlags();
    }

    default public void leavePack() {
        if (this.getPriorPackMember() != null) {
            this.getPriorPackMember().setAfterPackMember(null);
        }
        this.setPriorPackMember(null);
        this.resetPackFlags();
    }

    default public void resetPackFlags() {
    }
}


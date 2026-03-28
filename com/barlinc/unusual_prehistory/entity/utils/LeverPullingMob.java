/*
 * Decompiled with CFR 0.152.
 */
package com.barlinc.unusual_prehistory.entity.utils;

public interface LeverPullingMob {
    public int getPullLeverCooldown();

    public void setPullLeverCooldown(int var1);

    default public boolean canPullLever() {
        return this.getPullLeverCooldown() == 0;
    }

    default public void pullLever() {
    }
}


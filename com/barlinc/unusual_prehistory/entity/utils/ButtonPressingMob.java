/*
 * Decompiled with CFR 0.152.
 */
package com.barlinc.unusual_prehistory.entity.utils;

public interface ButtonPressingMob {
    public int getPushButtonCooldown();

    public void setPushButtonCooldown(int var1);

    default public boolean canPushButton() {
        return this.getPushButtonCooldown() == 0;
    }

    default public void pressButton() {
    }
}


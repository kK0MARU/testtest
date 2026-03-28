/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.control.LookControl
 */
package com.barlinc.unusual_prehistory.entity.ai.control;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.LookControl;

public class PrehistoricFlyingLookControl
extends LookControl {
    private final int maxYRotFromCenter;

    public PrehistoricFlyingLookControl(Mob mob, int maxYRotFromCenter) {
        super(mob);
        this.maxYRotFromCenter = maxYRotFromCenter;
    }

    public void m_8128_() {
        if (this.f_186068_ > 0) {
            --this.f_186068_;
            this.m_180896_().ifPresent(f -> {
                this.f_24937_.f_20885_ = this.m_24956_(this.f_24937_.f_20885_, f.floatValue() + 20.0f, this.f_24938_);
            });
            this.m_180897_().ifPresent(f -> this.f_24937_.m_146926_(this.m_24956_(this.f_24937_.m_146909_(), f.floatValue() + 1.0f, this.f_24939_)));
        } else {
            if (this.f_24937_.m_21573_().m_26571_()) {
                this.f_24937_.m_146926_(this.m_24956_(this.f_24937_.m_146909_(), 0.0f, 5.0f));
            }
            this.f_24937_.f_20885_ = this.m_24956_(this.f_24937_.f_20885_, this.f_24937_.f_20883_, this.f_24938_);
        }
        float f2 = Mth.m_14177_((float)(this.f_24937_.f_20885_ - this.f_24937_.f_20883_));
        if (f2 < (float)(-this.maxYRotFromCenter)) {
            this.f_24937_.f_20883_ -= 4.0f;
        } else if (f2 > (float)this.maxYRotFromCenter) {
            this.f_24937_.f_20883_ += 4.0f;
        }
    }
}


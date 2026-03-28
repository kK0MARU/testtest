/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.PathfinderMob
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import net.minecraft.world.entity.PathfinderMob;

public class SemiAquaticRandomStrollGoal
extends PrehistoricRandomStrollGoal {
    protected final SemiAquaticMob semiAquaticMob;

    public SemiAquaticRandomStrollGoal(SemiAquaticMob mob, double speedModifier) {
        this(mob, speedModifier, 120);
    }

    public SemiAquaticRandomStrollGoal(SemiAquaticMob mob, double speedModifier, int interval) {
        super((PathfinderMob)mob, speedModifier, interval, false);
        this.semiAquaticMob = mob;
    }

    public boolean m_8036_() {
        return super.m_8036_() && this.semiAquaticMob.isLandNavigator && !this.semiAquaticMob.m_20069_();
    }

    public boolean m_8045_() {
        return super.m_8045_() && this.semiAquaticMob.isLandNavigator && !this.semiAquaticMob.m_20069_();
    }
}


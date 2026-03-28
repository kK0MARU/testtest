/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;

public class EnterWaterGoal
extends Goal {
    protected final SemiAquaticMob semiAquaticMob;
    private final double speedModifier;
    private final int maxTimeOnLand;
    private BlockPos waterPos;

    public EnterWaterGoal(SemiAquaticMob semiAquaticMob, double speedModifier, int maxTimeOnLand) {
        this.semiAquaticMob = semiAquaticMob;
        this.speedModifier = speedModifier;
        this.maxTimeOnLand = maxTimeOnLand;
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean m_8036_() {
        if (this.semiAquaticMob.m_20069_()) {
            return false;
        }
        if (this.semiAquaticMob.getTimeInWater() != 0 || this.semiAquaticMob.getTimeOnLand() <= this.maxTimeOnLand) {
            return false;
        }
        return this.findWaterPos();
    }

    public boolean m_8045_() {
        return !this.semiAquaticMob.m_21573_().m_26571_();
    }

    public void m_8056_() {
        this.semiAquaticMob.m_21573_().m_26519_((double)this.waterPos.m_123341_(), (double)this.waterPos.m_123342_(), (double)this.waterPos.m_123343_(), this.speedModifier);
    }

    private boolean findWaterPos() {
        RandomSource random = this.semiAquaticMob.m_217043_();
        BlockPos.MutableBlockPos mutablePos = this.semiAquaticMob.m_20183_().m_122032_();
        for (int i = 0; i < 10; ++i) {
            mutablePos.m_122184_(random.m_188503_(20) - 10, random.m_188503_(6) - 3, random.m_188503_(20) - 10);
            if (!this.semiAquaticMob.m_9236_().m_6425_((BlockPos)mutablePos).m_205070_(FluidTags.f_13131_)) continue;
            this.waterPos = mutablePos.m_7949_();
            return true;
        }
        return false;
    }
}


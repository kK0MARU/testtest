/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;

public class LeaveWaterGoal
extends Goal {
    protected final SemiAquaticMob semiAquaticMob;
    private final double speedModifier;
    private final int maxTimeInWater;
    private final int maxTimeOnLand;
    private BlockPos landPos;

    public LeaveWaterGoal(SemiAquaticMob semiAquaticMob, double speedModifier, int maxTimeInWater, int maxTimeOnLand) {
        this.semiAquaticMob = semiAquaticMob;
        this.speedModifier = speedModifier;
        this.maxTimeInWater = maxTimeInWater;
        this.maxTimeOnLand = maxTimeOnLand;
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean m_8036_() {
        if (!this.semiAquaticMob.m_20069_()) {
            return false;
        }
        if (this.semiAquaticMob.getTimeInWater() <= this.maxTimeInWater || this.semiAquaticMob.getTimeOnLand() >= this.maxTimeOnLand) {
            return false;
        }
        return this.findLandPos();
    }

    public boolean m_8045_() {
        return this.semiAquaticMob.m_20069_();
    }

    public void m_8056_() {
        this.semiAquaticMob.m_21573_().m_26519_((double)this.landPos.m_123341_(), (double)this.landPos.m_123342_(), (double)this.landPos.m_123343_(), this.speedModifier);
    }

    public void m_8037_() {
        if (this.semiAquaticMob.f_19862_ && this.semiAquaticMob.m_20069_()) {
            float yRot = this.semiAquaticMob.m_146908_() * ((float)Math.PI / 180);
            this.semiAquaticMob.m_20256_(this.semiAquaticMob.m_20184_().m_82520_((double)(-Mth.m_14031_((float)yRot) * 0.2f), 0.1, (double)(Mth.m_14089_((float)yRot) * 0.2f)));
        }
    }

    private boolean findLandPos() {
        RandomSource random = this.semiAquaticMob.m_217043_();
        Level level = this.semiAquaticMob.m_9236_();
        BlockPos.MutableBlockPos mutablePos = this.semiAquaticMob.m_20183_().m_122032_();
        for (int i = 0; i < 10; ++i) {
            mutablePos.m_122184_(random.m_188503_(20) - 10, 1 + random.m_188503_(6), random.m_188503_(20) - 10);
            if (!level.m_8055_((BlockPos)mutablePos).m_60804_((BlockGetter)level, (BlockPos)mutablePos) || !level.m_8055_(mutablePos.m_7494_()).m_60795_() || mutablePos.m_123342_() < this.semiAquaticMob.m_20183_().m_123342_()) continue;
            this.landPos = mutablePos.m_7949_();
            return true;
        }
        return false;
    }
}


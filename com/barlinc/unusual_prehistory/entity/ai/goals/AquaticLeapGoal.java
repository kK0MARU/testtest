/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.ai.goal.JumpGoal
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.LeapingMob;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.goal.JumpGoal;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;

public class AquaticLeapGoal
extends JumpGoal {
    private static final int[] STEPS_TO_CHECK = new int[]{0, 1, 4, 5, 6, 7};
    protected final PrehistoricMob prehistoricMob;
    protected final int interval;
    protected boolean breached;
    protected final double jumpDistance;
    protected final double jumpHeight;

    public AquaticLeapGoal(PrehistoricMob prehistoricMob) {
        this(prehistoricMob, 10, 0.6, 0.7);
    }

    public AquaticLeapGoal(PrehistoricMob prehistoricMob, int interval, double jumpDistance, double jumpHeight) {
        this.prehistoricMob = prehistoricMob;
        this.interval = AquaticLeapGoal.m_186073_((int)interval);
        this.jumpDistance = jumpDistance;
        this.jumpHeight = jumpHeight;
    }

    public boolean m_8036_() {
        if (this.prehistoricMob.m_217043_().m_188503_(this.interval) != 0) {
            return false;
        }
        Direction direction = this.prehistoricMob.m_6374_();
        int i = direction.m_122429_();
        int j = direction.m_122431_();
        BlockPos blockpos = this.prehistoricMob.m_20183_();
        for (int k : STEPS_TO_CHECK) {
            if (this.waterIsClear(blockpos, i, j, k) && this.surfaceIsClear(blockpos, i, j, k)) continue;
            return false;
        }
        return true;
    }

    private boolean waterIsClear(BlockPos pos, int x, int z, int scale) {
        BlockPos blockpos = pos.m_7918_(x * scale, 0, z * scale);
        return this.prehistoricMob.m_9236_().m_6425_(blockpos).m_205070_(FluidTags.f_13131_) && !this.prehistoricMob.m_9236_().m_8055_(blockpos).m_280555_();
    }

    private boolean surfaceIsClear(BlockPos pPos, int pDx, int pDz, int pScale) {
        return this.prehistoricMob.m_9236_().m_8055_(pPos.m_7918_(pDx * pScale, 1, pDz * pScale)).m_60795_() && this.prehistoricMob.m_9236_().m_8055_(pPos.m_7918_(pDx * pScale, 2, pDz * pScale)).m_60795_();
    }

    public boolean m_8045_() {
        double y = this.prehistoricMob.m_20184_().f_82480_;
        return !(y * y < (double)0.03f && this.prehistoricMob.m_146909_() != 0.0f && Math.abs(this.prehistoricMob.m_146909_()) < 10.0f && this.prehistoricMob.m_20069_() || this.prehistoricMob.m_20096_() || !((LeapingMob)((Object)this.prehistoricMob)).isLeaping());
    }

    public boolean m_6767_() {
        return false;
    }

    public void m_8056_() {
        Direction direction = this.prehistoricMob.m_6374_();
        this.prehistoricMob.m_20256_(this.prehistoricMob.m_20184_().m_82520_((double)direction.m_122429_() * this.jumpDistance, this.jumpHeight, (double)direction.m_122431_() * this.jumpDistance));
        this.prehistoricMob.m_21573_().m_26573_();
        PrehistoricMob prehistoricMob = this.prehistoricMob;
        if (prehistoricMob instanceof LeapingMob) {
            LeapingMob leapingMob = (LeapingMob)((Object)prehistoricMob);
            leapingMob.setLeaping(true);
        }
    }

    public void m_8041_() {
        this.prehistoricMob.m_146926_(0.0f);
        PrehistoricMob prehistoricMob = this.prehistoricMob;
        if (prehistoricMob instanceof LeapingMob) {
            LeapingMob leapingMob = (LeapingMob)((Object)prehistoricMob);
            leapingMob.setLeaping(false);
        }
    }

    public void m_8037_() {
        boolean flag = this.breached;
        if (!flag) {
            FluidState fluidstate = this.prehistoricMob.m_9236_().m_6425_(this.prehistoricMob.m_20183_());
            this.breached = fluidstate.m_205070_(FluidTags.f_13131_);
        }
        if (this.breached && !flag) {
            this.prehistoricMob.m_5496_(SoundEvents.f_11805_, 1.0f, 1.0f);
        }
        Vec3 vec3 = this.prehistoricMob.m_20184_();
        if (vec3.f_82480_ * vec3.f_82480_ < (double)0.03f && this.prehistoricMob.m_146909_() != 0.0f) {
            this.prehistoricMob.m_146926_(Mth.m_14189_((float)0.2f, (float)this.prehistoricMob.m_146909_(), (float)0.0f));
        } else if (vec3.m_82553_() > (double)1.0E-5f) {
            double horizontalDistance = vec3.m_165924_();
            double xRot = Math.atan2(-vec3.f_82480_, horizontalDistance) * 57.2957763671875;
            this.prehistoricMob.m_146926_((float)xRot);
            this.prehistoricMob.m_146922_((float)Mth.m_14136_((double)this.prehistoricMob.m_6374_().m_122431_(), (double)this.prehistoricMob.m_6374_().m_122429_()) * 57.295776f - 90.0f);
        }
    }
}


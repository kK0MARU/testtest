/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_1;

import com.barlinc.unusual_prehistory.entity.mob.update_1.Dromaeosaurus;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

public class DromaeosaurusLeapGoal
extends Goal {
    protected final Dromaeosaurus dromaeosaurus;

    public DromaeosaurusLeapGoal(Dromaeosaurus dromaeosaurus) {
        this.dromaeosaurus = dromaeosaurus;
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean m_8036_() {
        return (!this.dromaeosaurus.isEepy() || this.dromaeosaurus.m_21223_() <= this.dromaeosaurus.m_21233_() * 0.5f) && !this.dromaeosaurus.m_20160_() && this.dromaeosaurus.m_20142_() && this.dromaeosaurus.leapCooldown == 0;
    }

    public boolean m_8045_() {
        return this.m_8036_();
    }

    public void m_8037_() {
        this.dromaeosaurus.m_21573_().m_26573_();
        if (this.dromaeosaurus.m_20096_()) {
            this.dromaeosaurus.m_246865_(new Vec3(0.0, 0.8, 0.0));
            this.dromaeosaurus.m_246865_(this.dromaeosaurus.m_20154_().m_82490_(2.0).m_82542_(0.6, 0.0, 0.6));
            this.dromaeosaurus.leapCooldown = 120 + this.dromaeosaurus.m_217043_().m_188503_(120);
        }
    }
}


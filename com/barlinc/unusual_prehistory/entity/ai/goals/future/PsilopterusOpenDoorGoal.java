/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.goal.DoorInteractGoal
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.future;

import com.barlinc.unusual_prehistory.entity.mob.future.Psilopterus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.goal.DoorInteractGoal;
import net.minecraft.world.phys.Vec3;

public class PsilopterusOpenDoorGoal
extends DoorInteractGoal {
    private final Psilopterus psilopterus;
    private int timer;

    public PsilopterusOpenDoorGoal(Psilopterus psilopterus) {
        super((Mob)psilopterus);
        this.psilopterus = psilopterus;
    }

    public void m_8056_() {
        this.timer = 0;
    }

    public boolean m_8036_() {
        return super.m_8036_() && !this.m_25200_() && this.psilopterus.m_20089_() == Pose.STANDING;
    }

    public boolean m_8045_() {
        return !this.m_25200_();
    }

    public void m_8037_() {
        super.m_8037_();
        Vec3 vec3 = Vec3.m_82512_((Vec3i)this.f_25190_);
        if (!this.m_25200_() && this.psilopterus.m_20238_(vec3) < 4.0) {
            this.psilopterus.m_7618_(EntityAnchorArgument.Anchor.EYES, vec3);
            if (this.psilopterus.m_20089_() == Pose.STANDING) {
                this.psilopterus.m_20124_(UP2Poses.POKING.get());
            }
        }
        if (this.psilopterus.m_20089_() == UP2Poses.POKING.get()) {
            ++this.timer;
            if (this.timer == 6) {
                this.m_25195_(true);
                this.timer = 0;
            }
        }
    }
}


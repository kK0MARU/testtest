/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_4;

import com.barlinc.unusual_prehistory.entity.mob.update_4.Lystrosaurus;
import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.phys.Vec3;

public class LystrosaurusRunLikeCrazyGoal
extends Goal {
    protected final Lystrosaurus lystrosaurus;
    protected double wantedX;
    protected double wantedY;
    protected double wantedZ;

    public LystrosaurusRunLikeCrazyGoal(Lystrosaurus lystrosaurus) {
        this.lystrosaurus = lystrosaurus;
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean m_8036_() {
        if (this.lystrosaurus.m_20160_()) {
            return false;
        }
        Vec3 vec3 = this.getPosition();
        if (vec3 == null) {
            return false;
        }
        if (this.lystrosaurus.m_21223_() <= this.lystrosaurus.m_21233_() * 0.6f) {
            this.wantedX = vec3.f_82479_;
            this.wantedY = vec3.f_82480_;
            this.wantedZ = vec3.f_82481_;
            return true;
        }
        return false;
    }

    @Nullable
    protected Vec3 getPosition() {
        return DefaultRandomPos.m_148403_((PathfinderMob)this.lystrosaurus, (int)15, (int)7);
    }

    public boolean m_8045_() {
        return !this.lystrosaurus.m_20160_() && !this.lystrosaurus.m_21573_().m_26571_();
    }

    public void m_8056_() {
        this.lystrosaurus.setRunning(true);
        this.lystrosaurus.m_21573_().m_26519_(this.wantedX, this.wantedY, this.wantedZ, 2.0);
    }

    public void m_8037_() {
        this.lystrosaurus.m_21563_().m_24950_(this.wantedX, this.wantedY, this.wantedZ, 30.0f, 30.0f);
    }

    public void m_8041_() {
        this.lystrosaurus.setRunning(false);
        this.lystrosaurus.m_21573_().m_26573_();
    }
}


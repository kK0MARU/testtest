/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.ai.util.LandRandomPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_1;

import com.barlinc.unusual_prehistory.entity.mob.update_1.Dromaeosaurus;
import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class DromaeosaurusRunGoal
extends Goal {
    protected final Dromaeosaurus dromaeosaurus;
    protected double wantedX;
    protected double wantedY;
    protected double wantedZ;

    public DromaeosaurusRunGoal(Dromaeosaurus dromaeosaurus) {
        this.dromaeosaurus = dromaeosaurus;
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean m_8036_() {
        if (this.dromaeosaurus.m_20160_()) {
            return false;
        }
        Vec3 vec3 = this.getPosition();
        if (vec3 == null) {
            return false;
        }
        if ((!this.dromaeosaurus.isEepy() || this.dromaeosaurus.m_21223_() <= this.dromaeosaurus.m_21233_() * 0.5f) && this.dromaeosaurus.m_21573_().m_26571_()) {
            this.wantedX = vec3.f_82479_;
            this.wantedY = vec3.f_82480_;
            this.wantedZ = vec3.f_82481_;
            return true;
        }
        return false;
    }

    @Nullable
    protected Vec3 getPosition() {
        if (this.dromaeosaurus.m_20069_()) {
            Vec3 randomPos = LandRandomPos.m_148488_((PathfinderMob)this.dromaeosaurus, (int)30, (int)8);
            return randomPos == null ? LandRandomPos.m_148488_((PathfinderMob)this.dromaeosaurus, (int)10, (int)7) : randomPos;
        }
        Vec3 randomPos = this.dromaeosaurus.m_217043_().m_188501_() > 0.001f ? LandRandomPos.m_148488_((PathfinderMob)this.dromaeosaurus, (int)10, (int)7) : DefaultRandomPos.m_148403_((PathfinderMob)this.dromaeosaurus, (int)10, (int)7);
        return randomPos;
    }

    public boolean m_8045_() {
        return (this.dromaeosaurus.m_9236_().m_46461_() || this.dromaeosaurus.m_21223_() <= this.dromaeosaurus.m_21233_() * 0.5f || this.dromaeosaurus.m_9236_().m_46472_() != Level.f_46428_) && !this.dromaeosaurus.m_20160_() && !this.dromaeosaurus.m_21573_().m_26571_();
    }

    public void m_8056_() {
        this.dromaeosaurus.m_21573_().m_26519_(this.wantedX, this.wantedY, this.wantedZ, 1.0);
    }

    public void m_8041_() {
        this.dromaeosaurus.m_6858_(false);
        this.dromaeosaurus.m_21573_().m_26573_();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.DataFixUtils
 *  net.minecraft.world.entity.ai.goal.Goal
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.SchoolingAquaticMob;
import com.mojang.datafixers.DataFixUtils;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.world.entity.ai.goal.Goal;

public class FollowVariantLeaderGoal
extends Goal {
    protected final SchoolingAquaticMob mob;
    private int timeToRecalcPath;
    private int nextStartTick;

    public FollowVariantLeaderGoal(SchoolingAquaticMob mob) {
        this.mob = mob;
        this.nextStartTick = this.nextStartTick(mob);
    }

    protected int nextStartTick(SchoolingAquaticMob mob) {
        return FollowVariantLeaderGoal.m_186073_((int)(200 + mob.m_217043_().m_188503_(200) % 20));
    }

    public boolean m_8036_() {
        if (this.mob.hasFollowers()) {
            return false;
        }
        if (this.mob.isFollower()) {
            return true;
        }
        if (this.nextStartTick > 0) {
            --this.nextStartTick;
            return false;
        }
        this.nextStartTick = this.nextStartTick(this.mob);
        Predicate<SchoolingAquaticMob> predicate = fishy -> fishy.canBeFollowed() || !fishy.isFollower();
        List list = this.mob.m_9236_().m_6443_(((Object)((Object)this.mob)).getClass(), this.mob.m_20191_().m_82377_(10.0, 10.0, 10.0), predicate);
        SchoolingAquaticMob schoolingFish = (SchoolingAquaticMob)((Object)DataFixUtils.orElse(list.stream().filter(SchoolingAquaticMob::canBeFollowed).findAny(), (Object)((Object)this.mob)));
        schoolingFish.addFollowers(list.stream().filter(fishy2 -> !fishy2.isFollower()));
        return this.mob.isFollower();
    }

    public boolean m_8045_() {
        return this.mob.isFollower() && this.mob.inRangeOfLeader();
    }

    public void m_8056_() {
        this.timeToRecalcPath = 0;
    }

    public void m_8041_() {
        this.mob.stopFollowing();
    }

    public void m_8037_() {
        if (this.timeToRecalcPath-- <= 0) {
            this.timeToRecalcPath = this.m_183277_(10);
            this.mob.pathToLeader();
        }
    }
}


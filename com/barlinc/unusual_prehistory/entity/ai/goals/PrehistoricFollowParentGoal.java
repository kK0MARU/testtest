/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.ai.goal.FollowParentGoal
 *  net.minecraft.world.entity.animal.Animal
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.animal.Animal;

public class PrehistoricFollowParentGoal
extends FollowParentGoal {
    protected final PrehistoricMob prehistoricMob;

    public PrehistoricFollowParentGoal(PrehistoricMob prehistoricMob, double speedModifier) {
        super((Animal)prehistoricMob, speedModifier);
        this.prehistoricMob = prehistoricMob;
    }

    public boolean m_8036_() {
        if (this.prehistoricMob.m_21188_() != null) {
            return false;
        }
        return super.m_8036_();
    }

    public boolean m_8045_() {
        if (this.prehistoricMob.m_21188_() != null) {
            return false;
        }
        return super.m_8045_();
    }
}


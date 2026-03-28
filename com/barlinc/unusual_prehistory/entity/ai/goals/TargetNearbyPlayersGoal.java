/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.player.Player
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;

public class TargetNearbyPlayersGoal
extends NearestAttackableTargetGoal<Player> {
    protected final PrehistoricMob prehistoricMob;
    protected final double distance;

    public TargetNearbyPlayersGoal(PrehistoricMob prehistoricMob) {
        this(prehistoricMob, 80, 2.0);
    }

    public TargetNearbyPlayersGoal(PrehistoricMob prehistoricMob, int interval, double distance) {
        super((Mob)prehistoricMob, Player.class, interval, true, true, null);
        this.prehistoricMob = prehistoricMob;
        this.distance = distance;
    }

    public boolean m_8036_() {
        return super.m_8036_() && !this.prehistoricMob.m_6162_() && !this.prehistoricMob.isEepy();
    }

    protected double m_7623_() {
        return this.distance;
    }
}


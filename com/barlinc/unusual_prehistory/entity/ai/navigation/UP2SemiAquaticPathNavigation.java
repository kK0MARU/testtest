/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator
 *  net.minecraft.world.level.pathfinder.PathFinder
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.ai.navigation;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class UP2SemiAquaticPathNavigation
extends WaterBoundPathNavigation {
    public UP2SemiAquaticPathNavigation(Mob mob, Level level) {
        super(mob, level);
    }

    @NotNull
    protected PathFinder m_5532_(int maxVisitedNodes) {
        this.f_26508_ = new AmphibiousNodeEvaluator(true);
        return new PathFinder(this.f_26508_, maxVisitedNodes);
    }

    protected boolean m_7632_() {
        return true;
    }

    @NotNull
    protected Vec3 m_7475_() {
        return new Vec3(this.f_26494_.m_20185_(), this.f_26494_.m_20227_(0.5), this.f_26494_.m_20189_());
    }

    public boolean m_6342_(BlockPos pos) {
        return !this.f_26495_.m_8055_(pos.m_7495_()).m_60795_();
    }
}


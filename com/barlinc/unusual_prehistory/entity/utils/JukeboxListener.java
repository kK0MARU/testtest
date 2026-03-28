/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEventListener
 *  net.minecraft.world.level.gameevent.PositionSource
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.utils;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public record JukeboxListener(PrehistoricMob mob, PositionSource listenerSource, int listenerRadius) implements GameEventListener
{
    @NotNull
    public PositionSource m_142460_() {
        return this.listenerSource;
    }

    public int m_142078_() {
        return this.listenerRadius;
    }

    public boolean m_214068_(@NotNull ServerLevel level, @NotNull GameEvent gameEvent, // Could not load outer class - annotation placement on inner may be incorrect
    @NotNull GameEvent.Context context, @NotNull Vec3 vec3) {
        if (this.mob.m_21188_() != null || this.mob.m_5448_() != null || this.mob.m_217005_() || !this.mob.canDanceToJukebox()) {
            return false;
        }
        if (gameEvent == GameEvent.f_238690_) {
            this.mob.danceToJukebox(BlockPos.m_274446_((Position)vec3), true);
            return true;
        }
        if (gameEvent == GameEvent.f_238649_) {
            this.mob.danceToJukebox(BlockPos.m_274446_((Position)vec3), false);
            return true;
        }
        return false;
    }
}


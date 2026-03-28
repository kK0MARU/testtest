/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.utils;

import com.barlinc.unusual_prehistory.events.ScreenShakeEvent;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

public class CommonProxy {
    public void commonInit() {
    }

    public void clientInit() {
    }

    public boolean isKeyDown(int keyType) {
        return false;
    }

    public Player getClientSidePlayer() {
        return null;
    }

    public boolean isFirstPersonPlayer(Entity entity) {
        return false;
    }

    public void blockRenderingEntity(UUID id) {
    }

    public void releaseRenderingEntity(UUID id) {
    }

    public void screenShake(ScreenShakeEvent event) {
    }

    public void playWorldSound(@Nullable Object soundEmitter, byte type) {
    }

    public void clearSoundCacheFor(Entity entity) {
    }

    public void clearSoundCacheFor(BlockEntity entity) {
    }
}


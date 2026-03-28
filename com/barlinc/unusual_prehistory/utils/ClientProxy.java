/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
 *  net.minecraft.client.resources.sounds.TickableSoundInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.utils;

import com.barlinc.unusual_prehistory.blocks.entity.TransmogrifierBlockEntity;
import com.barlinc.unusual_prehistory.client.sounds.AegirocassisHoverSound;
import com.barlinc.unusual_prehistory.client.sounds.BugBuzzSound;
import com.barlinc.unusual_prehistory.client.sounds.KimmeridgebrachypteraeschnidiumSound;
import com.barlinc.unusual_prehistory.client.sounds.TransmogrifierSound;
import com.barlinc.unusual_prehistory.entity.mob.base.AmbientMob;
import com.barlinc.unusual_prehistory.entity.mob.future.Aegirocassis;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Kimmeridgebrachypteraeschnidium;
import com.barlinc.unusual_prehistory.events.ClientForgeEvents;
import com.barlinc.unusual_prehistory.events.ScreenShakeEvent;
import com.barlinc.unusual_prehistory.utils.CommonProxy;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

@OnlyIn(value=Dist.CLIENT)
@Mod.EventBusSubscriber(modid="unusual_prehistory", value={Dist.CLIENT})
public class ClientProxy
extends CommonProxy {
    public static final Int2ObjectMap<AbstractTickableSoundInstance> ENTITY_SOUND_INSTANCE_MAP = new Int2ObjectOpenHashMap();
    public static final Map<BlockEntity, AbstractTickableSoundInstance> BLOCK_ENTITY_SOUND_INSTANCE_MAP = new HashMap<BlockEntity, AbstractTickableSoundInstance>();
    public static List<UUID> blockedEntityRenders = new ArrayList<UUID>();

    @Override
    public void clientInit() {
        MinecraftForge.EVENT_BUS.register((Object)new ClientForgeEvents());
    }

    @Override
    public boolean isKeyDown(int keyType) {
        if (keyType == 0) {
            return Minecraft.m_91087_().f_91066_.f_92089_.m_90857_();
        }
        if (keyType == 1) {
            return Minecraft.m_91087_().f_91066_.f_92091_.m_90857_();
        }
        if (keyType == 3) {
            return Minecraft.m_91087_().f_91066_.f_92096_.m_90857_();
        }
        if (keyType == 4) {
            return Minecraft.m_91087_().f_91066_.f_92090_.m_90857_();
        }
        return false;
    }

    @Override
    public Player getClientSidePlayer() {
        return Minecraft.m_91087_().f_91074_;
    }

    @Override
    public boolean isFirstPersonPlayer(Entity entity) {
        return entity.equals((Object)Minecraft.m_91087_().f_91075_) && Minecraft.m_91087_().f_91066_.m_92176_().m_90612_();
    }

    @Override
    public void blockRenderingEntity(UUID id) {
        blockedEntityRenders.add(id);
    }

    @Override
    public void releaseRenderingEntity(UUID id) {
        blockedEntityRenders.remove(id);
    }

    @Override
    public void screenShake(ScreenShakeEvent event) {
        ClientForgeEvents.SCREEN_SHAKE_EVENTS.add(event);
    }

    @Override
    public void playWorldSound(@Nullable Object soundEmitter, byte type) {
        Object entity;
        if (soundEmitter instanceof Entity) {
            entity = (Entity)soundEmitter;
            if (!entity.m_9236_().f_46443_) {
                return;
            }
        }
        switch (type) {
            case 0: {
                TransmogrifierSound sound;
                TransmogrifierSound sound1;
                if (!(soundEmitter instanceof TransmogrifierBlockEntity)) break;
                TransmogrifierBlockEntity blockEntity = (TransmogrifierBlockEntity)((Object)soundEmitter);
                AbstractTickableSoundInstance oldSound = BLOCK_ENTITY_SOUND_INSTANCE_MAP.get((Object)blockEntity);
                if (oldSound == null || !(oldSound instanceof TransmogrifierSound) || !(sound1 = (TransmogrifierSound)oldSound).isSameBlockEntity(blockEntity) || oldSound.m_7801_()) {
                    sound = new TransmogrifierSound(blockEntity);
                    BLOCK_ENTITY_SOUND_INSTANCE_MAP.put(blockEntity, sound);
                } else {
                    sound = (TransmogrifierSound)oldSound;
                }
                if (this.isSoundPlaying(sound) || !sound.m_7767_()) break;
                Minecraft.m_91087_().m_91106_().m_120372_((TickableSoundInstance)sound);
                break;
            }
            case 1: {
                KimmeridgebrachypteraeschnidiumSound sound;
                KimmeridgebrachypteraeschnidiumSound sound1;
                if (!(soundEmitter instanceof Kimmeridgebrachypteraeschnidium)) break;
                entity = (Kimmeridgebrachypteraeschnidium)((Object)soundEmitter);
                AbstractTickableSoundInstance oldSound = (AbstractTickableSoundInstance)ENTITY_SOUND_INSTANCE_MAP.get(entity.m_19879_());
                if (oldSound == null || !(oldSound instanceof KimmeridgebrachypteraeschnidiumSound) || !(sound1 = (KimmeridgebrachypteraeschnidiumSound)oldSound).isSameEntity((Kimmeridgebrachypteraeschnidium)((Object)entity))) {
                    sound = new KimmeridgebrachypteraeschnidiumSound((Kimmeridgebrachypteraeschnidium)((Object)entity));
                    ENTITY_SOUND_INSTANCE_MAP.put(entity.m_19879_(), (Object)sound);
                } else {
                    sound = (KimmeridgebrachypteraeschnidiumSound)oldSound;
                }
                if (this.isSoundPlaying(sound) || !sound.m_7767_()) break;
                Minecraft.m_91087_().m_91106_().m_120372_((TickableSoundInstance)sound);
                break;
            }
            case 2: {
                AegirocassisHoverSound sound;
                AegirocassisHoverSound sound1;
                if (!(soundEmitter instanceof Aegirocassis)) break;
                entity = (Aegirocassis)soundEmitter;
                AbstractTickableSoundInstance oldSound = (AbstractTickableSoundInstance)ENTITY_SOUND_INSTANCE_MAP.get(entity.m_19879_());
                if (oldSound == null || !(oldSound instanceof AegirocassisHoverSound) || !(sound1 = (AegirocassisHoverSound)oldSound).isSameEntity((Aegirocassis)entity)) {
                    sound = new AegirocassisHoverSound((Aegirocassis)entity);
                    ENTITY_SOUND_INSTANCE_MAP.put(entity.m_19879_(), (Object)sound);
                } else {
                    sound = (AegirocassisHoverSound)oldSound;
                }
                if (this.isSoundPlaying(sound) || !sound.m_7767_()) break;
                Minecraft.m_91087_().m_91106_().m_120372_((TickableSoundInstance)sound);
                break;
            }
            case 3: {
                BugBuzzSound sound;
                BugBuzzSound sound1;
                if (!(soundEmitter instanceof AmbientMob)) break;
                entity = (AmbientMob)((Object)soundEmitter);
                AbstractTickableSoundInstance oldSound = (AbstractTickableSoundInstance)ENTITY_SOUND_INSTANCE_MAP.get(entity.m_19879_());
                if (oldSound == null || !(oldSound instanceof BugBuzzSound) || !(sound1 = (BugBuzzSound)oldSound).isSameEntity((AmbientMob)((Object)entity))) {
                    sound = new BugBuzzSound((AmbientMob)((Object)entity));
                    ENTITY_SOUND_INSTANCE_MAP.put(entity.m_19879_(), (Object)sound);
                } else {
                    sound = (BugBuzzSound)oldSound;
                }
                if (this.isSoundPlaying(sound) || !sound.m_7767_()) break;
                Minecraft.m_91087_().m_91106_().m_120372_((TickableSoundInstance)sound);
            }
        }
    }

    private boolean isSoundPlaying(AbstractTickableSoundInstance sound) {
        return Minecraft.m_91087_().m_91106_().f_120349_.f_120232_.contains(sound) || Minecraft.m_91087_().m_91106_().f_120349_.f_120228_.contains(sound);
    }

    @Override
    public void clearSoundCacheFor(Entity entity) {
        ENTITY_SOUND_INSTANCE_MAP.remove(entity.m_19879_());
    }

    @Override
    public void clearSoundCacheFor(BlockEntity entity) {
        BLOCK_ENTITY_SOUND_INSTANCE_MAP.remove(entity);
    }
}


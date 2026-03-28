/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance$Attenuation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.barlinc.unusual_prehistory.client.sounds;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public abstract class BlockEntityTickableSound<T extends BlockEntity>
extends AbstractTickableSoundInstance {
    protected final T blockEntity;

    public BlockEntityTickableSound(SoundEvent soundEvent, T blockEntity) {
        super(soundEvent, SoundSource.BLOCKS, SoundInstance.m_235150_());
        this.blockEntity = blockEntity;
        this.f_119580_ = SoundInstance.Attenuation.LINEAR;
        this.f_119578_ = true;
        this.f_119575_ = (double)this.blockEntity.m_58899_().m_123341_() + 0.5;
        this.f_119576_ = (double)this.blockEntity.m_58899_().m_123342_() + 0.5;
        this.f_119577_ = (double)this.blockEntity.m_58899_().m_123343_() + 0.5;
        this.f_119579_ = 0;
    }

    public boolean m_7784_() {
        return true;
    }

    public boolean isSameBlockEntity(T blockEntity) {
        return this.blockEntity.m_58899_().equals((Object)blockEntity.m_58899_());
    }
}


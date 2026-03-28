/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance$Attenuation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.barlinc.unusual_prehistory.client.sounds;

import com.barlinc.unusual_prehistory.entity.mob.future.Aegirocassis;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class AegirocassisHoverSound
extends AbstractTickableSoundInstance {
    protected final Aegirocassis entity;
    private int fade = 0;

    public AegirocassisHoverSound(Aegirocassis entity) {
        super((SoundEvent)UP2SoundEvents.AEGIROCASSIS_HOVER.get(), SoundSource.NEUTRAL, SoundInstance.m_235150_());
        this.entity = entity;
        this.f_119575_ = (float)entity.m_20185_();
        this.f_119576_ = (float)entity.m_20186_();
        this.f_119577_ = (float)entity.m_20189_();
        this.f_119578_ = true;
        this.f_119579_ = 0;
        this.f_119580_ = SoundInstance.Attenuation.LINEAR;
    }

    public void m_7788_() {
        if (this.entity.m_213877_()) {
            this.m_119609_();
            return;
        }
        this.f_119575_ = (float)this.entity.m_20185_();
        this.f_119576_ = (float)this.entity.m_20186_();
        this.f_119577_ = (float)this.entity.m_20189_();
        if (this.entity.isLeaping()) {
            this.f_119574_ = 1.0f;
            if (this.fade > 0) {
                --this.fade;
            }
        } else {
            ++this.fade;
        }
        this.f_119573_ = Mth.m_14036_((float)(1.0f - (float)this.fade / 40.0f), (float)0.0f, (float)1.0f);
        if (this.fade > 40) {
            this.m_119609_();
        }
    }

    public boolean m_7784_() {
        return true;
    }

    public boolean m_7767_() {
        return !this.entity.m_20067_() && this.entity.m_6084_() && this.entity.isLeaping();
    }

    public boolean isSameEntity(Aegirocassis entity) {
        return this.entity.m_6084_() && this.entity.m_19879_() == entity.m_19879_();
    }
}


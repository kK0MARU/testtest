/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.barlinc.unusual_prehistory.client.sounds;

import com.barlinc.unusual_prehistory.entity.mob.update_1.Kimmeridgebrachypteraeschnidium;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class KimmeridgebrachypteraeschnidiumSound
extends AbstractTickableSoundInstance {
    protected final Kimmeridgebrachypteraeschnidium entity;

    public KimmeridgebrachypteraeschnidiumSound(Kimmeridgebrachypteraeschnidium entity) {
        super((SoundEvent)UP2SoundEvents.KIMMERIDGEBRACHYPTERAESCHNIDIUM_LOOP.get(), SoundSource.NEUTRAL, SoundInstance.m_235150_());
        this.entity = entity;
        this.f_119575_ = (float)entity.m_20185_();
        this.f_119576_ = (float)entity.m_20186_();
        this.f_119577_ = (float)entity.m_20189_();
        this.f_119578_ = true;
        this.f_119579_ = 0;
        this.f_119573_ = 0.0f;
    }

    public void m_7788_() {
        if (this.entity.m_213877_()) {
            this.m_119609_();
            return;
        }
        this.f_119575_ = (float)this.entity.m_20185_();
        this.f_119576_ = (float)this.entity.m_20186_();
        this.f_119577_ = (float)this.entity.m_20189_();
        float horizontalDistance = (float)this.entity.m_20184_().m_165924_();
        if (this.entity.m_29443_()) {
            this.f_119574_ = Mth.m_14179_((float)Mth.m_14036_((float)horizontalDistance, (float)1.5f, (float)1.75f), (float)1.5f, (float)1.75f);
            this.f_119573_ = Mth.m_14179_((float)Mth.m_14036_((float)horizontalDistance, (float)0.0f, (float)0.25f), (float)0.2f, (float)0.3f);
        } else {
            this.f_119573_ = 0.0f;
            this.f_119574_ = 0.0f;
        }
    }

    public boolean m_7784_() {
        return true;
    }

    public boolean m_7767_() {
        return !this.entity.m_20067_() && this.entity.m_6084_();
    }

    public boolean isSameEntity(Kimmeridgebrachypteraeschnidium entity) {
        return this.entity.m_6084_() && this.entity.m_19879_() == entity.m_19879_();
    }
}


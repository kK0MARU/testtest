/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.barlinc.unusual_prehistory.client.sounds;

import com.barlinc.unusual_prehistory.blocks.entity.TransmogrifierBlockEntity;
import com.barlinc.unusual_prehistory.client.sounds.BlockEntityTickableSound;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class TransmogrifierSound
extends BlockEntityTickableSound<TransmogrifierBlockEntity> {
    private int fade = 0;

    public TransmogrifierSound(TransmogrifierBlockEntity blockEntity) {
        super((SoundEvent)UP2SoundEvents.TRANSMOGRIFIER_LOOP.get(), blockEntity);
        this.f_119573_ = 0.1f;
    }

    public boolean m_7767_() {
        return !((TransmogrifierBlockEntity)this.blockEntity).m_58901_();
    }

    @Override
    public boolean isSameBlockEntity(TransmogrifierBlockEntity blockEntity) {
        return super.isSameBlockEntity(blockEntity);
    }

    public void m_7788_() {
        if (((TransmogrifierBlockEntity)this.blockEntity).isTransmogrifying()) {
            this.f_119575_ = (double)((TransmogrifierBlockEntity)this.blockEntity).m_58899_().m_123341_() + 0.5;
            this.f_119576_ = (double)((TransmogrifierBlockEntity)this.blockEntity).m_58899_().m_123342_() + 0.5;
            this.f_119577_ = (double)((TransmogrifierBlockEntity)this.blockEntity).m_58899_().m_123343_() + 0.5;
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
}


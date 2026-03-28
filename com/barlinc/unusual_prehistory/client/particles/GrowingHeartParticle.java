/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.particle.SpriteSet
 *  net.minecraft.client.particle.TextureSheetParticle
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.util.Mth
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class GrowingHeartParticle
extends TextureSheetParticle {
    public GrowingHeartParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z, 0.0, 0.0, 0.0);
        this.f_172259_ = true;
        this.f_172258_ = 0.86f;
        this.f_107215_ *= (double)0.01f;
        this.f_107216_ *= (double)0.01f;
        this.f_107217_ *= (double)0.01f;
        this.f_107663_ *= 1.5f;
        this.f_107219_ = false;
        this.f_107225_ = 20 + level.m_213780_().m_188503_(10);
    }

    public void m_5989_() {
        this.f_107209_ = this.f_107212_;
        this.f_107210_ = this.f_107213_;
        this.f_107211_ = this.f_107214_;
        if (this.f_107224_++ < this.f_107225_) {
            this.m_6257_(this.f_107215_, this.f_107216_, this.f_107217_);
        } else {
            this.m_107274_();
        }
    }

    @NotNull
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107430_;
    }

    public float m_5902_(float scaleFactor) {
        return this.f_107663_ * Mth.m_14036_((float)(((float)this.f_107224_ + scaleFactor) / (float)this.f_107225_ * 4.0f), (float)0.0f, (float)1.0f);
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Provider
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            GrowingHeartParticle heartParticle = new GrowingHeartParticle(level, x, y, z);
            heartParticle.m_108335_(this.sprite);
            return heartParticle;
        }
    }
}


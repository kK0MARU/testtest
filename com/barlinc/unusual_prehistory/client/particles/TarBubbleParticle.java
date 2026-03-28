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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class TarBubbleParticle
extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected TarBubbleParticle(ClientLevel level, double x, double y, double z, double xspeed, double yspeed, double zspeed, SpriteSet sprites) {
        super(level, x, y, z);
        this.sprites = sprites;
        this.m_107250_(0.02f, 0.02f);
        this.f_107663_ = 0.1f + level.f_46441_.m_188501_() * 0.2f;
        this.f_107215_ = xspeed * (double)0.2f + (Math.random() * 2.0 - 1.0) * (double)0.02f;
        this.f_107216_ = yspeed * (double)0.3f + (Math.random() * 2.0 - 1.0) * (double)0.02f;
        this.f_107217_ = zspeed * (double)0.2f + (Math.random() * 2.0 - 1.0) * (double)0.02f;
        this.f_107225_ = 10 + level.m_213780_().m_188503_(10);
        this.m_108339_(sprites);
    }

    public void m_5989_() {
        this.f_107209_ = this.f_107212_;
        this.f_107210_ = this.f_107213_;
        this.f_107211_ = this.f_107214_;
        if (this.f_107224_++ < this.f_107225_) {
            this.m_108339_(this.sprites);
            this.f_107216_ += 0.003;
            this.m_6257_(this.f_107215_, this.f_107216_, this.f_107217_);
            this.f_107215_ *= (double)0.85f;
            this.f_107216_ *= (double)0.85f;
            this.f_107217_ *= (double)0.85f;
        } else {
            this.m_107274_();
        }
    }

    @NotNull
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107430_;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Provider
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double xspeed, double yspeed, double zspeed) {
            return new TarBubbleParticle(level, x, y, z, xspeed, yspeed, zspeed, this.sprites);
        }
    }
}


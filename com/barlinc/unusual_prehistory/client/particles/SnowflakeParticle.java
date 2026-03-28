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
public class SnowflakeParticle
extends TextureSheetParticle {
    public SnowflakeParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        float f;
        this.f_107227_ = f = this.f_107223_.m_188501_() * 0.1f + 0.2f;
        this.f_107228_ = f;
        this.f_107229_ = f;
        this.m_107250_(0.02f, 0.02f);
        this.f_107663_ *= this.f_107223_.m_188501_() * 0.6f + 0.5f;
        this.f_107215_ *= (double)0.02f;
        this.f_107216_ *= (double)0.02f;
        this.f_107217_ *= (double)0.02f;
        this.f_107225_ = (int)(20.0 / (Math.random() * 0.8 + 0.2));
    }

    @NotNull
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107430_;
    }

    public void m_6257_(double x, double y, double z) {
        this.m_107259_(this.m_107277_().m_82386_(x, y, z));
        this.m_107275_();
    }

    public void m_5989_() {
        this.f_107209_ = this.f_107212_;
        this.f_107210_ = this.f_107213_;
        this.f_107211_ = this.f_107214_;
        if (this.f_107225_-- <= 0) {
            this.m_107274_();
        } else {
            this.m_6257_(this.f_107215_, this.f_107216_, this.f_107217_);
            this.f_107215_ *= 0.99;
            this.f_107216_ *= 0.99;
            this.f_107217_ *= 0.99;
        }
    }

    public static class Provider
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprite) {
            this.sprite = pSprite;
        }

        public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            SnowflakeParticle particle = new SnowflakeParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.m_108335_(this.sprite);
            particle.m_107253_(1.0f, 1.0f, 1.0f);
            return particle;
        }
    }
}


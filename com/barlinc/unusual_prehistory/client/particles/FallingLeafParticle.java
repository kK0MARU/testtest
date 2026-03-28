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
public class FallingLeafParticle
extends TextureSheetParticle {
    private float rotSpeed;
    private final float particleRandom;
    private final float spinAcceleration;
    private final float windBig;
    private boolean swirl;
    private boolean flowAway;
    private double xaFlowScale;
    private double zaFlowScale;
    private double swirlPeriod;

    public FallingLeafParticle(ClientLevel level, double xPos, double yPos, double zPos, SpriteSet sprites, float gravityMultiplier, float windBig, boolean swirl, boolean flowAway, float size, float ySpeed) {
        super(level, xPos, yPos, zPos);
        float f;
        this.m_108337_(sprites.m_5819_(this.f_107223_.m_188503_(12), 12));
        this.rotSpeed = (float)Math.toRadians(this.f_107223_.m_188499_() ? -30.0 : 30.0);
        this.particleRandom = this.f_107223_.m_188501_();
        this.spinAcceleration = (float)Math.toRadians(this.f_107223_.m_188499_() ? -5.0 : 5.0);
        this.windBig = windBig;
        this.swirl = swirl;
        this.flowAway = flowAway;
        this.f_107225_ = 300;
        this.f_107226_ = gravityMultiplier * 1.2f * 0.0025f;
        this.f_107663_ = f = size * (this.f_107223_.m_188499_() ? 0.05f : 0.075f);
        this.m_107250_(f, f);
        this.f_172258_ = 1.0f;
        this.f_107216_ = -ySpeed;
        this.xaFlowScale = Math.cos(Math.toRadians(this.particleRandom * 60.0f)) * (double)this.windBig;
        this.zaFlowScale = Math.sin(Math.toRadians(this.particleRandom * 60.0f)) * (double)this.windBig;
        this.swirlPeriod = Math.toRadians(1000.0f + this.particleRandom * 3000.0f);
    }

    public void m_5989_() {
        this.f_107209_ = this.f_107212_;
        this.f_107210_ = this.f_107213_;
        this.f_107211_ = this.f_107214_;
        if (this.f_107225_-- <= 0) {
            this.m_107274_();
        }
        if (!this.f_107220_) {
            float f = 300 - this.f_107225_;
            float f1 = Math.min(f / 300.0f, 1.0f);
            double d0 = 0.0;
            double d1 = 0.0;
            if (this.flowAway) {
                d0 += this.xaFlowScale * Math.pow(f1, 1.25);
                d1 += this.zaFlowScale * Math.pow(f1, 1.25);
            }
            if (this.swirl) {
                d0 += (double)f1 * Math.cos((double)f1 * this.swirlPeriod) * (double)this.windBig;
                d1 += (double)f1 * Math.sin((double)f1 * this.swirlPeriod) * (double)this.windBig;
            }
            this.f_107215_ += d0 * (double)0.0025f;
            this.f_107217_ += d1 * (double)0.0025f;
            this.f_107216_ -= (double)this.f_107226_;
            this.rotSpeed += this.spinAcceleration / 20.0f;
            this.f_107204_ = this.f_107231_;
            this.f_107231_ += this.rotSpeed / 20.0f;
            this.m_6257_(this.f_107215_, this.f_107216_, this.f_107217_);
            if (this.f_107218_ || this.f_107225_ < 299 && (this.f_107215_ == 0.0 || this.f_107217_ == 0.0)) {
                this.m_107274_();
            }
            if (!this.f_107220_) {
                this.f_107215_ *= (double)this.f_172258_;
                this.f_107216_ *= (double)this.f_172258_;
                this.f_107217_ *= (double)this.f_172258_;
            }
        }
    }

    @NotNull
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107430_;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class GinkgoProvider
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public GinkgoProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(@NotNull SimpleParticleType type, @NotNull ClientLevel level, double xPos, double yPos, double zPos, double xSpeed, double ySpeed, double zSpeed) {
            return new FallingLeafParticle(level, xPos, yPos, zPos, this.sprites, 0.11f, 10.0f, true, false, 2.0f, 0.023f);
        }
    }
}


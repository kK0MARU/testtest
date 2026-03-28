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
public class ImpactStunParticle
extends TextureSheetParticle {
    private final SpriteSet sprites;
    private final float spinIncrement;

    protected ImpactStunParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites) {
        super(level, x, y, z);
        this.sprites = sprites;
        this.f_107663_ *= 1.5f;
        this.f_172258_ = 0.98f;
        this.f_107215_ = xSpeed;
        this.f_107216_ = ySpeed;
        this.f_107217_ = zSpeed;
        this.f_107225_ = 15 + level.m_213780_().m_188503_(10);
        this.f_107204_ = this.f_107231_ = (float)Math.toRadians(360.0f * this.f_107223_.m_188501_());
        this.spinIncrement = (float)(this.f_107223_.m_188499_() ? -1 : 1) * this.f_107223_.m_188501_() * 0.6f;
        this.m_108339_(sprites);
    }

    public void m_5989_() {
        super.m_5989_();
        this.m_108339_(this.sprites);
        float ageProgress = (float)this.f_107224_ / (float)this.f_107225_;
        float f = ageProgress - 0.5f;
        float f1 = 1.0f - f * 2.0f;
        this.f_107204_ = this.f_107231_;
        this.f_107231_ += f1 * this.spinIncrement;
    }

    @NotNull
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107430_;
    }

    public float m_5902_(float scaleFactor) {
        return this.f_107663_ * Mth.m_14036_((float)(((float)this.f_107224_ + scaleFactor) / (float)this.f_107225_ * 3.0f), (float)0.0f, (float)1.0f);
    }

    @OnlyIn(value=Dist.CLIENT)
    public record Provider(SpriteSet sprites) implements ParticleProvider<SimpleParticleType>
    {
        public Particle createParticle(@NotNull SimpleParticleType type, @NotNull ClientLevel level, double x, double y, double z, double xSpeed, double zSpeed, double ySpeed) {
            ImpactStunParticle particle = new ImpactStunParticle(level, x, y, z, xSpeed, zSpeed, ySpeed, this.sprites);
            particle.m_108335_(this.sprites);
            return particle;
        }
    }
}


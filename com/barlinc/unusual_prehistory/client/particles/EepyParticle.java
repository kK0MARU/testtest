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
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.barlinc.unusual_prehistory.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EepyParticle
extends TextureSheetParticle {
    private final SpriteSet spriteProvider;
    private float sinOffset;
    private float cosOffset;
    private float rotationDirection;
    private float initialX;
    private float initialZ;

    EepyParticle(ClientLevel world, double x, double y, double z, SpriteSet spriteProvider) {
        super(world, x, y, z);
        this.spriteProvider = spriteProvider;
        this.f_107226_ = -0.06f;
        this.f_107225_ = 40;
        this.sinOffset = this.f_107223_.m_188501_();
        this.cosOffset = this.f_107223_.m_188501_();
        this.rotationDirection = this.f_107223_.m_188499_() ? 1.0f : -1.0f;
        this.initialX = (float)x;
        this.initialZ = (float)z;
        this.m_108339_(spriteProvider);
    }

    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107431_;
    }

    public void m_5989_() {
        super.m_5989_();
        float xTarget = this.initialX + (float)Math.cos((float)this.f_107224_ * 0.2f + this.cosOffset * 4.0f) * 0.1f * this.rotationDirection;
        float zTarget = this.initialZ + (float)Math.sin((float)this.f_107224_ * 0.2f + this.sinOffset * 4.0f) * 0.1f * this.rotationDirection;
        this.f_107215_ = (double)0.1f * ((double)xTarget - this.f_107212_);
        this.f_107217_ = (double)0.1f * ((double)zTarget - this.f_107214_);
        this.m_107271_(1.0f - (float)this.f_107224_ / (float)this.f_107225_);
    }

    protected int m_6355_(float f) {
        BlockPos blockPos = BlockPos.m_274561_((double)this.f_107212_, (double)this.f_107213_, (double)this.f_107214_);
        if (this.f_107208_.m_46805_(blockPos)) {
            return LevelRenderer.m_109541_((BlockAndTintGetter)this.f_107208_, (BlockPos)blockPos);
        }
        return 0;
    }

    @OnlyIn(value=Dist.CLIENT)
    public record Provider(SpriteSet spriteProvider) implements ParticleProvider<SimpleParticleType>
    {
        public Particle createParticle(SimpleParticleType defaultParticleType, ClientLevel clientWorld, double d, double e, double f, double g, double h, double i) {
            return new EepyParticle(clientWorld, d, e, f, this.spriteProvider);
        }
    }
}


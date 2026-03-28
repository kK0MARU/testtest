/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.util.valueproviders.IntProvider
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.utils;

import com.barlinc.unusual_prehistory.network.ParticlePacket;
import com.barlinc.unusual_prehistory.registry.UP2Network;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class UP2ParticleUtils {
    public static void queueParticlesOnBlockFaces(Level level, BlockPos pos, ParticleOptions particle, IntProvider count) {
        for (Direction direction : Direction.values()) {
            UP2ParticleUtils.queueParticlesOnBlockFace(level, pos, particle, count, direction, () -> UP2ParticleUtils.getRandomSpeedRanges(level.f_46441_), 0.55);
        }
    }

    public static void queueParticlesOnBlockFace(Level level, BlockPos pos, ParticleOptions particleOptions, IntProvider count, Direction direction, Supplier<Vec3> supplier, double v) {
        int sample = count.m_214085_(level.f_46441_);
        for (int j = 0; j < sample; ++j) {
            UP2ParticleUtils.queueParticleOnFace(level, pos, direction, particleOptions, supplier.get(), v);
        }
    }

    public static void queueParticleOnFace(Level level, BlockPos pos, Direction direction, ParticleOptions particle, Vec3 speed, double v) {
        ParticlePacket particlePacket = new ParticlePacket();
        Vec3 vec3 = Vec3.m_82512_((Vec3i)pos);
        int stepX = direction.m_122429_();
        int stepY = direction.m_122430_();
        int stepZ = direction.m_122431_();
        double x = vec3.f_82479_ + (stepX == 0 ? Mth.m_216263_((RandomSource)level.f_46441_, (double)-0.5, (double)0.5) : (double)stepX * v);
        double y = vec3.f_82480_ + (stepY == 0 ? Mth.m_216263_((RandomSource)level.f_46441_, (double)-0.5, (double)0.5) : (double)stepY * v);
        double z = vec3.f_82481_ + (stepZ == 0 ? Mth.m_216263_((RandomSource)level.f_46441_, (double)-0.5, (double)0.5) : (double)stepZ * v);
        double xSpeed = stepX == 0 ? speed.m_7096_() : 0.0;
        double ySpeed = stepY == 0 ? speed.m_7098_() : 0.0;
        double zSpeed = stepZ == 0 ? speed.m_7094_() : 0.0;
        level.m_7106_(particle, x, y, z, xSpeed, ySpeed, zSpeed);
        particlePacket.queueParticle(particle, false, x, y, z, xSpeed, ySpeed, zSpeed);
        UP2Network.sendPacketToTrackingChunk(particlePacket, level, pos);
    }

    private static Vec3 getRandomSpeedRanges(RandomSource random) {
        return new Vec3(Mth.m_216263_((RandomSource)random, (double)-0.5, (double)0.5), Mth.m_216263_((RandomSource)random, (double)-0.5, (double)0.5), Mth.m_216263_((RandomSource)random, (double)-0.5, (double)0.5));
    }
}


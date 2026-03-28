/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleType
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.network.NetworkEvent$Context
 */
package com.barlinc.unusual_prehistory.network;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

public class ParticlePacket {
    private final List<QueuedParticle> queuedParticles = new ArrayList<QueuedParticle>();

    public ParticlePacket() {
    }

    public ParticlePacket(FriendlyByteBuf buf) {
        ParticleType type;
        int size = buf.readInt();
        for (int i = 0; i < size && (type = (ParticleType)BuiltInRegistries.f_257034_.m_7942_(buf.readInt())) != null; ++i) {
            this.queuedParticles.add(new QueuedParticle((ParticleOptions)this.readParticle(type, buf), buf.readBoolean(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble()));
        }
    }

    private <T extends ParticleOptions> T readParticle(ParticleType<T> particleType, FriendlyByteBuf buf) {
        return (T)particleType.m_123743_().m_6507_(particleType, buf);
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeInt(this.queuedParticles.size());
        for (QueuedParticle queuedParticle : this.queuedParticles) {
            int d = BuiltInRegistries.f_257034_.m_7447_((Object)queuedParticle.particleOptions.m_6012_());
            buf.writeInt(d);
            queuedParticle.particleOptions.m_7711_(buf);
            buf.writeBoolean(queuedParticle.b);
            buf.writeDouble(queuedParticle.x);
            buf.writeDouble(queuedParticle.y);
            buf.writeDouble(queuedParticle.z);
            buf.writeDouble(queuedParticle.x2);
            buf.writeDouble(queuedParticle.y2);
            buf.writeDouble(queuedParticle.z2);
        }
    }

    public void queueParticle(ParticleOptions particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {
        this.queuedParticles.add(new QueuedParticle(particleOptions, b, x, y, z, x2, y2, z2));
    }

    public void queueParticle(ParticleOptions particleOptions, boolean b, Vec3 xyz, Vec3 xyz2) {
        this.queuedParticles.add(new QueuedParticle(particleOptions, b, xyz.f_82479_, xyz.f_82480_, xyz.f_82481_, xyz2.f_82479_, xyz2.f_82480_, xyz2.f_82481_));
    }

    private record QueuedParticle(ParticleOptions particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {
    }

    public static class Handler {
        public static boolean onMessage(ParticlePacket message, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ClientLevel level = Minecraft.m_91087_().f_91073_;
                if (level == null) {
                    return;
                }
                for (QueuedParticle queuedParticle : message.queuedParticles) {
                    level.m_6493_(queuedParticle.particleOptions, queuedParticle.b, queuedParticle.x, queuedParticle.y, queuedParticle.z, queuedParticle.x2, queuedParticle.y2, queuedParticle.z2);
                }
            });
            ctx.get().setPacketHandled(true);
            return true;
        }
    }
}


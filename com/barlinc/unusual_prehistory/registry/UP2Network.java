/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.Level
 *  net.minecraftforge.network.NetworkDirection
 *  net.minecraftforge.network.NetworkRegistry$ChannelBuilder
 *  net.minecraftforge.network.PacketDistributor
 *  net.minecraftforge.network.simple.SimpleChannel
 *  net.minecraftforge.server.ServerLifecycleHooks
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.network.ManipulatorOpenInventoryPacket;
import com.barlinc.unusual_prehistory.network.MountedEntityKeyPacket;
import com.barlinc.unusual_prehistory.network.ParticlePacket;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.server.ServerLifecycleHooks;

public class UP2Network {
    public static SimpleChannel CHANNEL;
    private static int packetId;

    private static int id() {
        return packetId++;
    }

    public static void registerNetwork() {
        SimpleChannel network;
        CHANNEL = network = NetworkRegistry.ChannelBuilder.named((ResourceLocation)new ResourceLocation("unusual_prehistory", "network")).networkProtocolVersion(() -> "1.0").clientAcceptedVersions(s -> true).serverAcceptedVersions(s -> true).simpleChannel();
        network.registerMessage(UP2Network.id(), MountedEntityKeyPacket.class, MountedEntityKeyPacket::write, MountedEntityKeyPacket::read, MountedEntityKeyPacket::handle);
        network.registerMessage(UP2Network.id(), ParticlePacket.class, ParticlePacket::encode, ParticlePacket::new, ParticlePacket.Handler::onMessage);
        network.registerMessage(UP2Network.id(), ManipulatorOpenInventoryPacket.class, ManipulatorOpenInventoryPacket::encode, ManipulatorOpenInventoryPacket::decode, ManipulatorOpenInventoryPacket::handle);
    }

    public static <MSG> void sendPacketToServer(MSG message) {
        CHANNEL.sendToServer(message);
    }

    public static <MSG> void sendPacketToPlayer(MSG message, ServerPlayer player) {
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static <MSG> void sendPacketToClients(MSG message) {
        CHANNEL.send(PacketDistributor.ALL.noArg(), message);
    }

    public static <MSG> void sendPacketToTrackingChunk(MSG message, Level level, BlockPos pos) {
        CHANNEL.send(PacketDistributor.TRACKING_CHUNK.with(() -> level.m_46745_(pos)), message);
    }

    public static <MSG> void sendPacketToAll(MSG message) {
        for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().m_6846_().m_11314_()) {
            UP2Network.sendPacketNonLocal(message, player);
        }
    }

    public static <MSG> void sendPacketNonLocal(MSG msg, ServerPlayer player) {
        CHANNEL.sendTo(msg, player.f_8906_.f_9742_, NetworkDirection.PLAY_TO_CLIENT);
    }

    static {
        packetId = 0;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraftforge.fml.LogicalSide
 *  net.minecraftforge.network.NetworkEvent$Context
 */
package com.barlinc.unusual_prehistory.network;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.utils.KeybindUsingMount;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

public class MountedEntityKeyPacket {
    public int mountId;
    public int playerId;
    public int type;

    public MountedEntityKeyPacket(int mountId, int playerId, int type) {
        this.mountId = mountId;
        this.playerId = playerId;
        this.type = type;
    }

    public MountedEntityKeyPacket() {
    }

    public static MountedEntityKeyPacket read(FriendlyByteBuf buf) {
        return new MountedEntityKeyPacket(buf.readInt(), buf.readInt(), buf.readInt());
    }

    public static void write(MountedEntityKeyPacket message, FriendlyByteBuf buf) {
        buf.writeInt(message.mountId);
        buf.writeInt(message.playerId);
        buf.writeInt(message.type);
    }

    public static void handle(MountedEntityKeyPacket message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayer playerSided = ((NetworkEvent.Context)context.get()).getSender();
            if (((NetworkEvent.Context)context.get()).getDirection().getReceptionSide() == LogicalSide.CLIENT) {
                playerSided = UnusualPrehistory2.PROXY.getClientSidePlayer();
            }
            Entity parent = playerSided.m_9236_().m_6815_(message.mountId);
            Entity keyPresser = playerSided.m_9236_().m_6815_(message.playerId);
            if (keyPresser != null && parent instanceof KeybindUsingMount) {
                KeybindUsingMount mount = (KeybindUsingMount)parent;
                if (keyPresser instanceof Player && keyPresser.m_20365_(parent)) {
                    mount.onKeyPacket(keyPresser, message.type);
                }
            }
        });
        context.get().setPacketHandled(true);
    }
}


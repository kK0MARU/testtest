/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientGamePacketListener
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.entity.PartEntity
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.future;

import com.barlinc.unusual_prehistory.entity.mob.future.Wonambi;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.NotNull;

public class WonambiPart
extends PartEntity<Wonambi> {
    public final Wonambi parent;
    private final EntityDimensions dimensions;
    private final Entity connectedTo;

    public WonambiPart(Wonambi parent, Entity connectedTo, float width, float height) {
        super((Entity)parent);
        this.parent = parent;
        this.connectedTo = connectedTo;
        this.dimensions = EntityDimensions.m_20395_((float)width, (float)height);
        this.m_6210_();
    }

    @NotNull
    public EntityDimensions m_6972_(@NotNull Pose pose) {
        return this.parent == null ? this.dimensions : this.dimensions.m_20388_(this.parent.m_6134_());
    }

    @NotNull
    public InteractionResult m_6096_(@NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (this.parent == null) {
            return InteractionResult.PASS;
        }
        return this.parent.m_6096_(player, interactionHand);
    }

    public boolean m_20223_(@NotNull CompoundTag compoundTag) {
        return false;
    }

    public boolean m_5829_() {
        return this.parent != null && this.parent.m_5829_();
    }

    public boolean m_6087_() {
        return this.parent != null && this.parent.m_6087_();
    }

    public boolean m_7306_(@NotNull Entity entity) {
        return this == entity || this.parent == entity;
    }

    @NotNull
    public Packet<ClientGamePacketListener> m_5654_() {
        throw new UnsupportedOperationException();
    }

    public boolean m_6469_(@NotNull DamageSource source, float amount) {
        return !this.m_6673_(source) && this.parent.m_6469_(source, amount);
    }

    @NotNull
    public AABB m_6921_() {
        return this.m_20191_().m_82377_(2.0, 1.0, 2.0);
    }

    public boolean m_142391_() {
        return false;
    }

    public void setToTransformation(Vec3 offset, float xRot, float yRot) {
        Vec3 transformed = offset.m_82496_((float)((double)(-xRot) * (Math.PI / 180))).m_82524_((float)((double)(-yRot) * (Math.PI / 180)));
        Vec3 offseted = transformed.m_82549_(this.connectedTo.m_20182_().m_82520_(0.0, (double)(this.connectedTo.m_20206_() * 0.5f), 0.0));
        this.m_6034_(offseted.f_82479_, offseted.f_82480_ - (double)(this.m_20206_() * 0.5f), offseted.f_82481_);
    }

    public void setPosCenteredY(Vec3 pos) {
        this.m_6034_(pos.f_82479_, pos.f_82480_ - (double)(this.m_20206_() * 0.5f), pos.f_82481_);
    }

    public Vec3 centeredPosition() {
        return this.m_20182_().m_82520_(0.0, (double)(this.m_20206_() * 0.5f), 0.0);
    }

    protected void m_8097_() {
    }

    protected void m_7378_(@NotNull CompoundTag compoundTag) {
    }

    protected void m_7380_(@NotNull CompoundTag compoundTag) {
    }
}


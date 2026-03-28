/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientGamePacketListener
 *  net.minecraft.network.protocol.game.ClientboundAddEntityPacket
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.vehicle.Boat
 *  net.minecraft.world.entity.vehicle.Boat$Status
 *  net.minecraft.world.entity.vehicle.Boat$Type
 *  net.minecraft.world.entity.vehicle.ChestBoat
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.network.PlayMessages$SpawnEntity
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.misc;

import com.barlinc.unusual_prehistory.entity.utils.UP2BoatType;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;

public class UP2ChestBoat
extends ChestBoat
implements UP2BoatType {
    public UP2ChestBoat(EntityType<? extends Boat> type, Level level) {
        super(type, level);
        this.f_19850_ = true;
    }

    public UP2ChestBoat(PlayMessages.SpawnEntity spawnEntity, Level level) {
        this((EntityType<? extends Boat>)((EntityType)UP2Entities.CHEST_BOAT.get()), level);
        this.m_20011_(this.m_142242_());
    }

    public UP2ChestBoat(Level level, double x, double y, double z) {
        this((EntityType<? extends Boat>)((EntityType)UP2Entities.CHEST_BOAT.get()), level);
        this.m_6034_(x, y, z);
        this.f_19854_ = x;
        this.f_19855_ = y;
        this.f_19856_ = z;
    }

    public UP2ChestBoat(Level level, Vec3 location, UP2BoatType.Type type) {
        this(level, location.f_82479_, location.f_82480_, location.f_82481_);
        this.setUP2BoatType(type);
    }

    @NotNull
    public Packet<ClientGamePacketListener> m_5654_() {
        return new ClientboundAddEntityPacket((Entity)this);
    }

    protected void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128359_("UP2BoatType", this.getUP2BoatType().getName());
    }

    protected void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        if (compoundTag.m_128441_("UP2BoatType")) {
            this.f_19804_.m_135381_(f_38285_, (Object)UP2BoatType.Type.byName(compoundTag.m_128461_("UP2BoatType")).ordinal());
        }
    }

    protected void m_7840_(double y, boolean onGround, @NotNull BlockState state, @NotNull BlockPos pos) {
        this.f_38281_ = this.m_20184_().f_82480_;
        if (!this.m_20159_()) {
            if (onGround) {
                if (this.f_19789_ > 3.0f) {
                    if (this.f_38279_ != Boat.Status.ON_LAND) {
                        this.m_183634_();
                        return;
                    }
                    this.m_142535_(this.f_19789_, 1.0f, this.m_269291_().m_268989_());
                    if (!this.m_9236_().f_46443_ && !this.m_213877_()) {
                        this.m_6074_();
                        if (this.m_9236_().m_46469_().m_46207_(GameRules.f_46137_)) {
                            for (int i = 0; i < 3; ++i) {
                                this.m_19998_((ItemLike)this.getUP2BoatType().getPlankSupplier().get());
                            }
                            for (int j = 0; j < 2; ++j) {
                                this.m_19998_((ItemLike)Items.f_42398_);
                            }
                        }
                    }
                }
                this.m_183634_();
            } else if (!this.m_9236_().m_6425_(this.m_20183_().m_7495_()).m_205070_(FluidTags.f_13131_) && y < 0.0) {
                this.f_19789_ -= (float)y;
            }
        }
    }

    public void setUP2BoatType(UP2BoatType.Type type) {
        this.f_19804_.m_135381_(f_38285_, (Object)type.ordinal());
    }

    @Override
    public UP2BoatType.Type getUP2BoatType() {
        return UP2BoatType.Type.byId((Integer)this.f_19804_.m_135370_(f_38285_));
    }

    public void m_28464_(// Could not load outer class - annotation placement on inner may be incorrect
    @NotNull Boat.Type vanillaType) {
    }

    @NotNull
    public Item m_38369_() {
        return this.getUP2BoatType().getChestDropSupplier().get();
    }

    public // Could not load outer class - annotation placement on inner may be incorrect
    @NotNull Boat.Type m_28554_() {
        return Boat.Type.OAK;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.entity;

import com.barlinc.unusual_prehistory.registry.UP2BlockEntities;
import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ExtraDataBlockEntity
extends BlockEntity {
    private UUID owner;

    public ExtraDataBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super((BlockEntityType)UP2BlockEntities.EXTRA_DATA_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    public UUID getOwner() {
        return this.owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
        this.m_6596_();
    }

    protected void m_183515_(@NotNull CompoundTag compoundTag) {
        super.m_183515_(compoundTag);
        if (this.owner != null) {
            compoundTag.m_128362_("Owner", this.owner);
        }
    }

    public void m_142466_(@NotNull CompoundTag compoundTag) {
        super.m_142466_(compoundTag);
        if (compoundTag.m_128403_("Owner")) {
            this.owner = compoundTag.m_128342_("Owner");
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.EntityBlock
 *  net.minecraft.world.level.block.FrogspawnBlock
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.entity;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FrogspawnBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class WaterEggBlockEntity
extends FrogspawnBlock
implements EntityBlock {
    public WaterEggBlockEntity(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public RenderShape m_7514_(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    public boolean m_8133_(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, int id, int param) {
        super.m_8133_(state, level, pos, id, param);
        BlockEntity blockentity = level.m_7702_(pos);
        return blockentity != null && blockentity.m_7531_(id, param);
    }

    @Nullable
    public MenuProvider m_7246_(@NotNull BlockState state, Level level, @NotNull BlockPos pos) {
        BlockEntity blockentity = level.m_7702_(pos);
        return blockentity instanceof MenuProvider ? (MenuProvider)blockentity : null;
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> serverType, BlockEntityType<E> clientType, BlockEntityTicker<? super E> ticker) {
        return clientType == serverType ? ticker : null;
    }
}


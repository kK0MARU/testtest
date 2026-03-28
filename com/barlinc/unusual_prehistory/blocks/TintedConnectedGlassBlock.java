/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks;

import com.barlinc.unusual_prehistory.blocks.ConnectedGlassBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TintedConnectedGlassBlock
extends ConnectedGlassBlock {
    public TintedConnectedGlassBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public boolean m_7420_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos) {
        return false;
    }

    public int m_7753_(@NotNull BlockState state, BlockGetter blockGetter, @NotNull BlockPos pos) {
        return blockGetter.m_7469_();
    }
}


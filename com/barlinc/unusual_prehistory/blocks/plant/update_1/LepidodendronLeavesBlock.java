/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.LeavesBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_1;

import com.barlinc.unusual_prehistory.blocks.plant.update_1.LepidodendronConeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class LepidodendronLeavesBlock
extends LeavesBlock
implements BonemealableBlock {
    public LepidodendronLeavesBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public boolean m_7370_(LevelReader level, BlockPos blockPos, @NotNull BlockState state, boolean valid) {
        return level.m_8055_(blockPos.m_7495_()).m_60795_();
    }

    public boolean m_214167_(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos blockPos, @NotNull BlockState state) {
        return true;
    }

    public void m_214148_(ServerLevel level, @NotNull RandomSource random, BlockPos blockPos, @NotNull BlockState state) {
        level.m_7731_(blockPos.m_7495_(), LepidodendronConeBlock.createHangingCone(), 2);
    }
}


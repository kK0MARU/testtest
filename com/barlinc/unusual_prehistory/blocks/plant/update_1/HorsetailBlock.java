/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.DoublePlantBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_1;

import com.barlinc.unusual_prehistory.blocks.plant.PrehistoricPlantBlock;
import com.barlinc.unusual_prehistory.blocks.plant.PrehistoricTallPlantBlock;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class HorsetailBlock
extends PrehistoricPlantBlock
implements BonemealableBlock {
    public HorsetailBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean m_7370_(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean m_214167_(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @Override
    public void m_214148_(@NotNull ServerLevel level, @NotNull RandomSource source, @NotNull BlockPos pos, @NotNull BlockState state) {
        PrehistoricTallPlantBlock tallPlant = (PrehistoricTallPlantBlock)((Object)UP2Blocks.LARGE_HORSETAIL.get());
        if (tallPlant.m_49966_().m_60710_((LevelReader)level, pos) && level.m_46859_(pos.m_7494_())) {
            DoublePlantBlock.m_153173_((LevelAccessor)level, (BlockState)tallPlant.m_49966_(), (BlockPos)pos, (int)2);
        }
    }

    @Override
    @NotNull
    public VoxelShape m_5940_(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.m_60824_(level, pos);
        return SHAPE.m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }
}


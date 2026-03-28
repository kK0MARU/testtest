/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.common.IForgeShearable
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IForgeShearable;
import org.jetbrains.annotations.NotNull;

public class HangingLeavesBlock
extends Block
implements IForgeShearable {
    protected static final VoxelShape SHAPE = Block.m_49796_((double)2.0, (double)0.0, (double)2.0, (double)14.0, (double)16.0, (double)14.0);

    public HangingLeavesBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape m_5940_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @NotNull
    public BlockState m_7417_(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState offsetState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos offset) {
        return direction == Direction.UP && !this.m_7898_(state, (LevelReader)level, pos) ? Blocks.f_50016_.m_49966_() : super.m_7417_(state, direction, offsetState, level, pos, offset);
    }

    public boolean m_7898_(@NotNull BlockState state, LevelReader level, BlockPos pos) {
        return Block.m_49918_((VoxelShape)level.m_8055_(pos.m_7494_()).m_60812_((BlockGetter)level, pos.m_7494_()), (Direction)Direction.DOWN) && !level.m_46801_(pos);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void m_214162_(@NotNull BlockState state, Level level, BlockPos pos, @NotNull RandomSource random) {
        BlockPos blockpos;
        BlockState blockstate;
        if (!(!level.m_46758_(pos.m_7494_()) || random.m_188503_(18) != 1 || (blockstate = level.m_8055_(blockpos = pos.m_7495_())).m_60815_() && blockstate.m_60783_((BlockGetter)level, blockpos, Direction.UP))) {
            double x = (float)pos.m_123341_() + random.m_188501_();
            double y = (double)pos.m_123342_() - 0.1;
            double z = (float)pos.m_123343_() + random.m_188501_();
            level.m_7106_((ParticleOptions)ParticleTypes.f_123803_, x, y, z, 0.0, 0.0, 0.0);
        }
    }
}


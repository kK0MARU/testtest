/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class FossilizedBoneSpikeBlock
extends Block
implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.f_61362_;
    public static final DirectionProperty VERTICAL_DIRECTION = BlockStateProperties.f_155997_;
    protected static final VoxelShape UP_AABB = Block.m_49796_((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)15.0, (double)13.0);
    protected static final VoxelShape DOWN_AABB = Block.m_49796_((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)15.0, (double)13.0);

    public FossilizedBoneSpikeBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)this.m_49966_().m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false))).m_61124_((Property)VERTICAL_DIRECTION, (Comparable)Direction.UP));
    }

    public void m_142072_(@NotNull Level level, BlockState state, @NotNull BlockPos pos, @NotNull Entity entity, float fallDistance) {
        if (state.m_61143_((Property)VERTICAL_DIRECTION) == Direction.UP) {
            entity.m_142535_(fallDistance + 2.0f, 2.0f, level.m_269111_().m_269571_());
        } else {
            super.m_142072_(level, state, pos, entity, fallDistance);
        }
    }

    @NotNull
    public VoxelShape m_5940_(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return state.m_61143_((Property)VERTICAL_DIRECTION) == Direction.UP ? UP_AABB : DOWN_AABB;
    }

    @NotNull
    public BlockState m_7417_(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (((Boolean)state.m_61143_((Property)WATERLOGGED)).booleanValue()) {
            level.m_186469_(pos, (Fluid)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)level));
        }
        return direction == ((Direction)state.m_61143_((Property)VERTICAL_DIRECTION)).m_122424_() && !state.m_60710_((LevelReader)level, pos) ? Blocks.f_50016_.m_49966_() : super.m_7417_(state, direction, neighborState, level, pos, neighborPos);
    }

    public boolean m_7898_(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = (Direction)state.m_61143_((Property)VERTICAL_DIRECTION);
        BlockPos blockPos = pos.m_121945_(direction.m_122424_());
        return level.m_8055_(blockPos).m_60783_((BlockGetter)level, blockPos, direction);
    }

    @Nullable
    public BlockState m_5573_(BlockPlaceContext context) {
        Direction direction;
        BlockPos pos;
        Level level = context.m_43725_();
        Direction direction1 = FossilizedBoneSpikeBlock.calculateDirection((LevelReader)level, pos = context.m_8083_(), direction = context.m_151260_().m_122424_());
        if (direction1 == null) {
            return null;
        }
        return (BlockState)((BlockState)this.m_49966_().m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(level.m_6425_(pos).m_76152_() == Fluids.f_76193_))).m_61124_((Property)VERTICAL_DIRECTION, (Comparable)direction1);
    }

    @Nullable
    private static Direction calculateDirection(LevelReader level, BlockPos pos, Direction direction) {
        Direction direction1;
        if (FossilizedBoneSpikeBlock.isValidPlacement(level, pos, direction)) {
            direction1 = direction;
        } else {
            if (!FossilizedBoneSpikeBlock.isValidPlacement(level, pos, direction.m_122424_())) {
                return null;
            }
            direction1 = direction.m_122424_();
        }
        return direction1;
    }

    private static boolean isValidPlacement(LevelReader level, BlockPos pos, Direction direction) {
        BlockPos blockpos = pos.m_121945_(direction.m_122424_());
        BlockState blockstate = level.m_8055_(blockpos);
        return blockstate.m_60783_((BlockGetter)level, blockpos, direction);
    }

    @NotNull
    public BlockState m_6843_(BlockState state, Rotation rotation) {
        return (BlockState)state.m_61124_((Property)VERTICAL_DIRECTION, (Comparable)rotation.m_55954_((Direction)state.m_61143_((Property)VERTICAL_DIRECTION)));
    }

    @NotNull
    public BlockState m_6943_(BlockState state, Mirror mirror) {
        return state.m_60717_(mirror.m_54846_((Direction)state.m_61143_((Property)VERTICAL_DIRECTION)));
    }

    @NotNull
    public FluidState m_5888_(BlockState state) {
        return (Boolean)state.m_61143_((Property)WATERLOGGED) != false ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[]{WATERLOGGED, VERTICAL_DIRECTION});
    }

    public boolean m_7420_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos) {
        return true;
    }

    public boolean m_7357_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull PathComputationType computationType) {
        return false;
    }

    public float m_7749_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return 1.0f;
    }
}


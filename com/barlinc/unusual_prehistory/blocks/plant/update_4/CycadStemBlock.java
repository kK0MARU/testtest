/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
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
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_4;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class CycadStemBlock
extends Block
implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.f_61362_;
    public static final DirectionProperty FACING = BlockStateProperties.f_61372_;
    protected static final VoxelShape EAST_AABB = Block.m_49796_((double)0.0, (double)2.0, (double)2.0, (double)16.0, (double)14.0, (double)14.0);
    protected static final VoxelShape WEST_AABB = Block.m_49796_((double)0.0, (double)2.0, (double)2.0, (double)16.0, (double)14.0, (double)14.0);
    protected static final VoxelShape SOUTH_AABB = Block.m_49796_((double)2.0, (double)2.0, (double)0.0, (double)14.0, (double)14.0, (double)16.0);
    protected static final VoxelShape NORTH_AABB = Block.m_49796_((double)2.0, (double)2.0, (double)0.0, (double)14.0, (double)14.0, (double)16.0);
    protected static final VoxelShape UP_AABB = Block.m_49796_((double)2.0, (double)0.0, (double)2.0, (double)14.0, (double)16.0, (double)14.0);
    protected static final VoxelShape DOWN_AABB = Block.m_49796_((double)2.0, (double)0.0, (double)2.0, (double)14.0, (double)16.0, (double)14.0);

    public CycadStemBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)this.m_49966_().m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false))).m_61124_((Property)FACING, (Comparable)Direction.UP));
    }

    @NotNull
    public VoxelShape m_5940_(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch ((Direction)state.m_61143_((Property)FACING)) {
            default -> throw new IncompatibleClassChangeError();
            case Direction.DOWN -> DOWN_AABB;
            case Direction.UP -> UP_AABB;
            case Direction.NORTH -> NORTH_AABB;
            case Direction.SOUTH -> SOUTH_AABB;
            case Direction.WEST -> WEST_AABB;
            case Direction.EAST -> EAST_AABB;
        };
    }

    @NotNull
    public BlockState m_7417_(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (((Boolean)state.m_61143_((Property)WATERLOGGED)).booleanValue()) {
            level.m_186469_(pos, (Fluid)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)level));
        }
        return direction == ((Direction)state.m_61143_((Property)FACING)).m_122424_() && !state.m_60710_((LevelReader)level, pos) ? Blocks.f_50016_.m_49966_() : super.m_7417_(state, direction, neighborState, level, pos, neighborPos);
    }

    @Nullable
    public BlockState m_5573_(BlockPlaceContext context) {
        Level level = context.m_43725_();
        BlockPos pos = context.m_8083_();
        return (BlockState)((BlockState)this.m_49966_().m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(level.m_6425_(pos).m_76152_() == Fluids.f_76193_))).m_61124_((Property)FACING, (Comparable)context.m_43719_());
    }

    @NotNull
    public BlockState m_6843_(BlockState state, Rotation rotation) {
        return (BlockState)state.m_61124_((Property)FACING, (Comparable)rotation.m_55954_((Direction)state.m_61143_((Property)FACING)));
    }

    @NotNull
    public BlockState m_6943_(BlockState state, Mirror mirror) {
        return state.m_60717_(mirror.m_54846_((Direction)state.m_61143_((Property)FACING)));
    }

    @NotNull
    public FluidState m_5888_(BlockState state) {
        return (Boolean)state.m_61143_((Property)WATERLOGGED) != false ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[]{WATERLOGGED, FACING});
    }
}


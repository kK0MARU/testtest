/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.PipeBlock
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_4;

import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;

public class PrototaxitesBlock
extends Block {
    public static final BooleanProperty NORTH = PipeBlock.f_55148_;
    public static final BooleanProperty EAST = PipeBlock.f_55149_;
    public static final BooleanProperty SOUTH = PipeBlock.f_55150_;
    public static final BooleanProperty WEST = PipeBlock.f_55151_;
    public static final BooleanProperty UP = PipeBlock.f_55152_;
    public static final BooleanProperty DOWN = PipeBlock.f_55153_;
    private static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.f_55154_;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.f_61365_;

    public PrototaxitesBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)NORTH, (Comparable)Boolean.valueOf(true))).m_61124_((Property)EAST, (Comparable)Boolean.valueOf(true))).m_61124_((Property)SOUTH, (Comparable)Boolean.valueOf(true))).m_61124_((Property)WEST, (Comparable)Boolean.valueOf(true))).m_61124_((Property)UP, (Comparable)Boolean.valueOf(true))).m_61124_((Property)DOWN, (Comparable)Boolean.valueOf(true))).m_61124_(AXIS, (Comparable)Direction.Axis.Y));
    }

    @NotNull
    public BlockState m_6843_(@NotNull BlockState state, @NotNull Rotation rotation) {
        return PrototaxitesBlock.rotatePillar(state, rotation);
    }

    public static BlockState rotatePillar(BlockState state, Rotation rotation) {
        return switch (rotation) {
            case Rotation.COUNTERCLOCKWISE_90, Rotation.CLOCKWISE_90 -> {
                switch ((Direction.Axis)state.m_61143_(AXIS)) {
                    case X: {
                        yield (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)state.m_61124_(AXIS, (Comparable)Direction.Axis.Z)).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.NORTH)), (Comparable)((Boolean)state.m_61143_((Property)NORTH)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.SOUTH)), (Comparable)((Boolean)state.m_61143_((Property)SOUTH)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.EAST)), (Comparable)((Boolean)state.m_61143_((Property)EAST)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.WEST)), (Comparable)((Boolean)state.m_61143_((Property)WEST)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.UP)), (Comparable)((Boolean)state.m_61143_((Property)UP)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.DOWN)), (Comparable)((Boolean)state.m_61143_((Property)DOWN)));
                    }
                    case Z: {
                        yield (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)state.m_61124_(AXIS, (Comparable)Direction.Axis.X)).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.NORTH)), (Comparable)((Boolean)state.m_61143_((Property)NORTH)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.SOUTH)), (Comparable)((Boolean)state.m_61143_((Property)SOUTH)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.EAST)), (Comparable)((Boolean)state.m_61143_((Property)EAST)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.WEST)), (Comparable)((Boolean)state.m_61143_((Property)WEST)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.UP)), (Comparable)((Boolean)state.m_61143_((Property)UP)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.DOWN)), (Comparable)((Boolean)state.m_61143_((Property)DOWN)));
                    }
                }
                yield (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)state.m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.NORTH)), (Comparable)((Boolean)state.m_61143_((Property)NORTH)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.SOUTH)), (Comparable)((Boolean)state.m_61143_((Property)SOUTH)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.EAST)), (Comparable)((Boolean)state.m_61143_((Property)EAST)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.WEST)), (Comparable)((Boolean)state.m_61143_((Property)WEST)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.UP)), (Comparable)((Boolean)state.m_61143_((Property)UP)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.DOWN)), (Comparable)((Boolean)state.m_61143_((Property)DOWN)));
            }
            default -> state;
        };
    }

    private static void setPropertyByDirection(BlockState state, Rotation rotation) {
        ((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)state.m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.NORTH)), (Comparable)((Boolean)state.m_61143_((Property)NORTH)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.SOUTH)), (Comparable)((Boolean)state.m_61143_((Property)SOUTH)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.EAST)), (Comparable)((Boolean)state.m_61143_((Property)EAST)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.WEST)), (Comparable)((Boolean)state.m_61143_((Property)WEST)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.UP)), (Comparable)((Boolean)state.m_61143_((Property)UP)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(rotation.m_55954_(Direction.DOWN)), (Comparable)((Boolean)state.m_61143_((Property)DOWN)));
    }

    protected void m_7926_(// Could not load outer class - annotation placement on inner may be incorrect
     @NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[]{UP, DOWN, NORTH, EAST, SOUTH, WEST, AXIS});
    }

    @NotNull
    public BlockState m_5573_(BlockPlaceContext pContext) {
        Level blockgetter = pContext.m_43725_();
        BlockPos blockpos = pContext.m_8083_();
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.m_49966_().m_61124_(AXIS, (Comparable)pContext.m_43719_().m_122434_())).m_61124_((Property)DOWN, (Comparable)Boolean.valueOf(!blockgetter.m_8055_(blockpos.m_7495_()).m_60713_((Block)this)))).m_61124_((Property)UP, (Comparable)Boolean.valueOf(!blockgetter.m_8055_(blockpos.m_7494_()).m_60713_((Block)this)))).m_61124_((Property)NORTH, (Comparable)Boolean.valueOf(!blockgetter.m_8055_(blockpos.m_122012_()).m_60713_((Block)this)))).m_61124_((Property)EAST, (Comparable)Boolean.valueOf(!blockgetter.m_8055_(blockpos.m_122029_()).m_60713_((Block)this)))).m_61124_((Property)SOUTH, (Comparable)Boolean.valueOf(!blockgetter.m_8055_(blockpos.m_122019_()).m_60713_((Block)this)))).m_61124_((Property)WEST, (Comparable)Boolean.valueOf(!blockgetter.m_8055_(blockpos.m_122024_()).m_60713_((Block)this)));
    }

    @NotNull
    public BlockState m_7417_(@NotNull BlockState state, @NotNull Direction direction, BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        return facingState.m_60713_((Block)this) ? (BlockState)state.m_61124_((Property)PROPERTY_BY_DIRECTION.get(direction), (Comparable)Boolean.valueOf(false)) : super.m_7417_(state, direction, facingState, level, currentPos, facingPos);
    }

    @NotNull
    public BlockState m_6943_(BlockState state, Mirror mirror) {
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)state.m_61124_((Property)PROPERTY_BY_DIRECTION.get(mirror.m_54848_(Direction.NORTH)), (Comparable)((Boolean)state.m_61143_((Property)NORTH)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(mirror.m_54848_(Direction.SOUTH)), (Comparable)((Boolean)state.m_61143_((Property)SOUTH)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(mirror.m_54848_(Direction.EAST)), (Comparable)((Boolean)state.m_61143_((Property)EAST)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(mirror.m_54848_(Direction.WEST)), (Comparable)((Boolean)state.m_61143_((Property)WEST)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(mirror.m_54848_(Direction.UP)), (Comparable)((Boolean)state.m_61143_((Property)UP)))).m_61124_((Property)PROPERTY_BY_DIRECTION.get(mirror.m_54848_(Direction.DOWN)), (Comparable)((Boolean)state.m_61143_((Property)DOWN)));
    }
}


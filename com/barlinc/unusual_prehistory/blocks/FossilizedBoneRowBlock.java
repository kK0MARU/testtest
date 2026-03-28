/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.Maps
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.HorizontalDirectionalBlock
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
package com.barlinc.unusual_prehistory.blocks;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
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

public class FossilizedBoneRowBlock
extends HorizontalDirectionalBlock
implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.f_54117_;
    public static final BooleanProperty ATTACHED = BlockStateProperties.f_61386_;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.f_61362_;
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap((Map)ImmutableMap.of((Object)Direction.NORTH, (Object)Block.m_49796_((double)6.0, (double)0.0, (double)0.0, (double)10.0, (double)7.0, (double)16.0), (Object)Direction.SOUTH, (Object)Block.m_49796_((double)6.0, (double)0.0, (double)0.0, (double)10.0, (double)7.0, (double)16.0), (Object)Direction.EAST, (Object)Block.m_49796_((double)0.0, (double)0.0, (double)6.0, (double)16.0, (double)7.0, (double)10.0), (Object)Direction.WEST, (Object)Block.m_49796_((double)0.0, (double)0.0, (double)6.0, (double)16.0, (double)7.0, (double)10.0)));
    private static final Map<Direction, VoxelShape> ATTACHED_AABBS = Maps.newEnumMap((Map)ImmutableMap.of((Object)Direction.NORTH, (Object)Block.m_49796_((double)6.0, (double)9.0, (double)0.0, (double)10.0, (double)16.0, (double)16.0), (Object)Direction.SOUTH, (Object)Block.m_49796_((double)6.0, (double)9.0, (double)0.0, (double)10.0, (double)16.0, (double)16.0), (Object)Direction.EAST, (Object)Block.m_49796_((double)0.0, (double)9.0, (double)6.0, (double)16.0, (double)16.0, (double)10.0), (Object)Direction.WEST, (Object)Block.m_49796_((double)0.0, (double)9.0, (double)6.0, (double)16.0, (double)16.0, (double)10.0)));

    public FossilizedBoneRowBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)FACING, (Comparable)Direction.NORTH)).m_61124_((Property)ATTACHED, (Comparable)Boolean.valueOf(false)));
    }

    @NotNull
    public VoxelShape m_5940_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return (Boolean)state.m_61143_((Property)ATTACHED) != false ? ATTACHED_AABBS.get(state.m_61143_((Property)FACING)) : AABBS.get(state.m_61143_((Property)FACING));
    }

    @NotNull
    public BlockState m_7417_(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (((Boolean)state.m_61143_((Property)WATERLOGGED)).booleanValue()) {
            level.m_186469_(pos, (Fluid)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)level));
        }
        return super.m_7417_(state, direction, neighborState, level, pos, neighborPos);
    }

    public BlockState m_5573_(BlockPlaceContext context) {
        Level level = context.m_43725_();
        BlockPos blockpos = context.m_8083_().m_7494_();
        BlockState blockstate = level.m_8055_(blockpos);
        FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        boolean facingDown = Block.m_49918_((VoxelShape)blockstate.m_60812_((BlockGetter)level, blockpos), (Direction)Direction.DOWN);
        return (BlockState)((BlockState)((BlockState)this.m_49966_().m_61124_((Property)FACING, (Comparable)context.m_8125_().m_122424_())).m_61124_((Property)ATTACHED, (Comparable)Boolean.valueOf(facingDown))).m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(fluidstate.m_205070_(FluidTags.f_13131_) && fluidstate.m_76186_() == 8));
    }

    @NotNull
    public FluidState m_5888_(BlockState state) {
        return (Boolean)state.m_61143_((Property)WATERLOGGED) != false ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.m_61104_(new Property[]{FACING, ATTACHED, WATERLOGGED});
    }
}


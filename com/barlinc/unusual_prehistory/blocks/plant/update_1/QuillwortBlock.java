/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.BushBlock
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_1;

import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class QuillwortBlock
extends BushBlock
implements SimpleWaterloggedBlock,
BonemealableBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.f_61362_;
    protected static final VoxelShape SHAPE = Block.m_49796_((double)2.0, (double)0.0, (double)2.0, (double)14.0, (double)13.0, (double)14.0);

    public QuillwortBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)this.m_49966_().m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected boolean m_6266_(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return state.m_204336_(UP2BlockTags.ANCIENT_PLANT_PLACEABLE);
    }

    public boolean m_7898_(BlockState state, @NotNull LevelReader level, BlockPos pos) {
        BlockPos blockPos = pos.m_7495_();
        BlockPos blockPos1 = pos.m_7494_();
        return state.m_60734_() == this ? level.m_8055_(blockPos).m_60783_((BlockGetter)level, blockPos, Direction.UP) && !level.m_8055_(blockPos1).m_60819_().m_205070_(FluidTags.f_13131_) : this.m_6266_(level.m_8055_(blockPos), (BlockGetter)level, blockPos);
    }

    @NotNull
    public VoxelShape m_5940_(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @NotNull
    public BlockState m_7417_(@NotNull BlockState state, @NotNull Direction facing, @NotNull BlockState state1, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos pos1) {
        if (facing == Direction.DOWN && !state.m_60710_((LevelReader)level, pos)) {
            return Blocks.f_50016_.m_49966_();
        }
        if (((Boolean)state.m_61143_((Property)WATERLOGGED)).booleanValue()) {
            level.m_186469_(pos, (Fluid)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)level));
        }
        return super.m_7417_(state, facing, state1, level, pos, pos1);
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[]{WATERLOGGED});
    }

    @Nullable
    public BlockState m_5573_(BlockPlaceContext context) {
        FluidState state = context.m_43725_().m_6425_(context.m_8083_());
        return (BlockState)this.m_49966_().m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(state.m_205070_(FluidTags.f_13131_) && state.m_76186_() == 8));
    }

    @NotNull
    public FluidState m_5888_(BlockState pState) {
        return (Boolean)pState.m_61143_((Property)WATERLOGGED) != false ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(pState);
    }

    public boolean m_7370_(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
        return true;
    }

    public boolean m_214167_(@NotNull Level level, @NotNull RandomSource source, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    public void m_214148_(@NotNull ServerLevel level, @NotNull RandomSource source, @NotNull BlockPos pos, @NotNull BlockState state) {
        QuillwortBlock.m_49840_((Level)level, (BlockPos)pos, (ItemStack)new ItemStack((ItemLike)this));
    }
}


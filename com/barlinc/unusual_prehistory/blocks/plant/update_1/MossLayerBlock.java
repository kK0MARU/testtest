/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.MultifaceBlock
 *  net.minecraft.world.level.block.MultifaceSpreader
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_1;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

public class MossLayerBlock
extends MultifaceBlock
implements BonemealableBlock,
SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.f_61362_;
    private final MultifaceSpreader spreader = new MultifaceSpreader((MultifaceBlock)this);

    public MossLayerBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.m_49959_((BlockState)this.m_49966_().m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected void m_7926_(// Could not load outer class - annotation placement on inner may be incorrect
     @NotNull StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[]{WATERLOGGED});
    }

    @NotNull
    public BlockState m_7417_(BlockState state, @NotNull Direction direction, @NotNull BlockState blockstate, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos blockpos) {
        if (((Boolean)state.m_61143_((Property)WATERLOGGED)).booleanValue()) {
            level.m_186469_(pos, (Fluid)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)level));
        }
        return super.m_7417_(state, direction, blockstate, level, pos, blockpos);
    }

    public boolean m_6864_(@NotNull BlockState state, BlockPlaceContext context) {
        return !context.m_43722_().m_150930_(Items.f_151025_) || super.m_6864_(state, context);
    }

    public boolean m_7370_(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean client) {
        return Direction.m_235666_().anyMatch(direction -> this.spreader.m_221601_(state, (BlockGetter)level, pos, direction.m_122424_()));
    }

    public boolean m_214167_(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    public void m_214148_(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        this.spreader.m_221619_(state, (LevelAccessor)level, pos, random);
    }

    @NotNull
    public FluidState m_5888_(BlockState state) {
        return (Boolean)state.m_61143_((Property)WATERLOGGED) != false ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }

    public boolean m_7420_(BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos) {
        return state.m_60819_().m_76178_();
    }

    @NotNull
    public MultifaceSpreader m_213612_() {
        return this.spreader;
    }
}


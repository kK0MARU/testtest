/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.AbstractGlassBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;

public class ConnectedGlassBlock
extends AbstractGlassBlock {
    public static final BooleanProperty UP = BooleanProperty.m_61465_((String)"up");
    public static final BooleanProperty DOWN = BooleanProperty.m_61465_((String)"down");
    public static final BooleanProperty EAST = BooleanProperty.m_61465_((String)"east");
    public static final BooleanProperty WEST = BooleanProperty.m_61465_((String)"west");
    public static final BooleanProperty NORTH = BooleanProperty.m_61465_((String)"north");
    public static final BooleanProperty SOUTH = BooleanProperty.m_61465_((String)"south");

    public ConnectedGlassBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)UP, (Comparable)Boolean.valueOf(false))).m_61124_((Property)DOWN, (Comparable)Boolean.valueOf(false))).m_61124_((Property)EAST, (Comparable)Boolean.valueOf(false))).m_61124_((Property)WEST, (Comparable)Boolean.valueOf(false))).m_61124_((Property)NORTH, (Comparable)Boolean.valueOf(false))).m_61124_((Property)SOUTH, (Comparable)Boolean.valueOf(false)));
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[]{UP, DOWN, NORTH, SOUTH, EAST, WEST});
    }

    public BlockState m_5573_(BlockPlaceContext context) {
        Level level = context.m_43725_();
        BlockPos blockpos = context.m_8083_();
        BlockPos north = blockpos.m_122012_();
        BlockPos east = blockpos.m_122029_();
        BlockPos south = blockpos.m_122019_();
        BlockPos west = blockpos.m_122024_();
        BlockPos up = blockpos.m_7494_();
        BlockPos down = blockpos.m_7495_();
        BlockState northState = level.m_8055_(north);
        BlockState eastState = level.m_8055_(east);
        BlockState southState = level.m_8055_(south);
        BlockState westState = level.m_8055_(west);
        BlockState upState = level.m_8055_(up);
        BlockState downState = level.m_8055_(down);
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.m_49966_().m_61124_((Property)NORTH, (Comparable)Boolean.valueOf(northState.m_60713_((Block)this)))).m_61124_((Property)NORTH, (Comparable)Boolean.valueOf(northState.m_60713_((Block)this)))).m_61124_((Property)EAST, (Comparable)Boolean.valueOf(eastState.m_60713_((Block)this)))).m_61124_((Property)SOUTH, (Comparable)Boolean.valueOf(southState.m_60713_((Block)this)))).m_61124_((Property)WEST, (Comparable)Boolean.valueOf(westState.m_60713_((Block)this)))).m_61124_((Property)UP, (Comparable)Boolean.valueOf(upState.m_60713_((Block)this)))).m_61124_((Property)DOWN, (Comparable)Boolean.valueOf(downState.m_60713_((Block)this)));
    }

    @NotNull
    public BlockState m_7417_(BlockState state, @NotNull Direction direction, @NotNull BlockState state2, LevelAccessor level, BlockPos blockpos, @NotNull BlockPos pos2) {
        BlockPos north = blockpos.m_122012_();
        BlockPos east = blockpos.m_122029_();
        BlockPos south = blockpos.m_122019_();
        BlockPos west = blockpos.m_122024_();
        BlockPos up = blockpos.m_7494_();
        BlockPos down = blockpos.m_7495_();
        BlockState northState = level.m_8055_(north);
        BlockState eastState = level.m_8055_(east);
        BlockState southState = level.m_8055_(south);
        BlockState westState = level.m_8055_(west);
        BlockState upState = level.m_8055_(up);
        BlockState downState = level.m_8055_(down);
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)state.m_61124_((Property)NORTH, (Comparable)Boolean.valueOf(northState.m_60713_((Block)this)))).m_61124_((Property)NORTH, (Comparable)Boolean.valueOf(northState.m_60713_((Block)this)))).m_61124_((Property)EAST, (Comparable)Boolean.valueOf(eastState.m_60713_((Block)this)))).m_61124_((Property)SOUTH, (Comparable)Boolean.valueOf(southState.m_60713_((Block)this)))).m_61124_((Property)WEST, (Comparable)Boolean.valueOf(westState.m_60713_((Block)this)))).m_61124_((Property)UP, (Comparable)Boolean.valueOf(upState.m_60713_((Block)this)))).m_61124_((Property)DOWN, (Comparable)Boolean.valueOf(downState.m_60713_((Block)this)));
    }
}


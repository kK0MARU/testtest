/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.egg;

import com.barlinc.unusual_prehistory.blocks.egg.EggBlock;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class TallEggBlock
extends EggBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.f_61401_;
    private final VoxelShape upperShape;

    public TallEggBlock(BlockBehaviour.Properties properties, Supplier<EntityType<?>> hatchedEntity, int widthPx, int heightPx, int topWidthPx, int topHeightPx, boolean canTrample) {
        super(properties, hatchedEntity, widthPx, heightPx, canTrample);
        int px = (16 - topWidthPx) / 2;
        this.upperShape = Block.m_49796_((double)px, (double)0.0, (double)px, (double)(16 - px), (double)topHeightPx, (double)(16 - px));
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(HALF, (Comparable)DoubleBlockHalf.LOWER)).m_61124_((Property)HATCH, (Comparable)Integer.valueOf(0)));
    }

    @Override
    public void m_213897_(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (state.m_61143_(HALF) == DoubleBlockHalf.LOWER && this.canHatch((BlockGetter)level, pos)) {
            if (!this.isReadyToHatch(state)) {
                level.m_5594_(null, pos, SoundEvents.f_276434_, SoundSource.BLOCKS, 0.7f, 0.9f + random.m_188501_() * 0.2f);
                level.m_7731_(pos.m_7494_(), (BlockState)((BlockState)state.m_61124_(HALF, (Comparable)DoubleBlockHalf.UPPER)).m_61124_((Property)HATCH, (Comparable)Integer.valueOf(this.getHatchLevel(level.m_8055_(pos.m_7494_())) + 1)), 2);
                level.m_7731_(pos, (BlockState)state.m_61124_((Property)HATCH, (Comparable)Integer.valueOf(this.getHatchLevel(state) + 1)), 2);
            } else {
                this.spawnEntity(level, pos, state, random);
            }
        }
    }

    @Nullable
    public BlockState m_5573_(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos = blockPlaceContext.m_8083_();
        Level level = blockPlaceContext.m_43725_();
        if (blockPos.m_123342_() < level.m_151558_() - 1 && level.m_8055_(blockPos.m_7494_()).m_60629_(blockPlaceContext)) {
            return super.m_5573_(blockPlaceContext);
        }
        return null;
    }

    @Override
    public void m_6402_(Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, LivingEntity livingEntity, @NotNull ItemStack itemStack) {
        super.m_6402_(level, blockPos, blockState, livingEntity, itemStack);
        BlockPos blockPos2 = blockPos.m_7494_();
        level.m_7731_(blockPos2, TallEggBlock.copyWaterloggedFrom((LevelReader)level, blockPos2, (BlockState)this.m_49966_().m_61124_(HALF, (Comparable)DoubleBlockHalf.UPPER)), 3);
    }

    public boolean m_7898_(BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
        if (blockState.m_61143_(HALF) == DoubleBlockHalf.UPPER) {
            BlockState blockState2 = levelReader.m_8055_(blockPos.m_7495_());
            return blockState2.m_60713_((Block)this) && blockState2.m_61143_(HALF) == DoubleBlockHalf.LOWER;
        }
        return super.m_7898_(blockState, levelReader, blockPos);
    }

    public static BlockState copyWaterloggedFrom(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        if (blockState.m_61138_((Property)BlockStateProperties.f_61362_)) {
            return (BlockState)blockState.m_61124_((Property)BlockStateProperties.f_61362_, (Comparable)Boolean.valueOf(levelReader.m_46801_(blockPos)));
        }
        return blockState;
    }

    public void m_5707_(Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull Player player) {
        if (!level.f_46443_) {
            if (player.m_7500_()) {
                TallEggBlock.preventCreativeDropFromBottomPart(level, blockPos, blockState, player);
            } else {
                TallEggBlock.m_49881_((BlockState)blockState, (Level)level, (BlockPos)blockPos, null, (Entity)player, (ItemStack)player.m_21205_());
            }
        }
        super.m_5707_(level, blockPos, blockState, player);
    }

    public void m_6240_(@NotNull Level level, @NotNull Player player, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable BlockEntity blockEntity, @NotNull ItemStack itemStack) {
        super.m_6240_(level, player, blockPos, Blocks.f_50016_.m_49966_(), blockEntity, itemStack);
    }

    protected static void preventCreativeDropFromBottomPart(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        BlockPos blockPos2;
        BlockState blockState2;
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)blockState.m_61143_(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.UPPER && (blockState2 = level.m_8055_(blockPos2 = blockPos.m_7495_())).m_60713_(blockState.m_60734_()) && blockState2.m_61143_(HALF) == DoubleBlockHalf.LOWER) {
            BlockState blockState3 = blockState2.m_60819_().m_192917_((Fluid)Fluids.f_76193_) ? Blocks.f_49990_.m_49966_() : Blocks.f_50016_.m_49966_();
            level.m_7731_(blockPos2, blockState3, 35);
            level.m_5898_(player, 2001, blockPos2, Block.m_49956_((BlockState)blockState2));
        }
    }

    @Override
    @NotNull
    public VoxelShape m_5940_(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return blockState.m_61143_(HALF) == DoubleBlockHalf.LOWER ? this.shape : this.upperShape;
    }

    @NotNull
    public BlockState m_7417_(BlockState blockState, Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)blockState.m_61143_(HALF);
        if (!(direction.m_122434_() != Direction.Axis.Y || doubleBlockHalf == DoubleBlockHalf.LOWER != (direction == Direction.UP) || blockState2.m_60713_((Block)this) && blockState2.m_61143_(HALF) != doubleBlockHalf)) {
            return Blocks.f_50016_.m_49966_();
        }
        if (doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !blockState.m_60710_((LevelReader)levelAccessor, blockPos)) {
            return Blocks.f_50016_.m_49966_();
        }
        return super.m_7417_(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Override
    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[]{HALF});
    }
}


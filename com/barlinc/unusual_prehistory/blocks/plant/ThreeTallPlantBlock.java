/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.IntegerProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant;

import com.barlinc.unusual_prehistory.blocks.plant.PrehistoricPlantBlock;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class ThreeTallPlantBlock
extends PrehistoricPlantBlock
implements BonemealableBlock {
    public static final IntegerProperty LAYER = IntegerProperty.m_61631_((String)"layer", (int)0, (int)2);
    protected static final VoxelShape BOTTOM_SHAPE = Block.m_49796_((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)16.0, (double)12.0);
    protected static final VoxelShape TOP_SHAPE = Block.m_49796_((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)14.0, (double)12.0);

    public ThreeTallPlantBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public boolean m_7898_(BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        if ((Integer)state.m_61143_((Property)LAYER) == 0) {
            return super.m_7898_(state, level, pos);
        }
        BlockState blockstate = level.m_8055_(pos.m_7495_());
        if (state.m_60734_() != this) {
            return super.m_7898_(state, level, pos);
        }
        return blockstate.m_60734_() == this;
    }

    @Nullable
    public BlockState m_5573_(BlockPlaceContext context) {
        BlockPos blockpos = context.m_8083_();
        return blockpos.m_123342_() < context.m_43725_().m_151558_() - 1 && context.m_43725_().m_8055_(blockpos.m_7494_()).m_60629_(context) && context.m_43725_().m_8055_(blockpos.m_6630_(2)).m_60629_(context) ? super.m_5573_(context) : null;
    }

    public void m_6402_(Level level, @NotNull BlockPos pos, @NotNull BlockState state, LivingEntity placer, @NotNull ItemStack stack) {
        level.m_7731_(pos, (BlockState)this.m_49966_().m_61124_((Property)LAYER, (Comparable)Integer.valueOf(0)), 2);
        level.m_7731_(pos.m_7494_(), (BlockState)this.m_49966_().m_61124_((Property)LAYER, (Comparable)Integer.valueOf(1)), 2);
        level.m_7731_(pos.m_6630_(2), (BlockState)this.m_49966_().m_61124_((Property)LAYER, (Comparable)Integer.valueOf(2)), 2);
    }

    public void m_5707_(@NotNull Level level, @NotNull BlockPos pos, BlockState state, @NotNull Player player) {
        if ((Integer)state.m_61143_((Property)LAYER) == 0) {
            if (!player.m_7500_()) {
                level.m_46961_(pos, true);
                level.m_46961_(pos.m_7494_(), false);
                level.m_46961_(pos.m_6630_(2), false);
            } else {
                level.m_46961_(pos, false);
                level.m_46961_(pos.m_7494_(), false);
                level.m_46961_(pos.m_6630_(2), false);
            }
        } else if ((Integer)state.m_61143_((Property)LAYER) == 1) {
            if (!player.m_7500_()) {
                level.m_46961_(pos.m_7495_(), true);
                level.m_46961_(pos, false);
                level.m_46961_(pos.m_7494_(), false);
            } else {
                level.m_46961_(pos.m_7495_(), false);
                level.m_46961_(pos, false);
                level.m_46961_(pos.m_7494_(), false);
            }
        } else if ((Integer)state.m_61143_((Property)LAYER) == 2) {
            if (!player.m_7500_()) {
                level.m_46961_(pos.m_6625_(2), true);
                level.m_46961_(pos.m_7495_(), false);
                level.m_46961_(pos, false);
            } else {
                level.m_46961_(pos.m_6625_(2), false);
                level.m_46961_(pos.m_7495_(), false);
                level.m_46961_(pos, false);
            }
        }
        super.m_5707_(level, pos, state, player);
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[]{LAYER});
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
    public void m_214148_(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        ThreeTallPlantBlock.m_49840_((Level)level, (BlockPos)pos, (ItemStack)new ItemStack((ItemLike)this));
    }

    @Override
    @NotNull
    public VoxelShape m_5940_(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.m_60824_(blockGetter, pos);
        if ((Integer)state.m_61143_((Property)LAYER) == 2) {
            return TOP_SHAPE.m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
        }
        return BOTTOM_SHAPE.m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }
}


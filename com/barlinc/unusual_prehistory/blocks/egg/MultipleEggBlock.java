/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.IntegerProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.egg;

import com.barlinc.unusual_prehistory.blocks.egg.EggBlock;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class MultipleEggBlock
extends EggBlock {
    private final VoxelShape multipleShape;
    public static final IntegerProperty EGGS = BlockStateProperties.f_61415_;
    private final int maxEggs;

    public MultipleEggBlock(BlockBehaviour.Properties properties, Supplier<EntityType<?>> hatchedEntity, int maxEggs, int widthPx, int heightPx, int multipleWidthPx, int multipleHeightPx, boolean canTrample) {
        super(properties, hatchedEntity, widthPx, heightPx, canTrample);
        this.maxEggs = maxEggs;
        int px = (16 - multipleWidthPx) / 2;
        this.multipleShape = Block.m_49796_((double)px, (double)0.0, (double)px, (double)(16 - px), (double)multipleHeightPx, (double)(16 - px));
        this.m_49959_((BlockState)((BlockState)this.m_49966_().m_61124_((Property)HATCH, (Comparable)Integer.valueOf(0))).m_61124_((Property)EGGS, (Comparable)Integer.valueOf(1)));
    }

    protected void removeOneEgg(Level level, BlockPos pos, BlockState state) {
        level.m_5594_(null, pos, SoundEvents.f_12533_, SoundSource.BLOCKS, 0.7f, 0.9f + level.f_46441_.m_188501_() * 0.2f);
        int i = (Integer)state.m_61143_((Property)EGGS);
        if (i <= 1) {
            level.m_46961_(pos, false);
        } else {
            level.m_7731_(pos, (BlockState)state.m_61124_((Property)EGGS, (Comparable)Integer.valueOf(i - 1)), 2);
            level.m_220407_(GameEvent.f_157794_, pos, GameEvent.Context.m_223722_((BlockState)state));
            level.m_46796_(2001, pos, Block.m_49956_((BlockState)state));
        }
    }

    public void m_6240_(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable BlockEntity blockEntity, @NotNull ItemStack stack) {
        super.m_6240_(level, player, pos, state, blockEntity, stack);
        this.removeOneEgg(level, pos, state);
    }

    @Override
    @NotNull
    public VoxelShape m_5940_(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return (Integer)state.m_61143_((Property)EGGS) > 1 ? this.multipleShape : this.shape;
    }

    public boolean m_6864_(@NotNull BlockState state, BlockPlaceContext context) {
        return context.m_43722_().m_41720_() == this.m_5456_() && (Integer)state.m_61143_((Property)EGGS) < this.maxEggs || super.m_6864_(state, context);
    }

    @Nullable
    public BlockState m_5573_(BlockPlaceContext context) {
        BlockState blockstate = context.m_43725_().m_8055_(context.m_8083_());
        return blockstate.m_60734_() == this ? (BlockState)blockstate.m_61124_((Property)EGGS, (Comparable)Integer.valueOf(Math.min(this.maxEggs, (Integer)blockstate.m_61143_((Property)EGGS) + 1))) : super.m_5573_(context);
    }

    @Override
    protected int getMobsBornFrom(BlockState state) {
        return (Integer)state.m_61143_((Property)EGGS);
    }

    @Override
    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[]{EGGS});
    }
}


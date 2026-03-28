/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.shapes.BooleanOp
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_4;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class CycadCrownBlock
extends Block
implements BonemealableBlock {
    public static final VoxelShape SHAPE = CycadCrownBlock.buildShape(Block.m_49796_((double)4.0, (double)4.0, (double)4.0, (double)12.0, (double)13.0, (double)12.0), Block.m_49796_((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)4.0, (double)16.0));

    public CycadCrownBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public boolean m_7370_(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
        return true;
    }

    public boolean m_214167_(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    public void m_214148_(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        CycadCrownBlock.m_49840_((Level)level, (BlockPos)pos, (ItemStack)new ItemStack((ItemLike)UP2Blocks.CYCAD_SEEDLING.get()));
    }

    @NotNull
    public VoxelShape m_5940_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    private static VoxelShape buildShape(VoxelShape ... from) {
        return Stream.of(from).reduce((v1, v2) -> Shapes.m_83113_((VoxelShape)v1, (VoxelShape)v2, (BooleanOp)BooleanOp.f_82695_)).get();
    }

    public boolean m_7357_(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull PathComputationType type) {
        return false;
    }

    public float m_7749_(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos blockPos) {
        return 1.0f;
    }

    public boolean m_7420_(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos blockPos) {
        return true;
    }
}


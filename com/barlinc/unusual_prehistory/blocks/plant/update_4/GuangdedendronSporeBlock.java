/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BambooLeaves
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.common.ToolActions
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_4;

import com.barlinc.unusual_prehistory.blocks.plant.update_4.GuangdedendronStalkBlock;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

public class GuangdedendronSporeBlock
extends Block
implements BonemealableBlock {
    protected static final VoxelShape SHAPE = Block.m_49796_((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)12.0, (double)12.0);

    public GuangdedendronSporeBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    @NotNull
    public VoxelShape m_5940_(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Vec3 vec3 = state.m_60824_(getter, pos);
        return SHAPE.m_83216_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_);
    }

    public void m_213898_(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, RandomSource random) {
        if (random.m_188503_(3) == 0 && level.m_46859_(pos.m_7494_()) && level.m_45524_(pos.m_7494_(), 0) >= 9) {
            this.growGuangdedendron((Level)level, pos);
        }
    }

    public boolean m_7898_(@NotNull BlockState state, LevelReader level, BlockPos pos) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.GUANGDEDENDRON_PLANTABLE_ON);
    }

    @NotNull
    public BlockState m_7417_(BlockState state, @NotNull Direction direction, @NotNull BlockState state1, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos pos1) {
        if (!state.m_60710_((LevelReader)level, pos)) {
            return Blocks.f_50016_.m_49966_();
        }
        if (direction == Direction.UP && state1.m_60713_((Block)UP2Blocks.GUANGDEDENDRON.get())) {
            level.m_7731_(pos, ((Block)UP2Blocks.GUANGDEDENDRON.get()).m_49966_(), 2);
        }
        return super.m_7417_(state, direction, state1, level, pos, pos1);
    }

    @NotNull
    public ItemStack m_7397_(@NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull BlockState state) {
        return new ItemStack((ItemLike)UP2Blocks.GUANGDEDENDRON.get());
    }

    public boolean m_7370_(LevelReader level, BlockPos pos, @NotNull BlockState state, boolean isClient) {
        return level.m_8055_(pos.m_7494_()).m_60795_();
    }

    public boolean m_214167_(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    public void m_214148_(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        this.growGuangdedendron((Level)level, pos);
    }

    public float m_5880_(@NotNull BlockState state, Player player, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return player.m_21205_().canPerformAction(ToolActions.SWORD_DIG) ? 1.0f : super.m_5880_(state, player, getter, pos);
    }

    protected void growGuangdedendron(Level level, BlockPos state) {
        level.m_7731_(state.m_7494_(), (BlockState)((Block)UP2Blocks.GUANGDEDENDRON.get()).m_49966_().m_61124_(GuangdedendronStalkBlock.LEAVES, (Comparable)BambooLeaves.SMALL), 3);
    }
}


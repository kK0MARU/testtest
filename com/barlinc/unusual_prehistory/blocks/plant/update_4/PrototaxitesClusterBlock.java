/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.BushBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.feature.ConfiguredFeature
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.common.IPlantable
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.event.level.SaplingGrowTreeEvent
 *  net.minecraftforge.eventbus.api.Event$Result
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_4;

import com.barlinc.unusual_prehistory.registry.UP2Features;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import org.jetbrains.annotations.NotNull;

public class PrototaxitesClusterBlock
extends BushBlock
implements BonemealableBlock {
    protected static final VoxelShape SHAPE = Block.m_49796_((double)2.0, (double)0.0, (double)2.0, (double)14.0, (double)13.0, (double)14.0);

    public PrototaxitesClusterBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape m_5940_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    protected boolean m_6266_(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return state.m_60804_(level, pos);
    }

    public boolean m_7898_(@NotNull BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.m_7495_();
        BlockState blockstate = level.m_8055_(blockpos);
        if (blockstate.m_204336_(BlockTags.f_13057_)) {
            return true;
        }
        return blockstate.canSustainPlant((BlockGetter)level, blockpos, Direction.UP, (IPlantable)this);
    }

    public boolean growPrototaxites(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        Optional optional = level.m_9598_().m_175515_(Registries.f_256911_).m_203636_(UP2Features.PROTOTAXITES);
        if (optional.isEmpty()) {
            return false;
        }
        SaplingGrowTreeEvent event = ForgeEventFactory.blockGrowFeature((LevelAccessor)level, (RandomSource)random, (BlockPos)pos, (Holder)((Holder)optional.get()));
        if (event.getResult().equals((Object)Event.Result.DENY)) {
            return false;
        }
        level.m_7471_(pos, false);
        if (((ConfiguredFeature)event.getFeature().m_203334_()).m_224953_((WorldGenLevel)level, level.m_7726_().m_8481_(), random, pos)) {
            return true;
        }
        level.m_7731_(pos, state, 3);
        return false;
    }

    public boolean m_7370_(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
        return true;
    }

    public boolean m_214167_(@NotNull Level level, RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return (double)random.m_188501_() < 0.4;
    }

    public void m_214148_(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        this.growPrototaxites(level, pos, state, random);
    }
}


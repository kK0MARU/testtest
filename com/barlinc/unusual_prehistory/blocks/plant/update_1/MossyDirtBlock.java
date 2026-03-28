/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.SnowLayerBlock
 *  net.minecraft.world.level.block.SnowyDirtBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.levelgen.placement.PlacedFeature
 *  net.minecraft.world.level.lighting.LightEngine
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_1;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Features;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.lighting.LightEngine;
import org.jetbrains.annotations.NotNull;

public class MossyDirtBlock
extends SnowyDirtBlock
implements BonemealableBlock {
    public MossyDirtBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    public boolean m_6724_(@NotNull BlockState state) {
        return true;
    }

    private static boolean canBeMossyDirt(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos abovePos = pos.m_7494_();
        BlockState aboveState = level.m_8055_(abovePos);
        if (aboveState.m_60713_(Blocks.f_50125_) && (Integer)aboveState.m_61143_((Property)SnowLayerBlock.f_56581_) == 1) {
            return true;
        }
        if (aboveState.m_60819_().m_76186_() == 8) {
            return false;
        }
        int light = LightEngine.m_284282_((BlockGetter)level, (BlockState)state, (BlockPos)pos, (BlockState)aboveState, (BlockPos)abovePos, (Direction)Direction.UP, (int)aboveState.m_60739_((BlockGetter)level, abovePos));
        return light < level.m_7469_();
    }

    private static boolean canPropagate(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.m_7494_();
        return MossyDirtBlock.canBeMossyDirt(state, level, pos) && !level.m_6425_(blockpos).m_205070_(FluidTags.f_13131_);
    }

    public void m_213898_(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (!MossyDirtBlock.canBeMossyDirt(state, (LevelReader)level, pos)) {
            if (!level.isAreaLoaded(pos, 1)) {
                return;
            }
            level.m_46597_(pos, Blocks.f_50493_.m_49966_());
        } else {
            if (!level.isAreaLoaded(pos, 3)) {
                return;
            }
            if (level.m_46803_(pos.m_7494_()) >= 9) {
                BlockState blockstate = this.m_49966_();
                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.m_7918_(random.m_188503_(3) - 1, random.m_188503_(5) - 3, random.m_188503_(3) - 1);
                    if (!level.m_8055_(blockpos).m_60713_(Blocks.f_50493_) || !MossyDirtBlock.canPropagate(blockstate, (LevelReader)level, blockpos)) continue;
                    level.m_46597_(blockpos, (BlockState)blockstate.m_61124_((Property)f_56637_, (Comparable)Boolean.valueOf(level.m_8055_(blockpos.m_7494_()).m_60713_(Blocks.f_50125_))));
                }
            }
        }
    }

    public boolean m_7370_(LevelReader level, BlockPos pos, @NotNull BlockState state, boolean valid) {
        return level.m_8055_(pos.m_7494_()).m_60795_();
    }

    public boolean m_214167_(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    public void m_214148_(ServerLevel level, @NotNull RandomSource random, BlockPos pos, @NotNull BlockState state) {
        BlockPos abovePos = pos.m_7494_();
        BlockState blockState = ((Block)UP2Blocks.HORSETAIL.get()).m_49966_();
        Optional mossLayer = level.m_9598_().m_175515_(Registries.f_256988_).m_203636_(UP2Features.MOSS_LAYER_BONEMEAL);
        Optional patch = level.m_9598_().m_175515_(Registries.f_256988_).m_203636_(UP2Features.PATCH_MOSSY_DIRT_PLANTS);
        block0: for (int i = 0; i < 128; ++i) {
            Holder featureHolder;
            BlockPos blockpos = abovePos;
            for (int j = 0; j < i / 16; ++j) {
                if (!level.m_8055_((blockpos = blockpos.m_7918_(random.m_188503_(3) - 1, (random.m_188503_(3) - 1) * random.m_188503_(3) / 2, random.m_188503_(3) - 1)).m_7495_()).m_60713_((Block)this) || level.m_8055_(blockpos).m_60838_((BlockGetter)level, blockpos)) continue block0;
            }
            BlockState state1 = level.m_8055_(blockpos);
            if (state1.m_60713_(blockState.m_60734_()) && random.m_188503_(10) == 0) {
                ((BonemealableBlock)blockState.m_60734_()).m_214148_(level, random, blockpos, state1);
            }
            if (!state1.m_60795_()) continue;
            if (random.m_188503_(4) == 0) {
                if (patch.isEmpty()) continue;
                featureHolder = (Holder)patch.get();
            } else {
                if (mossLayer.isEmpty()) continue;
                featureHolder = (Holder)mossLayer.get();
            }
            ((PlacedFeature)featureHolder.m_203334_()).m_226357_((WorldGenLevel)level, level.m_7726_().m_8481_(), random, blockpos);
        }
    }
}


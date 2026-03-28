/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 *  net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration
 */
package com.barlinc.unusual_prehistory.worldgen.feature;

import com.barlinc.unusual_prehistory.blocks.plant.update_1.CalamophytonBlock;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CalamophytonFeature
extends Feature<NoneFeatureConfiguration> {
    public CalamophytonFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean m_142674_(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.m_159777_();
        WorldGenLevel level = context.m_159774_();
        RandomSource random = context.m_225041_();
        int i = 0;
        for (int j = 0; j < 6; ++j) {
            int k = random.m_188503_(8) - random.m_188503_(8);
            int l = random.m_188503_(8) - random.m_188503_(8);
            int i1 = level.m_6924_(Heightmap.Types.WORLD_SURFACE, pos.m_123341_() + k, pos.m_123343_() + l);
            BlockPos blockpos = new BlockPos(pos.m_123341_() + k, i1, pos.m_123343_() + l);
            if (!this.canPlace(level, pos)) continue;
            BlockState blockstate = ((Block)UP2Blocks.CALAMOPHYTON.get()).m_49966_();
            if (blockstate.m_60710_((LevelReader)level, blockpos)) {
                level.m_7731_(blockpos, (BlockState)((Block)UP2Blocks.CALAMOPHYTON.get()).m_49966_().m_61124_((Property)CalamophytonBlock.LAYER, (Comparable)Integer.valueOf(0)), 2);
                level.m_7731_(blockpos.m_7494_(), (BlockState)((Block)UP2Blocks.CALAMOPHYTON.get()).m_49966_().m_61124_((Property)CalamophytonBlock.LAYER, (Comparable)Integer.valueOf(1)), 2);
                level.m_7731_(blockpos.m_6630_(2), (BlockState)((Block)UP2Blocks.CALAMOPHYTON.get()).m_49966_().m_61124_((Property)CalamophytonBlock.LAYER, (Comparable)Integer.valueOf(2)), 2);
            }
            ++i;
        }
        return i > 0;
    }

    private boolean canPlace(WorldGenLevel level, BlockPos pos) {
        return this.isOpenSpaceAbove(level, pos) && level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.ANCIENT_PLANT_PLACEABLE);
    }

    private boolean isOpenSpaceAbove(WorldGenLevel level, BlockPos pos) {
        return level.m_8055_(pos).m_60734_() == Blocks.f_50016_ && level.m_8055_(pos.m_7494_()).m_60734_() == Blocks.f_50016_ && level.m_8055_(pos.m_6630_(2)).m_60734_() == Blocks.f_50016_;
    }
}


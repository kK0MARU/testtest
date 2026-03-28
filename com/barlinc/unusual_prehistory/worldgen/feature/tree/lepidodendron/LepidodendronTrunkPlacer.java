/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  com.mojang.serialization.codecs.RecordCodecBuilder$Instance
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.LevelSimulatedReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration
 *  net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer$FoliageAttachment
 *  net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer
 *  net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.worldgen.feature.tree.lepidodendron;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Trees;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.jetbrains.annotations.NotNull;

public class LepidodendronTrunkPlacer
extends TrunkPlacer {
    public static final Codec<LepidodendronTrunkPlacer> CODEC = RecordCodecBuilder.create(lepidodendron -> LepidodendronTrunkPlacer.m_70305_((RecordCodecBuilder.Instance)lepidodendron).apply((Applicative)lepidodendron, LepidodendronTrunkPlacer::new));

    public LepidodendronTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @NotNull
    protected TrunkPlacerType<?> m_7362_() {
        return (TrunkPlacerType)UP2Trees.LEPIDODENDRON_TRUNK.get();
    }

    @NotNull
    public List<FoliagePlacer.FoliageAttachment> m_213934_(@NotNull LevelSimulatedReader level, @NotNull BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int height, @NotNull BlockPos startPos, @NotNull TreeConfiguration config) {
        int trunkHeight = height + random.m_216339_(this.f_70264_, this.f_70264_ + 3) + random.m_216339_(this.f_70265_ - 1, this.f_70265_ + 1);
        for (int i = 0; i < trunkHeight; ++i) {
            if (i > trunkHeight - (4 + random.m_188503_(4))) {
                blockSetter.accept(startPos.m_6630_(i), ((Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get()).m_49966_());
            } else {
                this.m_226187_(level, blockSetter, random, startPos.m_6630_(i), config);
            }
            for (Direction direction : Direction.values()) {
                if (direction == Direction.UP || direction == Direction.DOWN) continue;
                blockSetter.accept(startPos.m_6630_(trunkHeight).m_5484_(direction, 1), ((Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get()).m_49966_());
                blockSetter.accept(startPos.m_6630_(trunkHeight + 1).m_5484_(direction, 2), ((Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get()).m_49966_());
                blockSetter.accept(startPos.m_6630_(trunkHeight + 2).m_5484_(direction, 2), ((Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get()).m_49966_());
                blockSetter.accept(startPos.m_6630_(trunkHeight + 3).m_5484_(direction, 2), ((Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get()).m_49966_());
                blockSetter.accept(startPos.m_6630_(trunkHeight + 4).m_5484_(direction, 3), ((Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get()).m_49966_());
            }
        }
        return ImmutableList.of((Object)new FoliagePlacer.FoliageAttachment(startPos.m_6630_(trunkHeight), 0, false));
    }
}


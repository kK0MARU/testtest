/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.block.grower.AbstractTreeGrower
 *  net.minecraft.world.level.levelgen.feature.ConfiguredFeature
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.blocks.plant.grower;

import com.barlinc.unusual_prehistory.registry.UP2Features;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GoldenGinkgoTreeGrower
extends AbstractTreeGrower {
    @Nullable
    protected ResourceKey<ConfiguredFeature<?, ?>> m_213888_(@NotNull RandomSource random, boolean bees) {
        return bees ? UP2Features.GOLDEN_GINKGO_BEES : UP2Features.GOLDEN_GINKGO;
    }
}


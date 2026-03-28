/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  com.mojang.serialization.codecs.RecordCodecBuilder$Instance
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.util.RandomSource
 *  net.minecraft.util.valueproviders.IntProvider
 *  net.minecraft.world.level.LevelSimulatedReader
 *  net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration
 *  net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer
 *  net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer$FoliageAttachment
 *  net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer$FoliageSetter
 *  net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.worldgen.feature.tree.ginkgo;

import com.barlinc.unusual_prehistory.registry.UP2Trees;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

public class GinkgoFoliagePlacer
extends FoliagePlacer {
    public static final Codec<GinkgoFoliagePlacer> CODEC = RecordCodecBuilder.create(foliagePlacerInstance -> GinkgoFoliagePlacer.m_68573_((RecordCodecBuilder.Instance)foliagePlacerInstance).and((App)IntProvider.m_146545_((int)0, (int)24).fieldOf("trunk_height").forGetter(foliagePlacer -> foliagePlacer.trunkHeight)).apply((Applicative)foliagePlacerInstance, GinkgoFoliagePlacer::new));
    private final IntProvider trunkHeight;

    public GinkgoFoliagePlacer(IntProvider intProvider, IntProvider intProvider1, IntProvider trunkHeight) {
        super(intProvider, intProvider1);
        this.trunkHeight = trunkHeight;
    }

    @NotNull
    protected FoliagePlacerType<?> m_5897_() {
        return (FoliagePlacerType)UP2Trees.GINKGO_FOLIAGE.get();
    }

    protected void m_213633_(@NotNull LevelSimulatedReader level, // Could not load outer class - annotation placement on inner may be incorrect
    @NotNull FoliagePlacer.FoliageSetter placer, @NotNull RandomSource random, @NotNull TreeConfiguration config, int trunkHeight, FoliagePlacer.FoliageAttachment treeNode, int radius, int foliageHeight, int offset) {
        BlockPos blockPos = treeNode.m_161451_();
        BlockPos.MutableBlockPos mutable = blockPos.m_122032_();
        for (int height = -11; height <= foliageHeight; ++height) {
            if (height == -11) {
                this.m_225628_(level, placer, random, config, treeNode.m_161451_(), 1, height, treeNode.m_68590_());
                if (random.m_188499_()) {
                    this.m_225628_(level, placer, random, config, treeNode.m_161451_(), 1, height - 1, treeNode.m_68590_());
                }
            }
            if (height == -10 || height == -7 || height == -5 || height == -2) {
                this.generateDiamond(level, placer, random, config, blockPos, 2, height, treeNode.m_68590_());
            }
            if (height == -9 || height == -6 || height == -4) {
                this.m_225628_(level, placer, random, config, treeNode.m_161451_(), 2, height, treeNode.m_68590_());
                mutable.m_122154_((Vec3i)blockPos, 0, height, 0);
                if (random.m_188499_()) {
                    GinkgoFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(2, 0, 2));
                }
                if (random.m_188499_()) {
                    GinkgoFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(-2, 0, 2));
                }
                if (random.m_188499_()) {
                    GinkgoFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(2, 0, -2));
                }
                if (random.m_188499_()) {
                    GinkgoFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(-2, 0, -2));
                }
            }
            if (height == -8 || height == -6 || height == -3) {
                this.m_225628_(level, placer, random, config, treeNode.m_161451_(), 2, height, treeNode.m_68590_());
            }
            if (height == -1) {
                this.generateDiamond(level, placer, random, config, blockPos, 1, height, treeNode.m_68590_());
            }
            if (height == 0) {
                this.m_225628_(level, placer, random, config, treeNode.m_161451_(), 1, height, treeNode.m_68590_());
            }
            if (height != 1) continue;
            mutable.m_122154_((Vec3i)blockPos, 0, height, 0);
            GinkgoFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable);
            if (random.m_188499_()) {
                GinkgoFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(0, 1, 0));
                continue;
            }
            if (!random.m_188499_()) continue;
            this.m_225628_(level, placer, random, config, treeNode.m_161451_(), 1, height, treeNode.m_68590_());
            GinkgoFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(0, 1, 0));
            if (!random.m_188499_()) continue;
            GinkgoFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(0, 2, 0));
        }
    }

    public int m_214116_(@NotNull RandomSource random, int trunkHeight, @NotNull TreeConfiguration config) {
        return Math.max(8, trunkHeight - this.trunkHeight.m_214085_(random));
    }

    protected boolean m_214203_(@NotNull RandomSource random, int x, int y, int z, int radius, boolean giantTrunk) {
        return x == radius && z == radius && radius > 0;
    }

    protected void generateDiamond(LevelSimulatedReader world, FoliagePlacer.FoliageSetter placer, RandomSource random, TreeConfiguration config, BlockPos centerPos, int radius, int y, boolean giantTrunk) {
        int i = giantTrunk ? 1 : 0;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        for (int j = -radius; j <= radius + i; ++j) {
            for (int k = -radius; k <= radius + i; ++k) {
                if (this.validateDiamond(j, k, giantTrunk)) continue;
                mutable.m_122154_((Vec3i)centerPos, j, y, k);
                GinkgoFoliagePlacer.m_272253_((LevelSimulatedReader)world, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable);
            }
        }
    }

    protected boolean validateDiamond(int dx, int dz, boolean giantTrunk) {
        if (giantTrunk) {
            dx = Math.min(Math.abs(dx), Math.abs(dx - 1));
            dz = Math.min(Math.abs(dz), Math.abs(dz - 1));
        } else {
            dx = Math.abs(dx);
            dz = Math.abs(dz);
        }
        return (dx > 1 || dz > 1) && dx != 0 && dz != 0;
    }
}


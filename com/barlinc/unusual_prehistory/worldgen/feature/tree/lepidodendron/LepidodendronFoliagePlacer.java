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
package com.barlinc.unusual_prehistory.worldgen.feature.tree.lepidodendron;

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

public class LepidodendronFoliagePlacer
extends FoliagePlacer {
    public static final Codec<LepidodendronFoliagePlacer> CODEC = RecordCodecBuilder.create(lepidodendron -> LepidodendronFoliagePlacer.m_68573_((RecordCodecBuilder.Instance)lepidodendron).and((App)Codec.intRange((int)0, (int)16).fieldOf("height").forGetter(lepidodendronHeight -> lepidodendronHeight.height)).apply((Applicative)lepidodendron, LepidodendronFoliagePlacer::new));
    protected final int height;

    public LepidodendronFoliagePlacer(IntProvider intProvider, IntProvider intProvider1, int height) {
        super(intProvider, intProvider1);
        this.height = height;
    }

    @NotNull
    protected FoliagePlacerType<?> m_5897_() {
        return (FoliagePlacerType)UP2Trees.LEPIDODENDRON_FOLIAGE.get();
    }

    protected void m_213633_(@NotNull LevelSimulatedReader level, @NotNull FoliagePlacer.FoliageSetter placer, @NotNull RandomSource random, @NotNull TreeConfiguration config, int trunkHeight, FoliagePlacer.FoliageAttachment treeNode, int foliageHeight, int radius, int offset) {
        BlockPos blockPos = treeNode.m_161451_().m_6630_(offset);
        BlockPos.MutableBlockPos mutable = blockPos.m_122032_();
        this.m_225628_(level, placer, random, config, blockPos, radius + 1 + treeNode.m_68589_(), 3, false);
        this.generateDiamond(level, placer, random, config, blockPos, radius + 2 + treeNode.m_68589_(), 3, treeNode.m_68590_());
        this.m_225628_(level, placer, random, config, blockPos, radius + 3 + treeNode.m_68589_(), 4, false);
        this.m_225628_(level, placer, random, config, blockPos, radius + 2 + treeNode.m_68589_(), 5, false);
        mutable.m_122154_((Vec3i)blockPos, 0, 5, 0);
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(-1, 0, -5));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(0, 0, -5));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(1, 0, -5));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(-1, 0, 5));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(0, 0, 5));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(1, 0, 5));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(5, 0, -1));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(5, 0, 0));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(5, 0, 1));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(-5, 0, -1));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(-5, 0, 0));
        LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)level, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable.m_7918_(-5, 0, 1));
        this.m_225628_(level, placer, random, config, blockPos, radius + 1 + treeNode.m_68589_(), 6, false);
        this.generateDiamond(level, placer, random, config, blockPos, radius + 2 + treeNode.m_68589_(), 6, treeNode.m_68590_());
    }

    public int m_214116_(@NotNull RandomSource random, int trunkHeight, @NotNull TreeConfiguration config) {
        return 3;
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
                LepidodendronFoliagePlacer.m_272253_((LevelSimulatedReader)world, (FoliagePlacer.FoliageSetter)placer, (RandomSource)random, (TreeConfiguration)config, (BlockPos)mutable);
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


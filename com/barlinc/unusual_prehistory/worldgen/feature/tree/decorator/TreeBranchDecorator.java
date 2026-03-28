/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Plane
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider
 *  net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator
 *  net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator$Context
 *  net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.worldgen.feature.tree.decorator;

import com.barlinc.unusual_prehistory.registry.UP2Trees;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

public class TreeBranchDecorator
extends TreeDecorator {
    public static final Codec<TreeBranchDecorator> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("probability").forGetter(treeDecorator -> Float.valueOf(treeDecorator.probability)), (App)BlockStateProvider.f_68747_.fieldOf("leaf_provider").forGetter(treeDecorator -> treeDecorator.leafProvider)).apply((Applicative)instance, TreeBranchDecorator::new));
    private final float probability;
    private final BlockStateProvider leafProvider;

    public TreeBranchDecorator(float probability, BlockStateProvider leafProvider) {
        this.probability = probability;
        this.leafProvider = leafProvider;
    }

    @NotNull
    protected TreeDecoratorType<?> m_6663_() {
        return (TreeDecoratorType)UP2Trees.TREE_BRANCH.get();
    }

    public void m_214187_(TreeDecorator.Context context) {
        RandomSource random = context.m_226067_();
        ObjectArrayList logs = context.m_226068_();
        ObjectArrayList leaves = context.m_226069_();
        logs.stream().filter(arg_0 -> TreeBranchDecorator.lambda$place$3((List)leaves, (List)logs, arg_0)).forEach(pos -> {
            if (random.m_188501_() <= this.probability) {
                Direction direction = Direction.Plane.HORIZONTAL.m_235690_(random);
                BlockPos.MutableBlockPos mutablePos = pos.m_7918_(direction.m_122429_(), 0, direction.m_122431_()).m_122032_();
                if (context.m_226059_((BlockPos)mutablePos)) {
                    context.m_226061_((BlockPos)mutablePos, this.leafProvider.m_213972_(random, (BlockPos)mutablePos));
                }
                mutablePos.m_122173_(direction.m_122427_());
                if (context.m_226059_((BlockPos)mutablePos)) {
                    context.m_226061_((BlockPos)mutablePos, this.leafProvider.m_213972_(random, (BlockPos)mutablePos));
                }
                mutablePos.m_122175_(direction.m_122427_().m_122424_(), 2);
                if (context.m_226059_((BlockPos)mutablePos)) {
                    context.m_226061_((BlockPos)mutablePos, this.leafProvider.m_213972_(random, (BlockPos)mutablePos));
                }
                mutablePos.m_122173_(direction.m_122427_()).m_122173_(direction);
                if (context.m_226059_((BlockPos)mutablePos)) {
                    context.m_226061_((BlockPos)mutablePos, this.leafProvider.m_213972_(random, (BlockPos)mutablePos));
                }
                mutablePos.m_122173_(direction.m_122424_()).m_122173_(Direction.UP);
                if (context.m_226059_((BlockPos)mutablePos)) {
                    context.m_226061_((BlockPos)mutablePos, this.leafProvider.m_213972_(random, (BlockPos)mutablePos));
                }
            }
        });
    }

    private static /* synthetic */ boolean lambda$place$3(List leaves, List logs, BlockPos pos) {
        return pos.m_123342_() < ((BlockPos)leaves.get(0)).m_123342_() - 2 && pos.m_123342_() > ((BlockPos)logs.get(0)).m_123342_() + 2;
    }
}


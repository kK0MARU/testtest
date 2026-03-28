/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockBehaviour$BlockStateBase
 *  net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator
 *  net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator$Context
 *  net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.worldgen.feature.tree.lepidodendron;

import com.barlinc.unusual_prehistory.blocks.plant.update_1.LepidodendronConeBlock;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Trees;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

public class HangingLepidodendronLeavesDecorator
extends TreeDecorator {
    public static final HangingLepidodendronLeavesDecorator INSTANCE = new HangingLepidodendronLeavesDecorator();
    public static final Codec<HangingLepidodendronLeavesDecorator> CODEC = Codec.unit(() -> INSTANCE);

    @NotNull
    protected TreeDecoratorType<?> m_6663_() {
        return (TreeDecoratorType)UP2Trees.HANGING_LEPIDODENDRON_LEAVES.get();
    }

    public void m_214187_(TreeDecorator.Context context) {
        for (BlockPos pos : context.m_226069_()) {
            if (!context.m_226058_().m_7433_(pos.m_7495_(), BlockBehaviour.BlockStateBase::m_60795_)) continue;
            if (context.m_226067_().m_188503_(2) == 0) {
                context.m_226061_(pos.m_7495_(), ((Block)UP2Blocks.HANGING_LEPIDODENDRON_LEAVES.get()).m_49966_());
            }
            if (context.m_226067_().m_188503_(24) != 0) continue;
            context.m_226061_(pos.m_7495_(), LepidodendronConeBlock.createHangingCone());
        }
    }
}


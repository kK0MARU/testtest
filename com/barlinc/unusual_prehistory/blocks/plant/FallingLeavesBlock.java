/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.util.ParticleUtils
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.LeavesBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class FallingLeavesBlock
extends LeavesBlock {
    public final Supplier<SimpleParticleType> particle;

    public FallingLeavesBlock(BlockBehaviour.Properties properties, Supplier<SimpleParticleType> particle) {
        super(properties);
        this.particle = particle;
    }

    @OnlyIn(value=Dist.CLIENT)
    public void m_214162_(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        BlockPos pos1;
        BlockState state1;
        super.m_214162_(state, level, pos, random);
        if (!(random.m_188501_() >= 0.017f) && !FallingLeavesBlock.m_49918_((VoxelShape)(state1 = level.m_8055_(pos1 = pos.m_7495_())).m_60812_((BlockGetter)level, pos1), (Direction)Direction.UP)) {
            ParticleUtils.m_272037_((Level)level, (BlockPos)pos, (RandomSource)random, (ParticleOptions)((ParticleOptions)this.particle.get()));
        }
    }
}


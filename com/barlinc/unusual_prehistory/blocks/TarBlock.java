/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.LivingEntity$Fallsounds
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.LiquidBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FlowingFluid
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks;

import com.barlinc.unusual_prehistory.registry.UP2Particles;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class TarBlock
extends LiquidBlock {
    public TarBlock(Supplier<? extends FlowingFluid> fluid, BlockBehaviour.Properties properties) {
        super(fluid, properties);
    }

    public void m_7892_(@NotNull BlockState state, @NotNull Level level, BlockPos pos, Entity entity) {
        if (entity.m_20186_() < (double)pos.m_123342_() + f_54690_.m_83297_(Direction.Axis.Y) && (!(entity instanceof LivingEntity) || entity.m_146900_().m_60713_((Block)this))) {
            entity.m_7601_(state, new Vec3((double)0.9f, 1.0, (double)0.9f));
        }
    }

    public void m_142072_(@NotNull Level level, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull Entity entity, float fallDistance) {
        if ((double)fallDistance >= 4.0 && entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            LivingEntity.Fallsounds fallSound = livingEntity.m_196493_();
            SoundEvent sound = (double)fallDistance < 7.0 ? fallSound.f_196626_() : fallSound.f_196627_();
            entity.m_5496_(sound, 1.0f, 1.0f);
        }
    }

    @NotNull
    public Optional<SoundEvent> m_142298_() {
        return Optional.of(SoundEvents.f_144089_);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void m_214162_(@NotNull BlockState state, Level level, BlockPos pos, @NotNull RandomSource random) {
        boolean top = level.m_6425_(pos.m_7494_()).m_76178_();
        if (random.m_188503_(400) == 0) {
            level.m_7785_((double)pos.m_123341_() + 0.5, (double)pos.m_123342_() + 0.5, (double)pos.m_123343_() + 0.5, (SoundEvent)UP2SoundEvents.TAR_POP.get(), SoundSource.BLOCKS, 0.5f, random.m_188501_() * 0.4f + 0.8f, false);
        }
        if (random.m_188503_(top ? 10 : 40) == 0) {
            float height = top ? state.m_60819_().m_76155_((BlockGetter)level, pos) : random.m_188501_();
            level.m_7106_((ParticleOptions)UP2Particles.TAR_BUBBLE.get(), (double)((float)pos.m_123341_() + random.m_188501_()), (double)((float)pos.m_123342_() + height), (double)((float)pos.m_123343_() + random.m_188501_()), (double)((random.m_188501_() - 0.5f) * 0.1f), (double)(0.05f + random.m_188501_() * 0.1f), (double)((random.m_188501_() - 0.5f) * 0.1f));
        }
    }
}


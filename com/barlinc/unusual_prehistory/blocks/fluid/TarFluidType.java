/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.shaders.FogShape
 *  com.mojang.blaze3d.systems.RenderSystem
 *  javax.annotation.Nullable
 *  net.minecraft.client.Camera
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.renderer.FogRenderer$FogMode
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions
 *  net.minecraftforge.common.SoundActions
 *  net.minecraftforge.fluids.FluidStack
 *  net.minecraftforge.fluids.FluidType
 *  net.minecraftforge.fluids.FluidType$Properties
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package com.barlinc.unusual_prehistory.blocks.fluid;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.registry.UP2Particles;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public class TarFluidType
extends FluidType {
    public static final ResourceLocation FLUID_STILL = UnusualPrehistory2.modPrefix("block/tar");
    public static final ResourceLocation FLUID_FLOWING = UnusualPrehistory2.modPrefix("block/tar_flowing");
    public static final ResourceLocation OVERLAY = UnusualPrehistory2.modPrefix("block/tar_flowing");

    public TarFluidType(FluidType.Properties properties) {
        super(properties);
    }

    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions(){

            public ResourceLocation getStillTexture() {
                return FLUID_STILL;
            }

            public ResourceLocation getFlowingTexture() {
                return FLUID_FLOWING;
            }

            public ResourceLocation getOverlayTexture() {
                return OVERLAY;
            }

            @NotNull
            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return new Vector3f(0.0f, 0.0f, 0.0f);
            }

            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart((float)0.0f);
                RenderSystem.setShaderFogEnd((float)1.0f);
                RenderSystem.setShaderFogShape((FogShape)FogShape.SPHERE);
            }
        });
    }

    public boolean isVaporizedOnPlacement(Level level, BlockPos pos, FluidStack stack) {
        return level.m_6042_().f_63857_();
    }

    public void onVaporize(@Nullable Player player, Level level, BlockPos pos, FluidStack stack) {
        SoundEvent sound = this.getSound(player, (BlockGetter)level, pos, SoundActions.FLUID_VAPORIZE);
        level.m_5594_(player, pos, sound != null ? sound : SoundEvents.f_11937_, SoundSource.BLOCKS, 0.5f, 2.6f + (level.f_46441_.m_188501_() - level.f_46441_.m_188501_()) * 0.8f);
        for (int l = 0; l < 8; ++l) {
            level.m_7107_((ParticleOptions)UP2Particles.TAR_BUBBLE.get(), (double)pos.m_123341_() + Math.random(), (double)pos.m_123342_() + Math.random(), (double)pos.m_123343_() + Math.random(), (Math.random() - 0.5) * 0.25, Math.random() * 0.25, (Math.random() - 0.5) * 0.25);
            level.m_7107_((ParticleOptions)ParticleTypes.f_123755_, (double)pos.m_123341_() + Math.random(), (double)pos.m_123342_() + Math.random(), (double)pos.m_123343_() + Math.random(), (Math.random() - 0.5) * (double)0.05f, Math.random() * (double)0.05f, (Math.random() - 0.5) * (double)0.05f);
        }
        level.m_46597_(pos, Blocks.f_50016_.m_49966_());
    }
}


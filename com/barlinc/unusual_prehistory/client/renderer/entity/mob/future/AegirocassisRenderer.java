/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.future;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.AegirocassisBabyModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.AegirocassisModel;
import com.barlinc.unusual_prehistory.entity.mob.future.Aegirocassis;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class AegirocassisRenderer
extends MobRenderer<Aegirocassis, UP2Model<Aegirocassis>> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/aegirocassis/aegirocassis.png");
    private static final ResourceLocation TEXTURE_BABY = UnusualPrehistory2.modPrefix("textures/entity/aegirocassis/aegirocassis_baby.png");
    private final AegirocassisModel adultModel;
    private final AegirocassisBabyModel babyModel;

    public AegirocassisRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new AegirocassisModel(context.m_174023_(UP2ModelLayers.AEGIROCASSIS)), 1.5f);
        this.adultModel = new AegirocassisModel(context.m_174023_(UP2ModelLayers.AEGIROCASSIS));
        this.babyModel = new AegirocassisBabyModel(context.m_174023_(UP2ModelLayers.AEGIROCASSIS_BABY));
    }

    public void render(Aegirocassis entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
        this.f_115290_ = entity.m_6162_() ? this.babyModel : this.adultModel;
        super.m_7392_((Mob)entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
    }

    protected float getFlipDegrees(@NotNull Aegirocassis entity) {
        return !entity.m_20072_() ? 0.0f : super.m_6441_((LivingEntity)entity);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Aegirocassis entity) {
        return entity.m_6162_() ? TEXTURE_BABY : TEXTURE;
    }
}


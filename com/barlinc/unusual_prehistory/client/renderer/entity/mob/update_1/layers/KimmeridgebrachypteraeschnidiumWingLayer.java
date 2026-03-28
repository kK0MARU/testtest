/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.layers;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.KimmeridgebrachypteraeschnidiumModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.KimmeridgebrachypteraeschnidiumRenderer;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Kimmeridgebrachypteraeschnidium;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class KimmeridgebrachypteraeschnidiumWingLayer
extends RenderLayer<Kimmeridgebrachypteraeschnidium, KimmeridgebrachypteraeschnidiumModel> {
    public KimmeridgebrachypteraeschnidiumWingLayer(RenderLayerParent<Kimmeridgebrachypteraeschnidium, KimmeridgebrachypteraeschnidiumModel> renderer) {
        super(renderer);
    }

    public ResourceLocation wingTextures(Kimmeridgebrachypteraeschnidium entity) {
        return UnusualPrehistory2.modPrefix("textures/entity/kimmeridgebrachypteraeschnidium/wings/wings_" + entity.getWingColor() + ".png");
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, Kimmeridgebrachypteraeschnidium entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entity.m_20145_()) {
            ResourceLocation resourceLocation = this.wingTextures(entity);
            KimmeridgebrachypteraeschnidiumWingLayer.renderTranslucentModel((EntityModel<Kimmeridgebrachypteraeschnidium>)this.m_117386_(), resourceLocation, poseStack, bufferSource, packedLight, partialTicks, entity);
        }
    }

    protected static void renderTranslucentModel(EntityModel<Kimmeridgebrachypteraeschnidium> model, @NotNull ResourceLocation resourceLocation, @NotNull PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, float partialTicks, Kimmeridgebrachypteraeschnidium entity) {
        VertexConsumer vertexconsumer = bufferSource.m_6299_(RenderType.m_110473_((ResourceLocation)resourceLocation));
        int i = LivingEntityRenderer.m_115338_((LivingEntity)entity, (float)KimmeridgebrachypteraeschnidiumRenderer.getExplosionOverlayProgress(entity, partialTicks));
        model.m_7695_(poseStack, vertexconsumer, packedLight, i, 1.0f, 1.0f, 1.0f, 1.0f);
    }
}


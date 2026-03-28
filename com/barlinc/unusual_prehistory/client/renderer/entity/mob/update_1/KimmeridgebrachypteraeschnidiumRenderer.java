/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Mob
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.KimmeridgebrachypteraeschnidiumModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.layers.KimmeridgebrachypteraeschnidiumBaseLayer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.layers.KimmeridgebrachypteraeschnidiumPatternLayer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.layers.KimmeridgebrachypteraeschnidiumWingLayer;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Kimmeridgebrachypteraeschnidium;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OnlyIn(value=Dist.CLIENT)
public class KimmeridgebrachypteraeschnidiumRenderer
extends MobRenderer<Kimmeridgebrachypteraeschnidium, KimmeridgebrachypteraeschnidiumModel> {
    public KimmeridgebrachypteraeschnidiumRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new KimmeridgebrachypteraeschnidiumModel(context.m_174023_(UP2ModelLayers.KIMMERIDGEBRACHYPTERAESCHNIDIUM)), 0.3f);
        this.m_115326_(new KimmeridgebrachypteraeschnidiumBaseLayer((RenderLayerParent<Kimmeridgebrachypteraeschnidium, KimmeridgebrachypteraeschnidiumModel>)this));
        this.m_115326_(new KimmeridgebrachypteraeschnidiumPatternLayer((RenderLayerParent<Kimmeridgebrachypteraeschnidium, KimmeridgebrachypteraeschnidiumModel>)this));
        this.m_115326_(new KimmeridgebrachypteraeschnidiumWingLayer((RenderLayerParent<Kimmeridgebrachypteraeschnidium, KimmeridgebrachypteraeschnidiumModel>)this));
    }

    @NotNull
    public ResourceLocation getTextureLocation(Kimmeridgebrachypteraeschnidium entity) {
        return UnusualPrehistory2.modPrefix("textures/entity/kimmeridgebrachypteraeschnidium/base/base_" + entity.getBaseColor() + ".png");
    }

    public void render(Kimmeridgebrachypteraeschnidium entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
        if (!entity.m_20145_()) {
            super.m_7392_((Mob)entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
        }
    }

    protected void scale(Kimmeridgebrachypteraeschnidium entity, PoseStack poseStack, float partialTicks) {
        float f = entity.getSwelling(partialTicks);
        float f1 = 1.0f + Mth.m_14031_((float)(f * 100.0f)) * f * 0.05f;
        f = Mth.m_14036_((float)f, (float)0.0f, (float)1.0f);
        f *= f;
        f *= f;
        float f2 = (1.0f + f * 0.4f) * f1;
        float f3 = (1.0f + f * 0.1f) / f1;
        poseStack.m_85841_(f2, f3, f2);
    }

    public static float getExplosionOverlayProgress(Kimmeridgebrachypteraeschnidium entity, float partialTicks) {
        float f = entity.getSwelling(partialTicks);
        return (int)(f * 20.0f) % 2 == 0 ? 0.0f : Mth.m_14036_((float)f, (float)0.5f, (float)1.0f);
    }

    @Nullable
    protected RenderType getRenderType(@NotNull Kimmeridgebrachypteraeschnidium entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.m_110452_((ResourceLocation)this.getTextureLocation(entity));
    }
}


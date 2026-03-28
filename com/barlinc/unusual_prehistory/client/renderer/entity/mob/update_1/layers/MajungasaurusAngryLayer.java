/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
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
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.MajungasaurusModel;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Majungasaurus;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Locale;
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
public class MajungasaurusAngryLayer
extends RenderLayer<Majungasaurus, MajungasaurusModel> {
    public MajungasaurusAngryLayer(RenderLayerParent<Majungasaurus, MajungasaurusModel> parent) {
        super(parent);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, Majungasaurus entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.m_20145_()) {
            return;
        }
        float angryProgress = entity.getAngryProgress(partialTicks);
        if (angryProgress <= 0.0f) {
            return;
        }
        VertexConsumer consumer = buffer.m_6299_(RenderType.m_110473_((ResourceLocation)this.getAngryTexture(entity)));
        ((MajungasaurusModel)this.m_117386_()).m_7695_(poseStack, consumer, packedLight, LivingEntityRenderer.m_115338_((LivingEntity)entity, (float)0.0f), 1.0f, 1.0f, 1.0f, angryProgress);
    }

    public ResourceLocation getAngryTexture(Majungasaurus entity) {
        Majungasaurus.MajungasaurusVariant variant = Majungasaurus.MajungasaurusVariant.byId(entity.getVariant());
        return UnusualPrehistory2.modPrefix("textures/entity/majungasaurus/" + variant.name().toLowerCase(Locale.ROOT) + "_angry.png");
    }
}


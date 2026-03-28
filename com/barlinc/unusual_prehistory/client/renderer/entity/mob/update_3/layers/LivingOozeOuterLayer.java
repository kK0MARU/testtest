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
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3.layers;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_3.LivingOozeModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3.LivingOozeRenderer;
import com.barlinc.unusual_prehistory.entity.mob.update_3.LivingOoze;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
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
public class LivingOozeOuterLayer
extends RenderLayer<LivingOoze, LivingOozeModel> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/living_ooze/normal.png");
    private static final ResourceLocation TEXTURE_GULPING = UnusualPrehistory2.modPrefix("textures/entity/living_ooze/gulping.png");
    private static final ResourceLocation TEXTURE_SPITTING = UnusualPrehistory2.modPrefix("textures/entity/living_ooze/spitting.png");
    private static final ResourceLocation TEXTURE_COOLDOWN = UnusualPrehistory2.modPrefix("textures/entity/living_ooze/clarity.png");
    private static final ResourceLocation TEXTURE_SAD = UnusualPrehistory2.modPrefix("textures/entity/living_ooze/sad.png");
    private static final ResourceLocation TEXTURE_SCREAMING = UnusualPrehistory2.modPrefix("textures/entity/living_ooze/screaming.png");

    public LivingOozeOuterLayer(LivingOozeRenderer render) {
        super((RenderLayerParent)render);
    }

    public void render(@NotNull PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, @NotNull LivingOoze entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        VertexConsumer vertexConsumer = bufferSource.m_6299_(RenderType.m_110473_((ResourceLocation)this.getTextureLocation(entity)));
        if (!entity.m_20145_()) {
            ((LivingOozeModel)this.m_117386_()).m_7695_(poseStack, vertexConsumer, packedLight, LivingEntityRenderer.m_115338_((LivingEntity)entity, (float)0.0f), 1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull LivingOoze entity) {
        int spitTime = entity.getSpitTime();
        if (spitTime > 0 && entity.m_20089_() == UP2Poses.SPITTING.get()) {
            if (spitTime <= 6) {
                return TEXTURE_SPITTING;
            }
            if (spitTime <= 35) {
                return TEXTURE_GULPING;
            }
        }
        if (entity.getCooldown() > 0) {
            return TEXTURE_COOLDOWN;
        }
        if (entity.m_6084_() && entity.getSadTime() > 0) {
            return TEXTURE_SAD;
        }
        if (!entity.m_6084_()) {
            return TEXTURE_SCREAMING;
        }
        return TEXTURE;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Quaternionf
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3.layers;

import com.barlinc.unusual_prehistory.client.models.entity.mob.update_3.LivingOozeModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3.LivingOozeRenderer;
import com.barlinc.unusual_prehistory.entity.mob.update_3.LivingOoze;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.utils.UP2LoadedMods;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

@OnlyIn(value=Dist.CLIENT)
public class LivingOozeContainedItemLayer
extends RenderLayer<LivingOoze, LivingOozeModel> {
    public LivingOozeContainedItemLayer(LivingOozeRenderer renderer) {
        super((RenderLayerParent)renderer);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, @NotNull LivingOoze entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = entity.m_21205_();
        if (!(itemstack.m_41619_() || entity.m_20145_() || entity.m_142038_())) {
            poseStack.m_85836_();
            this.translateItemInCore(poseStack, entity, partialTicks);
            Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.FIXED, packedLight, OverlayTexture.f_118083_, poseStack, bufferSource, entity.m_9236_(), (int)entity.m_20183_().m_121878_());
            if (bufferSource instanceof MultiBufferSource.BufferSource) {
                MultiBufferSource.BufferSource source = (MultiBufferSource.BufferSource)bufferSource;
                if (!UP2LoadedMods.isOculusLoaded()) {
                    source.m_109911_();
                }
            }
            poseStack.m_85849_();
        }
    }

    private void translateItemInCore(PoseStack poseStack, LivingOoze entity, float partialTicks) {
        float age = (float)entity.f_19797_ + partialTicks;
        float yRot = age / 5.0f;
        float yPos = entity.m_20089_() == UP2Poses.SPITTING.get() ? 0.0f : (float)(0.0 + Math.sin(age * 0.07f) * (double)0.03f);
        float xScale = ((LivingOozeModel)this.m_117386_()).core_squish.f_233553_ * ((LivingOozeModel)this.m_117386_()).core.f_233553_ * 0.38f;
        float yScale = ((LivingOozeModel)this.m_117386_()).core_squish.f_233554_ * ((LivingOozeModel)this.m_117386_()).core.f_233554_ * 0.38f;
        float zScale = ((LivingOozeModel)this.m_117386_()).core_squish.f_233555_ * ((LivingOozeModel)this.m_117386_()).core.f_233555_ * 0.38f;
        ((LivingOozeModel)this.m_117386_()).translateToCore(poseStack);
        poseStack.m_252880_(0.0f, yPos, 0.0f);
        poseStack.m_252781_(new Quaternionf().rotateX((float)Math.PI));
        poseStack.m_252781_(Axis.f_252436_.m_252977_(yRot * 9.549296f));
        poseStack.m_85841_(xScale, yScale, zScale);
    }
}


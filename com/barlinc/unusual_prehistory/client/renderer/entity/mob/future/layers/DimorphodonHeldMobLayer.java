/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.layers;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.DimorphodonModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.layers.RiderLayer;
import com.barlinc.unusual_prehistory.entity.mob.future.Dimorphodon;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class DimorphodonHeldMobLayer
extends RiderLayer<Dimorphodon, DimorphodonModel> {
    public DimorphodonHeldMobLayer(RenderLayerParent<Dimorphodon, DimorphodonModel> parent) {
        super(parent);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, Dimorphodon entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        Entity heldMob = entity.getHeldMob((Entity)entity);
        if (heldMob != null) {
            UnusualPrehistory2.PROXY.releaseRenderingEntity(heldMob.m_20148_());
            poseStack.m_85836_();
            ((DimorphodonModel)this.m_117386_()).translateToFeet(poseStack);
            poseStack.m_252880_(0.0f, 2.0f * entity.m_6134_(), 0.0f);
            poseStack.m_252781_(Axis.f_252495_.m_252977_(180.0f));
            if (!UnusualPrehistory2.PROXY.isFirstPersonPlayer(heldMob)) {
                DimorphodonHeldMobLayer.renderPassenger(heldMob, 0.0, 0.0, 0.0, 0.0f, partialTicks, poseStack, bufferSource, packedLight);
            }
            poseStack.m_85849_();
            UnusualPrehistory2.PROXY.blockRenderingEntity(heldMob.m_20148_());
        }
    }
}


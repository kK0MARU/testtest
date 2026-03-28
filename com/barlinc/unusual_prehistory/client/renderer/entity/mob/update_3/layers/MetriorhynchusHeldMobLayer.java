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
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3.layers;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_3.MetriorhynchusModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.layers.RiderLayer;
import com.barlinc.unusual_prehistory.entity.mob.update_3.Metriorhynchus;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class MetriorhynchusHeldMobLayer
extends RiderLayer<Metriorhynchus, MetriorhynchusModel> {
    public MetriorhynchusHeldMobLayer(RenderLayerParent<Metriorhynchus, MetriorhynchusModel> parent) {
        super(parent);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, Metriorhynchus entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        Entity heldMob = entity.getHeldMob((Entity)entity);
        if (heldMob != null) {
            UnusualPrehistory2.PROXY.releaseRenderingEntity(heldMob.m_20148_());
            poseStack.m_85836_();
            ((MetriorhynchusModel)this.m_117386_()).translateToMouth(poseStack);
            poseStack.m_252880_(0.0f, 0.22f * entity.m_6134_(), -1.15f * entity.m_6134_());
            poseStack.m_252781_(Axis.f_252495_.m_252977_(180.0f));
            poseStack.m_252781_(Axis.f_252392_.m_252977_(-90.0f));
            poseStack.m_252781_(Axis.f_252495_.m_252977_(-10.0f));
            if (!UnusualPrehistory2.PROXY.isFirstPersonPlayer(heldMob)) {
                MetriorhynchusHeldMobLayer.renderPassenger(heldMob, 0.0, 0.0, 0.0, 0.0f, partialTicks, poseStack, bufferSource, packedLight);
            }
            poseStack.m_85849_();
            UnusualPrehistory2.PROXY.blockRenderingEntity(heldMob.m_20148_());
        }
    }
}


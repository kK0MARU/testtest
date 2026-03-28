/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.layers;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.UlughbegsaurusModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.layers.RiderLayer;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Ulughbegsaurus;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class UlughbegsaurusRiderLayer
extends RiderLayer<Ulughbegsaurus, UlughbegsaurusModel> {
    public UlughbegsaurusRiderLayer(RenderLayerParent<Ulughbegsaurus, UlughbegsaurusModel> parent) {
        super(parent);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, Ulughbegsaurus entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float bodyYaw = entity.f_20884_ + (entity.f_20883_ - entity.f_20884_) * partialTicks;
        if (entity.m_20160_()) {
            Vec3 offset = new Vec3(0.0, 0.0, 0.0);
            Vec3 ridePos = ((UlughbegsaurusModel)this.m_117386_()).getRiderPosition(offset);
            for (Entity passenger : entity.m_20197_()) {
                if (passenger == Minecraft.m_91087_().f_91074_ && Minecraft.m_91087_().f_91066_.m_92176_().m_90612_()) continue;
                UnusualPrehistory2.PROXY.releaseRenderingEntity(passenger.m_20148_());
                poseStack.m_85836_();
                ((UlughbegsaurusModel)this.m_117386_()).translateRiderToBody(poseStack);
                poseStack.m_85837_(ridePos.f_82479_, ridePos.f_82480_ - 2.0 + (double)passenger.m_20206_(), ridePos.f_82481_);
                poseStack.m_252781_(Axis.f_252529_.m_252977_(180.0f));
                poseStack.m_252781_(Axis.f_252392_.m_252977_(360.0f - bodyYaw));
                passenger.m_5618_(entity.m_146908_());
                UlughbegsaurusRiderLayer.renderPassenger(passenger, 0.0, 0.0, 0.0, 0.0f, partialTicks, poseStack, bufferSource, packedLight);
                poseStack.m_85849_();
                UnusualPrehistory2.PROXY.blockRenderingEntity(passenger.m_20148_());
            }
        }
    }
}


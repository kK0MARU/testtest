/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.CrashReport
 *  net.minecraft.CrashReportCategory
 *  net.minecraft.ReportedException
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.world.entity.Entity
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.Entity;

public abstract class RiderLayer<T extends Entity, M extends EntityModel<T>>
extends RenderLayer<T, M> {
    public RiderLayer(RenderLayerParent<T, M> parent) {
        super(parent);
    }

    public static <E extends Entity> void renderPassenger(E entity, double x, double y, double z, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        block4: {
            EntityRenderer render = null;
            EntityRenderDispatcher manager = Minecraft.m_91087_().m_91290_();
            try {
                render = manager.m_114382_(entity);
                if (render == null) break block4;
                try {
                    render.m_7392_(entity, yaw, partialTicks, poseStack, bufferSource, packedLight);
                }
                catch (Throwable throwable1) {
                    throw new ReportedException(CrashReport.m_127521_((Throwable)throwable1, (String)"Rendering entity in world"));
                }
            }
            catch (Throwable throwable3) {
                CrashReport crashreport = CrashReport.m_127521_((Throwable)throwable3, (String)"Rendering entity in world");
                CrashReportCategory crashreportcategory = crashreport.m_127514_("Entity being rendered");
                entity.m_7976_(crashreportcategory);
                CrashReportCategory details = crashreport.m_127514_("Renderer details");
                details.m_128159_("Assigned renderer", (Object)render);
                details.m_128159_("Rotation", (Object)Float.valueOf(yaw));
                details.m_128159_("Delta", (Object)Float.valueOf(partialTicks));
                throw new ReportedException(crashreport);
            }
        }
    }
}


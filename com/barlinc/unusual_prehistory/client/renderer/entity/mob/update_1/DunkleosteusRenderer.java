/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Mob
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DunkleosteusLargeModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DunkleosteusMediumModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DunkleosteusSmallModel;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Dunkleosteus;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class DunkleosteusRenderer
extends MobRenderer<Dunkleosteus, HierarchicalModel<Dunkleosteus>> {
    private final DunkleosteusLargeModel dunkleosteusLargeModel;
    private final DunkleosteusMediumModel dunkleosteusMediumModel;
    private final DunkleosteusSmallModel dunkleosteusSmallModel;

    public DunkleosteusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new DunkleosteusLargeModel(context.m_174023_(UP2ModelLayers.DUNKLEOSTEUS_LARGE)), 0.5f);
        this.dunkleosteusLargeModel = new DunkleosteusLargeModel(context.m_174023_(UP2ModelLayers.DUNKLEOSTEUS_LARGE));
        this.dunkleosteusMediumModel = new DunkleosteusMediumModel(context.m_174023_(UP2ModelLayers.DUNKLEOSTEUS_MEDIUM));
        this.dunkleosteusSmallModel = new DunkleosteusSmallModel(context.m_174023_(UP2ModelLayers.DUNKLEOSTEUS_SMALL));
    }

    public void render(Dunkleosteus entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        switch (Dunkleosteus.DunkleosteusVariant.byId(entity.getVariant()).getId()) {
            case 1: {
                this.f_115290_ = this.dunkleosteusMediumModel;
                this.f_114477_ = 0.8f;
                break;
            }
            case 2: {
                this.f_115290_ = this.dunkleosteusLargeModel;
                this.f_114477_ = 1.0f;
                break;
            }
            default: {
                this.f_115290_ = this.dunkleosteusSmallModel;
                this.f_114477_ = 0.4f;
            }
        }
        super.m_7392_((Mob)entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @NotNull
    public ResourceLocation getTextureLocation(Dunkleosteus entity) {
        Dunkleosteus.DunkleosteusVariant variant = Dunkleosteus.DunkleosteusVariant.byId(entity.getVariant());
        return UnusualPrehistory2.modPrefix("textures/entity/dunkleosteus/dunkleosteus_" + variant.name().toLowerCase(Locale.ROOT) + ".png");
    }
}


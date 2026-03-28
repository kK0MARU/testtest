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
 *  net.minecraft.world.entity.Mob
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.MajungasaurusModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.layers.MajungasaurusAngryEmissiveLayer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.layers.MajungasaurusAngryLayer;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Majungasaurus;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OnlyIn(value=Dist.CLIENT)
public class MajungasaurusRenderer
extends MobRenderer<Majungasaurus, MajungasaurusModel> {
    public MajungasaurusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new MajungasaurusModel(context.m_174023_(UP2ModelLayers.MAJUNGASAURUS)), 0.8f);
        this.m_115326_(new MajungasaurusAngryLayer((RenderLayerParent<Majungasaurus, MajungasaurusModel>)this));
        this.m_115326_(new MajungasaurusAngryEmissiveLayer((RenderLayerParent<Majungasaurus, MajungasaurusModel>)this));
    }

    public void render(Majungasaurus entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        this.f_114477_ = entity.getCamoProgress(partialTicks) > 0.0f ? 0.0f : 0.8f;
        float alpha = 1.0f - entity.getCamoProgress(partialTicks);
        if (alpha > 0.0f) {
            super.m_7392_((Mob)entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        }
    }

    @NotNull
    public ResourceLocation getTextureLocation(Majungasaurus entity) {
        Majungasaurus.MajungasaurusVariant variant = Majungasaurus.MajungasaurusVariant.byId(entity.getVariant());
        if (entity.isEepy()) {
            return UnusualPrehistory2.modPrefix("textures/entity/majungasaurus/" + variant.name().toLowerCase(Locale.ROOT) + "_eepy.png");
        }
        return UnusualPrehistory2.modPrefix("textures/entity/majungasaurus/" + variant.name().toLowerCase(Locale.ROOT) + ".png");
    }

    @Nullable
    protected RenderType getRenderType(Majungasaurus entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        if (entity.getCamoProgress(1.0f) > 0.0f) {
            return RenderType.m_110473_((ResourceLocation)this.getTextureLocation(entity));
        }
        return RenderType.m_110458_((ResourceLocation)this.getTextureLocation(entity));
    }

    protected void scale(Majungasaurus entity, @NotNull PoseStack poseStack, float partialTicks) {
        float alpha = 1.0f - entity.getCamoProgress(partialTicks);
        ((MajungasaurusModel)this.f_115290_).setAlpha(alpha);
    }
}


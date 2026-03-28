/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.CoelacanthusModel;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Coelacanthus;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class CoelacanthusRenderer
extends MobRenderer<Coelacanthus, CoelacanthusModel> {
    public CoelacanthusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new CoelacanthusModel(context.m_174023_(UP2ModelLayers.COELACANTHUS)), 0.25f);
    }

    protected void scale(Coelacanthus entity, PoseStack poseStack, float partialTicks) {
        float scale = 1.0f + 0.1f * (float)entity.getCoelacanthusSize();
        poseStack.m_85841_(scale, scale, scale);
    }

    @NotNull
    public ResourceLocation getTextureLocation(Coelacanthus entity) {
        Coelacanthus.CoelacanthusVariant variant = Coelacanthus.CoelacanthusVariant.byId(entity.getVariant());
        return UnusualPrehistory2.modPrefix("textures/entity/coelacanthus/" + variant.name().toLowerCase(Locale.ROOT) + ".png");
    }
}


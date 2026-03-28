/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.future;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.DimorphodonModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.layers.DimorphodonHeldMobLayer;
import com.barlinc.unusual_prehistory.entity.mob.future.Dimorphodon;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class DimorphodonRenderer
extends MobRenderer<Dimorphodon, DimorphodonModel> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/dimorphodon.png");

    public DimorphodonRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new DimorphodonModel(context.m_174023_(UP2ModelLayers.DIMORPHODON)), 0.5f);
        this.m_115326_(new DimorphodonHeldMobLayer((RenderLayerParent<Dimorphodon, DimorphodonModel>)this));
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Dimorphodon entity) {
        return TEXTURE;
    }
}


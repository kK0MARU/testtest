/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.ambient;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.ambient.DelitzschalaModel;
import com.barlinc.unusual_prehistory.entity.mob.future.ambient.Delitzschala;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class DelitzschalaRenderer
extends MobRenderer<Delitzschala, DelitzschalaModel> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/ambient/delitzschala.png");

    public DelitzschalaRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new DelitzschalaModel(context.m_174023_(UP2ModelLayers.DELITZSCHALA)), 0.0f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Delitzschala entity) {
        return TEXTURE;
    }
}


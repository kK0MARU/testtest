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
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_2;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_2.OnchopristisModel;
import com.barlinc.unusual_prehistory.entity.mob.update_2.Onchopristis;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class OnchopristisRenderer
extends MobRenderer<Onchopristis, OnchopristisModel> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/onchopristis.png");

    public OnchopristisRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new OnchopristisModel(context.m_174023_(UP2ModelLayers.ONCHOPRISTIS)), 0.7f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Onchopristis entity) {
        return TEXTURE;
    }
}


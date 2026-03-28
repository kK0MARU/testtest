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
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.ambient.ZhangsolvaModel;
import com.barlinc.unusual_prehistory.entity.mob.future.ambient.Zhangsolva;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class ZhangsolvaRenderer
extends MobRenderer<Zhangsolva, ZhangsolvaModel> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/ambient/zhangsolva.png");

    public ZhangsolvaRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new ZhangsolvaModel(context.m_174023_(UP2ModelLayers.ZHANGSOLVA)), 0.0f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Zhangsolva entity) {
        return TEXTURE;
    }
}


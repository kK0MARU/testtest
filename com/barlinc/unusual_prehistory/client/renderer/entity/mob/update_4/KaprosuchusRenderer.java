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
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.KaprosuchusModel;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Kaprosuchus;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class KaprosuchusRenderer
extends MobRenderer<Kaprosuchus, KaprosuchusModel> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/kaprosuchus/kaprosuchus.png");
    private static final ResourceLocation TEXTURE_EEPY = UnusualPrehistory2.modPrefix("textures/entity/kaprosuchus/kaprosuchus_eepy.png");

    public KaprosuchusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new KaprosuchusModel(context.m_174023_(UP2ModelLayers.KAPROSUCHUS)), 0.6f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Kaprosuchus entity) {
        return entity.isEepy() ? TEXTURE_EEPY : TEXTURE;
    }
}


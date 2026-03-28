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
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.PterodactylusModel;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Pterodactylus;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import java.util.Locale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class PterodactylusRenderer
extends MobRenderer<Pterodactylus, PterodactylusModel> {
    public PterodactylusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new PterodactylusModel(context.m_174023_(UP2ModelLayers.PTERODACTYLUS)), 0.3f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(Pterodactylus entity) {
        Pterodactylus.PterodactylusVariant variant = Pterodactylus.PterodactylusVariant.byId(entity.getVariant());
        return UnusualPrehistory2.modPrefix("textures/entity/pterodactylus/" + variant.name().toLowerCase(Locale.ROOT) + ".png");
    }
}


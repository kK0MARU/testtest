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
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.PachycephalosaurusModel;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Pachycephalosaurus;
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
public class PachycephalosaurusRenderer
extends MobRenderer<Pachycephalosaurus, PachycephalosaurusModel> {
    public PachycephalosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new PachycephalosaurusModel(context.m_174023_(UP2ModelLayers.PACHYCEPHALOSAURUS)), 0.5f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(Pachycephalosaurus entity) {
        Pachycephalosaurus.PachycephalosaurusVariant variant = Pachycephalosaurus.PachycephalosaurusVariant.byId(entity.getVariant());
        if (entity.isEepy()) {
            return UnusualPrehistory2.modPrefix("textures/entity/pachycephalosaurus/" + variant.name().toLowerCase(Locale.ROOT) + "_eepy.png");
        }
        return UnusualPrehistory2.modPrefix("textures/entity/pachycephalosaurus/" + variant.name().toLowerCase(Locale.ROOT) + ".png");
    }
}


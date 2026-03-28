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
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.CarnotaurusModel;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Carnotaurus;
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
public class CarnotaurusRenderer
extends MobRenderer<Carnotaurus, CarnotaurusModel> {
    public CarnotaurusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new CarnotaurusModel(context.m_174023_(UP2ModelLayers.CARNOTAURUS)), 1.0f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(Carnotaurus entity) {
        Carnotaurus.CarnotaurusVariant variant = Carnotaurus.CarnotaurusVariant.byId(entity.getVariant());
        if (entity.isEepy()) {
            return UnusualPrehistory2.modPrefix("textures/entity/carnotaurus/" + variant.name().toLowerCase(Locale.ROOT) + "_eepy.png");
        }
        return UnusualPrehistory2.modPrefix("textures/entity/carnotaurus/" + variant.name().toLowerCase(Locale.ROOT) + ".png");
    }
}


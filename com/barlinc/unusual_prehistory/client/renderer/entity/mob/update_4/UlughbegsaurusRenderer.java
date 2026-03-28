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
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.UlughbegsaurusModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.layers.UlughbegsaurusRiderLayer;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Ulughbegsaurus;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import java.util.Locale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class UlughbegsaurusRenderer
extends MobRenderer<Ulughbegsaurus, UlughbegsaurusModel> {
    private static final ResourceLocation TEXTURE_RAINBOW = UnusualPrehistory2.modPrefix("textures/entity/ulughbegsaurus/rainbow.png");

    public UlughbegsaurusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new UlughbegsaurusModel(context.m_174023_(UP2ModelLayers.ULUGHBEGSAURUS)), 0.95f);
        this.m_115326_(new UlughbegsaurusRiderLayer((RenderLayerParent<Ulughbegsaurus, UlughbegsaurusModel>)this));
    }

    @NotNull
    public ResourceLocation getTextureLocation(Ulughbegsaurus entity) {
        if (entity.isRainbow()) {
            return TEXTURE_RAINBOW;
        }
        Ulughbegsaurus.UlughbegsaurusVariant variant = Ulughbegsaurus.UlughbegsaurusVariant.byId(entity.getVariant());
        return UnusualPrehistory2.modPrefix("textures/entity/ulughbegsaurus/" + variant.name().toLowerCase(Locale.ROOT) + ".png");
    }
}


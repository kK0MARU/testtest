/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_3.LivingOozeModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3.layers.LivingOozeContainedItemLayer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3.layers.LivingOozeOuterLayer;
import com.barlinc.unusual_prehistory.entity.mob.update_3.LivingOoze;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import javax.annotation.Nullable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class LivingOozeRenderer
extends MobRenderer<LivingOoze, LivingOozeModel> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/misc/empty.png");

    public LivingOozeRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new LivingOozeModel(context.m_174023_(UP2ModelLayers.LIVING_OOZE)), 0.6f);
        this.m_115326_(new LivingOozeContainedItemLayer(this));
        this.m_115326_(new LivingOozeOuterLayer(this));
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull LivingOoze entity) {
        return TEXTURE;
    }

    @Nullable
    protected RenderType getRenderType(@NotNull LivingOoze entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.m_110473_((ResourceLocation)this.getTextureLocation(entity));
    }
}


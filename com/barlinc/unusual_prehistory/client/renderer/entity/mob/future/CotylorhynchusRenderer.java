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
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.future;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.CotylorhynchusModel;
import com.barlinc.unusual_prehistory.entity.mob.future.Cotylorhynchus;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class CotylorhynchusRenderer
extends MobRenderer<Cotylorhynchus, CotylorhynchusModel> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/cotylorhynchus.png");

    public CotylorhynchusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new CotylorhynchusModel(context.m_174023_(UP2ModelLayers.COTYLORHYNCHUS)), 0.5f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Cotylorhynchus entity) {
        return TEXTURE;
    }
}


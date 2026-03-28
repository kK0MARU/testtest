/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Mob
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish.ArandaspisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish.CephalaspisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish.DoryaspisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish.FurcacaudaModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish.SacabambaspisModel;
import com.barlinc.unusual_prehistory.entity.mob.update_1.JawlessFish;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OnlyIn(value=Dist.CLIENT)
public class JawlessFishRenderer
extends MobRenderer<JawlessFish, UP2Model<JawlessFish>> {
    private final CephalaspisModel cephalaspisModel;
    private final DoryaspisModel doryaspisModel;
    private final FurcacaudaModel furcacaudaModel;
    private final SacabambaspisModel sacabambaspisModel;
    private final ArandaspisModel arandaspisModel;

    public JawlessFishRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new CephalaspisModel(context.m_174023_(UP2ModelLayers.JAWLESS_FISH_CEPHALASPIS)), 0.25f);
        this.cephalaspisModel = new CephalaspisModel(context.m_174023_(UP2ModelLayers.JAWLESS_FISH_CEPHALASPIS));
        this.doryaspisModel = new DoryaspisModel(context.m_174023_(UP2ModelLayers.JAWLESS_FISH_DORYASPIS));
        this.furcacaudaModel = new FurcacaudaModel(context.m_174023_(UP2ModelLayers.JAWLESS_FISH_FURACACAUDA));
        this.sacabambaspisModel = new SacabambaspisModel(context.m_174023_(UP2ModelLayers.JAWLESS_FISH_SACABAMBASPIS));
        this.arandaspisModel = new ArandaspisModel(context.m_174023_(UP2ModelLayers.JAWLESS_FISH_ARANDASPIS));
    }

    public void render(JawlessFish entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        switch (entity.getVariant()) {
            case 1: {
                this.f_115290_ = this.cephalaspisModel;
                break;
            }
            case 2: {
                this.f_115290_ = this.doryaspisModel;
                break;
            }
            case 3: {
                this.f_115290_ = this.furcacaudaModel;
                break;
            }
            case 4: {
                this.f_115290_ = this.sacabambaspisModel;
                break;
            }
            default: {
                this.f_115290_ = this.arandaspisModel;
            }
        }
        super.m_7392_((Mob)entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @NotNull
    public ResourceLocation getTextureLocation(JawlessFish entity) {
        JawlessFish.JawlessFishVariant variant = JawlessFish.JawlessFishVariant.byId(entity.getVariant());
        return UnusualPrehistory2.modPrefix("textures/entity/jawless_fish/" + variant.name().toLowerCase(Locale.ROOT) + ".png");
    }

    @Nullable
    protected RenderType getRenderType(@NotNull JawlessFish entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.m_110458_((ResourceLocation)this.getTextureLocation(entity));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.HierarchicalModel
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
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish.AllenypterusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish.EusthenopteronModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish.GooloogongiaModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish.LaccognathusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish.ScaumenaciaModel;
import com.barlinc.unusual_prehistory.entity.mob.update_4.LobeFinnedFish;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
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
public class LobeFinnedFishRenderer
extends MobRenderer<LobeFinnedFish, HierarchicalModel<LobeFinnedFish>> {
    private final AllenypterusModel allenypterusModel;
    private final EusthenopteronModel eusthenopteronModel;
    private final GooloogongiaModel gooloogongiaModel;
    private final LaccognathusModel laccognathusModel;
    private final ScaumenaciaModel scaumenaciaModel;

    public LobeFinnedFishRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new AllenypterusModel(context.m_174023_(UP2ModelLayers.LOBE_FINNED_FISH_ALLENYPTERUS)), 0.35f);
        this.allenypterusModel = new AllenypterusModel(context.m_174023_(UP2ModelLayers.LOBE_FINNED_FISH_ALLENYPTERUS));
        this.eusthenopteronModel = new EusthenopteronModel(context.m_174023_(UP2ModelLayers.LOBE_FINNED_FISH_EUSTHENOPTERON));
        this.gooloogongiaModel = new GooloogongiaModel(context.m_174023_(UP2ModelLayers.LOBE_FINNED_FISH_GOOLOOGONGIA));
        this.laccognathusModel = new LaccognathusModel(context.m_174023_(UP2ModelLayers.LOBE_FINNED_FISH_LACCOGNATHUS));
        this.scaumenaciaModel = new ScaumenaciaModel(context.m_174023_(UP2ModelLayers.LOBE_FINNED_FISH_SCAUMENACIA));
    }

    public void render(LobeFinnedFish entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        switch (entity.getVariant()) {
            case 1: {
                this.f_115290_ = this.eusthenopteronModel;
                break;
            }
            case 2: {
                this.f_115290_ = this.gooloogongiaModel;
                break;
            }
            case 3: {
                this.f_115290_ = this.laccognathusModel;
                break;
            }
            case 4: {
                this.f_115290_ = this.scaumenaciaModel;
                break;
            }
            default: {
                this.f_115290_ = this.allenypterusModel;
            }
        }
        super.m_7392_((Mob)entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @NotNull
    public ResourceLocation getTextureLocation(LobeFinnedFish entity) {
        LobeFinnedFish.LobeFinnedFishVariant variant = LobeFinnedFish.LobeFinnedFishVariant.byId(entity.getVariant());
        return UnusualPrehistory2.modPrefix("textures/entity/lobe_finned_fish/" + variant.name().toLowerCase(Locale.ROOT) + ".png");
    }

    @Nullable
    protected RenderType getRenderType(@NotNull LobeFinnedFish entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.m_110458_((ResourceLocation)this.getTextureLocation(entity));
    }
}


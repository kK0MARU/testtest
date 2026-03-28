/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Mob
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DiplocaulusBrevirostrisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DiplocaulusMagnicornisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DiplocaulusRecurvatisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DiplocaulusSalamandroidesModel;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Diplocaulus;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class DiplocaulusRenderer
extends MobRenderer<Diplocaulus, HierarchicalModel<Diplocaulus>> {
    private final DiplocaulusBrevirostrisModel brevirostrisModel;
    private final DiplocaulusMagnicornisModel magnicornisModel;
    private final DiplocaulusRecurvatisModel recurvatisModel;
    private final DiplocaulusSalamandroidesModel salamandroidesModel;

    public DiplocaulusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new DiplocaulusBrevirostrisModel(context.m_174023_(UP2ModelLayers.DIPLOCAULUS_BREVIROSTRIS)), 0.3f);
        this.brevirostrisModel = new DiplocaulusBrevirostrisModel(context.m_174023_(UP2ModelLayers.DIPLOCAULUS_BREVIROSTRIS));
        this.magnicornisModel = new DiplocaulusMagnicornisModel(context.m_174023_(UP2ModelLayers.DIPLOCAULUS_MAGNICORNIS));
        this.recurvatisModel = new DiplocaulusRecurvatisModel(context.m_174023_(UP2ModelLayers.DIPLOCAULUS_RECURVATIS));
        this.salamandroidesModel = new DiplocaulusSalamandroidesModel(context.m_174023_(UP2ModelLayers.DIPLOCAULUS_SALAMANDROIDES));
    }

    public void render(Diplocaulus entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        switch (Diplocaulus.DiplocaulusVariant.byId(entity.getVariant()).getId()) {
            case 1: {
                this.f_115290_ = this.magnicornisModel;
                break;
            }
            case 2: {
                this.f_115290_ = this.recurvatisModel;
                break;
            }
            case 3: {
                this.f_115290_ = this.salamandroidesModel;
                break;
            }
            default: {
                this.f_115290_ = this.brevirostrisModel;
            }
        }
        super.m_7392_((Mob)entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @NotNull
    public ResourceLocation getTextureLocation(Diplocaulus entity) {
        Diplocaulus.DiplocaulusVariant variant = Diplocaulus.DiplocaulusVariant.byId(entity.getVariant());
        return UnusualPrehistory2.modPrefix("textures/entity/diplocaulus/diplocaulus_" + variant.name().toLowerCase(Locale.ROOT) + ".png");
    }
}


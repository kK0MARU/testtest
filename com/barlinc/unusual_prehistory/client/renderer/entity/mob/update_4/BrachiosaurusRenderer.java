/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Mob
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.BrachiosaurusBabyModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.BrachiosaurusModel;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Brachiosaurus;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class BrachiosaurusRenderer
extends MobRenderer<Brachiosaurus, UP2Model<Brachiosaurus>> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/brachiosaurus/brachiosaurus.png");
    private static final ResourceLocation TEXTURE_EEPY = UnusualPrehistory2.modPrefix("textures/entity/brachiosaurus/brachiosaurus_eepy.png");
    private static final ResourceLocation TEXTURE_BABY = UnusualPrehistory2.modPrefix("textures/entity/brachiosaurus/brachiosaurus_baby.png");
    private final BrachiosaurusModel adultModel;
    private final BrachiosaurusBabyModel babyModel;

    public BrachiosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new BrachiosaurusModel(context.m_174023_(UP2ModelLayers.BRACHIOSAURUS)), 1.8f);
        this.adultModel = new BrachiosaurusModel(context.m_174023_(UP2ModelLayers.BRACHIOSAURUS));
        this.babyModel = new BrachiosaurusBabyModel(context.m_174023_(UP2ModelLayers.BRACHIOSAURUS_BABY));
    }

    public void render(Brachiosaurus entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
        this.f_115290_ = entity.m_6162_() ? this.babyModel : this.adultModel;
        super.m_7392_((Mob)entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Brachiosaurus entity) {
        if (entity.isEepy() && !entity.m_6162_()) {
            return TEXTURE_EEPY;
        }
        return entity.m_6162_() ? TEXTURE_BABY : TEXTURE;
    }
}


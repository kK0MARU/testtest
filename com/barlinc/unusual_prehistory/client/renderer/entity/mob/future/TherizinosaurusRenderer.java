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
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.future;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.TherizinosaurusBabyModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.TherizinosaurusModel;
import com.barlinc.unusual_prehistory.entity.mob.future.Therizinosaurus;
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
public class TherizinosaurusRenderer
extends MobRenderer<Therizinosaurus, UP2Model<Therizinosaurus>> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/therizinosaurus/therizinosaurus.png");
    private static final ResourceLocation TEXTURE_BABY = UnusualPrehistory2.modPrefix("textures/entity/therizinosaurus/therizinosaurus_baby.png");
    private final TherizinosaurusModel adultModel;
    private final TherizinosaurusBabyModel babyModel;

    public TherizinosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new TherizinosaurusModel(context.m_174023_(UP2ModelLayers.THERIZINOSAURUS)), 1.3f);
        this.adultModel = new TherizinosaurusModel(context.m_174023_(UP2ModelLayers.THERIZINOSAURUS));
        this.babyModel = new TherizinosaurusBabyModel(context.m_174023_(UP2ModelLayers.THERIZINOSAURUS_BABY));
    }

    public void render(Therizinosaurus entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
        this.f_115290_ = entity.m_6162_() ? this.babyModel : this.adultModel;
        super.m_7392_((Mob)entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Therizinosaurus entity) {
        if (entity.m_6162_()) {
            return TEXTURE_BABY;
        }
        return TEXTURE;
    }
}


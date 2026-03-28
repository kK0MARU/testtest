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
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.UnicornModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.UnicornSkeletonModel;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Unicorn;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
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
public class UnicornRenderer
extends MobRenderer<Unicorn, HierarchicalModel<Unicorn>> {
    private final UnicornModel unicornModel;
    private final UnicornSkeletonModel unicornSkeletonModel;
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/unicorn/unicorn.png");
    private static final ResourceLocation TEXTURE_SKELETON = UnusualPrehistory2.modPrefix("textures/entity/unicorn/unicorn_skeleton.png");

    public UnicornRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new UnicornModel(context.m_174023_(UP2ModelLayers.UNICORN)), 0.9f);
        this.unicornModel = new UnicornModel(context.m_174023_(UP2ModelLayers.UNICORN));
        this.unicornSkeletonModel = new UnicornSkeletonModel(context.m_174023_(UP2ModelLayers.UNICORN_SKELETON));
    }

    public void render(Unicorn entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        this.f_115290_ = entity.isSkeletal() ? this.unicornSkeletonModel : this.unicornModel;
        super.m_7392_((Mob)entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @NotNull
    public ResourceLocation getTextureLocation(Unicorn entity) {
        if (entity.isSkeletal()) {
            return TEXTURE_SKELETON;
        }
        return TEXTURE;
    }

    @Nullable
    protected RenderType getRenderType(Unicorn entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        if (entity.isSkeletal()) {
            return RenderType.m_110458_((ResourceLocation)this.getTextureLocation(entity));
        }
        return RenderType.m_110452_((ResourceLocation)this.getTextureLocation(entity));
    }
}


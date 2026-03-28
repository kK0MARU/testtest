/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.layers;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.MegalaniaModel;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Megalania;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class MegalaniaTemperatureLayer
extends RenderLayer<Megalania, MegalaniaModel> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_temperate.png");
    private static final ResourceLocation TEXTURE_COLD = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_cold.png");
    private static final ResourceLocation TEXTURE_WARM = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_warm.png");
    private static final ResourceLocation TEXTURE_NETHER = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_nether.png");
    private static final ResourceLocation TEXTURE_EEPY = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_temperate_eepy.png");
    private static final ResourceLocation TEXTURE_COLD_EEPY = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_cold_eepy.png");
    private static final ResourceLocation TEXTURE_WARM_EEPY = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_warm_eepy.png");
    private static final ResourceLocation TEXTURE_NETHER_EEPY = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_nether_eepy.png");

    public MegalaniaTemperatureLayer(RenderLayerParent<Megalania, MegalaniaModel> parent) {
        super(parent);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, Megalania entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.m_20145_()) {
            return;
        }
        Megalania.TemperatureStates prev = entity.getPrevTemperatureState();
        Megalania.TemperatureStates current = entity.getTemperatureState();
        if (prev == null || prev == current) {
            return;
        }
        float progress = entity.getTempProgress(partialTicks);
        float alpha = 1.0f - progress;
        if (alpha <= 0.0f) {
            return;
        }
        VertexConsumer consumer = buffer.m_6299_(RenderType.m_110473_((ResourceLocation)this.getTexture(entity)));
        ((MegalaniaModel)this.m_117386_()).m_7695_(poseStack, consumer, packedLight, LivingEntityRenderer.m_115338_((LivingEntity)entity, (float)0.0f), 1.0f, 1.0f, 1.0f, alpha);
    }

    public ResourceLocation getTexture(Megalania entity) {
        return switch (entity.getPrevTemperatureState()) {
            case Megalania.TemperatureStates.COLD -> {
                if (entity.isEepy()) {
                    yield TEXTURE_COLD_EEPY;
                }
                yield TEXTURE_COLD;
            }
            case Megalania.TemperatureStates.WARM -> {
                if (entity.isEepy()) {
                    yield TEXTURE_WARM_EEPY;
                }
                yield TEXTURE_WARM;
            }
            case Megalania.TemperatureStates.NETHER -> {
                if (entity.isEepy()) {
                    yield TEXTURE_NETHER_EEPY;
                }
                yield TEXTURE_NETHER;
            }
            default -> entity.isEepy() ? TEXTURE_EEPY : TEXTURE;
        };
    }
}


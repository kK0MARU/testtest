/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.MegalaniaModel;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.layers.MegalaniaTemperatureLayer;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Megalania;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OnlyIn(value=Dist.CLIENT)
public class MegalaniaRenderer
extends MobRenderer<Megalania, MegalaniaModel> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_temperate.png");
    private static final ResourceLocation TEXTURE_COLD = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_cold.png");
    private static final ResourceLocation TEXTURE_WARM = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_warm.png");
    private static final ResourceLocation TEXTURE_NETHER = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_nether.png");
    private static final ResourceLocation TEXTURE_EEPY = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_temperate_eepy.png");
    private static final ResourceLocation TEXTURE_COLD_EEPY = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_cold_eepy.png");
    private static final ResourceLocation TEXTURE_WARM_EEPY = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_warm_eepy.png");
    private static final ResourceLocation TEXTURE_NETHER_EEPY = UnusualPrehistory2.modPrefix("textures/entity/megalania/megalania_nether_eepy.png");

    public MegalaniaRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new MegalaniaModel(context.m_174023_(UP2ModelLayers.MEGALANIA)), 0.9f);
        this.m_115326_(new MegalaniaTemperatureLayer((RenderLayerParent<Megalania, MegalaniaModel>)this));
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Megalania entity) {
        return switch (entity.getTemperatureState()) {
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

    @Nullable
    protected RenderType getRenderType(@NotNull Megalania entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.m_110458_((ResourceLocation)this.getTextureLocation(entity));
    }
}


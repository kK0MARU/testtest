/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.datafixers.util.Pair
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.ExtraCodecs
 *  net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
 */
package com.barlinc.unusual_prehistory.worldgen.feature.config;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record StructureFeatureConfig(ResourceLocation processor, ResourceLocation postProcessor, List<Pair<ResourceLocation, Integer>> structureLocationAndWeights, int structureYOffset) implements FeatureConfiguration
{
    public static final Codec<StructureFeatureConfig> CODEC = RecordCodecBuilder.create(configInstance -> configInstance.group((App)ResourceLocation.f_135803_.fieldOf("processors").forGetter(featureConfig -> featureConfig.processor), (App)ResourceLocation.f_135803_.fieldOf("post_processors").orElse((Object)new ResourceLocation("minecraft:empty")).forGetter(featureConfig -> featureConfig.postProcessor), (App)Codec.mapPair((MapCodec)ResourceLocation.f_135803_.fieldOf("structure"), (MapCodec)ExtraCodecs.f_144629_.fieldOf("weight")).codec().listOf().fieldOf("structures").forGetter(featureConfig -> featureConfig.structureLocationAndWeights), (App)Codec.INT.fieldOf("y_offset").orElse((Object)0).forGetter(featureConfig -> featureConfig.structureYOffset)).apply((Applicative)configInstance, StructureFeatureConfig::new));
}


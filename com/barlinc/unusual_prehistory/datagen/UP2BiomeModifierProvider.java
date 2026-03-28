/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.core.HolderSet
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.worldgen.BootstapContext
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.biome.MobSpawnSettings$SpawnerData
 *  net.minecraft.world.level.levelgen.GenerationStep$Decoration
 *  net.minecraft.world.level.levelgen.placement.PlacedFeature
 *  net.minecraftforge.common.world.BiomeModifier
 *  net.minecraftforge.common.world.ForgeBiomeModifiers$AddFeaturesBiomeModifier
 *  net.minecraftforge.common.world.ForgeBiomeModifiers$AddSpawnsBiomeModifier
 *  net.minecraftforge.common.world.ForgeBiomeModifiers$RemoveFeaturesBiomeModifier
 *  net.minecraftforge.common.world.ForgeBiomeModifiers$RemoveSpawnsBiomeModifier
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.ForgeRegistries$Keys
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid="unusual_prehistory", bus=Mod.EventBusSubscriber.Bus.MOD)
public class UP2BiomeModifierProvider {
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
    }

    private static void addSpawn(BootstapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, MobSpawnSettings.SpawnerData ... spawns) {
        UP2BiomeModifierProvider.register(context, "add_spawn/" + name, () -> new ForgeBiomeModifiers.AddSpawnsBiomeModifier((HolderSet)context.m_255420_(Registries.f_256952_).m_254956_(biomes), List.of((Object[])spawns)));
    }

    private static void removeSpawn(BootstapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, EntityType<?> ... types) {
        UP2BiomeModifierProvider.register(context, "remove_spawn/" + name, () -> new ForgeBiomeModifiers.RemoveSpawnsBiomeModifier((HolderSet)context.m_255420_(Registries.f_256952_).m_254956_(biomes), (HolderSet)HolderSet.m_205800_(Stream.of(types).map(type -> (Holder)ForgeRegistries.ENTITY_TYPES.getHolder(type).get()).collect(Collectors.toList()))));
    }

    @SafeVarargs
    private static void addFeature(BootstapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, GenerationStep.Decoration step, ResourceKey<PlacedFeature> ... features) {
        UP2BiomeModifierProvider.register(context, "add_feature/" + name, () -> new ForgeBiomeModifiers.AddFeaturesBiomeModifier((HolderSet)context.m_255420_(Registries.f_256952_).m_254956_(biomes), UP2BiomeModifierProvider.featureSet(context, features), step));
    }

    @SafeVarargs
    private static void removeFeature(BootstapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, GenerationStep.Decoration step, ResourceKey<PlacedFeature> ... features) {
        UP2BiomeModifierProvider.register(context, "remove_feature/" + name, () -> new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier((HolderSet)context.m_255420_(Registries.f_256952_).m_254956_(biomes), UP2BiomeModifierProvider.featureSet(context, features), Set.of((Object)step)));
    }

    private static void register(BootstapContext<BiomeModifier> context, String name, Supplier<? extends BiomeModifier> modifier) {
        context.m_255272_(ResourceKey.m_135785_((ResourceKey)ForgeRegistries.Keys.BIOME_MODIFIERS, (ResourceLocation)UnusualPrehistory2.modPrefix(name)), (Object)modifier.get());
    }

    @SafeVarargs
    private static HolderSet<PlacedFeature> featureSet(BootstapContext<?> context, ResourceKey<PlacedFeature> ... features) {
        return HolderSet.m_205800_(Stream.of(features).map(placedFeatureKey -> context.m_255420_(Registries.f_256988_).m_255043_(placedFeatureKey)).collect(Collectors.toList()));
    }
}


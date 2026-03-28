/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.levelgen.feature.ConfiguredFeature
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration
 *  net.minecraft.world.level.levelgen.placement.PlacedFeature
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.worldgen.feature.CalamophytonFeature;
import com.barlinc.unusual_prehistory.worldgen.feature.StructureFeature;
import com.barlinc.unusual_prehistory.worldgen.feature.config.StructureFeatureConfig;
import com.barlinc.unusual_prehistory.worldgen.feature.tree.TreeFromStructureFeature;
import com.barlinc.unusual_prehistory.worldgen.feature.tree.config.TreeFromStructureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class UP2Features {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create((IForgeRegistry)ForgeRegistries.FEATURES, (String)"unusual_prehistory");
    public static final RegistryObject<CalamophytonFeature> CALAMOPHYTON = FEATURES.register("calamophyton", () -> new CalamophytonFeature((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
    public static final RegistryObject<Feature<StructureFeatureConfig>> STRUCTURE_FEATURE = FEATURES.register("structure_feature", () -> new StructureFeature(StructureFeatureConfig.CODEC));
    public static final RegistryObject<Feature<TreeFromStructureConfig>> TREE_STRUCTURE_FEATURE = FEATURES.register("tree", () -> new TreeFromStructureFeature(TreeFromStructureConfig.CODEC));
    public static final ResourceKey<PlacedFeature> MOSS_LAYER_BONEMEAL = UP2Features.createPlacedFeatureKey("moss_layer_bonemeal");
    public static final ResourceKey<PlacedFeature> PATCH_MOSSY_DIRT_PLANTS = UP2Features.createPlacedFeatureKey("patch_mossy_dirt_plants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYCAD = UP2Features.createConfiguredFeatureKey("cycad");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM = UP2Features.createConfiguredFeatureKey("dryophyllum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM_BEES = UP2Features.createConfiguredFeatureKey("dryophyllum_bees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GINKGO = UP2Features.createConfiguredFeatureKey("ginkgo");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GINKGO_BEES = UP2Features.createConfiguredFeatureKey("ginkgo_bees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_GINKGO = UP2Features.createConfiguredFeatureKey("golden_ginkgo");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_GINKGO_BEES = UP2Features.createConfiguredFeatureKey("golden_ginkgo_bees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEPIDODENDRON = UP2Features.createConfiguredFeatureKey("lepidodendron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> METASEQUOIA = UP2Features.createConfiguredFeatureKey("metasequoia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_METASEQUOIA = UP2Features.createConfiguredFeatureKey("mega_metasequoia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PROTOTAXITES = UP2Features.createConfiguredFeatureKey("prototaxites");

    private static ResourceKey<PlacedFeature> createPlacedFeatureKey(String name) {
        return ResourceKey.m_135785_((ResourceKey)Registries.f_256988_, (ResourceLocation)UnusualPrehistory2.modPrefix(name));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createConfiguredFeatureKey(String name) {
        return ResourceKey.m_135785_((ResourceKey)Registries.f_256911_, (ResourceLocation)UnusualPrehistory2.modPrefix(name));
    }
}


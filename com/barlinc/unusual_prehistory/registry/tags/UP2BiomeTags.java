/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.biome.Biome
 */
package com.barlinc.unusual_prehistory.registry.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class UP2BiomeTags {
    public static final TagKey<Biome> HAS_FOSSIL = UP2BiomeTags.modBiomeTag("has_structure/fossil");
    public static final TagKey<Biome> HAS_TAR_PIT = UP2BiomeTags.modBiomeTag("has_structure/tar_pit");
    public static final TagKey<Biome> HAS_PETRIFIED_TREE = UP2BiomeTags.modBiomeTag("has_structure/petrified_tree");

    private static TagKey<Biome> modBiomeTag(String name) {
        return UP2BiomeTags.biomeTag("unusual_prehistory", name);
    }

    private static TagKey<Biome> forgeBiomeTag(String name) {
        return UP2BiomeTags.biomeTag("forge", name);
    }

    public static TagKey<Biome> biomeTag(String modid, String name) {
        return TagKey.m_203882_((ResourceKey)Registries.f_256952_, (ResourceLocation)new ResourceLocation(modid, name));
    }
}


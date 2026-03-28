/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.tags.BiomeTagsProvider
 *  net.minecraft.tags.BiomeTags
 *  net.minecraftforge.common.Tags$Biomes
 *  net.minecraftforge.common.data.ExistingFileHelper
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.registry.tags.UP2BiomeTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class UP2BiomeTagProvider
extends BiomeTagsProvider {
    public UP2BiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, "unusual_prehistory", helper);
    }

    protected void m_6577_(@NotNull HolderLookup.Provider provider) {
        this.addTags();
    }

    protected void addTags() {
        this.m_206424_(UP2BiomeTags.HAS_FOSSIL).m_206428_(BiomeTags.f_207609_).m_206428_(BiomeTags.f_207611_).m_206428_(BiomeTags.f_207610_).m_206428_(BiomeTags.f_215816_).m_206428_(BiomeTags.f_207607_).m_206428_(Tags.Biomes.IS_PLAINS).m_206428_(Tags.Biomes.IS_SWAMP).m_206428_(Tags.Biomes.IS_DESERT);
        this.m_206424_(UP2BiomeTags.HAS_TAR_PIT).m_206428_(BiomeTags.f_207609_).m_206428_(BiomeTags.f_207611_).m_206428_(BiomeTags.f_207610_).m_206428_(BiomeTags.f_215816_).m_206428_(Tags.Biomes.IS_PLAINS);
        this.m_206424_(UP2BiomeTags.HAS_PETRIFIED_TREE).m_206428_(BiomeTags.f_207609_).m_206428_(BiomeTags.f_207611_).m_206428_(BiomeTags.f_215816_).m_206428_(BiomeTags.f_207607_).m_206428_(Tags.Biomes.IS_PLAINS).m_206428_(Tags.Biomes.IS_DESERT);
    }
}


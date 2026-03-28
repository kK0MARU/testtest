/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.RegistrySetBuilder
 *  net.minecraft.data.PackOutput
 *  net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
 *  net.minecraftforge.registries.ForgeRegistries$Keys
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.datagen.UP2BiomeModifierProvider;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class UP2DatapackProvider
extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().m_254916_(ForgeRegistries.Keys.BIOME_MODIFIERS, UP2BiomeModifierProvider::bootstrap);

    public UP2DatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of((Object)"unusual_prehistory"));
    }
}


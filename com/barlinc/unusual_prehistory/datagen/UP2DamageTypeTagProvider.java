/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.tags.TagsProvider
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.world.damagesource.DamageType
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraftforge.common.data.ExistingFileHelper
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.registry.UP2DamageTypes;
import com.barlinc.unusual_prehistory.registry.tags.UP2DamageTypeTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class UP2DamageTypeTagProvider
extends TagsProvider<DamageType> {
    public UP2DamageTypeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, Registries.f_268580_, provider, "unusual_prehistory", helper);
    }

    protected void m_6577_(@NotNull HolderLookup.Provider provider) {
        this.m_206424_(UP2DamageTypeTags.KENTROSAURUS_IMMUNE_TO).m_211101_(new ResourceKey[]{DamageTypes.f_268585_, DamageTypes.f_268469_, DamageTypes.f_268440_});
        this.m_206424_(UP2DamageTypeTags.LYSTROSAURUS_IMMUNE_TO).m_211101_(new ResourceKey[]{DamageTypes.f_268585_, DamageTypes.f_268469_, DamageTypes.f_268440_, DamageTypes.f_268526_, DamageTypes.f_268513_, DamageTypes.f_268612_}).m_206428_(DamageTypeTags.f_268745_).m_206428_(DamageTypeTags.f_268419_).m_206428_(DamageTypeTags.f_268549_).m_206428_(DamageTypeTags.f_268524_);
        this.m_206424_(DamageTypeTags.f_268490_).m_255204_(UP2DamageTypes.EXECUTE);
    }
}


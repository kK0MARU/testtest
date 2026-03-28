/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.damagesource.DamageType
 */
package com.barlinc.unusual_prehistory.registry.tags;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;

public class UP2DamageTypeTags {
    public static final TagKey<DamageType> KENTROSAURUS_IMMUNE_TO = UP2DamageTypeTags.damageTypeTag("kentrosaurus_immune_to");
    public static final TagKey<DamageType> LYSTROSAURUS_IMMUNE_TO = UP2DamageTypeTags.damageTypeTag("lystrosaurus_immune_to");

    public static TagKey<DamageType> damageTypeTag(String name) {
        return TagKey.m_203882_((ResourceKey)Registries.f_268580_, (ResourceLocation)UnusualPrehistory2.modPrefix(name));
    }
}


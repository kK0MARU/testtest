/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageType
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import javax.annotation.Nullable;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class UP2DamageTypes {
    public static final ResourceKey<DamageType> EXECUTE = UP2DamageTypes.register("execute");

    public static DamageSource execute(Level level, Entity source, @Nullable Entity causingEntity) {
        return level.m_269111_().m_268998_(EXECUTE, source, causingEntity);
    }

    public static ResourceKey<DamageType> register(String name) {
        return ResourceKey.m_135785_((ResourceKey)Registries.f_268580_, (ResourceLocation)UnusualPrehistory2.modPrefix(name));
    }
}


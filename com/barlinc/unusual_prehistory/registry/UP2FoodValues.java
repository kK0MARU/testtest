/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.food.FoodProperties
 *  net.minecraft.world.food.FoodProperties$Builder
 */
package com.barlinc.unusual_prehistory.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class UP2FoodValues {
    public static final FoodProperties GINKGO_FRUIT = new FoodProperties.Builder().m_38760_(4).m_38758_(0.2f).effect(() -> new MobEffectInstance(MobEffects.f_19604_, 300, 0), 0.5f).m_38767_();
}


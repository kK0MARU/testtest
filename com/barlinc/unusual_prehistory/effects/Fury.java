/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectCategory
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.ai.attributes.AttributeMap
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.effects;

import java.util.UUID;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

public class Fury
extends MobEffect {
    private static final UUID FURY_ATTACK_SPEED_UUID = UUID.fromString("e0f87c4e-afbb-48b4-830b-815cff012072");
    private static final UUID FURY_SPEED_UUID = UUID.fromString("ef0f8dee-c1e8-4021-8620-0eae949aff55");

    public Fury() {
        super(MobEffectCategory.BENEFICIAL, 9187111);
    }

    public void m_6742_(LivingEntity entity, int level) {
        AttributeInstance attackSpeed = entity.m_21051_(Attributes.f_22283_);
        AttributeInstance speed = entity.m_21051_(Attributes.f_22279_);
        float levelScale = (float)(1 + level) * 2.5f;
        if (attackSpeed != null) {
            this.removeFuryModifiers(entity);
            float attackSpeedBoost = (1.0f - entity.m_21223_() / entity.m_21233_()) * levelScale * 0.5f;
            attackSpeed.m_22118_(new AttributeModifier(FURY_ATTACK_SPEED_UUID, "Fury attack speed boost", (double)attackSpeedBoost, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        if (speed != null) {
            this.removeFuryModifiers(entity);
            float speedBoost = (1.0f - entity.m_21223_() / entity.m_21233_()) * levelScale * 0.2f;
            speed.m_22118_(new AttributeModifier(FURY_SPEED_UUID, "Fury speed boost", (double)speedBoost, AttributeModifier.Operation.MULTIPLY_BASE));
        }
    }

    public boolean m_6584_(int duration, int amplifier) {
        return duration > 0;
    }

    protected void removeFuryModifiers(LivingEntity living) {
        AttributeInstance attackSpeed = living.m_21051_(Attributes.f_22283_);
        AttributeInstance speed = living.m_21051_(Attributes.f_22279_);
        if (attackSpeed != null && attackSpeed.m_22111_(FURY_ATTACK_SPEED_UUID) != null) {
            attackSpeed.m_22120_(FURY_ATTACK_SPEED_UUID);
        }
        if (speed != null && speed.m_22111_(FURY_SPEED_UUID) != null) {
            speed.m_22120_(FURY_SPEED_UUID);
        }
    }

    public void m_6385_(@NotNull LivingEntity entity, @NotNull AttributeMap map, int i) {
        super.m_6385_(entity, map, i);
    }

    public void m_6386_(@NotNull LivingEntity entity, @NotNull AttributeMap map, int i) {
        super.m_6386_(entity, map, i);
        this.removeFuryModifiers(entity);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.animation.AnimationChannel
 *  net.minecraft.client.animation.AnimationChannel$Interpolations
 *  net.minecraft.client.animation.AnimationChannel$Targets
 *  net.minecraft.client.animation.AnimationDefinition
 *  net.minecraft.client.animation.AnimationDefinition$Builder
 *  net.minecraft.client.animation.Keyframe
 *  net.minecraft.client.animation.KeyframeAnimations
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class DiplocaulusAnimations {
    public static final AnimationDefinition BABY_TRANSFORM = AnimationDefinition.Builder.m_232275_((float)0.0f).m_232274_().m_232279_("head", new AnimationChannel(AnimationChannel.Targets.f_232252_, new Keyframe[]{new Keyframe(0.0f, KeyframeAnimations.m_253004_((double)1.5, (double)1.5, (double)1.5), AnimationChannel.Interpolations.f_232229_)})).m_232282_();
}


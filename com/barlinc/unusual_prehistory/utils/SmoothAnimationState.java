/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.animation.AnimationDefinition
 *  net.minecraft.client.animation.KeyframeAnimations
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.joml.Vector3f
 */
package com.barlinc.unusual_prehistory.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector3f;

public class SmoothAnimationState
extends AnimationState {
    public static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();
    public float factorOld;
    public float factor;
    public final float lerpSpeed;

    public SmoothAnimationState(float lerpSpeed) {
        this.lerpSpeed = lerpSpeed;
    }

    public SmoothAnimationState() {
        this(0.5f);
    }

    public void m_246184_(boolean condition, int tickCount) {
        float target = condition ? 1.0f : 0.0f;
        this.factorOld = this.factor;
        this.factor += (target - this.factor) * this.lerpSpeed;
        this.factor = Mth.m_14036_((float)this.factor, (float)0.0f, (float)1.0f);
        if (condition) {
            this.m_216982_(tickCount);
        } else {
            this.m_216973_();
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public float factor() {
        return Mth.m_14179_((float)Minecraft.m_91087_().getPartialTick(), (float)this.factorOld, (float)this.factor);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void animate(HierarchicalModel<?> model, AnimationDefinition definition, float ageInTicks) {
        this.animate(model, definition, ageInTicks, this.factor(), 1.0f);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void animate(HierarchicalModel<?> model, AnimationDefinition definition, float ageInTicks, float speed) {
        this.animate(model, definition, ageInTicks, this.factor(), speed);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void animateIdle(HierarchicalModel<?> model, AnimationDefinition definition, float ageInTicks, float limbSwingAmount, float animationScaleFactor, SmoothAnimationState ... states) {
        this.animateIdle(model, definition, ageInTicks, limbSwingAmount, animationScaleFactor, 0.01f, states);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void animateIdle(HierarchicalModel<?> model, AnimationDefinition definition, float ageInTicks, float limbSwingAmount, float animationScaleFactor, float threshold, SmoothAnimationState ... states) {
        float totalFactor = 1.0f;
        float extraFactor = 0.0f;
        for (SmoothAnimationState state : states) {
            float factor = state.factor();
            totalFactor *= 1.0f - factor;
            extraFactor += factor;
        }
        float limb = Math.min(limbSwingAmount * (totalFactor + extraFactor) * animationScaleFactor, 1.0f);
        this.animate(model, definition, ageInTicks, Math.max(this.factor() * (1.0f - limb), threshold), 1.0f);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void animate(HierarchicalModel<?> model, AnimationDefinition definition, float ageInTicks, float factor, float speed) {
        this.m_216974_(ageInTicks, speed);
        KeyframeAnimations.m_232319_(model, (AnimationDefinition)definition, (long)this.m_216981_(), (float)factor, (Vector3f)ANIMATION_VECTOR_CACHE);
    }
}


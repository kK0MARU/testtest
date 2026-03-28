/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.animation.AnimationDefinition
 *  net.minecraft.client.animation.KeyframeAnimations
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package com.barlinc.unusual_prehistory.client.models.entity;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.function.Function;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public abstract class UP2Model<E extends Entity>
extends HierarchicalModel<E> {
    private static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();
    protected final float youngScaleFactor;
    protected final float bodyYOffset;

    public UP2Model(float youngScaleFactor, float youngBodyYoffset) {
        this(youngScaleFactor, youngBodyYoffset, RenderType::m_110458_);
    }

    public UP2Model(float youngScaleFactor, float youngBodyYoffset, Function<ResourceLocation, RenderType> renderType) {
        super(renderType);
        this.bodyYOffset = youngBodyYoffset;
        this.youngScaleFactor = youngScaleFactor;
    }

    public void m_7695_(PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.m_85836_();
        if (this.f_102610_) {
            poseStack.m_85841_(this.youngScaleFactor, this.youngScaleFactor, this.youngScaleFactor);
            poseStack.m_252880_(0.0f, this.bodyYOffset / 16.0f, 0.0f);
        }
        this.m_142109_().m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.m_85849_();
    }

    protected void animateIdle(AnimationState animationState, AnimationDefinition definition, float ageInTicks, float limbSwingAmount) {
        this.animateIdle(animationState, definition, ageInTicks, 1.0f, limbSwingAmount);
    }

    protected void animateIdle(AnimationState animationState, AnimationDefinition definition, float ageInTicks, float speed, float limbSwingAmount) {
        float scale = Math.max(0.0f, Math.min(1.0f - Math.abs(limbSwingAmount), 1.0f));
        animationState.m_216974_(ageInTicks, speed);
        animationState.m_216979_(state -> KeyframeAnimations.m_232319_((HierarchicalModel)this, (AnimationDefinition)definition, (long)state.m_216981_(), (float)scale, (Vector3f)ANIMATION_VECTOR_CACHE));
    }

    protected void animateLerped(AnimationState animationState, AnimationDefinition definition, float ageInTicks, float lerp) {
        this.animateLerped(animationState, definition, ageInTicks, 1.0f, lerp);
    }

    protected void animateLerped(AnimationState animationState, AnimationDefinition definition, float ageInTicks, float speed, float lerp) {
        float scale = Math.max(0.0f, Math.min(lerp, 1.0f));
        animationState.m_216974_(ageInTicks, speed);
        animationState.m_216979_(state -> KeyframeAnimations.m_232319_((HierarchicalModel)this, (AnimationDefinition)definition, (long)state.m_216981_(), (float)scale, (Vector3f)ANIMATION_VECTOR_CACHE));
    }

    protected void m_233381_(@NotNull AnimationState animationState, @NotNull AnimationDefinition definition, float ageInTicks) {
        this.m_233385_(animationState, definition, ageInTicks, 1.0f);
    }

    protected void m_267799_(@NotNull AnimationDefinition definition, float limbSwing, float limbSwingAmount, float maxAnimationSpeed, float animationScaleFactor) {
        if (limbSwing != 0.0f && limbSwingAmount != 0.0f) {
            long i = (long)(limbSwing * 50.0f * maxAnimationSpeed);
            float f = Math.min(limbSwingAmount * animationScaleFactor, 1.0f);
            KeyframeAnimations.m_232319_((HierarchicalModel)this, (AnimationDefinition)definition, (long)i, (float)f, (Vector3f)ANIMATION_VECTOR_CACHE);
        }
    }

    protected void m_233385_(AnimationState animationState, @NotNull AnimationDefinition definition, float ageInTicks, float speed) {
        animationState.m_216974_(ageInTicks, speed);
        animationState.m_216979_(state -> KeyframeAnimations.m_232319_((HierarchicalModel)this, (AnimationDefinition)definition, (long)state.m_216981_(), (float)1.0f, (Vector3f)ANIMATION_VECTOR_CACHE));
    }

    protected void animateIdleSmooth(SmoothAnimationState animationState, @NotNull AnimationDefinition definition, float ageInTicks, float limbSwingAmount) {
        animationState.animateIdle(this, definition, ageInTicks, limbSwingAmount, 1.5f, new SmoothAnimationState[0]);
    }

    protected void animateIdleSmooth(SmoothAnimationState animationState, @NotNull AnimationDefinition definition, float ageInTicks, float limbSwingAmount, float animationScaleFactor) {
        animationState.animateIdle(this, definition, ageInTicks, limbSwingAmount, animationScaleFactor, new SmoothAnimationState[0]);
    }

    protected void animateSmooth(SmoothAnimationState animationState, @NotNull AnimationDefinition definition, float ageInTicks) {
        this.animateSmooth(animationState, definition, ageInTicks, 1.0f);
    }

    protected void animateSmooth(SmoothAnimationState animationState, @NotNull AnimationDefinition definition, float ageInTicks, float speed) {
        animationState.animate(this, definition, ageInTicks, speed);
    }

    protected void m_288214_(@NotNull AnimationDefinition definition) {
        KeyframeAnimations.m_232319_((HierarchicalModel)this, (AnimationDefinition)definition, (long)0L, (float)1.0f, (Vector3f)ANIMATION_VECTOR_CACHE);
    }

    protected void animateHead(PrehistoricMob entity, ModelPart part, float netHeadYaw, float headPitch) {
        if (!entity.isEepy() && !entity.isSitting()) {
            part.f_104203_ += headPitch * ((float)Math.PI / 180) / 2.0f;
            part.f_104204_ += netHeadYaw * ((float)Math.PI / 180) / 2.0f;
        }
    }
}


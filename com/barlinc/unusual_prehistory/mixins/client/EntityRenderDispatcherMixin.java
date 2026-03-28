/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.AABB
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.barlinc.unusual_prehistory.mixins.client;

import com.barlinc.unusual_prehistory.entity.mob.update_2.Onchopristis;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityRenderDispatcher.class})
public class EntityRenderDispatcherMixin {
    @Inject(method={"renderHitbox"}, at={@At(value="TAIL")})
    private static void unusualPrehistory2$renderHitbox(PoseStack poseStack, VertexConsumer consumer, Entity entity, float partialTicks, CallbackInfo ci) {
        if (entity instanceof Onchopristis) {
            Onchopristis onchopristis = (Onchopristis)entity;
            AABB aABB = onchopristis.getAggroHitbox().m_82386_(-entity.m_20185_(), -entity.m_20186_(), -entity.m_20189_());
            LevelRenderer.m_109646_((PoseStack)poseStack, (VertexConsumer)consumer, (AABB)aABB, (float)1.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        }
    }
}


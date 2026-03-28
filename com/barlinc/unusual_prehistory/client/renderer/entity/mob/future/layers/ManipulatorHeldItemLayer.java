/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.ItemInHandRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.layers;

import com.barlinc.unusual_prehistory.client.models.entity.mob.future.ManipulatorModel;
import com.barlinc.unusual_prehistory.entity.mob.future.Manipulator;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ManipulatorHeldItemLayer
extends RenderLayer<Manipulator, ManipulatorModel> {
    private final ItemInHandRenderer itemInHandRenderer;

    public ManipulatorHeldItemLayer(RenderLayerParent<Manipulator, ManipulatorModel> pRenderer, ItemInHandRenderer pItemInHandRenderer) {
        super(pRenderer);
        this.itemInHandRenderer = pItemInHandRenderer;
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, Manipulator entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
        ItemStack rightStack;
        boolean flag = entity.m_5737_() == HumanoidArm.RIGHT;
        ItemStack leftStack = flag ? entity.m_21206_() : entity.m_21205_();
        ItemStack itemStack = rightStack = flag ? entity.m_21205_() : entity.m_21206_();
        if (!leftStack.m_41619_() || !rightStack.m_41619_()) {
            poseStack.m_85836_();
            this.renderArmWithItem(entity, rightStack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, HumanoidArm.RIGHT, poseStack, bufferSource, packedLight);
            this.renderArmWithItem(entity, leftStack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND, HumanoidArm.LEFT, poseStack, bufferSource, packedLight);
            poseStack.m_85849_();
        }
    }

    protected void renderArmWithItem(Manipulator entity, ItemStack itemStack, ItemDisplayContext displayContext, HumanoidArm arm, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (!itemStack.m_41619_()) {
            poseStack.m_85836_();
            boolean flag = arm == HumanoidArm.LEFT;
            ((ManipulatorModel)this.m_117386_()).translateToHand(arm, poseStack);
            poseStack.m_252781_(Axis.f_252529_.m_252977_(-90.0f));
            poseStack.m_252781_(Axis.f_252436_.m_252977_(180.0f));
            poseStack.m_252781_(Axis.f_252436_.m_252977_(flag ? -60.0f : 60.0f));
            poseStack.m_252880_(0.0f, 0.05f, -0.25f);
            this.itemInHandRenderer.m_269530_((LivingEntity)entity, itemStack, displayContext, flag, poseStack, bufferSource, packedLight);
            poseStack.m_85849_();
        }
    }
}


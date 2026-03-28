/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_3;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_3.LivingOozeAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_3.LivingOoze;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class LivingOozeModel
extends UP2Model<LivingOoze> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart body_squish;
    public final ModelPart core;
    public final ModelPart core_squish;

    public LivingOozeModel(ModelPart root) {
        super(1.0f, 0.0f);
        this.root = root.m_171324_("root");
        this.body = this.root.m_171324_("body");
        this.body_squish = this.body.m_171324_("body_squish");
        this.core = this.body.m_171324_("core");
        this.core_squish = this.core.m_171324_("core_squish");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)16.0f, (float)0.0f));
        PartDefinition body = root.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body_squish = body.m_171599_("body_squish", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)8.0f, (float)0.0f));
        PartDefinition core = body.m_171599_("core", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition core_squish = core.m_171599_("core_squish", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-4.0f, -12.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)8.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(@NotNull LivingOoze entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.m_233381_(entity.processingAnimationState, LivingOozeAnimations.PROCESSING, ageInTicks);
        this.m_233381_(entity.spittingAnimationState, LivingOozeAnimations.SPIT_OUT, ageInTicks);
        this.m_233381_(entity.cooldownAnimationState, LivingOozeAnimations.TRAUMA, ageInTicks);
        float partialTicks = ageInTicks - (float)entity.f_19797_;
        float jumpProgress = entity.getJumpProgress(partialTicks);
        float squishProgress = entity.getSquishProgress(partialTicks);
        float jiggleTime = entity.getJiggleTime(partialTicks);
        float squishJiggle = jiggleTime * (float)(1.0 + Math.sin((double)jiggleTime * Math.PI * 2.0)) * 0.5f;
        float xzScale = 0.9f - 0.1f * jumpProgress + 0.15f * squishProgress + squishJiggle;
        float yScale = 1.0f + jumpProgress / 3.0f - 0.5f * squishProgress * 0.03f - squishJiggle * 0.5f;
        this.root.f_233553_ = xzScale;
        this.root.f_233554_ = yScale;
        this.root.f_233555_ = xzScale;
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }

    public void translateToCore(PoseStack poseStack) {
        this.root.m_104299_(poseStack);
        this.body.m_104299_(poseStack);
        this.core.m_104299_(poseStack);
    }
}


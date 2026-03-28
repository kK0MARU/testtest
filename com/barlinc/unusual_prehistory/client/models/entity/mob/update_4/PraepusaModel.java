/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_4;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.PraepusaAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Praepusa;
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
public class PraepusaModel
extends UP2Model<Praepusa> {
    private final ModelPart root;
    private final ModelPart swim_control;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart left_eye;
    private final ModelPart right_eye;
    private final ModelPart hair;
    private final ModelPart snout;
    private final ModelPart tail;
    private final ModelPart arm_control;
    private final ModelPart left_arm;
    private final ModelPart right_arm;

    public PraepusaModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.swim_control = this.root.m_171324_("swim_control");
        this.body_main = this.swim_control.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.left_eye = this.head.m_171324_("left_eye");
        this.right_eye = this.head.m_171324_("right_eye");
        this.hair = this.head.m_171324_("hair");
        this.snout = this.head.m_171324_("snout");
        this.tail = this.body.m_171324_("tail");
        this.arm_control = this.body_main.m_171324_("arm_control");
        this.left_arm = this.arm_control.m_171324_("left_arm");
        this.right_arm = this.arm_control.m_171324_("right_arm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition swim_control = root.m_171599_("swim_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-3.5f, (float)-1.0f));
        PartDefinition body_main = swim_control.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)2.5f, (float)1.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.5f, -6.0f, -5.5f, 9.0f, 7.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(10, 40).m_171488_(-2.5f, -2.0f, -3.0f, 5.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-3.0f, (float)-5.5f));
        PartDefinition left_eye = head.m_171599_("left_eye", CubeListBuilder.m_171558_().m_171514_(0, 33).m_171488_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)1.5f, (float)-1.0f, (float)-2.0f));
        PartDefinition right_eye = head.m_171599_("right_eye", CubeListBuilder.m_171558_().m_171514_(0, 38).m_171488_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)-1.5f, (float)-1.0f, (float)-2.0f));
        PartDefinition hair = head.m_171599_("hair", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)-0.5f));
        PartDefinition snout = head.m_171599_("snout", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171488_(-1.5f, -1.0f, -2.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-3.0f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)4.0f));
        PartDefinition tail_r1 = tail.m_171599_("tail_r1", CubeListBuilder.m_171558_().m_171514_(14, 24).m_171488_(0.0f, -2.01f, 4.0f, 4.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition tail_r2 = tail.m_171599_("tail_r2", CubeListBuilder.m_171558_().m_171514_(18, 18).m_171488_(-4.0f, -2.01f, 3.0f, 4.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)-2.1f, (float)1.0f, (float)-2.1f, (float)0.0f, (float)0.7854f, (float)0.0f));
        PartDefinition tail_r3 = tail.m_171599_("tail_r3", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-4.0f, -2.01f, 4.0f, 4.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)0.7854f, (float)0.0f));
        PartDefinition arm_control = body_main.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)-1.5f));
        PartDefinition left_arm = arm_control.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171488_(0.0f, -0.5f, -2.0f, 5.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm = arm_control.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171480_().m_171488_(-5.0f, -0.5f, -2.0f, 5.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.5f, (float)0.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(@NotNull Praepusa entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (entity.m_20072_()) {
            if (entity.isRunning()) {
                this.m_267799_(PraepusaAnimations.SWIM_FAST, limbSwing, limbSwingAmount, 1.0f, 2.0f);
            } else {
                this.m_267799_(PraepusaAnimations.SWIM, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        } else if (entity.isRunning()) {
            this.m_267799_(PraepusaAnimations.RUN, limbSwing, limbSwingAmount, 1.0f, 2.0f);
        } else {
            this.m_267799_(PraepusaAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        }
        this.animateIdleSmooth(entity.idleAnimationState, PraepusaAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateIdleSmooth(entity.swimIdleAnimationState, PraepusaAnimations.SWIM_IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.sitAnimationState, PraepusaAnimations.ROLL, ageInTicks);
        this.animateSmooth(entity.slap1AnimationState, PraepusaAnimations.SLAP_BLEND1, ageInTicks);
        this.animateSmooth(entity.slap2AnimationState, PraepusaAnimations.SLAP_BLEND2, ageInTicks);
        this.animateSmooth(entity.applauseAnimationState, PraepusaAnimations.APPLAUSE, ageInTicks);
        this.animateSmooth(entity.loafAnimationState, PraepusaAnimations.LOAF_BLEND, ageInTicks);
        this.animateSmooth(entity.attackAnimationState, PraepusaAnimations.ATTACK_BLEND, ageInTicks);
        this.m_233381_(entity.mitosisAnimationState, PraepusaAnimations.MITOSIS_BLEND, ageInTicks);
        this.m_233381_(entity.bounceAnimationState, PraepusaAnimations.BOUNCE_BLEND, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(PraepusaAnimations.BABY_TRANSFORM);
        }
        if (entity.m_20072_()) {
            this.swim_control.f_104203_ = headPitch * ((float)Math.PI / 180);
        }
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


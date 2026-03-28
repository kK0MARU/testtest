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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_3.MetriorhynchusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_3.Metriorhynchus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
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
public class MetriorhynchusModel
extends UP2Model<Metriorhynchus> {
    private final ModelPart root;
    private final ModelPart swim_control;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart arm_control;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart leg_control;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public MetriorhynchusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.swim_control = this.root.m_171324_("swim_control");
        this.body_main = this.swim_control.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.tail1 = this.body.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
        this.arm_control = this.body_main.m_171324_("arm_control");
        this.left_arm = this.arm_control.m_171324_("left_arm");
        this.right_arm = this.arm_control.m_171324_("right_arm");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_leg = this.leg_control.m_171324_("left_leg");
        this.right_leg = this.leg_control.m_171324_("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition swim_control = root.m_171599_("swim_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-8.0f, (float)0.0f));
        PartDefinition body_main = swim_control.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 47).m_171488_(0.0f, -15.0f, -14.0f, 0.0f, 8.0f, 30.0f, new CubeDeformation(0.0025f)).m_171514_(0, 0).m_171488_(-7.5f, -7.0f, -16.0f, 15.0f, 15.0f, 32.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(95, 35).m_171488_(-6.5f, -7.0f, -7.0f, 13.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(50, 89).m_171488_(-4.5f, -3.0f, -9.0f, 9.0f, 3.0f, 11.0f, new CubeDeformation(0.0f)).m_171514_(32, 91).m_171488_(-4.5f, -7.0f, -1.0f, 9.0f, 4.0f, 3.0f, new CubeDeformation(0.01f)).m_171514_(84, 105).m_171488_(-1.5f, -3.0f, -22.0f, 3.0f, 3.0f, 13.0f, new CubeDeformation(0.0f)).m_171514_(65, 108).m_171488_(-1.0f, 0.0f, -21.0f, 2.0f, 2.0f, 13.0f, new CubeDeformation(0.0f)).m_171514_(120, 49).m_171488_(-1.5f, -5.0f, -22.0f, 3.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(0, 47).m_171488_(1.5f, -8.0f, -7.0f, 5.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(0, 47).m_171480_().m_171488_(-6.5f, -8.0f, -7.0f, 5.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)7.0f, (float)-16.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(0, 110).m_171488_(-4.5f, 0.0f, -9.0f, 9.0f, 2.0f, 11.0f, new CubeDeformation(0.01f)).m_171514_(110, 78).m_171488_(-1.5f, 0.0f, -22.0f, 3.0f, 2.0f, 13.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition teeth_r1 = jaw.m_171599_("teeth_r1", CubeListBuilder.m_171558_().m_171514_(116, 101).m_171480_().m_171488_(0.0f, -3.0f, -12.0f, 0.0f, 3.0f, 17.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-1.5f, (float)0.0f, (float)-10.0f, (float)0.0f, (float)0.0f, (float)-0.0873f));
        PartDefinition teeth_r2 = jaw.m_171599_("teeth_r2", CubeListBuilder.m_171558_().m_171514_(48, 85).m_171488_(-2.0f, -1.0f, 0.0f, 3.0f, 1.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)0.5f, (float)0.0f, (float)-22.0f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition teeth_r3 = jaw.m_171599_("teeth_r3", CubeListBuilder.m_171558_().m_171514_(116, 101).m_171488_(0.0f, -3.0f, -12.0f, 0.0f, 3.0f, 17.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)1.5f, (float)0.0f, (float)-10.0f, (float)0.0f, (float)0.0f, (float)0.0873f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(60, 78).m_171488_(1.5f, -5.0f, 0.0f, 0.0f, 2.0f, 25.0f, new CubeDeformation(0.0025f)).m_171514_(60, 47).m_171488_(-2.5f, -3.0f, 0.0f, 5.0f, 6.0f, 25.0f, new CubeDeformation(0.0f)).m_171514_(60, 78).m_171480_().m_171488_(-1.5f, -5.0f, 0.0f, 0.0f, 2.0f, 25.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)16.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)25.0f));
        PartDefinition tailspikes_r1 = tail2.m_171599_("tailspikes_r1", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(0.0f, 0.0f, 5.0f, 0.0f, 2.0f, 23.0f, new CubeDeformation(0.0025f)).m_171514_(0, 85).m_171488_(-1.0f, -3.0f, 6.0f, 2.0f, 3.0f, 22.0f, new CubeDeformation(0.0f)).m_171514_(36, 117).m_171488_(-1.0f, -12.0f, 0.0f, 2.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)1.0f, (float)-2.0f, (float)-0.5236f, (float)0.0f, (float)0.0f));
        PartDefinition arm_control = body_main.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)8.0f, (float)-9.0f));
        PartDefinition left_arm = arm_control.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(94, 25).m_171488_(0.0f, -1.0f, 0.0f, 13.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(52, 117).m_171488_(12.0f, -0.99f, 0.0f, 2.0f, 0.0f, 9.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)7.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm = arm_control.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(94, 25).m_171480_().m_171488_(-13.0f, -1.0f, 0.0f, 13.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(52, 117).m_171480_().m_171488_(-14.0f, -0.99f, 0.0f, 2.0f, 0.0f, 9.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-7.5f, (float)0.0f, (float)0.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)8.0f, (float)13.0f));
        PartDefinition left_leg = leg_control.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(120, 56).m_171488_(-1.0f, -0.99f, 8.0f, 7.0f, 0.0f, 3.0f, new CubeDeformation(0.0025f)).m_171514_(110, 93).m_171488_(0.0f, -1.0f, 0.0f, 6.0f, 2.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)7.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg = leg_control.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(120, 56).m_171480_().m_171488_(-6.0f, -0.99f, 8.0f, 7.0f, 0.0f, 3.0f, new CubeDeformation(0.0025f)).m_171555_(false).m_171514_(110, 93).m_171480_().m_171488_(-6.0f, -1.0f, 0.0f, 6.0f, 2.0f, 10.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-7.5f, (float)0.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Metriorhynchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        float deg = (float)Math.PI / 180;
        if (!entity.m_20072_() && !entity.isLeaping()) {
            if (entity.isRunning()) {
                this.m_267799_(MetriorhynchusAnimations.RUN, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
            this.m_267799_(MetriorhynchusAnimations.WALK, limbSwing, limbSwingAmount, 2.0f, 4.0f);
        } else if (entity.m_20089_() != UP2Poses.GRABBING.get()) {
            this.m_267799_(entity.isRunning() ? MetriorhynchusAnimations.SWIMFAST : MetriorhynchusAnimations.SWIM, limbSwing, limbSwingAmount, 1.25f, 2.5f);
        }
        if (this.f_102610_) {
            this.m_288214_(MetriorhynchusAnimations.BABY_TRANSFORM);
        }
        this.animateIdleSmooth(entity.idleAnimationState, MetriorhynchusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateIdleSmooth(entity.swimIdleAnimationState, MetriorhynchusAnimations.SWIM_IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.attack1AnimationState, MetriorhynchusAnimations.BITE_BLEND1, ageInTicks);
        this.animateSmooth(entity.attack2AnimationState, MetriorhynchusAnimations.BITE_BLEND2, ageInTicks);
        this.m_233381_(entity.grab1AnimationState, MetriorhynchusAnimations.DEATHROLL1, ageInTicks);
        this.m_233381_(entity.grab2AnimationState, MetriorhynchusAnimations.DEATHROLL2, ageInTicks);
        this.animateSmooth(entity.bellowAnimationState, MetriorhynchusAnimations.BELLOW_BLEND, ageInTicks);
        this.animateSmooth(entity.angryAnimationState, MetriorhynchusAnimations.AGGRO_BLEND, ageInTicks);
        this.animateSmooth(entity.leapAnimationState, MetriorhynchusAnimations.JUMP, ageInTicks);
        if (!entity.isLeaping() && entity.m_20089_() != UP2Poses.GRABBING.get() && !entity.m_20072_()) {
            this.head.f_104203_ += headPitch * deg / 2.0f;
            this.head.f_104204_ += netHeadYaw * deg / 2.0f;
        }
        if ((entity.isLeaping() || entity.m_20072_()) && entity.m_20089_() != UP2Poses.GRABBING.get()) {
            this.swim_control.f_104203_ = headPitch * deg;
        }
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }

    public void translateToMouth(PoseStack poseStack) {
        this.root.m_104299_(poseStack);
        this.swim_control.m_104299_(poseStack);
        this.body_main.m_104299_(poseStack);
        this.body.m_104299_(poseStack);
        this.head.m_104299_(poseStack);
    }
}


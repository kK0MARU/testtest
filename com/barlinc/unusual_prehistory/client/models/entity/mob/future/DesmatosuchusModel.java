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
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.models.entity.mob.future;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.DesmatosuchusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Desmatosuchus;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.jetbrains.annotations.NotNull;

public class DesmatosuchusModel
extends UP2Model<Desmatosuchus> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart body_main;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart left_shoulder;
    private final ModelPart right_shoulder;
    private final ModelPart tail;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;
    private final ModelPart arm_control;
    private final ModelPart leg_control;
    private final ModelPart left_arm1;
    private final ModelPart left_arm2;
    private final ModelPart right_arm1;
    private final ModelPart right_arm2;

    public DesmatosuchusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.neck = this.body.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.left_shoulder = this.body.m_171324_("left_shoulder");
        this.right_shoulder = this.body.m_171324_("right_shoulder");
        this.tail = this.body.m_171324_("tail");
        this.arm_control = this.body_main.m_171324_("arm_control");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_leg1 = this.leg_control.m_171324_("left_leg1");
        this.left_leg2 = this.left_leg1.m_171324_("left_leg2");
        this.right_leg1 = this.leg_control.m_171324_("right_leg1");
        this.right_leg2 = this.right_leg1.m_171324_("right_leg2");
        this.left_arm1 = this.arm_control.m_171324_("left_arm1");
        this.left_arm2 = this.left_arm1.m_171324_("left_arm2");
        this.right_arm1 = this.arm_control.m_171324_("right_arm1");
        this.right_arm2 = this.right_arm1.m_171324_("right_arm2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-13.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-7.0f, -5.5f, -12.0f, 14.0f, 11.0f, 24.0f, new CubeDeformation(0.01f)).m_171514_(40, 87).m_171488_(-5.0f, -9.5f, -5.6215f, 6.0f, 4.0f, 0.0f, new CubeDeformation(0.01f)).m_171514_(40, 87).m_171488_(0.0f, -9.5f, 4.3785f, 6.0f, 4.0f, 0.0f, new CubeDeformation(0.01f)).m_171514_(16, 85).m_171488_(-2.0f, -9.5f, -8.6215f, 0.0f, 4.0f, 6.0f, new CubeDeformation(0.01f)).m_171514_(16, 85).m_171488_(3.0f, -9.5f, 1.3785f, 0.0f, 4.0f, 6.0f, new CubeDeformation(0.01f)), PartPose.m_171423_((float)0.0f, (float)-0.5f, (float)0.0f, (float)0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition scutes_r1 = body.m_171599_("scutes_r1", CubeListBuilder.m_171558_().m_171514_(66, 64).m_171480_().m_171488_(-3.0f, 0.0f, -10.0f, 4.0f, 0.0f, 20.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-7.0f, (float)-5.5f, (float)3.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition scutes_r2 = body.m_171599_("scutes_r2", CubeListBuilder.m_171558_().m_171514_(66, 64).m_171488_(-1.0f, 0.0f, -10.0f, 4.0f, 0.0f, 20.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)7.0f, (float)-5.5f, (float)3.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition neck = body.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(0, 68).m_171488_(-4.0f, -3.0f, -8.0f, 8.0f, 7.0f, 10.0f, new CubeDeformation(0.01f)), PartPose.m_171423_((float)0.0f, (float)-1.5f, (float)-12.0f, (float)-0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition Spike_r1 = neck.m_171599_("Spike_r1", CubeListBuilder.m_171558_().m_171514_(76, 0).m_171480_().m_171488_(-3.0f, 0.0f, -4.5f, 4.0f, 0.0f, 9.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-4.0f, (float)-3.0f, (float)-4.5f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition Spike_r2 = neck.m_171599_("Spike_r2", CubeListBuilder.m_171558_().m_171514_(76, 0).m_171488_(-1.0f, 0.0f, -4.5f, 4.0f, 0.0f, 9.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)4.0f, (float)-3.0f, (float)-4.5f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(76, 21).m_171488_(-3.0f, -2.0f, -5.0f, 6.0f, 3.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(56, 68).m_171488_(-2.0f, -3.0f, -10.0f, 4.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).m_171514_(72, 84).m_171488_(-2.0f, -2.0f, -10.0f, 4.0f, 3.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-1.0f, (float)-8.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(76, 29).m_171488_(-2.5f, 0.0f, -5.0f, 5.0f, 1.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(0, 85).m_171488_(-1.5f, 0.0f, -10.0f, 3.0f, 1.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(56, 70).m_171488_(-1.5f, 1.0f, -10.0f, 3.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)0.0f));
        PartDefinition left_shoulder = body.m_171599_("left_shoulder", CubeListBuilder.m_171558_().m_171514_(28, 87).m_171488_(7.0f, 0.0f, 2.0f, 2.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(76, 9).m_171488_(-1.0f, 0.0f, -2.0f, 10.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)5.0f, (float)-5.5f, (float)-10.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_spike = body.m_171599_("right_shoulder", CubeListBuilder.m_171558_().m_171514_(28, 87).m_171480_().m_171488_(-9.0f, 0.0f, 2.0f, 2.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(76, 9).m_171480_().m_171488_(-9.0f, 0.0f, -2.0f, 10.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-5.0f, (float)-5.5f, (float)-10.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(0, 35).m_171488_(-2.5f, -2.0f, 0.0f, 5.0f, 5.0f, 28.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)-3.5f, (float)12.0f, (float)-0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition scutes_r3 = tail.m_171599_("scutes_r3", CubeListBuilder.m_171558_().m_171514_(66, 35).m_171480_().m_171488_(-2.0f, 0.0f, -14.5f, 3.0f, 0.0f, 29.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-2.5f, (float)-2.0f, (float)14.5f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition scutes_r4 = tail.m_171599_("scutes_r4", CubeListBuilder.m_171558_().m_171514_(66, 35).m_171488_(-1.0f, 0.0f, -14.5f, 3.0f, 0.0f, 29.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)2.5f, (float)-2.0f, (float)14.5f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition arm_control = body_main.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)4.25f, (float)-8.0f));
        PartDefinition left_arm1 = arm_control.m_171599_("left_arm1", CubeListBuilder.m_171558_().m_171514_(56, 84).m_171488_(-2.0f, -2.25f, -2.0f, 4.0f, 11.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)7.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm2 = left_arm1.m_171599_("left_arm2", CubeListBuilder.m_171558_().m_171514_(76, 15).m_171488_(-3.5f, -0.3f, -4.0f, 7.0f, 0.0f, 6.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)9.05f, (float)-1.0f));
        PartDefinition right_arm1 = arm_control.m_171599_("right_arm1", CubeListBuilder.m_171558_().m_171514_(56, 84).m_171480_().m_171488_(-2.0f, -1.25f, -2.0f, 4.0f, 11.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-7.0f, (float)-1.0f, (float)0.0f));
        PartDefinition right_arm2 = right_arm1.m_171599_("right_arm2", CubeListBuilder.m_171558_().m_171514_(76, 15).m_171480_().m_171488_(-3.5f, 0.7f, -4.0f, 7.0f, 0.0f, 6.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)9.05f, (float)-1.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)1.5f, (float)7.5f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(36, 68).m_171488_(-2.5f, -2.5f, -2.5f, 5.0f, 14.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)7.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(76, 15).m_171488_(-3.5f, 0.0f, -4.0f, 7.0f, 0.0f, 6.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)11.5f, (float)-1.5f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(36, 68).m_171480_().m_171488_(-2.5f, -2.5f, -2.5f, 5.0f, 14.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-7.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(76, 15).m_171480_().m_171488_(-3.5f, 0.0f, -4.0f, 7.0f, 0.0f, 6.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)11.5f, (float)-1.5f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Desmatosuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20069_() && !entity.isEepy()) {
            if (entity.isRunning()) {
                this.m_267799_(DesmatosuchusAnimations.RUN, limbSwing, limbSwingAmount, 1.0f, 2.0f);
            } else {
                this.m_267799_(DesmatosuchusAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, DesmatosuchusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.swimAnimationState, DesmatosuchusAnimations.SWIM, ageInTicks);
        this.animateSmooth(entity.grazeAnimationState, DesmatosuchusAnimations.IDLE_GRAZE_BLEND, ageInTicks);
        this.animateSmooth(entity.rollAnimationState, DesmatosuchusAnimations.ROLL, ageInTicks);
        this.animateSmooth(entity.shakeAnimationState, DesmatosuchusAnimations.IDLE_SHAKE_BLEND, ageInTicks);
        this.animateSmooth(entity.sniff1AnimationState, DesmatosuchusAnimations.IDLE_SNIFF_BLEND1, ageInTicks);
        this.animateSmooth(entity.sniff2AnimationState, DesmatosuchusAnimations.IDLE_SNIFF_BLEND2, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, DesmatosuchusAnimations.BURROW, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(DesmatosuchusAnimations.BABY_TRANSFORM);
        }
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


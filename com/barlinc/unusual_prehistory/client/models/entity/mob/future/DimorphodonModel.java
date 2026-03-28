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
package com.barlinc.unusual_prehistory.client.models.entity.mob.future;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.DimorphodonAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Dimorphodon;
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
public class DimorphodonModel
extends UP2Model<Dimorphodon> {
    private final ModelPart root;
    private final ModelPart flight_control;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart wing_control;
    private final ModelPart left_wing1;
    private final ModelPart left_membrane;
    private final ModelPart left_wing2;
    private final ModelPart left_wing3;
    private final ModelPart right_wing1;
    private final ModelPart right_membrane;
    private final ModelPart right_wing2;
    private final ModelPart right_wing3;
    private final ModelPart leg_control;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;

    public DimorphodonModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.flight_control = this.root.m_171324_("flight_control");
        this.body_main = this.flight_control.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.tail1 = this.body.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
        this.wing_control = this.body_main.m_171324_("wing_control");
        this.left_wing1 = this.wing_control.m_171324_("left_wing1");
        this.left_membrane = this.left_wing1.m_171324_("left_membrane");
        this.left_wing2 = this.left_wing1.m_171324_("left_wing2");
        this.left_wing3 = this.left_wing1.m_171324_("left_wing3");
        this.right_wing1 = this.wing_control.m_171324_("right_wing1");
        this.right_membrane = this.right_wing1.m_171324_("right_membrane");
        this.right_wing2 = this.right_wing1.m_171324_("right_wing2");
        this.right_wing3 = this.right_wing1.m_171324_("right_wing3");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_leg1 = this.leg_control.m_171324_("left_leg1");
        this.left_leg2 = this.left_leg1.m_171324_("left_leg2");
        this.right_leg1 = this.leg_control.m_171324_("right_leg1");
        this.right_leg2 = this.right_leg1.m_171324_("right_leg2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition flight_control = root.m_171599_("flight_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-9.0f, (float)0.0f));
        PartDefinition body_main = flight_control.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)2.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(32, 39).m_171488_(-3.5f, -7.0f, -6.0f, 7.0f, 7.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(48, 54).m_171488_(-2.5f, -6.0f, -2.0f, 5.0f, 7.0f, 5.0f, new CubeDeformation(0.01f)).m_171514_(0, 41).m_171488_(-2.5f, -6.0f, -10.0f, 5.0f, 5.0f, 8.0f, new CubeDeformation(0.01f)).m_171514_(46, 11).m_171488_(-2.5f, -1.0f, -10.0f, 5.0f, 1.0f, 8.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)-7.0f, (float)-6.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(0, 54).m_171488_(-2.0f, 0.0f, -8.0f, 4.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(24, 54).m_171488_(-2.0f, -1.0f, -8.0f, 4.0f, 1.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-1.0f, (float)-2.0f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(32, 22).m_171488_(0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 16.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)-6.5f, (float)2.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(0, 22).m_171488_(0.0f, -1.5f, 0.0f, 0.0f, 3.0f, 16.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)16.0f));
        PartDefinition wing_control = body_main.m_171599_("wing_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-3.0f, (float)-4.0f));
        PartDefinition left_wing1 = wing_control.m_171599_("left_wing1", CubeListBuilder.m_171558_(), PartPose.m_171423_((float)3.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.8378f));
        PartDefinition left_membrane = left_wing1.m_171599_("left_membrane", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171488_(0.0f, 0.0f, 0.0f, 12.0f, 0.0f, 11.0f, new CubeDeformation(0.005f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-1.0f));
        PartDefinition left_wing2 = left_wing1.m_171599_("left_wing2", CubeListBuilder.m_171558_().m_171514_(46, 20).m_171488_(-1.5f, 0.0f, -2.0f, 3.0f, 0.0f, 2.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)12.0f, (float)0.0f, (float)-1.0f, (float)0.0f, (float)0.0f, (float)-0.8552f));
        PartDefinition left_wing3 = left_wing1.m_171599_("left_wing3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0f, 0.0f, -1.0f, 21.0f, 0.0f, 11.0f, new CubeDeformation(0.005f)), PartPose.m_171423_((float)12.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-2.0944f));
        PartDefinition right_wing1 = wing_control.m_171599_("right_wing1", CubeListBuilder.m_171558_(), PartPose.m_171423_((float)-3.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.8378f));
        PartDefinition right_membrane = right_wing1.m_171599_("right_membrane", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171480_().m_171488_(-12.0f, 0.0f, 0.0f, 12.0f, 0.0f, 11.0f, new CubeDeformation(0.005f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-1.0f));
        PartDefinition right_wing2 = right_wing1.m_171599_("right_wing2", CubeListBuilder.m_171558_().m_171514_(46, 20).m_171480_().m_171488_(-1.5f, 0.0f, -2.0f, 3.0f, 0.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-12.0f, (float)0.0f, (float)-1.0f, (float)0.0f, (float)0.0f, (float)0.8552f));
        PartDefinition right_wing3 = right_wing1.m_171599_("right_wing3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-21.0f, 0.0f, -1.0f, 21.0f, 0.0f, 11.0f, new CubeDeformation(0.005f)).m_171555_(false), PartPose.m_171423_((float)-12.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)2.0944f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(26, 41).m_171488_(-0.5f, 0.0f, 0.0f, 1.0f, 6.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)3.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(62, 39).m_171488_(-2.5f, -0.02f, -4.0f, 5.0f, 1.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)6.0f, (float)0.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(26, 41).m_171480_().m_171488_(-0.5f, 0.0f, 0.0f, 1.0f, 6.0f, 0.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-3.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(62, 39).m_171480_().m_171488_(-2.5f, -0.02f, -4.0f, 5.0f, 1.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)6.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(Dimorphodon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_29443_()) {
            if (entity.m_20069_()) {
                this.m_267799_(DimorphodonAnimations.SWIM, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            } else if (entity.isRunning()) {
                this.m_267799_(DimorphodonAnimations.RUN, limbSwing, limbSwingAmount, 1.0f, 2.0f);
            } else {
                this.m_267799_(DimorphodonAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, DimorphodonAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateIdleSmooth(entity.hoverAnimationState, DimorphodonAnimations.HOVER, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.flyAnimationState, DimorphodonAnimations.FLY, ageInTicks);
        this.animateSmooth(entity.flyFastAnimationState, DimorphodonAnimations.FLY_FAST, ageInTicks);
        this.animateSmooth(entity.danceAnimationState, DimorphodonAnimations.DANCE, ageInTicks);
        this.animateSmooth(entity.grabAnimationState, DimorphodonAnimations.GRAB, ageInTicks);
        this.animateSmooth(entity.nip1AnimationState, DimorphodonAnimations.NIP_BLEND1, ageInTicks);
        this.animateSmooth(entity.nip2AnimationState, DimorphodonAnimations.NIP_BLEND2, ageInTicks);
        this.animateSmooth(entity.tailChaseAnimationState, DimorphodonAnimations.TAILCHASE, ageInTicks);
        float deg = (float)Math.PI / 180;
        this.head.f_104203_ += headPitch * deg / 2.0f;
        this.head.f_104204_ += netHeadYaw * deg / 2.0f;
        float partialTicks = ageInTicks - (float)entity.f_19797_;
        float flyProgress = entity.getFlyProgress(partialTicks);
        float rollAmount = entity.getFlightRoll(partialTicks) / 57.295776f * flyProgress;
        float flightPitchAmount = entity.getFlightPitch(partialTicks) / 57.295776f * flyProgress;
        this.flight_control.f_104203_ += flightPitchAmount / 2.0f;
        this.flight_control.f_104205_ += rollAmount / 2.0f;
        if (this.f_102610_) {
            this.m_288214_(DimorphodonAnimations.BABY_TRANSFORM);
        }
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }

    public void translateToFeet(PoseStack poseStack) {
        this.root.m_104299_(poseStack);
        this.leg_control.m_104299_(poseStack);
    }
}


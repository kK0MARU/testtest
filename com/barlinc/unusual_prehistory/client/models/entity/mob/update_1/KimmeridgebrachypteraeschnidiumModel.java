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
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_1;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.KimmeridgebrachypteraeschnidiumAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Kimmeridgebrachypteraeschnidium;
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
public class KimmeridgebrachypteraeschnidiumModel
extends UP2Model<Kimmeridgebrachypteraeschnidium> {
    public final ModelPart root;
    public final ModelPart body_main;
    public final ModelPart body;
    private final ModelPart tail;
    private final ModelPart head;
    private final ModelPart left_front_wing;
    private final ModelPart right_front_wing;
    private final ModelPart left_back_wing;
    private final ModelPart right_back_wing;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart leg_control;
    private final ModelPart left_front_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_back_leg;
    private final ModelPart right_back_leg;

    public KimmeridgebrachypteraeschnidiumModel(ModelPart root) {
        super(1.0f, 0.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.tail = this.body.m_171324_("tail");
        this.head = this.body.m_171324_("head");
        this.left_front_wing = this.body.m_171324_("left_front_wing");
        this.right_front_wing = this.body.m_171324_("right_front_wing");
        this.left_back_wing = this.body.m_171324_("left_back_wing");
        this.right_back_wing = this.body.m_171324_("right_back_wing");
        this.left_arm = this.body.m_171324_("left_arm");
        this.right_arm = this.body.m_171324_("right_arm");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_front_leg = this.leg_control.m_171324_("left_front_leg");
        this.right_front_leg = this.leg_control.m_171324_("right_front_leg");
        this.left_back_leg = this.leg_control.m_171324_("left_back_leg");
        this.right_back_leg = this.leg_control.m_171324_("right_back_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-5.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(14, 16).m_171488_(-2.0f, -2.0f, -1.5f, 4.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-1.0f, (float)1.5f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(12, 22).m_171488_(-3.0f, -1.0f, -2.0f, 6.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-1.5f));
        PartDefinition left_front_wing = body.m_171599_("left_front_wing", CubeListBuilder.m_171558_().m_171514_(-1, 8).m_171480_().m_171488_(0.0f, 0.0f, -7.0f, 10.0f, 0.0f, 8.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)1.0f, (float)-2.0f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition right_front_wing = body.m_171599_("right_front_wing", CubeListBuilder.m_171558_().m_171514_(-1, 8).m_171488_(-10.0f, 0.0f, -7.0f, 10.0f, 0.0f, 8.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)-1.0f, (float)-2.0f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)0.1745f));
        PartDefinition left_back_wing = body.m_171599_("left_back_wing", CubeListBuilder.m_171558_().m_171514_(-1, 0).m_171480_().m_171488_(0.0f, 0.0f, -1.0f, 10.0f, 0.0f, 8.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)0.0f, (float)-2.0f, (float)1.5f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition right_back_wing = body.m_171599_("right_back_wing", CubeListBuilder.m_171558_().m_171514_(-1, 0).m_171488_(-10.0f, 0.0f, -1.0f, 10.0f, 0.0f, 8.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)0.0f, (float)-2.0f, (float)1.5f, (float)0.0f, (float)0.0f, (float)0.1745f));
        PartDefinition left_arm = body.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(0, 7).m_171480_().m_171488_(0.0f, 0.0f, -3.0f, 0.0f, 5.0f, 3.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)1.0f, (float)1.0f, (float)-0.5f, (float)-0.48f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm = body.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 7).m_171488_(0.0f, 0.0f, -3.0f, 0.0f, 5.0f, 3.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)-1.0f, (float)1.0f, (float)-0.5f, (float)-0.48f, (float)0.0f, (float)0.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)1.0f, (float)1.0f, (float)-0.5f));
        PartDefinition left_front_leg = leg_control.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(2, -2).m_171480_().m_171488_(0.0f, 0.0f, -2.0f, 0.0f, 5.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7418f));
        PartDefinition right_front_leg = leg_control.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(2, -2).m_171488_(0.0f, 0.0f, -2.0f, 0.0f, 5.0f, 2.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)-2.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7418f));
        PartDefinition left_back_leg = leg_control.m_171599_("left_back_leg", CubeListBuilder.m_171558_().m_171514_(0, 3).m_171480_().m_171488_(0.0f, 0.0f, 0.0f, 0.0f, 5.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7418f));
        PartDefinition right_back_leg = leg_control.m_171599_("right_back_leg", CubeListBuilder.m_171558_().m_171514_(0, 3).m_171488_(0.0f, 0.0f, 0.0f, 0.0f, 5.0f, 2.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)-2.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7418f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(Kimmeridgebrachypteraeschnidium entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.animateSmooth(entity.flyAnimationState, KimmeridgebrachypteraeschnidiumAnimations.FLY, ageInTicks);
        this.animateSmooth(entity.flyAnimationState, KimmeridgebrachypteraeschnidiumAnimations.FLY_OVERLAY, ageInTicks);
        this.animateSmooth(entity.idleAnimationState, KimmeridgebrachypteraeschnidiumAnimations.IDLE1, ageInTicks);
        this.animateSmooth(entity.preenAnimationState, KimmeridgebrachypteraeschnidiumAnimations.PREEN, ageInTicks);
        float partialTicks = ageInTicks - (float)entity.f_19797_;
        float flyProgress = entity.getFlyProgress(partialTicks);
        float rollAmount = entity.getFlightRoll(partialTicks) / 57.295776f * flyProgress;
        float flightPitchAmount = entity.getFlightPitch(partialTicks) / 57.295776f * flyProgress;
        this.body_main.f_104203_ += flightPitchAmount;
        this.body_main.f_104205_ += rollAmount / 2.0f;
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


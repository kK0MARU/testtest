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
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4fc
 *  org.joml.Vector4f
 */
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_4;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.HibbertopterusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Hibbertopterus;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4fc;
import org.joml.Vector4f;

@OnlyIn(value=Dist.CLIENT)
public class HibbertopterusModel
extends UP2Model<Hibbertopterus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart left_arm1;
    private final ModelPart left_arm2;
    private final ModelPart right_arm1;
    private final ModelPart right_arm2;
    private final ModelPart thorax;
    private final ModelPart tail;
    private final ModelPart leg_control;
    private final ModelPart right_legs;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;
    private final ModelPart right_leg3;
    private final ModelPart left_legs;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart left_leg3;

    public HibbertopterusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.left_arm1 = this.body.m_171324_("left_arm1");
        this.left_arm2 = this.left_arm1.m_171324_("left_arm2");
        this.right_arm1 = this.body.m_171324_("right_arm1");
        this.right_arm2 = this.right_arm1.m_171324_("right_arm2");
        this.thorax = this.body.m_171324_("thorax");
        this.tail = this.thorax.m_171324_("tail");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.right_legs = this.leg_control.m_171324_("right_legs");
        this.right_leg1 = this.right_legs.m_171324_("right_leg1");
        this.right_leg2 = this.right_legs.m_171324_("right_leg2");
        this.right_leg3 = this.right_legs.m_171324_("right_leg3");
        this.left_legs = this.leg_control.m_171324_("left_legs");
        this.left_leg1 = this.left_legs.m_171324_("left_leg1");
        this.left_leg2 = this.left_legs.m_171324_("left_leg2");
        this.left_leg3 = this.left_legs.m_171324_("left_leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-19.0f, (float)-0.5f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-25.0f, -9.5f, -19.5f, 50.0f, 21.0f, 39.0f, new CubeDeformation(0.0f)).m_171514_(14, 98).m_171488_(1.0f, -10.5f, -4.5f, 2.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(14, 98).m_171480_().m_171488_(-3.0f, -10.5f, -4.5f, 2.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm1 = body.m_171599_("left_arm1", CubeListBuilder.m_171558_().m_171514_(42, 97).m_171488_(-1.5f, -1.0f, -3.0f, 3.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.5f, (float)11.5f, (float)-19.5f));
        PartDefinition left_arm2 = left_arm1.m_171599_("left_arm2", CubeListBuilder.m_171558_().m_171514_(26, 81).m_171488_(-1.0f, -2.0f, -8.0f, 6.0f, 4.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(0, 98).m_171488_(1.0f, 0.0f, -11.0f, 4.0f, 0.0f, 3.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.5f, (float)0.0f, (float)-2.0f));
        PartDefinition right_arm1 = body.m_171599_("right_arm1", CubeListBuilder.m_171558_().m_171514_(42, 97).m_171480_().m_171488_(-1.5f, -1.0f, -3.0f, 3.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.5f, (float)11.5f, (float)-19.5f));
        PartDefinition right_arm2 = right_arm1.m_171599_("right_arm2", CubeListBuilder.m_171558_().m_171514_(26, 81).m_171480_().m_171488_(-5.0f, -2.0f, -8.0f, 6.0f, 4.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 98).m_171480_().m_171488_(-5.0f, 0.0f, -11.0f, 4.0f, 0.0f, 3.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-0.5f, (float)0.0f, (float)-2.0f));
        PartDefinition thorax = body.m_171599_("thorax", CubeListBuilder.m_171558_().m_171514_(0, 60).m_171488_(-7.5f, -4.5f, 0.0f, 15.0f, 9.0f, 12.0f, new CubeDeformation(0.0f)).m_171514_(54, 60).m_171488_(-8.5f, -4.51f, 0.0f, 17.0f, 0.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)5.0f, (float)19.5f));
        PartDefinition tail = thorax.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(54, 72).m_171488_(-1.5f, -1.5f, 0.0f, 3.0f, 3.0f, 15.0f, new CubeDeformation(0.0f)).m_171514_(74, 81).m_171488_(-2.5f, -1.51f, 1.0f, 5.0f, 0.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)12.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)11.5f, (float)-8.5f));
        PartDefinition right_legs = leg_control.m_171599_("right_legs", CubeListBuilder.m_171558_(), PartPose.m_171423_((float)-22.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1745f));
        PartDefinition right_leg1 = right_legs.m_171599_("right_leg1", CubeListBuilder.m_171558_(), PartPose.m_171423_((float)0.0f, (float)-1.0f, (float)-8.0f, (float)-0.0873f, (float)-0.4363f, (float)0.0f));
        PartDefinition arm_r1 = right_leg1.m_171599_("arm_r1", CubeListBuilder.m_171558_().m_171514_(56, 97).m_171480_().m_171488_(-4.1812f, -0.7498f, -7.8442f, 3.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 81).m_171480_().m_171488_(-14.1812f, 2.2502f, -9.3442f, 7.0f, 11.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(76, 90).m_171480_().m_171488_(-15.1812f, 1.2502f, -5.3442f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(90, 72).m_171480_().m_171488_(-15.1812f, 1.2502f, -7.3442f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(26, 93).m_171480_().m_171488_(-14.1812f, 13.2502f, -9.3442f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(54, 90).m_171480_().m_171488_(-14.1812f, 15.2502f, -9.3442f, 5.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(92, 95).m_171480_().m_171488_(-10.1812f, 14.2502f, -9.3442f, 1.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(92, 89).m_171480_().m_171488_(-7.1812f, 4.2502f, -7.8442f, 6.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)2.9583f, (float)0.0f, (float)6.3442f, (float)0.0f, (float)0.0f, (float)0.4363f));
        PartDefinition right_leg2 = right_legs.m_171599_("right_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-1.0f, (float)0.0f));
        PartDefinition arm_r2 = right_leg2.m_171599_("arm_r2", CubeListBuilder.m_171558_().m_171514_(56, 97).m_171480_().m_171488_(-1.5f, -2.0f, -1.5f, 3.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 81).m_171480_().m_171488_(-11.5f, 1.0f, -3.0f, 7.0f, 11.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(76, 90).m_171480_().m_171488_(-12.5f, 0.0f, 1.0f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(90, 72).m_171480_().m_171488_(-12.5f, 0.0f, -1.0f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(26, 93).m_171480_().m_171488_(-11.5f, 12.0f, -3.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(54, 90).m_171480_().m_171488_(-11.5f, 14.0f, -3.0f, 5.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(92, 95).m_171480_().m_171488_(-7.5f, 13.0f, -3.0f, 1.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(92, 89).m_171480_().m_171488_(-4.5f, 3.0f, -1.5f, 6.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.4363f));
        PartDefinition right_leg3 = right_legs.m_171599_("right_leg3", CubeListBuilder.m_171558_(), PartPose.m_171423_((float)0.0f, (float)-1.0f, (float)8.0f, (float)0.0873f, (float)0.4363f, (float)0.0f));
        PartDefinition arm_r3 = right_leg3.m_171599_("arm_r3", CubeListBuilder.m_171558_().m_171514_(56, 97).m_171480_().m_171488_(1.1812f, -3.2502f, -7.8441f, 3.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 81).m_171480_().m_171488_(-8.8188f, -0.2502f, -9.3441f, 7.0f, 11.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(76, 90).m_171480_().m_171488_(-9.8188f, -1.2502f, -5.3441f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(90, 72).m_171480_().m_171488_(-9.8188f, -1.2502f, -7.3441f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(26, 93).m_171480_().m_171488_(-8.8188f, 10.7498f, -9.3441f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(54, 90).m_171480_().m_171488_(-8.8188f, 12.7498f, -9.3441f, 5.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(92, 95).m_171480_().m_171488_(-4.8188f, 11.7498f, -9.3441f, 1.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(92, 89).m_171480_().m_171488_(-1.8188f, 1.7498f, -7.8441f, 6.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-2.9583f, (float)0.0f, (float)6.3441f, (float)0.0f, (float)0.0f, (float)0.4363f));
        PartDefinition left_legs = leg_control.m_171599_("left_legs", CubeListBuilder.m_171558_(), PartPose.m_171423_((float)22.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition left_leg1 = left_legs.m_171599_("left_leg1", CubeListBuilder.m_171558_(), PartPose.m_171423_((float)0.0f, (float)-1.0f, (float)-8.0f, (float)-0.0873f, (float)0.4363f, (float)0.0f));
        PartDefinition arm_r4 = left_leg1.m_171599_("arm_r4", CubeListBuilder.m_171558_().m_171514_(56, 97).m_171488_(1.1812f, -0.7498f, -7.8442f, 3.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(0, 81).m_171488_(7.1812f, 2.2502f, -9.3442f, 7.0f, 11.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(76, 90).m_171488_(7.1812f, 1.2502f, -5.3442f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171514_(90, 72).m_171488_(7.1812f, 1.2502f, -7.3442f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171514_(26, 93).m_171488_(12.1812f, 13.2502f, -9.3442f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(54, 90).m_171488_(9.1812f, 15.2502f, -9.3442f, 5.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(92, 95).m_171488_(9.1812f, 14.2502f, -9.3442f, 1.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(92, 89).m_171488_(1.1812f, 4.2502f, -7.8442f, 6.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)-2.9583f, (float)0.0f, (float)6.3442f, (float)0.0f, (float)0.0f, (float)-0.4363f));
        PartDefinition left_leg2 = left_legs.m_171599_("left_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-1.0f, (float)0.0f));
        PartDefinition arm_r5 = left_leg2.m_171599_("arm_r5", CubeListBuilder.m_171558_().m_171514_(56, 97).m_171488_(-1.5f, -2.0f, -1.5f, 3.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(0, 81).m_171488_(4.5f, 1.0f, -3.0f, 7.0f, 11.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(76, 90).m_171488_(4.5f, 0.0f, 1.0f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171514_(90, 72).m_171488_(4.5f, 0.0f, -1.0f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171514_(26, 93).m_171488_(9.5f, 12.0f, -3.0f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(54, 90).m_171488_(6.5f, 14.0f, -3.0f, 5.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(92, 95).m_171488_(6.5f, 13.0f, -3.0f, 1.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(92, 89).m_171488_(-1.5f, 3.0f, -1.5f, 6.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.4363f));
        PartDefinition left_leg3 = left_legs.m_171599_("left_leg3", CubeListBuilder.m_171558_(), PartPose.m_171423_((float)0.0f, (float)-1.0f, (float)8.0f, (float)0.0873f, (float)-0.4363f, (float)0.0f));
        PartDefinition arm_r6 = left_leg3.m_171599_("arm_r6", CubeListBuilder.m_171558_().m_171514_(56, 97).m_171488_(-4.1812f, -3.2502f, -7.8441f, 3.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(0, 81).m_171488_(1.8188f, -0.2502f, -9.3441f, 7.0f, 11.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(76, 90).m_171488_(1.8188f, -1.2502f, -5.3441f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171514_(90, 72).m_171488_(1.8188f, -1.2502f, -7.3441f, 8.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)).m_171514_(26, 93).m_171488_(6.8188f, 10.7498f, -9.3441f, 2.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(54, 90).m_171488_(3.8188f, 12.7498f, -9.3441f, 5.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(92, 95).m_171488_(3.8188f, 11.7498f, -9.3441f, 1.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(92, 89).m_171488_(-4.1812f, 1.7498f, -7.8441f, 6.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)2.9583f, (float)0.0f, (float)6.3441f, (float)0.0f, (float)0.0f, (float)-0.4363f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(@NotNull Hibbertopterus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.m_267799_(HibbertopterusAnimations.WALK, limbSwing, limbSwingAmount, 2.0f, 4.0f);
        this.animateIdleSmooth(entity.idleAnimationState, HibbertopterusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateIdleSmooth(entity.idleAnimationState, HibbertopterusAnimations.IDLE_OVERLAY_BLEND, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.plowAnimationState, HibbertopterusAnimations.DIG_BLEND, ageInTicks);
        this.animateSmooth(entity.danceAnimationState, HibbertopterusAnimations.DANCE, ageInTicks);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }

    public Vec3 getRiderPosition(Vec3 offset) {
        PoseStack poseStack = new PoseStack();
        poseStack.m_85836_();
        Vector4f armOffsetVec = new Vector4f((float)offset.f_82479_, (float)offset.f_82480_, (float)offset.f_82481_, 1.0f);
        armOffsetVec.mul((Matrix4fc)poseStack.m_85850_().m_252922_());
        Vec3 vec3 = new Vec3((double)armOffsetVec.x(), (double)armOffsetVec.y(), (double)armOffsetVec.z());
        poseStack.m_85849_();
        return vec3;
    }

    public void positionRider(PoseStack poseStack) {
        this.root.m_104299_(poseStack);
        this.body_main.m_104299_(poseStack);
        this.body.m_104299_(poseStack);
    }
}


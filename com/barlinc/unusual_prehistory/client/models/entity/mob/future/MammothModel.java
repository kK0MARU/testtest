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
package com.barlinc.unusual_prehistory.client.models.entity.mob.future;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.MammothAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Mammoth;
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
public class MammothModel
extends UP2Model<Mammoth> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart wooly_fur;
    private final ModelPart head;
    private final ModelPart wooly_head;
    private final ModelPart left_ear;
    private final ModelPart right_ear;
    private final ModelPart trunk1;
    private final ModelPart trunk2;
    private final ModelPart trunk3;
    private final ModelPart jaw;
    private final ModelPart left_tusk;
    private final ModelPart left_tusk_wooly;
    private final ModelPart right_tusk;
    private final ModelPart right_tusk_wooly;
    private final ModelPart tail;
    private final ModelPart arm_control;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart leg_control;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public MammothModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.wooly_fur = this.body.m_171324_("wooly_fur");
        this.head = this.body.m_171324_("head");
        this.wooly_head = this.head.m_171324_("wooly_head");
        this.left_ear = this.head.m_171324_("left_ear");
        this.right_ear = this.head.m_171324_("right_ear");
        this.trunk1 = this.head.m_171324_("trunk1");
        this.trunk2 = this.trunk1.m_171324_("trunk2");
        this.trunk3 = this.trunk2.m_171324_("trunk3");
        this.jaw = this.head.m_171324_("jaw");
        this.left_tusk = this.head.m_171324_("left_tusk");
        this.left_tusk_wooly = this.left_tusk.m_171324_("left_tusk_wooly");
        this.right_tusk = this.head.m_171324_("right_tusk");
        this.right_tusk_wooly = this.right_tusk.m_171324_("right_tusk_wooly");
        this.tail = this.body.m_171324_("tail");
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
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-37.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 134).m_171488_(-19.0f, -43.0f, -32.0f, 38.0f, 47.0f, 63.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition wooly_fur = body.m_171599_("wooly_fur", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-26.5f, 1.0f, -32.0f, 53.0f, 71.0f, 63.0f, new CubeDeformation(1.0f)).m_171514_(202, 134).m_171488_(-26.5f, 64.0f, -33.0f, 53.0f, 0.0f, 65.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-44.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(202, 241).m_171488_(-10.5f, -18.0f, -19.0f, 21.0f, 29.0f, 22.0f, new CubeDeformation(0.0f)).m_171514_(288, 291).m_171488_(-10.5f, 11.0f, -19.0f, 21.0f, 5.0f, 19.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)-29.0f, (float)-32.0f));
        PartDefinition wooly_head = head.m_171599_("wooly_head", CubeListBuilder.m_171558_().m_171514_(232, 0).m_171488_(-13.5f, 1.5f, -15.5f, 27.0f, 3.0f, 31.0f, new CubeDeformation(0.0f)).m_171514_(0, 334).m_171480_().m_171488_(-13.5f, -7.5f, -15.5f, 27.0f, 9.0f, 31.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)-14.5f, (float)-7.5f));
        PartDefinition left_ear = head.m_171599_("left_ear", CubeListBuilder.m_171558_().m_171514_(160, 268).m_171488_(-1.0f, -6.0f, 0.0f, 11.0f, 16.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)11.5f, (float)-7.0f, (float)-5.0f));
        PartDefinition right_ear = head.m_171599_("right_ear", CubeListBuilder.m_171558_().m_171514_(160, 268).m_171480_().m_171488_(-10.0f, -6.0f, 0.0f, 11.0f, 16.0f, 0.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-11.5f, (float)-7.0f, (float)-5.0f));
        PartDefinition trunk1 = head.m_171599_("trunk1", CubeListBuilder.m_171558_().m_171514_(310, 199).m_171488_(-5.5f, -5.5f, -11.0f, 11.0f, 30.0f, 11.0f, new CubeDeformation(0.02f)), PartPose.m_171419_((float)0.0f, (float)1.5f, (float)-19.0f));
        PartDefinition trunk2 = trunk1.m_171599_("trunk2", CubeListBuilder.m_171558_().m_171514_(308, 315).m_171488_(-5.5f, 0.0f, -5.5f, 11.0f, 22.0f, 11.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)24.5f, (float)-5.5f));
        PartDefinition trunk3 = trunk2.m_171599_("trunk3", CubeListBuilder.m_171558_().m_171514_(194, 318).m_171488_(-5.5f, -3.5f, -0.5f, 11.0f, 7.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)18.5f, (float)0.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(324, 56).m_171488_(-4.5f, 0.0f, -11.0f, 9.0f, 4.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)11.0f, (float)-8.0f));
        PartDefinition left_tusk = head.m_171599_("left_tusk", CubeListBuilder.m_171558_().m_171514_(260, 292).m_171488_(-2.8627f, -4.0755f, -2.5f, 6.0f, 49.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)10.5f, (float)6.0f, (float)-19.0f, (float)0.0503f, (float)-0.5214f, (float)-0.1007f));
        PartDefinition left_tusk_wooly = left_tusk.m_171599_("left_tusk_wooly", CubeListBuilder.m_171558_().m_171514_(160, 244).m_171488_(2.0f, -2.0f, -5.0f, 6.0f, 19.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(232, 34).m_171488_(2.0f, 17.0f, -5.0f, 6.0f, 6.0f, 40.0f, new CubeDeformation(0.0f)).m_171514_(0, 334).m_171488_(-4.0f, -2.0f, -5.0f, 6.0f, 6.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-4.8627f, (float)27.9245f, (float)-31.5f));
        PartDefinition right_tusk = head.m_171599_("right_tusk", CubeListBuilder.m_171558_().m_171514_(260, 292).m_171480_().m_171488_(-3.1373f, -4.0755f, -2.5f, 6.0f, 49.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-10.5f, (float)6.0f, (float)-19.0f, (float)0.0503f, (float)0.5214f, (float)0.1007f));
        PartDefinition right_tusk_wooly = right_tusk.m_171599_("right_tusk_wooly", CubeListBuilder.m_171558_().m_171514_(160, 244).m_171480_().m_171488_(-8.0f, -2.0f, -5.0f, 6.0f, 19.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(232, 34).m_171480_().m_171488_(-8.0f, 17.0f, -5.0f, 6.0f, 6.0f, 40.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 334).m_171480_().m_171488_(-2.0f, -2.0f, -5.0f, 6.0f, 6.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)4.8627f, (float)27.9245f, (float)-31.5f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(194, 244).m_171488_(-1.0f, -1.0f, -0.5f, 2.0f, 20.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(324, 111).m_171488_(-2.5f, 19.0f, -2.0f, 5.0f, 9.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)-36.0f, (float)30.5f, (float)0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition arm_control = body_main.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)11.0f, (float)0.0f, (float)-17.5f));
        PartDefinition left_arm = arm_control.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(0, 284).m_171488_(-6.5f, 4.0f, -10.5f, 14.0f, 33.0f, 17.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm = arm_control.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 284).m_171480_().m_171488_(-7.5f, 4.0f, -10.5f, 14.0f, 33.0f, 17.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-22.0f, (float)0.0f, (float)0.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)11.5f, (float)0.0f, (float)18.5f));
        PartDefinition left_leg = leg_control.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(124, 284).m_171488_(-7.0f, 4.0f, -8.5f, 14.0f, 33.0f, 17.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg = leg_control.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(124, 284).m_171480_().m_171488_(-7.0f, 4.0f, -8.5f, 14.0f, 33.0f, 17.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-23.0f, (float)0.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)512, (int)512);
    }

    public void setupAnim(@NotNull Mammoth entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.m_267799_(MammothAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        this.animateIdle(entity.idleAnimationState, MammothAnimations.IDLE, ageInTicks, 1.0f, limbSwingAmount * 4.0f);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


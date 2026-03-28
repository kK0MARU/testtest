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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.EryonAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Eryon;
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
public class EryonModel
extends UP2Model<Eryon> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart eyes;
    private final ModelPart left_antennae;
    private final ModelPart right_antennae;
    private final ModelPart left_claw;
    private final ModelPart right_claw;
    private final ModelPart tail;
    private final ModelPart leg_control;
    private final ModelPart left_front_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_middle_front_leg;
    private final ModelPart right_middle_front_leg;
    private final ModelPart left_middle_back_leg;
    private final ModelPart right_middle_back_leg;
    private final ModelPart left_back_leg;
    private final ModelPart right_back_leg;

    public EryonModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.eyes = this.body.m_171324_("eyes");
        this.left_antennae = this.body.m_171324_("left_antennae");
        this.right_antennae = this.body.m_171324_("right_antennae");
        this.left_claw = this.body.m_171324_("left_claw");
        this.right_claw = this.body.m_171324_("right_claw");
        this.tail = this.body.m_171324_("tail");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_front_leg = this.leg_control.m_171324_("left_front_leg");
        this.right_front_leg = this.leg_control.m_171324_("right_front_leg");
        this.left_middle_front_leg = this.leg_control.m_171324_("left_middle_front_leg");
        this.right_middle_front_leg = this.leg_control.m_171324_("right_middle_front_leg");
        this.left_middle_back_leg = this.leg_control.m_171324_("left_middle_back_leg");
        this.right_middle_back_leg = this.leg_control.m_171324_("right_middle_back_leg");
        this.left_back_leg = this.leg_control.m_171324_("left_back_leg");
        this.right_back_leg = this.leg_control.m_171324_("right_back_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-3.0f, (float)1.5f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.5f, -1.0f, -3.5f, 7.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(17, 20).m_171488_(3.5f, -1.0f, -4.5f, 2.0f, 0.0f, 6.0f, new CubeDeformation(0.001f)).m_171514_(17, 20).m_171480_().m_171488_(-5.5f, -1.0f, -4.5f, 2.0f, 0.0f, 6.0f, new CubeDeformation(0.001f)).m_171555_(false).m_171514_(0, 21).m_171488_(-3.5f, -1.0f, 1.5f, 7.0f, 0.0f, 2.0f, new CubeDeformation(0.001f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition eyes = body.m_171599_("eyes", CubeListBuilder.m_171558_().m_171514_(22, 19).m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 0.0f, 1.0f, new CubeDeformation(0.001f)), PartPose.m_171419_((float)0.0f, (float)-1.0f, (float)-3.5f));
        PartDefinition left_antennae = body.m_171599_("left_antennae", CubeListBuilder.m_171558_().m_171514_(22, 7).m_171488_(-0.5f, -0.01f, -5.0f, 2.0f, 0.0f, 5.0f, new CubeDeformation(0.001f)), PartPose.m_171423_((float)1.0f, (float)-1.0f, (float)-2.5f, (float)-0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition right_antennae = body.m_171599_("right_antennae", CubeListBuilder.m_171558_().m_171514_(22, 7).m_171480_().m_171488_(-1.5f, -0.01f, -5.0f, 2.0f, 0.0f, 5.0f, new CubeDeformation(0.001f)).m_171555_(false), PartPose.m_171423_((float)-1.0f, (float)-1.0f, (float)-2.5f, (float)-0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition left_claw = body.m_171599_("left_claw", CubeListBuilder.m_171558_().m_171514_(0, 7).m_171488_(0.0f, 0.0f, -6.5f, 4.0f, 0.0f, 7.0f, new CubeDeformation(0.001f)), PartPose.m_171423_((float)3.5f, (float)0.0f, (float)-3.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition right_claw = body.m_171599_("right_claw", CubeListBuilder.m_171558_().m_171514_(0, 7).m_171480_().m_171488_(-4.0f, 0.0f, -6.5f, 4.0f, 0.0f, 7.0f, new CubeDeformation(0.001f)).m_171555_(false), PartPose.m_171423_((float)-3.5f, (float)0.0f, (float)-3.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(22, 12).m_171488_(-1.5f, -0.5f, 0.0f, 3.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(22, 17).m_171488_(-2.5f, 0.0f, 3.0f, 5.0f, 0.0f, 2.0f, new CubeDeformation(0.001f)), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)1.5f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)0.0f));
        PartDefinition left_front_leg = leg_control.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(14, 26).m_171488_(0.0f, -0.5f, 0.0f, 3.0f, 3.0f, 0.0f, new CubeDeformation(0.001f)), PartPose.m_171419_((float)3.5f, (float)0.0f, (float)-1.5f));
        PartDefinition right_front_leg = leg_control.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(14, 26).m_171480_().m_171488_(-3.0f, -0.5f, 0.0f, 3.0f, 3.0f, 0.0f, new CubeDeformation(0.001f)).m_171555_(false), PartPose.m_171419_((float)-3.5f, (float)0.0f, (float)-1.5f));
        PartDefinition left_middle_front_leg = leg_control.m_171599_("left_middle_front_leg", CubeListBuilder.m_171558_().m_171514_(14, 26).m_171488_(0.0f, -0.5f, 0.0f, 3.0f, 3.0f, 0.0f, new CubeDeformation(0.001f)), PartPose.m_171419_((float)3.5f, (float)0.0f, (float)-0.5f));
        PartDefinition right_middle_front_leg = leg_control.m_171599_("right_middle_front_leg", CubeListBuilder.m_171558_().m_171514_(14, 26).m_171480_().m_171488_(-3.0f, -0.5f, 0.0f, 3.0f, 3.0f, 0.0f, new CubeDeformation(0.001f)).m_171555_(false), PartPose.m_171419_((float)-3.5f, (float)0.0f, (float)-0.5f));
        PartDefinition left_middle_back_leg = leg_control.m_171599_("left_middle_back_leg", CubeListBuilder.m_171558_().m_171514_(14, 26).m_171488_(0.0f, -0.5f, 0.0f, 3.0f, 3.0f, 0.0f, new CubeDeformation(0.001f)), PartPose.m_171419_((float)3.5f, (float)0.0f, (float)0.5f));
        PartDefinition right_middle_back_leg = leg_control.m_171599_("right_middle_back_leg", CubeListBuilder.m_171558_().m_171514_(14, 26).m_171480_().m_171488_(-3.0f, -0.5f, 0.0f, 3.0f, 3.0f, 0.0f, new CubeDeformation(0.001f)).m_171555_(false), PartPose.m_171419_((float)-3.5f, (float)0.0f, (float)0.5f));
        PartDefinition left_back_leg = leg_control.m_171599_("left_back_leg", CubeListBuilder.m_171558_().m_171514_(14, 26).m_171488_(0.0f, -0.5f, 0.0f, 3.0f, 3.0f, 0.0f, new CubeDeformation(0.001f)), PartPose.m_171419_((float)3.5f, (float)0.0f, (float)1.5f));
        PartDefinition right_back_leg = leg_control.m_171599_("right_back_leg", CubeListBuilder.m_171558_().m_171514_(14, 26).m_171480_().m_171488_(-3.0f, -0.5f, 0.0f, 3.0f, 3.0f, 0.0f, new CubeDeformation(0.001f)).m_171555_(false), PartPose.m_171419_((float)-3.5f, (float)0.0f, (float)1.5f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(@NotNull Eryon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.m_267799_(EryonAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        this.animateIdle(entity.idleAnimationState, EryonAnimations.IDLE, ageInTicks, 1.0f, limbSwingAmount * 4.0f);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


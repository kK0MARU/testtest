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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.DromaeosaurusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Dromaeosaurus;
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
public class DromaeosaurusModel
extends UP2Model<Dromaeosaurus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart breathing;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart leg_control;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart left_leg3;
    private final ModelPart left_claw;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;
    private final ModelPart right_leg3;
    private final ModelPart right_claw;

    public DromaeosaurusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.breathing = this.body.m_171324_("breathing");
        this.neck = this.body.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.left_arm = this.body.m_171324_("left_arm");
        this.right_arm = this.body.m_171324_("right_arm");
        this.tail1 = this.body.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_leg1 = this.leg_control.m_171324_("left_leg1");
        this.left_leg2 = this.left_leg1.m_171324_("left_leg2");
        this.left_leg3 = this.left_leg2.m_171324_("left_leg3");
        this.left_claw = this.left_leg3.m_171324_("left_claw");
        this.right_leg1 = this.leg_control.m_171324_("right_leg1");
        this.right_leg2 = this.right_leg1.m_171324_("right_leg2");
        this.right_leg3 = this.right_leg2.m_171324_("right_leg3");
        this.right_claw = this.right_leg3.m_171324_("right_claw");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-10.0f, (float)3.5f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition breathing = body.m_171599_("breathing", CubeListBuilder.m_171558_().m_171514_(0, 39).m_171488_(-4.0f, -7.0f, -5.0f, 6.0f, 7.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)1.0f, (float)2.0f, (float)-3.5f));
        PartDefinition neck = body.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(0, 56).m_171488_(-1.5f, -5.0f, -3.0f, 3.0f, 7.0f, 4.0f, new CubeDeformation(0.0025f)).m_171514_(32, 51).m_171488_(-1.5f, -10.0f, -1.0f, 3.0f, 8.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(34, 63).m_171488_(-1.5f, -10.01f, 3.0f, 3.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)-8.5f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(46, 52).m_171488_(-2.5f, -1.01f, -4.0f, 5.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(14, 56).m_171488_(-1.5f, -1.01f, -8.0f, 3.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-9.0f, (float)2.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(62, 60).m_171488_(-1.5f, -0.01f, -4.0f, 3.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)2.0f, (float)-4.0f));
        PartDefinition left_arm = body.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(64, 39).m_171488_(-1.0f, -1.0f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(50, 39).m_171488_(0.99f, 1.0f, -3.0f, 0.0f, 6.0f, 7.0f, new CubeDeformation(0.0025f)).m_171514_(14, 63).m_171488_(-1.0f, 2.0f, -3.0f, 2.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(44, 64).m_171488_(-1.0f, 2.0f, -5.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)3.0f, (float)1.0f, (float)-6.5f));
        PartDefinition right_arm = body.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(64, 39).m_171480_().m_171488_(-1.0f, -1.0f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(50, 39).m_171480_().m_171488_(-0.99f, 1.0f, -3.0f, 0.0f, 6.0f, 7.0f, new CubeDeformation(0.0025f)).m_171555_(false).m_171514_(14, 63).m_171480_().m_171488_(-1.0f, 2.0f, -3.0f, 2.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(44, 64).m_171480_().m_171488_(-1.0f, 2.0f, -5.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-3.0f, (float)1.0f, (float)-6.5f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-4.0f, (float)1.5f));
        PartDefinition tail_r1 = tail1.m_171599_("tail_r1", CubeListBuilder.m_171558_().m_171514_(24, 24).m_171480_().m_171488_(-7.0f, 0.0f, 0.0f, 7.0f, 0.0f, 15.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        PartDefinition tail_r2 = tail1.m_171599_("tail_r2", CubeListBuilder.m_171558_().m_171514_(24, 24).m_171488_(0.0f, 0.0f, 0.0f, 7.0f, 0.0f, 15.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)15.0f));
        PartDefinition tail_r3 = tail2.m_171599_("tail_r3", CubeListBuilder.m_171558_().m_171514_(15, 0).m_171480_().m_171488_(-7.0f, 0.0f, 0.0f, 7.0f, 0.0f, 24.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        PartDefinition tail_r4 = tail2.m_171599_("tail_r4", CubeListBuilder.m_171558_().m_171514_(15, 0).m_171488_(0.0f, 0.0f, 0.0f, 7.0f, 0.0f, 24.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(32, 39).m_171488_(-2.0f, -2.0f, -2.5f, 4.0f, 7.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)2.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(26, 63).m_171488_(-1.0f, -1.0f, 0.0f, 2.0f, 8.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)2.5f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(46, 60).m_171488_(-1.0f, 0.09f, -4.0f, 4.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)6.9f, (float)1.0f));
        PartDefinition left_claw = left_leg3.m_171599_("left_claw", CubeListBuilder.m_171558_().m_171514_(28, 56).m_171488_(0.0f, -2.91f, -1.0f, 0.0f, 3.0f, 2.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)-1.0f, (float)0.0f, (float)-2.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(32, 39).m_171480_().m_171488_(-2.0f, -2.0f, -2.5f, 4.0f, 7.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-2.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(26, 63).m_171480_().m_171488_(-1.0f, -1.0f, 0.0f, 2.0f, 8.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)2.5f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(46, 60).m_171480_().m_171488_(-3.0f, 0.09f, -4.0f, 4.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)6.9f, (float)1.0f));
        PartDefinition right_claw = right_leg3.m_171599_("right_claw", CubeListBuilder.m_171558_().m_171514_(28, 56).m_171480_().m_171488_(0.0f, -2.91f, -1.0f, 0.0f, 3.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)1.0f, (float)0.0f, (float)-2.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(@NotNull Dromaeosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.m_267799_(DromaeosaurusAnimations.RUN, limbSwing, limbSwingAmount, 1.25f, 3.0f);
        this.animateIdleSmooth(entity.idleAnimationState, DromaeosaurusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.attackAnimationState, DromaeosaurusAnimations.BITE, ageInTicks);
        this.animateSmooth(entity.fallAnimationState, DromaeosaurusAnimations.JUMP, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, DromaeosaurusAnimations.SLEEP, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(DromaeosaurusAnimations.BABY_TRANSFORM);
        }
        this.animateHead(entity, this.neck, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


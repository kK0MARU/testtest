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
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_1;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.DiplocaulusAnimations;
import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.DiplocaulusRecurvatisAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Diplocaulus;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class DiplocaulusRecurvatisModel
extends UP2Model<Diplocaulus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart tail;
    private final ModelPart arm_control;
    private final ModelPart left_arm1;
    private final ModelPart left_arm2;
    private final ModelPart right_arm1;
    private final ModelPart right_arm2;
    private final ModelPart leg_control;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;

    public DiplocaulusRecurvatisModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.neck = this.body.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.tail = this.body.m_171324_("tail");
        this.arm_control = this.body_main.m_171324_("arm_control");
        this.left_arm1 = this.arm_control.m_171324_("left_arm1");
        this.left_arm2 = this.left_arm1.m_171324_("left_arm2");
        this.right_arm1 = this.arm_control.m_171324_("right_arm1");
        this.right_arm2 = this.right_arm1.m_171324_("right_arm2");
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
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-2.05f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(20, 7).m_171488_(-2.0f, -3.0f, -3.0f, 4.0f, 5.0f, 6.0f, new CubeDeformation(0.05f)).m_171514_(14, 28).m_171488_(0.0f, -4.0f, -3.0f, 0.0f, 1.0f, 6.0f, new CubeDeformation(0.0025f)).m_171514_(0, 0).m_171488_(-5.0f, -2.05f, -5.0f, 10.0f, 0.0f, 7.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition neck = body.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(0, 37).m_171488_(-1.5f, -1.0f, -2.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-1.5f, (float)-3.0f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)-1.0f));
        PartDefinition righthead_r1 = head.m_171599_("righthead_r1", CubeListBuilder.m_171558_().m_171514_(0, 25).m_171480_().m_171488_(-5.0f, -2.0f, 0.0f, 5.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-2.825f, (float)0.0f, (float)-2.0f, (float)0.0f, (float)0.7854f, (float)0.0f));
        PartDefinition lefthead_r1 = head.m_171599_("lefthead_r1", CubeListBuilder.m_171558_().m_171514_(26, 28).m_171488_(0.0f, -2.0f, 0.0f, 5.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)2.825f, (float)0.0f, (float)-2.0f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition face_r1 = head.m_171599_("face_r1", CubeListBuilder.m_171558_().m_171514_(20, 18).m_171488_(-2.0f, -0.5f, -2.0f, 4.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)-1.5f, (float)-2.0f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition jaw_r1 = jaw.m_171599_("jaw_r1", CubeListBuilder.m_171558_().m_171514_(14, 23).m_171488_(-2.0f, -2.0f, -2.0f, 4.0f, 1.0f, 4.0f, new CubeDeformation(0.0025f)).m_171514_(0, 29).m_171488_(-2.0f, -1.01f, -2.0f, 4.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)0.0f, (float)1.0f, (float)-2.0f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(0, 7).m_171488_(0.0f, -3.0f, -1.0f, 0.0f, 4.0f, 10.0f, new CubeDeformation(0.0025f)).m_171514_(31, 22).m_171488_(-3.0f, -2.0f, 0.0f, 6.0f, 0.0f, 9.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)3.0f));
        PartDefinition arm_control = body_main.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.4f, (float)-2.0f));
        PartDefinition left_arm1 = arm_control.m_171599_("left_arm1", CubeListBuilder.m_171558_().m_171514_(12, 35).m_171488_(0.0f, -0.42f, -1.01f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)2.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm2 = left_arm1.m_171599_("left_arm2", CubeListBuilder.m_171558_().m_171514_(-1, 33).m_171488_(-1.0f, 0.0f, -2.01f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)3.0f, (float)1.59f, (float)0.0f));
        PartDefinition right_arm1 = arm_control.m_171599_("right_arm1", CubeListBuilder.m_171558_().m_171514_(12, 35).m_171480_().m_171488_(-3.0f, -0.42f, -1.01f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-2.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm2 = right_arm1.m_171599_("right_arm2", CubeListBuilder.m_171558_().m_171514_(-1, 33).m_171480_().m_171488_(-1.0f, 0.0f, -2.01f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-3.0f, (float)1.59f, (float)0.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.4f, (float)3.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(12, 35).m_171488_(0.0f, -0.42f, -1.01f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)2.0f, (float)0.0f, (float)-1.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(-1, 33).m_171488_(-1.0f, 0.0f, -2.01f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)3.0f, (float)1.59f, (float)0.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(12, 35).m_171480_().m_171488_(-3.0f, -0.42f, -1.01f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-2.0f, (float)0.0f, (float)-1.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(-1, 33).m_171480_().m_171488_(-1.0f, 0.0f, -2.01f, 2.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-3.0f, (float)1.59f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(Diplocaulus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        float deg = (float)Math.PI / 180;
        if (entity.m_20072_()) {
            this.root.f_104203_ = headPitch * deg;
            this.m_267799_(DiplocaulusRecurvatisAnimations.SWIM, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        } else if (entity.isSliding()) {
            this.m_267799_(DiplocaulusRecurvatisAnimations.SLIDE, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        } else {
            this.m_267799_(DiplocaulusRecurvatisAnimations.WALK, limbSwing, limbSwingAmount, 2.0f, 4.0f);
        }
        this.animateIdleSmooth(entity.idleAnimationState, DiplocaulusRecurvatisAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateIdleSmooth(entity.swimIdleAnimationState, DiplocaulusRecurvatisAnimations.SWIM_IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.quirkAnimationState, DiplocaulusRecurvatisAnimations.QUIRK_BLEND, ageInTicks);
        this.animateSmooth(entity.burrowAnimationState, DiplocaulusRecurvatisAnimations.BURROW_HOLD, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(DiplocaulusAnimations.BABY_TRANSFORM);
        }
        if (entity.isBurrowed() && entity.m_9236_().m_8055_(entity.m_20183_()).m_60713_(Blocks.f_220864_)) {
            this.body_main.f_104201_ = 1.0f;
        }
        if (!entity.isBurrowed()) {
            this.head.f_104203_ += headPitch * deg / 4.0f;
            this.head.f_104204_ += netHeadYaw * deg / 4.0f;
        }
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


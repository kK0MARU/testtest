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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.TalpanasAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Talpanas;
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
public class TalpanasModel
extends UP2Model<Talpanas> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart bill;
    private final ModelPart lowerbill;
    private final ModelPart hair;
    private final ModelPart tail;
    private final ModelPart left_wing;
    private final ModelPart right_wing;
    private final ModelPart leg_control;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public TalpanasModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.bill = this.head.m_171324_("bill");
        this.lowerbill = this.bill.m_171324_("lowerbill");
        this.hair = this.head.m_171324_("hair");
        this.tail = this.body.m_171324_("tail");
        this.left_wing = this.body.m_171324_("left_wing");
        this.right_wing = this.body.m_171324_("right_wing");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_leg = this.leg_control.m_171324_("left_leg");
        this.right_leg = this.leg_control.m_171324_("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-6.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0f, -5.0f, -5.0f, 8.0f, 8.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(25, 18).m_171488_(-2.0f, -5.0f, -2.5f, 4.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-3.0f, (float)-3.5f));
        PartDefinition bill = head.m_171599_("bill", CubeListBuilder.m_171558_().m_171514_(0, 4).m_171488_(-1.5f, -1.0f, -2.0f, 3.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(0, 19).m_171488_(-2.5f, -1.0f, -5.0f, 5.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(0, 0).m_171488_(-0.5f, -1.0f, -5.5f, 1.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-3.0f, (float)-2.5f));
        PartDefinition lowerbill = bill.m_171599_("lowerbill", CubeListBuilder.m_171558_().m_171514_(-5, 24).m_171488_(-2.5f, 0.0f, -5.0f, 5.0f, 0.0f, 5.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition hair = head.m_171599_("hair", CubeListBuilder.m_171558_().m_171514_(38, 19).m_171488_(-1.5f, -3.0f, 0.0f, 3.0f, 3.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)0.0f, (float)-4.0f, (float)-2.5f, (float)0.3927f, (float)0.0f, (float)0.0f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(27, 0).m_171488_(-2.5f, 0.0f, 0.0f, 5.0f, 5.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-3.0f, (float)5.0f));
        PartDefinition left_wing = body.m_171599_("left_wing", CubeListBuilder.m_171558_().m_171514_(13, 18).m_171488_(0.0f, 0.0f, -1.0f, 1.0f, 3.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(13, 21).m_171488_(0.5f, 0.0f, 1.0f, 0.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.0f, (float)-3.0f, (float)-1.0f));
        PartDefinition right_wing = body.m_171599_("right_wing", CubeListBuilder.m_171558_().m_171514_(13, 18).m_171480_().m_171488_(-1.0f, 0.0f, -1.0f, 1.0f, 3.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(13, 21).m_171480_().m_171488_(-0.5f, 0.0f, 1.0f, 0.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.0f, (float)-3.0f, (float)-1.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)2.5f, (float)3.0f, (float)3.0f));
        PartDefinition left_leg = leg_control.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(37, 12).m_171488_(-0.5f, 0.0f, -1.5f, 2.0f, 4.0f, 2.0f, new CubeDeformation(0.0025f)).m_171514_(41, 13).m_171488_(-0.5f, 4.0f, -4.5f, 5.0f, 0.0f, 5.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)-1.0f, (float)-1.025f, (float)-0.5f));
        PartDefinition right_leg = leg_control.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(37, 12).m_171480_().m_171488_(-1.5f, 0.0f, -1.5f, 2.0f, 4.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false).m_171514_(41, 13).m_171480_().m_171488_(-4.5f, 4.0f, -4.5f, 5.0f, 0.0f, 5.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-4.0f, (float)-1.025f, (float)-0.5f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(@NotNull Talpanas entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (entity.m_20096_() && !entity.isEepy()) {
            if (entity.isRunning()) {
                this.m_267799_(TalpanasAnimations.RUN, limbSwing, limbSwingAmount, 1.0f, 2.0f);
            } else {
                this.m_267799_(TalpanasAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        if (this.f_102610_) {
            this.m_288214_(TalpanasAnimations.BABY_TRANSFORM);
        }
        this.animateIdleSmooth(entity.idleAnimationState, TalpanasAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.flapAnimationState, TalpanasAnimations.FALL, ageInTicks);
        this.animateSmooth(entity.peckAnimationState, TalpanasAnimations.PECK_BLEND, ageInTicks);
        this.animateSmooth(entity.shakeAnimationState, TalpanasAnimations.SHAKE_BLEND, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, TalpanasAnimations.SIT, ageInTicks);
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


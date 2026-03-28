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
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_4;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.KaprosuchusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Kaprosuchus;
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
public class KaprosuchusModel
extends UP2Model<Kaprosuchus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body_upper;
    private final ModelPart body;
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
    private final ModelPart left_leg3;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;
    private final ModelPart right_leg3;

    public KaprosuchusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body_upper = this.body_main.m_171324_("body_upper");
        this.body = this.body_upper.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.tail = this.body.m_171324_("tail");
        this.arm_control = this.body_upper.m_171324_("arm_control");
        this.left_arm1 = this.arm_control.m_171324_("left_arm1");
        this.left_arm2 = this.left_arm1.m_171324_("left_arm2");
        this.right_arm1 = this.arm_control.m_171324_("right_arm1");
        this.right_arm2 = this.right_arm1.m_171324_("right_arm2");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_leg1 = this.leg_control.m_171324_("left_leg1");
        this.left_leg2 = this.left_leg1.m_171324_("left_leg2");
        this.left_leg3 = this.left_leg2.m_171324_("left_leg3");
        this.right_leg1 = this.leg_control.m_171324_("right_leg1");
        this.right_leg2 = this.right_leg1.m_171324_("right_leg2");
        this.right_leg3 = this.right_leg2.m_171324_("right_leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-16.0f, (float)0.0f));
        PartDefinition body_upper = body_main.m_171599_("body_upper", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)6.5f));
        PartDefinition body = body_upper.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(34, 101).m_171488_(-3.0f, -4.0f, 1.5f, 6.0f, 8.0f, 9.0f, new CubeDeformation(0.0f)).m_171514_(37, 54).m_171488_(-2.0f, -6.0f, -11.5f, 4.0f, 2.0f, 19.0f, new CubeDeformation(0.0f)).m_171514_(82, 0).m_171488_(-5.5f, -4.0f, -11.5f, 11.0f, 12.0f, 13.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-3.0f, (float)-6.5f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(58, 119).m_171488_(-2.5f, -5.0f, -8.0f, 5.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(82, 41).m_171488_(-2.5f, -3.0f, -7.0f, 5.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(68, 87).m_171488_(-2.5f, 1.0f, -18.0f, 5.0f, 2.0f, 12.0f, new CubeDeformation(0.0f)).m_171514_(0, 87).m_171488_(-2.5f, -2.0f, -18.0f, 5.0f, 3.0f, 12.0f, new CubeDeformation(0.0f)).m_171514_(116, 25).m_171488_(-2.5f, -2.0f, -6.0f, 5.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-1.0f, (float)-11.5f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(0, 102).m_171488_(-3.5f, 0.0f, -5.0f, 7.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(34, 87).m_171488_(-2.5f, 2.0f, -17.0f, 5.0f, 2.0f, 12.0f, new CubeDeformation(0.01f)).m_171514_(98, 41).m_171488_(-1.5f, 4.0f, -17.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-1.0f, (float)-1.0f));
        PartDefinition fronteeth_r1 = jaw.m_171599_("fronteeth_r1", CubeListBuilder.m_171558_().m_171514_(122, 87).m_171488_(-2.5f, -2.0f, 0.0f, 5.0f, 2.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)0.0f, (float)2.0f, (float)-17.0f, (float)0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition sideteeth_r1 = jaw.m_171599_("sideteeth_r1", CubeListBuilder.m_171558_().m_171514_(64, 101).m_171480_().m_171488_(0.0f, -6.0f, -1.0f, 0.0f, 6.0f, 12.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-2.5f, (float)2.0f, (float)-16.0f, (float)0.0f, (float)0.0f, (float)-0.0873f));
        PartDefinition sideteeth_r2 = jaw.m_171599_("sideteeth_r2", CubeListBuilder.m_171558_().m_171514_(64, 101).m_171488_(0.0f, -6.0f, -1.0f, 0.0f, 6.0f, 12.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)2.5f, (float)2.0f, (float)-16.0f, (float)0.0f, (float)0.0f, (float)0.0873f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5f, -5.5f, -1.5f, 3.0f, 7.0f, 38.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-2.5f, (float)9.0f));
        PartDefinition spikes_r1 = tail.m_171599_("spikes_r1", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171480_().m_171488_(0.0f, -8.0f, -1.0f, 0.0f, 8.0f, 34.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-1.5f, (float)-5.5f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)-0.0436f));
        PartDefinition spikes_r2 = tail.m_171599_("spikes_r2", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171488_(0.0f, -8.0f, -1.0f, 0.0f, 8.0f, 34.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)1.5f, (float)-5.5f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)0.0873f));
        PartDefinition arm_control = body_upper.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)-16.0f));
        PartDefinition left_arm1 = arm_control.m_171599_("left_arm1", CubeListBuilder.m_171558_().m_171514_(78, 119).m_171488_(-2.0f, -1.0f, -2.0f, 3.0f, 11.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm2 = left_arm1.m_171599_("left_arm2", CubeListBuilder.m_171558_().m_171514_(117, 38).m_171488_(-2.5f, -1.0f, -3.0f, 5.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-0.5f, (float)8.9f, (float)-1.0f));
        PartDefinition right_arm1 = arm_control.m_171599_("right_arm1", CubeListBuilder.m_171558_().m_171514_(78, 119).m_171480_().m_171488_(-1.0f, -1.0f, -2.0f, 3.0f, 11.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm2 = right_arm1.m_171599_("right_arm2", CubeListBuilder.m_171558_().m_171514_(117, 38).m_171480_().m_171488_(-2.5f, -1.0f, -3.0f, 5.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.5f, (float)8.9f, (float)-1.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)6.5f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(102, 87).m_171488_(-2.0f, -3.0f, -3.0f, 4.0f, 8.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(20, 112).m_171488_(-1.5f, -2.0f, -1.0f, 3.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(26, 102).m_171488_(1.5f, -2.0f, 3.0f, 0.0f, 8.0f, 2.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)2.0f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(117, 45).m_171488_(-2.5f, -1.0f, -3.0f, 5.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)8.9f, (float)0.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(102, 87).m_171480_().m_171488_(-2.0f, -3.0f, -3.0f, 4.0f, 8.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(26, 102).m_171480_().m_171488_(-1.5f, -2.0f, 3.0f, 0.0f, 8.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false).m_171514_(20, 112).m_171480_().m_171488_(-1.5f, -2.0f, -1.0f, 3.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)2.0f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(117, 45).m_171480_().m_171488_(-2.5f, -1.0f, -3.0f, 5.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)8.9f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(@NotNull Kaprosuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!(entity.isLeaping() || entity.isSitting() || entity.isEepy())) {
            if (entity.m_20072_()) {
                this.m_267799_(KaprosuchusAnimations.SWIM, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            } else if (entity.isRunning()) {
                this.m_267799_(KaprosuchusAnimations.RUN, limbSwing, limbSwingAmount, 1.0f, 2.0f);
            } else {
                this.m_267799_(KaprosuchusAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, KaprosuchusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateIdleSmooth(entity.swimIdleAnimationState, KaprosuchusAnimations.SWIM_IDLE, ageInTicks, limbSwingAmount);
        if (entity.m_20072_()) {
            this.animateSmooth(entity.attack1AnimationState, KaprosuchusAnimations.SWIM_BITE_BLEND1, ageInTicks);
            this.animateSmooth(entity.attack2AnimationState, KaprosuchusAnimations.SWIM_BITE_BLEND2, ageInTicks);
        } else {
            this.animateSmooth(entity.attack1AnimationState, KaprosuchusAnimations.BITE_BLEND1, ageInTicks);
            this.animateSmooth(entity.attack2AnimationState, KaprosuchusAnimations.BITE_BLEND2, ageInTicks);
        }
        this.animateSmooth(entity.sitAnimationState, KaprosuchusAnimations.SIT, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, KaprosuchusAnimations.SLEEP, ageInTicks);
        this.m_233381_(entity.leapAnimationState, KaprosuchusAnimations.POUNCE, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(KaprosuchusAnimations.BABY_TRANSFORM);
        }
        if (entity.m_20072_() || entity.isLeaping()) {
            this.root.f_104203_ = headPitch * ((float)Math.PI / 180);
        }
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


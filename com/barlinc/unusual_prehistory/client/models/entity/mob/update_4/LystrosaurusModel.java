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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.LystrosaurusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Lystrosaurus;
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
public class LystrosaurusModel
extends UP2Model<Lystrosaurus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart breathing;
    private final ModelPart head;
    private final ModelPart left_brow;
    private final ModelPart right_brow;
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

    public LystrosaurusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.breathing = this.body.m_171324_("breathing");
        this.head = this.body.m_171324_("head");
        this.left_brow = this.head.m_171324_("left_brow");
        this.right_brow = this.head.m_171324_("right_brow");
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
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-4.5f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition breathing = body.m_171599_("breathing", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-6.0f, -5.5f, -8.0f, 12.0f, 11.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-4.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(1, 27).m_171488_(-3.5f, -4.0f, -6.0f, 7.0f, 7.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(21, 49).m_171488_(-1.5f, -2.0f, -9.0f, 3.0f, 4.0f, 3.0f, new CubeDeformation(0.01f)).m_171514_(37, 45).m_171480_().m_171488_(-3.5f, -1.0f, -8.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(37, 45).m_171488_(1.5f, -1.0f, -8.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-7.5f, (float)-8.0f));
        PartDefinition left_brow = head.m_171599_("left_brow", CubeListBuilder.m_171558_().m_171514_(47, 49).m_171488_(-1.5f, -0.5f, -1.5f, 3.0f, 1.0f, 3.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)2.0f, (float)-4.5f, (float)-4.5f));
        PartDefinition right_brow = head.m_171599_("right_brow", CubeListBuilder.m_171558_().m_171514_(47, 49).m_171480_().m_171488_(-1.5f, -0.5f, -1.5f, 3.0f, 1.0f, 3.0f, new CubeDeformation(0.01f)).m_171555_(false), PartPose.m_171419_((float)-2.0f, (float)-4.5f, (float)-4.5f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(52, 27).m_171488_(-1.5f, 0.0f, -3.0f, 3.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)2.0f, (float)-6.0f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(32, 27).m_171488_(-1.5f, -1.5f, 0.0f, 3.0f, 3.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)8.0f));
        PartDefinition arm_control = body_main.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)-5.5f));
        PartDefinition left_arm1 = arm_control.m_171599_("left_arm1", CubeListBuilder.m_171558_().m_171514_(0, 43).m_171488_(-2.0f, -2.0f, -1.5f, 7.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(52, 32).m_171488_(2.0f, 2.0f, -1.5f, 3.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)6.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm2 = left_arm1.m_171599_("left_arm2", CubeListBuilder.m_171558_().m_171514_(21, 45).m_171488_(-2.5f, 0.0f, -4.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)3.5f, (float)4.0f, (float)-0.5f));
        PartDefinition right_arm1 = arm_control.m_171599_("right_arm1", CubeListBuilder.m_171558_().m_171514_(0, 43).m_171480_().m_171488_(-5.0f, -2.0f, -1.5f, 7.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(52, 32).m_171480_().m_171488_(-5.0f, 2.0f, -1.5f, 3.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-6.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm2 = right_arm1.m_171599_("right_arm2", CubeListBuilder.m_171558_().m_171514_(21, 45).m_171480_().m_171488_(-3.5f, 0.0f, -4.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.01f)).m_171555_(false), PartPose.m_171419_((float)-3.5f, (float)4.0f, (float)-0.5f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)6.0f, (float)0.5f, (float)5.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(32, 37).m_171488_(-2.0f, -2.0f, -2.0f, 7.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(0, 50).m_171488_(2.0f, 2.0f, -2.0f, 3.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(21, 45).m_171488_(-2.5f, 0.0f, -4.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)3.5f, (float)4.0f, (float)-1.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(32, 37).m_171480_().m_171488_(-5.0f, -2.0f, -2.0f, 7.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 50).m_171480_().m_171488_(-5.0f, 2.0f, -2.0f, 3.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-12.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(21, 45).m_171480_().m_171488_(-3.5f, 0.0f, -4.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.01f)).m_171555_(false), PartPose.m_171419_((float)-3.5f, (float)4.0f, (float)-1.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(Lystrosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20069_() && !entity.isEepy()) {
            if (entity.isRunning()) {
                this.m_267799_(LystrosaurusAnimations.RUN, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            } else {
                this.m_267799_(LystrosaurusAnimations.WALK, limbSwing, limbSwingAmount, 2.0f, 4.0f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, LystrosaurusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.shakeAnimationState, LystrosaurusAnimations.IDLE_SHAKE_BLEND, ageInTicks);
        this.animateSmooth(entity.attackAnimationState, LystrosaurusAnimations.BITE_BLEND, ageInTicks);
        this.animateSmooth(entity.grazeAnimationState, LystrosaurusAnimations.EAT_BLEND, ageInTicks);
        this.animateSmooth(entity.digAnimationState, LystrosaurusAnimations.DIG, ageInTicks);
        this.animateSmooth(entity.scratch1AnimationState, LystrosaurusAnimations.IDLE_SCATCH1, ageInTicks);
        this.animateSmooth(entity.scratch2AnimationState, LystrosaurusAnimations.IDLE_SCATCH2, ageInTicks);
        this.animateSmooth(entity.blinkAnimationState, LystrosaurusAnimations.IDLE_BLINK_BLEND, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, LystrosaurusAnimations.SLEEP, ageInTicks);
        this.animateSmooth(entity.swimAnimationState, LystrosaurusAnimations.SWIM, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(LystrosaurusAnimations.BABY_TRANSFORM);
        }
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


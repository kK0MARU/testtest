/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.MajungasaurusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Majungasaurus;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
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
public class MajungasaurusModel
extends UP2Model<Majungasaurus> {
    private float alpha = 1.0f;
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart breathe;
    private final ModelPart neck;
    private final ModelPart dewlap;
    private final ModelPart head;
    private final ModelPart upper_jaw;
    private final ModelPart left_eye;
    private final ModelPart right_eye;
    private final ModelPart jaw;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart leg_control;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart left_leg3;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;
    private final ModelPart right_leg3;

    public MajungasaurusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.breathe = this.body.m_171324_("breathe");
        this.neck = this.body.m_171324_("neck");
        this.dewlap = this.neck.m_171324_("dewlap");
        this.head = this.neck.m_171324_("head");
        this.upper_jaw = this.head.m_171324_("upper_jaw");
        this.left_eye = this.upper_jaw.m_171324_("left_eye");
        this.right_eye = this.upper_jaw.m_171324_("right_eye");
        this.jaw = this.head.m_171324_("jaw");
        this.left_arm = this.body.m_171324_("left_arm");
        this.right_arm = this.body.m_171324_("right_arm");
        this.tail1 = this.body.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
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
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)-0.5f, (float)2.0f, (float)-6.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.5f, (float)3.0f, (float)4.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition breathe = body.m_171599_("breathe", CubeListBuilder.m_171558_().m_171514_(80, 42).m_171488_(-3.0f, -8.5f, -11.0f, 6.0f, 1.0f, 22.0f, new CubeDeformation(0.0f)).m_171514_(0, 80).m_171488_(-6.5f, -7.5f, -11.0f, 13.0f, 15.0f, 22.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-2.5f, (float)-4.0f));
        PartDefinition neck = body.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(104, 85).m_171488_(-2.5f, -15.0f, -2.0f, 5.0f, 17.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(70, 85).m_171488_(-3.5f, -14.0f, -5.0f, 7.0f, 18.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-3.0f, (float)-15.0f));
        PartDefinition dewlap = neck.m_171599_("dewlap", CubeListBuilder.m_171558_().m_171514_(58, 117).m_171488_(0.0f, -4.0f, -4.0f, 0.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(122, 65).m_171488_(-1.0f, -3.0f, -3.0f, 2.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)-5.0f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-11.0f, (float)-1.0f));
        PartDefinition upper_jaw = head.m_171599_("upper_jaw", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-4.5f, -6.0f, -5.0f, 9.0f, 6.0f, 5.0f, new CubeDeformation(0.01f)).m_171514_(104, 110).m_171488_(-4.5f, -6.0f, -11.0f, 9.0f, 7.0f, 6.0f, new CubeDeformation(0.01f)).m_171514_(70, 80).m_171488_(-1.0f, -9.0f, -4.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(122, 76).m_171488_(1.5f, -8.0f, -9.0f, 2.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(122, 76).m_171480_().m_171488_(-3.5f, -8.0f, -9.0f, 2.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(116, 35).m_171488_(-4.5f, 1.0f, -11.0f, 9.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)2.0f, (float)0.0f));
        PartDefinition left_eye = upper_jaw.m_171599_("left_eye", CubeListBuilder.m_171558_().m_171514_(120, 25).m_171488_(-2.5f, -2.5f, -2.5f, 5.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.0f, (float)-2.5f, (float)-5.5f));
        PartDefinition right_eye = upper_jaw.m_171599_("right_eye", CubeListBuilder.m_171558_().m_171514_(120, 25).m_171480_().m_171488_(-2.5f, -2.5f, -2.5f, 5.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.0f, (float)-2.5f, (float)-5.5f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(28, 117).m_171488_(-5.0f, 1.0f, -11.0f, 9.0f, 3.0f, 6.0f, new CubeDeformation(0.01f)).m_171514_(120, 0).m_171488_(-5.0f, 0.0f, -5.0f, 9.0f, 4.0f, 5.0f, new CubeDeformation(0.01f)).m_171514_(86, 35).m_171488_(-5.0f, 0.0f, -11.0f, 9.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.5f, (float)2.0f, (float)0.0f));
        PartDefinition left_arm = body.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(66, 123).m_171488_(-0.99f, 0.0f, -1.0f, 1.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)6.5f, (float)2.0f, (float)-12.0f));
        PartDefinition right_arm = body.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(66, 123).m_171480_().m_171488_(-0.01f, 0.0f, -1.0f, 1.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-6.5f, (float)2.0f, (float)-12.0f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(80, 65).m_171488_(-4.5f, -2.5f, 0.0f, 9.0f, 8.0f, 12.0f, new CubeDeformation(0.0f)).m_171514_(86, 22).m_171488_(-2.5f, -3.5f, 0.0f, 5.0f, 1.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-6.5f, (float)7.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0f, -2.5f, 0.0f, 6.0f, 5.0f, 37.0f, new CubeDeformation(0.0f)).m_171514_(1, 42).m_171488_(-1.5f, -3.5f, 0.0f, 3.0f, 1.0f, 37.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)12.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(86, 0).m_171488_(-4.0f, -4.0f, -5.0f, 7.0f, 12.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)6.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(120, 9).m_171488_(-3.0f, -1.0f, -3.0f, 5.0f, 11.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)7.0f, (float)4.0f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(70, 113).m_171488_(-3.5f, 0.0f, -4.5f, 7.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(82, 123).m_171488_(2.5f, 0.0f, -6.5f, 1.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(74, 123).m_171488_(-0.5f, 0.0f, -6.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(74, 123).m_171488_(-3.5f, 0.0f, -6.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-0.5f, (float)10.0f, (float)-0.5f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(86, 0).m_171480_().m_171488_(-3.0f, -4.0f, -5.0f, 7.0f, 12.0f, 10.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-6.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(120, 9).m_171480_().m_171488_(-2.0f, -1.0f, -3.0f, 5.0f, 11.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)7.0f, (float)4.0f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(70, 113).m_171480_().m_171488_(-3.5f, 0.0f, -4.5f, 7.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(82, 123).m_171480_().m_171488_(-3.5f, 0.0f, -6.5f, 1.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(74, 123).m_171480_().m_171488_(-1.5f, 0.0f, -6.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(74, 123).m_171480_().m_171488_(1.5f, 0.0f, -6.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.5f, (float)10.0f, (float)-0.5f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Majungasaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20069_() && !entity.isEepy()) {
            if (entity.isRunning() && !entity.isCamo()) {
                this.m_267799_(MajungasaurusAnimations.RUN, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            } else {
                this.m_267799_(MajungasaurusAnimations.WALK, limbSwing, limbSwingAmount, 4.0f, 8.0f);
            }
        }
        if (this.f_102610_) {
            this.m_288214_(MajungasaurusAnimations.BABY_TRANSFORM);
        }
        this.animateIdleSmooth(entity.idleAnimationState, MajungasaurusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.swimAnimationState, MajungasaurusAnimations.SWIM, ageInTicks);
        this.animateSmooth(entity.attack1AnimationState, MajungasaurusAnimations.ATTACK_BLEND1, ageInTicks);
        this.animateSmooth(entity.attack2AnimationState, MajungasaurusAnimations.ATTACK_BLEND2, ageInTicks);
        this.animateSmooth(entity.eyesAnimationState, MajungasaurusAnimations.EYESWIVEL_BLEND, ageInTicks);
        this.animateSmooth(entity.yawnAnimationState, MajungasaurusAnimations.YAWN_BLEND, ageInTicks);
        this.animateSmooth(entity.sniff1AnimationState, MajungasaurusAnimations.SNIFF_BLEND1, ageInTicks);
        this.animateSmooth(entity.sniff2AnimationState, MajungasaurusAnimations.SNIFF_BLEND2, ageInTicks);
        this.animateSmooth(entity.shakeAnimationState, MajungasaurusAnimations.SHAKE_BLEND, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, MajungasaurusAnimations.SLEEP, ageInTicks);
        this.animateHead(entity, this.neck, netHeadYaw, headPitch);
    }

    @Override
    public void m_7695_(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.m_85836_();
        if (this.f_102610_) {
            poseStack.m_85841_(this.youngScaleFactor, this.youngScaleFactor, this.youngScaleFactor);
            poseStack.m_252880_(0.0f, this.bodyYOffset / 16.0f, 0.0f);
        }
        this.m_142109_().m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha * this.alpha);
        poseStack.m_85849_();
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public float getAlpha() {
        return this.alpha;
    }
}


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
package com.barlinc.unusual_prehistory.client.models.entity.mob.future;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.BarinasuchusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Barinasuchus;
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
public class BarinasuchusModel
extends UP2Model<Barinasuchus> {
    private final ModelPart root;
    private final ModelPart body_main;
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

    public BarinasuchusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.head = this.body.m_171324_("head");
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
        this.left_leg3 = this.left_leg2.m_171324_("left_leg3");
        this.right_leg1 = this.leg_control.m_171324_("right_leg1");
        this.right_leg2 = this.right_leg1.m_171324_("right_leg2");
        this.right_leg3 = this.right_leg2.m_171324_("right_leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-23.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 59).m_171488_(-9.5f, -8.0f, -16.0f, 19.0f, 15.0f, 35.0f, new CubeDeformation(0.0f)).m_171514_(86, 109).m_171488_(-2.5f, -9.0f, -13.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(86, 109).m_171480_().m_171488_(0.5f, -9.0f, 12.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(86, 109).m_171480_().m_171488_(0.5f, -9.0f, 7.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(86, 109).m_171480_().m_171488_(0.5f, -9.0f, 2.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(86, 109).m_171480_().m_171488_(0.5f, -9.0f, -3.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(86, 109).m_171480_().m_171488_(0.5f, -9.0f, -8.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(86, 109).m_171480_().m_171488_(0.5f, -9.0f, -13.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(86, 109).m_171488_(-2.5f, -9.0f, 12.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(86, 109).m_171488_(-2.5f, -9.0f, 7.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(86, 109).m_171488_(-2.5f, -9.0f, 2.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(86, 109).m_171488_(-2.5f, -9.0f, -8.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(86, 109).m_171488_(-2.5f, -9.0f, -3.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(132, 137).m_171488_(-4.0f, -6.0f, -4.0f, 8.0f, 5.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(86, 109).m_171488_(-3.0f, -6.0f, -17.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(86, 109).m_171488_(1.0f, -6.0f, -17.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(108, 52).m_171488_(-4.0f, -5.0f, -21.0f, 8.0f, 7.0f, 17.0f, new CubeDeformation(0.0f)).m_171514_(108, 106).m_171488_(-4.0f, 0.75f, -21.0f, 8.0f, 4.0f, 17.0f, new CubeDeformation(-0.1f)).m_171514_(132, 127).m_171488_(-4.0f, -6.0f, -13.0f, 8.0f, 1.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-18.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(0, 109).m_171488_(-4.0f, 1.0f, -21.0f, 8.0f, 3.0f, 14.0f, new CubeDeformation(0.2f)).m_171514_(44, 109).m_171488_(-4.0f, -3.0f, -21.0f, 8.0f, 5.0f, 13.0f, new CubeDeformation(0.1f)).m_171514_(30, 127).m_171488_(-5.0f, -2.0f, -7.0f, 10.0f, 7.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)0.0f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5f, -2.0f, -1.0f, 5.0f, 11.0f, 48.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-5.0f, (float)18.0f));
        PartDefinition Tail_r1 = tail.m_171599_("Tail_r1", CubeListBuilder.m_171558_().m_171514_(106, 0).m_171488_(0.0f, -3.0f, -3.0f, 0.0f, 4.0f, 48.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)-1.0f, (float)-3.0f, (float)5.0f, (float)0.0f, (float)0.0f, (float)-0.2182f));
        PartDefinition Tail_r2 = tail.m_171599_("Tail_r2", CubeListBuilder.m_171558_().m_171514_(106, 0).m_171488_(0.0f, -3.0f, -3.0f, 0.0f, 4.0f, 48.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)1.0f, (float)-3.0f, (float)5.0f, (float)0.0f, (float)0.0f, (float)0.2182f));
        PartDefinition arm_control = body_main.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)6.0f, (float)-7.0f));
        PartDefinition left_arm1 = arm_control.m_171599_("left_arm1", CubeListBuilder.m_171558_().m_171514_(0, 126).m_171488_(0.0f, -4.0f, -4.0f, 7.0f, 21.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(78, 140).m_171488_(7.0f, -4.0f, 4.0f, 0.0f, 16.0f, 3.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)6.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm2 = left_arm1.m_171599_("left_arm2", CubeListBuilder.m_171558_().m_171514_(68, 127).m_171488_(-4.5f, -2.0f, -7.5f, 9.0f, 4.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)3.5f, (float)15.0f, (float)0.5f));
        PartDefinition right_arm1 = arm_control.m_171599_("right_arm1", CubeListBuilder.m_171558_().m_171514_(78, 140).m_171480_().m_171488_(-7.0f, -4.0f, 4.0f, 0.0f, 16.0f, 3.0f, new CubeDeformation(0.0025f)).m_171555_(false).m_171514_(0, 126).m_171480_().m_171488_(-7.0f, -4.0f, -4.0f, 7.0f, 21.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-6.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm2 = right_arm1.m_171599_("right_arm2", CubeListBuilder.m_171558_().m_171514_(68, 127).m_171480_().m_171488_(-4.5f, -2.0f, -7.5f, 9.0f, 4.0f, 9.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-3.5f, (float)15.0f, (float)0.5f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)6.0f, (float)8.0f, (float)13.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(108, 76).m_171488_(0.0f, -9.0f, -10.0f, 7.0f, 16.0f, 14.0f, new CubeDeformation(0.0f)).m_171514_(68, 140).m_171488_(7.0f, -9.0f, 4.0f, 0.0f, 16.0f, 5.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(104, 127).m_171488_(-3.0f, 0.0f, -4.0f, 7.0f, 10.0f, 7.0f, new CubeDeformation(-0.1f)), PartPose.m_171419_((float)3.0f, (float)5.0f, (float)1.5f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(68, 127).m_171488_(-4.5f, -2.0f, -7.0f, 9.0f, 4.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.5f, (float)8.0f, (float)0.5f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(108, 76).m_171480_().m_171488_(-7.0f, -9.0f, -10.0f, 7.0f, 16.0f, 14.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(68, 140).m_171480_().m_171488_(-7.0f, -9.0f, 4.0f, 0.0f, 16.0f, 5.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-12.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(104, 127).m_171480_().m_171488_(-4.0f, 0.0f, -4.0f, 7.0f, 10.0f, 7.0f, new CubeDeformation(-0.1f)).m_171555_(false), PartPose.m_171419_((float)-3.0f, (float)5.0f, (float)1.5f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(68, 127).m_171480_().m_171488_(-4.5f, -2.0f, -7.0f, 9.0f, 4.0f, 9.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-0.5f, (float)8.0f, (float)0.5f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(@NotNull Barinasuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20069_()) {
            if (entity.isRunning() || entity.m_217005_() && entity.m_6688_().m_20142_()) {
                this.m_267799_(BarinasuchusAnimations.RUN, limbSwing, limbSwingAmount, 1.1f, 2.2f);
            } else {
                this.m_267799_(BarinasuchusAnimations.WALK, limbSwing, limbSwingAmount, 1.3f, 2.6f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, BarinasuchusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.swimAnimationState, BarinasuchusAnimations.SWIM, ageInTicks, 2.0f);
        this.animateSmooth(entity.attack1AnimationState, BarinasuchusAnimations.BITE_BLEND1, ageInTicks);
        this.animateSmooth(entity.attack2AnimationState, BarinasuchusAnimations.BITE_BLEND2, ageInTicks);
        this.animateSmooth(entity.sitStartAnimationState, BarinasuchusAnimations.SIT_START, ageInTicks);
        this.animateSmooth(entity.sitAnimationState, BarinasuchusAnimations.SIT, ageInTicks);
        this.animateSmooth(entity.sitEndAnimationState, BarinasuchusAnimations.SIT_END, ageInTicks);
        this.animateSmooth(entity.yawnAnimationState, BarinasuchusAnimations.YAWN_BLEND, ageInTicks);
        this.animateSmooth(entity.shakeAnimationState, BarinasuchusAnimations.SHAKE_BLEND, ageInTicks);
        this.animateSmooth(entity.threatenAnimationState, BarinasuchusAnimations.THREATEN, ageInTicks);
        this.animateSmooth(entity.eepyStartAnimationState, BarinasuchusAnimations.SLEEP_START, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, BarinasuchusAnimations.SLEEP, ageInTicks);
        this.animateSmooth(entity.eepyEndAnimationState, BarinasuchusAnimations.SLEEP_END, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(BarinasuchusAnimations.BABY_TRANSFORM);
        }
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
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

    public void translateRiderToBody(PoseStack poseStack) {
        this.root.m_104299_(poseStack);
        this.body_main.m_104299_(poseStack);
        this.body.m_104299_(poseStack);
    }
}


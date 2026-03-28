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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.UlughbegsaurusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Ulughbegsaurus;
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
public class UlughbegsaurusModel
extends UP2Model<Ulughbegsaurus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart upper_jaw;
    private final ModelPart brow;
    private final ModelPart crestdetail;
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

    public UlughbegsaurusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.neck = this.body.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.upper_jaw = this.head.m_171324_("upper_jaw");
        this.brow = this.upper_jaw.m_171324_("brow");
        this.crestdetail = this.brow.m_171324_("crestdetail");
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
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-5.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.5f, -12.0f, -22.0f, 17.0f, 19.0f, 32.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)0.0f));
        PartDefinition neck = body.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-3.5f, -20.9f, -8.0f, 7.0f, 28.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-5.1f, (float)-20.0f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.5f, (float)-15.4f, (float)-1.0f));
        PartDefinition upper_jaw = head.m_171599_("upper_jaw", CubeListBuilder.m_171558_().m_171514_(90, 55).m_171488_(-4.5f, -10.0f, -11.0f, 9.0f, 10.0f, 11.0f, new CubeDeformation(0.0f)).m_171514_(96, 2).m_171488_(-3.5f, -10.0f, -19.0f, 7.0f, 10.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-0.5f, (float)4.5f, (float)0.0f));
        PartDefinition brow = upper_jaw.m_171599_("brow", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-7.75f, (float)-3.0f));
        PartDefinition crestdetail = brow.m_171599_("crestdetail", CubeListBuilder.m_171558_().m_171514_(85, 77).m_171488_(-6.0f, 0.0f, -7.0f, 13.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(4, 110).m_171488_(-6.0f, -1.0f, -7.0f, 13.0f, 1.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-0.5f, (float)-0.25f, (float)3.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(90, 41).m_171488_(-5.0f, 0.0f, -11.0f, 9.0f, 2.0f, 11.0f, new CubeDeformation(0.0f)).m_171514_(96, 22).m_171488_(-4.0f, 0.0f, -19.0f, 7.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)4.5f, (float)0.0f));
        PartDefinition left_arm = body.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(0, 10).m_171488_(-4.0f, -3.0f, -4.0f, 5.0f, 14.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(0, 95).m_171488_(-2.0f, 11.0f, 2.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(0, 95).m_171488_(-2.0f, 11.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(0, 95).m_171488_(-2.0f, 11.0f, -4.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)9.5f, (float)4.0f, (float)-16.0f));
        PartDefinition right_arm = body.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 10).m_171480_().m_171488_(-1.0f, -3.0f, -4.0f, 5.0f, 14.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 95).m_171480_().m_171488_(-1.0f, 11.0f, -4.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 95).m_171480_().m_171488_(-1.0f, 11.0f, 2.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 95).m_171480_().m_171488_(-1.0f, 11.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-9.5f, (float)4.0f, (float)-16.0f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(56, 88).m_171488_(-4.5f, -5.5f, 0.0f, 9.0f, 11.0f, 22.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-6.5f, (float)10.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(15, 90).m_171488_(-2.5f, -3.5f, 0.0f, 5.0f, 7.0f, 31.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)22.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)0.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(46, 51).m_171488_(-4.0f, -5.0f, -6.0f, 8.0f, 16.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)8.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(66, 8).m_171488_(-3.0f, -3.0f, -3.0f, 6.0f, 18.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)8.0f, (float)6.0f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(6, 95).m_171488_(-4.0f, 0.0f, -7.0f, 8.0f, 3.0f, 12.0f, new CubeDeformation(0.0f)).m_171514_(39, 54).m_171488_(2.0f, 0.0f, -10.0f, 2.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(39, 54).m_171488_(-1.0f, 0.0f, -10.0f, 2.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(39, 54).m_171488_(-4.0f, 0.0f, -10.0f, 2.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)15.0f, (float)0.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(46, 51).m_171480_().m_171488_(-4.0f, -5.0f, -6.0f, 8.0f, 16.0f, 12.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-8.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(66, 8).m_171480_().m_171488_(-3.0f, -3.0f, -3.0f, 6.0f, 18.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)8.0f, (float)6.0f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(6, 95).m_171480_().m_171488_(-4.0f, 0.0f, -7.0f, 8.0f, 3.0f, 12.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(39, 54).m_171480_().m_171488_(2.0f, 0.0f, -10.0f, 2.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(39, 54).m_171480_().m_171488_(-4.0f, 0.0f, -10.0f, 2.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(39, 54).m_171480_().m_171488_(-1.0f, 0.0f, -10.0f, 2.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)15.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(@NotNull Ulughbegsaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!(entity.m_20072_() || entity.isSitting() || entity.isEepy() || entity.isLeaping())) {
            if (entity.isRunning() || entity.m_217005_() && entity.m_6688_().m_20142_()) {
                this.m_267799_(UlughbegsaurusAnimations.RUN, limbSwing, limbSwingAmount, 1.1f, 2.2f);
            } else {
                this.m_267799_(UlughbegsaurusAnimations.WALK, limbSwing, limbSwingAmount, entity.m_217005_() ? 2.0f : 1.5f, entity.m_217005_() ? 4.0f : 3.0f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, UlughbegsaurusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.swimAnimationState, UlughbegsaurusAnimations.SWIM, ageInTicks);
        this.animateSmooth(entity.attack1AnimationState, UlughbegsaurusAnimations.ATTACK_BLEND1, ageInTicks);
        this.animateSmooth(entity.attack2AnimationState, UlughbegsaurusAnimations.ATTACK_BLEND2, ageInTicks);
        this.animateSmooth(entity.sitAnimationState, UlughbegsaurusAnimations.SIT, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, UlughbegsaurusAnimations.SLEEP, ageInTicks);
        this.animateSmooth(entity.yawnAnimationState, UlughbegsaurusAnimations.YAWN_BLEND, ageInTicks);
        this.animateSmooth(entity.shakeAnimationState, UlughbegsaurusAnimations.SHAKE_BLEND, ageInTicks);
        this.animateSmooth(entity.jumpAnimationState, UlughbegsaurusAnimations.JUMP, ageInTicks);
        this.animateSmooth(entity.blinkAnimationState, UlughbegsaurusAnimations.BLINK_BLEND, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(UlughbegsaurusAnimations.BABY_TRANSFORM);
        }
        this.animateHead(entity, this.neck, netHeadYaw, headPitch);
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

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


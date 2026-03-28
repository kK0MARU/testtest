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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.PachycephalosaurusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Pachycephalosaurus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
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
public class PachycephalosaurusModel
extends UP2Model<Pachycephalosaurus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart snout;
    private final ModelPart jaw;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart tail;
    private final ModelPart leg_control;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart left_leg3;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;
    private final ModelPart right_leg3;

    public PachycephalosaurusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.neck = this.body.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.snout = this.head.m_171324_("snout");
        this.jaw = this.head.m_171324_("jaw");
        this.left_arm = this.body.m_171324_("left_arm");
        this.right_arm = this.body.m_171324_("right_arm");
        this.tail = this.body.m_171324_("tail");
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
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-14.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.5f, -5.0f, -6.0f, 9.0f, 10.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition neck = body.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(0, 43).m_171488_(-2.5f, -8.0f, -4.0f, 5.0f, 11.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-5.0f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(40, 22).m_171488_(-4.0f, -8.0f, -5.0f, 8.0f, 8.0f, 9.0f, new CubeDeformation(0.0f)).m_171514_(43, 0).m_171488_(-5.0f, -5.0f, -1.0f, 10.0f, 1.0f, 7.0f, new CubeDeformation(0.0f)).m_171514_(41, 39).m_171488_(-5.0f, -4.0f, -1.0f, 10.0f, 2.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-6.0f, (float)0.0f));
        PartDefinition snout = head.m_171599_("snout", CubeListBuilder.m_171558_().m_171514_(24, 54).m_171488_(-4.0f, -1.0f, -4.0f, 4.0f, 2.0f, 4.0f, new CubeDeformation(0.0025f)).m_171514_(32, 61).m_171488_(-3.0f, -2.0f, -4.0f, 2.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(58, 48).m_171488_(-4.0f, 0.0f, -4.0f, 4.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)2.0f, (float)-2.0f, (float)-5.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(24, 32).m_171488_(-2.0f, 0.0f, -4.0f, 4.0f, 2.0f, 4.0f, new CubeDeformation(0.0025f)).m_171514_(58, 53).m_171488_(-2.0f, 0.99f, -4.0f, 4.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)-5.0f));
        PartDefinition left_arm = body.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(58, 58).m_171488_(-0.5f, -1.5f, -1.5f, 2.0f, 6.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(0, 61).m_171488_(-0.5f, 4.5f, -1.5f, 2.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.5f, (float)2.5f, (float)-2.5f));
        PartDefinition right_arm = body.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(58, 58).m_171480_().m_171488_(-1.5f, -1.5f, -1.5f, 2.0f, 6.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 61).m_171480_().m_171488_(-1.5f, 4.5f, -1.5f, 2.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.5f, (float)2.5f, (float)-2.5f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(0, 22).m_171488_(-2.0f, -2.5f, 0.0f, 4.0f, 5.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)2.5f, (float)6.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)3.5f, (float)4.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(42, 8).m_171488_(-2.5f, -2.5f, -2.5f, 5.0f, 7.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(46, 48).m_171488_(-1.5f, -1.5f, -1.5f, 3.0f, 10.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)2.0f, (float)2.0f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(24, 48).m_171488_(-2.5f, -0.01f, -4.0f, 5.0f, 0.0f, 6.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)8.45f, (float)0.5f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(42, 8).m_171480_().m_171488_(-2.5f, -2.5f, -2.5f, 5.0f, 7.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(46, 48).m_171480_().m_171488_(-1.5f, -1.5f, -1.5f, 3.0f, 10.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)2.0f, (float)2.0f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(24, 48).m_171480_().m_171488_(-2.5f, -0.01f, -4.0f, 5.0f, 0.0f, 6.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)8.45f, (float)0.5f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(Pachycephalosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20072_() && !entity.isEepy() && entity.m_20089_() != UP2Poses.WARNING.get() && entity.m_20089_() != UP2Poses.RECOVERING.get()) {
            if (entity.isRunning() && entity.getAttackState() != 1) {
                this.m_267799_(PachycephalosaurusAnimations.RUN, limbSwing, limbSwingAmount, 1.25f, 2.5f);
            } else if (entity.getAttackState() == 1) {
                this.m_267799_(PachycephalosaurusAnimations.CHARGE, limbSwing, limbSwingAmount, 1.25f, 2.5f);
            } else {
                this.m_267799_(PachycephalosaurusAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, PachycephalosaurusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.recoverAnimationState, PachycephalosaurusAnimations.CHARGE_STUN, ageInTicks);
        this.animateSmooth(entity.warnAnimationState, PachycephalosaurusAnimations.WARN_BLEND, ageInTicks);
        this.animateSmooth(entity.huffAnimationState, PachycephalosaurusAnimations.HUFF_BLEND, ageInTicks);
        this.animateSmooth(entity.grazeAnimationState, PachycephalosaurusAnimations.GRAZE_BLEND, ageInTicks);
        this.animateSmooth(entity.swimAnimationState, PachycephalosaurusAnimations.SWIM, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, PachycephalosaurusAnimations.SLEEP, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(PachycephalosaurusAnimations.BABY_TRANSFORM);
        }
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


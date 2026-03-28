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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.KentrosaurusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Kentrosaurus;
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
public class KentrosaurusModel
extends UP2Model<Kentrosaurus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart left_neckplates;
    private final ModelPart right_neckplates;
    private final ModelPart left_shoulder;
    private final ModelPart right_shoulder;
    private final ModelPart left_backplates;
    private final ModelPart right_backplates;
    private final ModelPart left_thagomizer1;
    private final ModelPart right_thagomizer1;
    private final ModelPart tail1;
    private final ModelPart left_thagomizer2;
    private final ModelPart right_thagomizer2;
    private final ModelPart tail2;
    private final ModelPart left_thagomizer3;
    private final ModelPart left_thagomizer4;
    private final ModelPart left_thagomizer5;
    private final ModelPart left_thagomizer6;
    private final ModelPart right_thagomizer3;
    private final ModelPart right_thagomizer4;
    private final ModelPart right_thagomizer5;
    private final ModelPart right_thagomizer6;
    private final ModelPart arm_control;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart leg_control;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;

    public KentrosaurusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.left_neckplates = this.head.m_171324_("left_neckplates");
        this.right_neckplates = this.head.m_171324_("right_neckplates");
        this.left_shoulder = this.body.m_171324_("left_shoulder");
        this.right_shoulder = this.body.m_171324_("right_shoulder");
        this.left_backplates = this.body.m_171324_("left_backplates");
        this.right_backplates = this.body.m_171324_("right_backplates");
        this.left_thagomizer1 = this.body.m_171324_("left_thagomizer1");
        this.right_thagomizer1 = this.body.m_171324_("right_thagomizer1");
        this.tail1 = this.body.m_171324_("tail1");
        this.left_thagomizer2 = this.tail1.m_171324_("left_thagomizer2");
        this.right_thagomizer2 = this.tail1.m_171324_("right_thagomizer2");
        this.tail2 = this.tail1.m_171324_("tail2");
        this.left_thagomizer3 = this.tail2.m_171324_("left_thagomizer3");
        this.left_thagomizer4 = this.tail2.m_171324_("left_thagomizer4");
        this.left_thagomizer5 = this.tail2.m_171324_("left_thagomizer5");
        this.left_thagomizer6 = this.tail2.m_171324_("left_thagomizer6");
        this.right_thagomizer3 = this.tail2.m_171324_("right_thagomizer3");
        this.right_thagomizer4 = this.tail2.m_171324_("right_thagomizer4");
        this.right_thagomizer5 = this.tail2.m_171324_("right_thagomizer5");
        this.right_thagomizer6 = this.tail2.m_171324_("right_thagomizer6");
        this.arm_control = this.body_main.m_171324_("arm_control");
        this.left_arm = this.arm_control.m_171324_("left_arm");
        this.right_arm = this.arm_control.m_171324_("right_arm");
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
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-19.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-9.5f, -18.0f, -16.0f, 19.0f, 27.0f, 33.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(83, 122).m_171488_(-1.5f, 0.0f, -11.0f, 3.0f, 2.0f, 11.0f, new CubeDeformation(0.0f)).m_171514_(46, 119).m_171488_(-2.5f, -5.0f, -9.0f, 5.0f, 5.0f, 12.0f, new CubeDeformation(0.0f)).m_171514_(126, 84).m_171488_(-2.5f, -5.0f, -15.0f, 5.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(45, 113).m_171488_(-2.5f, -2.0f, -13.0f, 5.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)7.0f, (float)-16.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(125, 107).m_171488_(-2.5f, 0.0f, -4.0f, 5.0f, 2.0f, 4.0f, new CubeDeformation(0.01f)).m_171514_(115, 107).m_171488_(-2.5f, 1.0f, -6.0f, 5.0f, 1.0f, 2.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)-9.0f));
        PartDefinition left_neckplates = head.m_171599_("left_neckplates", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)1.5f, (float)-5.1f, (float)-4.0f));
        PartDefinition plates_r1 = left_neckplates.m_171599_("plates_r1", CubeListBuilder.m_171558_().m_171514_(126, 95).m_171488_(1.0f, -5.0f, -1.0f, 0.0f, 5.0f, 7.0f, new CubeDeformation(0.025f)), PartPose.m_171423_((float)-0.9653f, (float)-0.197f, (float)-3.0f, (float)0.0f, (float)0.0f, (float)0.1745f));
        PartDefinition right_neckplates = head.m_171599_("right_neckplates", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)-1.5f, (float)-5.1f, (float)-4.0f));
        PartDefinition plates_r2 = right_neckplates.m_171599_("plates_r2", CubeListBuilder.m_171558_().m_171514_(126, 95).m_171480_().m_171488_(-1.0f, -5.0f, -1.0f, 0.0f, 5.0f, 7.0f, new CubeDeformation(0.025f)).m_171555_(false), PartPose.m_171423_((float)0.9653f, (float)-0.197f, (float)-3.0f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition left_shoulder = body.m_171599_("left_shoulder", CubeListBuilder.m_171558_().m_171514_(0, 145).m_171488_(-2.0f, -1.0f, -1.5f, 21.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(57, 145).m_171488_(16.0f, -1.0f, 1.5f, 3.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)8.5f, (float)3.0f, (float)-10.5f, (float)-0.0873f, (float)-0.3491f, (float)-0.6109f));
        PartDefinition right_shoulder = body.m_171599_("right_shoulder", CubeListBuilder.m_171558_().m_171514_(57, 145).m_171480_().m_171488_(-19.0f, -1.0f, 1.5f, 3.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 145).m_171480_().m_171488_(-19.0f, -1.0f, -1.5f, 21.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-8.5f, (float)3.0f, (float)-10.5f, (float)-0.0873f, (float)0.3491f, (float)0.6109f));
        PartDefinition left_backplates = body.m_171599_("left_backplates", CubeListBuilder.m_171558_().m_171514_(72, 84).m_171488_(0.0f, -9.0f, -14.0f, 0.0f, 9.0f, 26.0f, new CubeDeformation(0.025f)), PartPose.m_171423_((float)4.5f, (float)-18.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.2618f));
        PartDefinition right_backplates = body.m_171599_("right_backplates", CubeListBuilder.m_171558_().m_171514_(72, 84).m_171480_().m_171488_(0.0f, -9.0f, -14.0f, 0.0f, 9.0f, 26.0f, new CubeDeformation(0.025f)).m_171555_(false), PartPose.m_171423_((float)-4.5f, (float)-18.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2618f));
        PartDefinition left_thagomizer1 = body.m_171599_("left_thagomizer1", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)), PartPose.m_171423_((float)2.5f, (float)-16.0f, (float)16.0f, (float)0.0f, (float)0.0f, (float)0.1745f));
        PartDefinition right_thagomizer1 = body.m_171599_("right_thagomizer1", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171480_().m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)).m_171555_(false), PartPose.m_171423_((float)-2.5f, (float)-16.0f, (float)16.0f, (float)0.0f, (float)0.0f, (float)-0.1745f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(104, 26).m_171488_(-4.5f, -2.5f, 0.0f, 9.0f, 9.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-13.5f, (float)17.0f));
        PartDefinition left_thagomizer2 = tail1.m_171599_("left_thagomizer2", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)), PartPose.m_171423_((float)1.5f, (float)-1.5f, (float)5.0f, (float)0.0f, (float)0.0f, (float)0.48f));
        PartDefinition right_thagomizer2 = tail1.m_171599_("right_thagomizer2", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171480_().m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)).m_171555_(false), PartPose.m_171423_((float)-1.5f, (float)-1.5f, (float)5.0f, (float)0.0f, (float)0.0f, (float)-0.48f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(0, 60).m_171488_(-2.5f, -2.5f, 0.0f, 5.0f, 5.0f, 31.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)12.0f));
        PartDefinition left_thagomizer3 = tail2.m_171599_("left_thagomizer3", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)), PartPose.m_171423_((float)2.0f, (float)-1.75f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.6109f));
        PartDefinition left_thagomizer4 = tail2.m_171599_("left_thagomizer4", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)), PartPose.m_171423_((float)2.0f, (float)-1.75f, (float)10.0f, (float)0.0f, (float)0.0f, (float)0.829f));
        PartDefinition left_thagomizer5 = tail2.m_171599_("left_thagomizer5", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)), PartPose.m_171423_((float)2.0f, (float)-2.0f, (float)19.0f, (float)0.0f, (float)0.0f, (float)1.0472f));
        PartDefinition left_thagomizer6 = tail2.m_171599_("left_thagomizer6", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)), PartPose.m_171423_((float)2.0f, (float)-2.0f, (float)27.0f, (float)0.0f, (float)0.0f, (float)1.2654f));
        PartDefinition right_thagomizer3 = tail2.m_171599_("right_thagomizer3", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171480_().m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)).m_171555_(false), PartPose.m_171423_((float)-2.0f, (float)-1.75f, (float)2.0f, (float)0.0f, (float)0.0f, (float)-0.6109f));
        PartDefinition right_thagomizer4 = tail2.m_171599_("right_thagomizer4", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171480_().m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)).m_171555_(false), PartPose.m_171423_((float)-2.0f, (float)-1.75f, (float)10.0f, (float)0.0f, (float)0.0f, (float)-0.829f));
        PartDefinition right_thagomizer5 = tail2.m_171599_("right_thagomizer5", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171480_().m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)).m_171555_(false), PartPose.m_171423_((float)-2.0f, (float)-2.0f, (float)19.0f, (float)0.0f, (float)0.0f, (float)-1.0472f));
        PartDefinition right_thagomizer6 = tail2.m_171599_("right_thagomizer6", CubeListBuilder.m_171558_().m_171514_(0, 96).m_171480_().m_171488_(0.0f, -13.0f, -1.0f, 0.0f, 14.0f, 22.0f, new CubeDeformation(0.025f)).m_171555_(false), PartPose.m_171423_((float)-2.0f, (float)-2.0f, (float)27.0f, (float)0.0f, (float)0.0f, (float)-1.2654f));
        PartDefinition arm_control = body_main.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)5.5f, (float)9.0f, (float)-10.5f));
        PartDefinition left_arm = arm_control.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(50, 68).m_171488_(-3.0f, -2.0f, -3.5f, 6.0f, 12.0f, 7.0f, new CubeDeformation(0.0f)).m_171514_(122, 56).m_171488_(-3.0f, 8.0f, -5.5f, 6.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm = arm_control.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(50, 68).m_171480_().m_171488_(-3.0f, -2.0f, -3.5f, 6.0f, 12.0f, 7.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(122, 56).m_171480_().m_171488_(-3.0f, 8.0f, -5.5f, 6.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-11.0f, (float)0.0f, (float)0.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)8.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(104, 0).m_171488_(-5.0f, -6.0f, -7.0f, 9.0f, 14.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)9.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(114, 119).m_171488_(-3.5f, -3.0f, -5.0f, 7.0f, 16.0f, 7.0f, new CubeDeformation(0.0f)).m_171514_(104, 56).m_171488_(-3.5f, 11.0f, -7.0f, 7.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-0.5f, (float)6.0f, (float)5.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(104, 0).m_171480_().m_171488_(-4.0f, -6.0f, -7.0f, 9.0f, 14.0f, 12.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-9.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(114, 119).m_171480_().m_171488_(-3.5f, -3.0f, -5.0f, 7.0f, 16.0f, 7.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(104, 56).m_171480_().m_171488_(-3.5f, 11.0f, -7.0f, 7.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.5f, (float)6.0f, (float)5.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Kentrosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20069_() && !entity.isEepy()) {
            if (entity.isRunning()) {
                this.m_267799_(KentrosaurusAnimations.RUN, limbSwing, limbSwingAmount, 1.0f, 2.0f);
            } else {
                this.m_267799_(KentrosaurusAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, KentrosaurusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.attack1AnimationState, KentrosaurusAnimations.ATTACK1, ageInTicks);
        this.animateSmooth(entity.attack2AnimationState, KentrosaurusAnimations.ATTACK2, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, KentrosaurusAnimations.SIT, ageInTicks);
        this.animateSmooth(entity.grazeAnimationState, KentrosaurusAnimations.GRAZE_BLEND, ageInTicks);
        this.animateSmooth(entity.shakeAnimationState, KentrosaurusAnimations.SHAKE_BLEND, ageInTicks);
        this.animateSmooth(entity.stretch1AnimationState, KentrosaurusAnimations.STRETCH_IDLE_BLEND1, ageInTicks);
        this.animateSmooth(entity.stretch2AnimationState, KentrosaurusAnimations.STRETCH_IDLE_BLEND2, ageInTicks);
        this.animateSmooth(entity.yawnAnimationState, KentrosaurusAnimations.YAWN_IDLE_BLEND, ageInTicks);
        this.animateSmooth(entity.swimAnimationState, KentrosaurusAnimations.SWIM, ageInTicks);
        this.animateSmooth(entity.angryAnimationState, KentrosaurusAnimations.AGGRO_BLEND, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(KentrosaurusAnimations.BABY_TRANSFORM);
        }
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


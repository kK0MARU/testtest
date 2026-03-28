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
package com.barlinc.unusual_prehistory.client.models.entity.mob.future;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.TherizinosaurusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Therizinosaurus;
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
public class TherizinosaurusModel
extends UP2Model<Therizinosaurus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart body_adjust;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart hair;
    private final ModelPart left_arm;
    private final ModelPart left_claw1;
    private final ModelPart left_claw2;
    private final ModelPart left_claw3;
    private final ModelPart right_arm;
    private final ModelPart right_claw1;
    private final ModelPart right_claw2;
    private final ModelPart right_claw3;
    private final ModelPart tail;
    private final ModelPart tail_adjust;
    private final ModelPart tail_poof;
    private final ModelPart leg_control;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart left_leg3;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;
    private final ModelPart right_leg3;

    public TherizinosaurusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.body_adjust = this.body.m_171324_("body_adjust");
        this.neck = this.body_adjust.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.hair = this.head.m_171324_("hair");
        this.left_arm = this.body_adjust.m_171324_("left_arm");
        this.left_claw1 = this.left_arm.m_171324_("left_claw1");
        this.left_claw2 = this.left_arm.m_171324_("left_claw2");
        this.left_claw3 = this.left_arm.m_171324_("left_claw3");
        this.right_arm = this.body_adjust.m_171324_("right_arm");
        this.right_claw1 = this.right_arm.m_171324_("right_claw1");
        this.right_claw2 = this.right_arm.m_171324_("right_claw2");
        this.right_claw3 = this.right_arm.m_171324_("right_claw3");
        this.tail = this.body_adjust.m_171324_("tail");
        this.tail_adjust = this.tail.m_171324_("tail_adjust");
        this.tail_poof = this.tail_adjust.m_171324_("tail_poof");
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
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)16.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-37.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body_adjust = body.m_171599_("body_adjust", CubeListBuilder.m_171558_(), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.6109f, (float)0.0f, (float)0.0f));
        PartDefinition feathers_r1 = body_adjust.m_171599_("feathers_r1", CubeListBuilder.m_171558_().m_171514_(176, 94).m_171488_(-14.5f, 16.0f, -36.0f, 29.0f, 4.0f, 44.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)-5.0f, (float)1.0f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition Torso_r1 = body_adjust.m_171599_("Torso_r1", CubeListBuilder.m_171558_().m_171514_(9, 95).m_171488_(-14.5f, -16.0f, -36.0f, 29.0f, 31.0f, 45.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)-5.0f, (float)0.0f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition neck = body_adjust.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(5, 179).m_171488_(-8.5f, -16.0f, -11.0f, 17.0f, 28.0f, 22.0f, new CubeDeformation(0.01f)).m_171514_(141, 206).m_171488_(-4.5f, -45.0f, -1.0f, 9.0f, 29.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-41.0f, (float)1.0f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(187, 55).m_171488_(-3.0f, -5.0f, -17.0f, 6.0f, 7.0f, 17.0f, new CubeDeformation(0.0f)).m_171514_(183, 79).m_171488_(-3.0f, 2.0f, -17.0f, 6.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-40.0f, (float)-1.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(243, 56).m_171488_(-2.0f, 0.0f, -13.0f, 5.0f, 3.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-0.5f, (float)2.0f, (float)-2.0f));
        PartDefinition hair = head.m_171599_("hair", CubeListBuilder.m_171558_().m_171514_(241, 204).m_171488_(-5.0f, 0.0f, -5.5f, 10.0f, 14.0f, 11.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)-5.0f, (float)-4.5f));
        PartDefinition left_arm = body_adjust.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(240, 229).m_171488_(0.0f, -4.0f, -4.0f, 6.0f, 8.0f, 12.0f, new CubeDeformation(0.0f)).m_171514_(62, 229).m_171488_(0.0f, -4.0f, 8.0f, 6.0f, 26.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(90, 175).m_171488_(5.99f, -9.0f, -4.0f, 0.0f, 27.0f, 24.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)14.5f, (float)-35.0f, (float)-9.0f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition left_claw1 = left_arm.m_171599_("left_claw1", CubeListBuilder.m_171558_().m_171514_(188, 244).m_171488_(-2.0f, 0.0f, -1.0f, 4.0f, 35.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(138, 199).m_171488_(-5.0f, 33.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)4.0f, (float)22.0f, (float)9.0f, (float)-0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition left_claw2 = left_arm.m_171599_("left_claw2", CubeListBuilder.m_171558_().m_171514_(188, 244).m_171488_(-2.0f, 0.0f, -1.0f, 4.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(138, 199).m_171488_(-5.0f, 35.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)4.0f, (float)22.0f, (float)12.0f, (float)0.0f, (float)0.0f, (float)-0.0873f));
        PartDefinition left_claw3 = left_arm.m_171599_("left_claw3", CubeListBuilder.m_171558_().m_171514_(188, 244).m_171488_(-2.0f, 0.0f, -1.0f, 4.0f, 35.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(138, 199).m_171488_(-5.0f, 33.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)4.0f, (float)22.0f, (float)15.0f, (float)0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm = body_adjust.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(240, 229).m_171480_().m_171488_(-6.0f, -4.0f, -4.0f, 6.0f, 8.0f, 12.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(62, 229).m_171480_().m_171488_(-6.0f, -4.0f, 8.0f, 6.0f, 26.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(90, 175).m_171480_().m_171488_(-5.99f, -9.0f, -4.0f, 0.0f, 27.0f, 24.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-14.5f, (float)-35.0f, (float)-9.0f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition right_claw1 = right_arm.m_171599_("right_claw1", CubeListBuilder.m_171558_().m_171514_(188, 244).m_171480_().m_171488_(-2.0f, 0.0f, -1.0f, 4.0f, 35.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(138, 199).m_171480_().m_171488_(2.0f, 33.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-4.0f, (float)22.0f, (float)9.0f, (float)-0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition right_claw2 = right_arm.m_171599_("right_claw2", CubeListBuilder.m_171558_().m_171514_(188, 244).m_171480_().m_171488_(-2.0f, 0.0f, -1.0f, 4.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(138, 199).m_171480_().m_171488_(2.0f, 35.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-4.0f, (float)22.0f, (float)12.0f, (float)0.0f, (float)0.0f, (float)0.0873f));
        PartDefinition right_claw3 = right_arm.m_171599_("right_claw3", CubeListBuilder.m_171558_().m_171514_(188, 244).m_171480_().m_171488_(-2.0f, 0.0f, -1.0f, 4.0f, 35.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(138, 199).m_171480_().m_171488_(2.0f, 33.0f, -1.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-4.0f, (float)22.0f, (float)15.0f, (float)0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition tail = body_adjust.m_171599_("tail", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)3.5f, (float)16.0f));
        PartDefinition tail_adjust = tail.m_171599_("tail_adjust", CubeListBuilder.m_171558_().m_171514_(164, 142).m_171488_(-4.5f, -5.4f, -4.0f, 9.0f, 11.0f, 51.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.4363f, (float)0.0f, (float)0.0f));
        PartDefinition tail_poof = tail_adjust.m_171599_("tail_poof", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-22.5f, 0.0f, -23.0f, 45.0f, 40.0f, 46.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-5.5f, (float)27.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(183, 0).m_171488_(-7.0f, -9.0f, -12.0f, 14.0f, 24.0f, 24.0f, new CubeDeformation(0.0f)).m_171514_(188, 204).m_171488_(6.99f, 5.0f, -12.0f, 0.0f, 14.0f, 26.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)12.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(90, 226).m_171488_(-5.0f, -5.0f, -5.0f, 10.0f, 27.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)13.0f, (float)12.0f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(0, 229).m_171488_(-7.0f, 0.0f, -9.0f, 14.0f, 4.0f, 17.0f, new CubeDeformation(0.0f)).m_171514_(138, 188).m_171488_(3.0f, 0.0f, -15.0f, 4.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(132, 179).m_171488_(3.0f, 3.0f, -15.0f, 4.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(132, 179).m_171488_(-7.0f, 3.0f, -15.0f, 4.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(138, 188).m_171488_(-7.0f, 0.0f, -15.0f, 4.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(138, 175).m_171488_(-2.0f, 0.0f, -17.0f, 4.0f, 3.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(131, 175).m_171488_(-2.0f, 3.0f, -17.0f, 4.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)20.0f, (float)0.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(183, 0).m_171480_().m_171488_(-7.0f, -9.0f, -12.0f, 14.0f, 24.0f, 24.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(188, 204).m_171480_().m_171488_(-6.99f, 5.0f, -12.0f, 0.0f, 14.0f, 26.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-12.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(90, 226).m_171480_().m_171488_(-5.0f, -5.0f, -5.0f, 10.0f, 27.0f, 10.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)13.0f, (float)12.0f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(0, 229).m_171480_().m_171488_(-7.0f, 0.0f, -9.0f, 14.0f, 4.0f, 17.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(138, 188).m_171480_().m_171488_(-7.0f, 0.0f, -15.0f, 4.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(132, 179).m_171480_().m_171488_(-7.0f, 3.0f, -15.0f, 4.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(132, 179).m_171480_().m_171488_(3.0f, 3.0f, -15.0f, 4.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(138, 188).m_171480_().m_171488_(3.0f, 0.0f, -15.0f, 4.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(138, 175).m_171480_().m_171488_(-2.0f, 0.0f, -17.0f, 4.0f, 3.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(131, 175).m_171480_().m_171488_(-2.0f, 3.0f, -17.0f, 4.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)20.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)512, (int)512);
    }

    public void setupAnim(Therizinosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20069_() && !entity.isEepy() && entity.m_20089_() != UP2Poses.ATTACKING.get()) {
            if (entity.isRunning()) {
                this.m_267799_(TherizinosaurusAnimations.RUN, limbSwing, limbSwingAmount, 1.15f, 2.3f);
            } else {
                this.m_267799_(entity.isShaved() ? TherizinosaurusAnimations.WALK : TherizinosaurusAnimations.WALK_UNSHAVED, limbSwing, limbSwingAmount, 1.6f, 3.2f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, TherizinosaurusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.swimAnimationState, TherizinosaurusAnimations.SWIM, ageInTicks);
        this.animateSmooth(entity.attack1AnimationState, TherizinosaurusAnimations.SLASH1, ageInTicks);
        this.animateSmooth(entity.attack2AnimationState, TherizinosaurusAnimations.SLASH2, ageInTicks);
        this.animateSmooth(entity.forageLowAnimationState, TherizinosaurusAnimations.GRAZE_LOW, ageInTicks);
        this.animateSmooth(entity.forageHighAnimationState, TherizinosaurusAnimations.GRAZE_HIGH, ageInTicks);
        this.animateSmooth(entity.shakeAnimationState, TherizinosaurusAnimations.IDLE_SHAKE_BLEND, ageInTicks);
        this.animateSmooth(entity.stretchAnimationState, TherizinosaurusAnimations.IDLE_STRETCH_BLEND, ageInTicks);
        this.animateSmooth(entity.alert1AnimationState, TherizinosaurusAnimations.ALERT_LEFT_BLEND, ageInTicks);
        this.animateSmooth(entity.alert2AnimationState, TherizinosaurusAnimations.ALERT_RIGHT_BLEND, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, TherizinosaurusAnimations.SIT, ageInTicks);
        this.animateSmooth(entity.roarAnimationState, TherizinosaurusAnimations.AGGRO_ROAR_BLEND, ageInTicks);
        this.animateSmooth(entity.angryAnimationState, TherizinosaurusAnimations.AGGRO_BLEND, ageInTicks);
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


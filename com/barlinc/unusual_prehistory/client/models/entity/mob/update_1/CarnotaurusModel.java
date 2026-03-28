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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.CarnotaurusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Carnotaurus;
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
public class CarnotaurusModel
extends UP2Model<Carnotaurus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart breathing;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart upper_jaw;
    private final ModelPart left_horn;
    private final ModelPart right_horn;
    private final ModelPart jaw;
    private final ModelPart dewlap;
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

    public CarnotaurusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.breathing = this.body.m_171324_("breathing");
        this.neck = this.body.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.upper_jaw = this.head.m_171324_("upper_jaw");
        this.left_horn = this.upper_jaw.m_171324_("left_horn");
        this.right_horn = this.upper_jaw.m_171324_("right_horn");
        this.jaw = this.head.m_171324_("jaw");
        this.dewlap = this.jaw.m_171324_("dewlap");
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
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-27.0f, (float)6.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition breathing = body.m_171599_("breathing", CubeListBuilder.m_171558_().m_171514_(127, 130).m_171488_(-2.5f, -13.0f, -1.0f, 5.0f, 2.0f, 16.0f, new CubeDeformation(0.0f)).m_171514_(0, 0).m_171488_(-8.5f, -12.0f, -16.0f, 17.0f, 24.0f, 32.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-6.0f, (float)-6.0f));
        PartDefinition neck = body.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(74, 90).m_171488_(-3.5f, -19.0f, -10.0f, 7.0f, 24.0f, 19.0f, new CubeDeformation(0.0f)).m_171514_(126, 90).m_171488_(-2.5f, -21.0f, -4.0f, 5.0f, 25.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-14.0f, (float)-18.0f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-12.6f, (float)-5.1f));
        PartDefinition upper_jaw = head.m_171599_("upper_jaw", CubeListBuilder.m_171558_().m_171514_(150, 11).m_171488_(-4.5f, -8.91f, -3.9f, 9.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(146, 36).m_171488_(-4.5f, -8.91f, -12.9f, 9.0f, 11.0f, 9.0f, new CubeDeformation(0.0f)).m_171514_(185, 25).m_171488_(-4.5f, 2.09f, -12.9f, 9.0f, 1.0f, 9.0f, new CubeDeformation(0.0f)).m_171514_(150, 24).m_171488_(-3.5f, 2.09f, -11.9f, 7.0f, 1.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)2.5f, (float)0.0f));
        PartDefinition left_horn = upper_jaw.m_171599_("left_horn", CubeListBuilder.m_171558_().m_171514_(88, 133).m_171488_(-2.0f, -2.92f, -12.0f, 4.0f, 6.0f, 15.0f, new CubeDeformation(0.0f)).m_171514_(30, 152).m_171488_(-2.0f, -6.91f, -12.0f, 4.0f, 4.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(58, 110).m_171488_(-2.0f, -6.91f, -7.0f, 4.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)4.5f, (float)-6.0f, (float)-3.9f, (float)0.0f, (float)-0.0873f, (float)0.0873f));
        PartDefinition right_horn = upper_jaw.m_171599_("right_horn", CubeListBuilder.m_171558_().m_171514_(88, 133).m_171480_().m_171488_(-2.0f, -2.92f, -12.0f, 4.0f, 6.0f, 15.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(30, 152).m_171480_().m_171488_(-2.0f, -6.91f, -12.0f, 4.0f, 4.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(58, 110).m_171480_().m_171488_(-2.0f, -6.91f, -7.0f, 4.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-4.5f, (float)-6.0f, (float)-3.9f, (float)0.0f, (float)0.0873f, (float)-0.0873f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(0, 152).m_171488_(-3.5f, 1.09f, -11.9f, 7.0f, 1.0f, 8.0f, new CubeDeformation(-0.01f)).m_171514_(148, 82).m_171488_(-4.5f, 0.09f, -3.9f, 9.0f, 4.0f, 4.0f, new CubeDeformation(-0.01f)).m_171514_(150, 0).m_171488_(-4.5f, 2.09f, -12.9f, 9.0f, 2.0f, 9.0f, new CubeDeformation(-0.01f)), PartPose.m_171419_((float)0.0f, (float)2.5f, (float)0.0f));
        PartDefinition dewlap = jaw.m_171599_("dewlap", CubeListBuilder.m_171558_().m_171514_(126, 148).m_171488_(-1.0f, 0.0f, -4.0f, 2.0f, 10.0f, 12.0f, new CubeDeformation(-0.01f)).m_171514_(148, 56).m_171488_(0.0f, 0.0f, -7.0f, 0.0f, 11.0f, 15.0f, new CubeDeformation(-0.01f)), PartPose.m_171419_((float)0.0f, (float)4.0f, (float)-4.9f));
        PartDefinition left_arm = body.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(58, 98).m_171488_(-1.5f, 0.0f, -1.0f, 2.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(58, 119).m_171488_(-1.5f, 4.0f, -1.0f, 2.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)8.51f, (float)3.0f, (float)-15.0f));
        PartDefinition right_arm = body.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(58, 98).m_171480_().m_171488_(-0.5f, 0.0f, -1.0f, 2.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(58, 119).m_171480_().m_171488_(-0.5f, 4.0f, -1.0f, 2.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-8.51f, (float)3.0f, (float)-15.0f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(0, 98).m_171488_(-4.5f, -5.0f, 0.0f, 9.0f, 12.0f, 20.0f, new CubeDeformation(0.0f)).m_171514_(1, 130).m_171488_(-2.5f, -7.0f, 0.0f, 5.0f, 2.0f, 20.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-11.0f, (float)10.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(0, 56).m_171488_(-2.5f, -5.0f, 0.0f, 5.0f, 10.0f, 32.0f, new CubeDeformation(0.0f)).m_171514_(74, 56).m_171488_(-2.5f, -7.0f, 0.0f, 5.0f, 2.0f, 32.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)20.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)7.5f, (float)3.0f, (float)0.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(98, 0).m_171488_(-5.0f, -11.0f, -8.0f, 10.0f, 20.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(54, 133).m_171488_(-3.5f, -2.0f, -4.0f, 7.0f, 17.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-0.5f, (float)7.0f, (float)6.0f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(98, 36).m_171488_(-4.5f, 0.0f, -8.0f, 9.0f, 2.0f, 15.0f, new CubeDeformation(0.0f)).m_171514_(58, 114).m_171488_(2.5f, 0.0f, -11.0f, 2.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(58, 114).m_171488_(-4.5f, 0.0f, -11.0f, 2.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(58, 105).m_171488_(-1.5f, 0.0f, -11.0f, 3.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(58, 123).m_171488_(-1.5f, 0.0f, 7.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)15.0f, (float)1.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(98, 0).m_171480_().m_171488_(-5.0f, -11.0f, -8.0f, 10.0f, 20.0f, 16.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-15.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(54, 133).m_171480_().m_171488_(-3.5f, -2.0f, -4.0f, 7.0f, 17.0f, 10.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.5f, (float)7.0f, (float)6.0f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(98, 36).m_171480_().m_171488_(-4.5f, 0.0f, -8.0f, 9.0f, 2.0f, 15.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(58, 114).m_171480_().m_171488_(-4.5f, 0.0f, -11.0f, 2.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(58, 114).m_171480_().m_171488_(2.5f, 0.0f, -11.0f, 2.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(58, 105).m_171480_().m_171488_(-1.5f, 0.0f, -11.0f, 3.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(58, 123).m_171480_().m_171488_(-1.5f, 0.0f, 7.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)15.0f, (float)1.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Carnotaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20069_() && !entity.isEepy()) {
            if (entity.m_20089_() != UP2Poses.CHARGING.get()) {
                if (entity.isRunning()) {
                    this.m_267799_(CarnotaurusAnimations.RUN, limbSwing, limbSwingAmount, 1.3f, 2.6f);
                } else {
                    this.m_267799_(CarnotaurusAnimations.WALK, limbSwing, limbSwingAmount, 4.0f, 8.0f);
                }
            } else {
                this.m_267799_(CarnotaurusAnimations.CHARGE, limbSwing, limbSwingAmount, 1.2f, 2.4f);
            }
        }
        if (this.f_102610_) {
            this.m_288214_(CarnotaurusAnimations.BABY_TRANSFORM);
        }
        this.animateIdleSmooth(entity.idleAnimationState, CarnotaurusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.attack1AnimationState, CarnotaurusAnimations.BITE_BLEND1, ageInTicks);
        this.animateSmooth(entity.attack2AnimationState, CarnotaurusAnimations.BITE_BLEND2, ageInTicks);
        this.animateSmooth(entity.headbuttAnimationState, CarnotaurusAnimations.HEADBUTT_BLEND, ageInTicks);
        this.animateSmooth(entity.attackFast1AnimationState, CarnotaurusAnimations.BITE_FAST_BLEND1, ageInTicks);
        this.animateSmooth(entity.attackFast2AnimationState, CarnotaurusAnimations.BITE_FAST_BLEND2, ageInTicks);
        this.animateSmooth(entity.headbuttFastAnimationState, CarnotaurusAnimations.HEADBUTT_FAST_BLEND, ageInTicks);
        this.animateSmooth(entity.chargeStartAnimationState, CarnotaurusAnimations.CHARGE_START, ageInTicks);
        this.animateSmooth(entity.chargeEndAnimationState, CarnotaurusAnimations.CHARGE_END, ageInTicks);
        this.animateSmooth(entity.roarAnimationState, CarnotaurusAnimations.AGGRO_ROAR_BLEND, ageInTicks);
        this.animateSmooth(entity.angryAnimationState, CarnotaurusAnimations.AGGRO_BLEND, ageInTicks);
        this.animateSmooth(entity.swimAnimationState, CarnotaurusAnimations.SWIM, ageInTicks);
        this.animateSmooth(entity.sniff1AnimationState, CarnotaurusAnimations.SNIFF_BLEND1, ageInTicks);
        this.animateSmooth(entity.sniff2AnimationState, CarnotaurusAnimations.SNIFF_BLEND2, ageInTicks);
        this.animateSmooth(entity.yawnAnimationState, CarnotaurusAnimations.YAWN_BLEND, ageInTicks);
        this.animateSmooth(entity.shakeAnimationState, CarnotaurusAnimations.SHAKE_BLEND, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, CarnotaurusAnimations.SLEEP, ageInTicks);
        this.animateHead(entity, this.neck, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


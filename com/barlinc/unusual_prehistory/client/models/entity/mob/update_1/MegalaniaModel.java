/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.animation.AnimationDefinition
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.util.Mth
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_1;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.MegalaniaAnimations;
import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.MegalaniaIdleAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Megalania;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class MegalaniaModel
extends UP2Model<Megalania> {
    public final ModelPart root;
    public final ModelPart body_main;
    public final ModelPart body_upper;
    public final ModelPart body;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart tongue;
    private final ModelPart tail1_rot;
    private final ModelPart tail1;
    private final ModelPart tail2_rot;
    private final ModelPart tail2;
    private final ModelPart tail3_rot;
    private final ModelPart tail3;
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

    public MegalaniaModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body_upper = this.body_main.m_171324_("body_upper");
        this.body = this.body_upper.m_171324_("body");
        this.neck = this.body.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.tongue = this.jaw.m_171324_("tongue");
        this.tail1_rot = this.body.m_171324_("tail1_rot");
        this.tail1 = this.tail1_rot.m_171324_("tail1");
        this.tail2_rot = this.tail1.m_171324_("tail2_rot");
        this.tail2 = this.tail2_rot.m_171324_("tail2");
        this.tail3_rot = this.tail2.m_171324_("tail3_rot");
        this.tail3 = this.tail3_rot.m_171324_("tail3");
        this.arm_control = this.body_upper.m_171324_("arm_control");
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
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-13.5f, (float)0.0f));
        PartDefinition body_upper = body_main.m_171599_("body_upper", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)3.5f, (float)9.5f));
        PartDefinition body = body_upper.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-9.5f, -7.5f, -15.5f, 19.0f, 15.0f, 31.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-3.5f, (float)-9.5f));
        PartDefinition neck = body.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(89, 46).m_171488_(-3.0f, 0.0f, -13.0f, 6.0f, 11.0f, 13.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-6.5f, (float)-15.5f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(90, 111).m_171488_(-3.5f, 0.0f, -16.0f, 7.0f, 3.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(88, 70).m_171488_(-4.5f, 0.0f, -8.0f, 9.0f, 3.0f, 8.0f, new CubeDeformation(0.01f)).m_171514_(102, 96).m_171488_(-2.5f, 2.5f, -15.0f, 5.0f, 1.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(28, 114).m_171488_(-4.5f, 3.0f, -4.0f, 9.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-5.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(60, 111).m_171488_(-3.5f, 0.0f, -12.0f, 7.0f, 4.0f, 8.0f, new CubeDeformation(0.01f)).m_171514_(112, 114).m_171488_(-2.5f, -0.5f, -11.0f, 5.0f, 1.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(116, 81).m_171488_(-4.5f, 0.0f, -4.0f, 9.0f, 4.0f, 4.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)-4.0f));
        PartDefinition tongue = jaw.m_171599_("tongue", CubeListBuilder.m_171558_().m_171514_(11, 54).m_171488_(-1.5f, -0.01f, -9.0f, 3.0f, 0.0f, 9.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-1.0f));
        PartDefinition tail1_rot = body.m_171599_("tail1_rot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)2.5f, (float)15.5f));
        PartDefinition tail1 = tail1_rot.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(0, 46).m_171488_(-5.5f, -4.0f, -4.0f, 11.0f, 7.0f, 33.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition tail2_rot = tail1.m_171599_("tail2_rot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)29.0f));
        PartDefinition tail2 = tail2_rot.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(60, 86).m_171488_(-4.0f, -2.5f, 0.0f, 8.0f, 5.0f, 20.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition tail3_rot = tail2.m_171599_("tail3_rot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)20.0f));
        PartDefinition tail3 = tail3_rot.m_171599_("tail3", CubeListBuilder.m_171558_().m_171514_(0, 86).m_171488_(-3.0f, -2.0f, 0.0f, 6.0f, 4.0f, 24.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition arm_control = body_upper.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-19.0f));
        PartDefinition left_arm1 = arm_control.m_171599_("left_arm1", CubeListBuilder.m_171558_().m_171514_(100, 0).m_171488_(-3.0f, -2.0f, -3.0f, 6.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)9.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm2 = left_arm1.m_171599_("left_arm2", CubeListBuilder.m_171558_().m_171514_(100, 36).m_171488_(-3.5f, 0.0f, -5.0f, 8.0f, 3.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.5f, (float)9.0f, (float)-1.0f));
        PartDefinition right_arm1 = arm_control.m_171599_("right_arm1", CubeListBuilder.m_171558_().m_171514_(100, 0).m_171480_().m_171488_(-3.0f, -2.0f, -3.0f, 6.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-9.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm2 = right_arm1.m_171599_("right_arm2", CubeListBuilder.m_171558_().m_171514_(100, 36).m_171480_().m_171488_(-4.5f, 0.0f, -5.0f, 8.0f, 3.0f, 7.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-0.5f, (float)9.0f, (float)-1.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)3.5f, (float)9.5f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(100, 18).m_171488_(-3.0f, -2.0f, -3.0f, 6.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)9.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(0, 115).m_171488_(-4.0f, 0.0f, -5.0f, 8.0f, 3.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)9.0f, (float)-1.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(100, 18).m_171480_().m_171488_(-3.0f, -2.0f, -3.0f, 6.0f, 12.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-9.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(0, 115).m_171480_().m_171488_(-4.0f, 0.0f, -5.0f, 8.0f, 3.0f, 7.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)9.0f, (float)-1.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Megalania entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        float deg = (float)Math.PI / 180;
        float partialTicks = ageInTicks - (float)entity.f_19797_;
        float yaw = entity.f_20884_ + (entity.f_20883_ - entity.f_20884_) * partialTicks;
        float tailYaw = Mth.m_14177_((float)(entity.getTailYaw(partialTicks) - yaw)) / 57.295776f;
        this.tail1.f_104204_ += tailYaw * 0.35f;
        this.tail2.f_104204_ += tailYaw * 0.3f;
        this.tail3.f_104204_ += tailYaw * 0.25f;
        if (entity.getIdleState() != 2 && entity.m_20089_() != UP2Poses.TAIL_WHIPPING.get() && !entity.isEepy() && !entity.isSitting()) {
            if (!entity.m_20072_()) {
                if (this.canMegalaniaRun(entity)) {
                    this.m_267799_(MegalaniaAnimations.RUN, limbSwing, limbSwingAmount, 1.0f, 2.0f);
                } else {
                    this.m_267799_(MegalaniaAnimations.WALK, limbSwing, limbSwingAmount, 2.0f, 4.0f);
                }
            } else {
                this.root.f_104203_ = headPitch * ((float)Math.PI / 180) / 2.0f;
                this.m_267799_(MegalaniaAnimations.SWIM, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        if (this.f_102610_) {
            this.m_288214_(MegalaniaAnimations.BABY_TRANSFORM);
        }
        this.animateIdleSmooth(entity.idleAnimationState, this.getIdleAnimation(entity), ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.tongueAnimationState, MegalaniaAnimations.TONGUE_BLEND, ageInTicks);
        this.animateSmooth(entity.roarAnimationState, MegalaniaAnimations.ROAR, ageInTicks);
        this.animateSmooth(entity.sitAnimationState, MegalaniaAnimations.SIT, ageInTicks);
        this.animateSmooth(entity.eepyAnimationState, MegalaniaAnimations.SLEEP, ageInTicks);
        this.animateSmooth(entity.attack1AnimationState, MegalaniaAnimations.BITE_BLEND1, ageInTicks);
        this.animateSmooth(entity.attack2AnimationState, MegalaniaAnimations.BITE_BLEND2, ageInTicks);
        this.animateSmooth(entity.tailWhipAnimationState, MegalaniaAnimations.TAILWHIP, ageInTicks);
        this.animateSmooth(entity.aggroAnimationState, MegalaniaAnimations.AGGRO_BLEND, ageInTicks);
        this.animateIdleSmooth(entity.swimAnimationState, MegalaniaAnimations.SWIM, ageInTicks, limbSwingAmount);
        if (!entity.isEepy() && !entity.isSitting()) {
            this.head.f_104203_ += headPitch * deg / 4.0f;
            this.head.f_104204_ += netHeadYaw * deg / 4.0f;
            this.neck.f_104203_ += headPitch * deg / 2.0f;
            this.neck.f_104204_ += netHeadYaw * deg / 4.0f;
        }
    }

    private AnimationDefinition getIdleAnimation(Megalania entity) {
        switch (entity.getTemperatureState()) {
            case COLD: {
                return MegalaniaIdleAnimations.IDLE_COLD;
            }
            case WARM: {
                return MegalaniaIdleAnimations.IDLE_WARM;
            }
            case NETHER: {
                return MegalaniaIdleAnimations.IDLE_NETHER;
            }
        }
        return MegalaniaIdleAnimations.IDLE_TEMPERATE;
    }

    private boolean canMegalaniaRun(Megalania entity) {
        return (entity.isRunning() || entity.m_217005_() || entity.getTemperatureState() == Megalania.TemperatureStates.NETHER) && entity.getTemperatureState() != Megalania.TemperatureStates.COLD;
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


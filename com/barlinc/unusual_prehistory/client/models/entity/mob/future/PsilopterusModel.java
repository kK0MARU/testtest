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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.PsilopterusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Psilopterus;
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
public class PsilopterusModel
extends UP2Model<Psilopterus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart head;
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

    public PsilopterusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.head = this.body.m_171324_("head");
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
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-11.5f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.5f, -6.5f, -8.0f, 7.0f, 7.0f, 10.0f, new CubeDeformation(0.0f)).m_171514_(5, 38).m_171488_(-3.5f, -6.5f, 2.0f, 7.0f, 7.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(34, 36).m_171488_(-2.5f, -10.5f, -3.0f, 5.0f, 13.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(0, 50).m_171488_(-1.0f, -10.5f, -10.0f, 2.0f, 3.0f, 7.0f, new CubeDeformation(0.0f)).m_171514_(21, 58).m_171488_(-1.0f, -10.5f, -11.0f, 2.0f, 4.0f, 1.0f, new CubeDeformation(0.0f)).m_171514_(34, 3).m_171488_(-2.5f, -10.5f, 2.0f, 5.0f, 5.0f, 4.0f, new CubeDeformation(0.0025f)).m_171514_(0, 0).m_171488_(-1.0f, -2.0f, -1.5f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0025f)).m_171514_(40, 43).m_171488_(0.0f, -17.5f, -9.0f, 0.0f, 9.0f, 12.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)-4.0f, (float)-7.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(16, 50).m_171488_(-1.0f, 0.0f, -5.5f, 2.0f, 1.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-7.5f, (float)-2.5f));
        PartDefinition left_arm = body.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(34, 16).m_171488_(0.0f, 0.0f, -0.5f, 1.0f, 8.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)3.5f, (float)-5.5f, (float)-6.5f));
        PartDefinition right_arm = body.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(34, 16).m_171480_().m_171488_(-1.0f, 0.0f, -0.5f, 1.0f, 8.0f, 12.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-3.5f, (float)-5.5f, (float)-6.5f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0f, 0.0f, 0.0f, 8.0f, 0.0f, 15.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)0.0f, (float)-6.5f, (float)2.0f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-0.5f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(30, 54).m_171488_(-1.0f, -1.5f, -1.5f, 2.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(54, 36).m_171488_(0.0f, 1.5f, 1.5f, 1.0f, 5.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)3.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(54, 41).m_171488_(-0.5f, 0.0f, 0.0f, 1.0f, 5.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.5f, (float)6.5f, (float)1.5f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)5.0f, (float)0.0f));
        PartDefinition claw_r1 = left_leg3.m_171599_("claw_r1", CubeListBuilder.m_171558_().m_171514_(51, 17).m_171488_(-2.5f, -2.01f, -3.0f, 1.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)).m_171514_(26, 19).m_171488_(-2.5f, -0.01f, -4.0f, 5.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2182f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(30, 54).m_171480_().m_171488_(-1.0f, -1.5f, -1.5f, 2.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(54, 36).m_171480_().m_171488_(-1.0f, 1.5f, 1.5f, 1.0f, 5.0f, 0.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-3.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(54, 41).m_171480_().m_171488_(-0.5f, 0.0f, 0.0f, 1.0f, 5.0f, 0.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-0.5f, (float)6.5f, (float)1.5f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)5.0f, (float)0.0f));
        PartDefinition foot_r1 = right_leg3.m_171599_("foot_r1", CubeListBuilder.m_171558_().m_171514_(26, 19).m_171480_().m_171488_(-2.5f, -0.01f, -4.0f, 5.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(51, 17).m_171480_().m_171488_(1.5f, -2.01f, -3.0f, 1.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2182f, (float)0.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(Psilopterus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20069_() && !entity.isEepy()) {
            if (entity.isRunning() && entity.getAttackState() != 2) {
                this.m_267799_(PsilopterusAnimations.RUN, limbSwing, limbSwingAmount, 1.25f, 2.5f);
            } else {
                this.m_267799_(PsilopterusAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        this.animateIdle(entity.idleAnimationState, PsilopterusAnimations.IDLE, ageInTicks, 1.0f, limbSwingAmount * 4.0f);
        this.m_233381_(entity.eepyStartAnimationState, PsilopterusAnimations.SLEEP_START, ageInTicks);
        this.m_233381_(entity.eepyAnimationState, PsilopterusAnimations.SLEEP, ageInTicks);
        this.m_233381_(entity.eepyEndAnimationState, PsilopterusAnimations.SLEEP_END, ageInTicks);
        this.m_233381_(entity.swimAnimationState, PsilopterusAnimations.SWIM, ageInTicks);
        this.m_233381_(entity.attack1AnimationState, PsilopterusAnimations.ATTACK_BLEND1, ageInTicks);
        this.m_233381_(entity.attack2AnimationState, PsilopterusAnimations.ATTACK_BLEND2, ageInTicks);
        this.m_233381_(entity.kickAnimationState, PsilopterusAnimations.KICK, ageInTicks);
        this.m_233381_(entity.pokeAnimationState, PsilopterusAnimations.POKE_BLEND, ageInTicks);
        this.m_233381_(entity.dig1AnimationState, PsilopterusAnimations.DIG1, ageInTicks);
        this.m_233381_(entity.dig2AnimationState, PsilopterusAnimations.DIG2, ageInTicks);
        this.m_233381_(entity.preen1AnimationState, PsilopterusAnimations.PREEN1, ageInTicks);
        this.m_233381_(entity.preen2AnimationState, PsilopterusAnimations.PREEN2, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(PsilopterusAnimations.BABY_TRANSFORM);
        }
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


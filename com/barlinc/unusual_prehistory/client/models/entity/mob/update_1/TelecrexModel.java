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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.TelecrexAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Telecrex;
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
public class TelecrexModel
extends UP2Model<Telecrex> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart left_wing;
    private final ModelPart right_wing;
    private final ModelPart tail;
    private final ModelPart leg_control;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public TelecrexModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.left_wing = this.body.m_171324_("left_wing");
        this.right_wing = this.body.m_171324_("right_wing");
        this.tail = this.body.m_171324_("tail");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_leg = this.leg_control.m_171324_("left_leg");
        this.right_leg = this.leg_control.m_171324_("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-8.5f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0f, -9.0f, -7.0f, 8.0f, 9.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)4.5f, (float)2.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(14, 40).m_171488_(0.0f, -8.0f, -2.0f, 0.0f, 2.0f, 2.0f, new CubeDeformation(0.0025f)).m_171514_(36, 12).m_171488_(-1.5f, -3.0f, -2.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(8, 40).m_171488_(-0.5f, -5.0f, -4.0f, 1.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(36, 16).m_171488_(-0.5f, -3.0f, -4.0f, 1.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).m_171514_(36, 0).m_171488_(-1.5f, -6.0f, -2.0f, 3.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(0, 40).m_171488_(-1.0f, -3.0f, -1.0f, 2.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-7.0f, (float)-7.0f));
        PartDefinition left_wing = body.m_171599_("left_wing", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-0.5f, -7.0f, 0.0f, 1.0f, 7.0f, 13.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)4.5f, (float)-3.0f, (float)-5.0f));
        PartDefinition right_wing = body.m_171599_("right_wing", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-0.5f, -7.0f, 0.0f, 1.0f, 7.0f, 13.0f, new CubeDeformation(0.01f)).m_171555_(false), PartPose.m_171419_((float)-4.5f, (float)-3.0f, (float)-5.0f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(28, 33).m_171488_(-3.5f, 0.0f, 0.0f, 7.0f, 0.0f, 6.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)-9.0f, (float)3.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)4.5f, (float)2.0f));
        PartDefinition left_leg = leg_control.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(36, 6).m_171488_(-1.5f, 0.0f, -2.0f, 3.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)2.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg = leg_control.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(36, 6).m_171480_().m_171488_(-1.5f, 0.0f, -2.0f, 3.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-2.5f, (float)0.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(Telecrex entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_29443_() && !entity.hasSplat()) {
            this.m_267799_(TelecrexAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        }
        this.animateIdleSmooth(entity.idleAnimationState, TelecrexAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.flyAnimationState, TelecrexAnimations.FLY, ageInTicks);
        this.animateSmooth(entity.flyFastAnimationState, TelecrexAnimations.FLYFAST, ageInTicks);
        this.animateSmooth(entity.peckAnimationState, TelecrexAnimations.PECK, ageInTicks);
        this.animateSmooth(entity.preen1AnimationState, TelecrexAnimations.PREEN1, ageInTicks);
        this.animateSmooth(entity.preen2AnimationState, TelecrexAnimations.PREEN2, ageInTicks);
        this.animateSmooth(entity.splatAnimationState, TelecrexAnimations.SPLAT, ageInTicks);
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
        float partialTicks = ageInTicks - (float)entity.f_19797_;
        float flyProgress = entity.getFlyProgress(partialTicks);
        float rollAmount = entity.getFlightRoll(partialTicks) / 57.295776f * flyProgress;
        float flightPitchAmount = entity.getFlightPitch(partialTicks) / 57.295776f * flyProgress;
        this.body_main.f_104203_ += flightPitchAmount / 2.0f;
        this.body_main.f_104205_ += rollAmount / 2.0f;
        if (this.f_102610_) {
            this.m_288214_(TelecrexAnimations.BABY_TRANSFORM);
        }
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


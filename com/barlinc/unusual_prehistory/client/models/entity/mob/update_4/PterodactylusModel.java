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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.PterodactylusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Pterodactylus;
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
public class PterodactylusModel
extends UP2Model<Pterodactylus> {
    private final ModelPart root;
    private final ModelPart flight_control;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart leg_control;
    private final ModelPart left_leg;
    private final ModelPart right_leg;
    private final ModelPart left_wing1;
    private final ModelPart left_wing2;
    private final ModelPart left_wing3;
    private final ModelPart right_wing1;
    private final ModelPart right_wing2;
    private final ModelPart right_wing3;

    public PterodactylusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.flight_control = this.root.m_171324_("flight_control");
        this.body_main = this.flight_control.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_leg = this.leg_control.m_171324_("left_leg");
        this.right_leg = this.leg_control.m_171324_("right_leg");
        this.left_wing1 = this.body_main.m_171324_("left_wing1");
        this.left_wing2 = this.left_wing1.m_171324_("left_wing2");
        this.left_wing3 = this.left_wing2.m_171324_("left_wing3");
        this.right_wing1 = this.body_main.m_171324_("right_wing1");
        this.right_wing2 = this.right_wing1.m_171324_("right_wing2");
        this.right_wing3 = this.right_wing2.m_171324_("right_wing3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition flight_control = root.m_171599_("flight_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-4.0f, (float)0.0f));
        PartDefinition body_main = flight_control.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(20, 0).m_171488_(-1.0f, -3.0f, -1.0f, 2.0f, 5.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(0, 28).m_171488_(0.0f, 0.0f, 1.0f, 0.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(20, 7).m_171488_(-0.5f, -3.0f, -5.0f, 1.0f, 1.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(20, 11).m_171488_(0.0f, -6.0f, -2.0f, 0.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)2.0f, (float)0.0f));
        PartDefinition left_leg = leg_control.m_171599_("left_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.5f, (float)0.0f, (float)0.5f));
        PartDefinition cube_r1 = left_leg.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(20, 18).m_171480_().m_171488_(-0.5f, 2.0f, -2.0f, 2.0f, 0.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(8, 21).m_171488_(-0.5f, 0.0f, 0.0f, 1.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition right_leg = leg_control.m_171599_("right_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)-0.5f, (float)0.0f, (float)0.5f));
        PartDefinition cube_r2 = right_leg.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(20, 18).m_171488_(-1.5f, 2.0f, -2.0f, 2.0f, 0.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(8, 21).m_171488_(-0.5f, 0.0f, 0.0f, 1.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7854f, (float)0.0f));
        PartDefinition left_wing1 = body_main.m_171599_("left_wing1", CubeListBuilder.m_171558_().m_171514_(-5, 7).m_171488_(0.0f, 0.0f, -2.5f, 4.0f, 0.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)1.0f, (float)-0.5f, (float)0.0f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition left_wing2 = left_wing1.m_171599_("left_wing2", CubeListBuilder.m_171558_().m_171514_(-2, 23).m_171488_(-2.0f, 0.0f, -2.0f, 3.0f, 0.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.0f, (float)0.0f, (float)-2.5f));
        PartDefinition left_wing3 = left_wing2.m_171599_("left_wing3", CubeListBuilder.m_171558_().m_171514_(-1, 2).m_171488_(0.0f, 0.0f, -2.0f, 7.0f, 0.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)2.0f));
        PartDefinition right_wing1 = body_main.m_171599_("right_wing1", CubeListBuilder.m_171558_().m_171514_(-5, 7).m_171480_().m_171488_(-4.0f, 0.0f, -2.5f, 4.0f, 0.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-1.0f, (float)-0.5f, (float)0.0f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition right_wing2 = right_wing1.m_171599_("right_wing2", CubeListBuilder.m_171558_().m_171514_(-2, 23).m_171480_().m_171488_(-1.0f, 0.0f, -2.0f, 3.0f, 0.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.0f, (float)0.0f, (float)-2.5f));
        PartDefinition right_wing3 = right_wing2.m_171599_("right_wing3", CubeListBuilder.m_171558_().m_171514_(-1, 2).m_171480_().m_171488_(-7.0f, 0.0f, -2.0f, 7.0f, 0.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)2.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)32, (int)32);
    }

    public void setupAnim(Pterodactylus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.animateSmooth(entity.idleAnimationState, PterodactylusAnimations.GROUD_IDLE, ageInTicks);
        this.animateSmooth(entity.hangIdleAnimationState, PterodactylusAnimations.HANG_IDLE, ageInTicks);
        this.animateSmooth(entity.flyAnimationState, PterodactylusAnimations.FLY, ageInTicks);
        this.animateSmooth(entity.flyFastAnimationState, PterodactylusAnimations.FLYFAST, ageInTicks);
        this.animateSmooth(entity.stretchAnimationState, PterodactylusAnimations.GROUND_STRETCH_BLEND, ageInTicks);
        this.animateSmooth(entity.hangingStretchAnimationState, PterodactylusAnimations.HANG_STRETCH_BLEND, ageInTicks);
        float partialTicks = ageInTicks - (float)entity.f_19797_;
        float flyProgress = entity.getFlyProgress(partialTicks);
        float rollAmount = entity.getFlightRoll(partialTicks) / 57.295776f * flyProgress;
        float flightPitchAmount = entity.getFlightPitch(partialTicks) / 57.295776f * flyProgress;
        this.flight_control.f_104203_ += flightPitchAmount;
        this.flight_control.f_104205_ += rollAmount * 0.7f;
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


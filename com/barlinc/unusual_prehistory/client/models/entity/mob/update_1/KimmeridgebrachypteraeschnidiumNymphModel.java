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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.KimmeridgebrachypteraeschnidiumAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.KimmeridgebrachypteraeschnidiumNymph;
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
public class KimmeridgebrachypteraeschnidiumNymphModel
extends UP2Model<KimmeridgebrachypteraeschnidiumNymph> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leg_control;
    private final ModelPart left_front_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_middle_leg;
    private final ModelPart right_middle_leg;
    private final ModelPart left_back_leg;
    private final ModelPart right_back_leg;

    public KimmeridgebrachypteraeschnidiumNymphModel(ModelPart root) {
        super(1.0f, 0.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_front_leg = this.leg_control.m_171324_("left_front_leg");
        this.right_front_leg = this.leg_control.m_171324_("right_front_leg");
        this.left_middle_leg = this.leg_control.m_171324_("left_middle_leg");
        this.right_middle_leg = this.leg_control.m_171324_("right_middle_leg");
        this.left_back_leg = this.leg_control.m_171324_("left_back_leg");
        this.right_back_leg = this.leg_control.m_171324_("right_back_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)22.4f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.0f, -1.0f, -2.0f, 2.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(-5, 0).m_171488_(-2.0f, 0.0f, -1.0f, 4.0f, 0.0f, 5.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 5).m_171488_(-1.5f, -1.0f, -2.0f, 3.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171514_(0, 12).m_171488_(-0.5f, 0.0f, -3.0f, 1.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-2.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)0.0f));
        PartDefinition left_front_leg = leg_control.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(6, 5).m_171488_(0.0f, 0.0f, -1.5f, 4.0f, 0.0f, 2.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)1.0f, (float)0.0f, (float)-1.5f, (float)0.0f, (float)0.1745f, (float)0.1309f));
        PartDefinition right_front_leg = leg_control.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(6, 5).m_171480_().m_171488_(-4.0f, 0.0f, -1.5f, 4.0f, 0.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-1.0f, (float)0.0f, (float)-1.5f, (float)0.0f, (float)-0.1745f, (float)-0.1309f));
        PartDefinition left_middle_leg = leg_control.m_171599_("left_middle_leg", CubeListBuilder.m_171558_().m_171514_(6, 2).m_171488_(0.0f, 0.0f, -1.5f, 4.0f, 0.0f, 2.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)1.0f, (float)0.0f, (float)0.5f, (float)0.0f, (float)0.0f, (float)0.1309f));
        PartDefinition right_middle_leg = leg_control.m_171599_("right_middle_leg", CubeListBuilder.m_171558_().m_171514_(6, 2).m_171480_().m_171488_(-4.0f, 0.0f, -1.5f, 4.0f, 0.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-1.0f, (float)0.0f, (float)0.5f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition left_back_leg = leg_control.m_171599_("left_back_leg", CubeListBuilder.m_171558_().m_171514_(6, 0).m_171488_(0.0f, 0.0f, -0.5f, 4.0f, 0.0f, 2.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)1.0f, (float)0.0f, (float)1.5f, (float)0.0f, (float)-0.1745f, (float)0.1309f));
        PartDefinition right_back_leg = leg_control.m_171599_("right_back_leg", CubeListBuilder.m_171558_().m_171514_(6, 0).m_171480_().m_171488_(-4.0f, 0.0f, -0.5f, 4.0f, 0.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-1.0f, (float)0.0f, (float)1.5f, (float)0.0f, (float)0.1745f, (float)-0.1309f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)16, (int)16);
    }

    public void setupAnim(KimmeridgebrachypteraeschnidiumNymph entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.m_267799_(KimmeridgebrachypteraeschnidiumAnimations.NYMPH_WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        this.animateIdleSmooth(entity.idleAnimationState, KimmeridgebrachypteraeschnidiumAnimations.NYMPH_IDLE, ageInTicks, limbSwingAmount);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


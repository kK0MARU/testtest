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
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_2;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_2.OnchopristisAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_2.Onchopristis;
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
public class OnchopristisModel
extends UP2Model<Onchopristis> {
    private final ModelPart root;
    private final ModelPart swim_control;
    private final ModelPart body;
    private final ModelPart saw;
    private final ModelPart left_pectoralfin1;
    private final ModelPart left_pectoralfin2;
    private final ModelPart right_pectoralfin1;
    private final ModelPart right_pectoralfin2;
    private final ModelPart tail1;
    private final ModelPart left_pelvicfin;
    private final ModelPart right_pelvicfin;
    private final ModelPart tail2;

    public OnchopristisModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.swim_control = this.root.m_171324_("swim_control");
        this.body = this.swim_control.m_171324_("body");
        this.saw = this.body.m_171324_("saw");
        this.left_pectoralfin1 = this.body.m_171324_("left_pectoralfin1");
        this.left_pectoralfin2 = this.left_pectoralfin1.m_171324_("left_pectoralfin2");
        this.right_pectoralfin1 = this.body.m_171324_("right_pectoralfin1");
        this.right_pectoralfin2 = this.right_pectoralfin1.m_171324_("right_pectoralfin2");
        this.tail1 = this.body.m_171324_("tail1");
        this.left_pelvicfin = this.tail1.m_171324_("left_pelvicfin");
        this.right_pelvicfin = this.tail1.m_171324_("right_pelvicfin");
        this.tail2 = this.tail1.m_171324_("tail2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition swim_control = root.m_171599_("swim_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)0.0f));
        PartDefinition body = swim_control.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-9.5f, -3.0f, -11.0f, 19.0f, 5.0f, 22.0f, new CubeDeformation(0.0f)).m_171514_(66, 81).m_171488_(6.5f, -4.0f, -12.0f, 0.0f, 3.0f, 22.0f, new CubeDeformation(0.0025f)).m_171514_(66, 78).m_171488_(0.0f, -4.0f, -12.0f, 0.0f, 3.0f, 22.0f, new CubeDeformation(0.0025f)).m_171514_(66, 81).m_171480_().m_171488_(-6.5f, -4.0f, -12.0f, 0.0f, 3.0f, 22.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition saw = body.m_171599_("saw", CubeListBuilder.m_171558_().m_171514_(0, 56).m_171488_(-1.5f, -1.0f, -30.0f, 3.0f, 2.0f, 30.0f, new CubeDeformation(0.0f)).m_171514_(0, 27).m_171488_(-3.5f, 0.0f, -29.0f, 7.0f, 0.0f, 29.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)-11.0f));
        PartDefinition left_pectoralfin1 = body.m_171599_("left_pectoralfin1", CubeListBuilder.m_171558_().m_171514_(82, 0).m_171488_(0.0f, -0.5f, -9.5f, 4.0f, 1.0f, 19.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)9.5f, (float)1.5f, (float)-1.5f));
        PartDefinition left_pectoralfin2 = left_pectoralfin1.m_171599_("left_pectoralfin2", CubeListBuilder.m_171558_().m_171514_(72, 27).m_171488_(0.0f, -0.5f, -7.5f, 11.0f, 1.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.0f, (float)0.0f, (float)2.0f));
        PartDefinition right_pectoralfin1 = body.m_171599_("right_pectoralfin1", CubeListBuilder.m_171558_().m_171514_(82, 0).m_171480_().m_171488_(-4.0f, -0.5f, -9.5f, 4.0f, 1.0f, 19.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-9.5f, (float)1.5f, (float)-1.5f));
        PartDefinition right_pectoralfin2 = right_pectoralfin1.m_171599_("right_pectoralfin2", CubeListBuilder.m_171558_().m_171514_(72, 27).m_171480_().m_171488_(-11.0f, -0.5f, -7.5f, 11.0f, 1.0f, 15.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.0f, (float)0.0f, (float)2.0f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(66, 56).m_171488_(-1.5f, -1.0f, 0.0f, 3.0f, 2.0f, 23.0f, new CubeDeformation(0.0f)).m_171514_(22, 88).m_171488_(0.0f, -4.0f, 6.0f, 0.0f, 3.0f, 10.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)11.0f));
        PartDefinition left_pelvicfin = tail1.m_171599_("left_pelvicfin", CubeListBuilder.m_171558_().m_171514_(72, 43).m_171488_(0.0f, 0.0f, -4.0f, 6.0f, 1.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)1.5f, (float)0.0f, (float)4.0f));
        PartDefinition right_pelvicfin = tail1.m_171599_("right_pelvicfin", CubeListBuilder.m_171558_().m_171514_(72, 43).m_171480_().m_171488_(-6.0f, 0.0f, -4.0f, 6.0f, 1.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-1.5f, (float)0.0f, (float)4.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(0, 88).m_171488_(0.0f, -2.0f, 0.0f, 0.0f, 4.0f, 11.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)23.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(Onchopristis entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (entity.m_20069_() && !entity.isBurrowed()) {
            this.m_267799_(OnchopristisAnimations.SWIM, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        }
        this.animateIdleSmooth(entity.swimIdleAnimationState, OnchopristisAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.flopAnimationState, OnchopristisAnimations.SWIM, ageInTicks, 2.0f);
        this.animateSmooth(entity.attack1AnimationState, OnchopristisAnimations.ATTACK_BLEND1, ageInTicks);
        this.animateSmooth(entity.attack2AnimationState, OnchopristisAnimations.ATTACK_BLEND2, ageInTicks);
        this.animateSmooth(entity.burrowAnimationState, OnchopristisAnimations.BURROW, ageInTicks);
        if (!entity.isBurrowed()) {
            this.swim_control.f_104203_ = headPitch * ((float)Math.PI / 360);
        }
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


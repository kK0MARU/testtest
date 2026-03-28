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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.LeptictidiumAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Leptictidium;
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
public class LeptictidiumModel
extends UP2Model<Leptictidium> {
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart snout;
    private final ModelPart left_ear;
    private final ModelPart right_ear;
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

    public LeptictidiumModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.body_main = root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.snout = this.body.m_171324_("snout");
        this.left_ear = this.body.m_171324_("left_ear");
        this.right_ear = this.body.m_171324_("right_ear");
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
        PartDefinition body_main = partdefinition.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)1.5f, (float)14.9f, (float)-0.5f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-2.5f, -5.75f, -7.0f, 5.0f, 6.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-1.5f, (float)2.0f, (float)3.5f));
        PartDefinition snout = body.m_171599_("snout", CubeListBuilder.m_171558_().m_171514_(24, 14).m_171488_(-1.0f, -1.25f, -6.0f, 1.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(28, 8).m_171488_(-1.0f, -3.25f, -7.0f, 1.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.5f, (float)0.5f, (float)-7.0f));
        PartDefinition left_ear = body.m_171599_("left_ear", CubeListBuilder.m_171558_().m_171514_(28, 0).m_171488_(-1.0f, -3.75f, 0.0f, 4.0f, 4.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)2.5f, (float)-5.0f, (float)-4.0f));
        PartDefinition right_ear = body.m_171599_("right_ear", CubeListBuilder.m_171558_().m_171514_(28, 0).m_171480_().m_171488_(-3.0f, -3.75f, 0.0f, 4.0f, 4.0f, 0.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-2.5f, (float)-5.0f, (float)-4.0f));
        PartDefinition left_arm = body.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(28, 4).m_171488_(-1.5f, -0.75f, 0.0f, 3.0f, 4.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)2.0f, (float)1.0f, (float)-5.0f));
        PartDefinition right_arm = body.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(28, 4).m_171480_().m_171488_(-1.5f, -0.75f, 0.0f, 3.0f, 4.0f, 0.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-2.0f, (float)1.0f, (float)-5.0f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5f, -1.25f, 0.0f, 1.0f, 1.0f, 13.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)0.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(12, 27).m_171488_(-0.5f, -1.75f, 0.0f, 1.0f, 1.0f, 4.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)13.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)-1.5f, (float)2.0f, (float)3.5f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(24, 21).m_171488_(-1.0f, -1.75f, -1.0f, 2.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)2.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-0.5f, -0.75f, 0.0f, 1.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)4.0f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(0, 27).m_171488_(-0.5f, -0.75f, -5.0f, 1.0f, 0.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)5.0f, (float)0.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(24, 21).m_171480_().m_171488_(-1.0f, -1.75f, -1.0f, 2.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-2.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-0.5f, -0.75f, 0.0f, 1.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)4.0f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(0, 27).m_171480_().m_171488_(-0.5f, -0.75f, -5.0f, 1.0f, 0.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)5.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(Leptictidium entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20072_()) {
            if (entity.isRunning()) {
                this.m_267799_(LeptictidiumAnimations.RUN, limbSwing, limbSwingAmount, 1.25f, 2.5f);
            } else {
                this.m_267799_(LeptictidiumAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        if (this.f_102610_) {
            this.m_288214_(LeptictidiumAnimations.BABY_TRANSFORM);
        }
        this.animateIdleSmooth(entity.idleAnimationState, LeptictidiumAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.attackAnimationState, LeptictidiumAnimations.ATTACK, ageInTicks);
        this.animateSmooth(entity.swimAnimationState, LeptictidiumAnimations.SWIM, ageInTicks);
        this.animateSmooth(entity.preenAnimationState, LeptictidiumAnimations.IDLE_PREEN, ageInTicks);
        this.animateSmooth(entity.sniffAnimationState, LeptictidiumAnimations.SNIFF_BLEND, ageInTicks);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.body_main;
    }
}


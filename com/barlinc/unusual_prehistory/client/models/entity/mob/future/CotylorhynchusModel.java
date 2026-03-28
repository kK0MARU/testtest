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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.CotylorhynchusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Cotylorhynchus;
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
public class CotylorhynchusModel
extends UP2Model<Cotylorhynchus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart upper_jaw;
    private final ModelPart jaw;
    private final ModelPart dewlap;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart arm_control;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart leg_control;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public CotylorhynchusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.upper_jaw = this.head.m_171324_("upper_jaw");
        this.jaw = this.head.m_171324_("jaw");
        this.dewlap = this.jaw.m_171324_("dewlap");
        this.tail1 = this.body.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
        this.arm_control = this.body_main.m_171324_("arm_control");
        this.left_arm = this.arm_control.m_171324_("left_arm");
        this.right_arm = this.arm_control.m_171324_("right_arm");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_leg = this.leg_control.m_171324_("left_leg");
        this.right_leg = this.leg_control.m_171324_("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-15.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-13.5f, -11.0f, -20.0f, 27.0f, 22.0f, 41.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)-1.0f, (float)-9.0f, (float)-20.0f));
        PartDefinition upper_jaw = head.m_171599_("upper_jaw", CubeListBuilder.m_171558_().m_171514_(34, 94).m_171488_(-2.0f, -4.0f, -6.0f, 5.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.5f, (float)2.0f, (float)0.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(48, 107).m_171488_(-2.5f, 0.0f, -6.0f, 5.0f, 1.0f, 6.0f, new CubeDeformation(-0.01f)), PartPose.m_171419_((float)1.0f, (float)1.0f, (float)0.0f));
        PartDefinition dewlap = jaw.m_171599_("dewlap", CubeListBuilder.m_171558_().m_171514_(70, 107).m_171488_(-1.0f, 0.0f, -3.0f, 2.0f, 5.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(32, 103).m_171488_(0.0f, -0.01f, -4.0f, 0.0f, 6.0f, 8.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)1.01f, (float)0.0f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(62, 63).m_171488_(-5.5f, -4.0f, -2.0f, 11.0f, 8.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)5.0f, (float)21.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(0, 63).m_171488_(-2.5f, -2.7f, 0.0f, 5.0f, 5.0f, 26.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)1.5f, (float)13.0f));
        PartDefinition arm_control = body_main.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)4.9f, (float)-15.0f));
        PartDefinition left_arm = arm_control.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(90, 86).m_171488_(0.0f, -4.9f, -3.0f, 6.0f, 15.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(0, 102).m_171488_(0.0f, 10.0f, -5.0f, 8.0f, 0.0f, 8.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)13.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm = arm_control.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(90, 86).m_171480_().m_171488_(-6.0f, -4.9f, -3.0f, 6.0f, 15.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 102).m_171480_().m_171488_(-8.0f, 10.0f, -5.0f, 8.0f, 0.0f, 8.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-13.5f, (float)0.0f, (float)0.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)6.0f, (float)13.0f));
        PartDefinition left_leg = leg_control.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 94).m_171488_(-2.0f, 8.9f, -7.0f, 8.0f, 0.0f, 8.0f, new CubeDeformation(0.0025f)).m_171514_(62, 86).m_171488_(-2.0f, -4.0f, -4.0f, 6.0f, 13.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)13.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg = leg_control.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(62, 86).m_171480_().m_171488_(-4.0f, -4.0f, -4.0f, 6.0f, 13.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(0, 94).m_171480_().m_171488_(-6.0f, 8.9f, -7.0f, 8.0f, 0.0f, 8.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-13.5f, (float)0.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Cotylorhynchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20069_()) {
            if (entity.isRunning()) {
                this.m_267799_(CotylorhynchusAnimations.RUN, limbSwing, limbSwingAmount, 1.0f, 2.0f);
            } else {
                this.m_267799_(CotylorhynchusAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        this.animateIdle(entity.idleAnimationState, CotylorhynchusAnimations.IDLE, ageInTicks, 1.0f, limbSwingAmount * 4.0f);
        this.m_233381_(entity.swimAnimationState, CotylorhynchusAnimations.SWIM, ageInTicks);
        if (this.f_102610_) {
            this.m_288214_(CotylorhynchusAnimations.BABY_TRANSFORM);
        }
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


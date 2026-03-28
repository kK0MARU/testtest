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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.DunkleosteusSmallAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Dunkleosteus;
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
public class DunkleosteusSmallModel
extends UP2Model<Dunkleosteus> {
    private final ModelPart root;
    private final ModelPart swim_control;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart upper_jaw;
    private final ModelPart jaw;
    private final ModelPart dorsal;
    private final ModelPart left_front_fin;
    private final ModelPart right_front_fin;
    private final ModelPart left_back_fin;
    private final ModelPart right_back_fin;
    private final ModelPart tail1;
    private final ModelPart tail2;

    public DunkleosteusSmallModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.swim_control = this.root.m_171324_("swim_control");
        this.body = this.swim_control.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.upper_jaw = this.head.m_171324_("upper_jaw");
        this.jaw = this.head.m_171324_("jaw");
        this.dorsal = this.body.m_171324_("dorsal");
        this.left_front_fin = this.body.m_171324_("left_front_fin");
        this.right_front_fin = this.body.m_171324_("right_front_fin");
        this.left_back_fin = this.body.m_171324_("left_back_fin");
        this.right_back_fin = this.body.m_171324_("right_back_fin");
        this.tail1 = this.body.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition swim_control = root.m_171599_("swim_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-4.0f, (float)0.0f));
        PartDefinition body = swim_control.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0f, -4.0f, -2.5f, 6.0f, 8.0f, 7.0f, new CubeDeformation(0.05f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)2.0f, (float)-2.0f));
        PartDefinition upper_jaw = head.m_171599_("upper_jaw", CubeListBuilder.m_171558_().m_171514_(20, 15).m_171488_(-3.0f, -3.0f, -5.5f, 6.0f, 3.0f, 6.0f, new CubeDeformation(0.0025f)).m_171514_(-4, 41).m_171488_(-3.0f, -1.0f, -5.5f, 6.0f, 0.0f, 6.0f, new CubeDeformation(0.0025f)).m_171514_(26, 0).m_171488_(-3.0f, -3.0f, -3.5f, 6.0f, 5.0f, 3.0f, new CubeDeformation(0.1f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(2, 47).m_171488_(-3.0f, 0.0f, -5.5f, 6.0f, 2.0f, 6.0f, new CubeDeformation(0.001f)).m_171514_(-4, 41).m_171488_(-3.0f, 1.0f, -5.5f, 6.0f, 0.0f, 6.0f, new CubeDeformation(0.001f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition dorsal = body.m_171599_("dorsal", CubeListBuilder.m_171558_().m_171514_(20, 28).m_171488_(0.0f, -3.0f, -4.5f, 0.0f, 5.0f, 7.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)-3.0f, (float)4.0f));
        PartDefinition left_front_fin = body.m_171599_("left_front_fin", CubeListBuilder.m_171558_().m_171514_(34, 26).m_171488_(0.0f, -1.0f, -1.0f, 0.0f, 6.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)3.0f, (float)4.0f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition right_front_fin = body.m_171599_("right_front_fin", CubeListBuilder.m_171558_().m_171514_(34, 26).m_171480_().m_171488_(0.0f, -1.0f, -1.0f, 0.0f, 6.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-3.0f, (float)4.0f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition left_back_fin = body.m_171599_("left_back_fin", CubeListBuilder.m_171558_().m_171514_(27, 9).m_171488_(0.0f, -1.0f, -1.0f, 0.0f, 3.0f, 2.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)3.0f, (float)4.0f, (float)3.5f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition right_back_fin = body.m_171599_("right_back_fin", CubeListBuilder.m_171558_().m_171514_(27, 9).m_171480_().m_171488_(0.0f, -1.0f, -1.0f, 0.0f, 3.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-3.0f, (float)4.0f, (float)3.5f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(2, 17).m_171488_(0.0f, -6.0f, -1.0f, 0.0f, 10.0f, 8.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)4.5f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(38, 6).m_171488_(0.0f, -4.0f, 0.0f, 0.0f, 8.0f, 6.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)7.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(Dunkleosteus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (entity.isRunning()) {
            this.m_267799_(DunkleosteusSmallAnimations.SWIM, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        } else {
            this.m_267799_(DunkleosteusSmallAnimations.SWIM_CHASE, limbSwing, limbSwingAmount, 1.0f, 2.0f);
        }
        this.animateIdleSmooth(entity.swimIdleAnimationState, DunkleosteusSmallAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.flopAnimationState, DunkleosteusSmallAnimations.FLOP, ageInTicks);
        this.animateSmooth(entity.attackAnimationState, DunkleosteusSmallAnimations.ATTACK_BLEND, ageInTicks);
        this.animateSmooth(entity.quirkAnimationState, DunkleosteusSmallAnimations.QUIRK_BLEND, ageInTicks);
        this.swim_control.f_104203_ = headPitch * ((float)Math.PI / 180);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


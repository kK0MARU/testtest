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
 *  net.minecraft.util.Mth
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.models.entity.mob.future;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.AegirocassisBabyAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Aegirocassis;
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
public class AegirocassisBabyModel
extends UP2Model<Aegirocassis> {
    private final ModelPart root;
    private final ModelPart swim_control;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart left_eye;
    private final ModelPart right_eye;
    private final ModelPart left_mandible;
    private final ModelPart left_filter;
    private final ModelPart right_mandible;
    private final ModelPart right_filter;
    private final ModelPart segment1;
    private final ModelPart left_fin1;
    private final ModelPart right_fin1;
    private final ModelPart segment2;
    private final ModelPart left_rudder1;
    private final ModelPart right_rudder1;
    private final ModelPart left_fin2;
    private final ModelPart right_fin2;
    private final ModelPart segment3;
    private final ModelPart left_rudder2;
    private final ModelPart right_rudder2;
    private final ModelPart left_fin3;
    private final ModelPart right_fin3;
    private final ModelPart segment4;
    private final ModelPart left_rudder3;
    private final ModelPart right_rudder3;
    private final ModelPart left_fin4;
    private final ModelPart right_fin4;
    private final ModelPart segment5;
    private final ModelPart left_rudder4;
    private final ModelPart right_rudder4;
    private final ModelPart left_fin5;
    private final ModelPart right_fin5;

    public AegirocassisBabyModel(ModelPart root) {
        super(1.0f, 0.0f);
        this.root = root.m_171324_("root");
        this.swim_control = this.root.m_171324_("swim_control");
        this.body = this.swim_control.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.left_eye = this.head.m_171324_("left_eye");
        this.right_eye = this.head.m_171324_("right_eye");
        this.left_mandible = this.head.m_171324_("left_mandible");
        this.left_filter = this.left_mandible.m_171324_("left_filter");
        this.right_mandible = this.head.m_171324_("right_mandible");
        this.right_filter = this.right_mandible.m_171324_("right_filter");
        this.segment1 = this.body.m_171324_("segment1");
        this.left_fin1 = this.segment1.m_171324_("left_fin1");
        this.right_fin1 = this.segment1.m_171324_("right_fin1");
        this.segment2 = this.segment1.m_171324_("segment2");
        this.left_rudder1 = this.segment2.m_171324_("left_rudder1");
        this.right_rudder1 = this.segment2.m_171324_("right_rudder1");
        this.left_fin2 = this.segment2.m_171324_("left_fin2");
        this.right_fin2 = this.segment2.m_171324_("right_fin2");
        this.segment3 = this.segment2.m_171324_("segment3");
        this.left_rudder2 = this.segment3.m_171324_("left_rudder2");
        this.right_rudder2 = this.segment3.m_171324_("right_rudder2");
        this.left_fin3 = this.segment3.m_171324_("left_fin3");
        this.right_fin3 = this.segment3.m_171324_("right_fin3");
        this.segment4 = this.segment3.m_171324_("segment4");
        this.left_rudder3 = this.segment4.m_171324_("left_rudder3");
        this.right_rudder3 = this.segment4.m_171324_("right_rudder3");
        this.left_fin4 = this.segment4.m_171324_("left_fin4");
        this.right_fin4 = this.segment4.m_171324_("right_fin4");
        this.segment5 = this.segment4.m_171324_("segment5");
        this.left_rudder4 = this.segment5.m_171324_("left_rudder4");
        this.right_rudder4 = this.segment5.m_171324_("right_rudder4");
        this.left_fin5 = this.segment5.m_171324_("left_fin5");
        this.right_fin5 = this.segment5.m_171324_("right_fin5");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition swim_control = root.m_171599_("swim_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-5.0f, (float)0.0f));
        PartDefinition body = swim_control.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 31).m_171488_(-8.0f, -6.0f, -13.0f, 16.0f, 8.0f, 11.0f, new CubeDeformation(0.01f)).m_171514_(0, 0).m_171488_(-5.0f, -9.0f, -27.0f, 10.0f, 6.0f, 25.0f, new CubeDeformation(0.0f)).m_171514_(44, 65).m_171488_(-5.0f, -9.0f, -2.0f, 10.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(0, 50).m_171488_(-4.0f, -6.0f, -12.0f, 8.0f, 10.0f, 14.0f, new CubeDeformation(0.0f)).m_171514_(44, 50).m_171488_(-5.0f, 3.0f, -15.0f, 10.0f, 2.0f, 13.0f, new CubeDeformation(0.0f)).m_171514_(35, 61).m_171488_(-5.0f, 2.0f, -15.0f, 10.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_eye = head.m_171599_("left_eye", CubeListBuilder.m_171558_().m_171514_(0, 74).m_171488_(1.0f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f, new CubeDeformation(0.01f)).m_171514_(45, 53).m_171488_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.0f, (float)-4.5f, (float)0.5f));
        PartDefinition right_eye = head.m_171599_("right_eye", CubeListBuilder.m_171558_().m_171514_(0, 74).m_171480_().m_171488_(-4.0f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f, new CubeDeformation(0.01f)).m_171555_(false).m_171514_(45, 53).m_171480_().m_171488_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.0f, (float)-4.75f, (float)0.5f));
        PartDefinition left_mandible = head.m_171599_("left_mandible", CubeListBuilder.m_171558_().m_171514_(54, 13).m_171488_(-1.0f, -1.0f, -8.0f, 2.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)3.0f, (float)0.0f, (float)-13.0f));
        PartDefinition left_filter = left_mandible.m_171599_("left_filter", CubeListBuilder.m_171558_().m_171514_(70, 19).m_171488_(-2.0f, 0.0f, -1.0f, 2.0f, 6.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)1.0f, (float)1.0f, (float)-7.0f));
        PartDefinition right_mandible = head.m_171599_("right_mandible", CubeListBuilder.m_171558_().m_171514_(54, 13).m_171480_().m_171488_(-1.0f, -1.0f, -8.0f, 2.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-3.0f, (float)0.0f, (float)-13.0f));
        PartDefinition right_filter = right_mandible.m_171599_("right_filter", CubeListBuilder.m_171558_().m_171514_(70, 19).m_171480_().m_171488_(0.0f, 0.0f, -1.0f, 2.0f, 6.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-1.0f, (float)1.0f, (float)-7.0f));
        PartDefinition segment1 = body.m_171599_("segment1", CubeListBuilder.m_171558_().m_171514_(54, 31).m_171488_(-6.5f, -5.0f, 0.0f, 13.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(70, 0).m_171488_(-5.5f, -4.0f, 4.0f, 11.0f, 8.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_fin1 = segment1.m_171599_("left_fin1", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171488_(0.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)6.5f, (float)5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin1 = segment1.m_171599_("right_fin1", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171480_().m_171488_(-6.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-6.5f, (float)5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition segment2 = segment1.m_171599_("segment2", CubeListBuilder.m_171558_().m_171514_(54, 31).m_171488_(-6.5f, -5.0f, 0.0f, 13.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(70, 0).m_171488_(-5.5f, -4.0f, 4.0f, 11.0f, 8.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)5.0f));
        PartDefinition left_rudder1 = segment2.m_171599_("left_rudder1", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171488_(0.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)6.5f, (float)-5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_rudder1 = segment2.m_171599_("right_rudder1", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171480_().m_171488_(-6.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-6.5f, (float)-5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition left_fin2 = segment2.m_171599_("left_fin2", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171488_(0.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)6.5f, (float)5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin2 = segment2.m_171599_("right_fin2", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171480_().m_171488_(-6.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-6.5f, (float)5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition segment3 = segment2.m_171599_("segment3", CubeListBuilder.m_171558_().m_171514_(88, 31).m_171488_(-6.5f, -5.0f, 0.0f, 13.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(70, 0).m_171488_(-5.5f, -4.0f, 4.0f, 11.0f, 8.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)5.0f));
        PartDefinition left_rudder2 = segment3.m_171599_("left_rudder2", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171488_(0.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)6.5f, (float)-5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_rudder2 = segment3.m_171599_("right_rudder2", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171480_().m_171488_(-6.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-6.5f, (float)-5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition left_fin3 = segment3.m_171599_("left_fin3", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171488_(0.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)6.5f, (float)5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin3 = segment3.m_171599_("right_fin3", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171480_().m_171488_(-6.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-6.5f, (float)5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition segment4 = segment3.m_171599_("segment4", CubeListBuilder.m_171558_().m_171514_(88, 31).m_171488_(-6.5f, -5.0f, 0.0f, 13.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)5.0f));
        PartDefinition left_rudder3 = segment4.m_171599_("left_rudder3", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171488_(0.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)6.5f, (float)-5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_rudder3 = segment4.m_171599_("right_rudder3", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171480_().m_171488_(-6.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-6.5f, (float)-5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition left_fin4 = segment4.m_171599_("left_fin4", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171488_(0.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)6.5f, (float)5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin4 = segment4.m_171599_("right_fin4", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171480_().m_171488_(-6.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-6.5f, (float)5.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition segment5 = segment4.m_171599_("segment5", CubeListBuilder.m_171558_().m_171514_(91, 53).m_171488_(-4.5f, -3.0f, 1.0f, 9.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(93, 45).m_171488_(-3.5f, -2.0f, -1.0f, 7.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)4.0f));
        PartDefinition left_rudder4 = segment5.m_171599_("left_rudder4", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171488_(0.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)4.5f, (float)-3.0f, (float)3.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_rudder4 = segment5.m_171599_("right_rudder4", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171480_().m_171488_(-6.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-4.5f, (float)-3.0f, (float)3.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition left_fin5 = segment5.m_171599_("left_fin5", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171488_(0.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)4.5f, (float)3.0f, (float)3.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin5 = segment5.m_171599_("right_fin5", CubeListBuilder.m_171558_().m_171514_(54, 46).m_171480_().m_171488_(-6.0f, 0.0f, -2.0f, 6.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-4.5f, (float)3.0f, (float)3.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(@NotNull Aegirocassis entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (entity.m_20069_()) {
            this.m_267799_(AegirocassisBabyAnimations.MOUTH_SWIM_OVERLAY, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            this.m_267799_(AegirocassisBabyAnimations.SWIM, limbSwing, limbSwingAmount, 1.625f, 3.25f);
        }
        this.animateIdle(entity.swimIdleAnimationState, AegirocassisBabyAnimations.IDLE, ageInTicks, 1.0f, limbSwingAmount * 3.0f);
        this.m_233381_(entity.flopAnimationState, AegirocassisBabyAnimations.BEACHED, ageInTicks);
        this.m_233381_(entity.eyesAnimationState, AegirocassisBabyAnimations.EYE_OVERLAY, ageInTicks);
        this.animateIdle(entity.mouthAnimationState, AegirocassisBabyAnimations.MOUTH_IDLE_OVERLAY, ageInTicks, 1.0f, limbSwingAmount * 3.0f);
        float deg = (float)Math.PI / 180;
        float partialTicks = ageInTicks - (float)entity.f_19797_;
        double bodyYRot = Mth.m_14177_((float)(entity.f_20884_ + (entity.f_20883_ - entity.f_20884_) * partialTicks));
        double segment1Y = (double)entity.getTrailTransformation(5, partialTicks) - bodyYRot;
        double segment2Y = (double)entity.getTrailTransformation(10, partialTicks) - bodyYRot - segment1Y;
        double segment3Y = (double)entity.getTrailTransformation(15, partialTicks) - bodyYRot - segment2Y;
        double segment4Y = (double)entity.getTrailTransformation(20, partialTicks) - bodyYRot - segment3Y;
        this.segment2.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)segment1Y) * (double)0.4f);
        this.segment3.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)segment2Y) * (double)0.3f);
        this.segment4.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)segment2Y) * (double)0.3f);
        this.segment5.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)segment3Y) * (double)0.2f);
        if (entity.m_20069_()) {
            this.swim_control.f_104203_ = headPitch * deg / 3.0f;
        }
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


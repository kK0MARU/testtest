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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.AegirocassisAnimations;
import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.AegirocassisLeapAnimations;
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
public class AegirocassisModel
extends UP2Model<Aegirocassis> {
    private final ModelPart root;
    private final ModelPart swim_control;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart left_eye;
    private final ModelPart right_eye;
    private final ModelPart left_mandible;
    private final ModelPart left_filter1;
    private final ModelPart left_filter2;
    private final ModelPart left_filter3;
    private final ModelPart left_filter4;
    private final ModelPart left_filter5;
    private final ModelPart left_filter6;
    private final ModelPart right_mandible;
    private final ModelPart right_filter1;
    private final ModelPart right_filter2;
    private final ModelPart right_filter3;
    private final ModelPart right_filter4;
    private final ModelPart right_filter5;
    private final ModelPart right_filter6;
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
    private final ModelPart right_fin4;
    private final ModelPart left_fin4;
    private final ModelPart segment5;
    private final ModelPart left_rudder4;
    private final ModelPart right_rudder4;
    private final ModelPart left_fin5;
    private final ModelPart right_fin5;
    private final ModelPart segment6;
    private final ModelPart left_rudder5;
    private final ModelPart right_rudder5;
    private final ModelPart left_fin6;
    private final ModelPart right_fin6;

    public AegirocassisModel(ModelPart root) {
        super(1.0f, 0.0f);
        this.root = root.m_171324_("root");
        this.swim_control = this.root.m_171324_("swim_control");
        this.body = this.swim_control.m_171324_("body");
        this.head = this.body.m_171324_("head");
        this.left_eye = this.head.m_171324_("left_eye");
        this.right_eye = this.head.m_171324_("right_eye");
        this.left_mandible = this.head.m_171324_("left_mandible");
        this.left_filter1 = this.left_mandible.m_171324_("left_filter1");
        this.left_filter2 = this.left_mandible.m_171324_("left_filter2");
        this.left_filter3 = this.left_mandible.m_171324_("left_filter3");
        this.left_filter4 = this.left_mandible.m_171324_("left_filter4");
        this.left_filter5 = this.left_mandible.m_171324_("left_filter5");
        this.left_filter6 = this.left_mandible.m_171324_("left_filter6");
        this.right_mandible = this.head.m_171324_("right_mandible");
        this.right_filter1 = this.right_mandible.m_171324_("right_filter1");
        this.right_filter2 = this.right_mandible.m_171324_("right_filter2");
        this.right_filter3 = this.right_mandible.m_171324_("right_filter3");
        this.right_filter4 = this.right_mandible.m_171324_("right_filter4");
        this.right_filter5 = this.right_mandible.m_171324_("right_filter5");
        this.right_filter6 = this.right_mandible.m_171324_("right_filter6");
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
        this.right_fin4 = this.segment4.m_171324_("right_fin4");
        this.left_fin4 = this.segment4.m_171324_("left_fin4");
        this.segment5 = this.segment4.m_171324_("segment5");
        this.left_rudder4 = this.segment5.m_171324_("left_rudder4");
        this.right_rudder4 = this.segment5.m_171324_("right_rudder4");
        this.left_fin5 = this.segment5.m_171324_("left_fin5");
        this.right_fin5 = this.segment5.m_171324_("right_fin5");
        this.segment6 = this.segment5.m_171324_("Segment6");
        this.left_rudder5 = this.segment6.m_171324_("left_rudder5");
        this.right_rudder5 = this.segment6.m_171324_("right_rudder5");
        this.left_fin6 = this.segment6.m_171324_("left_fin6");
        this.right_fin6 = this.segment6.m_171324_("right_fin6");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition swim_control = root.m_171599_("swim_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-29.0f, (float)0.0f));
        PartDefinition body = swim_control.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 161).m_171488_(-20.0f, -19.0f, -61.0f, 40.0f, 50.0f, 82.0f, new CubeDeformation(0.0f)).m_171514_(244, 259).m_171488_(-23.0f, 26.0f, -76.0f, 46.0f, 11.0f, 70.0f, new CubeDeformation(0.0f)).m_171514_(354, 150).m_171488_(-23.0f, 22.0f, -76.0f, 46.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(244, 161).m_171488_(-35.0f, -19.0f, -63.01f, 70.0f, 41.0f, 57.0f, new CubeDeformation(0.0f)).m_171514_(0, 0).m_171488_(-22.0f, -32.0f, -139.0f, 44.0f, 28.0f, 133.0f, new CubeDeformation(0.0f)).m_171514_(314, 340).m_171488_(-22.0f, -32.0f, -6.0f, 44.0f, 13.0f, 29.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-8.0f, (float)8.0f));
        PartDefinition left_eye = head.m_171599_("left_eye", CubeListBuilder.m_171558_().m_171514_(92, 365).m_171488_(11.0f, -8.0f, -7.0f, 14.0f, 14.0f, 14.0f, new CubeDeformation(0.0f)).m_171514_(336, 424).m_171488_(-1.0f, -6.0f, -5.0f, 13.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)20.0f, (float)-6.0f, (float)3.0f));
        PartDefinition right_eye = head.m_171599_("right_eye", CubeListBuilder.m_171558_().m_171514_(92, 365).m_171480_().m_171488_(-25.0f, -8.0f, -7.0f, 14.0f, 14.0f, 14.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(336, 424).m_171480_().m_171488_(-12.0f, -6.0f, -5.0f, 13.0f, 10.0f, 10.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-20.0f, (float)-6.0f, (float)3.0f));
        PartDefinition left_mandible = head.m_171599_("left_mandible", CubeListBuilder.m_171558_().m_171514_(354, 0).m_171488_(-4.0f, -5.0f, -45.0f, 9.0f, 10.0f, 48.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)10.0f, (float)10.0f, (float)-63.0f));
        PartDefinition left_filter1 = left_mandible.m_171599_("left_filter1", CubeListBuilder.m_171558_().m_171514_(382, 424).m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.5f, (float)5.0f, (float)-41.5f, (float)0.0f, (float)-0.1745f, (float)0.0f));
        PartDefinition left_filter2 = left_mandible.m_171599_("left_filter2", CubeListBuilder.m_171558_().m_171514_(396, 424).m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.5f, (float)5.0f, (float)-37.5f, (float)0.0f, (float)-0.1745f, (float)0.0f));
        PartDefinition left_filter3 = left_mandible.m_171599_("left_filter3", CubeListBuilder.m_171558_().m_171514_(0, 425).m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.5f, (float)5.0f, (float)-33.5f, (float)0.0f, (float)-0.1745f, (float)0.0f));
        PartDefinition left_filter4 = left_mandible.m_171599_("left_filter4", CubeListBuilder.m_171558_().m_171514_(14, 425).m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.5f, (float)5.0f, (float)-29.5f, (float)0.0f, (float)-0.1745f, (float)0.0f));
        PartDefinition left_filter5 = left_mandible.m_171599_("left_filter5", CubeListBuilder.m_171558_().m_171514_(28, 425).m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.5f, (float)5.0f, (float)-25.5f, (float)0.0f, (float)-0.1745f, (float)0.0f));
        PartDefinition left_filter6 = left_mandible.m_171599_("left_filter6", CubeListBuilder.m_171558_().m_171514_(42, 425).m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.5f, (float)5.0f, (float)-21.5f, (float)0.0f, (float)-0.1745f, (float)0.0f));
        PartDefinition right_mandible = head.m_171599_("right_mandible", CubeListBuilder.m_171558_().m_171514_(354, 0).m_171480_().m_171488_(-5.0f, -5.0f, -45.0f, 9.0f, 10.0f, 48.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-10.0f, (float)10.0f, (float)-63.0f));
        PartDefinition right_filter1 = right_mandible.m_171599_("right_filter1", CubeListBuilder.m_171558_().m_171514_(382, 424).m_171480_().m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-0.5f, (float)5.0f, (float)-41.5f, (float)0.0f, (float)0.1745f, (float)0.0f));
        PartDefinition right_filter2 = right_mandible.m_171599_("right_filter2", CubeListBuilder.m_171558_().m_171514_(396, 424).m_171480_().m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-0.5f, (float)5.0f, (float)-37.5f, (float)0.0f, (float)0.1745f, (float)0.0f));
        PartDefinition right_filter3 = right_mandible.m_171599_("right_filter3", CubeListBuilder.m_171558_().m_171514_(0, 425).m_171480_().m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-0.5f, (float)5.0f, (float)-33.5f, (float)0.0f, (float)0.1745f, (float)0.0f));
        PartDefinition right_filter4 = right_mandible.m_171599_("right_filter4", CubeListBuilder.m_171558_().m_171514_(14, 425).m_171480_().m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-0.5f, (float)5.0f, (float)-29.5f, (float)0.0f, (float)0.1745f, (float)0.0f));
        PartDefinition right_filter5 = right_mandible.m_171599_("right_filter5", CubeListBuilder.m_171558_().m_171514_(28, 425).m_171480_().m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-0.5f, (float)5.0f, (float)-25.5f, (float)0.0f, (float)0.1745f, (float)0.0f));
        PartDefinition right_filter6 = right_mandible.m_171599_("right_filter6", CubeListBuilder.m_171558_().m_171514_(42, 425).m_171480_().m_171488_(-2.5f, 0.0f, -1.0f, 5.0f, 37.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-0.5f, (float)5.0f, (float)-21.5f, (float)0.0f, (float)0.1745f, (float)0.0f));
        PartDefinition segment1 = body.m_171599_("segment1", CubeListBuilder.m_171558_().m_171514_(0, 293).m_171488_(-28.0f, -24.0f, 8.0f, 56.0f, 49.0f, 23.0f, new CubeDeformation(0.0f)).m_171514_(0, 365).m_171488_(-18.0f, -14.0f, -2.0f, 36.0f, 29.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_fin1 = segment1.m_171599_("left_fin1", CubeListBuilder.m_171558_().m_171514_(314, 382).m_171488_(0.0f, -2.0f, -8.5f, 34.0f, 4.0f, 17.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)28.0f, (float)20.0f, (float)19.5f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin1 = segment1.m_171599_("right_fin1", CubeListBuilder.m_171558_().m_171514_(314, 382).m_171480_().m_171488_(-34.0f, -2.0f, -6.5f, 34.0f, 4.0f, 17.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-28.0f, (float)20.0f, (float)17.5f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition segment2 = segment1.m_171599_("segment2", CubeListBuilder.m_171558_().m_171514_(0, 293).m_171488_(-28.0f, -24.0f, 9.0f, 56.0f, 49.0f, 23.0f, new CubeDeformation(0.0f)).m_171514_(0, 365).m_171488_(-18.0f, -14.0f, -1.0f, 36.0f, 29.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)28.0f));
        PartDefinition left_rudder1 = segment2.m_171599_("left_rudder1", CubeListBuilder.m_171558_().m_171514_(314, 403).m_171488_(0.0f, -2.0f, -8.5f, 34.0f, 4.0f, 17.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)28.0f, (float)-19.0f, (float)22.5f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_rudder1 = segment2.m_171599_("right_rudder1", CubeListBuilder.m_171558_().m_171514_(314, 403).m_171480_().m_171488_(-34.0f, -2.0f, -8.5f, 34.0f, 4.0f, 17.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-28.0f, (float)-19.0f, (float)20.5f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition left_fin2 = segment2.m_171599_("left_fin2", CubeListBuilder.m_171558_().m_171514_(0, 404).m_171488_(0.0f, -2.0f, -8.5f, 34.0f, 4.0f, 17.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)28.0f, (float)20.0f, (float)20.5f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin2 = segment2.m_171599_("right_fin2", CubeListBuilder.m_171558_().m_171514_(102, 411).m_171488_(-34.0f, -2.077f, -8.5f, 34.0f, 4.0f, 17.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)-28.0f, (float)20.0f, (float)20.5f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition segment3 = segment2.m_171599_("segment3", CubeListBuilder.m_171558_().m_171514_(158, 340).m_171488_(-28.0f, -24.0f, 8.0f, 56.0f, 49.0f, 22.0f, new CubeDeformation(0.0f)).m_171514_(0, 365).m_171488_(-18.0f, -14.0f, -2.0f, 36.0f, 29.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)29.0f));
        PartDefinition left_rudder2 = segment3.m_171599_("left_rudder2", CubeListBuilder.m_171558_().m_171514_(416, 400).m_171488_(0.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)28.0f, (float)-19.0f, (float)19.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_rudder2 = segment3.m_171599_("right_rudder2", CubeListBuilder.m_171558_().m_171514_(416, 400).m_171480_().m_171488_(-23.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-28.0f, (float)-19.0f, (float)19.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition left_fin3 = segment3.m_171599_("left_fin3", CubeListBuilder.m_171558_().m_171514_(416, 418).m_171488_(0.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)28.0f, (float)20.0f, (float)19.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin3 = segment3.m_171599_("right_fin3", CubeListBuilder.m_171558_().m_171514_(416, 418).m_171480_().m_171488_(-23.866f, -2.5f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-27.0f, (float)20.0f, (float)19.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition segment4 = segment3.m_171599_("segment4", CubeListBuilder.m_171558_().m_171514_(158, 340).m_171488_(-28.0f, -24.0f, 8.0f, 56.0f, 49.0f, 22.0f, new CubeDeformation(0.0f)).m_171514_(0, 365).m_171488_(-18.0f, -14.0f, -2.0f, 36.0f, 29.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)27.0f));
        PartDefinition left_rudder3 = segment4.m_171599_("left_rudder3", CubeListBuilder.m_171558_().m_171514_(416, 400).m_171488_(0.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)28.0f, (float)-19.0f, (float)19.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_rudder3 = segment4.m_171599_("right_rudder3", CubeListBuilder.m_171558_().m_171514_(416, 400).m_171480_().m_171488_(-23.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-28.0f, (float)-19.0f, (float)19.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin4 = segment4.m_171599_("right_fin4", CubeListBuilder.m_171558_().m_171514_(158, 293).m_171480_().m_171488_(-23.5f, -1.134f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-28.0f, (float)19.0f, (float)19.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition left_fin4 = segment4.m_171599_("left_fin4", CubeListBuilder.m_171558_().m_171514_(158, 293).m_171488_(0.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)28.0f, (float)20.0f, (float)19.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition segment5 = segment4.m_171599_("segment5", CubeListBuilder.m_171558_().m_171514_(354, 104).m_171488_(-18.0f, -13.0f, 3.0f, 36.0f, 26.0f, 20.0f, new CubeDeformation(0.0f)).m_171514_(278, 424).m_171488_(-11.0f, -6.0f, -4.0f, 22.0f, 12.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)31.0f));
        PartDefinition left_rudder4 = segment5.m_171599_("left_rudder4", CubeListBuilder.m_171558_().m_171514_(204, 411).m_171488_(0.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)18.0f, (float)-10.0f, (float)13.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_rudder4 = segment5.m_171599_("right_rudder4", CubeListBuilder.m_171558_().m_171514_(204, 411).m_171480_().m_171488_(-23.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-18.0f, (float)-10.0f, (float)13.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition left_fin5 = segment5.m_171599_("left_fin5", CubeListBuilder.m_171558_().m_171514_(416, 382).m_171488_(0.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)18.0f, (float)10.0f, (float)13.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin5 = segment5.m_171599_("right_fin5", CubeListBuilder.m_171558_().m_171514_(416, 382).m_171480_().m_171488_(-23.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-18.0f, (float)10.0f, (float)13.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition Segment6 = segment5.m_171599_("Segment6", CubeListBuilder.m_171558_().m_171514_(354, 58).m_171488_(-18.0f, -13.0f, 3.0f, 36.0f, 26.0f, 20.0f, new CubeDeformation(0.0f)).m_171514_(278, 424).m_171488_(-11.0f, -6.0f, -4.0f, 22.0f, 12.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)24.0f));
        PartDefinition left_rudder5 = Segment6.m_171599_("left_rudder5", CubeListBuilder.m_171558_().m_171514_(204, 411).m_171488_(0.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)18.0f, (float)-10.0f, (float)13.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_rudder5 = Segment6.m_171599_("right_rudder5", CubeListBuilder.m_171558_().m_171514_(204, 411).m_171480_().m_171488_(-23.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-18.0f, (float)-10.0f, (float)13.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition left_fin6 = Segment6.m_171599_("left_fin6", CubeListBuilder.m_171558_().m_171514_(158, 311).m_171488_(0.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)18.0f, (float)10.0f, (float)13.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition right_fin6 = Segment6.m_171599_("right_fin6", CubeListBuilder.m_171558_().m_171514_(158, 311).m_171480_().m_171488_(-23.0f, -2.0f, -7.0f, 23.0f, 4.0f, 14.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-18.0f, (float)10.0f, (float)13.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)512, (int)512);
    }

    public void setupAnim(@NotNull Aegirocassis entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        float partialTicks = ageInTicks - (float)entity.f_19797_;
        float deg = (float)Math.PI / 180;
        double bodyYRot = Mth.m_14177_((float)(entity.f_20884_ + (entity.f_20883_ - entity.f_20884_) * partialTicks));
        if (entity.m_20069_() || entity.isLeaping() && !entity.isTryingToFly()) {
            this.m_267799_(AegirocassisAnimations.MOUTH_SWIM_OVERLAY, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            this.m_267799_(AegirocassisAnimations.SWIM, limbSwing, limbSwingAmount, 1.625f, 3.25f);
        }
        this.animateIdleSmooth(entity.swimIdleAnimationState, AegirocassisAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateIdleSmooth(entity.mouthAnimationState, AegirocassisAnimations.MOUTH_IDLE_OVERLAY, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.eyesAnimationState, AegirocassisAnimations.EYE_OVERLAY, ageInTicks);
        this.animateSmooth(entity.flopAnimationState, AegirocassisAnimations.BEACHED, ageInTicks);
        this.animateSmooth(entity.leapStartAnimationState, AegirocassisLeapAnimations.LEAP_START, ageInTicks);
        this.animateSmooth(entity.leapAnimationState, AegirocassisLeapAnimations.LEAP_HOLD, ageInTicks);
        double segment1Y = (double)entity.getTrailTransformation(5, partialTicks) - bodyYRot;
        double segment2Y = (double)entity.getTrailTransformation(10, partialTicks) - bodyYRot - segment1Y;
        double segment3Y = (double)entity.getTrailTransformation(15, partialTicks) - bodyYRot - segment2Y;
        double segment4Y = (double)entity.getTrailTransformation(20, partialTicks) - bodyYRot - segment3Y;
        double segment5Y = (double)entity.getTrailTransformation(25, partialTicks) - bodyYRot - segment4Y;
        this.segment2.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)segment1Y) * (double)0.4f);
        this.segment3.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)segment2Y) * (double)0.3f);
        this.segment4.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)segment2Y) * (double)0.3f);
        this.segment5.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)segment3Y) * (double)0.2f);
        this.segment6.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)segment4Y) * (double)0.1f);
        if (entity.m_20069_() && !entity.isTryingToFly()) {
            this.swim_control.f_104203_ = headPitch * deg / 3.0f;
        }
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


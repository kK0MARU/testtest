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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.PalaeophisAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Palaeophis;
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
public class PalaeophisModel
extends UP2Model<Palaeophis> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart head_rotate;
    private final ModelPart head;
    private final ModelPart upper_jaw;
    private final ModelPart jaw;
    private final ModelPart tongue;
    private final ModelPart dewlap;
    private final ModelPart body_rotate1;
    private final ModelPart body1;
    private final ModelPart body_rotate2;
    private final ModelPart body2;
    private final ModelPart body_rotate3;
    private final ModelPart body3;
    private final ModelPart body_rotate4;
    private final ModelPart body4;
    private final ModelPart body_rotate5;
    private final ModelPart body5;
    private final ModelPart tail_rotate1;
    private final ModelPart tail1;
    private final ModelPart tail_rotate2;
    private final ModelPart tail2;
    private final ModelPart tail_rotate3;
    private final ModelPart tail3;

    public PalaeophisModel(ModelPart root) {
        super(0.25f, 72.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.head_rotate = this.body_main.m_171324_("head_rotate");
        this.head = this.head_rotate.m_171324_("head");
        this.upper_jaw = this.head.m_171324_("upper_jaw");
        this.jaw = this.head.m_171324_("jaw");
        this.tongue = this.jaw.m_171324_("tongue");
        this.dewlap = this.jaw.m_171324_("dewlap");
        this.body_rotate1 = this.head.m_171324_("body_rotate1");
        this.body1 = this.body_rotate1.m_171324_("body1");
        this.body_rotate2 = this.body1.m_171324_("body_rotate2");
        this.body2 = this.body_rotate2.m_171324_("body2");
        this.body_rotate3 = this.body2.m_171324_("body_rotate3");
        this.body3 = this.body_rotate3.m_171324_("body3");
        this.body_rotate4 = this.body3.m_171324_("body_rotate4");
        this.body4 = this.body_rotate4.m_171324_("body4");
        this.body_rotate5 = this.body4.m_171324_("body_rotate5");
        this.body5 = this.body_rotate5.m_171324_("body5");
        this.tail_rotate1 = this.body5.m_171324_("tail_rotate1");
        this.tail1 = this.tail_rotate1.m_171324_("tail1");
        this.tail_rotate2 = this.tail1.m_171324_("tail_rotate2");
        this.tail2 = this.tail_rotate2.m_171324_("tail2");
        this.tail_rotate3 = this.tail2.m_171324_("tail_rotate3");
        this.tail3 = this.tail_rotate3.m_171324_("tail3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-9.0f, (float)76.0f));
        PartDefinition head_rotate = body_main.m_171599_("head_rotate", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)4.0f, (float)-89.0f));
        PartDefinition head = head_rotate.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition upper_jaw = head.m_171599_("upper_jaw", CubeListBuilder.m_171558_().m_171514_(54, 170).m_171488_(-7.0f, -2.0f, -5.0f, 14.0f, 2.0f, 7.0f, new CubeDeformation(0.01f)).m_171514_(56, 181).m_171488_(-5.0f, -1.0f, -21.0f, 10.0f, 5.0f, 13.0f, new CubeDeformation(0.01f)).m_171514_(182, 21).m_171488_(-5.0f, 4.0f, -21.0f, 10.0f, 3.0f, 16.0f, new CubeDeformation(0.0f)).m_171514_(167, 21).m_171488_(-1.5f, 4.0f, -16.0f, 3.0f, 1.0f, 11.0f, new CubeDeformation(0.0f)).m_171514_(180, 40).m_171488_(-7.0f, -2.0f, -8.0f, 14.0f, 6.0f, 3.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)-2.0f));
        PartDefinition crest_r1 = upper_jaw.m_171599_("crest_r1", CubeListBuilder.m_171558_().m_171514_(134, 180).m_171480_().m_171488_(0.0f, -4.0f, -4.0f, 0.0f, 4.0f, 7.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-3.25f, (float)0.0f, (float)-11.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition crest_r2 = upper_jaw.m_171599_("crest_r2", CubeListBuilder.m_171558_().m_171514_(134, 180).m_171488_(0.0f, -4.0f, -4.0f, 0.0f, 4.0f, 7.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)3.25f, (float)0.0f, (float)-11.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(96, 125).m_171488_(-5.0f, 4.0f, -21.0f, 10.0f, 3.0f, 13.0f, new CubeDeformation(0.01f)).m_171514_(115, 47).m_171488_(-7.0f, 4.0f, -8.0f, 14.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(54, 156).m_171488_(-7.0f, 0.0f, -5.0f, 14.0f, 7.0f, 7.0f, new CubeDeformation(0.0f)).m_171514_(182, 1).m_171488_(-5.0f, 1.0f, -21.0f, 10.0f, 3.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)-2.0f));
        PartDefinition tongue = jaw.m_171599_("tongue", CubeListBuilder.m_171558_().m_171514_(101, 180).m_171488_(-2.0f, 0.0f, -15.0f, 4.0f, 0.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)2.0f, (float)-5.0f));
        PartDefinition dewlap = jaw.m_171599_("dewlap", CubeListBuilder.m_171558_().m_171514_(99, 154).m_171488_(-3.0f, 0.0f, -11.0f, 6.0f, 5.0f, 21.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)7.0f, (float)2.0f));
        PartDefinition body_rotate1 = head.m_171599_("body_rotate1", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body1 = body_rotate1.m_171599_("body1", CubeListBuilder.m_171558_().m_171514_(160, 154).m_171488_(-5.5f, -5.0f, 0.0f, 11.0f, 10.0f, 17.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body_rotate2 = body1.m_171599_("body_rotate2", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-1.0f, (float)16.0f));
        PartDefinition body2 = body_rotate2.m_171599_("body2", CubeListBuilder.m_171558_().m_171514_(104, 53).m_171488_(-6.5f, -7.0f, 1.0f, 13.0f, 13.0f, 37.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body_rotate3 = body2.m_171599_("body_rotate3", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-3.0f, (float)37.0f));
        PartDefinition body3 = body_rotate3.m_171599_("body3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-9.5f, -9.0f, 1.0f, 19.0f, 18.0f, 35.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body_rotate4 = body3.m_171599_("body_rotate4", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)36.0f));
        PartDefinition body4 = body_rotate4.m_171599_("body4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-9.5f, -9.0f, 0.0f, 19.0f, 18.0f, 35.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body_rotate5 = body4.m_171599_("body_rotate5", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)4.0f, (float)35.0f));
        PartDefinition body5 = body_rotate5.m_171599_("body5", CubeListBuilder.m_171558_().m_171514_(0, 53).m_171488_(-7.5f, -11.0f, 0.0f, 15.0f, 16.0f, 37.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition tail_rotate1 = body5.m_171599_("tail_rotate1", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)37.0f));
        PartDefinition tail1 = tail_rotate1.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(0, 106).m_171488_(-5.5f, -8.0f, 0.0f, 11.0f, 13.0f, 37.0f, new CubeDeformation(0.0f)).m_171514_(0, 156).m_171488_(-0.5f, 5.0f, 11.0f, 1.0f, 7.0f, 26.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition tail_rotate2 = tail1.m_171599_("tail_rotate2", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-4.0f, (float)37.0f));
        PartDefinition tail2 = tail_rotate2.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(104, 103).m_171488_(-2.5f, -4.0f, 0.0f, 5.0f, 8.0f, 43.0f, new CubeDeformation(0.0f)).m_171514_(108, 0).m_171488_(-0.5f, 4.0f, 0.0f, 1.0f, 12.0f, 35.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition tail_rotate3 = tail2.m_171599_("tail_rotate3", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)35.0f));
        PartDefinition tail3 = tail_rotate3.m_171599_("tail3", CubeListBuilder.m_171558_().m_171514_(157, 103).m_171488_(-0.5f, -1.0f, 0.0f, 1.0f, 17.0f, 26.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Palaeophis entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (entity.m_20069_()) {
            this.m_267799_(PalaeophisAnimations.SWIM, limbSwing, limbSwingAmount, 1.25f, 2.5f);
            this.animateIdle(entity.idleAnimationState, PalaeophisAnimations.SWIM, ageInTicks, 0.8f, limbSwingAmount * 2.0f);
        } else {
            this.m_233381_(entity.idleAnimationState, PalaeophisAnimations.IDLE, ageInTicks);
        }
        float deg = (float)Math.PI / 180;
        float partialTicks = ageInTicks - (float)entity.f_19797_;
        double defaultY = Mth.m_14177_((float)(entity.f_20884_ + (entity.f_20883_ - entity.f_20884_) * partialTicks));
        double tail1Y = (double)entity.getTrailTransformation(8, partialTicks) - defaultY;
        double tail2Y = (double)entity.getTrailTransformation(15, partialTicks) - defaultY - tail1Y;
        double tail3Y = (double)entity.getTrailTransformation(21, partialTicks) - defaultY - tail2Y;
        double tail4Y = (double)entity.getTrailTransformation(26, partialTicks) - defaultY - tail3Y;
        double tail5Y = (double)entity.getTrailTransformation(30, partialTicks) - defaultY - tail4Y;
        double tail6Y = (double)entity.getTrailTransformation(33, partialTicks) - defaultY - tail5Y;
        double tail7Y = (double)entity.getTrailTransformation(35, partialTicks) - defaultY - tail6Y;
        float swimPitch = Mth.m_14179_((float)0.2f, (float)this.root.f_104203_, (float)Mth.m_14036_((float)(headPitch * deg), (float)-0.4f, (float)0.4f));
        this.root.f_104203_ += swimPitch * 0.35f;
        this.head.f_104203_ += swimPitch * 0.4f;
        this.body_main.f_104203_ += swimPitch * 0.4f;
        this.body1.f_104203_ += swimPitch * 0.35f;
        this.body2.f_104203_ += swimPitch * 0.35f;
        this.body3.f_104203_ += swimPitch * 0.3f;
        this.body4.f_104203_ += swimPitch * 0.3f;
        this.tail1.f_104203_ += swimPitch * 0.2f;
        this.tail2.f_104203_ += swimPitch * 0.25f;
        this.tail3.f_104203_ += swimPitch * 0.1f;
        this.body_rotate1.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail1Y) * (double)0.35f);
        this.body_rotate2.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail2Y) * (double)0.35f);
        this.body_rotate3.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail3Y) * (double)0.4f);
        this.body_rotate4.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail4Y) * (double)0.4f);
        this.tail_rotate1.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail5Y) * (double)0.4f);
        this.tail_rotate2.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail6Y) * 0.25);
        this.tail_rotate3.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail7Y) * (double)0.1f);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


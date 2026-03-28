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

import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Wonambi;
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
public class WonambiModel
extends UP2Model<Wonambi> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart tongue;
    private final ModelPart neck;
    private final ModelPart neck2;
    private final ModelPart neck3;
    private final ModelPart body1;
    private final ModelPart body2;
    private final ModelPart body3;
    private final ModelPart body4;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;

    public WonambiModel(ModelPart root) {
        super(0.25f, 72.0f);
        this.root = root.m_171324_("root");
        this.head = this.root.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.tongue = this.jaw.m_171324_("tongue");
        this.neck = this.head.m_171324_("neck");
        this.neck2 = this.neck.m_171324_("neck2");
        this.neck3 = this.neck2.m_171324_("neck3");
        this.body1 = this.neck3.m_171324_("body1");
        this.body2 = this.body1.m_171324_("body2");
        this.body3 = this.body2.m_171324_("body3");
        this.body4 = this.body3.m_171324_("body4");
        this.tail1 = this.body4.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
        this.tail3 = this.tail2.m_171324_("tail3");
        this.tail4 = this.tail3.m_171324_("tail4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)21.0f, (float)41.0f));
        PartDefinition head = root.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(28, 29).m_171488_(-3.0f, -2.0f, -6.0f, 6.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(32, 8).m_171488_(-2.0f, -2.0f, -10.0f, 4.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(14, 39).m_171488_(2.0f, -3.0f, -6.0f, 1.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(14, 39).m_171480_().m_171488_(-3.0f, -3.0f, -6.0f, 1.0f, 1.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(40, 37).m_171488_(-1.0f, -2.0f, -12.0f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)-44.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(24, 37).m_171488_(-2.0f, 0.0f, -10.0f, 4.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(0, 31).m_171488_(-3.0f, 0.0f, -6.0f, 6.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(0, 39).m_171488_(1.5f, -1.0f, -9.0f, 0.0f, 1.0f, 7.0f, new CubeDeformation(0.0025f)).m_171514_(0, 39).m_171480_().m_171488_(-1.5f, -1.0f, -9.0f, 0.0f, 1.0f, 7.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition tongue = jaw.m_171599_("tongue", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.5f, 0.0f, -8.0f, 3.0f, 0.0f, 8.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-2.0f));
        PartDefinition neck = head.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(28, 43).m_171488_(-2.0f, -2.5f, 0.0f, 4.0f, 5.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-0.5f, (float)0.0f));
        PartDefinition neck2 = neck.m_171599_("neck2", CubeListBuilder.m_171558_().m_171514_(28, 16).m_171488_(-2.0f, -2.5f, 0.0f, 4.0f, 5.0f, 8.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)8.0f));
        PartDefinition neck3 = neck2.m_171599_("neck3", CubeListBuilder.m_171558_().m_171514_(28, 16).m_171488_(-2.0f, -2.5f, 0.0f, 4.0f, 5.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)8.0f));
        PartDefinition body1 = neck3.m_171599_("body1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-0.5f, (float)8.0f));
        PartDefinition body2 = body1.m_171599_("body2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 10.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)10.0f));
        PartDefinition body3 = body2.m_171599_("body3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)10.0f));
        PartDefinition body4 = body3.m_171599_("body4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 10.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)10.0f));
        PartDefinition tail1 = body4.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(28, 16).m_171488_(-2.0f, -2.5f, 0.0f, 4.0f, 5.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)10.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(28, 16).m_171488_(-2.0f, -2.5f, 0.0f, 4.0f, 5.0f, 8.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)8.0f));
        PartDefinition tail3 = tail2.m_171599_("tail3", CubeListBuilder.m_171558_().m_171514_(28, 16).m_171488_(-2.0f, -2.5f, 0.0f, 4.0f, 5.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)8.0f));
        PartDefinition tail4 = tail3.m_171599_("tail4", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-1.0f, -1.5f, 0.0f, 2.0f, 3.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)8.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(Wonambi entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        float deg = (float)Math.PI / 180;
        float partialTicks = ageInTicks - (float)entity.f_19797_;
        double defaultY = Mth.m_14177_((float)(entity.f_20884_ + (entity.f_20883_ - entity.f_20884_) * partialTicks));
        double tail1Y = (double)entity.getTrailTransformation(10, partialTicks) - defaultY;
        double tail2Y = (double)entity.getTrailTransformation(19, partialTicks) - defaultY - tail1Y;
        double tail3Y = (double)entity.getTrailTransformation(28, partialTicks) - defaultY - tail2Y;
        double tail4Y = (double)entity.getTrailTransformation(36, partialTicks) - defaultY - tail3Y;
        double tail5Y = (double)entity.getTrailTransformation(43, partialTicks) - defaultY - tail4Y;
        double tail6Y = (double)entity.getTrailTransformation(49, partialTicks) - defaultY - tail5Y;
        double tail7Y = (double)entity.getTrailTransformation(54, partialTicks) - defaultY - tail6Y;
        double tail8Y = (double)entity.getTrailTransformation(58, partialTicks) - defaultY - tail7Y;
        double tail9Y = (double)entity.getTrailTransformation(61, partialTicks) - defaultY - tail8Y;
        double tail10Y = (double)entity.getTrailTransformation(63, partialTicks) - defaultY - tail9Y;
        this.neck.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail1Y) * 0.5);
        this.neck2.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail2Y) * 0.5);
        this.neck3.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail3Y) * 0.5);
        this.body1.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail4Y) * 0.5);
        this.body2.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail5Y) * (double)0.4f);
        this.body3.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail6Y) * (double)0.35f);
        this.body4.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail7Y) * (double)0.4f);
        this.tail1.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail8Y) * (double)0.45f);
        this.tail2.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail9Y) * (double)0.35f);
        this.tail3.f_104204_ += (float)Math.toRadians(Mth.m_14175_((double)tail10Y) * (double)0.3f);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


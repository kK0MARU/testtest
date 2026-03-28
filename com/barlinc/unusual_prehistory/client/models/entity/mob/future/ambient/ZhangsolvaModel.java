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
package com.barlinc.unusual_prehistory.client.models.entity.mob.future.ambient;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.ambient.ZhangsolvaAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.ambient.Zhangsolva;
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
public class ZhangsolvaModel
extends UP2Model<Zhangsolva> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart proboscis;
    private final ModelPart right_wing;
    private final ModelPart left_wing;
    private final ModelPart left_leg1;
    private final ModelPart right_leg1;
    private final ModelPart left_leg2;
    private final ModelPart right_leg2;
    private final ModelPart left_leg3;
    private final ModelPart right_leg3;

    public ZhangsolvaModel(ModelPart root) {
        super(1.0f, 0.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.proboscis = this.body.m_171324_("proboscis");
        this.right_wing = this.body.m_171324_("right_wing");
        this.left_wing = this.body.m_171324_("left_wing");
        this.left_leg1 = this.body_main.m_171324_("left_leg1");
        this.right_leg1 = this.body_main.m_171324_("right_leg1");
        this.left_leg2 = this.body_main.m_171324_("left_leg2");
        this.right_leg2 = this.body_main.m_171324_("right_leg2");
        this.left_leg3 = this.body_main.m_171324_("left_leg3");
        this.right_leg3 = this.body_main.m_171324_("right_leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5f, -3.0f, -4.0f, 3.0f, 3.0f, 9.0f, new CubeDeformation(0.0f)).m_171514_(14, 12).m_171488_(0.5f, -4.0f, -3.0f, 2.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(14, 12).m_171480_().m_171488_(-2.5f, -4.0f, -3.0f, 2.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition proboscis = body.m_171599_("proboscis", CubeListBuilder.m_171558_().m_171514_(20, 23).m_171488_(0.0f, 0.0f, -6.0f, 0.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)-1.0f, (float)-4.0f, (float)0.7854f, (float)0.0f, (float)0.0f));
        PartDefinition right_wing = body.m_171599_("right_wing", CubeListBuilder.m_171558_().m_171514_(0, 22).m_171480_().m_171488_(0.0f, -4.0f, -1.0f, 0.0f, 4.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-1.5f, (float)-3.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition left_wing = body.m_171599_("left_wing", CubeListBuilder.m_171558_().m_171514_(0, 22).m_171488_(0.0f, -4.0f, -1.0f, 0.0f, 4.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)1.5f, (float)-3.0f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition left_leg1 = body_main.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(8, 23).m_171488_(0.0f, 0.0f, -1.0f, 0.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)1.4f, (float)0.0f, (float)1.0f, (float)-0.4363f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg1 = body_main.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(8, 23).m_171480_().m_171488_(0.0f, 0.0f, -1.0f, 0.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-1.4f, (float)0.0f, (float)1.0f, (float)-0.4363f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = body_main.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(8, 24).m_171488_(0.0f, 0.0f, 0.0f, 1.0f, 3.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.25f, (float)0.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)-0.4363f));
        PartDefinition right_leg2 = body_main.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(8, 24).m_171480_().m_171488_(-1.0f, 0.0f, 0.0f, 1.0f, 3.0f, 0.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-0.25f, (float)0.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)0.4363f));
        PartDefinition left_leg3 = body_main.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(8, 23).m_171488_(0.04f, 0.0f, 0.0f, 0.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)1.3f, (float)0.0f, (float)1.0f, (float)0.4363f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg3 = body_main.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(8, 23).m_171480_().m_171488_(-0.04f, 0.0f, 0.0f, 0.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-1.3f, (float)0.0f, (float)1.0f, (float)0.4363f, (float)0.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)32, (int)32);
    }

    public void setupAnim(@NotNull Zhangsolva entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.animateIdleSmooth(entity.idleAnimationState, ZhangsolvaAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.flyAnimationState, ZhangsolvaAnimations.FLY, ageInTicks);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.BrachiosaurusBabyAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Brachiosaurus;
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
public class BrachiosaurusBabyModel
extends UP2Model<Brachiosaurus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body_upper;
    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart back;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart arm_control;
    private final ModelPart left_arm1;
    private final ModelPart right_arm1;
    private final ModelPart leg_control;
    private final ModelPart left_leg1;
    private final ModelPart right_leg1;

    public BrachiosaurusBabyModel(ModelPart root) {
        super(1.0f, 0.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body_upper = this.body_main.m_171324_("body_upper");
        this.body = this.body_upper.m_171324_("body");
        this.neck = this.body.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.back = this.body.m_171324_("back");
        this.tail1 = this.back.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
        this.arm_control = this.body_upper.m_171324_("arm_control");
        this.left_arm1 = this.arm_control.m_171324_("left_arm1");
        this.right_arm1 = this.arm_control.m_171324_("right_arm1");
        this.leg_control = this.body_main.m_171324_("leg_control");
        this.left_leg1 = this.leg_control.m_171324_("left_leg1");
        this.right_leg1 = this.leg_control.m_171324_("right_leg1");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-12.0f, (float)0.0f));
        PartDefinition body_upper = body_main.m_171599_("body_upper", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)6.0f, (float)6.5f));
        PartDefinition body = body_upper.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-5.0f, -6.0f, -9.0f, 10.0f, 12.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-6.0f, (float)-6.5f));
        PartDefinition neck = body.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5f, -34.5f, -3.5f, 5.0f, 38.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-2.5f, (float)-8.5f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(18, 49).m_171488_(-1.5f, -2.5f, -4.0f, 3.0f, 5.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(12, 54).m_171488_(0.0f, -2.5f, -7.0f, 0.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(44, 55).m_171488_(-1.5f, 0.5f, -8.0f, 3.0f, 2.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-32.0f, (float)-3.5f));
        PartDefinition back = body.m_171599_("back", CubeListBuilder.m_171558_().m_171514_(24, 24).m_171488_(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)3.0f));
        PartDefinition tail1 = back.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171488_(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 7.0f, new CubeDeformation(0.1f)), PartPose.m_171419_((float)0.0f, (float)2.0f, (float)6.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(48, 24).m_171488_(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)7.0f));
        PartDefinition arm_control = body_upper.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-11.5f));
        PartDefinition left_arm1 = arm_control.m_171599_("left_arm1", CubeListBuilder.m_171558_().m_171514_(24, 36).m_171480_().m_171488_(-2.0f, 0.0f, -2.0f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(32, 49).m_171480_().m_171488_(-2.0f, 7.0f, -2.0f, 4.0f, 2.0f, 4.0f, new CubeDeformation(0.25f)).m_171555_(false), PartPose.m_171419_((float)2.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm1 = arm_control.m_171599_("right_arm1", CubeListBuilder.m_171558_().m_171514_(24, 36).m_171488_(-2.0f, 0.0f, -2.0f, 4.0f, 9.0f, 4.0f, new CubeDeformation(0.0f)).m_171514_(32, 49).m_171488_(-2.0f, 7.0f, -2.0f, 4.0f, 2.0f, 4.0f, new CubeDeformation(0.25f)), PartPose.m_171419_((float)-2.5f, (float)0.0f, (float)0.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)6.0f, (float)6.5f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(0, 54).m_171480_().m_171488_(-1.5f, 0.0f, -1.5f, 3.0f, 6.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(56, 33).m_171480_().m_171488_(-1.5f, 4.0f, -1.5f, 3.0f, 2.0f, 3.0f, new CubeDeformation(0.25f)).m_171555_(false), PartPose.m_171419_((float)2.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(0, 54).m_171488_(-1.5f, 0.0f, -1.5f, 3.0f, 6.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(56, 33).m_171488_(-1.5f, 4.0f, -1.5f, 3.0f, 2.0f, 3.0f, new CubeDeformation(0.25f)), PartPose.m_171419_((float)-2.5f, (float)0.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(@NotNull Brachiosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (entity.isRunning()) {
            this.m_267799_(BrachiosaurusBabyAnimations.RUN, limbSwing, limbSwingAmount, 1.0f, 2.0f);
        } else {
            this.m_267799_(BrachiosaurusBabyAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        }
        this.animateIdleSmooth(entity.idleAnimationState, BrachiosaurusBabyAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.head.f_104203_ += headPitch * ((float)Math.PI / 180) / 6.0f;
        this.head.f_104204_ += netHeadYaw * ((float)Math.PI / 180) / 6.0f;
        this.neck.f_104203_ += headPitch * ((float)Math.PI / 180) / 4.0f;
        this.neck.f_104204_ += netHeadYaw * ((float)Math.PI / 180) / 4.0f;
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


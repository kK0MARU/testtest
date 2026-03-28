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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.TherizinosaurusBabyAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Therizinosaurus;
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
public class TherizinosaurusBabyModel
extends UP2Model<Therizinosaurus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart body_adjust;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart tail;
    private final ModelPart tail_adjust;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart leg_control;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart left_leg3;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;
    private final ModelPart right_leg3;

    public TherizinosaurusBabyModel(ModelPart root) {
        super(1.0f, 0.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.body_adjust = this.body.m_171324_("body_adjust");
        this.neck = this.body_adjust.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.tail = this.body_adjust.m_171324_("tail");
        this.tail_adjust = this.tail.m_171324_("tail_adjust");
        this.left_arm = this.body_adjust.m_171324_("left_arm");
        this.right_arm = this.body_adjust.m_171324_("right_arm");
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
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-7.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body_adjust = body.m_171599_("body_adjust", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0f, -10.0f, -3.0f, 8.0f, 11.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)0.6109f, (float)0.0f, (float)0.0f));
        PartDefinition neck = body_adjust.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-2.0f, -11.0f, -2.5f, 4.0f, 11.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-10.0f, (float)2.5f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 34).m_171488_(-2.0f, -2.0f, -6.0f, 4.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(42, 16).m_171488_(2.0f, -2.0f, -1.0f, 1.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(42, 16).m_171480_().m_171488_(-3.0f, -2.0f, -1.0f, 1.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)-9.0f, (float)-2.5f));
        PartDefinition cube_r1 = head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(42, 27).m_171488_(0.8112f, 0.6383f, -2.3112f, 0.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)-4.5837f, (float)2.6795f, (float)0.0f, (float)0.7854f, (float)0.0f));
        PartDefinition cube_r2 = head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(42, 22).m_171488_(-0.8112f, 0.6383f, -2.3112f, 0.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)-4.5837f, (float)2.6795f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition tail = body_adjust.m_171599_("tail", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.5f, (float)4.25f));
        PartDefinition tail_adjust = tail.m_171599_("tail_adjust", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.6109f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm = body_adjust.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(30, 19).m_171488_(0.0f, -1.0f, 0.0f, 0.0f, 16.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)4.0f, (float)-9.0f, (float)-1.0f, (float)-1.5708f, (float)0.0f, (float)-0.2182f));
        PartDefinition right_arm = body_adjust.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(30, 19).m_171480_().m_171488_(0.0f, -1.0f, 0.0f, 0.0f, 16.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171423_((float)-4.0f, (float)-9.0f, (float)-1.0f, (float)-1.5708f, (float)0.0f, (float)0.2182f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(20, 41).m_171488_(-2.0f, -2.0f, -2.0f, 4.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)3.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(20, 34).m_171488_(-1.0f, 0.0f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)2.0f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(38, 41).m_171488_(-2.0f, -0.5f, -4.0f, 4.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)3.5f, (float)0.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(20, 41).m_171480_().m_171488_(-2.0f, -2.0f, -2.0f, 4.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-3.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(20, 34).m_171480_().m_171488_(-1.0f, 0.0f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)3.0f, (float)2.0f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(38, 41).m_171480_().m_171488_(-2.0f, -0.5f, -4.0f, 4.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)3.5f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(Therizinosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.m_20069_() && !entity.isEepy()) {
            if (entity.isRunning()) {
                this.m_267799_(TherizinosaurusBabyAnimations.BABY_RUN, limbSwing, limbSwingAmount, 1.0f, 1.0f);
            } else {
                this.m_267799_(TherizinosaurusBabyAnimations.BABY_WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, TherizinosaurusBabyAnimations.BABY_IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.swimAnimationState, TherizinosaurusBabyAnimations.BABY_SWIM, ageInTicks);
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


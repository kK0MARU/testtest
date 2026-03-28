/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.models.entity.mob.future;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.ManipulatorAnimations;
import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.ManipulatorAttackAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.Manipulator;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class ManipulatorModel
extends UP2Model<Manipulator> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body;
    private final ModelPart thorax;
    private final ModelPart head;
    private final ModelPart left_antenna1;
    private final ModelPart left_antenna2;
    private final ModelPart right_antenna1;
    private final ModelPart right_antenna2;
    private final ModelPart left_mandible;
    private final ModelPart right_mandible;
    private final ModelPart left_feelers;
    private final ModelPart right_feelers;
    private final ModelPart abdomen;
    private final ModelPart left_elytra;
    private final ModelPart right_elytra;
    private final ModelPart left_wing_pivot;
    private final ModelPart left_wing;
    private final ModelPart right_wing_pivot;
    private final ModelPart right_wing;
    private final ModelPart limb_control;
    private final ModelPart left_arm_pivot;
    private final ModelPart left_arm1;
    private final ModelPart left_arm2;
    private final ModelPart left_arm3;
    private final ModelPart left_arm4;
    private final ModelPart right_arm_pivot;
    private final ModelPart right_arm1;
    private final ModelPart right_arm2;
    private final ModelPart right_arm3;
    private final ModelPart right_arm4;
    private final ModelPart left_back_leg_pivot;
    private final ModelPart left_back_leg1;
    private final ModelPart left_back_leg2;
    private final ModelPart left_back_leg3;
    private final ModelPart right_back_leg_pivot;
    private final ModelPart right_back_leg1;
    private final ModelPart right_back_leg2;
    private final ModelPart right_back_leg3;
    private final ModelPart left_front_leg_pivot;
    private final ModelPart left_front_leg1;
    private final ModelPart left_front_leg2;
    private final ModelPart left_front_leg3;
    private final ModelPart right_front_leg_pivot;
    private final ModelPart right_front_leg1;
    private final ModelPart right_front_leg2;
    private final ModelPart right_front_leg3;

    public ManipulatorModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body = this.body_main.m_171324_("body");
        this.thorax = this.body.m_171324_("thorax");
        this.head = this.thorax.m_171324_("head");
        this.left_antenna1 = this.head.m_171324_("left_antenna1");
        this.left_antenna2 = this.left_antenna1.m_171324_("left_antenna2");
        this.right_antenna1 = this.head.m_171324_("right_antenna1");
        this.right_antenna2 = this.right_antenna1.m_171324_("right_antenna2");
        this.left_mandible = this.head.m_171324_("left_mandible");
        this.right_mandible = this.head.m_171324_("right_mandible");
        this.left_feelers = this.head.m_171324_("left_feelers");
        this.right_feelers = this.head.m_171324_("right_feelers");
        this.abdomen = this.body.m_171324_("abdomen");
        this.left_elytra = this.abdomen.m_171324_("left_elytra");
        this.right_elytra = this.abdomen.m_171324_("right_elytra");
        this.left_wing_pivot = this.abdomen.m_171324_("left_wing_pivot");
        this.left_wing = this.left_wing_pivot.m_171324_("left_wing");
        this.right_wing_pivot = this.abdomen.m_171324_("right_wing_pivot");
        this.right_wing = this.right_wing_pivot.m_171324_("right_wing");
        this.limb_control = this.body_main.m_171324_("limb_control");
        this.left_arm_pivot = this.limb_control.m_171324_("left_arm_pivot");
        this.left_arm1 = this.left_arm_pivot.m_171324_("left_arm1");
        this.left_arm2 = this.left_arm1.m_171324_("left_arm2");
        this.left_arm3 = this.left_arm2.m_171324_("left_arm3");
        this.left_arm4 = this.left_arm3.m_171324_("left_arm4");
        this.right_arm_pivot = this.limb_control.m_171324_("right_arm_pivot");
        this.right_arm1 = this.right_arm_pivot.m_171324_("right_arm1");
        this.right_arm2 = this.right_arm1.m_171324_("right_arm2");
        this.right_arm3 = this.right_arm2.m_171324_("right_arm3");
        this.right_arm4 = this.right_arm3.m_171324_("right_arm4");
        this.left_back_leg_pivot = this.limb_control.m_171324_("left_back_leg_pivot");
        this.left_back_leg1 = this.left_back_leg_pivot.m_171324_("left_back_leg1");
        this.left_back_leg2 = this.left_back_leg1.m_171324_("left_back_leg2");
        this.left_back_leg3 = this.left_back_leg2.m_171324_("left_back_leg3");
        this.right_back_leg_pivot = this.limb_control.m_171324_("right_back_leg_pivot");
        this.right_back_leg1 = this.right_back_leg_pivot.m_171324_("right_back_leg1");
        this.right_back_leg2 = this.right_back_leg1.m_171324_("right_back_leg2");
        this.right_back_leg3 = this.right_back_leg2.m_171324_("right_back_leg3");
        this.left_front_leg_pivot = this.limb_control.m_171324_("left_front_leg_pivot");
        this.left_front_leg1 = this.left_front_leg_pivot.m_171324_("left_front_leg1");
        this.left_front_leg2 = this.left_front_leg1.m_171324_("left_front_leg2");
        this.left_front_leg3 = this.left_front_leg2.m_171324_("left_front_leg3");
        this.right_front_leg_pivot = this.limb_control.m_171324_("right_front_leg_pivot");
        this.right_front_leg1 = this.right_front_leg_pivot.m_171324_("right_front_leg1");
        this.right_front_leg2 = this.right_front_leg1.m_171324_("right_front_leg2");
        this.right_front_leg3 = this.right_front_leg2.m_171324_("right_front_leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-24.0f, (float)0.0f));
        PartDefinition body = body_main.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition thorax = body.m_171599_("thorax", CubeListBuilder.m_171558_().m_171514_(96, 110).m_171488_(-2.5f, -2.0f, -11.0f, 5.0f, 5.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition head = thorax.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(120, 52).m_171488_(-4.0f, -2.0f, -3.0f, 8.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(120, 59).m_171488_(-2.0f, -2.0f, -3.0f, 4.0f, 8.0f, 3.0f, new CubeDeformation(0.01f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-11.0f));
        PartDefinition left_antenna1 = head.m_171599_("left_antenna1", CubeListBuilder.m_171558_().m_171514_(96, 126).m_171488_(-0.5f, -21.0f, 0.0f, 1.0f, 21.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)1.5f, (float)0.0f, (float)-3.0f));
        PartDefinition left_antenna2 = left_antenna1.m_171599_("left_antenna2", CubeListBuilder.m_171558_().m_171514_(96, 90).m_171488_(-0.5f, 0.0f, -20.0f, 1.0f, 0.0f, 20.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)-21.0f, (float)0.0f));
        PartDefinition right_antenna1 = head.m_171599_("right_antenna1", CubeListBuilder.m_171558_().m_171514_(96, 126).m_171480_().m_171488_(-0.5f, -21.0f, 0.0f, 1.0f, 21.0f, 0.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-1.5f, (float)0.0f, (float)-3.0f));
        PartDefinition right_antenna2 = right_antenna1.m_171599_("right_antenna2", CubeListBuilder.m_171558_().m_171514_(96, 90).m_171480_().m_171488_(-0.5f, 0.0f, -20.0f, 1.0f, 0.0f, 20.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)-21.0f, (float)0.0f));
        PartDefinition left_mandible = head.m_171599_("left_mandible", CubeListBuilder.m_171558_().m_171514_(128, 25).m_171488_(-2.0f, 0.0f, -1.0f, 2.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)2.0f, (float)6.0f, (float)-2.0f));
        PartDefinition right_mandible = head.m_171599_("right_mandible", CubeListBuilder.m_171558_().m_171514_(128, 25).m_171480_().m_171488_(0.0f, 0.0f, -1.0f, 2.0f, 2.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-2.0f, (float)6.0f, (float)-2.0f));
        PartDefinition left_feelers = head.m_171599_("left_feelers", CubeListBuilder.m_171558_().m_171514_(120, 0).m_171488_(0.0f, 0.0f, -4.5f, 0.0f, 20.0f, 5.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)2.0f, (float)4.0f, (float)-1.5f));
        PartDefinition right_feelers = head.m_171599_("right_feelers", CubeListBuilder.m_171558_().m_171514_(120, 0).m_171480_().m_171488_(0.0f, 0.0f, -4.5f, 0.0f, 20.0f, 5.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-2.0f, (float)4.0f, (float)-1.5f));
        PartDefinition abdomen = body.m_171599_("abdomen", CubeListBuilder.m_171558_().m_171514_(0, 90).m_171488_(-4.5f, -3.0f, 0.0f, 9.0f, 7.0f, 39.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_elytra = abdomen.m_171599_("left_elytra", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-11.0f, -1.0f, 0.0f, 16.0f, 5.0f, 44.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)3.0f, (float)-2.5f, (float)-0.1f));
        PartDefinition right_elytra = abdomen.m_171599_("right_elytra", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-5.0f, -1.0f, 0.0f, 16.0f, 5.0f, 44.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-3.0f, (float)-2.5f, (float)-0.1f));
        PartDefinition left_wing_pivot = abdomen.m_171599_("left_wing_pivot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)3.0f, (float)-3.25f, (float)0.0f));
        PartDefinition left_wing = left_wing_pivot.m_171599_("left_wing", CubeListBuilder.m_171558_().m_171514_(0, 49).m_171480_().m_171488_(-18.0f, 0.0f, 0.0f, 19.0f, 0.0f, 41.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_wing_pivot = abdomen.m_171599_("right_wing_pivot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)-3.0f, (float)-3.25f, (float)0.0f));
        PartDefinition right_wing = right_wing_pivot.m_171599_("right_wing", CubeListBuilder.m_171558_().m_171514_(0, 49).m_171488_(-1.0f, 0.0f, 0.0f, 19.0f, 0.0f, 41.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition limb_control = body_main.m_171599_("limb_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)0.0f));
        PartDefinition left_arm_pivot = limb_control.m_171599_("left_arm_pivot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)2.5f, (float)0.0f, (float)-4.0f));
        PartDefinition left_arm1 = left_arm_pivot.m_171599_("left_arm1", CubeListBuilder.m_171558_().m_171514_(120, 70).m_171488_(-1.5f, 0.0f, -1.5f, 3.0f, 9.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(120, 82).m_171488_(1.5f, 6.0f, -1.5f, 5.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm2 = left_arm1.m_171599_("left_arm2", CubeListBuilder.m_171558_().m_171514_(120, 25).m_171488_(-2.0f, 0.0f, -1.0f, 2.0f, 25.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)6.5f, (float)9.0f, (float)0.0f));
        PartDefinition left_arm3 = left_arm2.m_171599_("left_arm3", CubeListBuilder.m_171558_().m_171514_(98, 126).m_171488_(0.0f, 0.0f, -1.0f, 7.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)25.0f, (float)0.0f));
        PartDefinition left_arm4 = left_arm3.m_171599_("left_arm4", CubeListBuilder.m_171558_().m_171514_(116, 126).m_171488_(-6.0f, 0.0f, -1.0f, 6.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm_pivot = limb_control.m_171599_("right_arm_pivot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)-2.5f, (float)0.0f, (float)-4.0f));
        PartDefinition right_arm1 = right_arm_pivot.m_171599_("right_arm1", CubeListBuilder.m_171558_().m_171514_(120, 70).m_171480_().m_171488_(-1.5f, 0.0f, -1.5f, 3.0f, 9.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(120, 82).m_171480_().m_171488_(-6.5f, 6.0f, -1.5f, 5.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm2 = right_arm1.m_171599_("right_arm2", CubeListBuilder.m_171558_().m_171514_(120, 25).m_171480_().m_171488_(0.0f, 0.0f, -1.0f, 2.0f, 25.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-6.5f, (float)9.0f, (float)0.0f));
        PartDefinition right_arm3 = right_arm2.m_171599_("right_arm3", CubeListBuilder.m_171558_().m_171514_(98, 126).m_171480_().m_171488_(-7.0f, 0.0f, -1.0f, 7.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)25.0f, (float)0.0f));
        PartDefinition right_arm4 = right_arm3.m_171599_("right_arm4", CubeListBuilder.m_171558_().m_171514_(116, 126).m_171480_().m_171488_(0.0f, 0.0f, -1.0f, 6.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_back_leg_pivot = limb_control.m_171599_("left_back_leg_pivot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)3.5f, (float)0.0f, (float)4.0f));
        PartDefinition left_back_leg1 = left_back_leg_pivot.m_171599_("left_back_leg1", CubeListBuilder.m_171558_().m_171514_(120, 70).m_171488_(-1.5f, 0.0f, -1.5f, 3.0f, 9.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(120, 82).m_171488_(1.5f, 6.0f, -1.5f, 5.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_back_leg2 = left_back_leg1.m_171599_("left_back_leg2", CubeListBuilder.m_171558_().m_171514_(120, 25).m_171488_(-2.0f, 0.0f, -1.0f, 2.0f, 25.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)6.5f, (float)9.0f, (float)0.0f));
        PartDefinition left_back_leg3 = left_back_leg2.m_171599_("left_back_leg3", CubeListBuilder.m_171558_().m_171514_(98, 126).m_171488_(0.0f, 0.0f, -1.0f, 7.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)25.0f, (float)0.0f));
        PartDefinition right_back_leg_pivot = limb_control.m_171599_("right_back_leg_pivot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)-3.5f, (float)0.0f, (float)4.0f));
        PartDefinition right_back_leg1 = right_back_leg_pivot.m_171599_("right_back_leg1", CubeListBuilder.m_171558_().m_171514_(120, 70).m_171480_().m_171488_(-1.5f, 0.0f, -1.5f, 3.0f, 9.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(120, 82).m_171480_().m_171488_(-6.5f, 6.0f, -1.5f, 5.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_back_leg2 = right_back_leg1.m_171599_("right_back_leg2", CubeListBuilder.m_171558_().m_171514_(120, 25).m_171480_().m_171488_(0.0f, 0.0f, -1.0f, 2.0f, 25.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-6.5f, (float)9.0f, (float)0.0f));
        PartDefinition right_back_leg3 = right_back_leg2.m_171599_("right_back_leg3", CubeListBuilder.m_171558_().m_171514_(98, 126).m_171480_().m_171488_(-7.0f, 0.0f, -1.0f, 7.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)25.0f, (float)0.0f));
        PartDefinition left_front_leg_pivot = limb_control.m_171599_("left_front_leg_pivot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)3.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_front_leg1 = left_front_leg_pivot.m_171599_("left_front_leg1", CubeListBuilder.m_171558_().m_171514_(120, 70).m_171488_(-1.5f, 0.0f, -1.5f, 3.0f, 9.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(120, 82).m_171488_(1.5f, 6.0f, -1.5f, 5.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_front_leg2 = left_front_leg1.m_171599_("left_front_leg2", CubeListBuilder.m_171558_().m_171514_(120, 25).m_171488_(-2.0f, 0.0f, -1.0f, 2.0f, 25.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)6.5f, (float)9.0f, (float)0.0f));
        PartDefinition left_front_leg3 = left_front_leg2.m_171599_("left_front_leg3", CubeListBuilder.m_171558_().m_171514_(98, 126).m_171488_(0.0f, 0.0f, -1.0f, 7.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)25.0f, (float)0.0f));
        PartDefinition right_front_leg_pivot = limb_control.m_171599_("right_front_leg_pivot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)-3.5f, (float)0.0f, (float)-0.5f));
        PartDefinition right_front_leg1 = right_front_leg_pivot.m_171599_("right_front_leg1", CubeListBuilder.m_171558_().m_171514_(120, 70).m_171480_().m_171488_(-1.5f, 0.0f, -0.5f, 3.0f, 9.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(120, 82).m_171480_().m_171488_(-6.5f, 6.0f, -0.5f, 5.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-0.5f));
        PartDefinition right_front_leg2 = right_front_leg1.m_171599_("right_front_leg2", CubeListBuilder.m_171558_().m_171514_(120, 25).m_171480_().m_171488_(0.0f, 0.0f, 0.0f, 2.0f, 25.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-6.5f, (float)9.0f, (float)0.0f));
        PartDefinition right_front_leg3 = right_front_leg2.m_171599_("right_front_leg3", CubeListBuilder.m_171558_().m_171514_(98, 126).m_171480_().m_171488_(-7.0f, 0.0f, 0.0f, 7.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)25.0f, (float)0.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    public void setupAnim(Manipulator entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (entity.isRunning()) {
            this.m_267799_(entity.isHoldingItem() ? ManipulatorAttackAnimations.RUN_ARMED : ManipulatorAnimations.RUN, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        } else {
            this.m_267799_(entity.isHoldingItem() ? ManipulatorAttackAnimations.WALK_ARMED : ManipulatorAnimations.WALK, limbSwing, limbSwingAmount, 2.0f, 4.0f);
        }
        this.animateIdleSmooth(entity.idleAnimationState, ManipulatorAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateIdleSmooth(entity.idleArmedAnimationState, ManipulatorAttackAnimations.IDLE_ARMED, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.sitAnimationState, ManipulatorAnimations.SIT, ageInTicks);
        this.animateSmooth(entity.sitArmedAnimationState, ManipulatorAttackAnimations.SIT_ARMED, ageInTicks);
        this.animateSmooth(entity.danceAnimationState, ManipulatorAnimations.DANCE, ageInTicks);
        this.animateSmooth(entity.attackAnimationState, ManipulatorAttackAnimations.ATTACK_UNARMED_BLEND, ageInTicks);
        this.animateSmooth(entity.attackArmedAnimationState, ManipulatorAttackAnimations.ATTACK_ARMED_BLEND, ageInTicks);
        this.animateSmooth(entity.blockAnimationState, ManipulatorAttackAnimations.SHIELDBLOCK_BLEND, ageInTicks);
        this.animateHead(entity, this.head, netHeadYaw, headPitch);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }

    public void translateToHand(@NotNull HumanoidArm arm, @NotNull PoseStack poseStack) {
        this.limb_control.m_104299_(poseStack);
        if (arm == HumanoidArm.RIGHT) {
            this.right_arm_pivot.m_104299_(poseStack);
            this.right_arm1.m_104299_(poseStack);
            this.right_arm2.m_104299_(poseStack);
            this.right_arm3.m_104299_(poseStack);
            this.right_arm4.m_104299_(poseStack);
        } else {
            this.left_arm_pivot.m_104299_(poseStack);
            this.left_arm1.m_104299_(poseStack);
            this.left_arm2.m_104299_(poseStack);
            this.left_arm3.m_104299_(poseStack);
            this.left_arm4.m_104299_(poseStack);
        }
    }
}


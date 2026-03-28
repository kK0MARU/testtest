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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.BrachiosaurusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Brachiosaurus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
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
public class BrachiosaurusModel
extends UP2Model<Brachiosaurus> {
    private final ModelPart root;
    private final ModelPart body_main;
    private final ModelPart body_upper;
    private final ModelPart body;
    private final ModelPart neck1;
    private final ModelPart neck2_pivot;
    private final ModelPart neck2;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart back;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart arm_control;
    private final ModelPart left_arm1;
    private final ModelPart left_arm2;
    private final ModelPart left_arm3;
    private final ModelPart right_arm1;
    private final ModelPart right_arm2;
    private final ModelPart right_arm3;
    private final ModelPart leg_control;
    private final ModelPart left_leg1;
    private final ModelPart left_leg2;
    private final ModelPart left_leg3;
    private final ModelPart right_leg1;
    private final ModelPart right_leg2;
    private final ModelPart right_leg3;

    public BrachiosaurusModel(ModelPart root) {
        super(1.0f, 0.0f);
        this.root = root.m_171324_("root");
        this.body_main = this.root.m_171324_("body_main");
        this.body_upper = this.body_main.m_171324_("body_upper");
        this.body = this.body_upper.m_171324_("body");
        this.neck1 = this.body.m_171324_("neck1");
        this.neck2_pivot = this.neck1.m_171324_("neck2_pivot");
        this.neck2 = this.neck2_pivot.m_171324_("neck2");
        this.head = this.neck2.m_171324_("head");
        this.jaw = this.head.m_171324_("jaw");
        this.back = this.body.m_171324_("back");
        this.tail1 = this.back.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
        this.arm_control = this.body_upper.m_171324_("arm_control");
        this.left_arm1 = this.arm_control.m_171324_("left_arm1");
        this.left_arm2 = this.left_arm1.m_171324_("left_arm2");
        this.left_arm3 = this.left_arm2.m_171324_("left_arm3");
        this.right_arm1 = this.arm_control.m_171324_("right_arm1");
        this.right_arm2 = this.right_arm1.m_171324_("right_arm2");
        this.right_arm3 = this.right_arm2.m_171324_("right_arm3");
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
        PartDefinition body_main = root.m_171599_("body_main", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-106.0f, (float)0.0f));
        PartDefinition body_upper = body_main.m_171599_("body_upper", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)34.0f, (float)37.0f));
        PartDefinition body = body_upper.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-27.5f, -32.0f, -47.0f, 55.0f, 80.0f, 61.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-34.0f, (float)-37.0f));
        PartDefinition neck1 = body.m_171599_("neck1", CubeListBuilder.m_171558_().m_171514_(139, 146).m_171488_(-15.0f, -99.0f, -22.0f, 31.0f, 125.0f, 39.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-0.5f, (float)-12.0f, (float)-45.0f));
        PartDefinition neck2_pivot = neck1.m_171599_("neck2_pivot", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-100.0f, (float)-21.0f));
        PartDefinition neck2 = neck2_pivot.m_171599_("neck2", CubeListBuilder.m_171558_().m_171514_(0, 174).m_171488_(-14.0f, -125.0f, -17.5f, 29.0f, 125.0f, 35.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)1.0f, (float)17.5f));
        PartDefinition head = neck2.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(312, 450).m_171488_(-4.5f, -4.0f, -34.0f, 13.0f, 11.0f, 13.0f, new CubeDeformation(0.0f)).m_171514_(222, 434).m_171488_(-8.5f, -14.0f, -21.0f, 21.0f, 21.0f, 24.0f, new CubeDeformation(0.0f)).m_171514_(0, 420).m_171488_(-3.5f, 7.0f, -33.0f, 11.0f, 3.0f, 13.0f, new CubeDeformation(0.0f)).m_171514_(319, 441).m_171488_(-7.5f, 7.0f, -20.0f, 19.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).m_171514_(354, 400).m_171488_(-8.5f, 0.0f, -8.0f, 21.0f, 7.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-1.5f, (float)-110.0f, (float)-20.5f));
        PartDefinition crest_r1 = head.m_171599_("crest_r1", CubeListBuilder.m_171558_().m_171514_(354, 335).m_171488_(-4.0f, -17.0f, -15.0f, 7.0f, 23.0f, 24.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)2.5f, (float)-7.0f, (float)-14.0f, (float)0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(0, 146).m_171488_(-8.0f, 0.0f, -9.0f, 21.0f, 12.0f, 11.0f, new CubeDeformation(0.0f)).m_171514_(89, 148).m_171488_(-7.0f, -12.0f, -7.0f, 19.0f, 12.0f, 8.0f, new CubeDeformation(0.0f)).m_171514_(364, 450).m_171488_(-4.0f, 7.0f, -35.0f, 13.0f, 5.0f, 13.0f, new CubeDeformation(0.0f)).m_171514_(354, 382).m_171488_(-8.0f, 7.0f, -22.0f, 21.0f, 5.0f, 13.0f, new CubeDeformation(0.0f)).m_171514_(363, 427).m_171488_(-7.0f, 4.0f, -21.0f, 19.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(48, 420).m_171488_(-3.0f, 4.0f, -34.0f, 11.0f, 3.0f, 13.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-0.5f, (float)0.0f, (float)1.0f));
        PartDefinition back = body.m_171599_("back", CubeListBuilder.m_171558_().m_171514_(284, 142).m_171488_(-21.5f, -27.5f, 0.0f, 43.0f, 55.0f, 34.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)17.5f, (float)14.0f));
        PartDefinition tail1 = back.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(0, 338).m_171488_(-9.0f, -16.0f, 0.0f, 19.0f, 30.0f, 46.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)6.5f, (float)32.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(340, 0).m_171488_(-6.5f, -9.0f, -1.0f, 13.0f, 16.0f, 66.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)5.0f, (float)46.0f));
        PartDefinition arm_control = body_upper.m_171599_("arm_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-7.5f, (float)-74.0f));
        PartDefinition left_arm1 = arm_control.m_171599_("left_arm1", CubeListBuilder.m_171558_().m_171514_(290, 238).m_171488_(-19.0f, -19.9175f, -17.0571f, 35.0f, 56.0f, 32.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)27.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_arm2 = left_arm1.m_171599_("left_arm2", CubeListBuilder.m_171558_().m_171514_(246, 335).m_171488_(-14.0f, -7.0f, -12.0f, 27.0f, 54.0f, 27.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)-2.0f, (float)26.0825f, (float)5.9429f));
        PartDefinition left_arm3 = left_arm2.m_171599_("left_arm3", CubeListBuilder.m_171558_().m_171514_(176, 0).m_171488_(-15.0f, -3.0f, -13.0f, 29.0f, 22.0f, 29.0f, new CubeDeformation(0.0f)).m_171514_(64, 146).m_171488_(-21.0f, 14.0f, -4.0f, 6.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)46.0f, (float)0.0f));
        PartDefinition right_arm1 = arm_control.m_171599_("right_arm1", CubeListBuilder.m_171558_().m_171514_(290, 238).m_171480_().m_171488_(-16.0f, -19.9175f, -17.0571f, 35.0f, 56.0f, 32.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-27.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm2 = right_arm1.m_171599_("right_arm2", CubeListBuilder.m_171558_().m_171514_(246, 335).m_171480_().m_171488_(-13.0f, -7.0f, -12.0f, 27.0f, 54.0f, 27.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)2.0f, (float)26.0825f, (float)5.9429f));
        PartDefinition right_arm3 = right_arm2.m_171599_("right_arm3", CubeListBuilder.m_171558_().m_171514_(176, 0).m_171480_().m_171488_(-14.0f, -3.0f, -13.0f, 29.0f, 22.0f, 29.0f, new CubeDeformation(0.0f)).m_171555_(false).m_171514_(64, 146).m_171480_().m_171488_(15.0f, 14.0f, -4.0f, 6.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)46.0f, (float)0.0f));
        PartDefinition leg_control = body_main.m_171599_("leg_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)34.0f, (float)38.0f));
        PartDefinition left_leg1 = leg_control.m_171599_("left_leg1", CubeListBuilder.m_171558_().m_171514_(241, 62).m_171488_(-15.5f, -16.0f, -14.0f, 31.0f, 44.0f, 30.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)21.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg2 = left_leg1.m_171599_("left_leg2", CubeListBuilder.m_171558_().m_171514_(136, 318).m_171488_(-13.0f, -8.0f, -9.0f, 26.0f, 53.0f, 23.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)20.0f, (float)9.0f));
        PartDefinition left_leg3 = left_leg2.m_171599_("left_leg3", CubeListBuilder.m_171558_().m_171514_(3, 440).m_171488_(-14.0f, -1.5f, -20.0f, 28.0f, 10.0f, 33.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)43.5f, (float)3.0f));
        PartDefinition right_leg1 = leg_control.m_171599_("right_leg1", CubeListBuilder.m_171558_().m_171514_(241, 62).m_171480_().m_171488_(-15.5f, -16.0f, -14.0f, 31.0f, 44.0f, 30.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-21.0f, (float)0.0f, (float)0.0f));
        PartDefinition right_leg2 = right_leg1.m_171599_("right_leg2", CubeListBuilder.m_171558_().m_171514_(136, 318).m_171480_().m_171488_(-13.0f, -8.0f, -9.0f, 26.0f, 53.0f, 23.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)20.0f, (float)9.0f));
        PartDefinition right_leg3 = right_leg2.m_171599_("right_leg3", CubeListBuilder.m_171558_().m_171514_(3, 440).m_171480_().m_171488_(-14.0f, -1.5f, -20.0f, 28.0f, 10.0f, 33.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)0.0f, (float)43.5f, (float)3.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)512, (int)512);
    }

    public void setupAnim(@NotNull Brachiosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (!entity.isEepy() && entity.m_20089_() != UP2Poses.STOMPING.get()) {
            if (entity.isRunning()) {
                this.m_267799_(BrachiosaurusAnimations.RUN, limbSwing, limbSwingAmount, 1.5f, 3.0f);
            } else {
                this.m_267799_(BrachiosaurusAnimations.WALK, limbSwing, limbSwingAmount, 3.5f, 7.0f);
            }
        }
        this.animateIdleSmooth(entity.idleAnimationState, BrachiosaurusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.eepyAnimationState, BrachiosaurusAnimations.SIT, ageInTicks);
        this.animateSmooth(entity.stompAnimationState, BrachiosaurusAnimations.SLAM, ageInTicks);
        this.animateSmooth(entity.shakeAnimationState, BrachiosaurusAnimations.SHAKE_BLEND, ageInTicks);
        this.animateSmooth(entity.callAnimationState, BrachiosaurusAnimations.BELLOW_BLEND, ageInTicks);
        if (!entity.isEepy()) {
            this.head.f_104203_ += headPitch * ((float)Math.PI / 180) / 6.0f;
            this.head.f_104204_ += netHeadYaw * ((float)Math.PI / 180) / 6.0f;
            this.neck1.f_104203_ += headPitch * ((float)Math.PI / 180) / 4.0f;
            this.neck1.f_104204_ += netHeadYaw * ((float)Math.PI / 180) / 4.0f;
        }
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


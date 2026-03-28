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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.UnicornAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Unicorn;
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
public class UnicornModel
extends UP2Model<Unicorn> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart upperBody;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart horn;
    private final ModelPart tail;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;

    public UnicornModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.body = this.root.m_171324_("body");
        this.upperBody = this.body.m_171324_("upperBody");
        this.neck = this.upperBody.m_171324_("neck");
        this.head = this.neck.m_171324_("head");
        this.horn = this.head.m_171324_("horn");
        this.tail = this.upperBody.m_171324_("tail");
        this.rightLeg = this.body.m_171324_("rightLeg");
        this.leftLeg = this.body.m_171324_("leftLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body = root.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition upperBody = body.m_171599_("upperBody", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)3.0f));
        PartDefinition upperBody_r1 = upperBody.m_171599_("upperBody_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-6.0f, -14.0f, -34.0f, 12.0f, 14.0f, 34.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition neck = upperBody.m_171599_("neck", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-35.0f, (float)-9.0f));
        PartDefinition neck_r1 = neck.m_171599_("neck_r1", CubeListBuilder.m_171558_().m_171514_(70, 74).m_171488_(-4.0f, -14.0f, -41.0f, 8.0f, 9.0f, 9.0f, new CubeDeformation(-0.001f)), PartPose.m_171423_((float)0.0f, (float)35.0f, (float)9.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-4.0f, (float)-3.0f));
        PartDefinition head_r1 = head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(20, 71).m_171488_(-4.0f, -14.0f, -51.0f, 8.0f, 9.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(72, 48).m_171488_(-4.0f, -14.0f, -48.0f, 8.0f, 18.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)39.0f, (float)12.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition horn = head.m_171599_("horn", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)30.0f, (float)9.0f));
        PartDefinition head_r2 = horn.m_171599_("head_r2", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-2.0f, -14.0f, -69.0f, 4.0f, 5.0f, 18.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)9.0f, (float)3.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition tail = upperBody.m_171599_("tail", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-10.0f, (float)8.0f));
        PartDefinition tail_r1 = tail.m_171599_("tail_r1", CubeListBuilder.m_171558_().m_171514_(44, 48).m_171488_(-3.0f, -29.0f, -8.1f, 6.0f, 19.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)10.0f, (float)-8.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition rightLeg = body.m_171599_("rightLeg", CubeListBuilder.m_171558_().m_171514_(0, 71).m_171488_(-2.65f, -4.0f, -2.5f, 5.0f, 30.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)4.5f, (float)-26.0f, (float)-9.5f));
        PartDefinition leftLeg = body.m_171599_("leftLeg", CubeListBuilder.m_171558_().m_171514_(0, 71).m_171480_().m_171488_(-2.35f, -4.0f, -2.5f, 5.0f, 30.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-4.5f, (float)-26.0f, (float)-9.5f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(@NotNull Unicorn entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.m_267799_(UnicornAnimations.WALK, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        if (this.f_102610_) {
            this.m_288214_(UnicornAnimations.BABY_TRANSFORM);
        }
        this.animateIdleSmooth(entity.idleAnimationState, UnicornAnimations.IDLE, ageInTicks, limbSwingAmount);
        float deg = (float)Math.PI / 180;
        this.head.f_104203_ += headPitch * deg - headPitch * deg / 4.0f;
        this.head.f_104204_ += netHeadYaw * deg - netHeadYaw * deg / 4.0f;
        this.neck.f_104203_ += headPitch * deg / 4.0f;
        this.neck.f_104204_ += netHeadYaw * deg / 4.0f;
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


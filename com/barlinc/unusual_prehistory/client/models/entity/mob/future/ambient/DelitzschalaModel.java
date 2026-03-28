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

import com.barlinc.unusual_prehistory.client.animations.entity.mob.future.ambient.DelitzschalaAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.future.ambient.Delitzschala;
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
public class DelitzschalaModel
extends UP2Model<Delitzschala> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart left_wing1;
    private final ModelPart left_wing2;
    private final ModelPart left_wing3;
    private final ModelPart right_wing1;
    private final ModelPart right_wing2;
    private final ModelPart right_wing3;
    private final ModelPart Tail;

    public DelitzschalaModel(ModelPart root) {
        super(1.0f, 0.0f);
        this.root = root.m_171324_("root");
        this.body = this.root.m_171324_("body");
        this.left_wing1 = this.body.m_171324_("left_wing1");
        this.left_wing2 = this.body.m_171324_("left_wing2");
        this.left_wing3 = this.body.m_171324_("left_wing3");
        this.right_wing1 = this.body.m_171324_("right_wing1");
        this.right_wing2 = this.body.m_171324_("right_wing2");
        this.right_wing3 = this.body.m_171324_("right_wing3");
        this.Tail = this.body.m_171324_("Tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body = root.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171488_(-1.5f, 0.0f, -4.0f, 3.0f, 0.0f, 8.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_wing1 = body.m_171599_("left_wing1", CubeListBuilder.m_171558_().m_171514_(7, 7).m_171488_(0.0f, 0.0f, -1.0f, 2.0f, 0.0f, 2.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)1.5f, (float)0.0f, (float)-2.0f));
        PartDefinition left_wing2 = body.m_171599_("left_wing2", CubeListBuilder.m_171558_().m_171514_(6, 4).m_171488_(0.0f, 0.0f, -1.0f, 7.0f, 0.0f, 3.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)1.5f, (float)0.0f, (float)0.0f));
        PartDefinition left_wing3 = body.m_171599_("left_wing3", CubeListBuilder.m_171558_().m_171514_(5, 0).m_171488_(0.0f, 0.0f, -1.0f, 5.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)1.5f, (float)0.0f, (float)2.0f));
        PartDefinition right_wing1 = body.m_171599_("right_wing1", CubeListBuilder.m_171558_().m_171514_(7, 7).m_171480_().m_171488_(-2.0f, 0.0f, -1.0f, 2.0f, 0.0f, 2.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-1.5f, (float)0.0f, (float)-2.0f));
        PartDefinition right_wing2 = body.m_171599_("right_wing2", CubeListBuilder.m_171558_().m_171514_(6, 4).m_171480_().m_171488_(-7.0f, 0.0f, -1.0f, 7.0f, 0.0f, 3.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-1.5f, (float)0.0f, (float)0.0f));
        PartDefinition right_wing3 = body.m_171599_("right_wing3", CubeListBuilder.m_171558_().m_171514_(5, 0).m_171480_().m_171488_(-5.0f, 0.0f, -1.0f, 5.0f, 0.0f, 4.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171419_((float)-1.5f, (float)0.0f, (float)2.0f));
        PartDefinition Tail = body.m_171599_("Tail", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-2.5f, 0.0f, 0.0f, 5.0f, 0.0f, 9.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)4.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)32, (int)32);
    }

    public void setupAnim(@NotNull Delitzschala entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.animateIdleSmooth(entity.idleAnimationState, DelitzschalaAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.flyAnimationState, DelitzschalaAnimations.FLY, ageInTicks);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


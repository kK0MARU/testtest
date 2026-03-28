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
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_1.JawlessFishAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_1.JawlessFish;
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
public class ArandaspisModel
extends UP2Model<JawlessFish> {
    private final ModelPart root;
    private final ModelPart swim_control;
    private final ModelPart body_sideways;
    private final ModelPart body;
    private final ModelPart tail1;

    public ArandaspisModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.swim_control = this.root.m_171324_("swim_control");
        this.body_sideways = this.swim_control.m_171324_("body_sideways");
        this.body = this.body_sideways.m_171324_("body");
        this.tail1 = this.body.m_171324_("tail1");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition swim_control = root.m_171599_("swim_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)-0.5f));
        PartDefinition body_sideways = swim_control.m_171599_("body_sideways", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body = body_sideways.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 1).m_171488_(-2.0f, -2.0f, -3.0f, 4.0f, 4.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(0, 5).m_171488_(0.0f, -2.0f, 0.0f, 0.0f, 4.0f, 8.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)4.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)32, (int)32);
    }

    public void setupAnim(JawlessFish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.m_267799_(JawlessFishAnimations.SWIM, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        this.animateIdle(entity.swimIdleAnimationState, JawlessFishAnimations.SWIM, ageInTicks, 0.8f, limbSwingAmount * 3.0f);
        this.m_233381_(entity.flopAnimationState, JawlessFishAnimations.FLOP, ageInTicks);
        this.swim_control.f_104203_ = headPitch * ((float)Math.PI / 180);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


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
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_4.LobeFinnedFishAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_4.LobeFinnedFish;
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
public class AllenypterusModel
extends UP2Model<LobeFinnedFish> {
    private final ModelPart root;
    private final ModelPart swim_control;
    private final ModelPart body;
    private final ModelPart dorsal2;
    private final ModelPart left_pectoralfin;
    private final ModelPart right_pectoralfin;
    private final ModelPart left_pelvicfin;
    private final ModelPart right_pelvicfin;
    private final ModelPart tail1;
    private final ModelPart tail2;

    public AllenypterusModel(ModelPart root) {
        super(0.5f, 24.0f);
        this.root = root.m_171324_("root");
        this.swim_control = this.root.m_171324_("swim_control");
        this.body = this.swim_control.m_171324_("body");
        this.dorsal2 = this.body.m_171324_("dorsal2");
        this.left_pectoralfin = this.body.m_171324_("left_pectoralfin");
        this.right_pectoralfin = this.body.m_171324_("right_pectoralfin");
        this.left_pelvicfin = this.body.m_171324_("left_pelvicfin");
        this.right_pelvicfin = this.body.m_171324_("right_pelvicfin");
        this.tail1 = this.body.m_171324_("tail1");
        this.tail2 = this.tail1.m_171324_("tail2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition swim_control = root.m_171599_("swim_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-6.0f, (float)0.0f));
        PartDefinition body = swim_control.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0f, -6.0f, -6.0f, 4.0f, 12.0f, 12.0f, new CubeDeformation(0.0f)).m_171514_(32, 11).m_171488_(-2.0f, 3.0f, -6.0f, 4.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition dorsal2 = body.m_171599_("dorsal2", CubeListBuilder.m_171558_().m_171514_(41, 26).m_171488_(0.0f, -4.0f, -2.0f, 0.0f, 7.0f, 8.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)-6.0f, (float)2.0f));
        PartDefinition left_pectoralfin = body.m_171599_("left_pectoralfin", CubeListBuilder.m_171558_().m_171514_(40, 18).m_171488_(0.0f, -2.0f, 0.0f, 4.0f, 4.0f, 0.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)2.0f, (float)2.0f, (float)1.0f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition right_pectoralfin = body.m_171599_("right_pectoralfin", CubeListBuilder.m_171558_().m_171514_(40, 18).m_171480_().m_171488_(-4.0f, -2.0f, 0.0f, 4.0f, 4.0f, 0.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-2.0f, (float)2.0f, (float)1.0f, (float)0.0f, (float)0.7854f, (float)0.0f));
        PartDefinition left_pelvicfin = body.m_171599_("left_pelvicfin", CubeListBuilder.m_171558_().m_171514_(33, 17).m_171488_(0.0f, 0.0f, -1.0f, 0.0f, 4.0f, 6.0f, new CubeDeformation(0.0025f)), PartPose.m_171423_((float)2.0f, (float)6.0f, (float)-1.0f, (float)0.0f, (float)0.0f, (float)-0.5236f));
        PartDefinition right_pelvicfin = body.m_171599_("right_pelvicfin", CubeListBuilder.m_171558_().m_171514_(33, 17).m_171480_().m_171488_(0.0f, 0.0f, -1.0f, 0.0f, 4.0f, 6.0f, new CubeDeformation(0.0025f)).m_171555_(false), PartPose.m_171423_((float)-2.0f, (float)6.0f, (float)-1.0f, (float)0.0f, (float)0.0f, (float)0.5236f));
        PartDefinition tail1 = body.m_171599_("tail1", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0f, -3.0f, 0.0f, 2.0f, 6.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(1, 32).m_171488_(0.0f, -5.0f, 2.0f, 0.0f, 10.0f, 6.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)2.0f, (float)6.0f));
        PartDefinition tail2 = tail1.m_171599_("tail2", CubeListBuilder.m_171558_().m_171514_(16, 33).m_171488_(0.0f, -2.0f, 0.0f, 0.0f, 4.0f, 7.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)8.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(LobeFinnedFish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        this.m_267799_(LobeFinnedFishAnimations.SWIM, limbSwing, limbSwingAmount, 1.5f, 3.0f);
        this.animateIdle(entity.swimIdleAnimationState, LobeFinnedFishAnimations.SWIM_IDLE, ageInTicks, 1.0f, limbSwingAmount * 3.0f);
        this.m_233381_(entity.flopAnimationState, LobeFinnedFishAnimations.FLOP, ageInTicks);
        this.swim_control.f_104203_ = headPitch * ((float)Math.PI / 180);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


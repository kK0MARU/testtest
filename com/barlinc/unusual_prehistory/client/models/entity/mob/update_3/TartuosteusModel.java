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
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_3;

import com.barlinc.unusual_prehistory.client.animations.entity.mob.update_3.TartuosteusAnimations;
import com.barlinc.unusual_prehistory.client.models.entity.UP2Model;
import com.barlinc.unusual_prehistory.entity.mob.update_3.Tartuosteus;
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
public class TartuosteusModel
extends UP2Model<Tartuosteus> {
    private final ModelPart root;
    private final ModelPart swim_control;
    private final ModelPart body;
    private final ModelPart left_fin;
    private final ModelPart right_fin;
    private final ModelPart tail;

    public TartuosteusModel(ModelPart root) {
        super(0.25f, 72.0f);
        this.root = root.m_171324_("root");
        this.swim_control = this.root.m_171324_("swim_control");
        this.body = this.swim_control.m_171324_("body");
        this.left_fin = this.body.m_171324_("left_fin");
        this.right_fin = this.body.m_171324_("right_fin");
        this.tail = this.body.m_171324_("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)20.0f, (float)0.0f));
        PartDefinition swim_control = root.m_171599_("swim_control", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition body = swim_control.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-10.0f, -3.0f, -9.0f, 20.0f, 8.0f, 18.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)0.0f, (float)-1.0f, (float)0.0f));
        PartDefinition left_fin = body.m_171599_("left_fin", CubeListBuilder.m_171558_().m_171514_(0, 67).m_171488_(0.0f, -1.0f, -4.0f, 16.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.m_171419_((float)10.0f, (float)-2.0f, (float)5.0f));
        PartDefinition right_fin = body.m_171599_("right_fin", CubeListBuilder.m_171558_().m_171514_(0, 67).m_171480_().m_171488_(-16.0f, -1.0f, -4.0f, 16.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-10.0f, (float)-2.0f, (float)5.0f));
        PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(44, 26).m_171488_(-2.0f, -2.5f, 0.0f, 4.0f, 5.0f, 18.0f, new CubeDeformation(0.0f)).m_171514_(0, 25).m_171488_(0.0f, -5.5f, -1.0f, 0.0f, 13.0f, 25.0f, new CubeDeformation(0.0025f)).m_171514_(43, 49).m_171488_(-3.0f, 0.5f, 0.0f, 6.0f, 0.0f, 19.0f, new CubeDeformation(0.0025f)), PartPose.m_171419_((float)0.0f, (float)-0.5f, (float)9.0f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(Tartuosteus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.m_142109_().m_171331_().forEach(ModelPart::m_233569_);
        if (entity.m_20069_()) {
            this.m_267799_(TartuosteusAnimations.SWIM, limbSwing, limbSwingAmount, 2.0f, 4.0f);
        }
        this.animateIdleSmooth(entity.swimIdleAnimationState, TartuosteusAnimations.IDLE, ageInTicks, limbSwingAmount);
        this.animateSmooth(entity.flopAnimationState, TartuosteusAnimations.FLOP, ageInTicks);
        this.swim_control.f_104203_ = headPitch * ((float)Math.PI / 180);
    }

    @NotNull
    public ModelPart m_142109_() {
        return this.root;
    }
}


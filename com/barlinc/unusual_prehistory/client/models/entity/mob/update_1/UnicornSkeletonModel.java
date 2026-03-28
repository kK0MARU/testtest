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
 */
package com.barlinc.unusual_prehistory.client.models.entity.mob.update_1;

import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.UnicornModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class UnicornSkeletonModel
extends UnicornModel {
    public UnicornSkeletonModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.m_171576_();
        PartDefinition root = partdefinition.m_171599_("root", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body = root.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)12.0f));
        PartDefinition upperBody = body.m_171599_("upperBody", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)0.0f, (float)-9.0f));
        PartDefinition upperBody_r1 = upperBody.m_171599_("upperBody_r1", CubeListBuilder.m_171558_().m_171514_(0, 44).m_171488_(0.0f, -8.0f, -34.0f, 0.0f, 14.0f, 34.0f, new CubeDeformation(0.0f)).m_171514_(0, 0).m_171488_(-2.0f, -14.0f, -34.0f, 4.0f, 6.0f, 38.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)0.0f, (float)0.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition neck = upperBody.m_171599_("neck", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-37.0f, (float)-10.0f));
        PartDefinition neck_r1 = neck.m_171599_("neck_r1", CubeListBuilder.m_171558_().m_171514_(84, 24).m_171488_(-2.0f, -14.0f, -41.0f, 4.0f, 6.0f, 9.0f, new CubeDeformation(-0.01f)), PartPose.m_171423_((float)0.0f, (float)37.0f, (float)10.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition head = neck.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-2.0f, (float)-1.0f));
        PartDefinition head_r1 = head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(18, 92).m_171488_(-3.0f, -14.0f, -51.0f, 6.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)).m_171514_(47, 102).m_171488_(-3.0f, -9.0f, -44.1f, 6.0f, 10.0f, 1.0f, new CubeDeformation(-0.1f)).m_171514_(88, 67).m_171488_(-3.0f, -14.0f, -48.0f, 6.0f, 18.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)39.0f, (float)11.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)25.0f, (float)-33.0f));
        PartDefinition jaw_r1 = jaw.m_171599_("jaw_r1", CubeListBuilder.m_171558_().m_171514_(84, 39).m_171488_(-3.0f, 1.0f, -41.0f, 6.0f, 3.0f, 0.0f, new CubeDeformation(0.0f)).m_171514_(88, 89).m_171488_(-3.0f, -14.0f, -44.0f, 6.0f, 15.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)14.0f, (float)44.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition horn = head.m_171599_("horn", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)30.0f, (float)-30.0f));
        PartDefinition head_r2 = horn.m_171599_("head_r2", CubeListBuilder.m_171558_().m_171514_(68, 44).m_171488_(-2.0f, -14.0f, -69.0f, 4.0f, 5.0f, 18.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)9.0f, (float)41.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition tail = upperBody.m_171599_("tail", CubeListBuilder.m_171558_(), PartPose.m_171419_((float)0.0f, (float)-5.0f, (float)12.0f));
        PartDefinition tail_r1 = tail.m_171599_("tail_r1", CubeListBuilder.m_171558_().m_171514_(0, 92).m_171488_(-2.0f, -24.0f, -1.1f, 4.0f, 10.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.m_171423_((float)0.0f, (float)5.0f, (float)-12.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition leftLeg = body.m_171599_("leftLeg", CubeListBuilder.m_171558_().m_171514_(84, 0).m_171480_().m_171488_(-2.4f, -11.0f, -2.5f, 5.0f, 15.0f, 9.0f, new CubeDeformation(0.1f)).m_171555_(false).m_171514_(68, 67).m_171480_().m_171488_(-2.4f, -4.0f, -2.5f, 5.0f, 30.0f, 5.0f, new CubeDeformation(0.0f)).m_171555_(false), PartPose.m_171419_((float)-3.5f, (float)-26.0f, (float)-21.5f));
        PartDefinition rightLeg = body.m_171599_("rightLeg", CubeListBuilder.m_171558_().m_171514_(68, 67).m_171488_(-2.6f, -4.0f, -2.5f, 5.0f, 30.0f, 5.0f, new CubeDeformation(0.0f)).m_171514_(84, 0).m_171488_(-2.6f, -11.0f, -2.5f, 5.0f, 15.0f, 9.0f, new CubeDeformation(0.1f)), PartPose.m_171419_((float)3.5f, (float)-26.0f, (float)-21.5f));
        return LayerDefinition.m_171565_((MeshDefinition)meshdefinition, (int)128, (int)128);
    }
}


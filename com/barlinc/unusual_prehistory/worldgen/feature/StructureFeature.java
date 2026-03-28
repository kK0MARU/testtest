/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Registry
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 */
package com.barlinc.unusual_prehistory.worldgen.feature;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.mixins.StructureTemplateAccessor;
import com.barlinc.unusual_prehistory.utils.GeneralUtils;
import com.barlinc.unusual_prehistory.worldgen.feature.config.StructureFeatureConfig;
import com.mojang.serialization.Codec;
import java.util.List;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class StructureFeature
extends Feature<StructureFeatureConfig> {
    private static final ResourceLocation EMPTY = new ResourceLocation("minecraft", "empty");

    public StructureFeature(Codec<StructureFeatureConfig> configFactory) {
        super(configFactory);
    }

    public boolean m_142674_(FeaturePlaceContext<StructureFeatureConfig> context) {
        ResourceLocation entry = (ResourceLocation)GeneralUtils.getRandomEntry(((StructureFeatureConfig)context.m_159778_()).structureLocationAndWeights(), context.m_225041_());
        StructureTemplateManager structureManager = context.m_159774_().m_6018_().m_215082_();
        Optional template = structureManager.m_230407_(entry);
        if (template.isEmpty()) {
            UnusualPrehistory2.LOGGER.error("Identifier to the specified nbt file was not found! : {}", (Object)entry);
            return false;
        }
        Rotation rotation = Rotation.m_221990_((RandomSource)context.m_225041_());
        BlockPos halfLengths = new BlockPos(((StructureTemplate)template.get()).m_163801_().m_123341_() / 2, ((StructureTemplate)template.get()).m_163801_().m_123342_() / 2, ((StructureTemplate)template.get()).m_163801_().m_123343_() / 2);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().m_122190_((Vec3i)context.m_159777_());
        BlockPos position = context.m_159777_().m_6630_(((StructureFeatureConfig)context.m_159778_()).structureYOffset());
        StructurePlaceSettings placeSettings = new StructurePlaceSettings().m_74379_(rotation).m_74385_(halfLengths).m_74392_(false);
        Registry processorLists = context.m_159774_().m_6018_().m_7654_().m_206579_().m_175515_(Registries.f_257011_);
        StructureProcessorList emptyProcessor = (StructureProcessorList)processorLists.m_7745_(EMPTY);
        Optional processor = processorLists.m_6612_(((StructureFeatureConfig)context.m_159778_()).processor());
        processor.orElse(emptyProcessor).m_74425_().forEach(arg_0 -> ((StructurePlaceSettings)placeSettings).m_74383_(arg_0));
        mutable.m_122190_((Vec3i)position).m_122184_(-halfLengths.m_123341_(), 0, -halfLengths.m_123343_());
        ((StructureTemplate)template.get()).m_230328_((ServerLevelAccessor)context.m_159774_(), (BlockPos)mutable, (BlockPos)mutable, placeSettings, context.m_225041_(), 3);
        placeSettings.m_74394_();
        Optional postProcessor = processorLists.m_6612_(((StructureFeatureConfig)context.m_159778_()).postProcessor());
        postProcessor.orElse(emptyProcessor).m_74425_().forEach(arg_0 -> ((StructurePlaceSettings)placeSettings).m_74383_(arg_0));
        List list = placeSettings.m_74387_(((StructureTemplateAccessor)template.get()).getBlocks(), (BlockPos)mutable).m_74652_();
        StructureTemplate.m_74517_((ServerLevelAccessor)context.m_159774_(), (BlockPos)mutable, (BlockPos)mutable, (StructurePlaceSettings)placeSettings, (List)list);
        return true;
    }
}


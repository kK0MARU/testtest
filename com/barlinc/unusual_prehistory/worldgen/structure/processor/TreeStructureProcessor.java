/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$StructureBlockInfo
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.worldgen.structure.processor;

import com.barlinc.unusual_prehistory.registry.UP2StructureProcessors;
import com.mojang.serialization.Codec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

public class TreeStructureProcessor
extends StructureProcessor {
    public static final Codec<TreeStructureProcessor> CODEC = Codec.unit(() -> INSTANCE);
    public static final TreeStructureProcessor INSTANCE = new TreeStructureProcessor();

    @Nullable
    public StructureTemplate.StructureBlockInfo m_7382_(@NotNull LevelReader level, @NotNull BlockPos blockPosUnused, @NotNull BlockPos pos, // Could not load outer class - annotation placement on inner may be incorrect
     @NotNull StructureTemplate.StructureBlockInfo relativeInfo, // Could not load outer class - annotation placement on inner may be incorrect
     @NotNull StructureTemplate.StructureBlockInfo info, @NotNull StructurePlaceSettings settings) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos(info.f_74675_().m_123341_(), info.f_74675_().m_123342_(), info.f_74675_().m_123343_());
        if (this.canReplace(level.m_8055_((BlockPos)mutableBlockPos))) {
            return new StructureTemplate.StructureBlockInfo(info.f_74675_(), info.f_74676_(), info.f_74677_());
        }
        return null;
    }

    private boolean canReplace(BlockState blockState) {
        return blockState.m_60795_() || blockState.m_204336_(BlockTags.f_278411_);
    }

    @NotNull
    protected StructureProcessorType<?> m_6953_() {
        return (StructureProcessorType)UP2StructureProcessors.TREE.get();
    }
}


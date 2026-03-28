/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  com.mojang.serialization.codecs.RecordCodecBuilder$Instance
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.NoiseColumn
 *  net.minecraft.world.level.levelgen.structure.Structure
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationContext
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationStub
 *  net.minecraft.world.level.levelgen.structure.Structure$StructureSettings
 *  net.minecraft.world.level.levelgen.structure.StructureType
 *  net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement
 *  net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.worldgen.structure;

import com.barlinc.unusual_prehistory.registry.UP2Structures;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.jetbrains.annotations.NotNull;

public class UndergroundStructure
extends Structure {
    public static final Codec<UndergroundStructure> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)UndergroundStructure.m_226567_((RecordCodecBuilder.Instance)instance), (App)StructureTemplatePool.f_210555_.fieldOf("start_pool").forGetter(structure -> structure.startPool), (App)ResourceLocation.f_135803_.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName), (App)Codec.INT.fieldOf("size").forGetter(provider -> provider.size), (App)Codec.INT.fieldOf("min_y").forGetter(provider -> provider.min), (App)Codec.INT.fieldOf("max_y").forGetter(provider -> provider.max), (App)Codec.INT.fieldOf("offset_in_ground").forGetter(provider -> provider.offsetInGround), (App)Codec.intRange((int)1, (int)128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter)).apply((Applicative)instance, UndergroundStructure::new)).codec();
    private final Holder<StructureTemplatePool> startPool;
    private final Optional<ResourceLocation> startJigsawName;
    private final int size;
    private final int min;
    private final int max;
    private final int offsetInGround;
    private final int maxDistanceFromCenter;

    public UndergroundStructure(Structure.StructureSettings config, Holder<StructureTemplatePool> startPool, Optional<ResourceLocation> startJigsawName, int size, int min, int max, int offsetInGround, int maxDistanceFromCenter) {
        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.min = min;
        this.max = max;
        this.offsetInGround = offsetInGround;
        this.maxDistanceFromCenter = maxDistanceFromCenter;
    }

    @NotNull
    protected Optional<Structure.GenerationStub> m_214086_(Structure.GenerationContext context) {
        BlockPos blockPos = new BlockPos(context.f_226628_().m_45604_(), 0, context.f_226628_().m_45605_());
        BlockPos validPos = new BlockPos(blockPos.m_123341_(), this.getValidY(context.f_226622_().m_214184_(blockPos.m_123341_(), blockPos.m_123343_(), context.f_226629_(), context.f_226624_())), blockPos.m_123343_());
        if (validPos.m_123342_() != this.min - 1 && this.isSufficientlyFlat(context, validPos, 3)) {
            return JigsawPlacement.m_227238_((Structure.GenerationContext)context, this.startPool, this.startJigsawName, (int)this.size, (BlockPos)validPos.m_6625_(-this.offsetInGround), (boolean)false, Optional.empty(), (int)this.maxDistanceFromCenter);
        }
        return Optional.empty();
    }

    public boolean isSufficientlyFlat(Structure.GenerationContext context, BlockPos origin, int check) {
        ArrayList<BlockPos> blockPosList = new ArrayList<BlockPos>();
        for (int x = -check; x < check; ++x) {
            for (int z = -check; z < check; ++z) {
                blockPosList.add(origin.m_7918_(x, 0, z));
            }
        }
        int count = 0;
        for (BlockPos pos : blockPosList) {
            NoiseColumn blockView = context.f_226622_().m_214184_(pos.m_123341_(), pos.m_123343_(), context.f_226629_(), context.f_226624_());
            if (!blockView.m_183556_(pos.m_123342_()).m_60795_() || blockView.m_183556_(pos.m_7495_().m_123342_()).m_60795_()) continue;
            ++count;
        }
        return count >= check * check * 2;
    }

    public int getValidY(NoiseColumn sample) {
        int maxLength = 0;
        int currentLength = 0;
        int maxIndex = this.min - 1;
        for (int i = this.min; i < this.max; i += this.size) {
            if (sample.m_183556_(i).m_60795_()) {
                int j;
                for (j = i + 1; j < this.max && sample.m_183556_(j).m_60795_(); ++j) {
                }
                int sequenceLength = j - i;
                if (sequenceLength < this.size) continue;
                if ((currentLength += sequenceLength) > maxLength) {
                    maxLength = currentLength;
                    maxIndex = i;
                }
                i = j - 1;
                continue;
            }
            currentLength = 0;
        }
        return maxIndex;
    }

    @NotNull
    public StructureType<?> m_213658_() {
        return (StructureType)UP2Structures.UNDERGROUND_STRUCTURE.get();
    }
}


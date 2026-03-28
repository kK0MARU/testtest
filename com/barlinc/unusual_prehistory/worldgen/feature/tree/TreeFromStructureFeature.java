/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  it.unimi.dsi.fastutil.longs.LongIterator
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  net.minecraft.Util
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.Direction$Plane
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelSimulatedReader
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.LeavesBlock
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkStatus
 *  net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 *  net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider
 *  net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator
 *  net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator$Context
 *  net.minecraft.world.level.levelgen.structure.Structure
 *  net.minecraft.world.level.levelgen.structure.StructurePiece
 *  net.minecraft.world.level.levelgen.structure.StructureStart
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$Palette
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$StructureBlockInfo
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.worldgen.feature.tree;

import com.barlinc.unusual_prehistory.worldgen.feature.tree.config.TreeFromStructureConfig;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TreeFromStructureFeature
extends Feature<TreeFromStructureConfig> {
    public static final List<BlockStateModifier> BLOCK_STATE_MODIFIERS = (List)Util.m_137469_(new ArrayList(), list -> {
        list.add((modifiedPos, state, nbtState, rotation, level, directionOfGrowth) -> {
            for (Property property : state.m_61147_()) {
                if (!nbtState.m_61138_(property)) continue;
                Comparable value = nbtState.m_61143_(property);
                state = (BlockState)state.m_61124_(property, value);
            }
            return state;
        });
        list.add((modifiedPos, lastState, nbtState, rotation, level, directionOfGrowth) -> {
            if (lastState.m_61138_((Property)BlockStateProperties.f_61362_)) {
                FluidState fluidState = level.m_6425_(modifiedPos);
                lastState = fluidState.m_192917_((Fluid)Fluids.f_76193_) && fluidState.m_76186_() >= 7 ? (BlockState)lastState.m_61124_((Property)BlockStateProperties.f_61362_, (Comparable)Boolean.valueOf(true)) : (BlockState)lastState.m_61124_((Property)BlockStateProperties.f_61362_, (Comparable)Boolean.valueOf(false));
            }
            return lastState;
        });
        list.add((modifiedPos, lastState, nbtState, rotation, level, directionOfGrowth) -> lastState.m_60717_(rotation));
        list.add((modifiedPos, lastState, nbtState, rotation, level, directionOfGrowth) -> {
            if (lastState.m_61138_((Property)BlockStateProperties.f_61365_)) {
                Direction.Axis axis = (Direction.Axis)lastState.m_61143_((Property)BlockStateProperties.f_61365_);
                Direction.Axis directionOfGrowthAxis = directionOfGrowth.m_122434_();
                switch (directionOfGrowthAxis) {
                    case Y: {
                        break;
                    }
                    case X: {
                        if (axis == Direction.Axis.Y) {
                            lastState = (BlockState)lastState.m_61124_((Property)BlockStateProperties.f_61365_, (Comparable)Direction.Axis.X);
                            break;
                        }
                        if (axis != Direction.Axis.X) break;
                        lastState = (BlockState)lastState.m_61124_((Property)BlockStateProperties.f_61365_, (Comparable)Direction.Axis.Y);
                        break;
                    }
                    case Z: {
                        if (axis == Direction.Axis.Y) {
                            lastState = (BlockState)lastState.m_61124_((Property)BlockStateProperties.f_61365_, (Comparable)Direction.Axis.Z);
                            break;
                        }
                        if (axis != Direction.Axis.Z) break;
                        lastState = (BlockState)lastState.m_61124_((Property)BlockStateProperties.f_61365_, (Comparable)Direction.Axis.Y);
                    }
                }
            }
            return lastState;
        });
    });

    public TreeFromStructureFeature(Codec<TreeFromStructureConfig> config) {
        super(config);
    }

    public boolean m_142674_(FeaturePlaceContext<TreeFromStructureConfig> featurePlaceContext) {
        TreeFromStructureConfig config = (TreeFromStructureConfig)featurePlaceContext.m_159778_();
        BlockStateProvider logProvider = config.logProvider();
        List<BlockStateProvider> leavesProvider = config.leavesProvider();
        WorldGenLevel level = featurePlaceContext.m_159774_();
        StructureTemplateManager templateManager = level.m_6018_().m_215082_();
        ResourceLocation baseLocation = config.baseLocation();
        Optional baseTemplateOptional = templateManager.m_230407_(baseLocation);
        ResourceLocation canopyLocation = config.canopyLocation();
        Optional canopyTemplateOptional = templateManager.m_230407_(canopyLocation);
        if (baseTemplateOptional.isEmpty()) {
            throw TreeFromStructureFeature.noTreePartPresent(baseLocation);
        }
        if (canopyTemplateOptional.isEmpty()) {
            throw TreeFromStructureFeature.noTreePartPresent(canopyLocation);
        }
        StructureTemplate baseTemplate = (StructureTemplate)baseTemplateOptional.get();
        StructureTemplate canopyTemplate = (StructureTemplate)canopyTemplateOptional.get();
        List basePalettes = baseTemplate.f_74482_;
        List canopyPalettes = canopyTemplate.f_74482_;
        BlockPos origin = featurePlaceContext.m_159777_();
        RandomSource random = featurePlaceContext.m_225041_();
        StructurePlaceSettings placeSettings = new StructurePlaceSettings().m_74379_(Rotation.m_221990_((RandomSource)random));
        StructureTemplate.Palette trunkBasePalette = placeSettings.m_74387_(basePalettes, origin);
        StructureTemplate.Palette randomCanopyPalette = placeSettings.m_74387_(canopyPalettes, origin);
        List center = trunkBasePalette.m_74653_(Blocks.f_50041_);
        if (center.isEmpty()) {
            throw new IllegalArgumentException("No trunk central position was specified for structure NBT palette %s. Trunk central position is specified with white wool.".formatted(new Object[]{config.baseLocation()}));
        }
        if (center.size() > 1) {
            throw new IllegalArgumentException("There cannot be more than one trunk central position for structure NBT palette %s. Trunk central position is specified with white wool.".formatted(new Object[]{config.baseLocation()}));
        }
        BlockPos centerOffset = ((StructureTemplate.StructureBlockInfo)center.get(0)).f_74675_();
        centerOffset = new BlockPos(-centerOffset.m_123341_(), 0, -centerOffset.m_123343_());
        List<StructureTemplate.StructureBlockInfo> logs = TreeFromStructureFeature.getStructureInfosInStructurePalletteFromBlockList(config.logTarget(), trunkBasePalette);
        List logBuilders = trunkBasePalette.m_74653_(Blocks.f_50108_);
        if (logBuilders.isEmpty()) {
            throw new UnsupportedOperationException(String.format("\"%s\" is missing log builders.", baseLocation));
        }
        int trunkLength = config.height().m_214085_(random);
        int maxTrunkBuildingDepth = config.maxLogDepth();
        Direction direction = TreeFromStructureFeature.findDirectionOfGrowthFromOrientation(config.orientation(), config, logBuilders, placeSettings, centerOffset, level, origin, random);
        if (direction == null) {
            return false;
        }
        HashMap<BlockPos, BlockState> leavePositions = new HashMap<BlockPos, BlockState>();
        HashMap<BlockPos, BlockState> logPositions = new HashMap<BlockPos, BlockState>();
        HashMap<BlockPos, BlockState> additionalPositions = new HashMap<BlockPos, BlockState>();
        TreeFromStructureFeature.fillTrunkPositions(logProvider, leavesProvider, config, level, random, origin, placeSettings, trunkBasePalette, centerOffset, logs, logBuilders, leavePositions, logPositions, additionalPositions, maxTrunkBuildingDepth, direction);
        if (!TreeFromStructureFeature.fillCanopyPositions(trunkBasePalette.m_74653_(Blocks.f_50098_), config, level, random, placeSettings, centerOffset, origin, randomCanopyPalette, leavePositions, logPositions, additionalPositions, trunkLength, direction)) {
            return false;
        }
        if (config.isSapling() && TreeFromStructureFeature.validateLogPositions(logPositions, config, level)) {
            return false;
        }
        if (TreeFromStructureFeature.insideStructure(logPositions, level, config)) {
            return false;
        }
        TreeFromStructureFeature.placeKnownBlockPositions(logPositions, level);
        TreeFromStructureFeature.placeKnownLeavePositions(leavePositions, level);
        TreeFromStructureFeature.placeKnownBlockPositions(additionalPositions, level);
        HashSet<BlockPos> decorationPositions = new HashSet<BlockPos>();
        TreeFromStructureFeature.placeTreeDecorations(config.treeDecorators(), level, random, leavePositions.keySet(), logPositions.keySet(), decorationPositions);
        return true;
    }

    private static boolean doAllPositionsTouchGround(List<StructureTemplate.StructureBlockInfo> logBuilders, StructurePlaceSettings placeSettings, BlockPos centerOffset, BlockPos origin, TreeFromStructureConfig config, WorldGenLevel level, Direction direction) {
        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = TreeFromStructureFeature.getModifiedPos(placeSettings, logBuilder, centerOffset, origin);
            pos = TreeFromStructureFeature.rotateInDirectionAroundOrigin(pos, origin, direction);
            if (TreeFromStructureFeature.isOnGround(config.maxLogDepth(), level, pos, config.growableOn(), direction)) continue;
            return false;
        }
        return true;
    }

    @Nullable
    private static Direction findDirectionOfGrowthFromOrientation(TreeFromStructureConfig.Orientation orientation, TreeFromStructureConfig config, List<StructureTemplate.StructureBlockInfo> logBuilders, StructurePlaceSettings placeSettings, BlockPos centerOffset, WorldGenLevel level, BlockPos origin, RandomSource random) {
        switch (orientation) {
            case STANDARD: {
                if (TreeFromStructureFeature.doAllPositionsTouchGround(logBuilders, placeSettings, centerOffset, origin, config, level, Direction.UP)) {
                    return Direction.UP;
                }
                return null;
            }
            case UPSIDE_DOWN: {
                if (TreeFromStructureFeature.doAllPositionsTouchGround(logBuilders, placeSettings, centerOffset, origin, config, level, Direction.DOWN)) {
                    return Direction.DOWN;
                }
                return null;
            }
            case SIDEWAYS: {
                List horizontalDirections = Direction.Plane.HORIZONTAL.m_235694_(random);
                ArrayList<Direction> validDirections = new ArrayList<Direction>(horizontalDirections.size());
                for (Direction direction : horizontalDirections) {
                    if (!TreeFromStructureFeature.doAllPositionsTouchGround(logBuilders, placeSettings, centerOffset, origin, config, level, direction)) continue;
                    validDirections.add(direction);
                }
                if (!validDirections.isEmpty()) {
                    return (Direction)validDirections.get(0);
                }
                return null;
            }
        }
        throw new IllegalArgumentException("Unreachable statement, orientation %s is not supported.".formatted(new Object[]{orientation}));
    }

    private static boolean fillCanopyPositions(List<StructureTemplate.StructureBlockInfo> canopyAnchor, TreeFromStructureConfig config, WorldGenLevel level, RandomSource randomSource, StructurePlaceSettings placeSettings, BlockPos centerOffset, BlockPos origin, StructureTemplate.Palette randomCanopyPalette, Map<BlockPos, BlockState> leavePositions, Map<BlockPos, BlockState> logPositions, Map<BlockPos, BlockState> additionalPositions, int trunkLength, Direction treeGrowthDirection) {
        if (!canopyAnchor.isEmpty()) {
            if (canopyAnchor.size() > 1) {
                throw new IllegalArgumentException("There cannot be more than one central canopy position. Canopy central position is specified with yellow wool on the trunk palette.");
            }
            return TreeFromStructureFeature.fillCanopyPositions(config.logProvider(), config.leavesProvider(), config, level, randomSource, TreeFromStructureFeature.getModifiedPos(placeSettings, canopyAnchor.get(0), centerOffset, origin), placeSettings, randomCanopyPalette, leavePositions, logPositions, additionalPositions, trunkLength, treeGrowthDirection);
        }
        return TreeFromStructureFeature.fillCanopyPositions(config.logProvider(), config.leavesProvider(), config, level, randomSource, origin, placeSettings, randomCanopyPalette, leavePositions, logPositions, additionalPositions, trunkLength, treeGrowthDirection);
    }

    private static boolean insideStructure(Map<BlockPos, BlockState> logPositions, WorldGenLevel level, TreeFromStructureConfig config) {
        if (level instanceof WorldGenRegion) {
            WorldGenRegion region = (WorldGenRegion)level;
            for (BlockPos trunkPosition : logPositions.keySet()) {
                ChunkAccess chunk = level.m_46865_(trunkPosition);
                for (StructureStart structureStart : chunk.m_6633_().values()) {
                    for (StructurePiece piece : structureStart.m_73602_()) {
                        if (!piece.m_73547_().m_71051_((Vec3i)trunkPosition) || TreeFromStructureFeature.testValidPos(config, level, trunkPosition)) continue;
                        return true;
                    }
                }
                for (Map.Entry entry : chunk.m_62769_().entrySet()) {
                    Structure structure = (Structure)entry.getKey();
                    LongSet references = (LongSet)entry.getValue();
                    LongIterator longIterator = references.iterator();
                    while (longIterator.hasNext()) {
                        ChunkAccess referenceChunk;
                        StructureStart startForStructure;
                        int chunkZ;
                        long reference = (Long)longIterator.next();
                        int chunkX = ChunkPos.m_45592_((long)reference);
                        if (!region.m_7232_(chunkX, chunkZ = ChunkPos.m_45602_((long)reference)) || (startForStructure = (referenceChunk = region.m_6522_(chunkX, chunkZ, ChunkStatus.f_62315_, true)).m_213652_(structure)) == null) continue;
                        for (StructurePiece piece : startForStructure.m_73602_()) {
                            if (!piece.m_73547_().m_71051_((Vec3i)trunkPosition) || TreeFromStructureFeature.testValidPos(config, level, trunkPosition)) continue;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean validateLogPositions(Map<BlockPos, BlockState> logPositions, TreeFromStructureConfig config, WorldGenLevel level) {
        for (BlockPos trunkPosition : logPositions.keySet()) {
            if (TreeFromStructureFeature.testValidPos(config, level, trunkPosition)) continue;
            return true;
        }
        return false;
    }

    private static boolean testValidPos(TreeFromStructureConfig config, WorldGenLevel level, BlockPos trunkPosition) {
        return config.leavesPlacementFilter().test((Object)level, (Object)trunkPosition);
    }

    private static void placeKnownBlockPositions(Map<BlockPos, BlockState> trunkPositions, WorldGenLevel level) {
        for (Map.Entry<BlockPos, BlockState> entry : trunkPositions.entrySet()) {
            BlockPos trunkPosition = entry.getKey();
            BlockState state = entry.getValue();
            level.m_7731_(trunkPosition, state, 2);
        }
    }

    private static void placeKnownLeavePositions(Map<BlockPos, BlockState> leavePositions, WorldGenLevel level) {
        ArrayList<Runnable> leavesPostApply = new ArrayList<Runnable>(leavePositions.size());
        for (Map.Entry<BlockPos, BlockState> entry : leavePositions.entrySet()) {
            BlockPos leavePosition = entry.getKey();
            BlockState state = entry.getValue();
            level.m_7731_(leavePosition, state, 2);
            if (!state.m_61138_((Property)LeavesBlock.f_54418_)) continue;
            Runnable postProcess = () -> {
                BlockState blockState = LeavesBlock.m_54435_((BlockState)state, (LevelAccessor)level, (BlockPos)leavePosition);
                if ((Integer)blockState.m_61143_((Property)LeavesBlock.f_54418_) < 7) {
                    if (blockState.m_61138_((Property)LeavesBlock.f_54419_)) {
                        blockState = (BlockState)blockState.m_61124_((Property)LeavesBlock.f_54419_, (Comparable)Boolean.valueOf(false));
                    }
                    level.m_7731_(leavePosition, blockState, 2);
                    level.m_186460_(leavePosition, blockState.m_60734_(), 0);
                } else {
                    level.m_7471_(leavePosition, false);
                    leavePositions.remove(leavePosition.m_7949_());
                }
            };
            leavesPostApply.add(postProcess);
        }
        leavesPostApply.forEach(Runnable::run);
    }

    public static void fillTrunkPositions(BlockStateProvider logProvider, List<BlockStateProvider> leavesProvider, TreeFromStructureConfig config, WorldGenLevel level, RandomSource randomSource, BlockPos origin, StructurePlaceSettings placeSettings, StructureTemplate.Palette trunkBasePalette, BlockPos centerOffset, List<StructureTemplate.StructureBlockInfo> logs, List<StructureTemplate.StructureBlockInfo> logBuilders, Map<BlockPos, BlockState> leavePositions, Map<BlockPos, BlockState> trunkPositions, Map<BlockPos, BlockState> additionalBlocks, int maxTrunkBuildingDepth, Direction treeGrowthDirection) {
        TreeFromStructureFeature.fillLogsUnder(logProvider, level, randomSource, origin, placeSettings, centerOffset, logBuilders, maxTrunkBuildingDepth, config.growableOn(), trunkPositions, treeGrowthDirection);
        TreeFromStructureFeature.placeLogsWithRotation(logProvider, level, randomSource, origin, placeSettings, centerOffset, logs, trunkPositions, treeGrowthDirection);
        TreeFromStructureFeature.placeLeavesWithCalculatedDistanceAndRotation(leavesProvider, level, origin, randomSource, placeSettings, TreeFromStructureFeature.getStructureInfosInStructurePalletteFromBlockListV2(config.leavesTarget(), trunkBasePalette), leavePositions, centerOffset, config.leavesPlacementFilter(), treeGrowthDirection);
        Map<Block, BlockStateProvider> replaceFromNBT = config.replaceFromNBT();
        replaceFromNBT.forEach((old, newBlock) -> {
            List<StructureTemplate.StructureBlockInfo> additionalBlocksInfo = TreeFromStructureFeature.getStructureInfosInStructurePalletteFromBlockList(List.of((Object)old), trunkBasePalette);
            for (StructureTemplate.StructureBlockInfo additionalBlock : additionalBlocksInfo) {
                BlockPos pos = TreeFromStructureFeature.getModifiedPos(placeSettings, additionalBlock, centerOffset, origin);
                pos = TreeFromStructureFeature.rotateInDirectionAroundOrigin(pos, origin, treeGrowthDirection);
                additionalBlocks.put(pos.m_7949_(), TreeFromStructureFeature.getTransformedState(pos, newBlock.m_213972_(randomSource, pos), additionalBlock.f_74676_(), placeSettings.m_74404_(), level, treeGrowthDirection));
            }
        });
    }

    public static boolean fillCanopyPositions(BlockStateProvider logProvider, List<BlockStateProvider> leavesProvider, TreeFromStructureConfig config, WorldGenLevel level, RandomSource randomSource, BlockPos origin, StructurePlaceSettings placeSettings, StructureTemplate.Palette randomCanopyPalette, Map<BlockPos, BlockState> leavePositions, Map<BlockPos, BlockState> trunkPositions, Map<BlockPos, BlockState> additionalBlocks, int trunkLength, Direction treeGrowthDirection) {
        ArrayList<StructureTemplate.StructureBlockInfo> trunkFillers;
        List<List<StructureTemplate.StructureBlockInfo>> leaves = TreeFromStructureFeature.getStructureInfosInStructurePalletteFromBlockListV2(config.leavesTarget(), randomCanopyPalette);
        List<StructureTemplate.StructureBlockInfo> canopyLogs = TreeFromStructureFeature.getStructureInfosInStructurePalletteFromBlockList(config.logTarget(), randomCanopyPalette);
        List canopyAnchor = randomCanopyPalette.m_74653_(Blocks.f_50041_);
        if (canopyAnchor.isEmpty()) {
            throw new IllegalArgumentException("No canopy anchor was specified for structure NBT palette %s. Canopy anchor is specified with white wool.".formatted(new Object[]{config.canopyLocation()}));
        }
        if (canopyAnchor.size() > 1) {
            throw new IllegalArgumentException("There cannot be more than one canopy anchor for structure NBT palette %s. Canopy anchor is specified with white wool.".formatted(new Object[]{config.canopyLocation()}));
        }
        StructureTemplate.StructureBlockInfo structureBlockInfo = (StructureTemplate.StructureBlockInfo)canopyAnchor.get(0);
        BlockPos canopyCenterOffset = structureBlockInfo.f_74675_();
        if (!TreeFromStructureFeature.intersectTrunk(logProvider, level, randomSource, origin, placeSettings, canopyCenterOffset = new BlockPos(-canopyCenterOffset.m_123341_(), trunkLength, -canopyCenterOffset.m_123343_()), trunkFillers = new ArrayList<StructureTemplate.StructureBlockInfo>(randomCanopyPalette.m_74653_(Blocks.f_50108_)), trunkLength + 1, trunkPositions, treeGrowthDirection)) {
            return false;
        }
        TreeFromStructureFeature.placeLogsWithRotation(logProvider, level, randomSource, origin, placeSettings, canopyCenterOffset, canopyLogs, trunkPositions, treeGrowthDirection);
        TreeFromStructureFeature.placeLeavesWithCalculatedDistanceAndRotation(leavesProvider, level, origin, randomSource, placeSettings, leaves, leavePositions, canopyCenterOffset, config.leavesPlacementFilter(), treeGrowthDirection);
        Map<Block, BlockStateProvider> replaceFromNBT = config.replaceFromNBT();
        BlockPos finalCanopyCenterOffset = canopyCenterOffset;
        replaceFromNBT.forEach((old, newBlock) -> {
            List<StructureTemplate.StructureBlockInfo> additionalBlocksInfo = TreeFromStructureFeature.getStructureInfosInStructurePalletteFromBlockList(List.of((Object)old), randomCanopyPalette);
            for (StructureTemplate.StructureBlockInfo additionalBlock : additionalBlocksInfo) {
                BlockPos pos = TreeFromStructureFeature.getModifiedPos(placeSettings, additionalBlock, finalCanopyCenterOffset, origin);
                pos = TreeFromStructureFeature.rotateInDirectionAroundOrigin(pos, origin, treeGrowthDirection);
                additionalBlocks.put(pos.m_7949_(), TreeFromStructureFeature.getTransformedState(pos, newBlock.m_213972_(randomSource, pos), additionalBlock.f_74676_(), placeSettings.m_74404_(), level, treeGrowthDirection));
            }
        });
        return true;
    }

    public static void placeLogsWithRotation(BlockStateProvider logProvider, WorldGenLevel level, RandomSource random, BlockPos origin, StructurePlaceSettings placeSettings, BlockPos centerOffset, List<StructureTemplate.StructureBlockInfo> logs, Map<BlockPos, BlockState> trunkPositions, Direction treeGrowthDirection) {
        for (StructureTemplate.StructureBlockInfo trunk : logs) {
            BlockPos pos = TreeFromStructureFeature.getModifiedPos(placeSettings, trunk, centerOffset, origin);
            pos = TreeFromStructureFeature.rotateInDirectionAroundOrigin(pos, origin, treeGrowthDirection);
            trunkPositions.put(pos.m_7949_(), TreeFromStructureFeature.getTransformedState(pos, logProvider.m_213972_(random, pos), trunk.f_74676_(), placeSettings.m_74404_(), level, treeGrowthDirection));
        }
    }

    public static void placeTreeDecorations(Iterable<TreeDecorator> treeDecorators, WorldGenLevel level, RandomSource random, Set<BlockPos> leavePositions, Set<BlockPos> trunkPositions, Set<BlockPos> decorationPositions) {
        for (TreeDecorator treeDecorator : treeDecorators) {
            treeDecorator.m_214187_(new TreeDecorator.Context((LevelSimulatedReader)level, (pos, state) -> {
                level.m_7731_(pos, state, 2);
                decorationPositions.add(pos.m_7949_());
            }, random, trunkPositions, leavePositions, trunkPositions));
        }
    }

    public static void placeLeavesWithCalculatedDistanceAndRotation(List<BlockStateProvider> leavesProvider, WorldGenLevel level, BlockPos origin, RandomSource random, StructurePlaceSettings placeSettings, List<List<StructureTemplate.StructureBlockInfo>> leaves, Map<BlockPos, BlockState> leavePositions, BlockPos canopyCenterOffset, BlockPredicate leavesPlacementFilter, Direction treeGrowthDirection) {
        for (int i = 0; i < leaves.size(); ++i) {
            List<StructureTemplate.StructureBlockInfo> meow = leaves.get(i);
            for (StructureTemplate.StructureBlockInfo leaf : meow) {
                BlockPos modifiedPos = TreeFromStructureFeature.getModifiedPos(placeSettings, leaf, canopyCenterOffset, origin);
                if (!leavesPlacementFilter.test((Object)level, (Object)(modifiedPos = TreeFromStructureFeature.rotateInDirectionAroundOrigin(modifiedPos, origin, treeGrowthDirection)))) continue;
                leavePositions.put(modifiedPos.m_7949_(), TreeFromStructureFeature.getTransformedState(modifiedPos, leavesProvider.get(i).m_213972_(random, modifiedPos), leaf.f_74676_(), placeSettings.m_74404_(), level, treeGrowthDirection));
            }
        }
    }

    public static void fillLogsUnder(BlockStateProvider logProvider, WorldGenLevel level, RandomSource random, BlockPos origin, StructurePlaceSettings placeSettings, BlockPos centerOffset, List<StructureTemplate.StructureBlockInfo> logBuilders, int maxTrunkBuildingDepth, BlockPredicate groundFilter, Map<BlockPos, BlockState> trunkPositions, Direction treeGrowthDirection) {
        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = TreeFromStructureFeature.getModifiedPos(placeSettings, logBuilder, centerOffset, origin);
            pos = TreeFromStructureFeature.rotateInDirectionAroundOrigin(pos, origin, treeGrowthDirection);
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().m_122190_((Vec3i)pos);
            for (int i = 0; i < maxTrunkBuildingDepth && !groundFilter.test((Object)level, (Object)mutableBlockPos) && !level.m_8055_((BlockPos)mutableBlockPos).m_60713_(Blocks.f_50752_); ++i) {
                trunkPositions.put(mutableBlockPos.m_7949_(), TreeFromStructureFeature.getTransformedState((BlockPos)mutableBlockPos, logProvider.m_213972_(random, (BlockPos)mutableBlockPos), logBuilder.f_74676_(), placeSettings.m_74404_(), level, treeGrowthDirection));
                mutableBlockPos.m_122173_(treeGrowthDirection.m_122424_());
            }
        }
    }

    public static boolean intersectTrunk(BlockStateProvider logProvider, WorldGenLevel level, RandomSource random, BlockPos origin, StructurePlaceSettings placeSettings, BlockPos centerOffset, List<StructureTemplate.StructureBlockInfo> logBuilders, int maxTrunkBuildingDepth, Map<BlockPos, BlockState> trunkPositions, Direction treeGrowthDirection) {
        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = TreeFromStructureFeature.getModifiedPos(placeSettings, logBuilder, centerOffset, origin);
            pos = TreeFromStructureFeature.rotateInDirectionAroundOrigin(pos, origin, treeGrowthDirection);
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().m_122190_((Vec3i)pos);
            for (int i = 0; i <= maxTrunkBuildingDepth && !trunkPositions.containsKey(mutableBlockPos); ++i) {
                trunkPositions.put(mutableBlockPos.m_7949_(), TreeFromStructureFeature.getTransformedState((BlockPos)mutableBlockPos, logProvider.m_213972_(random, (BlockPos)mutableBlockPos), logBuilder.f_74676_(), placeSettings.m_74404_(), level, treeGrowthDirection));
                mutableBlockPos.m_122173_(treeGrowthDirection.m_122424_());
                if (i != maxTrunkBuildingDepth) continue;
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static BlockState getTransformedState(BlockPos modifiedPos, BlockState state, BlockState nbtState, Rotation rotation, WorldGenLevel level, Direction directionOfGrowth) {
        for (BlockStateModifier modifier : BLOCK_STATE_MODIFIERS) {
            state = modifier.apply(modifiedPos, state, nbtState, rotation, level, directionOfGrowth);
        }
        return state;
    }

    public static boolean isOnGround(int maxLogDepth, WorldGenLevel level, BlockPos pos, BlockPredicate growableOn, Direction treeGrowthDirection) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().m_122190_((Vec3i)pos);
        for (int logDepth = 0; logDepth < maxLogDepth; ++logDepth) {
            mutableBlockPos.m_122173_(treeGrowthDirection.m_122424_());
            if (!growableOn.test((Object)level, (Object)mutableBlockPos)) continue;
            return true;
        }
        return false;
    }

    public static BlockPos getModifiedPos(StructurePlaceSettings settings, StructureTemplate.StructureBlockInfo placing, BlockPos partCenter, BlockPos featureOrigin) {
        return StructureTemplate.m_74563_((StructurePlaceSettings)settings, (BlockPos)placing.f_74675_()).m_121955_((Vec3i)featureOrigin).m_121955_((Vec3i)StructureTemplate.m_74563_((StructurePlaceSettings)settings, (BlockPos)partCenter));
    }

    public static BlockPos rotateInDirectionAroundOrigin(BlockPos pos, BlockPos origin, Direction direction) {
        BlockPos offset = pos.m_121996_((Vec3i)origin);
        return switch (direction) {
            default -> throw new IncompatibleClassChangeError();
            case Direction.UP -> pos;
            case Direction.DOWN -> new BlockPos(origin.m_123341_() + offset.m_123341_(), origin.m_123342_() - offset.m_123342_(), origin.m_123343_() + offset.m_123343_());
            case Direction.EAST -> new BlockPos(origin.m_123341_() + offset.m_123342_(), origin.m_123342_() - offset.m_123341_(), origin.m_123343_() + offset.m_123343_());
            case Direction.WEST -> new BlockPos(origin.m_123341_() - offset.m_123342_(), origin.m_123342_() + offset.m_123341_(), origin.m_123343_() + offset.m_123343_());
            case Direction.NORTH -> new BlockPos(origin.m_123341_() + offset.m_123341_(), origin.m_123342_() - offset.m_123343_(), origin.m_123343_() - offset.m_123342_());
            case Direction.SOUTH -> new BlockPos(origin.m_123341_() + offset.m_123341_(), origin.m_123342_() + offset.m_123343_(), origin.m_123343_() + offset.m_123342_());
        };
    }

    public static IllegalArgumentException noTreePartPresent(ResourceLocation location) {
        return new IllegalArgumentException(String.format("\"%s\" is not a valid tree part.", location));
    }

    public static List<StructureTemplate.StructureBlockInfo> getStructureInfosInStructurePalletteFromBlockList(Iterable<Block> blocks, StructureTemplate.Palette palette) {
        ArrayList<StructureTemplate.StructureBlockInfo> result = new ArrayList<StructureTemplate.StructureBlockInfo>();
        for (Block block : blocks) {
            result.addAll(palette.m_74653_(block));
        }
        return result;
    }

    public static List<List<StructureTemplate.StructureBlockInfo>> getStructureInfosInStructurePalletteFromBlockListV2(Iterable<Block> blocks, StructureTemplate.Palette palette) {
        ArrayList<List<StructureTemplate.StructureBlockInfo>> result = new ArrayList<List<StructureTemplate.StructureBlockInfo>>();
        for (Block block : blocks) {
            result.add(palette.m_74653_(block));
        }
        return result;
    }

    @FunctionalInterface
    public static interface BlockStateModifier {
        public BlockState apply(BlockPos var1, BlockState var2, BlockState var3, Rotation var4, WorldGenLevel var5, Direction var6);
    }
}


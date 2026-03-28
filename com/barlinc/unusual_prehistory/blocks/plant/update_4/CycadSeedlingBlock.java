/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.feature.ConfiguredFeature
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.shapes.BooleanOp
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.event.level.SaplingGrowTreeEvent
 *  net.minecraftforge.eventbus.api.Event$Result
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_4;

import com.barlinc.unusual_prehistory.blocks.plant.PrehistoricPlantBlock;
import com.barlinc.unusual_prehistory.registry.UP2Features;
import java.util.Optional;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import org.jetbrains.annotations.NotNull;

public class CycadSeedlingBlock
extends PrehistoricPlantBlock
implements BonemealableBlock {
    public static final VoxelShape SHAPE = CycadSeedlingBlock.buildShape(Block.m_49796_((double)5.0, (double)0.0, (double)5.0, (double)11.0, (double)8.0, (double)11.0), Block.m_49796_((double)6.0, (double)8.0, (double)6.0, (double)10.0, (double)12.0, (double)10.0));

    public CycadSeedlingBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    @NotNull
    public VoxelShape m_5940_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean m_7370_(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean m_214167_(@NotNull Level level, RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return random.m_188501_() < 0.4f;
    }

    @Override
    public void m_214148_(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        this.growCycad(level, pos, state, random);
    }

    public boolean growCycad(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        Optional optional = level.m_9598_().m_175515_(Registries.f_256911_).m_203636_(UP2Features.CYCAD);
        if (optional.isEmpty()) {
            return false;
        }
        SaplingGrowTreeEvent event = ForgeEventFactory.blockGrowFeature((LevelAccessor)level, (RandomSource)random, (BlockPos)pos, (Holder)((Holder)optional.get()));
        if (event.getResult().equals((Object)Event.Result.DENY)) {
            return false;
        }
        level.m_7471_(pos, false);
        if (((ConfiguredFeature)event.getFeature().m_203334_()).m_224953_((WorldGenLevel)level, level.m_7726_().m_8481_(), random, pos)) {
            return true;
        }
        level.m_7731_(pos, state, 3);
        return false;
    }

    private static VoxelShape buildShape(VoxelShape ... from) {
        return Stream.of(from).reduce((v1, v2) -> Shapes.m_83113_((VoxelShape)v1, (VoxelShape)v2, (BooleanOp)BooleanOp.f_82695_)).get();
    }

    public boolean m_7357_(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull PathComputationType type) {
        return false;
    }

    public float m_7749_(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos blockPos) {
        return 1.0f;
    }

    public boolean m_7420_(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos blockPos) {
        return true;
    }
}


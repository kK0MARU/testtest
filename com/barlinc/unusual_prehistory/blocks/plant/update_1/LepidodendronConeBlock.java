/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.SaplingBlock
 *  net.minecraft.world.level.block.grower.AbstractTreeGrower
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_1;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class LepidodendronConeBlock
extends SaplingBlock {
    public static final BooleanProperty HANGING = BlockStateProperties.f_61435_;
    protected static final VoxelShape SHAPE = Block.m_49796_((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)13.0, (double)12.0);
    protected static final VoxelShape HANGING_SHAPE = Block.m_49796_((double)4.0, (double)2.0, (double)4.0, (double)12.0, (double)16.0, (double)12.0);

    public LepidodendronConeBlock(AbstractTreeGrower tree, BlockBehaviour.Properties properties) {
        super(tree, properties);
        this.m_49959_((BlockState)((BlockState)this.m_49966_().m_61124_((Property)HANGING, (Comparable)Boolean.valueOf(false))).m_61124_((Property)f_55973_, (Comparable)Integer.valueOf(0)));
    }

    public void m_213898_(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos blockPos, @NotNull RandomSource random) {
        if (!LepidodendronConeBlock.isHanging(state) && level.m_46803_(blockPos.m_7494_()) >= 9 && random.m_188503_(7) == 0) {
            this.m_222000_(level, blockPos, state, random);
        }
    }

    public boolean m_7898_(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos blockPos) {
        return LepidodendronConeBlock.isHanging(state) ? level.m_8055_(blockPos.m_7494_()).m_60713_((Block)UP2Blocks.LEPIDODENDRON_LEAVES.get()) : super.m_7898_(state, level, blockPos);
    }

    private static boolean isHanging(BlockState state) {
        return (Boolean)state.m_61143_((Property)HANGING);
    }

    public boolean m_7370_(@NotNull LevelReader level, @NotNull BlockPos blockPos, @NotNull BlockState state, boolean valid) {
        return !LepidodendronConeBlock.isHanging(state);
    }

    public static BlockState createHangingCone() {
        return (BlockState)((Block)UP2Blocks.LEPIDODENDRON_CONE.get()).m_49966_().m_61124_((Property)HANGING, (Comparable)Boolean.valueOf(true));
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[]{HANGING}).m_61104_(new Property[]{f_55973_});
    }

    @NotNull
    public VoxelShape m_5940_(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Vec3 offset = state.m_60824_(level, pos);
        return (Boolean)state.m_61143_((Property)HANGING) != false ? HANGING_SHAPE.m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_) : SHAPE.m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }
}


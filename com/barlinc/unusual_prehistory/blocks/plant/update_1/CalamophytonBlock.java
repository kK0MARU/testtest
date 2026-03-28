/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_1;

import com.barlinc.unusual_prehistory.blocks.plant.ThreeTallPlantBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class CalamophytonBlock
extends ThreeTallPlantBlock {
    protected static final VoxelShape BOTTOM_SHAPE = Block.m_49796_((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)16.0, (double)12.0);
    protected static final VoxelShape TOP_SHAPE = Block.m_49796_((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)14.0, (double)12.0);

    public CalamophytonBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    @NotNull
    public VoxelShape m_5940_(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.m_60824_(blockGetter, pos);
        if ((Integer)state.m_61143_((Property)LAYER) == 2) {
            return TOP_SHAPE.m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
        }
        return BOTTOM_SHAPE.m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.TallFlowerBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant;

import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class PrehistoricTallFlowerBlock
extends TallFlowerBlock {
    protected static final VoxelShape UPPER_SHAPE = Block.m_49796_((double)2.0, (double)0.0, (double)2.0, (double)14.0, (double)16.0, (double)14.0);
    protected static final VoxelShape LOWER_SHAPE = Block.m_49796_((double)2.0, (double)0.0, (double)2.0, (double)14.0, (double)16.0, (double)14.0);

    public PrehistoricTallFlowerBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape m_5940_(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Vec3 offset = state.m_60824_(level, pos);
        return state.m_61143_((Property)f_52858_) == DoubleBlockHalf.LOWER ? LOWER_SHAPE.m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_) : UPPER_SHAPE.m_83216_(offset.f_82479_, offset.f_82480_, offset.f_82481_);
    }

    protected boolean m_6266_(BlockState state, @NotNull BlockGetter block, @NotNull BlockPos pos) {
        return state.m_204336_(UP2BlockTags.ANCIENT_PLANT_PLACEABLE);
    }
}


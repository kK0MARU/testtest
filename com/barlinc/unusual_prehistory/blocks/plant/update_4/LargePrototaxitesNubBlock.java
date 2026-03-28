/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.Property
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_4;

import com.barlinc.unusual_prehistory.blocks.plant.PrehistoricTallPlantBlock;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;

public class LargePrototaxitesNubBlock
extends PrehistoricTallPlantBlock
implements BonemealableBlock {
    public LargePrototaxitesNubBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void m_214148_(@NotNull ServerLevel level, @NotNull RandomSource source, @NotNull BlockPos pos, @NotNull BlockState state) {
        LargePrototaxitesNubBlock.m_49840_((Level)level, (BlockPos)pos, (ItemStack)new ItemStack((ItemLike)UP2Blocks.PROTOTAXITES_NUB.get()));
    }

    @Override
    protected boolean m_6266_(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return state.m_60804_(level, pos);
    }

    public boolean m_7898_(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        if (state.m_61143_((Property)f_52858_) != DoubleBlockHalf.UPPER) {
            return super.m_7898_(state, level, pos);
        }
        BlockPos blockpos = pos.m_7495_();
        BlockState blockstate = level.m_8055_(blockpos);
        if (blockstate.m_204336_(BlockTags.f_13057_)) {
            return true;
        }
        return blockstate.m_60713_((Block)this) && blockstate.m_61143_((Property)f_52858_) == DoubleBlockHalf.LOWER;
    }
}


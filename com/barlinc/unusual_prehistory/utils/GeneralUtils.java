/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 */
package com.barlinc.unusual_prehistory.utils;

import com.mojang.datafixers.util.Pair;
import java.util.List;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class GeneralUtils {
    public static <T> T getRandomEntry(List<Pair<T, Integer>> rlList, RandomSource random) {
        int index;
        double totalWeight = 0.0;
        for (Pair<T, Integer> pair : rlList) {
            totalWeight += (double)((Integer)pair.getSecond()).intValue();
        }
        double randomWeightPicked = (double)random.m_188501_() * totalWeight;
        for (index = 0; index < rlList.size() - 1 && !((randomWeightPicked -= (double)((Integer)rlList.get(index).getSecond()).intValue()) <= 0.0); ++index) {
        }
        return (T)rlList.get(index).getFirst();
    }

    public static BlockState copyBlockProperties(BlockState oldBlockState, BlockState newBlockState) {
        for (Property property : oldBlockState.m_61147_()) {
            if (!newBlockState.m_61138_(property)) continue;
            newBlockState = GeneralUtils.getStateWithProperty(newBlockState, oldBlockState, property);
        }
        return newBlockState;
    }

    public static <T extends Comparable<T>> BlockState getStateWithProperty(BlockState state, BlockState stateToCopy, Property<T> property) {
        return (BlockState)state.m_61124_(property, stateToCopy.m_61143_(property));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.biome.Biome$Precipitation
 *  net.minecraft.world.level.block.LayeredCauldronBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks;

import com.barlinc.unusual_prehistory.registry.UP2CauldronInteractions;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class OozeCauldron
extends LayeredCauldronBlock {
    public static final Predicate<Biome.Precipitation> NONE = precipitation -> false;

    public OozeCauldron(BlockBehaviour.Properties properties) {
        super(properties, NONE, UP2CauldronInteractions.OOZE.map());
    }

    @NotNull
    public ItemStack m_7397_(@NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull BlockState state) {
        return new ItemStack((ItemLike)Items.f_42544_);
    }
}


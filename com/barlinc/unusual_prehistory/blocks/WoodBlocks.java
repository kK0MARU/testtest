/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.RotatedPillarBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraftforge.common.ToolAction
 *  net.minecraftforge.common.ToolActions
 */
package com.barlinc.unusual_prehistory.blocks;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class WoodBlocks
extends RotatedPillarBlock {
    public WoodBlocks(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        ItemStack itemStack = context.m_43722_();
        if (!itemStack.canPerformAction(toolAction)) {
            return null;
        }
        if (ToolActions.AXE_STRIP == toolAction) {
            if (this == UP2Blocks.DRYOPHYLLUM_LOG.get()) {
                return (BlockState)((Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_LOG.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)((Direction.Axis)state.m_61143_((Property)RotatedPillarBlock.f_55923_)));
            }
            if (this == UP2Blocks.DRYOPHYLLUM_WOOD.get()) {
                return (BlockState)((Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_WOOD.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)((Direction.Axis)state.m_61143_((Property)RotatedPillarBlock.f_55923_)));
            }
            if (this == UP2Blocks.GINKGO_LOG.get()) {
                return (BlockState)((Block)UP2Blocks.STRIPPED_GINKGO_LOG.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)((Direction.Axis)state.m_61143_((Property)RotatedPillarBlock.f_55923_)));
            }
            if (this == UP2Blocks.GINKGO_WOOD.get()) {
                return (BlockState)((Block)UP2Blocks.STRIPPED_GINKGO_WOOD.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)((Direction.Axis)state.m_61143_((Property)RotatedPillarBlock.f_55923_)));
            }
            if (this == UP2Blocks.LEPIDODENDRON_LOG.get() || this == UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get()) {
                return (BlockState)((Block)UP2Blocks.STRIPPED_LEPIDODENDRON_LOG.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)((Direction.Axis)state.m_61143_((Property)RotatedPillarBlock.f_55923_)));
            }
            if (this == UP2Blocks.LEPIDODENDRON_WOOD.get() || this == UP2Blocks.MOSSY_LEPIDODENDRON_WOOD.get()) {
                return (BlockState)((Block)UP2Blocks.STRIPPED_LEPIDODENDRON_WOOD.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)((Direction.Axis)state.m_61143_((Property)RotatedPillarBlock.f_55923_)));
            }
            if (this == UP2Blocks.METASEQUOIA_LOG.get()) {
                return (BlockState)((Block)UP2Blocks.STRIPPED_METASEQUOIA_LOG.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)((Direction.Axis)state.m_61143_((Property)RotatedPillarBlock.f_55923_)));
            }
            if (this == UP2Blocks.METASEQUOIA_WOOD.get()) {
                return (BlockState)((Block)UP2Blocks.STRIPPED_METASEQUOIA_WOOD.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)((Direction.Axis)state.m_61143_((Property)RotatedPillarBlock.f_55923_)));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}


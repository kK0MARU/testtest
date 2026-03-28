/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraftforge.items.IItemHandler
 *  net.minecraftforge.items.SlotItemHandler
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.screens;

import com.barlinc.unusual_prehistory.blocks.entity.TransmogrifierBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class TransmogrifierResultSlot
extends SlotItemHandler {
    public final TransmogrifierBlockEntity blockEntity;
    private final Player player;
    private int removeCount;

    public TransmogrifierResultSlot(TransmogrifierBlockEntity blockEntity, Player player, IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
        this.blockEntity = blockEntity;
        this.player = player;
    }

    public boolean m_5857_(@NotNull ItemStack itemStack) {
        return false;
    }

    @NotNull
    public ItemStack m_6201_(int amount) {
        if (this.m_6657_()) {
            this.removeCount += Math.min(amount, this.m_7993_().m_41613_());
        }
        return super.m_6201_(amount);
    }

    public void m_142406_(@NotNull Player player, @NotNull ItemStack stack) {
        this.m_5845_(stack);
        super.m_142406_(player, stack);
    }

    protected void m_7169_(@NotNull ItemStack stack, int amount) {
        this.removeCount += amount;
        this.m_5845_(stack);
    }

    protected void m_5845_(ItemStack stack) {
        stack.m_41678_(this.player.m_9236_(), this.player, this.removeCount);
        this.removeCount = 0;
    }
}


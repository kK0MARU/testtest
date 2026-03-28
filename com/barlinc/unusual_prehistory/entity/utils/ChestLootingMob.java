/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.Container
 *  net.minecraft.world.item.ItemStack
 */
package com.barlinc.unusual_prehistory.entity.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;

public interface ChestLootingMob {
    default public boolean isLootable(Container inventory) {
        for (int i = 0; i < inventory.m_6643_(); ++i) {
            if (!this.shouldLootItem(inventory.m_8020_(i))) continue;
            return true;
        }
        return false;
    }

    public boolean shouldLootItem(ItemStack var1);

    default public void afterLooting(BlockPos blockPos) {
    }

    default public void startOpeningChest() {
    }

    default public boolean openChest() {
        return true;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.Container
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.Slot
 *  net.minecraft.world.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.screens;

import com.barlinc.unusual_prehistory.entity.mob.future.Manipulator;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ManipulatorContainer
extends AbstractContainerMenu {
    private final Container manipulatorInventory;
    private final Manipulator manipulator;

    public ManipulatorContainer(int id, final Inventory playerInventory, Container manipulatorInventory, final Manipulator manipulator) {
        super(null, id);
        this.manipulatorInventory = manipulatorInventory;
        this.manipulator = manipulator;
        manipulatorInventory.m_5856_(playerInventory.f_35978_);
        this.m_38897_(new Slot(manipulatorInventory, 0, 8, 18){

            public boolean m_5857_(@NotNull ItemStack stack) {
                return !playerInventory.f_35978_.m_9236_().f_46443_;
            }

            public int m_6641_() {
                return 1;
            }

            public void m_5852_(@NotNull ItemStack stack) {
                super.m_5852_(stack);
                manipulator.m_8061_(EquipmentSlot.MAINHAND, stack);
            }

            public boolean m_8010_(@NotNull Player player) {
                return !playerInventory.f_35978_.m_9236_().f_46443_;
            }
        });
        this.m_38897_(new Slot(manipulatorInventory, 1, 8, 36){

            public boolean m_5857_(@NotNull ItemStack stack) {
                return !playerInventory.f_35978_.m_9236_().f_46443_;
            }

            public int m_6641_() {
                return 1;
            }

            public void m_5852_(@NotNull ItemStack stack) {
                super.m_5852_(stack);
                manipulator.m_8061_(EquipmentSlot.OFFHAND, stack);
            }

            public boolean m_8010_(@NotNull Player player) {
                return !playerInventory.f_35978_.m_9236_().f_46443_;
            }
        });
        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.m_38897_(new Slot((Container)playerInventory, j1 + (l + 1) * 9, 8 + j1 * 18, 84 + l * 18));
            }
        }
        for (int i1 = 0; i1 < 9; ++i1) {
            this.m_38897_(new Slot((Container)playerInventory, i1, 8 + i1 * 18, 142));
        }
    }

    public boolean m_6875_(@NotNull Player player) {
        return this.manipulatorInventory.m_6542_(player) && this.manipulator.m_6084_() && this.manipulator.m_20270_((Entity)player) < 8.0f;
    }

    @NotNull
    public ItemStack m_7648_(@NotNull Player player, int index) {
        ItemStack itemstack = ItemStack.f_41583_;
        Slot slot = (Slot)this.f_38839_.get(index);
        if (slot != null && slot.m_6657_()) {
            ItemStack itemstack1 = slot.m_7993_();
            itemstack = itemstack1.m_41777_();
            int i = this.manipulatorInventory.m_6643_();
            if (index < i) {
                if (!this.m_38903_(itemstack1, i, this.f_38839_.size(), true)) {
                    return ItemStack.f_41583_;
                }
            } else if (this.m_38853_(1).m_5857_(itemstack1) && !this.m_38853_(1).m_6657_()) {
                if (!this.m_38903_(itemstack1, 1, 2, false)) {
                    return ItemStack.f_41583_;
                }
            } else if (this.m_38853_(0).m_5857_(itemstack1)) {
                if (!this.m_38903_(itemstack1, 0, 1, false)) {
                    return ItemStack.f_41583_;
                }
            } else if (i <= 2 || !this.m_38903_(itemstack1, 2, i, false)) {
                int j = i + 27;
                int k = j + 9;
                if (index >= j && index < k ? !this.m_38903_(itemstack1, i, j, false) : (index >= i && index < j ? !this.m_38903_(itemstack1, j, k, false) : !this.m_38903_(itemstack1, j, j, false))) {
                    return ItemStack.f_41583_;
                }
                return ItemStack.f_41583_;
            }
            if (itemstack1.m_41619_()) {
                slot.m_269060_(ItemStack.f_41583_);
            } else {
                slot.m_6654_();
            }
        }
        return itemstack;
    }

    public void m_6877_(@NotNull Player player) {
        super.m_6877_(player);
        this.manipulatorInventory.m_5785_(player);
        this.manipulator.interacting = false;
    }
}


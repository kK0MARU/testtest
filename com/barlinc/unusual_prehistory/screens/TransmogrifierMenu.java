/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.util.Mth
 *  net.minecraft.world.Container
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.ContainerData
 *  net.minecraft.world.inventory.ContainerLevelAccess
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraft.world.inventory.SimpleContainerData
 *  net.minecraft.world.inventory.Slot
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraftforge.common.capabilities.ForgeCapabilities
 *  net.minecraftforge.items.IItemHandler
 *  net.minecraftforge.items.SlotItemHandler
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.screens;

import com.barlinc.unusual_prehistory.blocks.entity.TransmogrifierBlockEntity;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2MenuTypes;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.screens.TransmogrifierResultSlot;
import java.util.Objects;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class TransmogrifierMenu
extends AbstractContainerMenu {
    private final TransmogrifierBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;
    private static final int SLOT_COUNT = 36;
    private static final int FIRST_SLOT_INDEX = 0;
    private static final int CULTIVATOR_SLOT_INDEX = 36;
    private static final int CULTIVATOR_SLOT_COUNT = 3;

    public TransmogrifierMenu(int containerId, Inventory inventory, FriendlyByteBuf data) {
        this(containerId, inventory, TransmogrifierMenu.getBlockEntity(inventory, data), (ContainerData)new SimpleContainerData(5));
    }

    public TransmogrifierMenu(int containerId, Inventory inventory, TransmogrifierBlockEntity blockEntity, ContainerData data) {
        super((MenuType)UP2MenuTypes.TRANSMOGRIFIER.get(), containerId);
        TransmogrifierMenu.m_38869_((Container)inventory, (int)3);
        this.blockEntity = blockEntity;
        this.level = inventory.f_35978_.m_9236_();
        this.data = data;
        this.addPlayerInventory(inventory);
        this.addPlayerHotbar(inventory);
        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.m_38897_((Slot)new OozeSlot((IItemHandler)handler, 1, 82, 59));
            this.m_38897_((Slot)new SlotItemHandler(handler, 0, 37, 31));
            this.m_38897_((Slot)new TransmogrifierResultSlot(blockEntity, inventory.f_35978_, (IItemHandler)handler, 2, 125, 31));
        });
        this.m_38884_(data);
    }

    private static TransmogrifierBlockEntity getBlockEntity(Inventory inventory, FriendlyByteBuf data) {
        Objects.requireNonNull(inventory, "inventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        BlockEntity blockEntity = inventory.f_35978_.m_9236_().m_7702_(data.m_130135_());
        if (blockEntity instanceof TransmogrifierBlockEntity) {
            return (TransmogrifierBlockEntity)blockEntity;
        }
        throw new IllegalStateException("Block entity is not correct! " + blockEntity);
    }

    public boolean isCrafting() {
        return this.data.m_6413_(0) > 0;
    }

    public int getScaledProgress(int scale) {
        int progress = this.data.m_6413_(0);
        int maxProgress = this.data.m_6413_(1);
        if (progress == 0 || maxProgress == 0) {
            return 0;
        }
        return Mth.m_14167_((float)((float)scale * (float)progress / (float)maxProgress));
    }

    public int getScaledFuel(int scale) {
        int fuel = this.data.m_6413_(2);
        int maxFuel = this.data.m_6413_(3);
        if (fuel == 0 || maxFuel == 0) {
            return 0;
        }
        return Mth.m_14167_((float)((float)scale * (float)fuel / (float)maxFuel));
    }

    @NotNull
    public ItemStack m_7648_(@NotNull Player player, int index) {
        Slot sourceSlot = (Slot)this.f_38839_.get(index);
        if (sourceSlot == null || !sourceSlot.m_6657_()) {
            return ItemStack.f_41583_;
        }
        ItemStack sourceStack = sourceSlot.m_7993_();
        ItemStack copyOfSourceStack = sourceStack.m_41777_();
        if (index < 36) {
            if (!this.m_38903_(sourceStack, 36, 39, false)) {
                return ItemStack.f_41583_;
            }
        } else if (index < 39) {
            if (!this.m_38903_(sourceStack, 0, 36, false)) {
                return ItemStack.f_41583_;
            }
        } else {
            return ItemStack.f_41583_;
        }
        if (sourceStack.m_41613_() == 0) {
            sourceSlot.m_5852_(ItemStack.f_41583_);
        } else {
            sourceSlot.m_6654_();
        }
        sourceSlot.m_142406_(player, sourceStack);
        return copyOfSourceStack;
    }

    public boolean m_6875_(@NotNull Player player) {
        return TransmogrifierMenu.m_38889_((ContainerLevelAccess)ContainerLevelAccess.m_39289_((Level)this.level, (BlockPos)this.blockEntity.m_58899_()), (Player)player, (Block)((Block)UP2Blocks.TRANSMOGRIFIER.get()));
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.m_38897_(new Slot((Container)playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.m_38897_(new Slot((Container)playerInventory, i, 8 + i * 18, 142));
        }
    }

    private static class OozeSlot
    extends SlotItemHandler {
        public OozeSlot(IItemHandler itemHandler, int index, int x, int y) {
            super(itemHandler, index, x, y);
        }

        public boolean m_5857_(@NotNull ItemStack itemStack) {
            return super.m_5857_(itemStack) && itemStack.m_204117_(UP2ItemTags.TRANSMOGRIFIER_FUEL);
        }
    }
}


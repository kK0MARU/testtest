/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
 *  net.minecraft.client.gui.screens.inventory.InventoryScreen
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.screens;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.mob.future.Manipulator;
import com.barlinc.unusual_prehistory.screens.ManipulatorContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.NotNull;

public class ManipulatorInventoryScreen
extends AbstractContainerScreen<ManipulatorContainer> {
    private static final ResourceLocation GUI_TEXTURE = UnusualPrehistory2.modPrefix("textures/gui/manipulator_inventory.png");
    private final Manipulator manipulator;
    private float mousePosX;
    private float mousePosY;

    public ManipulatorInventoryScreen(ManipulatorContainer container, Inventory playerInventory, Manipulator manipulator) {
        super((AbstractContainerMenu)container, playerInventory, manipulator.m_5446_());
        this.manipulator = manipulator;
    }

    protected void m_7286_(GuiGraphics graphics, float partialTicks, int x, int y) {
        int i = (this.f_96543_ - this.f_97726_) / 2;
        int j = (this.f_96544_ - this.f_97727_) / 2;
        graphics.m_280218_(GUI_TEXTURE, i, j, 0, 0, this.f_97726_, this.f_97727_);
        InventoryScreen.m_274545_((GuiGraphics)graphics, (int)(i + 62), (int)(j + 60), (int)12, (float)((float)(i + 51) - this.mousePosX), (float)((float)(j + 75 - 50) - this.mousePosY), (LivingEntity)this.manipulator);
    }

    public void m_88315_(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        this.m_280273_(graphics);
        this.mousePosX = mouseX;
        this.mousePosY = mouseY;
        super.m_88315_(graphics, mouseX, mouseY, partialTicks);
        this.m_280072_(graphics, mouseX, mouseY);
    }
}


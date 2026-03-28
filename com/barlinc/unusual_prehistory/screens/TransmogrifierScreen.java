/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.Lighting
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
 *  net.minecraft.client.renderer.GameRenderer
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.FormattedText
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.screens;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.screens.TransmogrifierMenu;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
public class TransmogrifierScreen
extends AbstractContainerScreen<TransmogrifierMenu> {
    private static final ResourceLocation TEXTURE = UnusualPrehistory2.modPrefix("textures/gui/transmogrifier.png");
    private static final int SCREEN_WIDTH = 176;
    private static final int SCREEN_HEIGHT = 166;
    private static final int PROGRESS_X = 62;
    private static final int PROGRESS_Y = 29;
    public static final int PROGRESS_WIDTH = 54;
    public static final int PROGRESS_HEIGHT = 20;
    private static final int FUEL_X = 102;
    private static final int FUEL_Y = 60;
    public static final int FUEL_WIDTH = 44;
    public static final int FUEL_HEIGHT = 14;

    public TransmogrifierScreen(TransmogrifierMenu menu, Inventory playerInventory, Component title) {
        super((AbstractContainerMenu)menu, playerInventory, title);
        this.f_97726_ = 176;
        this.f_97727_ = 166;
    }

    protected void m_7856_() {
        super.m_7856_();
        this.f_97728_ = (this.f_97726_ - this.f_96547_.m_92852_((FormattedText)this.f_96539_)) / 2;
    }

    protected void m_7286_(@NotNull GuiGraphics graphics, float partialTicks, int mouseX, int mouseY) {
        int width;
        this.m_280273_(graphics);
        Lighting.m_84930_();
        RenderSystem.setShader(GameRenderer::m_172817_);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderTexture((int)0, (ResourceLocation)TEXTURE);
        graphics.m_280218_(TEXTURE, this.f_97735_, this.f_97736_, 0, 0, 176, 166);
        if (((TransmogrifierMenu)this.f_97732_).isCrafting()) {
            width = ((TransmogrifierMenu)this.f_97732_).getScaledProgress(54);
            graphics.m_280218_(TEXTURE, this.f_97735_ + 62, this.f_97736_ + 29, 176, 14, width, 20);
        }
        width = ((TransmogrifierMenu)this.f_97732_).getScaledFuel(44);
        graphics.m_280218_(TEXTURE, this.f_97735_ + 102, this.f_97736_ + 60, 176, 0, width, 14);
    }

    public void m_88315_(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        this.m_280273_(graphics);
        super.m_88315_(graphics, mouseX, mouseY, partialTicks);
        this.m_280072_(graphics, mouseX, mouseY);
    }
}


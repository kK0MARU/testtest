/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mezz.jei.api.constants.VanillaTypes
 *  mezz.jei.api.gui.builder.IRecipeLayoutBuilder
 *  mezz.jei.api.gui.drawable.IDrawable
 *  mezz.jei.api.gui.drawable.IDrawableAnimated
 *  mezz.jei.api.gui.drawable.IDrawableAnimated$StartDirection
 *  mezz.jei.api.gui.ingredient.IRecipeSlotsView
 *  mezz.jei.api.helpers.IGuiHelper
 *  mezz.jei.api.ingredients.IIngredientType
 *  mezz.jei.api.recipe.IFocusGroup
 *  mezz.jei.api.recipe.RecipeIngredientRole
 *  mezz.jei.api.recipe.RecipeType
 *  mezz.jei.api.recipe.category.IRecipeCategory
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Font
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.FormattedText
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.integration.jei;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.integration.jei.JEIPlugin;
import com.barlinc.unusual_prehistory.recipes.TransmogrificationRecipe;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public class TransmogrificationCategory
implements IRecipeCategory<TransmogrificationRecipe> {
    public static final ResourceLocation UID = UnusualPrehistory2.modPrefix("transmogrification");
    public static final ResourceLocation BACKGROUND = UnusualPrehistory2.modPrefix("textures/gui/transmogrifier.png");
    private final IDrawable background;
    private final IDrawable icon;
    protected final IDrawableAnimated fuel;
    protected final IDrawableAnimated progress;

    public TransmogrificationCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(BACKGROUND, 32, 28, 116, 52);
        this.icon = guiHelper.createDrawableIngredient((IIngredientType)VanillaTypes.ITEM_STACK, (Object)new ItemStack((ItemLike)UP2Blocks.TRANSMOGRIFIER.get()));
        this.fuel = guiHelper.drawableBuilder(BACKGROUND, 176, 0, 44, 14).buildAnimated(800, IDrawableAnimated.StartDirection.RIGHT, true);
        this.progress = guiHelper.drawableBuilder(BACKGROUND, 176, 14, 54, 20).buildAnimated(1200, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @NotNull
    public RecipeType<TransmogrificationRecipe> getRecipeType() {
        return JEIPlugin.TRANSMOGRIFICATION;
    }

    @NotNull
    public Component getTitle() {
        return Component.m_237115_((String)"unusual_prehistory.jei.transmogrification");
    }

    public IDrawable getBackground() {
        return this.background;
    }

    public IDrawable getIcon() {
        return this.icon;
    }

    protected void drawProgress(TransmogrificationRecipe recipe, GuiGraphics guiGraphics, int y, int x) {
        int cookTime = recipe.getProcessingTime();
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            MutableComponent timeString = Component.m_237110_((String)"gui.jei.category.smelting.time.seconds", (Object[])new Object[]{cookTimeSeconds});
            Minecraft minecraft = Minecraft.m_91087_();
            Font fontRenderer = minecraft.f_91062_;
            int stringWidth = fontRenderer.m_92852_((FormattedText)timeString);
            guiGraphics.m_280614_(fontRenderer, (Component)timeString, this.getWidth() - stringWidth + x, y, -8355712, false);
        }
    }

    public void draw(@NotNull TransmogrificationRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics guiGraphics, double mouseX, double mouseY) {
        super.draw((Object)recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        this.drawProgress(recipe, guiGraphics, 24, -91);
        this.fuel.draw(guiGraphics, 70, 32);
        this.progress.draw(guiGraphics, 30, 1);
    }

    public void setRecipe(IRecipeLayoutBuilder builder, TransmogrificationRecipe recipe, @NotNull IFocusGroup foci) {
        builder.addSlot(RecipeIngredientRole.INPUT, 5, 3).addIngredients((Ingredient)recipe.m_7527_().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 50, 31).addItemStack(new ItemStack((ItemLike)UP2Items.ORGANIC_OOZE.get()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 93, 3).addItemStack(recipe.getJEIResultItem());
    }
}


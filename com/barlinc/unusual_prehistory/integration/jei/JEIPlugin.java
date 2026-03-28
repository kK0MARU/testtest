/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mezz.jei.api.IModPlugin
 *  mezz.jei.api.JeiPlugin
 *  mezz.jei.api.recipe.RecipeType
 *  mezz.jei.api.recipe.category.IRecipeCategory
 *  mezz.jei.api.registration.IGuiHandlerRegistration
 *  mezz.jei.api.registration.IRecipeCatalystRegistration
 *  mezz.jei.api.registration.IRecipeCategoryRegistration
 *  mezz.jei.api.registration.IRecipeRegistration
 *  net.minecraft.client.Minecraft
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.RecipeManager
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.minecraft.world.level.ItemLike
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.integration.jei;

import com.barlinc.unusual_prehistory.integration.jei.TransmogrificationCategory;
import com.barlinc.unusual_prehistory.recipes.TransmogrificationRecipe;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Recipes;
import com.barlinc.unusual_prehistory.screens.TransmogrifierScreen;
import java.util.List;
import java.util.Objects;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(value=Dist.CLIENT)
@JeiPlugin
public class JEIPlugin
implements IModPlugin {
    public static RecipeType<TransmogrificationRecipe> TRANSMOGRIFICATION = new RecipeType(TransmogrificationCategory.UID, TransmogrificationRecipe.class);

    @NotNull
    public ResourceLocation getPluginUid() {
        return new ResourceLocation("unusual_prehistory", "jei_plugin");
    }

    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new IRecipeCategory[]{new TransmogrificationCategory(registration.getJeiHelpers().getGuiHelper())});
    }

    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.m_91087_().f_91073_).m_7465_();
        List transmogrificationRecipes = recipeManager.m_44013_((net.minecraft.world.item.crafting.RecipeType)UP2Recipes.TRANSMOGRIFICATION.get());
        registration.addRecipes(TRANSMOGRIFICATION, transmogrificationRecipes);
    }

    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack((ItemLike)UP2Blocks.TRANSMOGRIFIER.get()), new RecipeType[]{TRANSMOGRIFICATION});
    }

    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(TransmogrifierScreen.class, 62, 29, 54, 20, new RecipeType[]{TRANSMOGRIFICATION});
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.minecraft.core.NonNullList
 *  net.minecraft.core.RegistryAccess
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.GsonHelper
 *  net.minecraft.world.Container
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.item.crafting.Recipe
 *  net.minecraft.world.item.crafting.RecipeSerializer
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.minecraft.world.item.crafting.ShapedRecipe
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.recipes;

import com.barlinc.unusual_prehistory.registry.UP2Recipes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TransmogrificationRecipe
implements Recipe<Container> {
    protected final ResourceLocation id;
    protected final Ingredient input;
    protected final ItemStack output;
    protected final int processingTime;
    private final NonNullList<Ingredient> recipeItems = NonNullList.m_122779_();

    public TransmogrificationRecipe(ResourceLocation id, Ingredient input, ItemStack output, int processingTime) {
        this.id = id;
        this.input = input;
        this.output = output;
        this.processingTime = processingTime;
        this.recipeItems.add((Object)input);
    }

    public boolean m_5818_(Container container, @NotNull Level level) {
        return this.input.test(!container.m_8020_(0).m_41619_() ? container.m_8020_(0) : ItemStack.f_41583_);
    }

    @NotNull
    public ItemStack m_5874_(@NotNull Container container, @NotNull RegistryAccess registryAccess) {
        return this.output.m_41777_();
    }

    public boolean m_8004_(int i, int i1) {
        return true;
    }

    @NotNull
    public NonNullList<Ingredient> m_7527_() {
        return this.recipeItems;
    }

    public int getProcessingTime() {
        return this.processingTime;
    }

    @NotNull
    public ItemStack m_8043_(@NotNull RegistryAccess registryAccess) {
        return this.output;
    }

    public ItemStack getJEIResultItem() {
        return this.output;
    }

    @NotNull
    public ResourceLocation m_6423_() {
        return this.id;
    }

    @NotNull
    public RecipeSerializer<?> m_7707_() {
        return (RecipeSerializer)UP2Recipes.TRANSMOGRIFICATION_SERIALIZER.get();
    }

    @NotNull
    public RecipeType<?> m_6671_() {
        return (RecipeType)UP2Recipes.TRANSMOGRIFICATION.get();
    }

    public static class Serializer
    implements RecipeSerializer<TransmogrificationRecipe> {
        @NotNull
        public TransmogrificationRecipe fromJson(@NotNull ResourceLocation resourceLocation, @NotNull JsonObject jsonObject) {
            Ingredient input = Ingredient.m_43917_((JsonElement)GsonHelper.m_13930_((JsonObject)jsonObject, (String)"input"));
            ItemStack output = ShapedRecipe.m_151274_((JsonObject)GsonHelper.m_13930_((JsonObject)jsonObject, (String)"output"));
            int processingTime = GsonHelper.m_13824_((JsonObject)jsonObject, (String)"processing_time", (int)3600);
            return new TransmogrificationRecipe(resourceLocation, input, output, processingTime);
        }

        @Nullable
        public TransmogrificationRecipe fromNetwork(@NotNull ResourceLocation resourceLocation, @NotNull FriendlyByteBuf buf) {
            Ingredient input = Ingredient.m_43940_((FriendlyByteBuf)buf);
            ItemStack result = buf.m_130267_();
            int processingTime = buf.m_130242_();
            return new TransmogrificationRecipe(resourceLocation, input, result, processingTime);
        }

        public void toNetwork(@NotNull FriendlyByteBuf buf, TransmogrificationRecipe recipe) {
            recipe.input.m_43923_(buf);
            buf.m_130055_(recipe.output);
            buf.m_130130_(recipe.processingTime);
        }
    }
}


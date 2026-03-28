/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.data.recipes.FinishedRecipe
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.item.crafting.RecipeSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.data;

import com.barlinc.unusual_prehistory.registry.UP2Recipes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.function.Consumer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TransmogrificationBuilder {
    private final Ingredient input;
    private final RecipeSerializer<?> type;
    private final Item output;
    private final int processingTime;

    public TransmogrificationBuilder(RecipeSerializer<?> type, Ingredient input, Item output, int processingTime) {
        this.type = type;
        this.input = input;
        this.output = output;
        this.processingTime = processingTime;
    }

    public static TransmogrificationBuilder transmogrification(Ingredient dna, Item output, int processingTime) {
        return new TransmogrificationBuilder((RecipeSerializer)UP2Recipes.TRANSMOGRIFICATION_SERIALIZER.get(), dna, output, processingTime);
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        consumer.accept(new Result(resourceLocation, this.type, this.input, this.output, this.processingTime));
    }

    public record Result(ResourceLocation resourceLocation, RecipeSerializer<?> type, Ingredient input, Item output, int processingTime) implements FinishedRecipe
    {
        public void m_7917_(JsonObject jsonObject) {
            jsonObject.add("input", this.input.m_43942_());
            jsonObject.addProperty("processing_time", (Number)this.processingTime);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", BuiltInRegistries.f_257033_.m_7981_((Object)this.output).toString());
            jsonObject.add("output", (JsonElement)jsonobject);
        }

        @NotNull
        public ResourceLocation m_6445_() {
            return this.resourceLocation;
        }

        @NotNull
        public RecipeSerializer<?> m_6637_() {
            return this.type;
        }

        @Nullable
        public JsonObject m_5860_() {
            return null;
        }

        @Nullable
        public ResourceLocation m_6448_() {
            return null;
        }
    }
}


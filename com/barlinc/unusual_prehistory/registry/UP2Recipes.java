/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.crafting.Recipe
 *  net.minecraft.world.item.crafting.RecipeSerializer
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.recipes.TransmogrificationRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class UP2Recipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create((IForgeRegistry)ForgeRegistries.RECIPE_TYPES, (String)"unusual_prehistory");
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create((IForgeRegistry)ForgeRegistries.RECIPE_SERIALIZERS, (String)"unusual_prehistory");
    public static final RegistryObject<RecipeType<TransmogrificationRecipe>> TRANSMOGRIFICATION = RECIPE_TYPES.register("transmogrification", () -> new SimpleNamedRecipeType("transmogrification"));
    public static final RegistryObject<RecipeSerializer<TransmogrificationRecipe>> TRANSMOGRIFICATION_SERIALIZER = RECIPE_SERIALIZERS.register("transmogrification", TransmogrificationRecipe.Serializer::new);

    public record SimpleNamedRecipeType<T extends Recipe<?>>(String name) implements RecipeType<T>
    {
        @NotNull
        public String toString() {
            return this.name;
        }
    }
}


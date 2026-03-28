/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.advancements.CriterionTriggerInstance
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.recipes.FinishedRecipe
 *  net.minecraft.data.recipes.RecipeBuilder
 *  net.minecraft.data.recipes.RecipeCategory
 *  net.minecraft.data.recipes.RecipeProvider
 *  net.minecraft.data.recipes.ShapedRecipeBuilder
 *  net.minecraft.data.recipes.ShapelessRecipeBuilder
 *  net.minecraft.data.recipes.SingleItemRecipeBuilder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraftforge.common.Tags$Items
 *  net.minecraftforge.common.crafting.ConditionalRecipe
 *  net.minecraftforge.common.crafting.conditions.ICondition
 *  net.minecraftforge.common.crafting.conditions.IConditionBuilder
 *  net.minecraftforge.registries.ForgeRegistries
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.data.TransmogrificationBuilder;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class UP2RecipeProvider
extends RecipeProvider
implements IConditionBuilder {
    public UP2RecipeProvider(PackOutput output) {
        super(output);
    }

    protected void m_245200_(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.m_245327_((RecipeCategory)RecipeCategory.MISC, (ItemLike)((ItemLike)UP2Blocks.TRANSMOGRIFIER.get())).m_206416_(Character.valueOf('#'), Tags.Items.INGOTS_GOLD).m_126127_(Character.valueOf('X'), (ItemLike)UP2Items.MACHINE_PARTS.get()).m_206416_(Character.valueOf('Y'), Tags.Items.DUSTS_REDSTONE).m_206416_(Character.valueOf('Z'), Tags.Items.INGOTS_COPPER).m_126130_("###").m_126130_("ZXZ").m_126130_("#Y#").m_126132_("has_machine_parts", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Items.MACHINE_PARTS.get()))).m_176498_(consumer);
        ShapelessRecipeBuilder.m_246517_((RecipeCategory)RecipeCategory.MISC, (ItemLike)((ItemLike)UP2Items.ORGANIC_OOZE.get()), (int)2).m_206419_(Tags.Items.SLIMEBALLS).m_126209_((ItemLike)Items.f_42583_).m_126209_((ItemLike)Items.f_42501_).m_206419_(Tags.Items.MUSHROOMS).m_126132_("has_slime", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)Items.f_42518_)).m_176498_(consumer);
        ShapelessRecipeBuilder.m_246517_((RecipeCategory)RecipeCategory.MISC, (ItemLike)((ItemLike)UP2Items.DIRT_ON_A_STICK.get()), (int)1).m_206419_(Tags.Items.TOOLS_FISHING_RODS).m_126209_((ItemLike)Blocks.f_50493_.m_5456_()).m_126132_("has_fishing_rod", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.TOOLS_FISHING_RODS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.PALEOSTONE_STAIRS.get()), (int)4).m_126127_(Character.valueOf('G'), (ItemLike)UP2Blocks.PALEOSTONE.get()).m_126130_("G  ").m_126130_("GG ").m_126130_("GGG").m_126132_("has_greynite", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.PALEOSTONE.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.PALEOSTONE_SLAB.get()), (int)6).m_126127_(Character.valueOf('G'), (ItemLike)UP2Blocks.PALEOSTONE.get()).m_126130_("GGG").m_126132_("has_greynite", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.PALEOSTONE.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.MESONITE_STAIRS.get()), (int)4).m_126127_(Character.valueOf('R'), (ItemLike)UP2Blocks.MESONITE.get()).m_126130_("R  ").m_126130_("RR ").m_126130_("RRR").m_126132_("has_ranatite", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.MESONITE.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.MESONITE_SLAB.get()), (int)6).m_126127_(Character.valueOf('R'), (ItemLike)UP2Blocks.MESONITE.get()).m_126130_("RRR").m_126132_("has_ranatite", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.MESONITE.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.FLORALITE_STAIRS.get()), (int)4).m_126127_(Character.valueOf('V'), (ItemLike)UP2Blocks.FLORALITE.get()).m_126130_("V  ").m_126130_("VV ").m_126130_("VVV").m_126132_("has_vistostone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FLORALITE.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.FLORALITE_SLAB.get()), (int)6).m_126127_(Character.valueOf('V'), (ItemLike)UP2Blocks.FLORALITE.get()).m_126130_("VVV").m_126132_("has_vistostone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FLORALITE.get()))).m_176498_(consumer);
        ShapelessRecipeBuilder.m_246517_((RecipeCategory)RecipeCategory.MISC, (ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_SKULL_LANTERN.get()), (int)1).m_126209_((ItemLike)UP2Blocks.FOSSILIZED_SKULL.get()).m_126209_((ItemLike)Items.f_42000_).m_126132_("has_fossilized_skull", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_SKULL.get()))).m_176498_(consumer);
        ShapelessRecipeBuilder.m_246517_((RecipeCategory)RecipeCategory.MISC, (ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_SKULL_SOUL_LANTERN.get()), (int)1).m_126209_((ItemLike)UP2Blocks.FOSSILIZED_SKULL.get()).m_126209_((ItemLike)Items.f_42053_).m_126132_("has_fossilized_skull", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_SKULL.get()))).m_176498_(consumer);
        UP2RecipeProvider.woodSet(UP2ItemTags.DRYOPHYLLUM_LOGS, (Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get(), (Block)UP2Blocks.DRYOPHYLLUM_SLAB.get(), (Block)UP2Blocks.DRYOPHYLLUM_STAIRS.get(), (Block)UP2Blocks.DRYOPHYLLUM_LOG.get(), (Block)UP2Blocks.DRYOPHYLLUM_WOOD.get(), (Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_LOG.get(), (Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_WOOD.get(), (ItemLike)UP2Items.DRYOPHYLLUM_BOAT.get(), (ItemLike)UP2Items.DRYOPHYLLUM_CHEST_BOAT.get(), (Block)UP2Blocks.DRYOPHYLLUM_BUTTON.get(), (Block)UP2Blocks.DRYOPHYLLUM_DOOR.get(), (Block)UP2Blocks.DRYOPHYLLUM_TRAPDOOR.get(), (Block)UP2Blocks.DRYOPHYLLUM_FENCE.get(), (Block)UP2Blocks.DRYOPHYLLUM_FENCE_GATE.get(), (Block)UP2Blocks.DRYOPHYLLUM_PRESSURE_PLATE.get(), (Block)UP2Blocks.DRYOPHYLLUM_SIGN.get(), (Block)UP2Blocks.DRYOPHYLLUM_HANGING_SIGN.get(), consumer);
        UP2RecipeProvider.woodSet(UP2ItemTags.GINKGO_LOGS, (Block)UP2Blocks.GINKGO_PLANKS.get(), (Block)UP2Blocks.GINKGO_SLAB.get(), (Block)UP2Blocks.GINKGO_STAIRS.get(), (Block)UP2Blocks.GINKGO_LOG.get(), (Block)UP2Blocks.GINKGO_WOOD.get(), (Block)UP2Blocks.STRIPPED_GINKGO_LOG.get(), (Block)UP2Blocks.STRIPPED_GINKGO_WOOD.get(), (ItemLike)UP2Items.GINKGO_BOAT.get(), (ItemLike)UP2Items.GINKGO_CHEST_BOAT.get(), (Block)UP2Blocks.GINKGO_BUTTON.get(), (Block)UP2Blocks.GINKGO_DOOR.get(), (Block)UP2Blocks.GINKGO_TRAPDOOR.get(), (Block)UP2Blocks.GINKGO_FENCE.get(), (Block)UP2Blocks.GINKGO_FENCE_GATE.get(), (Block)UP2Blocks.GINKGO_PRESSURE_PLATE.get(), (Block)UP2Blocks.GINKGO_SIGN.get(), (Block)UP2Blocks.GINKGO_HANGING_SIGN.get(), consumer);
        UP2RecipeProvider.woodSet(UP2ItemTags.LEPIDODENDRON_LOGS, (Block)UP2Blocks.LEPIDODENDRON_PLANKS.get(), (Block)UP2Blocks.LEPIDODENDRON_SLAB.get(), (Block)UP2Blocks.LEPIDODENDRON_STAIRS.get(), (Block)UP2Blocks.LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.LEPIDODENDRON_WOOD.get(), (Block)UP2Blocks.STRIPPED_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.STRIPPED_LEPIDODENDRON_WOOD.get(), (ItemLike)UP2Items.LEPIDODENDRON_BOAT.get(), (ItemLike)UP2Items.LEPIDODENDRON_CHEST_BOAT.get(), (Block)UP2Blocks.LEPIDODENDRON_BUTTON.get(), (Block)UP2Blocks.LEPIDODENDRON_DOOR.get(), (Block)UP2Blocks.LEPIDODENDRON_TRAPDOOR.get(), (Block)UP2Blocks.LEPIDODENDRON_FENCE.get(), (Block)UP2Blocks.LEPIDODENDRON_FENCE_GATE.get(), (Block)UP2Blocks.LEPIDODENDRON_PRESSURE_PLATE.get(), (Block)UP2Blocks.LEPIDODENDRON_SIGN.get(), (Block)UP2Blocks.LEPIDODENDRON_HANGING_SIGN.get(), consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.MOSSY_LEPIDODENDRON_WOOD.get()), (int)3).m_126127_(Character.valueOf('L'), (ItemLike)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get()).m_126130_("LL").m_126130_("LL").m_126145_("bark").m_126132_("has_log", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.LEPIDODENDRON_LOG.get()))).m_176498_(consumer);
        UP2RecipeProvider.woodSet(UP2ItemTags.METASEQUOIA_LOGS, (Block)UP2Blocks.METASEQUOIA_PLANKS.get(), (Block)UP2Blocks.METASEQUOIA_SLAB.get(), (Block)UP2Blocks.METASEQUOIA_STAIRS.get(), (Block)UP2Blocks.METASEQUOIA_LOG.get(), (Block)UP2Blocks.METASEQUOIA_WOOD.get(), (Block)UP2Blocks.STRIPPED_METASEQUOIA_LOG.get(), (Block)UP2Blocks.STRIPPED_METASEQUOIA_WOOD.get(), (ItemLike)UP2Items.METASEQUOIA_BOAT.get(), (ItemLike)UP2Items.METASEQUOIA_CHEST_BOAT.get(), (Block)UP2Blocks.METASEQUOIA_BUTTON.get(), (Block)UP2Blocks.METASEQUOIA_DOOR.get(), (Block)UP2Blocks.METASEQUOIA_TRAPDOOR.get(), (Block)UP2Blocks.METASEQUOIA_FENCE.get(), (Block)UP2Blocks.METASEQUOIA_FENCE_GATE.get(), (Block)UP2Blocks.METASEQUOIA_PRESSURE_PLATE.get(), (Block)UP2Blocks.METASEQUOIA_SIGN.get(), (Block)UP2Blocks.METASEQUOIA_HANGING_SIGN.get(), consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.PETRIFIED_WOOD.get()), (int)3).m_126127_(Character.valueOf('P'), (ItemLike)UP2Blocks.PETRIFIED_LOG.get()).m_126130_("PP").m_126130_("PP").m_126145_("bark").m_126132_("has_log", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.PETRIFIED_LOG.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD.get()), (int)4).m_126127_(Character.valueOf('P'), (ItemLike)UP2Blocks.PETRIFIED_WOOD.get()).m_126130_("PP").m_126130_("PP").m_126132_("has_log", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.PETRIFIED_LOG.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD_STAIRS.get()), (int)4).m_126127_(Character.valueOf('P'), (ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD.get()).m_126130_("P  ").m_126130_("PP ").m_126130_("PPP").m_126132_("has_log", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.PETRIFIED_LOG.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD_SLAB.get()), (int)6).m_126127_(Character.valueOf('P'), (ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD.get()).m_126130_("PPP").m_126132_("has_log", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.PETRIFIED_LOG.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_245327_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD_PRESSURE_PLATE.get())).m_126127_(Character.valueOf('P'), (ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD.get()).m_126130_("PP").m_126132_("has_log", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.PETRIFIED_LOG.get()))).m_176498_(consumer);
        ShapelessRecipeBuilder.m_246517_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD_BUTTON.get()), (int)1).m_126209_((ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD.get()).m_126132_("has_log", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.PETRIFIED_LOG.get()))).m_176498_(consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.PETRIFIED_LOG.get(), (ItemLike)UP2Blocks.PETRIFIED_WOOD.get(), 1, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.PETRIFIED_LOG.get(), (ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD.get(), 1, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD.get(), (ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD_STAIRS.get(), 1, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.PETRIFIED_LOG.get(), (ItemLike)UP2Blocks.POLISHED_PETRIFIED_WOOD_SLAB.get(), 2, consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BARK.get()), (int)3).m_126127_(Character.valueOf('F'), (ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()).m_126130_("FF").m_126130_("FF").m_126132_("has_fossilized_bone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()), (int)4).m_126127_(Character.valueOf('F'), (ItemLike)UP2Blocks.FOSSILIZED_BONE_BARK.get()).m_126130_("FF").m_126130_("FF").m_126132_("has_fossilized_bone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE_STAIRS.get()), (int)4).m_126127_(Character.valueOf('C'), (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()).m_126130_("C  ").m_126130_("CC ").m_126130_("CCC").m_126132_("has_fossilized_bone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE_SLAB.get()), (int)6).m_126127_(Character.valueOf('C'), (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()).m_126130_("CCC").m_126132_("has_fossilized_bone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_VERTEBRA.get()), (int)2).m_126127_(Character.valueOf('F'), (ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()).m_126130_("FF").m_126132_("has_fossilized_bone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()), (int)2).m_126127_(Character.valueOf('F'), (ItemLike)UP2Blocks.FOSSILIZED_BONE_VERTEBRA.get()).m_126130_("FF").m_126132_("has_fossilized_bone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_ROD.get()), (int)4).m_126127_(Character.valueOf('F'), (ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()).m_126130_("F").m_126130_("F").m_126132_("has_fossilized_bone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_ROW.get()), (int)6).m_126127_(Character.valueOf('F'), (ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()).m_126130_("FFF").m_126132_("has_fossilized_bone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_SPIKE.get()), (int)2).m_126127_(Character.valueOf('F'), (ItemLike)UP2Blocks.FOSSILIZED_BONE_ROD.get()).m_126130_("F").m_126130_("F").m_126132_("has_fossilized_bone", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get()))).m_176498_(consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get(), (ItemLike)UP2Blocks.FOSSILIZED_BONE_BARK.get(), 1, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get(), (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get(), 1, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get(), (ItemLike)UP2Blocks.FOSSILIZED_BONE_VERTEBRA.get(), 1, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get(), (ItemLike)UP2Blocks.FOSSILIZED_BONE_ROD.get(), 2, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get(), (ItemLike)UP2Blocks.FOSSILIZED_BONE_ROW.get(), 2, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get(), (ItemLike)UP2Blocks.FOSSILIZED_BONE_SPIKE.get(), 2, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get(), (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE_STAIRS.get(), 1, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get(), (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE_SLAB.get(), 2, consumer);
        UP2RecipeProvider.stonecutting((ItemLike)UP2Blocks.FOSSILIZED_BONE_VERTEBRA.get(), (ItemLike)UP2Blocks.FOSSILIZED_BONE_BLOCK.get(), 1, consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.MOSSY_DIRT.get()), (int)8).m_126127_(Character.valueOf('D'), (ItemLike)Blocks.f_50493_.m_5456_()).m_126127_(Character.valueOf('M'), (ItemLike)UP2Blocks.MOSS_LAYER.get()).m_126130_("DDD").m_126130_("DMD").m_126130_("DDD").m_126132_("has_moss_layer", (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)UP2Blocks.MOSS_LAYER.get()))).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_COLORLESS).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.TINTED_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_TINTED).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.WHITE_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_WHITE).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.LIGHT_GRAY_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_LIGHT_GRAY).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.GRAY_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_GRAY).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.BLACK_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_BLACK).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.BROWN_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_BROWN).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.RED_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_RED).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.ORANGE_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_ORANGE).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.YELLOW_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_YELLOW).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.LIME_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_LIME).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.GREEN_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_GREEN).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.CYAN_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_CYAN).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.LIGHT_BLUE_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_LIGHT_BLUE).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.BLUE_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_BLUE).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.PURPLE_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_PURPLE).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.MAGENTA_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_MAGENTA).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.PINK_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), Tags.Items.GLASS_PINK).m_206416_(Character.valueOf('I'), Tags.Items.INGOTS_IRON).m_126130_("GGG").m_126130_("GIG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_176498_(consumer);
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.WHITE_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_WHITE).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("white_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.LIGHT_GRAY_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_LIGHT_GRAY).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("light_gray_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.GRAY_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_GRAY).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("gray_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.BLACK_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_BLACK).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("black_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.BROWN_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_BROWN).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("brown_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.RED_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_RED).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("red_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.ORANGE_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_ORANGE).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("orange_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.YELLOW_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_YELLOW).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("yellow_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.LIME_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_LIME).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("lime_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.GREEN_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_GREEN).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("green_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.CYAN_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_CYAN).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("cyan_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.LIGHT_BLUE_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_LIGHT_BLUE).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("light_blue_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.BLUE_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_BLUE).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("blue_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.PURPLE_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_PURPLE).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("purple_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.MAGENTA_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_MAGENTA).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("magenta_reinforced_glass_from_dye"));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)UP2Blocks.PINK_REINFORCED_GLASS.get()), (int)8).m_206416_(Character.valueOf('G'), UP2ItemTags.REINFORCED_GLASS).m_206416_(Character.valueOf('D'), Tags.Items.DYES_PINK).m_126130_("GGG").m_126130_("GDG").m_126130_("GGG").m_126132_("has_glass", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_((TagKey)Tags.Items.GLASS)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation("pink_reinforced_glass_from_dye"));
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.ARM_FOSSIL.get(), ((Block)UP2Blocks.BRACHIOSAURUS_EGG.get()).m_5456_(), 3600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.FURY_FOSSIL.get(), ((Block)UP2Blocks.CARNOTAURUS_EGG.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.GLUTTONOUS_FOSSIL.get(), ((Block)UP2Blocks.COELACANTHUS_ROE.get()).m_5456_(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.BOOMERANG_FOSSIL.get(), ((Block)UP2Blocks.DIPLOCAULUS_EGGS.get()).m_5456_(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.RUNNER_FOSSIL.get(), (Item)UP2Items.DROMAEOSAURUS_EGG.get(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.GUILLOTINE_FOSSIL.get(), ((Block)UP2Blocks.DUNKLEOSTEUS_SAC.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.PLOW_FOSSIL.get(), ((Block)UP2Blocks.HIBBERTOPTERUS_EGGS.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.JAWLESS_FOSSIL.get(), ((Block)UP2Blocks.JAWLESS_FISH_ROE.get()).m_5456_(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.BOAR_TOOTH_FOSSIL.get(), ((Block)UP2Blocks.KAPROSUCHUS_EGG.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.IMPERATIVE_FOSSIL.get(), ((Block)UP2Blocks.KIMMERIDGEBRACHYPTERAESCHNIDIUM_EGGS.get()).m_5456_(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.PRICKLY_FOSSIL.get(), ((Block)UP2Blocks.KENTROSAURUS_EGG.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.TRUNK_MOUSE_FOSSIL.get(), (Item)UP2Items.LEPTICTIDIUM_EMBRYO.get(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.FISH_FOSSIL.get(), ((Block)UP2Blocks.LOBE_FINNED_FISH_ROE.get()).m_5456_(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.IMPERVIOUS_FOSSIL.get(), ((Block)UP2Blocks.LYSTROSAURUS_EGG.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.RUGOSE_FOSSIL.get(), ((Block)UP2Blocks.MAJUNGASAURUS_EGG.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.THERMAL_FOSSIL.get(), ((Block)UP2Blocks.MEGALANIA_EGG.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.MELTDOWN_FOSSIL.get(), (Item)UP2Items.METRIORHYNCHUS_EMBRYO.get(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.SAW_FOSSIL.get(), ((Block)UP2Blocks.ONCHOPRISTIS_SAC.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.CRANIUM_FOSSIL.get(), ((Block)UP2Blocks.PACHYCEPHALOSAURUS_EGG.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.FLIPPER_FOSSIL.get(), (Item)UP2Items.PRAEPUSA_EMBRYO.get(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.WING_FOSSIL.get(), (Item)UP2Items.PTERODACTYLUS_EGG.get(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.ANVIL_FOSSIL.get(), ((Block)UP2Blocks.STETHACANTHUS_SAC.get()).m_5456_(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.AGED_FEATHER.get(), (Item)UP2Items.TALPANAS_EGG.get(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.MOSSY_FOSSIL.get(), ((Block)UP2Blocks.TARTUOSTEUS_ROE.get()).m_5456_(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.PLUMAGE_FOSSIL.get(), (Item)UP2Items.TELECREX_EGG.get(), 1200);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.DUBIOUS_FOSSIL.get(), ((Block)UP2Blocks.ULUGHBEGSAURUS_EGG.get()).m_5456_(), 2400);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.AETHOPHYLLUM_FOSSIL.get(), ((Block)UP2Blocks.AETHOPHYLLUM.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.BENNETTITALES_FOSSIL.get(), ((Block)UP2Blocks.BENNETTITALES.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.BRACHYPHYLLUM_FOSSIL.get(), ((Block)UP2Blocks.BRACHYPHYLLUM.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.CALAMOPHYTON_FOSSIL.get(), ((Block)UP2Blocks.CALAMOPHYTON.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.CLADOPHLEBIS_FOSSIL.get(), ((Block)UP2Blocks.CLADOPHLEBIS.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.COOKSONIA_FOSSIL.get(), ((Block)UP2Blocks.COOKSONIA.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.CYCAD_FOSSIL.get(), ((Block)UP2Blocks.CYCAD_SEEDLING.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.GINKGO_FOSSIL.get(), ((Block)UP2Blocks.GINKGO_SAPLING.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.GUANGDEDENDRON_FOSSIL.get(), ((Block)UP2Blocks.GUANGDEDENDRON.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.NEOMARIOPTERIS_FOSSIL.get(), ((Block)UP2Blocks.NEOMARIOPTERIS.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.PROTOTAXITES_FOSSIL.get(), ((Block)UP2Blocks.PROTOTAXITES_CLUSTER.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.QUILLWORT_FOSSIL.get(), ((Block)UP2Blocks.QUILLWORT.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.LEEFRUCTUS_FOSSIL.get(), ((Block)UP2Blocks.LEEFRUCTUS.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.LEPIDODENDRON_FOSSIL.get(), ((Block)UP2Blocks.LEPIDODENDRON_CONE.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.RAIGUENRAYUN_FOSSIL.get(), ((Block)UP2Blocks.RAIGUENRAYUN.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.RHYNIA_FOSSIL.get(), ((Block)UP2Blocks.RHYNIA.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.TEMPSKYA_FOSSIL.get(), ((Block)UP2Blocks.TEMPSKYA.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.METASEQUOIA_FOSSIL.get(), ((Block)UP2Blocks.METASEQUOIA_SAPLING.get()).m_5456_(), 600);
        UP2RecipeProvider.transmogrification(consumer, (Item)UP2Items.DRYOPHYLLUM_FOSSIL.get(), ((Block)UP2Blocks.DRYOPHYLLUM_SAPLING.get()).m_5456_(), 600);
    }

    private static void conditionalRecipe(RecipeBuilder recipe, ICondition condition, Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        ConditionalRecipe.builder().addCondition(condition).addRecipe(consumer1 -> recipe.m_126140_(consumer1, id)).generateAdvancement(new ResourceLocation(id.m_135827_(), "recipes/" + id.m_135815_())).build(consumer, id);
    }

    private static void woodSet(TagKey<Item> logs, Block planks, Block slab, Block stairs, Block log, Block wood, Block strippedLog, Block strippedWood, ItemLike boat, ItemLike chestBoat, Block button, Block door, Block trapdoor, Block fence, Block fenceGate, Block pressurePlate, Block sign, Block hangingSign, Consumer<FinishedRecipe> consumer) {
        UP2RecipeProvider.m_126021_(consumer, (ItemLike)boat, (ItemLike)planks);
        ShapelessRecipeBuilder.m_245498_((RecipeCategory)RecipeCategory.TRANSPORTATION, (ItemLike)chestBoat).m_126145_("chest_boat").m_206419_(Tags.Items.CHESTS_WOODEN).m_126209_(boat).m_126132_(UP2RecipeProvider.m_176602_((ItemLike)boat), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)boat)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation(chestBoat));
        ShapelessRecipeBuilder.m_245498_((RecipeCategory)RecipeCategory.REDSTONE, (ItemLike)button).m_126145_("wooden_button").m_126209_((ItemLike)planks).m_126132_(UP2RecipeProvider.m_176602_((ItemLike)planks), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)planks)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation((ItemLike)button));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.DECORATIONS, (ItemLike)door, (int)3).m_126145_("wooden_door").m_126127_(Character.valueOf('#'), (ItemLike)planks).m_126130_("##").m_126130_("##").m_126130_("##").m_126132_(UP2RecipeProvider.m_176602_((ItemLike)planks), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)planks)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation((ItemLike)door));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.DECORATIONS, (ItemLike)fence, (int)3).m_126145_("wooden_fence").m_126127_(Character.valueOf('#'), (ItemLike)planks).m_126127_(Character.valueOf('S'), (ItemLike)Items.f_42398_).m_126130_("#S#").m_126130_("#S#").m_126132_(UP2RecipeProvider.m_176602_((ItemLike)planks), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)planks)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation((ItemLike)fence));
        ShapedRecipeBuilder.m_245327_((RecipeCategory)RecipeCategory.DECORATIONS, (ItemLike)fenceGate).m_126145_("wooden_fence_gate").m_126127_(Character.valueOf('#'), (ItemLike)planks).m_126127_(Character.valueOf('S'), (ItemLike)Items.f_42398_).m_126130_("S#S").m_126130_("S#S").m_126132_(UP2RecipeProvider.m_176602_((ItemLike)planks), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)planks)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation((ItemLike)fenceGate));
        ShapedRecipeBuilder.m_245327_((RecipeCategory)RecipeCategory.REDSTONE, (ItemLike)pressurePlate).m_126145_("wooden_pressure_plate").m_126127_(Character.valueOf('#'), (ItemLike)planks).m_126130_("##").m_126132_(UP2RecipeProvider.m_176602_((ItemLike)planks), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)planks)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation((ItemLike)pressurePlate));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.DECORATIONS, (ItemLike)sign, (int)3).m_126145_("wooden_sign").m_126127_(Character.valueOf('#'), (ItemLike)planks).m_126127_(Character.valueOf('S'), (ItemLike)Items.f_42398_).m_126130_("###").m_126130_("###").m_126130_(" S ").m_126132_(UP2RecipeProvider.m_176602_((ItemLike)planks), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)planks)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation((ItemLike)sign));
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.DECORATIONS, (ItemLike)trapdoor, (int)2).m_126145_("wooden_trapdoor").m_126127_(Character.valueOf('#'), (ItemLike)planks).m_126130_("###").m_126130_("###").m_126132_(UP2RecipeProvider.m_176602_((ItemLike)planks), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)planks)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation((ItemLike)trapdoor));
        UP2RecipeProvider.m_246977_(consumer, (ItemLike)hangingSign, (ItemLike)strippedLog);
        UP2RecipeProvider.m_257424_(consumer, (ItemLike)planks, logs, (int)4);
        UP2RecipeProvider.m_126002_(consumer, (ItemLike)wood, (ItemLike)log);
        UP2RecipeProvider.m_126002_(consumer, (ItemLike)strippedWood, (ItemLike)strippedLog);
        UP2RecipeProvider.slab((ItemLike)planks, (ItemLike)slab, "wooden_slab", consumer);
        UP2RecipeProvider.stairs((ItemLike)planks, (ItemLike)stairs, "wooden_stairs", consumer);
    }

    private static void stairs(ItemLike ingredient, ItemLike stairs, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)stairs, (int)4).m_126127_(Character.valueOf('#'), ingredient).m_126130_("#  ").m_126130_("## ").m_126130_("###").m_126132_(UP2RecipeProvider.m_176602_((ItemLike)ingredient), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)ingredient)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation(UP2RecipeProvider.getName(stairs)));
    }

    private static void stairs(ItemLike ingredient, ItemLike stairs, String group, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)stairs, (int)4).m_126145_(group).m_126127_(Character.valueOf('#'), ingredient).m_126130_("#  ").m_126130_("## ").m_126130_("###").m_126132_(UP2RecipeProvider.m_176602_((ItemLike)ingredient), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)ingredient)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation(UP2RecipeProvider.getName(stairs)));
    }

    private static void wall(ItemLike ingredient, ItemLike wall, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)wall, (int)6).m_126127_(Character.valueOf('#'), ingredient).m_126130_("###").m_126130_("###").m_126132_(UP2RecipeProvider.m_176602_((ItemLike)ingredient), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)ingredient)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation(UP2RecipeProvider.getName(wall)));
    }

    private static void slab(ItemLike ingredient, ItemLike slab, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)slab, (int)6).m_126127_(Character.valueOf('#'), ingredient).m_126130_("###").m_126132_(UP2RecipeProvider.m_176602_((ItemLike)ingredient), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)ingredient)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation(UP2RecipeProvider.getName(slab)));
    }

    private static void slab(ItemLike ingredient, ItemLike slab, String group, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)slab, (int)6).m_126145_(group).m_126127_(Character.valueOf('#'), ingredient).m_126130_("###").m_126132_("has_" + UP2RecipeProvider.getName(ingredient), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)ingredient)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation(UP2RecipeProvider.getName(slab)));
    }

    public ShapedRecipeBuilder door(Supplier<? extends Block> doorOut, Supplier<? extends Block> plankIn) {
        return ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)doorOut.get()), (int)3).m_126130_("PP").m_126130_("PP").m_126130_("PP").m_126127_(Character.valueOf('P'), (ItemLike)plankIn.get()).m_126132_("has_" + ForgeRegistries.BLOCKS.getKey((Object)plankIn.get()).m_135815_(), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)plankIn.get())));
    }

    public ShapedRecipeBuilder trapdoor(Supplier<? extends Block> trapdoorOut, Supplier<? extends Block> plankIn) {
        return ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)trapdoorOut.get()), (int)2).m_126130_("PPP").m_126130_("PPP").m_126127_(Character.valueOf('P'), (ItemLike)plankIn.get()).m_126132_("has_" + ForgeRegistries.BLOCKS.getKey((Object)plankIn.get()).m_135815_(), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)plankIn.get())));
    }

    public ShapelessRecipeBuilder button(Supplier<? extends Block> buttonOut, Supplier<? extends Block> blockIn) {
        return ShapelessRecipeBuilder.m_245498_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)buttonOut.get())).m_126209_((ItemLike)blockIn.get()).m_126132_("has_" + ForgeRegistries.BLOCKS.getKey((Object)blockIn.get()).m_135815_(), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)blockIn.get())));
    }

    public ShapedRecipeBuilder pressurePlate(Supplier<? extends Block> pressurePlateOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.m_245327_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)pressurePlateOut.get())).m_126130_("BB").m_126127_(Character.valueOf('B'), (ItemLike)blockIn.get()).m_126132_("has_" + ForgeRegistries.BLOCKS.getKey((Object)blockIn.get()).m_135815_(), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)blockIn.get())));
    }

    public ShapedRecipeBuilder stairs(Supplier<? extends Block> stairsOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)stairsOut.get()), (int)4).m_126130_("M  ").m_126130_("MM ").m_126130_("MMM").m_126127_(Character.valueOf('M'), (ItemLike)blockIn.get()).m_126132_("has_" + ForgeRegistries.BLOCKS.getKey((Object)blockIn.get()).m_135815_(), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)blockIn.get())));
    }

    public ShapedRecipeBuilder slab(Supplier<? extends Block> slabOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)slabOut.get()), (int)6).m_126130_("MMM").m_126127_(Character.valueOf('M'), (ItemLike)blockIn.get()).m_126132_("has_" + ForgeRegistries.BLOCKS.getKey((Object)blockIn.get()).m_135815_(), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)blockIn.get())));
    }

    public ShapedRecipeBuilder fence(Supplier<? extends Block> fenceOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)fenceOut.get()), (int)3).m_126130_("M/M").m_126130_("M/M").m_126127_(Character.valueOf('M'), (ItemLike)blockIn.get()).m_206416_(Character.valueOf('/'), Tags.Items.RODS_WOODEN).m_126132_("has_" + ForgeRegistries.BLOCKS.getKey((Object)blockIn.get()).m_135815_(), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)blockIn.get())));
    }

    public ShapedRecipeBuilder fenceGate(Supplier<? extends Block> fenceGateOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.m_245327_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)fenceGateOut.get())).m_126130_("/M/").m_126130_("/M/").m_126127_(Character.valueOf('M'), (ItemLike)blockIn.get()).m_206416_(Character.valueOf('/'), Tags.Items.RODS_WOODEN).m_126132_("has_" + ForgeRegistries.BLOCKS.getKey((Object)blockIn.get()).m_135815_(), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)blockIn.get())));
    }

    public ShapelessRecipeBuilder planks(Supplier<? extends Block> plankOut, TagKey<Item> logIn) {
        return ShapelessRecipeBuilder.m_246517_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)plankOut.get()), (int)4).m_206419_(logIn).m_126145_("planks").m_126132_("has_log", (CriterionTriggerInstance)UP2RecipeProvider.m_206406_(logIn));
    }

    public ShapedRecipeBuilder wood(Supplier<? extends Block> woodOut, Supplier<? extends Block> logIn) {
        return ShapedRecipeBuilder.m_246608_((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)((ItemLike)woodOut.get()), (int)3).m_126130_("MM").m_126130_("MM").m_126127_(Character.valueOf('M'), (ItemLike)logIn.get()).m_126132_("has_" + ForgeRegistries.BLOCKS.getKey((Object)logIn.get()).m_135815_(), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)((ItemLike)logIn.get())));
    }

    private static void stonecutting(ItemLike ingredient, ItemLike result, int amount, Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.m_246944_((Ingredient)Ingredient.m_43929_((ItemLike[])new ItemLike[]{ingredient}), (RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemLike)result, (int)amount).m_126132_(UP2RecipeProvider.m_176602_((ItemLike)ingredient), (CriterionTriggerInstance)UP2RecipeProvider.m_125977_((ItemLike)ingredient)).m_126140_(consumer, UP2RecipeProvider.getSaveLocation(UP2RecipeProvider.getName(result) + "_from_stonecutting"));
    }

    protected static void transmogrification(Consumer<FinishedRecipe> consumer, Item input, Item result, int processingTime) {
        Ingredient ingredient = Ingredient.m_43929_((ItemLike[])new ItemLike[]{input});
        TransmogrificationBuilder.transmogrification(ingredient, result, processingTime).save(consumer, UnusualPrehistory2.modPrefix("transmogrification/" + UP2RecipeProvider.m_176632_((ItemLike)result)));
    }

    private static String getName(ItemLike object) {
        return ForgeRegistries.ITEMS.getKey((Object)object.m_5456_()).m_135815_();
    }

    private static ResourceLocation getSaveLocation(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey((Object)item.m_5456_());
    }

    private static ResourceLocation getSaveLocation(String name) {
        return UnusualPrehistory2.modPrefix(name);
    }
}


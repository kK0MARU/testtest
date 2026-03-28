/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.storage.loot.LootContext
 *  net.minecraft.world.level.storage.loot.LootTable
 *  net.minecraft.world.level.storage.loot.predicates.LootItemCondition
 *  net.minecraft.world.level.storage.loot.predicates.LootItemConditions
 *  net.minecraftforge.common.loot.IGlobalLootModifier
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.modifier;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import org.jetbrains.annotations.NotNull;

public class AddLootTableModifier
implements IGlobalLootModifier {
    public static final Supplier<Codec<AddLootTableModifier>> CODEC = () -> RecordCodecBuilder.create(instance -> instance.group((App)LOOT_CONDITIONS_CODEC.fieldOf("conditions").forGetter(modifier -> modifier.conditions), (App)ResourceLocation.f_135803_.fieldOf("lootTable").forGetter(modifier -> modifier.lootTable), (App)Codec.BOOL.optionalFieldOf("replace", (Object)false).forGetter(modifier -> modifier.replace), (App)Codec.FLOAT.optionalFieldOf("replaceChance", (Object)Float.valueOf(0.0f)).forGetter(modifier -> Float.valueOf(modifier.replaceChance))).apply((Applicative)instance, AddLootTableModifier::new));
    private final LootItemCondition[] conditions;
    private final Predicate<LootContext> orConditions;
    private final ResourceLocation lootTable;
    private final boolean replace;
    private final float replaceChance;

    protected AddLootTableModifier(LootItemCondition[] conditions, ResourceLocation lootTable, boolean replace, float replaceChance) {
        this.lootTable = lootTable;
        this.conditions = conditions;
        this.orConditions = LootItemConditions.m_81841_((Predicate[])conditions);
        this.replace = replace;
        this.replaceChance = replaceChance;
    }

    @NotNull
    public ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        return this.orConditions.test(context) ? this.doApply(generatedLoot, context) : generatedLoot;
    }

    @NotNull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        LootTable extraTable = context.m_278643_().m_278676_(this.lootTable);
        if (this.replace && context.m_230907_().m_188501_() < this.replaceChance) {
            generatedLoot.clear();
        }
        extraTable.m_79131_(context, LootTable.m_246283_((ServerLevel)context.m_78952_(), arg_0 -> generatedLoot.add(arg_0)));
        return generatedLoot;
    }

    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.loot.LootTableProvider
 *  net.minecraft.data.loot.LootTableProvider$SubProviderEntry
 *  net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.datagen.UP2BlockLootTableProvider;
import java.util.List;
import java.util.Set;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class UP2LootProvider {
    public static LootTableProvider register(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of((Object)new LootTableProvider.SubProviderEntry(UP2BlockLootTableProvider::new, LootContextParamSets.f_81421_)));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance
 *  net.minecraft.advancements.critereon.ContextAwarePredicate
 *  net.minecraft.advancements.critereon.DeserializationContext
 *  net.minecraft.advancements.critereon.SimpleCriterionTrigger
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

public class UP2CriteriaTriggers
extends SimpleCriterionTrigger<TriggerInstance> {
    private final ResourceLocation CRITERIA;

    public UP2CriteriaTriggers(String name) {
        this.CRITERIA = UnusualPrehistory2.modPrefix(name);
    }

    @NotNull
    public ResourceLocation m_7295_() {
        return this.CRITERIA;
    }

    public void trigger(ServerPlayer player) {
        this.m_66234_(player, conditions -> true);
    }

    @NotNull
    protected TriggerInstance createInstance(@NotNull JsonObject object, @NotNull ContextAwarePredicate predicate, @NotNull DeserializationContext context) {
        return new TriggerInstance(this.CRITERIA, predicate);
    }

    public static class TriggerInstance
    extends AbstractCriterionTriggerInstance {
        public TriggerInstance(ResourceLocation id, ContextAwarePredicate predicate) {
            super(id, predicate);
        }
    }
}


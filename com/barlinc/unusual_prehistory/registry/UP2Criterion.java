/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.advancements.CriterionTrigger
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.registry.UP2CriteriaTriggers;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid="unusual_prehistory")
public class UP2Criterion {
    public static final UP2CriteriaTriggers PACIFY_MOB_PERMANENT = (UP2CriteriaTriggers)CriteriaTriggers.m_10595_((CriterionTrigger)new UP2CriteriaTriggers("pacify_mob"));
    public static final UP2CriteriaTriggers BREED_HOLOCENE_MOBS = (UP2CriteriaTriggers)CriteriaTriggers.m_10595_((CriterionTrigger)new UP2CriteriaTriggers("breed_holocene_mobs"));
}


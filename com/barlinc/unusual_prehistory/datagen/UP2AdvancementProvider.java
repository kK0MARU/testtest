/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.advancements.Advancement
 *  net.minecraft.advancements.Advancement$Builder
 *  net.minecraft.advancements.AdvancementRewards$Builder
 *  net.minecraft.advancements.CriterionTriggerInstance
 *  net.minecraft.advancements.FrameType
 *  net.minecraft.advancements.RequirementsStrategy
 *  net.minecraft.advancements.critereon.ContextAwarePredicate
 *  net.minecraft.advancements.critereon.EntityPredicate$Builder
 *  net.minecraft.advancements.critereon.InventoryChangeTrigger$TriggerInstance
 *  net.minecraft.advancements.critereon.SummonedEntityTrigger$TriggerInstance
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraftforge.common.data.ExistingFileHelper
 *  net.minecraftforge.common.data.ForgeAdvancementProvider
 *  net.minecraftforge.common.data.ForgeAdvancementProvider$AdvancementGenerator
 *  net.minecraftforge.registries.ForgeRegistries
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2CriteriaTriggers;
import com.barlinc.unusual_prehistory.registry.UP2Criterion;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.SummonedEntityTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class UP2AdvancementProvider
implements ForgeAdvancementProvider.AdvancementGenerator {
    private static final EntityType<?>[] REVIVABLE_MOBS = new EntityType[]{(EntityType)UP2Entities.BRACHIOSAURUS.get(), (EntityType)UP2Entities.CARNOTAURUS.get(), (EntityType)UP2Entities.DIPLOCAULUS.get(), (EntityType)UP2Entities.DROMAEOSAURUS.get(), (EntityType)UP2Entities.DUNKLEOSTEUS.get(), (EntityType)UP2Entities.HIBBERTOPTERUS.get(), (EntityType)UP2Entities.JAWLESS_FISH.get(), (EntityType)UP2Entities.KAPROSUCHUS.get(), (EntityType)UP2Entities.KENTROSAURUS.get(), (EntityType)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH.get(), (EntityType)UP2Entities.LEPTICTIDIUM.get(), (EntityType)UP2Entities.LYSTROSAURUS.get(), (EntityType)UP2Entities.MAJUNGASAURUS.get(), (EntityType)UP2Entities.MEGALANIA.get(), (EntityType)UP2Entities.METRIORHYNCHUS.get(), (EntityType)UP2Entities.ONCHOPRISTIS.get(), (EntityType)UP2Entities.PACHYCEPHALOSAURUS.get(), (EntityType)UP2Entities.PRAEPUSA.get(), (EntityType)UP2Entities.PTERODACTYLUS.get(), (EntityType)UP2Entities.STETHACANTHUS.get(), (EntityType)UP2Entities.TALPANAS.get(), (EntityType)UP2Entities.TELECREX.get(), (EntityType)UP2Entities.ULUGHBEGSAURUS.get()};
    private static final ItemLike[] HOLOCENE_REMAINS = new ItemLike[]{(ItemLike)UP2Items.AGED_FEATHER.get()};
    private static final ItemLike[] ROOT = new ItemLike[]{(ItemLike)UP2Items.MACHINE_PARTS.get()};
    public static List<ItemLike> ALL_EGG_BLOCKS = UP2Blocks.EGG_BLOCKS.stream().map(Supplier::get).collect(Collectors.toList());
    public static List<ItemLike> ALL_EGG_ITEMS = UP2Items.EGG_EMBRYO_ITEMS.stream().map(Supplier::get).collect(Collectors.toList());
    public static List<ItemLike> ALL_FOSSILS = UP2Items.FOSSILS.stream().map(Supplier::get).collect(Collectors.toList());

    public static ForgeAdvancementProvider register(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        return new ForgeAdvancementProvider(output, provider, helper, List.of((Object)new UP2AdvancementProvider()));
    }

    public void generate(@NotNull HolderLookup.Provider provider, @NotNull Consumer<Advancement> consumer, @NotNull ExistingFileHelper helper) {
        Advancement root = this.addRoot(Advancement.Builder.m_138353_().m_138371_((ItemLike)UP2Items.UNUSUAL_PREHISTORY.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.root"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.root.desc"), UnusualPrehistory2.modPrefix("textures/block/mossy_dirt_top.png"), FrameType.TASK, false, false, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("root"), helper);
        Advancement fossils = this.addItemList(ALL_FOSSILS, Advancement.Builder.m_138353_().m_138398_(root).m_138371_((ItemLike)UP2Items.RUGOSE_FOSSIL.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.obtain_fossil"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.obtain_fossil.desc"), null, FrameType.TASK, true, true, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("obtain_fossil"), helper);
        this.addItemList(HOLOCENE_REMAINS, Advancement.Builder.m_138353_().m_138398_(root).m_138371_((ItemLike)UP2Items.AGED_FEATHER.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.obtain_holocene_remains"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.obtain_holocene_remains.desc"), null, FrameType.TASK, true, true, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("obtain_holocene_remains"), helper);
        Advancement machineParts = UP2AdvancementProvider.createAdvancement("obtain_machine_parts", fossils, (ItemLike)UP2Items.MACHINE_PARTS.get(), FrameType.TASK, false).m_138386_("machine_parts", (CriterionTriggerInstance)InventoryChangeTrigger.TriggerInstance.m_43199_((ItemLike[])new ItemLike[]{(ItemLike)UP2Items.MACHINE_PARTS.get()})).save(consumer, UnusualPrehistory2.modPrefix("obtain_machine_parts"), helper);
        Advancement transmogrifier = UP2AdvancementProvider.createAdvancement("obtain_transmogrifier", machineParts, (ItemLike)UP2Blocks.TRANSMOGRIFIER.get(), FrameType.GOAL, false).m_138386_("transmogrifier", (CriterionTriggerInstance)InventoryChangeTrigger.TriggerInstance.m_43199_((ItemLike[])new ItemLike[]{(ItemLike)UP2Blocks.TRANSMOGRIFIER.get()})).save(consumer, UnusualPrehistory2.modPrefix("obtain_transmogrifier"), helper);
        Advancement organicOoze = UP2AdvancementProvider.createAdvancement("obtain_organic_ooze", transmogrifier, (ItemLike)UP2Items.ORGANIC_OOZE.get(), FrameType.TASK, false).m_138386_("organic_ooze", (CriterionTriggerInstance)InventoryChangeTrigger.TriggerInstance.m_43199_((ItemLike[])new ItemLike[]{(ItemLike)UP2Items.ORGANIC_OOZE.get()})).save(consumer, UnusualPrehistory2.modPrefix("obtain_organic_ooze"), helper);
        UP2AdvancementProvider.createAdvancement("obtain_living_ooze", organicOoze, (ItemLike)UP2Items.LIVING_OOZE_BUCKET.get(), FrameType.GOAL, false).m_138386_("living_ooze_bucket", (CriterionTriggerInstance)InventoryChangeTrigger.TriggerInstance.m_43199_((ItemLike[])new ItemLike[]{(ItemLike)UP2Items.LIVING_OOZE_BUCKET.get()})).save(consumer, UnusualPrehistory2.modPrefix("obtain_living_ooze"), helper);
        Advancement eggs = this.addAllEggs(Advancement.Builder.m_138353_().m_138398_(organicOoze).m_138371_((ItemLike)UP2Blocks.MAJUNGASAURUS_EGG.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.obtain_egg"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.obtain_egg.desc"), null, FrameType.GOAL, true, true, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("obtain_egg"), helper);
        this.addMobList(REVIVABLE_MOBS, Advancement.Builder.m_138353_().m_138398_(eggs).m_138371_((ItemLike)Items.f_271356_, (Component)Component.m_237115_((String)"advancement.unusual_prehistory.revive_all_mobs"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.revive_all_mobs.desc"), null, FrameType.CHALLENGE, true, true, true).m_138360_(RequirementsStrategy.f_15978_)).m_138354_(AdvancementRewards.Builder.m_10005_((int)100)).save(consumer, UnusualPrehistory2.modPrefix("revive_all_mobs"), helper);
        Advancement paleozoicRoot = this.addAllEggs(Advancement.Builder.m_138353_().m_138398_(eggs).m_138371_((ItemLike)UP2Blocks.DIPLOCAULUS_EGGS.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.paleozoic_root"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.paleozoic_root.desc"), null, FrameType.TASK, false, false, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("paleozoic_root"), helper);
        Advancement mesozoicRoot = this.addAllEggs(Advancement.Builder.m_138353_().m_138398_(eggs).m_138371_((ItemLike)UP2Blocks.CARNOTAURUS_EGG.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.mesozoic_root"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.mesozoic_root.desc"), null, FrameType.TASK, false, false, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("mesozoic_root"), helper);
        Advancement triassicRoot = this.addAllEggs(Advancement.Builder.m_138353_().m_138398_(mesozoicRoot).m_138371_((ItemLike)UP2Blocks.DESMATOSUCHUS_EGG.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.triassic_root"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.triassic_root.desc"), null, FrameType.TASK, false, false, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("triassic_root"), helper);
        Advancement jurassicRoot = this.addAllEggs(Advancement.Builder.m_138353_().m_138398_(mesozoicRoot).m_138371_((ItemLike)UP2Blocks.KENTROSAURUS_EGG.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.jurassic_root"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.jurassic_root.desc"), null, FrameType.TASK, false, false, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("jurassic_root"), helper);
        Advancement cretaceousRoot = this.addAllEggs(Advancement.Builder.m_138353_().m_138398_(mesozoicRoot).m_138371_((ItemLike)UP2Items.DROMAEOSAURUS_EGG.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.cretaceous_root"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.cretaceous_root.desc"), null, FrameType.TASK, false, false, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("cretaceous_root"), helper);
        Advancement cenozoicRoot = this.addAllEggs(Advancement.Builder.m_138353_().m_138398_(eggs).m_138371_((ItemLike)UP2Blocks.MEGALANIA_EGG.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.cenozoic_root"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.cenozoic_root.desc"), null, FrameType.TASK, false, false, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("cenozoic_root"), helper);
        Advancement holoceneRoot = this.addAllEggs(Advancement.Builder.m_138353_().m_138398_(cenozoicRoot).m_138371_((ItemLike)UP2Items.TALPANAS_EGG.get(), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.holocene_root"), (Component)Component.m_237115_((String)"advancement.unusual_prehistory.holocene_root.desc"), null, FrameType.TASK, false, false, false).m_138360_(RequirementsStrategy.f_15979_)).save(consumer, UnusualPrehistory2.modPrefix("holocene_root"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_coelacanthus", paleozoicRoot, (ItemLike)UP2Blocks.COELACANTHUS_ROE.get(), (EntityType)UP2Entities.COELACANTHUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_coelacanthus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_diplocaulus", paleozoicRoot, (ItemLike)UP2Blocks.DIPLOCAULUS_EGGS.get(), (EntityType)UP2Entities.DIPLOCAULUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_diplocaulus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_dunkleosteus", paleozoicRoot, (ItemLike)UP2Blocks.DUNKLEOSTEUS_SAC.get(), (EntityType)UP2Entities.DUNKLEOSTEUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_dunkleosteus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_hibbertopterus", paleozoicRoot, (ItemLike)UP2Blocks.HIBBERTOPTERUS_EGGS.get(), (EntityType)UP2Entities.HIBBERTOPTERUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_hibbertopterus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_jawless_fish", paleozoicRoot, (ItemLike)UP2Blocks.JAWLESS_FISH_ROE.get(), (EntityType)UP2Entities.JAWLESS_FISH.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_jawless_fish"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_lobe_finned_fish", paleozoicRoot, (ItemLike)UP2Blocks.LOBE_FINNED_FISH_ROE.get(), (EntityType)UP2Entities.LOBE_FINNED_FISH.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_lobe_finned_fish"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_stethacanthus", paleozoicRoot, (ItemLike)UP2Blocks.STETHACANTHUS_SAC.get(), (EntityType)UP2Entities.STETHACANTHUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_stethacanthus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_tartuosteus", paleozoicRoot, (ItemLike)UP2Blocks.TARTUOSTEUS_ROE.get(), (EntityType)UP2Entities.TARTUOSTEUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_tartuosteus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_lystrosaurus", triassicRoot, (ItemLike)UP2Blocks.LYSTROSAURUS_EGG.get(), (EntityType)UP2Entities.LYSTROSAURUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_lystrosaurus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_brachiosaurus", jurassicRoot, (ItemLike)UP2Blocks.BRACHIOSAURUS_EGG.get(), (EntityType)UP2Entities.BRACHIOSAURUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_brachiosaurus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_kentrosaurus", jurassicRoot, (ItemLike)UP2Blocks.KENTROSAURUS_EGG.get(), (EntityType)UP2Entities.KENTROSAURUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_kentrosaurus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_kimmeridgebrachypteraeschnidium", jurassicRoot, (ItemLike)UP2Blocks.KIMMERIDGEBRACHYPTERAESCHNIDIUM_EGGS.get(), (EntityType)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_kimmeridgebrachypteraeschnidium"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_metriorhynchus", jurassicRoot, (ItemLike)UP2Items.METRIORHYNCHUS_EMBRYO.get(), (EntityType)UP2Entities.METRIORHYNCHUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_metriorhynchus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_pterodactylus", jurassicRoot, (ItemLike)UP2Items.PTERODACTYLUS_EGG.get(), (EntityType)UP2Entities.PTERODACTYLUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_pterodactylus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_carnotaurus", cretaceousRoot, (ItemLike)UP2Blocks.CARNOTAURUS_EGG.get(), (EntityType)UP2Entities.CARNOTAURUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_carnotaurus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_dromaeosaurus", cretaceousRoot, (ItemLike)UP2Items.DROMAEOSAURUS_EGG.get(), (EntityType)UP2Entities.DROMAEOSAURUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_dromaeosaurus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_kaprosuchus", cretaceousRoot, (ItemLike)UP2Blocks.KAPROSUCHUS_EGG.get(), (EntityType)UP2Entities.KAPROSUCHUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_kaprosuchus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_majungasaurus", cretaceousRoot, (ItemLike)UP2Blocks.MAJUNGASAURUS_EGG.get(), (EntityType)UP2Entities.MAJUNGASAURUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_majungasaurus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_onchopristis", cretaceousRoot, (ItemLike)UP2Blocks.ONCHOPRISTIS_SAC.get(), (EntityType)UP2Entities.ONCHOPRISTIS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_onchopristis"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_pachycephalosaurus", cretaceousRoot, (ItemLike)UP2Blocks.PACHYCEPHALOSAURUS_EGG.get(), (EntityType)UP2Entities.PACHYCEPHALOSAURUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_pachycephalosaurus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_ulughbegsaurus", cretaceousRoot, (ItemLike)UP2Blocks.ULUGHBEGSAURUS_EGG.get(), (EntityType)UP2Entities.ULUGHBEGSAURUS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_ulughbegsaurus"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_leptictidium", cenozoicRoot, (ItemLike)UP2Items.LEPTICTIDIUM_EMBRYO.get(), (EntityType)UP2Entities.LEPTICTIDIUM.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_leptictidium"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_megalania", cenozoicRoot, (ItemLike)UP2Blocks.MEGALANIA_EGG.get(), (EntityType)UP2Entities.MEGALANIA.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_megalania"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_praepusa", cenozoicRoot, (ItemLike)UP2Items.PRAEPUSA_EMBRYO.get(), (EntityType)UP2Entities.PRAEPUSA.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_praepusa"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_telecrex", cenozoicRoot, (ItemLike)UP2Items.TELECREX_EGG.get(), (EntityType)UP2Entities.TELECREX.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_telecrex"), helper);
        UP2AdvancementProvider.reviveMobAdvancement("revive_talpanas", holoceneRoot, (ItemLike)UP2Items.TALPANAS_EGG.get(), (EntityType)UP2Entities.TALPANAS.get()).save(consumer, UnusualPrehistory2.modPrefix("revive_talpanas"), helper);
        UP2AdvancementProvider.createAdvancement("breed_holocene_mobs", holoceneRoot, (ItemLike)Items.f_151017_, FrameType.TASK, false).m_138386_("breed_holocene_mobs", (CriterionTriggerInstance)new UP2CriteriaTriggers.TriggerInstance(UP2Criterion.BREED_HOLOCENE_MOBS.m_7295_(), ContextAwarePredicate.f_285567_)).save(consumer, UnusualPrehistory2.modPrefix("breed_holocene_mobs"), helper);
        UP2AdvancementProvider.createAdvancement("pacify_mob", eggs, (ItemLike)Items.f_42437_, FrameType.CHALLENGE, false).m_138386_("pacify_mob", (CriterionTriggerInstance)new UP2CriteriaTriggers.TriggerInstance(UP2Criterion.PACIFY_MOB_PERMANENT.m_7295_(), ContextAwarePredicate.f_285567_)).m_138354_(AdvancementRewards.Builder.m_10005_((int)50)).save(consumer, UnusualPrehistory2.modPrefix("pacify_mob"), helper);
    }

    private static Advancement.Builder createAdvancement(String name, Advancement parent, ItemLike icon, FrameType frame, boolean hidden) {
        return Advancement.Builder.m_138353_().m_138398_(parent).m_138371_(icon, (Component)Component.m_237115_((String)("advancement.unusual_prehistory." + name)), (Component)Component.m_237115_((String)("advancement.unusual_prehistory." + name + ".desc")), null, frame, true, true, hidden);
    }

    private static Advancement.Builder createAdvancement(String name, Advancement parent, ItemLike icon, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return Advancement.Builder.m_138353_().m_138398_(parent).m_138371_(icon, (Component)Component.m_237115_((String)("advancement.unusual_prehistory." + name)), (Component)Component.m_237115_((String)("advancement.unusual_prehistory." + name + ".desc")), null, frame, showToast, announceToChat, hidden);
    }

    private static Advancement.Builder reviveMobAdvancement(String name, Advancement parent, ItemLike icon, EntityType<?> entityType) {
        return UP2AdvancementProvider.createAdvancement(name, parent, icon, FrameType.TASK, true, true, false).m_138386_(name, (CriterionTriggerInstance)SummonedEntityTrigger.TriggerInstance.m_68275_((EntityPredicate.Builder)EntityPredicate.Builder.m_36633_().m_36636_(entityType)));
    }

    private Advancement.Builder addItemList(ItemLike[] itemLikes, Advancement.Builder builder) {
        for (ItemLike items : itemLikes) {
            builder.m_138386_(ForgeRegistries.ITEMS.getKey((Object)items.m_5456_()).m_135815_(), (CriterionTriggerInstance)InventoryChangeTrigger.TriggerInstance.m_43199_((ItemLike[])new ItemLike[]{items}));
        }
        return builder;
    }

    private Advancement.Builder addItemList(List<ItemLike> itemLikes, Advancement.Builder builder) {
        for (ItemLike items : itemLikes) {
            builder.m_138386_(ForgeRegistries.ITEMS.getKey((Object)items.m_5456_()).m_135815_(), (CriterionTriggerInstance)InventoryChangeTrigger.TriggerInstance.m_43199_((ItemLike[])new ItemLike[]{items}));
        }
        return builder;
    }

    private Advancement.Builder addMobList(EntityType<?>[] entityTypes, Advancement.Builder builder) {
        for (EntityType<?> entity : entityTypes) {
            builder.m_138386_(EntityType.m_20613_(entity).m_135815_(), (CriterionTriggerInstance)SummonedEntityTrigger.TriggerInstance.m_68275_((EntityPredicate.Builder)EntityPredicate.Builder.m_36633_().m_36636_(entity)));
        }
        return builder;
    }

    private Advancement.Builder addAllEggs(Advancement.Builder builder) {
        this.addItemList(ALL_EGG_BLOCKS, builder);
        this.addItemList(ALL_EGG_ITEMS, builder);
        return builder;
    }

    private Advancement.Builder addRoot(Advancement.Builder builder) {
        this.addItemList(ALL_EGG_BLOCKS, builder);
        this.addItemList(ALL_EGG_ITEMS, builder);
        this.addItemList(ALL_FOSSILS, builder);
        this.addItemList(HOLOCENE_REMAINS, builder);
        this.addItemList(ROOT, builder);
        return builder;
    }
}


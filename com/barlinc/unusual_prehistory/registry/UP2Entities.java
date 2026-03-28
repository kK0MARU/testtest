/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EntityType$Builder
 *  net.minecraft.world.entity.EntityType$EntityFactory
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.MobCategory
 *  net.minecraft.world.entity.projectile.ThrowableItemProjectile
 *  net.minecraft.world.item.Item
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.misc.UP2Boat;
import com.barlinc.unusual_prehistory.entity.misc.UP2ChestBoat;
import com.barlinc.unusual_prehistory.entity.mob.future.Aegirocassis;
import com.barlinc.unusual_prehistory.entity.mob.future.Barinasuchus;
import com.barlinc.unusual_prehistory.entity.mob.future.Cotylorhynchus;
import com.barlinc.unusual_prehistory.entity.mob.future.Desmatosuchus;
import com.barlinc.unusual_prehistory.entity.mob.future.Dimorphodon;
import com.barlinc.unusual_prehistory.entity.mob.future.Eryon;
import com.barlinc.unusual_prehistory.entity.mob.future.Mammoth;
import com.barlinc.unusual_prehistory.entity.mob.future.Manipulator;
import com.barlinc.unusual_prehistory.entity.mob.future.Palaeophis;
import com.barlinc.unusual_prehistory.entity.mob.future.Psilopterus;
import com.barlinc.unusual_prehistory.entity.mob.future.Therizinosaurus;
import com.barlinc.unusual_prehistory.entity.mob.future.Wonambi;
import com.barlinc.unusual_prehistory.entity.mob.future.ambient.Delitzschala;
import com.barlinc.unusual_prehistory.entity.mob.future.ambient.Zhangsolva;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Carnotaurus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Diplocaulus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Dromaeosaurus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Dunkleosteus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.JawlessFish;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Kentrosaurus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Kimmeridgebrachypteraeschnidium;
import com.barlinc.unusual_prehistory.entity.mob.update_1.KimmeridgebrachypteraeschnidiumNymph;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Majungasaurus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Megalania;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Stethacanthus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Talpanas;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Telecrex;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Unicorn;
import com.barlinc.unusual_prehistory.entity.mob.update_2.Onchopristis;
import com.barlinc.unusual_prehistory.entity.mob.update_3.LivingOoze;
import com.barlinc.unusual_prehistory.entity.mob.update_3.Metriorhynchus;
import com.barlinc.unusual_prehistory.entity.mob.update_3.Tartuosteus;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Brachiosaurus;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Coelacanthus;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Hibbertopterus;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Kaprosuchus;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Leptictidium;
import com.barlinc.unusual_prehistory.entity.mob.update_4.LobeFinnedFish;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Lystrosaurus;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Pachycephalosaurus;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Praepusa;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Pterodactylus;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Ulughbegsaurus;
import com.barlinc.unusual_prehistory.entity.projectile.ThrowableEgg;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid="unusual_prehistory", bus=Mod.EventBusSubscriber.Bus.MOD)
public class UP2Entities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create((IForgeRegistry)ForgeRegistries.ENTITY_TYPES, (String)"unusual_prehistory");
    public static final RegistryObject<EntityType<Carnotaurus>> CARNOTAURUS = UP2Entities.registerLivingEntity("carnotaurus", Carnotaurus::new, MobCategory.CREATURE, 1.6f, 2.9f);
    public static final RegistryObject<EntityType<Diplocaulus>> DIPLOCAULUS = UP2Entities.registerLivingEntity("diplocaulus", Diplocaulus::new, MobCategory.CREATURE, 0.6f, 0.4f);
    public static final RegistryObject<EntityType<Dromaeosaurus>> DROMAEOSAURUS = UP2Entities.registerLivingEntity("dromaeosaurus", Dromaeosaurus::new, MobCategory.CREATURE, 0.7f, 1.2f);
    public static final RegistryObject<EntityType<Dunkleosteus>> DUNKLEOSTEUS = UP2Entities.registerLivingEntity("dunkleosteus", Dunkleosteus::new, MobCategory.WATER_CREATURE, 0.75f, 0.6f);
    public static final RegistryObject<EntityType<JawlessFish>> JAWLESS_FISH = UP2Entities.registerLivingEntity("jawless_fish", JawlessFish::new, MobCategory.WATER_AMBIENT, 0.36f, 0.36f);
    public static final RegistryObject<EntityType<Kentrosaurus>> KENTROSAURUS = UP2Entities.registerLivingEntity("kentrosaurus", Kentrosaurus::new, MobCategory.CREATURE, 1.6f, 2.2f);
    public static final RegistryObject<EntityType<Kimmeridgebrachypteraeschnidium>> KIMMERIDGEBRACHYPTERAESCHNIDIUM = UP2Entities.registerLivingEntity("kimmeridgebrachypteraeschnidium", Kimmeridgebrachypteraeschnidium::new, MobCategory.CREATURE, 0.5f, 0.5f);
    public static final RegistryObject<EntityType<KimmeridgebrachypteraeschnidiumNymph>> KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH = UP2Entities.registerLivingEntity("kimmeridgebrachypteraeschnidium_nymph", KimmeridgebrachypteraeschnidiumNymph::new, MobCategory.CREATURE, 0.5f, 0.5f);
    public static final RegistryObject<EntityType<Majungasaurus>> MAJUNGASAURUS = UP2Entities.registerLivingEntity("majungasaurus", Majungasaurus::new, MobCategory.CREATURE, 1.2f, 1.9f);
    public static final RegistryObject<EntityType<Megalania>> MEGALANIA = UP2Entities.registerLivingEntity("megalania", Megalania::new, MobCategory.CREATURE, 1.7f, 1.5f);
    public static final RegistryObject<EntityType<Stethacanthus>> STETHACANTHUS = UP2Entities.registerLivingEntity("stethacanthus", Stethacanthus::new, MobCategory.WATER_CREATURE, 0.7f, 0.7f);
    public static final RegistryObject<EntityType<Talpanas>> TALPANAS = UP2Entities.registerLivingEntity("talpanas", Talpanas::new, MobCategory.CREATURE, 0.7f, 0.9f);
    public static final RegistryObject<EntityType<Telecrex>> TELECREX = UP2Entities.registerLivingEntity("telecrex", Telecrex::new, MobCategory.CREATURE, 0.7f, 0.9f);
    public static final RegistryObject<EntityType<Unicorn>> UNICORN = UP2Entities.registerLivingEntity("unicorn", Unicorn::new, MobCategory.CREATURE, 1.2f, 2.9f);
    public static final RegistryObject<EntityType<ThrowableEgg>> DROMAEOSAURUS_EGG = UP2Entities.registerEntity("dromaeosaurus_egg", (entityType, level) -> new ThrowableEgg((EntityType<? extends ThrowableItemProjectile>)entityType, level, (Supplier<Item>)UP2Items.DROMAEOSAURUS_EGG, () -> DROMAEOSAURUS.get()), MobCategory.MISC, 0.25f, 0.25f);
    public static final RegistryObject<EntityType<ThrowableEgg>> TALPANAS_EGG = UP2Entities.registerEntity("talpanas_egg", (entityType, level) -> new ThrowableEgg((EntityType<? extends ThrowableItemProjectile>)entityType, level, (Supplier<Item>)UP2Items.TALPANAS_EGG, () -> TALPANAS.get()), MobCategory.MISC, 0.25f, 0.25f);
    public static final RegistryObject<EntityType<ThrowableEgg>> TELECREX_EGG = UP2Entities.registerEntity("telecrex_egg", (entityType, level) -> new ThrowableEgg((EntityType<? extends ThrowableItemProjectile>)entityType, level, (Supplier<Item>)UP2Items.TELECREX_EGG, () -> TELECREX.get()), MobCategory.MISC, 0.25f, 0.25f);
    public static final RegistryObject<EntityType<UP2Boat>> BOAT = UP2Entities.registerEntity("boat", UP2Boat::new, MobCategory.MISC, 1.375f, 0.5625f);
    public static final RegistryObject<EntityType<UP2ChestBoat>> CHEST_BOAT = UP2Entities.registerEntity("chest_boat", UP2ChestBoat::new, MobCategory.MISC, 1.375f, 0.5625f);
    public static final RegistryObject<EntityType<Onchopristis>> ONCHOPRISTIS = UP2Entities.registerLivingEntity("onchopristis", Onchopristis::new, MobCategory.WATER_CREATURE, 1.2f, 0.5f);
    public static final RegistryObject<EntityType<LivingOoze>> LIVING_OOZE = UP2Entities.registerLivingEntity("living_ooze", LivingOoze::new, MobCategory.CREATURE, 0.98f, 0.98f);
    public static final RegistryObject<EntityType<Metriorhynchus>> METRIORHYNCHUS = UP2Entities.registerLivingEntity("metriorhynchus", Metriorhynchus::new, MobCategory.CREATURE, 1.3f, 1.25f);
    public static final RegistryObject<EntityType<Tartuosteus>> TARTUOSTEUS = UP2Entities.registerLivingEntity("tartuosteus", Tartuosteus::new, MobCategory.WATER_CREATURE, 1.2f, 0.5f);
    public static final RegistryObject<EntityType<Brachiosaurus>> BRACHIOSAURUS = UP2Entities.registerLivingEntity("brachiosaurus", Brachiosaurus::new, MobCategory.CREATURE, 4.1f, 9.1f);
    public static final RegistryObject<EntityType<Coelacanthus>> COELACANTHUS = UP2Entities.registerLivingEntity("coelacanthus", Coelacanthus::new, MobCategory.WATER_CREATURE, 0.5f, 0.5f);
    public static final RegistryObject<EntityType<Hibbertopterus>> HIBBERTOPTERUS = UP2Entities.registerLivingEntity("hibbertopterus", Hibbertopterus::new, MobCategory.CREATURE, 2.6f, 1.7f);
    public static final RegistryObject<EntityType<Kaprosuchus>> KAPROSUCHUS = UP2Entities.registerLivingEntity("kaprosuchus", Kaprosuchus::new, MobCategory.CREATURE, 0.9f, 1.3f);
    public static final RegistryObject<EntityType<Leptictidium>> LEPTICTIDIUM = UP2Entities.registerLivingEntity("leptictidium", Leptictidium::new, MobCategory.CREATURE, 0.4f, 0.7f);
    public static final RegistryObject<EntityType<LobeFinnedFish>> LOBE_FINNED_FISH = UP2Entities.registerLivingEntity("lobe_finned_fish", LobeFinnedFish::new, MobCategory.WATER_AMBIENT, 0.5f, 0.8f);
    public static final RegistryObject<EntityType<Lystrosaurus>> LYSTROSAURUS = UP2Entities.registerLivingEntity("lystrosaurus", Lystrosaurus::new, MobCategory.CREATURE, 0.9f, 0.9f);
    public static final RegistryObject<EntityType<Pachycephalosaurus>> PACHYCEPHALOSAURUS = UP2Entities.registerLivingEntity("pachycephalosaurus", Pachycephalosaurus::new, MobCategory.CREATURE, 0.8f, 1.3f);
    public static final RegistryObject<EntityType<Praepusa>> PRAEPUSA = UP2Entities.registerLivingEntity("praepusa", Praepusa::new, MobCategory.CREATURE, 0.6f, 0.5f);
    public static final RegistryObject<EntityType<Pterodactylus>> PTERODACTYLUS = UP2Entities.registerLivingEntity("pterodactylus", Pterodactylus::new, MobCategory.CREATURE, 0.4f, 0.5f);
    public static final RegistryObject<EntityType<Ulughbegsaurus>> ULUGHBEGSAURUS = UP2Entities.registerLivingEntity("ulughbegsaurus", Ulughbegsaurus::new, MobCategory.CREATURE, 1.3f, 2.4f);
    public static final RegistryObject<EntityType<ThrowableEgg>> PTERODACTYLUS_EGG = UP2Entities.registerEntity("pterodactylus_egg", (entityType, level) -> new ThrowableEgg((EntityType<? extends ThrowableItemProjectile>)entityType, level, (Supplier<Item>)UP2Items.PTERODACTYLUS_EGG, () -> PTERODACTYLUS.get()), MobCategory.MISC, 0.25f, 0.25f);
    public static final RegistryObject<EntityType<Aegirocassis>> AEGIROCASSIS = UP2Entities.registerLivingEntity("aegirocassis", Aegirocassis::new, MobCategory.WATER_CREATURE, 4.1f, 4.1f);
    public static final RegistryObject<EntityType<Barinasuchus>> BARINASUCHUS = UP2Entities.registerLivingEntity("barinasuchus", Barinasuchus::new, MobCategory.CREATURE, 1.5f, 2.1f);
    public static final RegistryObject<EntityType<Cotylorhynchus>> COTYLORHYNCHUS = UP2Entities.registerLivingEntity("cotylorhynchus", Cotylorhynchus::new, MobCategory.CREATURE, 2.2f, 1.6f);
    public static final RegistryObject<EntityType<Delitzschala>> DELITZSCHALA = UP2Entities.registerLivingEntity("delitzschala", Delitzschala::new, MobCategory.AMBIENT, 0.4f, 0.1f);
    public static final RegistryObject<EntityType<Desmatosuchus>> DESMATOSUCHUS = UP2Entities.registerLivingEntity("desmatosuchus", Desmatosuchus::new, MobCategory.CREATURE, 1.3f, 1.2f);
    public static final RegistryObject<EntityType<Dimorphodon>> DIMORPHODON = UP2Entities.registerLivingEntity("dimorphodon", Dimorphodon::new, MobCategory.CREATURE, 0.9f, 0.9f);
    public static final RegistryObject<EntityType<Eryon>> ERYON = UP2Entities.registerLivingEntity("eryon", Eryon::new, MobCategory.CREATURE, 0.5f, 0.3f);
    public static final RegistryObject<EntityType<Mammoth>> MAMMOTH = UP2Entities.registerLivingEntity("mammoth", Mammoth::new, MobCategory.CREATURE, 3.2f, 5.2f);
    public static final RegistryObject<EntityType<Manipulator>> MANIPULATOR = UP2Entities.registerLivingEntity("manipulator", Manipulator::new, MobCategory.CREATURE, 1.5f, 1.9f);
    public static final RegistryObject<EntityType<Palaeophis>> PALAEOPHIS = UP2Entities.registerLivingEntity("palaeophis", Palaeophis::new, MobCategory.WATER_CREATURE, 1.8f, 1.25f);
    public static final RegistryObject<EntityType<Psilopterus>> PSILOPTERUS = UP2Entities.registerLivingEntity("psilopterus", Psilopterus::new, MobCategory.CREATURE, 0.6f, 1.4f);
    public static final RegistryObject<EntityType<Therizinosaurus>> THERIZINOSAURUS = UP2Entities.registerLivingEntity("therizinosaurus", Therizinosaurus::new, MobCategory.CREATURE, 2.2f, 5.4f);
    public static final RegistryObject<EntityType<Wonambi>> WONAMBI = UP2Entities.registerLivingEntity("wonambi", Wonambi::new, MobCategory.CREATURE, 1.25f, 0.5f);
    public static final RegistryObject<EntityType<Zhangsolva>> ZHANGSOLVA = UP2Entities.registerLivingEntity("zhangsolva", Zhangsolva::new, MobCategory.AMBIENT, 0.3f, 0.4f);
    public static final RegistryObject<EntityType<ThrowableEgg>> DIMORPHODON_EGG = UP2Entities.registerEntity("dimorphodon_egg", (entityType, level) -> new ThrowableEgg((EntityType<? extends ThrowableItemProjectile>)entityType, level, (Supplier<Item>)UP2Items.DIMORPHODON_EGG, () -> DIMORPHODON.get()), MobCategory.MISC, 0.25f, 0.25f);
    public static final RegistryObject<EntityType<ThrowableEgg>> PSILOPTERUS_EGG = UP2Entities.registerEntity("psilopterus_egg", (entityType, level) -> new ThrowableEgg((EntityType<? extends ThrowableItemProjectile>)entityType, level, (Supplier<Item>)UP2Items.PSILOPTERUS_EGG, () -> PSILOPTERUS.get()), MobCategory.MISC, 0.25f, 0.25f);

    private static <E extends LivingEntity> RegistryObject<EntityType<E>> registerLivingEntity(String name, EntityType.EntityFactory<E> factory, MobCategory entityClassification, float width, float height) {
        return ENTITY_TYPE.register(name, () -> UP2Entities.registerLivingEntity(factory, entityClassification, name, width, height));
    }

    private static <E extends Entity> RegistryObject<EntityType<E>> registerEntity(String name, EntityType.EntityFactory<E> factory, MobCategory entityClassification, float width, float height) {
        return ENTITY_TYPE.register(name, () -> UP2Entities.registerEntity(factory, entityClassification, name, width, height));
    }

    private static <E extends LivingEntity> EntityType<E> registerLivingEntity(EntityType.EntityFactory<E> factory, MobCategory entityClassification, String name, float width, float height) {
        ResourceLocation location = UnusualPrehistory2.modPrefix(name);
        return EntityType.Builder.m_20704_(factory, (MobCategory)entityClassification).m_20699_(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).m_20712_(location.toString());
    }

    private static <E extends Entity> EntityType<E> registerEntity(EntityType.EntityFactory<E> factory, MobCategory entityClassification, String name, float width, float height) {
        ResourceLocation location = UnusualPrehistory2.modPrefix(name);
        return EntityType.Builder.m_20704_(factory, (MobCategory)entityClassification).m_20699_(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).m_20712_(location.toString());
    }
}


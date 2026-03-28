/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.food.FoodProperties
 *  net.minecraft.world.item.BucketItem
 *  net.minecraft.world.item.HangingSignItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.MobBucketItem
 *  net.minecraft.world.item.Rarity
 *  net.minecraft.world.item.RecordItem
 *  net.minecraft.world.item.SignItem
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraftforge.common.ForgeSpawnEggItem
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.entity.mob.update_1.Diplocaulus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Dunkleosteus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.JawlessFish;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Coelacanthus;
import com.barlinc.unusual_prehistory.entity.mob.update_4.LobeFinnedFish;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Pterodactylus;
import com.barlinc.unusual_prehistory.entity.utils.UP2BoatType;
import com.barlinc.unusual_prehistory.items.EmbryoItem;
import com.barlinc.unusual_prehistory.items.KimmeridgebrachypteraeschnidiumBottleItem;
import com.barlinc.unusual_prehistory.items.LivingOozeBucketItem;
import com.barlinc.unusual_prehistory.items.PterodactylusPotItem;
import com.barlinc.unusual_prehistory.items.ThrowableEggItem;
import com.barlinc.unusual_prehistory.items.UP2BoatItem;
import com.barlinc.unusual_prehistory.items.UP2FoodOnAStickItem;
import com.barlinc.unusual_prehistory.items.UP2MobBucketItem;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Fluids;
import com.barlinc.unusual_prehistory.registry.UP2FoodValues;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.utils.VariantHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class UP2Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create((IForgeRegistry)ForgeRegistries.ITEMS, (String)"unusual_prehistory");
    public static List<RegistryObject<? extends Item>> ITEM_TRANSLATIONS = new ArrayList<RegistryObject<? extends Item>>();
    public static final List<Supplier<? extends Item>> EGG_EMBRYO_ITEMS = new ArrayList<Supplier<? extends Item>>();
    public static final List<Supplier<? extends Item>> FOSSILS = new ArrayList<Supplier<? extends Item>>();
    public static final RegistryObject<Item> CARNOTAURUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("carnotaurus", UP2Entities.CARNOTAURUS, 9187111, 2435891);
    public static final RegistryObject<Item> DIPLOCAULUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("diplocaulus", UP2Entities.DIPLOCAULUS, 15036958, 2697011);
    public static final RegistryObject<Item> DROMAEOSAURUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("dromaeosaurus", UP2Entities.DROMAEOSAURUS, 16382558, 15451988);
    public static final RegistryObject<Item> DUNKLEOSTEUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("dunkleosteus", UP2Entities.DUNKLEOSTEUS, 4688245, 6765877);
    public static final RegistryObject<Item> JAWLESS_FISH_SPAWN_EGG = UP2Items.registerSpawnEggItem("jawless_fish", UP2Entities.JAWLESS_FISH, 3223096, 9532296);
    public static final RegistryObject<Item> KENTROSAURUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("kentrosaurus", UP2Entities.KENTROSAURUS, 5924407, 1908504);
    public static final RegistryObject<Item> KIMMERIDGEBRACHYPTERAESCHNIDIUM_SPAWN_EGG = UP2Items.registerSpawnEggItem("kimmeridgebrachypteraeschnidium", UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM, 7653135, 9057382);
    public static final RegistryObject<Item> KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_SPAWN_EGG = UP2Items.registerSpawnEggItem("kimmeridgebrachypteraeschnidium_nymph", UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH, 3555359, 659974);
    public static final RegistryObject<Item> MAJUNGASAURUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("majungasaurus", UP2Entities.MAJUNGASAURUS, 5941278, 1658496);
    public static final RegistryObject<Item> MEGALANIA_SPAWN_EGG = UP2Items.registerSpawnEggItem("megalania", UP2Entities.MEGALANIA, 5194539, 1037542);
    public static final RegistryObject<Item> STETHACANTHUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("stethacanthus", UP2Entities.STETHACANTHUS, 7220767, 16753152);
    public static final RegistryObject<Item> TALPANAS_SPAWN_EGG = UP2Items.registerSpawnEggItem("talpanas", UP2Entities.TALPANAS, 5256487, 9678215);
    public static final RegistryObject<Item> TELECREX_SPAWN_EGG = UP2Items.registerSpawnEggItem("telecrex", UP2Entities.TELECREX, 920594, 9638725);
    public static final RegistryObject<Item> FURY_FOSSIL = UP2Items.registerFossilItem("fury");
    public static final RegistryObject<Item> BOOMERANG_FOSSIL = UP2Items.registerFossilItem("boomerang");
    public static final RegistryObject<Item> RUNNER_FOSSIL = UP2Items.registerFossilItem("runner");
    public static final RegistryObject<Item> GUILLOTINE_FOSSIL = UP2Items.registerFossilItem("guillotine");
    public static final RegistryObject<Item> JAWLESS_FOSSIL = UP2Items.registerFossilItem("jawless");
    public static final RegistryObject<Item> PRICKLY_FOSSIL = UP2Items.registerFossilItem("prickly");
    public static final RegistryObject<Item> IMPERATIVE_FOSSIL = UP2Items.registerFossilItem("imperative");
    public static final RegistryObject<Item> RUGOSE_FOSSIL = UP2Items.registerFossilItem("rugose");
    public static final RegistryObject<Item> THERMAL_FOSSIL = UP2Items.registerFossilItem("thermal");
    public static final RegistryObject<Item> ANVIL_FOSSIL = UP2Items.registerFossilItem("anvil");
    public static final RegistryObject<Item> AGED_FEATHER = UP2Items.registerItem("aged_feather", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLUMAGE_FOSSIL = UP2Items.registerFossilItem("plumage");
    public static final RegistryObject<Item> DROMAEOSAURUS_EGG = UP2Items.registerEggItem("dromaeosaurus", UP2Entities.DROMAEOSAURUS_EGG);
    public static final RegistryObject<Item> TALPANAS_EGG = UP2Items.registerEggItem("talpanas", UP2Entities.TALPANAS_EGG);
    public static final RegistryObject<Item> TELECREX_EGG = UP2Items.registerEggItem("telecrex", UP2Entities.TELECREX_EGG);
    public static final RegistryObject<Item> DIPLOCAULUS_BUCKET = UP2Items.registerItemNoLang("diplocaulus_bucket", () -> new UP2MobBucketItem((Supplier<? extends EntityType<?>>)UP2Entities.DIPLOCAULUS, (Fluid)Fluids.f_76193_, SoundEvents.f_11779_, new Item.Properties(), VariantHelper.nameOf(Diplocaulus.DiplocaulusVariant::byId)));
    public static final RegistryObject<Item> DUNKLEOSTEUS_BUCKET = UP2Items.registerItemNoLang("dunkleosteus_bucket", () -> new UP2MobBucketItem((Supplier<? extends EntityType<?>>)UP2Entities.DUNKLEOSTEUS, (Fluid)Fluids.f_76193_, SoundEvents.f_11779_, new Item.Properties(), VariantHelper.nameOf(Dunkleosteus.DunkleosteusVariant::byId)));
    public static final RegistryObject<Item> JAWLESS_FISH_BUCKET = UP2Items.registerItemNoLang("jawless_fish_bucket", () -> new UP2MobBucketItem((Supplier<? extends EntityType<?>>)UP2Entities.JAWLESS_FISH, (Fluid)Fluids.f_76193_, SoundEvents.f_11779_, new Item.Properties(), VariantHelper.nameOf(JawlessFish.JawlessFishVariant::byId)));
    public static final RegistryObject<Item> KIMMERIDGEBRACHYPTERAESCHNIDIUM_BOTTLE = UP2Items.registerItemNoLang("kimmeridgebrachypteraeschnidium_bottle", () -> new KimmeridgebrachypteraeschnidiumBottleItem(new Item.Properties()));
    public static final RegistryObject<Item> KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_BUCKET = UP2Items.registerItemNoLang("kimmeridgebrachypteraeschnidium_nymph_bucket", () -> new UP2MobBucketItem((Supplier<? extends EntityType<?>>)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH, (Fluid)Fluids.f_76193_, SoundEvents.f_11779_, new Item.Properties()));
    public static final RegistryObject<Item> STETHACANTHUS_BUCKET = UP2Items.registerItemNoLang("stethacanthus_bucket", () -> new MobBucketItem(UP2Entities.STETHACANTHUS, () -> Fluids.f_76193_, () -> SoundEvents.f_11779_, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> BENNETTITALES_FOSSIL = UP2Items.registerFossilItem("bennettitales");
    public static final RegistryObject<Item> CALAMOPHYTON_FOSSIL = UP2Items.registerFossilItem("calamophyton");
    public static final RegistryObject<Item> CLADOPHLEBIS_FOSSIL = UP2Items.registerFossilItem("cladophlebis");
    public static final RegistryObject<Item> COOKSONIA_FOSSIL = UP2Items.registerFossilItem("cooksonia");
    public static final RegistryObject<Item> LEEFRUCTUS_FOSSIL = UP2Items.registerFossilItem("leefructus");
    public static final RegistryObject<Item> QUILLWORT_FOSSIL = UP2Items.registerFossilItem("quillwort");
    public static final RegistryObject<Item> RAIGUENRAYUN_FOSSIL = UP2Items.registerFossilItem("raiguenrayun");
    public static final RegistryObject<Item> RHYNIA_FOSSIL = UP2Items.registerFossilItem("rhynia");
    public static final RegistryObject<Item> GINKGO_FOSSIL = UP2Items.registerFossilItem("ginkgo");
    public static final RegistryObject<Item> LEPIDODENDRON_FOSSIL = UP2Items.registerFossilItem("lepidodendron");
    public static final RegistryObject<Item> GINKGO_FRUIT = UP2Items.registerItem("ginkgo_fruit", () -> new Item(UP2Items.registerFoodValue(UP2FoodValues.GINKGO_FRUIT)));
    public static final RegistryObject<Item> GINKGO_SIGN = UP2Items.registerItem("ginkgo_sign", () -> new SignItem(new Item.Properties().m_41487_(16), (Block)UP2Blocks.GINKGO_SIGN.get(), (Block)UP2Blocks.GINKGO_WALL_SIGN.get()));
    public static final RegistryObject<Item> GINKGO_HANGING_SIGN = UP2Items.registerItem("ginkgo_hanging_sign", () -> new HangingSignItem((Block)UP2Blocks.GINKGO_HANGING_SIGN.get(), (Block)UP2Blocks.GINKGO_WALL_HANGING_SIGN.get(), new Item.Properties().m_41487_(16)));
    public static final RegistryObject<Item> GINKGO_BOAT = UP2Items.registerItem("ginkgo_boat", () -> new UP2BoatItem(false, UP2BoatType.Type.GINKGO, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> GINKGO_CHEST_BOAT = UP2Items.registerItemNoLang("ginkgo_chest_boat", () -> new UP2BoatItem(true, UP2BoatType.Type.GINKGO, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> LEPIDODENDRON_SIGN = UP2Items.registerItem("lepidodendron_sign", () -> new SignItem(new Item.Properties().m_41487_(16), (Block)UP2Blocks.LEPIDODENDRON_SIGN.get(), (Block)UP2Blocks.LEPIDODENDRON_WALL_SIGN.get()));
    public static final RegistryObject<Item> LEPIDODENDRON_HANGING_SIGN = UP2Items.registerItem("lepidodendron_hanging_sign", () -> new HangingSignItem((Block)UP2Blocks.LEPIDODENDRON_HANGING_SIGN.get(), (Block)UP2Blocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), new Item.Properties().m_41487_(16)));
    public static final RegistryObject<Item> LEPIDODENDRON_BOAT = UP2Items.registerItem("lepidodendron_boat", () -> new UP2BoatItem(false, UP2BoatType.Type.LEPIDODENDRON, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> LEPIDODENDRON_CHEST_BOAT = UP2Items.registerItemNoLang("lepidodendron_chest_boat", () -> new UP2BoatItem(true, UP2BoatType.Type.LEPIDODENDRON, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> UNUSUAL_PREHISTORY = UP2Items.registerItem("unusual_prehistory", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORGANIC_OOZE = UP2Items.registerItem("organic_ooze", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_PARTS = UP2Items.registerItem("machine_parts", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TAR_BUCKET = UP2Items.registerItem("tar_bucket", () -> new BucketItem((Fluid)UP2Fluids.TAR_FLUID_SOURCE.get(), new Item.Properties().m_41487_(1).m_41495_(Items.f_42446_)));
    public static final RegistryObject<Item> TARIFYING_DISC = UP2Items.registerItemNoLang("tarifying_disc", () -> new RecordItem(13, UP2SoundEvents.TARIFYING_DISC, new Item.Properties().m_41487_(1).m_41497_(Rarity.RARE), 5180));
    public static final RegistryObject<Item> ONCHOPRISTIS_SPAWN_EGG = UP2Items.registerSpawnEggItem("onchopristis", UP2Entities.ONCHOPRISTIS, 10649159, 3681054);
    public static final RegistryObject<Item> SAW_FOSSIL = UP2Items.registerFossilItem("saw");
    public static final RegistryObject<Item> DOOMSURF_DISC = UP2Items.registerItemNoLang("doomsurf_disc", () -> new RecordItem(15, UP2SoundEvents.DOOMSURF_DISC, new Item.Properties().m_41487_(1).m_41497_(Rarity.RARE), 3920));
    public static final RegistryObject<Item> MEGALANIA_DISC = UP2Items.registerItemNoLang("megalania_disc", () -> new RecordItem(14, UP2SoundEvents.MEGALANIA_DISC, new Item.Properties().m_41487_(1).m_41497_(Rarity.RARE), 1400));
    public static final RegistryObject<Item> LIVING_OOZE_SPAWN_EGG = UP2Items.registerSpawnEggItem("living_ooze", UP2Entities.LIVING_OOZE, 5364329, 351023);
    public static final RegistryObject<Item> METRIORHYNCHUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("metriorhynchus", UP2Entities.METRIORHYNCHUS, 3812430, 10315437);
    public static final RegistryObject<Item> TARTUOSTEUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("tartuosteus", UP2Entities.TARTUOSTEUS, 2320188, 730912);
    public static final RegistryObject<Item> MELTDOWN_FOSSIL = UP2Items.registerFossilItem("meltdown");
    public static final RegistryObject<Item> MOSSY_FOSSIL = UP2Items.registerFossilItem("mossy");
    public static final RegistryObject<Item> METRIORHYNCHUS_EMBRYO = UP2Items.registerEmbryoItem("metriorhynchus", UP2Entities.METRIORHYNCHUS);
    public static final RegistryObject<Item> LIVING_OOZE_BUCKET = UP2Items.registerItemNoLang("living_ooze_bucket", () -> new LivingOozeBucketItem(new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> BRACHIOSAURUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("brachiosaurus", UP2Entities.BRACHIOSAURUS, 2643589, 1318182);
    public static final RegistryObject<Item> COELACANTHUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("coelacanthus", UP2Entities.COELACANTHUS, 15366674, 10824980);
    public static final RegistryObject<Item> HIBBERTOPTERUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("hibbertopterus", UP2Entities.HIBBERTOPTERUS, 14988668, 6109743);
    public static final RegistryObject<Item> KAPROSUCHUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("kaprosuchus", UP2Entities.KAPROSUCHUS, 3810595, 16757596);
    public static final RegistryObject<Item> LEPTICTIDIUM_SPAWN_EGG = UP2Items.registerSpawnEggItem("leptictidium", UP2Entities.LEPTICTIDIUM, 11298630, 6896957);
    public static final RegistryObject<Item> LOBE_FINNED_FISH_SPAWN_EGG = UP2Items.registerSpawnEggItem("lobe_finned_fish", UP2Entities.LOBE_FINNED_FISH, 3702710, 3883909);
    public static final RegistryObject<Item> LYSTROSAURUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("lystrosaurus", UP2Entities.LYSTROSAURUS, 11181157, 6773315);
    public static final RegistryObject<Item> PACHYCEPHALOSAURUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("pachycephalosaurus", UP2Entities.PACHYCEPHALOSAURUS, 5193074, 6799067);
    public static final RegistryObject<Item> PRAEPUSA_SPAWN_EGG = UP2Items.registerSpawnEggItem("praepusa", UP2Entities.PRAEPUSA, 5132374, 0xCFCFC8);
    public static final RegistryObject<Item> PTERODACTYLUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("pterodactylus", UP2Entities.PTERODACTYLUS, 6507321, 16767843);
    public static final RegistryObject<Item> ULUGHBEGSAURUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("ulughbegsaurus", UP2Entities.ULUGHBEGSAURUS, 4338996, 4298977);
    public static final RegistryObject<Item> ARM_FOSSIL = UP2Items.registerFossilItem("arm");
    public static final RegistryObject<Item> GLUTTONOUS_FOSSIL = UP2Items.registerFossilItem("gluttonous");
    public static final RegistryObject<Item> PLOW_FOSSIL = UP2Items.registerFossilItem("plow");
    public static final RegistryObject<Item> BOAR_TOOTH_FOSSIL = UP2Items.registerFossilItem("boar_tooth");
    public static final RegistryObject<Item> TRUNK_MOUSE_FOSSIL = UP2Items.registerFossilItem("trunk_mouse");
    public static final RegistryObject<Item> FISH_FOSSIL = UP2Items.registerFossilItem("fish");
    public static final RegistryObject<Item> IMPERVIOUS_FOSSIL = UP2Items.registerFossilItem("impervious");
    public static final RegistryObject<Item> CRANIUM_FOSSIL = UP2Items.registerFossilItem("cranium");
    public static final RegistryObject<Item> FLIPPER_FOSSIL = UP2Items.registerFossilItem("flipper");
    public static final RegistryObject<Item> WING_FOSSIL = UP2Items.registerFossilItem("wing");
    public static final RegistryObject<Item> DUBIOUS_FOSSIL = UP2Items.registerFossilItem("dubious");
    public static final RegistryObject<Item> LEPTICTIDIUM_EMBRYO = UP2Items.registerEmbryoItem("leptictidium", UP2Entities.LEPTICTIDIUM);
    public static final RegistryObject<Item> PRAEPUSA_EMBRYO = UP2Items.registerEmbryoItem("praepusa", UP2Entities.PRAEPUSA);
    public static final RegistryObject<Item> PTERODACTYLUS_EGG = UP2Items.registerEggItem("pterodactylus", UP2Entities.PTERODACTYLUS_EGG);
    public static final RegistryObject<Item> COELACANTHUS_BUCKET = UP2Items.registerItemNoLang("coelacanthus_bucket", () -> new UP2MobBucketItem((Supplier<? extends EntityType<?>>)UP2Entities.COELACANTHUS, (Fluid)Fluids.f_76193_, SoundEvents.f_11779_, new Item.Properties().m_41487_(1), VariantHelper.nameOf(Coelacanthus.CoelacanthusVariant::byId)));
    public static final RegistryObject<Item> LOBE_FINNED_FISH_BUCKET = UP2Items.registerItemNoLang("lobe_finned_fish_bucket", () -> new UP2MobBucketItem((Supplier<? extends EntityType<?>>)UP2Entities.LOBE_FINNED_FISH, (Fluid)Fluids.f_76193_, SoundEvents.f_11779_, new Item.Properties().m_41487_(1), VariantHelper.nameOf(LobeFinnedFish.LobeFinnedFishVariant::byId)));
    public static final RegistryObject<Item> PRAEPUSA_BUCKET = UP2Items.registerItemNoLang("praepusa_bucket", () -> new UP2MobBucketItem((Supplier<? extends EntityType<?>>)UP2Entities.PRAEPUSA, (Fluid)Fluids.f_76193_, SoundEvents.f_11779_, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> PTERODACTYLUS_POT = UP2Items.registerItemNoLang("pterodactylus_pot", () -> new PterodactylusPotItem(new Item.Properties().m_41487_(1), VariantHelper.nameOf(Pterodactylus.PterodactylusVariant::byId)));
    public static final RegistryObject<Item> DIRT_ON_A_STICK = UP2Items.registerItemNoLang("dirt_on_a_stick", () -> new UP2FoodOnAStickItem(new Item.Properties().m_41503_(20), 4));
    public static final RegistryObject<Item> AETHOPHYLLUM_FOSSIL = UP2Items.registerFossilItem("aethophyllum");
    public static final RegistryObject<Item> BRACHYPHYLLUM_FOSSIL = UP2Items.registerFossilItem("brachyphyllum");
    public static final RegistryObject<Item> CYCAD_FOSSIL = UP2Items.registerFossilItem("cycad");
    public static final RegistryObject<Item> GUANGDEDENDRON_FOSSIL = UP2Items.registerFossilItem("guangdedendron");
    public static final RegistryObject<Item> NEOMARIOPTERIS_FOSSIL = UP2Items.registerFossilItem("neomariopteris");
    public static final RegistryObject<Item> PROTOTAXITES_FOSSIL = UP2Items.registerFossilItem("prototaxites");
    public static final RegistryObject<Item> TEMPSKYA_FOSSIL = UP2Items.registerFossilItem("tempskya");
    public static final RegistryObject<Item> METASEQUOIA_FOSSIL = UP2Items.registerFossilItem("metasequoia");
    public static final RegistryObject<Item> DRYOPHYLLUM_FOSSIL = UP2Items.registerFossilItem("dryophyllum");
    public static final RegistryObject<Item> DRYOPHYLLUM_SIGN = UP2Items.registerItem("dryophyllum_sign", () -> new SignItem(new Item.Properties().m_41487_(16), (Block)UP2Blocks.DRYOPHYLLUM_SIGN.get(), (Block)UP2Blocks.DRYOPHYLLUM_WALL_SIGN.get()));
    public static final RegistryObject<Item> DRYOPHYLLUM_HANGING_SIGN = UP2Items.registerItem("dryophyllum_hanging_sign", () -> new HangingSignItem((Block)UP2Blocks.DRYOPHYLLUM_HANGING_SIGN.get(), (Block)UP2Blocks.DRYOPHYLLUM_WALL_HANGING_SIGN.get(), new Item.Properties().m_41487_(16)));
    public static final RegistryObject<Item> DRYOPHYLLUM_BOAT = UP2Items.registerItem("dryophyllum_boat", () -> new UP2BoatItem(false, UP2BoatType.Type.DRYOPHYLLUM, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> DRYOPHYLLUM_CHEST_BOAT = UP2Items.registerItemNoLang("dryophyllum_chest_boat", () -> new UP2BoatItem(true, UP2BoatType.Type.DRYOPHYLLUM, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> METASEQUOIA_SIGN = UP2Items.registerItem("metasequoia_sign", () -> new SignItem(new Item.Properties().m_41487_(16), (Block)UP2Blocks.METASEQUOIA_SIGN.get(), (Block)UP2Blocks.METASEQUOIA_WALL_SIGN.get()));
    public static final RegistryObject<Item> METASEQUOIA_HANGING_SIGN = UP2Items.registerItem("metasequoia_hanging_sign", () -> new HangingSignItem((Block)UP2Blocks.METASEQUOIA_HANGING_SIGN.get(), (Block)UP2Blocks.METASEQUOIA_WALL_HANGING_SIGN.get(), new Item.Properties().m_41487_(16)));
    public static final RegistryObject<Item> METASEQUOIA_BOAT = UP2Items.registerItem("metasequoia_boat", () -> new UP2BoatItem(false, UP2BoatType.Type.METASEQUOIA, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> METASEQUOIA_CHEST_BOAT = UP2Items.registerItemNoLang("metasequoia_chest_boat", () -> new UP2BoatItem(true, UP2BoatType.Type.METASEQUOIA, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> PALEOPEDIA = UP2Items.registerItem("paleopedia", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AEGIROCASSIS_SPAWN_EGG = UP2Items.registerSpawnEggItem("aegirocassis", UP2Entities.AEGIROCASSIS, 26854, 1057620);
    public static final RegistryObject<Item> BARINASUCHUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("barinasuchus", UP2Entities.BARINASUCHUS, 2435858, 11377422);
    public static final RegistryObject<Item> DESMATOSUCHUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("desmatosuchus", UP2Entities.DESMATOSUCHUS, 2567486, 12220197);
    public static final RegistryObject<Item> DIMORPHODON_SPAWN_EGG = UP2Items.registerSpawnEggItem("dimorphodon", UP2Entities.DIMORPHODON, 0x35355A, 0xFFFFFF);
    public static final RegistryObject<Item> MANIPULATOR_SPAWN_EGG = UP2Items.registerSpawnEggItem("manipulator", UP2Entities.MANIPULATOR, 985615, 0x9C9C9C);
    public static final RegistryObject<Item> PSILOPTERUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("psilopterus", UP2Entities.PSILOPTERUS, 3223082, 14932687);
    public static final RegistryObject<Item> THERIZINOSAURUS_SPAWN_EGG = UP2Items.registerSpawnEggItem("therizinosaurus", UP2Entities.THERIZINOSAURUS, 1314839, 5326489);
    public static final RegistryObject<Item> BRISTLE_FOSSIL = UP2Items.registerFossilItem("bristle");
    public static final RegistryObject<Item> BRUTE_FOSSIL = UP2Items.registerFossilItem("brute");
    public static final RegistryObject<Item> FLAT_BACK_FOSSIL = UP2Items.registerFossilItem("flat_back");
    public static final RegistryObject<Item> BILL_FOSSIL = UP2Items.registerFossilItem("bill");
    public static final RegistryObject<Item> ROACH_FOSSIL = UP2Items.registerFossilItem("roach");
    public static final RegistryObject<Item> CROOKED_BEAK_FOSSIL = UP2Items.registerFossilItem("crooked_beak");
    public static final RegistryObject<Item> SCYTHE_FOSSIL = UP2Items.registerFossilItem("scythe");
    public static final RegistryObject<Item> DIMORPHODON_EGG = UP2Items.registerEggItem("dimorphodon", UP2Entities.DIMORPHODON_EGG);
    public static final RegistryObject<Item> PSILOPTERUS_EGG = UP2Items.registerEggItem("psilopterus", UP2Entities.PSILOPTERUS_EGG);
    public static final RegistryObject<Item> BABY_AEGIROCASSIS_BUCKET = UP2Items.registerItemNoLang("baby_aegirocassis_bucket", () -> new MobBucketItem(UP2Entities.AEGIROCASSIS, () -> Fluids.f_76193_, () -> SoundEvents.f_11779_, new Item.Properties().m_41487_(1)));
    public static final RegistryObject<Item> PETRIFIED_LUCA = UP2Items.registerItemNoLang("petrified_luca", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LUCA = UP2Items.registerItemNoLang("luca", () -> new Item(new Item.Properties()));

    private static <I extends Item> RegistryObject<I> registerItem(String name, Supplier<? extends I> supplier) {
        RegistryObject item = ITEMS.register(name, supplier);
        ITEM_TRANSLATIONS.add((RegistryObject<? extends Item>)item);
        return item;
    }

    private static RegistryObject<Item> registerEggItem(String name, Supplier<? extends EntityType<?>> entityType) {
        RegistryObject<Item> item = UP2Items.registerItem(name + "_egg", () -> new ThrowableEggItem(new Item.Properties().m_41487_(16), entityType));
        EGG_EMBRYO_ITEMS.add((Supplier<? extends Item>)item);
        return item;
    }

    private static RegistryObject<Item> registerEmbryoItem(String name, Supplier<? extends EntityType<?>> entityType) {
        RegistryObject<Item> item = UP2Items.registerItem(name + "_embryo", () -> new EmbryoItem(new Item.Properties(), entityType));
        EGG_EMBRYO_ITEMS.add((Supplier<? extends Item>)item);
        return item;
    }

    private static <I extends Item> RegistryObject<I> registerItemNoLang(String name, Supplier<? extends I> supplier) {
        return ITEMS.register(name, supplier);
    }

    private static RegistryObject<Item> registerSpawnEggItem(String name, Supplier<? extends EntityType<? extends Mob>> type, int baseColor, int spotColor) {
        return UP2Items.registerItem(name + "_spawn_egg", () -> new ForgeSpawnEggItem(type, baseColor, spotColor, new Item.Properties()));
    }

    private static RegistryObject<Item> registerFossilItem(String name) {
        RegistryObject<Item> item = UP2Items.registerItem(name + "_fossil", () -> new Item(new Item.Properties()));
        FOSSILS.add((Supplier<? extends Item>)item);
        return item;
    }

    public static Item.Properties registerFoodValue(FoodProperties food) {
        return new Item.Properties().m_41489_(food);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.item.CreativeModeTab
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.block.Block
 *  net.minecraftforge.common.data.LanguageProvider
 *  net.minecraftforge.data.event.GatherDataEvent
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 *  org.apache.commons.lang3.text.WordUtils
 *  org.codehaus.plexus.util.StringUtils
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.UnusualPrehistory2Tab;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2MobEffects;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.utils.UP2TextUtils;
import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.text.WordUtils;
import org.codehaus.plexus.util.StringUtils;

public class UP2LanguageProvider
extends LanguageProvider {
    public UP2LanguageProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), "unusual_prehistory", "en_us");
    }

    protected void addTranslations() {
        this.creativeTab((CreativeModeTab)UnusualPrehistory2Tab.UNUSUAL_PREHISTORY_2_TAB.get(), "Unusual Prehistory");
        UP2Blocks.BLOCK_TRANSLATIONS.forEach(this::forBlock);
        UP2Items.ITEM_TRANSLATIONS.forEach(this::forItem);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.AEGIROCASSIS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.BARINASUCHUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.BRACHIOSAURUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.CARNOTAURUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.COELACANTHUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.DESMATOSUCHUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.DIMORPHODON);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.DIPLOCAULUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.DROMAEOSAURUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.DUNKLEOSTEUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.HIBBERTOPTERUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.JAWLESS_FISH);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.KAPROSUCHUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.KENTROSAURUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.LEPTICTIDIUM);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.LOBE_FINNED_FISH);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.LYSTROSAURUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.MAJUNGASAURUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.MANIPULATOR);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.MEGALANIA);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.METRIORHYNCHUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.ONCHOPRISTIS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.PACHYCEPHALOSAURUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.PRAEPUSA);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.PSILOPTERUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.PTERODACTYLUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.STETHACANTHUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.TALPANAS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.TARTUOSTEUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.TELECREX);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.THERIZINOSAURUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.ULUGHBEGSAURUS);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.UNICORN);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.DIMORPHODON_EGG);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.DROMAEOSAURUS_EGG);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.PSILOPTERUS_EGG);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.PTERODACTYLUS_EGG);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.TALPANAS_EGG);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.TELECREX_EGG);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.LIVING_OOZE);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.BOAT);
        this.addEntityType((Supplier)UP2Entities.CHEST_BOAT, "Boat with Chest");
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.DELITZSCHALA);
        this.forEntity((Supplier<? extends EntityType<?>>)UP2Entities.ZHANGSOLVA);
        this.addItem((Supplier)UP2Items.PETRIFIED_LUCA, "Petrified L.U.C.A");
        this.addItem((Supplier)UP2Items.LUCA, "L.U.C.A");
        this.addItem((Supplier)UP2Items.DIRT_ON_A_STICK, "Dirt on a Stick");
        this.addItem((Supplier)UP2Items.DRYOPHYLLUM_CHEST_BOAT, "Dryophyllum Boat with Chest");
        this.addItem((Supplier)UP2Items.GINKGO_CHEST_BOAT, "Ginkgo Boat with Chest");
        this.addItem((Supplier)UP2Items.LEPIDODENDRON_CHEST_BOAT, "Lepidodendron Boat with Chest");
        this.addItem((Supplier)UP2Items.METASEQUOIA_CHEST_BOAT, "Metasequoia Boat with Chest");
        this.addItem((Supplier)UP2Items.BABY_AEGIROCASSIS_BUCKET, "Bucket of Baby Aegirocassis");
        this.addItem((Supplier)UP2Items.COELACANTHUS_BUCKET, "Bucket of Coelacanthus");
        this.addItem((Supplier)UP2Items.DIPLOCAULUS_BUCKET, "Bucket of Diplocaulus");
        this.addItem((Supplier)UP2Items.DUNKLEOSTEUS_BUCKET, "Bucket of Dunkleosteus");
        this.addItem((Supplier)UP2Items.JAWLESS_FISH_BUCKET, "Bucket of Jawless Fish");
        this.addItem((Supplier)UP2Items.KIMMERIDGEBRACHYPTERAESCHNIDIUM_BOTTLE, "Bottle of Kimmeridgebrachypteraeschnidium");
        this.addItem((Supplier)UP2Items.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_BUCKET, "Bucket of Kimmeridgebrachypteraeschnidium Nymph");
        this.addItem((Supplier)UP2Items.LIVING_OOZE_BUCKET, "Bucket of Living Ooze");
        this.addItem((Supplier)UP2Items.LOBE_FINNED_FISH_BUCKET, "Bucket of Lobe Finned Fish");
        this.addItem((Supplier)UP2Items.PRAEPUSA_BUCKET, "Bucket of Praepusa");
        this.addItem((Supplier)UP2Items.STETHACANTHUS_BUCKET, "Bucket of Stethacanthus");
        this.addItem((Supplier)UP2Items.PTERODACTYLUS_POT, "Pot of Pterodactylus");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TAR_POP, "Tar pops");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.AEGIROCASSIS_HURT, "Aegirocassis hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.AEGIROCASSIS_DEATH, "Aegirocassis dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.AEGIROCASSIS_IDLE, "Aegirocassis rumbles");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.AEGIROCASSIS_HOVER, "Aegirocassis tries to fly");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BARINASUCHUS_HURT, "Barinasuchus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BARINASUCHUS_DEATH, "Barinasuchus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BARINASUCHUS_IDLE, "Barinasuchus grumbles");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BARINASUCHUS_ATTACK, "Barinasuchus snaps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BARINASUCHUS_THREATEN, "Barinasuchus rumbles");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BRACHIOSAURUS_HURT, "Brachiosaurus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BRACHIOSAURUS_DEATH, "Brachiosaurus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BRACHIOSAURUS_IDLE, "Brachiosaurus rumbles");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BRACHIOSAURUS_ATTACK, "Brachiosaurus attacks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BRACHIOSAURUS_STEP, "Brachiosaurus stomps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BRACHIOSAURUS_CALL, "Brachiosaurus calls");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.CARNOTAURUS_STEP, "Carnotaurus steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.CARNOTAURUS_HURT, "Carnotaurus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.CARNOTAURUS_DEATH, "Carnotaurus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.CARNOTAURUS_IDLE, "Carnotaurus grumbles");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.CARNOTAURUS_SNIFF, "Carnotaurus sniffs");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.CARNOTAURUS_BITE, "Carnotaurus bites");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.CARNOTAURUS_CHARGE, "Carnotaurus charges");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.CARNOTAURUS_HEADBUTT, "Carnotaurus headbutts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.CARNOTAURUS_ROAR, "Carnotaurus roars");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DESMATOSUCHUS_HURT, "Desmatosuchus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DESMATOSUCHUS_DEATH, "Desmatosuchus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DESMATOSUCHUS_IDLE, "Desmatosuchus groans");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DESMATOSUCHUS_STEP, "Desmatosuchus steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DIMORPHODON_HURT, "Dimorphodon hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DIMORPHODON_DEATH, "Dimorphodon dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DIMORPHODON_IDLE, "Dimorphodon chatters");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DIPLOCAULUS_HURT, "Diplocaulus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DIPLOCAULUS_DEATH, "Diplocaulus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DIPLOCAULUS_IDLE, "Diplocaulus croaks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DIPLOCAULUS_STEP, "Diplocaulus steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DROMAEOSAURUS_HURT, "Dromaeosaurus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DROMAEOSAURUS_DEATH, "Dromaeosaurus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DROMAEOSAURUS_IDLE, "Dromaeosaurus chatters");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DROMAEOSAURUS_EEPY, "Dromaeosaurus snores");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DUNKLEOSTEUS_HURT, "Dunkleosteus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DUNKLEOSTEUS_DEATH, "Dunkleosteus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DUNKLEOSTEUS_FLOP, "Dunkleosteus flops");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.SMALL_DUNKLEOSTEUS_BITE, "Dunkleosteus nibbles");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MEDIUM_DUNKLEOSTEUS_BITE, "Dunkleosteus chomps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LARGE_DUNKLEOSTEUS_BITE, "Dunkleosteus crushes");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.HIBBERTOPTERUS_HURT, "Hibbertopterus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.HIBBERTOPTERUS_DEATH, "Hibbertopterus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.HIBBERTOPTERUS_IDLE, "Hibbertopterus rattles");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.HIBBERTOPTERUS_STEP, "Hibbertopterus steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.COELACANTHUS_DEATH, "Coelacanthus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.COELACANTHUS_HURT, "Coelacanthus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.COELACANTHUS_FLOP, "Coelacanthus flops");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.JAWLESS_FISH_HURT, "Jawless Fish hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.JAWLESS_FISH_DEATH, "Jawless Fish dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.JAWLESS_FISH_FLOP, "Jawless Fish flops");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KAPROSUCHUS_HURT, "Kaprosuchus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KAPROSUCHUS_DEATH, "Kaprosuchus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KAPROSUCHUS_IDLE, "Kaprosuchus hisses");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KENTROSAURUS_HURT, "Kentrosaurus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KENTROSAURUS_DEATH, "Kentrosaurus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KENTROSAURUS_IDLE, "Kentrosaurus groans");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KENTROSAURUS_STEP, "Kentrosaurus steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KIMMERIDGEBRACHYPTERAESCHNIDIUM_HURT, "Kimmeridgebrachypteraeschnidium hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KIMMERIDGEBRACHYPTERAESCHNIDIUM_DEATH, "Kimmeridgebrachypteraeschnidium dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KIMMERIDGEBRACHYPTERAESCHNIDIUM_LOOP, "Kimmeridgebrachypteraeschnidium buzzes");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_HURT, "Kimmeridgebrachypteraeschnidium Nymph hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_DEATH, "Kimmeridgebrachypteraeschnidium Nymph dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LEPTICTIDIUM_HURT, "Leptictidium hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LEPTICTIDIUM_DEATH, "Leptictidium dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LEPTICTIDIUM_IDLE, "Leptictidium squeaks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LYSTROSAURUS_HURT, "Lystrosaurus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LYSTROSAURUS_DEATH, "Lystrosaurus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LYSTROSAURUS_IDLE, "Lystrosaurus oinks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LYSTROSAURUS_STEP, "Lystrosaurus steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LYSTROSAURUS_CHAINSMOKER, "Lystrosaurus coughs");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MAJUNGASAURUS_HURT, "Majungasaurus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MAJUNGASAURUS_DEATH, "Majungasaurus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MAJUNGASAURUS_IDLE, "Majungasaurus groans");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MAJUNGASAURUS_ATTACK, "Majungasaurus bites");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MAJUNGASAURUS_SNIFF, "Majungasaurus sniffs");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MAJUNGASAURUS_STEP, "Majungasaurus steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MANIPULATOR_HURT, "Manipulator hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MANIPULATOR_DEATH, "Manipulator dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MANIPULATOR_IDLE, "Manipulator chatters");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MANIPULATOR_STEP, "Manipulator steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MANIPULATOR_ATTACK_VOCAL, "Manipulator prepares attack");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MANIPULATOR_ATTACK_SLASH, "Manipulator slashes");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MEGALANIA_HURT, "Megalania hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MEGALANIA_DEATH, "Megalania dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MEGALANIA_IDLE, "Megalania hisses");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MEGALANIA_ROAR, "Megalania roars");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MEGALANIA_STEP, "Megalania steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MEGALANIA_TAIL_SWING, "Megalania swings tail");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MEGALANIA_BITE, "Megalania bites");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MEGALANIA_JUMPSCARE, "Megalania jumpscares");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.METRIORHYNCHUS_HURT, "Metriorhynchus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.METRIORHYNCHUS_DEATH, "Metriorhynchus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.METRIORHYNCHUS_IDLE, "Metriorhynchus hisses");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.METRIORHYNCHUS_BITE, "Metriorhynchus bites");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.METRIORHYNCHUS_BELLOW, "Metriorhynchus bellows");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.ONCHOPRISTIS_HURT, "Onchopristis hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.ONCHOPRISTIS_DEATH, "Onchopristis dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.ONCHOPRISTIS_FLOP, "Onchopristis flops");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PACHYCEPHALOSAURUS_HURT, "Pachycephalosaurus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PACHYCEPHALOSAURUS_DEATH, "Pachycephalosaurus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PACHYCEPHALOSAURUS_IDLE, "Pachycephalosaurus grunts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PACHYCEPHALOSAURUS_WARN, "Pachycephalosaurus warns");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PACHYCEPHALOSAURUS_STEP, "Pachycephalosaurus steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PACHYCEPHALOSAURUS_BONK, "Pachycephalosaurus bonks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PRAEPUSA_HURT, "Praepusa hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PRAEPUSA_DEATH, "Praepusa dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PRAEPUSA_IDLE, "Praepusa honks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PRAEPUSA_MITOSIS, "Praepusa mitoses");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PRAEPUSA_BOUNCE, "Praepusa bounces");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PSILOPTERUS_HURT, "Psilopterus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PSILOPTERUS_DEATH, "Psilopterus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PSILOPTERUS_IDLE, "Psilopterus squawks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PSILOPTERUS_ATTACK, "Psilopterus attacks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PSILOPTERUS_BITE, "Psilopterus bites");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PSILOPTERUS_CALL, "Psilopterus calls");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PTERODACTYLUS_HURT, "Pterodactylus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PTERODACTYLUS_DEATH, "Pterodactylus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.PTERODACTYLUS_IDLE, "Pterodactylus chirps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.STETHACANTHUS_HURT, "Stethacanthus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.STETHACANTHUS_DEATH, "Stethacanthus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.STETHACANTHUS_FLOP, "Stethacanthus flops");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.STETHACANTHUS_BITE, "Stethacanthus chomps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TALPANAS_HURT, "Talpanas hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TALPANAS_DEATH, "Talpanas dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TALPANAS_IDLE, "Talpanas quacks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TELECREX_HURT, "Telecrex hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TELECREX_DEATH, "Telecrex dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TELECREX_IDLE, "Telecrex squawks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.THERIZINOSAURUS_HURT, "Therizinosaurus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.THERIZINOSAURUS_DEATH, "Therizinosaurus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.THERIZINOSAURUS_IDLE, "Therizinosaurus squawks");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.THERIZINOSAURUS_ATTACK, "Therizinosaurus slices");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.THERIZINOSAURUS_STEP, "Therizinosaurus steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.THERIZINOSAURUS_ROAR, "Therizinosaurus screams");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.THERIZINOSAURUS_NOTICE, "Therizinosaurus takes notice");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.ULUGHBEGSAURUS_HURT, "Ulughbegsaurus hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.ULUGHBEGSAURUS_DEATH, "Ulughbegsaurus dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.ULUGHBEGSAURUS_IDLE, "Ulughbegsaurus groans");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.ULUGHBEGSAURUS_ATTACK, "Ulughbegsaurus bites");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.ULUGHBEGSAURUS_STEP, "Ulughbegsaurus steps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.UNICORN_HURT, "Unicorn hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.UNICORN_DEATH, "Unicorn dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.UNICORN_IDLE, "Unicorn grunts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LIVING_OOZE_HURT, "Living Ooze hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LIVING_OOZE_DEATH, "Living Ooze dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LIVING_OOZE_SQUISH, "Living Ooze squishes");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LIVING_OOZE_JUMP, "Living Ooze jumps");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.LIVING_OOZE_SPIT, "Living Ooze spits");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TRANSMOGRIFIER_LOOP, "Transmogrifying");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TRANSMOGRIFIER_START, "Transmogrifier starts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TRANSMOGRIFIER_STOP, "Transmogrifier stops");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.DOOMSURF_DISC, "Music Disc");
        this.musicDisc((Supplier<? extends Item>)UP2Items.DOOMSURF_DISC, "ChipsTheCat - Doomsurf");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.MEGALANIA_DISC, "Music Disc");
        this.musicDisc((Supplier<? extends Item>)UP2Items.MEGALANIA_DISC, "ValiantEnvoy - MEGALANIA");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.TARIFYING_DISC, "Music Disc");
        this.musicDisc((Supplier<? extends Item>)UP2Items.TARIFYING_DISC, "Dylanvhs - Tarifying");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BUG_HURT, "Bug hurts");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BUG_DEATH, "Bug dies");
        this.sound((Supplier<? extends SoundEvent>)UP2SoundEvents.BUG_BUZZ, "Bug buzzes");
        this.translateAdvancement("root", "Unusual Prehistory 2", "Revive creatures from the ancient past!");
        this.translateAdvancement("paleozoic_root", "Paleozoic Era", "Paleozoic era creatures");
        this.translateAdvancement("mesozoic_root", "Mesozoic Era", "Mesozoic era creatures");
        this.translateAdvancement("triassic_root", "Triassic Period", "Triassic period creatures");
        this.translateAdvancement("jurassic_root", "Jurassic Period", "Jurassic period creatures");
        this.translateAdvancement("cretaceous_root", "Cretaceous Period", "Cretaceous period creatures");
        this.translateAdvancement("cenozoic_root", "Cenozoic Era", "Cenozoic era creatures");
        this.translateAdvancement("holocene_root", "Holocene Epoch", "Holocene epoch creatures");
        this.translateAdvancement("revive_all_mobs", "Unusual Prehistorian", "Revive all known prehistoric creatures");
        this.translateAdvancement("revive_aegirocassis", "Vessel of God", "Revive an Aegirocassis");
        this.translateAdvancement("revive_barinasuchus", "Croc and Roll", "Revive a Barinasuchus");
        this.translateAdvancement("revive_brachiosaurus", "Time of the Titans", "Revive a Brachiosaurus");
        this.translateAdvancement("revive_carnotaurus", "Endless Fury", "Revive a Carnotaurus");
        this.translateAdvancement("revive_coelacanthus", "Fishy", "Revive a Coelacanthus");
        this.translateAdvancement("revive_desmatosuchus", "Flat Back", "Revive a Desmatosuchus");
        this.translateAdvancement("revive_dimorphodon", "Up Up and Away!", "Revive a Dimorphodon");
        this.translateAdvancement("revive_diplocaulus", "Comes Right Back", "Revive a Diplocaulus");
        this.translateAdvancement("revive_dromaeosaurus", "Dino Run", "Revive a Dromaeosaurus");
        this.translateAdvancement("revive_dunkleosteus", "Definitely Not a Shark", "Revive a Dunkleosteus");
        this.translateAdvancement("revive_hibbertopterus", "No Thoughts, Head Empty", "Revive a Hibbertopterus");
        this.translateAdvancement("revive_jawless_fish", "No Chewing For You", "Revive a Jawless Fish");
        this.translateAdvancement("revive_kaprosuchus", "Boar Croc", "Revive a Kaprosuchus");
        this.translateAdvancement("revive_kentrosaurus", "Extra Pointy!", "Revive a Kentrosaurus");
        this.translateAdvancement("revive_kimmeridgebrachypteraeschnidium", "The man on the street will not be able to remember this.", "Revive a Kimmeridgebrachypteraeschnidium");
        this.translateAdvancement("revive_leptictidium", "Plague Carriers", "Revive a Leptictidium");
        this.translateAdvancement("revive_lobe_finned_fish", "Shark Bait, Hoo Ha Ha!", "Revive a Lobe Finned Fish");
        this.translateAdvancement("revive_lystrosaurus", "Survivalist", "Revive a Lystrosaurus");
        this.translateAdvancement("revive_majungasaurus", "Camouflaging Cannibal", "Revive a Majungasaurus");
        this.translateAdvancement("revive_manipulator", "Mandibles", "Revive a Manipulator");
        this.translateAdvancement("revive_megalania", "The Giant Goanna", "Revive a Megalania");
        this.translateAdvancement("revive_metriorhynchus", "The Meltdown", "Revive a Metriorhynchus");
        this.translateAdvancement("revive_onchopristis", "Cretaceous Chainsaw Massacre", "Revive an Onchopristis");
        this.translateAdvancement("revive_pachycephalosaurus", "Thick-Headed", "Revive a Pachycephalosaurus");
        this.translateAdvancement("revive_praepusa", "Cumulative Cuteness", "Revive a Praepusa");
        this.translateAdvancement("revive_psilopterus", "Clever Girl", "Revive a Psilopterus");
        this.translateAdvancement("revive_pterodactylus", "Honey I Shrunk the Pterosaur", "Revive a Pterodactylus");
        this.translateAdvancement("revive_stethacanthus", "Not Quite a Shark", "Revive a Stethacanthus");
        this.translateAdvancement("revive_talpanas", "Blind as a Duck", "Revive a Talpanas");
        this.translateAdvancement("revive_tartuosteus", "Thinkin\u2019 Bout Moss Balls", "Revive a Tartuosteus");
        this.translateAdvancement("revive_telecrex", "From a Singular Femur", "Revive a Telecrex");
        this.translateAdvancement("revive_therizinosaurus", "Tickle Chicken", "Revive a Therizinosaurus");
        this.translateAdvancement("revive_ulughbegsaurus", "How Do You Pronounce That?", "Revive an Ulughbegsaurus");
        this.translateAdvancement("pacify_mob", "Chill Pill", "Feed an Enchanted Golden Apple to an aggressive creature to make it permanently neutral");
        this.translateAdvancement("breed_holocene_mobs", "Repopulation!", "Breed a pair of Holocene animals");
        this.translateAdvancement("obtain_fossil", "Rock and Bone", "Use a Brush to uncover fossils at a Fossil Site or Tar Pit");
        this.translateAdvancement("obtain_holocene_remains", "Not So Ancient", "Find the remains of a recently extinct creature");
        this.translateAdvancement("obtain_machine_parts", "Electrical Doodads", "Find some Machine Parts in a loot chest");
        this.translateAdvancement("obtain_transmogrifier", "Jesse, We Have to Cook", "Craft a Transmogrifier, the key component in creature revival");
        this.translateAdvancement("obtain_organic_ooze", "It's Looking at Me...", "Craft some Organic Ooze to fuel the revival process");
        this.translateAdvancement("obtain_egg", "E G G S", "Recreate your first prehistoric egg or embryo");
        this.translateAdvancement("obtain_living_ooze", "Alakagoo!", "Create a Living Ooze in a cauldron to incubate embryos with");
        this.translateEffect(UP2MobEffects.FURY, "Gain increased speed and attack speed as your health gets lower");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_0", "Black Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_1", "Blue Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_2", "Brown Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_3", "Cyan Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_4", "Gray Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_5", "Green Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_6", "Light Blue Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_7", "Light Gray Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_8", "Lime Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_9", "Magenta Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_10", "Orange Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_11", "Pink Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_12", "Purple Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_13", "Red Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_14", "White Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_15", "Yellow Body");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_0", "Black Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_1", "Blue Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_2", "Brown Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_3", "Cyan Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_4", "Gray Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_5", "Green Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_6", "Light Blue Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_7", "Light Gray Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_8", "Lime Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_9", "Magenta Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_10", "Orange Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_11", "Pink Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_12", "Purple Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_13", "Red Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_14", "White Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_15", "Yellow Wings");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_0", "Black");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_1", "Blue");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_2", "Brown");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_3", "Cyan");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_4", "Gray");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_5", "Green");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_6", "Light Blue");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_7", "Light Gray");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_8", "Lime");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_9", "Magenta");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_10", "Orange");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_11", "Pink");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_12", "Purple");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_13", "Red");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_14", "White");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_15", "Yellow");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_stripe", "Stripes");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_tailshade", "Tail");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_topshade", "Back");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_halfshade", "Duality");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_large_stripe", "Large Stripes");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_racing_stripe", "Racing Stripe");
        this.add("entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_large_racing_stripe", "Large Racing Stripe");
        this.add("entity.unusual_prehistory.jawless_fish.variant_arandaspis", "Arandaspis");
        this.add("entity.unusual_prehistory.jawless_fish.variant_cephalaspis", "Cephalaspis");
        this.add("entity.unusual_prehistory.jawless_fish.variant_doryaspis", "Doryaspis");
        this.add("entity.unusual_prehistory.jawless_fish.variant_furcacauda", "Furcacauda");
        this.add("entity.unusual_prehistory.jawless_fish.variant_sacabambaspis", "Sacabambaspis");
        this.add("entity.unusual_prehistory.diplocaulus.variant_brevirostris", "D. brevirostris");
        this.add("entity.unusual_prehistory.diplocaulus.variant_magnicornis", "D. magnicornis");
        this.add("entity.unusual_prehistory.diplocaulus.variant_recurvatis", "D. recurvatis");
        this.add("entity.unusual_prehistory.diplocaulus.variant_salamandroides", "D. salamandroides");
        this.add("entity.unusual_prehistory.dunkleosteus.variant_raveri", "D. raveri");
        this.add("entity.unusual_prehistory.dunkleosteus.variant_marsaisi", "D. marsaisi");
        this.add("entity.unusual_prehistory.dunkleosteus.variant_terrelli", "D. terrelli");
        this.add("entity.unusual_prehistory.lobe_finned_fish.variant_allenypterus", "Allenypterus");
        this.add("entity.unusual_prehistory.lobe_finned_fish.variant_eusthenopteron", "Eusthenopteron");
        this.add("entity.unusual_prehistory.lobe_finned_fish.variant_gooloogongia", "Gooloogongia");
        this.add("entity.unusual_prehistory.lobe_finned_fish.variant_laccognathus", "Laccognathus");
        this.add("entity.unusual_prehistory.lobe_finned_fish.variant_scaumenacia", "Scaumenacia");
        this.add("entity.unusual_prehistory.pterodactylus.variant_brown", "Brown");
        this.add("entity.unusual_prehistory.pterodactylus.variant_banana", "Banana");
        this.add("entity.unusual_prehistory.coelacanthus.variant_fishy", "Fishy");
        this.add("entity.unusual_prehistory.coelacanthus.variant_golden", "Golden");
        this.add("entity.unusual_prehistory.coelacanthus.variant_lilac", "Lilac");
        this.add("entity.unusual_prehistory.coelacanthus.variant_peach", "Peach");
        this.add("entity.unusual_prehistory.coelacanthus.variant_rose", "Rose");
        this.add("entity.unusual_prehistory.coelacanthus.variant_silver", "Silver");
        this.add("entity.unusual_prehistory.coelacanthus.variant_blue", "Blue");
        this.add("entity.unusual_prehistory.coelacanthus.size", "Size: %s");
        this.add("unusual_prehistory.jei.transmogrification", "Transmogrification");
        this.add("item.unusual_prehistory.paleopedia.desc", "By Dr. Professor Peeko Noneyah Jr., PhD.");
        this.add("entity.unusual_prehistory.all.command_0", "%s is wandering");
        this.add("entity.unusual_prehistory.all.command_1", "%s is staying");
        this.add("entity.unusual_prehistory.all.command_2", "%s is following");
        this.add("unusual_prehistory.patchouli.book.name", "Paleopedia");
        this.add("unusual_prehistory.patchouli.book.landing", "This book acts as a guide to the revival process of various ancient plants and animals, along with any notable traits or uses that they may have.");
        this.add("death.attack.unusual_prehistory.execute", "%s was executed by %s");
    }

    private void forBlock(Supplier<? extends Block> block) {
        this.addBlock(block, UP2TextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey((Object)block.get())).m_135815_()));
    }

    private void forItem(Supplier<? extends Item> item) {
        this.addItem(item, UP2TextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey((Object)item.get())).m_135815_()));
    }

    private void forEntity(Supplier<? extends EntityType<?>> entity) {
        this.addEntityType(entity, UP2TextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.get())).m_135815_()));
    }

    private String format(ResourceLocation registryName) {
        return WordUtils.capitalizeFully((String)registryName.m_135815_().replace("_", " "));
    }

    protected void painting(String name, String author) {
        this.add("painting.unusual_prehistory." + name + ".title", UP2TextUtils.createTranslation(name));
        this.add("painting.unusual_prehistory." + name + ".author", author);
    }

    protected void musicDisc(Supplier<? extends Item> item, String description) {
        String disc = item.get().m_5524_();
        this.add(disc, "Music Disc");
        this.add(disc + ".desc", description);
    }

    public void translateAdvancement(String key, String name, String desc) {
        this.add("advancement.unusual_prehistory." + key, name);
        this.add("advancement.unusual_prehistory." + key + ".desc", desc);
    }

    private void translateEffect(RegistryObject<? extends MobEffect> effect, String desc) {
        this.add((MobEffect)effect.get(), UP2LanguageProvider.toUpper(ForgeRegistries.MOB_EFFECTS, effect));
        this.add(((MobEffect)effect.get()).m_19481_() + ".description", desc);
    }

    public void creativeTab(CreativeModeTab key, String name) {
        this.add(key.m_40786_().getString(), name);
    }

    public void sound(Supplier<? extends SoundEvent> key, String subtitle) {
        this.add("subtitles." + key.get().m_11660_().m_135815_(), subtitle);
    }

    private static <T> String toUpper(IForgeRegistry<T> registry, RegistryObject<? extends T> object) {
        return UP2LanguageProvider.toUpper(registry.getKey(object.get()).m_135815_());
    }

    private static String toUpper(String string) {
        return StringUtils.capitaliseAllWords((String)string.replace('_', ' '));
    }
}


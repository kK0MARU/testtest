/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid="unusual_prehistory", bus=Mod.EventBusSubscriber.Bus.MOD)
public class UP2SoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create((IForgeRegistry)ForgeRegistries.SOUND_EVENTS, (String)"unusual_prehistory");
    public static final RegistryObject<SoundEvent> CARNOTAURUS_HURT = UP2SoundEvents.registerSoundEvent("carnotaurus_hurt");
    public static final RegistryObject<SoundEvent> CARNOTAURUS_DEATH = UP2SoundEvents.registerSoundEvent("carnotaurus_death");
    public static final RegistryObject<SoundEvent> CARNOTAURUS_IDLE = UP2SoundEvents.registerSoundEvent("carnotaurus_idle");
    public static final RegistryObject<SoundEvent> CARNOTAURUS_STEP = UP2SoundEvents.registerSoundEvent("carnotaurus_step");
    public static final RegistryObject<SoundEvent> CARNOTAURUS_ROAR = UP2SoundEvents.registerSoundEvent("carnotaurus_roar");
    public static final RegistryObject<SoundEvent> CARNOTAURUS_SNIFF = UP2SoundEvents.registerSoundEvent("carnotaurus_sniff");
    public static final RegistryObject<SoundEvent> CARNOTAURUS_BITE = UP2SoundEvents.registerSoundEvent("carnotaurus_bite");
    public static final RegistryObject<SoundEvent> CARNOTAURUS_CHARGE = UP2SoundEvents.registerSoundEvent("carnotaurus_charge");
    public static final RegistryObject<SoundEvent> CARNOTAURUS_HEADBUTT = UP2SoundEvents.registerSoundEvent("carnotaurus_headbutt");
    public static final RegistryObject<SoundEvent> DIPLOCAULUS_HURT = UP2SoundEvents.registerSoundEvent("diplocaulus_hurt");
    public static final RegistryObject<SoundEvent> DIPLOCAULUS_DEATH = UP2SoundEvents.registerSoundEvent("diplocaulus_death");
    public static final RegistryObject<SoundEvent> DIPLOCAULUS_IDLE = UP2SoundEvents.registerSoundEvent("diplocaulus_idle");
    public static final RegistryObject<SoundEvent> DIPLOCAULUS_STEP = UP2SoundEvents.registerSoundEvent("diplocaulus_step");
    public static final RegistryObject<SoundEvent> DROMAEOSAURUS_HURT = UP2SoundEvents.registerSoundEvent("dromaeosaurus_hurt");
    public static final RegistryObject<SoundEvent> DROMAEOSAURUS_DEATH = UP2SoundEvents.registerSoundEvent("dromaeosaurus_death");
    public static final RegistryObject<SoundEvent> DROMAEOSAURUS_IDLE = UP2SoundEvents.registerSoundEvent("dromaeosaurus_idle");
    public static final RegistryObject<SoundEvent> DROMAEOSAURUS_EEPY = UP2SoundEvents.registerSoundEvent("dromaeosaurus_eepy");
    public static final RegistryObject<SoundEvent> DUNKLEOSTEUS_HURT = UP2SoundEvents.registerSoundEvent("dunkleosteus_hurt");
    public static final RegistryObject<SoundEvent> DUNKLEOSTEUS_DEATH = UP2SoundEvents.registerSoundEvent("dunkleosteus_death");
    public static final RegistryObject<SoundEvent> DUNKLEOSTEUS_FLOP = UP2SoundEvents.registerSoundEvent("dunkleosteus_flop");
    public static final RegistryObject<SoundEvent> SMALL_DUNKLEOSTEUS_BITE = UP2SoundEvents.registerSoundEvent("small_dunkleosteus_bite");
    public static final RegistryObject<SoundEvent> MEDIUM_DUNKLEOSTEUS_BITE = UP2SoundEvents.registerSoundEvent("medium_dunkleosteus_bite");
    public static final RegistryObject<SoundEvent> LARGE_DUNKLEOSTEUS_BITE = UP2SoundEvents.registerSoundEvent("large_dunkleosteus_bite");
    public static final RegistryObject<SoundEvent> KENTROSAURUS_HURT = UP2SoundEvents.registerSoundEvent("kentrosaurus_hurt");
    public static final RegistryObject<SoundEvent> KENTROSAURUS_DEATH = UP2SoundEvents.registerSoundEvent("kentrosaurus_death");
    public static final RegistryObject<SoundEvent> KENTROSAURUS_IDLE = UP2SoundEvents.registerSoundEvent("kentrosaurus_idle");
    public static final RegistryObject<SoundEvent> KENTROSAURUS_STEP = UP2SoundEvents.registerSoundEvent("kentrosaurus_step");
    public static final RegistryObject<SoundEvent> KIMMERIDGEBRACHYPTERAESCHNIDIUM_HURT = UP2SoundEvents.registerSoundEvent("kimmeridgebrachypteraeschnidium_hurt");
    public static final RegistryObject<SoundEvent> KIMMERIDGEBRACHYPTERAESCHNIDIUM_DEATH = UP2SoundEvents.registerSoundEvent("kimmeridgebrachypteraeschnidium_death");
    public static final RegistryObject<SoundEvent> KIMMERIDGEBRACHYPTERAESCHNIDIUM_LOOP = UP2SoundEvents.registerSoundEvent("kimmeridgebrachypteraeschnidium_loop");
    public static final RegistryObject<SoundEvent> KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_HURT = UP2SoundEvents.registerSoundEvent("kimmeridgebrachypteraeschnidium_nymph_hurt");
    public static final RegistryObject<SoundEvent> KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_DEATH = UP2SoundEvents.registerSoundEvent("kimmeridgebrachypteraeschnidium_nymph_death");
    public static final RegistryObject<SoundEvent> JAWLESS_FISH_HURT = UP2SoundEvents.registerSoundEvent("jawless_fish_hurt");
    public static final RegistryObject<SoundEvent> JAWLESS_FISH_DEATH = UP2SoundEvents.registerSoundEvent("jawless_fish_death");
    public static final RegistryObject<SoundEvent> JAWLESS_FISH_FLOP = UP2SoundEvents.registerSoundEvent("jawless_fish_flop");
    public static final RegistryObject<SoundEvent> MAJUNGASAURUS_HURT = UP2SoundEvents.registerSoundEvent("majungasaurus_hurt");
    public static final RegistryObject<SoundEvent> MAJUNGASAURUS_DEATH = UP2SoundEvents.registerSoundEvent("majungasaurus_death");
    public static final RegistryObject<SoundEvent> MAJUNGASAURUS_IDLE = UP2SoundEvents.registerSoundEvent("majungasaurus_idle");
    public static final RegistryObject<SoundEvent> MAJUNGASAURUS_ATTACK = UP2SoundEvents.registerSoundEvent("majungasaurus_attack");
    public static final RegistryObject<SoundEvent> MAJUNGASAURUS_SNIFF = UP2SoundEvents.registerSoundEvent("majungasaurus_sniff");
    public static final RegistryObject<SoundEvent> MAJUNGASAURUS_STEP = UP2SoundEvents.registerSoundEvent("majungasaurus_step");
    public static final RegistryObject<SoundEvent> MEGALANIA_HURT = UP2SoundEvents.registerSoundEvent("megalania_hurt");
    public static final RegistryObject<SoundEvent> MEGALANIA_DEATH = UP2SoundEvents.registerSoundEvent("megalania_death");
    public static final RegistryObject<SoundEvent> MEGALANIA_IDLE = UP2SoundEvents.registerSoundEvent("megalania_idle");
    public static final RegistryObject<SoundEvent> MEGALANIA_ROAR = UP2SoundEvents.registerSoundEvent("megalania_roar");
    public static final RegistryObject<SoundEvent> MEGALANIA_STEP = UP2SoundEvents.registerSoundEvent("megalania_step");
    public static final RegistryObject<SoundEvent> MEGALANIA_TAIL_SWING = UP2SoundEvents.registerSoundEvent("megalania_tail_swing");
    public static final RegistryObject<SoundEvent> MEGALANIA_BITE = UP2SoundEvents.registerSoundEvent("megalania_bite");
    public static final RegistryObject<SoundEvent> MEGALANIA_JUMPSCARE = UP2SoundEvents.registerSoundEvent("megalania_jumpscare");
    public static final RegistryObject<SoundEvent> STETHACANTHUS_HURT = UP2SoundEvents.registerSoundEvent("stethacanthus_hurt");
    public static final RegistryObject<SoundEvent> STETHACANTHUS_DEATH = UP2SoundEvents.registerSoundEvent("stethacanthus_death");
    public static final RegistryObject<SoundEvent> STETHACANTHUS_FLOP = UP2SoundEvents.registerSoundEvent("stethacanthus_flop");
    public static final RegistryObject<SoundEvent> STETHACANTHUS_BITE = UP2SoundEvents.registerSoundEvent("stethacanthus_bite");
    public static final RegistryObject<SoundEvent> TALPANAS_HURT = UP2SoundEvents.registerSoundEvent("talpanas_hurt");
    public static final RegistryObject<SoundEvent> TALPANAS_DEATH = UP2SoundEvents.registerSoundEvent("talpanas_death");
    public static final RegistryObject<SoundEvent> TALPANAS_IDLE = UP2SoundEvents.registerSoundEvent("talpanas_idle");
    public static final RegistryObject<SoundEvent> TELECREX_HURT = UP2SoundEvents.registerSoundEvent("telecrex_hurt");
    public static final RegistryObject<SoundEvent> TELECREX_DEATH = UP2SoundEvents.registerSoundEvent("telecrex_death");
    public static final RegistryObject<SoundEvent> TELECREX_IDLE = UP2SoundEvents.registerSoundEvent("telecrex_idle");
    public static final RegistryObject<SoundEvent> UNICORN_HURT = UP2SoundEvents.registerSoundEvent("unicorn_hurt");
    public static final RegistryObject<SoundEvent> UNICORN_DEATH = UP2SoundEvents.registerSoundEvent("unicorn_death");
    public static final RegistryObject<SoundEvent> UNICORN_IDLE = UP2SoundEvents.registerSoundEvent("unicorn_idle");
    public static final RegistryObject<SoundEvent> TRANSMOGRIFIER_LOOP = UP2SoundEvents.registerSoundEvent("transmogrifier_loop");
    public static final RegistryObject<SoundEvent> TRANSMOGRIFIER_START = UP2SoundEvents.registerSoundEvent("transmogrifier_start");
    public static final RegistryObject<SoundEvent> TRANSMOGRIFIER_STOP = UP2SoundEvents.registerSoundEvent("transmogrifier_stop");
    public static final RegistryObject<SoundEvent> TAR_POP = UP2SoundEvents.registerSoundEvent("tar_pop");
    public static final RegistryObject<SoundEvent> TARIFYING_DISC = UP2SoundEvents.registerSoundEvent("tarifying_disc");
    public static final RegistryObject<SoundEvent> ONCHOPRISTIS_HURT = UP2SoundEvents.registerSoundEvent("onchopristis_hurt");
    public static final RegistryObject<SoundEvent> ONCHOPRISTIS_DEATH = UP2SoundEvents.registerSoundEvent("onchopristis_death");
    public static final RegistryObject<SoundEvent> ONCHOPRISTIS_FLOP = UP2SoundEvents.registerSoundEvent("onchopristis_flop");
    public static final RegistryObject<SoundEvent> DOOMSURF_DISC = UP2SoundEvents.registerSoundEvent("doomsurf_disc");
    public static final RegistryObject<SoundEvent> MEGALANIA_DISC = UP2SoundEvents.registerSoundEvent("megalania_disc");
    public static final RegistryObject<SoundEvent> METRIORHYNCHUS_HURT = UP2SoundEvents.registerSoundEvent("metriorhynchus_hurt");
    public static final RegistryObject<SoundEvent> METRIORHYNCHUS_DEATH = UP2SoundEvents.registerSoundEvent("metriorhynchus_death");
    public static final RegistryObject<SoundEvent> METRIORHYNCHUS_IDLE = UP2SoundEvents.registerSoundEvent("metriorhynchus_idle");
    public static final RegistryObject<SoundEvent> METRIORHYNCHUS_BITE = UP2SoundEvents.registerSoundEvent("metriorhynchus_bite");
    public static final RegistryObject<SoundEvent> METRIORHYNCHUS_BELLOW = UP2SoundEvents.registerSoundEvent("metriorhynchus_bellow");
    public static final RegistryObject<SoundEvent> LIVING_OOZE_HURT = UP2SoundEvents.registerSoundEvent("living_ooze_hurt");
    public static final RegistryObject<SoundEvent> LIVING_OOZE_DEATH = UP2SoundEvents.registerSoundEvent("living_ooze_death");
    public static final RegistryObject<SoundEvent> LIVING_OOZE_SQUISH = UP2SoundEvents.registerSoundEvent("living_ooze_squish");
    public static final RegistryObject<SoundEvent> LIVING_OOZE_JUMP = UP2SoundEvents.registerSoundEvent("living_ooze_jump");
    public static final RegistryObject<SoundEvent> LIVING_OOZE_SPIT = UP2SoundEvents.registerSoundEvent("living_ooze_spit");
    public static final RegistryObject<SoundEvent> BRACHIOSAURUS_HURT = UP2SoundEvents.registerSoundEvent("brachiosaurus_hurt");
    public static final RegistryObject<SoundEvent> BRACHIOSAURUS_DEATH = UP2SoundEvents.registerSoundEvent("brachiosaurus_death");
    public static final RegistryObject<SoundEvent> BRACHIOSAURUS_IDLE = UP2SoundEvents.registerSoundEvent("brachiosaurus_idle");
    public static final RegistryObject<SoundEvent> BRACHIOSAURUS_ATTACK = UP2SoundEvents.registerSoundEvent("brachiosaurus_attack");
    public static final RegistryObject<SoundEvent> BRACHIOSAURUS_STEP = UP2SoundEvents.registerSoundEvent("brachiosaurus_step");
    public static final RegistryObject<SoundEvent> BRACHIOSAURUS_CALL = UP2SoundEvents.registerSoundEvent("brachiosaurus_call");
    public static final RegistryObject<SoundEvent> COELACANTHUS_HURT = UP2SoundEvents.registerSoundEvent("coelacanthus_hurt");
    public static final RegistryObject<SoundEvent> COELACANTHUS_DEATH = UP2SoundEvents.registerSoundEvent("coelacanthus_death");
    public static final RegistryObject<SoundEvent> COELACANTHUS_FLOP = UP2SoundEvents.registerSoundEvent("coelacanthus_flop");
    public static final RegistryObject<SoundEvent> HIBBERTOPTERUS_HURT = UP2SoundEvents.registerSoundEvent("hibbertopterus_hurt");
    public static final RegistryObject<SoundEvent> HIBBERTOPTERUS_DEATH = UP2SoundEvents.registerSoundEvent("hibbertopterus_death");
    public static final RegistryObject<SoundEvent> HIBBERTOPTERUS_IDLE = UP2SoundEvents.registerSoundEvent("hibbertopterus_idle");
    public static final RegistryObject<SoundEvent> HIBBERTOPTERUS_STEP = UP2SoundEvents.registerSoundEvent("hibbertopterus_step");
    public static final RegistryObject<SoundEvent> KAPROSUCHUS_HURT = UP2SoundEvents.registerSoundEvent("kaprosuchus_hurt");
    public static final RegistryObject<SoundEvent> KAPROSUCHUS_DEATH = UP2SoundEvents.registerSoundEvent("kaprosuchus_death");
    public static final RegistryObject<SoundEvent> KAPROSUCHUS_IDLE = UP2SoundEvents.registerSoundEvent("kaprosuchus_idle");
    public static final RegistryObject<SoundEvent> LEPTICTIDIUM_HURT = UP2SoundEvents.registerSoundEvent("leptictidium_hurt");
    public static final RegistryObject<SoundEvent> LEPTICTIDIUM_DEATH = UP2SoundEvents.registerSoundEvent("leptictidium_death");
    public static final RegistryObject<SoundEvent> LEPTICTIDIUM_IDLE = UP2SoundEvents.registerSoundEvent("leptictidium_idle");
    public static final RegistryObject<SoundEvent> LYSTROSAURUS_HURT = UP2SoundEvents.registerSoundEvent("lystrosaurus_hurt");
    public static final RegistryObject<SoundEvent> LYSTROSAURUS_DEATH = UP2SoundEvents.registerSoundEvent("lystrosaurus_death");
    public static final RegistryObject<SoundEvent> LYSTROSAURUS_IDLE = UP2SoundEvents.registerSoundEvent("lystrosaurus_idle");
    public static final RegistryObject<SoundEvent> LYSTROSAURUS_STEP = UP2SoundEvents.registerSoundEvent("lystrosaurus_step");
    public static final RegistryObject<SoundEvent> LYSTROSAURUS_CHAINSMOKER = UP2SoundEvents.registerSoundEvent("lystrosaurus_chainsmoker");
    public static final RegistryObject<SoundEvent> PACHYCEPHALOSAURUS_HURT = UP2SoundEvents.registerSoundEvent("pachycephalosaurus_hurt");
    public static final RegistryObject<SoundEvent> PACHYCEPHALOSAURUS_DEATH = UP2SoundEvents.registerSoundEvent("pachycephalosaurus_death");
    public static final RegistryObject<SoundEvent> PACHYCEPHALOSAURUS_IDLE = UP2SoundEvents.registerSoundEvent("pachycephalosaurus_idle");
    public static final RegistryObject<SoundEvent> PACHYCEPHALOSAURUS_WARN = UP2SoundEvents.registerSoundEvent("pachycephalosaurus_warn");
    public static final RegistryObject<SoundEvent> PACHYCEPHALOSAURUS_STEP = UP2SoundEvents.registerSoundEvent("pachycephalosaurus_step");
    public static final RegistryObject<SoundEvent> PACHYCEPHALOSAURUS_BONK = UP2SoundEvents.registerSoundEvent("pachycephalosaurus_bonk");
    public static final RegistryObject<SoundEvent> PRAEPUSA_HURT = UP2SoundEvents.registerSoundEvent("praepusa_hurt");
    public static final RegistryObject<SoundEvent> PRAEPUSA_DEATH = UP2SoundEvents.registerSoundEvent("praepusa_death");
    public static final RegistryObject<SoundEvent> PRAEPUSA_IDLE = UP2SoundEvents.registerSoundEvent("praepusa_idle");
    public static final RegistryObject<SoundEvent> PRAEPUSA_MITOSIS = UP2SoundEvents.registerSoundEvent("praepusa_mitosis");
    public static final RegistryObject<SoundEvent> PRAEPUSA_BOUNCE = UP2SoundEvents.registerSoundEvent("praepusa_bounce");
    public static final RegistryObject<SoundEvent> PTERODACTYLUS_HURT = UP2SoundEvents.registerSoundEvent("pterodactylus_hurt");
    public static final RegistryObject<SoundEvent> PTERODACTYLUS_DEATH = UP2SoundEvents.registerSoundEvent("pterodactylus_death");
    public static final RegistryObject<SoundEvent> PTERODACTYLUS_IDLE = UP2SoundEvents.registerSoundEvent("pterodactylus_idle");
    public static final RegistryObject<SoundEvent> ULUGHBEGSAURUS_HURT = UP2SoundEvents.registerSoundEvent("ulughbegsaurus_hurt");
    public static final RegistryObject<SoundEvent> ULUGHBEGSAURUS_DEATH = UP2SoundEvents.registerSoundEvent("ulughbegsaurus_death");
    public static final RegistryObject<SoundEvent> ULUGHBEGSAURUS_IDLE = UP2SoundEvents.registerSoundEvent("ulughbegsaurus_idle");
    public static final RegistryObject<SoundEvent> ULUGHBEGSAURUS_ATTACK = UP2SoundEvents.registerSoundEvent("ulughbegsaurus_attack");
    public static final RegistryObject<SoundEvent> ULUGHBEGSAURUS_STEP = UP2SoundEvents.registerSoundEvent("ulughbegsaurus_step");
    public static final RegistryObject<SoundEvent> AEGIROCASSIS_HURT = UP2SoundEvents.registerSoundEvent("aegirocassis_hurt");
    public static final RegistryObject<SoundEvent> AEGIROCASSIS_DEATH = UP2SoundEvents.registerSoundEvent("aegirocassis_death");
    public static final RegistryObject<SoundEvent> AEGIROCASSIS_IDLE = UP2SoundEvents.registerSoundEvent("aegirocassis_idle");
    public static final RegistryObject<SoundEvent> AEGIROCASSIS_HOVER = UP2SoundEvents.registerSoundEvent("aegirocassis_hover");
    public static final RegistryObject<SoundEvent> BARINASUCHUS_HURT = UP2SoundEvents.registerSoundEvent("barinasuchus_hurt");
    public static final RegistryObject<SoundEvent> BARINASUCHUS_DEATH = UP2SoundEvents.registerSoundEvent("barinasuchus_death");
    public static final RegistryObject<SoundEvent> BARINASUCHUS_IDLE = UP2SoundEvents.registerSoundEvent("barinasuchus_idle");
    public static final RegistryObject<SoundEvent> BARINASUCHUS_ATTACK = UP2SoundEvents.registerSoundEvent("barinasuchus_attack");
    public static final RegistryObject<SoundEvent> BARINASUCHUS_THREATEN = UP2SoundEvents.registerSoundEvent("barinasuchus_threaten");
    public static final RegistryObject<SoundEvent> DESMATOSUCHUS_HURT = UP2SoundEvents.registerSoundEvent("desmatosuchus_hurt");
    public static final RegistryObject<SoundEvent> DESMATOSUCHUS_DEATH = UP2SoundEvents.registerSoundEvent("desmatosuchus_death");
    public static final RegistryObject<SoundEvent> DESMATOSUCHUS_IDLE = UP2SoundEvents.registerSoundEvent("desmatosuchus_idle");
    public static final RegistryObject<SoundEvent> DESMATOSUCHUS_STEP = UP2SoundEvents.registerSoundEvent("desmatosuchus_step");
    public static final RegistryObject<SoundEvent> DIMORPHODON_HURT = UP2SoundEvents.registerSoundEvent("dimorphodon_hurt");
    public static final RegistryObject<SoundEvent> DIMORPHODON_DEATH = UP2SoundEvents.registerSoundEvent("dimorphodon_death");
    public static final RegistryObject<SoundEvent> DIMORPHODON_IDLE = UP2SoundEvents.registerSoundEvent("dimorphodon_idle");
    public static final RegistryObject<SoundEvent> MANIPULATOR_HURT = UP2SoundEvents.registerSoundEvent("manipulator_hurt");
    public static final RegistryObject<SoundEvent> MANIPULATOR_DEATH = UP2SoundEvents.registerSoundEvent("manipulator_death");
    public static final RegistryObject<SoundEvent> MANIPULATOR_IDLE = UP2SoundEvents.registerSoundEvent("manipulator_idle");
    public static final RegistryObject<SoundEvent> MANIPULATOR_STEP = UP2SoundEvents.registerSoundEvent("manipulator_step");
    public static final RegistryObject<SoundEvent> MANIPULATOR_ATTACK_VOCAL = UP2SoundEvents.registerSoundEvent("manipulator_attack_vocal");
    public static final RegistryObject<SoundEvent> MANIPULATOR_ATTACK_SLASH = UP2SoundEvents.registerSoundEvent("manipulator_attack_slash");
    public static final RegistryObject<SoundEvent> PSILOPTERUS_HURT = UP2SoundEvents.registerSoundEvent("psilopterus_hurt");
    public static final RegistryObject<SoundEvent> PSILOPTERUS_DEATH = UP2SoundEvents.registerSoundEvent("psilopterus_death");
    public static final RegistryObject<SoundEvent> PSILOPTERUS_IDLE = UP2SoundEvents.registerSoundEvent("psilopterus_idle");
    public static final RegistryObject<SoundEvent> PSILOPTERUS_ATTACK = UP2SoundEvents.registerSoundEvent("psilopterus_attack");
    public static final RegistryObject<SoundEvent> PSILOPTERUS_BITE = UP2SoundEvents.registerSoundEvent("psilopterus_bite");
    public static final RegistryObject<SoundEvent> PSILOPTERUS_CALL = UP2SoundEvents.registerSoundEvent("psilopterus_call");
    public static final RegistryObject<SoundEvent> THERIZINOSAURUS_HURT = UP2SoundEvents.registerSoundEvent("therizinosaurus_hurt");
    public static final RegistryObject<SoundEvent> THERIZINOSAURUS_DEATH = UP2SoundEvents.registerSoundEvent("therizinosaurus_death");
    public static final RegistryObject<SoundEvent> THERIZINOSAURUS_IDLE = UP2SoundEvents.registerSoundEvent("therizinosaurus_idle");
    public static final RegistryObject<SoundEvent> THERIZINOSAURUS_ATTACK = UP2SoundEvents.registerSoundEvent("therizinosaurus_attack");
    public static final RegistryObject<SoundEvent> THERIZINOSAURUS_STEP = UP2SoundEvents.registerSoundEvent("therizinosaurus_step");
    public static final RegistryObject<SoundEvent> THERIZINOSAURUS_ROAR = UP2SoundEvents.registerSoundEvent("therizinosaurus_roar");
    public static final RegistryObject<SoundEvent> THERIZINOSAURUS_NOTICE = UP2SoundEvents.registerSoundEvent("therizinosaurus_notice");
    public static final RegistryObject<SoundEvent> BUG_HURT = UP2SoundEvents.registerSoundEvent("bug_hurt");
    public static final RegistryObject<SoundEvent> BUG_DEATH = UP2SoundEvents.registerSoundEvent("bug_death");
    public static final RegistryObject<SoundEvent> BUG_BUZZ = UP2SoundEvents.registerSoundEvent("bug_buzz");

    private static RegistryObject<SoundEvent> registerSoundEvent(String soundName) {
        return SOUND_EVENTS.register(soundName, () -> SoundEvent.m_262824_((ResourceLocation)new ResourceLocation("unusual_prehistory", soundName)));
    }
}


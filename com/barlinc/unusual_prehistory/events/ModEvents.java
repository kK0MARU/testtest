/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.SpawnPlacements$Type
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraftforge.event.entity.EntityAttributeCreationEvent
 *  net.minecraftforge.event.entity.SpawnPlacementRegisterEvent
 *  net.minecraftforge.event.entity.SpawnPlacementRegisterEvent$Operation
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 */
package com.barlinc.unusual_prehistory.events;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricAquaticMob;
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
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid="unusual_prehistory", bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register((EntityType)UP2Entities.CARNOTAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Carnotaurus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.DIPLOCAULUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Diplocaulus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.DROMAEOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dromaeosaurus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.DUNKLEOSTEUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PrehistoricAquaticMob::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.JAWLESS_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JawlessFish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.KENTROSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Kentrosaurus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Kimmeridgebrachypteraeschnidium::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, KimmeridgebrachypteraeschnidiumNymph::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.MAJUNGASAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Majungasaurus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.MEGALANIA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Megalania::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.STETHACANTHUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PrehistoricAquaticMob::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.TALPANAS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Talpanas::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.TELECREX.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Telecrex::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.UNICORN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Unicorn::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.ONCHOPRISTIS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PrehistoricAquaticMob::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.METRIORHYNCHUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Metriorhynchus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.TARTUOSTEUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Tartuosteus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.AEGIROCASSIS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PrehistoricAquaticMob::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.BARINASUCHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Barinasuchus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.BRACHIOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Brachiosaurus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.COELACANTHUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PrehistoricAquaticMob::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.DESMATOSUCHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Desmatosuchus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.DIMORPHODON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dimorphodon::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.HIBBERTOPTERUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Hibbertopterus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.KAPROSUCHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Kaprosuchus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.LEPTICTIDIUM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Leptictidium::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.LOBE_FINNED_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LobeFinnedFish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.LYSTROSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Lystrosaurus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.MANIPULATOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Manipulator::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.PACHYCEPHALOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Pachycephalosaurus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.PRAEPUSA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Praepusa::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.PSILOPTERUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Psilopterus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.PTERODACTYLUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Pterodactylus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.THERIZINOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Therizinosaurus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.ULUGHBEGSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ulughbegsaurus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.COTYLORHYNCHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Cotylorhynchus::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.ERYON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Eryon::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.MAMMOTH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mammoth::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.PALAEOPHIS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Palaeophis::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register((EntityType)UP2Entities.WONAMBI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Wonambi::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put((EntityType)UP2Entities.CARNOTAURUS.get(), Carnotaurus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.DIPLOCAULUS.get(), Diplocaulus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.DROMAEOSAURUS.get(), Dromaeosaurus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.DUNKLEOSTEUS.get(), Dunkleosteus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.JAWLESS_FISH.get(), JawlessFish.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.KENTROSAURUS.get(), Kentrosaurus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM.get(), Kimmeridgebrachypteraeschnidium.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH.get(), KimmeridgebrachypteraeschnidiumNymph.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.MAJUNGASAURUS.get(), Majungasaurus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.MEGALANIA.get(), Megalania.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.STETHACANTHUS.get(), Stethacanthus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.TALPANAS.get(), Talpanas.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.TELECREX.get(), Telecrex.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.ONCHOPRISTIS.get(), Onchopristis.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.LIVING_OOZE.get(), LivingOoze.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.METRIORHYNCHUS.get(), Metriorhynchus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.TARTUOSTEUS.get(), Tartuosteus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.AEGIROCASSIS.get(), Aegirocassis.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.BARINASUCHUS.get(), Barinasuchus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.BRACHIOSAURUS.get(), Brachiosaurus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.COELACANTHUS.get(), Coelacanthus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.DELITZSCHALA.get(), Delitzschala.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.DESMATOSUCHUS.get(), Desmatosuchus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.DIMORPHODON.get(), Dimorphodon.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.HIBBERTOPTERUS.get(), Hibbertopterus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.KAPROSUCHUS.get(), Kaprosuchus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.LEPTICTIDIUM.get(), Leptictidium.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.LOBE_FINNED_FISH.get(), LobeFinnedFish.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.LYSTROSAURUS.get(), Lystrosaurus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.MANIPULATOR.get(), Manipulator.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.PACHYCEPHALOSAURUS.get(), Pachycephalosaurus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.PRAEPUSA.get(), Praepusa.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.PSILOPTERUS.get(), Psilopterus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.PTERODACTYLUS.get(), Pterodactylus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.THERIZINOSAURUS.get(), Therizinosaurus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.ULUGHBEGSAURUS.get(), Ulughbegsaurus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.UNICORN.get(), Unicorn.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.ZHANGSOLVA.get(), Zhangsolva.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.COTYLORHYNCHUS.get(), Cotylorhynchus.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.ERYON.get(), Eryon.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.MAMMOTH.get(), Mammoth.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.PALAEOPHIS.get(), Palaeophis.createAttributes().m_22265_());
        event.put((EntityType)UP2Entities.WONAMBI.get(), Wonambi.createAttributes().m_22265_());
    }
}


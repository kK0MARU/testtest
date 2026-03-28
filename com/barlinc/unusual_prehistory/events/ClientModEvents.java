/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screens.MenuScreens
 *  net.minecraft.client.renderer.BiomeColors
 *  net.minecraft.client.renderer.Sheets
 *  net.minecraft.client.renderer.entity.ThrownItemRenderer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleType
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.FoliageColor
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.WoodType
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.client.event.EntityRenderersEvent$RegisterLayerDefinitions
 *  net.minecraftforge.client.event.EntityRenderersEvent$RegisterRenderers
 *  net.minecraftforge.client.event.RegisterColorHandlersEvent$Block
 *  net.minecraftforge.client.event.RegisterColorHandlersEvent$Item
 *  net.minecraftforge.client.event.RegisterParticleProvidersEvent
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
 */
package com.barlinc.unusual_prehistory.events;

import com.barlinc.unusual_prehistory.client.models.entity.mob.future.AegirocassisBabyModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.AegirocassisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.BarinasuchusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.CotylorhynchusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.DesmatosuchusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.DimorphodonModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.EryonModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.MammothModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.ManipulatorModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.PalaeophisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.PsilopterusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.TherizinosaurusBabyModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.TherizinosaurusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.WonambiModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.ambient.DelitzschalaModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.future.ambient.ZhangsolvaModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.CarnotaurusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DiplocaulusBrevirostrisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DiplocaulusMagnicornisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DiplocaulusRecurvatisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DiplocaulusSalamandroidesModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DromaeosaurusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DunkleosteusLargeModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DunkleosteusMediumModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.DunkleosteusSmallModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.KentrosaurusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.KimmeridgebrachypteraeschnidiumModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.KimmeridgebrachypteraeschnidiumNymphModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.MajungasaurusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.MegalaniaModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.StethacanthusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.TalpanasModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.TelecrexModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.UnicornModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.UnicornSkeletonModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish.ArandaspisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish.CephalaspisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish.DoryaspisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish.FurcacaudaModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_1.jawless_fish.SacabambaspisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_2.OnchopristisModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_3.LivingOozeModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_3.MetriorhynchusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_3.TartuosteusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.BrachiosaurusBabyModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.BrachiosaurusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.CoelacanthusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.HibbertopterusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.KaprosuchusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.LeptictidiumModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.LystrosaurusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.PachycephalosaurusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.PraepusaModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.PterodactylusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.UlughbegsaurusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish.AllenypterusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish.EusthenopteronModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish.GooloogongiaModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish.LaccognathusModel;
import com.barlinc.unusual_prehistory.client.models.entity.mob.update_4.lobe_finned_fish.ScaumenaciaModel;
import com.barlinc.unusual_prehistory.client.particles.EepyParticle;
import com.barlinc.unusual_prehistory.client.particles.FallingLeafParticle;
import com.barlinc.unusual_prehistory.client.particles.GrowingHeartParticle;
import com.barlinc.unusual_prehistory.client.particles.ImpactStunParticle;
import com.barlinc.unusual_prehistory.client.particles.OozeBubbleParticle;
import com.barlinc.unusual_prehistory.client.particles.SnowflakeParticle;
import com.barlinc.unusual_prehistory.client.particles.TarBubbleParticle;
import com.barlinc.unusual_prehistory.client.renderer.entity.UP2BoatRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.UP2ChestBoatRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.AegirocassisRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.BarinasuchusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.CotylorhynchusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.DesmatosuchusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.DimorphodonRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.EryonRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.MammothRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.ManipulatorRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.PalaeophisRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.PsilopterusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.TherizinosaurusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.WonambiRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.ambient.DelitzschalaRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.future.ambient.ZhangsolvaRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.CarnotaurusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.DiplocaulusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.DromaeosaurusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.DunkleosteusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.JawlessFishRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.KentrosaurusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.KimmeridgebrachypteraeschnidiumNymphRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.KimmeridgebrachypteraeschnidiumRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.MajungasaurusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.MegalaniaRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.StethacanthusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.TalpanasRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.TelecrexRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_1.UnicornRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_2.OnchopristisRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3.LivingOozeRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3.MetriorhynchusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_3.TartuosteusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.BrachiosaurusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.CoelacanthusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.HibbertopterusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.KaprosuchusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.LeptictidiumRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.LobeFinnedFishRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.LystrosaurusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.PachycephalosaurusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.PraepusaRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.PterodactylusRenderer;
import com.barlinc.unusual_prehistory.client.renderer.entity.mob.update_4.UlughbegsaurusRenderer;
import com.barlinc.unusual_prehistory.registry.UP2BlockProperties;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2ItemProperties;
import com.barlinc.unusual_prehistory.registry.UP2MenuTypes;
import com.barlinc.unusual_prehistory.registry.UP2ModelLayers;
import com.barlinc.unusual_prehistory.registry.UP2Particles;
import com.barlinc.unusual_prehistory.screens.TransmogrifierScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(value=Dist.CLIENT)
@Mod.EventBusSubscriber(modid="unusual_prehistory", bus=Mod.EventBusSubscriber.Bus.MOD, value={Dist.CLIENT})
public class ClientModEvents {
    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(UP2ItemProperties::registerItemProperties);
        Sheets.addWoodType((WoodType)UP2BlockProperties.DRYOPHYLLUM_WOOD_TYPE);
        Sheets.addWoodType((WoodType)UP2BlockProperties.GINKGO_WOOD_TYPE);
        Sheets.addWoodType((WoodType)UP2BlockProperties.LEPIDODENDRON_WOOD_TYPE);
        Sheets.addWoodType((WoodType)UP2BlockProperties.METASEQUOIA_WOOD_TYPE);
        MenuScreens.m_96206_((MenuType)((MenuType)UP2MenuTypes.TRANSMOGRIFIER.get()), TransmogrifierScreen::new);
    }

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet((ParticleType)UP2Particles.GINKGO_LEAVES.get(), FallingLeafParticle.GinkgoProvider::new);
        event.registerSpriteSet((ParticleType)UP2Particles.GOLDEN_GINKGO_LEAVES.get(), FallingLeafParticle.GinkgoProvider::new);
        event.registerSpriteSet((ParticleType)UP2Particles.EEPY.get(), EepyParticle.Provider::new);
        event.registerSpriteSet((ParticleType)UP2Particles.OOZE_BUBBLE.get(), OozeBubbleParticle.Provider::new);
        event.registerSpriteSet((ParticleType)UP2Particles.TAR_BUBBLE.get(), TarBubbleParticle.Provider::new);
        event.registerSpriteSet((ParticleType)UP2Particles.GOLDEN_HEART.get(), GrowingHeartParticle.Provider::new);
        event.registerSpriteSet((ParticleType)UP2Particles.SNOWFLAKE.get(), SnowflakeParticle.Provider::new);
        event.registerSpriteSet((ParticleType)UP2Particles.IMPACT_STUN.get(), ImpactStunParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType)UP2Entities.CARNOTAURUS.get(), CarnotaurusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.DIPLOCAULUS.get(), DiplocaulusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.DROMAEOSAURUS.get(), DromaeosaurusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.DUNKLEOSTEUS.get(), DunkleosteusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.JAWLESS_FISH.get(), JawlessFishRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.KENTROSAURUS.get(), KentrosaurusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM.get(), KimmeridgebrachypteraeschnidiumRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH.get(), KimmeridgebrachypteraeschnidiumNymphRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.MAJUNGASAURUS.get(), MajungasaurusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.MEGALANIA.get(), MegalaniaRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.STETHACANTHUS.get(), StethacanthusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.TALPANAS.get(), TalpanasRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.TELECREX.get(), TelecrexRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.UNICORN.get(), UnicornRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.DROMAEOSAURUS_EGG.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.TALPANAS_EGG.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.TELECREX_EGG.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.ONCHOPRISTIS.get(), OnchopristisRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.LIVING_OOZE.get(), LivingOozeRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.METRIORHYNCHUS.get(), MetriorhynchusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.TARTUOSTEUS.get(), TartuosteusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.AEGIROCASSIS.get(), AegirocassisRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.BARINASUCHUS.get(), BarinasuchusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.COELACANTHUS.get(), CoelacanthusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.DELITZSCHALA.get(), DelitzschalaRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.DESMATOSUCHUS.get(), DesmatosuchusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.DIMORPHODON.get(), DimorphodonRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.HIBBERTOPTERUS.get(), HibbertopterusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.KAPROSUCHUS.get(), KaprosuchusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.LEPTICTIDIUM.get(), LeptictidiumRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.LOBE_FINNED_FISH.get(), LobeFinnedFishRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.LYSTROSAURUS.get(), LystrosaurusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.MANIPULATOR.get(), ManipulatorRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.PACHYCEPHALOSAURUS.get(), PachycephalosaurusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.PRAEPUSA.get(), PraepusaRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.PSILOPTERUS.get(), PsilopterusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.PTERODACTYLUS.get(), PterodactylusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.THERIZINOSAURUS.get(), TherizinosaurusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.ULUGHBEGSAURUS.get(), UlughbegsaurusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.DIMORPHODON_EGG.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.PSILOPTERUS_EGG.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.PTERODACTYLUS_EGG.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.ZHANGSOLVA.get(), ZhangsolvaRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.COTYLORHYNCHUS.get(), CotylorhynchusRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.ERYON.get(), EryonRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.MAMMOTH.get(), MammothRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.PALAEOPHIS.get(), PalaeophisRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.WONAMBI.get(), WonambiRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.BOAT.get(), UP2BoatRenderer::new);
        event.registerEntityRenderer((EntityType)UP2Entities.CHEST_BOAT.get(), UP2ChestBoatRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(UP2ModelLayers.CARNOTAURUS, CarnotaurusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DIPLOCAULUS_BREVIROSTRIS, DiplocaulusBrevirostrisModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DIPLOCAULUS_MAGNICORNIS, DiplocaulusMagnicornisModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DIPLOCAULUS_RECURVATIS, DiplocaulusRecurvatisModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DIPLOCAULUS_SALAMANDROIDES, DiplocaulusSalamandroidesModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DROMAEOSAURUS, DromaeosaurusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DUNKLEOSTEUS_LARGE, DunkleosteusLargeModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DUNKLEOSTEUS_MEDIUM, DunkleosteusMediumModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DUNKLEOSTEUS_SMALL, DunkleosteusSmallModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.JAWLESS_FISH_ARANDASPIS, ArandaspisModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.JAWLESS_FISH_CEPHALASPIS, CephalaspisModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.JAWLESS_FISH_DORYASPIS, DoryaspisModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.JAWLESS_FISH_FURACACAUDA, FurcacaudaModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.JAWLESS_FISH_SACABAMBASPIS, SacabambaspisModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.KENTROSAURUS, KentrosaurusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.KIMMERIDGEBRACHYPTERAESCHNIDIUM, KimmeridgebrachypteraeschnidiumModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH, KimmeridgebrachypteraeschnidiumNymphModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.MAJUNGASAURUS, MajungasaurusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.MEGALANIA, MegalaniaModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.STETHACANTHUS, StethacanthusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.TALPANAS, TalpanasModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.TELECREX, TelecrexModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.UNICORN, UnicornModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.UNICORN_SKELETON, UnicornSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.ONCHOPRISTIS, OnchopristisModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.LIVING_OOZE, LivingOozeModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.METRIORHYNCHUS, MetriorhynchusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.TARTUOSTEUS, TartuosteusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.AEGIROCASSIS, AegirocassisModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.AEGIROCASSIS_BABY, AegirocassisBabyModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.BARINASUCHUS, BarinasuchusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.BRACHIOSAURUS, BrachiosaurusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.BRACHIOSAURUS_BABY, BrachiosaurusBabyModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.COELACANTHUS, CoelacanthusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DELITZSCHALA, DelitzschalaModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DESMATOSUCHUS, DesmatosuchusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.DIMORPHODON, DimorphodonModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.HIBBERTOPTERUS, HibbertopterusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.KAPROSUCHUS, KaprosuchusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.LEPTICTIDIUM, LeptictidiumModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.LOBE_FINNED_FISH_ALLENYPTERUS, AllenypterusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.LOBE_FINNED_FISH_EUSTHENOPTERON, EusthenopteronModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.LOBE_FINNED_FISH_GOOLOOGONGIA, GooloogongiaModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.LOBE_FINNED_FISH_LACCOGNATHUS, LaccognathusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.LOBE_FINNED_FISH_SCAUMENACIA, ScaumenaciaModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.LYSTROSAURUS, LystrosaurusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.MANIPULATOR, ManipulatorModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.PACHYCEPHALOSAURUS, PachycephalosaurusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.PRAEPUSA, PraepusaModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.PSILOPTERUS, PsilopterusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.PTERODACTYLUS, PterodactylusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.THERIZINOSAURUS, TherizinosaurusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.THERIZINOSAURUS_BABY, TherizinosaurusBabyModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.ULUGHBEGSAURUS, UlughbegsaurusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.ZHANGSOLVA, ZhangsolvaModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.COTYLORHYNCHUS, CotylorhynchusModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.ERYON, EryonModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.MAMMOTH, MammothModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.PALAEOPHIS, PalaeophisModel::createBodyLayer);
        event.registerLayerDefinition(UP2ModelLayers.WONAMBI, WonambiModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return FoliageColor.m_46113_();
            }
            return BiomeColors.m_108804_((BlockAndTintGetter)world, (BlockPos)pos);
        }, new Block[]{(Block)UP2Blocks.CLADOPHLEBIS.get()});
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
            BlockState blockstate = ((BlockItem)stack.m_41720_()).m_40614_().m_49966_();
            return event.getBlockColors().m_92577_(blockstate, null, null, tintIndex);
        }, new ItemLike[]{(ItemLike)UP2Blocks.CLADOPHLEBIS.get()});
    }
}


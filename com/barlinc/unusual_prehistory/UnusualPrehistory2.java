/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.logging.LogUtils
 *  net.minecraft.data.DataGenerator
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.common.data.ExistingFileHelper
 *  net.minecraftforge.data.event.GatherDataEvent
 *  net.minecraftforge.eventbus.api.IEventBus
 *  net.minecraftforge.fml.DistExecutor
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
 *  net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
 *  net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent
 *  net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
 *  org.slf4j.Logger
 */
package com.barlinc.unusual_prehistory;

import com.barlinc.unusual_prehistory.UnusualPrehistory2Tab;
import com.barlinc.unusual_prehistory.datagen.UP2AdvancementProvider;
import com.barlinc.unusual_prehistory.datagen.UP2BiomeTagProvider;
import com.barlinc.unusual_prehistory.datagen.UP2BlockTagProvider;
import com.barlinc.unusual_prehistory.datagen.UP2BlockstateProvider;
import com.barlinc.unusual_prehistory.datagen.UP2DamageTypeTagProvider;
import com.barlinc.unusual_prehistory.datagen.UP2DatapackProvider;
import com.barlinc.unusual_prehistory.datagen.UP2EntityTagProvider;
import com.barlinc.unusual_prehistory.datagen.UP2ItemModelProvider;
import com.barlinc.unusual_prehistory.datagen.UP2ItemTagProvider;
import com.barlinc.unusual_prehistory.datagen.UP2LanguageProvider;
import com.barlinc.unusual_prehistory.datagen.UP2LootProvider;
import com.barlinc.unusual_prehistory.datagen.UP2RecipeProvider;
import com.barlinc.unusual_prehistory.datagen.UP2SoundDefinitionsProvider;
import com.barlinc.unusual_prehistory.registry.UP2BlockEntities;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Compat;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Features;
import com.barlinc.unusual_prehistory.registry.UP2Fluids;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2LootModifiers;
import com.barlinc.unusual_prehistory.registry.UP2MenuTypes;
import com.barlinc.unusual_prehistory.registry.UP2MobEffects;
import com.barlinc.unusual_prehistory.registry.UP2Network;
import com.barlinc.unusual_prehistory.registry.UP2Particles;
import com.barlinc.unusual_prehistory.registry.UP2Recipes;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.UP2StructureProcessors;
import com.barlinc.unusual_prehistory.registry.UP2Structures;
import com.barlinc.unusual_prehistory.registry.UP2Trees;
import com.barlinc.unusual_prehistory.utils.ClientProxy;
import com.barlinc.unusual_prehistory.utils.CommonProxy;
import com.barlinc.unusual_prehistory.utils.UP2LoadedMods;
import com.mojang.logging.LogUtils;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(value="unusual_prehistory")
public class UnusualPrehistory2 {
    public static final String MOD_ID = "unusual_prehistory";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static CommonProxy PROXY = (CommonProxy)DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public UnusualPrehistory2() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = MinecraftForge.EVENT_BUS;
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::loadComplete);
        bus.addListener(this::dataSetup);
        UP2Entities.ENTITY_TYPE.register(bus);
        UP2Blocks.BLOCKS.register(bus);
        UP2Items.ITEMS.register(bus);
        UP2Fluids.FLUIDS.register(bus);
        UP2Fluids.TYPES.register(bus);
        UP2BlockEntities.BLOCK_ENTITIES.register(bus);
        UP2MobEffects.MOB_EFFECTS.register(bus);
        UP2MenuTypes.MENUS.register(bus);
        UP2Recipes.RECIPE_TYPES.register(bus);
        UP2Recipes.RECIPE_SERIALIZERS.register(bus);
        UP2Features.FEATURES.register(bus);
        UP2Trees.TREE_DECORATORS.register(bus);
        UP2Trees.TRUNK_PLACERS.register(bus);
        UP2Trees.FOLIAGE_PLACERS.register(bus);
        UP2Structures.STRUCTURE_TYPES.register(bus);
        UP2StructureProcessors.PROCESSOR_TYPES.register(bus);
        UP2LootModifiers.LOOT_MODIFIERS.register(bus);
        UP2SoundEvents.SOUND_EVENTS.register(bus);
        UP2Particles.PARTICLE_TYPES.register(bus);
        UnusualPrehistory2Tab.CREATIVE_TABS.register(bus);
        PROXY.commonInit();
        eventBus.register((Object)this);
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(UP2Compat::registerCompat);
        UP2Network.registerNetwork();
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> PROXY.clientInit());
    }

    private void loadComplete(FMLLoadCompleteEvent event) {
        event.enqueueWork(UP2Fluids::postInit);
        event.enqueueWork(UP2LoadedMods::afterAllModsLoaded);
    }

    private void dataSetup(GatherDataEvent data) {
        DataGenerator generator = data.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture provider = data.getLookupProvider();
        ExistingFileHelper helper = data.getExistingFileHelper();
        boolean client = data.includeClient();
        generator.addProvider(client, (DataProvider)new UP2BlockstateProvider(data));
        generator.addProvider(client, (DataProvider)new UP2ItemModelProvider(data));
        generator.addProvider(client, (DataProvider)new UP2SoundDefinitionsProvider(output, helper));
        generator.addProvider(client, (DataProvider)new UP2LanguageProvider(data));
        boolean server = data.includeServer();
        UP2DatapackProvider datapackEntries = new UP2DatapackProvider(output, provider);
        generator.addProvider(server, (DataProvider)datapackEntries);
        provider = datapackEntries.getRegistryProvider();
        UP2BlockTagProvider blockTags = new UP2BlockTagProvider(output, provider, helper);
        generator.addProvider(server, (DataProvider)blockTags);
        generator.addProvider(server, (DataProvider)new UP2ItemTagProvider(output, provider, blockTags.m_274426_(), helper));
        generator.addProvider(server, (DataProvider)new UP2EntityTagProvider(output, provider, helper));
        generator.addProvider(server, (DataProvider)new UP2BiomeTagProvider(output, provider, helper));
        generator.addProvider(server, (DataProvider)new UP2DamageTypeTagProvider(output, provider, helper));
        generator.addProvider(server, (DataProvider)UP2LootProvider.register(output));
        generator.addProvider(server, (DataProvider)new UP2RecipeProvider(output));
        generator.addProvider(server, (DataProvider)UP2AdvancementProvider.register(output, provider, helper));
    }

    public static ResourceLocation modPrefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}


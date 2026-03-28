/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.SpawnEggItem
 *  net.minecraftforge.client.model.generators.ItemModelBuilder
 *  net.minecraftforge.client.model.generators.ItemModelProvider
 *  net.minecraftforge.client.model.generators.ModelFile
 *  net.minecraftforge.data.event.GatherDataEvent
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import java.util.Objects;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UP2ItemModelProvider
extends ItemModelProvider {
    public UP2ItemModelProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), "unusual_prehistory", event.getExistingFileHelper());
    }

    protected void registerModels() {
        this.item(UP2Items.UNUSUAL_PREHISTORY);
        this.item(UP2Items.MACHINE_PARTS);
        this.item(UP2Items.GINKGO_FRUIT);
        this.item(UP2Items.KIMMERIDGEBRACHYPTERAESCHNIDIUM_BOTTLE);
        this.item(UP2Items.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_BUCKET);
        this.item(UP2Items.PRAEPUSA_BUCKET);
        this.item(UP2Items.STETHACANTHUS_BUCKET);
        this.item(UP2Items.BABY_AEGIROCASSIS_BUCKET);
        this.item(UP2Items.DOOMSURF_DISC);
        this.item(UP2Items.MEGALANIA_DISC);
        this.item(UP2Items.TARIFYING_DISC);
        this.item(UP2Items.TAR_BUCKET);
        this.item(UP2Items.LIVING_OOZE_BUCKET);
        this.item(UP2Items.PETRIFIED_LUCA);
        this.item(UP2Items.LUCA);
        this.handheldRodItem(UP2Items.DIRT_ON_A_STICK);
        this.item(UP2Blocks.CYCAD_SEEDLING);
        this.item(UP2Blocks.GUANGDEDENDRON);
        this.item(UP2Items.BRISTLE_FOSSIL);
        this.item(UP2Items.BRUTE_FOSSIL);
        this.item(UP2Items.ARM_FOSSIL);
        this.item(UP2Items.FURY_FOSSIL);
        this.item(UP2Items.GLUTTONOUS_FOSSIL);
        this.item(UP2Items.FLAT_BACK_FOSSIL);
        this.item(UP2Items.BILL_FOSSIL);
        this.item(UP2Items.BOOMERANG_FOSSIL);
        this.item(UP2Items.RUNNER_FOSSIL);
        this.item(UP2Items.GUILLOTINE_FOSSIL);
        this.item(UP2Items.PLOW_FOSSIL);
        this.item(UP2Items.JAWLESS_FOSSIL);
        this.item(UP2Items.BOAR_TOOTH_FOSSIL);
        this.item(UP2Items.PRICKLY_FOSSIL);
        this.item(UP2Items.IMPERATIVE_FOSSIL);
        this.item(UP2Items.TRUNK_MOUSE_FOSSIL);
        this.item(UP2Items.FISH_FOSSIL);
        this.item(UP2Items.IMPERVIOUS_FOSSIL);
        this.item(UP2Items.RUGOSE_FOSSIL);
        this.item(UP2Items.ROACH_FOSSIL);
        this.item(UP2Items.THERMAL_FOSSIL);
        this.item(UP2Items.MELTDOWN_FOSSIL);
        this.item(UP2Items.SAW_FOSSIL);
        this.item(UP2Items.ANVIL_FOSSIL);
        this.item(UP2Items.CRANIUM_FOSSIL);
        this.item(UP2Items.FLIPPER_FOSSIL);
        this.item(UP2Items.CROOKED_BEAK_FOSSIL);
        this.item(UP2Items.WING_FOSSIL);
        this.item(UP2Items.MOSSY_FOSSIL);
        this.item(UP2Items.PLUMAGE_FOSSIL);
        this.item(UP2Items.SCYTHE_FOSSIL);
        this.item(UP2Items.AGED_FEATHER);
        this.item(UP2Items.DUBIOUS_FOSSIL);
        this.item(UP2Blocks.AEGIROCASSIS_EGGS);
        this.item(UP2Blocks.BARINASUCHUS_EGG);
        this.item(UP2Blocks.BRACHIOSAURUS_EGG);
        this.item(UP2Blocks.CARNOTAURUS_EGG);
        this.item(UP2Blocks.COELACANTHUS_ROE);
        this.item(UP2Blocks.DESMATOSUCHUS_EGG);
        this.item(UP2Items.DIMORPHODON_EGG);
        this.item(UP2Blocks.DIPLOCAULUS_EGGS);
        this.item(UP2Items.DROMAEOSAURUS_EGG);
        this.item(UP2Blocks.DUNKLEOSTEUS_SAC);
        this.item(UP2Blocks.HIBBERTOPTERUS_EGGS);
        this.item(UP2Blocks.JAWLESS_FISH_ROE);
        this.item(UP2Blocks.KAPROSUCHUS_EGG);
        this.item(UP2Blocks.KENTROSAURUS_EGG);
        this.item(UP2Blocks.KIMMERIDGEBRACHYPTERAESCHNIDIUM_EGGS);
        this.item(UP2Items.LEPTICTIDIUM_EMBRYO);
        this.item(UP2Blocks.LOBE_FINNED_FISH_ROE);
        this.item(UP2Blocks.LYSTROSAURUS_EGG);
        this.item(UP2Blocks.MAJUNGASAURUS_EGG);
        this.item(UP2Blocks.MANIPULATOR_OOTHECA);
        this.item(UP2Blocks.MEGALANIA_EGG);
        this.item(UP2Items.METRIORHYNCHUS_EMBRYO);
        this.item(UP2Blocks.ONCHOPRISTIS_SAC);
        this.item(UP2Blocks.PACHYCEPHALOSAURUS_EGG);
        this.item(UP2Items.PRAEPUSA_EMBRYO);
        this.item(UP2Items.PSILOPTERUS_EGG);
        this.item(UP2Items.PTERODACTYLUS_EGG);
        this.item(UP2Blocks.STETHACANTHUS_SAC);
        this.item(UP2Items.TALPANAS_EGG);
        this.item(UP2Blocks.TARTUOSTEUS_ROE);
        this.item(UP2Items.TELECREX_EGG);
        this.item(UP2Blocks.THERIZINOSAURUS_EGG);
        this.item(UP2Blocks.ULUGHBEGSAURUS_EGG);
        this.item(UP2Items.CALAMOPHYTON_FOSSIL);
        this.item(UP2Items.RAIGUENRAYUN_FOSSIL);
        this.item(UP2Items.GINKGO_FOSSIL);
        this.item(UP2Items.RHYNIA_FOSSIL);
        this.item(UP2Items.TEMPSKYA_FOSSIL);
        this.item(UP2Items.LEEFRUCTUS_FOSSIL);
        this.item(UP2Items.NEOMARIOPTERIS_FOSSIL);
        this.item(UP2Items.PROTOTAXITES_FOSSIL);
        this.item(UP2Items.QUILLWORT_FOSSIL);
        this.item(UP2Items.LEPIDODENDRON_FOSSIL);
        this.item(UP2Items.COOKSONIA_FOSSIL);
        this.item(UP2Items.CLADOPHLEBIS_FOSSIL);
        this.item(UP2Items.BENNETTITALES_FOSSIL);
        this.item(UP2Items.AETHOPHYLLUM_FOSSIL);
        this.item(UP2Items.BRACHYPHYLLUM_FOSSIL);
        this.item(UP2Items.GUANGDEDENDRON_FOSSIL);
        this.item(UP2Items.METASEQUOIA_FOSSIL);
        this.item(UP2Items.DRYOPHYLLUM_FOSSIL);
        this.item(UP2Items.CYCAD_FOSSIL);
        this.item(UP2Blocks.TEMPSKYA);
        this.item(UP2Blocks.BRACHYPHYLLUM);
        this.item(UP2Blocks.AETHOPHYLLUM);
        this.item(UP2Items.DRYOPHYLLUM_SIGN);
        this.item(UP2Items.DRYOPHYLLUM_HANGING_SIGN);
        this.item(UP2Items.DRYOPHYLLUM_BOAT);
        this.item(UP2Items.DRYOPHYLLUM_CHEST_BOAT);
        this.item(UP2Items.GINKGO_SIGN);
        this.item(UP2Items.GINKGO_HANGING_SIGN);
        this.item(UP2Items.GINKGO_BOAT);
        this.item(UP2Items.GINKGO_CHEST_BOAT);
        this.item(UP2Items.LEPIDODENDRON_SIGN);
        this.item(UP2Items.LEPIDODENDRON_HANGING_SIGN);
        this.item(UP2Items.LEPIDODENDRON_BOAT);
        this.item(UP2Items.LEPIDODENDRON_CHEST_BOAT);
        this.item(UP2Items.METASEQUOIA_SIGN);
        this.item(UP2Items.METASEQUOIA_HANGING_SIGN);
        this.item(UP2Items.METASEQUOIA_BOAT);
        this.item(UP2Items.METASEQUOIA_CHEST_BOAT);
        for (Item item : BuiltInRegistries.f_257033_) {
            if (!(item instanceof SpawnEggItem) || !Objects.requireNonNull(ForgeRegistries.ITEMS.getKey((Object)item)).m_135827_().equals("unusual_prehistory")) continue;
            ((ItemModelBuilder)this.getBuilder(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey((Object)item)).m_135815_())).parent((ModelFile)this.getExistingFile(new ResourceLocation("item/template_spawn_egg")));
        }
    }

    private ItemModelBuilder item(RegistryObject<?> item) {
        return this.generated(item.getId().m_135815_(), this.modLoc("item/" + item.getId().m_135815_()));
    }

    private void handheldItem(RegistryObject<?> item) {
        this.handheld(item.getId().m_135815_(), this.modLoc("item/" + item.getId().m_135815_()));
    }

    private void handheldRodItem(RegistryObject<?> item) {
        this.handheldRod(item.getId().m_135815_(), this.modLoc("item/" + item.getId().m_135815_()));
    }

    private ItemModelBuilder generated(String name, ResourceLocation ... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "item/generated");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    private void handheld(String name, ResourceLocation ... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "item/handheld");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
    }

    private void handheldRod(String name, ResourceLocation ... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "item/handheld_rod");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
    }
}


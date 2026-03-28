/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.tags.ItemTagsProvider
 *  net.minecraft.data.tags.TagsProvider$TagLookup
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.ItemTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraftforge.common.Tags$Blocks
 *  net.minecraftforge.common.Tags$Items
 *  net.minecraftforge.common.data.ExistingFileHelper
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class UP2ItemTagProvider
extends ItemTagsProvider {
    public UP2ItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> lookup, ExistingFileHelper helper) {
        super(output, provider, lookup, "unusual_prehistory", helper);
    }

    protected void m_6577_(@NotNull HolderLookup.Provider provider) {
        this.m_206424_(UP2ItemTags.FOSSILS).m_255179_((Object[])new Item[]{(Item)UP2Items.BRISTLE_FOSSIL.get(), (Item)UP2Items.BRUTE_FOSSIL.get(), (Item)UP2Items.ARM_FOSSIL.get(), (Item)UP2Items.FURY_FOSSIL.get(), (Item)UP2Items.GLUTTONOUS_FOSSIL.get(), (Item)UP2Items.BILL_FOSSIL.get(), (Item)UP2Items.BOOMERANG_FOSSIL.get(), (Item)UP2Items.RUNNER_FOSSIL.get(), (Item)UP2Items.GUILLOTINE_FOSSIL.get(), (Item)UP2Items.PLOW_FOSSIL.get(), (Item)UP2Items.JAWLESS_FOSSIL.get(), (Item)UP2Items.BOAR_TOOTH_FOSSIL.get(), (Item)UP2Items.PRICKLY_FOSSIL.get(), (Item)UP2Items.IMPERATIVE_FOSSIL.get(), (Item)UP2Items.RUGOSE_FOSSIL.get(), (Item)UP2Items.ROACH_FOSSIL.get(), (Item)UP2Items.THERMAL_FOSSIL.get(), (Item)UP2Items.MELTDOWN_FOSSIL.get(), (Item)UP2Items.SAW_FOSSIL.get(), (Item)UP2Items.ANVIL_FOSSIL.get(), (Item)UP2Items.PLUMAGE_FOSSIL.get(), (Item)UP2Items.FISH_FOSSIL.get(), (Item)UP2Items.TRUNK_MOUSE_FOSSIL.get(), (Item)UP2Items.IMPERVIOUS_FOSSIL.get(), (Item)UP2Items.CRANIUM_FOSSIL.get(), (Item)UP2Items.FLAT_BACK_FOSSIL.get(), (Item)UP2Items.MOSSY_FOSSIL.get(), (Item)UP2Items.SCYTHE_FOSSIL.get(), (Item)UP2Items.CROOKED_BEAK_FOSSIL.get(), (Item)UP2Items.WING_FOSSIL.get(), (Item)UP2Items.DUBIOUS_FOSSIL.get(), (Item)UP2Items.CALAMOPHYTON_FOSSIL.get(), (Item)UP2Items.DRYOPHYLLUM_FOSSIL.get(), (Item)UP2Items.RAIGUENRAYUN_FOSSIL.get(), (Item)UP2Items.GINKGO_FOSSIL.get(), (Item)UP2Items.CYCAD_FOSSIL.get(), (Item)UP2Items.RHYNIA_FOSSIL.get(), (Item)UP2Items.TEMPSKYA_FOSSIL.get(), (Item)UP2Items.LEEFRUCTUS_FOSSIL.get(), (Item)UP2Items.NEOMARIOPTERIS_FOSSIL.get(), (Item)UP2Items.METASEQUOIA_FOSSIL.get(), (Item)UP2Items.PROTOTAXITES_FOSSIL.get(), (Item)UP2Items.QUILLWORT_FOSSIL.get(), (Item)UP2Items.LEPIDODENDRON_FOSSIL.get(), (Item)UP2Items.COOKSONIA_FOSSIL.get(), (Item)UP2Items.CLADOPHLEBIS_FOSSIL.get(), (Item)UP2Items.BENNETTITALES_FOSSIL.get(), (Item)UP2Items.AETHOPHYLLUM_FOSSIL.get(), (Item)UP2Items.BRACHYPHYLLUM_FOSSIL.get(), (Item)UP2Items.GUANGDEDENDRON_FOSSIL.get()});
        this.m_206424_(UP2ItemTags.TRANSMOGRIFIER_FUEL).m_255245_((Object)((Item)UP2Items.ORGANIC_OOZE.get()));
        this.m_206424_(UP2ItemTags.RAW_MEATS).m_255179_((Object[])new Item[]{Items.f_42579_, Items.f_42485_, Items.f_42581_, Items.f_42658_, Items.f_42697_});
        this.m_206424_(UP2ItemTags.COOKED_MEATS).m_255179_((Object[])new Item[]{Items.f_42580_, Items.f_42486_, Items.f_42582_, Items.f_42659_, Items.f_42698_});
        this.m_206424_(UP2ItemTags.RAW_FISH).m_255179_((Object[])new Item[]{Items.f_42526_, Items.f_42527_, Items.f_42528_});
        this.m_206424_(UP2ItemTags.COOKED_FISH).m_255179_((Object[])new Item[]{Items.f_42530_, Items.f_42531_});
        this.m_206424_(UP2ItemTags.BRACHIOSAURUS_FOOD).m_206428_(ItemTags.f_13143_).m_255179_((Object[])new Item[]{Blocks.f_50575_.m_5456_(), Blocks.f_50037_.m_5456_()});
        this.m_206424_(UP2ItemTags.CARNOTAURUS_FOOD).addTags(new TagKey[]{UP2ItemTags.RAW_MEATS, UP2ItemTags.COOKED_MEATS});
        this.m_206424_(UP2ItemTags.DIPLOCAULUS_FOOD).m_255245_((Object)Items.f_42591_);
        this.m_206424_(UP2ItemTags.DROMAEOSAURUS_FOOD).m_255179_((Object[])new Item[]{Items.f_42581_, Items.f_42582_});
        this.m_206424_(UP2ItemTags.DUNKLEOSTEUS_FOOD).addTags(new TagKey[]{UP2ItemTags.RAW_FISH, UP2ItemTags.COOKED_FISH});
        this.m_206424_(UP2ItemTags.HIBBERTOPTERUS_FOOD).m_255179_((Object[])new Item[]{Blocks.f_50493_.m_5456_(), Blocks.f_50546_.m_5456_(), Blocks.f_50599_.m_5456_(), Blocks.f_50093_.m_5456_()});
        this.m_206424_(UP2ItemTags.JAWLESS_FISH_FOOD).m_255245_((Object)Items.f_41867_);
        this.m_206424_(UP2ItemTags.KAPROSUCHUS_FOOD).addTags(new TagKey[]{UP2ItemTags.RAW_MEATS, UP2ItemTags.COOKED_MEATS, UP2ItemTags.RAW_FISH, UP2ItemTags.COOKED_FISH});
        this.m_206424_(UP2ItemTags.KENTROSAURUS_FOOD).m_255179_((Object[])new Item[]{Items.f_41982_, Items.f_42780_});
        this.m_206424_(UP2ItemTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_FOOD).m_255245_((Object)Items.f_42591_);
        this.m_206424_(UP2ItemTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_FOOD).addTags(new TagKey[]{UP2ItemTags.RAW_FISH, UP2ItemTags.COOKED_FISH});
        this.m_206424_(UP2ItemTags.LEPTICTIDIUM_FOOD).m_255245_((Object)Items.f_42780_);
        this.m_206424_(UP2ItemTags.LOBE_FINNED_FISH_FOOD).m_255245_((Object)Blocks.f_50037_.m_5456_());
        this.m_206424_(UP2ItemTags.LYSTROSAURUS_FOOD).m_255245_((Object)Blocks.f_50034_.m_5456_());
        this.m_206424_(UP2ItemTags.MAJUNGASAURUS_FOOD).addTags(new TagKey[]{UP2ItemTags.RAW_MEATS, UP2ItemTags.COOKED_MEATS});
        this.m_206424_(UP2ItemTags.MEGALANIA_FOOD).addTags(new TagKey[]{UP2ItemTags.RAW_MEATS, UP2ItemTags.COOKED_MEATS});
        this.m_206424_(UP2ItemTags.METRIORHYNCHUS_FOOD).addTags(new TagKey[]{UP2ItemTags.RAW_FISH, UP2ItemTags.COOKED_FISH});
        this.m_206424_(UP2ItemTags.ONCHOPRISTIS_FOOD).addTags(new TagKey[]{UP2ItemTags.RAW_FISH, UP2ItemTags.COOKED_FISH});
        this.m_206424_(UP2ItemTags.PACHYCEPHALOSAURUS_FOOD).m_255179_((Object[])new Item[]{Items.f_42780_, Items.f_42410_, Items.f_42028_});
        this.m_206424_(UP2ItemTags.PRAEPUSA_FOOD).m_255179_((Object[])new Item[]{Items.f_42526_, Items.f_42527_, Items.f_42530_, Items.f_42531_});
        this.m_206424_(UP2ItemTags.PTERODACTYLUS_FOOD).m_255179_((Object[])new Item[]{Items.f_42410_, Items.f_42780_, Items.f_42575_});
        this.m_206424_(UP2ItemTags.STETHACANTHUS_FOOD).addTags(new TagKey[]{UP2ItemTags.RAW_FISH, UP2ItemTags.COOKED_FISH});
        this.m_206424_(UP2ItemTags.TALPANAS_FOOD).m_255179_((Object[])new Item[]{Blocks.f_152548_.m_5456_(), Items.f_42780_});
        this.m_206424_(UP2ItemTags.TARTUOSTEUS_FOOD).m_255179_((Object[])new Item[]{Blocks.f_50037_.m_5456_(), Blocks.f_152544_.m_5456_(), Blocks.f_152543_.m_5456_(), ((Block)UP2Blocks.MOSS_LAYER.get()).m_5456_()});
        this.m_206424_(UP2ItemTags.TELECREX_FOOD).m_255179_((Object[])new Item[]{Items.f_42780_, Items.f_151079_});
        this.m_206424_(UP2ItemTags.ULUGHBEGSAURUS_FOOD).addTags(new TagKey[]{UP2ItemTags.RAW_MEATS, UP2ItemTags.COOKED_MEATS});
        this.m_206424_(UP2ItemTags.UNICORN_FOOD).m_255245_((Object)Items.f_42502_);
        this.m_206424_(UP2ItemTags.TAMES_ULUGHBEGSAURUS).m_206428_(UP2ItemTags.ULUGHBEGSAURUS_FOOD);
        this.m_206424_(UP2ItemTags.TAMES_KAPROSUCHUS).m_255245_((Object)Items.f_42500_);
        this.m_206424_(UP2ItemTags.TAMES_MEGALANIA).m_255245_((Object)Items.f_42583_);
        this.m_206424_(UP2ItemTags.PERMANENTLY_PACIFIES_MOB).m_255245_((Object)Items.f_42437_);
        this.m_206424_(UP2ItemTags.PACIFIES_CARNOTAURUS).m_206428_(UP2ItemTags.CARNOTAURUS_FOOD);
        this.m_206424_(UP2ItemTags.PACIFIES_DROMAEOSAURUS).m_206428_(UP2ItemTags.DROMAEOSAURUS_FOOD);
        this.m_206424_(UP2ItemTags.PACIFIES_DUNKLEOSTEUS).m_206428_(UP2ItemTags.DUNKLEOSTEUS_FOOD);
        this.m_206424_(UP2ItemTags.PACIFIES_KAPROSUCHUS).m_206428_(UP2ItemTags.KAPROSUCHUS_FOOD);
        this.m_206424_(UP2ItemTags.PACIFIES_MAJUNGASAURUS).m_206428_(UP2ItemTags.MAJUNGASAURUS_FOOD);
        this.m_206424_(UP2ItemTags.PACIFIES_MEGALANIA).m_206428_(UP2ItemTags.MEGALANIA_FOOD);
        this.m_206424_(UP2ItemTags.PACIFIES_METRIORHYNCHUS).m_206428_(UP2ItemTags.METRIORHYNCHUS_FOOD);
        this.m_206424_(UP2ItemTags.PACIFIES_ONCHOPRISTIS).m_206428_(UP2ItemTags.ONCHOPRISTIS_FOOD);
        this.m_206424_(UP2ItemTags.PACIFIES_STETHACANTHUS).m_206428_(UP2ItemTags.STETHACANTHUS_FOOD);
        this.m_206424_(UP2ItemTags.PACIFIES_PRAEPUSA).m_255245_((Object)Items.f_42528_);
        this.m_206424_(UP2ItemTags.PACIFIES_ULUGHBEGSAURUS).m_206428_(UP2ItemTags.ULUGHBEGSAURUS_FOOD);
        this.m_206424_(UP2ItemTags.AMBER_DYES).m_176839_(new ResourceLocation("dye_depot", "amber_dye"));
        this.m_206424_(UP2ItemTags.AQUA_DYES).m_176839_(new ResourceLocation("dye_depot", "aqua_dye"));
        this.m_206424_(UP2ItemTags.BEIGE_DYES).m_176839_(new ResourceLocation("dye_depot", "beige_dye"));
        this.m_206424_(UP2ItemTags.CORAL_DYES).m_176839_(new ResourceLocation("dye_depot", "coral_dye"));
        this.m_206424_(UP2ItemTags.FOREST_DYES).m_176839_(new ResourceLocation("dye_depot", "forest_dye"));
        this.m_206424_(UP2ItemTags.GINGER_DYES).m_176839_(new ResourceLocation("dye_depot", "ginger_dye"));
        this.m_206424_(UP2ItemTags.INDIGO_DYES).m_176839_(new ResourceLocation("dye_depot", "indigo_dye"));
        this.m_206424_(UP2ItemTags.MAROON_DYES).m_176839_(new ResourceLocation("dye_depot", "maroon_dye"));
        this.m_206424_(UP2ItemTags.MINT_DYES).m_176839_(new ResourceLocation("dye_depot", "mint_dye"));
        this.m_206424_(UP2ItemTags.NAVY_DYES).m_176839_(new ResourceLocation("dye_depot", "navy_dye"));
        this.m_206424_(UP2ItemTags.OLIVE_DYES).m_176839_(new ResourceLocation("dye_depot", "olive_dye"));
        this.m_206424_(UP2ItemTags.ROSE_DYES).m_176839_(new ResourceLocation("dye_depot", "rose_dye"));
        this.m_206424_(UP2ItemTags.SLATE_DYES).m_176839_(new ResourceLocation("dye_depot", "slate_dye"));
        this.m_206424_(UP2ItemTags.TAN_DYES).m_176839_(new ResourceLocation("dye_depot", "tan_dye"));
        this.m_206424_(UP2ItemTags.TEAL_DYES).m_176839_(new ResourceLocation("dye_depot", "teal_dye"));
        this.m_206424_(UP2ItemTags.VERDANT_DYES).m_176839_(new ResourceLocation("dye_depot", "verdant_dye"));
        this.m_206424_(UP2ItemTags.STOPS_MOB_AGING).m_255245_((Object)Items.f_42675_);
        this.m_206421_(UP2BlockTags.DRYOPHYLLUM_LOGS, UP2ItemTags.DRYOPHYLLUM_LOGS);
        this.m_206421_(UP2BlockTags.GINKGO_LOGS, UP2ItemTags.GINKGO_LOGS);
        this.m_206421_(UP2BlockTags.LEPIDODENDRON_LOGS, UP2ItemTags.LEPIDODENDRON_LOGS);
        this.m_206421_(UP2BlockTags.METASEQUOIA_LOGS, UP2ItemTags.METASEQUOIA_LOGS);
        this.m_206421_(BlockTags.f_13035_, ItemTags.f_13143_);
        this.m_206421_(BlockTags.f_13105_, ItemTags.f_13181_);
        this.m_206421_(BlockTags.f_13090_, ItemTags.f_13168_);
        this.m_206421_(BlockTags.f_13104_, ItemTags.f_13180_);
        this.m_206421_(BlockTags.f_13037_, ItemTags.f_13145_);
        this.m_206421_(BlockTags.f_13040_, ItemTags.f_13148_);
        this.m_206421_(BlockTags.f_13092_, ItemTags.f_13170_);
        this.m_206421_(BlockTags.f_13095_, ItemTags.f_13173_);
        this.m_206421_(BlockTags.f_13102_, ItemTags.f_13178_);
        this.m_206421_(BlockTags.f_13098_, ItemTags.f_13176_);
        this.m_206421_(BlockTags.f_13100_, ItemTags.f_13177_);
        this.m_206421_(BlockTags.f_13097_, ItemTags.f_13175_);
        this.m_206421_(BlockTags.f_13096_, ItemTags.f_13174_);
        this.m_206421_(BlockTags.f_13055_, ItemTags.f_254662_);
        this.m_206421_(Tags.Blocks.FENCE_GATES, Tags.Items.FENCE_GATES);
        this.m_206421_(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
        this.m_206421_(BlockTags.f_13031_, ItemTags.f_13139_);
        this.m_206421_(BlockTags.f_13030_, ItemTags.f_13138_);
        this.m_206421_(BlockTags.f_279568_, ItemTags.f_279629_);
        this.m_206421_(UP2BlockTags.REINFORCED_GLASS, UP2ItemTags.REINFORCED_GLASS);
        this.m_206424_(Tags.Items.GLASS).m_206428_(UP2ItemTags.REINFORCED_GLASS);
        this.m_206424_(ItemTags.f_13157_).m_255179_((Object[])new Item[]{(Item)UP2Items.DRYOPHYLLUM_SIGN.get(), (Item)UP2Items.GINKGO_SIGN.get(), (Item)UP2Items.LEPIDODENDRON_SIGN.get(), (Item)UP2Items.METASEQUOIA_SIGN.get()});
        this.m_206424_(ItemTags.f_244389_).m_255179_((Object[])new Item[]{(Item)UP2Items.DRYOPHYLLUM_HANGING_SIGN.get(), (Item)UP2Items.GINKGO_HANGING_SIGN.get(), (Item)UP2Items.LEPIDODENDRON_HANGING_SIGN.get(), (Item)UP2Items.METASEQUOIA_HANGING_SIGN.get()});
        this.m_206424_(ItemTags.f_13155_).m_255179_((Object[])new Item[]{(Item)UP2Items.DRYOPHYLLUM_BOAT.get(), (Item)UP2Items.GINKGO_BOAT.get(), (Item)UP2Items.LEPIDODENDRON_BOAT.get(), (Item)UP2Items.METASEQUOIA_BOAT.get()});
        this.m_206424_(ItemTags.f_215864_).m_255179_((Object[])new Item[]{(Item)UP2Items.DRYOPHYLLUM_CHEST_BOAT.get(), (Item)UP2Items.GINKGO_CHEST_BOAT.get(), (Item)UP2Items.LEPIDODENDRON_CHEST_BOAT.get(), (Item)UP2Items.METASEQUOIA_CHEST_BOAT.get()});
        this.m_206424_(ItemTags.f_13158_).m_255179_((Object[])new Item[]{(Item)UP2Items.DOOMSURF_DISC.get(), (Item)UP2Items.MEGALANIA_DISC.get(), (Item)UP2Items.TARIFYING_DISC.get()});
        this.m_206424_(UP2ItemTags.FRUITS).m_206428_(UP2ItemTags.FRUITS_GINKGO);
        this.m_206424_(UP2ItemTags.FRUITS_GINKGO).m_255245_((Object)((Item)UP2Items.GINKGO_FRUIT.get()));
    }
}


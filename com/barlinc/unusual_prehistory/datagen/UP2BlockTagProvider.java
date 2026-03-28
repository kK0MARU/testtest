/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraftforge.common.Tags$Blocks
 *  net.minecraftforge.common.data.BlockTagsProvider
 *  net.minecraftforge.common.data.ExistingFileHelper
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class UP2BlockTagProvider
extends BlockTagsProvider {
    public UP2BlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, "unusual_prehistory", helper);
    }

    protected void m_6577_(@NotNull HolderLookup.Provider provider) {
        this.m_206424_(UP2BlockTags.DRYOPHYLLUM_LOGS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_LOG.get(), (Block)UP2Blocks.DRYOPHYLLUM_WOOD.get(), (Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_LOG.get(), (Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_WOOD.get()});
        this.m_206424_(UP2BlockTags.GINKGO_LOGS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.GINKGO_LOG.get(), (Block)UP2Blocks.GINKGO_WOOD.get(), (Block)UP2Blocks.STRIPPED_GINKGO_LOG.get(), (Block)UP2Blocks.STRIPPED_GINKGO_WOOD.get()});
        this.m_206424_(UP2BlockTags.LEPIDODENDRON_LOGS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.LEPIDODENDRON_WOOD.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_WOOD.get(), (Block)UP2Blocks.STRIPPED_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.STRIPPED_LEPIDODENDRON_WOOD.get()});
        this.m_206424_(UP2BlockTags.METASEQUOIA_LOGS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.METASEQUOIA_LOG.get(), (Block)UP2Blocks.METASEQUOIA_WOOD.get(), (Block)UP2Blocks.STRIPPED_METASEQUOIA_LOG.get(), (Block)UP2Blocks.STRIPPED_METASEQUOIA_WOOD.get()});
        this.m_206424_(UP2BlockTags.ANCIENT_PLANT_PLACEABLE).m_206428_(BlockTags.f_13029_).m_206428_(BlockTags.f_144274_).m_255245_((Object)Blocks.f_49994_).m_255245_((Object)Blocks.f_50093_);
        this.m_206424_(UP2BlockTags.ACCELERATES_EGG_HATCHING).m_206428_(BlockTags.f_13089_).m_255179_((Object[])new Block[]{Blocks.f_50335_, Blocks.f_152544_});
        this.m_206424_(UP2BlockTags.PREVENTS_EGG_HATCHING).m_206428_(BlockTags.f_13047_);
        this.m_206424_(UP2BlockTags.FOSSIL_REPLACEABLE).m_206428_(BlockTags.f_144274_).m_255245_((Object)Blocks.f_49994_);
        this.m_206424_(UP2BlockTags.TAR_PIT_REPLACEABLE).m_206428_(BlockTags.f_144274_).m_255245_((Object)Blocks.f_49994_);
        this.m_206424_(UP2BlockTags.PETRIFIED_TREE_REPLACEABLE).m_206428_(BlockTags.f_144274_).m_255245_((Object)Blocks.f_49994_);
        this.m_206424_(UP2BlockTags.REINFORCED_GLASS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.REINFORCED_GLASS.get(), (Block)UP2Blocks.TINTED_REINFORCED_GLASS.get(), (Block)UP2Blocks.WHITE_REINFORCED_GLASS.get(), (Block)UP2Blocks.LIGHT_GRAY_REINFORCED_GLASS.get(), (Block)UP2Blocks.GRAY_REINFORCED_GLASS.get(), (Block)UP2Blocks.BLACK_REINFORCED_GLASS.get(), (Block)UP2Blocks.BROWN_REINFORCED_GLASS.get(), (Block)UP2Blocks.RED_REINFORCED_GLASS.get(), (Block)UP2Blocks.ORANGE_REINFORCED_GLASS.get(), (Block)UP2Blocks.YELLOW_REINFORCED_GLASS.get(), (Block)UP2Blocks.LIME_REINFORCED_GLASS.get(), (Block)UP2Blocks.GREEN_REINFORCED_GLASS.get(), (Block)UP2Blocks.CYAN_REINFORCED_GLASS.get(), (Block)UP2Blocks.LIGHT_BLUE_REINFORCED_GLASS.get(), (Block)UP2Blocks.BLUE_REINFORCED_GLASS.get(), (Block)UP2Blocks.PURPLE_REINFORCED_GLASS.get(), (Block)UP2Blocks.MAGENTA_REINFORCED_GLASS.get(), (Block)UP2Blocks.PINK_REINFORCED_GLASS.get()});
        this.m_206424_(UP2BlockTags.FOSSILIZED_BONE_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.FOSSILIZED_BONE_BLOCK.get(), (Block)UP2Blocks.FOSSILIZED_BONE_BARK.get(), (Block)UP2Blocks.FOSSILIZED_BONE_VERTEBRA.get()});
        this.m_206424_(UP2BlockTags.PETRIFIED_WOOD).m_255179_((Object[])new Block[]{(Block)UP2Blocks.PETRIFIED_LOG.get(), (Block)UP2Blocks.PETRIFIED_WOOD.get()});
        this.m_206424_(UP2BlockTags.GUANGDEDENDRON_PLANTABLE_ON).m_206428_(BlockTags.f_13029_).m_206428_(BlockTags.f_144274_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.GUANGDEDENDRON.get(), (Block)UP2Blocks.GUANGDEDENDRON_SPORE.get(), Blocks.f_49994_, Blocks.f_276445_});
        this.m_206424_(UP2BlockTags.GUARDED_BY_KENTROSAURUS).m_255179_((Object[])new Block[]{Blocks.f_50685_, Blocks.f_50128_});
        this.m_206424_(UP2BlockTags.BARINASUCHUS_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.BRACHIOSAURUS_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.CARNOTAURUS_SPAWNABLE_ON).m_255179_((Object[])new Block[]{Blocks.f_50546_, Blocks.f_49993_, Blocks.f_50440_}).m_206428_(BlockTags.f_198156_);
        this.m_206424_(UP2BlockTags.DESMATOSUCHUS_SPAWNABLE_ON).m_255179_((Object[])new Block[]{Blocks.f_49992_, Blocks.f_50440_});
        this.m_206424_(UP2BlockTags.DIMORPHODON_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.DIPLOCAULUS_SPAWNABLE_ON).m_255179_((Object[])new Block[]{Blocks.f_220864_, Blocks.f_50440_});
        this.m_206424_(UP2BlockTags.DROMAEOSAURUS_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.HIBBERTOPTERUS_SPAWNABLE_ON).m_255179_((Object[])new Block[]{Blocks.f_50440_, Blocks.f_220864_});
        this.m_206424_(UP2BlockTags.KAPROSUCHUS_SPAWNABLE_ON).m_255179_((Object[])new Block[]{Blocks.f_50440_, Blocks.f_49994_, Blocks.f_49992_});
        this.m_206424_(UP2BlockTags.KENTROSAURUS_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_SPAWNABLE_ON).m_255179_((Object[])new Block[]{Blocks.f_50440_, Blocks.f_220864_});
        this.m_206424_(UP2BlockTags.LEPTICTIDIUM_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.LYSTROSAURUS_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.MAJUNGASAURUS_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.MANIPULATOR_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.MEGALANIA_SPAWNABLE_ON).m_255179_((Object[])new Block[]{Blocks.f_50440_, Blocks.f_49992_, Blocks.f_49993_});
        this.m_206424_(UP2BlockTags.PACHYCEPHALOSAURUS_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.PRAEPUSA_SPAWNABLE_ON).m_255245_((Object)Blocks.f_49992_);
        this.m_206424_(UP2BlockTags.PSILOPTERUS_SPAWNABLE_ON).m_255179_((Object[])new Block[]{Blocks.f_50440_, Blocks.f_50546_});
        this.m_206424_(UP2BlockTags.PTERODACTYLUS_SPAWNABLE_ON).m_255179_((Object[])new Block[]{Blocks.f_50440_, Blocks.f_50069_});
        this.m_206424_(UP2BlockTags.TALPANAS_SPAWNABLE_ON).m_255179_((Object[])new Block[]{Blocks.f_152544_, Blocks.f_50129_, Blocks.f_50440_});
        this.m_206424_(UP2BlockTags.TELECREX_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.THERIZINOSAURUS_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.ULUGHBEGSAURUS_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.UNICORN_SPAWNABLE_ON).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.DESMATOSUCHUS_PREFERRED_WALKING_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSSY_DIRT.get(), Blocks.f_152544_, Blocks.f_220864_, Blocks.f_49992_, Blocks.f_50493_, Blocks.f_152549_, Blocks.f_50546_, Blocks.f_220843_, Blocks.f_50125_, Blocks.f_50127_});
        this.m_206424_(UP2BlockTags.DESMATOSUCHUS_ROLLING_BLOCKS).m_206428_(UP2BlockTags.DESMATOSUCHUS_PREFERRED_WALKING_BLOCKS);
        this.m_206424_(UP2BlockTags.DESMATOSUCHUS_MOSSY_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSSY_DIRT.get(), Blocks.f_152544_});
        this.m_206424_(UP2BlockTags.DESMATOSUCHUS_MUDDY_BLOCKS).m_255245_((Object)Blocks.f_220864_);
        this.m_206424_(UP2BlockTags.DESMATOSUCHUS_SNOWY_BLOCKS).m_255179_((Object[])new Block[]{Blocks.f_50127_, Blocks.f_50125_});
        this.m_206424_(UP2BlockTags.DIPLOCAULUS_PREFERRED_WALKING_BLOCKS).m_255245_((Object)Blocks.f_220864_);
        this.m_206424_(UP2BlockTags.DIPLOCAULUS_SLIDING_BLOCKS).m_255179_((Object[])new Block[]{Blocks.f_220864_, Blocks.f_50126_, Blocks.f_50354_, Blocks.f_50568_, Blocks.f_50127_});
        this.m_206424_(UP2BlockTags.DIPLOCAULUS_BURROWING_BLOCKS).m_255179_((Object[])new Block[]{Blocks.f_220864_, Blocks.f_49992_, Blocks.f_49994_});
        this.m_206424_(UP2BlockTags.LYSTROSAURUS_DIGGING_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSSY_DIRT.get(), Blocks.f_50440_, Blocks.f_50493_, Blocks.f_50546_, Blocks.f_50127_, Blocks.f_49992_, Blocks.f_152549_, Blocks.f_220843_});
        this.m_206424_(UP2BlockTags.DESMATOSUCHUS_GRAZING_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSSY_DIRT.get(), Blocks.f_152544_, Blocks.f_152549_});
        this.m_206424_(UP2BlockTags.JAWLESS_FISH_NIBBLING_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSS_LAYER.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_WOOD.get(), Blocks.f_50037_, Blocks.f_50038_, Blocks.f_152544_, Blocks.f_152543_}).m_206428_(Tags.Blocks.COBBLESTONE_MOSSY);
        this.m_206424_(UP2BlockTags.KENTROSAURUS_GRAZING_BLOCKS).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.LOBE_FINNED_FISH_NIBBLING_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSS_LAYER.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_WOOD.get(), Blocks.f_50037_, Blocks.f_50038_, Blocks.f_152544_, Blocks.f_152543_}).m_206428_(Tags.Blocks.COBBLESTONE_MOSSY);
        this.m_206424_(UP2BlockTags.LYSTROSAURUS_GRAZING_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSSY_DIRT.get(), Blocks.f_50440_});
        this.m_206424_(UP2BlockTags.PACHYCEPHALOSAURUS_GRAZING_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSSY_DIRT.get(), Blocks.f_50440_});
        this.m_206424_(UP2BlockTags.PSILOPTERUS_DIGGING_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSSY_DIRT.get(), Blocks.f_50440_, Blocks.f_50493_, Blocks.f_50546_, Blocks.f_50127_, Blocks.f_50125_, Blocks.f_50599_, Blocks.f_152549_, Blocks.f_49994_});
        this.m_206424_(UP2BlockTags.TALPANAS_PECKING_BLOCKS).m_255179_((Object[])new Block[]{Blocks.f_50440_, Blocks.f_152544_});
        this.m_206424_(UP2BlockTags.TARTUOSTEUS_NIBBLING_BLOCKS).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSS_LAYER.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_WOOD.get(), Blocks.f_50037_, Blocks.f_50038_, Blocks.f_152544_, Blocks.f_152543_}).m_206428_(Tags.Blocks.COBBLESTONE_MOSSY);
        this.m_206424_(UP2BlockTags.TELECREX_PECKING_BLOCKS).m_255245_((Object)Blocks.f_50440_);
        this.m_206424_(UP2BlockTags.THERIZINOSAURUS_FORAGING_BLOCKS).m_206428_(BlockTags.f_13035_);
        this.m_206424_(BlockTags.f_144282_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.TRANSMOGRIFIER.get(), (Block)UP2Blocks.PALEOSTONE.get(), (Block)UP2Blocks.PALEOSTONE_STAIRS.get(), (Block)UP2Blocks.PALEOSTONE_SLAB.get(), (Block)UP2Blocks.MESONITE.get(), (Block)UP2Blocks.MESONITE_STAIRS.get(), (Block)UP2Blocks.MESONITE_SLAB.get(), (Block)UP2Blocks.FLORALITE.get(), (Block)UP2Blocks.FLORALITE_STAIRS.get(), (Block)UP2Blocks.FLORALITE_SLAB.get(), (Block)UP2Blocks.FOSSILIZED_BONE_BLOCK.get(), (Block)UP2Blocks.FOSSILIZED_BONE_BARK.get(), (Block)UP2Blocks.FOSSILIZED_BONE_VERTEBRA.get(), (Block)UP2Blocks.FOSSILIZED_SKULL.get(), (Block)UP2Blocks.FOSSILIZED_SKULL_LANTERN.get(), (Block)UP2Blocks.FOSSILIZED_SKULL_SOUL_LANTERN.get(), (Block)UP2Blocks.COBBLED_FOSSILIZED_BONE.get(), (Block)UP2Blocks.COBBLED_FOSSILIZED_BONE_STAIRS.get(), (Block)UP2Blocks.COBBLED_FOSSILIZED_BONE_SLAB.get(), (Block)UP2Blocks.FOSSILIZED_BONE_ROD.get(), (Block)UP2Blocks.FOSSILIZED_BONE_SPIKE.get(), (Block)UP2Blocks.FOSSILIZED_BONE_ROW.get(), (Block)UP2Blocks.PETRIFIED_LOG.get(), (Block)UP2Blocks.PETRIFIED_WOOD.get(), (Block)UP2Blocks.POLISHED_PETRIFIED_WOOD.get(), (Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_STAIRS.get(), (Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_SLAB.get(), (Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_PRESSURE_PLATE.get(), (Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_BUTTON.get(), (Block)UP2Blocks.ASPHALT.get(), (Block)UP2Blocks.OOZE_CAULDRON.get()}).m_206428_(UP2BlockTags.REINFORCED_GLASS);
        this.m_206424_(BlockTags.f_13049_).m_206428_(UP2BlockTags.REINFORCED_GLASS);
        this.m_206424_(BlockTags.f_144280_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.HORSETAIL.get(), (Block)UP2Blocks.LARGE_HORSETAIL.get(), (Block)UP2Blocks.GUANGDEDENDRON.get(), (Block)UP2Blocks.GUANGDEDENDRON_SPORE.get(), (Block)UP2Blocks.CYCAD_STEM.get(), (Block)UP2Blocks.CYCAD_CROWN.get(), (Block)UP2Blocks.DRYOPHYLLUM_LOG.get(), (Block)UP2Blocks.DRYOPHYLLUM_WOOD.get(), (Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_LOG.get(), (Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_WOOD.get(), (Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get(), (Block)UP2Blocks.DRYOPHYLLUM_STAIRS.get(), (Block)UP2Blocks.DRYOPHYLLUM_SLAB.get(), (Block)UP2Blocks.DRYOPHYLLUM_FENCE.get(), (Block)UP2Blocks.DRYOPHYLLUM_FENCE_GATE.get(), (Block)UP2Blocks.DRYOPHYLLUM_PRESSURE_PLATE.get(), (Block)UP2Blocks.DRYOPHYLLUM_BUTTON.get(), (Block)UP2Blocks.DRYOPHYLLUM_DOOR.get(), (Block)UP2Blocks.DRYOPHYLLUM_TRAPDOOR.get(), (Block)UP2Blocks.GINKGO_LOG.get(), (Block)UP2Blocks.GINKGO_WOOD.get(), (Block)UP2Blocks.STRIPPED_GINKGO_LOG.get(), (Block)UP2Blocks.STRIPPED_GINKGO_WOOD.get(), (Block)UP2Blocks.GINKGO_PLANKS.get(), (Block)UP2Blocks.GINKGO_STAIRS.get(), (Block)UP2Blocks.GINKGO_SLAB.get(), (Block)UP2Blocks.GINKGO_FENCE.get(), (Block)UP2Blocks.GINKGO_FENCE_GATE.get(), (Block)UP2Blocks.GINKGO_PRESSURE_PLATE.get(), (Block)UP2Blocks.GINKGO_BUTTON.get(), (Block)UP2Blocks.GINKGO_DOOR.get(), (Block)UP2Blocks.GINKGO_TRAPDOOR.get(), (Block)UP2Blocks.LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.LEPIDODENDRON_WOOD.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_WOOD.get(), (Block)UP2Blocks.STRIPPED_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.STRIPPED_LEPIDODENDRON_WOOD.get(), (Block)UP2Blocks.LEPIDODENDRON_PLANKS.get(), (Block)UP2Blocks.LEPIDODENDRON_STAIRS.get(), (Block)UP2Blocks.LEPIDODENDRON_SLAB.get(), (Block)UP2Blocks.LEPIDODENDRON_FENCE.get(), (Block)UP2Blocks.LEPIDODENDRON_FENCE_GATE.get(), (Block)UP2Blocks.LEPIDODENDRON_PRESSURE_PLATE.get(), (Block)UP2Blocks.LEPIDODENDRON_BUTTON.get(), (Block)UP2Blocks.LEPIDODENDRON_DOOR.get(), (Block)UP2Blocks.LEPIDODENDRON_TRAPDOOR.get(), (Block)UP2Blocks.METASEQUOIA_LOG.get(), (Block)UP2Blocks.METASEQUOIA_WOOD.get(), (Block)UP2Blocks.STRIPPED_METASEQUOIA_LOG.get(), (Block)UP2Blocks.STRIPPED_METASEQUOIA_WOOD.get(), (Block)UP2Blocks.METASEQUOIA_PLANKS.get(), (Block)UP2Blocks.METASEQUOIA_STAIRS.get(), (Block)UP2Blocks.METASEQUOIA_SLAB.get(), (Block)UP2Blocks.METASEQUOIA_FENCE.get(), (Block)UP2Blocks.METASEQUOIA_FENCE_GATE.get(), (Block)UP2Blocks.METASEQUOIA_PRESSURE_PLATE.get(), (Block)UP2Blocks.METASEQUOIA_BUTTON.get(), (Block)UP2Blocks.METASEQUOIA_DOOR.get(), (Block)UP2Blocks.METASEQUOIA_TRAPDOOR.get()});
        this.m_206424_(BlockTags.f_144281_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.MOSS_LAYER.get(), (Block)UP2Blocks.DRYOPHYLLUM_LEAVES.get(), (Block)UP2Blocks.GINKGO_LEAVES.get(), (Block)UP2Blocks.GOLDEN_GINKGO_LEAVES.get(), (Block)UP2Blocks.LEPIDODENDRON_LEAVES.get(), (Block)UP2Blocks.METASEQUOIA_LEAVES.get()});
        this.m_206424_(BlockTags.f_144283_).m_255245_((Object)((Block)UP2Blocks.MOSSY_DIRT.get()));
        this.m_206424_(BlockTags.f_278398_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.GUANGDEDENDRON_SPORE.get(), (Block)UP2Blocks.GUANGDEDENDRON.get()});
        this.m_206424_(BlockTags.f_13031_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.PALEOSTONE_SLAB.get(), (Block)UP2Blocks.MESONITE_SLAB.get(), (Block)UP2Blocks.FLORALITE_SLAB.get(), (Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_SLAB.get()});
        this.m_206424_(BlockTags.f_13030_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.PALEOSTONE_STAIRS.get(), (Block)UP2Blocks.MESONITE_STAIRS.get(), (Block)UP2Blocks.FLORALITE_STAIRS.get(), (Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_STAIRS.get()});
        this.m_206424_(BlockTags.f_13101_).m_255245_((Object)((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_PRESSURE_PLATE.get()));
        this.m_206424_(BlockTags.f_279568_).m_255245_((Object)((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_BUTTON.get()));
        this.m_206424_(BlockTags.f_278394_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.HORSETAIL.get(), (Block)UP2Blocks.LARGE_HORSETAIL.get()});
        this.m_206424_(BlockTags.f_278411_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.HORSETAIL.get(), (Block)UP2Blocks.LARGE_HORSETAIL.get(), (Block)UP2Blocks.RAIGUENRAYUN.get(), (Block)UP2Blocks.AETHOPHYLLUM.get()});
        this.m_206424_(BlockTags.f_144274_).m_255245_((Object)((Block)UP2Blocks.MOSSY_DIRT.get()));
        this.m_206424_(BlockTags.f_13037_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.COOKSONIA.get(), (Block)UP2Blocks.LEEFRUCTUS.get()});
        this.m_206424_(BlockTags.f_13040_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.AETHOPHYLLUM.get(), (Block)UP2Blocks.RAIGUENRAYUN.get()});
        this.m_206424_(BlockTags.f_13104_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_SAPLING.get(), (Block)UP2Blocks.GINKGO_SAPLING.get(), (Block)UP2Blocks.GOLDEN_GINKGO_SAPLING.get(), (Block)UP2Blocks.LEPIDODENDRON_CONE.get()});
        this.m_206424_(BlockTags.f_13035_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_LEAVES.get(), (Block)UP2Blocks.GINKGO_LEAVES.get(), (Block)UP2Blocks.GOLDEN_GINKGO_LEAVES.get(), (Block)UP2Blocks.LEPIDODENDRON_LEAVES.get()});
        this.m_206424_(BlockTags.f_13105_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_LOG.get(), (Block)UP2Blocks.DRYOPHYLLUM_WOOD.get(), (Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_LOG.get(), (Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_WOOD.get(), (Block)UP2Blocks.GINKGO_LOG.get(), (Block)UP2Blocks.GINKGO_WOOD.get(), (Block)UP2Blocks.STRIPPED_GINKGO_LOG.get(), (Block)UP2Blocks.STRIPPED_GINKGO_WOOD.get(), (Block)UP2Blocks.LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.LEPIDODENDRON_WOOD.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_WOOD.get(), (Block)UP2Blocks.STRIPPED_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.STRIPPED_LEPIDODENDRON_WOOD.get(), (Block)UP2Blocks.METASEQUOIA_LOG.get(), (Block)UP2Blocks.METASEQUOIA_WOOD.get(), (Block)UP2Blocks.STRIPPED_METASEQUOIA_LOG.get(), (Block)UP2Blocks.STRIPPED_METASEQUOIA_WOOD.get()});
        this.m_206424_(BlockTags.f_215839_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_LOG.get(), (Block)UP2Blocks.GINKGO_LOG.get(), (Block)UP2Blocks.LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get(), (Block)UP2Blocks.METASEQUOIA_LOG.get()});
        this.m_206424_(BlockTags.f_13090_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get(), (Block)UP2Blocks.GINKGO_PLANKS.get(), (Block)UP2Blocks.LEPIDODENDRON_PLANKS.get(), (Block)UP2Blocks.METASEQUOIA_PLANKS.get()});
        this.m_206424_(BlockTags.f_13096_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_STAIRS.get(), (Block)UP2Blocks.GINKGO_STAIRS.get(), (Block)UP2Blocks.LEPIDODENDRON_STAIRS.get(), (Block)UP2Blocks.METASEQUOIA_STAIRS.get()});
        this.m_206424_(BlockTags.f_13097_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_SLAB.get(), (Block)UP2Blocks.GINKGO_SLAB.get(), (Block)UP2Blocks.LEPIDODENDRON_SLAB.get(), (Block)UP2Blocks.METASEQUOIA_SLAB.get()});
        this.m_206424_(BlockTags.f_13098_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_FENCE.get(), (Block)UP2Blocks.GINKGO_FENCE.get(), (Block)UP2Blocks.LEPIDODENDRON_FENCE.get(), (Block)UP2Blocks.METASEQUOIA_FENCE.get()});
        this.m_206424_(BlockTags.f_13055_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_FENCE_GATE.get(), (Block)UP2Blocks.GINKGO_FENCE_GATE.get(), (Block)UP2Blocks.LEPIDODENDRON_FENCE_GATE.get(), (Block)UP2Blocks.METASEQUOIA_FENCE_GATE.get()});
        this.m_206424_(BlockTags.f_13095_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_DOOR.get(), (Block)UP2Blocks.GINKGO_DOOR.get(), (Block)UP2Blocks.LEPIDODENDRON_DOOR.get(), (Block)UP2Blocks.METASEQUOIA_DOOR.get()});
        this.m_206424_(BlockTags.f_13102_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_TRAPDOOR.get(), (Block)UP2Blocks.GINKGO_TRAPDOOR.get(), (Block)UP2Blocks.LEPIDODENDRON_TRAPDOOR.get(), (Block)UP2Blocks.METASEQUOIA_TRAPDOOR.get()});
        this.m_206424_(BlockTags.f_13100_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_PRESSURE_PLATE.get(), (Block)UP2Blocks.GINKGO_PRESSURE_PLATE.get(), (Block)UP2Blocks.LEPIDODENDRON_PRESSURE_PLATE.get(), (Block)UP2Blocks.METASEQUOIA_PRESSURE_PLATE.get()});
        this.m_206424_(BlockTags.f_13092_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_BUTTON.get(), (Block)UP2Blocks.GINKGO_BUTTON.get(), (Block)UP2Blocks.LEPIDODENDRON_BUTTON.get(), (Block)UP2Blocks.METASEQUOIA_BUTTON.get()});
        this.m_206424_(BlockTags.f_13066_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_SIGN.get(), (Block)UP2Blocks.GINKGO_SIGN.get(), (Block)UP2Blocks.LEPIDODENDRON_SIGN.get(), (Block)UP2Blocks.METASEQUOIA_SIGN.get()});
        this.m_206424_(BlockTags.f_13067_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_WALL_SIGN.get(), (Block)UP2Blocks.GINKGO_WALL_SIGN.get(), (Block)UP2Blocks.LEPIDODENDRON_WALL_SIGN.get(), (Block)UP2Blocks.METASEQUOIA_WALL_SIGN.get()});
        this.m_206424_(BlockTags.f_243838_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_HANGING_SIGN.get(), (Block)UP2Blocks.GINKGO_HANGING_SIGN.get(), (Block)UP2Blocks.LEPIDODENDRON_HANGING_SIGN.get(), (Block)UP2Blocks.METASEQUOIA_HANGING_SIGN.get()});
        this.m_206424_(BlockTags.f_244544_).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_WALL_HANGING_SIGN.get(), (Block)UP2Blocks.GINKGO_WALL_HANGING_SIGN.get(), (Block)UP2Blocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), (Block)UP2Blocks.METASEQUOIA_WALL_HANGING_SIGN.get()});
        this.m_206424_(BlockTags.f_144269_).m_255245_((Object)((Block)UP2Blocks.OOZE_CAULDRON.get()));
        this.m_206424_(Tags.Blocks.FENCE_GATES).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_FENCE_GATE.get(), (Block)UP2Blocks.GINKGO_FENCE_GATE.get(), (Block)UP2Blocks.LEPIDODENDRON_FENCE_GATE.get(), (Block)UP2Blocks.METASEQUOIA_FENCE_GATE.get()});
        this.m_206424_(Tags.Blocks.FENCE_GATES_WOODEN).m_255179_((Object[])new Block[]{(Block)UP2Blocks.DRYOPHYLLUM_FENCE_GATE.get(), (Block)UP2Blocks.GINKGO_FENCE_GATE.get(), (Block)UP2Blocks.LEPIDODENDRON_FENCE_GATE.get(), (Block)UP2Blocks.METASEQUOIA_FENCE_GATE.get()});
    }
}


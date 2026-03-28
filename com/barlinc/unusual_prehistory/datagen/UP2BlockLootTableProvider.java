/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.advancements.critereon.BlockPredicate$Builder
 *  net.minecraft.advancements.critereon.EnchantmentPredicate
 *  net.minecraft.advancements.critereon.ItemPredicate$Builder
 *  net.minecraft.advancements.critereon.LocationPredicate$Builder
 *  net.minecraft.advancements.critereon.MinMaxBounds$Ints
 *  net.minecraft.advancements.critereon.StatePropertiesPredicate$Builder
 *  net.minecraft.core.BlockPos
 *  net.minecraft.data.loot.BlockLootSubProvider
 *  net.minecraft.world.flag.FeatureFlags
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.enchantment.Enchantment
 *  net.minecraft.world.item.enchantment.Enchantments
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.DoublePlantBlock
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.IntegerProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.storage.loot.LootPool
 *  net.minecraft.world.level.storage.loot.LootPool$Builder
 *  net.minecraft.world.level.storage.loot.LootTable
 *  net.minecraft.world.level.storage.loot.LootTable$Builder
 *  net.minecraft.world.level.storage.loot.entries.LootItem
 *  net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer$Builder
 *  net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer$Builder
 *  net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder
 *  net.minecraft.world.level.storage.loot.functions.LootItemFunction$Builder
 *  net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
 *  net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition
 *  net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder
 *  net.minecraft.world.level.storage.loot.predicates.LocationCheck
 *  net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition
 *  net.minecraft.world.level.storage.loot.predicates.LootItemCondition$Builder
 *  net.minecraft.world.level.storage.loot.predicates.MatchTool
 *  net.minecraft.world.level.storage.loot.providers.number.ConstantValue
 *  net.minecraft.world.level.storage.loot.providers.number.NumberProvider
 *  net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
 *  net.minecraftforge.common.Tags$Items
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.blocks.egg.TallEggBlock;
import com.barlinc.unusual_prehistory.blocks.plant.ThreeTallPlantBlock;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

public class UP2BlockLootTableProvider
extends BlockLootSubProvider {
    private final Set<Block> knownBlocks = new HashSet<Block>();
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.m_81997_((ItemPredicate.Builder)ItemPredicate.Builder.m_45068_().m_45071_(new EnchantmentPredicate(Enchantments.f_44985_, MinMaxBounds.Ints.m_55386_((int)1))));
    private static final LootItemCondition.Builder HAS_SHEARS = MatchTool.m_81997_((ItemPredicate.Builder)ItemPredicate.Builder.m_45068_().m_204145_(Tags.Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.m_285888_(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.m_81807_();
    private static final float[] LEAVES_SAPLING_CHANCES = new float[]{0.05f, 0.0625f, 0.083333336f, 0.1f};
    private static final float[] LEAVES_STICK_CHANCES = new float[]{0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f};

    public UP2BlockLootTableProvider() {
        super(Set.of(), FeatureFlags.f_244280_.m_247355_());
    }

    protected void m_247577_(@NotNull Block block, // Could not load outer class - annotation placement on inner may be incorrect
    @NotNull LootTable.Builder builder) {
        super.m_247577_(block, builder);
        this.knownBlocks.add(block);
    }

    protected void m_245660_() {
        this.m_245724_((Block)UP2Blocks.ASPHALT.get());
        this.m_245724_((Block)UP2Blocks.PALEOSTONE.get());
        this.m_245724_((Block)UP2Blocks.PALEOSTONE_STAIRS.get());
        this.m_246481_((Block)UP2Blocks.PALEOSTONE_SLAB.get(), x$0 -> this.m_247233_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.MESONITE.get());
        this.m_245724_((Block)UP2Blocks.MESONITE_STAIRS.get());
        this.m_246481_((Block)UP2Blocks.MESONITE_SLAB.get(), x$0 -> this.m_247233_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.FLORALITE.get());
        this.m_245724_((Block)UP2Blocks.FLORALITE_STAIRS.get());
        this.m_246481_((Block)UP2Blocks.FLORALITE_SLAB.get(), x$0 -> this.m_247233_((Block)x$0));
        this.m_246481_((Block)UP2Blocks.FOSSILIZED_BONE_BLOCK.get(), block -> this.m_245514_((Block)block, (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()));
        this.m_246481_((Block)UP2Blocks.FOSSILIZED_BONE_BARK.get(), block -> this.m_245514_((Block)block, (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()));
        this.m_246481_((Block)UP2Blocks.FOSSILIZED_BONE_VERTEBRA.get(), block -> this.m_245514_((Block)block, (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()));
        this.m_246481_((Block)UP2Blocks.FOSSILIZED_BONE_ROD.get(), block -> this.m_245514_((Block)block, (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()));
        this.m_246481_((Block)UP2Blocks.FOSSILIZED_BONE_SPIKE.get(), block -> this.m_245514_((Block)block, (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()));
        this.m_246481_((Block)UP2Blocks.FOSSILIZED_BONE_ROW.get(), block -> this.m_245514_((Block)block, (ItemLike)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()));
        this.m_245724_((Block)UP2Blocks.FOSSILIZED_SKULL.get());
        this.m_245724_((Block)UP2Blocks.FOSSILIZED_SKULL_LANTERN.get());
        this.m_245724_((Block)UP2Blocks.FOSSILIZED_SKULL_SOUL_LANTERN.get());
        this.m_245724_((Block)UP2Blocks.COBBLED_FOSSILIZED_BONE.get());
        this.m_245724_((Block)UP2Blocks.COBBLED_FOSSILIZED_BONE_STAIRS.get());
        this.m_246481_((Block)UP2Blocks.COBBLED_FOSSILIZED_BONE_SLAB.get(), x$0 -> this.m_247233_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.PETRIFIED_BUSH.get());
        this.m_245724_((Block)UP2Blocks.PETRIFIED_LOG.get());
        this.m_245724_((Block)UP2Blocks.PETRIFIED_WOOD.get());
        this.m_245724_((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD.get());
        this.m_245724_((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_STAIRS.get());
        this.m_246481_((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_SLAB.get(), x$0 -> this.m_247233_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_PRESSURE_PLATE.get());
        this.m_245724_((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD_BUTTON.get());
        this.m_245724_((Block)UP2Blocks.TRANSMOGRIFIER.get());
        this.m_245724_((Block)UP2Blocks.REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.TINTED_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.WHITE_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.LIGHT_GRAY_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.GRAY_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.BLACK_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.BROWN_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.RED_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.ORANGE_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.YELLOW_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.LIME_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.GREEN_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.CYAN_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.LIGHT_BLUE_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.BLUE_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.PURPLE_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.MAGENTA_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.PINK_REINFORCED_GLASS.get());
        this.m_245724_((Block)UP2Blocks.AEGIROCASSIS_EGGS.get());
        this.m_245724_((Block)UP2Blocks.BARINASUCHUS_EGG.get());
        this.m_246481_((Block)UP2Blocks.BRACHIOSAURUS_EGG.get(), block -> this.m_245178_((Block)block, (Property)TallEggBlock.HALF, (Comparable)DoubleBlockHalf.LOWER));
        this.m_245724_((Block)UP2Blocks.CARNOTAURUS_EGG.get());
        this.m_245724_((Block)UP2Blocks.COELACANTHUS_ROE.get());
        this.m_245724_((Block)UP2Blocks.DESMATOSUCHUS_EGG.get());
        this.m_245724_((Block)UP2Blocks.DIPLOCAULUS_EGGS.get());
        this.m_245724_((Block)UP2Blocks.DUNKLEOSTEUS_SAC.get());
        this.m_245724_((Block)UP2Blocks.HIBBERTOPTERUS_EGGS.get());
        this.m_245724_((Block)UP2Blocks.JAWLESS_FISH_ROE.get());
        this.m_245724_((Block)UP2Blocks.KAPROSUCHUS_EGG.get());
        this.m_245724_((Block)UP2Blocks.KENTROSAURUS_EGG.get());
        this.m_245724_((Block)UP2Blocks.KIMMERIDGEBRACHYPTERAESCHNIDIUM_EGGS.get());
        this.m_245724_((Block)UP2Blocks.LOBE_FINNED_FISH_ROE.get());
        this.m_245724_((Block)UP2Blocks.LYSTROSAURUS_EGG.get());
        this.m_245724_((Block)UP2Blocks.MAJUNGASAURUS_EGG.get());
        this.m_245724_((Block)UP2Blocks.MANIPULATOR_OOTHECA.get());
        this.m_245724_((Block)UP2Blocks.MEGALANIA_EGG.get());
        this.m_245724_((Block)UP2Blocks.ONCHOPRISTIS_SAC.get());
        this.m_245724_((Block)UP2Blocks.PACHYCEPHALOSAURUS_EGG.get());
        this.m_245724_((Block)UP2Blocks.STETHACANTHUS_SAC.get());
        this.m_245724_((Block)UP2Blocks.TARTUOSTEUS_ROE.get());
        this.m_245724_((Block)UP2Blocks.THERIZINOSAURUS_EGG.get());
        this.m_245724_((Block)UP2Blocks.ULUGHBEGSAURUS_EGG.get());
        this.m_245724_((Block)UP2Blocks.BENNETTITALES.get());
        this.m_246535_((Block)UP2Blocks.POTTED_BENNETTITALES.get());
        this.m_245724_((Block)UP2Blocks.NEOMARIOPTERIS.get());
        this.m_246535_((Block)UP2Blocks.POTTED_NEOMARIOPTERIS.get());
        this.m_246481_((Block)UP2Blocks.CALAMOPHYTON.get(), block -> this.createLayeredSinglePropConditionTable((Block)block, ThreeTallPlantBlock.LAYER, 0));
        this.m_246481_((Block)UP2Blocks.BRACHYPHYLLUM.get(), block -> this.createLayeredSinglePropConditionTable((Block)block, ThreeTallPlantBlock.LAYER, 0));
        this.m_245724_((Block)UP2Blocks.COOKSONIA.get());
        this.m_246535_((Block)UP2Blocks.POTTED_COOKSONIA.get());
        this.m_245724_((Block)UP2Blocks.CLADOPHLEBIS.get());
        this.m_246535_((Block)UP2Blocks.POTTED_CLADOPHLEBIS.get());
        this.m_245724_((Block)UP2Blocks.ARCHAEOSIGILLARIA.get());
        this.m_246535_((Block)UP2Blocks.POTTED_ARCHAEOSIGILLARIA.get());
        this.m_245724_((Block)UP2Blocks.QUILLWORT.get());
        this.m_246535_((Block)UP2Blocks.POTTED_QUILLWORT.get());
        this.m_245724_((Block)UP2Blocks.LEEFRUCTUS.get());
        this.m_246535_((Block)UP2Blocks.POTTED_LEEFRUCTUS.get());
        this.m_246481_((Block)UP2Blocks.RAIGUENRAYUN.get(), block -> this.m_245178_((Block)block, (Property)DoublePlantBlock.f_52858_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_246481_((Block)UP2Blocks.TEMPSKYA.get(), block -> this.m_245178_((Block)block, (Property)DoublePlantBlock.f_52858_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_246481_((Block)UP2Blocks.AETHOPHYLLUM.get(), block -> this.m_245178_((Block)block, (Property)DoublePlantBlock.f_52858_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_245724_((Block)UP2Blocks.RHYNIA.get());
        this.m_246535_((Block)UP2Blocks.POTTED_RHYNIA.get());
        this.m_245724_((Block)UP2Blocks.HORSETAIL.get());
        this.m_246535_((Block)UP2Blocks.POTTED_HORSETAIL.get());
        this.m_246481_((Block)UP2Blocks.LARGE_HORSETAIL.get(), block -> UP2BlockLootTableProvider.doublePlantDrops(block, (Block)UP2Blocks.HORSETAIL.get()));
        this.m_246481_((Block)UP2Blocks.MOSSY_DIRT.get(), block -> this.m_245514_((Block)block, (ItemLike)Blocks.f_50493_));
        this.m_245724_((Block)UP2Blocks.MOSS_LAYER.get());
        this.m_247577_((Block)UP2Blocks.GUANGDEDENDRON_SPORE.get(), this.m_245765_((ItemLike)UP2Blocks.GUANGDEDENDRON.get(), (NumberProvider)ConstantValue.m_165692_((float)1.0f)));
        this.m_245724_((Block)UP2Blocks.GUANGDEDENDRON.get());
        this.m_245724_((Block)UP2Blocks.CYCAD_SEEDLING.get());
        this.m_245724_((Block)UP2Blocks.CYCAD_STEM.get());
        this.m_245724_((Block)UP2Blocks.CYCAD_CROWN.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_LOG.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_WOOD.get());
        this.m_245724_((Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_LOG.get());
        this.m_245724_((Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_WOOD.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_STAIRS.get());
        this.m_246481_((Block)UP2Blocks.DRYOPHYLLUM_SLAB.get(), x$0 -> this.m_247233_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_FENCE.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_FENCE_GATE.get());
        this.m_246481_((Block)UP2Blocks.DRYOPHYLLUM_DOOR.get(), x$0 -> this.m_247398_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_TRAPDOOR.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_PRESSURE_PLATE.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_BUTTON.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_SIGN.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_WALL_SIGN.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_HANGING_SIGN.get());
        this.m_245724_((Block)UP2Blocks.DRYOPHYLLUM_SAPLING.get());
        this.m_246535_((Block)UP2Blocks.POTTED_DRYOPHYLLUM_SAPLING.get());
        this.m_246481_((Block)UP2Blocks.DRYOPHYLLUM_LEAVES.get(), block -> this.createGinkgoLeavesDrops((Block)block, (Block)UP2Blocks.DRYOPHYLLUM_SAPLING.get(), LEAVES_SAPLING_CHANCES));
        this.m_245724_((Block)UP2Blocks.GINKGO_LOG.get());
        this.m_245724_((Block)UP2Blocks.GINKGO_WOOD.get());
        this.m_245724_((Block)UP2Blocks.STRIPPED_GINKGO_LOG.get());
        this.m_245724_((Block)UP2Blocks.STRIPPED_GINKGO_WOOD.get());
        this.m_245724_((Block)UP2Blocks.GINKGO_PLANKS.get());
        this.m_245724_((Block)UP2Blocks.GINKGO_STAIRS.get());
        this.m_246481_((Block)UP2Blocks.GINKGO_SLAB.get(), x$0 -> this.m_247233_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.GINKGO_FENCE.get());
        this.m_245724_((Block)UP2Blocks.GINKGO_FENCE_GATE.get());
        this.m_246481_((Block)UP2Blocks.GINKGO_DOOR.get(), x$0 -> this.m_247398_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.GINKGO_TRAPDOOR.get());
        this.m_245724_((Block)UP2Blocks.GINKGO_PRESSURE_PLATE.get());
        this.m_245724_((Block)UP2Blocks.GINKGO_BUTTON.get());
        this.m_245724_((Block)UP2Blocks.GINKGO_SIGN.get());
        this.m_245724_((Block)UP2Blocks.GINKGO_WALL_SIGN.get());
        this.m_245724_((Block)UP2Blocks.GINKGO_HANGING_SIGN.get());
        this.m_245724_((Block)UP2Blocks.GINKGO_SAPLING.get());
        this.m_246535_((Block)UP2Blocks.POTTED_GINKGO_SAPLING.get());
        this.m_245724_((Block)UP2Blocks.GOLDEN_GINKGO_SAPLING.get());
        this.m_246535_((Block)UP2Blocks.POTTED_GOLDEN_GINKGO_SAPLING.get());
        this.m_246481_((Block)UP2Blocks.GOLDEN_GINKGO_LEAVES.get(), block -> this.createGinkgoLeavesDrops((Block)block, (Block)UP2Blocks.GOLDEN_GINKGO_SAPLING.get(), LEAVES_SAPLING_CHANCES));
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_LOG.get());
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_WOOD.get());
        this.m_245724_((Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get());
        this.m_245724_((Block)UP2Blocks.MOSSY_LEPIDODENDRON_WOOD.get());
        this.m_245724_((Block)UP2Blocks.STRIPPED_LEPIDODENDRON_LOG.get());
        this.m_245724_((Block)UP2Blocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_PLANKS.get());
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_STAIRS.get());
        this.m_246481_((Block)UP2Blocks.LEPIDODENDRON_SLAB.get(), x$0 -> this.m_247233_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_FENCE.get());
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_FENCE_GATE.get());
        this.m_246481_((Block)UP2Blocks.LEPIDODENDRON_DOOR.get(), x$0 -> this.m_247398_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_TRAPDOOR.get());
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_PRESSURE_PLATE.get());
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_BUTTON.get());
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_SIGN.get());
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_WALL_SIGN.get());
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_HANGING_SIGN.get());
        this.m_245724_((Block)UP2Blocks.LEPIDODENDRON_CONE.get());
        this.m_246481_((Block)UP2Blocks.LEPIDODENDRON_LEAVES.get(), this::createLepidodendronLeavesDrops);
        this.m_246481_((Block)UP2Blocks.HANGING_LEPIDODENDRON_LEAVES.get(), this::createLepidodendronLeavesDrops);
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_LOG.get());
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_WOOD.get());
        this.m_245724_((Block)UP2Blocks.STRIPPED_METASEQUOIA_LOG.get());
        this.m_245724_((Block)UP2Blocks.STRIPPED_METASEQUOIA_WOOD.get());
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_PLANKS.get());
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_STAIRS.get());
        this.m_246481_((Block)UP2Blocks.METASEQUOIA_SLAB.get(), x$0 -> this.m_247233_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_FENCE.get());
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_FENCE_GATE.get());
        this.m_246481_((Block)UP2Blocks.METASEQUOIA_DOOR.get(), x$0 -> this.m_247398_((Block)x$0));
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_TRAPDOOR.get());
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_PRESSURE_PLATE.get());
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_BUTTON.get());
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_SIGN.get());
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_WALL_SIGN.get());
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_HANGING_SIGN.get());
        this.m_245724_((Block)UP2Blocks.METASEQUOIA_SAPLING.get());
        this.m_246535_((Block)UP2Blocks.POTTED_METASEQUOIA_SAPLING.get());
        this.m_246481_((Block)UP2Blocks.METASEQUOIA_LEAVES.get(), block -> this.createGinkgoLeavesDrops((Block)block, (Block)UP2Blocks.METASEQUOIA_SAPLING.get(), LEAVES_SAPLING_CHANCES));
        this.m_245724_((Block)UP2Blocks.PROTOTAXITES_NUB.get());
        this.m_245724_((Block)UP2Blocks.PROTOTAXITES_CLUSTER.get());
        this.m_245724_((Block)UP2Blocks.PROTOTAXITES.get());
        this.m_246481_((Block)UP2Blocks.LARGE_PROTOTAXITES_NUB.get(), block -> this.m_245178_((Block)block, (Property)DoublePlantBlock.f_52858_, (Comparable)DoubleBlockHalf.LOWER));
    }

    @NotNull
    protected Iterable<Block> getKnownBlocks() {
        return this.knownBlocks;
    }

    protected static LootTable.Builder doublePlantDrops(Block large, Block big) {
        LootPoolSingletonContainer.Builder builder = LootItem.m_79579_((ItemLike)big).m_79078_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)ConstantValue.m_165692_((float)2.0f)));
        return LootTable.m_79147_().m_79161_(LootPool.m_79043_().m_79076_((LootPoolEntryContainer.Builder)builder).m_79080_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)large).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)DoublePlantBlock.f_52858_, (Comparable)DoubleBlockHalf.LOWER))).m_79080_(LocationCheck.m_81727_((LocationPredicate.Builder)LocationPredicate.Builder.m_52651_().m_52652_(BlockPredicate.Builder.m_17924_().m_146726_(new Block[]{large}).m_17929_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)DoublePlantBlock.f_52858_, (Comparable)DoubleBlockHalf.UPPER).m_67706_()).m_17931_()), (BlockPos)new BlockPos(0, 1, 0)))).m_79161_(LootPool.m_79043_().m_79076_((LootPoolEntryContainer.Builder)builder).m_79080_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)large).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)DoublePlantBlock.f_52858_, (Comparable)DoubleBlockHalf.UPPER))).m_79080_(LocationCheck.m_81727_((LocationPredicate.Builder)LocationPredicate.Builder.m_52651_().m_52652_(BlockPredicate.Builder.m_17924_().m_146726_(new Block[]{large}).m_17929_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)DoublePlantBlock.f_52858_, (Comparable)DoubleBlockHalf.LOWER).m_67706_()).m_17931_()), (BlockPos)new BlockPos(0, -1, 0))));
    }

    protected LootTable.Builder createLayeredSinglePropConditionTable(Block block, IntegerProperty property, int value) {
        return LootTable.m_79147_().m_79161_((LootPool.Builder)this.m_247733_((ItemLike)block, (ConditionUserBuilder)LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_((float)1.0f)).m_79076_(LootItem.m_79579_((ItemLike)block).m_79080_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)block).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67694_((Property)property, value))))));
    }

    protected LootTable.Builder createLepidodendronLeavesDrops(Block leaves) {
        return UP2BlockLootTableProvider.m_246160_((Block)leaves, (LootPoolEntryContainer.Builder)((LootPoolSingletonContainer.Builder)this.m_246108_((ItemLike)leaves, (FunctionUserBuilder)LootItem.m_79579_((ItemLike)Items.f_42398_).m_79078_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)UniformGenerator.m_165780_((float)1.0f, (float)2.0f))))).m_79080_(BonusLevelTableCondition.m_81517_((Enchantment)Enchantments.f_44987_, (float[])LEAVES_STICK_CHANCES)));
    }

    protected LootTable.Builder createGinkgoLeavesDrops(Block leaves, Block sapling, float ... chances) {
        return this.m_246047_(leaves, sapling, chances).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_((float)1.0f)).m_79080_(HAS_NO_SHEARS_OR_SILK_TOUCH).m_79076_(((LootPoolSingletonContainer.Builder)this.m_247733_((ItemLike)leaves, (ConditionUserBuilder)LootItem.m_79579_((ItemLike)((ItemLike)UP2Items.GINKGO_FRUIT.get())))).m_79080_(BonusLevelTableCondition.m_81517_((Enchantment)Enchantments.f_44987_, (float[])new float[]{0.005f, 0.0055555557f, 0.00625f, 0.008333334f, 0.025f}))));
    }
}


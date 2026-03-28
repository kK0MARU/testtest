/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.flag.FeatureFlag
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.PlaceOnWaterBlockItem
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.ButtonBlock
 *  net.minecraft.world.level.block.CeilingHangingSignBlock
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.FenceBlock
 *  net.minecraft.world.level.block.FenceGateBlock
 *  net.minecraft.world.level.block.FlowerPotBlock
 *  net.minecraft.world.level.block.LeavesBlock
 *  net.minecraft.world.level.block.LiquidBlock
 *  net.minecraft.world.level.block.PressurePlateBlock
 *  net.minecraft.world.level.block.PressurePlateBlock$Sensitivity
 *  net.minecraft.world.level.block.RotatedPillarBlock
 *  net.minecraft.world.level.block.SaplingBlock
 *  net.minecraft.world.level.block.SlabBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.StairBlock
 *  net.minecraft.world.level.block.StandingSignBlock
 *  net.minecraft.world.level.block.TrapDoorBlock
 *  net.minecraft.world.level.block.WallHangingSignBlock
 *  net.minecraft.world.level.block.WallSignBlock
 *  net.minecraft.world.level.block.grower.AbstractTreeGrower
 *  net.minecraft.world.level.block.state.BlockBehaviour
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockSetType
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.FlowingFluid
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.material.PushReaction
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.blocks.AlternatesWaterEggBlock;
import com.barlinc.unusual_prehistory.blocks.ConnectedGlassBlock;
import com.barlinc.unusual_prehistory.blocks.FossilizedBoneRodBlock;
import com.barlinc.unusual_prehistory.blocks.FossilizedBoneRowBlock;
import com.barlinc.unusual_prehistory.blocks.FossilizedBoneSpikeBlock;
import com.barlinc.unusual_prehistory.blocks.FossilizedSkullBlock;
import com.barlinc.unusual_prehistory.blocks.OozeCauldron;
import com.barlinc.unusual_prehistory.blocks.PetrifiedBushBlock;
import com.barlinc.unusual_prehistory.blocks.TarBlock;
import com.barlinc.unusual_prehistory.blocks.TintedConnectedGlassBlock;
import com.barlinc.unusual_prehistory.blocks.TransmogrifierBlock;
import com.barlinc.unusual_prehistory.blocks.WoodBlocks;
import com.barlinc.unusual_prehistory.blocks.egg.EggBlock;
import com.barlinc.unusual_prehistory.blocks.egg.MultipleEggBlock;
import com.barlinc.unusual_prehistory.blocks.egg.RotatableEggBlock;
import com.barlinc.unusual_prehistory.blocks.egg.TallEggBlock;
import com.barlinc.unusual_prehistory.blocks.egg.UnderwaterEggBlock;
import com.barlinc.unusual_prehistory.blocks.egg.WaterEggBlock;
import com.barlinc.unusual_prehistory.blocks.plant.FallingLeavesBlock;
import com.barlinc.unusual_prehistory.blocks.plant.HangingLeavesBlock;
import com.barlinc.unusual_prehistory.blocks.plant.PrehistoricFlowerBlock;
import com.barlinc.unusual_prehistory.blocks.plant.PrehistoricPlantBlock;
import com.barlinc.unusual_prehistory.blocks.plant.PrehistoricTallFlowerBlock;
import com.barlinc.unusual_prehistory.blocks.plant.PrehistoricTallPlantBlock;
import com.barlinc.unusual_prehistory.blocks.plant.ThreeTallPlantBlock;
import com.barlinc.unusual_prehistory.blocks.plant.grower.DryophyllumTreeGrower;
import com.barlinc.unusual_prehistory.blocks.plant.grower.GinkgoTreeGrower;
import com.barlinc.unusual_prehistory.blocks.plant.grower.GoldenGinkgoTreeGrower;
import com.barlinc.unusual_prehistory.blocks.plant.grower.LepidodendronTreeGrower;
import com.barlinc.unusual_prehistory.blocks.plant.grower.MetasequoiaTreeGrower;
import com.barlinc.unusual_prehistory.blocks.plant.update_1.CalamophytonBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_1.HorsetailBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_1.LargeHorsetailBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_1.LepidodendronConeBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_1.LepidodendronLeavesBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_1.MossLayerBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_1.MossyDirtBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_1.QuillwortBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_4.CycadCrownBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_4.CycadSeedlingBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_4.CycadStemBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_4.GuangdedendronSporeBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_4.GuangdedendronStalkBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_4.LargePrototaxitesNubBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_4.MetasequoiaSaplingBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_4.PrototaxitesClusterBlock;
import com.barlinc.unusual_prehistory.blocks.plant.update_4.PrototaxitesNubBlock;
import com.barlinc.unusual_prehistory.registry.UP2BlockProperties;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Fluids;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2Particles;
import com.barlinc.unusual_prehistory.registry.UP2SoundTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class UP2Blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create((IForgeRegistry)ForgeRegistries.BLOCKS, (String)"unusual_prehistory");
    public static final List<Supplier<? extends Block>> EGG_BLOCKS = new ArrayList<Supplier<? extends Block>>();
    public static List<RegistryObject<? extends Block>> BLOCK_TRANSLATIONS = new ArrayList<RegistryObject<? extends Block>>();
    public static final RegistryObject<Block> CARNOTAURUS_EGG = UP2Blocks.registerEggBlock("carnotaurus_egg", () -> new EggBlock(UP2BlockProperties.EGG, () -> UP2Entities.CARNOTAURUS.get(), 12, 15, false));
    public static final RegistryObject<Block> DIPLOCAULUS_EGGS = UP2Blocks.registerWaterEggBlock("diplocaulus_eggs", () -> new WaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.DIPLOCAULUS.get(), 2));
    public static final RegistryObject<Block> DUNKLEOSTEUS_SAC = UP2Blocks.registerEggBlock("dunkleosteus_sac", () -> new UnderwaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.DUNKLEOSTEUS.get(), 1));
    public static final RegistryObject<Block> JAWLESS_FISH_ROE = UP2Blocks.registerWaterEggBlock("jawless_fish_roe", () -> new AlternatesWaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.JAWLESS_FISH.get(), () -> UP2Entities.TARTUOSTEUS.get(), 4));
    public static final RegistryObject<Block> KENTROSAURUS_EGG = UP2Blocks.registerEggBlock("kentrosaurus_egg", () -> new EggBlock(UP2BlockProperties.EGG, () -> UP2Entities.KENTROSAURUS.get(), 8, 15, false));
    public static final RegistryObject<Block> KIMMERIDGEBRACHYPTERAESCHNIDIUM_EGGS = UP2Blocks.registerWaterEggBlock("kimmeridgebrachypteraeschnidium_eggs", () -> new WaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH.get(), 4));
    public static final RegistryObject<Block> MAJUNGASAURUS_EGG = UP2Blocks.registerEggBlock("majungasaurus_egg", () -> new EggBlock(UP2BlockProperties.EGG, () -> UP2Entities.MAJUNGASAURUS.get(), 12, 11, false));
    public static final RegistryObject<Block> MEGALANIA_EGG = UP2Blocks.registerEggBlock("megalania_egg", () -> new EggBlock(UP2BlockProperties.EGG, () -> UP2Entities.MEGALANIA.get(), 12, 14, false));
    public static final RegistryObject<Block> STETHACANTHUS_SAC = UP2Blocks.registerEggBlock("stethacanthus_sac", () -> new UnderwaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.STETHACANTHUS.get(), 2));
    public static final RegistryObject<Block> BENNETTITALES = UP2Blocks.registerBlock("bennettitales", () -> new PrehistoricPlantBlock(UP2BlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_BENNETTITALES = UP2Blocks.registerBlockWithoutItem("potted_bennettitales", () -> new FlowerPotBlock((Block)BENNETTITALES.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> CALAMOPHYTON = UP2Blocks.registerBlock("calamophyton", () -> new CalamophytonBlock(BlockBehaviour.Properties.m_284310_().m_60910_().m_60966_().m_60918_(SoundType.f_56740_).m_278166_(PushReaction.DESTROY)));
    public static final RegistryObject<Block> COOKSONIA = UP2Blocks.registerBlock("cooksonia", () -> new PrehistoricFlowerBlock(() -> MobEffects.f_19605_, 9, UP2BlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_COOKSONIA = UP2Blocks.registerBlockWithoutItem("potted_cooksonia", () -> new FlowerPotBlock((Block)COOKSONIA.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> CLADOPHLEBIS = UP2Blocks.registerBlock("cladophlebis", () -> new PrehistoricPlantBlock(UP2BlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_CLADOPHLEBIS = UP2Blocks.registerBlockWithoutItem("potted_cladophlebis", () -> new FlowerPotBlock((Block)CLADOPHLEBIS.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> HORSETAIL = UP2Blocks.registerBlock("horsetail", () -> new HorsetailBlock(UP2BlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_HORSETAIL = UP2Blocks.registerBlockWithoutItem("potted_horsetail", () -> new FlowerPotBlock((Block)HORSETAIL.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> LARGE_HORSETAIL = UP2Blocks.registerBlock("large_horsetail", () -> new LargeHorsetailBlock(UP2BlockProperties.TALL_PLANT));
    public static final RegistryObject<Block> QUILLWORT = UP2Blocks.registerBlock("quillwort", () -> new QuillwortBlock(UP2BlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_QUILLWORT = UP2Blocks.registerBlockWithoutItem("potted_quillwort", () -> new FlowerPotBlock((Block)QUILLWORT.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> LEEFRUCTUS = UP2Blocks.registerBlock("leefructus", () -> new PrehistoricFlowerBlock(() -> MobEffects.f_19617_, 9, UP2BlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_LEEFRUCTUS = UP2Blocks.registerBlockWithoutItem("potted_leefructus", () -> new FlowerPotBlock((Block)LEEFRUCTUS.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> RAIGUENRAYUN = UP2Blocks.registerBlock("raiguenrayun", () -> new PrehistoricTallFlowerBlock(UP2BlockProperties.TALL_PLANT));
    public static final RegistryObject<Block> RHYNIA = UP2Blocks.registerBlock("rhynia", () -> new PrehistoricPlantBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283824_).m_60910_().m_60966_().m_60918_(SoundType.f_56740_).m_278166_(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_RHYNIA = UP2Blocks.registerBlockWithoutItem("potted_rhynia", () -> new FlowerPotBlock((Block)RHYNIA.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> MOSSY_DIRT = UP2Blocks.registerBlock("mossy_dirt", () -> new MossyDirtBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283824_).m_60978_(0.5f).m_60918_(UP2SoundTypes.MOSSY_DIRT)));
    public static final RegistryObject<Block> MOSS_LAYER = UP2Blocks.registerBlock("moss_layer", () -> new MossLayerBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283824_).m_280170_().m_60910_().m_60978_(0.2f).m_60918_(SoundType.f_154676_).m_278183_().m_278166_(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GINKGO_LOG = UP2Blocks.registerBlock("ginkgo_log", () -> new WoodBlocks(UP2BlockProperties.log(MapColor.f_283818_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> GINKGO_WOOD = UP2Blocks.registerBlock("ginkgo_wood", () -> new WoodBlocks(UP2BlockProperties.log(MapColor.f_283818_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_GINKGO_LOG = UP2Blocks.registerBlock("stripped_ginkgo_log", () -> new RotatedPillarBlock(UP2BlockProperties.log(MapColor.f_283843_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_GINKGO_WOOD = UP2Blocks.registerBlock("stripped_ginkgo_wood", () -> new RotatedPillarBlock(UP2BlockProperties.log(MapColor.f_283843_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> GINKGO_PLANKS = UP2Blocks.registerBlock("ginkgo_planks", () -> new Block(UP2BlockProperties.plank(MapColor.f_283843_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> GINKGO_STAIRS = UP2Blocks.registerBlock("ginkgo_stairs", () -> new StairBlock(() -> ((Block)GINKGO_PLANKS.get()).m_49966_(), BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)GINKGO_PLANKS.get()))));
    public static final RegistryObject<Block> GINKGO_SLAB = UP2Blocks.registerBlock("ginkgo_slab", () -> new SlabBlock(BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)GINKGO_PLANKS.get()))));
    public static final RegistryObject<Block> GINKGO_FENCE = UP2Blocks.registerBlock("ginkgo_fence", () -> new FenceBlock(UP2BlockProperties.plank(MapColor.f_283843_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> GINKGO_FENCE_GATE = UP2Blocks.registerBlock("ginkgo_fence_gate", () -> new FenceGateBlock(UP2BlockProperties.plank(MapColor.f_283843_, SoundType.f_271497_, NoteBlockInstrument.BASS), SoundEvents.f_271336_, SoundEvents.f_271336_));
    public static final RegistryObject<Block> GINKGO_DOOR = UP2Blocks.registerBlock("ginkgo_door", () -> new DoorBlock(UP2BlockProperties.woodenDoor(MapColor.f_283843_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> GINKGO_TRAPDOOR = UP2Blocks.registerBlock("ginkgo_trapdoor", () -> new TrapDoorBlock(UP2BlockProperties.woodenTrapdoor(MapColor.f_283843_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> GINKGO_PRESSURE_PLATE = UP2Blocks.registerBlock("ginkgo_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, UP2BlockProperties.woodenPressurePlate(MapColor.f_283843_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> GINKGO_BUTTON = UP2Blocks.registerBlock("ginkgo_button", () -> new ButtonBlock(UP2BlockProperties.woodenButton(SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_, 30, true));
    public static final RegistryObject<Block> GINKGO_LEAVES = UP2Blocks.registerBlock("ginkgo_leaves", () -> new FallingLeavesBlock(UP2BlockProperties.leaves(MapColor.f_283915_, SoundType.f_154674_), (Supplier<SimpleParticleType>)UP2Particles.GINKGO_LEAVES));
    public static final RegistryObject<Block> GOLDEN_GINKGO_LEAVES = UP2Blocks.registerBlock("golden_ginkgo_leaves", () -> new FallingLeavesBlock(UP2BlockProperties.leaves(MapColor.f_283757_, SoundType.f_154674_), (Supplier<SimpleParticleType>)UP2Particles.GOLDEN_GINKGO_LEAVES));
    public static final RegistryObject<Block> GINKGO_SAPLING = UP2Blocks.registerBlock("ginkgo_sapling", () -> new SaplingBlock((AbstractTreeGrower)new GinkgoTreeGrower(), UP2BlockProperties.sapling(MapColor.f_283915_, SoundType.f_271370_)));
    public static final RegistryObject<Block> POTTED_GINKGO_SAPLING = UP2Blocks.registerBlockWithoutItem("potted_ginkgo_sapling", () -> new FlowerPotBlock((Block)GINKGO_SAPLING.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> GOLDEN_GINKGO_SAPLING = UP2Blocks.registerBlock("golden_ginkgo_sapling", () -> new SaplingBlock((AbstractTreeGrower)new GoldenGinkgoTreeGrower(), UP2BlockProperties.sapling(MapColor.f_283757_, SoundType.f_271370_)));
    public static final RegistryObject<Block> POTTED_GOLDEN_GINKGO_SAPLING = UP2Blocks.registerBlockWithoutItem("potted_golden_ginkgo_sapling", () -> new FlowerPotBlock((Block)GOLDEN_GINKGO_SAPLING.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> GINKGO_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("ginkgo_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_60910_().m_60978_(1.0f).m_60918_(SoundType.f_271497_), UP2BlockProperties.GINKGO_WOOD_TYPE));
    public static final RegistryObject<Block> GINKGO_WALL_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("ginkgo_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_60910_().m_60978_(1.0f).m_60918_(SoundType.f_271497_), UP2BlockProperties.GINKGO_WOOD_TYPE));
    public static final RegistryObject<Block> GINKGO_HANGING_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("ginkgo_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280606_().m_280658_(NoteBlockInstrument.BASS).m_60910_().m_60978_(1.0f), UP2BlockProperties.GINKGO_WOOD_TYPE));
    public static final RegistryObject<Block> GINKGO_WALL_HANGING_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("ginkgo_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280606_().m_280658_(NoteBlockInstrument.BASS).m_60910_().m_60978_(1.0f).m_60916_((Block)GINKGO_HANGING_SIGN.get()), UP2BlockProperties.GINKGO_WOOD_TYPE));
    public static final RegistryObject<Block> LEPIDODENDRON_LOG = UP2Blocks.registerBlock("lepidodendron_log", () -> new WoodBlocks(UP2BlockProperties.log(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> MOSSY_LEPIDODENDRON_LOG = UP2Blocks.registerBlock("mossy_lepidodendron_log", () -> new WoodBlocks(UP2BlockProperties.log(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> LEPIDODENDRON_WOOD = UP2Blocks.registerBlock("lepidodendron_wood", () -> new WoodBlocks(UP2BlockProperties.log(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> MOSSY_LEPIDODENDRON_WOOD = UP2Blocks.registerBlock("mossy_lepidodendron_wood", () -> new WoodBlocks(UP2BlockProperties.log(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_LEPIDODENDRON_LOG = UP2Blocks.registerBlock("stripped_lepidodendron_log", () -> new RotatedPillarBlock(UP2BlockProperties.log(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_LEPIDODENDRON_WOOD = UP2Blocks.registerBlock("stripped_lepidodendron_wood", () -> new RotatedPillarBlock(UP2BlockProperties.log(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> LEPIDODENDRON_PLANKS = UP2Blocks.registerBlock("lepidodendron_planks", () -> new Block(UP2BlockProperties.plank(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> LEPIDODENDRON_STAIRS = UP2Blocks.registerBlock("lepidodendron_stairs", () -> new StairBlock(() -> ((Block)LEPIDODENDRON_PLANKS.get()).m_49966_(), BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)LEPIDODENDRON_PLANKS.get()))));
    public static final RegistryObject<Block> LEPIDODENDRON_SLAB = UP2Blocks.registerBlock("lepidodendron_slab", () -> new SlabBlock(BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)LEPIDODENDRON_PLANKS.get()))));
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE = UP2Blocks.registerBlock("lepidodendron_fence", () -> new FenceBlock(UP2BlockProperties.plank(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE_GATE = UP2Blocks.registerBlock("lepidodendron_fence_gate", () -> new FenceGateBlock(UP2BlockProperties.plank(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS), SoundEvents.f_271336_, SoundEvents.f_271336_));
    public static final RegistryObject<Block> LEPIDODENDRON_DOOR = UP2Blocks.registerBlock("lepidodendron_door", () -> new DoorBlock(UP2BlockProperties.woodenDoor(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> LEPIDODENDRON_TRAPDOOR = UP2Blocks.registerBlock("lepidodendron_trapdoor", () -> new TrapDoorBlock(UP2BlockProperties.woodenTrapdoor(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> LEPIDODENDRON_PRESSURE_PLATE = UP2Blocks.registerBlock("lepidodendron_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, UP2BlockProperties.woodenPressurePlate(MapColor.f_283771_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> LEPIDODENDRON_BUTTON = UP2Blocks.registerBlock("lepidodendron_button", () -> new ButtonBlock(UP2BlockProperties.woodenButton(SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_, 30, true));
    public static final RegistryObject<Block> LEPIDODENDRON_LEAVES = UP2Blocks.registerBlock("lepidodendron_leaves", () -> new LepidodendronLeavesBlock(UP2BlockProperties.leaves(MapColor.f_283915_, SoundType.f_154674_)));
    public static final RegistryObject<Block> HANGING_LEPIDODENDRON_LEAVES = UP2Blocks.registerBlock("hanging_lepidodendron_leaves", () -> new HangingLeavesBlock(UP2BlockProperties.leaves(MapColor.f_283915_, SoundType.f_154674_).m_60910_()));
    public static final RegistryObject<Block> LEPIDODENDRON_CONE = UP2Blocks.registerBlock("lepidodendron_cone", () -> new LepidodendronConeBlock(new LepidodendronTreeGrower(), UP2BlockProperties.sapling(MapColor.f_283915_, SoundType.f_271370_)));
    public static final RegistryObject<Block> LEPIDODENDRON_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("lepidodendron_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_60910_().m_60978_(1.0f).m_60918_(SoundType.f_271497_), UP2BlockProperties.LEPIDODENDRON_WOOD_TYPE));
    public static final RegistryObject<Block> LEPIDODENDRON_WALL_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("lepidodendron_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_60910_().m_60978_(1.0f).m_60918_(SoundType.f_271497_), UP2BlockProperties.LEPIDODENDRON_WOOD_TYPE));
    public static final RegistryObject<Block> LEPIDODENDRON_HANGING_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("lepidodendron_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280606_().m_280658_(NoteBlockInstrument.BASS).m_60910_().m_60978_(1.0f), UP2BlockProperties.LEPIDODENDRON_WOOD_TYPE));
    public static final RegistryObject<Block> LEPIDODENDRON_WALL_HANGING_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("lepidodendron_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280606_().m_280658_(NoteBlockInstrument.BASS).m_60910_().m_60978_(1.0f).m_60916_((Block)LEPIDODENDRON_HANGING_SIGN.get()), UP2BlockProperties.LEPIDODENDRON_WOOD_TYPE));
    public static final RegistryObject<Block> TRANSMOGRIFIER = UP2Blocks.registerBlock("transmogrifier", () -> new TransmogrifierBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283906_).m_280658_(NoteBlockInstrument.IRON_XYLOPHONE).m_60999_().m_60955_().m_60913_(5.0f, 6.0f).m_60918_(SoundType.f_56743_).m_60953_(UP2Blocks.litBlockEmission(7))));
    public static final RegistryObject<Block> FOSSILIZED_BONE_BLOCK = UP2Blocks.registerBlock("fossilized_bone_block", () -> new RotatedPillarBlock(UP2BlockProperties.FOSSIL_BLOCK));
    public static final RegistryObject<Block> FOSSILIZED_BONE_BARK = UP2Blocks.registerBlock("fossilized_bone_bark", () -> new RotatedPillarBlock(UP2BlockProperties.FOSSIL_BLOCK));
    public static final RegistryObject<Block> FOSSILIZED_BONE_VERTEBRA = UP2Blocks.registerBlock("fossilized_bone_vertebra", () -> new RotatedPillarBlock(UP2BlockProperties.FOSSIL_BLOCK));
    public static final RegistryObject<Block> FOSSILIZED_SKULL = UP2Blocks.registerBlock("fossilized_skull", () -> new FossilizedSkullBlock(UP2BlockProperties.FOSSIL_BLOCK));
    public static final RegistryObject<Block> FOSSILIZED_SKULL_LANTERN = UP2Blocks.registerBlock("fossilized_skull_lantern", () -> new FossilizedSkullBlock(UP2BlockProperties.fossilLantern(15)));
    public static final RegistryObject<Block> FOSSILIZED_SKULL_SOUL_LANTERN = UP2Blocks.registerBlock("fossilized_skull_soul_lantern", () -> new FossilizedSkullBlock(UP2BlockProperties.fossilLantern(10)));
    public static final RegistryObject<Block> COBBLED_FOSSILIZED_BONE = UP2Blocks.registerBlock("cobbled_fossilized_bone", () -> new Block(UP2BlockProperties.FOSSIL_BLOCK));
    public static final RegistryObject<Block> COBBLED_FOSSILIZED_BONE_STAIRS = UP2Blocks.registerBlock("cobbled_fossilized_bone_stairs", () -> new StairBlock(() -> ((Block)COBBLED_FOSSILIZED_BONE.get()).m_49966_(), BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)COBBLED_FOSSILIZED_BONE.get()))));
    public static final RegistryObject<Block> COBBLED_FOSSILIZED_BONE_SLAB = UP2Blocks.registerBlock("cobbled_fossilized_bone_slab", () -> new SlabBlock(BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)COBBLED_FOSSILIZED_BONE.get()))));
    public static final RegistryObject<Block> FOSSILIZED_BONE_ROD = UP2Blocks.registerBlock("fossilized_bone_rod", () -> new FossilizedBoneRodBlock(UP2BlockProperties.FOSSIL_BLOCK));
    public static final RegistryObject<Block> FOSSILIZED_BONE_SPIKE = UP2Blocks.registerBlock("fossilized_bone_spike", () -> new FossilizedBoneSpikeBlock(UP2BlockProperties.FOSSIL_BLOCK.m_60955_()));
    public static final RegistryObject<Block> FOSSILIZED_BONE_ROW = UP2Blocks.registerBlock("fossilized_bone_row", () -> new FossilizedBoneRowBlock(UP2BlockProperties.FOSSIL_BLOCK.m_60955_()));
    public static final RegistryObject<Block> PETRIFIED_BUSH = UP2Blocks.registerBlock("petrified_bush", () -> new PetrifiedBushBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_60955_().m_60910_().m_280658_(NoteBlockInstrument.HARP).m_60978_(1.0f).m_60966_().m_60918_(SoundType.f_154661_)));
    public static final RegistryObject<Block> PETRIFIED_LOG = UP2Blocks.registerBlock("petrified_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280658_(NoteBlockInstrument.HARP).m_60999_().m_60978_(3.0f).m_60918_(SoundType.f_154661_)));
    public static final RegistryObject<Block> PETRIFIED_WOOD = UP2Blocks.registerBlock("petrified_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280658_(NoteBlockInstrument.HARP).m_60999_().m_60978_(3.0f).m_60918_(SoundType.f_154661_)));
    public static final RegistryObject<Block> POLISHED_PETRIFIED_WOOD = UP2Blocks.registerBlock("polished_petrified_wood", () -> new Block(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280658_(NoteBlockInstrument.HARP).m_60999_().m_60978_(3.0f).m_60918_(SoundType.f_154661_)));
    public static final RegistryObject<Block> POLISHED_PETRIFIED_WOOD_STAIRS = UP2Blocks.registerBlock("polished_petrified_wood_stairs", () -> new StairBlock(() -> ((Block)POLISHED_PETRIFIED_WOOD.get()).m_49966_(), BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)POLISHED_PETRIFIED_WOOD.get()))));
    public static final RegistryObject<Block> POLISHED_PETRIFIED_WOOD_SLAB = UP2Blocks.registerBlock("polished_petrified_wood_slab", () -> new SlabBlock(BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)POLISHED_PETRIFIED_WOOD.get()))));
    public static final RegistryObject<Block> POLISHED_PETRIFIED_WOOD_PRESSURE_PLATE = UP2Blocks.registerBlock("polished_petrified_wood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280606_().m_280658_(NoteBlockInstrument.HARP).m_60999_().m_60910_().m_60978_(0.5f).m_278166_(PushReaction.DESTROY), BlockSetType.f_271479_));
    public static final RegistryObject<Block> POLISHED_PETRIFIED_WOOD_BUTTON = UP2Blocks.registerBlock("polished_petrified_wood_button", () -> new ButtonBlock(BlockBehaviour.Properties.m_284310_().m_60910_().m_60978_(0.5f).m_278166_(PushReaction.DESTROY), BlockSetType.f_271479_, 20, false));
    public static final RegistryObject<LiquidBlock> TAR = UP2Blocks.registerBlockWithoutItem("tar", () -> new TarBlock((Supplier<? extends FlowingFluid>)UP2Fluids.TAR_FLUID_SOURCE, UP2BlockProperties.TAR));
    public static final RegistryObject<Block> ASPHALT = UP2Blocks.registerBlock("asphalt", () -> new Block(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283927_).m_280658_(NoteBlockInstrument.BASEDRUM).m_60999_().m_60913_(1.5f, 5.0f).m_60918_(SoundType.f_56742_).m_60956_(1.15f)));
    public static final RegistryObject<Block> ONCHOPRISTIS_SAC = UP2Blocks.registerEggBlock("onchopristis_sac", () -> new UnderwaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.ONCHOPRISTIS.get(), 1));
    public static final RegistryObject<Block> TARTUOSTEUS_ROE = UP2Blocks.registerWaterEggBlock("tartuosteus_roe", () -> new WaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.TARTUOSTEUS.get(), 1));
    public static final RegistryObject<Block> OOZE_CAULDRON = UP2Blocks.registerBlockWithoutItem("ooze_cauldron", () -> new OozeCauldron(UP2BlockProperties.CAULDRON));
    public static final RegistryObject<Block> BRACHIOSAURUS_EGG = UP2Blocks.registerEggBlock("brachiosaurus_egg", () -> new TallEggBlock(UP2BlockProperties.EGG, () -> UP2Entities.BRACHIOSAURUS.get(), 16, 16, 16, 8, false));
    public static final RegistryObject<Block> COELACANTHUS_ROE = UP2Blocks.registerWaterEggBlock("coelacanthus_roe", () -> new WaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.COELACANTHUS.get(), 1));
    public static final RegistryObject<Block> HIBBERTOPTERUS_EGGS = UP2Blocks.registerWaterEggBlock("hibbertopterus_eggs", () -> new WaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.HIBBERTOPTERUS.get(), 1));
    public static final RegistryObject<Block> KAPROSUCHUS_EGG = UP2Blocks.registerEggBlock("kaprosuchus_egg", () -> new EggBlock(UP2BlockProperties.EGG, () -> UP2Entities.KAPROSUCHUS.get(), 8, 12, false));
    public static final RegistryObject<Block> LOBE_FINNED_FISH_ROE = UP2Blocks.registerWaterEggBlock("lobe_finned_fish_roe", () -> new WaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.LOBE_FINNED_FISH.get(), 3));
    public static final RegistryObject<Block> LYSTROSAURUS_EGG = UP2Blocks.registerEggBlock("lystrosaurus_egg", () -> new MultipleEggBlock(UP2BlockProperties.EGG, () -> UP2Entities.LYSTROSAURUS.get(), 3, 6, 6, 12, 12, false));
    public static final RegistryObject<Block> PACHYCEPHALOSAURUS_EGG = UP2Blocks.registerEggBlock("pachycephalosaurus_egg", () -> new EggBlock(UP2BlockProperties.EGG, () -> UP2Entities.PACHYCEPHALOSAURUS.get(), 10, 10, false));
    public static final RegistryObject<Block> ULUGHBEGSAURUS_EGG = UP2Blocks.registerEggBlock("ulughbegsaurus_egg", () -> new EggBlock(UP2BlockProperties.EGG, () -> UP2Entities.ULUGHBEGSAURUS.get(), 10, 14, false));
    public static final RegistryObject<Block> AETHOPHYLLUM = UP2Blocks.registerBlock("aethophyllum", () -> new PrehistoricTallFlowerBlock(UP2BlockProperties.TALL_PLANT));
    public static final RegistryObject<Block> ARCHAEOSIGILLARIA = UP2Blocks.registerBlock("archaeosigillaria", () -> new PrehistoricPlantBlock(UP2BlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_ARCHAEOSIGILLARIA = UP2Blocks.registerBlockWithoutItem("potted_archaeosigillaria", () -> new FlowerPotBlock((Block)ARCHAEOSIGILLARIA.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> BRACHYPHYLLUM = UP2Blocks.registerBlock("brachyphyllum", () -> new ThreeTallPlantBlock(UP2BlockProperties.TALL_PLANT));
    public static final RegistryObject<Block> CYCAD_SEEDLING = UP2Blocks.registerBlock("cycad_seedling", () -> new CycadSeedlingBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283748_).m_280658_(NoteBlockInstrument.BASS).m_60918_(SoundType.f_56736_).m_60966_().m_278166_(PushReaction.DESTROY).m_60955_().m_278183_()));
    public static final RegistryObject<Block> CYCAD_STEM = UP2Blocks.registerBlock("cycad_stem", () -> new CycadStemBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283748_).m_280658_(NoteBlockInstrument.BASS).m_60978_(1.5f).m_60918_(SoundType.f_56736_).m_278183_()));
    public static final RegistryObject<Block> CYCAD_CROWN = UP2Blocks.registerBlock("cycad_crown", () -> new CycadCrownBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283784_).m_280658_(NoteBlockInstrument.BASS).m_60978_(1.5f).m_60918_(SoundType.f_56736_).m_60955_().m_278183_()));
    public static final RegistryObject<Block> GUANGDEDENDRON_SPORE = UP2Blocks.registerBlockWithoutItem("guangdedendron_spore", () -> new GuangdedendronSporeBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283915_).m_280606_().m_60977_().m_60966_().m_60910_().m_60978_(1.0f).m_60918_(SoundType.f_56755_).m_222979_(BlockBehaviour.OffsetType.XZ).m_278183_().m_278166_(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GUANGDEDENDRON = UP2Blocks.registerBlock("guangdedendron", () -> new GuangdedendronStalkBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283915_).m_280606_().m_60977_().m_60966_().m_60978_(1.0f).m_60918_(SoundType.f_56754_).m_60955_().m_222979_(BlockBehaviour.OffsetType.XZ).m_60988_().m_278183_().m_278166_(PushReaction.DESTROY).m_60924_(UP2BlockProperties::never)));
    public static final RegistryObject<Block> NEOMARIOPTERIS = UP2Blocks.registerBlock("neomariopteris", () -> new PrehistoricPlantBlock(UP2BlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_NEOMARIOPTERIS = UP2Blocks.registerBlockWithoutItem("potted_neomariopteris", () -> new FlowerPotBlock((Block)NEOMARIOPTERIS.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> PROTOTAXITES = UP2Blocks.registerBlock("prototaxites", () -> new RotatedPillarBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283811_).m_280658_(NoteBlockInstrument.BASS).m_60978_(0.2f).m_60918_(SoundType.f_56753_).m_278183_()));
    public static final RegistryObject<Block> PROTOTAXITES_NUB = UP2Blocks.registerBlock("prototaxites_nub", () -> new PrototaxitesNubBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283811_).m_280658_(NoteBlockInstrument.BASS).m_60978_(0.2f).m_60910_().m_60918_(SoundType.f_56753_).m_278183_()));
    public static final RegistryObject<Block> LARGE_PROTOTAXITES_NUB = UP2Blocks.registerBlock("large_prototaxites_nub", () -> new LargePrototaxitesNubBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283811_).m_280658_(NoteBlockInstrument.BASS).m_60978_(0.2f).m_60910_().m_60918_(SoundType.f_56753_).m_278183_()));
    public static final RegistryObject<Block> PROTOTAXITES_CLUSTER = UP2Blocks.registerBlock("prototaxites_cluster", () -> new PrototaxitesClusterBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283811_).m_280658_(NoteBlockInstrument.BASS).m_60978_(0.2f).m_60910_().m_60918_(SoundType.f_56753_).m_278183_()));
    public static final RegistryObject<Block> TEMPSKYA = UP2Blocks.registerBlock("tempskya", () -> new PrehistoricTallPlantBlock(UP2BlockProperties.TALL_PLANT));
    public static final RegistryObject<Block> DRYOPHYLLUM_LOG = UP2Blocks.registerBlock("dryophyllum_log", () -> new WoodBlocks(UP2BlockProperties.log(MapColor.f_283818_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> DRYOPHYLLUM_WOOD = UP2Blocks.registerBlock("dryophyllum_wood", () -> new WoodBlocks(UP2BlockProperties.log(MapColor.f_283818_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_DRYOPHYLLUM_LOG = UP2Blocks.registerBlock("stripped_dryophyllum_log", () -> new RotatedPillarBlock(UP2BlockProperties.log(MapColor.f_283765_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_DRYOPHYLLUM_WOOD = UP2Blocks.registerBlock("stripped_dryophyllum_wood", () -> new RotatedPillarBlock(UP2BlockProperties.log(MapColor.f_283765_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> DRYOPHYLLUM_PLANKS = UP2Blocks.registerBlock("dryophyllum_planks", () -> new Block(UP2BlockProperties.plank(MapColor.f_283765_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> DRYOPHYLLUM_STAIRS = UP2Blocks.registerBlock("dryophyllum_stairs", () -> new StairBlock(() -> ((Block)DRYOPHYLLUM_PLANKS.get()).m_49966_(), BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)DRYOPHYLLUM_PLANKS.get()))));
    public static final RegistryObject<Block> DRYOPHYLLUM_SLAB = UP2Blocks.registerBlock("dryophyllum_slab", () -> new SlabBlock(BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)DRYOPHYLLUM_PLANKS.get()))));
    public static final RegistryObject<Block> DRYOPHYLLUM_FENCE = UP2Blocks.registerBlock("dryophyllum_fence", () -> new FenceBlock(UP2BlockProperties.plank(MapColor.f_283765_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> DRYOPHYLLUM_FENCE_GATE = UP2Blocks.registerBlock("dryophyllum_fence_gate", () -> new FenceGateBlock(UP2BlockProperties.plank(MapColor.f_283765_, SoundType.f_271497_, NoteBlockInstrument.BASS), SoundEvents.f_271336_, SoundEvents.f_271336_));
    public static final RegistryObject<Block> DRYOPHYLLUM_DOOR = UP2Blocks.registerBlock("dryophyllum_door", () -> new DoorBlock(UP2BlockProperties.woodenDoor(MapColor.f_283765_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> DRYOPHYLLUM_TRAPDOOR = UP2Blocks.registerBlock("dryophyllum_trapdoor", () -> new TrapDoorBlock(UP2BlockProperties.woodenTrapdoor(MapColor.f_283765_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> DRYOPHYLLUM_PRESSURE_PLATE = UP2Blocks.registerBlock("dryophyllum_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, UP2BlockProperties.woodenPressurePlate(MapColor.f_283765_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> DRYOPHYLLUM_BUTTON = UP2Blocks.registerBlock("dryophyllum_button", () -> new ButtonBlock(UP2BlockProperties.woodenButton(SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_, 30, true));
    public static final RegistryObject<Block> DRYOPHYLLUM_LEAVES = UP2Blocks.registerBlock("dryophyllum_leaves", () -> new LeavesBlock(UP2BlockProperties.leaves(MapColor.f_283915_, SoundType.f_154674_)));
    public static final RegistryObject<Block> DRYOPHYLLUM_SAPLING = UP2Blocks.registerBlock("dryophyllum_sapling", () -> new SaplingBlock((AbstractTreeGrower)new DryophyllumTreeGrower(), UP2BlockProperties.sapling(MapColor.f_283915_, SoundType.f_271370_)));
    public static final RegistryObject<Block> POTTED_DRYOPHYLLUM_SAPLING = UP2Blocks.registerBlockWithoutItem("potted_dryophyllum_sapling", () -> new FlowerPotBlock((Block)DRYOPHYLLUM_SAPLING.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> DRYOPHYLLUM_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("dryophyllum_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_60910_().m_60978_(1.0f).m_60918_(SoundType.f_271497_), UP2BlockProperties.DRYOPHYLLUM_WOOD_TYPE));
    public static final RegistryObject<Block> DRYOPHYLLUM_WALL_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("dryophyllum_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_60910_().m_60978_(1.0f).m_60918_(SoundType.f_271497_), UP2BlockProperties.DRYOPHYLLUM_WOOD_TYPE));
    public static final RegistryObject<Block> DRYOPHYLLUM_HANGING_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("dryophyllum_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280606_().m_280658_(NoteBlockInstrument.BASS).m_60910_().m_60978_(1.0f), UP2BlockProperties.DRYOPHYLLUM_WOOD_TYPE));
    public static final RegistryObject<Block> DRYOPHYLLUM_WALL_HANGING_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("dryophyllum_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280606_().m_280658_(NoteBlockInstrument.BASS).m_60910_().m_60978_(1.0f).m_60916_((Block)DRYOPHYLLUM_HANGING_SIGN.get()), UP2BlockProperties.DRYOPHYLLUM_WOOD_TYPE));
    public static final RegistryObject<Block> METASEQUOIA_LOG = UP2Blocks.registerBlock("metasequoia_log", () -> new WoodBlocks(UP2BlockProperties.log(MapColor.f_283798_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> METASEQUOIA_WOOD = UP2Blocks.registerBlock("metasequoia_wood", () -> new WoodBlocks(UP2BlockProperties.log(MapColor.f_283798_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_METASEQUOIA_LOG = UP2Blocks.registerBlock("stripped_metasequoia_log", () -> new RotatedPillarBlock(UP2BlockProperties.log(MapColor.f_283798_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> STRIPPED_METASEQUOIA_WOOD = UP2Blocks.registerBlock("stripped_metasequoia_wood", () -> new RotatedPillarBlock(UP2BlockProperties.log(MapColor.f_283798_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> METASEQUOIA_PLANKS = UP2Blocks.registerBlock("metasequoia_planks", () -> new Block(UP2BlockProperties.plank(MapColor.f_283798_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> METASEQUOIA_STAIRS = UP2Blocks.registerBlock("metasequoia_stairs", () -> new StairBlock(() -> ((Block)METASEQUOIA_PLANKS.get()).m_49966_(), BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)METASEQUOIA_PLANKS.get()))));
    public static final RegistryObject<Block> METASEQUOIA_SLAB = UP2Blocks.registerBlock("metasequoia_slab", () -> new SlabBlock(BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)METASEQUOIA_PLANKS.get()))));
    public static final RegistryObject<Block> METASEQUOIA_FENCE = UP2Blocks.registerBlock("metasequoia_fence", () -> new FenceBlock(UP2BlockProperties.plank(MapColor.f_283798_, SoundType.f_271497_, NoteBlockInstrument.BASS)));
    public static final RegistryObject<Block> METASEQUOIA_FENCE_GATE = UP2Blocks.registerBlock("metasequoia_fence_gate", () -> new FenceGateBlock(UP2BlockProperties.plank(MapColor.f_283798_, SoundType.f_271497_, NoteBlockInstrument.BASS), SoundEvents.f_271336_, SoundEvents.f_271336_));
    public static final RegistryObject<Block> METASEQUOIA_DOOR = UP2Blocks.registerBlock("metasequoia_door", () -> new DoorBlock(UP2BlockProperties.woodenDoor(MapColor.f_283798_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> METASEQUOIA_TRAPDOOR = UP2Blocks.registerBlock("metasequoia_trapdoor", () -> new TrapDoorBlock(UP2BlockProperties.woodenTrapdoor(MapColor.f_283798_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> METASEQUOIA_PRESSURE_PLATE = UP2Blocks.registerBlock("metasequoia_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, UP2BlockProperties.woodenPressurePlate(MapColor.f_283798_, SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_));
    public static final RegistryObject<Block> METASEQUOIA_BUTTON = UP2Blocks.registerBlock("metasequoia_button", () -> new ButtonBlock(UP2BlockProperties.woodenButton(SoundType.f_271497_, NoteBlockInstrument.BASS), BlockSetType.f_271401_, 30, true));
    public static final RegistryObject<Block> METASEQUOIA_LEAVES = UP2Blocks.registerBlock("metasequoia_leaves", () -> new LeavesBlock(UP2BlockProperties.leaves(MapColor.f_283915_, SoundType.f_154674_)));
    public static final RegistryObject<Block> METASEQUOIA_SAPLING = UP2Blocks.registerBlock("metasequoia_sapling", () -> new MetasequoiaSaplingBlock((AbstractTreeGrower)new MetasequoiaTreeGrower(), UP2BlockProperties.sapling(MapColor.f_283915_, SoundType.f_271370_)));
    public static final RegistryObject<Block> POTTED_METASEQUOIA_SAPLING = UP2Blocks.registerBlockWithoutItem("potted_metasequoia_sapling", () -> new FlowerPotBlock((Block)METASEQUOIA_SAPLING.get(), UP2Blocks.registerFlowerPot(new FeatureFlag[0])));
    public static final RegistryObject<Block> METASEQUOIA_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("metasequoia_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_60910_().m_60978_(1.0f).m_60918_(SoundType.f_271497_), UP2BlockProperties.METASEQUOIA_WOOD_TYPE));
    public static final RegistryObject<Block> METASEQUOIA_WALL_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("metasequoia_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_60910_().m_60978_(1.0f).m_60918_(SoundType.f_271497_), UP2BlockProperties.METASEQUOIA_WOOD_TYPE));
    public static final RegistryObject<Block> METASEQUOIA_HANGING_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("metasequoia_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280606_().m_280658_(NoteBlockInstrument.BASS).m_60910_().m_60978_(1.0f), UP2BlockProperties.METASEQUOIA_WOOD_TYPE));
    public static final RegistryObject<Block> METASEQUOIA_WALL_HANGING_SIGN = UP2Blocks.registerBlockWithoutItemNoLang("metasequoia_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283825_).m_280606_().m_280658_(NoteBlockInstrument.BASS).m_60910_().m_60978_(1.0f).m_60916_((Block)METASEQUOIA_HANGING_SIGN.get()), UP2BlockProperties.METASEQUOIA_WOOD_TYPE));
    public static final RegistryObject<Block> PALEOSTONE = UP2Blocks.registerBlock("paleostone", () -> new Block(UP2BlockProperties.FOSSIL_STONE));
    public static final RegistryObject<Block> PALEOSTONE_STAIRS = UP2Blocks.registerBlock("paleostone_stairs", () -> new StairBlock(() -> ((Block)PALEOSTONE.get()).m_49966_(), BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)PALEOSTONE.get()))));
    public static final RegistryObject<Block> PALEOSTONE_SLAB = UP2Blocks.registerBlock("paleostone_slab", () -> new SlabBlock(BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)PALEOSTONE.get()))));
    public static final RegistryObject<Block> MESONITE = UP2Blocks.registerBlock("mesonite", () -> new Block(UP2BlockProperties.FOSSIL_STONE));
    public static final RegistryObject<Block> MESONITE_STAIRS = UP2Blocks.registerBlock("mesonite_stairs", () -> new StairBlock(() -> ((Block)MESONITE.get()).m_49966_(), BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)MESONITE.get()))));
    public static final RegistryObject<Block> MESONITE_SLAB = UP2Blocks.registerBlock("mesonite_slab", () -> new SlabBlock(BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)MESONITE.get()))));
    public static final RegistryObject<Block> FLORALITE = UP2Blocks.registerBlock("floralite", () -> new Block(UP2BlockProperties.FOSSIL_STONE));
    public static final RegistryObject<Block> FLORALITE_STAIRS = UP2Blocks.registerBlock("floralite_stairs", () -> new StairBlock(() -> ((Block)FLORALITE.get()).m_49966_(), BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)FLORALITE.get()))));
    public static final RegistryObject<Block> FLORALITE_SLAB = UP2Blocks.registerBlock("floralite_slab", () -> new SlabBlock(BlockBehaviour.Properties.m_60926_((BlockBehaviour)((BlockBehaviour)FLORALITE.get()))));
    public static final RegistryObject<Block> REINFORCED_GLASS = UP2Blocks.registerBlock("reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283808_)));
    public static final RegistryObject<Block> TINTED_REINFORCED_GLASS = UP2Blocks.registerBlock("tinted_reinforced_glass", () -> new TintedConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283818_)));
    public static final RegistryObject<Block> WHITE_REINFORCED_GLASS = UP2Blocks.registerBlock("white_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283811_)));
    public static final RegistryObject<Block> LIGHT_GRAY_REINFORCED_GLASS = UP2Blocks.registerBlock("light_gray_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283779_)));
    public static final RegistryObject<Block> GRAY_REINFORCED_GLASS = UP2Blocks.registerBlock("gray_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283818_)));
    public static final RegistryObject<Block> BLACK_REINFORCED_GLASS = UP2Blocks.registerBlock("black_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283927_)));
    public static final RegistryObject<Block> BROWN_REINFORCED_GLASS = UP2Blocks.registerBlock("brown_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283748_)));
    public static final RegistryObject<Block> RED_REINFORCED_GLASS = UP2Blocks.registerBlock("red_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283913_)));
    public static final RegistryObject<Block> ORANGE_REINFORCED_GLASS = UP2Blocks.registerBlock("orange_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283750_)));
    public static final RegistryObject<Block> YELLOW_REINFORCED_GLASS = UP2Blocks.registerBlock("yellow_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283832_)));
    public static final RegistryObject<Block> LIME_REINFORCED_GLASS = UP2Blocks.registerBlock("lime_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283916_)));
    public static final RegistryObject<Block> GREEN_REINFORCED_GLASS = UP2Blocks.registerBlock("green_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283784_)));
    public static final RegistryObject<Block> CYAN_REINFORCED_GLASS = UP2Blocks.registerBlock("cyan_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283772_)));
    public static final RegistryObject<Block> LIGHT_BLUE_REINFORCED_GLASS = UP2Blocks.registerBlock("light_blue_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283869_)));
    public static final RegistryObject<Block> BLUE_REINFORCED_GLASS = UP2Blocks.registerBlock("blue_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283743_)));
    public static final RegistryObject<Block> PURPLE_REINFORCED_GLASS = UP2Blocks.registerBlock("purple_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283889_)));
    public static final RegistryObject<Block> MAGENTA_REINFORCED_GLASS = UP2Blocks.registerBlock("magenta_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283931_)));
    public static final RegistryObject<Block> PINK_REINFORCED_GLASS = UP2Blocks.registerBlock("pink_reinforced_glass", () -> new ConnectedGlassBlock(UP2BlockProperties.reinforcedGlass(MapColor.f_283765_)));
    public static final RegistryObject<Block> AEGIROCASSIS_EGGS = UP2Blocks.registerEggBlock("aegirocassis_eggs", () -> new UnderwaterEggBlock(UP2BlockProperties.WATER_EGG, () -> UP2Entities.AEGIROCASSIS.get(), 1));
    public static final RegistryObject<Block> BARINASUCHUS_EGG = UP2Blocks.registerEggBlock("barinasuchus_egg", () -> new EggBlock(UP2BlockProperties.EGG, () -> UP2Entities.BARINASUCHUS.get(), 12, 12, false));
    public static final RegistryObject<Block> DESMATOSUCHUS_EGG = UP2Blocks.registerEggBlock("desmatosuchus_egg", () -> new EggBlock(UP2BlockProperties.EGG, () -> UP2Entities.DESMATOSUCHUS.get(), 8, 13, false));
    public static final RegistryObject<Block> MANIPULATOR_OOTHECA = UP2Blocks.registerWaterEggBlock("manipulator_ootheca", () -> new RotatableEggBlock(UP2BlockProperties.SQUISHY_EGG, () -> UP2Entities.MANIPULATOR.get(), 10, 6, false));
    public static final RegistryObject<Block> THERIZINOSAURUS_EGG = UP2Blocks.registerEggBlock("therizinosaurus_egg", () -> new EggBlock(UP2BlockProperties.EGG, () -> UP2Entities.THERIZINOSAURUS.get(), 16, 16, false));

    private static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier) {
        RegistryObject block = BLOCKS.register(name, supplier);
        UP2Items.ITEMS.register(name, () -> new BlockItem((Block)block.get(), new Item.Properties()));
        BLOCK_TRANSLATIONS.add((RegistryObject<? extends Block>)block);
        return block;
    }

    private static <B extends Block> RegistryObject<B> registerBlockNoLang(String name, Supplier<? extends B> supplier) {
        RegistryObject block = BLOCKS.register(name, supplier);
        UP2Items.ITEMS.register(name, () -> new BlockItem((Block)block.get(), new Item.Properties()));
        return block;
    }

    private static <B extends Block> RegistryObject<B> registerBlockWithoutItem(String name, Supplier<? extends B> supplier) {
        RegistryObject block = BLOCKS.register(name, supplier);
        BLOCK_TRANSLATIONS.add((RegistryObject<? extends Block>)block);
        return block;
    }

    private static <B extends Block> RegistryObject<B> registerBlockWithoutItemNoLang(String name, Supplier<? extends B> supplier) {
        return BLOCKS.register(name, supplier);
    }

    private static <B extends Block> Supplier<B> registerBlockWithItem(String name, Supplier<B> block, Function<Supplier<B>, Item> item) {
        RegistryObject entry = UP2Blocks.registerBlockWithoutItem(name, block);
        UP2Items.ITEMS.register(name, () -> (Item)item.apply((Supplier)entry));
        return entry;
    }

    public static <T extends Block> RegistryObject<T> registerEggBlock(String name, Supplier<T> supplier) {
        RegistryObject block = BLOCKS.register(name, supplier);
        UP2Items.ITEMS.register(name, () -> new BlockItem((Block)block.get(), new Item.Properties()));
        BLOCK_TRANSLATIONS.add((RegistryObject<? extends Block>)block);
        EGG_BLOCKS.add((Supplier<? extends Block>)block);
        return block;
    }

    private static <B extends Block> RegistryObject<B> registerWaterEggBlock(String name, Supplier<? extends B> supplier) {
        RegistryObject block = BLOCKS.register(name, supplier);
        UP2Items.ITEMS.register(name, () -> new PlaceOnWaterBlockItem((Block)block.get(), new Item.Properties()));
        BLOCK_TRANSLATIONS.add((RegistryObject<? extends Block>)block);
        EGG_BLOCKS.add((Supplier<? extends Block>)block);
        return block;
    }

    private static BlockBehaviour.Properties registerFlowerPot(FeatureFlag ... featureFlags) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.m_284310_().m_60966_().m_60955_().m_278166_(PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties = properties.m_246843_(featureFlags);
        }
        return properties;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int lightLevel) {
        return state -> (Boolean)state.m_61143_((Property)BlockStateProperties.f_61443_) != false ? lightLevel : 0;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.ButtonBlock
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.DoublePlantBlock
 *  net.minecraft.world.level.block.FenceBlock
 *  net.minecraft.world.level.block.FenceGateBlock
 *  net.minecraft.world.level.block.PressurePlateBlock
 *  net.minecraft.world.level.block.RotatedPillarBlock
 *  net.minecraft.world.level.block.SlabBlock
 *  net.minecraft.world.level.block.StairBlock
 *  net.minecraft.world.level.block.TrapDoorBlock
 *  net.minecraft.world.level.block.WallBlock
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraftforge.client.model.generators.BlockModelBuilder
 *  net.minecraftforge.client.model.generators.BlockStateProvider
 *  net.minecraftforge.client.model.generators.ConfiguredModel
 *  net.minecraftforge.client.model.generators.ItemModelBuilder
 *  net.minecraftforge.client.model.generators.ModelBuilder
 *  net.minecraftforge.client.model.generators.ModelFile
 *  net.minecraftforge.data.event.GatherDataEvent
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import java.util.function.Function;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UP2BlockstateProvider
extends BlockStateProvider {
    public UP2BlockstateProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), "unusual_prehistory", event.getExistingFileHelper());
    }

    protected void registerStatesAndModels() {
        this.cubeAllBlock(UP2Blocks.ASPHALT);
        this.cubeAllBlock(UP2Blocks.PALEOSTONE);
        this.stairs(UP2Blocks.PALEOSTONE_STAIRS, this.blockTexture((Block)UP2Blocks.PALEOSTONE.get()));
        this.slab(UP2Blocks.PALEOSTONE_SLAB, this.blockTexture((Block)UP2Blocks.PALEOSTONE.get()));
        this.cubeAllBlock(UP2Blocks.MESONITE);
        this.stairs(UP2Blocks.MESONITE_STAIRS, this.blockTexture((Block)UP2Blocks.MESONITE.get()));
        this.slab(UP2Blocks.MESONITE_SLAB, this.blockTexture((Block)UP2Blocks.MESONITE.get()));
        this.cubeAllBlock(UP2Blocks.FLORALITE);
        this.stairs(UP2Blocks.FLORALITE_STAIRS, this.blockTexture((Block)UP2Blocks.FLORALITE.get()));
        this.slab(UP2Blocks.FLORALITE_SLAB, this.blockTexture((Block)UP2Blocks.FLORALITE.get()));
        this.pottedPlant(UP2Blocks.BENNETTITALES, UP2Blocks.POTTED_BENNETTITALES);
        this.pottedPlant(UP2Blocks.COOKSONIA, UP2Blocks.POTTED_COOKSONIA);
        this.pottedPlant(UP2Blocks.HORSETAIL, UP2Blocks.POTTED_HORSETAIL);
        this.pottedPlant(UP2Blocks.QUILLWORT, UP2Blocks.POTTED_QUILLWORT);
        this.pottedPlant(UP2Blocks.LEEFRUCTUS, UP2Blocks.POTTED_LEEFRUCTUS);
        this.pottedPlant(UP2Blocks.NEOMARIOPTERIS, UP2Blocks.POTTED_NEOMARIOPTERIS);
        this.pottedPlant(UP2Blocks.ARCHAEOSIGILLARIA, UP2Blocks.POTTED_ARCHAEOSIGILLARIA);
        this.tintedPottedPlant(UP2Blocks.CLADOPHLEBIS, UP2Blocks.POTTED_CLADOPHLEBIS);
        this.tallPlant(UP2Blocks.LARGE_HORSETAIL);
        this.tallPlant(UP2Blocks.RAIGUENRAYUN);
        this.pillar(UP2Blocks.DRYOPHYLLUM_LOG);
        this.wood(UP2Blocks.DRYOPHYLLUM_WOOD, this.blockTexture((Block)UP2Blocks.DRYOPHYLLUM_LOG.get()));
        this.pillar(UP2Blocks.STRIPPED_DRYOPHYLLUM_LOG);
        this.wood(UP2Blocks.STRIPPED_DRYOPHYLLUM_WOOD, this.blockTexture((Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_LOG.get()));
        this.cubeAllBlock(UP2Blocks.DRYOPHYLLUM_PLANKS);
        this.stairs(UP2Blocks.DRYOPHYLLUM_STAIRS, this.blockTexture((Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get()));
        this.slab(UP2Blocks.DRYOPHYLLUM_SLAB, this.blockTexture((Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get()));
        this.fence(UP2Blocks.DRYOPHYLLUM_FENCE, this.blockTexture((Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get()));
        this.fenceGate(UP2Blocks.DRYOPHYLLUM_FENCE_GATE, this.blockTexture((Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get()));
        this.doorCutout(UP2Blocks.DRYOPHYLLUM_DOOR);
        this.trapdoorCutout(UP2Blocks.DRYOPHYLLUM_TRAPDOOR);
        this.pressurePlate(UP2Blocks.DRYOPHYLLUM_PRESSURE_PLATE, this.blockTexture((Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get()));
        this.button(UP2Blocks.DRYOPHYLLUM_BUTTON, this.blockTexture((Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get()));
        this.leaves(UP2Blocks.DRYOPHYLLUM_LEAVES);
        this.pottedPlant(UP2Blocks.DRYOPHYLLUM_SAPLING, UP2Blocks.POTTED_DRYOPHYLLUM_SAPLING);
        this.pillar(UP2Blocks.GINKGO_LOG);
        this.wood(UP2Blocks.GINKGO_WOOD, this.blockTexture((Block)UP2Blocks.GINKGO_LOG.get()));
        this.pillar(UP2Blocks.STRIPPED_GINKGO_LOG);
        this.wood(UP2Blocks.STRIPPED_GINKGO_WOOD, this.blockTexture((Block)UP2Blocks.STRIPPED_GINKGO_LOG.get()));
        this.cubeAllBlock(UP2Blocks.GINKGO_PLANKS);
        this.stairs(UP2Blocks.GINKGO_STAIRS, this.blockTexture((Block)UP2Blocks.GINKGO_PLANKS.get()));
        this.slab(UP2Blocks.GINKGO_SLAB, this.blockTexture((Block)UP2Blocks.GINKGO_PLANKS.get()));
        this.fence(UP2Blocks.GINKGO_FENCE, this.blockTexture((Block)UP2Blocks.GINKGO_PLANKS.get()));
        this.fenceGate(UP2Blocks.GINKGO_FENCE_GATE, this.blockTexture((Block)UP2Blocks.GINKGO_PLANKS.get()));
        this.doorCutout(UP2Blocks.GINKGO_DOOR);
        this.trapdoorCutout(UP2Blocks.GINKGO_TRAPDOOR);
        this.pressurePlate(UP2Blocks.GINKGO_PRESSURE_PLATE, this.blockTexture((Block)UP2Blocks.GINKGO_PLANKS.get()));
        this.button(UP2Blocks.GINKGO_BUTTON, this.blockTexture((Block)UP2Blocks.GINKGO_PLANKS.get()));
        this.leaves(UP2Blocks.GINKGO_LEAVES);
        this.leaves(UP2Blocks.GOLDEN_GINKGO_LEAVES);
        this.pottedPlant(UP2Blocks.GINKGO_SAPLING, UP2Blocks.POTTED_GINKGO_SAPLING);
        this.pottedPlant(UP2Blocks.GOLDEN_GINKGO_SAPLING, UP2Blocks.POTTED_GOLDEN_GINKGO_SAPLING);
        this.pillar(UP2Blocks.LEPIDODENDRON_LOG);
        this.wood(UP2Blocks.LEPIDODENDRON_WOOD, this.blockTexture((Block)UP2Blocks.LEPIDODENDRON_LOG.get()));
        this.pillar(UP2Blocks.STRIPPED_LEPIDODENDRON_LOG);
        this.wood(UP2Blocks.STRIPPED_LEPIDODENDRON_WOOD, this.blockTexture((Block)UP2Blocks.STRIPPED_LEPIDODENDRON_LOG.get()));
        this.cubeAllBlock(UP2Blocks.LEPIDODENDRON_PLANKS);
        this.stairs(UP2Blocks.LEPIDODENDRON_STAIRS, this.blockTexture((Block)UP2Blocks.LEPIDODENDRON_PLANKS.get()));
        this.slab(UP2Blocks.LEPIDODENDRON_SLAB, this.blockTexture((Block)UP2Blocks.LEPIDODENDRON_PLANKS.get()));
        this.fence(UP2Blocks.LEPIDODENDRON_FENCE, this.blockTexture((Block)UP2Blocks.LEPIDODENDRON_PLANKS.get()));
        this.fenceGate(UP2Blocks.LEPIDODENDRON_FENCE_GATE, this.blockTexture((Block)UP2Blocks.LEPIDODENDRON_PLANKS.get()));
        this.doorCutout(UP2Blocks.LEPIDODENDRON_DOOR);
        this.trapdoorCutout(UP2Blocks.LEPIDODENDRON_TRAPDOOR);
        this.pressurePlate(UP2Blocks.LEPIDODENDRON_PRESSURE_PLATE, this.blockTexture((Block)UP2Blocks.LEPIDODENDRON_PLANKS.get()));
        this.button(UP2Blocks.LEPIDODENDRON_BUTTON, this.blockTexture((Block)UP2Blocks.LEPIDODENDRON_PLANKS.get()));
        this.leaves(UP2Blocks.LEPIDODENDRON_LEAVES);
        this.simpleCross(UP2Blocks.HANGING_LEPIDODENDRON_LEAVES);
        this.pillar(UP2Blocks.METASEQUOIA_LOG);
        this.wood(UP2Blocks.METASEQUOIA_WOOD, this.blockTexture((Block)UP2Blocks.METASEQUOIA_LOG.get()));
        this.pillar(UP2Blocks.STRIPPED_METASEQUOIA_LOG);
        this.wood(UP2Blocks.STRIPPED_METASEQUOIA_WOOD, this.blockTexture((Block)UP2Blocks.STRIPPED_METASEQUOIA_LOG.get()));
        this.cubeAllBlock(UP2Blocks.METASEQUOIA_PLANKS);
        this.stairs(UP2Blocks.METASEQUOIA_STAIRS, this.blockTexture((Block)UP2Blocks.METASEQUOIA_PLANKS.get()));
        this.slab(UP2Blocks.METASEQUOIA_SLAB, this.blockTexture((Block)UP2Blocks.METASEQUOIA_PLANKS.get()));
        this.fence(UP2Blocks.METASEQUOIA_FENCE, this.blockTexture((Block)UP2Blocks.METASEQUOIA_PLANKS.get()));
        this.fenceGate(UP2Blocks.METASEQUOIA_FENCE_GATE, this.blockTexture((Block)UP2Blocks.METASEQUOIA_PLANKS.get()));
        this.doorCutout(UP2Blocks.METASEQUOIA_DOOR);
        this.trapdoorCutout(UP2Blocks.METASEQUOIA_TRAPDOOR);
        this.pressurePlate(UP2Blocks.METASEQUOIA_PRESSURE_PLATE, this.blockTexture((Block)UP2Blocks.METASEQUOIA_PLANKS.get()));
        this.button(UP2Blocks.METASEQUOIA_BUTTON, this.blockTexture((Block)UP2Blocks.METASEQUOIA_PLANKS.get()));
        this.leaves(UP2Blocks.METASEQUOIA_LEAVES);
        this.pillar(UP2Blocks.FOSSILIZED_BONE_BLOCK);
        this.pillarWithTop(UP2Blocks.FOSSILIZED_BONE_VERTEBRA, "fossilized_bone_block_top");
        this.pillarWithName(UP2Blocks.FOSSILIZED_BONE_BARK, "fossilized_bone_block", "fossilized_bone_block");
        this.cubeAllBlock(UP2Blocks.COBBLED_FOSSILIZED_BONE);
        this.stairs(UP2Blocks.COBBLED_FOSSILIZED_BONE_STAIRS, this.blockTexture((Block)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()));
        this.slab(UP2Blocks.COBBLED_FOSSILIZED_BONE_SLAB, this.blockTexture((Block)UP2Blocks.COBBLED_FOSSILIZED_BONE.get()));
        this.simpleCross(UP2Blocks.PETRIFIED_BUSH);
        this.pillar(UP2Blocks.PETRIFIED_LOG);
        this.pillarWithName(UP2Blocks.PETRIFIED_WOOD, "petrified_log", "petrified_log");
        this.cubeAllBlock(UP2Blocks.POLISHED_PETRIFIED_WOOD);
        this.stairs(UP2Blocks.POLISHED_PETRIFIED_WOOD_STAIRS, this.blockTexture((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD.get()));
        this.slab(UP2Blocks.POLISHED_PETRIFIED_WOOD_SLAB, this.blockTexture((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD.get()));
        this.pressurePlate(UP2Blocks.POLISHED_PETRIFIED_WOOD_PRESSURE_PLATE, this.blockTexture((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD.get()));
        this.button(UP2Blocks.POLISHED_PETRIFIED_WOOD_BUTTON, this.blockTexture((Block)UP2Blocks.POLISHED_PETRIFIED_WOOD.get()));
        this.simpleCross(UP2Blocks.PROTOTAXITES_CLUSTER);
    }

    private void itemModel(RegistryObject<Block> block) {
        this.itemModels().withExistingParent(UP2BlockstateProvider.getItemName((ItemLike)block.get()), this.blockTexture((Block)block.get()));
    }

    private void generatedItem(ItemLike item, TextureFolder folder) {
        String name = UP2BlockstateProvider.getItemName(item);
        ((ItemModelBuilder)this.itemModels().withExistingParent(name, "item/generated")).texture("layer0", this.modLoc(folder.format(name)));
    }

    private void cubeAllBlock(RegistryObject<Block> block) {
        this.simpleBlock((Block)block.get());
        this.itemModel(block);
    }

    private void stairs(RegistryObject<Block> stairs, ResourceLocation texture) {
        this.stairsBlock((StairBlock)stairs.get(), texture);
        this.itemModel(stairs);
    }

    private void slab(RegistryObject<Block> slab, ResourceLocation texture) {
        this.slabBlock((SlabBlock)slab.get(), texture, texture);
        this.itemModel(slab);
    }

    private void wall(RegistryObject<Block> wall, ResourceLocation texture) {
        this.wallBlock((WallBlock)wall.get(), texture);
        this.itemModels().wallInventory(UP2BlockstateProvider.getItemName((ItemLike)wall.get()), texture);
    }

    private void pillar(RegistryObject<Block> pillar) {
        this.axisBlock((RotatedPillarBlock)pillar.get(), this.blockTexture((Block)pillar.get()), this.modLoc("block/" + UP2BlockstateProvider.getItemName((ItemLike)pillar.get()) + "_top"));
        this.itemModel(pillar);
    }

    private void pillarWithTop(RegistryObject<Block> pillar, String topTexture) {
        this.axisBlock((RotatedPillarBlock)pillar.get(), this.blockTexture((Block)pillar.get()), this.modLoc("block/" + topTexture));
        this.itemModel(pillar);
    }

    private void pillarWithName(RegistryObject<Block> pillar, String sideTexture, String topTexture) {
        this.axisBlock((RotatedPillarBlock)pillar.get(), this.modLoc("block/" + sideTexture), this.modLoc("block/" + topTexture));
        this.itemModel(pillar);
    }

    private void pillarNoTop(RegistryObject<Block> pillar) {
        this.axisBlock((RotatedPillarBlock)pillar.get(), this.blockTexture((Block)pillar.get()), this.modLoc("block/" + UP2BlockstateProvider.getItemName((ItemLike)pillar.get()) + "_top"));
        this.itemModel(pillar);
    }

    private void wood(RegistryObject<Block> log, ResourceLocation texture) {
        this.axisBlock((RotatedPillarBlock)log.get(), texture, texture);
        this.itemModel(log);
    }

    private void fence(RegistryObject<Block> fence, ResourceLocation texture) {
        this.fenceBlock((FenceBlock)fence.get(), texture);
        this.itemModels().fenceInventory(UP2BlockstateProvider.getItemName((ItemLike)fence.get()), texture);
    }

    private void fenceGate(RegistryObject<Block> gate, ResourceLocation texture) {
        this.fenceGateBlock((FenceGateBlock)gate.get(), texture);
        this.itemModel(gate);
    }

    private void trapdoor(RegistryObject<Block> trapdoor) {
        this.trapdoorBlock((TrapDoorBlock)trapdoor.get(), this.blockTexture((Block)trapdoor.get()), true);
        this.itemModels().withExistingParent(UP2BlockstateProvider.getItemName((ItemLike)trapdoor.get()), this.modLoc("block/" + UP2BlockstateProvider.getItemName((ItemLike)trapdoor.get()) + "_bottom"));
    }

    private void trapdoorCutout(RegistryObject<Block> trapdoor) {
        this.trapdoorBlockWithRenderType((TrapDoorBlock)trapdoor.get(), this.blockTexture((Block)trapdoor.get()), true, "cutout");
        this.itemModels().withExistingParent(UP2BlockstateProvider.getItemName((ItemLike)trapdoor.get()), this.modLoc("block/" + UP2BlockstateProvider.getItemName((ItemLike)trapdoor.get()) + "_bottom"));
    }

    private void door(RegistryObject<Block> door) {
        String name = UP2BlockstateProvider.getItemName((ItemLike)door.get());
        this.doorBlock((DoorBlock)door.get(), name.replace("_door", ""), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top"));
        this.generatedItem((ItemLike)door.get(), TextureFolder.ITEM);
    }

    private void doorCutout(RegistryObject<Block> door) {
        String name = UP2BlockstateProvider.getItemName((ItemLike)door.get());
        this.doorBlockWithRenderType((DoorBlock)door.get(), name.replace("_door", ""), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top"), "cutout");
        this.generatedItem((ItemLike)door.get(), TextureFolder.ITEM);
    }

    private void button(RegistryObject<Block> button, ResourceLocation texture) {
        this.buttonBlock((ButtonBlock)button.get(), texture);
        this.itemModels().buttonInventory(UP2BlockstateProvider.getItemName((ItemLike)button.get()), texture);
    }

    private void pressurePlate(RegistryObject<Block> pressurePlate, ResourceLocation texture) {
        this.pressurePlateBlock((PressurePlateBlock)pressurePlate.get(), texture);
        this.itemModel(pressurePlate);
    }

    private void leaves(RegistryObject<Block> leaves) {
        this.simpleBlock((Block)leaves.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(UP2BlockstateProvider.getItemName((ItemLike)leaves.get()), "block/leaves")).texture("all", this.blockTexture((Block)leaves.get()))).renderType("cutout"));
        this.itemModel(leaves);
    }

    private void simpleCross(RegistryObject<Block> block) {
        this.simpleBlock((Block)block.get(), (ModelFile)((BlockModelBuilder)this.models().cross(UP2BlockstateProvider.getItemName((ItemLike)block.get()), this.blockTexture((Block)block.get()))).renderType("cutout"));
        this.generatedItem((ItemLike)block.get(), TextureFolder.BLOCK);
    }

    private void tallPlant(RegistryObject<Block> flower) {
        String name = UP2BlockstateProvider.getItemName((ItemLike)flower.get());
        Function<String, ModelFile> model = s -> ((BlockModelBuilder)this.models().cross(name + "_" + s, this.modLoc("block/" + name + "_" + s))).renderType("cutout");
        ((ItemModelBuilder)this.itemModels().withExistingParent(name, "item/generated")).texture("layer0", this.modLoc("block/" + name + "_top"));
        this.getVariantBuilder((Block)flower.get()).partialState().with((Property)DoublePlantBlock.f_52858_, (Comparable)DoubleBlockHalf.UPPER).addModels(new ConfiguredModel[]{new ConfiguredModel(model.apply("top"))}).partialState().with((Property)DoublePlantBlock.f_52858_, (Comparable)DoubleBlockHalf.LOWER).addModels(new ConfiguredModel[]{new ConfiguredModel(model.apply("bottom"))});
    }

    private void pot(RegistryObject<Block> pot, ResourceLocation texture) {
        ModelBuilder model = ((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(UP2BlockstateProvider.getBlockName((Block)pot.get()), "block/flower_pot_cross")).texture("plant", texture)).renderType("cutout");
        this.simpleBlock((Block)pot.get(), (ModelFile)model);
    }

    private void pottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pot) {
        this.pot(pot, this.blockTexture((Block)plant.get()));
        this.simpleCross(plant);
        this.generatedItem((ItemLike)plant.get(), TextureFolder.BLOCK);
    }

    private void simpleTintedCross(RegistryObject<Block> block) {
        this.simpleBlock((Block)block.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(UP2BlockstateProvider.getItemName((ItemLike)block.get()), "block/tinted_cross")).texture("cross", this.blockTexture((Block)block.get()))).renderType("cutout"));
        this.itemModel(block);
    }

    private void tintedPot(RegistryObject<Block> pot, ResourceLocation texture) {
        ModelBuilder model = ((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(UP2BlockstateProvider.getBlockName((Block)pot.get()), "block/tinted_flower_pot_cross")).texture("plant", texture)).renderType("cutout");
        this.simpleBlock((Block)pot.get(), (ModelFile)model);
    }

    private void tintedPottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pot) {
        this.tintedPot(pot, this.blockTexture((Block)plant.get()));
        this.simpleTintedCross(plant);
        this.generatedItem((ItemLike)plant.get(), TextureFolder.BLOCK);
    }

    private static String getItemName(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey((Object)item.m_5456_()).m_135815_();
    }

    private static String getBlockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey((Object)block).m_135815_();
    }

    private static enum TextureFolder {
        ITEM,
        BLOCK;


        public String format(String itemName) {
            return this.name().toLowerCase() + "/" + itemName;
        }
    }
}


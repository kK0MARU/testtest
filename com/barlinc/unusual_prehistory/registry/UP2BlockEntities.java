/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.BlockEntityType$Builder
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.blocks.entity.ExtraDataBlockEntity;
import com.barlinc.unusual_prehistory.blocks.entity.TransmogrifierBlockEntity;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import java.util.function.Supplier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class UP2BlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create((IForgeRegistry)ForgeRegistries.BLOCK_ENTITY_TYPES, (String)"unusual_prehistory");
    public static final RegistryObject<BlockEntityType<TransmogrifierBlockEntity>> TRANSMOGRIFIER = BLOCK_ENTITIES.register("transmogrifier", () -> BlockEntityType.Builder.m_155273_(TransmogrifierBlockEntity::new, (Block[])new Block[]{(Block)UP2Blocks.TRANSMOGRIFIER.get()}).m_58966_(null));
    public static final RegistryObject<BlockEntityType<ExtraDataBlockEntity>> EXTRA_DATA_BLOCK_ENTITY = BLOCK_ENTITIES.register("extra_data_block_entity", () -> BlockEntityType.Builder.m_155273_(ExtraDataBlockEntity::new, (Block[])((Block[])UP2Blocks.EGG_BLOCKS.stream().map(Supplier::get).toArray(Block[]::new))).m_58966_(null));
}


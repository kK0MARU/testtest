/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.worldgen.structure.processor.TreeStructureProcessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UP2StructureProcessors {
    public static final DeferredRegister<StructureProcessorType<?>> PROCESSOR_TYPES = DeferredRegister.create((ResourceKey)Registries.f_256983_, (String)"unusual_prehistory");
    public static final RegistryObject<StructureProcessorType<TreeStructureProcessor>> TREE = PROCESSOR_TYPES.register("tree", () -> () -> TreeStructureProcessor.CODEC);
}


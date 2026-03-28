/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.material.FlowingFluid
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraftforge.common.ForgeMod
 *  net.minecraftforge.common.SoundActions
 *  net.minecraftforge.fluids.FluidInteractionRegistry
 *  net.minecraftforge.fluids.FluidInteractionRegistry$InteractionInformation
 *  net.minecraftforge.fluids.FluidType
 *  net.minecraftforge.fluids.FluidType$Properties
 *  net.minecraftforge.fluids.ForgeFlowingFluid$Flowing
 *  net.minecraftforge.fluids.ForgeFlowingFluid$Properties
 *  net.minecraftforge.fluids.ForgeFlowingFluid$Source
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.ForgeRegistries$Keys
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.blocks.fluid.TarFluidType;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class UP2Fluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create((IForgeRegistry)ForgeRegistries.FLUIDS, (String)"unusual_prehistory");
    public static final DeferredRegister<FluidType> TYPES = DeferredRegister.create((ResourceKey)ForgeRegistries.Keys.FLUID_TYPES, (String)"unusual_prehistory");
    public static final RegistryObject<FluidType> TAR_TYPE = TYPES.register("tar", () -> new TarFluidType(FluidType.Properties.create().descriptionId("block.unusual_prehistory.tar").density(4000).viscosity(12000).pathType(BlockPathTypes.WALKABLE).adjacentPathType(BlockPathTypes.WALKABLE).canSwim(false).sound(SoundActions.BUCKET_EMPTY, SoundEvents.f_144076_).sound(SoundActions.BUCKET_FILL, SoundEvents.f_144089_)));
    public static final RegistryObject<FlowingFluid> TAR_FLUID_SOURCE = FLUIDS.register("tar", () -> new ForgeFlowingFluid.Source(UP2Fluids.tarProperties()));
    public static final RegistryObject<FlowingFluid> TAR_FLUID_FLOWING = FLUIDS.register("tar_flowing", () -> new ForgeFlowingFluid.Flowing(UP2Fluids.tarProperties()));

    private static ForgeFlowingFluid.Properties tarProperties() {
        return new ForgeFlowingFluid.Properties(TAR_TYPE, TAR_FLUID_SOURCE, TAR_FLUID_FLOWING).bucket(UP2Items.TAR_BUCKET).block(UP2Blocks.TAR).levelDecreasePerBlock(3).slopeFindDistance(3).tickRate(40);
    }

    public static void postInit() {
        FluidInteractionRegistry.addInteraction((FluidType)((FluidType)TAR_TYPE.get()), (FluidInteractionRegistry.InteractionInformation)new FluidInteractionRegistry.InteractionInformation((FluidType)ForgeMod.WATER_TYPE.get(), fluidState -> ((Block)UP2Blocks.ASPHALT.get()).m_49966_()));
        FluidInteractionRegistry.addInteraction((FluidType)((FluidType)TAR_TYPE.get()), (FluidInteractionRegistry.InteractionInformation)new FluidInteractionRegistry.InteractionInformation((FluidType)ForgeMod.LAVA_TYPE.get(), fluidState -> ((Block)UP2Blocks.ASPHALT.get()).m_49966_()));
    }
}


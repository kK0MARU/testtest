/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType
 *  net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType
 *  net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.worldgen.feature.tree.decorator.TreeBranchDecorator;
import com.barlinc.unusual_prehistory.worldgen.feature.tree.ginkgo.GinkgoFoliagePlacer;
import com.barlinc.unusual_prehistory.worldgen.feature.tree.lepidodendron.HangingLepidodendronLeavesDecorator;
import com.barlinc.unusual_prehistory.worldgen.feature.tree.lepidodendron.LepidodendronFoliagePlacer;
import com.barlinc.unusual_prehistory.worldgen.feature.tree.lepidodendron.LepidodendronTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class UP2Trees {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create((ResourceKey)Registries.f_256963_, (String)"unusual_prehistory");
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create((IForgeRegistry)ForgeRegistries.TREE_DECORATOR_TYPES, (String)"unusual_prehistory");
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create((IForgeRegistry)ForgeRegistries.FOLIAGE_PLACER_TYPES, (String)"unusual_prehistory");
    public static final RegistryObject<TrunkPlacerType<LepidodendronTrunkPlacer>> LEPIDODENDRON_TRUNK = TRUNK_PLACERS.register("lepidodendron_trunk_placer", () -> new TrunkPlacerType(LepidodendronTrunkPlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<GinkgoFoliagePlacer>> GINKGO_FOLIAGE = FOLIAGE_PLACERS.register("ginkgo_foliage_placer", () -> new FoliagePlacerType(GinkgoFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<LepidodendronFoliagePlacer>> LEPIDODENDRON_FOLIAGE = FOLIAGE_PLACERS.register("lepidodendron_foliage_placer", () -> new FoliagePlacerType(LepidodendronFoliagePlacer.CODEC));
    public static final RegistryObject<TreeDecoratorType<?>> HANGING_LEPIDODENDRON_LEAVES = TREE_DECORATORS.register("hanging_lepidodendron_leaves", () -> new TreeDecoratorType(HangingLepidodendronLeavesDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<?>> TREE_BRANCH = TREE_DECORATORS.register("tree_branch", () -> new TreeDecoratorType(TreeBranchDecorator.CODEC));
}


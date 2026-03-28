/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet$Builder
 *  net.minecraft.core.Position
 *  net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior
 *  net.minecraft.core.dispenser.DispenseItemBehavior
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.ComposterBlock
 *  net.minecraft.world.level.block.DispenserBlock
 *  net.minecraft.world.level.block.FireBlock
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.entity.projectile.ThrowableEgg;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2CauldronInteractions;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.google.common.collect.ImmutableSet;
import java.util.function.Supplier;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.jetbrains.annotations.NotNull;

public class UP2Compat {
    public static void registerCompat() {
        UP2Compat.registerCompostables();
        UP2Compat.registerFlammables();
        UP2Compat.registerDispenserBehaviours();
        UP2Compat.registerSigns();
        UP2Compat.registerHangingSigns();
        UP2CauldronInteractions.registerCauldronInteractions();
    }

    public static void registerCompostables() {
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.BENNETTITALES.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.CALAMOPHYTON.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.CLADOPHLEBIS.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.COOKSONIA.get(), 0.65f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.HORSETAIL.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.LARGE_HORSETAIL.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.LEEFRUCTUS.get(), 0.65f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.QUILLWORT.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.RAIGUENRAYUN.get(), 0.65f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.RHYNIA.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Items.GINKGO_FRUIT.get(), 0.5f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.GINKGO_LEAVES.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.GOLDEN_GINKGO_LEAVES.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.GINKGO_SAPLING.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.GOLDEN_GINKGO_SAPLING.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.LEPIDODENDRON_LEAVES.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.LEPIDODENDRON_CONE.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.AETHOPHYLLUM.get(), 0.65f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.NEOMARIOPTERIS.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.TEMPSKYA.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.BRACHYPHYLLUM.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.ARCHAEOSIGILLARIA.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.CYCAD_SEEDLING.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.CYCAD_CROWN.get(), 0.5f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.GUANGDEDENDRON.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.PROTOTAXITES_CLUSTER.get(), 0.65f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.PROTOTAXITES.get(), 0.65f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.PROTOTAXITES_NUB.get(), 0.65f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.LARGE_PROTOTAXITES_NUB.get(), 0.65f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.DRYOPHYLLUM_LEAVES.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.DRYOPHYLLUM_SAPLING.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.METASEQUOIA_LEAVES.get(), 0.3f);
        UP2Compat.registerCompostable((ItemLike)UP2Blocks.METASEQUOIA_SAPLING.get(), 0.3f);
    }

    public static void registerFlammables() {
        UP2Compat.registerFlammable((Block)UP2Blocks.CALAMOPHYTON.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.CLADOPHLEBIS.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.COOKSONIA.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.HORSETAIL.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.LARGE_HORSETAIL.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.QUILLWORT.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.LEEFRUCTUS.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.RAIGUENRAYUN.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.RHYNIA.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.GINKGO_LOG.get(), 5, 3);
        UP2Compat.registerFlammable((Block)UP2Blocks.GINKGO_WOOD.get(), 5, 3);
        UP2Compat.registerFlammable((Block)UP2Blocks.STRIPPED_GINKGO_LOG.get(), 5, 3);
        UP2Compat.registerFlammable((Block)UP2Blocks.STRIPPED_GINKGO_WOOD.get(), 5, 3);
        UP2Compat.registerFlammable((Block)UP2Blocks.GINKGO_PLANKS.get(), 5, 15);
        UP2Compat.registerFlammable((Block)UP2Blocks.GINKGO_SLAB.get(), 5, 15);
        UP2Compat.registerFlammable((Block)UP2Blocks.GINKGO_STAIRS.get(), 5, 15);
        UP2Compat.registerFlammable((Block)UP2Blocks.GINKGO_FENCE.get(), 5, 15);
        UP2Compat.registerFlammable((Block)UP2Blocks.GINKGO_FENCE_GATE.get(), 5, 15);
        UP2Compat.registerFlammable((Block)UP2Blocks.GINKGO_LEAVES.get(), 30, 50);
        UP2Compat.registerFlammable((Block)UP2Blocks.GOLDEN_GINKGO_LEAVES.get(), 30, 50);
        UP2Compat.registerFlammable((Block)UP2Blocks.LEPIDODENDRON_LOG.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.LEPIDODENDRON_WOOD.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.MOSSY_LEPIDODENDRON_LOG.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.MOSSY_LEPIDODENDRON_WOOD.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.STRIPPED_LEPIDODENDRON_LOG.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.STRIPPED_LEPIDODENDRON_WOOD.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.LEPIDODENDRON_PLANKS.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.LEPIDODENDRON_SLAB.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.LEPIDODENDRON_STAIRS.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.LEPIDODENDRON_FENCE.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.LEPIDODENDRON_FENCE_GATE.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.LEPIDODENDRON_LEAVES.get(), 30, 60);
        UP2Compat.registerFlammable((Block)UP2Blocks.TEMPSKYA.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.BRACHYPHYLLUM.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.NEOMARIOPTERIS.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.BENNETTITALES.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.AETHOPHYLLUM.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.ARCHAEOSIGILLARIA.get(), 60, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.GUANGDEDENDRON_SPORE.get(), 20, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.GUANGDEDENDRON.get(), 20, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.CYCAD_STEM.get(), 20, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.CYCAD_CROWN.get(), 20, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.CYCAD_SEEDLING.get(), 20, 100);
        UP2Compat.registerFlammable((Block)UP2Blocks.DRYOPHYLLUM_LOG.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.DRYOPHYLLUM_WOOD.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_LOG.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.STRIPPED_DRYOPHYLLUM_WOOD.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.DRYOPHYLLUM_PLANKS.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.DRYOPHYLLUM_SLAB.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.DRYOPHYLLUM_STAIRS.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.DRYOPHYLLUM_FENCE.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.DRYOPHYLLUM_FENCE_GATE.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.DRYOPHYLLUM_LEAVES.get(), 30, 60);
        UP2Compat.registerFlammable((Block)UP2Blocks.METASEQUOIA_LOG.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.METASEQUOIA_WOOD.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.STRIPPED_METASEQUOIA_LOG.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.STRIPPED_METASEQUOIA_WOOD.get(), 5, 5);
        UP2Compat.registerFlammable((Block)UP2Blocks.METASEQUOIA_PLANKS.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.METASEQUOIA_SLAB.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.METASEQUOIA_STAIRS.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.METASEQUOIA_FENCE.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.METASEQUOIA_FENCE_GATE.get(), 5, 20);
        UP2Compat.registerFlammable((Block)UP2Blocks.METASEQUOIA_LEAVES.get(), 30, 60);
    }

    public static void registerDispenserBehaviours() {
        UP2Compat.registerEggDispenserBehaviour(UP2Items.DIMORPHODON_EGG, () -> UP2Entities.DIMORPHODON_EGG.get());
        UP2Compat.registerEggDispenserBehaviour(UP2Items.DROMAEOSAURUS_EGG, () -> UP2Entities.DROMAEOSAURUS_EGG.get());
        UP2Compat.registerEggDispenserBehaviour(UP2Items.PSILOPTERUS_EGG, () -> UP2Entities.PSILOPTERUS_EGG.get());
        UP2Compat.registerEggDispenserBehaviour(UP2Items.PTERODACTYLUS_EGG, () -> UP2Entities.PTERODACTYLUS_EGG.get());
        UP2Compat.registerEggDispenserBehaviour(UP2Items.TALPANAS_EGG, () -> UP2Entities.TALPANAS_EGG.get());
        UP2Compat.registerEggDispenserBehaviour(UP2Items.TELECREX_EGG, () -> UP2Entities.TELECREX_EGG.get());
    }

    public static void registerEggDispenserBehaviour(Supplier<Item> itemSupplier, final Supplier<EntityType<? extends ThrowableEgg>> entityTypeSupplier) {
        DispenserBlock.m_52672_((ItemLike)((ItemLike)itemSupplier.get()), (DispenseItemBehavior)new AbstractProjectileDispenseBehavior(){

            @NotNull
            protected Projectile m_6895_(@NotNull Level level, @NotNull Position pos, @NotNull ItemStack itemStack) {
                ThrowableEgg egg = (ThrowableEgg)((EntityType)entityTypeSupplier.get()).m_20615_(level);
                egg.m_6034_(pos.m_7096_(), pos.m_7098_(), pos.m_7094_());
                return egg;
            }
        });
    }

    public static void registerSigns() {
        ImmutableSet.Builder signs = new ImmutableSet.Builder();
        signs.addAll((Iterable)BlockEntityType.f_58924_.f_58915_);
        signs.add((Object)((Block)UP2Blocks.DRYOPHYLLUM_SIGN.get()));
        signs.add((Object)((Block)UP2Blocks.DRYOPHYLLUM_WALL_SIGN.get()));
        signs.add((Object)((Block)UP2Blocks.GINKGO_SIGN.get()));
        signs.add((Object)((Block)UP2Blocks.GINKGO_WALL_SIGN.get()));
        signs.add((Object)((Block)UP2Blocks.LEPIDODENDRON_SIGN.get()));
        signs.add((Object)((Block)UP2Blocks.LEPIDODENDRON_WALL_SIGN.get()));
        signs.add((Object)((Block)UP2Blocks.METASEQUOIA_SIGN.get()));
        signs.add((Object)((Block)UP2Blocks.METASEQUOIA_WALL_SIGN.get()));
        BlockEntityType.f_58924_.f_58915_ = signs.build();
    }

    public static void registerHangingSigns() {
        ImmutableSet.Builder hangingSigns = new ImmutableSet.Builder();
        hangingSigns.addAll((Iterable)BlockEntityType.f_244529_.f_58915_);
        hangingSigns.add((Object)((Block)UP2Blocks.DRYOPHYLLUM_HANGING_SIGN.get()));
        hangingSigns.add((Object)((Block)UP2Blocks.DRYOPHYLLUM_WALL_HANGING_SIGN.get()));
        hangingSigns.add((Object)((Block)UP2Blocks.GINKGO_HANGING_SIGN.get()));
        hangingSigns.add((Object)((Block)UP2Blocks.GINKGO_WALL_HANGING_SIGN.get()));
        hangingSigns.add((Object)((Block)UP2Blocks.LEPIDODENDRON_HANGING_SIGN.get()));
        hangingSigns.add((Object)((Block)UP2Blocks.LEPIDODENDRON_WALL_HANGING_SIGN.get()));
        hangingSigns.add((Object)((Block)UP2Blocks.METASEQUOIA_HANGING_SIGN.get()));
        hangingSigns.add((Object)((Block)UP2Blocks.METASEQUOIA_WALL_HANGING_SIGN.get()));
        BlockEntityType.f_244529_.f_58915_ = hangingSigns.build();
    }

    public static void registerCompostable(ItemLike item, float chance) {
        ComposterBlock.f_51914_.put((Object)item.m_5456_(), chance);
    }

    public static void registerFlammable(Block block, int igniteChance, int burnChance) {
        FireBlock fire = (FireBlock)Blocks.f_50083_;
        fire.m_53444_(block, igniteChance, burnChance);
    }
}


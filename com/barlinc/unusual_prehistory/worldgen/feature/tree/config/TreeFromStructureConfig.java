/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  it.unimi.dsi.fastutil.objects.ObjectOpenHashSet
 *  javax.annotation.Nullable
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.valueproviders.IntProvider
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate
 *  net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
 *  net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider
 *  net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator
 */
package com.barlinc.unusual_prehistory.worldgen.feature.tree.config;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;

public record TreeFromStructureConfig(ResourceLocation baseLocation, ResourceLocation canopyLocation, IntProvider height, BlockStateProvider logProvider, List<BlockStateProvider> leavesProvider, Set<Block> logTarget, List<Block> leavesTarget, BlockPredicate growableOn, BlockPredicate leavesPlacementFilter, int maxLogDepth, List<TreeDecorator> treeDecorators, Map<Block, BlockStateProvider> replaceFromNBT, boolean isSapling, Orientation orientation) implements FeatureConfiguration
{
    public static final Codec<Set<Block>> BLOCK_SET_CODEC = Codec.list((Codec)BuiltInRegistries.f_256975_.m_194605_()).xmap(ObjectOpenHashSet::new, ArrayList::new);
    public static final Codec<TreeFromStructureConfig> CODEC = RecordCodecBuilder.create(builder -> builder.group((App)ResourceLocation.f_135803_.fieldOf("base_location").forGetter(TreeFromStructureConfig::baseLocation), (App)ResourceLocation.f_135803_.fieldOf("canopy_location").forGetter(TreeFromStructureConfig::canopyLocation), (App)IntProvider.f_146531_.fieldOf("height").forGetter(TreeFromStructureConfig::height), (App)BlockStateProvider.f_68747_.fieldOf("log_provider").forGetter(TreeFromStructureConfig::logProvider), (App)BlockStateProvider.f_68747_.listOf().fieldOf("leaves_provider").forGetter(TreeFromStructureConfig::leavesProvider), (App)BLOCK_SET_CODEC.fieldOf("log_target").forGetter(TreeFromStructureConfig::logTarget), (App)BuiltInRegistries.f_256975_.m_194605_().listOf().fieldOf("leaves_target").forGetter(TreeFromStructureConfig::leavesTarget), (App)BlockPredicate.f_190392_.fieldOf("can_grow_on_filter").forGetter(TreeFromStructureConfig::growableOn), (App)BlockPredicate.f_190392_.fieldOf("can_leaves_place_filter").forGetter(TreeFromStructureConfig::leavesPlacementFilter), (App)Codec.INT.optionalFieldOf("max_log_depth", (Object)5).forGetter(TreeFromStructureConfig::maxLogDepth), (App)TreeDecorator.f_70021_.listOf().optionalFieldOf("decorators", new ArrayList()).forGetter(TreeFromStructureConfig::treeDecorators), (App)Codec.unboundedMap((Codec)BuiltInRegistries.f_256975_.m_194605_(), (Codec)BlockStateProvider.f_68747_).fieldOf("replace_from_nbt").forGetter(TreeFromStructureConfig::replaceFromNBT), (App)Codec.BOOL.optionalFieldOf("sapling", (Object)false).forGetter(TreeFromStructureConfig::isSapling), (App)Orientation.CODEC.optionalFieldOf("orientation", (Object)Orientation.STANDARD).forGetter(TreeFromStructureConfig::orientation)).apply((Applicative)builder, TreeFromStructureConfig::new));

    public static enum Orientation {
        STANDARD,
        UPSIDE_DOWN,
        SIDEWAYS;

        public static final Codec<Orientation> CODEC;

        static {
            CODEC = Codec.STRING.xmap(s -> Orientation.valueOf(s.toUpperCase()), s -> s.name().toUpperCase());
        }
    }

    public static class Builder {
        @Nullable
        private ResourceLocation baseLocation;
        @Nullable
        private ResourceLocation canopyLocation;
        @Nullable
        private IntProvider height;
        @Nullable
        private BlockStateProvider logProvider;
        @Nullable
        private List<BlockStateProvider> leavesProvider;
        @Nullable
        private Set<Block> logTarget;
        @Nullable
        private List<Block> leavesTarget;
        private BlockPredicate growableOn = BlockPredicate.m_190419_();
        private BlockPredicate leavesPlacementFilter = BlockPredicate.m_190419_();
        private int maxLogDepth = 5;
        private List<TreeDecorator> treeDecorators = new ArrayList<TreeDecorator>();
        private Map<Block, BlockStateProvider> replaceFromNBT = new HashMap<Block, BlockStateProvider>();
        private boolean isSapling = false;
        private Orientation orientation = Orientation.STANDARD;

        public Builder baseLocation(ResourceLocation baseLocation) {
            this.baseLocation = baseLocation;
            return this;
        }

        public Builder canopyLocation(ResourceLocation canopyLocation) {
            this.canopyLocation = canopyLocation;
            return this;
        }

        public Builder height(IntProvider height) {
            this.height = height;
            return this;
        }

        public Builder logProvider(BlockStateProvider logProvider) {
            this.logProvider = logProvider;
            return this;
        }

        public Builder leavesProvider(List<BlockStateProvider> leavesProvider) {
            this.leavesProvider = leavesProvider;
            return this;
        }

        public Builder logTarget(Set<Block> logTarget) {
            this.logTarget = logTarget;
            return this;
        }

        public Builder leavesTarget(List<Block> leavesTarget) {
            this.leavesTarget = leavesTarget;
            return this;
        }

        public Builder growableOn(BlockPredicate growableOn) {
            this.growableOn = growableOn;
            return this;
        }

        public Builder leavesPlacementFilter(BlockPredicate leavesPlacementFilter) {
            this.leavesPlacementFilter = leavesPlacementFilter;
            return this;
        }

        public Builder maxLogDepth(int maxLogDepth) {
            this.maxLogDepth = maxLogDepth;
            return this;
        }

        public Builder treeDecorators(List<TreeDecorator> treeDecorators) {
            this.treeDecorators = treeDecorators;
            return this;
        }

        public Builder replaceFromNBT(Map<Block, BlockStateProvider> placeFromNBT) {
            this.replaceFromNBT = placeFromNBT;
            return this;
        }

        public Builder isSapling(boolean isSapling) {
            this.isSapling = isSapling;
            return this;
        }

        public Builder orientation(Orientation orientation) {
            this.orientation = orientation;
            return this;
        }

        public TreeFromStructureConfig build() {
            if (this.baseLocation == null) {
                throw new IllegalStateException("Base location cannot be null");
            }
            if (this.canopyLocation == null) {
                throw new IllegalStateException("Canopy location cannot be null");
            }
            if (this.height == null) {
                throw new IllegalStateException("Height cannot be null");
            }
            if (this.logProvider == null) {
                throw new IllegalStateException("Log provider cannot be null");
            }
            if (this.leavesProvider == null) {
                throw new IllegalStateException("Leaves provider cannot be null");
            }
            if (this.logTarget == null) {
                throw new IllegalStateException("Log target cannot be null");
            }
            if (this.leavesTarget == null) {
                throw new IllegalStateException("Leaves target cannot be null");
            }
            return new TreeFromStructureConfig(this.baseLocation, this.canopyLocation, this.height, this.logProvider, this.leavesProvider, this.logTarget, this.leavesTarget, this.growableOn, this.leavesPlacementFilter, this.maxLogDepth, this.treeDecorators, this.replaceFromNBT, this.isSapling, this.orientation);
        }
    }
}


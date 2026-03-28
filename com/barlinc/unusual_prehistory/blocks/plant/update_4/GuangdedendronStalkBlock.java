/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BambooLeaves
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.IntegerProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.common.IPlantable
 *  net.minecraftforge.common.ToolActions
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.plant.update_4;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

public class GuangdedendronStalkBlock
extends Block
implements BonemealableBlock,
IPlantable {
    protected static final VoxelShape SMALL_SHAPE = Block.m_49796_((double)5.0, (double)0.0, (double)5.0, (double)11.0, (double)16.0, (double)11.0);
    protected static final VoxelShape LARGE_SHAPE = Block.m_49796_((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)16.0, (double)13.0);
    protected static final VoxelShape COLLISION_SHAPE = Block.m_49796_((double)6.5, (double)0.0, (double)6.5, (double)9.5, (double)16.0, (double)9.5);
    public static final IntegerProperty AGE = BlockStateProperties.f_61405_;
    public static final EnumProperty<BambooLeaves> LEAVES = BlockStateProperties.f_61400_;
    public static final IntegerProperty STAGE = BlockStateProperties.f_61387_;

    public GuangdedendronStalkBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)AGE, (Comparable)Integer.valueOf(0))).m_61124_(LEAVES, (Comparable)BambooLeaves.NONE)).m_61124_((Property)STAGE, (Comparable)Integer.valueOf(0)));
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[]{AGE, LEAVES, STAGE});
    }

    public boolean m_7420_(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return true;
    }

    @NotNull
    public VoxelShape m_5940_(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        VoxelShape shape = state.m_61143_(LEAVES) == BambooLeaves.LARGE ? LARGE_SHAPE : SMALL_SHAPE;
        Vec3 vec3 = state.m_60824_(getter, pos);
        return shape.m_83216_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_);
    }

    public boolean m_7357_(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull PathComputationType type) {
        return false;
    }

    @NotNull
    public VoxelShape m_5939_(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Vec3 vec3 = state.m_60824_(getter, pos);
        return COLLISION_SHAPE.m_83216_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_);
    }

    public boolean m_180643_(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return false;
    }

    @Nullable
    public BlockState m_5573_(BlockPlaceContext context) {
        FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        if (!fluidstate.m_76178_()) {
            return null;
        }
        BlockState blockstate = context.m_43725_().m_8055_(context.m_8083_().m_7495_());
        if (blockstate.m_204336_(UP2BlockTags.GUANGDEDENDRON_PLANTABLE_ON)) {
            if (blockstate.m_60713_((Block)UP2Blocks.GUANGDEDENDRON_SPORE.get())) {
                return (BlockState)this.m_49966_().m_61124_((Property)AGE, (Comparable)Integer.valueOf(0));
            }
            if (blockstate.m_60713_((Block)UP2Blocks.GUANGDEDENDRON.get())) {
                int i = (Integer)blockstate.m_61143_((Property)AGE) > 0 ? 1 : 0;
                return (BlockState)this.m_49966_().m_61124_((Property)AGE, (Comparable)Integer.valueOf(i));
            }
            BlockState blockstate1 = context.m_43725_().m_8055_(context.m_8083_().m_7494_());
            return blockstate1.m_60713_((Block)UP2Blocks.GUANGDEDENDRON.get()) ? (BlockState)this.m_49966_().m_61124_((Property)AGE, (Comparable)((Integer)blockstate1.m_61143_((Property)AGE))) : ((Block)UP2Blocks.GUANGDEDENDRON_SPORE.get()).m_49966_();
        }
        return null;
    }

    public void m_213897_(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (!state.m_60710_((LevelReader)level, pos)) {
            level.m_46961_(pos, true);
        }
    }

    public boolean m_6724_(BlockState state) {
        return (Integer)state.m_61143_((Property)STAGE) == 0;
    }

    public void m_213898_(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        int belowMax;
        if ((Integer)state.m_61143_((Property)STAGE) == 0 && level.m_46859_(pos.m_7494_()) && level.m_45524_(pos.m_7494_(), 0) >= 9 && (belowMax = this.getHeightBelowUpToMax((BlockGetter)level, pos) + 1) < 16 && ForgeHooks.onCropsGrowPre((Level)level, (BlockPos)pos, (BlockState)state, (random.m_188503_(3) == 0 ? 1 : 0) != 0)) {
            this.growGuangdedendron(state, (Level)level, pos, random, belowMax);
            ForgeHooks.onCropsGrowPost((Level)level, (BlockPos)pos, (BlockState)state);
        }
    }

    public boolean m_7898_(@NotNull BlockState state, LevelReader level, BlockPos pos) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.GUANGDEDENDRON_PLANTABLE_ON);
    }

    @NotNull
    public BlockState m_7417_(BlockState state, @NotNull Direction direction, @NotNull BlockState state1, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos pos1) {
        if (!state.m_60710_((LevelReader)level, pos)) {
            level.m_186460_(pos, (Block)this, 1);
        }
        if (direction == Direction.UP && state1.m_60713_((Block)UP2Blocks.GUANGDEDENDRON.get()) && (Integer)state1.m_61143_((Property)AGE) > (Integer)state.m_61143_((Property)AGE)) {
            level.m_7731_(pos, (BlockState)state.m_61122_((Property)AGE), 2);
        }
        return super.m_7417_(state, direction, state1, level, pos, pos1);
    }

    public boolean m_7370_(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
        int belowMax;
        int aboveMax = this.getHeightAboveUpToMax((BlockGetter)level, pos);
        return aboveMax + (belowMax = this.getHeightBelowUpToMax((BlockGetter)level, pos)) + 1 < 16 && (Integer)level.m_8055_(pos.m_6630_(aboveMax)).m_61143_((Property)STAGE) != 1;
    }

    public boolean m_214167_(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    public void m_214148_(@NotNull ServerLevel level, RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        int aboveMax = this.getHeightAboveUpToMax((BlockGetter)level, pos);
        int belowMax = this.getHeightBelowUpToMax((BlockGetter)level, pos);
        int k = aboveMax + belowMax + 1;
        int l = 1 + random.m_188503_(2);
        for (int i = 0; i < l; ++i) {
            BlockPos blockpos = pos.m_6630_(aboveMax);
            BlockState blockstate = level.m_8055_(blockpos);
            if (k >= 16 || (Integer)blockstate.m_61143_((Property)STAGE) == 1 || !level.m_46859_(blockpos.m_7494_())) {
                return;
            }
            this.growGuangdedendron(blockstate, (Level)level, blockpos, random, k);
            ++aboveMax;
            ++k;
        }
    }

    public float m_5880_(@NotNull BlockState state, Player player, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return player.m_21205_().canPerformAction(ToolActions.SWORD_DIG) ? 1.0f : super.m_5880_(state, player, getter, pos);
    }

    protected void growGuangdedendron(BlockState state, Level level, BlockPos pos, RandomSource random, int age) {
        BlockState belowState = level.m_8055_(pos.m_7495_());
        BlockState twoBelowState = level.m_8055_(pos.m_6625_(2));
        BambooLeaves leaves = BambooLeaves.NONE;
        if (age >= 1) {
            if (state.m_60713_((Block)UP2Blocks.GUANGDEDENDRON.get()) && state.m_61143_(LEAVES) != BambooLeaves.NONE) {
                leaves = BambooLeaves.LARGE;
                if (belowState.m_60713_((Block)UP2Blocks.GUANGDEDENDRON.get())) {
                    level.m_7731_(pos, (BlockState)state.m_61124_(LEAVES, (Comparable)BambooLeaves.SMALL), 3);
                    if (twoBelowState.m_60713_((Block)UP2Blocks.GUANGDEDENDRON.get())) {
                        level.m_7731_(pos.m_7495_(), (BlockState)belowState.m_61124_(LEAVES, (Comparable)BambooLeaves.SMALL), 3);
                        level.m_7731_(pos.m_6625_(2), (BlockState)twoBelowState.m_61124_(LEAVES, (Comparable)BambooLeaves.NONE), 3);
                    }
                }
            } else {
                leaves = BambooLeaves.SMALL;
            }
        }
        int i = (Integer)state.m_61143_((Property)AGE) != 1 && !twoBelowState.m_60713_((Block)UP2Blocks.GUANGDEDENDRON.get()) ? 0 : 1;
        int j = !(age >= 11 && random.m_188501_() < 0.25f || age == 15) ? 0 : 1;
        level.m_7731_(pos.m_7494_(), (BlockState)((BlockState)((BlockState)this.m_49966_().m_61124_((Property)AGE, (Comparable)Integer.valueOf(i))).m_61124_(LEAVES, (Comparable)leaves)).m_61124_((Property)STAGE, (Comparable)Integer.valueOf(j)), 3);
    }

    protected int getHeightAboveUpToMax(BlockGetter getter, BlockPos pos) {
        int i;
        for (i = 0; i < 16 && getter.m_8055_(pos.m_6630_(i + 1)).m_60713_((Block)UP2Blocks.GUANGDEDENDRON.get()); ++i) {
        }
        return i;
    }

    protected int getHeightBelowUpToMax(BlockGetter getter, BlockPos pos) {
        int i;
        for (i = 0; i < 16 && getter.m_8055_(pos.m_6625_(i + 1)).m_60713_((Block)UP2Blocks.GUANGDEDENDRON.get()); ++i) {
        }
        return i;
    }

    public BlockState getPlant(BlockGetter getter, BlockPos pos) {
        BlockState state = getter.m_8055_(pos);
        if (state.m_60734_() != this) {
            return this.m_49966_();
        }
        return state;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraftforge.event.ForgeEventFactory
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.blocks.egg;

import com.barlinc.unusual_prehistory.blocks.entity.ExtraDataBlockEntity;
import com.barlinc.unusual_prehistory.blocks.entity.WaterEggBlockEntity;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricAquaticMob;
import java.util.UUID;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;

public class UnderwaterEggBlock
extends WaterEggBlockEntity
implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.f_61362_;
    private final Supplier<EntityType<?>> hatchedEntity;
    private final int babyCount;

    public UnderwaterEggBlock(BlockBehaviour.Properties properties, Supplier<EntityType<?>> hatchedEntity, int spawnCount) {
        super(properties);
        this.hatchedEntity = hatchedEntity;
        this.babyCount = spawnCount;
    }

    public void m_213897_(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (!this.m_7898_(state, (LevelReader)level, pos)) {
            level.m_46961_(pos, false);
        } else {
            BlockEntity blockEntity = level.m_7702_(pos);
            if (!(blockEntity instanceof ExtraDataBlockEntity)) {
                return;
            }
            ExtraDataBlockEntity dataBlockEntity = (ExtraDataBlockEntity)blockEntity;
            UUID placer = dataBlockEntity.getOwner();
            level.m_46961_(pos, false);
            for (int j = 0; j < this.babyCount; ++j) {
                Player player;
                Entity entity = this.hatchedEntity.get().m_20615_((Level)level);
                if (!(entity instanceof Mob)) continue;
                Mob mob = (Mob)entity;
                if (entity instanceof Animal) {
                    Animal animal = (Animal)entity;
                    animal.m_6863_(true);
                }
                if (entity instanceof PrehistoricAquaticMob) {
                    PrehistoricAquaticMob prehistoricAquaticMob = (PrehistoricAquaticMob)entity;
                    prehistoricAquaticMob.setFromEgg(true);
                }
                int k = random.m_216339_(1, 361);
                if (placer != null && (player = level.m_46003_(placer)) instanceof ServerPlayer) {
                    ServerPlayer serverPlayer = (ServerPlayer)player;
                    CriteriaTriggers.f_10580_.m_68256_(serverPlayer, entity);
                }
                entity.m_7678_((double)pos.m_123341_(), (double)pos.m_123342_() + 0.5, (double)pos.m_123343_(), (float)k, 0.0f);
                level.m_7967_(entity);
                ForgeEventFactory.onFinalizeSpawn((Mob)mob, (ServerLevelAccessor)level, (DifficultyInstance)level.m_6436_(pos), (MobSpawnType)MobSpawnType.NATURAL, null, null);
            }
        }
    }

    @NotNull
    public BlockState m_7417_(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (((Boolean)state.m_61143_((Property)WATERLOGGED)).booleanValue()) {
            level.m_186469_(pos, (Fluid)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)level));
        }
        return super.m_7417_(state, direction, neighborState, level, pos, neighborPos);
    }

    public boolean m_7898_(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        BlockPos blockpos = pos.m_7495_();
        FluidState fluidstate = level.m_6425_(pos);
        return this.mayPlaceOn(level.m_8055_(blockpos), (BlockGetter)level, blockpos) && fluidstate.m_205070_(FluidTags.f_13131_) && fluidstate.m_76186_() == 8;
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return state.m_60783_(blockGetter, pos, Direction.UP) && !state.m_60713_(Blocks.f_50450_);
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[]{WATERLOGGED});
    }

    @Nullable
    public BlockState m_5573_(BlockPlaceContext context) {
        FluidState state = context.m_43725_().m_6425_(context.m_8083_());
        return (BlockState)this.m_49966_().m_61124_((Property)WATERLOGGED, (Comparable)Boolean.valueOf(state.m_205070_(FluidTags.f_13131_) && state.m_76186_() == 8));
    }

    @NotNull
    public FluidState m_5888_(BlockState state) {
        return (Boolean)state.m_61143_((Property)WATERLOGGED) != false ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }

    public BlockEntity m_142194_(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new ExtraDataBlockEntity(pos, state);
    }

    public void m_6402_(Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack) {
        if (!level.f_46443_ && placer instanceof Player) {
            Player player = (Player)placer;
            BlockEntity blockEntity = level.m_7702_(pos);
            if (blockEntity instanceof ExtraDataBlockEntity) {
                ExtraDataBlockEntity owned = (ExtraDataBlockEntity)blockEntity;
                owned.setOwner(player.m_20148_());
            }
        }
    }
}


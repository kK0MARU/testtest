/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.BlockPos
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
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraftforge.event.ForgeEventFactory
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.blocks.egg;

import com.barlinc.unusual_prehistory.blocks.entity.ExtraDataBlockEntity;
import com.barlinc.unusual_prehistory.blocks.entity.WaterEggBlockEntity;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WaterEggBlock
extends WaterEggBlockEntity {
    private final Supplier<EntityType<?>> hatchedEntity;
    private final int babyCount;

    public WaterEggBlock(BlockBehaviour.Properties properties, Supplier<EntityType<?>> hatchedEntity, int spawnCount) {
        super(properties);
        this.hatchedEntity = hatchedEntity;
        this.babyCount = spawnCount;
    }

    public void m_213897_(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (!this.m_7898_(state, (LevelReader)level, pos)) {
            level.m_46961_(pos, false);
        } else if (level.m_6425_(pos.m_7495_()).m_205070_(FluidTags.f_13131_)) {
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
                if (entity instanceof PrehistoricMob) {
                    PrehistoricMob prehistoricMob = (PrehistoricMob)entity;
                    prehistoricMob.setFromEgg(true);
                }
                int k = random.m_216339_(1, 361);
                if (placer != null && (player = level.m_46003_(placer)) instanceof ServerPlayer) {
                    ServerPlayer serverPlayer = (ServerPlayer)player;
                    CriteriaTriggers.f_10580_.m_68256_(serverPlayer, entity);
                }
                entity.m_7678_((double)pos.m_123341_(), (double)pos.m_123342_() - 0.5, (double)pos.m_123343_(), (float)k, 0.0f);
                level.m_7967_(entity);
                ForgeEventFactory.onFinalizeSpawn((Mob)mob, (ServerLevelAccessor)level, (DifficultyInstance)level.m_6436_(pos), (MobSpawnType)MobSpawnType.NATURAL, null, null);
            }
        }
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


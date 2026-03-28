/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.util.valueproviders.IntProvider
 *  net.minecraft.util.valueproviders.UniformInt
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.TamableAnimal
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.monster.Zombie
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.IntegerProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.event.ForgeEventFactory
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.blocks.egg;

import com.barlinc.unusual_prehistory.blocks.entity.ExtraDataBlockEntity;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.registry.UP2Particles;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.utils.UP2ParticleUtils;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EggBlock
extends BaseEntityBlock {
    public static final IntegerProperty HATCH = BlockStateProperties.f_61416_;
    protected final VoxelShape shape;
    private final Supplier<EntityType<?>> hatchedEntity;
    private final boolean canTrample;

    public EggBlock(BlockBehaviour.Properties properties, Supplier<EntityType<?>> hatchedEntity, int widthPx, int heightPx, boolean canTrample) {
        super(properties);
        this.canTrample = canTrample;
        this.hatchedEntity = hatchedEntity;
        int px = (16 - widthPx) / 2;
        this.shape = Block.m_49796_((double)px, (double)0.0, (double)px, (double)(16 - px), (double)heightPx, (double)(16 - px));
        this.m_49959_((BlockState)this.m_49966_().m_61124_((Property)HATCH, (Comparable)Integer.valueOf(0)));
    }

    public void m_141947_(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        this.tryTrample(level, pos, entity, 100);
        super.m_141947_(level, pos, state, entity);
    }

    public void m_142072_(@NotNull Level level, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull Entity entity, float fallDistance) {
        if (!(entity instanceof Zombie)) {
            this.tryTrample(level, pos, entity, 3);
        }
        super.m_142072_(level, state, pos, entity, fallDistance);
    }

    @NotNull
    public VoxelShape m_5940_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.shape;
    }

    private void tryTrample(Level level, BlockPos pos, Entity trampler, int chances) {
        if (this.canTrample(level, trampler) && !level.f_46443_ && level.f_46441_.m_188503_(chances) == 0) {
            this.trampleEgg(level, pos, trampler);
        }
    }

    protected void trampleEgg(Level level, BlockPos pos, Entity trampler) {
        Player player;
        AABB boundingBox = new AABB((double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), (double)(pos.m_123341_() + 1), (double)(pos.m_123342_() + 1), (double)(pos.m_123343_() + 1)).m_82377_(25.0, 25.0, 25.0);
        if (!(!(trampler instanceof LivingEntity) || trampler instanceof Player && (player = (Player)trampler).m_7500_())) {
            List list = level.m_6443_(Mob.class, boundingBox, living -> living.m_6084_() && living.m_6095_() == this.hatchedEntity.get());
            for (Mob living2 : list) {
                if (living2 instanceof TamableAnimal && ((TamableAnimal)living2).m_21824_() && ((TamableAnimal)living2).m_21830_((LivingEntity)trampler)) continue;
                living2.m_6710_((LivingEntity)trampler);
            }
        }
        level.m_46961_(pos, false);
    }

    public int getHatchLevel(BlockState state) {
        return (Integer)state.m_61143_((Property)HATCH);
    }

    protected boolean canHatch(BlockGetter blockGetter, BlockPos pos) {
        return !blockGetter.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.PREVENTS_EGG_HATCHING);
    }

    public static boolean hatchBoost(BlockGetter blockGetter, BlockPos pos) {
        return blockGetter.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.ACCELERATES_EGG_HATCHING);
    }

    protected boolean isReadyToHatch(BlockState state) {
        return this.getHatchLevel(state) == 2;
    }

    public void m_213897_(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (this.canHatch((BlockGetter)level, pos)) {
            if (!this.isReadyToHatch(state)) {
                level.m_5594_(null, pos, SoundEvents.f_276434_, SoundSource.BLOCKS, 0.7f, 0.9f + random.m_188501_() * 0.2f);
                level.m_7731_(pos, (BlockState)state.m_61124_((Property)HATCH, (Comparable)Integer.valueOf(this.getHatchLevel(state) + 1)), 2);
            } else {
                this.spawnEntity(level, pos, state, random);
            }
        }
    }

    public void spawnEntity(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        BlockEntity blockEntity = level.m_7702_(pos);
        if (!(blockEntity instanceof ExtraDataBlockEntity)) {
            return;
        }
        ExtraDataBlockEntity dataBlockEntity = (ExtraDataBlockEntity)blockEntity;
        UUID placer = dataBlockEntity.getOwner();
        level.m_5594_(null, pos, SoundEvents.f_276489_, SoundSource.BLOCKS, 0.7f, 0.9f + random.m_188501_() * 0.2f);
        level.m_46961_(pos, false);
        int i = this.getMobsBornFrom(state);
        if (random.m_188503_(5) == 0) {
            ++i;
        }
        for (int j = 0; j < i; ++j) {
            Player player;
            Vec3 vec3 = pos.m_252807_();
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
            if (placer != null && (player = level.m_46003_(placer)) instanceof ServerPlayer) {
                ServerPlayer serverPlayer = (ServerPlayer)player;
                CriteriaTriggers.f_10580_.m_68256_(serverPlayer, entity);
            }
            entity.m_7678_(vec3.m_7096_(), vec3.m_7098_(), vec3.m_7094_(), Mth.m_14177_((float)(level.f_46441_.m_188501_() * 360.0f)), 0.0f);
            level.m_7967_(entity);
            ForgeEventFactory.onFinalizeSpawn((Mob)mob, (ServerLevelAccessor)level, (DifficultyInstance)level.m_6436_(pos), (MobSpawnType)MobSpawnType.NATURAL, null, null);
        }
    }

    protected int getMobsBornFrom(BlockState state) {
        return 1;
    }

    protected boolean canTrample(Level level, Entity trampler) {
        if (!(trampler instanceof LivingEntity)) {
            return false;
        }
        return (trampler instanceof Player || ForgeEventFactory.getMobGriefingEvent((Level)level, (Entity)trampler)) && this.canTrample;
    }

    public void m_6807_(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState blockState, boolean b) {
        boolean preventsHatch;
        boolean hatchBoost = EggBlock.hatchBoost((BlockGetter)level, pos);
        boolean bl = preventsHatch = !this.canHatch((BlockGetter)level, pos);
        if (!level.f_46443_) {
            if (hatchBoost) {
                level.m_46796_(3009, pos, 0);
            }
            if (preventsHatch) {
                UP2ParticleUtils.queueParticlesOnBlockFaces(level, pos, (ParticleOptions)UP2Particles.SNOWFLAKE.get(), (IntProvider)UniformInt.m_146622_((int)3, (int)6));
            }
        }
        int hatchTime = hatchBoost ? 12000 : 24000;
        int delay = hatchTime / 3;
        level.m_220407_(GameEvent.f_157797_, pos, GameEvent.Context.m_223722_((BlockState)state));
        level.m_186460_(pos, (Block)this, delay + level.f_46441_.m_188503_(300));
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[]{HATCH});
    }

    public boolean m_7357_(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull PathComputationType computationType) {
        return false;
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

    public BlockEntity m_142194_(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new ExtraDataBlockEntity(pos, state);
    }

    @NotNull
    public RenderShape m_7514_(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
}


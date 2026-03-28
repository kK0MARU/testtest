/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.TryFindWaterGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_4;

import com.barlinc.unusual_prehistory.entity.ai.goals.AquaticNibbleBlockGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.CustomizableRandomSwimGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.FollowVariantLeaderGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricAquaticMob;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.mob.base.SchoolingAquaticMob;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LobeFinnedFish
extends SchoolingAquaticMob {
    private static final EntityDimensions ALLENYPTERUS_DIMENSIONS = EntityDimensions.m_20395_((float)0.5f, (float)0.8f);
    private static final EntityDimensions EUSTHENOPTERON_DIMENSIONS = EntityDimensions.m_20395_((float)0.6f, (float)0.7f);
    private static final EntityDimensions GOOLOOGONGIA_DIMENSIONS = EntityDimensions.m_20395_((float)0.6f, (float)0.5f);
    private static final EntityDimensions LACCOGNATHUS_DIMENSIONS = EntityDimensions.m_20395_((float)0.98f, (float)0.5f);
    private static final EntityDimensions SCAUMENACIA_DIMENSIONS = EntityDimensions.m_20395_((float)0.5f, (float)0.4f);

    public LobeFinnedFish(EntityType<? extends SchoolingAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 1000, 10, 0.02f, 0.1f, false);
        this.f_21365_ = new SmoothSwimmingLookControl((Mob)this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 6.0).m_22268_(Attributes.f_22279_, (double)0.8f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new TryFindWaterGoal((PathfinderMob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargePanicGoal(this, 2.0, 10, 7));
        this.f_21345_.m_25352_(2, new PrehistoricAvoidEntityGoal<LivingEntity>((PrehistoricMob)this, LivingEntity.class, 6.0f, 2.0, entity -> entity.m_6095_().m_204039_(UP2EntityTags.JAWLESS_FISH_AVOIDS)));
        this.f_21345_.m_25352_(2, new PrehistoricAvoidEntityGoal<Player>((PrehistoricMob)this, Player.class, 6.0f, 2.0, EntitySelector.f_20408_::test));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.LOBE_FINNED_FISH_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new AquaticNibbleBlockGoal(this, UP2BlockTags.LOBE_FINNED_FISH_NIBBLING_BLOCKS));
        this.f_21345_.m_25352_(5, (Goal)new CustomizableRandomSwimGoal((PathfinderMob)this, 1.0, 30));
        this.f_21345_.m_25352_(6, (Goal)new LobeFinnedFishFollowVariantLeaderGoal(this));
    }

    @Override
    public int getMaxSchoolSize() {
        return switch (this.getVariant()) {
            case 1 -> 2;
            case 2 -> 3;
            case 3 -> 1;
            case 4 -> 5;
            default -> 4;
        };
    }

    public void m_7023_(@NotNull Vec3 travelVector) {
        if (this.m_21515_() && this.m_20069_()) {
            this.m_19920_(this.m_6113_(), travelVector);
            this.m_6478_(MoverType.SELF, this.m_20184_());
            this.m_20256_(this.m_20184_().m_82490_(0.9));
            if (this.f_19862_ && this.m_204029_(FluidTags.f_13131_) && this.m_21691_()) {
                this.m_20256_(this.m_20184_().m_82520_(0.0, 0.005, 0.0));
            }
        } else {
            super.m_7023_(travelVector);
        }
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.LOBE_FINNED_FISH_FOOD);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.5f;
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (VARIANT.equals(accessor)) {
            this.m_6210_();
        }
        super.m_7350_(accessor);
    }

    @NotNull
    public EntityDimensions m_6972_(@NotNull Pose pose) {
        return this.getDimsForLobeFinnedFish().m_20388_(this.m_6134_());
    }

    private EntityDimensions getDimsForLobeFinnedFish() {
        return switch (this.getVariant()) {
            case 1 -> EUSTHENOPTERON_DIMENSIONS;
            case 2 -> GOOLOOGONGIA_DIMENSIONS;
            case 3 -> LACCOGNATHUS_DIMENSIONS;
            case 4 -> SCAUMENACIA_DIMENSIONS;
            default -> ALLENYPTERUS_DIMENSIONS;
        };
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.LOBE_FINNED_FISH_BUCKET.get());
    }

    @Override
    public boolean canBucket() {
        return true;
    }

    @Override
    @NotNull
    public SoundEvent m_142623_() {
        return SoundEvents.f_11779_;
    }

    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.JAWLESS_FISH_DEATH.get();
    }

    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.JAWLESS_FISH_HURT.get();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return (SoundEvent)UP2SoundEvents.JAWLESS_FISH_FLOP.get();
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        LobeFinnedFish lobeFinnedFish = (LobeFinnedFish)((EntityType)UP2Entities.LOBE_FINNED_FISH.get()).m_20615_((Level)level);
        if (lobeFinnedFish != null) {
            lobeFinnedFish.setVariant(this.getVariant());
        }
        return lobeFinnedFish;
    }

    @Override
    public int getVariantCount() {
        return LobeFinnedFishVariant.values().length;
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        spawnGroupData = super.m_6518_(level, difficulty, spawnType, spawnGroupData, compoundTag);
        if (spawnType == MobSpawnType.BUCKET && compoundTag != null && compoundTag.m_128425_("BucketVariantTag", 3)) {
            this.setVariant(compoundTag.m_128451_("BucketVariantTag"));
        } else {
            this.setVariant(this.f_19796_.m_188503_(LobeFinnedFishVariant.values().length));
        }
        return spawnGroupData;
    }

    public static boolean canSpawn(EntityType<LobeFinnedFish> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return PrehistoricAquaticMob.checkSpawnRules(entityType, level, spawnType, pos, random);
    }

    private static class LobeFinnedFishFollowVariantLeaderGoal
    extends FollowVariantLeaderGoal {
        public LobeFinnedFishFollowVariantLeaderGoal(SchoolingAquaticMob mob) {
            super(mob);
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.mob.getVariant() != 3;
        }
    }

    public static enum LobeFinnedFishVariant {
        ALLENYPTERUS(0),
        EUSTHENOPTERON(1),
        GOOLOOGONGIA(2),
        LACCOGNATHUS(3),
        SCAUMENACIA(4);

        private final int variant;

        private LobeFinnedFishVariant(int variant) {
            this.variant = variant;
        }

        public int getId() {
            return this.variant;
        }

        public static LobeFinnedFishVariant byId(int id) {
            if (id < 0 || id >= LobeFinnedFishVariant.values().length) {
                id = 0;
            }
            return LobeFinnedFishVariant.values()[id];
        }
    }
}


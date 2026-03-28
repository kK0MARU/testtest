/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LightningBolt
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.BreedGoal
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.FollowParentGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.PanicGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.ItemUtils
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Unicorn
extends Animal {
    private static final EntityDataAccessor<Boolean> SKELETAL = SynchedEntityData.m_135353_(Unicorn.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private UUID lastLightningBoltUUID;
    public final SmoothAnimationState idleAnimationState = new SmoothAnimationState();

    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        return new NoSpinGroundPathNavigation((Mob)this, level);
    }

    public Unicorn(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22279_, (double)0.2f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new PanicGoal((PathfinderMob)this, 2.0));
        this.f_21345_.m_25352_(2, (Goal)new BreedGoal((Animal)this, 1.0));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.UNICORN_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new FollowParentGoal((Animal)this, 1.0));
        this.f_21345_.m_25352_(5, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
    }

    public void m_8119_() {
        super.m_8119_();
        if (this.m_9236_().f_46443_) {
            this.setupAnimationStates();
        } else if (this.f_19797_ % 200 == 0 && this.m_21223_() < this.m_21233_()) {
            this.m_5634_(2.0f);
        }
    }

    private void setupAnimationStates() {
        this.idleAnimationState.m_246184_(this.m_6084_(), this.f_19797_);
    }

    public void m_267651_(boolean flying) {
        float pos = (float)Mth.m_184648_((double)(this.m_20185_() - this.f_19854_), (double)(this.m_20186_() - this.f_19855_), (double)(this.m_20189_() - this.f_19856_));
        float speed = Math.min(pos * this.getWalkAnimationSpeed(), 1.0f);
        this.f_267362_.m_267566_(speed, 0.4f);
    }

    public float getWalkAnimationSpeed() {
        return this.m_6162_() ? 3.0f : 10.0f;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.UNICORN_FOOD);
    }

    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        if (this.m_6898_(itemstack)) {
            int i = this.m_146764_();
            if (!this.m_9236_().f_46443_ && i == 0 && this.m_5957_()) {
                this.m_142075_(player, hand, itemstack);
                this.m_27595_(player);
                this.m_216990_(SoundEvents.f_144165_);
                return InteractionResult.SUCCESS;
            }
            if (this.m_6162_()) {
                this.m_142075_(player, hand, itemstack);
                this.m_146740_(Unicorn.m_216967_((int)(-i)), true);
                this.m_216990_(SoundEvents.f_144165_);
                return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
            }
            if (this.m_9236_().f_46443_) {
                return InteractionResult.CONSUME;
            }
        }
        if (itemstack.m_150930_(Items.f_42446_) && !this.m_6162_()) {
            player.m_5496_(SoundEvents.f_11833_, 1.0f, 1.0f);
            ItemStack result = ItemUtils.m_41813_((ItemStack)itemstack, (Player)player, (ItemStack)Items.f_42455_.m_7968_());
            player.m_21008_(hand, result);
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        if (itemstack.m_150930_(Items.f_42399_) && !this.m_6162_()) {
            player.m_5496_(SoundEvents.f_12073_, 1.0f, 1.0f);
            ItemStack result = ItemUtils.m_41813_((ItemStack)itemstack, (Player)player, (ItemStack)Items.f_42734_.m_7968_());
            player.m_21008_(hand, result);
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        return InteractionResult.PASS;
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.UNICORN.get()).m_20615_((Level)serverLevel);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.UNICORN_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        if (this.isSkeletal()) {
            return SoundEvents.f_12381_;
        }
        return (SoundEvent)UP2SoundEvents.UNICORN_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        if (this.isSkeletal()) {
            return SoundEvents.f_12424_;
        }
        return (SoundEvent)UP2SoundEvents.UNICORN_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_(SoundEvents.f_12624_, 0.25f, 1.0f);
    }

    public int m_8100_() {
        return 150;
    }

    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128379_("Skeletal", this.isSkeletal());
    }

    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setSkeletal(compoundTag.m_128471_("Skeletal"));
    }

    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(SKELETAL, (Object)false);
    }

    public boolean isSkeletal() {
        return (Boolean)this.f_19804_.m_135370_(SKELETAL);
    }

    private void setSkeletal(boolean isSkeletal) {
        this.f_19804_.m_135381_(SKELETAL, (Object)isSkeletal);
    }

    public void m_8038_(@NotNull ServerLevel level, LightningBolt lightningBolt) {
        UUID uuid = lightningBolt.m_20148_();
        if (!uuid.equals(this.lastLightningBoltUUID)) {
            this.setSkeletal((!this.isSkeletal() || this.isSkeletal()) != this.isSkeletal());
            this.lastLightningBoltUUID = uuid;
            this.m_5496_(SoundEvents.f_12424_, 2.0f, 1.0f);
        }
    }

    public static boolean canSpawn(EntityType<Unicorn> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.UNICORN_SPAWNABLE_ON) && Unicorn.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }
}


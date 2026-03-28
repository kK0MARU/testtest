/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MovementEmission
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.animal.Bucketable
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.common.Tags$Items
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricFlyingLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricFlyingMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.goals.FlyingPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.RandomFlightGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinFlyingPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricFlyingMob;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import com.barlinc.unusual_prehistory.utils.UP2Developers;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

public class Kimmeridgebrachypteraeschnidium
extends PrehistoricFlyingMob
implements Bucketable {
    private static final EntityDataAccessor<Integer> BASE_COLOR = SynchedEntityData.m_135353_(Kimmeridgebrachypteraeschnidium.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Integer> PATTERN = SynchedEntityData.m_135353_(Kimmeridgebrachypteraeschnidium.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Integer> PATTERN_COLOR = SynchedEntityData.m_135353_(Kimmeridgebrachypteraeschnidium.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Boolean> HAS_PATTERN = SynchedEntityData.m_135353_(Kimmeridgebrachypteraeschnidium.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Integer> WING_COLOR = SynchedEntityData.m_135353_(Kimmeridgebrachypteraeschnidium.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    public static final EntityDataAccessor<Integer> PREEN_COOLDOWN = SynchedEntityData.m_135353_(Kimmeridgebrachypteraeschnidium.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.m_135353_(Kimmeridgebrachypteraeschnidium.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Integer> SWELL_DURATION = SynchedEntityData.m_135353_(Kimmeridgebrachypteraeschnidium.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private int oldSwell;
    private int swell;
    private final int maxSwell = 60;
    public final SmoothAnimationState preenAnimationState = new SmoothAnimationState();

    public Kimmeridgebrachypteraeschnidium(EntityType<? extends PrehistoricFlyingMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new PrehistoricFlyingMoveControl(this);
        this.f_21365_ = new PrehistoricFlyingLookControl((Mob)this, 85);
        this.m_21441_(BlockPathTypes.LEAVES, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 6.0).m_22268_(Attributes.f_22279_, (double)0.01f).m_22268_(Attributes.f_22280_, (double)1.3f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new FlyingPanicGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new KimmeridgebrachypteraeschnidiumScatterGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new RandomFlightGoal(this, 1.0f, 1.5f, 13, 5, 60, 600));
        this.f_21345_.m_25352_(5, (Goal)new KimmeridgebrachypteraeschnidiumLookAroundGoal(this));
        this.f_21345_.m_25352_(6, (Goal)new KimmeridgebrachypteraeschnidiumPreenGoal(this));
    }

    @NotNull
    public MobType m_6336_() {
        return MobType.f_21642_;
    }

    public boolean m_6040_() {
        return true;
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.6f;
    }

    @Override
    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        return new NoSpinFlyingPathNavigation((Mob)this, level);
    }

    @Override
    public float m_5610_(@NotNull BlockPos pos, @NotNull LevelReader level) {
        return level.m_8055_(pos).m_60795_() ? 10.0f : 0.0f;
    }

    @Override
    public void switchNavigator(boolean onLand) {
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.refuseToMove() || this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        super.m_7023_(travelVec);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_FOOD);
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.getPreenCooldown() > 0 && !this.m_9236_().f_46443_) {
            this.setPreenCooldown(this.getPreenCooldown() - 1);
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.m_29443_() && this.getIdleState() != 1, this.f_19797_);
        this.flyAnimationState.m_246184_(this.m_29443_(), this.f_19797_);
        this.preenAnimationState.m_246184_(!this.m_29443_() && this.getIdleState() == 1, this.f_19797_);
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (this.m_20072_()) {
            this.setFlying(true);
        }
        if (this.m_6084_()) {
            int i;
            this.oldSwell = this.swell;
            if (this.m_8077_() && this.m_7755_().getString().contains("draconoptera")) {
                this.setSwellDuration(1);
            }
            if ((i = this.getSwellDuration()) > 0 && this.swell == 0) {
                this.m_5496_(SoundEvents.f_11837_, 1.0f, 0.5f);
                this.m_146850_(GameEvent.f_157776_);
            }
            this.swell += i;
            if (this.swell < 0) {
                this.swell = 0;
            }
            if (this.swell >= this.maxSwell) {
                this.swell = this.maxSwell;
                this.explode();
            }
        }
        if (this.m_9236_().f_46443_ && this.m_6084_()) {
            UnusualPrehistory2.PROXY.playWorldSound((Object)this, (byte)1);
        }
    }

    @Override
    public void tickFlight() {
        if (this.m_29443_() && this.flyProgress < 5.0f) {
            this.flyProgress += 1.0f;
        }
        if (!this.m_29443_() && this.flyProgress > 0.0f) {
            this.flyProgress -= 1.0f;
        }
        if (this.m_29443_()) {
            ++this.flightTicks;
            this.m_20242_(true);
            if (this.groundTicks > 0) {
                this.setFlying(false);
            }
        } else {
            this.flightTicks = 0;
            this.m_20242_(false);
        }
        if (this.groundTicks > 0) {
            --this.groundTicks;
        }
        if (!this.m_9236_().f_46443_) {
            if (this.m_29443_() && this.m_6084_() && !this.m_20160_()) {
                if (this.landingFlag) {
                    this.m_20256_(this.m_20184_().m_82520_(0.0, -0.1, 0.0));
                }
                if (this.f_19862_ && !this.landingFlag) {
                    this.m_20256_(this.m_20184_().m_82520_(0.0, 0.05, 0.0));
                }
            }
            if (this.m_29443_() && this.flightTicks > 40 && this.m_20096_()) {
                this.setFlying(false);
            }
        }
    }

    private void explode() {
        if (!this.m_9236_().f_46443_) {
            this.f_20890_ = true;
            this.m_9236_().m_254849_((Entity)this, this.m_20185_(), this.m_20186_(), this.m_20189_(), 7.0f, Level.ExplosionInteraction.MOB);
            this.m_146870_();
        }
    }

    public float getSwelling(float partialTicks) {
        return Mth.m_14179_((float)partialTicks, (float)this.oldSwell, (float)this.swell) / (float)(this.maxSwell - 2);
    }

    public void m_142687_(// Could not load outer class - annotation placement on inner may be incorrect
    @NotNull Entity.RemovalReason removalReason) {
        UnusualPrehistory2.PROXY.clearSoundCacheFor((Entity)this);
        super.m_142687_(removalReason);
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        if (itemstack.m_41720_() == Items.f_42590_ && this.m_6084_()) {
            this.m_5496_(SoundEvents.f_11771_, 0.5f, 1.0f);
            itemstack.m_41774_(1);
            ItemStack bottle = new ItemStack((ItemLike)UP2Items.KIMMERIDGEBRACHYPTERAESCHNIDIUM_BOTTLE.get());
            this.setBucketData(bottle);
            if (!this.m_9236_().f_46443_) {
                CriteriaTriggers.f_10576_.m_38772_((ServerPlayer)player, bottle);
            }
            if (itemstack.m_41619_() && !player.m_7500_()) {
                player.m_21008_(hand, bottle);
            } else if (!player.m_150109_().m_36054_(bottle)) {
                player.m_36176_(bottle, false);
            }
            this.m_146870_();
            return InteractionResult.SUCCESS;
        }
        if (!this.m_21824_() && itemstack.m_150930_(Items.f_42751_) && UP2Developers.isDeveloper(player.m_20148_()) || itemstack.m_204117_(Tags.Items.GEMS_DIAMOND) && player.m_20148_().equals(UP2Developers.CRYDIGO.getUuid())) {
            if (!player.m_150110_().f_35937_) {
                itemstack.m_41774_(1);
            }
            this.m_146850_(GameEvent.f_223708_);
            this.m_21828_(player);
            this.m_9236_().m_7605_((Entity)this, (byte)9);
            this.m_5634_(this.m_21233_());
            return InteractionResult.SUCCESS;
        }
        return super.m_6071_(player, hand);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() && this.getIdleState() == 1;
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(FROM_BUCKET, (Object)false);
        this.f_19804_.m_135372_(BASE_COLOR, (Object)0);
        this.f_19804_.m_135372_(PATTERN, (Object)0);
        this.f_19804_.m_135372_(PATTERN_COLOR, (Object)0);
        this.f_19804_.m_135372_(HAS_PATTERN, (Object)false);
        this.f_19804_.m_135372_(WING_COLOR, (Object)0);
        this.f_19804_.m_135372_(PREEN_COOLDOWN, (Object)(20 + this.f_19796_.m_188503_(200)));
        this.f_19804_.m_135372_(SWELL_DURATION, (Object)-1);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("BaseColor", this.getBaseColor());
        compoundTag.m_128405_("Pattern", this.getPattern());
        compoundTag.m_128405_("PatternColor", this.getPatternColor());
        compoundTag.m_128405_("WingColor", this.getWingColor());
        compoundTag.m_128379_("HasPattern", this.getHasPattern());
        compoundTag.m_128405_("PreenCooldown", this.getPreenCooldown());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setBaseColor(compoundTag.m_128451_("BaseColor"));
        this.setPattern(compoundTag.m_128451_("Pattern"));
        this.setPatternColor(compoundTag.m_128451_("PatternColor"));
        this.setWingColor(compoundTag.m_128451_("WingColor"));
        this.setHasPattern(compoundTag.m_128471_("HasPattern"));
        this.setPreenCooldown(compoundTag.m_128451_("PreenCooldown"));
    }

    public void m_6872_(ItemStack bucket) {
        CompoundTag compoundTag = bucket.m_41784_();
        Bucketable.m_148822_((Mob)this, (ItemStack)bucket);
        compoundTag.m_128350_("Health", this.m_21223_());
        compoundTag.m_128405_("BaseColor", this.getBaseColor());
        compoundTag.m_128405_("Pattern", this.getPattern());
        compoundTag.m_128405_("PatternColor", this.getPatternColor());
        compoundTag.m_128405_("WingColor", this.getWingColor());
        compoundTag.m_128379_("HasPattern", this.getHasPattern());
        compoundTag.m_128405_("Age", this.m_146764_());
        if (this.m_8077_()) {
            bucket.m_41714_(this.m_7770_());
        }
    }

    private void setBucketData(ItemStack bucket) {
        CompoundTag compoundTag = bucket.m_41784_();
        compoundTag.m_128350_("Health", this.m_21223_());
        compoundTag.m_128405_("BaseColor", this.getBaseColor());
        compoundTag.m_128405_("Pattern", this.getPattern());
        compoundTag.m_128405_("PatternColor", this.getPatternColor());
        compoundTag.m_128379_("HasPattern", this.getHasPattern());
        compoundTag.m_128405_("WingColor", this.getWingColor());
        if (this.m_8077_()) {
            bucket.m_41714_(this.m_7770_());
        }
    }

    public static String getPatternName(int pattern) {
        return switch (pattern) {
            case 1 -> "tailshade";
            case 2 -> "topshade";
            case 3 -> "halfshade";
            case 4 -> "large_stripe";
            case 5 -> "racing_stripe";
            case 6 -> "large_racing_stripe";
            default -> "stripe";
        };
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        if (spawnType == MobSpawnType.BUCKET && dataTag != null && dataTag.m_128425_("BaseColor", 3)) {
            this.setBaseColor(dataTag.m_128451_("BaseColor"));
            this.setPattern(dataTag.m_128451_("Pattern"));
            this.setPatternColor(dataTag.m_128451_("PatternColor"));
            this.setWingColor(dataTag.m_128451_("WingColor"));
            this.setHasPattern(dataTag.m_128471_("HasPattern"));
        } else {
            this.setBaseColor(this.f_19796_.m_188503_(16));
            this.setPattern(this.f_19796_.m_188503_(7));
            this.setPatternColor(this.f_19796_.m_188503_(16));
            this.setWingColor(this.f_19796_.m_188503_(16));
            this.setHasPattern(this.f_19796_.m_188503_(3) == 0);
        }
        return super.m_6518_(level, difficulty, spawnType, spawnData, dataTag);
    }

    public void m_142278_(@NotNull CompoundTag tag) {
        Bucketable.m_148825_((Mob)this, (CompoundTag)tag);
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.KIMMERIDGEBRACHYPTERAESCHNIDIUM_BOTTLE.get());
    }

    @NotNull
    public SoundEvent m_142623_() {
        return SoundEvents.f_11771_;
    }

    public int getBaseColor() {
        return (Integer)this.f_19804_.m_135370_(BASE_COLOR);
    }

    public void setBaseColor(int variant) {
        this.f_19804_.m_135381_(BASE_COLOR, (Object)Mth.m_14045_((int)variant, (int)0, (int)15));
    }

    public int getPattern() {
        return (Integer)this.f_19804_.m_135370_(PATTERN);
    }

    public void setPattern(int variant) {
        this.f_19804_.m_135381_(PATTERN, (Object)Mth.m_14045_((int)variant, (int)0, (int)6));
    }

    public int getPatternColor() {
        return (Integer)this.f_19804_.m_135370_(PATTERN_COLOR);
    }

    public void setPatternColor(int variant) {
        this.f_19804_.m_135381_(PATTERN_COLOR, (Object)Mth.m_14045_((int)variant, (int)0, (int)15));
    }

    public int getWingColor() {
        return (Integer)this.f_19804_.m_135370_(WING_COLOR);
    }

    public void setWingColor(int variant) {
        this.f_19804_.m_135381_(WING_COLOR, (Object)Mth.m_14045_((int)variant, (int)0, (int)15));
    }

    public boolean getHasPattern() {
        return (Boolean)this.f_19804_.m_135370_(HAS_PATTERN);
    }

    public void setHasPattern(boolean hasPattern) {
        this.f_19804_.m_135381_(HAS_PATTERN, (Object)hasPattern);
    }

    public boolean m_27487_() {
        return (Boolean)this.f_19804_.m_135370_(FROM_BUCKET);
    }

    public void m_27497_(boolean fromBucket) {
        this.f_19804_.m_135381_(FROM_BUCKET, (Object)fromBucket);
    }

    public int getPreenCooldown() {
        return (Integer)this.f_19804_.m_135370_(PREEN_COOLDOWN);
    }

    public void setPreenCooldown(int cooldown) {
        this.f_19804_.m_135381_(PREEN_COOLDOWN, (Object)cooldown);
    }

    public int getSwellDuration() {
        return (Integer)this.f_19804_.m_135370_(SWELL_DURATION);
    }

    public void setSwellDuration(int duration) {
        this.f_19804_.m_135381_(SWELL_DURATION, (Object)duration);
    }

    public boolean m_6673_(DamageSource source) {
        return source.m_276093_(DamageTypes.f_268671_) || super.m_6673_(source);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        return null;
    }

    protected void m_7324_(@NotNull Entity entity) {
    }

    protected void m_6138_() {
    }

    protected // Could not load outer class - annotation placement on inner may be incorrect
    @NotNull Entity.MovementEmission m_142319_() {
        return Entity.MovementEmission.EVENTS;
    }

    protected void m_5841_() {
    }

    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.KIMMERIDGEBRACHYPTERAESCHNIDIUM_HURT.get();
    }

    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.KIMMERIDGEBRACHYPTERAESCHNIDIUM_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
    }

    protected float m_6121_() {
        return 0.5f;
    }

    @NotNull
    public AABB m_6921_() {
        return this.m_20191_().m_82377_(3.0, 3.0, 3.0);
    }

    public boolean m_6783_(double distance) {
        return Math.sqrt(distance) < 1024.0;
    }

    public static boolean canSpawn(EntityType<Kimmeridgebrachypteraeschnidium> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_SPAWNABLE_ON) && Kimmeridgebrachypteraeschnidium.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class KimmeridgebrachypteraeschnidiumScatterGoal
    extends Goal {
        private final Kimmeridgebrachypteraeschnidium dragonfly;

        public KimmeridgebrachypteraeschnidiumScatterGoal(Kimmeridgebrachypteraeschnidium dragonfly) {
            this.dragonfly = dragonfly;
        }

        public boolean m_8036_() {
            if (this.dragonfly.m_29443_()) {
                return false;
            }
            long worldTime = this.dragonfly.m_9236_().m_46467_() % 10L;
            if (this.dragonfly.m_217043_().m_188503_(10) != 0 && worldTime != 0L) {
                return false;
            }
            AABB aabb = this.dragonfly.m_20191_().m_82400_(4.0);
            List list = this.dragonfly.m_9236_().m_6443_(Entity.class, aabb, entity -> entity.m_6095_().m_204039_(UP2EntityTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_AVOIDS) || entity instanceof Player && !((Player)entity).m_7500_());
            return !list.isEmpty();
        }

        public boolean m_8045_() {
            return false;
        }

        public void m_8056_() {
            this.dragonfly.setFlying(true);
            if (this.dragonfly.m_20096_()) {
                this.dragonfly.m_20256_(this.dragonfly.m_20184_().m_82520_(0.0, 0.5, 0.0));
            }
        }
    }

    private static class KimmeridgebrachypteraeschnidiumLookAroundGoal
    extends RandomLookAroundGoal {
        private final Kimmeridgebrachypteraeschnidium dragonfly;

        public KimmeridgebrachypteraeschnidiumLookAroundGoal(Kimmeridgebrachypteraeschnidium dragonfly) {
            super((Mob)dragonfly);
            this.dragonfly = dragonfly;
        }

        public boolean m_8036_() {
            return this.dragonfly.m_20096_() && super.m_8036_();
        }

        public boolean m_8045_() {
            return this.dragonfly.m_20096_() && super.m_8045_();
        }
    }

    private static class KimmeridgebrachypteraeschnidiumPreenGoal
    extends IdleAnimationGoal {
        private final Kimmeridgebrachypteraeschnidium kimmeridgebrachypteraeschnidium;

        public KimmeridgebrachypteraeschnidiumPreenGoal(Kimmeridgebrachypteraeschnidium kimmeridgebrachypteraeschnidium) {
            super(kimmeridgebrachypteraeschnidium, 60, 1);
            this.kimmeridgebrachypteraeschnidium = kimmeridgebrachypteraeschnidium;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.kimmeridgebrachypteraeschnidium.getPreenCooldown() == 0 && !this.kimmeridgebrachypteraeschnidium.m_29443_() && this.kimmeridgebrachypteraeschnidium.m_20096_();
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && !this.kimmeridgebrachypteraeschnidium.m_29443_() && this.kimmeridgebrachypteraeschnidium.m_20096_();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.kimmeridgebrachypteraeschnidium.setPreenCooldown(20 + this.kimmeridgebrachypteraeschnidium.m_217043_().m_188503_(200));
        }
    }
}


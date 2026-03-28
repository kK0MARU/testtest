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
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.TagKey
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.PlayerRideableJumping
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.FollowParentGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.common.Tags$Items
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_4;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargeBabyPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricFollowOwnerGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricOwnerHurtByTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricOwnerHurtTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricSitWhenOrderedToGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.KeybindUsingMount;
import com.barlinc.unusual_prehistory.entity.utils.LeapingMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.network.MountedEntityKeyPacket;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Network;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import com.barlinc.unusual_prehistory.utils.UP2LoadedMods;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.PlayerRideableJumping;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Ulughbegsaurus
extends PrehistoricMob
implements KeybindUsingMount,
PlayerRideableJumping,
LeapingMob {
    private static final EntityDataAccessor<Boolean> RAINBOW = SynchedEntityData.m_135353_(Ulughbegsaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Boolean> LEAPING = SynchedEntityData.m_135353_(Ulughbegsaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Integer> TAME_ATTEMPTS = SynchedEntityData.m_135353_(Ulughbegsaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private boolean leapImpulse;
    private int attackCooldown = 0;
    public final SmoothAnimationState attack1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState yawnAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState shakeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState jumpAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState blinkAnimationState = new SmoothAnimationState();
    private int attackTicks;
    private boolean attackAlt = false;
    private int blinkCooldown = 60 + this.m_217043_().m_188503_(60);
    private int shakeCooldown = 1000 + this.m_217043_().m_188503_(1000);
    private int yawnCooldown = 600 + this.m_217043_().m_188503_(600);

    public Ulughbegsaurus(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
        this.m_274367_(1.1f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new PrehistoricSitWhenOrderedToGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new LargeBabyPanicGoal(this, 1.8, 10, 4));
        this.f_21345_.m_25352_(3, (Goal)new UlughbegsaurusAttackGoal(this));
        this.f_21345_.m_25352_(4, (Goal)new PrehistoricFollowOwnerGoal(this, 1.2, 7.0f, 4.0f));
        this.f_21345_.m_25352_(5, (Goal)new TemptGoal((PathfinderMob)this, 1.1, Ingredient.m_204132_(UP2ItemTags.ULUGHBEGSAURUS_FOOD), false));
        this.f_21345_.m_25352_(6, (Goal)new FollowParentGoal((Animal)this, 1.1));
        this.f_21345_.m_25352_(7, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(8, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 10.0f));
        this.f_21345_.m_25352_(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(9, (Goal)new SleepingGoal(this));
        this.f_21345_.m_25352_(10, (Goal)new UlughbegsaurusBlinkGoal(this));
        this.f_21345_.m_25352_(10, (Goal)new UlughbegsaurusShakeGoal(this));
        this.f_21345_.m_25352_(10, (Goal)new UlughbegsaurusYawnGoal(this));
        this.f_21346_.m_25352_(0, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(1, new PrehistoricNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 300, true, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.ULUGHBEGSAURUS_TARGETS)));
        this.f_21346_.m_25352_(2, (Goal)new PrehistoricOwnerHurtByTargetGoal(this));
        this.f_21346_.m_25352_(3, (Goal)new PrehistoricOwnerHurtTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 40.0).m_22268_(Attributes.f_22281_, 6.0).m_22268_(Attributes.f_22279_, (double)0.23f).m_22268_(Attributes.f_22278_, 0.5).m_22268_(Attributes.f_22277_, 32.0).m_22268_(Attributes.f_22288_, 0.5);
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_ULUGHBEGSAURUS);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.ULUGHBEGSAURUS_FOOD);
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        UlughbegsaurusVariant variant;
        ItemStack itemstack = player.m_21120_(hand);
        InteractionResult type = super.m_6071_(player, hand);
        if (!this.m_21824_() && itemstack.m_204117_(UP2ItemTags.TAMES_ULUGHBEGSAURUS)) {
            if (!this.m_9236_().f_46443_) {
                if (!player.m_150110_().f_35937_) {
                    itemstack.m_41774_(1);
                }
                this.m_146850_(GameEvent.f_223708_);
                if (this.getTameAttempts() > 2 && this.m_217043_().m_188499_()) {
                    this.m_9236_().m_7605_((Entity)this, (byte)7);
                    this.m_21828_(player);
                    this.setPacifiedTicks(-1);
                    this.m_5634_(this.m_21233_());
                } else {
                    this.m_9236_().m_7605_((Entity)this, (byte)6);
                    this.setTameAttempts(this.getTameAttempts() + 1);
                }
            }
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        if (!this.isRainbow() && itemstack.m_204117_(Tags.Items.DYES) && (variant = UlughbegsaurusVariant.byDye(itemstack)) != null && variant.getId() != this.getVariant()) {
            if (!player.m_150110_().f_35937_) {
                itemstack.m_41774_(1);
            }
            this.setVariant(variant.getId());
            this.m_146850_(GameEvent.f_223708_);
            this.m_216990_(SoundEvents.f_144133_);
            return InteractionResult.SUCCESS;
        }
        return type;
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.refuseToMove() && this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        this.floatWhileRidden(travelVec);
        super.m_7023_(travelVec);
    }

    protected float m_245547_(@NotNull Player rider) {
        float sprintSpeed = rider.m_20142_() ? 0.1f : 0.0f;
        return (float)this.m_21133_(Attributes.f_22279_) * 0.55f + sprintSpeed;
    }

    public boolean m_264410_() {
        return true;
    }

    @Override
    public Vec3 getRiderOffset() {
        return new Vec3(0.0, (double)0.3f, 0.0);
    }

    @Override
    public boolean canOwnerCommand(Player player) {
        return player.m_6144_() && (!this.isPlayerHoldingDye(player) || this.isRainbow());
    }

    @Override
    public boolean canOwnerMount(Player player) {
        return !this.m_6162_() && (!this.isPlayerHoldingDye(player) || this.isRainbow());
    }

    private boolean isPlayerHoldingDye(Player player) {
        return player.m_21120_(InteractionHand.OFF_HAND).m_204117_(Tags.Items.DYES) || player.m_21120_(InteractionHand.MAIN_HAND).m_204117_(Tags.Items.DYES);
    }

    @Override
    public void onKeyPacket(Entity keyPresser, int type) {
        if (keyPresser.m_20365_((Entity)this) && type == 3 && this.m_20089_() == Pose.STANDING) {
            this.m_5616_(keyPresser.m_6080_());
            this.m_146926_(keyPresser.m_146909_());
            this.attackAlt = this.m_217043_().m_188499_();
            this.m_20124_(UP2Poses.ATTACKING.get());
        }
    }

    private void tickPlayerBite() {
        if (this.attackCooldown == 0) {
            if (!this.m_9236_().f_46443_) {
                if (this.m_20089_() == UP2Poses.ATTACKING.get() && this.m_217005_()) {
                    if (this.attackTicks == 7) {
                        this.m_9236_().m_6269_(null, (Entity)this, (SoundEvent)UP2SoundEvents.ULUGHBEGSAURUS_ATTACK.get(), SoundSource.PLAYERS, 1.0f, 0.9f + this.m_217043_().m_188501_() * 0.2f);
                    }
                    if (this.attackTicks <= 6 && this.attackTicks > 4) {
                        this.biteNearbyEntities(2.3);
                        this.m_6674_(InteractionHand.MAIN_HAND);
                    }
                }
            } else {
                Player player = UnusualPrehistory2.PROXY.getClientSidePlayer();
                if (player != null && player.m_20365_((Entity)this) && UnusualPrehistory2.PROXY.isKeyDown(3) && this.m_20089_() != UP2Poses.ATTACKING.get()) {
                    UP2Network.sendPacketToServer(new MountedEntityKeyPacket(this.m_19879_(), player.m_19879_(), 3));
                }
            }
        }
    }

    private void biteNearbyEntities(double radius) {
        LivingEntity entity;
        List nearbyEntities = this.m_9236_().m_45971_(LivingEntity.class, TargetingConditions.m_148352_(), (LivingEntity)this, this.m_20191_().m_82400_(radius));
        if (!(nearbyEntities.isEmpty() || (entity = (LivingEntity)nearbyEntities.get(0)).m_7306_((Entity)this) || this.m_7307_((Entity)entity))) {
            this.m_7327_((Entity)entity);
            this.m_6674_(InteractionHand.MAIN_HAND);
        }
    }

    public void m_7888_(int jumpPower) {
        this.setLeaping(true);
        if (this.m_20096_()) {
            this.leapImpulse = true;
            float f = 0.05f + (float)jumpPower * 0.01f;
            float jump = f * this.m_20098_() + this.m_285755_();
            Vec3 jumpForwards = new Vec3(0.0, (double)(jump * 0.9f), (double)this.f_20902_).m_82524_((float)Math.toRadians(-this.f_20883_));
            this.m_20256_(this.m_20184_().m_82549_(jumpForwards));
        }
    }

    public boolean m_7132_() {
        return !this.isLeaping() && !this.m_20072_();
    }

    public void m_7199_(int jumpPower) {
    }

    public void m_8012_() {
    }

    protected int m_5639_(float fallDistance, float damageMultiplier) {
        return super.m_5639_(fallDistance, damageMultiplier) - 6;
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        this.tickPlayerBite();
        if ((this.m_20096_() || this.m_20072_()) && this.isLeaping() && !this.leapImpulse) {
            this.setLeaping(false);
        }
        if (this.leapImpulse) {
            this.leapImpulse = false;
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.attackTicks > 0) {
            --this.attackTicks;
        }
        if (this.attackTicks == 0 && this.m_20089_() == UP2Poses.ATTACKING.get()) {
            this.attackCooldown = 2 + this.m_217043_().m_188503_(2);
            this.m_20124_(Pose.STANDING);
        }
        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
        if (!this.m_9236_().f_46443_) {
            if (this.blinkCooldown > 0) {
                --this.blinkCooldown;
            }
            if (this.m_21188_() == null && this.m_5448_() == null && !this.m_20072_()) {
                if (this.shakeCooldown > 0) {
                    --this.shakeCooldown;
                }
                if (this.yawnCooldown > 0) {
                    --this.yawnCooldown;
                }
            }
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.isEepy() && !this.isSitting() && !this.m_20072_(), this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20072_(), this.f_19797_);
        this.jumpAnimationState.m_246184_(this.isLeaping(), this.f_19797_);
        this.attack1AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && !this.attackAlt, this.f_19797_);
        this.attack2AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && this.attackAlt, this.f_19797_);
        this.sitAnimationState.m_246184_(this.isSitting(), this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
        this.blinkAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.shakeAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
        this.yawnAnimationState.m_246184_(this.getIdleState() == 3, this.f_19797_);
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (f_19806_.equals(accessor) && this.m_20089_() == UP2Poses.ATTACKING.get()) {
            this.attackTicks = 15;
        }
        super.m_7350_(accessor);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(TAME_ATTEMPTS, (Object)0);
        this.f_19804_.m_135372_(RAINBOW, (Object)false);
        this.f_19804_.m_135372_(LEAPING, (Object)false);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("TameAttempts", this.getTameAttempts());
        compoundTag.m_128379_("Rainbow", this.isRainbow());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setTameAttempts(compoundTag.m_128451_("TameAttempts"));
        this.setRainbow(compoundTag.m_128471_("Rainbow"));
    }

    public void setTameAttempts(int tameAttempts) {
        this.f_19804_.m_135381_(TAME_ATTEMPTS, (Object)tameAttempts);
    }

    public int getTameAttempts() {
        return (Integer)this.f_19804_.m_135370_(TAME_ATTEMPTS);
    }

    public boolean isRainbow() {
        return (Boolean)this.f_19804_.m_135370_(RAINBOW);
    }

    public void setRainbow(boolean rainbow) {
        this.f_19804_.m_135381_(RAINBOW, (Object)rainbow);
    }

    @Override
    public boolean isLeaping() {
        return (Boolean)this.f_19804_.m_135370_(LEAPING);
    }

    @Override
    public void setLeaping(boolean leaping) {
        this.f_19804_.m_135381_(LEAPING, (Object)leaping);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        Ulughbegsaurus ulughbegsaurus = (Ulughbegsaurus)((EntityType)UP2Entities.ULUGHBEGSAURUS.get()).m_20615_((Level)level);
        if (ulughbegsaurus != null) {
            ulughbegsaurus.setVariant(this.getVariant());
            ulughbegsaurus.setRainbow(this.isRainbow());
        }
        return ulughbegsaurus;
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.ULUGHBEGSAURUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.ULUGHBEGSAURUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.ULUGHBEGSAURUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.ULUGHBEGSAURUS_STEP.get(), this.m_6162_() ? 0.3f : 1.0f, this.m_6162_() ? 1.2f : 1.0f);
    }

    public int m_8100_() {
        return 250;
    }

    @Override
    public int getVariantCount() {
        return UlughbegsaurusVariant.values().length;
    }

    public static int getRandomNaturalColor(RandomSource random) {
        int i = random.m_188503_(100);
        if (i < 10) {
            return UlughbegsaurusVariant.ORANGE.getId();
        }
        if (i < 20) {
            return UlughbegsaurusVariant.BROWN.getId();
        }
        if (i < 30) {
            return UlughbegsaurusVariant.WHITE.getId();
        }
        if (i < 38) {
            return UlughbegsaurusVariant.YELLOW.getId();
        }
        if (UP2LoadedMods.isDyeDepotLoaded()) {
            if (i < 42) {
                return UlughbegsaurusVariant.NAVY.getId();
            }
            if (i < 52) {
                return UlughbegsaurusVariant.TAN.getId();
            }
            if (i < 62) {
                return UlughbegsaurusVariant.OLIVE.getId();
            }
        }
        return UlughbegsaurusVariant.BLUE.getId();
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag compoundTag) {
        this.setVariant(Ulughbegsaurus.getRandomNaturalColor(level.m_213780_()));
        if (level.m_213780_().m_188501_() < 0.01f) {
            this.setRainbow(true);
        }
        return super.m_6518_(level, difficulty, spawnType, spawnData, compoundTag);
    }

    public static boolean canSpawn(EntityType<Ulughbegsaurus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.ULUGHBEGSAURUS_SPAWNABLE_ON) && Ulughbegsaurus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class UlughbegsaurusAttackGoal
    extends AttackGoal {
        protected final Ulughbegsaurus ulughbegsaurus;

        public UlughbegsaurusAttackGoal(Ulughbegsaurus ulughbegsaurus) {
            super(ulughbegsaurus);
            this.ulughbegsaurus = ulughbegsaurus;
        }

        public void m_8037_() {
            LivingEntity target = this.ulughbegsaurus.m_5448_();
            if (target != null) {
                double distance = this.ulughbegsaurus.m_20280_((Entity)target);
                this.ulughbegsaurus.m_21391_((Entity)this.ulughbegsaurus.m_5448_(), 30.0f, 30.0f);
                this.ulughbegsaurus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
                if (this.ulughbegsaurus.getAttackState() == 1) {
                    this.ulughbegsaurus.m_21573_().m_5624_((Entity)target, 1.5);
                    this.tickBite();
                } else {
                    this.ulughbegsaurus.m_21573_().m_5624_((Entity)target, 1.7);
                    if (distance <= this.getAttackReachSqr(target) && this.ulughbegsaurus.attackCooldown == 0) {
                        this.ulughbegsaurus.setAttackState(1);
                    }
                }
            }
        }

        protected void tickBite() {
            ++this.timer;
            LivingEntity target = this.ulughbegsaurus.m_5448_();
            if (this.timer == 1) {
                this.ulughbegsaurus.attackAlt = this.ulughbegsaurus.m_217043_().m_188499_();
                this.ulughbegsaurus.m_20124_(UP2Poses.ATTACKING.get());
            }
            if (this.timer == 8) {
                this.ulughbegsaurus.m_5496_((SoundEvent)UP2SoundEvents.ULUGHBEGSAURUS_ATTACK.get(), 1.0f, 0.9f + this.ulughbegsaurus.m_217043_().m_188501_() * 0.2f);
            }
            if (this.timer == 10 && this.isInAttackRange(target, 1.8)) {
                this.ulughbegsaurus.m_7327_((Entity)target);
                this.ulughbegsaurus.m_6674_(InteractionHand.MAIN_HAND);
            }
            if (this.timer > 15) {
                this.timer = 0;
                this.ulughbegsaurus.m_20124_(Pose.STANDING);
                this.ulughbegsaurus.setAttackState(0);
            }
        }
    }

    private static class UlughbegsaurusBlinkGoal
    extends IdleAnimationGoal {
        private final Ulughbegsaurus ulughbegsaurus;

        public UlughbegsaurusBlinkGoal(Ulughbegsaurus ulughbegsaurus) {
            super(ulughbegsaurus, 20, 1, false, false);
            this.ulughbegsaurus = ulughbegsaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.ulughbegsaurus.blinkCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.ulughbegsaurus.blinkCooldown = 60 + this.ulughbegsaurus.m_217043_().m_188503_(60);
        }
    }

    private static class UlughbegsaurusShakeGoal
    extends IdleAnimationGoal {
        private final Ulughbegsaurus ulughbegsaurus;

        public UlughbegsaurusShakeGoal(Ulughbegsaurus ulughbegsaurus) {
            super(ulughbegsaurus, 80, 2, false);
            this.ulughbegsaurus = ulughbegsaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.ulughbegsaurus.shakeCooldown == 0 && !this.ulughbegsaurus.isSitting();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.ulughbegsaurus.shakeCooldown = 1000 + this.ulughbegsaurus.m_217043_().m_188503_(1000);
        }
    }

    private static class UlughbegsaurusYawnGoal
    extends IdleAnimationGoal {
        private final Ulughbegsaurus ulughbegsaurus;

        public UlughbegsaurusYawnGoal(Ulughbegsaurus ulughbegsaurus) {
            super(ulughbegsaurus, 60, 3, false);
            this.ulughbegsaurus = ulughbegsaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.ulughbegsaurus.yawnCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.ulughbegsaurus.yawnCooldown = 600 + this.ulughbegsaurus.m_217043_().m_188503_(600);
        }
    }

    public static enum UlughbegsaurusVariant {
        WHITE(0, (TagKey<Item>)Tags.Items.DYES_WHITE),
        LIGHT_GRAY(1, (TagKey<Item>)Tags.Items.DYES_LIGHT_GRAY),
        GRAY(2, (TagKey<Item>)Tags.Items.DYES_GRAY),
        BLACK(3, (TagKey<Item>)Tags.Items.DYES_BLACK),
        BROWN(4, (TagKey<Item>)Tags.Items.DYES_BROWN),
        RED(5, (TagKey<Item>)Tags.Items.DYES_RED),
        ORANGE(6, (TagKey<Item>)Tags.Items.DYES_ORANGE),
        YELLOW(7, (TagKey<Item>)Tags.Items.DYES_YELLOW),
        LIME(8, (TagKey<Item>)Tags.Items.DYES_LIME),
        GREEN(9, (TagKey<Item>)Tags.Items.DYES_GREEN),
        CYAN(10, (TagKey<Item>)Tags.Items.DYES_CYAN),
        LIGHT_BLUE(11, (TagKey<Item>)Tags.Items.DYES_LIGHT_BLUE),
        BLUE(12, (TagKey<Item>)Tags.Items.DYES_BLUE),
        PURPLE(13, (TagKey<Item>)Tags.Items.DYES_PURPLE),
        MAGENTA(14, (TagKey<Item>)Tags.Items.DYES_MAGENTA),
        PINK(15, (TagKey<Item>)Tags.Items.DYES_PINK),
        MAROON(16, UP2ItemTags.MAROON_DYES),
        ROSE(17, UP2ItemTags.ROSE_DYES),
        CORAL(18, UP2ItemTags.CORAL_DYES),
        GINGER(19, UP2ItemTags.GINGER_DYES),
        TAN(20, UP2ItemTags.TAN_DYES),
        BEIGE(21, UP2ItemTags.BEIGE_DYES),
        OLIVE(22, UP2ItemTags.OLIVE_DYES),
        AMBER(23, UP2ItemTags.AMBER_DYES),
        FOREST(24, UP2ItemTags.FOREST_DYES),
        VERDANT(25, UP2ItemTags.VERDANT_DYES),
        TEAL(26, UP2ItemTags.TEAL_DYES),
        AQUA(27, UP2ItemTags.AQUA_DYES),
        MINT(28, UP2ItemTags.MINT_DYES),
        NAVY(29, UP2ItemTags.NAVY_DYES),
        SLATE(30, UP2ItemTags.SLATE_DYES),
        INDIGO(31, UP2ItemTags.INDIGO_DYES);

        private final int id;
        private final TagKey<Item> dye;

        private UlughbegsaurusVariant(int id, TagKey<Item> dye) {
            this.id = id;
            this.dye = dye;
        }

        public int getId() {
            return this.id;
        }

        public TagKey<Item> getDye() {
            return this.dye;
        }

        public static UlughbegsaurusVariant byDye(ItemStack stack) {
            for (UlughbegsaurusVariant variant : UlughbegsaurusVariant.values()) {
                if (!stack.m_204117_(variant.getDye())) continue;
                return variant;
            }
            return null;
        }

        public static UlughbegsaurusVariant byId(int id) {
            if (id < 0 || id >= UlughbegsaurusVariant.values().length) {
                id = 0;
            }
            return UlughbegsaurusVariant.values()[id];
        }
    }
}


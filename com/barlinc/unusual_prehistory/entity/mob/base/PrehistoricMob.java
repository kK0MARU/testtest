/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.EntityTypeTags
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MoveFunction
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.TamableAnimal
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.gameevent.DynamicGameEventListener
 *  net.minecraft.world.level.gameevent.EntityPositionSource
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEventListener
 *  net.minecraft.world.level.gameevent.PositionSource
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.common.ForgeMod
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.base;

import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricBodyRotationControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricLookControl;
import com.barlinc.unusual_prehistory.entity.ai.control.PrehistoricMoveControl;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.utils.JukeboxListener;
import com.barlinc.unusual_prehistory.registry.UP2Criterion;
import com.barlinc.unusual_prehistory.registry.UP2Particles;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import com.mojang.datafixers.util.Pair;
import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;

public abstract class PrehistoricMob
extends TamableAnimal {
    protected static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    protected static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    protected static final EntityDataAccessor<Integer> PACIFIED_TICKS = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    protected static final EntityDataAccessor<Boolean> FROM_EGG = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    protected static final EntityDataAccessor<Boolean> SHOT_FROM_OOZE = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    protected static final EntityDataAccessor<Boolean> RUNNING = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    protected static final EntityDataAccessor<Integer> IDLE_STATE = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    protected static final EntityDataAccessor<Integer> EAT_COOLDOWN = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    protected static final EntityDataAccessor<Boolean> FOREVER_BABY = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    protected static final EntityDataAccessor<Integer> COMMAND = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    protected static final EntityDataAccessor<Boolean> DANCING = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    protected static final EntityDataAccessor<Integer> SIT_COOLDOWN = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    protected static final EntityDataAccessor<Integer> EEPY_COOLDOWN = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    protected static final EntityDataAccessor<Boolean> EEPY = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    protected static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData.m_135353_(PrehistoricMob.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    protected int eepyTicks;
    private BlockPos jukeboxPosition;
    private final DynamicGameEventListener<JukeboxListener> dynamicJukeboxListener;
    private float tailYaw;
    private float prevTailYaw;
    public final SmoothAnimationState idleAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState eepyStartAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState eepyAnimationState = new SmoothAnimationState(0.15f);
    public final SmoothAnimationState eepyEndAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState sitStartAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState sitAnimationState = new SmoothAnimationState(0.25f);
    public final SmoothAnimationState sitEndAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState danceAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState swimAnimationState = new SmoothAnimationState();

    protected PrehistoricMob(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new PrehistoricMoveControl(this);
        this.f_21365_ = new PrehistoricLookControl(this);
        EntityPositionSource source = new EntityPositionSource((Entity)this, this.m_20192_());
        this.dynamicJukeboxListener = new DynamicGameEventListener((GameEventListener)new JukeboxListener(this, (PositionSource)source, GameEvent.f_238690_.m_157827_()));
        this.tailYaw = this.m_146908_();
        this.prevTailYaw = this.m_146908_();
        this.m_21530_();
    }

    public int m_213860_() {
        return 0;
    }

    public boolean m_6149_() {
        return false;
    }

    public void strongKnockback(Entity entity, double horizontalStrength, double verticalStrength) {
        double x = entity.m_20185_() - this.m_20185_();
        double y = entity.m_20189_() - this.m_20189_();
        double scale = Math.max(x * x + y * y, 0.001);
        entity.m_5997_(x / scale * horizontalStrength, verticalStrength, y / scale * horizontalStrength);
    }

    public boolean m_6094_() {
        return !this.isEepy();
    }

    public void m_213651_(@NotNull BiConsumer<DynamicGameEventListener<?>, ServerLevel> consumer) {
        Level level;
        if (this.canDanceToJukebox() && (level = this.m_9236_()) instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            consumer.accept(this.dynamicJukeboxListener, serverlevel);
        }
    }

    public void danceToJukebox(BlockPos pos, boolean dancing) {
        if (dancing) {
            if (!this.isDancing()) {
                this.jukeboxPosition = pos;
                this.setDancing(true);
            }
        } else if (pos.equals((Object)this.jukeboxPosition)) {
            this.jukeboxPosition = null;
            this.setDancing(false);
        }
    }

    public boolean shouldStopDancing() {
        return this.m_21188_() != null || this.m_5448_() != null || this.m_217005_() || this.jukeboxPosition == null || !this.jukeboxPosition.m_203195_((Position)this.m_20182_(), (double)GameEvent.f_238690_.m_157827_()) || !this.m_9236_().m_8055_(this.jukeboxPosition).m_60713_(Blocks.f_50131_);
    }

    public boolean canDanceToJukebox() {
        return false;
    }

    @NotNull
    protected BodyRotationControl m_7560_() {
        return new PrehistoricBodyRotationControl(this);
    }

    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        return new NoSpinGroundPathNavigation((Mob)this, level);
    }

    public float m_5610_(@NotNull BlockPos pos, @NotNull LevelReader level) {
        return 0.0f;
    }

    public double m_20204_() {
        if (this.m_20069_() && this.f_19862_) {
            return super.m_20204_();
        }
        return 0.6 * (double)this.m_20206_();
    }

    protected void floatInWaterWhileRidden() {
        if (this.m_20160_() && this.m_204036_(FluidTags.f_13131_) > this.m_20204_()) {
            this.m_20256_(this.m_20184_().m_82520_(0.0, (double)0.04f, 0.0));
        }
    }

    public void floatWhileRidden(Vec3 travelVec) {
        if (this.m_20069_() || this.isInFluidType(this.getEyeInFluidType()) && !this.moveInFluid(this.m_9236_().m_6425_(BlockPos.m_274446_((Position)this.m_146892_())), travelVec, this.m_21133_((Attribute)ForgeMod.ENTITY_GRAVITY.get()))) {
            this.floatInWaterWhileRidden();
        }
    }

    public boolean m_5957_() {
        return false;
    }

    public boolean m_7848_(@NotNull Animal animal) {
        return false;
    }

    public boolean m_8023_() {
        return true;
    }

    public boolean m_6785_(double distanceToClosestPlayer) {
        return !this.m_8023_();
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.f_11912_;
    }

    public boolean isForeverBabyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.STOPS_MOB_AGING);
    }

    public boolean isPacifyItem(ItemStack itemStack) {
        return this.m_6898_(itemStack);
    }

    public boolean isPermanentPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PERMANENTLY_PACIFIES_MOB);
    }

    private void applyFoodEffects(ItemStack food, Level level, LivingEntity livingEntity) {
        Item item = food.m_41720_();
        if (item.m_41472_()) {
            for (Pair pair : food.getFoodProperties((LivingEntity)this).m_38749_()) {
                if (level.f_46443_ || pair.getFirst() == null || !(level.f_46441_.m_188501_() < ((Float)pair.getSecond()).floatValue())) continue;
                livingEntity.m_7292_(new MobEffectInstance((MobEffectInstance)pair.getFirst()));
            }
        }
    }

    protected void feedItemToMob(Player player, InteractionHand hand, ItemStack itemstack) {
        this.m_142075_(player, hand, itemstack);
        this.m_5496_(this.getEatingSound(), 1.0f, this.m_6100_());
        this.applyFoodEffects(itemstack, this.m_9236_(), (LivingEntity)this);
        this.m_146850_(GameEvent.f_157806_);
    }

    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        InteractionResult type = super.m_6071_(player, hand);
        if (this.m_6898_(itemstack) && this.m_6162_()) {
            this.feedItemToMob(player, hand, itemstack);
            this.m_146740_(PrehistoricMob.m_216967_((int)(-this.m_146764_())), true);
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        if (this.isForeverBabyItem(itemstack) && this.m_6162_()) {
            this.feedItemToMob(player, hand, itemstack);
            this.setForeverBaby(true);
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        if (this.canPacify()) {
            if (this.isPermanentPacifyItem(itemstack) && !this.isPacified() && !this.m_6162_()) {
                this.feedItemToMob(player, hand, itemstack);
                this.setPacifiedTicks(-1);
                this.m_9236_().m_7605_((Entity)this, (byte)10);
                if (player instanceof ServerPlayer) {
                    ServerPlayer serverPlayer = (ServerPlayer)player;
                    UP2Criterion.PACIFY_MOB_PERMANENT.trigger(serverPlayer);
                }
                return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
            }
            if (this.isPacifyItem(itemstack) && !this.isPacified() && !this.m_6162_()) {
                this.feedItemToMob(player, hand, itemstack);
                this.setPacifiedTicks(this.getPacifiedTicks() + this.pacifiedTicks());
                this.m_9236_().m_7605_((Entity)this, (byte)9);
                return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
            }
        }
        if (!type.m_19077_()) {
            return this.interactTameCommands(player, hand);
        }
        return type;
    }

    public InteractionResult interactTameCommands(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        if (this.m_21824_() && this.m_21830_((LivingEntity)player) && !this.m_6898_(itemstack)) {
            if (this.canOwnerCommand(player)) {
                this.setCommand(this.getCommand() + 1);
                if (this.getCommand() == 3) {
                    this.setCommand(0);
                }
                player.m_5661_((Component)Component.m_237110_((String)("entity.unusual_prehistory.all.command_" + this.getCommand()), (Object[])new Object[]{this.m_7755_()}), true);
                this.m_21839_(this.getCommand() == 1);
                return InteractionResult.SUCCESS;
            }
            if (this.canOwnerMount(player)) {
                if (!this.m_9236_().f_46443_ && player.m_20329_((Entity)this)) {
                    return InteractionResult.CONSUME;
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    public void m_7822_(byte id) {
        switch (id) {
            case 9: {
                this.spawnPacifyParticles(false);
                break;
            }
            case 10: {
                this.spawnPacifyParticles(true);
                break;
            }
            default: {
                super.m_7822_(id);
            }
        }
    }

    protected void spawnPacifyParticles(boolean permanent) {
        SimpleParticleType particleoptions = permanent ? (ParticleOptions)UP2Particles.GOLDEN_HEART.get() : ParticleTypes.f_123750_;
        for (int i = 0; i < 7; ++i) {
            double xspeed = this.f_19796_.m_188583_() * 0.02;
            double yspeed = this.f_19796_.m_188583_() * 0.08;
            double zspeed = this.f_19796_.m_188583_() * 0.02;
            this.m_9236_().m_7106_((ParticleOptions)particleoptions, this.m_20208_(1.0), this.m_20187_() + 0.5, this.m_20262_(1.0), xspeed, yspeed, zspeed);
        }
    }

    public void m_8119_() {
        super.m_8119_();
        this.tickTailYaw();
        this.tickCooldowns();
        if (this.m_9236_().f_46443_) {
            this.setupAnimationStates();
            if (this.shouldDoEepyParticles()) {
                this.doEepyParticles();
            }
        } else {
            if (this.canHealOverTime()) {
                this.m_5634_(2.0f);
            }
            if (this.f_19797_ % 20 == 0 && this.shouldStopDancing() && this.isDancing()) {
                this.setDancing(false);
                this.jukeboxPosition = null;
            }
        }
        if (this.isForeverBaby() && this.m_6162_()) {
            this.m_146762_(-24000);
        }
        if (this.m_21523_()) {
            this.m_183634_();
        }
        if (this.wasShotFromOoze()) {
            if (!(this.m_20096_() || this.m_20072_() || this.m_6147_())) {
                this.m_183634_();
            } else {
                this.setShotFromOoze(false);
            }
        }
        if (this.getPacifiedTicks() > 0) {
            this.setPacifiedTicks(this.getPacifiedTicks() - 1);
        }
    }

    public void tickCooldowns() {
        if (this.getEatCooldown() > 0 && this.canEat()) {
            this.setEatCooldown(this.getEatCooldown() - 1);
        }
        if (this.m_21188_() == null && this.m_5448_() == null && !this.m_20072_() && !this.m_6162_()) {
            if (this.getEepyCooldown() > 0) {
                this.setEepyCooldown(this.getEepyCooldown() - 1);
            }
            if (!this.isEepy() && this.getSitCooldown() > 0) {
                this.setSitCooldown(this.getSitCooldown() - 1);
            }
        }
    }

    public boolean canEat() {
        return true;
    }

    public void tickTailYaw() {
        this.prevTailYaw = this.tailYaw;
        this.tailYaw = Mth.m_14148_((float)this.tailYaw, (float)this.f_20883_, (float)8.0f);
    }

    public float getTailYaw(float partialTick) {
        return this.prevTailYaw + (this.tailYaw - this.prevTailYaw) * partialTick;
    }

    public void setupAnimationStates() {
    }

    public void m_267651_(boolean flying) {
        float pos = (float)Mth.m_184648_((double)(this.m_20185_() - this.f_19854_), (double)(this.m_20186_() - this.f_19855_), (double)(this.m_20189_() - this.f_19856_));
        float speed = Math.min(pos * this.getWalkAnimationSpeed(), 1.0f);
        this.f_267362_.m_267566_(speed, 0.4f);
    }

    public float getWalkAnimationSpeed() {
        return this.m_6162_() ? 3.0f : 10.0f;
    }

    public int getHealCooldown() {
        return this.isEepy() ? 100 : 200;
    }

    public boolean canHealOverTime() {
        return this.f_19797_ % this.getHealCooldown() == 0 && this.m_21223_() < this.m_21233_() && this.m_6084_();
    }

    public boolean refuseToMove() {
        return this.isEepy() || this.isSitting();
    }

    public boolean refuseToLook() {
        return this.isEepy() || this.isSitting();
    }

    protected void m_6475_(@NotNull DamageSource source, float amount) {
        if (this.isSitting() && !this.m_21827_()) {
            this.setSitting(false);
            this.setSitCooldown(400);
        } else if (this.isEepy()) {
            this.setEepy(false);
            this.setEatCooldown(400);
        }
        super.m_6475_(source, amount);
    }

    protected void m_7880_(float distance) {
        if (distance > 6.0f) {
            if (this.isSitting() && !this.m_21827_()) {
                this.setSitting(false);
                this.setSitCooldown(this.getSitCooldown() + 200);
            }
            if (this.isEepy()) {
                this.setEepy(false);
                this.setEepyCooldown(this.getEepyCooldown() + 200);
            }
        }
    }

    public boolean isEepyTime() {
        return this.m_9236_().m_46462_();
    }

    public void doEepyParticles() {
        Vec3 lookVec = this.getEepyParticleVec();
        Vec3 eyeVec = this.m_146892_().m_82549_(lookVec);
        if (this.eepyTicks == 0) {
            this.eepyTicks = 40 + this.f_19796_.m_188503_(20);
            this.m_9236_().m_7106_((ParticleOptions)UP2Particles.EEPY.get(), eyeVec.f_82479_, eyeVec.f_82480_ + (double)((1.0f - this.f_19796_.m_188501_()) * 0.3f), eyeVec.f_82481_, 1.0, 0.0, 0.0);
        }
        if (this.eepyTicks > 0) {
            --this.eepyTicks;
        }
    }

    public Vec3 getEepyParticleVec() {
        return new Vec3(0.0, 0.0, (double)(-this.m_20205_() * 1.7f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    public boolean shouldDoEepyParticles() {
        return this.isEepy();
    }

    public boolean m_7307_(@NotNull Entity entity) {
        if (this.m_21824_() && this.m_269323_() != null) {
            if (entity == this.m_269323_()) {
                return true;
            }
            if (entity instanceof TamableAnimal) {
                TamableAnimal tamableAnimal = (TamableAnimal)entity;
                return tamableAnimal.m_21830_(this.m_269323_());
            }
            return this.m_269323_().m_7307_(entity);
        }
        return super.m_7307_(entity);
    }

    public boolean canOwnerMount(Player player) {
        return false;
    }

    public boolean canOwnerCommand(Player ownerPlayer) {
        return false;
    }

    public boolean m_21825_() {
        return super.m_21825_() && !this.m_20160_() && !this.m_20159_();
    }

    protected void clampRotation(LivingEntity livingEntity, float clampRange) {
        livingEntity.m_5618_(this.m_146908_());
        float f = Mth.m_14177_((float)(livingEntity.m_146908_() - this.m_146908_()));
        float f1 = Mth.m_14036_((float)f, (float)(-clampRange), (float)clampRange);
        livingEntity.f_19859_ += f1 - f;
        livingEntity.f_20884_ += f1 - f;
        livingEntity.m_146922_(livingEntity.m_146908_() + f1 - f);
        livingEntity.m_5616_(livingEntity.m_146908_());
    }

    protected void m_20351_(@NotNull Entity passenger) {
        super.m_20351_(passenger);
        if (!this.m_9236_().f_46443_ && this.getCommand() == 1 && !this.isSitting()) {
            this.setSitting(true);
        }
    }

    @NotNull
    public Vec3 m_7688_(@NotNull LivingEntity livingEntity) {
        return new Vec3(this.m_20185_(), this.m_20191_().f_82289_, this.m_20189_());
    }

    /*
     * Enabled aggressive block sorting
     */
    public void m_19956_(@NotNull Entity passenger, @NotNull Entity.MoveFunction moveFunction) {
        if (this.m_20365_(passenger) && passenger instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)passenger;
            if (!this.m_146899_()) {
                Vec3 seatOffset = this.getRiderOffset().m_82524_((float)Math.toRadians(-this.f_20883_));
                passenger.m_5618_(this.f_20883_);
                passenger.f_19789_ = 0.0f;
                this.clampRotation(livingEntity, 105.0f);
                moveFunction.m_20372_(passenger, this.m_20185_() + seatOffset.f_82479_, this.m_20186_() + seatOffset.f_82480_ + this.m_6048_(), this.m_20189_() + seatOffset.f_82481_);
                return;
            }
        }
        super.m_19956_(passenger, moveFunction);
    }

    public Vec3 getRiderOffset() {
        return new Vec3(0.0, 0.0, 0.0);
    }

    public LivingEntity m_6688_() {
        Entity entity = this.m_146895_();
        if (entity instanceof Player) {
            Player player = (Player)entity;
            return player;
        }
        return null;
    }

    @NotNull
    protected Vec3 m_274312_(Player player, @NotNull Vec3 vec3) {
        float xxa = player.f_20900_ * 0.5f;
        float zza = player.f_20902_;
        if (zza <= 0.0f) {
            zza *= 0.25f;
        }
        return new Vec3((double)xxa, 0.0, (double)zza);
    }

    protected void m_274498_(@NotNull Player player, @NotNull Vec3 vec3) {
        super.m_274498_(player, vec3);
        if (player.f_20902_ > 0.0f) {
            if (this.isSitting()) {
                this.setSitting(false);
            }
            if (this.isEepy()) {
                this.setEepy(false);
            }
        }
        if (player.f_20902_ != 0.0f || player.f_20900_ != 0.0f) {
            this.m_19915_(player.m_146908_(), player.m_146909_() * 0.25f);
            this.m_5616_(player.m_6080_());
            this.m_6710_(null);
        }
    }

    public boolean m_142535_(float f1, float f2, @NotNull DamageSource source) {
        float[] ret = ForgeHooks.onLivingFall((LivingEntity)this, (float)f1, (float)f2);
        if (ret == null) {
            return false;
        }
        f1 = ret[0];
        f2 = ret[1];
        boolean flag = this.causeInternalFallDamage(f1, f2, source);
        int i = this.m_5639_(f1, f2);
        if (i > 0) {
            this.m_5496_(i > 4 ? this.m_196493_().f_196627_() : this.m_196493_().f_196626_(), 1.0f, 1.0f);
            this.m_21229_();
            this.m_6469_(source, i);
            return true;
        }
        return flag;
    }

    private boolean causeInternalFallDamage(float f1, float f2, DamageSource damageSource) {
        float[] livingFall = ForgeHooks.onLivingFall((LivingEntity)this, (float)f1, (float)f2);
        if (livingFall == null) {
            return false;
        }
        f1 = livingFall[0];
        f2 = livingFall[1];
        int i = this.m_5639_(f1, f2);
        if (i > 0) {
            this.m_21229_();
            this.m_6469_(damageSource, i);
            return true;
        }
        return this.m_6095_().m_204039_(EntityTypeTags.f_273841_);
    }

    public boolean canPlayAmbientSound() {
        return !this.isEepy();
    }

    public void m_8032_() {
        SoundEvent soundevent = this.m_7515_();
        if (soundevent != null && this.canPlayAmbientSound()) {
            this.m_5496_(soundevent, this.m_6121_(), this.m_6100_());
        }
    }

    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (EEPY.equals(accessor)) {
            this.m_6210_();
        } else if (SITTING.equals(accessor)) {
            this.m_6210_();
        }
        super.m_7350_(accessor);
    }

    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(VARIANT, (Object)0);
        this.f_19804_.m_135372_(ATTACK_STATE, (Object)0);
        this.f_19804_.m_135372_(PACIFIED_TICKS, (Object)0);
        this.f_19804_.m_135372_(FROM_EGG, (Object)false);
        this.f_19804_.m_135372_(SHOT_FROM_OOZE, (Object)false);
        this.f_19804_.m_135372_(RUNNING, (Object)false);
        this.f_19804_.m_135372_(IDLE_STATE, (Object)0);
        this.f_19804_.m_135372_(EAT_COOLDOWN, (Object)(600 + this.f_19796_.m_188503_(2400)));
        this.f_19804_.m_135372_(FOREVER_BABY, (Object)false);
        this.f_19804_.m_135372_(SIT_COOLDOWN, (Object)(6000 + this.f_19796_.m_188503_(3000)));
        this.f_19804_.m_135372_(EEPY_COOLDOWN, (Object)100);
        this.f_19804_.m_135372_(COMMAND, (Object)0);
        this.f_19804_.m_135372_(DANCING, (Object)false);
        this.f_19804_.m_135372_(EEPY, (Object)false);
        this.f_19804_.m_135372_(SITTING, (Object)false);
    }

    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("Variant", this.getVariant());
        compoundTag.m_128405_("PacifiedTicks", this.getPacifiedTicks());
        compoundTag.m_128379_("FromEgg", this.isFromEgg());
        compoundTag.m_128405_("EatCooldown", this.getEatCooldown());
        compoundTag.m_128379_("ForeverBaby", this.isForeverBaby());
        compoundTag.m_128405_("SitCooldown", this.getSitCooldown());
        compoundTag.m_128405_("EepyCooldown", this.getEepyCooldown());
        compoundTag.m_128405_("Command", this.getCommand());
        compoundTag.m_128379_("Eepy", this.isEepy());
        compoundTag.m_128379_("Sitting", this.isSitting());
    }

    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setVariant(compoundTag.m_128451_("Variant"));
        this.setPacifiedTicks(compoundTag.m_128451_("PacifiedTicks"));
        this.setFromEgg(compoundTag.m_128471_("FromEgg"));
        this.setEatCooldown(compoundTag.m_128451_("EatCooldown"));
        this.setForeverBaby(compoundTag.m_128471_("ForeverBaby"));
        this.setSitCooldown(compoundTag.m_128451_("SitCooldown"));
        this.setEepyCooldown(compoundTag.m_128451_("EepyCooldown"));
        this.setCommand(compoundTag.m_128451_("Command"));
        this.setEepy(compoundTag.m_128471_("Eepy"));
        this.setSitting(compoundTag.m_128471_("Sitting"));
    }

    public int getAttackState() {
        return (Integer)this.f_19804_.m_135370_(ATTACK_STATE);
    }

    public void setAttackState(int attackState) {
        this.f_19804_.m_135381_(ATTACK_STATE, (Object)attackState);
    }

    public int getIdleState() {
        return (Integer)this.f_19804_.m_135370_(IDLE_STATE);
    }

    public void setIdleState(int idleState) {
        this.f_19804_.m_135381_(IDLE_STATE, (Object)idleState);
    }

    public int getVariant() {
        return (Integer)this.f_19804_.m_135370_(VARIANT);
    }

    public void setVariant(int variant) {
        this.f_19804_.m_135381_(VARIANT, (Object)Mth.m_14045_((int)variant, (int)0, (int)this.getVariantCount()));
    }

    public int getVariantCount() {
        return 128;
    }

    public boolean canPacify() {
        return false;
    }

    public int pacifiedTicks() {
        return 1500 + this.m_217043_().m_188503_(1500);
    }

    public boolean isPacified() {
        return this.getPacifiedTicks() > 0 || this.getPacifiedTicks() <= -1;
    }

    public int getPacifiedTicks() {
        return (Integer)this.f_19804_.m_135370_(PACIFIED_TICKS);
    }

    public void setPacifiedTicks(int ticks) {
        this.f_19804_.m_135381_(PACIFIED_TICKS, (Object)ticks);
    }

    public boolean isFromEgg() {
        return (Boolean)this.f_19804_.m_135370_(FROM_EGG);
    }

    public void setFromEgg(boolean fromEgg) {
        this.f_19804_.m_135381_(FROM_EGG, (Object)fromEgg);
    }

    public boolean wasShotFromOoze() {
        return (Boolean)this.f_19804_.m_135370_(SHOT_FROM_OOZE);
    }

    public void setShotFromOoze(boolean shotFromOoze) {
        this.f_19804_.m_135381_(SHOT_FROM_OOZE, (Object)shotFromOoze);
    }

    public boolean isRunning() {
        return (Boolean)this.f_19804_.m_135370_(RUNNING);
    }

    public void setRunning(boolean running) {
        this.f_19804_.m_135381_(RUNNING, (Object)running);
    }

    public int getEatCooldown() {
        return (Integer)this.f_19804_.m_135370_(EAT_COOLDOWN);
    }

    public void setEatCooldown(int cooldown) {
        this.f_19804_.m_135381_(EAT_COOLDOWN, (Object)cooldown);
    }

    public boolean isForeverBaby() {
        return (Boolean)this.f_19804_.m_135370_(FOREVER_BABY);
    }

    public void setForeverBaby(boolean foreverBaby) {
        this.f_19804_.m_135381_(FOREVER_BABY, (Object)foreverBaby);
    }

    public int getSitCooldown() {
        return (Integer)this.f_19804_.m_135370_(SIT_COOLDOWN);
    }

    public void setSitCooldown(int cooldown) {
        this.f_19804_.m_135381_(SIT_COOLDOWN, (Object)cooldown);
    }

    public boolean isSitting() {
        return (Boolean)this.f_19804_.m_135370_(SITTING);
    }

    public void setSitting(boolean sitting) {
        this.f_19804_.m_135381_(SITTING, (Object)sitting);
    }

    public int getEepyCooldown() {
        return (Integer)this.f_19804_.m_135370_(EEPY_COOLDOWN);
    }

    public void setEepyCooldown(int cooldown) {
        this.f_19804_.m_135381_(EEPY_COOLDOWN, (Object)cooldown);
    }

    public boolean isEepy() {
        return (Boolean)this.f_19804_.m_135370_(EEPY);
    }

    public void setEepy(boolean eepy) {
        this.f_19804_.m_135381_(EEPY, (Object)eepy);
    }

    public int getCommand() {
        return (Integer)this.f_19804_.m_135370_(COMMAND);
    }

    public void setCommand(int command) {
        this.f_19804_.m_135381_(COMMAND, (Object)command);
    }

    public boolean isFollowingOwner() {
        return this.getCommand() == 2;
    }

    public boolean isDancing() {
        return (Boolean)this.f_19804_.m_135370_(DANCING);
    }

    public void setDancing(boolean dancing) {
        this.f_19804_.m_135381_(DANCING, (Object)dancing);
    }
}


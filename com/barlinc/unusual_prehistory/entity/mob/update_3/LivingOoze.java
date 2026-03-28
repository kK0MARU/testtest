/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ItemParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.players.OldUsersConverter
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.animal.Bucketable
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.ItemUtils
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.entity.EntityTypeTest
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.registries.ForgeRegistries
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.update_3;

import com.barlinc.unusual_prehistory.entity.ai.control.LivingOozeMoveControl;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.items.EmbryoItem;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class LivingOoze
extends PathfinderMob
implements Bucketable {
    private static final EntityDataAccessor<Integer> SPIT_TIME = SynchedEntityData.m_135353_(LivingOoze.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Boolean> HAS_CONTAINED_ENTITY = SynchedEntityData.m_135353_(LivingOoze.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<String> CONTAINED_ENTITY_TYPE = SynchedEntityData.m_135353_(LivingOoze.class, (EntityDataSerializer)EntityDataSerializers.f_135030_);
    private static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.m_135353_(LivingOoze.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Boolean> WANTS_TO_JUMP = SynchedEntityData.m_135353_(LivingOoze.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Boolean> HAS_JUMPED = SynchedEntityData.m_135353_(LivingOoze.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    private static final EntityDataAccessor<Integer> SAD_TIME = SynchedEntityData.m_135353_(LivingOoze.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Integer> PICKUP_COOLDOWN = SynchedEntityData.m_135353_(LivingOoze.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    protected static final EntityDataAccessor<Optional<UUID>> OWNER_UUID = SynchedEntityData.m_135353_(LivingOoze.class, (EntityDataSerializer)EntityDataSerializers.f_135041_);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.m_135353_(LivingOoze.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public final SmoothAnimationState processingAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState spittingAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState cooldownAnimationState = new SmoothAnimationState();
    private int spittingTicks;
    private float squishProgress;
    private float prevSquishProgress;
    private float jumpProgress;
    private float prevJumpProgress;
    private float jiggleTime;
    private float prevJiggleTime;

    public LivingOoze(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new LivingOozeMoveControl(this);
        this.m_21441_(BlockPathTypes.WATER, 0.0f);
        this.m_21441_(BlockPathTypes.WATER_BORDER, 0.0f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new LivingOozeRandomDirectionGoal(this));
        this.f_21345_.m_25352_(1, (Goal)new LivingOozeKeepOnJumpingGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22279_, (double)0.3f);
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.m_20089_() == UP2Poses.SPITTING.get()) {
            this.m_21573_().m_26573_();
            travelVec = Vec3.f_82478_;
        }
        super.m_7023_(travelVec);
    }

    public boolean m_6063_() {
        return false;
    }

    public boolean m_6040_() {
        return true;
    }

    public float m_6108_() {
        return 0.9f;
    }

    public boolean m_142535_(float fallDistance, float multiplier, @NotNull DamageSource damageSource) {
        return false;
    }

    protected void m_7840_(double y, boolean onGround, @NotNull BlockState state, @NotNull BlockPos pos) {
    }

    protected void m_6475_(@NotNull DamageSource damageSource, float amount) {
        this.setSadTime(10);
        super.m_6475_(damageSource, amount);
    }

    public void m_8119_() {
        super.m_8119_();
        if (this.getSpitTime() > 0) {
            this.setSpitTime(this.getSpitTime() - 1);
        }
        if (this.getCooldown() > 0) {
            this.setCooldown(this.getCooldown() - 1);
        }
        if (this.getSpitTime() == 35) {
            this.m_20124_(UP2Poses.SPITTING.get());
        }
        if (this.spittingTicks > 0) {
            --this.spittingTicks;
        }
        if (this.spittingTicks == 0 && this.m_20089_() == UP2Poses.SPITTING.get()) {
            this.m_20124_(Pose.STANDING);
        }
        if (this.getSadTime() > 0) {
            this.setSadTime(this.getSadTime() - 1);
        }
        if (this.getPickupCooldown() > 0) {
            this.setPickupCooldown(this.getPickupCooldown() - 1);
        }
        if (this.getSpitTime() == 2 && this.hasEntity()) {
            if (!this.m_9236_().f_46443_) {
                this.spawnMob();
            }
            this.m_246865_(new Vec3(0.0, 0.25, 0.0));
            this.m_246865_(this.m_20154_().m_82490_(2.0).m_82542_(-0.4, 0.0, -0.4));
            this.spawnSpitParticles();
            this.m_5496_((SoundEvent)UP2SoundEvents.LIVING_OOZE_SPIT.get(), 1.5f, this.getSoundPitch());
        }
        if (this.m_9236_().f_46443_) {
            this.setupAnimationStates();
        }
        this.tickSquish();
        if (this.f_19797_ % 20 == 0 && this.m_21205_().m_41619_() && this.getPickupCooldown() == 0 && this.getCooldown() == 0) {
            this.tickItemAbsorption();
        }
        if (this.f_19797_ % 100 == 0 && this.m_21223_() < this.m_21233_()) {
            this.m_5634_(2.0f);
        }
    }

    public void setupAnimationStates() {
        this.processingAnimationState.m_246184_(this.hasEntity() && this.m_20089_() != UP2Poses.SPITTING.get(), this.f_19797_);
        this.cooldownAnimationState.m_246184_(this.getCooldown() > 0 && this.m_20089_() != UP2Poses.SPITTING.get(), this.f_19797_);
        this.spittingAnimationState.m_246184_(this.spittingAnimationState.m_216984_(), this.f_19797_);
    }

    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (f_19806_.equals(accessor)) {
            if (this.m_20089_() == UP2Poses.SPITTING.get()) {
                this.spittingAnimationState.m_216977_(this.f_19797_);
                this.spittingTicks = 35;
            } else {
                this.spittingAnimationState.m_216973_();
            }
        }
        super.m_7350_(accessor);
    }

    protected float m_21519_(@NotNull EquipmentSlot slot) {
        return 0.0f;
    }

    protected void m_5907_() {
        ItemStack itemstack = this.m_6844_(EquipmentSlot.MAINHAND);
        if (!itemstack.m_41619_()) {
            this.m_19983_(itemstack);
            this.m_8061_(EquipmentSlot.MAINHAND, ItemStack.f_41583_);
        }
    }

    public int processingTime(RandomSource random) {
        return random.m_216339_(3600, 12000);
    }

    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        if (this.m_6084_() && this.m_6844_(EquipmentSlot.MAINHAND).m_41619_() && !itemstack.m_41619_() && this.getCooldown() == 0 && (!itemstack.m_150930_(Items.f_42446_) || player.m_6047_())) {
            Item item = itemstack.m_41720_();
            if (item instanceof EmbryoItem) {
                EmbryoItem embryoItem = (EmbryoItem)item;
                ResourceLocation mobType = ForgeRegistries.ENTITY_TYPES.getKey(embryoItem.toSpawn.get());
                if (mobType != null) {
                    this.setContainedEntityType(mobType.toString());
                    this.setHasEntity(true);
                    this.setSpitTime(this.processingTime(this.m_9236_().m_213780_()));
                    this.setOwnerUUID(player.m_20148_());
                }
            }
            this.m_8061_(EquipmentSlot.MAINHAND, itemstack.m_41620_(1));
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        if (itemstack.m_41720_() == Items.f_42446_ && this.m_6084_() && !player.m_6047_()) {
            this.m_5496_(this.m_142623_(), 1.0f, 1.0f);
            ItemStack bucketStack = this.m_28282_();
            this.m_6872_(bucketStack);
            ItemStack filledBucketStack = ItemUtils.m_41817_((ItemStack)itemstack, (Player)player, (ItemStack)bucketStack, (boolean)false);
            player.m_21008_(hand, filledBucketStack);
            if (!this.m_9236_().f_46443_) {
                CriteriaTriggers.f_10576_.m_38772_((ServerPlayer)player, bucketStack);
            }
            this.m_146870_();
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        if (!this.m_6844_(EquipmentSlot.MAINHAND).m_41619_() && itemstack.m_41619_()) {
            this.m_5907_();
            this.setContainedEntityType("minecraft:pig");
            this.setHasEntity(false);
            this.setSpitTime(-1);
            this.setPickupCooldown(40);
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        if (this.m_9236_().f_46443_) {
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    public int cooldown(RandomSource random) {
        return random.m_216339_(1200, 2400);
    }

    public void spawnMob() {
        EntityType type = (EntityType)ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(this.getContainedEntityType()));
        if (type != null) {
            Entity entity = type.m_20615_(this.m_9236_());
            UUID owner = this.getOwnerUUID();
            if (entity instanceof Mob) {
                Mob mob = (Mob)entity;
                if (mob instanceof PrehistoricMob) {
                    PrehistoricMob prehistoricMob = (PrehistoricMob)mob;
                    prehistoricMob.m_146762_(-24000);
                    prehistoricMob.setFromEgg(true);
                    prehistoricMob.setShotFromOoze(true);
                }
                Vec3 shootingVec = this.m_20154_().m_82490_(1.2).m_82542_(0.25, 1.0, 0.25);
                this.spitMob(mob, shootingVec.m_7096_(), 0.2f, shootingVec.m_7094_(), 0.6f, 15.0f);
                this.setCooldown(this.cooldown(this.m_9236_().m_213780_()));
                if (this.m_9236_().m_7967_((Entity)mob)) {
                    Player player;
                    ForgeEventFactory.onFinalizeSpawn((Mob)mob, (ServerLevelAccessor)((ServerLevel)this.m_9236_()), (DifficultyInstance)this.m_9236_().m_6436_(this.m_20183_()), (MobSpawnType)MobSpawnType.NATURAL, null, null);
                    this.setHasEntity(false);
                    this.setContainedEntityType("minecraft:pig");
                    this.m_8061_(EquipmentSlot.MAINHAND, ItemStack.f_41583_);
                    this.setOwnerUUID(null);
                    if (owner != null && (player = this.m_9236_().m_46003_(owner)) instanceof ServerPlayer) {
                        ServerPlayer serverPlayer = (ServerPlayer)player;
                        CriteriaTriggers.f_10580_.m_68256_(serverPlayer, entity);
                    }
                }
            }
        }
    }

    private Vec3 getMouthVec() {
        Vec3 vec3 = new Vec3(0.0, (double)(this.m_20206_() * 0.7f), (double)(this.m_20205_() * 0.5f)).m_82496_(this.m_146909_() * ((float)Math.PI / 180)).m_82524_(-this.m_146908_() * ((float)Math.PI / 180));
        return this.m_20182_().m_82549_(vec3);
    }

    public void spitMob(Mob mob, double x, double y, double z, float velocity, float inaccuracy) {
        Vec3 movement = new Vec3(x, y, z).m_82541_().m_82520_(mob.m_217043_().m_216328_(0.0, 0.0172275 * (double)inaccuracy), mob.m_217043_().m_216328_(0.0, 0.0172275 * (double)inaccuracy), mob.m_217043_().m_216328_(0.0, 0.0172275 * (double)inaccuracy)).m_82490_((double)velocity);
        mob.m_146884_(this.getMouthVec());
        mob.m_20256_(movement);
        double horizontalDistance = movement.m_165924_();
        mob.m_146922_((float)(Mth.m_14136_((double)movement.f_82479_, (double)movement.f_82481_) * 57.2957763671875));
        mob.m_146926_((float)(Mth.m_14136_((double)movement.f_82480_, (double)horizontalDistance) * 57.2957763671875));
        mob.f_19859_ = this.m_146908_();
        mob.f_19860_ = this.m_146909_();
        mob.f_19864_ = true;
    }

    private void tickSquish() {
        boolean squish;
        this.prevJumpProgress = this.jumpProgress;
        this.prevSquishProgress = this.squishProgress;
        this.prevJiggleTime = this.jiggleTime;
        boolean jumping = !this.m_20096_() && this.f_19797_ > 4;
        boolean bl = squish = !jumping && (this.wantsToJump() || this.hasJumped() && this.m_20096_());
        if (jumping && this.jumpProgress < 3.0f) {
            this.jumpProgress += 1.0f;
        }
        if (!jumping && this.jumpProgress > 0.0f) {
            this.jumpProgress -= 1.0f;
        }
        if (squish && this.squishProgress < 5.0f) {
            this.squishProgress += 1.0f;
            if (this.squishProgress >= 5.0f) {
                this.setHasJumped(false);
            }
        }
        if (!squish && this.squishProgress > 0.0f) {
            this.squishProgress -= 1.0f;
        }
        if (this.hasJumped() && this.m_20096_()) {
            this.jiggleTime = 5.0f;
        } else if (this.jiggleTime > 0.0f) {
            if (this.jiggleTime == 4.0f) {
                this.m_5496_(this.getSquishSound(), this.m_6121_(), this.getSoundPitch());
            }
            if (this.jiggleTime > 4.0f) {
                this.spawnJumpParticles();
            }
            this.jiggleTime -= 1.0f;
        }
    }

    private void tickItemAbsorption() {
        boolean canAbsorb;
        boolean bl = canAbsorb = !this.m_9236_().f_46443_ && this.m_6084_() && this.m_9236_().m_46469_().m_46207_(GameRules.f_46132_);
        if (canAbsorb) {
            if (!this.m_21205_().m_41619_()) {
                return;
            }
            AABB boundingBox = this.m_20191_();
            List items = this.m_9236_().m_142425_((EntityTypeTest)EntityType.f_20461_, boundingBox, item -> item.m_6084_() && !item.m_6087_() && !item.m_32055_().m_41619_());
            items.stream().filter(item -> !item.m_32055_().m_204117_(UP2ItemTags.LIVING_OOZE_CANNOT_ABSORB)).findFirst().ifPresent(item -> {
                ItemStack stack = item.m_32055_();
                ItemStack absorbedStack = stack.m_41620_(1);
                Item patt16695$temp = absorbedStack.m_41720_();
                if (patt16695$temp instanceof EmbryoItem) {
                    EmbryoItem embryoItem = (EmbryoItem)patt16695$temp;
                    ResourceLocation mobType = ForgeRegistries.ENTITY_TYPES.getKey(embryoItem.toSpawn.get());
                    if (mobType != null) {
                        this.setContainedEntityType(mobType.toString());
                        this.setHasEntity(true);
                        this.setSpitTime(this.processingTime(this.m_9236_().m_213780_()));
                    }
                }
                this.m_21008_(InteractionHand.MAIN_HAND, absorbedStack);
                this.setPickupCooldown(20);
                this.m_5496_(SoundEvents.f_12019_, 0.1f, this.getSoundPitch());
                if (stack.m_41619_()) {
                    item.m_146870_();
                }
            });
        }
    }

    public float getJiggleTime(float partialTick) {
        return (this.prevJiggleTime + (this.jiggleTime - this.prevJiggleTime) * partialTick) * 0.2f;
    }

    public float getJumpProgress(float partialTick) {
        return (this.prevJumpProgress + (this.jumpProgress - this.prevJumpProgress) * partialTick) * 0.33f;
    }

    public float getSquishProgress(float partialTick) {
        return (this.prevSquishProgress + (this.squishProgress - this.prevSquishProgress) * partialTick) * 0.2f;
    }

    private void spawnJumpParticles() {
        for (int j = 0; j < 6; ++j) {
            float f = this.f_19796_.m_188501_() * ((float)Math.PI * 2);
            float f1 = this.f_19796_.m_188501_() * 0.5f + 0.5f;
            float f2 = Mth.m_14031_((float)f) * 2.0f * 0.5f * f1;
            float f3 = Mth.m_14089_((float)f) * 2.0f * 0.5f * f1;
            this.m_9236_().m_7106_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, ((Item)UP2Items.ORGANIC_OOZE.get()).m_7968_()), this.m_20185_() + (double)f2, this.m_20186_(), this.m_20189_() + (double)f3, 0.0, 0.0, 0.0);
        }
    }

    private void spawnSpitParticles() {
        for (int j = 0; j < 10; ++j) {
            Vec3 shootingVec = this.m_20154_().m_82490_(0.6);
            this.m_9236_().m_7106_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, ((Item)UP2Items.ORGANIC_OOZE.get()).m_7968_()), this.getMouthVec().m_7096_() + (double)(this.m_217043_().m_188501_() * 0.7f), this.getMouthVec().m_7098_() + (double)(this.m_217043_().m_188501_() * 0.7f), this.getMouthVec().m_7094_() + (double)(this.m_217043_().m_188501_() * 0.7f), shootingVec.m_7096_() * (double)this.m_217043_().m_188501_() * (double)0.6f, shootingVec.m_7098_() * (double)this.m_217043_().m_188501_() * (double)0.6f, shootingVec.m_7094_() * (double)this.m_217043_().m_188501_() * (double)0.6f);
        }
    }

    public int m_8132_() {
        return 0;
    }

    protected void m_6135_() {
        Vec3 vec3 = this.m_20184_();
        this.m_20334_(vec3.f_82479_, this.m_6118_(), vec3.f_82481_);
        this.f_19812_ = true;
    }

    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.LIVING_OOZE_HURT.get();
    }

    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.LIVING_OOZE_DEATH.get();
    }

    protected SoundEvent getSquishSound() {
        return (SoundEvent)UP2SoundEvents.LIVING_OOZE_SQUISH.get();
    }

    public SoundEvent getJumpSound() {
        return (SoundEvent)UP2SoundEvents.LIVING_OOZE_JUMP.get();
    }

    public float getSoundPitch() {
        return ((this.f_19796_.m_188501_() - this.f_19796_.m_188501_()) * 0.2f + 1.0f) / 0.8f;
    }

    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(CONTAINED_ENTITY_TYPE, (Object)"minecraft:pig");
        this.f_19804_.m_135372_(HAS_CONTAINED_ENTITY, (Object)false);
        this.f_19804_.m_135372_(SPIT_TIME, (Object)-1);
        this.f_19804_.m_135372_(WANTS_TO_JUMP, (Object)false);
        this.f_19804_.m_135372_(HAS_JUMPED, (Object)false);
        this.f_19804_.m_135372_(COOLDOWN, (Object)0);
        this.f_19804_.m_135372_(SAD_TIME, (Object)0);
        this.f_19804_.m_135372_(PICKUP_COOLDOWN, (Object)0);
        this.f_19804_.m_135372_(OWNER_UUID, Optional.empty());
        this.f_19804_.m_135372_(FROM_BUCKET, (Object)false);
    }

    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("SpitTime", this.getSpitTime());
        compoundTag.m_128359_("ContainedEntityType", this.getContainedEntityType());
        compoundTag.m_128379_("HasContainedEntity", this.hasEntity());
        compoundTag.m_128405_("Cooldown", this.getCooldown());
        if (this.getOwnerUUID() != null) {
            compoundTag.m_128362_("Owner", this.getOwnerUUID());
        }
        compoundTag.m_128379_("FromBucket", this.m_27487_());
        compoundTag.m_128405_("Cooldown", this.getCooldown());
    }

    public void m_7378_(@NotNull CompoundTag compoundTag) {
        UUID uuid;
        super.m_7378_(compoundTag);
        this.setSpitTime(compoundTag.m_128451_("SpitTime"));
        this.setContainedEntityType(compoundTag.m_128461_("ContainedEntityType"));
        this.setHasEntity(compoundTag.m_128471_("HasContainedEntity"));
        this.setCooldown(compoundTag.m_128451_("Cooldown"));
        this.m_27497_(compoundTag.m_128471_("FromBucket"));
        if (compoundTag.m_128403_("Owner")) {
            uuid = compoundTag.m_128342_("Owner");
        } else {
            String s = compoundTag.m_128461_("Owner");
            uuid = OldUsersConverter.m_11083_((MinecraftServer)this.m_20194_(), (String)s);
        }
        if (uuid != null) {
            try {
                this.setOwnerUUID(uuid);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    public String getContainedEntityType() {
        return (String)this.f_19804_.m_135370_(CONTAINED_ENTITY_TYPE);
    }

    public void setContainedEntityType(String containedEntityType) {
        this.f_19804_.m_135381_(CONTAINED_ENTITY_TYPE, (Object)containedEntityType);
    }

    public boolean hasEntity() {
        return (Boolean)this.f_19804_.m_135370_(HAS_CONTAINED_ENTITY);
    }

    public void setHasEntity(boolean hasEntity) {
        this.f_19804_.m_135381_(HAS_CONTAINED_ENTITY, (Object)hasEntity);
    }

    public int getSpitTime() {
        return (Integer)this.f_19804_.m_135370_(SPIT_TIME);
    }

    public void setSpitTime(int time) {
        this.f_19804_.m_135381_(SPIT_TIME, (Object)time);
    }

    public void setWantsToJump(boolean wantsToJump) {
        this.f_19804_.m_135381_(WANTS_TO_JUMP, (Object)wantsToJump);
    }

    public boolean wantsToJump() {
        return (Boolean)this.f_19804_.m_135370_(WANTS_TO_JUMP);
    }

    public void setHasJumped(boolean hasJumped) {
        this.f_19804_.m_135381_(HAS_JUMPED, (Object)hasJumped);
    }

    public boolean hasJumped() {
        return (Boolean)this.f_19804_.m_135370_(HAS_JUMPED);
    }

    public int getCooldown() {
        return (Integer)this.f_19804_.m_135370_(COOLDOWN);
    }

    public void setCooldown(int cooldown) {
        this.f_19804_.m_135381_(COOLDOWN, (Object)cooldown);
    }

    public int getSadTime() {
        return (Integer)this.f_19804_.m_135370_(SAD_TIME);
    }

    public void setSadTime(int time) {
        this.f_19804_.m_135381_(SAD_TIME, (Object)time);
    }

    public int getPickupCooldown() {
        return (Integer)this.f_19804_.m_135370_(PICKUP_COOLDOWN);
    }

    public void setPickupCooldown(int cooldown) {
        this.f_19804_.m_135381_(PICKUP_COOLDOWN, (Object)cooldown);
    }

    @Nullable
    public UUID getOwnerUUID() {
        return ((Optional)this.f_19804_.m_135370_(OWNER_UUID)).orElse(null);
    }

    public void setOwnerUUID(@Nullable UUID uuid) {
        this.f_19804_.m_135381_(OWNER_UUID, Optional.ofNullable(uuid));
    }

    public boolean m_27487_() {
        return (Boolean)this.f_19804_.m_135370_(FROM_BUCKET);
    }

    public void m_27497_(boolean fromBucket) {
        this.f_19804_.m_135381_(FROM_BUCKET, (Object)fromBucket);
    }

    public void m_6872_(@NotNull ItemStack bucket) {
        Bucketable.m_148822_((Mob)this, (ItemStack)bucket);
        if (this.m_8077_()) {
            bucket.m_41714_(this.m_7770_());
        }
        CompoundTag compoundTag = bucket.m_41784_();
        this.m_7380_(compoundTag);
    }

    public void m_142278_(@NotNull CompoundTag compoundTag) {
        Bucketable.m_148825_((Mob)this, (CompoundTag)compoundTag);
        this.m_7378_(compoundTag);
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.LIVING_OOZE_BUCKET.get());
    }

    @NotNull
    public SoundEvent m_142623_() {
        return SoundEvents.f_12392_;
    }

    private static class LivingOozeRandomDirectionGoal
    extends Goal {
        private final LivingOoze ooze;
        private float chosenDegrees;
        private int nextRandomizeTime;

        public LivingOozeRandomDirectionGoal(LivingOoze ooze) {
            this.ooze = ooze;
            this.m_7021_(EnumSet.of(Goal.Flag.LOOK));
        }

        public boolean m_8036_() {
            return this.ooze.m_20089_() != UP2Poses.SPITTING.get() && this.ooze.m_5448_() == null && (this.ooze.m_20096_() || this.ooze.m_20069_() || this.ooze.m_20077_() || this.ooze.m_21023_(MobEffects.f_19620_)) && this.ooze.m_21566_() instanceof LivingOozeMoveControl;
        }

        public void m_8037_() {
            MoveControl moveControl;
            if (--this.nextRandomizeTime <= 0) {
                this.nextRandomizeTime = this.m_183277_(40 + this.ooze.m_217043_().m_188503_(60));
                this.chosenDegrees = this.ooze.m_217043_().m_188503_(360);
            }
            if ((moveControl = this.ooze.m_21566_()) instanceof LivingOozeMoveControl) {
                LivingOozeMoveControl moveControl2 = (LivingOozeMoveControl)moveControl;
                moveControl2.setDirection(this.chosenDegrees);
            }
        }
    }

    private static class LivingOozeKeepOnJumpingGoal
    extends Goal {
        private final LivingOoze ooze;

        public LivingOozeKeepOnJumpingGoal(LivingOoze ooze) {
            this.ooze = ooze;
            this.m_7021_(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        public boolean m_8036_() {
            return !this.ooze.m_20159_() && this.ooze.m_20089_() != UP2Poses.SPITTING.get();
        }

        public void m_8037_() {
            MoveControl moveControl = this.ooze.m_21566_();
            if (moveControl instanceof LivingOozeMoveControl) {
                LivingOozeMoveControl moveControl2 = (LivingOozeMoveControl)moveControl;
                moveControl2.setWantedMovement(1.0);
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Container
 *  net.minecraft.world.ContainerListener
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.SimpleContainer
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.AbstractArrow
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.common.ToolActions
 *  net.minecraftforge.common.capabilities.Capability
 *  net.minecraftforge.common.capabilities.ForgeCapabilities
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.event.entity.player.PlayerContainerEvent$Open
 *  net.minecraftforge.eventbus.api.Event
 *  net.minecraftforge.items.wrapper.InvWrapper
 *  net.minecraftforge.network.PacketDistributor
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.future;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.network.ManipulatorOpenInventoryPacket;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Network;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.screens.ManipulatorContainer;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerListener;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Manipulator
extends PrehistoricMob
implements ContainerListener {
    private static final EntityDataAccessor<Integer> TAME_ATTEMPTS = SynchedEntityData.m_135353_(Manipulator.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Boolean> SHIELD_BLOCKING = SynchedEntityData.m_135353_(Manipulator.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public final SimpleContainer manipulatorInventory = new SimpleContainer(2);
    private LazyOptional<?> itemHandler;
    public boolean interacting;
    public int attackCooldown = 0;
    public int blockCooldown = 0;
    public final SmoothAnimationState idleAnimationState = new SmoothAnimationState(1.0f);
    public final SmoothAnimationState idleArmedAnimationState = new SmoothAnimationState(1.0f);
    public final SmoothAnimationState sitArmedAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attackAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attackArmedAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState blockAnimationState = new SmoothAnimationState();
    private int blockTicks;

    public Manipulator(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
        this.manipulatorInventory.m_19164_((ContainerListener)this);
        this.itemHandler = LazyOptional.of(() -> new InvWrapper((Container)this.manipulatorInventory));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 28.0).m_22268_(Attributes.f_22279_, (double)0.3f).m_22268_(Attributes.f_22281_, 4.0).m_22268_(Attributes.f_22277_, 20.0);
    }

    @NotNull
    public MobType m_6336_() {
        return MobType.f_21642_;
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.9f;
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if ((this.refuseToMove() || this.isDancing()) && this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        super.m_7023_(travelVec);
    }

    public boolean m_214076_(@NotNull ServerLevel level, @NotNull LivingEntity victim) {
        this.m_5634_(8.0f);
        return super.m_214076_(level, victim);
    }

    public float getStepHeight() {
        return this.isRunning() ? 1.1f : 0.6f;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.MANIPULATOR_FOOD);
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_MANIPULATOR);
    }

    @Override
    public boolean canDanceToJukebox() {
        return true;
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.interacting;
    }

    @Override
    public boolean canOwnerCommand(Player player) {
        return player.m_6144_();
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        InteractionResult type = super.m_6071_(player, hand);
        if (!this.m_21824_() && itemstack.m_204117_(UP2ItemTags.TAMES_MANIPULATOR)) {
            if (!this.m_9236_().f_46443_) {
                if (!player.m_150110_().f_35937_) {
                    itemstack.m_41774_(1);
                }
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
        if (this.m_21824_() && !player.m_6144_() && player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)player;
            this.openGui(serverPlayer);
            return InteractionResult.SUCCESS;
        }
        return type;
    }

    protected void m_6728_(@NotNull LivingEntity entity) {
        super.m_6728_(entity);
        this.m_5496_(SoundEvents.f_12346_, 1.0f, 1.0f);
        this.onManipulatorBlock();
        if (entity.m_21205_().canDisableShield(this.f_20935_, (LivingEntity)this, entity)) {
            this.disableShield(true);
        }
    }

    private boolean isHoldingShield() {
        return this.m_21205_().canPerformAction(ToolActions.SHIELD_BLOCK) || this.m_21206_().canPerformAction(ToolActions.SHIELD_BLOCK);
    }

    public void onManipulatorBlock() {
        this.setShieldBlocking(true);
        this.blockTicks = 10;
        this.blockCooldown();
        this.attackCooldown();
    }

    protected void m_7909_(float damage) {
        if (this.f_20935_.canPerformAction(ToolActions.SHIELD_BLOCK) && damage >= 3.0f) {
            int i = 1 + Mth.m_14143_((float)damage);
            InteractionHand hand = this.m_7655_();
            this.damageManipulatorItem(i, hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND, this.f_20935_);
            this.f_20935_.m_41622_(i, (LivingEntity)this, entity -> entity.m_21190_(hand));
            if (this.f_20935_.m_41619_()) {
                if (hand == InteractionHand.MAIN_HAND) {
                    this.m_8061_(EquipmentSlot.MAINHAND, ItemStack.f_41583_);
                } else {
                    this.m_8061_(EquipmentSlot.OFFHAND, ItemStack.f_41583_);
                }
                this.f_20935_ = ItemStack.f_41583_;
                this.m_5496_(SoundEvents.f_12347_, 0.8f, 0.8f + this.m_9236_().f_46441_.m_188501_() * 0.4f);
            }
        }
    }

    public void damageManipulatorItem(int damage, EquipmentSlot slotToDamage, ItemStack item) {
        item.m_41622_(damage, (LivingEntity)this, entity -> entity.m_21166_(slotToDamage));
    }

    public void disableShield(boolean increase) {
        float chance = 0.25f + (float)EnchantmentHelper.m_44926_((LivingEntity)this) * 0.05f;
        if (increase) {
            chance += 0.75f;
        }
        if (this.f_19796_.m_188501_() < chance) {
            this.blockCooldown = 100;
            this.m_5810_();
            this.m_9236_().m_7605_((Entity)this, (byte)30);
        }
    }

    public boolean m_21275_(DamageSource source) {
        Vec3 sourcePosition;
        AbstractArrow abstractarrow;
        Entity entity = source.m_7640_();
        boolean flag = false;
        if (entity instanceof AbstractArrow && (abstractarrow = (AbstractArrow)entity).m_36796_() > 0) {
            flag = true;
        }
        if (!source.m_269533_(DamageTypeTags.f_276146_) && this.isHoldingShield() && !flag && this.blockCooldown == 0 && this.getAttackState() == 0 && (sourcePosition = source.m_7270_()) != null) {
            Vec3 viewVector = this.m_20252_(1.0f);
            Vec3 normalize = sourcePosition.m_82505_(this.m_20182_()).m_82541_();
            normalize = new Vec3(normalize.f_82479_, 0.0, normalize.f_82481_);
            return normalize.m_82526_(viewVector) < 0.0;
        }
        return false;
    }

    public void attackCooldown() {
        this.attackCooldown = 10 + this.m_217043_().m_188503_(10);
    }

    public void blockCooldown() {
        this.blockCooldown = 30 + this.m_217043_().m_188503_(10);
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (!this.m_9236_().f_46443_) {
            if (this.blockTicks > 0) {
                --this.blockTicks;
            }
            if (this.isShieldBlocking() && this.blockTicks == 0) {
                this.setShieldBlocking(false);
            }
            if (this.attackCooldown > 0) {
                --this.attackCooldown;
            }
            if (this.blockCooldown > 0) {
                --this.blockCooldown;
            }
        }
    }

    public boolean isHoldingItem() {
        return !this.m_21205_().m_41619_() || !this.m_21206_().m_41619_();
    }

    private boolean canPlayIdle() {
        return !this.m_21825_() && !this.isDancing();
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.isHoldingItem() && this.canPlayIdle(), this.f_19797_);
        this.idleArmedAnimationState.m_246184_(this.isHoldingItem() && this.canPlayIdle(), this.f_19797_);
        this.danceAnimationState.m_246184_(this.isDancing(), this.f_19797_);
        this.sitAnimationState.m_246184_(this.m_21825_() && !this.isHoldingItem() && !this.isDancing(), this.f_19797_);
        this.sitArmedAnimationState.m_246184_(this.m_21825_() && this.isHoldingItem() && !this.isDancing(), this.f_19797_);
        this.blockAnimationState.m_246184_(this.isShieldBlocking() && this.getAttackState() == 0, this.f_19797_);
        this.attackAnimationState.m_246184_(!this.isHoldingItem() && this.m_20089_() == UP2Poses.ATTACKING.get(), this.f_19797_);
        this.attackArmedAnimationState.m_246184_(this.isHoldingItem() && this.m_20089_() == UP2Poses.ATTACKING.get(), this.f_19797_);
    }

    protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHitIn) {
        for (int i = 0; i < this.manipulatorInventory.m_6643_(); ++i) {
            ItemStack itemstack = this.manipulatorInventory.m_8020_(i);
            if (itemstack.m_41619_() || EnchantmentHelper.m_44924_((ItemStack)itemstack)) continue;
            this.m_19983_(itemstack);
        }
    }

    @NotNull
    public ItemStack m_6844_(EquipmentSlot slot) {
        return switch (slot) {
            case EquipmentSlot.MAINHAND -> this.manipulatorInventory.m_8020_(0);
            case EquipmentSlot.OFFHAND -> this.manipulatorInventory.m_8020_(1);
            default -> ItemStack.f_41583_;
        };
    }

    public void m_8061_(@NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
        super.m_8061_(slot, stack);
        switch (slot) {
            case MAINHAND: {
                this.manipulatorInventory.m_6836_(0, (ItemStack)this.f_21350_.get(slot.m_20749_()));
                break;
            }
            case OFFHAND: {
                this.manipulatorInventory.m_6836_(1, (ItemStack)this.f_21350_.get(slot.m_20749_()));
            }
        }
    }

    protected void m_213945_(@NotNull RandomSource source, @NotNull DifficultyInstance instance) {
        this.f_21347_[EquipmentSlot.MAINHAND.m_20749_()] = 100.0f;
        this.f_21347_[EquipmentSlot.OFFHAND.m_20749_()] = 100.0f;
    }

    public void m_5757_(@NotNull Container container) {
    }

    public void openGui(ServerPlayer player) {
        if (player.f_36096_ != player.f_36095_) {
            player.m_6915_();
        }
        this.interacting = true;
        player.m_9217_();
        UP2Network.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), (Object)new ManipulatorOpenInventoryPacket(player.f_8940_, this.manipulatorInventory.m_6643_(), this.m_19879_()));
        player.f_36096_ = new ManipulatorContainer(player.f_8940_, player.m_150109_(), (Container)this.manipulatorInventory, this);
        player.m_143399_(player.f_36096_);
        MinecraftForge.EVENT_BUS.post((Event)new PlayerContainerEvent.Open((Player)player, player.f_36096_));
    }

    @NotNull
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction facing) {
        if (this.m_6084_() && capability == ForgeCapabilities.ITEM_HANDLER && this.itemHandler != null) {
            return this.itemHandler.cast();
        }
        return super.getCapability(capability, facing);
    }

    public void invalidateCaps() {
        super.invalidateCaps();
        if (this.itemHandler != null) {
            LazyOptional<?> oldHandler = this.itemHandler;
            this.itemHandler = null;
            oldHandler.invalidate();
        }
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(TAME_ATTEMPTS, (Object)0);
        this.f_19804_.m_135372_(SHIELD_BLOCKING, (Object)false);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("TameAttempts", this.getTameAttempts());
        compoundTag.m_128379_("Interacting", this.interacting);
        ListTag list = new ListTag();
        for (int i = 0; i < this.manipulatorInventory.m_6643_(); ++i) {
            ItemStack itemstack = this.manipulatorInventory.m_8020_(i);
            if (itemstack.m_41619_()) continue;
            CompoundTag tag = new CompoundTag();
            tag.m_128344_("Slot", (byte)i);
            itemstack.m_41739_(tag);
            list.add((Object)tag);
        }
        compoundTag.m_128365_("Inventory", (Tag)list);
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setTameAttempts(compoundTag.m_128451_("TameAttempts"));
        this.interacting = compoundTag.m_128471_("Interacting");
        ListTag list = compoundTag.m_128437_("Inventory", 9);
        for (int i = 0; i < list.size(); ++i) {
            CompoundTag compoundnbt = list.m_128728_(i);
            int j = compoundnbt.m_128445_("Slot") & 0xFF;
            this.manipulatorInventory.m_6836_(j, ItemStack.m_41712_((CompoundTag)compoundnbt));
        }
        if (compoundTag.m_128425_("HandItems", 9)) {
            ListTag handItems = compoundTag.m_128437_("HandItems", 10);
            for (int i = 0; i < this.f_21350_.size(); ++i) {
                this.manipulatorInventory.m_6836_(i, ItemStack.m_41712_((CompoundTag)handItems.m_128728_(i)));
            }
        }
    }

    public void setTameAttempts(int tameAttempts) {
        this.f_19804_.m_135381_(TAME_ATTEMPTS, (Object)tameAttempts);
    }

    public int getTameAttempts() {
        return (Integer)this.f_19804_.m_135370_(TAME_ATTEMPTS);
    }

    public void setShieldBlocking(boolean blocking) {
        this.f_19804_.m_135381_(SHIELD_BLOCKING, (Object)blocking);
    }

    public boolean isShieldBlocking() {
        return (Boolean)this.f_19804_.m_135370_(SHIELD_BLOCKING);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.MANIPULATOR_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.MANIPULATOR_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.MANIPULATOR_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.MANIPULATOR_STEP.get(), 0.25f, this.getStepPitch());
    }

    protected float m_6059_() {
        return this.f_19788_ + 0.75f;
    }

    private float getStepPitch() {
        return this.m_6162_() ? 1.45f + this.m_217043_().m_188501_() * 0.1f : 0.95f + this.m_217043_().m_188501_() * 0.1f;
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.MANIPULATOR.get()).m_20615_((Level)level);
    }

    public static boolean canSpawn(EntityType<Manipulator> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.MANIPULATOR_SPAWNABLE_ON) && Manipulator.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }
}


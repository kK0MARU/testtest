/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
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
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.TryFindWaterGoal
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_4;

import com.barlinc.unusual_prehistory.entity.ai.goals.CustomizableRandomSwimGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricAquaticMob;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.List;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Coelacanthus
extends PrehistoricAquaticMob {
    private static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.m_135353_(Coelacanthus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private int absorbCooldown = 0;
    public final SmoothAnimationState absorbAnimationState = new SmoothAnimationState();
    private int absorbTicks;

    public Coelacanthus(EntityType<? extends PrehistoricAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 85, 10, 0.02f, 0.1f, false);
        this.f_21365_ = new SmoothSwimmingLookControl((Mob)this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 8.0).m_22268_(Attributes.f_22281_, 1.0).m_22268_(Attributes.f_22279_, (double)0.8f).m_22268_(Attributes.f_22278_, 0.01);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new TryFindWaterGoal((PathfinderMob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargePanicGoal(this, 1.8, 10, 7){

            @Override
            public boolean m_8036_() {
                return super.m_8036_() && Coelacanthus.this.getCoelacanthusSize() <= 5;
            }
        });
        this.f_21345_.m_25352_(2, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.STETHACANTHUS_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new PrehistoricAvoidEntityGoal<Player>((PrehistoricMob)this, Player.class, 8.0f, 1.8, EntitySelector.f_20408_::test){

            @Override
            public boolean m_8036_() {
                return super.m_8036_() && Coelacanthus.this.getCoelacanthusSize() <= 5;
            }
        });
        this.f_21345_.m_25352_(4, (Goal)new PrehistoricAvoidEntityGoal<LivingEntity>((PrehistoricMob)this, LivingEntity.class, 8.0f, 1.8, entity -> entity.m_6095_().m_204039_(UP2EntityTags.COELACANTHUS_AVOIDS)){

            @Override
            public boolean m_8036_() {
                return super.m_8036_() && Coelacanthus.this.getCoelacanthusSize() <= 5;
            }
        });
        this.f_21345_.m_25352_(5, (Goal)new CustomizableRandomSwimGoal((PathfinderMob)this, 1.0, 40));
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.6f;
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_STETHACANTHUS);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.STETHACANTHUS_FOOD);
    }

    public void m_7023_(@NotNull Vec3 travelVector) {
        if (this.m_21515_() && this.m_20069_()) {
            this.m_19920_(this.m_6113_(), travelVector);
            this.m_6478_(MoverType.SELF, this.m_20184_());
            this.m_20256_(this.m_20184_().m_82490_(0.9));
            if (this.f_19862_ && this.m_204029_(FluidTags.f_13131_) && this.m_21691_()) {
                this.m_20256_(this.m_20184_().m_82520_(0.0, 0.005, 0.0));
            }
            if (!this.m_204029_(FluidTags.f_13131_)) {
                this.m_20256_(this.m_20184_().m_82520_(0.0, -0.005, 0.0));
            }
        } else {
            super.m_7023_(travelVector);
        }
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (this.absorbCooldown > 0) {
            --this.absorbCooldown;
        }
        if (this.getCoelacanthusSize() < 127 && this.m_6084_() && this.absorbCooldown == 0 && this.consumeNearbyMobs()) {
            this.m_146850_(GameEvent.f_157806_);
            this.m_5496_(SoundEvents.f_11912_, this.m_6121_(), this.m_6100_());
            this.m_5634_(this.m_21233_());
            this.setCoelacanthusSize(this.getCoelacanthusSize() + 1);
            if (this.m_20089_() == Pose.STANDING) {
                this.m_20124_(UP2Poses.ATTACKING.get());
            }
            this.absorbCooldown = 40 + this.m_217043_().m_188503_(60);
        }
    }

    public boolean canConsumeEntity(Entity entity) {
        if (entity == null || !entity.m_6084_() || entity == this) {
            return false;
        }
        if (entity.m_6095_().m_204039_(UP2EntityTags.COELACANTHUS_NEVER_EATS)) {
            return false;
        }
        return entity.m_20205_() < this.m_20205_() && entity.m_20206_() < this.m_20206_() || entity.m_6095_().m_204039_(UP2EntityTags.COELACANTHUS_ALWAYS_EATS);
    }

    private boolean consumeNearbyMobs() {
        List nearbyEntities = this.m_9236_().m_45971_(LivingEntity.class, TargetingConditions.m_148353_(), (LivingEntity)this, this.m_20191_().m_82400_(1.1));
        if (!nearbyEntities.isEmpty()) {
            LivingEntity entity = (LivingEntity)nearbyEntities.get(0);
            if (this.canConsumeEntity((Entity)entity) && !this.m_9236_().f_46443_) {
                if (entity instanceof Player) {
                    Player player = (Player)entity;
                    if (!player.m_7500_() && !player.m_5833_()) {
                        entity.m_6469_(this.m_269291_().m_269333_((LivingEntity)this), (float)this.m_21133_(Attributes.f_22281_));
                    }
                } else {
                    entity.m_146870_();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public void setupAnimationStates() {
        this.swimIdleAnimationState.m_246184_(this.m_20072_(), this.f_19797_);
        this.flopAnimationState.m_246184_(!this.m_20072_(), this.f_19797_);
        this.absorbAnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get(), this.f_19797_);
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.absorbTicks > 0) {
            --this.absorbTicks;
        }
        if (this.absorbTicks == 0 && this.m_20089_() == UP2Poses.ATTACKING.get()) {
            this.m_20124_(Pose.STANDING);
        }
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (SIZE.equals(accessor)) {
            this.m_6210_();
            this.m_146922_(this.f_20885_);
            this.f_20883_ = this.f_20885_;
        }
        if (f_19806_.equals(accessor) && this.m_20089_() == UP2Poses.ATTACKING.get()) {
            this.absorbTicks = 10;
        }
        super.m_7350_(accessor);
    }

    @Override
    public boolean m_6094_() {
        return this.getCoelacanthusSize() <= 5;
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(SIZE, (Object)1);
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("Size", this.getCoelacanthusSize() - 1);
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setCoelacanthusSize(compoundTag.m_128451_("Size") + 1);
    }

    public int getCoelacanthusSize() {
        return (Integer)this.f_19804_.m_135370_(SIZE);
    }

    public void setCoelacanthusSize(int size) {
        int maxSize = Mth.m_14045_((int)size, (int)1, (int)2048);
        this.f_19804_.m_135381_(SIZE, (Object)maxSize);
        this.m_20090_();
        this.m_6210_();
        this.m_21051_(Attributes.f_22281_).m_22100_((double)(1 + this.getCoelacanthusSize()));
        this.m_21051_(Attributes.f_22278_).m_22100_(0.01 + (double)this.getCoelacanthusSize() * 0.01);
    }

    public void m_6210_() {
        double x = this.m_20185_();
        double y = this.m_20186_();
        double z = this.m_20189_();
        super.m_6210_();
        this.m_6034_(x, y, z);
    }

    @NotNull
    public EntityDimensions m_6972_(@NotNull Pose pose) {
        int size = this.getCoelacanthusSize();
        EntityDimensions dimensions = super.m_6972_(pose);
        if (dimensions.f_20377_ <= 0.0f || dimensions.f_20378_ <= 0.0f) {
            return dimensions;
        }
        float scale = (dimensions.f_20377_ + 0.05f * (float)size) / dimensions.f_20377_;
        return dimensions.m_20388_(scale);
    }

    public float m_6100_() {
        int size = this.getCoelacanthusSize();
        float pitch = Mth.m_14036_((float)((float)size / 127.0f), (float)0.0f, (float)1.0f);
        return Mth.m_14179_((float)pitch, (float)1.8f, (float)0.1f);
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.COELACANTHUS_BUCKET.get());
    }

    @Override
    public boolean canBucket() {
        return true;
    }

    @Override
    public void m_6872_(@NotNull ItemStack bucket) {
        super.m_6872_(bucket);
        CompoundTag compoundTag = bucket.m_41784_();
        compoundTag.m_128405_("Size", this.getCoelacanthusSize());
    }

    @Override
    public void m_142278_(@NotNull CompoundTag compoundTag) {
        super.m_142278_(compoundTag);
        this.setCoelacanthusSize(compoundTag.m_128451_("Size"));
    }

    @javax.annotation.Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.COELACANTHUS_DEATH.get();
    }

    @javax.annotation.Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.COELACANTHUS_HURT.get();
    }

    @Override
    @javax.annotation.Nullable
    protected SoundEvent getFlopSound() {
        return (SoundEvent)UP2SoundEvents.COELACANTHUS_FLOP.get();
    }

    @javax.annotation.Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        Coelacanthus coelacanthus = (Coelacanthus)((EntityType)UP2Entities.COELACANTHUS.get()).m_20615_((Level)level);
        if (coelacanthus != null) {
            coelacanthus.setVariant(this.getVariant());
        }
        return coelacanthus;
    }

    @Override
    public int getVariantCount() {
        return CoelacanthusVariant.values().length;
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag compoundTag) {
        this.setVariant(level.m_213780_().m_188503_(this.getVariantCount()));
        return super.m_6518_(level, difficulty, spawnType, spawnData, compoundTag);
    }

    public static enum CoelacanthusVariant {
        FISHY(0),
        GOLDEN(1),
        LILAC(2),
        PEACH(3),
        ROSE(4),
        SILVER(5),
        BLUE(6);

        private final int id;

        private CoelacanthusVariant(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static CoelacanthusVariant byId(int id) {
            if (id < 0 || id >= CoelacanthusVariant.values().length) {
                id = 0;
            }
            return CoelacanthusVariant.values()[id];
        }
    }
}


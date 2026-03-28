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
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.EntityDimensions
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
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_3;

import com.barlinc.unusual_prehistory.entity.ai.goals.AquaticLeapGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.AquaticNibbleBlockGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.CustomizableRandomSwimGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricAquaticMob;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.LeapingMob;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import net.minecraft.core.BlockPos;
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
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Tartuosteus
extends PrehistoricAquaticMob
implements LeapingMob {
    private static final EntityDataAccessor<Boolean> LEAPING = SynchedEntityData.m_135353_(Tartuosteus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);

    public Tartuosteus(EntityType<? extends PrehistoricAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 85, 10, 0.02f, 0.1f, false);
        this.f_21365_ = new SmoothSwimmingLookControl((Mob)this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22284_, 8.0).m_22268_(Attributes.f_22279_, (double)0.55f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new TryFindWaterGoal((PathfinderMob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargePanicGoal(this, 2.0, 10, 7));
        this.f_21345_.m_25352_(2, new PrehistoricAvoidEntityGoal<LivingEntity>((PrehistoricMob)this, LivingEntity.class, 6.0f, 2.0, entity -> entity.m_6095_().m_204039_(UP2EntityTags.TARTUOSTEUS_AVOIDS)));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.TARTUOSTEUS_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new AquaticNibbleBlockGoal(this, 30, 800, UP2BlockTags.TARTUOSTEUS_NIBBLING_BLOCKS, 1.0));
        this.f_21345_.m_25352_(5, (Goal)new CustomizableRandomSwimGoal((PathfinderMob)this, 1.0, 10));
        this.f_21345_.m_25352_(6, (Goal)new TartuosteusGlideGoal(this));
    }

    public int m_8132_() {
        return 1;
    }

    public int m_8085_() {
        return 1;
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
        return stack.m_204117_(UP2ItemTags.TARTUOSTEUS_FOOD);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.8f;
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (this.isLeaping() && !this.m_20072_() && this.m_20184_().f_82480_ < 0.0) {
            this.m_20256_(this.m_20184_().m_82542_(1.0, (double)0.66f, 1.0));
        }
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(LEAPING, (Object)false);
    }

    @Override
    public boolean isLeaping() {
        return (Boolean)this.f_19804_.m_135370_(LEAPING);
    }

    @Override
    public void setLeaping(boolean leaping) {
        this.f_19804_.m_135381_(LEAPING, (Object)leaping);
    }

    @NotNull
    public ItemStack m_28282_() {
        return ItemStack.f_41583_;
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
    public AgeableMob m_142606_(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        Tartuosteus tartuosteus = (Tartuosteus)((EntityType)UP2Entities.TARTUOSTEUS.get()).m_20615_((Level)serverLevel);
        if (tartuosteus != null) {
            tartuosteus.setVariant(this.getVariant());
        }
        return tartuosteus;
    }

    @Override
    public int getVariantCount() {
        return TartuosteusVariant.values().length;
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        spawnGroupData = super.m_6518_(level, difficulty, spawnType, spawnGroupData, compoundTag);
        if (spawnType == MobSpawnType.BUCKET && compoundTag != null && compoundTag.m_128425_("BucketVariantTag", 3)) {
            this.setVariant(compoundTag.m_128451_("BucketVariantTag"));
        } else if (level.m_6018_().m_46462_()) {
            this.setVariant(1);
        } else {
            this.setVariant(0);
        }
        return spawnGroupData;
    }

    public static boolean canSpawn(EntityType<Tartuosteus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return PrehistoricAquaticMob.checkSpawnRules(entityType, level, spawnType, pos, random);
    }

    private static class TartuosteusGlideGoal
    extends AquaticLeapGoal {
        private final Tartuosteus tartuosteus;

        public TartuosteusGlideGoal(Tartuosteus tartuosteus) {
            super(tartuosteus, 10, 1.0, 0.5);
            this.tartuosteus = tartuosteus;
        }

        @Override
        public void m_8037_() {
            boolean flag = this.breached;
            this.tartuosteus.m_21573_().m_26573_();
            if (!flag) {
                FluidState fluidstate = this.tartuosteus.m_9236_().m_6425_(this.tartuosteus.m_20183_());
                this.breached = fluidstate.m_205070_(FluidTags.f_13131_);
            }
            if (this.breached && !flag) {
                this.tartuosteus.m_5496_(SoundEvents.f_11805_, 1.0f, 1.0f);
            }
            Vec3 vec3 = this.tartuosteus.m_20184_();
            if (vec3.f_82480_ * vec3.f_82480_ < (double)0.03f && this.tartuosteus.m_146909_() != 0.0f) {
                this.tartuosteus.m_146926_(Mth.m_14189_((float)0.2f, (float)this.tartuosteus.m_146909_(), (float)0.0f));
            } else if (vec3.m_82553_() > (double)1.0E-5f) {
                double d0 = vec3.m_165924_();
                double d1 = Math.atan2(-vec3.f_82480_, d0) * 57.2957763671875;
                this.tartuosteus.m_146926_((float)d1);
            }
            Vec3 movement = new Vec3((double)this.tartuosteus.m_6374_().m_122429_(), 0.0, (double)this.tartuosteus.m_6374_().m_122431_()).m_82541_().m_82490_((double)0.53f);
            Vec3 glide = new Vec3(movement.f_82479_, vec3.f_82480_, movement.f_82481_);
            this.tartuosteus.m_20256_(glide);
            this.tartuosteus.m_146922_((float)Mth.m_14136_((double)this.tartuosteus.m_6374_().m_122431_(), (double)this.tartuosteus.m_6374_().m_122429_()) * 57.295776f - 90.0f);
        }
    }

    public static enum TartuosteusVariant {
        TARTUOSTEUS(0),
        EVIL_TARTUOSTEUS(1);

        private final int variant;

        private TartuosteusVariant(int variant) {
            this.variant = variant;
        }

        public int getId() {
            return this.variant;
        }

        public static TartuosteusVariant byId(int id) {
            if (id < 0 || id >= TartuosteusVariant.values().length) {
                id = 0;
            }
            return TartuosteusVariant.values()[id];
        }
    }
}


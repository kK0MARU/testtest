/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
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
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.CustomizableRandomSwimGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricAquaticMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2DamageTypes;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Dunkleosteus
extends PrehistoricAquaticMob {
    private static final EntityDimensions SMALL_SIZE = EntityDimensions.m_20395_((float)0.5f, (float)0.5f);
    private static final EntityDimensions MEDIUM_SIZE = EntityDimensions.m_20395_((float)0.8f, (float)0.98f);
    private static final EntityDimensions LARGE_SIZE = EntityDimensions.m_20395_((float)1.7f, (float)1.98f);
    public int attackCooldown = 0;
    public final SmoothAnimationState attackAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState quirkAnimationState = new SmoothAnimationState();
    private int quirkCooldown = 600 + this.m_217043_().m_188503_(3600);

    public Dunkleosteus(EntityType<? extends PrehistoricAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 85, 10, 0.02f, 0.1f, false);
        this.f_21365_ = new SmoothSwimmingLookControl((Mob)this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22281_, 2.0).m_22268_(Attributes.f_22279_, 0.5).m_22268_(Attributes.f_22284_, 2.0);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new TryFindWaterGoal((PathfinderMob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargePanicGoal(this, 1.5, 10, 4){

            @Override
            public boolean m_8036_() {
                return super.m_8036_() && Dunkleosteus.this.getVariant() == 0 || Dunkleosteus.this.m_6162_();
            }
        });
        this.f_21345_.m_25352_(2, (Goal)new DunkleosteusAttackGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.DUNKLEOSTEUS_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new CustomizableRandomSwimGoal((PathfinderMob)this, 1.0, 30, 10, 7, 3, true));
        this.f_21345_.m_25352_(5, (Goal)new DunkleosteusQuirkGoal(this));
        this.f_21346_.m_25352_(0, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]){

            public boolean m_8036_() {
                return super.m_8036_() && Dunkleosteus.this.getVariant() != 0;
            }
        });
        this.f_21346_.m_25352_(1, new PrehistoricNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 300, true, true, this::isTarget));
        this.f_21346_.m_25352_(2, new PrehistoricNearestAttackableTargetGoal<Player>(this, Player.class, 300, true, true, this::canAttackPlayer));
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
    public float m_5610_(@NotNull BlockPos pos, @NotNull LevelReader level) {
        return this.getDepthPathfindingFavor(pos, level);
    }

    public double getChaseSpeed() {
        switch (this.getVariant()) {
            case 1: {
                return 1.5;
            }
            case 2: {
                return 1.6;
            }
        }
        return 1.4;
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.quirkCooldown > 0) {
            --this.quirkCooldown;
        }
    }

    @Override
    public void setupAnimationStates() {
        super.setupAnimationStates();
        this.attackAnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get(), this.f_19797_);
        this.quirkAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (VARIANT.equals(accessor)) {
            this.m_6210_();
            this.setupSizeAttributes();
        }
        super.m_7350_(accessor);
    }

    private void setupSizeAttributes() {
        if (this.getVariant() == 0) {
            this.m_21051_(Attributes.f_22276_).m_22100_(8.0);
            this.m_21051_(Attributes.f_22284_).m_22100_(4.0);
            this.m_21051_(Attributes.f_22281_).m_22100_(3.0);
            this.m_21051_(Attributes.f_22279_).m_22100_((double)0.9f);
            this.m_21051_(Attributes.f_22278_).m_22100_(0.0);
        }
        if (this.getVariant() == 1) {
            this.m_21051_(Attributes.f_22276_).m_22100_(24.0);
            this.m_21051_(Attributes.f_22284_).m_22100_(6.0);
            this.m_21051_(Attributes.f_22281_).m_22100_(5.0);
            this.m_21051_(Attributes.f_22279_).m_22100_((double)0.8f);
            this.m_21051_(Attributes.f_22278_).m_22100_(0.25);
        }
        if (this.getVariant() == 2) {
            this.m_21051_(Attributes.f_22276_).m_22100_(40.0);
            this.m_21051_(Attributes.f_22284_).m_22100_(10.0);
            this.m_21051_(Attributes.f_22281_).m_22100_(8.0);
            this.m_21051_(Attributes.f_22279_).m_22100_((double)0.6f);
            this.m_21051_(Attributes.f_22278_).m_22100_(0.5);
        }
        this.m_5634_(50.0f);
    }

    protected void quirkCooldown() {
        this.quirkCooldown = 600 + this.m_217043_().m_188503_(3600);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.DUNKLEOSTEUS_FOOD);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions size) {
        return size.f_20378_ * 0.5f;
    }

    public boolean isTarget(Entity entity) {
        if (this.getVariant() == 1) {
            return entity.m_6095_().m_204039_(UP2EntityTags.MEDIUM_DUNKLEOSTEUS_TARGETS);
        }
        if (this.getVariant() == 2) {
            return entity.m_6095_().m_204039_(UP2EntityTags.BIG_DUNKLEOSTEUS_TARGETS);
        }
        return entity.m_6095_().m_204039_(UP2EntityTags.SMALL_DUNKLEOSTEUS_TARGETS);
    }

    public boolean canAttackPlayer(LivingEntity entity) {
        return this.m_6779_(entity) && this.getVariant() > 0;
    }

    public boolean m_6779_(@NotNull LivingEntity entity) {
        boolean prev = super.m_6779_(entity);
        if (prev && !this.isPacified() && entity instanceof LivingEntity && (this.m_21188_() == null || !this.m_21188_().m_20148_().equals(entity.m_20148_()))) {
            return false;
        }
        return prev;
    }

    public void doKnockback(LivingEntity target) {
        if (this.getVariant() == 0) {
            this.strongKnockback((Entity)target, 0.1, 0.01);
        } else if (this.getVariant() == 1) {
            this.strongKnockback((Entity)target, 0.2, 0.01);
        } else {
            this.strongKnockback((Entity)target, 0.3, 0.01);
        }
    }

    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.DUNKLEOSTEUS_HURT.get();
    }

    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.DUNKLEOSTEUS_DEATH.get();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return (SoundEvent)UP2SoundEvents.DUNKLEOSTEUS_FLOP.get();
    }

    public SoundEvent getBiteSound() {
        if (this.getVariant() == 0) {
            return (SoundEvent)UP2SoundEvents.SMALL_DUNKLEOSTEUS_BITE.get();
        }
        if (this.getVariant() == 1) {
            return (SoundEvent)UP2SoundEvents.MEDIUM_DUNKLEOSTEUS_BITE.get();
        }
        return (SoundEvent)UP2SoundEvents.LARGE_DUNKLEOSTEUS_BITE.get();
    }

    public float m_6100_() {
        float size = (float)(3 - this.getVariant()) * 0.33f;
        return (float)((double)super.m_6100_() * Math.sqrt(size) * (double)1.2f);
    }

    @Override
    public boolean m_6094_() {
        return super.m_6094_() && this.getVariant() != 2;
    }

    @NotNull
    public EntityDimensions m_6972_(@NotNull Pose pose) {
        return this.getDimsForDunk().m_20388_(this.m_6134_());
    }

    private EntityDimensions getDimsForDunk() {
        return switch (this.getVariant()) {
            case 1 -> MEDIUM_SIZE;
            case 2 -> LARGE_SIZE;
            default -> SMALL_SIZE;
        };
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_DUNKLEOSTEUS);
    }

    @javax.annotation.Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        Dunkleosteus dunkleosteus = (Dunkleosteus)((EntityType)UP2Entities.DUNKLEOSTEUS.get()).m_20615_((Level)serverLevel);
        if (dunkleosteus != null) {
            dunkleosteus.setVariant(this.getVariant());
        }
        return dunkleosteus;
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.DUNKLEOSTEUS_BUCKET.get());
    }

    @Override
    public boolean canBucket() {
        return true;
    }

    @Override
    public int getVariantCount() {
        return DunkleosteusVariant.values().length;
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        spawnGroupData = super.m_6518_(level, difficulty, spawnType, spawnGroupData, compoundTag);
        if (spawnType == MobSpawnType.BUCKET && compoundTag != null && compoundTag.m_128425_("BucketVariantTag", 3)) {
            this.setVariant(compoundTag.m_128451_("BucketVariantTag"));
        } else {
            this.setVariant(this.f_19796_.m_188503_(DunkleosteusVariant.values().length));
        }
        return spawnGroupData;
    }

    private static class DunkleosteusAttackGoal
    extends AttackGoal {
        private final Dunkleosteus dunkleosteus;

        public DunkleosteusAttackGoal(Dunkleosteus dunkleosteus) {
            super(dunkleosteus);
            this.dunkleosteus = dunkleosteus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && (this.dunkleosteus.m_5448_().m_20072_() || !this.dunkleosteus.m_20072_());
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && (this.dunkleosteus.m_5448_().m_20072_() || !this.dunkleosteus.m_20072_());
        }

        public void m_8037_() {
            LivingEntity target = this.dunkleosteus.m_5448_();
            if (target != null) {
                this.dunkleosteus.m_21391_((Entity)target, 30.0f, 30.0f);
                this.dunkleosteus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
                double distance = this.dunkleosteus.m_20275_(target.m_20185_(), target.m_20186_(), target.m_20189_());
                int attackState = this.dunkleosteus.getAttackState();
                this.dunkleosteus.m_21573_().m_5624_((Entity)target, this.dunkleosteus.getChaseSpeed());
                if (attackState == 1) {
                    this.tickBite();
                } else if (distance < this.getAttackReachSqr(target) && this.dunkleosteus.attackCooldown == 0) {
                    this.dunkleosteus.setAttackState(1);
                }
            }
        }

        protected void tickBite() {
            ++this.timer;
            LivingEntity target = this.dunkleosteus.m_5448_();
            if (this.timer == 1) {
                this.dunkleosteus.m_20124_(UP2Poses.ATTACKING.get());
            }
            if (this.timer == 2) {
                this.dunkleosteus.m_5496_(this.dunkleosteus.getBiteSound(), 1.0f, this.dunkleosteus.m_217043_().m_188501_() * 0.1f + 0.9f);
            }
            if (this.timer == 5 && this.isInAttackRange(target, 1.5)) {
                DamageSource damagesource = UP2DamageTypes.execute(this.dunkleosteus.m_9236_(), (Entity)this.dunkleosteus, (Entity)this.dunkleosteus);
                target.m_6469_(damagesource, (float)this.dunkleosteus.m_21133_(Attributes.f_22281_));
                this.dunkleosteus.doKnockback(target);
                this.dunkleosteus.m_6674_(InteractionHand.MAIN_HAND);
            }
            if (this.timer > 10) {
                this.timer = 0;
                this.dunkleosteus.m_20124_(Pose.STANDING);
                this.dunkleosteus.attackCooldown = 5 + this.dunkleosteus.m_217043_().m_188503_(3);
                this.dunkleosteus.setAttackState(0);
            }
        }
    }

    private static class DunkleosteusQuirkGoal
    extends IdleAnimationGoal {
        private final Dunkleosteus dunkleosteus;

        public DunkleosteusQuirkGoal(Dunkleosteus dunkleosteus) {
            super(dunkleosteus, 40, 1, false, false);
            this.dunkleosteus = dunkleosteus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.dunkleosteus.quirkCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.dunkleosteus.quirkCooldown();
        }
    }

    public static enum DunkleosteusVariant {
        RAVERI(0),
        MARSAISI(1),
        TERRELLI(2);

        private final int id;

        private DunkleosteusVariant(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static DunkleosteusVariant byId(int id) {
            if (id < 0 || id >= DunkleosteusVariant.values().length) {
                id = 0;
            }
            return DunkleosteusVariant.values()[id];
        }
    }
}


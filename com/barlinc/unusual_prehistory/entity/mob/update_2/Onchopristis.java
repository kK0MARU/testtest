/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.TryFindWaterGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_2;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.CustomizableRandomSwimGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargeBabyPanicGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricAquaticMob;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Onchopristis
extends PrehistoricAquaticMob {
    public static final EntityDataAccessor<Boolean> BURROWED = SynchedEntityData.m_135353_(Onchopristis.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<Integer> BURROW_COOLDOWN = SynchedEntityData.m_135353_(Onchopristis.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private int attackCooldown = 0;
    public final SmoothAnimationState attack1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState burrowAnimationState = new SmoothAnimationState();
    private boolean attackAlt = false;

    public Onchopristis(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new OnchopristisMoveControl(this);
        this.f_21365_ = new SmoothSwimmingLookControl((Mob)this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 16.0).m_22268_(Attributes.f_22281_, 5.0).m_22268_(Attributes.f_22279_, (double)0.64f).m_22268_(Attributes.f_22277_, 16.0);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new TryFindWaterGoal((PathfinderMob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargeBabyPanicGoal(this, 1.5, 10, 4));
        this.f_21345_.m_25352_(2, (Goal)new OnchopristisAttackGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.ONCHOPRISTIS_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new CustomizableRandomSwimGoal((PathfinderMob)this, 1.0, 40, 10, 7));
        this.f_21345_.m_25352_(5, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.f_21345_.m_25352_(5, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(0, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.refuseToMove() && this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        if (this.m_21515_() && this.m_20069_()) {
            this.m_19920_(this.m_6113_(), travelVec);
            this.m_6478_(MoverType.SELF, this.m_20184_());
            this.m_20256_(this.m_20184_().m_82490_(0.9));
            if (this.f_19862_ && this.m_204029_(FluidTags.f_13131_) && this.m_21691_()) {
                this.m_20256_(this.m_20184_().m_82520_(0.0, 0.005, 0.0));
            }
            if (!(this.m_20096_() && !this.isBurrowed() || this.getBurrowCooldown() != 0 || this.m_21523_())) {
                if (this.m_21573_().m_26570_() != null) {
                    this.m_21573_().m_26573_();
                }
                this.m_20256_(this.m_20184_().m_82520_(0.0, -0.05, 0.0));
            }
        } else {
            super.m_7023_(travelVec);
        }
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions size) {
        return size.f_20378_ * 0.5f;
    }

    @Override
    public float m_5610_(@NotNull BlockPos pos, @NotNull LevelReader level) {
        return this.getDepthPathfindingFavor(pos, level);
    }

    @Override
    public boolean m_6094_() {
        return !this.isBurrowed();
    }

    public void m_7324_(@NotNull Entity entity) {
        if (!this.isBurrowed()) {
            super.m_7324_(entity);
        }
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
        if (this.m_6084_() && this.isBurrowed() && !this.m_9236_().f_46443_ && this.m_5448_() == null && this.f_19797_ % 20 == 0) {
            this.getSteppedOn();
        }
        if (this.m_20069_() && !this.m_5912_() && this.m_21214_() == null && this.getBurrowCooldown() > 0) {
            this.setBurrowCooldown(this.getBurrowCooldown() - 1);
        }
        this.tickBurrowing();
    }

    private void tickBurrowing() {
        if (this.isBurrowed() && !this.m_20069_()) {
            this.setBurrowed(false);
        }
        if (this.m_20069_() && !this.m_21523_() && this.getBurrowCooldown() == 0 && this.m_20096_() && !this.isBurrowed() && !this.m_5912_() && this.m_21214_() == null) {
            this.setBurrowed(true);
        }
        if (this.isBurrowed() && this.m_217043_().m_188503_(1600) == 0) {
            this.setBurrowCooldown(600 + this.m_217043_().m_188503_(600));
            this.setBurrowed(false);
        }
    }

    private void getSteppedOn() {
        this.m_9236_().m_45933_((Entity)this, this.getAggroHitbox()).forEach(entity -> {
            LivingEntity mob;
            if (entity instanceof LivingEntity && (mob = (LivingEntity)entity).m_6084_() && !(mob instanceof Onchopristis) && EntitySelector.f_20406_.test(mob) && !this.isPacified()) {
                this.m_6710_(mob);
                this.setBurrowed(false);
                this.setBurrowCooldown(600 + this.m_217043_().m_188503_(600));
            }
        });
    }

    @NotNull
    public AABB getAggroHitbox() {
        return this.m_20191_().m_165897_(0.0, 0.1, 0.0).m_82386_(0.0, 0.4, 0.0);
    }

    @Override
    protected void m_7880_(float distance) {
        if (distance > 6.0f && this.isBurrowed()) {
            this.setBurrowed(false);
            this.setBurrowCooldown(600 + this.m_217043_().m_188503_(600));
        }
    }

    @Override
    protected void m_6475_(@NotNull DamageSource source, float amount) {
        super.m_6475_(source, amount);
        if (this.isBurrowed()) {
            this.setBurrowed(false);
            this.setBurrowCooldown(600 + this.m_217043_().m_188503_(600));
        }
    }

    @Override
    public void setupAnimationStates() {
        this.swimIdleAnimationState.m_246184_(this.m_20072_() && !this.isBurrowed(), this.f_19797_);
        this.flopAnimationState.m_246184_(!this.m_20072_(), this.f_19797_);
        this.attack1AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && !this.attackAlt, this.f_19797_);
        this.attack2AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && this.attackAlt, this.f_19797_);
        this.burrowAnimationState.m_246184_(this.isBurrowed(), this.f_19797_);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.isBurrowed();
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(BURROWED, (Object)false);
        this.f_19804_.m_135372_(BURROW_COOLDOWN, (Object)(600 + this.m_217043_().m_188503_(600)));
    }

    public boolean isBurrowed() {
        return (Boolean)this.f_19804_.m_135370_(BURROWED);
    }

    public void setBurrowed(boolean burrowed) {
        this.f_19804_.m_135381_(BURROWED, (Object)burrowed);
    }

    public int getBurrowCooldown() {
        return (Integer)this.f_19804_.m_135370_(BURROW_COOLDOWN);
    }

    public void setBurrowCooldown(int cooldown) {
        this.f_19804_.m_135381_(BURROW_COOLDOWN, (Object)cooldown);
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_ONCHOPRISTIS);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.ONCHOPRISTIS_FOOD);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.ONCHOPRISTIS.get()).m_20615_((Level)level);
    }

    @NotNull
    public ItemStack m_28282_() {
        return ItemStack.f_41583_;
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.ONCHOPRISTIS_DEATH.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.ONCHOPRISTIS_DEATH.get();
    }

    @Override
    @Nullable
    protected SoundEvent getFlopSound() {
        return (SoundEvent)UP2SoundEvents.ONCHOPRISTIS_FLOP.get();
    }

    private static class OnchopristisMoveControl
    extends SmoothSwimmingMoveControl {
        protected final Onchopristis onchopristis;

        public OnchopristisMoveControl(Onchopristis onchopristis) {
            super((Mob)onchopristis, 85, 10, 0.02f, 0.1f, false);
            this.onchopristis = onchopristis;
        }

        public void m_8126_() {
            if (!this.onchopristis.refuseToMove()) {
                if (this.f_24981_ == MoveControl.Operation.MOVE_TO && !this.onchopristis.m_21523_() && this.onchopristis.isBurrowed()) {
                    this.onchopristis.setBurrowed(false);
                }
                super.m_8126_();
            }
        }
    }

    private static class OnchopristisAttackGoal
    extends AttackGoal {
        private final Onchopristis onchopristis;

        public OnchopristisAttackGoal(Onchopristis onchopristis) {
            super(onchopristis);
            this.onchopristis = onchopristis;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && (this.onchopristis.m_5448_().m_20069_() || !this.onchopristis.m_20069_());
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && (this.onchopristis.m_5448_().m_20069_() || !this.onchopristis.m_20069_());
        }

        public void m_8037_() {
            LivingEntity target = this.onchopristis.m_5448_();
            if (target != null) {
                this.onchopristis.m_21391_((Entity)target, 30.0f, 30.0f);
                this.onchopristis.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
                double distance = this.onchopristis.m_20280_((Entity)target);
                int attackState = this.onchopristis.getAttackState();
                this.onchopristis.m_21573_().m_5624_((Entity)target, 1.5);
                if (attackState == 1) {
                    this.tickAttack();
                } else if (distance < this.getAttackReachSqr(target)) {
                    this.onchopristis.setAttackState(1);
                }
            }
        }

        protected void tickAttack() {
            ++this.timer;
            LivingEntity target = this.onchopristis.m_5448_();
            if (this.timer == 1) {
                this.onchopristis.attackAlt = this.onchopristis.m_217043_().m_188499_();
                this.onchopristis.m_20124_(UP2Poses.ATTACKING.get());
            }
            if (this.timer == 9 && this.isInAttackRange(target, 2.0)) {
                this.onchopristis.m_7327_((Entity)target);
                this.onchopristis.m_6674_(InteractionHand.MAIN_HAND);
            }
            if (this.timer > 20) {
                this.timer = 0;
                this.onchopristis.m_20124_(Pose.STANDING);
                this.onchopristis.setAttackState(0);
            }
        }
    }
}


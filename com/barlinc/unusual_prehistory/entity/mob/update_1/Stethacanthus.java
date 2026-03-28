/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
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
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.RandomSwimmingGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.TryFindWaterGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.mob.base.SchoolingAquaticMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import javax.annotation.Nullable;
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
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class Stethacanthus
extends SchoolingAquaticMob {
    public final SmoothAnimationState attackAnimationState = new SmoothAnimationState();

    public Stethacanthus(EntityType<? extends SchoolingAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 85, 10, 0.02f, 0.1f, false);
        this.f_21365_ = new SmoothSwimmingLookControl((Mob)this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 12.0).m_22268_(Attributes.f_22281_, 3.0).m_22268_(Attributes.f_22279_, (double)0.85f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new TryFindWaterGoal((PathfinderMob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargePanicGoal(this, 1.5, 10, 7));
        this.f_21345_.m_25352_(2, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.STETHACANTHUS_FOOD), false));
        this.f_21345_.m_25352_(3, new PrehistoricAvoidEntityGoal<Player>((PrehistoricMob)this, Player.class, 10.0f, 1.5, EntitySelector.f_20408_::test));
        this.f_21345_.m_25352_(3, new PrehistoricAvoidEntityGoal<LivingEntity>((PrehistoricMob)this, LivingEntity.class, 10.0f, 1.5, entity -> entity.m_6095_().m_204039_(UP2EntityTags.STETHACANTHUS_AVOIDS)));
        this.f_21345_.m_25352_(4, (Goal)new StethacanthusAttackGoal(this));
        this.f_21345_.m_25352_(5, (Goal)new RandomSwimmingGoal((PathfinderMob)this, 1.0, 10));
        this.f_21346_.m_25352_(0, new PrehistoricNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 300, true, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.STETHACANTHUS_TARGETS)));
    }

    @Override
    public int getMaxSchoolSize() {
        return 3;
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.55f;
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
        } else {
            super.m_7023_(travelVector);
        }
    }

    @Override
    public void setupAnimationStates() {
        this.swimIdleAnimationState.m_246184_(this.m_20072_() && this.m_20089_() != UP2Poses.ATTACKING.get(), this.f_19797_);
        this.flopAnimationState.m_246184_(!this.m_20072_(), this.f_19797_);
        this.attackAnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get(), this.f_19797_);
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.STETHACANTHUS_DEATH.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.STETHACANTHUS_HURT.get();
    }

    @Override
    @Nullable
    protected SoundEvent getFlopSound() {
        return (SoundEvent)UP2SoundEvents.STETHACANTHUS_FLOP.get();
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.STETHACANTHUS_BUCKET.get());
    }

    @Override
    public boolean canBucket() {
        return true;
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.STETHACANTHUS.get()).m_20615_((Level)serverLevel);
    }

    private static class StethacanthusAttackGoal
    extends AttackGoal {
        private final Stethacanthus stethacanthus;

        public StethacanthusAttackGoal(Stethacanthus stethacanthus) {
            super(stethacanthus);
            this.stethacanthus = stethacanthus;
        }

        @Override
        public boolean m_8036_() {
            LivingEntity target = this.stethacanthus.m_5448_();
            return super.m_8036_() && target != null && target.m_6084_() && target.m_20069_() && !target.m_6095_().m_204039_(UP2EntityTags.STETHACANTHUS_AVOIDS) && !(target instanceof Player);
        }

        public void m_8037_() {
            LivingEntity target = this.stethacanthus.m_5448_();
            if (target != null && target.m_20069_()) {
                this.stethacanthus.m_21391_((Entity)target, 30.0f, 30.0f);
                this.stethacanthus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
                double distance = this.stethacanthus.m_20275_(target.m_20185_(), target.m_20186_(), target.m_20189_());
                if (this.stethacanthus.getAttackState() == 1) {
                    this.tickAttack();
                } else {
                    if (distance <= 4.0) {
                        this.stethacanthus.setAttackState(1);
                    }
                    this.stethacanthus.m_21573_().m_5624_((Entity)target, 1.5);
                }
            }
        }

        protected void tickAttack() {
            ++this.timer;
            LivingEntity target = this.stethacanthus.m_5448_();
            if (this.timer == 1) {
                this.stethacanthus.m_20124_(UP2Poses.ATTACKING.get());
            }
            if (this.timer == 5) {
                this.stethacanthus.m_5496_((SoundEvent)UP2SoundEvents.STETHACANTHUS_BITE.get(), 0.7f, this.stethacanthus.m_6100_());
            }
            if (this.timer == 6 && this.isInAttackRange(target, 1.5)) {
                this.stethacanthus.m_7327_((Entity)target);
                this.stethacanthus.m_6674_(InteractionHand.MAIN_HAND);
            }
            if (this.timer > 20) {
                this.timer = 0;
                this.stethacanthus.m_20124_(Pose.STANDING);
                this.stethacanthus.setAttackState(0);
            }
        }
    }
}


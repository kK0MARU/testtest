/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.OpenDoorGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_1.DromaeosaurusAttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_1.DromaeosaurusLeapGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_1.DromaeosaurusRunGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Dromaeosaurus
extends PrehistoricMob {
    public int leapCooldown = 120 + this.m_217043_().m_188503_(120);
    public final SmoothAnimationState attackAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState fallAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState eepyAnimationState = new SmoothAnimationState(0.25f);

    public Dromaeosaurus(EntityType<? extends Dromaeosaurus> entityType, Level level) {
        super(entityType, level);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargePanicGoal(this, 1.0));
        this.f_21345_.m_25352_(2, (Goal)new SleepingGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new DromaeosaurusLeapGoal(this));
        this.f_21345_.m_25352_(4, (Goal)new DromaeosaurusAttackGoal(this));
        this.f_21345_.m_25352_(5, new PrehistoricAvoidEntityGoal<LivingEntity>((PrehistoricMob)this, LivingEntity.class, 12.0f, 1.0, entity -> entity.m_6095_().m_204039_(UP2EntityTags.DROMAEOSAURUS_AVOIDS)));
        this.f_21345_.m_25352_(6, (Goal)new OpenDoorGoal((Mob)this, true));
        this.f_21345_.m_25352_(7, (Goal)new TemptGoal((PathfinderMob)this, 1.0, Ingredient.m_204132_(UP2ItemTags.DROMAEOSAURUS_FOOD), false));
        this.f_21345_.m_25352_(8, (Goal)new DromaeosaurusRunGoal(this));
        this.f_21345_.m_25352_(9, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.f_21345_.m_25352_(9, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(0, (Goal)new PrehistoricNearestAttackableTargetGoal<LivingEntity>((PrehistoricMob)this, LivingEntity.class, 300, true, false, entity -> entity.m_6095_().m_204039_(UP2EntityTags.DROMAEOSAURUS_TARGETS)){

            @Override
            public boolean m_8036_() {
                return super.m_8036_() && !Dromaeosaurus.this.isEepy() && (Dromaeosaurus.this.m_9236_().m_46461_() || Dromaeosaurus.this.m_9236_().m_6042_().f_63854_().isPresent());
            }

            @Override
            public boolean m_8045_() {
                return super.m_8045_() && !Dromaeosaurus.this.isEepy() && (Dromaeosaurus.this.m_9236_().m_46461_() || Dromaeosaurus.this.m_9236_().m_6042_().f_63854_().isPresent());
            }
        });
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 12.0).m_22268_(Attributes.f_22281_, 3.0).m_22268_(Attributes.f_22279_, (double)0.4f);
    }

    @Override
    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        NoSpinGroundPathNavigation navigation = new NoSpinGroundPathNavigation((Mob)this, level);
        navigation.m_26477_(true);
        navigation.m_148214_(true);
        return navigation;
    }

    public float getStepHeight() {
        return 1.1f;
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_DROMAEOSAURUS);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.DROMAEOSAURUS_FOOD);
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        this.m_6858_(this.m_20184_().m_165924_() > 0.05);
        if (this.leapCooldown > 0) {
            --this.leapCooldown;
        }
    }

    @Override
    public boolean isEepyTime() {
        return this.m_9236_().m_46462_() && this.m_21223_() > this.m_21233_() * 0.5f && !this.m_20069_() && this.m_20096_() && this.m_21188_() == null && this.m_5448_() == null && !this.m_21523_();
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.isEepy(), this.f_19797_);
        this.fallAnimationState.m_246184_(!this.m_20096_() && !this.m_20072_() && !this.m_6147_() && !this.m_20159_() && !this.isEepy(), this.f_19797_);
        this.attackAnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get(), this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        return (AgeableMob)((EntityType)UP2Entities.DROMAEOSAURUS.get()).m_20615_((Level)level);
    }

    public boolean m_6673_(DamageSource source) {
        return source.m_276093_(DamageTypes.f_268671_);
    }

    protected void m_7840_(double y, boolean onGround, @NotNull BlockState state, @NotNull BlockPos pos) {
    }

    public void m_7023_(@NotNull Vec3 vec3) {
        if (this.refuseToMove() && this.m_20096_()) {
            this.m_20256_(this.m_20184_().m_82542_(0.0, 1.0, 0.0));
            vec3 = vec3.m_82542_(0.0, 1.0, 0.0);
        }
        super.m_7023_(vec3);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return this.isEepy() ? (SoundEvent)UP2SoundEvents.DROMAEOSAURUS_EEPY.get() : (SoundEvent)UP2SoundEvents.DROMAEOSAURUS_IDLE.get();
    }

    @Override
    public boolean canPlayAmbientSound() {
        return true;
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.DROMAEOSAURUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.DROMAEOSAURUS_DEATH.get();
    }

    public static boolean canSpawn(EntityType<Dromaeosaurus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.DROMAEOSAURUS_SPAWNABLE_ON) && Dromaeosaurus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }
}


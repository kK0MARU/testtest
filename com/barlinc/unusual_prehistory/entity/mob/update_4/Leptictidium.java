/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.FollowParentGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.animal.Animal
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
package com.barlinc.unusual_prehistory.entity.mob.update_4;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.EnumSet;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.Animal;
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

public class Leptictidium
extends PrehistoricMob {
    private int attackCooldown = 0;
    public final SmoothAnimationState attackAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState sniffAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState preenAnimationState = new SmoothAnimationState();
    private int sniffCooldown = 400 + this.m_217043_().m_188503_(400);
    private int preenCooldown = 700 + this.m_217043_().m_188503_(700);

    public Leptictidium(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new LeptictidiumAttackGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new LeptictidiumRunLikeCrazyGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new LargePanicGoal(this, 1.6, 10, 4));
        this.f_21345_.m_25352_(4, new PrehistoricAvoidEntityGoal<LivingEntity>((PrehistoricMob)this, LivingEntity.class, 8.0f, 1.6, entity -> entity.m_6095_().m_204039_(UP2EntityTags.LEPTICTIDIUM_AVOIDS)));
        this.f_21345_.m_25352_(4, new PrehistoricAvoidEntityGoal<Player>((PrehistoricMob)this, Player.class, 8.0f, 1.6, EntitySelector.f_20408_::test));
        this.f_21345_.m_25352_(5, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.LEPTICTIDIUM_FOOD), false));
        this.f_21345_.m_25352_(6, (Goal)new FollowParentGoal((Animal)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(8, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.f_21345_.m_25352_(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(9, (Goal)new LeptictidiumPreenGoal(this));
        this.f_21345_.m_25352_(9, (Goal)new LeptictidiumSniffGoal(this));
        this.f_21346_.m_25352_(0, new PrehistoricNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 200, true, true, entity -> entity.m_6336_() == MobType.f_21642_ && !entity.m_6095_().m_204039_(UP2EntityTags.LEPTICTIDIUM_DOESNT_TARGET)));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 6.0).m_22268_(Attributes.f_22281_, 4.0).m_22268_(Attributes.f_22279_, (double)0.3f);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions size) {
        return size.f_20378_ * 0.8f;
    }

    @Override
    public double m_20204_() {
        if (this.m_20069_() && this.f_19862_) {
            return super.m_20204_();
        }
        return 0.7 * (double)this.m_20206_();
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.refuseToMove() && this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        super.m_7023_(travelVec);
    }

    public float getStepHeight() {
        return this.isRunning() ? 1.0f : 0.6f;
    }

    protected void m_7840_(double y, boolean onGround, @NotNull BlockState state, @NotNull BlockPos pos) {
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.LEPTICTIDIUM_FOOD);
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (!this.m_9236_().f_46443_) {
            if (this.f_19797_ % 20 == 0) {
                this.infectNearbyMobs();
                this.getInfectedByNearbyMobs();
            }
            if (this.attackCooldown > 0) {
                --this.attackCooldown;
            }
        }
    }

    private void infectNearbyMobs() {
        List nearbyEntities = this.m_9236_().m_45971_(LivingEntity.class, TargetingConditions.m_148353_(), (LivingEntity)this, this.m_20191_().m_82400_(3.0));
        if (!this.m_21220_().isEmpty() && !nearbyEntities.isEmpty()) {
            for (MobEffectInstance effectInstance : this.m_21220_()) {
                nearbyEntities.stream().filter(entity -> entity != this && !entity.m_21023_(effectInstance.m_19544_()) && effectInstance.m_19557_() > 20 && !effectInstance.m_19544_().m_8093_()).forEach(entity -> entity.m_147207_(new MobEffectInstance(effectInstance.m_19544_(), (int)((float)effectInstance.m_19557_() * 0.3f), 0), (Entity)this));
            }
        }
    }

    private void getInfectedByNearbyMobs() {
        List nearbyEntities = this.m_9236_().m_45971_(LivingEntity.class, TargetingConditions.m_148353_(), (LivingEntity)this, this.m_20191_().m_82400_(3.0));
        if (!nearbyEntities.isEmpty()) {
            nearbyEntities.stream().filter(entity -> entity != this).forEach(entity -> {
                if (!entity.m_21220_().isEmpty()) {
                    for (MobEffectInstance effectInstance : entity.m_21220_()) {
                        if (this.m_21023_(effectInstance.m_19544_()) || effectInstance.m_19557_() <= 20 || effectInstance.m_19544_().m_8093_()) continue;
                        this.m_147207_(new MobEffectInstance(effectInstance.m_19544_(), (int)((float)effectInstance.m_19557_() * 0.3f), effectInstance.m_19564_()), (Entity)entity);
                    }
                }
            });
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.m_9236_().f_46443_) {
            if (this.preenCooldown > 0) {
                --this.preenCooldown;
            }
            if (this.sniffCooldown > 0) {
                --this.sniffCooldown;
            }
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.m_20072_() && this.m_20089_() == Pose.STANDING && this.getIdleState() != 1, this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20072_() && this.m_20089_() == Pose.STANDING, this.f_19797_);
        this.attackAnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get(), this.f_19797_);
        this.preenAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.sniffAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1;
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        return (AgeableMob)((EntityType)UP2Entities.LEPTICTIDIUM.get()).m_20615_((Level)level);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.LEPTICTIDIUM_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.LEPTICTIDIUM_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.LEPTICTIDIUM_DEATH.get();
    }

    public int m_8100_() {
        return 150;
    }

    public static boolean canSpawn(EntityType<Leptictidium> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.LEPTICTIDIUM_SPAWNABLE_ON) && Leptictidium.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class LeptictidiumAttackGoal
    extends AttackGoal {
        private final Leptictidium leptictidium;

        public LeptictidiumAttackGoal(Leptictidium leptictidium) {
            super(leptictidium);
            this.leptictidium = leptictidium;
        }

        public void m_8037_() {
            LivingEntity target = this.leptictidium.m_5448_();
            if (target != null) {
                double distance = this.leptictidium.m_20280_((Entity)target);
                this.leptictidium.m_21391_((Entity)this.leptictidium.m_5448_(), 30.0f, 30.0f);
                this.leptictidium.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
                if (this.leptictidium.getAttackState() == 1) {
                    this.leptictidium.m_21573_().m_26573_();
                    this.tickAttack();
                } else {
                    this.leptictidium.m_21573_().m_5624_((Entity)target, 1.7);
                    if (distance <= this.getAttackReachSqr(target) && this.leptictidium.attackCooldown == 0) {
                        this.leptictidium.setAttackState(1);
                    }
                }
            }
        }

        protected void tickAttack() {
            ++this.timer;
            LivingEntity target = this.leptictidium.m_5448_();
            if (this.timer == 1) {
                this.leptictidium.m_20124_(UP2Poses.ATTACKING.get());
            }
            if (this.timer == 8 && this.isInAttackRange(target, 1.5)) {
                this.leptictidium.m_7327_((Entity)target);
                this.leptictidium.m_6674_(InteractionHand.MAIN_HAND);
            }
            if (this.timer > 20) {
                this.timer = 0;
                this.leptictidium.m_20124_(Pose.STANDING);
                this.leptictidium.setAttackState(0);
                this.leptictidium.attackCooldown = 5 + this.leptictidium.m_217043_().m_188503_(5);
            }
        }

        @Override
        protected double getAttackReachSqr(LivingEntity target) {
            return this.mob.m_20205_() * 1.5f * this.mob.m_20205_() * 1.5f + target.m_20205_();
        }
    }

    private static class LeptictidiumRunLikeCrazyGoal
    extends Goal {
        protected final Leptictidium leptictidium;
        protected double wantedX;
        protected double wantedY;
        protected double wantedZ;

        public LeptictidiumRunLikeCrazyGoal(Leptictidium leptictidium) {
            this.leptictidium = leptictidium;
            this.m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean m_8036_() {
            if (this.leptictidium.m_20160_()) {
                return false;
            }
            Vec3 vec3 = this.getPosition();
            if (vec3 == null) {
                return false;
            }
            if (this.leptictidium.m_21223_() <= this.leptictidium.m_21233_() * 0.5f) {
                this.wantedX = vec3.f_82479_;
                this.wantedY = vec3.f_82480_;
                this.wantedZ = vec3.f_82481_;
                return true;
            }
            return false;
        }

        @javax.annotation.Nullable
        protected Vec3 getPosition() {
            return DefaultRandomPos.m_148403_((PathfinderMob)this.leptictidium, (int)15, (int)7);
        }

        public boolean m_8045_() {
            return !this.leptictidium.m_20160_() && !this.leptictidium.m_21573_().m_26571_();
        }

        public void m_8056_() {
            this.leptictidium.setRunning(true);
            this.leptictidium.m_21573_().m_26519_(this.wantedX, this.wantedY, this.wantedZ, 1.6 + (double)(0.25f * (1.0f - this.leptictidium.m_21223_() / this.leptictidium.m_21233_())));
        }

        public void m_8037_() {
            this.leptictidium.m_21563_().m_24950_(this.wantedX, this.wantedY, this.wantedZ, 30.0f, 30.0f);
        }

        public void m_8041_() {
            this.leptictidium.setRunning(false);
            this.leptictidium.m_21573_().m_26573_();
        }
    }

    private static class LeptictidiumPreenGoal
    extends IdleAnimationGoal {
        private final Leptictidium leptictidium;

        public LeptictidiumPreenGoal(Leptictidium leptictidium) {
            super(leptictidium, 30, 1);
            this.leptictidium = leptictidium;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.leptictidium.preenCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.leptictidium.preenCooldown = 700 + this.leptictidium.m_217043_().m_188503_(700);
        }
    }

    private static class LeptictidiumSniffGoal
    extends IdleAnimationGoal {
        private final Leptictidium leptictidium;

        public LeptictidiumSniffGoal(Leptictidium leptictidium) {
            super(leptictidium, 30, 2, false);
            this.leptictidium = leptictidium;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.leptictidium.sniffCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.leptictidium.sniffCooldown = 400 + this.leptictidium.m_217043_().m_188503_(400);
        }
    }
}


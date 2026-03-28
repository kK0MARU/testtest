/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.behavior.BehaviorUtils
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.TargetGoal
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.item.enchantment.Enchantments
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricFollowParentGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2DamageTypeTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.EnumSet;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Kentrosaurus
extends PrehistoricMob {
    private int attackCooldown = 0;
    public final SmoothAnimationState attack1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState grazeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState shakeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState stretch1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState stretch2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState yawnAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState angryAnimationState = new SmoothAnimationState();
    private boolean attackAlt = false;
    private int grazeCooldown = 400 + this.m_217043_().m_188503_(2500);
    private int shakeCooldown = 300 + this.m_217043_().m_188503_(1200);
    private int yawnCooldown = 400 + this.m_217043_().m_188503_(1500);
    private int stretchCooldown = 400 + this.m_217043_().m_188503_(3000);
    private boolean stretchAlt = false;

    public Kentrosaurus(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
        this.m_21441_(BlockPathTypes.DANGER_OTHER, 0.0f);
        this.m_21441_(BlockPathTypes.DAMAGE_OTHER, 0.0f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargePanicGoal(this, 2.0, 10, 4){

            protected boolean m_202729_() {
                return super.m_202729_() && (Kentrosaurus.this.m_21223_() <= Kentrosaurus.this.m_21233_() * 0.4f || Kentrosaurus.this.m_6162_());
            }
        });
        this.f_21345_.m_25352_(2, (Goal)new KentrosaurusAttackGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new KentrosaurusFollowThornsGoal(this));
        this.f_21345_.m_25352_(4, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.KENTROSAURUS_FOOD), false));
        this.f_21345_.m_25352_(5, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new PrehistoricFollowParentGoal(this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(8, (Goal)new SleepingGoal(this));
        this.f_21345_.m_25352_(9, (Goal)new KentrosaurusGrazeGoal(this));
        this.f_21345_.m_25352_(9, (Goal)new KentrosaurusShakeGoal(this));
        this.f_21345_.m_25352_(9, (Goal)new KentrosaurusStretchGoal(this));
        this.f_21345_.m_25352_(9, (Goal)new KentrosaurusYawnGoal(this));
        this.f_21346_.m_25352_(0, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(1, (Goal)new KentrosaurusDefendThornsGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22281_, 7.0).m_22268_(Attributes.f_22278_, 0.5).m_22268_(Attributes.f_22279_, (double)0.16f).m_22268_(Attributes.f_22284_, 4.0);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions size) {
        return size.f_20378_ * 0.5f;
    }

    @Override
    public double m_20204_() {
        if (this.m_20069_() && this.f_19862_) {
            return super.m_20204_();
        }
        return 0.4 * (double)this.m_20206_();
    }

    public float getStepHeight() {
        return 1.1f;
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

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.KENTROSAURUS_FOOD);
    }

    public boolean entityHasThorns(LivingEntity entity) {
        return entity.m_6844_(EquipmentSlot.HEAD).getEnchantmentLevel(Enchantments.f_44972_) > 0 || entity.m_6844_(EquipmentSlot.CHEST).getEnchantmentLevel(Enchantments.f_44972_) > 0 || entity.m_6844_(EquipmentSlot.LEGS).getEnchantmentLevel(Enchantments.f_44972_) > 0 || entity.m_6844_(EquipmentSlot.FEET).getEnchantmentLevel(Enchantments.f_44972_) > 0;
    }

    public static void angerNearbyKentrosaurus(Player player, boolean angerIfSeen) {
        List list = player.m_9236_().m_45976_(Kentrosaurus.class, player.m_20191_().m_82400_(16.0));
        list.stream().filter(kentrosaurus -> !angerIfSeen || BehaviorUtils.m_22667_((LivingEntity)kentrosaurus, (LivingEntity)player)).forEach(kentrosaurus -> kentrosaurus.m_6710_((LivingEntity)player));
    }

    @Override
    public Vec3 getEepyParticleVec() {
        return new Vec3(0.0, 0.0, (double)(-this.m_20205_() * 1.1f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.m_9236_().f_46443_) {
            if (this.attackCooldown > 0) {
                --this.attackCooldown;
            }
            if (!this.isEepy()) {
                if (this.grazeCooldown > 0) {
                    --this.grazeCooldown;
                }
                if (this.shakeCooldown > 0) {
                    --this.shakeCooldown;
                }
                if (this.stretchCooldown > 0) {
                    --this.stretchCooldown;
                }
                if (this.yawnCooldown > 0) {
                    --this.yawnCooldown;
                }
            }
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(this.m_20089_() != UP2Poses.ATTACKING.get() && !this.m_20069_() && !this.isEepy(), this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20089_() != UP2Poses.ATTACKING.get() && this.m_20069_(), this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
        this.attack1AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && !this.attackAlt, this.f_19797_);
        this.attack2AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && this.attackAlt, this.f_19797_);
        this.angryAnimationState.m_246184_(this.m_20089_() != UP2Poses.ATTACKING.get() && this.m_5912_(), this.f_19797_);
        this.grazeAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.shakeAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
        this.yawnAnimationState.m_246184_(this.getIdleState() == 3, this.f_19797_);
        this.stretch1AnimationState.m_246184_(this.getIdleState() == 4 && !this.stretchAlt, this.f_19797_);
        this.stretch2AnimationState.m_246184_(this.getIdleState() == 4 && this.stretchAlt, this.f_19797_);
    }

    protected void grazeCooldown() {
        this.grazeCooldown = 400 + this.m_217043_().m_188503_(2500);
    }

    protected void shakeCooldown() {
        this.shakeCooldown = 300 + this.m_217043_().m_188503_(1200);
    }

    protected void yawnCooldown() {
        this.yawnCooldown = 400 + this.m_217043_().m_188503_(1500);
    }

    protected void stretchCooldown() {
        this.stretchCooldown = 400 + this.m_217043_().m_188503_(3000);
    }

    @Override
    protected void m_6475_(@NotNull DamageSource source, float amount) {
        Entity entity;
        if (!source.m_269533_(DamageTypeTags.f_268640_) && !source.m_276093_(DamageTypes.f_268440_) && (entity = source.m_7640_()) instanceof LivingEntity) {
            LivingEntity target = (LivingEntity)entity;
            target.m_6469_(this.m_269291_().m_269374_((Entity)this), 2.0f);
        }
        super.m_6475_(source, amount);
    }

    public boolean m_6673_(@NotNull DamageSource source) {
        return super.m_6673_(source) || source.m_269533_(UP2DamageTypeTags.KENTROSAURUS_IMMUNE_TO);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1 || this.getIdleState() == 4;
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        return (AgeableMob)((EntityType)UP2Entities.KENTROSAURUS.get()).m_20615_((Level)level);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.KENTROSAURUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSourceIn) {
        return (SoundEvent)UP2SoundEvents.KENTROSAURUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.KENTROSAURUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.KENTROSAURUS_STEP.get(), 1.0f, 1.1f);
    }

    public int m_8100_() {
        return 160;
    }

    public static boolean canSpawn(EntityType<Kentrosaurus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.KENTROSAURUS_SPAWNABLE_ON) && Kentrosaurus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class KentrosaurusAttackGoal
    extends AttackGoal {
        private final Kentrosaurus kentrosaurus;

        public KentrosaurusAttackGoal(Kentrosaurus kentrosaurus) {
            super(kentrosaurus);
            this.kentrosaurus = kentrosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.kentrosaurus.m_21223_() > this.kentrosaurus.m_21233_() * 0.4f;
        }

        @Override
        public boolean m_8045_() {
            return super.m_8045_() && this.kentrosaurus.m_21223_() > this.kentrosaurus.m_21233_() * 0.4f;
        }

        public void m_8037_() {
            LivingEntity target = this.kentrosaurus.m_5448_();
            if (target != null) {
                this.kentrosaurus.m_21391_((Entity)this.kentrosaurus.m_5448_(), 30.0f, 30.0f);
                this.kentrosaurus.m_21563_().m_24960_((Entity)this.kentrosaurus.m_5448_(), 30.0f, 30.0f);
                double distance = this.kentrosaurus.m_20275_(target.m_20185_(), target.m_20186_(), target.m_20189_());
                if (this.kentrosaurus.getAttackState() == 1) {
                    this.tickAttack();
                } else {
                    this.kentrosaurus.m_21573_().m_5624_((Entity)target, 2.0);
                    if (distance <= this.getAttackReachSqr(target) && this.kentrosaurus.attackCooldown == 0) {
                        this.kentrosaurus.setAttackState(1);
                    }
                }
            }
        }

        protected void tickAttack() {
            ++this.timer;
            LivingEntity target = this.kentrosaurus.m_5448_();
            if (this.timer == 1) {
                this.kentrosaurus.attackAlt = this.kentrosaurus.m_217043_().m_188499_();
                this.kentrosaurus.m_20124_(UP2Poses.ATTACKING.get());
            }
            if (this.timer == 19 && this.isInAttackRange(target, 3.0)) {
                this.kentrosaurus.m_6674_(InteractionHand.MAIN_HAND);
                this.kentrosaurus.m_7327_((Entity)target);
            }
            if (this.timer > 40) {
                this.timer = 0;
                this.kentrosaurus.setAttackState(0);
                this.kentrosaurus.attackCooldown = 5;
                this.kentrosaurus.m_20124_(Pose.STANDING);
            }
        }

        @Override
        protected double getAttackReachSqr(LivingEntity target) {
            return this.mob.m_20205_() * 2.3f * this.mob.m_20205_() * 2.3f + target.m_20205_();
        }
    }

    private static class KentrosaurusFollowThornsGoal
    extends Goal {
        private static final TargetingConditions TEMP_TARGETING = TargetingConditions.m_148353_().m_26883_(10.0).m_148355_();
        private final TargetingConditions targetingConditions;
        protected final Kentrosaurus kentrosaurus;
        @Nullable
        protected LivingEntity livingEntity;
        private int calmDown;

        public KentrosaurusFollowThornsGoal(Kentrosaurus kentrosaurus) {
            this.kentrosaurus = kentrosaurus;
            this.m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
            this.targetingConditions = TEMP_TARGETING.m_148354_().m_26888_(this::shouldFollow);
        }

        public boolean m_8036_() {
            if (this.calmDown > 0) {
                --this.calmDown;
                return false;
            }
            this.livingEntity = this.kentrosaurus.m_9236_().m_45946_(this.targetingConditions, (LivingEntity)this.kentrosaurus);
            return this.livingEntity != null;
        }

        public boolean m_8045_() {
            return this.m_8036_();
        }

        public void m_8041_() {
            this.livingEntity = null;
            this.kentrosaurus.m_21573_().m_26573_();
            this.calmDown = KentrosaurusFollowThornsGoal.m_186073_((int)100);
        }

        public void m_8037_() {
            if (this.livingEntity != null) {
                this.kentrosaurus.m_21563_().m_24960_((Entity)this.livingEntity, (float)(this.kentrosaurus.m_8085_() + 20), (float)this.kentrosaurus.m_8132_());
                if (this.kentrosaurus.m_20280_((Entity)this.livingEntity) < 6.25) {
                    this.kentrosaurus.m_21573_().m_26573_();
                } else {
                    this.kentrosaurus.m_21573_().m_5624_((Entity)this.livingEntity, 1.0);
                }
            }
        }

        private boolean shouldFollow(LivingEntity entity) {
            return this.kentrosaurus.entityHasThorns(entity);
        }
    }

    private static class KentrosaurusGrazeGoal
    extends IdleAnimationGoal {
        private final Kentrosaurus kentrosaurus;

        public KentrosaurusGrazeGoal(Kentrosaurus kentrosaurus) {
            super(kentrosaurus, 40, 1);
            this.kentrosaurus = kentrosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.kentrosaurus.grazeCooldown == 0 && this.kentrosaurus.m_9236_().m_8055_(this.kentrosaurus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.KENTROSAURUS_GRAZING_BLOCKS);
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.kentrosaurus.grazeCooldown();
        }
    }

    private static class KentrosaurusShakeGoal
    extends IdleAnimationGoal {
        private final Kentrosaurus kentrosaurus;

        public KentrosaurusShakeGoal(Kentrosaurus kentrosaurus) {
            super(kentrosaurus, 40, 2, false);
            this.kentrosaurus = kentrosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.kentrosaurus.shakeCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.kentrosaurus.shakeCooldown();
        }
    }

    private static class KentrosaurusStretchGoal
    extends IdleAnimationGoal {
        private final Kentrosaurus kentrosaurus;

        public KentrosaurusStretchGoal(Kentrosaurus kentrosaurus) {
            super(kentrosaurus, 60, 4);
            this.kentrosaurus = kentrosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.kentrosaurus.stretchCooldown == 0;
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            this.kentrosaurus.stretchAlt = this.kentrosaurus.m_217043_().m_188499_();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.kentrosaurus.stretchCooldown();
        }
    }

    private static class KentrosaurusYawnGoal
    extends IdleAnimationGoal {
        private final Kentrosaurus kentrosaurus;

        public KentrosaurusYawnGoal(Kentrosaurus kentrosaurus) {
            super(kentrosaurus, 80, 3, false);
            this.kentrosaurus = kentrosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.kentrosaurus.yawnCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.kentrosaurus.yawnCooldown();
        }
    }

    private static class KentrosaurusDefendThornsGoal
    extends TargetGoal {
        private final Kentrosaurus kentrosaurus;
        private LivingEntity ownerLastHurtBy;
        private int timestamp;
        @Nullable
        protected LivingEntity target;

        public KentrosaurusDefendThornsGoal(Kentrosaurus kentrosaurus) {
            super((Mob)kentrosaurus, false);
            this.kentrosaurus = kentrosaurus;
            this.m_7021_(EnumSet.of(Goal.Flag.TARGET));
        }

        public boolean m_8036_() {
            this.findTarget();
            if (this.target == null) {
                return false;
            }
            this.ownerLastHurtBy = this.target.m_21188_();
            int i = this.target.m_21213_();
            return i != this.timestamp && this.m_26150_(this.ownerLastHurtBy, TargetingConditions.f_26872_);
        }

        public void m_8056_() {
            this.f_26135_.m_6710_(this.ownerLastHurtBy);
            LivingEntity livingentity = this.target;
            if (livingentity != null) {
                this.timestamp = livingentity.m_21213_();
            }
            super.m_8056_();
        }

        protected void findTarget() {
            this.target = this.f_26135_.m_9236_().m_45982_(this.f_26135_.m_9236_().m_6443_(LivingEntity.class, this.getTargetSearchArea(this.m_7623_()), target -> true), TargetingConditions.m_148352_().m_26883_(this.m_7623_()).m_26888_(this.kentrosaurus::entityHasThorns), (LivingEntity)this.f_26135_, this.f_26135_.m_20185_(), this.f_26135_.m_20188_(), this.f_26135_.m_20189_());
        }

        protected AABB getTargetSearchArea(double distance) {
            return this.kentrosaurus.m_20191_().m_82377_(distance, 4.0, distance);
        }
    }
}


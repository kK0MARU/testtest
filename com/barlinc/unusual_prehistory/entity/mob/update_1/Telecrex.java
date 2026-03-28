/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.FollowParentGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.FlyingPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.RandomFlightGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricFlyingMob;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class Telecrex
extends PrehistoricFlyingMob {
    private static final EntityDataAccessor<Boolean> SPLAT = SynchedEntityData.m_135353_(Telecrex.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public final SmoothAnimationState peckAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState preen1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState preen2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState splatAnimationState = new SmoothAnimationState(0.75f);
    private boolean preenAlt = false;
    public int preenCooldown = 700 + this.m_217043_().m_188503_(3600);
    public int peckCooldown = 800 + this.m_217043_().m_188503_(3600);
    private int splatTicks;

    public Telecrex(EntityType<? extends PrehistoricFlyingMob> entityType, Level level) {
        super(entityType, level);
        this.switchNavigator(false);
        this.m_21441_(BlockPathTypes.LEAVES, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 6.0).m_22268_(Attributes.f_22280_, 1.0).m_22268_(Attributes.f_22279_, (double)0.2f);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new FlyingPanicGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new TelecrexScatterGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.TELECREX_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0){

            public boolean m_8036_() {
                return super.m_8036_() && !Telecrex.this.m_29443_();
            }
        });
        this.f_21345_.m_25352_(5, (Goal)new RandomFlightGoal(this, 0.8f, 1.4f, 16, 4, 1600, 200));
        this.f_21345_.m_25352_(6, (Goal)new FollowParentGoal((Animal)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(8, (Goal)new TelecrexPreenGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new TelecrexPeckGoal(this));
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

    public boolean m_6469_(@NotNull DamageSource source, float amount) {
        Entity entity;
        boolean hurt = super.m_6469_(source, amount);
        if (hurt && source.m_7639_() != null && this.m_6084_() && (entity = source.m_7639_()) instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            double range = 8.0;
            List entities = this.m_9236_().m_45976_(((Object)((Object)this)).getClass(), this.m_20191_().m_82377_(range, range / 2.0, range));
            for (Telecrex telecrex : entities) {
                telecrex.m_6703_(livingEntity);
            }
        }
        return hurt;
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (this.m_29443_() && this.f_19862_ && this.m_217043_().m_188499_() && !this.m_9236_().f_46443_) {
            this.setSplat(true);
            this.setFlying(false);
        }
        if (this.hasSplat()) {
            ++this.splatTicks;
            this.m_20334_(this.m_20184_().f_82479_ * (double)0.1f, this.m_20184_().f_82480_ * (double)0.4f, this.m_20184_().f_82481_ * (double)0.1f);
        }
        if (this.splatTicks > 60 || this.m_20096_() || this.m_20072_()) {
            this.setSplat(false);
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.m_29443_()) {
            if (this.preenCooldown > 0) {
                --this.preenCooldown;
            }
            if (this.peckCooldown > 0) {
                --this.peckCooldown;
            }
        }
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1 || this.getIdleState() == 2 || this.hasSplat();
    }

    @Override
    public boolean refuseToLook() {
        return super.refuseToMove() || this.hasSplat();
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.m_29443_() && this.getIdleState() != 1 && this.getIdleState() != 2, this.f_19797_);
        this.flyAnimationState.m_246184_(this.m_29443_() && !this.isRunning(), this.f_19797_);
        this.flyFastAnimationState.m_246184_(this.m_29443_() && this.isRunning(), this.f_19797_);
        this.splatAnimationState.m_246184_(this.hasSplat(), this.f_19797_);
        this.preen1AnimationState.m_246184_(this.getIdleState() == 1 && !this.preenAlt, this.f_19797_);
        this.preen2AnimationState.m_246184_(this.getIdleState() == 1 && this.preenAlt, this.f_19797_);
        this.peckAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
    }

    protected void preenCooldown() {
        this.preenCooldown = 700 + this.m_217043_().m_188503_(3600);
    }

    protected void peckCooldown() {
        this.peckCooldown = 800 + this.m_217043_().m_188503_(3600);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(SPLAT, (Object)false);
    }

    public boolean hasSplat() {
        return (Boolean)this.f_19804_.m_135370_(SPLAT);
    }

    public void setSplat(boolean splat) {
        this.f_19804_.m_135381_(SPLAT, (Object)splat);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.TELECREX_FOOD);
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.f_12190_;
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.TELECREX_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.TELECREX_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.TELECREX_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        this.m_5496_(SoundEvents.f_11754_, 0.06f, 1.0f);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.TELECREX.get()).m_20615_((Level)serverLevel);
    }

    public boolean m_6673_(DamageSource source) {
        return source.m_276093_(DamageTypes.f_268671_);
    }

    @NotNull
    public AABB m_6921_() {
        return this.m_20191_().m_82377_(3.0, 3.0, 3.0);
    }

    public boolean m_6783_(double distance) {
        return Math.sqrt(distance) < 1024.0;
    }

    public static boolean canSpawn(EntityType<Telecrex> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.TELECREX_SPAWNABLE_ON) && Telecrex.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class TelecrexScatterGoal
    extends Goal {
        private final Telecrex telecrex;

        public TelecrexScatterGoal(Telecrex telecrex) {
            this.telecrex = telecrex;
        }

        public boolean m_8036_() {
            if (this.telecrex.m_29443_()) {
                return false;
            }
            long worldTime = this.telecrex.m_9236_().m_46467_() % 10L;
            if (this.telecrex.m_217043_().m_188503_(10) != 0 && worldTime != 0L) {
                return false;
            }
            AABB aabb = this.telecrex.m_20191_().m_82400_(8.0);
            List list = this.telecrex.m_9236_().m_6443_(Entity.class, aabb, entity -> entity.m_6095_().m_204039_(UP2EntityTags.TELECREX_AVOIDS) || entity instanceof Player && !((Player)entity).m_7500_());
            return !list.isEmpty();
        }

        public boolean m_8045_() {
            return false;
        }

        public void m_8056_() {
            this.telecrex.setFlying(true);
            if (this.telecrex.m_20096_()) {
                this.telecrex.m_20256_(this.telecrex.m_20184_().m_82520_(0.0, 0.5, 0.0));
            }
        }
    }

    private static class TelecrexPreenGoal
    extends IdleAnimationGoal {
        private final Telecrex telecrex;

        public TelecrexPreenGoal(Telecrex telecrex) {
            super(telecrex, 60, 1);
            this.telecrex = telecrex;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && !this.telecrex.hasSplat() && this.telecrex.preenCooldown == 0 && !this.telecrex.m_29443_();
        }

        @Override
        public boolean m_8045_() {
            return super.m_8036_() && !this.telecrex.m_29443_();
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            this.telecrex.preenAlt = this.telecrex.m_217043_().m_188499_();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.telecrex.preenCooldown();
        }
    }

    private static class TelecrexPeckGoal
    extends IdleAnimationGoal {
        private final Telecrex telecrex;

        public TelecrexPeckGoal(Telecrex telecrex) {
            super(telecrex, 60, 2);
            this.telecrex = telecrex;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && !this.telecrex.hasSplat() && this.telecrex.peckCooldown == 0 && !this.telecrex.m_29443_() && this.telecrex.m_9236_().m_8055_(this.telecrex.m_20183_().m_7495_()).m_204336_(UP2BlockTags.TELECREX_PECKING_BLOCKS);
        }

        @Override
        public boolean m_8045_() {
            return super.m_8036_() && !this.telecrex.m_29443_();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.telecrex.peckCooldown();
        }
    }
}


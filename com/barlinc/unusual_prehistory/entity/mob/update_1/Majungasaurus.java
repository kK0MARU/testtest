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
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity$MovementEmission
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_1;

import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargeBabyPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricNearestAttackableTargetGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.update_1.MajungasaurusAttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Majungasaurus
extends PrehistoricMob {
    public static final EntityDataAccessor<Boolean> CAMO = SynchedEntityData.m_135353_(Majungasaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<Integer> CAMO_COOLDOWN = SynchedEntityData.m_135353_(Majungasaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    public float prevCamoProgress;
    public float camoProgress;
    public float prevAngryProgress;
    public float angryProgress;
    public final SmoothAnimationState eyesAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState attack2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState swimAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState yawnAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState sniff1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState sniff2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState shakeAnimationState = new SmoothAnimationState();
    public boolean attackAlt = false;
    private boolean sniffAlt = false;
    private int yawnCooldown = 500 + this.m_217043_().m_188503_(2500);
    private int shakeCooldown = 600 + this.m_217043_().m_188503_(3600);
    private int sniffCooldown = 700 + this.m_217043_().m_188503_(4200);

    public Majungasaurus(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new LargeBabyPanicGoal(this, 1.7, 10, 4));
        this.f_21345_.m_25352_(2, (Goal)new MajungasaurusAttackGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.MAJUNGASAURUS_FOOD), false));
        this.f_21345_.m_25352_(4, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(5, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.f_21345_.m_25352_(5, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(6, (Goal)new MajungasaurusAvoidEntityGoal<Majungasaurus>(this, Majungasaurus.class, this::avoidsParents){

            @Override
            public boolean m_8036_() {
                return super.m_8036_() && Majungasaurus.this.m_6162_();
            }
        });
        this.f_21345_.m_25352_(6, new MajungasaurusAvoidEntityGoal<LivingEntity>(this, LivingEntity.class, entity -> entity.m_6095_().m_204039_(UP2EntityTags.MAJUNGASAURUS_AVOIDS)));
        this.f_21345_.m_25352_(7, (Goal)new SleepingGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new MajungasaurusYawnGoal(this));
        this.f_21345_.m_25352_(8, (Goal)new MajungasaurusShakeGoal(this));
        this.f_21345_.m_25352_(9, (Goal)new MajungasaurusSniffGoal(this));
        this.f_21346_.m_25352_(1, new PrehistoricNearestAttackableTargetGoal<Majungasaurus>(this, Majungasaurus.class, 200, true, true, this::canCannibalize));
        this.f_21346_.m_25352_(2, new PrehistoricNearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 300, true, true, entity -> entity.m_6095_().m_204039_(UP2EntityTags.MAJUNGASAURUS_TARGETS)));
        this.f_21346_.m_25352_(3, new PrehistoricNearestAttackableTargetGoal<Player>(this, Player.class, 300, true, true, this::attacksPlayers));
        this.f_21346_.m_25352_(4, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 32.0).m_22268_(Attributes.f_22281_, 6.0).m_22268_(Attributes.f_22279_, (double)0.19f).m_22268_(Attributes.f_22277_, 32.0).m_22268_(Attributes.f_22278_, 0.25).m_22268_(Attributes.f_22284_, 4.0);
    }

    @Override
    protected void m_6475_(@NotNull DamageSource source, float amount) {
        if (this.isCamo()) {
            this.setCamo(false);
            this.camoCooldown();
        }
        super.m_6475_(source, amount);
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
        return 1.1f;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.MAJUNGASAURUS_FOOD);
    }

    public float getCamoProgress(float partialTicks) {
        return (this.prevCamoProgress + (this.camoProgress - this.prevCamoProgress) * partialTicks) * 0.1f;
    }

    public float getAngryProgress(float partialTicks) {
        return (this.prevAngryProgress + (this.angryProgress - this.prevAngryProgress) * partialTicks) * 0.2f;
    }

    public boolean canCannibalize(LivingEntity entity) {
        return this.m_6779_(entity) && (entity.m_21223_() < entity.m_21233_() * 0.5f || entity.m_6162_());
    }

    public boolean avoidsParents(LivingEntity entity) {
        Majungasaurus majungasaurus = (Majungasaurus)entity;
        return this.m_6162_() && !entity.m_6162_() && !majungasaurus.isCamo();
    }

    @Override
    public boolean canPacify() {
        return true;
    }

    @Override
    public boolean isPacifyItem(ItemStack itemStack) {
        return itemStack.m_204117_(UP2ItemTags.PACIFIES_MAJUNGASAURUS);
    }

    public boolean isNightTime() {
        return this.m_9236_().m_46468_() < 23000L && this.m_9236_().m_46468_() > 12000L && !this.m_9236_().m_6042_().m_63967_();
    }

    protected boolean attacksPlayers(LivingEntity entity) {
        return this.m_6779_(entity) && this.isNightTime();
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 3;
    }

    @Override
    public boolean isEepyTime() {
        return this.m_9236_().m_46461_();
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        this.prevCamoProgress = this.camoProgress;
        this.prevAngryProgress = this.angryProgress;
        if (this.isCamo() && this.camoProgress < 10.0f) {
            this.camoProgress += 1.0f;
        } else if (!this.isCamo() && this.camoProgress > 0.0f) {
            this.camoProgress -= 1.0f;
        }
        if (this.m_5912_() && this.angryProgress < 5.0f) {
            this.angryProgress += 1.0f;
        } else if (!this.m_5912_() && this.angryProgress > 0.0f) {
            this.angryProgress -= 1.0f;
        }
        if (this.getCamoCooldown() > 0) {
            this.setCamoCooldown(this.getCamoCooldown() - 1);
        }
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.isEepy()) {
            if (this.yawnCooldown > 0) {
                --this.yawnCooldown;
            }
            if (this.shakeCooldown > 0) {
                --this.shakeCooldown;
            }
            if (this.sniffCooldown > 0) {
                --this.sniffCooldown;
            }
        }
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(!this.m_20069_() && !this.isEepy(), this.f_19797_);
        this.eyesAnimationState.m_246184_(!this.m_5912_() && !this.isEepy(), this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20069_(), this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
        this.attack1AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && !this.attackAlt, this.f_19797_);
        this.attack2AnimationState.m_246184_(this.m_20089_() == UP2Poses.ATTACKING.get() && this.attackAlt, this.f_19797_);
        this.yawnAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.shakeAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
        this.sniff1AnimationState.m_246184_(this.getIdleState() == 3 && !this.sniffAlt, this.f_19797_);
        this.sniff2AnimationState.m_246184_(this.getIdleState() == 3 && this.sniffAlt, this.f_19797_);
    }

    @Override
    public float getWalkAnimationSpeed() {
        return this.m_6162_() ? 2.0f : 4.0f;
    }

    protected void yawnCooldown() {
        this.yawnCooldown = 500 + this.m_217043_().m_188503_(2500);
    }

    protected void shakeCooldown() {
        this.shakeCooldown = 600 + this.m_217043_().m_188503_(3600);
    }

    protected void sniffCooldown() {
        this.sniffCooldown = 700 + this.m_217043_().m_188503_(4200);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(CAMO, (Object)false);
        this.f_19804_.m_135372_(CAMO_COOLDOWN, (Object)0);
    }

    public boolean isCamo() {
        return (Boolean)this.f_19804_.m_135370_(CAMO);
    }

    public void setCamo(boolean camo) {
        this.f_19804_.m_135381_(CAMO, (Object)camo);
    }

    public int getCamoCooldown() {
        return (Integer)this.f_19804_.m_135370_(CAMO_COOLDOWN);
    }

    public void setCamoCooldown(int cooldown) {
        this.f_19804_.m_135381_(CAMO_COOLDOWN, (Object)cooldown);
    }

    public void camoCooldown() {
        this.setCamoCooldown(30 + this.m_217043_().m_188503_(10));
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        Majungasaurus majungasaurus = (Majungasaurus)((EntityType)UP2Entities.MAJUNGASAURUS.get()).m_20615_((Level)level);
        if (majungasaurus != null) {
            majungasaurus.setVariant(this.getVariant());
        }
        return majungasaurus;
    }

    @Override
    public boolean canPlayAmbientSound() {
        return !this.isCamo() && super.canPlayAmbientSound();
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.MAJUNGASAURUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.MAJUNGASAURUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.MAJUNGASAURUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        if (!this.isCamo()) {
            this.m_5496_((SoundEvent)UP2SoundEvents.MAJUNGASAURUS_STEP.get(), 1.0f, 0.9f);
        }
    }

    @NotNull
    protected Entity.MovementEmission m_142319_() {
        return this.isCamo() ? Entity.MovementEmission.NONE : super.m_142319_();
    }

    @Override
    public int getVariantCount() {
        return MajungasaurusVariant.values().length;
    }

    @NotNull
    public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag compoundTag) {
        if (level.m_213780_().m_188499_() && level.m_6018_().m_46462_()) {
            this.setVariant(1);
        } else {
            this.setVariant(0);
        }
        return super.m_6518_(level, difficulty, spawnType, spawnData, compoundTag);
    }

    public static boolean canSpawn(EntityType<Majungasaurus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.MAJUNGASAURUS_SPAWNABLE_ON) && Majungasaurus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class MajungasaurusAvoidEntityGoal<T extends LivingEntity>
    extends PrehistoricAvoidEntityGoal<T> {
        private final Majungasaurus majungasaurus;

        public MajungasaurusAvoidEntityGoal(Majungasaurus mob, Class<T> classToAvoid, Predicate<LivingEntity> predicateOnAvoid) {
            super((PrehistoricMob)mob, classToAvoid, 12.0f, 1.7, predicateOnAvoid);
            this.majungasaurus = mob;
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            if (this.majungasaurus.getCamoCooldown() == 0) {
                this.majungasaurus.setCamo(true);
            }
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.majungasaurus.setCamo(false);
            this.majungasaurus.camoCooldown();
        }

        public void m_8037_() {
            this.mob.m_21573_().m_26517_(this.majungasaurus.isCamo() ? 0.9 : 2.0);
        }
    }

    private static class MajungasaurusYawnGoal
    extends IdleAnimationGoal {
        private final Majungasaurus majungasaurus;

        public MajungasaurusYawnGoal(Majungasaurus majungasaurus) {
            super(majungasaurus, 60, 1, false);
            this.majungasaurus = majungasaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.majungasaurus.yawnCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.majungasaurus.yawnCooldown();
        }
    }

    private static class MajungasaurusShakeGoal
    extends IdleAnimationGoal {
        private final Majungasaurus majungasaurus;

        public MajungasaurusShakeGoal(Majungasaurus majungasaurus) {
            super(majungasaurus, 80, 2, false);
            this.majungasaurus = majungasaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.majungasaurus.shakeCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.majungasaurus.shakeCooldown();
        }
    }

    private static class MajungasaurusSniffGoal
    extends IdleAnimationGoal {
        private final Majungasaurus majungasaurus;

        public MajungasaurusSniffGoal(Majungasaurus majungasaurus) {
            super(majungasaurus, 80, 3);
            this.majungasaurus = majungasaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.majungasaurus.sniffCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.majungasaurus.sniffCooldown();
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            this.majungasaurus.sniffAlt = this.majungasaurus.m_217043_().m_188499_();
        }

        @Override
        public void m_8037_() {
            super.m_8037_();
            if (this.timer == 50) {
                this.majungasaurus.m_5496_((SoundEvent)UP2SoundEvents.MAJUNGASAURUS_SNIFF.get(), 1.0f, this.majungasaurus.m_6100_());
            }
        }
    }

    public static enum MajungasaurusVariant {
        MAJUNGASAURUS(0),
        DUSKLURKER(1);

        private final int id;

        private MajungasaurusVariant(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static MajungasaurusVariant byId(int id) {
            if (id < 0 || id >= MajungasaurusVariant.values().length) {
                id = 0;
            }
            return MajungasaurusVariant.values()[id];
        }
    }
}


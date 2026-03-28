/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.entity.PartEntity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_4;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.LargeBabyPanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.SleepingGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import com.barlinc.unusual_prehistory.entity.mob.update_4.BrachiosaurusPart;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.events.ScreenShakeEvent;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Particles;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import com.barlinc.unusual_prehistory.utils.UP2Math;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Brachiosaurus
extends SemiAquaticMob {
    private static final EntityDataAccessor<Integer> STOMP_COOLDOWN = SynchedEntityData.m_135353_(Brachiosaurus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private final BrachiosaurusPart[] allParts;
    public final BrachiosaurusPart headPart;
    public final BrachiosaurusPart neckPart1;
    public final BrachiosaurusPart neckPart2;
    public final BrachiosaurusPart tailPart1;
    public final BrachiosaurusPart tailPart2;
    private double lastStompX = 0.0;
    private double lastStompZ = 0.0;
    private float screenShakeAmount;
    private float neckXRot;
    private float neckYRot;
    private float[] yawBuffer = new float[128];
    private int yawPointer = -1;
    private boolean wasPreviouslyBaby;
    public final SmoothAnimationState stompAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState callAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState shakeAnimationState = new SmoothAnimationState();
    public int callCooldown = 1500 + this.m_217043_().m_188503_(1500);
    public int shakeCooldown = 900 + this.m_217043_().m_188503_(900);

    public Brachiosaurus(EntityType<? extends SemiAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.m_21441_(BlockPathTypes.WATER, 0.0f);
        this.m_21441_(BlockPathTypes.WATER_BORDER, 0.0f);
        this.m_21441_(BlockPathTypes.FENCE, 0.0f);
        this.headPart = new BrachiosaurusPart(this, "head", 2.5f, 2.5f);
        this.neckPart1 = new BrachiosaurusPart(this, "neck1", 2.5f, 6.0f);
        this.neckPart2 = new BrachiosaurusPart(this, "neck2", 2.5f, 6.0f);
        this.tailPart1 = new BrachiosaurusPart(this, "tail1", 2.5f, 2.5f);
        this.tailPart2 = new BrachiosaurusPart(this, "tail2", 2.0f, 2.0f);
        this.allParts = new BrachiosaurusPart[]{this.headPart, this.neckPart1, this.neckPart2, this.tailPart1, this.tailPart2};
        this.m_20234_(f_19843_.getAndAdd(this.allParts.length + 1) + 1);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 400.0).m_22268_(Attributes.f_22279_, (double)0.17f).m_22268_(Attributes.f_22281_, 24.0).m_22268_(Attributes.f_22278_, 1.0).m_22268_(Attributes.f_22277_, 20.0);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new LargeBabyPanicGoal(this, 1.8, 10, 4));
        this.f_21345_.m_25352_(1, (Goal)new BrachiosaurusAttackGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.BRACHIOSAURUS_FOOD), false));
        this.f_21345_.m_25352_(3, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(4, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.f_21345_.m_25352_(5, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(6, (Goal)new SleepingGoal(this));
        this.f_21345_.m_25352_(7, (Goal)new BrachiosaurusCallGoal(this));
        this.f_21345_.m_25352_(7, (Goal)new BrachiosaurusShakeGoal(this));
        this.f_21346_.m_25352_(0, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
    }

    public void m_20234_(int i1) {
        super.m_20234_(i1);
        for (int i = 0; i < this.allParts.length; ++i) {
            this.allParts[i].m_20234_(i1 + i + 1);
        }
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.98f;
    }

    protected float m_6108_() {
        return 0.9f;
    }

    @Override
    @NotNull
    protected PathNavigation m_6037_(@NotNull Level level) {
        NoSpinGroundPathNavigation navigation = new NoSpinGroundPathNavigation((Mob)this, level, 1.0f);
        navigation.m_255224_(true);
        return navigation;
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if (this.refuseToMove() && this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        if (this.m_21515_() && this.m_20069_() && !this.m_20096_()) {
            this.m_20256_(this.m_20184_().m_82520_(0.0, -0.01, 0.0));
        }
        super.m_7023_(travelVec);
    }

    public float getStepHeight() {
        return this.m_6162_() ? 1.0f : 3.0f;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.BRACHIOSAURUS_FOOD);
    }

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1;
    }

    public boolean m_5829_() {
        return !this.m_5912_() && !this.m_6162_();
    }

    @Override
    public boolean m_6094_() {
        return this.m_6162_();
    }

    @Override
    public void doEepyParticles() {
        Vec3 lookVec = this.getEepyParticleVec();
        Vec3 eyeVec = this.headPart.m_146892_().m_82549_(lookVec);
        if (this.eepyTicks == 0) {
            this.eepyTicks = 40 + this.f_19796_.m_188503_(20);
            this.m_9236_().m_7106_((ParticleOptions)UP2Particles.EEPY.get(), eyeVec.f_82479_, eyeVec.f_82480_ + (double)((1.0f - this.f_19796_.m_188501_()) * 0.3f), eyeVec.f_82481_, 1.0, 0.0, 0.0);
        }
        if (this.eepyTicks > 0) {
            --this.eepyTicks;
        }
    }

    @Override
    public Vec3 getEepyParticleVec() {
        return new Vec3(0.0, (double)-0.7f, (double)(-this.m_20205_() * 0.4f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    @Override
    public void m_8119_() {
        if (this.m_6162_()) {
            this.tickMultipartBaby();
        } else {
            this.tickMultipart();
        }
        super.m_8119_();
        this.lastStompX = this.m_20185_();
        this.lastStompZ = this.m_20189_();
        if (!this.m_6162_()) {
            this.f_20883_ = Mth.m_14148_((float)this.f_20884_, (float)this.m_146908_(), (float)4.0f);
        }
        if (this.screenShakeAmount > 0.0f) {
            this.screenShakeAmount = Math.max(0.0f, this.screenShakeAmount - 0.34f);
        }
        if (this.m_20096_() && this.f_267362_.m_267731_() > 0.1f && !this.m_6162_()) {
            this.tickFootsteps();
        }
        if (this.wasPreviouslyBaby != this.m_6162_()) {
            this.wasPreviouslyBaby = this.m_6162_();
            this.m_6210_();
            for (BrachiosaurusPart brachiosaurusPart : this.allParts) {
                brachiosaurusPart.m_6210_();
            }
        }
        if (this.getStompCooldown() > 0) {
            this.setStompCooldown(this.getStompCooldown() - 1);
        }
    }

    public float m_6134_() {
        return this.m_6162_() ? 0.25f : 1.0f;
    }

    private void tickMultipart() {
        float headAdditionalZ;
        if (this.yawPointer == -1) {
            for (int i = 0; i < this.yawBuffer.length; ++i) {
                this.yawBuffer[i] = this.f_20883_;
            }
        }
        if (++this.yawPointer == this.yawBuffer.length) {
            this.yawPointer = 0;
        }
        this.yawBuffer[this.yawPointer] = this.f_20883_;
        Vec3[] avector3d = new Vec3[this.allParts.length];
        for (int j = 0; j < this.allParts.length; ++j) {
            avector3d[j] = new Vec3(this.allParts[j].m_20185_(), this.allParts[j].m_20186_(), this.allParts[j].m_20189_());
        }
        Vec3 center = this.m_20182_().m_82520_(0.0, (double)this.m_20206_(), 0.0);
        this.neckXRot = this.wrapNeckDegrees(Mth.m_14148_((float)this.neckXRot, (float)-30.0f, (float)45.0f));
        this.neckYRot = this.wrapNeckDegrees(Mth.m_14148_((float)this.neckYRot, (float)this.getTargetNeckYRot(), (float)45.0f));
        float headXStep = this.neckXRot / 4.0f;
        float headYStep = this.neckYRot / 4.0f;
        boolean isMoving = this.f_267362_.m_267731_() > 0.1f;
        float headAdditionalY = isMoving ? -0.8f : 0.0f;
        float f = headAdditionalZ = isMoving ? 3.0f : 0.0f;
        if (this.isEepy()) {
            headAdditionalZ = -2.0f;
        }
        float neck1AdditionalY = isMoving ? 0.8f : 0.0f;
        float neck1AdditionalZ = isMoving ? -1.0f : 0.0f;
        float neck2AdditionalY = isMoving ? 0.8f : 0.0f;
        float neck2AdditionalZ = isMoving ? -1.0f : 0.0f;
        this.headPart.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, (double)(10.5f + headAdditionalY), (double)(7.8f + headAdditionalZ)).m_82490_((double)this.m_6134_()), headXStep, this.f_20883_ + headYStep).m_82549_(center));
        this.neckPart1.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, (double)(-4.0f + neck1AdditionalY), (double)(-2.2f + neck1AdditionalZ)).m_82490_((double)this.m_6134_()), headXStep, this.f_20883_ + headYStep).m_82549_(this.headPart.centeredPosition()));
        this.neckPart2.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, (double)(-6.0f + neck2AdditionalY), (double)(-2.2f + neck2AdditionalZ)).m_82490_((double)this.m_6134_()), headXStep, this.f_20883_ + headYStep).m_82549_(this.neckPart1.centeredPosition()));
        this.tailPart1.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, -3.5, -4.0).m_82490_((double)this.m_6134_()), headXStep, this.f_20883_).m_82549_(center));
        this.tailPart2.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, -1.0, -3.0).m_82490_((double)this.m_6134_()), headXStep, this.f_20883_).m_82549_(this.tailPart1.centeredPosition()));
        for (int l = 0; l < this.allParts.length; ++l) {
            this.allParts[l].f_19854_ = avector3d[l].f_82479_;
            this.allParts[l].f_19855_ = avector3d[l].f_82480_;
            this.allParts[l].f_19856_ = avector3d[l].f_82481_;
            this.allParts[l].f_19790_ = avector3d[l].f_82479_;
            this.allParts[l].f_19791_ = avector3d[l].f_82480_;
            this.allParts[l].f_19792_ = avector3d[l].f_82481_;
        }
    }

    private void tickMultipartBaby() {
        if (this.yawPointer == -1) {
            for (int i = 0; i < this.yawBuffer.length; ++i) {
                this.yawBuffer[i] = this.f_20883_;
            }
        }
        if (++this.yawPointer == this.yawBuffer.length) {
            this.yawPointer = 0;
        }
        this.yawBuffer[this.yawPointer] = this.f_20883_;
        Vec3[] avector3d = new Vec3[this.allParts.length];
        for (int j = 0; j < this.allParts.length; ++j) {
            avector3d[j] = new Vec3(this.allParts[j].m_20185_(), this.allParts[j].m_20186_(), this.allParts[j].m_20189_());
        }
        Vec3 center = this.m_20182_().m_82520_(0.0, (double)this.m_20206_(), 0.0);
        this.neckXRot = this.wrapNeckDegrees(Mth.m_14148_((float)this.neckXRot, (float)-30.0f, (float)45.0f));
        this.neckYRot = this.wrapNeckDegrees(Mth.m_14148_((float)this.neckYRot, (float)this.getTargetNeckYRot(), (float)45.0f));
        float headXStep = this.neckXRot / 4.0f;
        float headYStep = this.neckYRot / 4.0f;
        this.headPart.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, (double)5.1f, (double)6.8f).m_82490_((double)this.m_6134_()), headXStep, this.f_20883_ + headYStep).m_82549_(center));
        this.neckPart1.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, -1.5, -2.0).m_82490_((double)this.m_6134_()), headXStep, this.f_20883_ + headYStep).m_82549_(this.headPart.centeredPosition()));
        this.neckPart2.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, -3.0, -2.0).m_82490_((double)this.m_6134_()), headXStep, this.f_20883_ + headYStep).m_82549_(this.neckPart1.centeredPosition()));
        this.tailPart1.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, -3.0, -3.0).m_82490_((double)this.m_6134_()), headXStep, this.f_20883_).m_82549_(center));
        this.tailPart2.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, 0.0, -2.0).m_82490_((double)this.m_6134_()), headXStep, this.f_20883_).m_82549_(this.tailPart1.centeredPosition()));
        for (int l = 0; l < this.allParts.length; ++l) {
            this.allParts[l].f_19854_ = avector3d[l].f_82479_;
            this.allParts[l].f_19855_ = avector3d[l].f_82480_;
            this.allParts[l].f_19856_ = avector3d[l].f_82481_;
            this.allParts[l].f_19790_ = avector3d[l].f_82479_;
            this.allParts[l].f_19791_ = avector3d[l].f_82480_;
            this.allParts[l].f_19792_ = avector3d[l].f_82481_;
        }
    }

    private float wrapNeckDegrees(float f) {
        return f % 360.0f;
    }

    private Vec3 rotateOffsetVec(Vec3 offset, float xRot, float yRot) {
        return offset.m_82496_(-xRot * ((float)Math.PI / 180)).m_82524_(-yRot * ((float)Math.PI / 180));
    }

    public float getYawFromBuffer(int pointer, float partialTick) {
        int i = this.yawPointer - pointer & 0x7F;
        int j = this.yawPointer - pointer - 1 & 0x7F;
        float d0 = this.yawBuffer[j];
        float d1 = this.yawBuffer[i] - d0;
        return d0 + d1 * partialTick;
    }

    public float getTargetNeckYRot() {
        float buffered = this.getYawFromBuffer(10, 1.0f) - this.f_20883_;
        return this.m_6080_() - this.f_20883_ + buffered;
    }

    public boolean isMultipartEntity() {
        return true;
    }

    public PartEntity<?>[] getParts() {
        return this.allParts;
    }

    private void tickFootsteps() {
        float walkPosition = (float)Math.cos(this.f_267362_.m_267756_() * 0.515f - 1.5f);
        if (Math.abs(walkPosition) < 0.2f) {
            if (this.screenShakeAmount <= 0.3f) {
                if (this.isInFluidType()) {
                    this.m_5496_((SoundEvent)UP2SoundEvents.BRACHIOSAURUS_STEP.get(), 1.5f, 0.8f + this.m_217043_().m_188501_() * 0.2f);
                } else {
                    this.m_5496_((SoundEvent)UP2SoundEvents.BRACHIOSAURUS_STEP.get(), 2.5f, 0.9f + this.m_217043_().m_188501_() * 0.2f);
                }
                UnusualPrehistory2.PROXY.screenShake(new ScreenShakeEvent(this.m_20182_(), 10, 2.5f, 16.0f, false));
            }
            this.screenShakeAmount = 1.0f;
        }
    }

    @Override
    public void m_267651_(boolean flying) {
        float f1 = (float)Mth.m_184648_((double)(this.m_20185_() - this.lastStompX), (double)0.0, (double)(this.m_20189_() - this.lastStompZ));
        float f2 = Math.min(f1 * this.getWalkAnimationSpeed(), 1.0f);
        this.f_267362_.m_267566_(f2, 0.4f);
    }

    @Override
    public float getWalkAnimationSpeed() {
        return this.m_6162_() ? 3.0f : 4.0f;
    }

    public int m_21529_() {
        return this.m_6162_() ? super.m_21529_() : 4;
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.m_246184_(this.m_20089_() != UP2Poses.STOMPING.get() && !this.isEepy(), this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
        this.stompAnimationState.m_246184_(this.m_20089_() == UP2Poses.STOMPING.get(), this.f_19797_);
        this.callAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.shakeAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.m_9236_().f_46443_ && this.m_5448_() == null && !this.isEepy()) {
            if (this.callCooldown > 0) {
                --this.callCooldown;
            }
            if (this.shakeCooldown > 0) {
                --this.shakeCooldown;
            }
        }
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(STOMP_COOLDOWN, (Object)0);
    }

    public void setStompCooldown(int cooldown) {
        this.f_19804_.m_135381_(STOMP_COOLDOWN, (Object)cooldown);
    }

    public int getStompCooldown() {
        return (Integer)this.f_19804_.m_135370_(STOMP_COOLDOWN);
    }

    @NotNull
    public AABB m_6921_() {
        return this.m_20191_().m_82377_(4.0, 6.0, 4.0);
    }

    public boolean m_6783_(double distance) {
        return Math.sqrt(distance) < 1024.0;
    }

    @Override
    public void m_7822_(byte id) {
        if (id == 40) {
            this.stompEffect();
        } else {
            super.m_7822_(id);
        }
    }

    private void stompEffect() {
        Vec3 groundedVec = UP2Math.getGroundBelowPosition((BlockGetter)this.m_9236_(), new Vec3(this.m_20208_(2.0), this.m_20186_() + 0.25, this.m_20262_(2.0)));
        BlockPos ground = BlockPos.m_274446_((Position)groundedVec.m_82492_(0.0, 0.5, 0.0));
        BlockState state = this.m_9236_().m_8055_(ground);
        for (int i = 0; i <= this.m_217043_().m_188503_(60) + 80; ++i) {
            this.m_9236_().m_6493_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, state), true, this.m_20208_(2.0), this.m_20186_() + 0.25, this.m_20262_(2.0), 0.0, 0.0, 0.0);
        }
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.BRACHIOSAURUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.BRACHIOSAURUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.BRACHIOSAURUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        if (this.m_6162_()) {
            super.m_7355_(pos, state);
        }
    }

    public float m_6121_() {
        return this.m_6162_() ? 1.0f : 3.0f;
    }

    public int m_8100_() {
        return 360;
    }

    @Override
    public boolean canPlayAmbientSound() {
        return super.canPlayAmbientSound() && this.getIdleState() != 1;
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.BRACHIOSAURUS.get()).m_20615_((Level)level);
    }

    public static boolean canSpawn(EntityType<Brachiosaurus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.BRACHIOSAURUS_SPAWNABLE_ON) && Brachiosaurus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class BrachiosaurusAttackGoal
    extends AttackGoal {
        private final Brachiosaurus brachiosaurus;

        public BrachiosaurusAttackGoal(Brachiosaurus brachiosaurus) {
            super(brachiosaurus);
            this.brachiosaurus = brachiosaurus;
        }

        public void m_8037_() {
            LivingEntity target = this.brachiosaurus.m_5448_();
            if (target != null) {
                double distance = this.brachiosaurus.m_20280_((Entity)target);
                this.brachiosaurus.m_21391_((Entity)target, 30.0f, 30.0f);
                this.brachiosaurus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
                if (this.brachiosaurus.getAttackState() == 1) {
                    this.brachiosaurus.m_21573_().m_26573_();
                    this.tickStomp();
                } else {
                    if (distance > this.getAttackReachSqr(target)) {
                        this.brachiosaurus.m_21573_().m_5624_((Entity)target, 1.5);
                    }
                    if (distance <= this.getAttackReachSqr(target) && this.brachiosaurus.getStompCooldown() <= 0) {
                        this.brachiosaurus.setAttackState(1);
                    }
                }
            }
        }

        protected void tickStomp() {
            ++this.timer;
            LivingEntity target = this.brachiosaurus.m_5448_();
            if (this.timer == 6) {
                this.brachiosaurus.m_5496_((SoundEvent)UP2SoundEvents.BRACHIOSAURUS_ATTACK.get(), 4.0f, 1.0f);
            }
            if (this.timer == 10) {
                this.brachiosaurus.m_20124_(UP2Poses.STOMPING.get());
            }
            if (this.timer == 51) {
                for (LivingEntity entity : this.brachiosaurus.m_9236_().m_45976_(LivingEntity.class, this.brachiosaurus.m_20191_().m_82377_(6.0, -0.5, 6.0))) {
                    if (entity == this.brachiosaurus) continue;
                    entity.m_6469_(this.brachiosaurus.m_269291_().m_269333_((LivingEntity)this.brachiosaurus), (float)this.brachiosaurus.m_21133_(Attributes.f_22281_));
                    this.brachiosaurus.strongKnockback((Entity)entity, 9.0, 0.55);
                }
                UnusualPrehistory2.PROXY.screenShake(new ScreenShakeEvent(this.brachiosaurus.m_20182_(), 40, 4.0f, 32.0f, false));
                this.brachiosaurus.m_9236_().m_7605_((Entity)this.brachiosaurus, (byte)40);
            }
            if (this.timer > 70) {
                this.brachiosaurus.m_21391_((Entity)target, 30.0f, 30.0f);
                this.brachiosaurus.m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
            }
            if (this.timer > 80) {
                this.timer = 0;
                this.brachiosaurus.m_20124_(Pose.STANDING);
                this.brachiosaurus.setAttackState(0);
                this.brachiosaurus.setStompCooldown(24 + this.brachiosaurus.m_217043_().m_188503_(20));
            }
        }
    }

    private static class BrachiosaurusCallGoal
    extends IdleAnimationGoal {
        private final Brachiosaurus brachiosaurus;

        public BrachiosaurusCallGoal(Brachiosaurus brachiosaurus) {
            super(brachiosaurus, 60, 1, true, false);
            this.brachiosaurus = brachiosaurus;
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            this.brachiosaurus.m_5496_((SoundEvent)UP2SoundEvents.BRACHIOSAURUS_CALL.get(), 4.0f, 0.9f + this.brachiosaurus.m_217043_().m_188501_() * 0.15f);
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.brachiosaurus.callCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.brachiosaurus.callCooldown = 1500 + this.brachiosaurus.m_217043_().m_188503_(1500);
        }
    }

    private static class BrachiosaurusShakeGoal
    extends IdleAnimationGoal {
        private final Brachiosaurus brachiosaurus;

        public BrachiosaurusShakeGoal(Brachiosaurus brachiosaurus) {
            super(brachiosaurus, 100, 2, false, false);
            this.brachiosaurus = brachiosaurus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.brachiosaurus.shakeCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.brachiosaurus.shakeCooldown = 900 + this.brachiosaurus.m_217043_().m_188503_(900);
        }
    }
}


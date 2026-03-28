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
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl
 *  net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.entity.PartEntity
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.future;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.ai.goals.AquaticLeapGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricAquaticMob;
import com.barlinc.unusual_prehistory.entity.mob.future.AegirocassisPart;
import com.barlinc.unusual_prehistory.entity.utils.LeapingMob;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.NotNull;

public class Aegirocassis
extends PrehistoricAquaticMob
implements LeapingMob {
    private static final EntityDataAccessor<Boolean> LEAPING = SynchedEntityData.m_135353_(Aegirocassis.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public final AegirocassisPart headPart;
    public final AegirocassisPart tailPart1;
    public final AegirocassisPart tailPart2;
    private final AegirocassisPart[] allParts;
    private boolean wasPreviouslyBaby;
    private float fakeYRot = 0.0f;
    private float[] yawBuffer = new float[128];
    private int yawPointer = -1;
    public final SmoothAnimationState eyesAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState mouthAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState leapStartAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState leapAnimationState = new SmoothAnimationState();
    private int leapStartTicks;
    private int leapTicks;

    public Aegirocassis(EntityType<? extends PrehistoricAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.f_21342_ = new SmoothSwimmingMoveControl((Mob)this, 1000, 10, 0.02f, 0.1f, false);
        this.f_21365_ = new SmoothSwimmingLookControl((Mob)this, 10);
        this.headPart = new AegirocassisPart(this, (Entity)this, 3.6f, 4.1f);
        this.tailPart1 = new AegirocassisPart(this, (Entity)this, 3.6f, 4.1f);
        this.tailPart2 = new AegirocassisPart(this, (Entity)this.tailPart1, 3.6f, 4.1f);
        this.allParts = new AegirocassisPart[]{this.headPart, this.tailPart1, this.tailPart2};
        this.m_20234_(f_19843_.getAndAdd(this.allParts.length + 1) + 1);
        this.fakeYRot = this.m_146908_();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 200.0).m_22268_(Attributes.f_22279_, (double)0.7f).m_22268_(Attributes.f_22284_, 6.0).m_22268_(Attributes.f_22278_, 1.0);
    }

    @Override
    @NotNull
    public MobType m_6336_() {
        return MobType.f_21642_;
    }

    @Override
    public float m_5610_(@NotNull BlockPos pos, @NotNull LevelReader level) {
        return this.m_9236_().m_46462_() ? (level.m_6425_(pos).m_205070_(FluidTags.f_13131_) ? 10.0f : 0.0f) : this.getDepthPathfindingFavor(pos, level);
    }

    public void m_20234_(int id) {
        super.m_20234_(id);
        for (int i = 0; i < this.allParts.length; ++i) {
            this.allParts[i].m_20234_(id + i + 1);
        }
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.5f;
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.AEGIROCASSIS_FOOD);
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
    public boolean m_6094_() {
        return this.m_6162_();
    }

    @Override
    public boolean shouldFlop() {
        return false;
    }

    public float m_6134_() {
        return this.m_6162_() ? 0.25f : 1.0f;
    }

    public boolean isMultipartEntity() {
        return true;
    }

    public PartEntity<?>[] getParts() {
        return this.allParts;
    }

    @NotNull
    public AABB m_6921_() {
        return this.m_20191_().m_82377_(4.0, 6.0, 4.0);
    }

    public void m_142687_(@NotNull Entity.RemovalReason removalReason) {
        UnusualPrehistory2.PROXY.clearSoundCacheFor((Entity)this);
        super.m_142687_(removalReason);
        if (this.allParts != null) {
            for (AegirocassisPart aegirocassisPart : this.allParts) {
                aegirocassisPart.m_142687_(Entity.RemovalReason.KILLED);
            }
        }
    }

    public int m_21529_() {
        return 5;
    }

    @Override
    public void m_8119_() {
        this.tickMultipart();
        super.m_8119_();
        this.f_20883_ = Mth.m_14148_((float)this.f_20884_, (float)this.f_20883_, (float)this.m_21529_());
        this.fakeYRot = Mth.m_14148_((float)this.fakeYRot, (float)this.f_20883_, (float)10.0f);
        if (this.wasPreviouslyBaby != this.m_6162_()) {
            this.wasPreviouslyBaby = this.m_6162_();
            this.m_6210_();
            for (AegirocassisPart aegirocassisPart : this.allParts) {
                aegirocassisPart.m_6210_();
            }
        }
        if (this.m_20089_() == UP2Poses.START_FLYING.get() && this.leapStartTicks > 20 && !this.m_20072_() && this.m_20184_().f_82480_ < 0.0) {
            this.m_20256_(this.m_20184_().m_82542_(1.0, (double)0.3f, 1.0));
        }
        if (this.m_20089_() == Pose.FALL_FLYING && (this.m_20072_() || this.m_20096_())) {
            this.m_20124_(Pose.STANDING);
        }
        if (this.m_9236_().f_46443_ && this.m_6084_() && this.isLeaping()) {
            UnusualPrehistory2.PROXY.playWorldSound(this, (byte)2);
        }
    }

    @Override
    public void setupAnimationStates() {
        if (this.leapStartTicks == 0 && this.leapStartAnimationState.m_216984_()) {
            this.leapStartAnimationState.m_216973_();
        }
        if (this.leapTicks == 0 && this.leapAnimationState.m_216984_()) {
            this.leapAnimationState.m_216973_();
        }
        this.eyesAnimationState.m_246184_(this.m_6084_() && !this.isTryingToFly(), this.f_19797_);
        this.mouthAnimationState.m_246184_(this.m_20072_() && !this.isTryingToFly(), this.f_19797_);
        this.swimIdleAnimationState.m_246184_(this.m_20072_() && !this.isTryingToFly(), this.f_19797_);
        this.flopAnimationState.m_246184_(!this.m_20072_() && !this.isTryingToFly(), this.f_19797_);
        this.leapStartAnimationState.m_246184_(this.leapStartAnimationState.m_216984_(), this.f_19797_);
        this.leapAnimationState.m_246184_(this.leapAnimationState.m_216984_(), this.f_19797_);
    }

    public boolean isTryingToFly() {
        return this.m_20089_() == UP2Poses.START_FLYING.get() || this.m_20089_() == Pose.FALL_FLYING;
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (this.leapStartTicks > 0) {
            --this.leapStartTicks;
        }
        if (this.leapTicks > 0) {
            --this.leapTicks;
        }
        if (this.leapStartTicks == 0 && this.m_20089_() == UP2Poses.START_FLYING.get()) {
            this.m_20124_(Pose.FALL_FLYING);
        }
        if (this.leapTicks == 0 && this.m_20089_() == Pose.FALL_FLYING) {
            this.m_20124_(Pose.STANDING);
        }
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (f_19806_.equals(accessor)) {
            if (this.m_20089_() == UP2Poses.START_FLYING.get()) {
                this.leapStartAnimationState.m_216977_(this.f_19797_);
                this.leapStartTicks = 120;
            }
            if (this.m_20089_() == Pose.FALL_FLYING) {
                this.leapStartAnimationState.m_216973_();
                this.leapAnimationState.m_216977_(this.f_19797_);
                this.leapTicks = 60;
            } else if (this.m_20089_() == Pose.STANDING) {
                this.leapStartAnimationState.m_216973_();
                this.leapAnimationState.m_216973_();
            }
        }
        super.m_7350_(accessor);
    }

    private void tickMultipart() {
        if (this.yawPointer == -1) {
            this.fakeYRot = this.f_20883_;
            for (int i = 0; i < this.yawBuffer.length; ++i) {
                this.yawBuffer[i] = this.fakeYRot;
            }
        }
        if (++this.yawPointer == this.yawBuffer.length) {
            this.yawPointer = 0;
        }
        this.yawBuffer[this.yawPointer] = this.fakeYRot;
        Vec3[] avector3d = new Vec3[this.allParts.length];
        for (int j = 0; j < this.allParts.length; ++j) {
            avector3d[j] = new Vec3(this.allParts[j].m_20185_(), this.allParts[j].m_20186_(), this.allParts[j].m_20189_());
        }
        Vec3 center = this.m_20182_().m_82520_(0.0, (double)(this.m_20206_() * 0.5f), 0.0);
        float headOffset = this.m_6162_() ? 0.8f : 4.0f;
        float tailOffset = this.m_6162_() ? 0.5f : 4.0f;
        this.headPart.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, 0.0, (double)headOffset), this.m_146909_() * 0.33f, this.m_6080_()).m_82549_(center));
        this.tailPart1.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, 0.0, (double)(-tailOffset)), this.m_146909_() * 0.33f, this.getYawFromBuffer(2, 1.0f)).m_82549_(center));
        this.tailPart2.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, 0.0, (double)(-tailOffset)), this.m_146909_() * 0.33f, this.getYawFromBuffer(4, 1.0f)).m_82549_(this.tailPart1.centeredPosition()));
        for (int l = 0; l < this.allParts.length; ++l) {
            this.allParts[l].f_19854_ = avector3d[l].f_82479_;
            this.allParts[l].f_19855_ = avector3d[l].f_82480_;
            this.allParts[l].f_19856_ = avector3d[l].f_82481_;
            this.allParts[l].f_19790_ = avector3d[l].f_82479_;
            this.allParts[l].f_19791_ = avector3d[l].f_82480_;
            this.allParts[l].f_19792_ = avector3d[l].f_82481_;
        }
    }

    public float getTrailTransformation(int pointer, float partialTick) {
        if (this.m_213877_()) {
            partialTick = 1.0f;
        }
        int i = this.yawPointer - pointer & 0x7F;
        int j = this.yawPointer - pointer - 1 & 0x7F;
        float d0 = this.yawBuffer[j];
        float d1 = this.yawBuffer[i] - d0;
        return d0 + d1 * partialTick;
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

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.AEGIROCASSIS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.AEGIROCASSIS_DEATH.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.AEGIROCASSIS_HURT.get();
    }

    @Override
    @Nullable
    protected SoundEvent getFlopSound() {
        return SoundEvents.f_271165_;
    }

    public int m_8100_() {
        return 350;
    }

    @NotNull
    public ItemStack m_28282_() {
        return new ItemStack((ItemLike)UP2Items.BABY_AEGIROCASSIS_BUCKET.get());
    }

    @Override
    public boolean canBucket() {
        return this.m_6162_();
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.AEGIROCASSIS.get()).m_20615_((Level)serverLevel);
    }

    private static class AegirocassisTryToFlyGoal
    extends AquaticLeapGoal {
        private final Aegirocassis aegirocassis;

        public AegirocassisTryToFlyGoal(Aegirocassis aegirocassis) {
            super(aegirocassis, 50, 1.0, 1.25);
            this.aegirocassis = aegirocassis;
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            this.aegirocassis.m_20124_(UP2Poses.START_FLYING.get());
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && !this.aegirocassis.m_6162_();
        }

        @Override
        public boolean m_8045_() {
            Vec3 motion = this.aegirocassis.m_20184_();
            if (!this.aegirocassis.m_20072_() && motion.f_82480_ < -0.1) {
                return false;
            }
            if (this.aegirocassis.m_20096_()) {
                return false;
            }
            return this.aegirocassis.isLeaping();
        }

        @Override
        public void m_8037_() {
            boolean flag = this.breached;
            this.aegirocassis.m_21573_().m_26573_();
            if (!flag) {
                FluidState fluidstate = this.aegirocassis.m_9236_().m_6425_(this.aegirocassis.m_20183_());
                this.breached = fluidstate.m_205070_(FluidTags.f_13131_);
            }
            if (this.breached && !flag) {
                this.aegirocassis.m_5496_(SoundEvents.f_11805_, 1.0f, 1.0f);
            }
            Vec3 vec3 = this.aegirocassis.m_20184_();
            Vec3 movement = new Vec3((double)this.aegirocassis.m_6374_().m_122429_(), 0.0, (double)this.aegirocassis.m_6374_().m_122431_()).m_82541_().m_82490_((double)0.1f);
            Vec3 glide = new Vec3(movement.f_82479_, vec3.f_82480_, movement.f_82481_);
            this.aegirocassis.m_20256_(glide);
            this.aegirocassis.m_146922_((float)Mth.m_14136_((double)this.aegirocassis.m_6374_().m_122431_(), (double)this.aegirocassis.m_6374_().m_122429_()) * 57.295776f - 90.0f);
        }
    }
}


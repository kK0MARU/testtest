/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.entity.PartEntity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.future;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.mob.future.WonambiPart;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Wonambi
extends PrehistoricMob {
    public final WonambiPart body1Part;
    public final WonambiPart body2Part;
    public final WonambiPart body3Part;
    public final WonambiPart tail1Part;
    public final WonambiPart tail2Part;
    public final WonambiPart tail3Part;
    private final WonambiPart[] allParts;
    private float fakeYRot;
    private float[] yawBuffer = new float[128];
    private int yawPointer = -1;

    public Wonambi(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
        this.body1Part = new WonambiPart(this, (Entity)this, 0.9f, 0.5f);
        this.body2Part = new WonambiPart(this, (Entity)this.body1Part, 0.9f, 0.5f);
        this.body3Part = new WonambiPart(this, (Entity)this.body2Part, 0.9f, 0.5f);
        this.tail1Part = new WonambiPart(this, (Entity)this.body3Part, 0.9f, 0.5f);
        this.tail2Part = new WonambiPart(this, (Entity)this.tail1Part, 0.8f, 0.5f);
        this.tail3Part = new WonambiPart(this, (Entity)this.tail2Part, 0.7f, 0.5f);
        this.allParts = new WonambiPart[]{this.body1Part, this.body2Part, this.body3Part, this.tail1Part, this.tail2Part, this.tail3Part};
        this.m_20234_(f_19843_.getAndAdd(this.allParts.length + 1) + 1);
        this.fakeYRot = this.m_146908_();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 18.0).m_22268_(Attributes.f_22281_, 4.0).m_22268_(Attributes.f_22279_, 0.25);
    }

    public void m_20234_(int id) {
        super.m_20234_(id);
        for (int i = 0; i < this.allParts.length; ++i) {
            this.allParts[i].m_20234_(id + i + 1);
        }
    }

    public int m_21529_() {
        return 5;
    }

    public void m_7023_(@NotNull Vec3 travelVector) {
        super.m_7023_(travelVector);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.TARTUOSTEUS_FOOD);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions dimensions) {
        return dimensions.f_20378_ * 0.5f;
    }

    public boolean isMultipartEntity() {
        return true;
    }

    public PartEntity<?>[] getParts() {
        return this.allParts;
    }

    public void m_142687_(@NotNull Entity.RemovalReason removalReason) {
        super.m_142687_(removalReason);
        if (this.allParts != null) {
            for (WonambiPart part : this.allParts) {
                part.m_142687_(Entity.RemovalReason.KILLED);
            }
        }
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        this.f_20883_ = Mth.m_14148_((float)this.f_20884_, (float)this.f_20883_, (float)this.m_21529_());
        this.fakeYRot = Mth.m_14148_((float)this.fakeYRot, (float)this.f_20883_, (float)10.0f);
        this.tickMultipart();
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
        this.body1Part.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, 0.0, (double)-0.9f), this.m_146909_() * 0.25f, this.m_6080_()).m_82549_(center));
        this.body2Part.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, 0.0, (double)-0.9f), this.m_146909_() * 0.25f, this.getYawFromBuffer(2, 1.0f)).m_82549_(this.body1Part.centeredPosition()));
        this.body3Part.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, 0.0, (double)-0.9f), this.m_146909_() * 0.25f, this.getYawFromBuffer(4, 1.0f)).m_82549_(this.body2Part.centeredPosition()));
        this.tail1Part.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, 0.0, (double)-0.9f), this.m_146909_() * 0.25f, this.getYawFromBuffer(6, 1.0f)).m_82549_(this.body3Part.centeredPosition()));
        this.tail2Part.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, 0.0, (double)-0.9f), this.m_146909_() * 0.25f, this.getYawFromBuffer(8, 1.0f)).m_82549_(this.tail1Part.centeredPosition()));
        this.tail3Part.setPosCenteredY(this.rotateOffsetVec(new Vec3(0.0, 0.0, (double)-0.9f), this.m_146909_() * 0.25f, this.getYawFromBuffer(10, 1.0f)).m_82549_(this.tail2Part.centeredPosition()));
        for (int l = 0; l < this.allParts.length; ++l) {
            this.allParts[l].f_19854_ = avector3d[l].f_82479_;
            this.allParts[l].f_19855_ = avector3d[l].f_82480_;
            this.allParts[l].f_19856_ = avector3d[l].f_82481_;
            this.allParts[l].f_19790_ = avector3d[l].f_82479_;
            this.allParts[l].f_19791_ = avector3d[l].f_82480_;
            this.allParts[l].f_19792_ = avector3d[l].f_82481_;
        }
    }

    public float getTrailTransformation(int pointer, float partialTicks) {
        if (this.m_213877_()) {
            partialTicks = 1.0f;
        }
        int i = this.yawPointer - pointer & 0x7F;
        int j = this.yawPointer - pointer - 1 & 0x7F;
        float d0 = this.yawBuffer[j];
        float d1 = this.yawBuffer[i] - d0;
        return d0 + d1 * partialTicks;
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

    @NotNull
    public AABB m_6921_() {
        return this.m_20191_().m_82377_(6.0, 4.0, 6.0);
    }

    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.JAWLESS_FISH_DEATH.get();
    }

    protected SoundEvent m_7975_(@NotNull DamageSource damageSource) {
        return (SoundEvent)UP2SoundEvents.JAWLESS_FISH_HURT.get();
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        Wonambi wonambi = (Wonambi)((EntityType)UP2Entities.WONAMBI.get()).m_20615_((Level)serverLevel);
        wonambi.setVariant(this.getVariant());
        return wonambi;
    }

    public static boolean canSpawn(EntityType<Wonambi> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.TELECREX_SPAWNABLE_ON) && Wonambi.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }
}


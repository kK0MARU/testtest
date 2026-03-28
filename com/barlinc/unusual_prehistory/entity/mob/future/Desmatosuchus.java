/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.storage.loot.LootParams$Builder
 *  net.minecraft.world.level.storage.loot.LootTable
 *  net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
 *  net.minecraft.world.level.storage.loot.parameters.LootContextParams
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.common.Tags$Items
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.future;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.ai.goals.IdleAnimationGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Desmatosuchus
extends PrehistoricMob {
    private static final EntityDataAccessor<Integer> DIRTY = SynchedEntityData.m_135353_(Desmatosuchus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDataAccessor<Integer> ROLL_COOLDOWN = SynchedEntityData.m_135353_(Desmatosuchus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private static final EntityDimensions EEPY_DIMENSIONS = EntityDimensions.m_20395_((float)1.3f, (float)0.4f);
    public static final ResourceLocation[] SHEARING_LOOT = new ResourceLocation[]{UnusualPrehistory2.modPrefix("entities/desmatosuchus_shearing_moss"), UnusualPrehistory2.modPrefix("entities/desmatosuchus_shearing_mud"), UnusualPrehistory2.modPrefix("entities/desmatosuchus_shearing_snow")};
    public final SmoothAnimationState sniff1AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState sniff2AnimationState = new SmoothAnimationState();
    public final SmoothAnimationState shakeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState grazeAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState rollAnimationState = new SmoothAnimationState();
    private boolean sniffAlt = false;
    private int sniffCooldown = 700 + this.m_217043_().m_188503_(700);
    private int shakeCooldown = 600 + this.m_217043_().m_188503_(600);
    private int grazeCooldown = 800 + this.m_217043_().m_188503_(800);

    public Desmatosuchus(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 16.0).m_22268_(Attributes.f_22281_, 5.0).m_22268_(Attributes.f_22278_, 0.5).m_22268_(Attributes.f_22279_, (double)0.18f).m_22268_(Attributes.f_22284_, 12.0);
    }

    protected float m_6431_(@NotNull Pose pose, EntityDimensions size) {
        return size.f_20378_ * 0.9f;
    }

    @Override
    public double m_20204_() {
        if (this.m_20069_() && this.f_19862_) {
            return super.m_20204_();
        }
        return 0.5 * (double)this.m_20206_();
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

    @Override
    public boolean refuseToMove() {
        return super.refuseToMove() || this.getIdleState() == 1 || this.getIdleState() == 3 || this.getIdleState() == 4;
    }

    @Override
    public boolean isEepyTime() {
        return this.m_9236_().m_46462_() && this.m_9236_().m_8055_(this.m_20183_().m_7495_()).m_204336_(UP2BlockTags.DESMATOSUCHUS_PREFERRED_WALKING_BLOCKS);
    }

    @Override
    public Vec3 getEepyParticleVec() {
        return new Vec3(0.0, 0.0, (double)(-this.m_20205_() * 1.25f)).m_82524_((float)Math.toRadians(180.0f - this.m_6080_()));
    }

    @Override
    public float m_5610_(@NotNull BlockPos pos, @NotNull LevelReader level) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.DESMATOSUCHUS_PREFERRED_WALKING_BLOCKS) ? 10.0f : super.m_5610_(pos, level);
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.DESMATOSUCHUS_FOOD);
    }

    @NotNull
    public EntityDimensions m_6972_(@NotNull Pose pose) {
        return this.isEepy() ? EEPY_DIMENSIONS.m_20388_(this.m_6134_()) : super.m_6972_(pose);
    }

    public boolean m_7337_(@NotNull Entity entity) {
        return super.m_7337_(entity) && !(entity instanceof Desmatosuchus);
    }

    public boolean m_5829_() {
        return true;
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        InteractionResult type = super.m_6071_(player, hand);
        if (this.isDirty() && itemstack.m_204117_(Tags.Items.SHEARS)) {
            this.m_9236_().m_6269_(null, (Entity)this, SoundEvents.f_12344_, SoundSource.PLAYERS, 1.0f, 1.0f);
            this.m_146852_(GameEvent.f_157781_, (Entity)player);
            int dirtLevel = this.getDirtLevel();
            this.setDirtLevel(0);
            if (!this.m_9236_().f_46443_) {
                LootTable loottable = this.m_9236_().m_7654_().m_278653_().m_278676_(SHEARING_LOOT[dirtLevel - 1]);
                ObjectArrayList items = loottable.m_287195_(new LootParams.Builder((ServerLevel)this.m_9236_()).m_287286_(LootContextParams.f_81455_, (Object)this).m_287235_(LootContextParamSets.f_81417_));
                items.forEach(arg_0 -> ((Desmatosuchus)this).m_19983_(arg_0));
            }
            return InteractionResult.SUCCESS;
        }
        return type;
    }

    @Override
    public void tickCooldowns() {
        super.tickCooldowns();
        if (!this.isEepy()) {
            if (this.getRollCooldown() > 0) {
                this.setRollCooldown(this.getRollCooldown() - 1);
            }
            if (this.shakeCooldown > 0) {
                --this.shakeCooldown;
            }
            if (this.sniffCooldown > 0) {
                --this.sniffCooldown;
            }
            if (this.grazeCooldown > 0) {
                --this.grazeCooldown;
            }
        }
    }

    @Override
    public void setupAnimationStates() {
        super.setupAnimationStates();
        this.idleAnimationState.m_246184_(!this.m_20072_() && !this.isEepy() && this.getIdleState() != 1, this.f_19797_);
        this.swimAnimationState.m_246184_(this.m_20072_(), this.f_19797_);
        this.eepyAnimationState.m_246184_(this.isEepy(), this.f_19797_);
        this.rollAnimationState.m_246184_(this.getIdleState() == 1, this.f_19797_);
        this.shakeAnimationState.m_246184_(this.getIdleState() == 2, this.f_19797_);
        this.sniff1AnimationState.m_246184_(this.getIdleState() == 3 && !this.sniffAlt, this.f_19797_);
        this.sniff2AnimationState.m_246184_(this.getIdleState() == 3 && this.sniffAlt, this.f_19797_);
        this.grazeAnimationState.m_246184_(this.getIdleState() == 4, this.f_19797_);
    }

    protected void shakeCooldown() {
        this.shakeCooldown = 600 + this.m_217043_().m_188503_(600);
    }

    protected void sniffCooldown() {
        this.sniffCooldown = 700 + this.m_217043_().m_188503_(700);
    }

    protected void grazeCooldown() {
        this.grazeCooldown = 800 + this.m_217043_().m_188503_(800);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(DIRTY, (Object)0);
        this.f_19804_.m_135372_(ROLL_COOLDOWN, (Object)(1000 + this.m_217043_().m_188503_(4900)));
    }

    @Override
    public void m_7380_(@NotNull CompoundTag compoundTag) {
        super.m_7380_(compoundTag);
        compoundTag.m_128405_("Dirty", this.getDirtLevel());
        compoundTag.m_128405_("RollCooldown", this.getRollCooldown());
    }

    @Override
    public void m_7378_(@NotNull CompoundTag compoundTag) {
        super.m_7378_(compoundTag);
        this.setDirtLevel(compoundTag.m_128451_("Dirty"));
        this.setRollCooldown(compoundTag.m_128451_("RollCooldown"));
    }

    public boolean isDirty() {
        return (Integer)this.f_19804_.m_135370_(DIRTY) > 0;
    }

    public void setDirtLevel(int dirt) {
        this.f_19804_.m_135381_(DIRTY, (Object)dirt);
    }

    public int getDirtLevel() {
        return (Integer)this.f_19804_.m_135370_(DIRTY);
    }

    public int getRollCooldown() {
        return (Integer)this.f_19804_.m_135370_(ROLL_COOLDOWN);
    }

    public void setRollCooldown(int cooldown) {
        this.f_19804_.m_135381_(ROLL_COOLDOWN, (Object)cooldown);
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
        return (AgeableMob)((EntityType)UP2Entities.DESMATOSUCHUS.get()).m_20615_((Level)level);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.DESMATOSUCHUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource damageSourceIn) {
        return (SoundEvent)UP2SoundEvents.DESMATOSUCHUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.DESMATOSUCHUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.DESMATOSUCHUS_STEP.get(), 0.15f, 1.0f);
    }

    public int m_8100_() {
        return 200;
    }

    public static boolean canSpawn(EntityType<Desmatosuchus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.DESMATOSUCHUS_SPAWNABLE_ON) && Desmatosuchus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }

    private static class DesmatosuchusGrazeGoal
    extends IdleAnimationGoal {
        private final Desmatosuchus desmatosuchus;

        public DesmatosuchusGrazeGoal(Desmatosuchus desmatosuchus) {
            super(desmatosuchus, 40, 4);
            this.desmatosuchus = desmatosuchus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.desmatosuchus.grazeCooldown == 0 && this.desmatosuchus.m_9236_().m_8055_(this.desmatosuchus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.DESMATOSUCHUS_GRAZING_BLOCKS);
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.desmatosuchus.grazeCooldown();
        }
    }

    private static class DesmatosuchusSniffGoal
    extends IdleAnimationGoal {
        private final Desmatosuchus desmatosuchus;

        public DesmatosuchusSniffGoal(Desmatosuchus desmatosuchus) {
            super(desmatosuchus, 40, 3);
            this.desmatosuchus = desmatosuchus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.desmatosuchus.sniffCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.desmatosuchus.sniffCooldown();
        }

        @Override
        public void m_8056_() {
            super.m_8056_();
            this.desmatosuchus.sniffAlt = this.desmatosuchus.m_217043_().m_188499_();
        }
    }

    private static class DesmatosuchusShakeGoal
    extends IdleAnimationGoal {
        private final Desmatosuchus desmatosuchus;

        public DesmatosuchusShakeGoal(Desmatosuchus desmatosuchus) {
            super(desmatosuchus, 40, 2, false);
            this.desmatosuchus = desmatosuchus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.desmatosuchus.shakeCooldown == 0;
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.desmatosuchus.shakeCooldown();
        }
    }

    private static class DesmatosuchusRollGoal
    extends IdleAnimationGoal {
        private final Desmatosuchus desmatosuchus;

        public DesmatosuchusRollGoal(Desmatosuchus desmatosuchus) {
            super(desmatosuchus, 80, 1);
            this.desmatosuchus = desmatosuchus;
        }

        @Override
        public boolean m_8036_() {
            return super.m_8036_() && this.desmatosuchus.getRollCooldown() == 0 && this.isRollingBlock();
        }

        @Override
        public void m_8041_() {
            super.m_8041_();
            this.desmatosuchus.setRollCooldown(1200 + this.desmatosuchus.m_217043_().m_188503_(1200));
        }

        @Override
        public void m_8037_() {
            super.m_8037_();
            if (this.timer == 30 && !this.desmatosuchus.isDirty()) {
                if (this.desmatosuchus.m_9236_().m_8055_(this.desmatosuchus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.DESMATOSUCHUS_MOSSY_BLOCKS)) {
                    this.desmatosuchus.setDirtLevel(1);
                } else if (this.desmatosuchus.m_9236_().m_8055_(this.desmatosuchus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.DESMATOSUCHUS_MUDDY_BLOCKS)) {
                    this.desmatosuchus.setDirtLevel(2);
                } else if (this.desmatosuchus.m_9236_().m_8055_(this.desmatosuchus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.DESMATOSUCHUS_SNOWY_BLOCKS)) {
                    this.desmatosuchus.setDirtLevel(3);
                }
            }
        }

        protected boolean isRollingBlock() {
            return this.desmatosuchus.m_9236_().m_8055_(this.desmatosuchus.m_20183_().m_7495_()).m_204336_(UP2BlockTags.DESMATOSUCHUS_ROLLING_BLOCKS) || this.desmatosuchus.m_9236_().m_8055_(this.desmatosuchus.m_20183_()).m_204336_(UP2BlockTags.DESMATOSUCHUS_ROLLING_BLOCKS);
        }
    }
}


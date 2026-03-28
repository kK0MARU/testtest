/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Vec3i
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.ItemSteerable
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.common.ToolActions
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.update_4;

import com.barlinc.unusual_prehistory.entity.ai.goals.LargePanicGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricRandomStrollGoal;
import com.barlinc.unusual_prehistory.entity.ai.navigation.NoSpinGroundPathNavigation;
import com.barlinc.unusual_prehistory.entity.mob.base.SemiAquaticMob;
import com.barlinc.unusual_prehistory.entity.utils.SaddlelessItemBasedSteering;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.utils.SmoothAnimationState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ItemSteerable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Hibbertopterus
extends SemiAquaticMob
implements ItemSteerable {
    private static final EntityDataAccessor<Integer> PLOW_TIME = SynchedEntityData.m_135353_(Hibbertopterus.class, (EntityDataSerializer)EntityDataSerializers.f_135028_);
    private final SaddlelessItemBasedSteering steering;
    public final SmoothAnimationState plowAnimationState;

    public Hibbertopterus(EntityType<? extends SemiAquaticMob> entityType, Level level) {
        super(entityType, level);
        this.steering = new SaddlelessItemBasedSteering(this.f_19804_, PLOW_TIME);
        this.plowAnimationState = new SmoothAnimationState();
        this.m_21441_(BlockPathTypes.WATER_BORDER, 0.0f);
        this.m_21441_(BlockPathTypes.WATER, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 36.0).m_22268_(Attributes.f_22279_, (double)0.17f).m_22268_(Attributes.f_22284_, 10.0).m_22268_(Attributes.f_22278_, 0.5);
    }

    protected void m_8099_() {
        this.f_21345_.m_25352_(1, (Goal)new LargePanicGoal(this, 1.8, 10, 4, true));
        this.f_21345_.m_25352_(2, (Goal)new TemptGoal((PathfinderMob)this, 1.2, Ingredient.m_204132_(UP2ItemTags.HIBBERTOPTERUS_FOOD), false));
        this.f_21345_.m_25352_(3, (Goal)new PrehistoricRandomStrollGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(4, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.f_21345_.m_25352_(4, (Goal)new RandomLookAroundGoal((Mob)this));
    }

    @NotNull
    public MobType m_6336_() {
        return MobType.f_21642_;
    }

    @Override
    @NotNull
    public PathNavigation m_6037_(@NotNull Level level) {
        return new NoSpinGroundPathNavigation((Mob)this, level);
    }

    protected float m_6108_() {
        return 0.9f;
    }

    public void m_7023_(@NotNull Vec3 travelVec) {
        if ((this.refuseToMove() || this.isDancing()) && this.m_20096_()) {
            if (this.m_21573_().m_26570_() != null) {
                this.m_21573_().m_26573_();
            }
            travelVec = travelVec.m_82542_(0.0, 1.0, 0.0);
        }
        if (this.m_20069_()) {
            if (this.f_20899_) {
                this.m_20256_(this.m_20184_().m_82520_(0.0, 0.42, 0.0));
            } else {
                this.m_20256_(this.m_20184_().m_82520_(0.0, -0.05, 0.0));
            }
        }
        super.m_7023_(travelVec);
    }

    @Override
    public boolean canDanceToJukebox() {
        return true;
    }

    public float getStepHeight() {
        return 1.1f;
    }

    public boolean m_7337_(@NotNull Entity entity) {
        return super.m_7337_(entity) && !(entity instanceof Hibbertopterus);
    }

    public boolean m_5829_() {
        return this.m_6084_() && !this.m_6162_();
    }

    public boolean m_6898_(ItemStack stack) {
        return stack.m_204117_(UP2ItemTags.HIBBERTOPTERUS_FOOD);
    }

    @Override
    @Nullable
    public LivingEntity m_6688_() {
        Player player;
        Entity entity = this.m_146895_();
        if (entity instanceof Player && ((player = (Player)entity).m_21205_().m_150930_((Item)UP2Items.DIRT_ON_A_STICK.get()) || player.m_21206_().m_150930_((Item)UP2Items.DIRT_ON_A_STICK.get()))) {
            return player;
        }
        return null;
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        boolean flag = this.m_6898_(player.m_21120_(hand));
        if (!(flag || this.m_6162_() || this.m_20160_() || player.m_36341_() || player.m_6144_())) {
            if (!this.m_9236_().f_46443_) {
                player.m_20329_((Entity)this);
            }
            return InteractionResult.m_19078_((boolean)this.m_9236_().f_46443_);
        }
        return super.m_6071_(player, hand);
    }

    @Override
    @NotNull
    protected Vec3 m_274312_(Player player, @NotNull Vec3 vec3) {
        return new Vec3(0.0, 0.0, 1.0);
    }

    protected float m_245547_(@NotNull Player player) {
        return (float)(this.m_21133_(Attributes.f_22279_) * (this.m_20069_() ? 0.2 : 0.225) * (double)this.steering.boostFactor());
    }

    @Override
    public Vec3 getRiderOffset() {
        return new Vec3(0.0, 0.0, -0.5);
    }

    @Override
    @NotNull
    public Vec3 m_7688_(@NotNull LivingEntity livingEntity) {
        return new Vec3(this.m_20185_(), this.m_20191_().f_82292_ + (double)0.1f, this.m_20189_());
    }

    @Override
    protected void m_274498_(@NotNull Player player, @NotNull Vec3 vec3) {
        this.m_19915_(player.m_146908_(), player.m_146909_() * 0.5f);
        this.f_20883_ = this.f_20885_ = this.m_146908_();
        this.f_19859_ = this.f_20885_;
    }

    public boolean m_6746_() {
        return this.steering.boost(this.m_217043_());
    }

    private void tickPlowing() {
        LivingEntity livingEntity = this.m_6688_();
        if (!(livingEntity instanceof Player)) {
            return;
        }
        Player player = (Player)livingEntity;
        for (int i = 0; i < 4; ++i) {
            UseOnContext context;
            BlockState modified;
            boolean replaceable;
            float offset = 38.0f - (float)i * 38.0f;
            double blockPosX = this.m_20185_() - (double)Mth.m_14031_((float)((float)Math.toRadians(this.m_146908_() - offset))) * 1.7;
            double blockPosZ = this.m_20189_() + (double)Mth.m_14089_((float)((float)Math.toRadians(this.m_146908_() - offset))) * 1.7;
            BlockPos pos = BlockPos.m_274561_((double)blockPosX, (double)(this.m_20186_() - 0.75), (double)blockPosZ);
            BlockPos above = pos.m_7494_();
            BlockState state = this.m_9236_().m_8055_(pos);
            BlockState aboveState = this.m_9236_().m_8055_(above);
            boolean bl = replaceable = aboveState.m_247087_() || aboveState.m_204336_(BlockTags.f_278394_) || aboveState.m_204336_(BlockTags.f_13037_) || aboveState.m_204336_(BlockTags.f_13040_);
            if (replaceable && !aboveState.m_60795_()) {
                this.m_9236_().m_46961_(above, true);
            }
            if (!replaceable || (modified = state.getToolModifiedState(context = new UseOnContext(player.m_9236_(), player, InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42387_), new BlockHitResult(Vec3.m_82512_((Vec3i)pos), Direction.UP, pos, false)), ToolActions.HOE_TILL, false)) == null) continue;
            this.m_9236_().m_7731_(pos, modified, 11);
            this.m_9236_().m_46796_(2001, pos, Block.m_49956_((BlockState)state));
        }
    }

    @Override
    public void m_8119_() {
        super.m_8119_();
        if (!this.m_9236_().f_46443_ && this.steering.isBoosting()) {
            this.tickPlowing();
        }
        this.steering.tickBoost();
    }

    @Override
    public void setupAnimationStates() {
        super.setupAnimationStates();
        this.idleAnimationState.m_246184_(!this.isDancing(), this.f_19797_);
        this.plowAnimationState.m_246184_(this.steering.isBoosting() && this.m_217005_(), this.f_19797_);
        this.danceAnimationState.m_246184_(this.isDancing(), this.f_19797_);
    }

    @Override
    public float getWalkAnimationSpeed() {
        return this.m_6162_() ? 5.0f : 10.0f;
    }

    @Override
    public void m_7350_(@NotNull EntityDataAccessor<?> accessor) {
        if (PLOW_TIME.equals(accessor) && this.m_9236_().f_46443_) {
            this.steering.onSynced();
        }
        super.m_7350_(accessor);
    }

    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(PLOW_TIME, (Object)0);
    }

    @Nullable
    protected SoundEvent m_7515_() {
        return (SoundEvent)UP2SoundEvents.HIBBERTOPTERUS_IDLE.get();
    }

    @Nullable
    protected SoundEvent m_7975_(@NotNull DamageSource source) {
        return (SoundEvent)UP2SoundEvents.HIBBERTOPTERUS_HURT.get();
    }

    @Nullable
    protected SoundEvent m_5592_() {
        return (SoundEvent)UP2SoundEvents.HIBBERTOPTERUS_DEATH.get();
    }

    protected void m_7355_(@NotNull BlockPos pos, @NotNull BlockState state) {
        this.m_5496_((SoundEvent)UP2SoundEvents.HIBBERTOPTERUS_STEP.get(), 0.4f, this.getStepPitch());
    }

    protected float m_6059_() {
        return this.f_19788_ + 0.55f;
    }

    private float getStepPitch() {
        return this.m_6162_() ? 1.45f + this.m_217043_().m_188501_() * 0.1f : 0.95f + this.m_217043_().m_188501_() * 0.1f;
    }

    @Nullable
    public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return (AgeableMob)((EntityType)UP2Entities.HIBBERTOPTERUS.get()).m_20615_((Level)level);
    }

    public static boolean canSpawn(EntityType<Hibbertopterus> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.m_8055_(pos.m_7495_()).m_204336_(UP2BlockTags.HIBBERTOPTERUS_SPAWNABLE_ON) && Hibbertopterus.m_186209_((BlockAndTintGetter)level, (BlockPos)pos);
    }
}


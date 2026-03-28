/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.ai.util.LandRandomPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import java.util.EnumSet;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.Vec3;

public class PrehistoricAvoidEntityGoal<T extends LivingEntity>
extends Goal {
    protected final PrehistoricMob mob;
    private final double speedModifier;
    protected double posX;
    protected double posY;
    protected double posZ;
    protected final boolean shouldEscapeToWater;
    @Nullable
    protected T toAvoid;
    protected final float maxDist;
    @Nullable
    protected final Class<T> avoidClass;
    protected final Predicate<LivingEntity> avoidPredicate;
    protected final Predicate<LivingEntity> predicateOnAvoidEntity;
    protected final TargetingConditions avoidEntityTargeting;

    public PrehistoricAvoidEntityGoal(PrehistoricMob mob, Class<T> classToAvoid, float distance, double speedModifier, boolean shouldEscapeToWater) {
        this(mob, classToAvoid, entity -> true, distance, speedModifier, shouldEscapeToWater, EntitySelector.f_20406_::test);
    }

    public PrehistoricAvoidEntityGoal(PrehistoricMob mob, @Nullable Class<T> classToAvoid, float distance, double speedModifier, Predicate<LivingEntity> avoidPredicate) {
        this(mob, classToAvoid, avoidPredicate, distance, speedModifier, false, entity -> true);
    }

    public PrehistoricAvoidEntityGoal(PrehistoricMob mob, @Nullable Class<T> classToAvoid, float distance, double speedModifier, boolean shouldEscapeToWater, Predicate<LivingEntity> avoidPredicate) {
        this(mob, classToAvoid, avoidPredicate, distance, speedModifier, shouldEscapeToWater, entity -> true);
    }

    public PrehistoricAvoidEntityGoal(PrehistoricMob mob, @Nullable Class<T> classToAvoid, Predicate<LivingEntity> avoidPredicate, float distance, double speedModifier, boolean shouldEscapeToWater, Predicate<LivingEntity> predicateOnAvoid) {
        this.mob = mob;
        this.avoidClass = classToAvoid;
        this.avoidPredicate = avoidPredicate;
        this.maxDist = distance;
        this.speedModifier = speedModifier;
        this.shouldEscapeToWater = shouldEscapeToWater;
        this.predicateOnAvoidEntity = predicateOnAvoid;
        this.avoidEntityTargeting = TargetingConditions.m_148352_().m_26883_((double)distance).m_26888_(predicateOnAvoid.and(avoidPredicate));
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean m_8036_() {
        BlockPos blockpos;
        if (this.avoidClass != null) {
            this.toAvoid = this.mob.m_9236_().m_45982_(this.mob.m_9236_().m_6443_(this.avoidClass, this.mob.m_20191_().m_82377_((double)this.maxDist, 3.0, (double)this.maxDist), entity -> true), this.avoidEntityTargeting, (LivingEntity)this.mob, this.mob.m_20185_(), this.mob.m_20186_(), this.mob.m_20189_());
        }
        if (this.toAvoid == null) {
            return false;
        }
        if (this.shouldEscapeToWater && !this.mob.m_20072_() && (blockpos = this.lookForWater((BlockGetter)this.mob.m_9236_(), (Entity)this.mob)) != null) {
            this.posX = blockpos.m_123341_();
            this.posY = blockpos.m_123342_();
            this.posZ = blockpos.m_123343_();
            return true;
        }
        return this.findRandomPositionAway();
    }

    public boolean m_8045_() {
        return !this.mob.m_21573_().m_26571_();
    }

    public void m_8056_() {
        this.mob.setRunning(true);
        if (this.mob.isSitting()) {
            this.mob.setSitting(false);
            this.mob.setSitCooldown(this.mob.getSitCooldown() + 200);
        }
        this.mob.m_21573_().m_26519_(this.posX, this.posY, this.posZ, this.speedModifier);
    }

    public void m_8041_() {
        this.mob.setRunning(false);
        this.toAvoid = null;
    }

    protected boolean findRandomPositionAway() {
        Vec3 vec3 = DefaultRandomPos.m_148403_((PathfinderMob)this.mob, (int)10, (int)4);
        if (this.toAvoid != null) {
            vec3 = LandRandomPos.m_148521_((PathfinderMob)this.mob, (int)10, (int)4, (Vec3)this.toAvoid.m_20182_());
        }
        if (vec3 != null) {
            this.mob.m_21573_().m_26519_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_, this.speedModifier);
        }
        if (vec3 == null) {
            return false;
        }
        this.posX = vec3.f_82479_;
        this.posY = vec3.f_82480_;
        this.posZ = vec3.f_82481_;
        return true;
    }

    protected BlockPos lookForWater(BlockGetter level, Entity entity) {
        BlockPos entityPos = entity.m_20183_();
        if (!level.m_8055_(entityPos).m_60812_(level, entityPos).m_83281_()) {
            return null;
        }
        return BlockPos.m_121930_((BlockPos)entityPos, (int)16, (int)4, pos -> level.m_6425_(pos).m_205070_(FluidTags.f_13131_)).orElse(null);
    }
}


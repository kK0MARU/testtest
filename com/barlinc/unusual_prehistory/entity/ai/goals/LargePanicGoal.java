/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.PanicGoal
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.ai.util.LandRandomPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.Vec3;

public class LargePanicGoal
extends PanicGoal {
    protected final PrehistoricMob prehistoricMob;
    protected final int radius;
    protected final int height;
    protected final boolean shouldEscapeToWater;

    public LargePanicGoal(PrehistoricMob mob, double speedModifier) {
        this(mob, speedModifier, 10, 4, false);
    }

    public LargePanicGoal(PrehistoricMob mob, double speedModifier, int radius, int height) {
        this(mob, speedModifier, radius, height, false);
    }

    public LargePanicGoal(PrehistoricMob mob, double speedModifier, int radius, int height, boolean shouldEscapeToWater) {
        super((PathfinderMob)mob, speedModifier);
        this.prehistoricMob = mob;
        this.radius = radius;
        this.height = height;
        this.shouldEscapeToWater = shouldEscapeToWater;
    }

    public void m_8056_() {
        super.m_8056_();
        this.prehistoricMob.setRunning(true);
    }

    public void m_8041_() {
        super.m_8041_();
        this.prehistoricMob.setRunning(false);
    }

    public boolean m_8036_() {
        BlockPos blockpos;
        if (!this.m_202729_()) {
            return false;
        }
        if ((this.f_25684_.m_6060_() || this.shouldEscapeToWater && !this.f_25684_.m_20072_()) && (blockpos = this.m_198172_((BlockGetter)this.f_25684_.m_9236_(), (Entity)this.f_25684_, this.radius)) != null) {
            this.f_25686_ = blockpos.m_123341_();
            this.f_25687_ = blockpos.m_123342_();
            this.f_25688_ = blockpos.m_123343_();
            return true;
        }
        return this.m_25702_();
    }

    protected boolean m_25702_() {
        Vec3 vec3 = DefaultRandomPos.m_148403_((PathfinderMob)this.prehistoricMob, (int)this.radius, (int)this.height);
        if (this.prehistoricMob.m_21188_() != null) {
            vec3 = LandRandomPos.m_148521_((PathfinderMob)this.prehistoricMob, (int)this.radius, (int)this.height, (Vec3)this.prehistoricMob.m_21188_().m_20182_());
        }
        if (vec3 != null) {
            this.prehistoricMob.m_21573_().m_26519_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_, this.f_25685_);
        }
        if (vec3 == null) {
            return false;
        }
        this.f_25686_ = vec3.f_82479_;
        this.f_25687_ = vec3.f_82480_;
        this.f_25688_ = vec3.f_82481_;
        return true;
    }

    protected BlockPos m_198172_(BlockGetter level, Entity entity, int range) {
        BlockPos entityPos = entity.m_20183_();
        if (!level.m_8055_(entityPos).m_60812_(level, entityPos).m_83281_()) {
            return null;
        }
        return BlockPos.m_121930_((BlockPos)entityPos, (int)(range + 6), (int)this.height, pos -> level.m_6425_(pos).m_205070_(FluidTags.f_13131_)).orElse(null);
    }
}


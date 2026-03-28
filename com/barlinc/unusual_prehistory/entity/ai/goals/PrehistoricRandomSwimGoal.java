/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class PrehistoricRandomSwimGoal
extends Goal {
    private BlockPos targetPos = null;
    private final Mob mob;
    private final double speedModifier;
    private final int range;
    private final int chance;
    private final int belowSeaLevel;

    public PrehistoricRandomSwimGoal(Mob mob, double speed, int chance, int range, int belowSeaLevel) {
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE));
        this.mob = mob;
        this.speedModifier = speed;
        this.chance = chance;
        this.range = range;
        this.belowSeaLevel = belowSeaLevel;
    }

    public boolean m_8036_() {
        LivingEntity target = this.mob.m_5448_();
        return !(!this.mob.m_20072_() || target != null && target.m_6084_() || this.chance != 0 && this.mob.m_217043_().m_188503_(this.chance) != 0);
    }

    public boolean m_8045_() {
        return this.targetPos != null && this.mob.m_20238_(Vec3.m_82512_((Vec3i)this.targetPos)) > 30.0 && !this.mob.m_21573_().m_26571_();
    }

    public void m_8056_() {
        this.targetPos = this.findSwimToPos();
        this.mob.m_21573_().m_26519_((double)this.targetPos.m_123341_(), (double)this.targetPos.m_123342_(), (double)this.targetPos.m_123343_(), this.speedModifier);
    }

    public boolean isTargetBlocked(Vec3 target) {
        Vec3 Vector3d = new Vec3(this.mob.m_20185_(), this.mob.m_20188_(), this.mob.m_20189_());
        return this.mob.m_9236_().m_45547_(new ClipContext(Vector3d, target, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)this.mob)).m_6662_() != HitResult.Type.MISS;
    }

    public BlockPos findSwimToPos() {
        BlockPos around = this.mob.m_20183_();
        BlockPos.MutableBlockPos move = new BlockPos.MutableBlockPos();
        move.m_122169_(this.mob.m_20185_(), this.mob.m_20186_(), this.mob.m_20189_());
        while (move.m_123342_() < this.mob.m_9236_().m_151558_() && this.mob.m_9236_().m_6425_((BlockPos)move).m_205070_(FluidTags.f_13131_)) {
            move.m_122184_(0, 5, 0);
        }
        int surfaceY = move.m_123342_();
        around = around.m_175288_(Math.min(surfaceY - this.belowSeaLevel, around.m_123342_()));
        for (int i = 0; i < 15; ++i) {
            BlockPos blockPos = around.m_7918_(this.mob.m_217043_().m_188503_(this.range) - this.range / 2, this.mob.m_217043_().m_188503_(this.range) - this.range / 2, this.mob.m_217043_().m_188503_(this.range) - this.range / 2);
            if (!this.mob.m_9236_().m_6425_(blockPos).m_205070_(FluidTags.f_13131_) || this.isTargetBlocked(Vec3.m_82512_((Vec3i)blockPos)) || blockPos.m_123342_() <= this.mob.m_9236_().m_141937_() + 1) continue;
            return blockPos;
        }
        return around;
    }
}


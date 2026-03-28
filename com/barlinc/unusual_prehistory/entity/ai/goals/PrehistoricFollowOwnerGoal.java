/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.LeavesBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.level.pathfinder.WalkNodeEvaluator
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;

public class PrehistoricFollowOwnerGoal
extends Goal {
    protected final PrehistoricMob tamedMob;
    protected LivingEntity owner;
    private final double speedModifier;
    protected int timeToRecalcPath;
    private final float stopDistance;
    private final float startDistance;
    private float oldWaterCost;
    protected final boolean canFly;
    protected final boolean shouldChangeMalus;

    public PrehistoricFollowOwnerGoal(PrehistoricMob tamedMob, double speedModifier, float startDistance, float stopDistance) {
        this(tamedMob, speedModifier, startDistance, stopDistance, false, false);
    }

    public PrehistoricFollowOwnerGoal(PrehistoricMob tamedMob, double speedModifier, float startDistance, float stopDistance, boolean shouldChangeMalus) {
        this(tamedMob, speedModifier, startDistance, stopDistance, false, shouldChangeMalus);
    }

    public PrehistoricFollowOwnerGoal(PrehistoricMob tamedMob, double speedModifier, float startDistance, float stopDistance, boolean canFly, boolean shouldChangeMalus) {
        this.tamedMob = tamedMob;
        this.speedModifier = speedModifier;
        this.startDistance = startDistance;
        this.stopDistance = stopDistance;
        this.canFly = canFly;
        this.shouldChangeMalus = shouldChangeMalus;
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean m_8036_() {
        LivingEntity owner = this.tamedMob.m_269323_();
        if (owner == null) {
            return false;
        }
        if (owner.m_5833_()) {
            return false;
        }
        if (this.unableToMove()) {
            return false;
        }
        if (this.tamedMob.m_20280_((Entity)owner) < (double)(this.startDistance * this.startDistance)) {
            return false;
        }
        this.owner = owner;
        return this.shouldFollow() && !this.isInCombat();
    }

    public boolean m_8045_() {
        if (this.tamedMob.m_21573_().m_26571_()) {
            return false;
        }
        if (this.unableToMove()) {
            return false;
        }
        return !(this.tamedMob.m_20280_((Entity)this.owner) <= (double)(this.stopDistance * this.stopDistance)) && this.shouldFollow() && !this.isInCombat();
    }

    public void m_8056_() {
        this.timeToRecalcPath = 0;
        if (this.shouldChangeMalus) {
            this.oldWaterCost = this.tamedMob.m_21439_(BlockPathTypes.WATER);
            this.tamedMob.m_21441_(BlockPathTypes.WATER, 0.0f);
        }
    }

    public void m_8041_() {
        this.owner = null;
        this.tamedMob.m_21573_().m_26573_();
        if (this.shouldChangeMalus) {
            this.tamedMob.m_21441_(BlockPathTypes.WATER, this.oldWaterCost);
        }
    }

    public void m_8037_() {
        this.tamedMob.m_21563_().m_24960_((Entity)this.owner, 10.0f, (float)this.tamedMob.m_8132_());
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = this.m_183277_(10);
            if (this.tamedMob.m_20280_((Entity)this.owner) >= 144.0) {
                this.teleportToOwner();
            } else {
                this.tamedMob.m_21573_().m_5624_((Entity)this.owner, this.speedModifier);
            }
        }
    }

    private boolean unableToMove() {
        return this.tamedMob.m_21827_() || this.tamedMob.m_20159_() || this.tamedMob.m_21523_();
    }

    private void teleportToOwner() {
        BlockPos blockpos = this.owner.m_20183_();
        for (int i = 0; i < 10; ++i) {
            int j = this.randomIntInclusive(-3, 3);
            int k = this.randomIntInclusive(-1, 1);
            int l = this.randomIntInclusive(-3, 3);
            boolean flag = this.maybeTeleportTo(blockpos.m_123341_() + j, blockpos.m_123342_() + k, blockpos.m_123343_() + l);
            if (!flag) continue;
            return;
        }
    }

    private boolean maybeTeleportTo(int x, int y, int z) {
        if (Math.abs((double)x - this.owner.m_20185_()) < 2.0 && Math.abs((double)z - this.owner.m_20189_()) < 2.0) {
            return false;
        }
        if (!this.canTeleportTo(new BlockPos(x, y, z))) {
            return false;
        }
        this.tamedMob.m_7678_((double)x + 0.5, y, (double)z + 0.5, this.tamedMob.m_146908_(), this.tamedMob.m_146909_());
        this.tamedMob.m_21573_().m_26573_();
        return true;
    }

    protected boolean canTeleportTo(BlockPos blockPos) {
        BlockPathTypes blockpathtypes = WalkNodeEvaluator.m_77604_((BlockGetter)this.tamedMob.m_9236_(), (BlockPos.MutableBlockPos)blockPos.m_122032_());
        if (blockpathtypes != BlockPathTypes.WALKABLE) {
            return false;
        }
        BlockState blockstate = this.tamedMob.m_9236_().m_8055_(blockPos.m_7495_());
        if (!this.canFly && blockstate.m_60734_() instanceof LeavesBlock) {
            return false;
        }
        BlockPos blockpos = blockPos.m_121996_((Vec3i)this.tamedMob.m_20183_());
        return this.tamedMob.m_9236_().m_45756_((Entity)this.tamedMob, this.tamedMob.m_20191_().m_82338_(blockpos));
    }

    private boolean shouldFollow() {
        return this.tamedMob.getCommand() == 2;
    }

    private boolean isInCombat() {
        LivingEntity owner = this.tamedMob.m_269323_();
        if (owner != null) {
            return this.tamedMob.m_20270_((Entity)owner) < 30.0f && this.tamedMob.m_5448_() != null && this.tamedMob.m_5448_().m_6084_();
        }
        return false;
    }

    private int randomIntInclusive(int min, int max) {
        return this.tamedMob.m_217043_().m_188503_(max - min + 1) + min;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.MoveToBlockGoal
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.LeverBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraftforge.event.ForgeEventFactory
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.utils.LeverPullingMob;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;

public class PullLeverGoal
extends MoveToBlockGoal {
    protected final LeverPullingMob leverPullingMob;
    protected int ticksWaited = 0;

    public PullLeverGoal(PathfinderMob mob, double speedModifier, int searchRange, int verticalSearchRange) {
        super(mob, speedModifier, searchRange, verticalSearchRange);
        this.leverPullingMob = (LeverPullingMob)mob;
    }

    public void m_8056_() {
        super.m_8056_();
        this.ticksWaited = 0;
    }

    public void m_8041_() {
        super.m_8041_();
        this.leverPullingMob.setPullLeverCooldown(200 + this.f_25598_.m_217043_().m_188503_(200));
    }

    public boolean m_8036_() {
        if (this.f_25598_ instanceof LeverPullingMob) {
            return super.m_8036_() && this.leverPullingMob.canPullLever();
        }
        return false;
    }

    public boolean m_8045_() {
        return super.m_8045_() && this.leverPullingMob.canPullLever();
    }

    public void m_8037_() {
        ++this.ticksWaited;
        if (this.m_25625_() && this.ticksWaited > 30) {
            this.onReachedTarget();
        }
        super.m_8037_();
    }

    protected void onReachedTarget() {
        BlockState blockstate;
        if (ForgeEventFactory.getMobGriefingEvent((Level)this.f_25598_.m_9236_(), (Entity)this.f_25598_) && (blockstate = this.f_25598_.m_9236_().m_8055_(this.f_25602_)).m_60734_() instanceof LeverBlock) {
            this.pullLever();
            this.m_8041_();
        }
        this.ticksWaited = 0;
    }

    protected boolean m_25625_() {
        double z;
        double y;
        double x = this.f_25598_.m_20185_() - ((double)this.f_25602_.m_123341_() + 0.5);
        return x * x + (y = this.f_25598_.m_20188_() - ((double)this.f_25602_.m_123342_() + 0.5)) * y + (z = this.f_25598_.m_20189_() - ((double)this.f_25602_.m_123343_() + 0.5)) * z < 2.25;
    }

    @NotNull
    protected BlockPos m_6669_() {
        return this.f_25602_;
    }

    protected boolean m_6465_(LevelReader level, @NotNull BlockPos pos) {
        BlockState state = level.m_8055_(pos);
        return state.m_60734_() instanceof LeverBlock;
    }

    private void pullLever() {
        ((LeverPullingMob)this.f_25598_).pullLever();
        this.f_25600_ = this.m_6099_(this.f_25598_);
        BlockState state = this.f_25598_.m_9236_().m_8055_(this.f_25602_);
        ((LeverBlock)state.m_60734_()).m_6227_(state, this.f_25598_.m_9236_(), this.f_25602_, null, null, null);
    }
}


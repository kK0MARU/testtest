/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.update_4;

import com.barlinc.unusual_prehistory.entity.ai.goals.RandomFlightGoal;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Pterodactylus;
import java.util.EnumSet;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class PterodactylusFlyAndHangGoal
extends RandomFlightGoal {
    private final Pterodactylus pterodactylus;
    private boolean wantsToHang = false;
    private int hangTimer = 0;

    public PterodactylusFlyAndHangGoal(Pterodactylus pterodactylus) {
        super(pterodactylus, 1.0f, 1.5f, 13, 4, 100, 900);
        this.m_7021_(EnumSet.of(Goal.Flag.MOVE));
        this.pterodactylus = pterodactylus;
    }

    @Override
    public boolean m_8036_() {
        if (this.pterodactylus.isHanging() || this.pterodactylus.getIdleState() == 1 || this.pterodactylus.groundTicks > 0) {
            return false;
        }
        this.wantsToHang = this.pterodactylus.flightTicks > 300 && !this.pterodactylus.isRunning();
        return super.m_8036_();
    }

    @Override
    protected Vec3 getPosition() {
        Vec3 hangPos;
        if (this.wantsToHang && (hangPos = this.findHangFromPos()) != null) {
            return hangPos;
        }
        return super.getPosition();
    }

    @Override
    public void m_8056_() {
        super.m_8056_();
        this.pterodactylus.setHanging(false);
        this.hangTimer = 0;
    }

    @Override
    public void m_8037_() {
        if (this.wantsToHang && this.hangTimer-- < 0) {
            this.hangTimer = 5 + this.pterodactylus.m_217043_().m_188503_(5);
            if (!this.pterodactylus.isHanging() && this.pterodactylus.canHangFrom(this.pterodactylus.posAbove(), this.pterodactylus.m_9236_().m_8055_(this.pterodactylus.posAbove()))) {
                this.pterodactylus.setHanging(true);
                this.pterodactylus.setFlying(false);
            }
        }
        if (this.pterodactylus.m_29443_() && this.pterodactylus.m_20096_() && this.pterodactylus.flightTicks > 40) {
            this.pterodactylus.setFlying(false);
        }
        if (this.isOverWaterOrVoid() || this.pterodactylus.m_20072_()) {
            this.pterodactylus.setFlying(true);
            this.pterodactylus.setHanging(false);
            this.pterodactylus.landingFlag = false;
        }
        if (this.pterodactylus.m_29443_() && this.pterodactylus.flightTicks > this.maxTimeFlying && !this.isOverWaterOrVoid()) {
            this.pterodactylus.landingFlag = true;
        }
    }

    @Override
    public boolean m_8045_() {
        if (this.wantsToHang) {
            return !this.pterodactylus.m_21573_().m_26571_() && !this.pterodactylus.isHanging() && this.pterodactylus.groundTicks <= 0;
        }
        return this.pterodactylus.m_29443_() && !this.pterodactylus.m_21573_().m_26571_() && this.pterodactylus.groundTicks <= 0;
    }

    @Override
    public void m_8041_() {
        if (this.wantsToHang) {
            this.pterodactylus.m_21573_().m_26573_();
        }
        this.wantsToHang = false;
    }

    public Vec3 findHangFromPos() {
        BlockPos blockpos = null;
        Random random = new Random();
        int range = 14;
        for (int i = 0; i < 15; ++i) {
            BlockPos blockpos1 = this.pterodactylus.m_20183_().m_7918_(random.nextInt(range) - range / 2, 0, random.nextInt(range) - range / 2);
            if (!this.pterodactylus.m_9236_().m_46859_(blockpos1) || !this.pterodactylus.m_9236_().m_46749_(blockpos1)) continue;
            while (this.pterodactylus.m_9236_().m_46859_(blockpos1) && blockpos1.m_123342_() < this.pterodactylus.m_9236_().m_151558_()) {
                blockpos1 = blockpos1.m_7494_();
            }
            if (!((double)blockpos1.m_123342_() > this.pterodactylus.m_20186_() - 1.0) || !this.pterodactylus.canHangFrom(blockpos1, this.pterodactylus.m_9236_().m_8055_(blockpos1)) || !this.hasLineOfToPos(blockpos1)) continue;
            blockpos = blockpos1;
        }
        return blockpos == null ? null : Vec3.m_82512_(blockpos);
    }

    public boolean hasLineOfToPos(BlockPos blockPos) {
        BlockHitResult result = this.pterodactylus.m_9236_().m_45547_(new ClipContext(this.pterodactylus.m_20299_(1.0f), new Vec3((double)blockPos.m_123341_() + 0.5, (double)blockPos.m_123342_() + 0.5, (double)blockPos.m_123343_() + 0.5), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)this.pterodactylus));
        if (result instanceof BlockHitResult) {
            BlockHitResult blockRayTraceResult = result;
            BlockPos pos = blockRayTraceResult.m_82425_();
            return pos.equals((Object)blockPos) || this.pterodactylus.m_9236_().m_46859_(pos);
        }
        return true;
    }
}


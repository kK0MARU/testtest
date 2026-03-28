/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricAquaticMob;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class AquaticNibbleBlockGoal
extends Goal {
    protected final PrehistoricAquaticMob aquaticMob;
    protected int digTime;
    private final int digTimeLimit;
    private int timeOut = 400;
    private final int cooldown;
    protected BlockPos digPos = null;
    protected TagKey<Block> foodBlocks;
    protected final double speedModifier;

    public AquaticNibbleBlockGoal(PrehistoricAquaticMob aquaticMob, TagKey<Block> foodBlocks) {
        this(aquaticMob, 20, 600, foodBlocks, 1.1);
    }

    public AquaticNibbleBlockGoal(PrehistoricAquaticMob aquaticMob, int digTime, int cooldown, TagKey<Block> foodBlocks, double speedModifier) {
        this.foodBlocks = foodBlocks;
        this.aquaticMob = aquaticMob;
        this.digTime = digTime;
        this.digTimeLimit = digTime;
        this.cooldown = cooldown;
        this.speedModifier = speedModifier;
    }

    public boolean m_8036_() {
        if (this.aquaticMob.getEatCooldown() <= 0 && this.aquaticMob.m_20069_()) {
            this.aquaticMob.setEatCooldown(600 + this.aquaticMob.m_217043_().m_188503_(2400));
            this.digPos = this.getDigPos();
            this.timeOut = 800;
            return this.digPos != null;
        }
        return false;
    }

    public boolean m_8045_() {
        return this.aquaticMob.m_5448_() == null && this.aquaticMob.m_21188_() == null && this.digPos != null && this.aquaticMob.m_9236_().m_8055_(this.digPos).m_204336_(this.foodBlocks) && this.aquaticMob.m_9236_().m_6425_(this.digPos.m_7494_()).m_205070_(FluidTags.f_13131_) && this.timeOut >= 0;
    }

    public void m_8056_() {
        this.digTime += this.aquaticMob.m_217043_().m_188503_(10);
        this.aquaticMob.m_21573_().m_26519_((double)this.digPos.m_123341_() + 0.5, (double)this.digPos.m_123342_(), (double)this.digPos.m_123343_() + 0.5, this.speedModifier);
    }

    public void m_8037_() {
        double dist = this.aquaticMob.m_20182_().m_82554_(Vec3.m_82512_((Vec3i)this.digPos));
        double dy = (double)this.digPos.m_123342_() + 0.5 - this.aquaticMob.m_20186_();
        double dx = (double)this.digPos.m_123341_() + 0.5 - this.aquaticMob.m_20185_();
        double dz = (double)this.digPos.m_123343_() + 0.5 - this.aquaticMob.m_20189_();
        float yaw = (float)(Mth.m_14136_((double)dz, (double)dx) * 57.2957763671875) - 90.0f;
        float pitch = (float)(-(Mth.m_14136_((double)dy, (double)Math.hypot(dx, dz)) * 57.2957763671875));
        --this.timeOut;
        if (dist < this.aquaticMob.m_20191_().m_82362_() + 1.0) {
            this.aquaticMob.m_146922_(yaw);
            this.aquaticMob.m_146926_(pitch);
            --this.digTime;
            if (dist < this.aquaticMob.m_20191_().m_82362_()) {
                this.aquaticMob.m_21573_().m_26573_();
            }
            if (this.digTime % 5 == 0) {
                this.spawnEffectsAtBlock(this.digPos);
                this.aquaticMob.m_5496_(this.aquaticMob.m_9236_().m_8055_(this.digPos).m_60827_().m_56778_(), 0.2f, 0.8f + this.aquaticMob.m_217043_().m_188501_() * 0.25f);
            }
            if (this.digTime <= 0) {
                this.digPos = null;
            }
        } else {
            this.aquaticMob.m_21573_().m_26519_((double)this.digPos.m_123341_() + 0.5, (double)this.digPos.m_123342_(), (double)this.digPos.m_123343_() + 0.5, this.speedModifier);
            if (this.timeOut <= 0) {
                this.digPos = null;
            }
        }
    }

    public void m_8041_() {
        this.aquaticMob.setEatCooldown(this.cooldown + this.aquaticMob.m_217043_().m_188503_(this.cooldown * 4));
        this.digPos = null;
        this.digTime = this.digTimeLimit;
        this.timeOut = 400;
    }

    private BlockPos getSeafloorPos(BlockPos parent) {
        Level world = this.aquaticMob.m_9236_();
        RandomSource random = this.aquaticMob.m_217043_();
        int range = 15;
        for (int i = 0; i < 25; ++i) {
            BlockState state;
            BlockPos seafloor = parent.m_7918_(random.m_188503_(range) - range / 2, 0, random.m_188503_(range) - range / 2);
            while (world.m_6425_(seafloor).m_205070_(FluidTags.f_13131_) && seafloor.m_123342_() > 1) {
                state = world.m_8055_(seafloor);
                if (state.m_204336_(this.foodBlocks)) {
                    return seafloor;
                }
                seafloor = seafloor.m_7495_();
            }
            state = world.m_8055_(seafloor);
            if (!state.m_204336_(this.foodBlocks)) continue;
            return seafloor;
        }
        return null;
    }

    private BlockPos getDigPos() {
        RandomSource random = this.aquaticMob.m_217043_();
        int range = 15;
        if (this.aquaticMob.m_20069_()) {
            return this.getSeafloorPos(this.aquaticMob.m_20183_());
        }
        for (int i = 0; i < 25; ++i) {
            BlockPos pos3;
            BlockPos blockpos1 = this.aquaticMob.m_20183_().m_7918_(random.m_188503_(range) - range / 2, 3, random.m_188503_(range) - range / 2);
            while (this.aquaticMob.m_9236_().m_46859_(blockpos1) && blockpos1.m_123342_() > 1) {
                blockpos1 = blockpos1.m_7495_();
            }
            if (!this.aquaticMob.m_9236_().m_6425_(blockpos1).m_205070_(FluidTags.f_13131_) || (pos3 = this.getSeafloorPos(blockpos1)) == null || !((double)pos3.m_123342_() < this.aquaticMob.m_20186_())) continue;
            return pos3;
        }
        return null;
    }

    public void spawnEffectsAtBlock(BlockPos blockPos) {
        float radius = 0.3f;
        for (int i1 = 0; i1 < 3; ++i1) {
            double motionX = this.aquaticMob.m_217043_().m_188583_() * 0.07;
            double motionY = this.aquaticMob.m_217043_().m_188583_() * 0.07;
            double motionZ = this.aquaticMob.m_217043_().m_188583_() * 0.07;
            float angle = (float)(0.0174532925 * (double)this.aquaticMob.f_20883_ + (double)i1);
            double extraX = radius * Mth.m_14031_((float)((float)Math.PI + angle));
            double extraY = 0.8f;
            double extraZ = radius * Mth.m_14089_((float)angle);
            BlockState state = this.aquaticMob.m_9236_().m_8055_(blockPos);
            ((ServerLevel)this.aquaticMob.m_9236_()).m_8767_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, state), (double)blockPos.m_123341_() + 0.5 + extraX, (double)blockPos.m_123342_() + 0.5 + extraY, (double)blockPos.m_123343_() + 0.5 + extraZ, 1, motionX, motionY, motionZ, 1.0);
        }
    }
}


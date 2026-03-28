/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.goal.MoveToBlockGoal
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.Node
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.future;

import com.barlinc.unusual_prehistory.entity.mob.future.Therizinosaurus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class TherizinosaurusForageLeavesGoal
extends MoveToBlockGoal {
    private final Therizinosaurus therizinosaurus;
    private boolean stopFlag = false;
    private int reachCheckTime = 50;
    private int timer;

    public TherizinosaurusForageLeavesGoal(Therizinosaurus therizinosaurus, double speedModifier, int range) {
        super((PathfinderMob)therizinosaurus, speedModifier, range, 7);
        this.therizinosaurus = therizinosaurus;
    }

    public void m_8056_() {
        super.m_8056_();
        this.timer = 0;
    }

    public void m_8041_() {
        this.f_25602_ = BlockPos.f_121853_;
        super.m_8041_();
        this.stopFlag = false;
    }

    public boolean m_8036_() {
        return super.m_8036_() && !this.therizinosaurus.m_6162_();
    }

    public boolean m_8045_() {
        return super.m_8045_() && !this.stopFlag;
    }

    protected int m_6099_(@NotNull PathfinderMob mob) {
        return TherizinosaurusForageLeavesGoal.m_186073_((int)(220 + this.therizinosaurus.m_217043_().m_188503_(500)));
    }

    public double m_8052_() {
        return 4.0;
    }

    protected boolean m_25625_() {
        BlockPos target = this.m_6669_();
        return this.therizinosaurus.m_20275_((float)target.m_123341_() + 0.5f, this.therizinosaurus.m_20186_(), (float)target.m_123343_() + 0.5f) < this.m_8052_();
    }

    @NotNull
    protected BlockPos m_6669_() {
        return this.getStandAtTreePos(this.f_25602_);
    }

    public void m_8037_() {
        super.m_8037_();
        BlockPos target = this.m_6669_();
        if (this.reachCheckTime > 0) {
            --this.reachCheckTime;
        } else {
            this.reachCheckTime = 50 + this.therizinosaurus.m_217043_().m_188503_(100);
            if (!this.canReach(target)) {
                this.stopFlag = true;
                this.f_25602_ = BlockPos.f_121853_;
                return;
            }
        }
        if (this.m_25625_()) {
            if (this.therizinosaurus.m_20089_() == Pose.STANDING) {
                if (this.getHeightOfBlock((LevelReader)this.therizinosaurus.m_9236_(), this.f_25602_) > 4) {
                    this.therizinosaurus.setForagingTree(true);
                }
                this.therizinosaurus.m_20124_(UP2Poses.FORAGING.get());
            } else if (this.therizinosaurus.m_20089_() == UP2Poses.FORAGING.get()) {
                ++this.timer;
                if (this.timer % 5 == 0) {
                    this.spawnEffectsAtBlock(this.f_25602_);
                    this.therizinosaurus.m_5496_(this.therizinosaurus.m_9236_().m_8055_(this.f_25602_).m_60827_().m_56778_(), 1.0f, 0.9f + this.therizinosaurus.m_217043_().m_188501_() * 0.25f);
                }
                if (this.timer >= 60) {
                    this.stopFlag = true;
                    this.f_25602_ = BlockPos.f_121853_;
                }
            }
        }
    }

    protected void m_25624_() {
        BlockPos pos = this.m_6669_();
        this.f_25598_.m_21573_().m_26519_((double)pos.m_123341_() + 0.5, (double)pos.m_123342_(), (double)pos.m_123343_() + 0.5, this.f_25599_);
    }

    protected BlockPos getStandAtTreePos(BlockPos target) {
        Vec3 vec3 = Vec3.m_82512_((Vec3i)target).m_82546_(this.therizinosaurus.m_20182_());
        float f = -((float)Mth.m_14136_((double)vec3.f_82479_, (double)vec3.f_82481_)) * 180.0f / (float)Math.PI;
        Direction direction = Direction.m_122364_((double)f);
        if (this.therizinosaurus.m_9236_().m_8055_(target.m_7495_()).m_60795_()) {
            target = target.m_121945_(direction);
        }
        return target.m_5484_(direction.m_122424_(), 4).m_175288_((int)this.therizinosaurus.m_20186_());
    }

    private int getHeightOfBlock(LevelReader level, BlockPos pos) {
        int i = 0;
        while (pos.m_123342_() > level.m_141937_() && (level.m_8055_(pos).m_204336_(UP2BlockTags.THERIZINOSAURUS_FORAGING_BLOCKS) || level.m_8055_(pos).m_60795_())) {
            pos = pos.m_7495_();
            ++i;
        }
        return i;
    }

    private boolean highEnough(LevelReader level, BlockPos pos) {
        int height = this.getHeightOfBlock(level, pos);
        if (this.therizinosaurus.m_6162_()) {
            return height <= 1;
        }
        return height > 3 && height < 8;
    }

    protected boolean m_6465_(LevelReader level, @NotNull BlockPos pos) {
        return level.m_8055_(pos).m_204336_(UP2BlockTags.THERIZINOSAURUS_FORAGING_BLOCKS) && this.highEnough(level, pos);
    }

    private boolean canReach(BlockPos target) {
        int k;
        int j;
        Path path = this.therizinosaurus.m_21573_().m_7864_(target, 0);
        if (path == null) {
            return false;
        }
        Node node = path.m_77395_();
        if (node == null) {
            return false;
        }
        int i = node.f_77271_ - target.m_123341_();
        return (double)(i * i + (j = node.f_77272_ - target.m_123342_()) * j + (k = node.f_77273_ - target.m_123343_()) * k) <= 3.0;
    }

    public void spawnEffectsAtBlock(BlockPos blockPos) {
        float radius = 0.3f;
        for (int i1 = 0; i1 < 3; ++i1) {
            double motionX = this.therizinosaurus.m_217043_().m_188583_() * 0.07;
            double motionY = this.therizinosaurus.m_217043_().m_188583_() * 0.07;
            double motionZ = this.therizinosaurus.m_217043_().m_188583_() * 0.07;
            float angle = (float)(0.0174532925 * (double)this.therizinosaurus.f_20883_ + (double)i1);
            double extraX = radius * Mth.m_14031_((float)((float)Math.PI + angle));
            double extraY = 0.8f;
            double extraZ = radius * Mth.m_14089_((float)angle);
            BlockState state = this.therizinosaurus.m_9236_().m_8055_(blockPos);
            ((ServerLevel)this.therizinosaurus.m_9236_()).m_8767_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, state), (double)blockPos.m_123341_() + 0.5 + extraX, (double)blockPos.m_123342_() + 0.5 + extraY, (double)blockPos.m_123343_() + 0.5 + extraZ, 1, motionX, motionY, motionZ, 1.0);
        }
    }
}


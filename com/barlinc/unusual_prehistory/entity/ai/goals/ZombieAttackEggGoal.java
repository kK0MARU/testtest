/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.SectionPos
 *  net.minecraft.core.particles.ItemParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.TagKey
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.MoveToBlockGoal
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkStatus
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.event.ForgeEventFactory
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;

public class ZombieAttackEggGoal
extends MoveToBlockGoal {
    private final TagKey<Block> blockToRemove = UP2BlockTags.ZOMBIE_EGG_TARGETS;
    protected final Mob removerMob;
    private int ticksSinceReachedGoal;

    public ZombieAttackEggGoal(PathfinderMob mob) {
        super(mob, 1.0, 24, 3);
        this.removerMob = mob;
    }

    public boolean m_8036_() {
        if (!ForgeEventFactory.getMobGriefingEvent((Level)this.removerMob.m_9236_(), (Entity)this.removerMob)) {
            return false;
        }
        if (this.f_25600_ > 0) {
            --this.f_25600_;
            return false;
        }
        if (this.m_25626_()) {
            this.f_25600_ = ZombieAttackEggGoal.m_186073_((int)20);
            return true;
        }
        this.f_25600_ = this.m_6099_(this.f_25598_);
        return false;
    }

    public void m_8041_() {
        super.m_8041_();
        this.removerMob.f_19789_ = 1.0f;
    }

    public void m_8056_() {
        super.m_8056_();
        this.ticksSinceReachedGoal = 0;
    }

    public void playDestroyProgressSound(LevelAccessor level, BlockPos pos) {
        level.m_5594_(null, pos, SoundEvents.f_12604_, SoundSource.HOSTILE, 0.5f, 0.9f + this.removerMob.m_217043_().m_188501_() * 0.2f);
    }

    public void playBreakSound(Level level, BlockPos pos) {
        level.m_5594_(null, pos, SoundEvents.f_276489_, SoundSource.BLOCKS, 0.7f, 0.9f + level.f_46441_.m_188501_() * 0.2f);
    }

    public void m_8037_() {
        super.m_8037_();
        Level level = this.removerMob.m_9236_();
        BlockPos blockpos = this.removerMob.m_20183_();
        BlockPos blockpos1 = this.getPosWithBlock(blockpos, (BlockGetter)level);
        RandomSource randomsource = this.removerMob.m_217043_();
        if (this.m_25625_() && blockpos1 != null) {
            if (this.ticksSinceReachedGoal > 0) {
                Vec3 vec3 = this.removerMob.m_20184_();
                this.removerMob.m_20334_(vec3.f_82479_, 0.3, vec3.f_82481_);
                if (!level.f_46443_) {
                    ((ServerLevel)level).m_8767_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, new ItemStack((ItemLike)Items.f_42521_)), (double)blockpos1.m_123341_() + 0.5, (double)blockpos1.m_123342_() + 0.7, (double)blockpos1.m_123343_() + 0.5, 3, ((double)randomsource.m_188501_() - 0.5) * 0.08, ((double)randomsource.m_188501_() - 0.5) * 0.08, ((double)randomsource.m_188501_() - 0.5) * 0.08, (double)0.15f);
                }
            }
            if (this.ticksSinceReachedGoal % 2 == 0) {
                Vec3 vec31 = this.removerMob.m_20184_();
                this.removerMob.m_20334_(vec31.f_82479_, -0.3, vec31.f_82481_);
                if (this.ticksSinceReachedGoal % 6 == 0) {
                    this.playDestroyProgressSound((LevelAccessor)level, this.f_25602_);
                }
            }
            if (this.ticksSinceReachedGoal > 60) {
                level.m_7471_(blockpos1, false);
                if (!level.f_46443_) {
                    for (int i = 0; i < 20; ++i) {
                        double d3 = randomsource.m_188583_() * 0.02;
                        double d1 = randomsource.m_188583_() * 0.02;
                        double d2 = randomsource.m_188583_() * 0.02;
                        ((ServerLevel)level).m_8767_((ParticleOptions)ParticleTypes.f_123759_, (double)blockpos1.m_123341_() + 0.5, (double)blockpos1.m_123342_(), (double)blockpos1.m_123343_() + 0.5, 1, d3, d1, d2, (double)0.15f);
                    }
                    this.playBreakSound(level, blockpos1);
                }
            }
            ++this.ticksSinceReachedGoal;
        }
    }

    @Nullable
    private BlockPos getPosWithBlock(BlockPos pos, BlockGetter blockGetter) {
        BlockPos[] ablockpos;
        if (blockGetter.m_8055_(pos).m_204336_(this.blockToRemove)) {
            return pos;
        }
        for (BlockPos blockpos : ablockpos = new BlockPos[]{pos.m_7495_(), pos.m_122024_(), pos.m_122029_(), pos.m_122012_(), pos.m_122019_(), pos.m_7495_().m_7495_()}) {
            if (!blockGetter.m_8055_(blockpos).m_204336_(this.blockToRemove)) continue;
            return blockpos;
        }
        return null;
    }

    protected boolean m_6465_(LevelReader level, BlockPos pos) {
        ChunkAccess chunkaccess = level.m_6522_(SectionPos.m_123171_((int)pos.m_123341_()), SectionPos.m_123171_((int)pos.m_123343_()), ChunkStatus.f_62326_, false);
        if (chunkaccess == null) {
            return false;
        }
        if (!chunkaccess.m_8055_(pos).canEntityDestroy((BlockGetter)level, pos, (Entity)this.removerMob)) {
            return false;
        }
        return chunkaccess.m_8055_(pos).m_204336_(this.blockToRemove) && chunkaccess.m_8055_(pos.m_7494_()).m_60795_() && chunkaccess.m_8055_(pos.m_6630_(2)).m_60795_();
    }

    public double m_8052_() {
        return 1.14;
    }
}


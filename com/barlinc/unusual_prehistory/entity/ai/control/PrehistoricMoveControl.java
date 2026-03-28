/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.barlinc.unusual_prehistory.entity.ai.control;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PrehistoricMoveControl
extends MoveControl {
    private final PrehistoricMob prehistoricMob;

    public PrehistoricMoveControl(PrehistoricMob mob) {
        super((Mob)mob);
        this.prehistoricMob = mob;
    }

    public void m_8126_() {
        if (!this.prehistoricMob.refuseToMove() && !this.prehistoricMob.isDancing()) {
            if (this.f_24981_ == MoveControl.Operation.STRAFE) {
                this.doStrafing();
            } else if (this.f_24981_ == MoveControl.Operation.MOVE_TO) {
                this.doMoveTo();
                if (!this.prehistoricMob.m_21523_() && this.prehistoricMob.isSitting() && !this.prehistoricMob.m_21827_()) {
                    this.prehistoricMob.setSitting(false);
                }
            } else if (this.f_24981_ == MoveControl.Operation.JUMPING) {
                this.f_24974_.m_7910_((float)(this.f_24978_ * this.f_24974_.m_21133_(Attributes.f_22279_)));
                if (this.f_24974_.m_20096_()) {
                    this.f_24981_ = MoveControl.Operation.WAIT;
                }
            } else {
                this.f_24974_.m_21564_(0.0f);
            }
        }
    }

    protected void doStrafing() {
        float f8;
        float speed = (float)(this.f_24978_ * this.f_24974_.m_21133_(Attributes.f_22279_));
        float forwards = this.f_24979_;
        float right = this.f_24980_;
        float f4 = Mth.m_14116_((float)(forwards * forwards + right * right));
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        f4 = speed / f4;
        float f5 = Mth.m_14031_((float)(this.f_24974_.m_146908_() * ((float)Math.PI / 180)));
        float f6 = Mth.m_14089_((float)(this.f_24974_.m_146908_() * ((float)Math.PI / 180)));
        float f7 = (forwards *= f4) * f6 - (right *= f4) * f5;
        if (!this.m_24996_(f7, f8 = right * f6 + forwards * f5)) {
            this.f_24979_ = 1.0f;
            this.f_24980_ = 0.0f;
        }
        this.f_24974_.m_7910_(speed);
        this.f_24974_.m_21564_(this.f_24979_);
        this.f_24974_.m_21570_(this.f_24980_);
        this.f_24981_ = MoveControl.Operation.WAIT;
    }

    protected void doMoveTo() {
        double z;
        double y;
        this.f_24981_ = MoveControl.Operation.WAIT;
        double x = this.f_24975_ - this.f_24974_.m_20185_();
        double direction = x * x + (y = this.f_24976_ - this.f_24974_.m_20186_()) * y + (z = this.f_24977_ - this.f_24974_.m_20189_()) * z;
        if (direction < 2.500000277905201E-7) {
            this.f_24974_.m_21564_(0.0f);
            return;
        }
        float f9 = (float)(Mth.m_14136_((double)z, (double)x) * 57.2957763671875) - 90.0f;
        this.f_24974_.m_146922_(this.m_24991_(this.f_24974_.m_146908_(), f9, 90.0f));
        this.f_24974_.m_7910_((float)(this.f_24978_ * this.f_24974_.m_21133_(Attributes.f_22279_)));
        if (this.f_24974_.m_20069_()) {
            this.f_24974_.m_7910_(this.f_24974_.m_6113_() * 2.0f);
        }
        BlockPos blockpos = this.f_24974_.m_20183_();
        BlockState blockstate = this.f_24974_.m_9236_().m_8055_(blockpos);
        VoxelShape voxelshape = blockstate.m_60812_((BlockGetter)this.f_24974_.m_9236_(), blockpos);
        if (y > (double)this.f_24974_.getStepHeight() && x * x + z * z < (double)Math.max(1.0f, this.f_24974_.m_20205_()) || !voxelshape.m_83281_() && this.f_24974_.m_20186_() < voxelshape.m_83297_(Direction.Axis.Y) + (double)blockpos.m_123342_() && !blockstate.m_204336_(BlockTags.f_13103_) && !blockstate.m_204336_(BlockTags.f_13039_)) {
            this.f_24974_.m_21569_().m_24901_();
            this.f_24981_ = MoveControl.Operation.JUMPING;
        }
    }
}


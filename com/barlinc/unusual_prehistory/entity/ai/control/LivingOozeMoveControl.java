/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 */
package com.barlinc.unusual_prehistory.entity.ai.control;

import com.barlinc.unusual_prehistory.entity.mob.update_3.LivingOoze;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

public class LivingOozeMoveControl
extends MoveControl {
    private float yRot;
    private int jumpDelay;
    private final LivingOoze ooze;

    public LivingOozeMoveControl(LivingOoze ooze) {
        super((Mob)ooze);
        this.ooze = ooze;
        this.yRot = 180.0f * ooze.m_146908_() / (float)Math.PI;
    }

    public void setDirection(float yRot) {
        this.yRot = yRot;
    }

    public void setWantedMovement(double speed) {
        this.f_24978_ = speed;
        this.f_24981_ = MoveControl.Operation.MOVE_TO;
    }

    public void m_8126_() {
        this.f_24974_.m_146922_(this.m_24991_(this.f_24974_.m_146908_(), this.yRot, 90.0f));
        this.f_24974_.f_20885_ = this.f_24974_.m_146908_();
        this.f_24974_.f_20883_ = this.f_24974_.m_146908_();
        if (this.f_24981_ != MoveControl.Operation.MOVE_TO) {
            this.f_24974_.m_21564_(0.0f);
        } else {
            this.f_24981_ = MoveControl.Operation.WAIT;
            if (this.f_24974_.m_20096_()) {
                this.f_24974_.m_7910_((float)(this.f_24978_ * (double)1.1f * this.f_24974_.m_21133_(Attributes.f_22279_)));
                if (this.jumpDelay-- <= 0) {
                    this.ooze.setWantsToJump(false);
                    this.jumpDelay = 20;
                    this.ooze.m_21569_().m_24901_();
                    this.ooze.setHasJumped(true);
                    this.ooze.m_5496_(this.ooze.getJumpSound(), 0.8f, this.ooze.getSoundPitch());
                } else {
                    this.ooze.f_20900_ = 0.0f;
                    this.ooze.f_20902_ = 0.0f;
                    this.f_24974_.m_7910_(0.0f);
                    this.ooze.setWantsToJump(true);
                }
            } else {
                this.f_24974_.m_7910_((float)(this.f_24978_ * this.f_24974_.m_21133_(Attributes.f_22279_)));
            }
        }
    }
}


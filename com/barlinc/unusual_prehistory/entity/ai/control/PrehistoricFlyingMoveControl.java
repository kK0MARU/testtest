/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.phys.Vec3
 */
package com.barlinc.unusual_prehistory.entity.ai.control;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.phys.Vec3;

public class PrehistoricFlyingMoveControl
extends MoveControl {
    private final PrehistoricMob prehistoricMob;

    public PrehistoricFlyingMoveControl(PrehistoricMob prehistoricMob) {
        super((Mob)prehistoricMob);
        this.prehistoricMob = prehistoricMob;
    }

    public void m_8126_() {
        if (!this.prehistoricMob.refuseToMove() && this.f_24981_ == MoveControl.Operation.MOVE_TO) {
            Vec3 vector3d = new Vec3(this.f_24975_ - this.prehistoricMob.m_20185_(), this.f_24976_ - this.prehistoricMob.m_20186_(), this.f_24977_ - this.prehistoricMob.m_20189_());
            double d0 = vector3d.m_82553_();
            double width = this.prehistoricMob.m_20191_().m_82309_();
            Vec3 vector3d1 = vector3d.m_82490_(this.f_24978_ * 0.05 / d0);
            this.prehistoricMob.m_20256_(this.prehistoricMob.m_20184_().m_82549_(vector3d1).m_82490_(0.95).m_82520_(0.0, -0.01, 0.0));
            if (d0 < width) {
                this.f_24981_ = MoveControl.Operation.WAIT;
            } else if (d0 >= width) {
                float yaw = -((float)Mth.m_14136_((double)vector3d1.f_82479_, (double)vector3d1.f_82481_)) * 57.295776f;
                this.prehistoricMob.m_146922_(Mth.m_14148_((float)this.prehistoricMob.m_146908_(), (float)yaw, (float)8.0f));
            }
        }
    }
}


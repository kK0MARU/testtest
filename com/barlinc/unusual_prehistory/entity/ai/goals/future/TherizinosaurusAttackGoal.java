/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 */
package com.barlinc.unusual_prehistory.entity.ai.goals.future;

import com.barlinc.unusual_prehistory.entity.ai.goals.AttackGoal;
import com.barlinc.unusual_prehistory.entity.mob.future.Therizinosaurus;
import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import com.barlinc.unusual_prehistory.registry.UP2SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class TherizinosaurusAttackGoal
extends AttackGoal {
    private final Therizinosaurus therizinosaurus;

    public TherizinosaurusAttackGoal(Therizinosaurus therizinosaurus) {
        super(therizinosaurus);
        this.therizinosaurus = therizinosaurus;
    }

    public void m_8037_() {
        LivingEntity target = this.therizinosaurus.m_5448_();
        if (target != null) {
            this.therizinosaurus.m_21391_((Entity)this.therizinosaurus.m_5448_(), 30.0f, 30.0f);
            this.therizinosaurus.m_21563_().m_24960_((Entity)this.therizinosaurus.m_5448_(), 30.0f, 30.0f);
            double distance = this.therizinosaurus.m_20275_(target.m_20185_(), target.m_20186_(), target.m_20189_());
            int attackState = this.therizinosaurus.getAttackState();
            if (attackState == 1) {
                this.tickSlash();
                this.therizinosaurus.m_21573_().m_26573_();
            } else {
                if (distance > 12.0) {
                    this.therizinosaurus.m_21573_().m_5624_((Entity)target, 1.7);
                }
                if (distance < 14.0 && this.therizinosaurus.slashCooldown == 0) {
                    this.therizinosaurus.setAttackState(1);
                }
            }
        }
    }

    protected void tickSlash() {
        ++this.timer;
        LivingEntity target = this.therizinosaurus.m_5448_();
        if (this.timer == 10) {
            this.therizinosaurus.m_20124_(UP2Poses.ATTACKING.get());
        }
        if (this.timer == 17) {
            this.therizinosaurus.m_5496_((SoundEvent)UP2SoundEvents.THERIZINOSAURUS_ATTACK.get(), 1.0f, 0.9f + this.therizinosaurus.m_217043_().m_188501_() * 0.3f);
        }
        if (this.timer == 24 && this.isInAttackRange(target, 3.0)) {
            this.therizinosaurus.m_6674_(InteractionHand.MAIN_HAND);
            this.therizinosaurus.m_7327_((Entity)target);
            this.therizinosaurus.strongKnockback((Entity)target, 0.5, 0.0);
        }
        if (this.timer > 30) {
            this.timer = 0;
            this.therizinosaurus.slashCooldown = 5 + this.therizinosaurus.m_217043_().m_188503_(6);
            this.therizinosaurus.setAttackState(0);
        }
    }
}


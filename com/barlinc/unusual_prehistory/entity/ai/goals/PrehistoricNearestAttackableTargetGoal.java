/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import java.util.function.Predicate;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import org.jetbrains.annotations.Nullable;

public class PrehistoricNearestAttackableTargetGoal<T extends LivingEntity>
extends NearestAttackableTargetGoal<T> {
    protected final PrehistoricMob prehistoricMob;

    public PrehistoricNearestAttackableTargetGoal(PrehistoricMob mob, Class<T> targetClass, boolean mustSee) {
        super((Mob)mob, targetClass, mustSee);
        this.prehistoricMob = mob;
    }

    public PrehistoricNearestAttackableTargetGoal(PrehistoricMob mob, Class<T> targetClass, boolean mustSee, Predicate<LivingEntity> entityPredicate) {
        super((Mob)mob, targetClass, mustSee, entityPredicate);
        this.prehistoricMob = mob;
    }

    public PrehistoricNearestAttackableTargetGoal(PrehistoricMob mob, Class<T> targetClass, boolean mustSee, boolean mustReach) {
        super((Mob)mob, targetClass, mustSee, mustReach);
        this.prehistoricMob = mob;
    }

    public PrehistoricNearestAttackableTargetGoal(PrehistoricMob mob, Class<T> targetClass, int interval, boolean mustSee, boolean mustReach, @Nullable Predicate<LivingEntity> entityPredicate) {
        super((Mob)mob, targetClass, interval, mustSee, mustReach, entityPredicate);
        this.prehistoricMob = mob;
    }

    public boolean m_8036_() {
        return super.m_8036_() && !this.prehistoricMob.isPacified() && !this.prehistoricMob.m_6162_() && !this.prehistoricMob.isEepy();
    }

    public boolean m_8045_() {
        return super.m_8045_() && !this.prehistoricMob.isPacified() && !this.prehistoricMob.isEepy();
    }
}


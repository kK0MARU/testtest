/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.monster.Evoker
 *  net.minecraft.world.entity.monster.SpellcasterIllager$IllagerSpell
 *  net.minecraft.world.level.Level
 *  net.minecraftforge.event.ForgeEventFactory
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.utils.EvokerAccessor;
import java.util.List;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;

public class WololoSpellGoal<T extends LivingEntity>
extends Goal {
    protected final Evoker evoker;
    protected final EvokerAccessor evokerAccess;
    protected final Class<T> targetType;
    protected TargetingConditions targetConditions;
    protected final int redVariant;
    protected int attackWarmupDelay;
    protected int nextAttackTickCount;

    public WololoSpellGoal(Evoker evoker, Class<T> targetType, @Nullable Predicate<LivingEntity> entityPredicate, int redVariant) {
        this.evoker = evoker;
        this.evokerAccess = (EvokerAccessor)evoker;
        this.targetType = targetType;
        this.targetConditions = TargetingConditions.m_148353_().m_26883_(16.0).m_26888_(entityPredicate);
        this.redVariant = redVariant;
    }

    public boolean m_8036_() {
        if (this.evoker.m_5448_() != null) {
            return false;
        }
        if (this.evoker.m_33736_()) {
            return false;
        }
        if (this.evoker.f_19797_ < this.nextAttackTickCount) {
            return false;
        }
        if (!ForgeEventFactory.getMobGriefingEvent((Level)this.evoker.m_9236_(), (Entity)this.evoker)) {
            return false;
        }
        List list = this.evoker.m_9236_().m_45971_(this.targetType, this.targetConditions, (LivingEntity)this.evoker, this.evoker.m_20191_().m_82377_(16.0, 4.0, 16.0));
        if (list.isEmpty()) {
            return false;
        }
        this.evokerAccess.unusualPrehistory2$setLivingWololoTarget((LivingEntity)list.get(this.evoker.m_217043_().m_188503_(list.size())));
        return true;
    }

    public boolean m_8045_() {
        return this.evokerAccess.unusualPrehistory2$getLivingWololoTarget() != null && this.attackWarmupDelay > 0;
    }

    public void m_8056_() {
        this.attackWarmupDelay = this.m_183277_(this.getCastWarmupTime());
        this.evokerAccess.unusualPrehistory2$setSpellCastingTickCount(this.getCastingTime());
        this.nextAttackTickCount = this.evoker.f_19797_ + this.getCastingInterval();
        SoundEvent soundevent = this.getSpellPrepareSound();
        if (soundevent != null) {
            this.evoker.m_5496_(soundevent, 1.0f, 1.0f);
        }
        this.evoker.m_33727_(this.getSpell());
    }

    public void m_8041_() {
        this.evokerAccess.unusualPrehistory2$setLivingWololoTarget(null);
    }

    protected int getCastWarmupTime() {
        return 40;
    }

    protected int getCastingTime() {
        return 60;
    }

    protected int getCastingInterval() {
        return 140;
    }

    public void m_8037_() {
        --this.attackWarmupDelay;
        if (this.attackWarmupDelay == 0) {
            this.performSpellCasting();
            this.evoker.m_5496_(SoundEvents.f_11862_, 1.0f, 1.0f);
        }
    }

    protected void performSpellCasting() {
        LivingEntity wololoTarget = this.evokerAccess.unusualPrehistory2$getLivingWololoTarget();
        if (wololoTarget != null && wololoTarget.m_6084_() && wololoTarget instanceof PrehistoricMob) {
            PrehistoricMob prehistoricMob = (PrehistoricMob)wololoTarget;
            prehistoricMob.setVariant(this.redVariant);
        }
    }

    protected SoundEvent getSpellPrepareSound() {
        return SoundEvents.f_11869_;
    }

    protected // Could not load outer class - annotation placement on inner may be incorrect
     @NotNull SpellcasterIllager.IllagerSpell getSpell() {
        return SpellcasterIllager.IllagerSpell.WOLOLO;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.monster.Evoker
 *  net.minecraft.world.entity.monster.SpellcasterIllager
 *  net.minecraft.world.level.Level
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package com.barlinc.unusual_prehistory.mixins;

import com.barlinc.unusual_prehistory.utils.EvokerAccessor;
import javax.annotation.Nullable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={Evoker.class})
public abstract class EvokerMixin
extends SpellcasterIllager
implements EvokerAccessor {
    @Unique
    @Nullable
    private LivingEntity unusualPrehistory2$livingWololoTarget;

    protected EvokerMixin(EntityType<? extends SpellcasterIllager> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void unusualPrehistory2$setLivingWololoTarget(@Nullable LivingEntity entity) {
        this.unusualPrehistory2$livingWololoTarget = entity;
    }

    @Override
    @Nullable
    public LivingEntity unusualPrehistory2$getLivingWololoTarget() {
        return this.unusualPrehistory2$livingWololoTarget;
    }

    @Override
    public void unusualPrehistory2$setSpellCastingTickCount(int spellCastingTickCount) {
        this.f_33719_ = spellCastingTickCount;
    }
}


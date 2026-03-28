/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Mob
 *  org.jetbrains.annotations.NotNull
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package com.barlinc.unusual_prehistory.mixins;

import com.barlinc.unusual_prehistory.utils.MobAccessor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={Mob.class})
public abstract class MobMixin
implements MobAccessor {
    @Shadow
    protected abstract void m_7472_(@NotNull DamageSource var1, int var2, boolean var3);

    @Override
    public void unusualPrehistory2$dropCustomDeathLoot(DamageSource damageSource, int looting, boolean hitByPlayer) {
        this.m_7472_(damageSource, looting, hitByPlayer);
    }
}


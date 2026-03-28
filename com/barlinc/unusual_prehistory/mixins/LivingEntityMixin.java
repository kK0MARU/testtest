/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.barlinc.unusual_prehistory.mixins;

import com.barlinc.unusual_prehistory.utils.LivingEntityAccessor;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LivingEntity.class})
public abstract class LivingEntityMixin
extends Entity
implements LivingEntityAccessor {
    @Unique
    private static final EntityDataAccessor<Boolean> DATA_GRABBED = SynchedEntityData.m_135353_(LivingEntity.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at={@At(value="TAIL")}, method={"defineSynchedData"})
    private void unusualPrehistory2$defineSynchedData(CallbackInfo ci) {
        this.f_19804_.m_135372_(DATA_GRABBED, (Object)false);
    }

    @Override
    public boolean unusualPrehistory2$isBeingGrabbed() {
        return (Boolean)this.f_19804_.m_135370_(DATA_GRABBED);
    }

    @Override
    public void unusualPrehistory2$setBeingGrabbed(boolean grabbed) {
        this.f_19804_.m_135381_(DATA_GRABBED, (Object)grabbed);
    }
}


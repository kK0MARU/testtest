/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.particles.ItemParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.projectile.ThrowableItemProjectile
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.HitResult
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.event.ForgeEventFactory
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.projectile;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import java.util.function.Supplier;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;

public class ThrowableEgg
extends ThrowableItemProjectile {
    private final Supplier<EntityType<? extends PrehistoricMob>> mobToSpawn;
    private final Supplier<Item> eggItem;

    public ThrowableEgg(EntityType<? extends ThrowableItemProjectile> projectileType, Level level, Supplier<Item> eggItem, Supplier<EntityType<? extends PrehistoricMob>> mobToSpawn) {
        super(projectileType, level);
        this.eggItem = eggItem;
        this.mobToSpawn = mobToSpawn;
    }

    public ThrowableEgg(EntityType<? extends ThrowableItemProjectile> projectileType, Level level, double x, double y, double z, Supplier<Item> eggItem, Supplier<EntityType<? extends PrehistoricMob>> mobToSpawn) {
        super(projectileType, x, y, z, level);
        this.eggItem = eggItem;
        this.mobToSpawn = mobToSpawn;
    }

    protected void m_6532_(@NotNull HitResult result) {
        super.m_6532_(result);
        if (!this.m_9236_().f_46443_ && this.mobToSpawn.get() != null) {
            this.spawnMob(this.mobToSpawn.get());
        }
    }

    @NotNull
    protected Item m_7881_() {
        if (this.eggItem.get() == null) {
            return Items.f_41852_;
        }
        return this.eggItem.get();
    }

    @OnlyIn(value=Dist.CLIENT)
    public void m_7822_(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.m_9236_().m_7106_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, this.m_7846_()), this.m_20185_(), this.m_20186_(), this.m_20189_(), ((double)this.f_19796_.m_188501_() - 0.5) * 0.08, ((double)this.f_19796_.m_188501_() - 0.5) * 0.08, ((double)this.f_19796_.m_188501_() - 0.5) * 0.08);
            }
        }
    }

    public void spawnMob(EntityType<? extends PrehistoricMob> entityType) {
        Entity entity;
        int i = 1;
        if (this.f_19796_.m_188503_(200) == 0) {
            i = 4;
        }
        PrehistoricMob mob = (PrehistoricMob)entityType.m_20615_(this.m_9236_());
        for (int j = 0; j < i; ++j) {
            if (mob == null) continue;
            mob.m_146762_(-24000);
            mob.m_7678_(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_146908_(), 0.0f);
            this.m_9236_().m_7967_((Entity)mob);
            if (this.m_9236_().f_46443_) continue;
            ForgeEventFactory.onFinalizeSpawn((Mob)mob, (ServerLevelAccessor)((ServerLevel)this.m_9236_()), (DifficultyInstance)this.m_9236_().m_6436_(this.m_20183_()), (MobSpawnType)MobSpawnType.NATURAL, null, null);
        }
        if (!this.m_9236_().f_46443_ && this.m_19749_() != null && (entity = this.m_19749_()) instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            if (mob != null) {
                CriteriaTriggers.f_10580_.m_68256_(serverPlayer, (Entity)mob);
            }
        }
        this.m_9236_().m_7605_((Entity)this, (byte)3);
        this.m_146870_();
    }
}


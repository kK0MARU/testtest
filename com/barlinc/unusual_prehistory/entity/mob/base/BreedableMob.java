/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.ExperienceOrb
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.mob.base;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.registry.UP2Criterion;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class BreedableMob
extends PrehistoricMob {
    protected BreedableMob(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public int m_213860_() {
        return 1 + this.m_9236_().f_46441_.m_188503_(3);
    }

    @Override
    public boolean m_6149_() {
        return !this.m_6162_();
    }

    @Override
    public boolean m_5957_() {
        return true;
    }

    @Override
    public boolean m_7848_(@NotNull Animal animal) {
        return true;
    }

    @Override
    @NotNull
    public InteractionResult m_6071_(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        if (this.m_6898_(itemstack)) {
            int i = this.m_146764_();
            if (!this.m_9236_().f_46443_ && i == 0 && this.m_5957_()) {
                this.m_142075_(player, hand, itemstack);
                this.m_216990_(this.getEatingSound());
                this.m_27595_(player);
                return InteractionResult.SUCCESS;
            }
        }
        return super.m_6071_(player, hand);
    }

    public void m_277117_(ServerLevel level, Animal animal, @Nullable AgeableMob baby) {
        Optional.ofNullable(this.m_27592_()).or(() -> Optional.ofNullable(animal.m_27592_())).ifPresent(serverPlayer -> {
            serverPlayer.m_36220_(Stats.f_12937_);
            CriteriaTriggers.f_10581_.m_147278_(serverPlayer, (Animal)this, animal, baby);
            UP2Criterion.BREED_HOLOCENE_MOBS.trigger((ServerPlayer)serverPlayer);
        });
        this.m_146762_(6000);
        animal.m_146762_(6000);
        this.m_27594_();
        animal.m_27594_();
        level.m_7605_((Entity)this, (byte)18);
        if (level.m_46469_().m_46207_(GameRules.f_46135_)) {
            level.m_7967_((Entity)new ExperienceOrb((Level)level, this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_217043_().m_188503_(7) + 1));
        }
    }
}


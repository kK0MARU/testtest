/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.gameevent.GameEvent
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.items;

import com.barlinc.unusual_prehistory.entity.projectile.ThrowableEgg;
import java.util.Random;
import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class ThrowableEggItem
extends Item {
    private final Random random = new Random();
    private final Supplier<? extends EntityType<?>> toSpawn;

    public ThrowableEggItem(Item.Properties properties, Supplier<? extends EntityType<?>> toSpawn) {
        super(properties);
        this.toSpawn = toSpawn;
    }

    @NotNull
    public InteractionResultHolder<ItemStack> m_7203_(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        player.m_146850_(GameEvent.f_223698_);
        level.m_6263_(null, player.m_20185_(), player.m_20186_(), player.m_20189_(), SoundEvents.f_11877_, SoundSource.PLAYERS, 0.5f, 0.4f / (this.random.nextFloat() * 0.4f + 0.8f));
        if (!level.f_46443_) {
            if (this.toSpawn.get() == null) {
                return InteractionResultHolder.m_19100_((Object)itemstack);
            }
            Entity entity = this.toSpawn.get().m_20615_(level);
            if (entity instanceof ThrowableEgg) {
                ThrowableEgg egg = (ThrowableEgg)entity;
                egg.m_5602_((Entity)player);
                egg.m_6034_(player.m_20185_(), player.m_20188_() - (double)0.1f, player.m_20189_());
                egg.m_37446_(itemstack);
                egg.m_37251_((Entity)player, player.m_146909_(), player.m_146908_(), 0.0f, 1.5f, 1.0f);
                level.m_7967_((Entity)egg);
            }
        }
        player.m_36246_(Stats.f_12982_.m_12902_((Object)this));
        if (!player.m_150110_().f_35937_) {
            itemstack.m_41774_(1);
        }
        return InteractionResultHolder.m_19092_((Object)itemstack, (boolean)level.m_5776_());
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.ItemSteerable
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.items;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ItemSteerable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class UP2FoodOnAStickItem
extends Item {
    private final int consumeItemDamage;

    public UP2FoodOnAStickItem(Item.Properties properties, int consumeItemDamage) {
        super(properties);
        this.consumeItemDamage = consumeItemDamage;
    }

    @NotNull
    public InteractionResultHolder<ItemStack> m_7203_(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        if (!level.f_46443_) {
            ItemSteerable itemsteerable;
            Entity entity = player.m_275832_();
            if (player.m_20159_() && entity instanceof ItemSteerable && (itemsteerable = (ItemSteerable)entity).m_6746_()) {
                itemstack.m_41622_(this.consumeItemDamage, (LivingEntity)player, player1 -> player1.m_21190_(hand));
                if (itemstack.m_41619_()) {
                    ItemStack stack = new ItemStack((ItemLike)Items.f_42523_);
                    stack.m_41751_(itemstack.m_41783_());
                    return InteractionResultHolder.m_19090_((Object)stack);
                }
                return InteractionResultHolder.m_19090_((Object)itemstack);
            }
            player.m_36246_(Stats.f_12982_.m_12902_((Object)this));
        }
        return InteractionResultHolder.m_19098_((Object)itemstack);
    }
}


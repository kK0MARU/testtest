/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.MobBucketItem
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraftforge.event.ForgeEventFactory
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.items;

import com.barlinc.unusual_prehistory.registry.UP2Entities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;

public class LivingOozeBucketItem
extends MobBucketItem {
    public LivingOozeBucketItem(Item.Properties properties) {
        super(UP2Entities.LIVING_OOZE, () -> Fluids.f_76191_, () -> SoundEvents.f_12392_, properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> m_7203_(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        BlockHitResult blockhitresult;
        ItemStack itemstack = player.m_21120_(hand);
        InteractionResultHolder onBucketUse = ForgeEventFactory.onBucketUse((Player)player, (Level)level, (ItemStack)itemstack, (HitResult)(blockhitresult = LivingOozeBucketItem.m_41435_((Level)level, (Player)player, (ClipContext.Fluid)ClipContext.Fluid.NONE)));
        if (onBucketUse != null) {
            return onBucketUse;
        }
        if (blockhitresult.m_6662_() == HitResult.Type.MISS) {
            return InteractionResultHolder.m_19098_((Object)itemstack);
        }
        if (blockhitresult.m_6662_() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.m_19098_((Object)itemstack);
        }
        BlockPos blockpos = blockhitresult.m_82425_();
        Direction direction = blockhitresult.m_82434_();
        BlockPos blockpos1 = blockpos.m_121945_(direction);
        if (level.m_7966_(player, blockpos) && player.m_36204_(blockpos1, direction, itemstack)) {
            this.m_142131_(player, level, itemstack, blockpos1);
            this.m_7718_(player, (LevelAccessor)level, blockpos1);
            player.m_36246_(Stats.f_12982_.m_12902_((Object)this));
            return InteractionResultHolder.m_19092_((Object)LivingOozeBucketItem.m_40699_((ItemStack)itemstack, (Player)player), (boolean)level.m_5776_());
        }
        return super.m_7203_(level, player, hand);
    }
}


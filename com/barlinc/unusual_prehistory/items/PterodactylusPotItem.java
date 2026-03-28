/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.items;

import com.barlinc.unusual_prehistory.entity.mob.update_4.Pterodactylus;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import java.util.List;
import java.util.Objects;
import java.util.function.IntFunction;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PterodactylusPotItem
extends Item {
    private final IntFunction<String> variantNameGetter;

    public PterodactylusPotItem(Item.Properties properties, @Nullable IntFunction<String> variantNameGetter) {
        super(properties);
        this.variantNameGetter = variantNameGetter;
    }

    @NotNull
    public InteractionResult m_6225_(UseOnContext context) {
        Entity entity;
        Level level = context.m_43725_();
        level.m_5594_(context.m_43723_(), context.m_8083_(), SoundEvents.f_12019_, SoundSource.BLOCKS, 1.0f, 1.1f);
        if (level.m_5776_()) {
            return InteractionResult.SUCCESS;
        }
        ItemStack itemstack = context.m_43722_();
        BlockPos blockpos = context.m_8083_();
        Direction direction = context.m_43719_();
        BlockState blockstate = level.m_8055_(blockpos);
        BlockPos blockpos1 = blockstate.m_60812_((BlockGetter)level, blockpos).m_83281_() ? blockpos : blockpos.m_121945_(direction);
        CompoundTag compoundTag = itemstack.m_41784_();
        if (!context.m_43723_().m_150110_().f_35937_) {
            context.m_43723_().m_21008_(context.m_43724_(), new ItemStack((ItemLike)Items.f_42618_));
        }
        if ((entity = ((EntityType)UP2Entities.PTERODACTYLUS.get()).m_20592_((ServerLevel)level, itemstack, context.m_43723_(), blockpos1, MobSpawnType.BUCKET, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP)) instanceof Pterodactylus) {
            Pterodactylus mob = (Pterodactylus)entity;
            mob.m_142278_(compoundTag);
        }
        return InteractionResult.CONSUME;
    }

    public void m_7373_(@NotNull ItemStack stack, @Nullable Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.m_7373_(stack, world, tooltip, flag);
        if (this.variantNameGetter == null) {
            return;
        }
        ChatFormatting[] grayChatFormatting = new ChatFormatting[]{ChatFormatting.ITALIC, ChatFormatting.GRAY};
        CompoundTag compoundTag = stack.m_41783_();
        if (compoundTag == null || !compoundTag.m_128425_("BucketVariantTag", 3)) {
            return;
        }
        int variantId = compoundTag.m_128451_("BucketVariantTag");
        String variantName = this.variantNameGetter.apply(variantId);
        EntityType type = (EntityType)UP2Entities.PTERODACTYLUS.get();
        ResourceLocation key = EntityType.m_20613_((EntityType)type);
        String translationKey = "entity." + key.m_135827_() + "." + key.m_135815_() + ".variant_" + variantName;
        tooltip.add((Component)Component.m_237115_((String)translationKey).m_130944_(grayChatFormatting));
    }
}


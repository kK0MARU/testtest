/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.CommonComponents
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
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
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.items;

import com.barlinc.unusual_prehistory.entity.mob.update_1.Kimmeridgebrachypteraeschnidium;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import java.util.List;
import java.util.Objects;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KimmeridgebrachypteraeschnidiumBottleItem
extends Item {
    public KimmeridgebrachypteraeschnidiumBottleItem(Item.Properties properties) {
        super(properties.m_41487_(1));
    }

    @NotNull
    public InteractionResult m_6225_(UseOnContext context) {
        Entity entity;
        Level level = context.m_43725_();
        level.m_5594_(context.m_43723_(), context.m_8083_(), SoundEvents.f_11771_, SoundSource.BLOCKS, 1.0f, 1.0f);
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
            context.m_43723_().m_21008_(context.m_43724_(), new ItemStack((ItemLike)Items.f_42590_));
        }
        if ((entity = ((EntityType)UP2Entities.KIMMERIDGEBRACHYPTERAESCHNIDIUM.get()).m_20592_((ServerLevel)level, itemstack, context.m_43723_(), blockpos1, MobSpawnType.BUCKET, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP)) instanceof Kimmeridgebrachypteraeschnidium) {
            Kimmeridgebrachypteraeschnidium mob = (Kimmeridgebrachypteraeschnidium)entity;
            int age = compoundTag.m_128441_("Age") ? compoundTag.m_128451_("Age") : 0;
            float health = compoundTag.m_128441_("Health") ? compoundTag.m_128457_("Health") : 6.0f;
            int base_color = compoundTag.m_128441_("BaseColor") ? compoundTag.m_128451_("BaseColor") : level.f_46441_.m_188503_(16);
            int pattern = compoundTag.m_128441_("Pattern") ? compoundTag.m_128451_("Pattern") : level.f_46441_.m_188503_(7);
            int pattern_color = compoundTag.m_128441_("PatternColor") ? compoundTag.m_128451_("PatternColor") : level.f_46441_.m_188503_(16);
            int wing_color = compoundTag.m_128441_("WingColor") ? compoundTag.m_128451_("WingColor") : level.f_46441_.m_188503_(16);
            boolean hasPattern = compoundTag.m_128441_("HasPattern") && compoundTag.m_128471_("HasPattern");
            mob.m_146762_(age);
            mob.m_21153_(health);
            mob.m_21530_();
            mob.setBaseColor(base_color);
            mob.setPattern(pattern);
            mob.setPatternColor(pattern_color);
            mob.setWingColor(wing_color);
            mob.setHasPattern(hasPattern);
        }
        return InteractionResult.CONSUME;
    }

    @OnlyIn(value=Dist.CLIENT)
    public void m_7373_(@NotNull ItemStack stack, @Nullable Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.m_7373_(stack, world, tooltip, flag);
        ChatFormatting[] grayChatFormatting = new ChatFormatting[]{ChatFormatting.ITALIC, ChatFormatting.GRAY};
        CompoundTag compoundTag = stack.m_41783_();
        if (compoundTag != null && compoundTag.m_128425_("BaseColor", 3)) {
            int base_color = compoundTag.m_128451_("BaseColor");
            int pattern = compoundTag.m_128451_("Pattern");
            int pattern_color = compoundTag.m_128451_("PatternColor");
            int wing_color = compoundTag.m_128451_("WingColor");
            boolean hasPattern = compoundTag.m_128471_("HasPattern");
            String base = "entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.base_color_" + base_color;
            String patterns = "entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_" + Kimmeridgebrachypteraeschnidium.getPatternName(pattern);
            String patternColor = "entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.pattern_color_" + pattern_color;
            String wingColor = "entity.unusual_prehistory.kimmeridgebrachypteraeschnidium.wing_color_" + wing_color;
            MutableComponent patternInfo = Component.m_237115_((String)patternColor);
            patternInfo.m_7220_(CommonComponents.f_263701_).m_7220_((Component)Component.m_237115_((String)patterns));
            patternInfo.m_130944_(grayChatFormatting);
            tooltip.add((Component)Component.m_237115_((String)base).m_130944_(grayChatFormatting));
            tooltip.add((Component)Component.m_237115_((String)wingColor).m_130944_(grayChatFormatting));
            if (hasPattern) {
                tooltip.add((Component)patternInfo);
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.ChatFormatting
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.MobBucketItem
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.material.Fluid
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.items;

import com.barlinc.unusual_prehistory.registry.UP2Entities;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

public class UP2MobBucketItem
extends MobBucketItem {
    private final IntFunction<String> variantNameGetter;

    public UP2MobBucketItem(Supplier<? extends EntityType<?>> entityType, Fluid fluid, SoundEvent sound, Item.Properties properties) {
        this(entityType, fluid, sound, properties, null);
    }

    public UP2MobBucketItem(Supplier<? extends EntityType<?>> entityType, Fluid fluid, SoundEvent sound, Item.Properties properties, @Nullable IntFunction<String> variantNameGetter) {
        super(entityType, () -> fluid, () -> sound, properties.m_41487_(1));
        this.variantNameGetter = variantNameGetter;
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
        EntityType type = this.getFishType();
        ResourceLocation key = EntityType.m_20613_((EntityType)type);
        String translationKey = "entity." + key.m_135827_() + "." + key.m_135815_() + ".variant_" + variantName;
        tooltip.add((Component)Component.m_237115_((String)translationKey).m_130944_(grayChatFormatting));
        if (type == UP2Entities.COELACANTHUS.get() && compoundTag.m_128425_("Size", 3)) {
            int i = compoundTag.m_128451_("Size");
            String size = "entity." + key.m_135827_() + "." + key.m_135815_() + ".size";
            tooltip.add((Component)Component.m_237110_((String)size, (Object[])new Object[]{i}).m_130940_(ChatFormatting.GRAY).m_130940_(ChatFormatting.ITALIC));
        }
    }
}


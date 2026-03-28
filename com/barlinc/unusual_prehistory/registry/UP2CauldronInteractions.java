/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  it.unimi.dsi.fastutil.objects.ObjectArraySet
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.cauldron.CauldronInteraction
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.LayeredCauldronBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.gameevent.GameEvent
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import java.util.Map;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;

public record UP2CauldronInteractions(ResourceLocation name, Map<Item, CauldronInteraction> map) {
    private static final Set<UP2CauldronInteractions> CAULDRON_INTERACTIONS = new ObjectArraySet();
    public static final UP2CauldronInteractions EMPTY = UP2CauldronInteractions.register(new ResourceLocation("empty"), CauldronInteraction.f_175606_);
    public static final UP2CauldronInteractions WATER = UP2CauldronInteractions.register(new ResourceLocation("water"), CauldronInteraction.f_175607_);
    public static final UP2CauldronInteractions LAVA = UP2CauldronInteractions.register(new ResourceLocation("lava"), CauldronInteraction.f_175608_);
    public static final UP2CauldronInteractions POWDER_SNOW = UP2CauldronInteractions.register(new ResourceLocation("powder_snow"), CauldronInteraction.f_175609_);
    public static UP2CauldronInteractions OOZE = UP2CauldronInteractions.register(UnusualPrehistory2.modPrefix("ooze"), (Map<Item, CauldronInteraction>)CauldronInteraction.m_175617_());
    public static final CauldronInteraction FILL_OOZE = (state, level, pos, player, hand, stack) -> CauldronInteraction.m_175618_((Level)level, (BlockPos)pos, (Player)player, (InteractionHand)hand, (ItemStack)stack, (BlockState)((BlockState)((Block)UP2Blocks.OOZE_CAULDRON.get()).m_49966_().m_61124_((Property)LayeredCauldronBlock.f_153514_, (Comparable)Integer.valueOf(3))), (SoundEvent)SoundEvents.f_12389_);

    public static void registerCauldronInteractions() {
        UP2CauldronInteractions.addMoreDefaultInteractions((Item)UP2Items.LIVING_OOZE_BUCKET.get(), FILL_OOZE);
        OOZE.map().put(Items.f_42446_, (state, level, pos, player, hand, stack) -> CauldronInteraction.m_175635_((BlockState)state, (Level)level, (BlockPos)pos, (Player)player, (InteractionHand)hand, (ItemStack)stack, (ItemStack)new ItemStack((ItemLike)UP2Items.LIVING_OOZE_BUCKET.get()), cauldronState -> (Integer)cauldronState.m_61143_((Property)LayeredCauldronBlock.f_153514_) == 3, (SoundEvent)SoundEvents.f_12392_));
        UP2CauldronInteractions.fillWithItem((Item)UP2Items.ORGANIC_OOZE.get(), (Block)UP2Blocks.OOZE_CAULDRON.get(), OOZE.map());
    }

    public static void fillWithItem(Item item, Block filledCauldron, Map<Item, CauldronInteraction> map) {
        CauldronInteraction.m_175647_(map);
        map.put(item, (state, level, pos, player, hand, stack) -> {
            if ((Integer)state.m_61143_((Property)LayeredCauldronBlock.f_153514_) != 3) {
                if (!level.f_46443_) {
                    player.m_36220_(Stats.f_12944_);
                    player.m_36246_(Stats.f_12982_.m_12902_((Object)stack.m_41720_()));
                    level.m_46597_(pos, (BlockState)state.m_61122_((Property)LayeredCauldronBlock.f_153514_));
                    level.m_5594_(null, pos, SoundEvents.f_12392_, SoundSource.BLOCKS, 1.0f, 1.0f);
                    level.m_142346_(null, GameEvent.f_157769_, pos);
                    stack.m_41774_(1);
                }
                return InteractionResult.m_19078_((boolean)level.f_46443_);
            }
            return InteractionResult.PASS;
        });
        CauldronInteraction.f_175606_.put(item, (state, level, pos, player, hand, stack) -> {
            if (!level.f_46443_) {
                Item item1 = stack.m_41720_();
                player.m_36220_(Stats.f_12944_);
                player.m_36246_(Stats.f_12982_.m_12902_((Object)item1));
                level.m_46597_(pos, filledCauldron.m_49966_());
                level.m_5594_(null, pos, SoundEvents.f_12392_, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.m_142346_(null, GameEvent.f_157769_, pos);
                stack.m_41774_(1);
            }
            return InteractionResult.m_19078_((boolean)level.f_46443_);
        });
    }

    public static UP2CauldronInteractions create(ResourceLocation name, Map<Item, CauldronInteraction> map) {
        return new UP2CauldronInteractions(name, map);
    }

    public static synchronized UP2CauldronInteractions register(UP2CauldronInteractions map) {
        CAULDRON_INTERACTIONS.add(map);
        return map;
    }

    public static UP2CauldronInteractions register(ResourceLocation name, Map<Item, CauldronInteraction> map) {
        return UP2CauldronInteractions.register(UP2CauldronInteractions.create(name, map));
    }

    public static void addMoreDefaultInteractions(Item item, CauldronInteraction interaction) {
        UP2CauldronInteractions.values().forEach(cauldronInteractions -> cauldronInteractions.map.put(item, interaction));
    }

    public static ImmutableList<UP2CauldronInteractions> values() {
        return ImmutableList.copyOf(CAULDRON_INTERACTIONS);
    }
}


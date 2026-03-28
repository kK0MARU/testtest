/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.items;

import com.barlinc.unusual_prehistory.entity.misc.UP2Boat;
import com.barlinc.unusual_prehistory.entity.misc.UP2ChestBoat;
import com.barlinc.unusual_prehistory.entity.utils.UP2BoatType;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class UP2BoatItem
extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.f_20408_.and(Entity::m_6087_);
    private final UP2BoatType.Type type;
    private final boolean hasChest;

    public UP2BoatItem(boolean hasChest, UP2BoatType.Type type, Item.Properties properties) {
        super(properties);
        this.type = type;
        this.hasChest = hasChest;
    }

    @NotNull
    public InteractionResultHolder<ItemStack> m_7203_(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.m_21120_(hand);
        BlockHitResult hitresult = UP2BoatItem.m_41435_((Level)level, (Player)player, (ClipContext.Fluid)ClipContext.Fluid.ANY);
        if (hitresult.m_6662_() == HitResult.Type.MISS) {
            return InteractionResultHolder.m_19098_((Object)itemstack);
        }
        Vec3 vec3 = player.m_20252_(1.0f);
        List list = level.m_6249_((Entity)player, player.m_20191_().m_82369_(vec3.m_82490_(5.0)).m_82400_(1.0), ENTITY_PREDICATE);
        if (!list.isEmpty()) {
            Vec3 vec31 = player.m_146892_();
            for (Entity entity : list) {
                AABB aabb = entity.m_20191_().m_82400_((double)entity.m_6143_());
                if (!aabb.m_82390_(vec31)) continue;
                return InteractionResultHolder.m_19098_((Object)itemstack);
            }
        }
        if (hitresult.m_6662_() == HitResult.Type.BLOCK) {
            UP2BoatType boat = this.hasChest ? new UP2ChestBoat(level, hitresult.m_82450_(), this.type) : new UP2Boat(level, hitresult.m_82450_(), this.type);
            boat.m_146922_(player.m_146908_());
            if (!level.m_45756_((Entity)boat, boat.m_20191_())) {
                return InteractionResultHolder.m_19100_((Object)itemstack);
            }
            if (!level.f_46443_) {
                level.m_7967_((Entity)boat);
                level.m_220400_((Entity)player, GameEvent.f_157810_, hitresult.m_82450_());
                if (!player.m_150110_().f_35937_) {
                    itemstack.m_41774_(1);
                }
            }
            player.m_36246_(Stats.f_12982_.m_12902_((Object)this));
            return InteractionResultHolder.m_19092_((Object)itemstack, (boolean)level.m_5776_());
        }
        return InteractionResultHolder.m_19098_((Object)itemstack);
    }
}


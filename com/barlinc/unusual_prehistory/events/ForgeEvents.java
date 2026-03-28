/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LightningBolt
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.AvoidEntityGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.animal.Cow
 *  net.minecraft.world.entity.monster.Creeper
 *  net.minecraft.world.entity.monster.Evoker
 *  net.minecraft.world.entity.monster.Guardian
 *  net.minecraft.world.entity.monster.Zombie
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraftforge.event.entity.EntityJoinLevelEvent
 *  net.minecraftforge.event.entity.living.BabyEntitySpawnEvent
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingVisibilityEvent
 *  net.minecraftforge.event.entity.living.LivingHurtEvent
 *  net.minecraftforge.event.level.BlockEvent$BreakEvent
 *  net.minecraftforge.eventbus.api.EventPriority
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 */
package com.barlinc.unusual_prehistory.events;

import com.barlinc.unusual_prehistory.entity.ai.goals.PrehistoricAvoidEntityGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.WololoSpellGoal;
import com.barlinc.unusual_prehistory.entity.ai.goals.ZombieAttackEggGoal;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Dunkleosteus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Kentrosaurus;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Majungasaurus;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Leptictidium;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Ulughbegsaurus;
import com.barlinc.unusual_prehistory.registry.UP2DamageTypes;
import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.tags.UP2BlockTags;
import com.barlinc.unusual_prehistory.utils.MobAccessor;
import com.mojang.authlib.GameProfile;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid="unusual_prehistory", bus=Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    @SubscribeEvent
    public static void onBabySpawn(BabyEntitySpawnEvent event) {
        Mob mob = event.getParentA();
        if (mob instanceof Cow) {
            Level level;
            Cow parent = (Cow)mob;
            if (event.getParentB() instanceof Cow && (level = parent.m_20193_()).m_213780_().m_188503_(10000) == 0) {
                event.setChild((AgeableMob)((EntityType)UP2Entities.UNICORN.get()).m_20615_(level));
            }
        }
    }

    @SubscribeEvent(priority=EventPriority.LOWEST)
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Mob) {
            PathfinderMob pathfinderMob;
            Mob mob = (Mob)entity;
            if (mob instanceof Evoker) {
                Evoker evoker = (Evoker)mob;
                evoker.f_21345_.m_25352_(6, new WololoSpellGoal<Ulughbegsaurus>(evoker, Ulughbegsaurus.class, livingEntity -> ((Ulughbegsaurus)livingEntity).getVariant() == 12, 5));
            }
            if (mob instanceof Guardian) {
                Guardian guardian = (Guardian)mob;
                guardian.f_21345_.m_25352_(3, (Goal)new AvoidEntityGoal((PathfinderMob)guardian, Dunkleosteus.class, 12.0f, 1.5, 1.5));
            }
            if (mob instanceof Zombie) {
                Zombie zombie = (Zombie)mob;
                zombie.f_21345_.m_25352_(4, (Goal)new ZombieAttackEggGoal((PathfinderMob)zombie));
            }
            if (mob instanceof PathfinderMob && (pathfinderMob = (PathfinderMob)mob).m_6336_() == MobType.f_21642_) {
                if (pathfinderMob instanceof PrehistoricMob) {
                    PrehistoricMob prehistoricMob = (PrehistoricMob)pathfinderMob;
                    prehistoricMob.f_21345_.m_25352_(1, new PrehistoricAvoidEntityGoal<Leptictidium>(prehistoricMob, Leptictidium.class, 12.0f, 1.5, false));
                } else {
                    pathfinderMob.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal(pathfinderMob, Leptictidium.class, 12.0f, 1.5, 1.5));
                }
            }
        }
    }

    @SubscribeEvent
    public static void breakBlock(BlockEvent.BreakEvent event) {
        BlockState state = event.getState();
        if (state.m_204336_(UP2BlockTags.GUARDED_BY_KENTROSAURUS)) {
            Kentrosaurus.angerNearbyKentrosaurus(event.getPlayer(), false);
        }
    }

    @SubscribeEvent
    public static void onMobHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        DamageSource damageSource = event.getSource();
        if (entity instanceof Guardian && damageSource.m_7639_() instanceof Dunkleosteus) {
            event.setAmount(event.getAmount() * 2.0f);
        }
        if (entity.m_6336_() == MobType.f_21642_ && damageSource.m_7639_() instanceof Leptictidium) {
            event.setAmount(event.getAmount() * 2.0f);
        }
    }

    @SubscribeEvent
    public static void onLivingVisibility(LivingEvent.LivingVisibilityEvent event) {
        Majungasaurus majungasaurus;
        LivingEntity entity = event.getEntity();
        if (event.getLookingEntity() != null && entity instanceof Majungasaurus && (majungasaurus = (Majungasaurus)entity).isCamo()) {
            event.modifyVisibility((double)0.3f);
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (event.getSource().m_276093_(UP2DamageTypes.EXECUTE) && !entity.m_9236_().f_46443_) {
            Creeper fakeCreeperForSkullDrop;
            Mob mob;
            if (entity instanceof Player) {
                Player player = (Player)entity;
                ItemStack itemstack = new ItemStack((ItemLike)Items.f_42680_);
                CompoundTag compoundTag = new CompoundTag();
                GameProfile profile = player.m_36316_();
                compoundTag.m_128362_("Id", profile.getId());
                compoundTag.m_128359_("Name", profile.getName());
                itemstack.m_41784_().m_128365_("SkullOwner", (Tag)compoundTag);
                player.m_19983_(itemstack);
            } else if (entity instanceof Mob && (mob = (Mob)entity).m_9236_().m_213780_().m_188501_() < 0.1f && (fakeCreeperForSkullDrop = (Creeper)EntityType.f_20558_.m_20615_(mob.m_9236_())) != null) {
                ServerLevel serverLevel;
                LightningBolt fakeThunder;
                Level profile = event.getEntity().m_9236_();
                if (profile instanceof ServerLevel && (fakeThunder = (LightningBolt)EntityType.f_20465_.m_20615_((Level)(serverLevel = (ServerLevel)profile))) != null) {
                    fakeThunder.m_20874_(true);
                    fakeCreeperForSkullDrop.m_8038_(serverLevel, fakeThunder);
                }
                DamageSource fakeCreeperDamage = mob.m_9236_().m_269111_().m_269333_((LivingEntity)fakeCreeperForSkullDrop);
                MobAccessor accessor = (MobAccessor)mob;
                accessor.unusualPrehistory2$dropCustomDeathLoot(fakeCreeperDamage, 0, false);
            }
        }
    }
}


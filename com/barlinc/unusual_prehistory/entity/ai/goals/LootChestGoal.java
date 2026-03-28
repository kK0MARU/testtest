/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Vec3i
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Container
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.TamableAnimal
 *  net.minecraft.world.entity.ai.goal.MoveToBlockGoal
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.ChestBlock
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.ChestBlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.ChestType
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.ai.goals;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.utils.ChestLootingMob;
import java.util.ArrayList;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class LootChestGoal
extends MoveToBlockGoal {
    protected final ChestLootingMob chestLooter;
    protected boolean hasOpenedChest = false;

    public LootChestGoal(PathfinderMob mob, double speedModifier, int range, int verticalRange) {
        super(mob, speedModifier, range, verticalRange);
        this.chestLooter = (ChestLootingMob)mob;
    }

    public boolean m_8036_() {
        if (this.f_25598_ instanceof TamableAnimal && ((TamableAnimal)this.f_25598_).m_21824_()) {
            return false;
        }
        if (!this.f_25598_.m_21120_(InteractionHand.MAIN_HAND).m_41619_()) {
            return false;
        }
        return super.m_8036_();
    }

    public boolean m_8045_() {
        return super.m_8045_() && this.f_25598_.m_21120_(InteractionHand.MAIN_HAND).m_41619_();
    }

    public void m_8041_() {
        super.m_8041_();
        BlockEntity blockEntity = this.f_25598_.m_9236_().m_7702_(this.f_25602_);
        if (blockEntity instanceof Container) {
            this.toggleChest((Container)blockEntity, false);
        }
        this.f_25602_ = BlockPos.f_121853_;
        this.hasOpenedChest = false;
    }

    protected int m_6099_(@NotNull PathfinderMob mob) {
        return LootChestGoal.m_186073_((int)(100 + mob.m_217043_().m_188503_(100)));
    }

    public boolean isChestRaidable(LevelReader level, BlockPos pos) {
        BlockEntity entity;
        if (level.m_8055_(pos).m_60734_() instanceof BaseEntityBlock && (entity = level.m_7702_(pos)) instanceof Container) {
            Container inventory = (Container)entity;
            try {
                if (!inventory.m_7983_() && this.chestLooter.isLootable(inventory)) {
                    return true;
                }
            }
            catch (Exception exception) {
                UnusualPrehistory2.LOGGER.warn("Unusual Prehistory 2 stopped a {} from causing a crash during access", (Object)entity.getClass().getSimpleName());
                exception.printStackTrace();
            }
        }
        return false;
    }

    @NotNull
    protected BlockPos m_6669_() {
        return this.f_25602_;
    }

    protected void m_25624_() {
        BlockPos pos = this.m_6669_();
        this.f_25598_.m_21573_().m_26519_((double)pos.m_123341_() + 0.5, (double)(pos.m_123342_() + 1), (double)pos.m_123343_() + 0.5, this.f_25599_);
    }

    public boolean hasLineOfSightChest() {
        BlockHitResult hitResult = this.f_25598_.m_9236_().m_45547_(new ClipContext(this.f_25598_.m_20299_(1.0f), new Vec3((double)this.f_25602_.m_123341_() + 0.5, (double)this.f_25602_.m_123342_() + 0.5, (double)this.f_25602_.m_123343_() + 0.5), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)this.f_25598_));
        if (hitResult instanceof BlockHitResult) {
            BlockHitResult blockHitResult = hitResult;
            BlockPos pos = blockHitResult.m_82425_();
            return pos.equals((Object)this.f_25602_) || this.f_25598_.m_9236_().m_46859_(pos) || this.f_25598_.m_9236_().m_7702_(pos) == this.f_25598_.m_9236_().m_7702_(this.f_25602_);
        }
        return true;
    }

    public ItemStack getItemsFromInventory(Container inventory, RandomSource random) {
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        for (int i = 0; i < inventory.m_6643_(); ++i) {
            ItemStack stack = inventory.m_8020_(i);
            if (stack.m_41619_() || !this.chestLooter.shouldLootItem(stack)) continue;
            items.add(stack);
        }
        if (items.isEmpty()) {
            return ItemStack.f_41583_;
        }
        if (items.size() == 1) {
            return (ItemStack)items.get(0);
        }
        return (ItemStack)items.get(random.m_188503_(items.size() - 1));
    }

    public double m_8052_() {
        return Math.pow(this.f_25598_.m_20205_(), 2.0) + 3.0;
    }

    public boolean m_8064_() {
        return false;
    }

    public void m_8037_() {
        super.m_8037_();
        BlockEntity blockEntity = this.f_25598_.m_9236_().m_7702_(this.f_25602_);
        if (blockEntity instanceof Container) {
            Container container = (Container)blockEntity;
            double distance = this.f_25598_.m_20275_((double)((float)this.f_25602_.m_123341_() + 0.5f), (double)((float)this.f_25602_.m_123342_() + 0.5f), (double)((float)this.f_25602_.m_123343_() + 0.5f));
            this.f_25598_.m_21573_().m_26519_((double)((float)this.f_25602_.m_123341_() + 0.5f), (double)(this.f_25602_.m_123342_() - 1), (double)((float)this.f_25602_.m_123343_() + 0.5f), 1.0);
            if (this.hasLineOfSightChest()) {
                this.f_25598_.m_7618_(EntityAnchorArgument.Anchor.EYES, Vec3.m_82512_((Vec3i)this.f_25602_));
                if (distance <= this.m_8052_()) {
                    this.f_25598_.m_21573_().m_26573_();
                    this.chestLooter.startOpeningChest();
                    if (!this.hasOpenedChest) {
                        this.hasOpenedChest = true;
                        this.toggleChest(container, true);
                    }
                    if (this.hasOpenedChest && this.chestLooter.openChest()) {
                        ItemStack stack = this.getItemsFromInventory(container, this.f_25598_.m_9236_().f_46441_);
                        if (stack == ItemStack.f_41583_) {
                            this.m_8041_();
                        } else {
                            ItemStack duplicate = stack.m_41777_();
                            duplicate.m_41764_(1);
                            if (!this.f_25598_.m_21120_(InteractionHand.MAIN_HAND).m_41619_() && !this.f_25598_.m_9236_().f_46443_) {
                                this.f_25598_.m_5552_(this.f_25598_.m_21120_(InteractionHand.MAIN_HAND), 0.0f);
                            }
                            this.f_25598_.m_21008_(InteractionHand.MAIN_HAND, duplicate);
                            stack.m_41774_(1);
                            this.chestLooter.afterLooting(this.f_25602_);
                            this.m_8041_();
                        }
                    }
                }
            }
        }
    }

    protected boolean m_6465_(@NotNull LevelReader level, @NotNull BlockPos pos) {
        return this.isChestRaidable(level, pos);
    }

    public void toggleChest(Container container, boolean open) {
        if (container instanceof ChestBlockEntity) {
            ChestBlockEntity chest = (ChestBlockEntity)container;
            if (open) {
                this.f_25598_.m_9236_().m_7696_(this.f_25602_, chest.m_58900_().m_60734_(), 1, 1);
                this.playChestSound(this.f_25598_.m_9236_(), this.f_25602_, chest.m_58900_(), SoundEvents.f_11749_);
            } else {
                this.f_25598_.m_9236_().m_7696_(this.f_25602_, chest.m_58900_().m_60734_(), 1, 0);
                this.playChestSound(this.f_25598_.m_9236_(), this.f_25602_, chest.m_58900_(), SoundEvents.f_11747_);
            }
            this.f_25598_.m_9236_().m_46672_(this.f_25602_, chest.m_58900_().m_60734_());
            this.f_25598_.m_9236_().m_46672_(this.f_25602_.m_7495_(), chest.m_58900_().m_60734_());
        }
    }

    protected void playChestSound(Level level, BlockPos pos, BlockState state, SoundEvent soundEvent) {
        ChestType type = (ChestType)state.m_61143_((Property)ChestBlock.f_51479_);
        if (type != ChestType.LEFT) {
            double x = (double)pos.m_123341_() + 0.5;
            double y = (double)pos.m_123342_() + 0.5;
            double z = (double)pos.m_123343_() + 0.5;
            if (type == ChestType.RIGHT) {
                Direction direction = ChestBlock.m_51584_((BlockState)state);
                x += (double)direction.m_122429_() * 0.5;
                z += (double)direction.m_122431_() * 0.5;
            }
            level.m_6263_(null, x, y, z, soundEvent, SoundSource.BLOCKS, 0.5f, level.f_46441_.m_188501_() * 0.1f + 0.9f);
        }
    }
}


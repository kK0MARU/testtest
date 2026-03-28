/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.Component$Serializer
 *  net.minecraft.world.Container
 *  net.minecraft.world.Containers
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.Nameable
 *  net.minecraft.world.SimpleContainer
 *  net.minecraft.world.WorldlyContainer
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.ContainerData
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraftforge.common.capabilities.Capability
 *  net.minecraftforge.common.capabilities.ForgeCapabilities
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.items.IItemHandler
 *  net.minecraftforge.items.ItemStackHandler
 *  net.minecraftforge.items.wrapper.SidedInvWrapper
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.blocks.entity;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.blocks.TransmogrifierBlock;
import com.barlinc.unusual_prehistory.blocks.entity.SyncedBlockEntity;
import com.barlinc.unusual_prehistory.recipes.TransmogrificationRecipe;
import com.barlinc.unusual_prehistory.registry.UP2BlockEntities;
import com.barlinc.unusual_prehistory.registry.UP2Particles;
import com.barlinc.unusual_prehistory.registry.UP2Recipes;
import com.barlinc.unusual_prehistory.registry.tags.UP2ItemTags;
import com.barlinc.unusual_prehistory.screens.TransmogrifierMenu;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TransmogrifierBlockEntity
extends SyncedBlockEntity
implements MenuProvider,
WorldlyContainer,
Nameable {
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2};
    private final ItemStackHandler inventory = new ItemStackHandler(3){

        protected void onContentsChanged(int slot) {
            TransmogrifierBlockEntity.this.m_6596_();
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.of(() -> this.inventory);
    protected final ContainerData data;
    private final RecipeType<TransmogrificationRecipe> recipeType;
    private int progress;
    private int maxProgress;
    private int fuel = 0;
    private int maxFuel = 800;
    private Component customName;
    private LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create((WorldlyContainer)this, (Direction[])new Direction[]{Direction.DOWN, Direction.UP, Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST});

    public TransmogrifierBlockEntity(BlockPos pos, BlockState state) {
        super((BlockEntityType)UP2BlockEntities.TRANSMOGRIFIER.get(), pos, state);
        this.recipeType = (RecipeType)UP2Recipes.TRANSMOGRIFICATION.get();
        this.data = new ContainerData(){

            public int m_6413_(int index) {
                return switch (index) {
                    case 0 -> TransmogrifierBlockEntity.this.progress;
                    case 1 -> TransmogrifierBlockEntity.this.maxProgress;
                    case 2 -> TransmogrifierBlockEntity.this.fuel;
                    case 3 -> TransmogrifierBlockEntity.this.maxFuel;
                    default -> 0;
                };
            }

            public void m_8050_(int index, int value) {
                switch (index) {
                    case 0: {
                        TransmogrifierBlockEntity.this.progress = value;
                        break;
                    }
                    case 1: {
                        TransmogrifierBlockEntity.this.maxProgress = value;
                        break;
                    }
                    case 2: {
                        TransmogrifierBlockEntity.this.fuel = value;
                        break;
                    }
                    case 3: {
                        TransmogrifierBlockEntity.this.maxFuel = value;
                    }
                }
            }

            public int m_6499_() {
                return 4;
            }
        };
    }

    public static void tick(Level level, BlockPos pos, BlockState state, TransmogrifierBlockEntity blockEntity) {
        boolean didInventoryChange = false;
        if (!blockEntity.hasRecipe(blockEntity, level)) {
            blockEntity.progress = 0;
            if (!blockEntity.hasFuel()) {
                blockEntity.refuel();
            }
            TransmogrifierBlockEntity.m_155232_((Level)level, (BlockPos)pos, (BlockState)state);
        } else {
            int processTime;
            Container input = blockEntity.getContainer(level);
            TransmogrificationRecipe recipe = blockEntity.getRecipeFor(level, input).get();
            blockEntity.maxProgress = processTime = recipe.getProcessingTime();
            ++blockEntity.progress;
            blockEntity.depleteFuel();
            TransmogrifierBlockEntity.m_155232_((Level)level, (BlockPos)pos, (BlockState)state);
            TransmogrifierBlockEntity.spawnParticles(level, pos, state);
            if (blockEntity.progress >= processTime) {
                blockEntity.progress = 1;
                blockEntity.assembleRecipe(level, input, recipe);
                didInventoryChange = true;
            }
        }
        if (blockEntity.isTransmogrifying() && !blockEntity.m_58901_() && level.m_5776_()) {
            UnusualPrehistory2.PROXY.playWorldSound((Object)blockEntity, (byte)0);
        }
        if (!level.m_5776_()) {
            state = (BlockState)((BlockState)state.m_60734_().m_49966_().m_61124_((Property)TransmogrifierBlock.LIT, (Comparable)Boolean.valueOf(blockEntity.isTransmogrifying()))).m_61124_((Property)TransmogrifierBlock.FACING, (Comparable)((Direction)state.m_61143_((Property)TransmogrifierBlock.FACING)));
            level.m_7731_(pos, state, 3);
        }
        if (didInventoryChange) {
            blockEntity.inventoryChanged();
        }
    }

    public static void spawnParticles(Level level, BlockPos pos, BlockState state) {
        Direction direction = ((Direction)state.m_61143_((Property)TransmogrifierBlock.FACING)).m_122428_();
        Direction.Axis axis = direction.m_122434_();
        double x = (double)pos.m_123341_() + 0.5;
        double y = (double)pos.m_123342_() + 0.5;
        double z = (double)pos.m_123343_() + 0.5;
        double offset = 0.0;
        double xdirection = axis == Direction.Axis.X ? (double)direction.m_122429_() * 0.52 : offset;
        double zdirection = axis == Direction.Axis.Z ? (double)direction.m_122431_() * 0.52 : offset;
        double xoffset = 0.0;
        double zoffset = 0.0;
        if (direction == Direction.NORTH) {
            xoffset = -0.25;
        } else if (direction == Direction.SOUTH) {
            xoffset = 0.25;
        } else if (direction == Direction.EAST) {
            zoffset = -0.25;
        } else if (direction == Direction.WEST) {
            zoffset = 0.25;
        }
        double xspeed = (float)direction.m_122429_() * 0.2f;
        double zspeed = (float)direction.m_122431_() * 0.2f;
        BlockPos sidePos = pos.m_5484_(direction, 1);
        BlockState sideState = level.m_8055_(sidePos);
        if (level.f_46441_.m_188503_(10) == 0 && (sideState.m_60795_() || sideState.m_60812_((BlockGetter)level, sidePos).m_83281_())) {
            level.m_7106_((ParticleOptions)UP2Particles.OOZE_BUBBLE.get(), x + xdirection + xoffset, y - 0.2, z + zdirection + zoffset, xspeed, 0.0, zspeed);
        }
    }

    public void m_7651_() {
        UnusualPrehistory2.PROXY.clearSoundCacheFor(this);
        super.m_7651_();
    }

    protected Optional<TransmogrificationRecipe> getRecipeFor(Level level, Container input) {
        return level.m_7465_().m_44015_((RecipeType)UP2Recipes.TRANSMOGRIFICATION.get(), input, level);
    }

    private void assembleRecipe(Level level, Container input, TransmogrificationRecipe recipe) {
        ItemStack output = recipe.m_5874_(input, level.m_9598_());
        if (output.m_41619_()) {
            return;
        }
        ItemStackHandler itemHandler = this.inventory;
        itemHandler.insertItem(2, output, false);
        itemHandler.extractItem(0, 1, false);
    }

    protected boolean hasRecipe(TransmogrifierBlockEntity blockEntity, Level level) {
        Container inventory = this.getContainer(level);
        Optional<TransmogrificationRecipe> recipe = this.getRecipeFor(level, inventory);
        return recipe.isPresent() && blockEntity.hasFuel() && TransmogrifierBlockEntity.canInsertAmountIntoOutputSlot(inventory) && TransmogrifierBlockEntity.canInsertItemIntoOutputSlot(inventory, recipe.get().m_5874_(inventory, level.m_9598_()));
    }

    private static boolean canInsertItemIntoOutputSlot(Container inventory, ItemStack output) {
        return inventory.m_8020_(2).m_41720_() == output.m_41720_() || inventory.m_8020_(2).m_41619_();
    }

    private static boolean canInsertAmountIntoOutputSlot(Container inventory) {
        return inventory.m_8020_(2).m_41741_() > inventory.m_8020_(2).m_41613_() && inventory.m_8020_(3).m_41741_() > inventory.m_8020_(3).m_41613_();
    }

    private Container getContainer(Level level) {
        SimpleContainer inventory = new SimpleContainer(this.inventory.getSlots());
        for (int i = 0; i < this.inventory.getSlots(); ++i) {
            inventory.m_6836_(i, this.inventory.getStackInSlot(i));
        }
        return inventory;
    }

    private void depleteFuel() {
        --this.fuel;
        if (this.fuel <= 0) {
            this.fuel = 0;
            this.refuel();
        }
    }

    private void refuel() {
        ItemStack fuelStack = this.inventory.getStackInSlot(1);
        int fuelAmount = this.getFuelAmount(fuelStack);
        if (fuelAmount > 0) {
            this.inventory.extractItem(1, 1, false);
            this.fuel = fuelAmount;
        }
    }

    private boolean hasFuel() {
        return this.fuel > 0;
    }

    private int getFuelAmount(ItemStack fuelStack) {
        if (!fuelStack.m_41619_() && fuelStack.m_204117_(UP2ItemTags.TRANSMOGRIFIER_FUEL)) {
            return this.maxFuel;
        }
        return 0;
    }

    public void reviveCaps() {
        super.reviveCaps();
        this.handlers = SidedInvWrapper.create((WorldlyContainer)this, (Direction[])new Direction[]{Direction.DOWN, Direction.UP, Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST});
    }

    @NotNull
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction direction) {
        if (capability == ForgeCapabilities.ITEM_HANDLER) {
            if (direction == null) {
                return this.lazyItemHandler.cast();
            }
            return this.handlers[direction.ordinal()].cast();
        }
        return super.getCapability(capability, direction);
    }

    public void onLoad() {
        super.onLoad();
        this.lazyItemHandler = LazyOptional.of(() -> this.inventory);
    }

    public void invalidateCaps() {
        super.invalidateCaps();
        this.lazyItemHandler.invalidate();
    }

    public void getDrops() {
        SimpleContainer inventory = new SimpleContainer(this.inventory.getSlots());
        for (int i = 0; i < this.inventory.getSlots(); ++i) {
            inventory.m_6836_(i, this.inventory.getStackInSlot(i));
        }
        Containers.m_19002_((Level)this.f_58857_, (BlockPos)this.f_58858_, (Container)inventory);
    }

    public boolean canRemoveItem(int slot) {
        return slot == 2;
    }

    @NotNull
    public Component m_7755_() {
        return this.customName != null ? this.customName : Component.m_237115_((String)"block.unusual_prehistory.transmogrifier");
    }

    @NotNull
    public Component m_5446_() {
        return this.m_7755_();
    }

    @Nullable
    public Component m_7770_() {
        return this.customName;
    }

    public void setCustomName(Component name) {
        this.customName = name;
    }

    @Nullable
    public AbstractContainerMenu m_7208_(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new TransmogrifierMenu(id, inventory, this, this.data);
    }

    protected void m_183515_(@NotNull CompoundTag compoundTag) {
        super.m_183515_(compoundTag);
        compoundTag.m_128365_("Inventory", (Tag)this.inventory.serializeNBT());
        compoundTag.m_128405_("Progress", this.progress);
        if (this.customName != null) {
            compoundTag.m_128359_("CustomName", Component.Serializer.m_130703_((Component)this.customName));
        }
    }

    public void m_142466_(@NotNull CompoundTag compoundTag) {
        super.m_142466_(compoundTag);
        this.inventory.deserializeNBT(compoundTag.m_128469_("Inventory"));
        this.progress = compoundTag.m_128451_("Progress");
        if (compoundTag.m_128425_("CustomName", 8)) {
            this.customName = Component.Serializer.m_130701_((String)compoundTag.m_128461_("CustomName"));
        }
    }

    public int @NotNull [] m_7071_(@NotNull Direction direction) {
        if (direction == Direction.UP) {
            return SLOTS_FOR_UP;
        }
        return direction == Direction.DOWN ? SLOTS_FOR_DOWN : SLOTS_FOR_SIDES;
    }

    public boolean m_7155_(int index, @NotNull ItemStack itemStack, @Nullable Direction direction) {
        return true;
    }

    public boolean m_7157_(int i, @NotNull ItemStack itemStack, @NotNull Direction direction) {
        return true;
    }

    public int m_6643_() {
        return this.inventory.getSlots();
    }

    public boolean m_7983_() {
        for (int i = 0; i < this.inventory.getSlots(); ++i) {
            if (this.inventory.getStackInSlot(i).m_41619_()) continue;
            return false;
        }
        return true;
    }

    @NotNull
    public ItemStack m_8020_(int slot) {
        return this.inventory.getStackInSlot(slot);
    }

    @NotNull
    public ItemStack m_7407_(int slot, int amount) {
        if (this.canRemoveItem(slot)) {
            return this.inventory.extractItem(slot, amount, false);
        }
        return ItemStack.f_41583_;
    }

    @NotNull
    public ItemStack m_8016_(int slot) {
        if (this.canRemoveItem(slot)) {
            return this.inventory.extractItem(slot, 0, false);
        }
        return ItemStack.f_41583_;
    }

    public void m_6836_(int slot, @NotNull ItemStack stack) {
        if (this.canTakeItem(slot, stack)) {
            this.inventory.setStackInSlot(slot, stack);
        }
    }

    public boolean canTakeItem(int slot, ItemStack stack) {
        return (slot == 0 || slot == 1) && this.inventory.isItemValid(slot, stack);
    }

    public boolean m_6542_(@NotNull Player player) {
        return Container.m_272074_((BlockEntity)this, (Player)player);
    }

    public void m_6211_() {
        this.inventory.setSize(3);
    }

    public boolean isTransmogrifying() {
        return this.progress > 0;
    }
}


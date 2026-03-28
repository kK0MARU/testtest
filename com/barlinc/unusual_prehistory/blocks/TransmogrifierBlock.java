/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraftforge.network.NetworkHooks
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.blocks;

import com.barlinc.unusual_prehistory.blocks.entity.TransmogrifierBlockEntity;
import com.barlinc.unusual_prehistory.registry.UP2BlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TransmogrifierBlock
extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.f_61374_;
    public static final BooleanProperty LIT = BlockStateProperties.f_61443_;

    public TransmogrifierBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)FACING, (Comparable)Direction.NORTH)).m_61124_((Property)LIT, (Comparable)Boolean.valueOf(false)));
    }

    @NotNull
    public RenderShape m_7514_(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    public void m_6810_(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState blockState, boolean isMoving) {
        BlockEntity blockEntity;
        if (state.m_60734_() != blockState.m_60734_() && (blockEntity = level.m_7702_(pos)) instanceof TransmogrifierBlockEntity) {
            ((TransmogrifierBlockEntity)blockEntity).getDrops();
        }
        super.m_6810_(state, level, pos, blockState, isMoving);
    }

    @NotNull
    public InteractionResult m_6227_(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.m_5776_()) {
            BlockEntity entity = level.m_7702_(pos);
            if (entity instanceof TransmogrifierBlockEntity) {
                NetworkHooks.openScreen((ServerPlayer)((ServerPlayer)player), (MenuProvider)((TransmogrifierBlockEntity)entity), (BlockPos)pos);
            } else {
                throw new IllegalStateException("Transmogrifier container provider is missing!");
            }
        }
        return InteractionResult.m_19078_((boolean)level.m_5776_());
    }

    @Nullable
    public BlockEntity m_142194_(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new TransmogrifierBlockEntity(pos, state);
    }

    public BlockState m_5573_(BlockPlaceContext context) {
        return (BlockState)this.m_49966_().m_61124_((Property)FACING, (Comparable)context.m_8125_().m_122424_());
    }

    public void m_6402_(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, LivingEntity entity, ItemStack stack) {
        BlockEntity blockentity;
        if (stack.m_41788_() && (blockentity = level.m_7702_(pos)) instanceof TransmogrifierBlockEntity) {
            ((TransmogrifierBlockEntity)blockentity).setCustomName(stack.m_41786_());
        }
    }

    @NotNull
    public ItemStack m_7397_(@NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull BlockState state) {
        ItemStack stack = super.m_7397_(level, pos, state);
        TransmogrifierBlockEntity transmogrifierBlockEntity = (TransmogrifierBlockEntity)level.m_7702_(pos);
        if (transmogrifierBlockEntity != null && transmogrifierBlockEntity.m_8077_()) {
            stack.m_41714_(transmogrifierBlockEntity.m_7770_());
        }
        return stack;
    }

    @NotNull
    public BlockState m_6843_(BlockState state, Rotation rotation) {
        return (BlockState)state.m_61124_((Property)FACING, (Comparable)rotation.m_55954_((Direction)state.m_61143_((Property)FACING)));
    }

    @NotNull
    public BlockState m_6943_(BlockState state, Mirror mirror) {
        return state.m_60717_(mirror.m_54846_((Direction)state.m_61143_((Property)FACING)));
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.m_61104_(new Property[]{FACING, LIT});
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType) {
        return TransmogrifierBlock.m_152132_(blockEntityType, (BlockEntityType)((BlockEntityType)UP2BlockEntities.TRANSMOGRIFIER.get()), TransmogrifierBlockEntity::tick);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockSetType
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.level.block.state.properties.WoodType
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.material.PushReaction
 */
package com.barlinc.unusual_prehistory.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class UP2BlockProperties {
    public static final WoodType DRYOPHYLLUM_WOOD_TYPE = WoodType.m_61844_((WoodType)new WoodType("unusual_prehistory:dryophyllum", BlockSetType.f_271198_));
    public static final WoodType GINKGO_WOOD_TYPE = WoodType.m_61844_((WoodType)new WoodType("unusual_prehistory:ginkgo", BlockSetType.f_271198_));
    public static final WoodType LEPIDODENDRON_WOOD_TYPE = WoodType.m_61844_((WoodType)new WoodType("unusual_prehistory:lepidodendron", BlockSetType.f_271198_));
    public static final WoodType METASEQUOIA_WOOD_TYPE = WoodType.m_61844_((WoodType)new WoodType("unusual_prehistory:metasequoia", BlockSetType.f_271198_));
    public static final BlockBehaviour.Properties PLANT = BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283824_).m_60910_().m_60966_().m_60918_(SoundType.f_56740_).m_222979_(BlockBehaviour.OffsetType.XZ).m_278166_(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties TALL_PLANT = BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283824_).m_60910_().m_60966_().m_278183_().m_60918_(SoundType.f_56740_).m_222979_(BlockBehaviour.OffsetType.XZ).m_278166_(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties EGG = BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283919_).m_60978_(0.5f).m_60918_(SoundType.f_56743_).m_60955_();
    public static final BlockBehaviour.Properties WATER_EGG = BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283919_).m_60966_().m_60955_().m_60910_().m_60918_(SoundType.f_222466_);
    public static final BlockBehaviour.Properties SQUISHY_EGG = BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283919_).m_60978_(0.6f).m_60918_(SoundType.f_56753_).m_60955_();
    public static final BlockBehaviour.Properties FOSSIL_BLOCK = BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283761_).m_280658_(NoteBlockInstrument.XYLOPHONE).m_60999_().m_60978_(2.0f).m_60918_(SoundType.f_56724_);
    public static final BlockBehaviour.Properties TAR = BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283927_).m_60978_(100.0f).m_60910_().m_60918_(SoundType.f_222469_).m_60991_((state, world, pos) -> false).m_222994_().m_280170_().m_278788_().m_278166_(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties CAULDRON = BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283947_).m_60999_().m_60978_(2.0f).m_60955_();
    public static final BlockBehaviour.Properties FOSSIL_STONE = BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283947_).m_280658_(NoteBlockInstrument.BASS).m_60999_().m_60913_(1.5f, 6.0f).m_60918_(SoundType.f_154661_);

    public static BlockBehaviour.Properties reinforcedGlass(MapColor color) {
        return BlockBehaviour.Properties.m_284310_().m_280658_(NoteBlockInstrument.HAT).m_284180_(color).m_60913_(0.4f, 6.0f).m_60918_(SoundType.f_56744_).m_60955_().m_60922_(UP2BlockProperties::never).m_60924_(UP2BlockProperties::never).m_60960_(UP2BlockProperties::never).m_60971_(UP2BlockProperties::never);
    }

    public static BlockBehaviour.Properties fossilLantern(int lightLevel) {
        return BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283761_).m_280658_(NoteBlockInstrument.XYLOPHONE).m_60999_().m_60978_(2.0f).m_60918_(SoundType.f_56724_).m_60953_(state -> lightLevel);
    }

    public static BlockBehaviour.Properties leaves(MapColor color, SoundType sound) {
        return BlockBehaviour.Properties.m_284310_().m_284180_(color).m_60978_(0.2f).m_60977_().m_60918_(sound).m_60955_().m_60922_(UP2BlockProperties::ocelotOrParrot).m_60960_(UP2BlockProperties::never).m_60971_(UP2BlockProperties::never).m_278183_().m_278166_(PushReaction.DESTROY).m_60924_(UP2BlockProperties::never);
    }

    public static BlockBehaviour.Properties sapling(MapColor color, SoundType sound) {
        return BlockBehaviour.Properties.m_284310_().m_284180_(color).m_60910_().m_60977_().m_60966_().m_60918_(sound).m_278166_(PushReaction.DESTROY);
    }

    public static BlockBehaviour.Properties log(MapColor color, SoundType sound, NoteBlockInstrument instrument) {
        return BlockBehaviour.Properties.m_284310_().m_284180_(color).m_60913_(2.0f, 3.0f).m_60918_(sound).m_280658_(instrument).m_278183_();
    }

    public static BlockBehaviour.Properties plank(MapColor color, SoundType sound, NoteBlockInstrument instrument) {
        return BlockBehaviour.Properties.m_284310_().m_284180_(color).m_60913_(2.0f, 3.0f).m_60918_(sound).m_280658_(instrument).m_278183_();
    }

    public static BlockBehaviour.Properties woodenPressurePlate(MapColor color, SoundType sound, NoteBlockInstrument instrument) {
        return BlockBehaviour.Properties.m_284310_().m_284180_(color).m_60978_(0.5f).m_60918_(sound).m_280658_(instrument).m_60910_().m_280606_().m_278166_(PushReaction.DESTROY).m_278183_();
    }

    public static BlockBehaviour.Properties woodenButton(SoundType sound, NoteBlockInstrument instrument) {
        return BlockBehaviour.Properties.m_284310_().m_60978_(0.5f).m_60918_(sound).m_280658_(instrument).m_60910_().m_278166_(PushReaction.DESTROY);
    }

    public static BlockBehaviour.Properties woodenDoor(MapColor color, SoundType sound, NoteBlockInstrument instrument) {
        return BlockBehaviour.Properties.m_284310_().m_284180_(color).m_60978_(3.0f).m_60918_(sound).m_280658_(instrument).m_278166_(PushReaction.DESTROY).m_60955_();
    }

    public static BlockBehaviour.Properties woodenTrapdoor(MapColor color, SoundType sound, NoteBlockInstrument instrument) {
        return BlockBehaviour.Properties.m_284310_().m_284180_(color).m_60978_(3.0f).m_60918_(sound).m_280658_(instrument).m_60955_().m_60922_(UP2BlockProperties::never);
    }

    public static BlockBehaviour.Properties coral(MapColor color) {
        return BlockBehaviour.Properties.m_284310_().m_284180_(color).m_60910_().m_60966_().m_60918_(SoundType.f_56752_).m_278166_(PushReaction.DESTROY);
    }

    public static BlockBehaviour.Properties coralBlock(MapColor color) {
        return BlockBehaviour.Properties.m_284310_().m_284180_(color).m_60999_().m_60913_(1.5f, 6.0f).m_60918_(SoundType.f_56753_);
    }

    public static boolean ocelotOrParrot(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.f_20505_ || entity == EntityType.f_20508_;
    }

    public static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }

    public static boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entity) {
        return false;
    }
}


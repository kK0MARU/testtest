/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.barlinc.unusual_prehistory.utils;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class UP2Math {
    public static Vec3 getGroundBelowPosition(BlockGetter level, Vec3 in) {
        float top;
        BlockPos pos = BlockPos.m_274446_((Position)in);
        while (pos.m_123342_() > level.m_141937_() && level.m_8055_(pos).m_60812_(level, pos).m_83281_()) {
            pos = pos.m_7495_();
        }
        BlockState state = level.m_8055_(pos);
        VoxelShape shape = state.m_60812_(level, pos);
        if (shape.m_83281_()) {
            top = 0.0f;
        } else {
            Vec3 modIn = new Vec3(in.f_82479_ % 1.0, 1.0, in.f_82481_ % 1.0);
            Optional closest = shape.m_166067_(modIn);
            top = closest.map(vec3 -> Float.valueOf((float)vec3.f_82480_)).orElse(Float.valueOf(0.0f)).floatValue();
        }
        return Vec3.m_82514_((Vec3i)pos, (double)top);
    }
}


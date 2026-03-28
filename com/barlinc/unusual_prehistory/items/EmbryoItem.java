/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 */
package com.barlinc.unusual_prehistory.items;

import java.util.function.Supplier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class EmbryoItem
extends Item {
    public final Supplier<? extends EntityType<?>> toSpawn;

    public EmbryoItem(Item.Properties properties, Supplier<? extends EntityType<?>> toSpawn) {
        super(properties);
        this.toSpawn = toSpawn;
    }
}


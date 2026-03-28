/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.client.model.BoatModel
 *  net.minecraft.client.model.ListModel
 *  net.minecraft.client.model.geom.ModelLayerLocation
 *  net.minecraft.client.renderer.entity.BoatRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.vehicle.Boat
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.client.renderer.entity;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.misc.UP2Boat;
import com.barlinc.unusual_prehistory.entity.utils.UP2BoatType;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import java.util.Map;
import java.util.stream.Stream;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

public class UP2BoatRenderer
extends BoatRenderer {
    private final Map<UP2BoatType.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources = (Map)Stream.of(UP2BoatType.Type.values()).collect(ImmutableMap.toImmutableMap(boatType -> boatType, boatType -> Pair.of((Object)UnusualPrehistory2.modPrefix("textures/entity/boat/" + boatType.getName() + ".png"), (Object)new BoatModel(renderContext.m_174023_(new ModelLayerLocation(new ResourceLocation("boat/oak"), "main"))))));

    public UP2BoatRenderer(EntityRendererProvider.Context renderContext, boolean isChestBoat) {
        super(renderContext, isChestBoat);
    }

    public UP2BoatRenderer(EntityRendererProvider.Context renderContext) {
        this(renderContext, false);
    }

    @NotNull
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(@NotNull Boat boat) {
        UP2Boat up2Boat = (UP2Boat)boat;
        return this.boatResources.get((Object)up2Boat.getUP2BoatType());
    }
}


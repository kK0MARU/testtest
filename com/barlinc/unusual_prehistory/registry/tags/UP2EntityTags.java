/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.entity.EntityType
 */
package com.barlinc.unusual_prehistory.registry.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class UP2EntityTags {
    public static final TagKey<EntityType<?>> CARNOTAURUS_TARGETS = UP2EntityTags.modEntityTag("carnotaurus_targets");
    public static final TagKey<EntityType<?>> DROMAEOSAURUS_TARGETS = UP2EntityTags.modEntityTag("dromaeosaurus_targets");
    public static final TagKey<EntityType<?>> SMALL_DUNKLEOSTEUS_TARGETS = UP2EntityTags.modEntityTag("small_dunkleosteus_targets");
    public static final TagKey<EntityType<?>> MEDIUM_DUNKLEOSTEUS_TARGETS = UP2EntityTags.modEntityTag("medium_dunkleosteus_targets");
    public static final TagKey<EntityType<?>> BIG_DUNKLEOSTEUS_TARGETS = UP2EntityTags.modEntityTag("big_dunkleosteus_targets");
    public static final TagKey<EntityType<?>> MAJUNGASAURUS_TARGETS = UP2EntityTags.modEntityTag("majungasaurus_targets");
    public static final TagKey<EntityType<?>> MEGALANIA_TARGETS = UP2EntityTags.modEntityTag("megalania_targets");
    public static final TagKey<EntityType<?>> STETHACANTHUS_TARGETS = UP2EntityTags.modEntityTag("stethacanthus_targets");
    public static final TagKey<EntityType<?>> DIPLOCAULUS_AVOIDS = UP2EntityTags.modEntityTag("diplocaulus_avoids");
    public static final TagKey<EntityType<?>> DROMAEOSAURUS_AVOIDS = UP2EntityTags.modEntityTag("dromaeosaurus_avoids");
    public static final TagKey<EntityType<?>> JAWLESS_FISH_AVOIDS = UP2EntityTags.modEntityTag("jawless_fish_avoids");
    public static final TagKey<EntityType<?>> KIMMERIDGEBRACHYPTERAESCHNIDIUM_AVOIDS = UP2EntityTags.modEntityTag("kimmeridgebrachypteraeschnidium_avoids");
    public static final TagKey<EntityType<?>> KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_AVOIDS = UP2EntityTags.modEntityTag("kimmeridgebrachypteraeschnidium_nymph_avoids");
    public static final TagKey<EntityType<?>> MAJUNGASAURUS_AVOIDS = UP2EntityTags.modEntityTag("majungasaurus_avoids");
    public static final TagKey<EntityType<?>> STETHACANTHUS_AVOIDS = UP2EntityTags.modEntityTag("stethacanthus_avoids");
    public static final TagKey<EntityType<?>> TALPANAS_AVOIDS = UP2EntityTags.modEntityTag("talpanas_avoids");
    public static final TagKey<EntityType<?>> TELECREX_AVOIDS = UP2EntityTags.modEntityTag("telecrex_avoids");
    public static final TagKey<EntityType<?>> CARNOTAURUS_IGNORES = UP2EntityTags.modEntityTag("carnotaurus_ignores");
    public static final TagKey<EntityType<?>> SWEET_BERRY_BUSH_IMMUNE = UP2EntityTags.modEntityTag("sweet_berry_bush_immune");
    public static final TagKey<EntityType<?>> METRIORHYNCHUS_TARGETS = UP2EntityTags.modEntityTag("metriorhynchus_targets");
    public static final TagKey<EntityType<?>> TARTUOSTEUS_AVOIDS = UP2EntityTags.modEntityTag("tartuosteus_avoids");
    public static final TagKey<EntityType<?>> METRIORHYNCHUS_CANT_GRAB = UP2EntityTags.modEntityTag("metriorhynchus_cant_grab");
    public static final TagKey<EntityType<?>> METRIORHYNCHUS_CAN_GRAB = UP2EntityTags.modEntityTag("metriorhynchus_can_grab");
    public static final TagKey<EntityType<?>> KAPROSUCHUS_TARGETS = UP2EntityTags.modEntityTag("kaprosuchus_targets");
    public static final TagKey<EntityType<?>> PACHYCEPHALOSAURUS_TARGETS = UP2EntityTags.modEntityTag("pachycephalosaurus_targets");
    public static final TagKey<EntityType<?>> PACHYCEPHALOSAURUS_TARGETS_TO_KILL = UP2EntityTags.modEntityTag("pachycephalosaurus_targets_to_kill");
    public static final TagKey<EntityType<?>> PRAEPUSA_TARGETS = UP2EntityTags.modEntityTag("praepusa_targets");
    public static final TagKey<EntityType<?>> ULUGHBEGSAURUS_TARGETS = UP2EntityTags.modEntityTag("ulughbegsaurus_targets");
    public static final TagKey<EntityType<?>> COELACANTHUS_AVOIDS = UP2EntityTags.modEntityTag("coelacanthus_avoids");
    public static final TagKey<EntityType<?>> LEPTICTIDIUM_AVOIDS = UP2EntityTags.modEntityTag("leptictidium_avoids");
    public static final TagKey<EntityType<?>> PRAEPUSA_AVOIDS = UP2EntityTags.modEntityTag("praepusa_avoids");
    public static final TagKey<EntityType<?>> LEPTICTIDIUM_DOESNT_TARGET = UP2EntityTags.modEntityTag("leptictidium_doesnt_target");
    public static final TagKey<EntityType<?>> COELACANTHUS_NEVER_EATS = UP2EntityTags.modEntityTag("coelacanthus_never_eats");
    public static final TagKey<EntityType<?>> COELACANTHUS_ALWAYS_EATS = UP2EntityTags.modEntityTag("coelacanthus_always_eats");
    public static final TagKey<EntityType<?>> SMALL_PSILOPTERUS_PACK_TARGETS = UP2EntityTags.modEntityTag("small_psilopterus_pack_targets");
    public static final TagKey<EntityType<?>> MEDIUM_PSILOPTERUS_PACK_TARGETS = UP2EntityTags.modEntityTag("medium_psilopterus_pack_targets");
    public static final TagKey<EntityType<?>> LARGE_PSILOPTERUS_PACK_TARGETS = UP2EntityTags.modEntityTag("large_psilopterus_pack_targets");
    public static final TagKey<EntityType<?>> DIMORPHODON_AVOIDS = UP2EntityTags.modEntityTag("dimorphodon_avoids");
    public static final TagKey<EntityType<?>> DIMORPHODON_CANT_GRAB = UP2EntityTags.modEntityTag("dimorphodon_cant_grab");
    public static final TagKey<EntityType<?>> DIMORPHODON_CAN_GRAB = UP2EntityTags.modEntityTag("dimorphodon_can_grab");

    private static TagKey<EntityType<?>> modEntityTag(String name) {
        return UP2EntityTags.entityTag("unusual_prehistory", name);
    }

    private static TagKey<EntityType<?>> forgeEntityTag(String name) {
        return UP2EntityTags.entityTag("forge", name);
    }

    public static TagKey<EntityType<?>> entityTag(String modid, String name) {
        return TagKey.m_203882_((ResourceKey)Registries.f_256939_, (ResourceLocation)new ResourceLocation(modid, name));
    }
}


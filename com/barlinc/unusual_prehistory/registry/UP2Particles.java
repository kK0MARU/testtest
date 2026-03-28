/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleType
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import java.util.function.Supplier;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid="unusual_prehistory")
public class UP2Particles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create((IForgeRegistry)ForgeRegistries.PARTICLE_TYPES, (String)"unusual_prehistory");
    public static final RegistryObject<SimpleParticleType> GINKGO_LEAVES = UP2Particles.registerParticle("ginkgo_leaves", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> GOLDEN_GINKGO_LEAVES = UP2Particles.registerParticle("golden_ginkgo_leaves", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> EEPY = UP2Particles.registerParticle("eepy", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> OOZE_BUBBLE = UP2Particles.registerParticle("ooze_bubble", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> TAR_BUBBLE = UP2Particles.registerParticle("tar_bubble", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> GOLDEN_HEART = UP2Particles.registerParticle("golden_heart", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SNOWFLAKE = UP2Particles.registerParticle("snowflake", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> IMPACT_STUN = UP2Particles.registerParticle("impact_stun", () -> new SimpleParticleType(false));

    private static <P extends ParticleType<?>> RegistryObject<P> registerParticle(String name, Supplier<P> particle) {
        return PARTICLE_TYPES.register(name, particle);
    }
}


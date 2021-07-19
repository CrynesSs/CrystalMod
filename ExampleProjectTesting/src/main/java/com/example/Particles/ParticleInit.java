package com.example.Particles;

import com.example.examplemod.ExampleMod;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleInit {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ExampleMod.MOD_ID);
    public static final RegistryObject<ParticleType<BasicParticleType>> EXAMPLE_PARTICLE_TYPE = PARTICLE_TYPES.register("example",
            ()->  new BasicParticleType(true));
}

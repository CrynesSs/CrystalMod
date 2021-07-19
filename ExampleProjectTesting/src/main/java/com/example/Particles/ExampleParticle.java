package com.example.Particles;

import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;

import javax.annotation.Nonnull;

public class ExampleParticle extends SpriteTexturedParticle {
    protected ExampleParticle(ClientWorld world, double p_i232447_2_, double p_i232447_4_, double p_i232447_6_) {
        super(world, p_i232447_2_, p_i232447_4_, p_i232447_6_);
    }

    protected ExampleParticle(ClientWorld world, double xPos, double yPos, double zPos, double xSpeed, double ySpeed, double zSpeed) {
        super(world, xPos, yPos, zPos, xSpeed, ySpeed, zSpeed);
    }

    @Override
    @Nonnull
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }
}

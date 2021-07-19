package com.example.Initrs;

import com.example.Fluids.CustomFlowing;
import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {
    public static final ResourceLocation MOLTEN_METAL_STILL_RL = new ResourceLocation(ExampleMod.MOD_ID, "blocks/molten_metal_still");
    public static final ResourceLocation MOLTEN_METAL_FLOWING_RL = new ResourceLocation(ExampleMod.MOD_ID, "blocks/molten_metal_flowing");
    public static final ResourceLocation MOLTEN_METAL_OVERLAY_RL = new ResourceLocation(ExampleMod.MOD_ID, "blocks/molten_metal_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ExampleMod.MOD_ID);
    //*Fluids
    public static final RegistryObject<FlowingFluid> MOLTEN_METAL_SOURCE = FLUIDS.register("molten_metal_source", () -> new ForgeFlowingFluid.Source(FluidInit.MOLTEN_METAL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> MOLTEN_METAL_FLOWING = FLUIDS.register("molten_metal_flowing", () -> new ForgeFlowingFluid.Flowing(FluidInit.MOLTEN_METAL_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_METAL_PROPERTIES =  new ForgeFlowingFluid.Properties(MOLTEN_METAL_SOURCE, MOLTEN_METAL_FLOWING,
            FluidAttributes.builder(MOLTEN_METAL_STILL_RL, MOLTEN_METAL_FLOWING_RL)
                    .luminosity(10).rarity(Rarity.RARE).sound(SoundEvents.LAVA_AMBIENT).overlay(MOLTEN_METAL_OVERLAY_RL));
    public static final Block.Properties MOLTEN_METAL_PROPS = Block.Properties.of(Material.LAVA).speedFactor(0.2f).jumpFactor(0.4f).noDrops().noCollission().strength(100.0f).lightLevel((blockState)->6);
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_METAL_BLOCK = BlockInit.BLOCKS.register("molten_metal",
            () -> new FlowingFluidBlock(() -> FluidInit.MOLTEN_METAL_SOURCE.get(),
                    MOLTEN_METAL_PROPS));
}

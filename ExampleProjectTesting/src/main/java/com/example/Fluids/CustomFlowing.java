package com.example.Fluids;

import net.minecraftforge.fluids.ForgeFlowingFluid;

public class CustomFlowing extends ForgeFlowingFluid.Flowing {
    public CustomFlowing(Properties properties, int sourceHeight) {
        super(properties);
        this.registerDefaultState(defaultFluidState().setValue(LEVEL, sourceHeight - 1));
    }
}

package com.crylol.morevillagers.ASMTut;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;

public class AnimatedBlock extends Block {
    public AnimatedBlock() {
        super(AbstractBlock.Properties.of(Material.METAL).noOcclusion());
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(net.minecraftforge.common.property.Properties.StaticProperty);
    }

    @Override
    public BlockState getStateAtViewpoint(BlockState state, IBlockReader world, BlockPos pos, Vector3d viewpoint) {
        return defaultBlockState().setValue(net.minecraftforge.common.property.Properties.StaticProperty,true);
    }
}

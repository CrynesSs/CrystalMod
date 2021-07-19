package com.crylol.morevillagers.init;


import com.crylol.morevillagers.MoreVillagers;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreVillagers.MOD_ID);

    public static final RegistryObject<Block> OCEANOGRAPHY_TABLE = BLOCKS.register("oceanography_table",
            () -> new Block(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> TEST = BLOCKS.register("test",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL)));
}

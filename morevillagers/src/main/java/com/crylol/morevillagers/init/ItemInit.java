package com.crylol.morevillagers.init;

import com.crylol.morevillagers.MoreVillagers;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreVillagers.MOD_ID);

    // Block Items
    public static final RegistryObject<BlockItem> OCEANOGRAPHY_TABLE = ITEMS.register("oceanography_table",
            () -> new BlockItem(BlockInit.OCEANOGRAPHY_TABLE.get(), new Item.Properties().tab(MoreVillagers.GROUP)));

}

package com.crylol.morevillagers;

import com.crylol.morevillagers.init.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

@Mod(MoreVillagers.MOD_ID)
public class MoreVillagers {
    private static final Logger LOGGER = LogManager.getLogger();
    // MOD ID
    public static final String MOD_ID = "testmod";
    // CREATE CREATIVE TAB
    public static final ItemGroup GROUP = new ItemGroup(MoreVillagers.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.EMERALD);
        }
    };

    public MoreVillagers() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        EntityTypeInit.ENTITY_TYPES.register(bus);
        TileEntityTypeInit.TILE_ENTITY_TYPES.register(bus);
        VillagerInit.VILLAGER_PROFESSIONS.register(bus);
        VillagerInit.POINT_OF_INTEREST_TYPES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }
    //*This is a new Itemgroup to display all the Items that are associated with this Mod
    //*It needs to be mentioned in the en_us.json
    public static final ItemGroup TAB = new ItemGroup("RedstoneEnhancements") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.OCEANOGRAPHY_TABLE.get());
        }
    };
}

package com.crylol.morevillagers.init;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.crylol.morevillagers.MoreVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.InvocationTargetException;

public class VillagerInit {
    // REGISTER WORKSTATIONS AND PROFESSIONS
    public static final DeferredRegister<PointOfInterestType> POINT_OF_INTEREST_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, MoreVillagers.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, MoreVillagers.MOD_ID);

    // OCEANOGRAPHER ATTRIBUTES
    public static final RegistryObject<PointOfInterestType> OCEANOGRAPHER_POI = POINT_OF_INTEREST_TYPES.register("oceanographer",
            () -> new PointOfInterestType("oceanographer", PointOfInterestType.getBlockStates(BlockInit.OCEANOGRAPHY_TABLE.get()), 1, 1));
    public static final RegistryObject<VillagerProfession> OCEANOGRAPHER = VILLAGER_PROFESSIONS.register("oceanographer",
            () -> new VillagerProfession("oceanographer", OCEANOGRAPHER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));

    public static void registerPOI() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null, OCEANOGRAPHER_POI.get());
        } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    // OCEANOGRAPHER TRADES

    public static void fillTradeData() {
        VillagerTrades.ITrade[] level1 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.PRISMARINE, 18, 16, 2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.SEA_LANTERN, 1, 6, 16, 1)
        };
        VillagerTrades.ITrade[] level2 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.PRISMARINE_BRICKS, 18, 16, 10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.SPONGE, 1, 4, 16, 5)
        };
        VillagerTrades.ITrade[] level3 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.DARK_PRISMARINE, 16, 16, 20),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.SPONGE, 1, 4, 16, 10)
        };
        VillagerTrades.ITrade[] level4 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(Items.NAUTILUS_SHELL, 3, 1, 12, 15),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.HEART_OF_THE_SEA, 6, 1, 3, 15),
        };
        VillagerTrades.ITrade[] level5 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(Items.TRIDENT, 32, 1, 3, 30)
        };
        VillagerTrades.TRADES.put(OCEANOGRAPHER.get(), toIntMap(ImmutableMap.of(1, level1, 2, level2, 3, level3, 4, level4, 5, level5)));
    }

    private static Int2ObjectMap<VillagerTrades.ITrade[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ITrade[]> p_221238_0_) {
        return new Int2ObjectOpenHashMap<>(p_221238_0_);
    }
}
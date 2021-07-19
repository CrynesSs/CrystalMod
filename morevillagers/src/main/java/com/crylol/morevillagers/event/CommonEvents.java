package com.crylol.morevillagers.event;

import com.crylol.morevillagers.EntityTest.TestEntity;
import com.crylol.morevillagers.MoreVillagers;
import com.crylol.morevillagers.Networking.Networking;
import com.crylol.morevillagers.init.EntityTypeInit;
import com.crylol.morevillagers.init.VillagerInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = MoreVillagers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            VillagerInit.registerPOI();
            VillagerInit.fillTradeData();
            Networking.registerMessages();
        });
    }

    @SubscribeEvent
    public static void setupAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityTypeInit.TEST_ENTITY_TYPE.get(), TestEntity.createAttributes().build());
    }
}

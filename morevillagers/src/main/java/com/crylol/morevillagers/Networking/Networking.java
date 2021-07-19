package com.crylol.morevillagers.Networking;

import com.crylol.morevillagers.MoreVillagers;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Networking {
    private static SimpleChannel INSTANCE;
    private static int ID = 0;

    private static int nextID() {
        return ID++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(MoreVillagers.MOD_ID + "networking"),
                () -> "1.0", s -> true, s -> true);
        INSTANCE.messageBuilder(ChangeAnimStatePackage.class, nextID())
                .encoder(ChangeAnimStatePackage::toBytes)
                .decoder(ChangeAnimStatePackage::new)
                .consumer(ChangeAnimStatePackage::handle)
                .add();

    }

    public static void sendToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }

    public static void sendToClient(Object packet, ServerPlayerEntity player) {
        INSTANCE.sendTo(packet, player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
    }
}

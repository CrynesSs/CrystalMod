package com.crylol.morevillagers.Networking;


import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ChangeAnimStatePackage {
    private final int changeTo;
    private final BlockPos pos;

    public ChangeAnimStatePackage(PacketBuffer buf) {
        this.changeTo = buf.readInt();
        this.pos = buf.readBlockPos();
    }

    public ChangeAnimStatePackage(int changeTo, BlockPos pos) {
        this.pos = pos;
        this.changeTo = changeTo;
    }

    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
    //    ctx.get().enqueueWork(() -> ((TestTE) Objects.requireNonNull(Objects.requireNonNull(ctx.get().getSender()).level.getBlockEntity(pos))).switchAnimationClient(changeTo));
        return true;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeInt(changeTo);
        buf.writeBlockPos(pos);
    }
}

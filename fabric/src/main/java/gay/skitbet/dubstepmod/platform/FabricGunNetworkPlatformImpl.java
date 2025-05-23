package gay.skitbet.dubstepmod.platform;

import gay.skitbet.dubstepmod.utils.ModPackets;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import org.joml.Vector3f;

public class FabricGunNetworkPlatformImpl implements GunNetworkPlatform{

    @Override
    public void startDubstep(ServerPlayerEntity sender, Vector3f position) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeVector3f(sender.getPos().toVector3f());

        for (ServerPlayerEntity player : PlayerLookup.tracking(sender)) {
            ServerPlayNetworking.send(player, ModPackets.DUBSTEP_START, buf);
        }
        ServerPlayNetworking.send(sender, ModPackets.DUBSTEP_START, buf);
    }

    @Override
    public void stopDubstep(ServerPlayerEntity sender) {
        for (ServerPlayerEntity player : PlayerLookup.tracking(sender)) {
            ServerPlayNetworking.send(player, ModPackets.DUBSTEP_STOP, PacketByteBufs.empty());
        }
        ServerPlayNetworking.send(sender, ModPackets.DUBSTEP_STOP, PacketByteBufs.empty());
    }

}

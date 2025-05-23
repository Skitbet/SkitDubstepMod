package gay.skitbet.dubstepmod.platform;

import gay.skitbet.dubstepmod.SkitDubstepMod;
import gay.skitbet.dubstepmod.utils.ModPackets;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.CustomPayloadS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.joml.Vector3f;

public class ForgeGunNetworkPlatformImpl implements GunNetworkPlatform {

    @Override
    public void startDubstep(ServerPlayerEntity serverPlayerEntity, Vector3f position) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeFloat(position.x);
        buf.writeFloat(position.y);
        buf.writeFloat(position.z);

        CustomPayloadS2CPacket packet = new CustomPayloadS2CPacket(ModPackets.DUBSTEP_START, buf);

        ((ServerWorld) serverPlayerEntity.getWorld()).getPlayers()
                .forEach(player ->  player.networkHandler.sendPacket(packet));
    }

    @Override
    public void stopDubstep(ServerPlayerEntity sender) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());

        CustomPayloadS2CPacket packet = new CustomPayloadS2CPacket(ModPackets.DUBSTEP_STOP, buf);

        ((ServerWorld) sender.getWorld()).getPlayers()
                .forEach(player -> player.networkHandler.sendPacket(packet));

        sender.networkHandler.sendPacket(packet);
    }
}

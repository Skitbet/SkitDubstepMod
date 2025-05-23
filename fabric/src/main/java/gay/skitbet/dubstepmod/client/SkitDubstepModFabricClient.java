package gay.skitbet.dubstepmod.client;

import gay.skitbet.dubstepmod.util.SoundHelper;
import gay.skitbet.dubstepmod.utils.ModPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import org.joml.Vector3f;

public final class SkitDubstepModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.DUBSTEP_START, (minecraftClient, clientPlayNetworkHandler, packetByteBuf, sender) -> {
            Vector3f pos = packetByteBuf.readVector3f();
            minecraftClient.execute(() -> SoundHelper.playDubstepLoopSound(pos));
        });

        ClientPlayNetworking.registerGlobalReceiver(ModPackets.DUBSTEP_STOP, (client, handler, buf, sender) -> {
           client.execute(SoundHelper::stopDubstepLoopSound);
        });
    }
}

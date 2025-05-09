package gay.skitbet.client;

import gay.skitbet.init.ModEntities;
import gay.skitbet.init.ModPackets;
import gay.skitbet.util.SoundHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.joml.Vector3f;

public class SkitDubstepModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ClientPlayNetworking.registerGlobalReceiver(ModPackets.DUBSTEP_START, (client, clientPlayNetworkHandler, packetByteBuf, packetSender) -> {
            Vector3f position = packetByteBuf.readVector3f();
            System.out.println("test");
            client.execute(() -> SoundHelper.playDubstepLoopSound(position));
        });

        ClientPlayNetworking.registerGlobalReceiver(ModPackets.DUBSTEP_STOP, (minecraftClient, clientPlayNetworkHandler, packetByteBuf, packetSender) -> {
            minecraftClient.execute(SoundHelper::stopDubstepLoopSound);
        });
    }
}

package gay.skitbet.dubstepmod.platform;

import net.minecraft.server.network.ServerPlayerEntity;
import org.joml.Vector3f;

public interface GunNetworkPlatform {

    void startDubstep(ServerPlayerEntity serverPlayerEntity, Vector3f position);
    void stopDubstep(ServerPlayerEntity serverPlayerEntity);
}

package gay.skitbet.dubstepmod;

import gay.skitbet.dubstepmod.platform.GunNetworkPlatform;
import gay.skitbet.dubstepmod.utils.ModPackets;
import gay.skitbet.dubstepmod.utils.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SkitDubstepMod {
    public static final String MOD_ID = "skitdubstepguns";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static GunNetworkPlatform gunNetworkPlatform;

    public static void init(GunNetworkPlatform gunNetworkPlatform) {
        SkitDubstepMod.gunNetworkPlatform = gunNetworkPlatform;

        ModPackets.init();
        ModSounds.init();
    }
}

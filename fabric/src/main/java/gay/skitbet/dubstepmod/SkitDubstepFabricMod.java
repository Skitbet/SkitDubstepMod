package gay.skitbet.dubstepmod;

import gay.skitbet.dubstepmod.init.ModItemGroup;
import gay.skitbet.dubstepmod.init.ModItems;
import gay.skitbet.dubstepmod.utils.ModSounds;
import gay.skitbet.dubstepmod.platform.FabricGunNetworkPlatformImpl;
import net.fabricmc.api.ModInitializer;

public final class SkitDubstepFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // Run our common setup.
        SkitDubstepMod.init(new FabricGunNetworkPlatformImpl());

        ModItems.init();
        ModItemGroup.register();
    }
}

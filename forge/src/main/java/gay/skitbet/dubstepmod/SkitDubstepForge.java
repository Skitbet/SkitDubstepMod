package gay.skitbet.dubstepmod;

import gay.skitbet.dubstepmod.init.ModItems;
import gay.skitbet.dubstepmod.init.ModTabs;
import gay.skitbet.dubstepmod.platform.ForgeGunNetworkPlatformImpl;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SkitDubstepMod.MOD_ID)
public final class SkitDubstepForge {
    public SkitDubstepForge(FMLJavaModLoadingContext context) {
        IEventBus modBus = context.getModEventBus();
        SkitDubstepMod.init(new ForgeGunNetworkPlatformImpl());

        ModItems.init(modBus);
        ModTabs.register(modBus);



    }
}

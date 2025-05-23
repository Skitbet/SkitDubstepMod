package gay.skitbet.dubstepmod;

import net.minecraft.util.Identifier;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ForgeNetwork {
    public static final String VERSION = "1.0";
    public static SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            Identifier.of(SkitDubstepMod.MOD_ID, "network_main"),
            () -> VERSION,
            VERSION::equals,
            VERSION::equals,
    );

    public static void register() {
        int id = 0;
        CHANNEL.registerMessage(id++, DubstepStart)
    }

}

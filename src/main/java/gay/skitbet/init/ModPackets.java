package gay.skitbet.init;

import gay.skitbet.SkitDubstepMod;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier DUBSTEP_START = Identifier.of(SkitDubstepMod.MOD_ID, "dubstep_start");
    public static final Identifier DUBSTEP_STOP = Identifier.of(SkitDubstepMod.MOD_ID, "dubstep_stop");

    public static void init() {
        SkitDubstepMod.LOGGER.info("Loading packets.");
    }
}

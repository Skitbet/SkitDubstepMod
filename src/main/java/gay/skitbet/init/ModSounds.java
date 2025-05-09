package gay.skitbet.init;

import gay.skitbet.SkitDubstepMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent DUBSTEP_LOOP = registerSound("dubstep_loop");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(SkitDubstepMod.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void init() {
        SkitDubstepMod.LOGGER.info("Loading sounds...");
    }

}

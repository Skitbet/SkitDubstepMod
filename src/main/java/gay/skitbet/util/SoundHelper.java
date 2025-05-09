package gay.skitbet.util;

import gay.skitbet.init.ModSounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundCategory;
import org.joml.Vector3f;

public class SoundHelper {
    private static PositionedSoundInstance dubstepSound;

    public static void playDubstepLoopSound(Vector3f position) {
        MinecraftClient client = MinecraftClient.getInstance();
        System.out.println("test");
        // Avoid duplicates
        if (dubstepSound == null || !client.getSoundManager().isPlaying(dubstepSound)) {
            dubstepSound = new PositionedSoundInstance(
                    ModSounds.DUBSTEP_LOOP,
                    SoundCategory.PLAYERS,
                    1.0f,
                    1.0f,
                    MinecraftClient.getInstance().player.getRandom(),
                    (float) position.x,
                    (float) position.y,
                    (float) position.z
            );

            client.getSoundManager().play(dubstepSound);
        }
    }

    public static void stopDubstepLoopSound() {
        if (dubstepSound != null) {
            MinecraftClient.getInstance().getSoundManager().stop(dubstepSound);
            dubstepSound = null;
        }
    }
}
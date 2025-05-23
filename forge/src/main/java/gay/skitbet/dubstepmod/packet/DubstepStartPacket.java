package gay.skitbet.dubstepmod.packet;

import net.minecraftforge.common.extensions.IForgeFriendlyByteBuf;
import org.joml.Vector3f;

public class DubstepStartPacket {
    private final Vector3f pos;

    public DubstepStartPacket(Vector3f pos) {
        this.pos = pos;
    }

    public static void execute(DubstepStartPacket msg, IForgeFriendlyByteBuf buf) {
    }
}

package gay.skitbet.util;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

public class ParticleHelper {
    public static void createBeamParticles(World world, Vec3d start, Vec3d direction, double distance) {
        if (!(world instanceof ServerWorld serverWorld)) return;

        for (double d = 0; d < distance; d += 0.4) {
            Vec3d pos = start.add(direction.multiply(d));
            serverWorld.spawnParticles(ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 1, 0, 0, 0, 0);
            serverWorld.spawnParticles(ParticleTypes.NOTE, pos.x, pos.y, pos.z, 1, 0, 0, 0, 1);
            serverWorld.spawnParticles(ParticleTypes.ELECTRIC_SPARK, pos.x, pos.y, pos.z, 1, 0.1, 0.1, 0.1, 0.01);
            serverWorld.spawnParticles(ParticleTypes.FIREWORK, pos.x, pos.y, pos.z, 1, 0, 0.05, 0, 0.01);
        }
    }


    public static void createExplosionParticles(World world, double x, double y, double z) {
        if (!(world instanceof ServerWorld serverWorld)) return;

        serverWorld.addParticle(ParticleTypes.NOTE, x, y + 1.0, z, 12, 0.5, 0.5);
        serverWorld.addParticle(ParticleTypes.ELECTRIC_SPARK, x, y + 0.5, z, 10, 0.3, 0.3);
        serverWorld.addParticle(ParticleTypes.FIREWORK, x, y, z, 4, 0.2, 0.2);
    }
}
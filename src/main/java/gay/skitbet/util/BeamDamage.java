package gay.skitbet.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import java.util.List;

public class BeamDamage {
    public static void applyDamageAndKnockback(ServerWorld world, PlayerEntity player, Vec3d start, Vec3d end) {
        List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class,
                new Box(end.x - 3, end.y - 3, end.z - 3, end.x + 3, end.y + 3, end.z + 3),
                e -> e != player);

        DamageSource damageSource = new DamageSource(
                world.getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .getEntry(DamageTypes.PLAYER_EXPLOSION).get()
        );

        for (LivingEntity entity : entities) {
            entity.damage(damageSource, 6.0F);

            // Knockback
            Vec3d knockback = entity.getPos().subtract(player.getPos()).normalize().multiply(0.8);
            entity.addVelocity(knockback.x, 0.4, knockback.z);

            // Particles around the entity
            if (!world.isClient) {
                ParticleHelper.createExplosionParticles(world, entity.getX(), entity.getY(), entity.getZ());
            }
        }

        world.createExplosion(null, end.x, end.y, end.z, 0.0F, World.ExplosionSourceType.NONE);
    }
}

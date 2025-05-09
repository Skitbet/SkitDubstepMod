package gay.skitbet.item;

import gay.skitbet.init.ModPackets;
import gay.skitbet.util.BeamDamage;
import gay.skitbet.util.ParticleHelper;
import gay.skitbet.util.SoundHelper;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DubstepGunItem extends Item {
    private static final Map<UUID, Integer> cooldownTicks = new HashMap<>();

    public DubstepGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);

        if (!world.isClient && user instanceof ServerPlayerEntity serverPlayer) {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeVector3f(serverPlayer.getPos().toVector3f());

            double range = 64.0;
            for (ServerPlayerEntity player : ((ServerWorld) world).getPlayers()) {
                if (player.squaredDistanceTo(serverPlayer) <= range * range) {
                    ServerPlayNetworking.send(player, ModPackets.DUBSTEP_START, buf);
                }
            }
        }

        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient && user instanceof ServerPlayerEntity serverPlayer) {
            for (ServerPlayerEntity player : PlayerLookup.tracking(serverPlayer)) {
                ServerPlayNetworking.send(player, ModPackets.DUBSTEP_STOP, PacketByteBufs.empty());
            }

            ServerPlayNetworking.send(serverPlayer, ModPackets.DUBSTEP_STOP, PacketByteBufs.empty());
        }

    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!(entity instanceof PlayerEntity player)) return;
        if (!player.isUsingItem() || player.getActiveItem() != stack) return;

        UUID playerId = player.getUuid();
        int ticks = cooldownTicks.getOrDefault(playerId, 0);

        if (ticks <= 0) {
            fireDubstepBeam(player, world);
            cooldownTicks.put(playerId, 10);
        } else {
            cooldownTicks.put(playerId, ticks - 1);
        }
    }

    private void fireDubstepBeam(PlayerEntity player, World world) {
        HitResult result = player.raycast(50.0D, 0.0F, false);
        Vec3d start = player.getEyePos();
        Vec3d end = result.getPos();
        Vec3d direction = end.subtract(start).normalize();
        double distance = start.distanceTo(end);

        if (!world.isClient) {
            ParticleHelper.createBeamParticles(world, start, direction, distance);
        }

        if (!world.isClient && result.getType() == HitResult.Type.BLOCK) {
            BeamDamage.applyDamageAndKnockback((ServerWorld) world, player, start, end);
        }
    }
}

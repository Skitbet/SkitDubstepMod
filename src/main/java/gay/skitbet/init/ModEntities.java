package gay.skitbet.init;

import gay.skitbet.SkitDubstepMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
//    public static final EntityType<BeamEntity> BEAM_ENTITY = Registry.register(
//            Registries.ENTITY_TYPE,
//            Identifier.of(SkitDubstepMod.MOD_ID, "dubstep_laser"),
//            FabricEntityTypeBuilder.<BeamEntity>create(SpawnGroup.MISC, (type, world) -> new BeamEntity(type, world))
//                    .dimensions(EntityDimensions.fixed(0.2f, 0.2f))
//                    .trackRangeBlocks(64)
//                    .trackedUpdateRate(10)
//                    .build()
//
//    );

    public static void init() {
        // No-op, just to call during Mod init
    }
}

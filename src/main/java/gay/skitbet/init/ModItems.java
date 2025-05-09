package gay.skitbet.init;

import gay.skitbet.SkitDubstepMod;
import gay.skitbet.item.DubstepGunItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DUPSTEP_GUN = register("dubstep_gun", new DubstepGunItem(new Item.Settings()));

    public static Item register(String name, Item item) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SkitDubstepMod.MOD_ID, name));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void init() {
        SkitDubstepMod.LOGGER.info("Loading items...");
    }


}
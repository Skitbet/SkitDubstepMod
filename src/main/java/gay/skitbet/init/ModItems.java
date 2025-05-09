package gay.skitbet.init;

import gay.skitbet.SkitDubstepMod;
import gay.skitbet.item.RedstoneDubstepGunItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {



    public static final Item REDSTONE_DEBSTEP_GUN = register("redstone_dubstep_gun", new RedstoneDubstepGunItem(new Item.Settings()));

    public static Item register(String name, Item item) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SkitDubstepMod.MOD_ID, name));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void init() {
        SkitDubstepMod.LOGGER.info("Loading items...");
    }


}
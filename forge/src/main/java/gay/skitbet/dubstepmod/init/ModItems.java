package gay.skitbet.dubstepmod.init;

import gay.skitbet.dubstepmod.SkitDubstepMod;
import gay.skitbet.dubstepmod.items.RedstoneDubstepGunItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SkitDubstepMod.MOD_ID);

    public static final RegistryObject<Item> REDSTONE_DUBSTEP_GUN =
            ITEMS.register("redstone_dubstep_gun",
                    () -> new RedstoneDubstepGunItem(new Item.Settings()));

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }
}

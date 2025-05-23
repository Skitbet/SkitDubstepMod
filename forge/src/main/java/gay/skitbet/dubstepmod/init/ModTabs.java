package gay.skitbet.dubstepmod.init;

import gay.skitbet.dubstepmod.SkitDubstepMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<ItemGroup> ITEM_GROUPS =
            DeferredRegister.create(Registries.ITEM_GROUP.getKey(), SkitDubstepMod.MOD_ID);

    public static final RegistryObject<ItemGroup> MAIN =
            ITEM_GROUPS.register("dubstep_item_group", () -> ItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.REDSTONE_DUBSTEP_GUN.get()))
                    .displayName(Text.translatable("itemGroup.dubstep_item_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.REDSTONE_DUBSTEP_GUN.get());
                    })
                    .build());

    public static void register(IEventBus bus) {
        ITEM_GROUPS.register(bus);
    }
}

package gay.skitbet.forge;

import net.minecraftforge.fml.common.Mod;

import gay.skitbet.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModForge {
    public ExampleModForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}

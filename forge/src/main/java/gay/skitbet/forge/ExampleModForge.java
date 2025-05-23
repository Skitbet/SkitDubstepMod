package gay.skitbet.forge;

import net.minecraftforge.fml.common.Mod;

import gay.skitbet.dubstepmod.SkitDubstepMod;

@Mod(SkitDubstepMod.MOD_ID)
public final class ExampleModForge {
    public ExampleModForge() {
        // Run our common setup.
        SkitDubstepMod.init();
    }
}

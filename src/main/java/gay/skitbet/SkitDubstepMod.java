package gay.skitbet;

import gay.skitbet.init.ModEntities;
import gay.skitbet.init.ModItems;
import gay.skitbet.init.ModPackets;
import gay.skitbet.init.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkitDubstepMod implements ModInitializer {
	public static final String MOD_ID = "skitdubstepguns";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModSounds.init();
		ModEntities.init();
		ModItems.init();
		ModPackets.init();
	}
}
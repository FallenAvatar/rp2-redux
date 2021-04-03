package fallenavatar.rp2_redux.event;

import static fallenavatar.rp2_redux.common.Constants.ID_RP2_REDUX;

import fallenavatar.rp2_redux.world.biome.RP2BiomeFeatures;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ID_RP2_REDUX)
public class RP2CommonSetupEvents {
	private RP2CommonSetupEvents() {}

	@SubscribeEvent(priority = EventPriority.HIGH)
    public static void biomeLoadingAdd(final BiomeLoadingEvent event) {
        RP2BiomeFeatures.addOreGeneration(event);
    }
}

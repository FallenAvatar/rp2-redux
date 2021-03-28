package fallenavatar.rp2_redux.event;

import net.minecraft.client.resources.ReloadListener;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.client.event.RecipesUpdatedEvent;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.TagsUpdatedEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLModIdMappingEvent;

import fallenavatar.rp2_redux.world.biome.RP2BiomeFeatures;
import static fallenavatar.rp2_redux.common.Constants.ID_RP2_REDUX;

@Mod.EventBusSubscriber(modid = ID_RP2_REDUX)
public class RP2CommonSetupEvents {
	private RP2CommonSetupEvents() {}

	@SubscribeEvent(priority = EventPriority.HIGH)
    public static void biomeLoadingAdd(final BiomeLoadingEvent event) {
        RP2BiomeFeatures.addOreGeneration(event);
    }
}

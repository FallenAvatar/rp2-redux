package fallenavatar.rp2_redux.event;

import static fallenavatar.rp2_redux.common.Constants.ID_RP2_REDUX;

import fallenavatar.rp2_redux.common.RP2RecipeManagers;
import fallenavatar.rp2_redux.world.biome.RP2BiomeFeatures;
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

@Mod.EventBusSubscriber(modid = ID_RP2_REDUX)
public class RP2CommonSetupEvents {
	private RP2CommonSetupEvents() {}

	@SubscribeEvent
    public static void addReloadListener(final AddReloadListenerEvent event) {
        event.addListener(
                new ReloadListener<Void>() {

                    @Override
                    protected Void prepare(IResourceManager resourceManagerIn, IProfiler profilerIn) {

                        RP2RecipeManagers.instance().setServerRecipeManager(event.getDataPackRegistries().getRecipeManager());
                        return null;
                    }

                    @Override
                    protected void apply(Void nothing, IResourceManager resourceManagerIn, IProfiler profilerIn) {

                    }
                }
        );
    }

    // Recipes reload during TagsUpdatedEvent or IdMapping on Server side.
    @SubscribeEvent
    public static void tagsUpdated(final TagsUpdatedEvent.VanillaTagTypes event) {
        RP2RecipeManagers.instance().refreshServer();
    }

    @SubscribeEvent
    public static void idRemap(final FMLModIdMappingEvent event) {
        RP2RecipeManagers.instance().refreshServer();
    }

    // Recipes reload during RecipesUpdatedEvent on Client side.
    @SubscribeEvent
    public static void recipesUpdated(final RecipesUpdatedEvent event) {
        RP2RecipeManagers.instance().refreshClient(event.getRecipeManager());
    }

	@SubscribeEvent(priority = EventPriority.HIGH)
    public static void biomeLoadingAdd(final BiomeLoadingEvent event) {
        RP2BiomeFeatures.addOreGeneration(event);
    }
}

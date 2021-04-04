package fallenavatar.rp2_redux;

import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fallenavatar.rp2_redux.client.gui.AlloyFurnaceScreen;
import fallenavatar.rp2_redux.init.RP2Blocks;
import fallenavatar.rp2_redux.init.RP2Containers;
import fallenavatar.rp2_redux.init.RP2Items;
import fallenavatar.rp2_redux.init.RP2RecipeManagers;
import fallenavatar.rp2_redux.init.RP2RecipeSerializers;
import fallenavatar.rp2_redux.init.RP2RecipeTypes;
import cofh.core.util.Proxy;
import cofh.core.util.ProxyClient;
import cofh.lib.util.DeferredRegisterCoFH;
import fallenavatar.rp2_redux.world.biome.RP2BiomeFeatures;
import fallenavatar.rp2_redux.world.gen.feature.RP2Features;

import java.util.stream.Collectors;

import static fallenavatar.rp2_redux.common.Constants.*;
import static fallenavatar.rp2_redux.init.RP2References.ALLOY_FURNACE_CONTAINER;

@Mod(ID_RP2_REDUX)
public class RP2ReduxMod {
	public static final Logger LOG = LogManager.getLogger(ID_RP2_REDUX);
	public static final Proxy PROXY = DistExecutor.safeRunForDist(() -> ProxyClient::new, () -> Proxy::new);

	public static final DeferredRegisterCoFH<Block> BLOCKS = DeferredRegisterCoFH.create(ForgeRegistries.BLOCKS, ID_RP2_REDUX);
	public static final DeferredRegisterCoFH<Item> ITEMS = DeferredRegisterCoFH.create(ForgeRegistries.ITEMS, ID_RP2_REDUX);

	public static final DeferredRegisterCoFH<ContainerType<?>> CONTAINERS = DeferredRegisterCoFH.create(ForgeRegistries.CONTAINERS, ID_RP2_REDUX);
	public static final DeferredRegisterCoFH<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegisterCoFH.create(ForgeRegistries.RECIPE_SERIALIZERS, ID_RP2_REDUX);
	public static final DeferredRegisterCoFH<TileEntityType<?>> TILE_ENTITIES = DeferredRegisterCoFH.create(ForgeRegistries.TILE_ENTITIES, ID_RP2_REDUX);

	public RP2ReduxMod() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);

		CONTAINERS.register(modEventBus);
		RECIPE_SERIALIZERS.register(modEventBus);
		TILE_ENTITIES.register(modEventBus);

		RP2Blocks.register();
		RP2Items.register();
		RP2Containers.register();

		RP2RecipeManagers.register();
        RP2RecipeSerializers.register();
        RP2RecipeTypes.register();
    }

	@Mod.EventBusSubscriber(modid = ID_RP2_REDUX, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
			LOG.info("HELLO from onBlocksRegistry");
		}

		@SubscribeEvent
		public static void onCommonSetup(final FMLCommonSetupEvent event) {
			LOG.info("HELLO from onCommonSetup");

			event.enqueueWork(RP2Features::setup);
		}
	
		@SubscribeEvent
		public static void onClientSetup(final FMLClientSetupEvent event) {
			LOG.info("HELLO from onClientSetup");

			ScreenManager.registerFactory(ALLOY_FURNACE_CONTAINER, AlloyFurnaceScreen::new);
		}
		
		@SubscribeEvent
		public static void onEnqueueIMC(final InterModEnqueueEvent event) {
			// some example code to dispatch IMC to another mod
			InterModComms.sendTo(ID_RP2_REDUX, "helloworld", () -> {
				LOG.info("Hello world from the MDK");
				return "Hello world";
			});
		}
	
		@SubscribeEvent
		public static void onProcessIMC(final InterModProcessEvent event) {
			// some example code to receive and process InterModComms from other mods
			LOG.info("Got IMC {}", event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
		}
	
		// You can use SubscribeEvent and let the Event Bus discover methods to call
		/* @SubscribeEvent
		public static void onServerStarting(FMLServerStartingEvent event) {
			LOGGER.info("HELLO from server starting");
		} */
	}
}

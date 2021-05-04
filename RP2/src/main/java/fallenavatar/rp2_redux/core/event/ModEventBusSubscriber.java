package fallenavatar.rp2_redux.core.event;



import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;

import fallenavatar.rp2_redux.core.RP2ReduxMod;
import fallenavatar.rp2_redux.core.init.RP2Containers;
import fallenavatar.rp2_redux.core.world.gen.feature.RP2Features;

import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;



@Mod.EventBusSubscriber(modid = ID_RP2_REDUX, bus = Bus.MOD)
public class ModEventBusSubscriber {
	@SubscribeEvent
	public static void onGatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		RP2ReduxMod.LOG.info("HELLO from onGatherData");
	}

	@SubscribeEvent
	public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
		RP2ReduxMod.LOG.info("HELLO from onBlocksRegistry");
	}

	@SubscribeEvent
	public static void onCommonSetup(final FMLCommonSetupEvent event) {
		RP2ReduxMod.LOG.info("HELLO from onCommonSetup");

		event.enqueueWork(RP2Features::setup);
	}

	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		RP2ReduxMod.LOG.info("HELLO from onClientSetup");

		RP2Containers.registerScreens();
	}

	@SubscribeEvent
	public static void onEnqueueIMC(final InterModEnqueueEvent event) {
		// some example code to dispatch IMC to another mod
		InterModComms.sendTo(ID_RP2_REDUX, "helloworld", () -> {
			RP2ReduxMod.LOG.info("Hello world from the MDK");
			return "Hello world";
		});
	}

	@SubscribeEvent
	public static void onProcessIMC(final InterModProcessEvent event) {
		// some example code to receive and process InterModComms from other mods
		RP2ReduxMod.LOG.info("Got IMC {}", event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
	}
}
package fallenavatar.rp2_redux.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import cofh.core.util.Proxy;
import cofh.core.util.ProxyClient;
import cofh.lib.util.DeferredRegisterCoFH;

import fallenavatar.rp2_redux.core.init.RP2Blocks;
import fallenavatar.rp2_redux.core.init.RP2Containers;
import fallenavatar.rp2_redux.core.init.RP2Items;
import fallenavatar.rp2_redux.core.init.RP2RecipeManagers;
import fallenavatar.rp2_redux.core.init.RP2RecipeSerializers;
import fallenavatar.rp2_redux.core.init.RP2RecipeTypes;


import static fallenavatar.rp2_redux.lib.util.Constants.*;


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
}

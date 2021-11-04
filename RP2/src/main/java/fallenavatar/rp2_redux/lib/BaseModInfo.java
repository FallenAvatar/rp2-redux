package fallenavatar.rp2_redux.lib;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;

import cofh.lib.util.DeferredRegisterCoFH;

public abstract class BaseModInfo implements IModInfo {
	protected String mod_id;
	public String getModID() { return mod_id; }
	
	protected String mod_name;
	public String getModName() { return mod_name; }

	protected Logger log;
	public Logger getLogger() { return log; }

	protected DeferredRegisterCoFH<Block> blocksRegistry;
	public DeferredRegisterCoFH<Block> getBlocksRegistry() { return blocksRegistry; }

	protected DeferredRegisterCoFH<Item> itemsRegistry;
	public DeferredRegisterCoFH<Item> getItemRegistry() { return itemsRegistry; }

	protected DeferredRegisterCoFH<TileEntityType<?>> tesRegistry;
	public DeferredRegisterCoFH<TileEntityType<?>> getTileEntitiesRegistry() { return tesRegistry; }

	protected DeferredRegisterCoFH<ContainerType<?>> containersRegistry;
	public DeferredRegisterCoFH<ContainerType<?>> getContainersRegistry() { return containersRegistry; }

	protected DeferredRegisterCoFH<IRecipeSerializer<?>> recipeSerializersRegistry;
	public DeferredRegisterCoFH<IRecipeSerializer<?>> getRecipeSerializersRegistry() { return recipeSerializersRegistry; }

	protected BaseModInfo(String id, String name) {
		mod_id = id;
		mod_name = name;

		log = LogManager.getLogger(mod_id);

		blocksRegistry = DeferredRegisterCoFH.create(ForgeRegistries.BLOCKS, mod_id);
		itemsRegistry = DeferredRegisterCoFH.create(ForgeRegistries.ITEMS, mod_id);
		tesRegistry = DeferredRegisterCoFH.create(ForgeRegistries.TILE_ENTITIES, mod_id);
		containersRegistry = DeferredRegisterCoFH.create(ForgeRegistries.CONTAINERS, mod_id);
		recipeSerializersRegistry = DeferredRegisterCoFH.create(ForgeRegistries.RECIPE_SERIALIZERS, mod_id);
	}

	public void Register(IEventBus modEventBus) {
		blocksRegistry.register(modEventBus);
		itemsRegistry.register(modEventBus);
		tesRegistry.register(modEventBus);
		containersRegistry.register(modEventBus);
		recipeSerializersRegistry.register(modEventBus);
	}
}

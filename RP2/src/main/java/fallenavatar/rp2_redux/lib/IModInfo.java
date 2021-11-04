package fallenavatar.rp2_redux.lib;

import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;

import cofh.lib.util.DeferredRegisterCoFH;

public interface IModInfo {
	String getModID();
	String getModName();

	Logger getLogger();

	DeferredRegisterCoFH<Block> getBlocksRegistry();
	DeferredRegisterCoFH<Item> getItemRegistry();
	DeferredRegisterCoFH<TileEntityType<?>> getTileEntitiesRegistry();
	DeferredRegisterCoFH<ContainerType<?>> getContainersRegistry();
	DeferredRegisterCoFH<IRecipeSerializer<?>> getRecipeSerializersRegistry();

	void Register(IEventBus modEventBus);
}

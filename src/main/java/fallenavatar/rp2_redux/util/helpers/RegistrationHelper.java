package fallenavatar.rp2_redux.util.helpers;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import com.google.common.base.Supplier;

import static fallenavatar.rp2_redux.RP2ReduxMod.BLOCKS;
import static fallenavatar.rp2_redux.RP2ReduxMod.ITEMS;

public class RegistrationHelper {
	private RegistrationHelper() {}

	public static void registerBlock(String name, Properties props, ItemGroup tab) {
		BLOCKS.register(name, () -> new Block(props));
		ITEMS.register(name, () -> new BlockItem(BLOCKS.get(name), new Item.Properties().tab(tab)));
	}

	public static RegistryObject<Item> registerItem(String name, Supplier<Item> sup) {
        return ITEMS.register(name, sup);
    }
}

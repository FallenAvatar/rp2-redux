package fallenavatar.rp2_redux.util.helpers;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import static fallenavatar.rp2_redux.common.RP2ItemGroups.*;
import static fallenavatar.rp2_redux.util.constants.Constants.*;

import static fallenavatar.rp2_redux.RP2ReduxMod.BLOCKS;
import static fallenavatar.rp2_redux.RP2ReduxMod.ITEMS;

public class RegistrationHelper {
	private RegistrationHelper() {}

	public static void registerBlock(String id, Properties props) {
		BLOCKS.register(id, () -> new Block(props));
		ITEMS.register(id, () -> new BlockItem(BLOCKS.get(id), new Item.Properties().tab(RP2_BLOCKS)));
	}
}

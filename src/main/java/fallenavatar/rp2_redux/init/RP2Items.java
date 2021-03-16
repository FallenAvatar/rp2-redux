package fallenavatar.rp2_redux.init;

import fallenavatar.rp2_redux.util.helpers.RegistrationHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

import static fallenavatar.rp2_redux.common.RP2IDs.*;
import static fallenavatar.rp2_redux.common.RP2ItemGroups.*;
import static fallenavatar.rp2_redux.common.RP2ItemTiers.*;

import fallenavatar.rp2_redux.item.RP2AxeItem;

public class RP2Items {
	private RP2Items() {}

	public static void register() {
		RegistrationHelper.registerItem(ID_RUBY, () -> new Item(new Item.Properties().tab(RP2_ITEMS)));
		RegistrationHelper.registerItem(ID_GREEN_SAPPHIRE, () -> new Item(new Item.Properties().tab(RP2_ITEMS)));
		RegistrationHelper.registerItem(ID_SAPPHIRE, () -> new Item(new Item.Properties().tab(RP2_ITEMS)));

		RegistrationHelper.registerItem(ID_SCREWDRIVER, () -> new Item(new Item.Properties().tab(RP2_ITEMS)));

		RegistrationHelper.registerItem(ID_AXE_RUBY, () -> new RP2AxeItem( MATERIAL_RUBY, new Item.Properties().rarity(Rarity.UNCOMMON)));
		RegistrationHelper.registerItem(ID_AXE_GREEN_SAPPHIRE, () -> new RP2AxeItem( MATERIAL_GREEN_SAPPHIRE, new Item.Properties().rarity(Rarity.UNCOMMON)));
		RegistrationHelper.registerItem(ID_AXE_SAPPHIRE, () -> new RP2AxeItem( MATERIAL_SAPPHIRE, new Item.Properties().rarity(Rarity.UNCOMMON)));
	}
}

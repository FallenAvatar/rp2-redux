package fallenavatar.rp2_redux.init;

import fallenavatar.rp2_redux.util.helpers.RegistrationHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import static fallenavatar.rp2_redux.init.RP2IDs.*;

public class RP2Items {
	private RP2Items() {}

	public static void register() {
		RegistrationHelper.registerItem(ID_SCREWDRIVER, () -> new Item(new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
	}
}

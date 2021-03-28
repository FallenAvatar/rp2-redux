package fallenavatar.rp2_redux.init;

import fallenavatar.rp2_redux.util.helpers.RegistrationHelper;

import static fallenavatar.rp2_redux.common.RP2IDs.*;
import static fallenavatar.rp2_redux.common.RP2ItemTiers.*;

public class RP2Items {
	private RP2Items() {}

	public static void register() {
		RegistrationHelper.registerGemSet(ID_RUBY);
		RegistrationHelper.registerGemSet(ID_GREEN_SAPPHIRE);
		RegistrationHelper.registerGemSet(ID_SAPPHIRE);

		RegistrationHelper.registerMetalSet(ID_COPPER);
		RegistrationHelper.registerMetalSet(ID_TIN);
		RegistrationHelper.registerMetalSet(ID_SILVER);
		//RegistrationHelper.registerMetalSet(ID_BRASS);

		RegistrationHelper.registerItem(ID_SCREWDRIVER);

		RegistrationHelper.registerStandardToolSet(ID_RUBY, MATERIAL_RUBY);
		RegistrationHelper.registerStandardToolSet(ID_GREEN_SAPPHIRE, MATERIAL_GREEN_SAPPHIRE);
		RegistrationHelper.registerStandardToolSet(ID_SAPPHIRE, MATERIAL_SAPPHIRE);

		RegistrationHelper.registerStandardToolSet(ID_WOOD, net.minecraft.item.ItemTier.WOOD, false, true);
		RegistrationHelper.registerStandardToolSet(ID_STONE, net.minecraft.item.ItemTier.STONE, false, true);
		RegistrationHelper.registerStandardToolSet(ID_IRON, net.minecraft.item.ItemTier.IRON, true, true);
		RegistrationHelper.registerStandardToolSet(ID_GOLD, net.minecraft.item.ItemTier.GOLD, false, true);
		RegistrationHelper.registerStandardToolSet(ID_DIAMOND, net.minecraft.item.ItemTier.DIAMOND, true, true);
	}
}

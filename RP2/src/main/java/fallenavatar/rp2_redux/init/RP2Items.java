package fallenavatar.rp2_redux.init;

import fallenavatar.rp2_redux.util.helpers.RegistrationHelper;
import cofh.lib.util.constants.ToolTypes;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import fallenavatar.rp2_redux.item.WrenchItem;

import static fallenavatar.rp2_redux.common.RP2IDs.*;
import static fallenavatar.rp2_redux.common.RP2ItemTiers.*;
import static fallenavatar.rp2_redux.common.RP2ItemGroups.*;

public class RP2Items {
	private RP2Items() {}

	public static void register() {
		RegistrationHelper.registerDustSet(ID_NIKOLITE);

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

		RegistrationHelper.registerItem(ID_CANVAS);
		RegistrationHelper.registerItem(ID_STONE_WAFER);
		RegistrationHelper.registerItem(ID_STONE_WIRE);
		RegistrationHelper.registerItem(ID_STONE_CATHODE);
		RegistrationHelper.registerItem(ID_STONE_ANODE);
		RegistrationHelper.registerItem(ID_STONE_POINTER);

		RegistrationHelper.registerItem("wrench", () -> new WrenchItem(new Item.Properties().maxStackSize(1).group(RP2_ITEMS).addToolType(ToolTypes.WRENCH, 1)));
		RegistrationHelper.registerItem(ID_BRASS+"_ingot");
	}
}

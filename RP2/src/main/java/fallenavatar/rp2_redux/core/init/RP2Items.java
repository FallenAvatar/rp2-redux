package fallenavatar.rp2_redux.core.init;

import fallenavatar.rp2_redux.core.util.helpers.RegistrationHelper;
import cofh.lib.util.constants.ToolTypes;
import cofh.thermal.core.item.WrenchItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

import static fallenavatar.rp2_redux.core.common.RP2IDs.*;
import static fallenavatar.rp2_redux.core.common.RP2ItemTiers.*;
import static fallenavatar.rp2_redux.core.common.RP2ItemGroups.*;

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
		RegistrationHelper.registerItem(ID_SONIC_SCREWDRIVER);
		RegistrationHelper.registerItem(ID_ATHAME);
		RegistrationHelper.registerItem(ID_DIAMOND_DRAWPLATE);
		RegistrationHelper.registerItem(ID_VOLTMETER);
		RegistrationHelper.registerItem(ID_WOOL_CARD);
		RegistrationHelper.registerItem(ID_PAINT_BRUSH);
		RegistrationHelper.registerItem(ID_PAINT_CAN);
		RegistrationHelper.registerItem(ID_WOODEN_WINDMILL);
		RegistrationHelper.registerItem(ID_WOODEN_WIND_TURBINE);
		RegistrationHelper.registerItem(ID_CANVAS_BAG);
		RegistrationHelper.registerItem(ID_SEED_BAG);
		RegistrationHelper.registerItem(ID_PAINT_CANVAS);

		RegistrationHelper.registerStandardToolSet(ID_RUBY, MATERIAL_RUBY);
		RegistrationHelper.registerStandardToolSet(ID_GREEN_SAPPHIRE, MATERIAL_GREEN_SAPPHIRE);
		RegistrationHelper.registerStandardToolSet(ID_SAPPHIRE, MATERIAL_SAPPHIRE);

		RegistrationHelper.registerStandardToolSet(ID_WOOD, net.minecraft.item.ItemTier.WOOD, false, true);
		RegistrationHelper.registerStandardToolSet(ID_STONE, net.minecraft.item.ItemTier.STONE, false, true);
		RegistrationHelper.registerStandardToolSet(ID_IRON, net.minecraft.item.ItemTier.IRON, true, true);
		RegistrationHelper.registerStandardToolSet(ID_GOLD, net.minecraft.item.ItemTier.GOLD, false, true);
		RegistrationHelper.registerStandardToolSet(ID_DIAMOND, net.minecraft.item.ItemTier.DIAMOND, true, true);

		RegistrationHelper.registerItem(ID_CANVAS);
		RegistrationHelper.registerItem(ID_WOODEN_SAIL);
		RegistrationHelper.registerItem(ID_BLANK_PLAN);
		RegistrationHelper.registerItem(ID_WRITTEN_PLAN);

		RegistrationHelper.registerItem(ID_STONE_WAFER);
		RegistrationHelper.registerItem(ID_STONE_WIRE);
		RegistrationHelper.registerItem(ID_STONE_CATHODE);
		RegistrationHelper.registerItem(ID_STONE_ANODE);
		RegistrationHelper.registerItem(ID_STONE_POINTER);
		RegistrationHelper.registerItem(ID_STONE_BUNDLE);
		RegistrationHelper.registerItem(ID_STONE_REDWIRE);
		RegistrationHelper.registerItem(ID_PLATE_ASSEMBLY);

		RegistrationHelper.registerItem(ID_SILICON_BOULE);
		RegistrationHelper.registerItem(ID_SILICON_WAFER);
		RegistrationHelper.registerItem(ID_RED_DOPED_WAFER);
		RegistrationHelper.registerItem(ID_BLUE_DOPED_WAFER);
		RegistrationHelper.registerItem(ID_SILICON_CHIP);
		RegistrationHelper.registerItem(ID_TAINTED_SILICON_CHIP);

		RegistrationHelper.registerItem(ID_BT_BATTERY);
		RegistrationHelper.registerItem(ID_BLULECTRIC_MOTOR);
		RegistrationHelper.registerItem(ID_COPPER_COIL);
		RegistrationHelper.registerItem(ID_FINE_COPPER_WIRE);
		RegistrationHelper.registerItem(ID_FINE_IRON_WIRE);
		RegistrationHelper.registerItem(ID_LUMAR);

		RegistrationHelper.registerItem("wrench", () -> new WrenchItem(new Item.Properties().maxStackSize(1).group(RP2_ITEMS).addToolType(ToolTypes.WRENCH, 1)));
		
		RegistrationHelper.registerItem(ID_BRASS+"_ingot");
		RegistrationHelper.registerItem(ID_RED_ALLOY+"_ingot");
		RegistrationHelper.registerItem(ID_BLUE_ALLOY+"_ingot");
	}
}

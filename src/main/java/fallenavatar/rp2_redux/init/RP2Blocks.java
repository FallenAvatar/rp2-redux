package fallenavatar.rp2_redux.init;

import fallenavatar.rp2_redux.block.Block4Way;
import fallenavatar.rp2_redux.util.helpers.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import static fallenavatar.rp2_redux.common.RP2IDs.*;
import static fallenavatar.rp2_redux.common.RP2ItemGroups.*;
import static net.minecraft.block.AbstractBlock.Properties.copy;

public class RP2Blocks {
	private RP2Blocks() {}

	public static void register() {
		RegistrationHelper.registerBlock(ID_MARBLE, () -> new Block(copy(Blocks.STONE)) );
		RegistrationHelper.registerBlock(ID_MARBLE_BRICKS, () -> new Block(copy(Blocks.STONE_BRICKS)) );

		RegistrationHelper.registerBlock(ID_BASALT, () -> new Block(copy(Blocks.STONE)) );
		RegistrationHelper.registerBlock(ID_BASALT_COBBLESTONE, () -> new Block(copy(Blocks.COBBLESTONE)) );
		RegistrationHelper.registerBlock(ID_BASALT_SMOOTH, () -> new Block(copy(Blocks.SMOOTH_STONE)) );
		RegistrationHelper.registerBlock(ID_BASALT_CHISELED, () -> new Block(copy(Blocks.CHISELED_STONE_BRICKS)) );
		RegistrationHelper.registerBlock(ID_BASALT_BRICKS, () -> new Block(copy(Blocks.STONE_BRICKS)) );

		RegistrationHelper.registerBlock(ID_PROJECT_TABLE, () -> new Block4Way(copy(Blocks.CRAFTING_TABLE)), RP2_MACHINES );

		RegistrationHelper.registerBlock(ID_RUBY+"_ore", () -> new Block(copy(Blocks.EMERALD_ORE)) );
		RegistrationHelper.registerBlock(ID_RUBY+"_block", () -> new Block(copy(Blocks.REDSTONE_BLOCK)) );
		RegistrationHelper.registerBlock(ID_SAPPHIRE+"_ore", () -> new Block(copy(Blocks.EMERALD_ORE)) );
		RegistrationHelper.registerBlock(ID_SAPPHIRE+"_block", () -> new Block(copy(Blocks.REDSTONE_BLOCK)) );
		RegistrationHelper.registerBlock(ID_GREEN_SAPPHIRE+"_ore", () -> new Block(copy(Blocks.EMERALD_ORE)) );
		RegistrationHelper.registerBlock(ID_GREEN_SAPPHIRE+"_block", () -> new Block(copy(Blocks.REDSTONE_BLOCK)) );

		RegistrationHelper.registerBlock(ID_NIKOLITE+"_ore", () -> new Block(copy(Blocks.REDSTONE_BLOCK)) );

		RegistrationHelper.registerBlock(ID_COPPER+"_ore", () -> new Block(copy(Blocks.IRON_ORE)) );
		RegistrationHelper.registerBlock(ID_COPPER+"_block", () -> new Block(copy(Blocks.IRON_BLOCK)) );
		RegistrationHelper.registerBlock(ID_TIN+"_ore", () -> new Block(copy(Blocks.IRON_ORE)) );
		RegistrationHelper.registerBlock(ID_TIN+"_block", () -> new Block(copy(Blocks.IRON_BLOCK)) );
		RegistrationHelper.registerBlock(ID_SILVER+"_ore", () -> new Block(copy(Blocks.GOLD_ORE)) );
		RegistrationHelper.registerBlock(ID_SILVER+"_block", () -> new Block(copy(Blocks.GOLD_BLOCK)) );

		//RegistrationHelper.registerBlock(ID_BRASS+"_block", () -> new Block(copy(Blocks.IRON_BLOCK)) );

		RegistrationHelper.registerBlock(ID_TUNGSTEN+"_ore", () -> new Block(copy(Blocks.DIAMOND_ORE)) );
	}
}

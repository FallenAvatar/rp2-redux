package fallenavatar.rp2_redux.core.init;

import fallenavatar.rp2_redux.core.block.AlloyFurnace;
import fallenavatar.rp2_redux.lib.block.Block4Way;
import fallenavatar.rp2_redux.core.tileentity.AlloyFurnaceTile;
import fallenavatar.rp2_redux.core.util.helpers.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntityType;

import static fallenavatar.rp2_redux.core.common.RP2IDs.*;
import static fallenavatar.rp2_redux.core.common.RP2ItemGroups.*;
import static net.minecraft.block.AbstractBlock.Properties.from;
import static fallenavatar.rp2_redux.core.RP2ReduxMod.TILE_ENTITIES;
import static fallenavatar.rp2_redux.core.init.RP2References.*;

public class RP2Blocks {
	private RP2Blocks() {}

	public static void register() {
		RegistrationHelper.registerBlock(ID_MARBLE, () -> new Block(from(Blocks.STONE)) );
		RegistrationHelper.registerBlock(ID_MARBLE_BRICKS, () -> new Block(from(Blocks.STONE_BRICKS)) );

		RegistrationHelper.registerBlock(ID_BASALT, () -> new Block(from(Blocks.STONE)) );
		RegistrationHelper.registerBlock(ID_BASALT_COBBLESTONE, () -> new Block(from(Blocks.COBBLESTONE)) );
		RegistrationHelper.registerBlock(ID_BASALT_SMOOTH, () -> new Block(from(Blocks.SMOOTH_STONE)) );
		RegistrationHelper.registerBlock(ID_BASALT_CHISELED, () -> new Block(from(Blocks.CHISELED_STONE_BRICKS)) );
		RegistrationHelper.registerBlock(ID_BASALT_BRICKS, () -> new Block(from(Blocks.STONE_BRICKS)) );

		RegistrationHelper.registerBlock(ID_PROJECT_TABLE, () -> new Block4Way(from(Blocks.CRAFTING_TABLE)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_ALLOY_FURNACE, () -> new AlloyFurnace(from(Blocks.FURNACE)), RP2_MACHINES );

		RegistrationHelper.registerBlock(ID_RUBY+"_ore", () -> new Block(from(Blocks.EMERALD_ORE)) );
		RegistrationHelper.registerBlock(ID_RUBY+"_block", () -> new Block(from(Blocks.REDSTONE_BLOCK)) );
		RegistrationHelper.registerBlock(ID_SAPPHIRE+"_ore", () -> new Block(from(Blocks.EMERALD_ORE)) );
		RegistrationHelper.registerBlock(ID_SAPPHIRE+"_block", () -> new Block(from(Blocks.REDSTONE_BLOCK)) );
		RegistrationHelper.registerBlock(ID_GREEN_SAPPHIRE+"_ore", () -> new Block(from(Blocks.EMERALD_ORE)) );
		RegistrationHelper.registerBlock(ID_GREEN_SAPPHIRE+"_block", () -> new Block(from(Blocks.REDSTONE_BLOCK)) );

		RegistrationHelper.registerBlock(ID_NIKOLITE+"_ore", () -> new Block(from(Blocks.REDSTONE_BLOCK)) );

		RegistrationHelper.registerBlock(ID_COPPER+"_ore", () -> new Block(from(Blocks.IRON_ORE)) );
		RegistrationHelper.registerBlock(ID_COPPER+"_block", () -> new Block(from(Blocks.IRON_BLOCK)) );
		RegistrationHelper.registerBlock(ID_TIN+"_ore", () -> new Block(from(Blocks.IRON_ORE)) );
		RegistrationHelper.registerBlock(ID_TIN+"_block", () -> new Block(from(Blocks.IRON_BLOCK)) );
		RegistrationHelper.registerBlock(ID_SILVER+"_ore", () -> new Block(from(Blocks.GOLD_ORE)) );
		RegistrationHelper.registerBlock(ID_SILVER+"_block", () -> new Block(from(Blocks.GOLD_BLOCK)) );

		//RegistrationHelper.registerBlock(ID_BRASS+"_block", () -> new Block(from(Blocks.IRON_BLOCK)) );

		RegistrationHelper.registerBlock(ID_TUNGSTEN+"_ore", () -> new Block(from(Blocks.DIAMOND_ORE)) );

		TILE_ENTITIES.register(ID_ALLOY_FURNACE, () -> TileEntityType.Builder.create(AlloyFurnaceTile::new, ALLOY_FURNACE).build(null));
	}
}

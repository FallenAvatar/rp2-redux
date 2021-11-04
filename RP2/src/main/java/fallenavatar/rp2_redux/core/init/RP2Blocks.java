package fallenavatar.rp2_redux.core.init;

import fallenavatar.rp2_redux.core.block.AlloyFurnace;
import fallenavatar.rp2_redux.core.block.ProjectTable;
import fallenavatar.rp2_redux.core.tile.AlloyFurnaceTile;
import fallenavatar.rp2_redux.core.tile.ProjectTableTile;
import fallenavatar.rp2_redux.lib.block.Block24Way;
import fallenavatar.rp2_redux.lib.block.Block4Way;
import fallenavatar.rp2_redux.lib.block.Block6Way;
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

		RegistrationHelper.registerBlock(ID_ASSEMBLER, () -> new Block24Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_BLOCK_BREAKER, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_BUFFER, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_DEPLOYER, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_EJECTOR, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_FILTER, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_IGNITER, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_ITEM_DETECTOR, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_REGULATOR, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_RELAY, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_TRANSPOSER, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );

		RegistrationHelper.registerBlock(ID_BATTERY_BOX, () -> new Block4Way(from(Blocks.DROPPER)), RP2_MACHINES );

		RegistrationHelper.registerBlock(ID_KINETIC_GENERATOR, () -> new Block4Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_SOLAR_PANEL, () -> new Block4Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_THERMOPILE, () -> new Block4Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_BLULECTRIC_DYNAMO, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );

		RegistrationHelper.registerBlock(ID_BLULECTRIC_ALLOY_FURNACE, () -> new Block4Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_BLULECTRIC_FURNACE, () -> new Block4Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_CHARGING_BENCH, () -> new Block4Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_FRAME_MOTOR, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_MANAGER, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_PUMP, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_RETRIEVER, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );
		RegistrationHelper.registerBlock(ID_SORTING_MACHINE, () -> new Block6Way(from(Blocks.DROPPER)), RP2_MACHINES );



		RegistrationHelper.registerBlock(ID_PROJECT_TABLE,() -> new ProjectTable(from(Blocks.CRAFTING_TABLE)), RP2_MACHINES );
		TILE_ENTITIES.register(ID_PROJECT_TABLE, () -> TileEntityType.Builder.create(ProjectTableTile::new, PROJECT_TABLE).build(null));

		RegistrationHelper.registerBlock(ID_ALLOY_FURNACE, () -> new AlloyFurnace(from(Blocks.FURNACE)), RP2_MACHINES );
		TILE_ENTITIES.register(ID_ALLOY_FURNACE, () -> TileEntityType.Builder.create(AlloyFurnaceTile::new, ALLOY_FURNACE).build(null));



		RegistrationHelper.registerBlock(ID_GATE_AND, () -> new Block24Way(from(Blocks.DROPPER)), RP2_MACHINES );
	}
}

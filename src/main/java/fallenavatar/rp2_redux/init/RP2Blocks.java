package fallenavatar.rp2_redux.init;

import fallenavatar.rp2_redux.util.helpers.RegistrationHelper;
import net.minecraft.block.Blocks;

import static fallenavatar.rp2_redux.common.RP2IDs.*;
import static fallenavatar.rp2_redux.common.RP2ItemGroups.*;
import static net.minecraft.block.AbstractBlock.Properties.copy;

public class RP2Blocks {
	private RP2Blocks() {}

	public static void register() {
		RegistrationHelper.registerBlock(ID_MARBLE, copy(Blocks.STONE), RP2_BLOCKS );
		RegistrationHelper.registerBlock(ID_MARBLE_BRICKS, copy(Blocks.STONE_BRICKS), RP2_BLOCKS );

		RegistrationHelper.registerBlock(ID_BASALT, copy(Blocks.STONE), RP2_BLOCKS );
		RegistrationHelper.registerBlock(ID_BASALT_COBBLESTONE, copy(Blocks.COBBLESTONE), RP2_BLOCKS );
		RegistrationHelper.registerBlock(ID_BASALT_SMOOTH, copy(Blocks.SMOOTH_STONE), RP2_BLOCKS );
		RegistrationHelper.registerBlock(ID_BASALT_CHISELED, copy(Blocks.CHISELED_STONE_BRICKS), RP2_BLOCKS );
		RegistrationHelper.registerBlock(ID_BASALT_BRICKS, copy(Blocks.STONE_BRICKS), RP2_BLOCKS );
	}
}

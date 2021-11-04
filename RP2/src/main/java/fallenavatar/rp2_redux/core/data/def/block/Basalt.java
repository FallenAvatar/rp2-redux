package fallenavatar.rp2_redux.core.data.def.block;


import java.util.EnumSet;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import fallenavatar.rp2_redux.core.RP2ReduxMod;
import fallenavatar.rp2_redux.core.common.RP2ItemGroups;
import fallenavatar.rp2_redux.lib.data.def.LootFlags;
import fallenavatar.rp2_redux.lib.data.def.SimpleBlock;

import static net.minecraft.block.AbstractBlock.Properties.from;

public class Basalt extends SimpleBlock {
	public static final String CATEGORY = "world";
	public static final String ID = "basalt";
	public static final String NAME = "Basalt";
	public static final ItemGroup TAB = RP2ItemGroups.RP2_BLOCKS;
	public static final EnumSet<LootFlags> FLAGS = LootFlags.None;

	public Basalt() {
		super(RP2ReduxMod.ModInfo, CATEGORY, ID, NAME, TAB, from(Blocks.STONE), FLAGS);

		addVariant("cobblestone", from(Blocks.COBBLESTONE));
		addVariant("smooth", from(Blocks.SMOOTH_STONE));
		addVariant("chiseled", from(Blocks.CHISELED_STONE_BRICKS));
		addVariant("brick", from(Blocks.STONE_BRICKS));
	}
}

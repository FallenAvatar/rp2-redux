package fallenavatar.rp2_redux.core.data.def.block;


import java.util.EnumSet;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import fallenavatar.rp2_redux.core.RP2ReduxMod;
import fallenavatar.rp2_redux.core.common.RP2ItemGroups;
import fallenavatar.rp2_redux.lib.data.def.LootFlags;
import fallenavatar.rp2_redux.lib.data.def.SimpleBlock;

import static net.minecraft.block.AbstractBlock.Properties.from;

public class Marble extends SimpleBlock {
	public static final String CATEGORY = "world";
	public static final String ID = "marble";
	public static final String NAME = "Marble";
	public static final ItemGroup TAB = RP2ItemGroups.RP2_BLOCKS;
	public static final EnumSet<LootFlags> FLAGS = LootFlags.None;

	public Marble() {
		super(RP2ReduxMod.ModInfo, CATEGORY, ID, NAME, TAB, from(Blocks.STONE), FLAGS);

		addVariant("brick", from(Blocks.STONE_BRICKS));
	}
}

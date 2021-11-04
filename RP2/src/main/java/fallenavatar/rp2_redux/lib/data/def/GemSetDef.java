package fallenavatar.rp2_redux.lib.data.def;

import net.minecraft.block.Blocks;

import fallenavatar.rp2_redux.core.common.RP2ItemGroups;
import fallenavatar.rp2_redux.lib.BaseModInfo;

import static net.minecraft.block.AbstractBlock.Properties.from;

public abstract class GemSetDef extends BaseSetDef {
	protected String base_id;
	public String getBaseID() { return base_id; }

	protected String base_name;
	public String getBaseName() { return base_name; }

	protected BaseBlockDef ore;
	protected BaseBlockDef storage_block;
	protected BaseItemDef gem;

	protected GemSetDef(BaseModInfo mi, String cat, String id, String name) {
		super(mi);

		base_id = id;
		base_name = name;

		ore = new BaseBlockDef(mi, cat, id+"_ore", name+" Ore", RP2ItemGroups.RP2_BLOCKS, from(Blocks.EMERALD_ORE));
		storage_block = new BaseBlockDef(mi, cat, id+"_block", name+" Block",  RP2ItemGroups.RP2_BLOCKS, from(Blocks.EMERALD_BLOCK));
		gem = new BaseItemDef(mi, cat, id+"_gem", name, RP2ItemGroups.RP2_ITEMS);
	}

	@Override
	public void Register() {
		ore.Register();
		storage_block.Register();
		gem.Register();
	}
}

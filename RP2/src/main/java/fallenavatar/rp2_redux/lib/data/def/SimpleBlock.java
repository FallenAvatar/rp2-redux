package fallenavatar.rp2_redux.lib.data.def;


import java.util.EnumSet;

import fallenavatar.rp2_redux.lib.BaseModInfo;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.ItemGroup;


public abstract class SimpleBlock extends BaseBlockDef {
	protected EnumSet<LootFlags> flags;
	public EnumSet<LootFlags> getFlags() { return flags; }

	protected SimpleBlock(BaseModInfo mi, String cat, String id, String name, ItemGroup tab, Properties props, EnumSet<LootFlags> flags) {
		super(mi, cat, id, name, tab, props);

		this.flags = flags;
	}
}

package fallenavatar.rp2_redux.lib.data.def;


import java.util.EnumSet;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.ItemGroup;


public abstract class SimpleBlock extends BaseBlockDef {
	protected String name_en;
	public String getNameEN() { return name_en; }

	protected EnumSet<LootFlags> flags;
	public EnumSet<LootFlags> getFlags() { return flags; }

	protected SimpleBlock(ItemGroup tab, Properties props, String name, EnumSet<LootFlags> flags) {
		super(tab, props);

		this.name_en = name;
		this.flags = flags;
	}
}

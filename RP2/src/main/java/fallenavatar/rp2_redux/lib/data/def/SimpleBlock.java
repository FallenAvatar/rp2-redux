package fallenavatar.rp2_redux.lib.data.def;


import java.util.EnumSet;


import net.minecraft.item.ItemGroup;


public abstract class SimpleBlock extends BaseBlockDef {
	protected String name_en;
	public String getNameEN() { return name_en; }

	protected EnumSet<LootFlags> flags;
	public EnumSet<LootFlags> getFlags() { return flags; }

	protected SimpleBlock(ItemGroup tab, String name, EnumSet<LootFlags> flags) {
		super(tab);

		this.name_en = name;
		this.flags = flags;
	}
}

package fallenavatar.rp2_redux.lib.data.def;


import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


import net.minecraft.item.ItemGroup;


public abstract class SimpleBlock extends BlockDef {
	protected String id;
	public String getID() { return id; }

	public String getItemName() { return "item."+mod_id+"."+id; }
	public String getBlockName() { return "block."+mod_id+"."+id; }

	protected String mod_id;
	public String getModID() { return mod_id; }

	protected String name_en;
	public String getNameEN() { return name_en; }

	protected ItemGroup tab;
	public ItemGroup getTab() { return tab; }

	protected EnumSet<LootFlags> flags;
	public EnumSet<LootFlags> getFlags() { return flags; }

	protected List<String> variants;
	public List<String> getVariants() { return variants; }

	protected SimpleBlock(String mod_id, String id, String name, ItemGroup tab, EnumSet<LootFlags> flags) {
		this.mod_id = mod_id;
		this.id = id;
		this.name_en = name;
		this.tab = tab;
		this.flags = flags;

		variants = new ArrayList<String>();
	}

	protected void AddVariant(String name) {
		variants.add(name);
	}

	public void GenData() {

	}

	public void Register() {

	}
}

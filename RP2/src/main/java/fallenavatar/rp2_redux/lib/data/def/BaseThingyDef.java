package fallenavatar.rp2_redux.lib.data.def;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraft.item.ItemGroup;
import fallenavatar.rp2_redux.lib.util.annotation.Thingy;

public abstract class BaseThingyDef {
	protected String mod_id;
	public String getModID() { return mod_id; }

	protected String path;
	public String getPath() { return path; }

	protected String id;
	public String getID() { return id; }

	public String getName() {
		String ret = getModID()+":";

		if( path != null && path.trim() != "")
			ret += path+"/";

		return ret + id;
	}

	public abstract String getLangName();

	protected ItemGroup tab;
	public ItemGroup getTab() { return tab; }

	protected BaseThingyDef(ItemGroup tab) {
		Thingy attr = this.getClass().getAnnotation(Thingy.class);
		this.mod_id = attr.mod();
		this.path = attr.path();
		this.id = attr.id();
		this.tab = tab;
	}

	public abstract void GenData(BlockStateProvider bsp);
	public abstract void Register();
}

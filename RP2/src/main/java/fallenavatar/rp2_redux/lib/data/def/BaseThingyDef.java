package fallenavatar.rp2_redux.lib.data.def;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import fallenavatar.rp2_redux.lib.util.annotation.Thingy;

public abstract class BaseThingyDef {
	protected String mod_id;
	public String getModID() { return mod_id; }

	protected String category;
	public String getCategory() { return category; }

	protected String id;
	public String getID() { return id; }

	public String getName() {
		return getName(true);
	}

	public String getName(boolean includeModID) {
		String ret = "";
		if( includeModID )
			ret += getModID()+":";
		String cat = getCategory();

		if( cat != null && cat.trim() != "")
			ret += cat+"/";

		return ret + getID();
	}

	public ResourceLocation getResourceLoc() {
		String ret = "";
		String cat = getCategory();

		if( cat != null && cat.trim() != "")
			ret += cat+"/";

		return new ResourceLocation(getModID(), ret + getID());
	}

	public abstract String getLangName();

	protected ItemGroup tab;
	public ItemGroup getTab() { return tab; }

	protected BaseThingyDef(ItemGroup tab) {
		Thingy attr = this.getClass().getAnnotation(Thingy.class);
		this.mod_id = attr.mod();
		this.category = attr.category();
		this.id = attr.id();
		this.tab = tab;
	}

	public abstract void Register();
}

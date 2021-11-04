package fallenavatar.rp2_redux.lib.data.def;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import fallenavatar.rp2_redux.lib.BaseModInfo;

public abstract class BaseThingyDef {
	protected BaseModInfo modInfo;
	public BaseModInfo getModInfo() { return modInfo; }

	protected String category;
	public String getCategory() { return category; }

	protected String thingyId;
	public String getID() { return thingyId; }

	protected String thingyName;
	public String getI10nName() { return thingyName; }

	public String getName() {
		return getName(true);
	}

	public String getName(boolean includeModID) {
		String ret = "";
		if( includeModID )
			ret += getModInfo().getModID()+":";
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

		return new ResourceLocation(getModInfo().getModID(), ret + getID());
	}

	public abstract String getLangName();

	protected ItemGroup tabGroup;
	public ItemGroup getTab() { return tabGroup; }

	protected BaseThingyDef(BaseModInfo mi, String cat, String id, String i10n_name, ItemGroup tab) {
		modInfo = mi;
		category = cat;
		thingyId = id;
		thingyName = i10n_name;
		tabGroup = tab;
	}

	public abstract void Register();
}

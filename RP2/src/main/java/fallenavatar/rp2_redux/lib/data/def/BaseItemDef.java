package fallenavatar.rp2_redux.lib.data.def;

import fallenavatar.rp2_redux.core.util.helpers.RegistrationHelper;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;

public class BaseItemDef extends BaseThingyDef {
	public String getLangName() { return "item."+getModID()+"."+id; }

	public String getItemName() {
		String ret = getModID()+":item/";
		String cat = getCategory();

		if( cat != null && cat.trim() != "")
			ret += cat+"/";

		return ret + getID();
	}

	public BaseItemDef(ItemGroup tab) {
		super(tab);
	}

	public void GenItemModel(ItemModelProvider imp) {
		imp.getBuilder(getName()).parent(new UncheckedModelFile("item/generated")).texture("layer0", getItemName());
	}

	@Override
	public void Register() {
		RegistrationHelper.registerItem(getName());
	}
}

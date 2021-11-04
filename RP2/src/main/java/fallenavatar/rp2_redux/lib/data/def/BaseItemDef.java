package fallenavatar.rp2_redux.lib.data.def;

import com.google.common.base.Supplier;

import fallenavatar.rp2_redux.core.util.helpers.RegistrationHelper;
import fallenavatar.rp2_redux.lib.BaseModInfo;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;

public class BaseItemDef extends BaseThingyDef {
	public String getLangName() { return "item."+getModInfo().getModID()+"."+getID(); }

	public String getItemName() {
		String ret = getModInfo().getModID()+":item/";
		String cat = getCategory();

		if( cat != null && cat.trim() != "")
			ret += cat+"/";

		return ret + getID();
	}

	public ResourceLocation getItemResourceLoc() {
		String ret = "item/";
		String cat = getCategory();

		if( cat != null && cat.trim() != "")
			ret += cat+"/";

		return new ResourceLocation(getModInfo().getModID(), ret + getID());
	}

	public Supplier<Item> asItem() { return () -> new Item(new Item.Properties().group(getTab()).rarity(Rarity.COMMON)); }

	public BaseItemDef(BaseModInfo mi, String cat, String id, String i10n_name, ItemGroup tab) {
		super(mi, cat, id, i10n_name, tab);
	}

	public void GenItemModel(ItemModelProvider imp) {
		imp.getBuilder(getName()).parent(new UncheckedModelFile("item/generated")).texture("layer0", getItemName());
	}

	@Override
	public void Register() {
		RegistrationHelper.registerItem(getName(), asItem());
	}
}

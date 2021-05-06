package fallenavatar.rp2_redux.lib.data.def;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraft.item.ItemGroup;

public class BaseItemDef extends BaseThingyDef {
	public String getLangName() { return "item."+getModID()+"."+id; }

	public BaseItemDef(ItemGroup tab) {
		super(tab);
	}

	@Override
	public void GenData(BlockStateProvider bsp) {

	}

	@Override
	public void Register() {

	}
}

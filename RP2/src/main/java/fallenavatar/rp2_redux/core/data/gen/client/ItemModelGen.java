package fallenavatar.rp2_redux.core.data.gen.client;

import fallenavatar.rp2_redux.core.init.RP2Thingys;
import fallenavatar.rp2_redux.lib.data.gen.client.BaseItemModelGen;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGen extends BaseItemModelGen {
	public ItemModelGen(DataGenerator gen, ExistingFileHelper efh) {
        super(gen, efh);
    }

	@Override
	protected void registerModels() {
		//genItemModel(RP2Thingys.Blocks.Basalt);
	}
}

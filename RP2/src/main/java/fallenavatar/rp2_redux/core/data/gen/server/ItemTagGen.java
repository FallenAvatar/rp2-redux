package fallenavatar.rp2_redux.core.data.gen.server;

import fallenavatar.rp2_redux.lib.data.gen.server.BaseBlockTagGen;
import fallenavatar.rp2_redux.lib.data.gen.server.BaseItemTagsGen;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTagGen extends BaseItemTagsGen {
	public ItemTagGen(DataGenerator gen, ExistingFileHelper efh, BaseBlockTagGen blockTagsGen) {
		super(gen,efh, blockTagsGen);
	}
}

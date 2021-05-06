package fallenavatar.rp2_redux.lib.data.gen.server;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;

public abstract class BaseItemTagsGen extends ItemTagsProvider {
	public BaseItemTagsGen(DataGenerator gen, ExistingFileHelper efh, BlockTagsProvider blockProvider) {
		super(gen, blockProvider, ID_RP2_REDUX, efh);
	}

	@Override
	protected void registerTags() {
		super.registerTags();


	}
}

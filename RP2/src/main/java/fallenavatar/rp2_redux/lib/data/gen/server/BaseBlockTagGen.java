package fallenavatar.rp2_redux.lib.data.gen.server;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;

public abstract class BaseBlockTagGen extends BlockTagsProvider {
	public BaseBlockTagGen(DataGenerator gen, ExistingFileHelper efh) {
		super(gen, ID_RP2_REDUX, efh);
	}

	@Override
	protected void registerTags() {
		super.registerTags();


	}
}

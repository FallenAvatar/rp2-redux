package fallenavatar.rp2_redux.lib.data.gen.server;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;

public abstract class BaseFluidTagGen extends FluidTagsProvider {
	public BaseFluidTagGen(DataGenerator gen, ExistingFileHelper efh) {
		super(gen, ID_RP2_REDUX, efh);
	}
}

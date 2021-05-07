package fallenavatar.rp2_redux.lib.data.gen.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fallenavatar.rp2_redux.lib.data.def.BaseItemDef;

public abstract class BaseItemModelGen extends ItemModelProvider {
	private static final Logger LOGGER = LogManager.getLogger();

	public BaseItemModelGen(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, ID_RP2_REDUX, existingFileHelper);
	}

	public void genItemModel(BaseItemDef item) {
		item.GenItemModel(this);
	}
}

package fallenavatar.rp2_redux.lib.data.gen.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;

import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;

import java.util.Locale;

public abstract class BaseLangGen extends LanguageProvider {
	public BaseLangGen(DataGenerator gen) {
		super(gen, ID_RP2_REDUX, "en_us");
	}

	public BaseLangGen(DataGenerator gen, String locale) {
		super(gen, ID_RP2_REDUX, locale);
	}

	@Override
	protected void addTranslations() {
		// TODO Auto-generated method stub
		
	}
}

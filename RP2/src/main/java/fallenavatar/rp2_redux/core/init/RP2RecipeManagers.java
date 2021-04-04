package fallenavatar.rp2_redux.init;

import fallenavatar.rp2_redux.util.managers.AlloyFurnaceRecipeManager;
import static fallenavatar.rp2_redux.common.RP2RecipeManagers.registerManager;

public class RP2RecipeManagers {
	private RP2RecipeManagers() {}

	public static void register() {
		registerManager(AlloyFurnaceRecipeManager.instance());
	}
}

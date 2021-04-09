package fallenavatar.rp2_redux.lib.util.manager;

import net.minecraft.item.crafting.RecipeManager;

public abstract class BaseRecipeManager extends AbstractManager implements IRecipeManager {
	protected BaseRecipeManager() {
		super(100);
	}

	public abstract void config();
	public abstract void refresh(RecipeManager recipeManager);
}

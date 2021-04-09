package fallenavatar.rp2_redux.lib.util.manager;

import java.util.List;

import fallenavatar.rp2_redux.lib.inventory.IInventory;
import fallenavatar.rp2_redux.lib.util.recipe.IRecipe;

public interface IRecipeManager extends IManager {
	default boolean validRecipe(IInventory inventory) {
        return getRecipe(inventory) != null;
    }

    IRecipe getRecipe(IInventory inventory);

    List<IRecipe> getRecipeList();
}
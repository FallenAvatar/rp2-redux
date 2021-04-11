package fallenavatar.rp2_redux.core.init;

import static fallenavatar.rp2_redux.core.RP2ReduxMod.RECIPE_SERIALIZERS;
import static fallenavatar.rp2_redux.core.init.RP2RecipeTypes.ID_RECIPE_ALLOY_FURNACE;

import fallenavatar.rp2_redux.core.util.recipes.AlloyFurnaceRecipe;
import fallenavatar.rp2_redux.core.util.recipes.RP2RecipeSerializer;

public class RP2RecipeSerializers {
	private RP2RecipeSerializers() {}

	public static void register() {
		RECIPE_SERIALIZERS.register(ID_RECIPE_ALLOY_FURNACE, () -> new RP2RecipeSerializer<>(AlloyFurnaceRecipe::new));
	}
}

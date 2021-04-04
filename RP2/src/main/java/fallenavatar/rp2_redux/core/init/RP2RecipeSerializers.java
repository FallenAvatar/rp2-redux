package fallenavatar.rp2_redux.init;

import static fallenavatar.rp2_redux.RP2ReduxMod.RECIPE_SERIALIZERS;
import static fallenavatar.rp2_redux.init.RP2RecipeTypes.ID_RECIPE_ALLOY_FURNACE;

import fallenavatar.rp2_redux.util.recipes.AlloyFurnaceRecipe;
import fallenavatar.rp2_redux.util.recipes.RP2RecipeSerializer;

public class RP2RecipeSerializers {
	private RP2RecipeSerializers() {}

	public static void register() {
		RECIPE_SERIALIZERS.register(ID_RECIPE_ALLOY_FURNACE, () -> new RP2RecipeSerializer<>(AlloyFurnaceRecipe::new));
	}
}

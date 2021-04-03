package fallenavatar.rp2_redux.init;

import cofh.lib.util.recipes.SerializableRecipeType;
import fallenavatar.rp2_redux.util.recipes.AlloyFurnaceRecipe;
import net.minecraft.util.ResourceLocation;

import static fallenavatar.rp2_redux.common.Constants.ID_RP2_REDUX;

public class RP2RecipeTypes {
	private RP2RecipeTypes() {}

	public static void register() {
		RECIPE_ALLOY_FURNACE.register();
	}

	public static final ResourceLocation ID_RECIPE_ALLOY_FURNACE = new ResourceLocation(ID_RP2_REDUX, "alloy_furnace");

	public static final SerializableRecipeType<AlloyFurnaceRecipe> RECIPE_ALLOY_FURNACE = new SerializableRecipeType<>(ID_RECIPE_ALLOY_FURNACE);
}

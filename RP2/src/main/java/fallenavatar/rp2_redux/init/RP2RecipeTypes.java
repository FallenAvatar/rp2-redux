package fallenavatar.rp2_redux.init;

import cofh.lib.util.recipes.SerializableRecipeType;
import fallenavatar.rp2_redux.util.recipes.AlloyFurnaceRecipe;
import fallenavatar.rp2_redux.util.recipes.FurnaceFuel;
import net.minecraft.util.ResourceLocation;

import static fallenavatar.rp2_redux.common.Constants.ID_RP2_REDUX;

public class RP2RecipeTypes {
	private RP2RecipeTypes() {}

	public static void register() {
		RECIPE_ALLOY_FURNACE.register();
		FUEL_FURNACE.register();
	}

	public static final ResourceLocation ID_FUEL_FURNACE = new ResourceLocation(ID_RP2_REDUX, "furnace_fuel");
	public static final SerializableRecipeType<FurnaceFuel> FUEL_FURNACE = new SerializableRecipeType<>(ID_FUEL_FURNACE);

	public static final ResourceLocation ID_RECIPE_ALLOY_FURNACE = new ResourceLocation(ID_RP2_REDUX, "alloy_furnace");
	public static final SerializableRecipeType<AlloyFurnaceRecipe> RECIPE_ALLOY_FURNACE = new SerializableRecipeType<>(ID_RECIPE_ALLOY_FURNACE);
}

package fallenavatar.rp2_redux.util.recipes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import cofh.thermal.lib.util.recipes.ThermalRecipe;
import fallenavatar.rp2_redux.init.RP2RecipeTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import static fallenavatar.rp2_redux.RP2ReduxMod.RECIPE_SERIALIZERS;
import static fallenavatar.rp2_redux.init.RP2RecipeTypes.ID_RECIPE_ALLOY_FURNACE;

public class AlloyFurnaceRecipe extends RP2Recipe {
	public AlloyFurnaceRecipe(ResourceLocation recipeId, float experience, List<Ingredient> inputItems, List<ItemStack> outputItems) {
        super(recipeId, experience, 100, inputItems, outputItems);
    }

    @Nonnull
    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RECIPE_SERIALIZERS.get(ID_RECIPE_ALLOY_FURNACE);
    }

    @Nonnull
    @Override
    public IRecipeType<?> getType() {
        return RP2RecipeTypes.RECIPE_ALLOY_FURNACE;
    }
}

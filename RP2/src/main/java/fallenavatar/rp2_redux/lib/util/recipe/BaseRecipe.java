package fallenavatar.rp2_redux.lib.util.recipe;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Supplier;

import cofh.lib.util.recipes.SerializableRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;

public abstract class BaseRecipe<RT extends IRecipeType<?>, RS extends IRecipeSerializer<?>> extends SerializableRecipe implements IRecipe {
	protected Supplier<IRecipeType<?>> recipeType;
	protected Supplier<IRecipeSerializer<?>> recipeSerializer;

	protected BaseRecipe(ResourceLocation recipeId, Supplier<IRecipeType<?>> rt, Supplier<IRecipeSerializer<?>> rs) {
		super(recipeId);

		recipeType = rt;
		recipeSerializer = rs;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return recipeSerializer.get();
	}

	@Override
	public IRecipeType<?> getType() {
		return recipeType.get();
	}
}

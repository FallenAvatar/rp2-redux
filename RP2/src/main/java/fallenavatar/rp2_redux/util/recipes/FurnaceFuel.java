
package fallenavatar.rp2_redux.util.recipes;

import cofh.thermal.lib.util.recipes.ThermalFuel;
import fallenavatar.rp2_redux.init.RP2RecipeTypes;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static cofh.thermal.core.ThermalCore.RECIPE_SERIALIZERS;
import static fallenavatar.rp2_redux.init.RP2RecipeTypes.ID_FUEL_FURNACE;;

public class FurnaceFuel extends ThermalFuel {

    public FurnaceFuel(ResourceLocation recipeId, int energy, @Nullable List<Ingredient> inputItems, @Nullable List<FluidStack> inputFluids) {

        super(recipeId, energy, inputItems, inputFluids);
    }

    @Nonnull
    @Override
    public IRecipeSerializer<?> getSerializer() {

        return RECIPE_SERIALIZERS.get(ID_FUEL_FURNACE);
    }

    @Nonnull
    @Override
    public IRecipeType<?> getType() {

        return RP2RecipeTypes.FUEL_FURNACE;
    }

    //    @Nonnull
    //    @Override
    //    public String getGroup() {
    //
    //        return DYNAMO_STIRLING_BLOCK.getTranslationKey();
    //    }
    //
    //    @Nonnull
    //    @Override
    //    public ItemStack getIcon() {
    //
    //        return new ItemStack(DYNAMO_STIRLING_BLOCK);
    //    }

}
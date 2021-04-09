package fallenavatar.rp2_redux.lib.util.recipe.internal;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import fallenavatar.rp2_redux.lib.inventory.IContainerInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public interface IRecipe {
	List<ItemStack> getInputItems();
    List<FluidStack> getInputFluids();

    List<ItemStack> getOutputItems(IContainerInventory inventory);
    List<FluidStack> getOutputFluids(IContainerInventory inventory);

    List<Float> getOutputItemChances(IContainerInventory inventory);

    List<Integer> getInputItemCounts(IContainerInventory inventory);
    List<Integer> getInputFluidCounts(IContainerInventory inventory);
    default Pair<List<Integer>, List<Integer>> getInputItemAndFluidCounts(IContainerInventory inventory) {
        return Pair.of(getInputItemCounts(inventory), getInputFluidCounts(inventory));
    }

    int getEnergy(IContainerInventory inventory);
    float getXp(IContainerInventory inventory);
}

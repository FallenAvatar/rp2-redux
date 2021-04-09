package fallenavatar.rp2_redux.lib.util.manager;

import cofh.lib.fluid.IFluidStackAccess;
import cofh.lib.inventory.IItemStackAccess;
import cofh.lib.inventory.ItemStackHolder;
import cofh.lib.util.ComparableItemStack;
import fallenavatar.rp2_redux.core.util.recipes.FurnaceFuel;
import fallenavatar.rp2_redux.lib.inventory.IInventory;
import fallenavatar.rp2_redux.lib.util.recipe.BaseFuel;
import fallenavatar.rp2_redux.lib.util.recipe.IFuel;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class SingleItemFuelManager extends AbstractManager implements IFuelManager {
	public static final int MIN_ENERGY = 1000;
    public static final int MAX_ENERGY = 20000000;

    protected Map<ComparableItemStack, IFuel> fuelMap = new Object2ObjectOpenHashMap<>();

    protected SingleItemFuelManager(int defaultEnergy) {

        super(defaultEnergy);
    }

    public void addFuel(FurnaceFuel recipe) {

        for (ItemStack recipeInput : recipe.getInputItems().get(0).getMatchingStacks()) {
            addFuel(recipe.getEnergy(), Collections.singletonList(recipeInput));
        }
    }

    public boolean validFuel(ItemStack input) {

        return getFuel(input) != null;
    }

    protected void clear() {

        fuelMap.clear();
    }

    protected IFuel getFuel(ItemStack input) {

        return getFuel(Collections.singletonList(new ItemStackHolder(input)));
    }

    protected IFuel getFuel(List<? extends IItemStackAccess> inputSlots) {

        if (inputSlots.isEmpty() || inputSlots.get(0).isEmpty()) {
            return null;
        }
        return fuelMap.get(convert(inputSlots.get(0).getItemStack()));
    }

    public IFuel addFuel(int energy, List<ItemStack> inputItems) {

        if (inputItems.isEmpty() || energy <= 0) {
            return null;
        }
        if (energy < MIN_ENERGY || energy > MAX_ENERGY) {
            return null;
        }
        ItemStack input = inputItems.get(0);
        if (input.isEmpty()) {
            return null;
        }
        energy = (int) (energy * getDefaultScale());

        BaseFuel fuel = new BaseFuel(energy, inputItems);
        fuelMap.put(convert(input), fuel);
        return fuel;
    }

    // region IFuelManager
    @Override
    public IFuel getFuel(IInventory inventory) {

        return getFuel(inventory.inputSlots());
    }

    @Override
    public List<IFuel> getFuelList() {
        return new ArrayList<>(fuelMap.values());
    }
    // endregion
}

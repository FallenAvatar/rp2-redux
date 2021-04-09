package fallenavatar.rp2_redux.lib.util.recipe;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class BaseFuel implements IFuel {
	protected final List<ItemStack> inputItems = new ArrayList<>();

    protected final int energy;

    public BaseFuel(int energy) {
        this.energy = energy;
    }

    public BaseFuel(int energy, @Nullable List<ItemStack> inputItems) {
        this(energy);

        if (inputItems != null) {
            this.inputItems.addAll(inputItems);
        }
        trim();
    }

    private void trim() {
        ((ArrayList<ItemStack>) this.inputItems).trimToSize();
    }

    // region IDynamoFuel
    @Override
    public List<ItemStack> getInputItems() {
        return inputItems;
    }

    @Override
    public int getEnergy() {
        return energy;
    }
    // endregion
}

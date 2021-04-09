package fallenavatar.rp2_redux.lib.util.manager;

import java.util.List;

import fallenavatar.rp2_redux.lib.inventory.IInventory;
import fallenavatar.rp2_redux.lib.util.recipe.IFuel;

public interface IFuelManager {
	default boolean validFuel(IInventory inventory) {

        return getFuel(inventory) != null;
    }

    IFuel getFuel(IInventory inventory);

    List<IFuel> getFuelList();
}

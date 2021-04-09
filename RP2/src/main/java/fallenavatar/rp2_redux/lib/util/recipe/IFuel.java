package fallenavatar.rp2_redux.lib.util.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

public interface IFuel {
	List<ItemStack> getInputItems();
    int getEnergy();
}

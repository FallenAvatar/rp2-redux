package fallenavatar.rp2_redux.lib.inventory;

import javax.annotation.Nullable;

import cofh.lib.inventory.IItemStackAccess;
import net.minecraft.item.ItemStack;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.fluids.FluidStack;

public interface IInventorySlot extends IItemStackAccess {
	int getSlotIndex();
	SlotType getSlotType();

	default boolean isEmpty() {
		switch(getSlotType()){
		case None:
			return true;
		case Item:
			return getItemStack().getCount() <= 0;
		case Fluid:
			return getFluidStack().getAmount() <= 0;
		case Energy:
			return getEnergyStorage().getEnergyStored() <= 0;
		case Other:
			return getOther() == null;
		default:
			return true;
		}
	}

	@Nullable default ItemStack getItemStack() { return null; }
	@Nullable default FluidStack getFluidStack() { return null; }
	@Nullable default EnergyStorage getEnergyStorage() { return null; }
	@Nullable default <T> T getOther() { return null; }
}

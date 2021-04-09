package fallenavatar.rp2_redux.lib.inventory;

import java.util.List;

import cofh.lib.fluid.IFluidStackAccess;

public interface IInventory {
	List<? extends IInventorySlot> inputSlots();
	List<? extends IFluidStackAccess> inputTanks();
	List<? extends IInventorySlot> outputSlots();
	List<? extends IFluidStackAccess> outputTanks();
}

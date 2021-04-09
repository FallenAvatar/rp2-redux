package fallenavatar.rp2_redux.lib.inventory;

public abstract class BaseInventorySlot implements IInventorySlot {
	protected int slotIndex;
	public int getSlotIndex() {return slotIndex; }
	protected SlotType slotType;
	public SlotType getSlotType() { return slotType; }

	protected BaseInventorySlot(int idx, SlotType st) {
		slotIndex = idx;
		slotType = st;
	}
}

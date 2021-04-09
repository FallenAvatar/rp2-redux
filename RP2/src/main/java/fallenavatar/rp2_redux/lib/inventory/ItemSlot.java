package fallenavatar.rp2_redux.lib.inventory;

import net.minecraft.item.ItemStack;

public class ItemSlot extends BaseInventorySlot {
	protected ItemStack items;
	
	public ItemSlot(int idx) {
		super(idx, SlotType.Item);
	}

	@Override
	public ItemStack getItemStack() { return items; }

	@Override
	public int getCount() { return items.getCount(); }
}

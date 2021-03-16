package fallenavatar.rp2_redux.item;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

import static fallenavatar.rp2_redux.common.RP2ItemGroups.*;

public class RP2AxeItem extends AxeItem {
	public RP2AxeItem(IItemTier tier, Properties builder) {
		super(tier, 1f, 1f, builder.stacksTo(1).tab(RP2_ITEMS));
	}
}

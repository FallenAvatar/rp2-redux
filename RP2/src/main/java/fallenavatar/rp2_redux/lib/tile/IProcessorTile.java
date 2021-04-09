package fallenavatar.rp2_redux.lib.tile;

import fallenavatar.rp2_redux.lib.inventory.IInventory;
import net.minecraft.inventory.container.INamedContainerProvider;

public interface IProcessorTile extends INamedContainerProvider, IInventory {
	int getScaledProgress();
	int getScaledSpeed();
	int getScaledDuration();
}

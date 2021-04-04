package fallenavatar.rp2_redux.core.init;

import cofh.core.util.ProxyUtils;

import static fallenavatar.rp2_redux.core.RP2ReduxMod.CONTAINERS;
import static fallenavatar.rp2_redux.core.common.RP2IDs.*;

import fallenavatar.rp2_redux.core.inventory.container.AlloyFurnaceContainer;
import net.minecraftforge.common.extensions.IForgeContainerType;

public class RP2Containers {
	private RP2Containers() {}

	public static void register() {
        CONTAINERS.register(ID_ALLOY_FURNACE, () -> IForgeContainerType.create((windowId, inv, data) -> new AlloyFurnaceContainer(windowId, ProxyUtils.getClientWorld(), data.readBlockPos(), inv, ProxyUtils.getClientPlayer())));
	}
}

package fallenavatar.rp2_redux.core.init;

import cofh.core.util.ProxyUtils;

import static fallenavatar.rp2_redux.core.RP2ReduxMod.CONTAINERS;
import static fallenavatar.rp2_redux.core.common.RP2IDs.*;

import fallenavatar.rp2_redux.core.client.gui.AlloyFurnaceScreen;
import fallenavatar.rp2_redux.core.client.gui.ProjectTableScreen;
import fallenavatar.rp2_redux.core.inventory.container.AlloyFurnaceContainer;
import fallenavatar.rp2_redux.core.inventory.container.ProjectTableContainer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.common.extensions.IForgeContainerType;

import static fallenavatar.rp2_redux.core.init.RP2References.ALLOY_FURNACE_CONTAINER;
import static fallenavatar.rp2_redux.core.init.RP2References.PROJECT_TABLE_CONTAINER;

public class RP2Containers {
	private RP2Containers() {}

	public static void register() {
        CONTAINERS.register(ID_ALLOY_FURNACE, () -> IForgeContainerType.create((windowId, inv, data) -> new AlloyFurnaceContainer(windowId, ProxyUtils.getClientWorld(), data.readBlockPos(), inv, ProxyUtils.getClientPlayer())));
		CONTAINERS.register(ID_PROJECT_TABLE, () -> IForgeContainerType.create((windowId, inv, data) -> new ProjectTableContainer(windowId, ProxyUtils.getClientWorld(), data.readBlockPos(), inv, ProxyUtils.getClientPlayer())));
	}

	public static void registerScreens() {
		ScreenManager.registerFactory(ALLOY_FURNACE_CONTAINER, AlloyFurnaceScreen::new);
		ScreenManager.registerFactory(PROJECT_TABLE_CONTAINER, ProjectTableScreen::new);
	}
}

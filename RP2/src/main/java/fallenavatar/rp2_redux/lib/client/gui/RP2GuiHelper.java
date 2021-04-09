package fallenavatar.rp2_redux.lib.client.gui;

import cofh.core.client.gui.CoreTextures;
import cofh.core.client.gui.element.ElementConditionalLayered;
import cofh.core.client.gui.element.ElementScaled;
import cofh.core.client.gui.element.ElementScaledFluid;
import cofh.core.client.gui.element.panel.ResourcePanel;
import cofh.core.util.helpers.GuiHelper;
import cofh.core.util.helpers.RenderHelper;
import cofh.lib.client.gui.IGuiAccess;
import cofh.lib.util.helpers.BlockHelper;
import fallenavatar.rp2_redux.lib.tile.BaseTile;
import fallenavatar.rp2_redux.lib.tile.IProcessorTile;

import static cofh.core.util.helpers.RenderHelper.getFluidTexture;
import static cofh.core.util.helpers.RenderHelper.textureExists;
import static fallenavatar.rp2_redux.core.common.Constants.ID_RP2_REDUX;
import static cofh.lib.util.constants.Constants.TRUE;
import static cofh.lib.util.control.IReconfigurable.SideConfig.*;
import static net.minecraft.util.Direction.DOWN;
import static net.minecraft.util.Direction.UP;

public class RP2GuiHelper {
	private RP2GuiHelper() {}

    // region COMMON UX
    public static ElementScaled createDefaultProgress(IGuiAccess gui, int posX, int posY, String texture, IProcessorTile tile) {
        return GuiHelper.createDefaultProgress(gui, posX, posY, texture, tile::getScaledProgress, () -> false);
    }

    public static ElementScaled createDefaultSpeed(IGuiAccess gui, int posX, int posY, String texture, IProcessorTile tile) {
        return GuiHelper.createDefaultSpeed(gui, posX, posY, texture, tile::getScaledSpeed);
    }

    public static ElementScaled createDefaultDuration(IGuiAccess gui, int posX, int posY, String texture, IProcessorTile tile) {
        return GuiHelper.createDefaultDuration(gui, posX, posY, texture, tile::getScaledDuration);
    }
    // endregion
}

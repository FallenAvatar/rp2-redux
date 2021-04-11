package fallenavatar.rp2_redux.core.client.gui;

import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;

import cofh.lib.util.helpers.StringHelper;
import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.ThermalTileScreenBase;
import fallenavatar.rp2_redux.core.inventory.container.AlloyFurnaceContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import static cofh.core.util.helpers.GuiHelper.*;

public class AlloyFurnaceScreen extends ThermalTileScreenBase<AlloyFurnaceContainer> {
	public static final String TEX_PATH = ID_RP2_REDUX + ":textures/gui/alloy_furnace.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public AlloyFurnaceScreen(AlloyFurnaceContainer container, PlayerInventory inv, ITextComponent titleIn) {
        super(container, inv, container.tile, StringHelper.getTextComponent("block.rp2_redux.alloy_furnace"));
        texture = TEXTURE;
        info = generatePanelInfo("info.rp2_redux.alloy_furnace");
    }

    @Override
    public void init() {
        super.init();

		addElement(ThermalGuiHelper.createDefaultProgress(this, 107, 34, PROG_ARROW_RIGHT, tile));
        addElement(ThermalGuiHelper.createDefaultSpeed(this, 16, 24, SCALE_FLAME, tile));
    }
}

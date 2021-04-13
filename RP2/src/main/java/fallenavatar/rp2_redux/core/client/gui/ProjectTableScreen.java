package fallenavatar.rp2_redux.core.client.gui;

import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import cofh.core.util.helpers.RenderHelper;
import cofh.lib.util.helpers.StringHelper;
import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.ThermalTileScreenBase;
import fallenavatar.rp2_redux.core.inventory.container.ProjectTableContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import static cofh.core.util.helpers.GuiHelper.*;

public class ProjectTableScreen extends ThermalTileScreenBase<ProjectTableContainer> {
	public static final String TEX_PATH = ID_RP2_REDUX + ":textures/gui/project_table.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public ProjectTableScreen(ProjectTableContainer container, PlayerInventory inv, ITextComponent titleIn) {
        super(container, inv, container.tile, StringHelper.getTextComponent("block.rp2_redux.project_table"));
        texture = TEXTURE;
        info = generatePanelInfo("info.rp2_redux.project_table");
    }

    @Override
    public void init() {
        super.init();

		addElement(ThermalGuiHelper.createDefaultProgress(this, 107, 34, PROG_ARROW_RIGHT, tile));

		ySize += 56;
		guiTop -= (56 / 2);
    }
}

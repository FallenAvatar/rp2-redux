package fallenavatar.rp2_redux.lib.client.gui;

import cofh.core.client.gui.ContainerScreenCoFH;
import fallenavatar.rp2_redux.lib.tile.IProcessorTile;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public abstract class TileScreenBase<T extends Container> extends ContainerScreenCoFH<T> implements ITileScreen {
	protected ResourceLocation texture;
	protected String info;
	protected IProcessorTile baseTile;
	
	protected TileScreenBase(T container, PlayerInventory inv, IProcessorTile tile, ITextComponent titleIn) {
		super(container, inv, titleIn);
		baseTile = tile;
	}
}
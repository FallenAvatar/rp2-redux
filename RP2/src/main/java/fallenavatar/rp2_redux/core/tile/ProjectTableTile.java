package fallenavatar.rp2_redux.core.tile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

import static fallenavatar.rp2_redux.core.init.RP2References.*;
import static cofh.lib.util.StorageGroup.*;

import javax.annotation.Nullable;

import cofh.lib.inventory.ItemStorageCoFH;
import cofh.thermal.lib.tileentity.ThermalTileBase;
import fallenavatar.rp2_redux.core.inventory.container.ProjectTableContainer;

public class ProjectTableTile extends ThermalTileBase {
	protected ItemStorageCoFH planSlot = new ItemStorageCoFH();
	protected ItemStorageCoFH[] inputSlots = new ItemStorageCoFH[9];
    protected ItemStorageCoFH outputSlot = new ItemStorageCoFH();

	protected ItemStorageCoFH[] invSlots = new ItemStorageCoFH[18];

	public ProjectTableTile() {
		super(PROJECT_TABLE_TILE);

		for( int i=0; i<9; i++ ) {
			invSlots[i] = new ItemStorageCoFH();
			inventory.addSlot(invSlots[i], INPUT);
		}

		for( int i=0; i<9; i++ ) {
			invSlots[i+9] = new ItemStorageCoFH();
			inventory.addSlot(invSlots[i+9], INPUT);
		}

		for( int i=0; i<9; i++ ) {
			inputSlots[i] = new ItemStorageCoFH();
			inventory.addSlot(inputSlots[i], INPUT);
		}

		inventory.addSlot(planSlot, INPUT);
		inventory.addSlot(outputSlot, OUTPUT);
	}

	@Nullable
    @Override
    public Container createMenu(int i, PlayerInventory inventory, PlayerEntity player) {
        return new ProjectTableContainer(i, world, pos, inventory, player);
    }
}

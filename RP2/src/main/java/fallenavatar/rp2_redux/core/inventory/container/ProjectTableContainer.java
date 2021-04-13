package fallenavatar.rp2_redux.core.inventory.container;

import cofh.core.inventory.container.TileContainer;
import cofh.lib.inventory.container.slot.SlotCoFH;
import cofh.lib.inventory.container.slot.SlotRemoveOnly;
import cofh.lib.inventory.wrapper.InvWrapperCoFH;
import fallenavatar.rp2_redux.core.tile.ProjectTableTile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static fallenavatar.rp2_redux.core.init.RP2References.PROJECT_TABLE_CONTAINER;

public class ProjectTableContainer extends TileContainer {
	public final ProjectTableTile tile;

    public ProjectTableContainer(int windowId, World world, BlockPos pos, PlayerInventory inventory, PlayerEntity player) {
        super(PROJECT_TABLE_CONTAINER, windowId, world, pos, inventory, player);

        this.tile = (ProjectTableTile) world.getTileEntity(pos);

		InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

		// Inventory Row 1
		for( int i=0; i<9; i++ ) {
			addSlot(new SlotCoFH(tileInv, i, 8+(i*18), 34 + 56));
		}

		// Inventory Row 2
		for( int i=0; i<9; i++ ) {
			addSlot(new SlotCoFH(tileInv, i+9, 8+(i*18), 52 + 56));
		}
		
		// Crafting Grid
		for( int i=0; i<9; i++ ) {
			addSlot(new SlotCoFH(tileInv, i+18, 48+((i%3)*18), 18+((i/3)*18)));
		}

		// Plan slot
		addSlot(new SlotCoFH(tileInv, 27, 17, 36));
		// Output slot
		addSlot(new SlotRemoveOnly(tileInv, 28, 142, 36));

		bindPlayerInventory(inventory);
    }

	@Override
	protected int getPlayerInventoryVerticalOffset() {
        return 84 + 56;
    }
}

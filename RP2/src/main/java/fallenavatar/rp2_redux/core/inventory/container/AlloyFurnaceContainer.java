package fallenavatar.rp2_redux.core.inventory.container;

import cofh.core.inventory.container.TileContainer;
import cofh.lib.inventory.container.slot.SlotCoFH;
import cofh.lib.inventory.container.slot.SlotRemoveOnly;
import cofh.lib.inventory.wrapper.InvWrapperCoFH;
import fallenavatar.rp2_redux.core.tileentity.AlloyFurnaceTile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static fallenavatar.rp2_redux.core.init.RP2References.ALLOY_FURNACE_CONTAINER;

public class AlloyFurnaceContainer extends TileContainer {
	public final AlloyFurnaceTile tile;

    public AlloyFurnaceContainer(int windowId, World world, BlockPos pos, PlayerInventory inventory, PlayerEntity player) {
        super(ALLOY_FURNACE_CONTAINER, windowId, world, pos, inventory, player);

        this.tile = (AlloyFurnaceTile) world.getTileEntity(pos);

		InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

		for( int i=0; i<9; i++ ) {
			addSlot(new SlotCoFH(tileInv, i, 48+((i%3)*18), 17+((i/3)*18)));
		}

		addSlot(new SlotCoFH(tileInv, 9, 17, 42));
		addSlot(new SlotRemoveOnly(tileInv, 10, 142, 36));

		bindPlayerInventory(inventory);
    }
}

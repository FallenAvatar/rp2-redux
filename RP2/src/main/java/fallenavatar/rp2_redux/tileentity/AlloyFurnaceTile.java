package fallenavatar.rp2_redux.tileentity;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

import static fallenavatar.rp2_redux.util.references.RP2References.*;

public class AlloyFurnaceTile extends TileEntity implements ITickableTileEntity {
	public AlloyFurnaceTile() {
		super(ALLOY_FURNACE_TILE);
	}

	@Override
	public void tick() {
		if (this.world == null)
            return;
		
	}
}

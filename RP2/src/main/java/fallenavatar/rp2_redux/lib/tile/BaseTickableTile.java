package fallenavatar.rp2_redux.lib.tile;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntityType;

public abstract class BaseTickableTile extends BaseTile implements ITickableTileEntity {
	protected boolean valid;
	public boolean isValid() { return valid; }

	public BaseTickableTile(TileEntityType<?> teType) {
		super(teType);

		valid = false;
	}

	@Override
	public void tick() {
		if( !isValid() ) {
			update();
			valid = true;
		}
	}

	public abstract void update();
}

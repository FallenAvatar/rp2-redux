package fallenavatar.rp2_redux.lib.tile;

import cofh.core.tileentity.TileCoFH;
import net.minecraft.tileentity.TileEntityType;

public abstract class BaseTile extends TileCoFH {
	protected BaseTile(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
}

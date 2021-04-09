package fallenavatar.rp2_redux.lib.block;

import com.google.common.base.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public abstract class TileBlock<T extends TileEntity> extends Block  {
	protected Supplier<T> tileSupplier;

	public TileBlock(Properties properties, Supplier<T> tileSup) {
        super(properties);

		tileSupplier = tileSup;
    }

	@Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

	@Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return tileSupplier.get();
    }
}

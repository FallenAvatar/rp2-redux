package fallenavatar.rp2_redux.core.block;

import cofh.core.block.TileBlock4Way;
import fallenavatar.rp2_redux.core.tile.ProjectTableTile;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ProjectTable extends TileBlock4Way {
    public ProjectTable(Properties properties) {
        super(properties, () -> new ProjectTableTile());
    }

	@Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

	@Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ProjectTableTile();
    }
}
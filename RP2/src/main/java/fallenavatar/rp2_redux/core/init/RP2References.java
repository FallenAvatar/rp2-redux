package fallenavatar.rp2_redux.core.init;

import static fallenavatar.rp2_redux.lib.util.Constants.*;
import static fallenavatar.rp2_redux.core.common.RP2IDs.*;

import fallenavatar.rp2_redux.core.inventory.container.AlloyFurnaceContainer;
import fallenavatar.rp2_redux.core.inventory.container.ProjectTableContainer;
import fallenavatar.rp2_redux.core.tile.AlloyFurnaceTile;
import fallenavatar.rp2_redux.core.tile.ProjectTableTile;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ID_RP2_REDUX)
public class RP2References {
	private RP2References() {}

	@ObjectHolder(ID_ALLOY_FURNACE)
    public static final Block ALLOY_FURNACE = null;
	@ObjectHolder(ID_ALLOY_FURNACE)
    public static final TileEntityType<AlloyFurnaceTile> ALLOY_FURNACE_TILE = null;
	@ObjectHolder(ID_ALLOY_FURNACE)
    public static final ContainerType<AlloyFurnaceContainer> ALLOY_FURNACE_CONTAINER = null;

	@ObjectHolder(ID_PROJECT_TABLE)
    public static final Block PROJECT_TABLE = null;
	@ObjectHolder(ID_PROJECT_TABLE)
    public static final TileEntityType<ProjectTableTile> PROJECT_TABLE_TILE = null;
	@ObjectHolder(ID_PROJECT_TABLE)
    public static final ContainerType<ProjectTableContainer> PROJECT_TABLE_CONTAINER = null;

	@ObjectHolder(ID_BASALT)
    public static final Block BASALT = null;
}

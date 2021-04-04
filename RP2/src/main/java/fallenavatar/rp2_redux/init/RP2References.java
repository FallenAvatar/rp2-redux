package fallenavatar.rp2_redux.init;

import static fallenavatar.rp2_redux.common.Constants.*;
import static fallenavatar.rp2_redux.common.RP2IDs.*;

import fallenavatar.rp2_redux.inventory.container.AlloyFurnaceContainer;
import fallenavatar.rp2_redux.tileentity.AlloyFurnaceTile;
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
}

package fallenavatar.rp2_redux.lib.inventory;

import cofh.core.inventory.container.TileContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BaseTileContainer extends TileContainer {
	public BaseTileContainer(ContainerType<?> type, int windowId, World world, BlockPos pos, PlayerInventory inventory, PlayerEntity player) {
		super(type, windowId, world, pos, inventory, player);
	}
}
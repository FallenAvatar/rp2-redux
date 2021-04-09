package fallenavatar.rp2_redux.lib.tile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import cofh.core.inventory.container.TileContainer;
import fallenavatar.rp2_redux.lib.inventory.IContainerInventory;
import fallenavatar.rp2_redux.lib.inventory.IInventorySlot;
import fallenavatar.rp2_redux.lib.util.java.Supplier5;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BaseProcessorTile<T extends TileContainer> extends BaseTickableTile implements IProcessorTile, IContainerInventory {
	protected List<? extends IInventorySlot> inputs = new ArrayList<>();
	protected List<? extends IInventorySlot> inventory = new ArrayList<>();
	protected List<? extends IInventorySlot> outputs = new ArrayList<>();
	protected Supplier5<Integer, World, BlockPos, PlayerInventory, PlayerEntity, T> supplierContainer;

	protected int maxInputSlots;
	public int getMaxInputSlots() { return maxInputSlots; }

	protected int maxInvSlots;

	protected int maxOutputSlots;
	public int getMaxOutputSlots() { return maxInputSlots; }

	protected boolean running;
	public boolean isRunning() { return running; }

	@Override public boolean isValid() { return false; }

	public BaseProcessorTile(TileEntityType<?> teType, Supplier5<Integer, World, BlockPos, PlayerInventory, PlayerEntity, T> supContainer, int numInputSlots, int numInvSlots, int numOutputSlots) {
		super(teType);

		maxInputSlots = numInputSlots;
		maxInvSlots = numInputSlots;
		maxOutputSlots = numOutputSlots;

		supplierContainer = supContainer;
	}

	@Override public List<? extends IInventorySlot> inputSlots() { return inputs; }
	@Override public List<? extends IInventorySlot> outputSlots() { return outputs; }

	protected abstract boolean canStartProcess();
	protected abstract void startProcess();
	protected abstract void tickProcess();
	protected abstract boolean canFinishProcess();
	protected abstract void finishProcess();

	@Override
	public void update() {
		if( isRunning() ) {
			if( canFinishProcess() ) {
				finishProcess();
			} else {
				tickProcess();
			}
		} else if( canStartProcess() ) {
			startProcess();
		}
	}

	@Nullable
    @Override
    public Container createMenu(int i, PlayerInventory inventory, PlayerEntity player) {
        return supplierContainer.get(Integer.valueOf(i), world, pos, inventory, player);
    }
}

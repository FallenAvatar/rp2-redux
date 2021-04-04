package fallenavatar.rp2_redux.tileentity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.ITickableTileEntity;

import static fallenavatar.rp2_redux.init.RP2References.*;

import java.util.List;

import static cofh.lib.util.StorageGroup.*;

import javax.annotation.Nullable;

import cofh.lib.fluid.IFluidStackAccess;
import cofh.lib.inventory.ItemStorageCoFH;
import cofh.thermal.lib.tileentity.MachineTileProcess;
import fallenavatar.rp2_redux.inventory.container.AlloyFurnaceContainer;
import fallenavatar.rp2_redux.util.managers.AlloyFurnaceRecipeManager;
import fallenavatar.rp2_redux.util.managers.FurnaceFuelManager;

import static cofh.lib.util.helpers.ItemHelper.itemsEqual;
import static cofh.lib.util.helpers.ItemHelper.itemsEqualWithTags;

public class AlloyFurnaceTile extends MachineTileProcess {
	protected ItemStorageCoFH fuelSlot = new ItemStorageCoFH(item -> filter.valid(item) && FurnaceFuelManager.instance().validFuel(item));
	protected ItemStorageCoFH[] inputSlots = new ItemStorageCoFH[9];
    protected ItemStorageCoFH outputSlot = new ItemStorageCoFH();

	protected int fuel;
    protected int fuelMax;

	public AlloyFurnaceTile() {
		super(ALLOY_FURNACE_TILE);

		for( int i=0; i<inputSlots.length; i++ ) {
			final int t = i;
			inputSlots[i] = new ItemStorageCoFH(item -> filter.valid(item) && AlloyFurnaceRecipeManager.instance().isValid(item, t, inputSlots));
			inventory.addSlot(inputSlots[i], INPUT);
		}

		inventory.addSlot(fuelSlot, INPUT);
		inventory.addSlot(outputSlot, OUTPUT);
	}

	@Override
    protected boolean canProcessStart() {
        if( FurnaceFuelManager.instance().getEnergy(fuelSlot.getItemStack()) <= 0 )
			return false;

		if (!validateInputs()) {
			return false;
		}
		return validateOutputs();
    }

    @Override
    protected void processStart() {
        fuel += fuelMax = Math.round(FurnaceFuelManager.instance().getEnergy(fuelSlot.getItemStack()));
        fuelSlot.consume(1);
    }

	@Override
    protected boolean cacheRecipe() {
        curRecipe = AlloyFurnaceRecipeManager.instance().getRecipe(this);
        if (curRecipe != null) {
            itemInputCounts = curRecipe.getInputItemCounts(this);
        }
        return curRecipe != null;
    }

    @Override
    protected void resolveInputs() {
        // Input Items
        for (int i = 0; i < 3; ++i) {
            inputSlots[i].modify(-itemInputCounts.get(i));
        }
    }

	@Nullable
    @Override
    public Container createMenu(int i, PlayerInventory inventory, PlayerEntity player) {
        return new AlloyFurnaceContainer(i, world, pos, inventory, player);
    }

	// region OPTIMIZATION
    @Override
    protected boolean validateInputs() {

        if (!cacheRecipe()) {
            return false;
        }
        List<? extends ItemStorageCoFH> slotInputs = inputSlots();
        for (int i = 0; i < slotInputs.size() && i < itemInputCounts.size(); ++i) {
            int inputCount = itemInputCounts.get(i);
            if (slotInputs.get(i).getItemStack().getCount() < inputCount) {
                return false;
            }
        }
        return true;
    }
    // endregion
}

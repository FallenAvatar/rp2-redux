package fallenavatar.rp2_redux.lib.util.manager;

import cofh.lib.util.ComparableItemStack;
import cofh.lib.util.ComparableItemStackNBT;
import net.minecraft.item.ItemStack;

public abstract class AbstractManager implements IManager {
	public static ComparableItemStack convert(ItemStack stack) {
        return new ComparableItemStack(stack);
    }

    public static ComparableItemStack convertNBT(ItemStack stack) {
        return new ComparableItemStackNBT(stack);
    }



	protected int defaultEnergy;
    protected float defaultScale = 1.0F;

    protected AbstractManager(int defaultEnergy) {

        this.defaultEnergy = defaultEnergy;
    }

	public int getDefaultEnergy() {
        return defaultEnergy;
    }

    protected AbstractManager setDefaultEnergy(int defaultEnergy) {
        if (defaultEnergy > 0)
            this.defaultEnergy = defaultEnergy;
        
        return this;
    }

	public float getDefaultScale() {
        return defaultScale;
    }

    protected AbstractManager setDefaultScale(int defaultScale) {
        if (defaultScale > 0)
            this.defaultScale = defaultScale;
        
        return this;
    }
}

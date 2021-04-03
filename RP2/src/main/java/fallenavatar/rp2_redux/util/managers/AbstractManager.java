package fallenavatar.rp2_redux.util.managers;

import cofh.lib.util.ComparableItemStack;
import cofh.lib.util.ComparableItemStackNBT;
import net.minecraft.item.ItemStack;

public abstract class AbstractManager implements IManager {
    protected float defaultScale = 1.0F;

    protected AbstractManager() {
    }

    protected AbstractManager setDefaultScale(int defaultScale) {

        if (defaultScale > 0) {
            this.defaultScale = defaultScale;
        }
        return this;
    }

    public static ComparableItemStack convert(ItemStack stack) {

        return new ComparableItemStack(stack);
    }

    public static ComparableItemStack convertNBT(ItemStack stack) {

        return new ComparableItemStackNBT(stack);
    }

    public float getDefaultScale() {

        return defaultScale;
    }

}

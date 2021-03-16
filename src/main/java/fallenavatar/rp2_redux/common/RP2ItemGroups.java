package fallenavatar.rp2_redux.common;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static fallenavatar.rp2_redux.RP2ReduxMod.ITEMS;
import static fallenavatar.rp2_redux.util.constants.Constants.*;
import static fallenavatar.rp2_redux.init.RP2IDs.*;

public class RP2ItemGroups {
	private RP2ItemGroups() {}

	public static final ItemGroup RP2_BLOCKS = new ItemGroup(-1, ID_RP2_REDUX + ".blocks") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {

            return new ItemStack(ITEMS.get(ID_MARBLE_BRICKS));
        }
    };
}

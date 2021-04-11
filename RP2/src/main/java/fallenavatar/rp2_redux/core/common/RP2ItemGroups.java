package fallenavatar.rp2_redux.core.common;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static fallenavatar.rp2_redux.core.RP2ReduxMod.ITEMS;
import static fallenavatar.rp2_redux.lib.util.Constants.*;
import static fallenavatar.rp2_redux.core.common.RP2IDs.*;

public class RP2ItemGroups {
	private RP2ItemGroups() {}

	public static final ItemGroup RP2_BLOCKS = new ItemGroup(-1, ID_RP2_REDUX + ".blocks") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {

            return new ItemStack(ITEMS.get(ID_MARBLE_BRICKS));
        }
    };

	public static final ItemGroup RP2_ITEMS = new ItemGroup(-1, ID_RP2_REDUX + ".items") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {

            return new ItemStack(ITEMS.get(ID_SCREWDRIVER));
        }
    };

	public static final ItemGroup RP2_MACHINES = new ItemGroup(-1, ID_RP2_REDUX + ".machines") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {

            return new ItemStack(ITEMS.get(ID_PROJECT_TABLE));
        }
    };

	public static final ItemGroup RP2_TOOLS = new ItemGroup(-1, ID_RP2_REDUX + ".tools") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {

            return new ItemStack(ITEMS.get(ID_SCREWDRIVER));
        }
    };

	public static final ItemGroup RP2_COMBAT = new ItemGroup(-1, ID_RP2_REDUX + ".combat") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {

            return new ItemStack(ITEMS.get(ID_RUBY+"_sword"));
        }
    };
}

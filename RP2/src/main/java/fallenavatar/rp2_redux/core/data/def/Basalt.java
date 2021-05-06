package fallenavatar.rp2_redux.core.data.def;


import java.util.EnumSet;


import net.minecraft.item.ItemGroup;
import fallenavatar.rp2_redux.core.common.RP2ItemGroups;
import fallenavatar.rp2_redux.lib.data.def.LootFlags;
import fallenavatar.rp2_redux.lib.data.def.SimpleBlock;
import fallenavatar.rp2_redux.lib.util.annotation.Thingy;


import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;

@Thingy(mod = ID_RP2_REDUX, id="basalt", path="world")
public class Basalt extends SimpleBlock {
	public static final String NAME_en = "Basalt";
	public static final ItemGroup TAB = RP2ItemGroups.RP2_BLOCKS;
	public static final EnumSet<LootFlags> FLAGS = LootFlags.None;

	public Basalt() {
		super(TAB, NAME_en, FLAGS);
	}
}

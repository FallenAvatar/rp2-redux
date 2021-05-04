package fallenavatar.rp2_redux.core.data.def;


import java.util.EnumSet;


import net.minecraft.item.ItemGroup;


import fallenavatar.rp2_redux.core.common.RP2ItemGroups;
import fallenavatar.rp2_redux.lib.data.def.LootFlags;
import fallenavatar.rp2_redux.lib.data.def.SimpleBlock;


import static fallenavatar.rp2_redux.lib.util.Constants.ID_RP2_REDUX;


public class Basalt extends SimpleBlock {
	public static final String ID = "basalt";
	public static final String NAME_en = "Basalt";
	public static final ItemGroup TAB = RP2ItemGroups.RP2_BLOCKS;
	public static final EnumSet<LootFlags> FLAGS = LootFlags.None;

	public Basalt() {
		super(ID_RP2_REDUX, ID, NAME_en, TAB, FLAGS);

		AddVariant("bricks");
		AddVariant("chiseled");
		AddVariant("cobble");
		AddVariant("smooth");
	}
}

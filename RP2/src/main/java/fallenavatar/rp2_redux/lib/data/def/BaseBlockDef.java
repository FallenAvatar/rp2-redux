package fallenavatar.rp2_redux.lib.data.def;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import static net.minecraft.block.AbstractBlock.Properties.from;

public class BaseBlockDef extends BaseThingyDef {
	public String getLangName() { return "block."+getModID()+"."+id; }

	public BaseBlockDef(ItemGroup tab) {
		super(tab);
	}

	@Override
	public void GenData(BlockStateProvider bsp) {
		bsp.simpleBlock(new Block(from(Blocks.STONE)).setRegistryName(getName()));
	}

	@Override
	public void Register() {

	}
}

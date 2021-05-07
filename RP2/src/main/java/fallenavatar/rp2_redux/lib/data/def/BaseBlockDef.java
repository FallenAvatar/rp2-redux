package fallenavatar.rp2_redux.lib.data.def;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.AbstractBlock.Properties;

import fallenavatar.rp2_redux.core.util.helpers.RegistrationHelper;

public class BaseBlockDef extends BaseItemDef {
	public String getLangName() { return "block."+getModID()+"."+id; }

	public String getBlockName() {
		String ret = getModID()+":item/";
		String cat = getCategory();

		if( cat != null && cat.trim() != "")
			ret += cat+"/";

		return ret + getID();
	}

	protected Properties blockProps;
	public Properties getBlockProperties() { return blockProps; }

	public BaseBlockDef(ItemGroup tab, Properties props) {
		super(tab);
		blockProps = props;
	}

	public void GenBlockState(BlockStateProvider bsp) {
		bsp.simpleBlock(new Block(blockProps).setRegistryName(getBlockName()));
	}

	@Override
	public void GenItemModel(ItemModelProvider imp) {
		imp.withExistingParent(getItemName(), getBlockName());
	}

	@Override
	public void Register() {
		RegistrationHelper.registerBlock(getName(), () -> new Block(blockProps).setRegistryName(getBlockName()) );
	}
}

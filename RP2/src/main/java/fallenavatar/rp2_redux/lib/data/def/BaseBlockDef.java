package fallenavatar.rp2_redux.lib.data.def;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.AbstractBlock.Properties;

import com.google.common.base.Supplier;

import fallenavatar.rp2_redux.core.util.helpers.RegistrationHelper;

public class BaseBlockDef extends BaseItemDef {
	public String getLangName() { return "block."+getModID()+"."+id; }

	public String getBlockName() {
		String ret = getModID()+":block/";
		String cat = getCategory();

		if( cat != null && cat.trim() != "")
			ret += cat+"/";

		return ret + getID();
	}

	public ResourceLocation getBlockResourceLoc() {
		String ret = "block/";
		String cat = getCategory();

		if( cat != null && cat.trim() != "")
			ret += cat+"/";

		return new ResourceLocation(getModID(), ret + getID());
	}

	protected Properties blockProps;
	public Properties getBlockProperties() { return blockProps; }

	protected Supplier<Block> asBlock() { return () -> new Block(blockProps); }

	public BaseBlockDef(ItemGroup tab, Properties props) {
		super(tab);
		blockProps = props;
	}

	public void GenBlockState(BlockStateProvider bsp) {
		bsp.simpleBlock(asBlock().get().setRegistryName(getName(false)), bsp.models().cubeAll(getName(false), getBlockResourceLoc()));
	}

	@Override
	public void GenItemModel(ItemModelProvider imp) {
		imp.withExistingParent(getName(false), imp.modLoc(getName(false)));
	}

	@Override
	public void Register() {
		RegistrationHelper.registerBlockAndItem(getName(false), asBlock(), asItem());
	}
}

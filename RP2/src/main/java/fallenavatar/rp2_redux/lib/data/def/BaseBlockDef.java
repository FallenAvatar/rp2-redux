package fallenavatar.rp2_redux.lib.data.def;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.AbstractBlock.Properties;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Supplier;

import fallenavatar.rp2_redux.core.util.helpers.RegistrationHelper;
import fallenavatar.rp2_redux.lib.BaseModInfo;

public class BaseBlockDef extends BaseItemDef {
	public String getLangName() { return "block."+getModInfo().getModID()+"."+getID(); }

	public String getBlockName() {
		String ret = getModInfo().getModID()+":block/";
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

		return new ResourceLocation(getModInfo().getModID(), ret + getID());
	}

	protected List<BlockVariant> variants = new ArrayList<BlockVariant>();
	protected void addVariant(String name, Properties props) { addVariant(name, props, true); }
	protected void addVariant(String name, Properties props, Boolean append) { variants.add(new BlockVariant(append ? getName()+"_"+name : name, props)); }

	public BaseBlockDef(BaseModInfo mi, String cat, String id, String i10n_name, ItemGroup tab, Properties props) {
		super(mi, cat, id, i10n_name, tab);
		
		addVariant(getName(), props, false);
	}

	public void GenBlockState(BlockStateProvider bsp) {
		//bsp.simpleBlock(asBlock().get().setRegistryName(getName(false)), bsp.models().cubeAll(getName(false), getBlockResourceLoc()));
	}

	@Override
	public void GenItemModel(ItemModelProvider imp) {
		//imp.withExistingParent(getName(false), imp.modLoc(getName(false)));
	}

	@Override
	public void Register() {
		for (BlockVariant blockVariant : variants) {
			RegistrationHelper.registerBlock(blockVariant.getName(), blockVariant.asBlock());
		}
	}
}
